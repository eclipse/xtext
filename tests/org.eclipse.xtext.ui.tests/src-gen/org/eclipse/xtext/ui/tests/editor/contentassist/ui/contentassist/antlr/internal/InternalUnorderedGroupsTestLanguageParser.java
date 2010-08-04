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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'private'", "'protected'", "'1'", "'2'", "'3'", "'4'", "'5'", "'bug304681'", "'class'", "'{'", "'}'", "'before'", "'after'", "'short'", "';'", "'long'", "'uid'", "'attr'", "'ref'", "'static'", "'synchronized'", "'abstract'", "'final'", "'flag'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g"; }


     
     	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:63:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:70:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:75:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:75:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:76:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:77:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:77:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel94);
            rule__Model__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start entryRuleSimpleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:1: entryRuleSimpleModel : ruleSimpleModel EOF ;
    public final void entryRuleSimpleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:90:1: ( ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:91:1: ruleSimpleModel EOF
            {
             before(grammarAccess.getSimpleModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel121);
            ruleSimpleModel();
            _fsp--;

             after(grammarAccess.getSimpleModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleModel128); 

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
    // $ANTLR end entryRuleSimpleModel


    // $ANTLR start ruleSimpleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:98:1: ruleSimpleModel : ( ( rule__SimpleModel__Group__0 ) ) ;
    public final void ruleSimpleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:102:2: ( ( ( rule__SimpleModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:103:1: ( ( rule__SimpleModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:103:1: ( ( rule__SimpleModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:104:1: ( rule__SimpleModel__Group__0 )
            {
             before(grammarAccess.getSimpleModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:105:1: ( rule__SimpleModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:105:2: rule__SimpleModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__0_in_ruleSimpleModel154);
            rule__SimpleModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSimpleModel


    // $ANTLR start entryRuleMandatoryModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:117:1: entryRuleMandatoryModel : ruleMandatoryModel EOF ;
    public final void entryRuleMandatoryModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:118:1: ( ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:119:1: ruleMandatoryModel EOF
            {
             before(grammarAccess.getMandatoryModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel181);
            ruleMandatoryModel();
            _fsp--;

             after(grammarAccess.getMandatoryModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryModel188); 

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
    // $ANTLR end entryRuleMandatoryModel


    // $ANTLR start ruleMandatoryModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:126:1: ruleMandatoryModel : ( ( rule__MandatoryModel__Group__0 ) ) ;
    public final void ruleMandatoryModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:130:2: ( ( ( rule__MandatoryModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:131:1: ( ( rule__MandatoryModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:131:1: ( ( rule__MandatoryModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:132:1: ( rule__MandatoryModel__Group__0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:133:1: ( rule__MandatoryModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:133:2: rule__MandatoryModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__0_in_ruleMandatoryModel214);
            rule__MandatoryModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleMandatoryModel


    // $ANTLR start entryRuleLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:145:1: entryRuleLoopedModel : ruleLoopedModel EOF ;
    public final void entryRuleLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:146:1: ( ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:147:1: ruleLoopedModel EOF
            {
             before(grammarAccess.getLoopedModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel241);
            ruleLoopedModel();
            _fsp--;

             after(grammarAccess.getLoopedModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedModel248); 

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
    // $ANTLR end entryRuleLoopedModel


    // $ANTLR start ruleLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:154:1: ruleLoopedModel : ( ( rule__LoopedModel__Group__0 ) ) ;
    public final void ruleLoopedModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:158:2: ( ( ( rule__LoopedModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:159:1: ( ( rule__LoopedModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:159:1: ( ( rule__LoopedModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:160:1: ( rule__LoopedModel__Group__0 )
            {
             before(grammarAccess.getLoopedModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:161:1: ( rule__LoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:161:2: rule__LoopedModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__0_in_ruleLoopedModel274);
            rule__LoopedModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleLoopedModel


    // $ANTLR start entryRuleGroupLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:173:1: entryRuleGroupLoopedModel : ruleGroupLoopedModel EOF ;
    public final void entryRuleGroupLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:1: ( ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:175:1: ruleGroupLoopedModel EOF
            {
             before(grammarAccess.getGroupLoopedModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel301);
            ruleGroupLoopedModel();
            _fsp--;

             after(grammarAccess.getGroupLoopedModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupLoopedModel308); 

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
    // $ANTLR end entryRuleGroupLoopedModel


    // $ANTLR start ruleGroupLoopedModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:182:1: ruleGroupLoopedModel : ( ( rule__GroupLoopedModel__Group__0 ) ) ;
    public final void ruleGroupLoopedModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:186:2: ( ( ( rule__GroupLoopedModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:187:1: ( ( rule__GroupLoopedModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:187:1: ( ( rule__GroupLoopedModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:188:1: ( rule__GroupLoopedModel__Group__0 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:189:1: ( rule__GroupLoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:189:2: rule__GroupLoopedModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__0_in_ruleGroupLoopedModel334);
            rule__GroupLoopedModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGroupLoopedModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleGroupLoopedModel


    // $ANTLR start entryRuleLoopedAlternativeModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:201:1: entryRuleLoopedAlternativeModel : ruleLoopedAlternativeModel EOF ;
    public final void entryRuleLoopedAlternativeModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:202:1: ( ruleLoopedAlternativeModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:1: ruleLoopedAlternativeModel EOF
            {
             before(grammarAccess.getLoopedAlternativeModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel361);
            ruleLoopedAlternativeModel();
            _fsp--;

             after(grammarAccess.getLoopedAlternativeModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedAlternativeModel368); 

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
    // $ANTLR end entryRuleLoopedAlternativeModel


    // $ANTLR start ruleLoopedAlternativeModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:210:1: ruleLoopedAlternativeModel : ( ( rule__LoopedAlternativeModel__Group__0 ) ) ;
    public final void ruleLoopedAlternativeModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:214:2: ( ( ( rule__LoopedAlternativeModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:215:1: ( ( rule__LoopedAlternativeModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:215:1: ( ( rule__LoopedAlternativeModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:216:1: ( rule__LoopedAlternativeModel__Group__0 )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:217:1: ( rule__LoopedAlternativeModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:217:2: rule__LoopedAlternativeModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__0_in_ruleLoopedAlternativeModel394);
            rule__LoopedAlternativeModel__Group__0();
            _fsp--;


            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleLoopedAlternativeModel


    // $ANTLR start entryRuleBug304681Model
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:229:1: entryRuleBug304681Model : ruleBug304681Model EOF ;
    public final void entryRuleBug304681Model() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:230:1: ( ruleBug304681Model EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:231:1: ruleBug304681Model EOF
            {
             before(grammarAccess.getBug304681ModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model421);
            ruleBug304681Model();
            _fsp--;

             after(grammarAccess.getBug304681ModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Model428); 

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
    // $ANTLR end entryRuleBug304681Model


    // $ANTLR start ruleBug304681Model
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:238:1: ruleBug304681Model : ( ( rule__Bug304681Model__Group__0 ) ) ;
    public final void ruleBug304681Model() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:242:2: ( ( ( rule__Bug304681Model__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:243:1: ( ( rule__Bug304681Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:243:1: ( ( rule__Bug304681Model__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:244:1: ( rule__Bug304681Model__Group__0 )
            {
             before(grammarAccess.getBug304681ModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:245:1: ( rule__Bug304681Model__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:245:2: rule__Bug304681Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__0_in_ruleBug304681Model454);
            rule__Bug304681Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBug304681Model


    // $ANTLR start entryRuleBug304681Feature
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:257:1: entryRuleBug304681Feature : ruleBug304681Feature EOF ;
    public final void entryRuleBug304681Feature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:258:1: ( ruleBug304681Feature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:259:1: ruleBug304681Feature EOF
            {
             before(grammarAccess.getBug304681FeatureRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature481);
            ruleBug304681Feature();
            _fsp--;

             after(grammarAccess.getBug304681FeatureRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Feature488); 

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
    // $ANTLR end entryRuleBug304681Feature


    // $ANTLR start ruleBug304681Feature
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:266:1: ruleBug304681Feature : ( ( rule__Bug304681Feature__Alternatives ) ) ;
    public final void ruleBug304681Feature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:270:2: ( ( ( rule__Bug304681Feature__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:271:1: ( ( rule__Bug304681Feature__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:271:1: ( ( rule__Bug304681Feature__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:272:1: ( rule__Bug304681Feature__Alternatives )
            {
             before(grammarAccess.getBug304681FeatureAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:273:1: ( rule__Bug304681Feature__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:273:2: rule__Bug304681Feature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Feature__Alternatives_in_ruleBug304681Feature514);
            rule__Bug304681Feature__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getBug304681FeatureAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBug304681Feature


    // $ANTLR start entryRuleBug304681Attribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:285:1: entryRuleBug304681Attribute : ruleBug304681Attribute EOF ;
    public final void entryRuleBug304681Attribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:286:1: ( ruleBug304681Attribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:287:1: ruleBug304681Attribute EOF
            {
             before(grammarAccess.getBug304681AttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute541);
            ruleBug304681Attribute();
            _fsp--;

             after(grammarAccess.getBug304681AttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Attribute548); 

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
    // $ANTLR end entryRuleBug304681Attribute


    // $ANTLR start ruleBug304681Attribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:294:1: ruleBug304681Attribute : ( ( rule__Bug304681Attribute__Group__0 ) ) ;
    public final void ruleBug304681Attribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:298:2: ( ( ( rule__Bug304681Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:299:1: ( ( rule__Bug304681Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:299:1: ( ( rule__Bug304681Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:1: ( rule__Bug304681Attribute__Group__0 )
            {
             before(grammarAccess.getBug304681AttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:301:1: ( rule__Bug304681Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:301:2: rule__Bug304681Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__0_in_ruleBug304681Attribute574);
            rule__Bug304681Attribute__Group__0();
            _fsp--;


            }

             after(grammarAccess.getBug304681AttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBug304681Attribute


    // $ANTLR start entryRuleBug304681Reference
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:313:1: entryRuleBug304681Reference : ruleBug304681Reference EOF ;
    public final void entryRuleBug304681Reference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:314:1: ( ruleBug304681Reference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ruleBug304681Reference EOF
            {
             before(grammarAccess.getBug304681ReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference601);
            ruleBug304681Reference();
            _fsp--;

             after(grammarAccess.getBug304681ReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Reference608); 

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
    // $ANTLR end entryRuleBug304681Reference


    // $ANTLR start ruleBug304681Reference
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:322:1: ruleBug304681Reference : ( ( rule__Bug304681Reference__Group__0 ) ) ;
    public final void ruleBug304681Reference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:326:2: ( ( ( rule__Bug304681Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:327:1: ( ( rule__Bug304681Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:327:1: ( ( rule__Bug304681Reference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:328:1: ( rule__Bug304681Reference__Group__0 )
            {
             before(grammarAccess.getBug304681ReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:329:1: ( rule__Bug304681Reference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:329:2: rule__Bug304681Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__0_in_ruleBug304681Reference634);
            rule__Bug304681Reference__Group__0();
            _fsp--;


            }

             after(grammarAccess.getBug304681ReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBug304681Reference


    // $ANTLR start rule__Model__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:341:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:345:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 18:
                {
                alt1=5;
                }
                break;
            case 19:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("341:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:346:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:346:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:347:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:348:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:348:2: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives670);
                    rule__Model__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:352:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:352:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:353:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:354:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:354:2: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives688);
                    rule__Model__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:358:6: ( ( rule__Model__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:358:6: ( ( rule__Model__Group_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:359:1: ( rule__Model__Group_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:360:1: ( rule__Model__Group_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:360:2: rule__Model__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives706);
                    rule__Model__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:364:6: ( ( rule__Model__Group_3__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:364:6: ( ( rule__Model__Group_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:365:1: ( rule__Model__Group_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:366:1: ( rule__Model__Group_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:366:2: rule__Model__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives724);
                    rule__Model__Group_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:6: ( ( rule__Model__Group_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:6: ( ( rule__Model__Group_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:371:1: ( rule__Model__Group_4__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:372:1: ( rule__Model__Group_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:372:2: rule__Model__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__0_in_rule__Model__Alternatives742);
                    rule__Model__Group_4__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:376:6: ( ( rule__Model__Group_5__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:376:6: ( ( rule__Model__Group_5__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:377:1: ( rule__Model__Group_5__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:378:1: ( rule__Model__Group_5__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:378:2: rule__Model__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__0_in_rule__Model__Alternatives760);
                    rule__Model__Group_5__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_5()); 

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
    // $ANTLR end rule__Model__Alternatives


    // $ANTLR start rule__SimpleModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:387:1: rule__SimpleModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__SimpleModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:391:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("387:1: rule__SimpleModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:392:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:392:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:393:1: 'public'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__SimpleModel__VisibilityAlternatives_0_0_0794); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:400:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:400:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:401:1: 'private'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__SimpleModel__VisibilityAlternatives_0_0_0814); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:408:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:408:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:409:1: 'protected'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__SimpleModel__VisibilityAlternatives_0_0_0834); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__SimpleModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__SimpleModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:421:1: rule__SimpleModel__Alternatives_0_3 : ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__SimpleModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:425:1: ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==33) ) {
                alt3=1;
            }
            else if ( (LA3_0==34) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("421:1: rule__SimpleModel__Alternatives_0_3 : ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:426:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:426:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:427:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:428:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:428:2: rule__SimpleModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__AbstractAssignment_0_3_0_in_rule__SimpleModel__Alternatives_0_3868);
                    rule__SimpleModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:433:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:434:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:434:2: rule__SimpleModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__FinalAssignment_0_3_1_in_rule__SimpleModel__Alternatives_0_3886);
                    rule__SimpleModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__SimpleModel__Alternatives_0_3


    // $ANTLR start rule__MandatoryModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:443:1: rule__MandatoryModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__MandatoryModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("443:1: rule__MandatoryModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:449:1: 'public'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0920); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:456:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:456:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:457:1: 'private'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0940); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:464:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:464:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:465:1: 'protected'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0960); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__MandatoryModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__MandatoryModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:477:1: rule__MandatoryModel__Alternatives_0_3 : ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__MandatoryModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:481:1: ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==33) ) {
                alt5=1;
            }
            else if ( (LA5_0==34) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("477:1: rule__MandatoryModel__Alternatives_0_3 : ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:482:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:482:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:483:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:484:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:484:2: rule__MandatoryModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__AbstractAssignment_0_3_0_in_rule__MandatoryModel__Alternatives_0_3994);
                    rule__MandatoryModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:488:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:488:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:489:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:490:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:490:2: rule__MandatoryModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__FinalAssignment_0_3_1_in_rule__MandatoryModel__Alternatives_0_31012);
                    rule__MandatoryModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__MandatoryModel__Alternatives_0_3


    // $ANTLR start rule__LoopedModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:499:1: rule__LoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__LoopedModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:503:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 12:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("499:1: rule__LoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:504:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:504:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:505:1: 'public'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LoopedModel__VisibilityAlternatives_0_0_01046); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:512:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:512:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:513:1: 'private'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__LoopedModel__VisibilityAlternatives_0_0_01066); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:520:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:520:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:521:1: 'protected'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__LoopedModel__VisibilityAlternatives_0_0_01086); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__LoopedModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__LoopedModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:533:1: rule__LoopedModel__Alternatives_0_3 : ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__LoopedModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:537:1: ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==33) ) {
                alt7=1;
            }
            else if ( (LA7_0==34) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("533:1: rule__LoopedModel__Alternatives_0_3 : ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:539:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:540:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:540:2: rule__LoopedModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__AbstractAssignment_0_3_0_in_rule__LoopedModel__Alternatives_0_31120);
                    rule__LoopedModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:544:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:544:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:545:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:546:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:546:2: rule__LoopedModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__FinalAssignment_0_3_1_in_rule__LoopedModel__Alternatives_0_31138);
                    rule__LoopedModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__LoopedModel__Alternatives_0_3


    // $ANTLR start rule__GroupLoopedModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:555:1: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__GroupLoopedModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:559:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt8=1;
                }
                break;
            case 12:
                {
                alt8=2;
                }
                break;
            case 13:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("555:1: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:560:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:560:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:561:1: 'public'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01172); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:569:1: 'private'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01192); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:576:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:576:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:577:1: 'protected'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01212); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__GroupLoopedModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__GroupLoopedModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:589:1: rule__GroupLoopedModel__Alternatives_0_3 : ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__GroupLoopedModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:593:1: ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            else if ( (LA9_0==34) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("589:1: rule__GroupLoopedModel__Alternatives_0_3 : ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:594:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:594:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:595:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:596:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:596:2: rule__GroupLoopedModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__AbstractAssignment_0_3_0_in_rule__GroupLoopedModel__Alternatives_0_31246);
                    rule__GroupLoopedModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:600:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:600:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:601:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:602:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:602:2: rule__GroupLoopedModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__FinalAssignment_0_3_1_in_rule__GroupLoopedModel__Alternatives_0_31264);
                    rule__GroupLoopedModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__GroupLoopedModel__Alternatives_0_3


    // $ANTLR start rule__LoopedAlternativeModel__Alternatives_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:611:1: rule__LoopedAlternativeModel__Alternatives_0 : ( ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) ) | ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) ) | ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) ) | ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) ) | ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) ) );
    public final void rule__LoopedAlternativeModel__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:615:1: ( ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) ) | ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) ) | ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) ) | ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) ) | ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 11:
            case 12:
            case 13:
                {
                alt10=1;
                }
                break;
            case 31:
                {
                alt10=2;
                }
                break;
            case 32:
                {
                alt10=3;
                }
                break;
            case 33:
            case 34:
                {
                alt10=4;
                }
                break;
            case 23:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("611:1: rule__LoopedAlternativeModel__Alternatives_0 : ( ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) ) | ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) ) | ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) ) | ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) ) | ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:616:1: ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:616:1: ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:617:1: ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:618:1: ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:618:2: rule__LoopedAlternativeModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__VisibilityAssignment_0_0_in_rule__LoopedAlternativeModel__Alternatives_01297);
                    rule__LoopedAlternativeModel__VisibilityAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:622:6: ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:622:6: ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:623:1: ( rule__LoopedAlternativeModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:624:1: ( rule__LoopedAlternativeModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:624:2: rule__LoopedAlternativeModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__StaticAssignment_0_1_in_rule__LoopedAlternativeModel__Alternatives_01315);
                    rule__LoopedAlternativeModel__StaticAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedAlternativeModelAccess().getStaticAssignment_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:628:6: ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:628:6: ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:1: ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:630:1: ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:630:2: rule__LoopedAlternativeModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__SynchronizedAssignment_0_2_in_rule__LoopedAlternativeModel__Alternatives_01333);
                    rule__LoopedAlternativeModel__SynchronizedAssignment_0_2();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedAssignment_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:634:6: ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:634:6: ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:1: ( rule__LoopedAlternativeModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:1: ( rule__LoopedAlternativeModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:2: rule__LoopedAlternativeModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_3_in_rule__LoopedAlternativeModel__Alternatives_01351);
                    rule__LoopedAlternativeModel__Alternatives_0_3();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:640:6: ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:640:6: ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:641:1: ( rule__LoopedAlternativeModel__Group_0_4__0 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getGroup_0_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:642:1: ( rule__LoopedAlternativeModel__Group_0_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:642:2: rule__LoopedAlternativeModel__Group_0_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0_in_rule__LoopedAlternativeModel__Alternatives_01369);
                    rule__LoopedAlternativeModel__Group_0_4__0();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedAlternativeModelAccess().getGroup_0_4()); 

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
    // $ANTLR end rule__LoopedAlternativeModel__Alternatives_0


    // $ANTLR start rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:651:1: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:655:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt11=1;
                }
                break;
            case 12:
                {
                alt11=2;
                }
                break;
            case 13:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("651:1: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:656:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:656:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:657:1: 'public'
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01403); 
                     after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:665:1: 'private'
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01423); 
                     after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:672:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:672:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:673:1: 'protected'
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01443); 
                     after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0


    // $ANTLR start rule__LoopedAlternativeModel__Alternatives_0_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:685:1: rule__LoopedAlternativeModel__Alternatives_0_3 : ( ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__LoopedAlternativeModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:689:1: ( ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==33) ) {
                alt12=1;
            }
            else if ( (LA12_0==34) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("685:1: rule__LoopedAlternativeModel__Alternatives_0_3 : ( ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) ) );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:690:1: ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:690:1: ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:691:1: ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:692:1: ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:692:2: rule__LoopedAlternativeModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__AbstractAssignment_0_3_0_in_rule__LoopedAlternativeModel__Alternatives_0_31477);
                    rule__LoopedAlternativeModel__AbstractAssignment_0_3_0();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAssignment_0_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:6: ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:6: ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:1: ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:1: ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:2: rule__LoopedAlternativeModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__FinalAssignment_0_3_1_in_rule__LoopedAlternativeModel__Alternatives_0_31495);
                    rule__LoopedAlternativeModel__FinalAssignment_0_3_1();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedAlternativeModelAccess().getFinalAssignment_0_3_1()); 

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
    // $ANTLR end rule__LoopedAlternativeModel__Alternatives_0_3


    // $ANTLR start rule__Bug304681Feature__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:707:1: rule__Bug304681Feature__Alternatives : ( ( ruleBug304681Attribute ) | ( ruleBug304681Reference ) );
    public final void rule__Bug304681Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:711:1: ( ( ruleBug304681Attribute ) | ( ruleBug304681Reference ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( (LA13_0==30) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("707:1: rule__Bug304681Feature__Alternatives : ( ( ruleBug304681Attribute ) | ( ruleBug304681Reference ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:712:1: ( ruleBug304681Attribute )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:712:1: ( ruleBug304681Attribute )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:713:1: ruleBug304681Attribute
                    {
                     before(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_rule__Bug304681Feature__Alternatives1528);
                    ruleBug304681Attribute();
                    _fsp--;

                     after(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:718:6: ( ruleBug304681Reference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:718:6: ( ruleBug304681Reference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:719:1: ruleBug304681Reference
                    {
                     before(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_rule__Bug304681Feature__Alternatives1545);
                    ruleBug304681Reference();
                    _fsp--;

                     after(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1()); 

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
    // $ANTLR end rule__Bug304681Feature__Alternatives


    // $ANTLR start rule__Model__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:731:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__01575);
            rule__Model__Group_0__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01578);
            rule__Model__Group_0__1();
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
    // $ANTLR end rule__Model__Group_0__0


    // $ANTLR start rule__Model__Group_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:743:1: rule__Model__Group_0__0__Impl : ( '1' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:747:1: ( ( '1' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:748:1: ( '1' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:748:1: ( '1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:749:1: '1'
            {
             before(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_0__0__Impl1606); 
             after(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_0__0__Impl


    // $ANTLR start rule__Model__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:762:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:766:1: ( rule__Model__Group_0__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:767:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__11637);
            rule__Model__Group_0__1__Impl();
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
    // $ANTLR end rule__Model__Group_0__1


    // $ANTLR start rule__Model__Group_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:773:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__FirstAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:777:1: ( ( ( rule__Model__FirstAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:778:1: ( ( rule__Model__FirstAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:778:1: ( ( rule__Model__FirstAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:779:1: ( rule__Model__FirstAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getFirstAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:780:1: ( rule__Model__FirstAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:780:2: rule__Model__FirstAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__1__Impl1664);
            rule__Model__FirstAssignment_0_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getFirstAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_0__1__Impl


    // $ANTLR start rule__Model__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:794:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:798:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:799:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__01698);
            rule__Model__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01701);
            rule__Model__Group_1__1();
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
    // $ANTLR end rule__Model__Group_1__0


    // $ANTLR start rule__Model__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:806:1: rule__Model__Group_1__0__Impl : ( '2' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:810:1: ( ( '2' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:811:1: ( '2' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:811:1: ( '2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:812:1: '2'
            {
             before(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_1__0__Impl1729); 
             after(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_1__0__Impl


    // $ANTLR start rule__Model__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:825:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:829:1: ( rule__Model__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:830:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11760);
            rule__Model__Group_1__1__Impl();
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
    // $ANTLR end rule__Model__Group_1__1


    // $ANTLR start rule__Model__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:836:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__SecondAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:840:1: ( ( ( rule__Model__SecondAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:841:1: ( ( rule__Model__SecondAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:841:1: ( ( rule__Model__SecondAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:842:1: ( rule__Model__SecondAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getSecondAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:843:1: ( rule__Model__SecondAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:843:2: rule__Model__SecondAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__1__Impl1787);
            rule__Model__SecondAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getSecondAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_1__1__Impl


    // $ANTLR start rule__Model__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:857:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:861:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:862:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__01821);
            rule__Model__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01824);
            rule__Model__Group_2__1();
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
    // $ANTLR end rule__Model__Group_2__0


    // $ANTLR start rule__Model__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:869:1: rule__Model__Group_2__0__Impl : ( '3' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:873:1: ( ( '3' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:1: ( '3' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:1: ( '3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:875:1: '3'
            {
             before(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__Group_2__0__Impl1852); 
             after(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_2__0__Impl


    // $ANTLR start rule__Model__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:888:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:892:1: ( rule__Model__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:893:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__11883);
            rule__Model__Group_2__1__Impl();
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
    // $ANTLR end rule__Model__Group_2__1


    // $ANTLR start rule__Model__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:899:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__ThrirdAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:903:1: ( ( ( rule__Model__ThrirdAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:904:1: ( ( rule__Model__ThrirdAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:904:1: ( ( rule__Model__ThrirdAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:905:1: ( rule__Model__ThrirdAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getThrirdAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:906:1: ( rule__Model__ThrirdAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:906:2: rule__Model__ThrirdAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__1__Impl1910);
            rule__Model__ThrirdAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getThrirdAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_2__1__Impl


    // $ANTLR start rule__Model__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:920:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:924:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:925:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__0__Impl_in_rule__Model__Group_3__01944);
            rule__Model__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01947);
            rule__Model__Group_3__1();
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
    // $ANTLR end rule__Model__Group_3__0


    // $ANTLR start rule__Model__Group_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:932:1: rule__Model__Group_3__0__Impl : ( '4' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:936:1: ( ( '4' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:937:1: ( '4' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:937:1: ( '4' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:938:1: '4'
            {
             before(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__Group_3__0__Impl1975); 
             after(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_3__0__Impl


    // $ANTLR start rule__Model__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:951:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:955:1: ( rule__Model__Group_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:956:2: rule__Model__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__1__Impl_in_rule__Model__Group_3__12006);
            rule__Model__Group_3__1__Impl();
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
    // $ANTLR end rule__Model__Group_3__1


    // $ANTLR start rule__Model__Group_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:962:1: rule__Model__Group_3__1__Impl : ( ( rule__Model__ForthAssignment_3_1 ) ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:966:1: ( ( ( rule__Model__ForthAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:967:1: ( ( rule__Model__ForthAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:967:1: ( ( rule__Model__ForthAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:968:1: ( rule__Model__ForthAssignment_3_1 )
            {
             before(grammarAccess.getModelAccess().getForthAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:969:1: ( rule__Model__ForthAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:969:2: rule__Model__ForthAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__1__Impl2033);
            rule__Model__ForthAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getForthAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_3__1__Impl


    // $ANTLR start rule__Model__Group_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:983:1: rule__Model__Group_4__0 : rule__Model__Group_4__0__Impl rule__Model__Group_4__1 ;
    public final void rule__Model__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:987:1: ( rule__Model__Group_4__0__Impl rule__Model__Group_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:988:2: rule__Model__Group_4__0__Impl rule__Model__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__0__Impl_in_rule__Model__Group_4__02067);
            rule__Model__Group_4__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__1_in_rule__Model__Group_4__02070);
            rule__Model__Group_4__1();
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
    // $ANTLR end rule__Model__Group_4__0


    // $ANTLR start rule__Model__Group_4__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:995:1: rule__Model__Group_4__0__Impl : ( '5' ) ;
    public final void rule__Model__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:999:1: ( ( '5' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1000:1: ( '5' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1000:1: ( '5' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1001:1: '5'
            {
             before(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Model__Group_4__0__Impl2098); 
             after(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_4__0__Impl


    // $ANTLR start rule__Model__Group_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1014:1: rule__Model__Group_4__1 : rule__Model__Group_4__1__Impl ;
    public final void rule__Model__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: ( rule__Model__Group_4__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:2: rule__Model__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__1__Impl_in_rule__Model__Group_4__12129);
            rule__Model__Group_4__1__Impl();
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
    // $ANTLR end rule__Model__Group_4__1


    // $ANTLR start rule__Model__Group_4__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1025:1: rule__Model__Group_4__1__Impl : ( ( rule__Model__FifthAssignment_4_1 ) ) ;
    public final void rule__Model__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1029:1: ( ( ( rule__Model__FifthAssignment_4_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1030:1: ( ( rule__Model__FifthAssignment_4_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1030:1: ( ( rule__Model__FifthAssignment_4_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1031:1: ( rule__Model__FifthAssignment_4_1 )
            {
             before(grammarAccess.getModelAccess().getFifthAssignment_4_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1032:1: ( rule__Model__FifthAssignment_4_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1032:2: rule__Model__FifthAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__FifthAssignment_4_1_in_rule__Model__Group_4__1__Impl2156);
            rule__Model__FifthAssignment_4_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getFifthAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_4__1__Impl


    // $ANTLR start rule__Model__Group_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1046:1: rule__Model__Group_5__0 : rule__Model__Group_5__0__Impl rule__Model__Group_5__1 ;
    public final void rule__Model__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1050:1: ( rule__Model__Group_5__0__Impl rule__Model__Group_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1051:2: rule__Model__Group_5__0__Impl rule__Model__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__0__Impl_in_rule__Model__Group_5__02190);
            rule__Model__Group_5__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__1_in_rule__Model__Group_5__02193);
            rule__Model__Group_5__1();
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
    // $ANTLR end rule__Model__Group_5__0


    // $ANTLR start rule__Model__Group_5__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1058:1: rule__Model__Group_5__0__Impl : ( 'bug304681' ) ;
    public final void rule__Model__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1062:1: ( ( 'bug304681' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1063:1: ( 'bug304681' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1063:1: ( 'bug304681' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1064:1: 'bug304681'
            {
             before(grammarAccess.getModelAccess().getBug304681Keyword_5_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Model__Group_5__0__Impl2221); 
             after(grammarAccess.getModelAccess().getBug304681Keyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_5__0__Impl


    // $ANTLR start rule__Model__Group_5__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1077:1: rule__Model__Group_5__1 : rule__Model__Group_5__1__Impl ;
    public final void rule__Model__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1081:1: ( rule__Model__Group_5__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1082:2: rule__Model__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__1__Impl_in_rule__Model__Group_5__12252);
            rule__Model__Group_5__1__Impl();
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
    // $ANTLR end rule__Model__Group_5__1


    // $ANTLR start rule__Model__Group_5__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:1: rule__Model__Group_5__1__Impl : ( ( rule__Model__ModelAssignment_5_1 ) ) ;
    public final void rule__Model__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1092:1: ( ( ( rule__Model__ModelAssignment_5_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1093:1: ( ( rule__Model__ModelAssignment_5_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1093:1: ( ( rule__Model__ModelAssignment_5_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1094:1: ( rule__Model__ModelAssignment_5_1 )
            {
             before(grammarAccess.getModelAccess().getModelAssignment_5_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1095:1: ( rule__Model__ModelAssignment_5_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1095:2: rule__Model__ModelAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ModelAssignment_5_1_in_rule__Model__Group_5__1__Impl2279);
            rule__Model__ModelAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getModelAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_5__1__Impl


    // $ANTLR start rule__SimpleModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1109:1: rule__SimpleModel__Group__0 : rule__SimpleModel__Group__0__Impl rule__SimpleModel__Group__1 ;
    public final void rule__SimpleModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1113:1: ( rule__SimpleModel__Group__0__Impl rule__SimpleModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1114:2: rule__SimpleModel__Group__0__Impl rule__SimpleModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__0__Impl_in_rule__SimpleModel__Group__02313);
            rule__SimpleModel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__02316);
            rule__SimpleModel__Group__1();
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
    // $ANTLR end rule__SimpleModel__Group__0


    // $ANTLR start rule__SimpleModel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1121:1: rule__SimpleModel__Group__0__Impl : ( ( rule__SimpleModel__UnorderedGroup_0 ) ) ;
    public final void rule__SimpleModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1125:1: ( ( ( rule__SimpleModel__UnorderedGroup_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1126:1: ( ( rule__SimpleModel__UnorderedGroup_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1126:1: ( ( rule__SimpleModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1127:1: ( rule__SimpleModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1128:1: ( rule__SimpleModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1128:2: rule__SimpleModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__0__Impl2343);
            rule__SimpleModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__Group__0__Impl


    // $ANTLR start rule__SimpleModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1138:1: rule__SimpleModel__Group__1 : rule__SimpleModel__Group__1__Impl rule__SimpleModel__Group__2 ;
    public final void rule__SimpleModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1142:1: ( rule__SimpleModel__Group__1__Impl rule__SimpleModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1143:2: rule__SimpleModel__Group__1__Impl rule__SimpleModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__1__Impl_in_rule__SimpleModel__Group__12373);
            rule__SimpleModel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__12376);
            rule__SimpleModel__Group__2();
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
    // $ANTLR end rule__SimpleModel__Group__1


    // $ANTLR start rule__SimpleModel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1150:1: rule__SimpleModel__Group__1__Impl : ( 'class' ) ;
    public final void rule__SimpleModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1154:1: ( ( 'class' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1155:1: ( 'class' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1155:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1156:1: 'class'
            {
             before(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__SimpleModel__Group__1__Impl2404); 
             after(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__Group__1__Impl


    // $ANTLR start rule__SimpleModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1169:1: rule__SimpleModel__Group__2 : rule__SimpleModel__Group__2__Impl rule__SimpleModel__Group__3 ;
    public final void rule__SimpleModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1173:1: ( rule__SimpleModel__Group__2__Impl rule__SimpleModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1174:2: rule__SimpleModel__Group__2__Impl rule__SimpleModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__2__Impl_in_rule__SimpleModel__Group__22435);
            rule__SimpleModel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__22438);
            rule__SimpleModel__Group__3();
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
    // $ANTLR end rule__SimpleModel__Group__2


    // $ANTLR start rule__SimpleModel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1181:1: rule__SimpleModel__Group__2__Impl : ( ( rule__SimpleModel__NameAssignment_2 ) ) ;
    public final void rule__SimpleModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1185:1: ( ( ( rule__SimpleModel__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1186:1: ( ( rule__SimpleModel__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1186:1: ( ( rule__SimpleModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1187:1: ( rule__SimpleModel__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1188:1: ( rule__SimpleModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1188:2: rule__SimpleModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__2__Impl2465);
            rule__SimpleModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__Group__2__Impl


    // $ANTLR start rule__SimpleModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1198:1: rule__SimpleModel__Group__3 : rule__SimpleModel__Group__3__Impl rule__SimpleModel__Group__4 ;
    public final void rule__SimpleModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1202:1: ( rule__SimpleModel__Group__3__Impl rule__SimpleModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1203:2: rule__SimpleModel__Group__3__Impl rule__SimpleModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__3__Impl_in_rule__SimpleModel__Group__32495);
            rule__SimpleModel__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__32498);
            rule__SimpleModel__Group__4();
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
    // $ANTLR end rule__SimpleModel__Group__3


    // $ANTLR start rule__SimpleModel__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1210:1: rule__SimpleModel__Group__3__Impl : ( '{' ) ;
    public final void rule__SimpleModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1214:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1215:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1215:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1216:1: '{'
            {
             before(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__SimpleModel__Group__3__Impl2526); 
             after(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__Group__3__Impl


    // $ANTLR start rule__SimpleModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:1: rule__SimpleModel__Group__4 : rule__SimpleModel__Group__4__Impl ;
    public final void rule__SimpleModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:1: ( rule__SimpleModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:2: rule__SimpleModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__4__Impl_in_rule__SimpleModel__Group__42557);
            rule__SimpleModel__Group__4__Impl();
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
    // $ANTLR end rule__SimpleModel__Group__4


    // $ANTLR start rule__SimpleModel__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1240:1: rule__SimpleModel__Group__4__Impl : ( '}' ) ;
    public final void rule__SimpleModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1244:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1245:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1245:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1246:1: '}'
            {
             before(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__SimpleModel__Group__4__Impl2585); 
             after(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__Group__4__Impl


    // $ANTLR start rule__MandatoryModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1269:1: rule__MandatoryModel__Group__0 : rule__MandatoryModel__Group__0__Impl rule__MandatoryModel__Group__1 ;
    public final void rule__MandatoryModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1273:1: ( rule__MandatoryModel__Group__0__Impl rule__MandatoryModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1274:2: rule__MandatoryModel__Group__0__Impl rule__MandatoryModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__0__Impl_in_rule__MandatoryModel__Group__02626);
            rule__MandatoryModel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__02629);
            rule__MandatoryModel__Group__1();
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
    // $ANTLR end rule__MandatoryModel__Group__0


    // $ANTLR start rule__MandatoryModel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1281:1: rule__MandatoryModel__Group__0__Impl : ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) ;
    public final void rule__MandatoryModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1285:1: ( ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1286:1: ( ( rule__MandatoryModel__UnorderedGroup_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1286:1: ( ( rule__MandatoryModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1287:1: ( rule__MandatoryModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1288:1: ( rule__MandatoryModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1288:2: rule__MandatoryModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__0__Impl2656);
            rule__MandatoryModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__Group__0__Impl


    // $ANTLR start rule__MandatoryModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1298:1: rule__MandatoryModel__Group__1 : rule__MandatoryModel__Group__1__Impl rule__MandatoryModel__Group__2 ;
    public final void rule__MandatoryModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1302:1: ( rule__MandatoryModel__Group__1__Impl rule__MandatoryModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1303:2: rule__MandatoryModel__Group__1__Impl rule__MandatoryModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__1__Impl_in_rule__MandatoryModel__Group__12686);
            rule__MandatoryModel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__12689);
            rule__MandatoryModel__Group__2();
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
    // $ANTLR end rule__MandatoryModel__Group__1


    // $ANTLR start rule__MandatoryModel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1310:1: rule__MandatoryModel__Group__1__Impl : ( 'class' ) ;
    public final void rule__MandatoryModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1314:1: ( ( 'class' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1315:1: ( 'class' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1315:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1316:1: 'class'
            {
             before(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__MandatoryModel__Group__1__Impl2717); 
             after(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__Group__1__Impl


    // $ANTLR start rule__MandatoryModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1329:1: rule__MandatoryModel__Group__2 : rule__MandatoryModel__Group__2__Impl rule__MandatoryModel__Group__3 ;
    public final void rule__MandatoryModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1333:1: ( rule__MandatoryModel__Group__2__Impl rule__MandatoryModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1334:2: rule__MandatoryModel__Group__2__Impl rule__MandatoryModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__2__Impl_in_rule__MandatoryModel__Group__22748);
            rule__MandatoryModel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__22751);
            rule__MandatoryModel__Group__3();
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
    // $ANTLR end rule__MandatoryModel__Group__2


    // $ANTLR start rule__MandatoryModel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1341:1: rule__MandatoryModel__Group__2__Impl : ( ( rule__MandatoryModel__NameAssignment_2 ) ) ;
    public final void rule__MandatoryModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1345:1: ( ( ( rule__MandatoryModel__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1346:1: ( ( rule__MandatoryModel__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1346:1: ( ( rule__MandatoryModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1347:1: ( rule__MandatoryModel__NameAssignment_2 )
            {
             before(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1348:1: ( rule__MandatoryModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1348:2: rule__MandatoryModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__2__Impl2778);
            rule__MandatoryModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__Group__2__Impl


    // $ANTLR start rule__MandatoryModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1358:1: rule__MandatoryModel__Group__3 : rule__MandatoryModel__Group__3__Impl rule__MandatoryModel__Group__4 ;
    public final void rule__MandatoryModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1362:1: ( rule__MandatoryModel__Group__3__Impl rule__MandatoryModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1363:2: rule__MandatoryModel__Group__3__Impl rule__MandatoryModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__3__Impl_in_rule__MandatoryModel__Group__32808);
            rule__MandatoryModel__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__32811);
            rule__MandatoryModel__Group__4();
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
    // $ANTLR end rule__MandatoryModel__Group__3


    // $ANTLR start rule__MandatoryModel__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1370:1: rule__MandatoryModel__Group__3__Impl : ( '{' ) ;
    public final void rule__MandatoryModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1374:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1375:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1375:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1376:1: '{'
            {
             before(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__MandatoryModel__Group__3__Impl2839); 
             after(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__Group__3__Impl


    // $ANTLR start rule__MandatoryModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1389:1: rule__MandatoryModel__Group__4 : rule__MandatoryModel__Group__4__Impl ;
    public final void rule__MandatoryModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1393:1: ( rule__MandatoryModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1394:2: rule__MandatoryModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__4__Impl_in_rule__MandatoryModel__Group__42870);
            rule__MandatoryModel__Group__4__Impl();
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
    // $ANTLR end rule__MandatoryModel__Group__4


    // $ANTLR start rule__MandatoryModel__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1400:1: rule__MandatoryModel__Group__4__Impl : ( '}' ) ;
    public final void rule__MandatoryModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1404:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1405:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1405:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1406:1: '}'
            {
             before(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__MandatoryModel__Group__4__Impl2898); 
             after(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__Group__4__Impl


    // $ANTLR start rule__LoopedModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1429:1: rule__LoopedModel__Group__0 : rule__LoopedModel__Group__0__Impl rule__LoopedModel__Group__1 ;
    public final void rule__LoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1433:1: ( rule__LoopedModel__Group__0__Impl rule__LoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1434:2: rule__LoopedModel__Group__0__Impl rule__LoopedModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__0__Impl_in_rule__LoopedModel__Group__02939);
            rule__LoopedModel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__02942);
            rule__LoopedModel__Group__1();
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
    // $ANTLR end rule__LoopedModel__Group__0


    // $ANTLR start rule__LoopedModel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1441:1: rule__LoopedModel__Group__0__Impl : ( ( rule__LoopedModel__UnorderedGroup_0 ) ) ;
    public final void rule__LoopedModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1445:1: ( ( ( rule__LoopedModel__UnorderedGroup_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1446:1: ( ( rule__LoopedModel__UnorderedGroup_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1446:1: ( ( rule__LoopedModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1447:1: ( rule__LoopedModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1448:1: ( rule__LoopedModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1448:2: rule__LoopedModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__0__Impl2969);
            rule__LoopedModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__Group__0__Impl


    // $ANTLR start rule__LoopedModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1458:1: rule__LoopedModel__Group__1 : rule__LoopedModel__Group__1__Impl rule__LoopedModel__Group__2 ;
    public final void rule__LoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1462:1: ( rule__LoopedModel__Group__1__Impl rule__LoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1463:2: rule__LoopedModel__Group__1__Impl rule__LoopedModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__1__Impl_in_rule__LoopedModel__Group__12999);
            rule__LoopedModel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__13002);
            rule__LoopedModel__Group__2();
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
    // $ANTLR end rule__LoopedModel__Group__1


    // $ANTLR start rule__LoopedModel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1470:1: rule__LoopedModel__Group__1__Impl : ( 'class' ) ;
    public final void rule__LoopedModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1474:1: ( ( 'class' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1475:1: ( 'class' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1475:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1476:1: 'class'
            {
             before(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LoopedModel__Group__1__Impl3030); 
             after(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__Group__1__Impl


    // $ANTLR start rule__LoopedModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1489:1: rule__LoopedModel__Group__2 : rule__LoopedModel__Group__2__Impl rule__LoopedModel__Group__3 ;
    public final void rule__LoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1493:1: ( rule__LoopedModel__Group__2__Impl rule__LoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1494:2: rule__LoopedModel__Group__2__Impl rule__LoopedModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__2__Impl_in_rule__LoopedModel__Group__23061);
            rule__LoopedModel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__23064);
            rule__LoopedModel__Group__3();
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
    // $ANTLR end rule__LoopedModel__Group__2


    // $ANTLR start rule__LoopedModel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1501:1: rule__LoopedModel__Group__2__Impl : ( ( rule__LoopedModel__NameAssignment_2 ) ) ;
    public final void rule__LoopedModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1505:1: ( ( ( rule__LoopedModel__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:1: ( ( rule__LoopedModel__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:1: ( ( rule__LoopedModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1507:1: ( rule__LoopedModel__NameAssignment_2 )
            {
             before(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1508:1: ( rule__LoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1508:2: rule__LoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__2__Impl3091);
            rule__LoopedModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__Group__2__Impl


    // $ANTLR start rule__LoopedModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1518:1: rule__LoopedModel__Group__3 : rule__LoopedModel__Group__3__Impl rule__LoopedModel__Group__4 ;
    public final void rule__LoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1522:1: ( rule__LoopedModel__Group__3__Impl rule__LoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1523:2: rule__LoopedModel__Group__3__Impl rule__LoopedModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__3__Impl_in_rule__LoopedModel__Group__33121);
            rule__LoopedModel__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__33124);
            rule__LoopedModel__Group__4();
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
    // $ANTLR end rule__LoopedModel__Group__3


    // $ANTLR start rule__LoopedModel__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1530:1: rule__LoopedModel__Group__3__Impl : ( '{' ) ;
    public final void rule__LoopedModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1534:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1535:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1535:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1536:1: '{'
            {
             before(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LoopedModel__Group__3__Impl3152); 
             after(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__Group__3__Impl


    // $ANTLR start rule__LoopedModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1549:1: rule__LoopedModel__Group__4 : rule__LoopedModel__Group__4__Impl ;
    public final void rule__LoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1553:1: ( rule__LoopedModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1554:2: rule__LoopedModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__4__Impl_in_rule__LoopedModel__Group__43183);
            rule__LoopedModel__Group__4__Impl();
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
    // $ANTLR end rule__LoopedModel__Group__4


    // $ANTLR start rule__LoopedModel__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1560:1: rule__LoopedModel__Group__4__Impl : ( '}' ) ;
    public final void rule__LoopedModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1564:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1565:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1565:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1566:1: '}'
            {
             before(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LoopedModel__Group__4__Impl3211); 
             after(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__Group__4__Impl


    // $ANTLR start rule__GroupLoopedModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1589:1: rule__GroupLoopedModel__Group__0 : rule__GroupLoopedModel__Group__0__Impl rule__GroupLoopedModel__Group__1 ;
    public final void rule__GroupLoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1593:1: ( rule__GroupLoopedModel__Group__0__Impl rule__GroupLoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1594:2: rule__GroupLoopedModel__Group__0__Impl rule__GroupLoopedModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__0__Impl_in_rule__GroupLoopedModel__Group__03252);
            rule__GroupLoopedModel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__03255);
            rule__GroupLoopedModel__Group__1();
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
    // $ANTLR end rule__GroupLoopedModel__Group__0


    // $ANTLR start rule__GroupLoopedModel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1601:1: rule__GroupLoopedModel__Group__0__Impl : ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) ;
    public final void rule__GroupLoopedModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1605:1: ( ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1606:1: ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1606:1: ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1607:1: ( rule__GroupLoopedModel__UnorderedGroup_0 )*
            {
             before(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1608:1: ( rule__GroupLoopedModel__UnorderedGroup_0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( LA14_0 >=11 && LA14_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt14=1;
                }
                else if ( LA14_0 >=33 && LA14_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1608:2: rule__GroupLoopedModel__UnorderedGroup_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__0__Impl3282);
            	    rule__GroupLoopedModel__UnorderedGroup_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__Group__0__Impl


    // $ANTLR start rule__GroupLoopedModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1618:1: rule__GroupLoopedModel__Group__1 : rule__GroupLoopedModel__Group__1__Impl rule__GroupLoopedModel__Group__2 ;
    public final void rule__GroupLoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1622:1: ( rule__GroupLoopedModel__Group__1__Impl rule__GroupLoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1623:2: rule__GroupLoopedModel__Group__1__Impl rule__GroupLoopedModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__1__Impl_in_rule__GroupLoopedModel__Group__13313);
            rule__GroupLoopedModel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__13316);
            rule__GroupLoopedModel__Group__2();
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
    // $ANTLR end rule__GroupLoopedModel__Group__1


    // $ANTLR start rule__GroupLoopedModel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1630:1: rule__GroupLoopedModel__Group__1__Impl : ( 'class' ) ;
    public final void rule__GroupLoopedModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1634:1: ( ( 'class' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1635:1: ( 'class' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1635:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1636:1: 'class'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__GroupLoopedModel__Group__1__Impl3344); 
             after(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__Group__1__Impl


    // $ANTLR start rule__GroupLoopedModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1649:1: rule__GroupLoopedModel__Group__2 : rule__GroupLoopedModel__Group__2__Impl rule__GroupLoopedModel__Group__3 ;
    public final void rule__GroupLoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1653:1: ( rule__GroupLoopedModel__Group__2__Impl rule__GroupLoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1654:2: rule__GroupLoopedModel__Group__2__Impl rule__GroupLoopedModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__2__Impl_in_rule__GroupLoopedModel__Group__23375);
            rule__GroupLoopedModel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__23378);
            rule__GroupLoopedModel__Group__3();
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
    // $ANTLR end rule__GroupLoopedModel__Group__2


    // $ANTLR start rule__GroupLoopedModel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1661:1: rule__GroupLoopedModel__Group__2__Impl : ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) ;
    public final void rule__GroupLoopedModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1665:1: ( ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1666:1: ( ( rule__GroupLoopedModel__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1666:1: ( ( rule__GroupLoopedModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1667:1: ( rule__GroupLoopedModel__NameAssignment_2 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1668:1: ( rule__GroupLoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1668:2: rule__GroupLoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__2__Impl3405);
            rule__GroupLoopedModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__Group__2__Impl


    // $ANTLR start rule__GroupLoopedModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1678:1: rule__GroupLoopedModel__Group__3 : rule__GroupLoopedModel__Group__3__Impl rule__GroupLoopedModel__Group__4 ;
    public final void rule__GroupLoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1682:1: ( rule__GroupLoopedModel__Group__3__Impl rule__GroupLoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:2: rule__GroupLoopedModel__Group__3__Impl rule__GroupLoopedModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__3__Impl_in_rule__GroupLoopedModel__Group__33435);
            rule__GroupLoopedModel__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__33438);
            rule__GroupLoopedModel__Group__4();
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
    // $ANTLR end rule__GroupLoopedModel__Group__3


    // $ANTLR start rule__GroupLoopedModel__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1690:1: rule__GroupLoopedModel__Group__3__Impl : ( '{' ) ;
    public final void rule__GroupLoopedModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1694:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1695:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1695:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1696:1: '{'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__GroupLoopedModel__Group__3__Impl3466); 
             after(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__Group__3__Impl


    // $ANTLR start rule__GroupLoopedModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1709:1: rule__GroupLoopedModel__Group__4 : rule__GroupLoopedModel__Group__4__Impl ;
    public final void rule__GroupLoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1713:1: ( rule__GroupLoopedModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1714:2: rule__GroupLoopedModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__4__Impl_in_rule__GroupLoopedModel__Group__43497);
            rule__GroupLoopedModel__Group__4__Impl();
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
    // $ANTLR end rule__GroupLoopedModel__Group__4


    // $ANTLR start rule__GroupLoopedModel__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1720:1: rule__GroupLoopedModel__Group__4__Impl : ( '}' ) ;
    public final void rule__GroupLoopedModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1724:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1725:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1725:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1726:1: '}'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GroupLoopedModel__Group__4__Impl3525); 
             after(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__Group__4__Impl


    // $ANTLR start rule__LoopedAlternativeModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1749:1: rule__LoopedAlternativeModel__Group__0 : rule__LoopedAlternativeModel__Group__0__Impl rule__LoopedAlternativeModel__Group__1 ;
    public final void rule__LoopedAlternativeModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1753:1: ( rule__LoopedAlternativeModel__Group__0__Impl rule__LoopedAlternativeModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1754:2: rule__LoopedAlternativeModel__Group__0__Impl rule__LoopedAlternativeModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__0__Impl_in_rule__LoopedAlternativeModel__Group__03566);
            rule__LoopedAlternativeModel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__1_in_rule__LoopedAlternativeModel__Group__03569);
            rule__LoopedAlternativeModel__Group__1();
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
    // $ANTLR end rule__LoopedAlternativeModel__Group__0


    // $ANTLR start rule__LoopedAlternativeModel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:1: rule__LoopedAlternativeModel__Group__0__Impl : ( ( rule__LoopedAlternativeModel__Alternatives_0 )* ) ;
    public final void rule__LoopedAlternativeModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1765:1: ( ( ( rule__LoopedAlternativeModel__Alternatives_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1766:1: ( ( rule__LoopedAlternativeModel__Alternatives_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1766:1: ( ( rule__LoopedAlternativeModel__Alternatives_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1767:1: ( rule__LoopedAlternativeModel__Alternatives_0 )*
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1768:1: ( rule__LoopedAlternativeModel__Alternatives_0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=11 && LA15_0<=13)||LA15_0==23||(LA15_0>=31 && LA15_0<=34)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1768:2: rule__LoopedAlternativeModel__Alternatives_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_in_rule__LoopedAlternativeModel__Group__0__Impl3596);
            	    rule__LoopedAlternativeModel__Alternatives_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__Group__0__Impl


    // $ANTLR start rule__LoopedAlternativeModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1778:1: rule__LoopedAlternativeModel__Group__1 : rule__LoopedAlternativeModel__Group__1__Impl rule__LoopedAlternativeModel__Group__2 ;
    public final void rule__LoopedAlternativeModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1782:1: ( rule__LoopedAlternativeModel__Group__1__Impl rule__LoopedAlternativeModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1783:2: rule__LoopedAlternativeModel__Group__1__Impl rule__LoopedAlternativeModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__1__Impl_in_rule__LoopedAlternativeModel__Group__13627);
            rule__LoopedAlternativeModel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__2_in_rule__LoopedAlternativeModel__Group__13630);
            rule__LoopedAlternativeModel__Group__2();
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
    // $ANTLR end rule__LoopedAlternativeModel__Group__1


    // $ANTLR start rule__LoopedAlternativeModel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1790:1: rule__LoopedAlternativeModel__Group__1__Impl : ( 'class' ) ;
    public final void rule__LoopedAlternativeModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1794:1: ( ( 'class' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1795:1: ( 'class' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1795:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1796:1: 'class'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LoopedAlternativeModel__Group__1__Impl3658); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__Group__1__Impl


    // $ANTLR start rule__LoopedAlternativeModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1809:1: rule__LoopedAlternativeModel__Group__2 : rule__LoopedAlternativeModel__Group__2__Impl rule__LoopedAlternativeModel__Group__3 ;
    public final void rule__LoopedAlternativeModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1813:1: ( rule__LoopedAlternativeModel__Group__2__Impl rule__LoopedAlternativeModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1814:2: rule__LoopedAlternativeModel__Group__2__Impl rule__LoopedAlternativeModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__2__Impl_in_rule__LoopedAlternativeModel__Group__23689);
            rule__LoopedAlternativeModel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__3_in_rule__LoopedAlternativeModel__Group__23692);
            rule__LoopedAlternativeModel__Group__3();
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
    // $ANTLR end rule__LoopedAlternativeModel__Group__2


    // $ANTLR start rule__LoopedAlternativeModel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1821:1: rule__LoopedAlternativeModel__Group__2__Impl : ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) ) ;
    public final void rule__LoopedAlternativeModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1825:1: ( ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1826:1: ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1826:1: ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1827:1: ( rule__LoopedAlternativeModel__NameAssignment_2 )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1828:1: ( rule__LoopedAlternativeModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1828:2: rule__LoopedAlternativeModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__NameAssignment_2_in_rule__LoopedAlternativeModel__Group__2__Impl3719);
            rule__LoopedAlternativeModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__Group__2__Impl


    // $ANTLR start rule__LoopedAlternativeModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1838:1: rule__LoopedAlternativeModel__Group__3 : rule__LoopedAlternativeModel__Group__3__Impl rule__LoopedAlternativeModel__Group__4 ;
    public final void rule__LoopedAlternativeModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:1: ( rule__LoopedAlternativeModel__Group__3__Impl rule__LoopedAlternativeModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1843:2: rule__LoopedAlternativeModel__Group__3__Impl rule__LoopedAlternativeModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__3__Impl_in_rule__LoopedAlternativeModel__Group__33749);
            rule__LoopedAlternativeModel__Group__3__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__4_in_rule__LoopedAlternativeModel__Group__33752);
            rule__LoopedAlternativeModel__Group__4();
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
    // $ANTLR end rule__LoopedAlternativeModel__Group__3


    // $ANTLR start rule__LoopedAlternativeModel__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1850:1: rule__LoopedAlternativeModel__Group__3__Impl : ( '{' ) ;
    public final void rule__LoopedAlternativeModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1854:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1855:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1855:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1856:1: '{'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LoopedAlternativeModel__Group__3__Impl3780); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__Group__3__Impl


    // $ANTLR start rule__LoopedAlternativeModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1869:1: rule__LoopedAlternativeModel__Group__4 : rule__LoopedAlternativeModel__Group__4__Impl ;
    public final void rule__LoopedAlternativeModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1873:1: ( rule__LoopedAlternativeModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1874:2: rule__LoopedAlternativeModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__4__Impl_in_rule__LoopedAlternativeModel__Group__43811);
            rule__LoopedAlternativeModel__Group__4__Impl();
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
    // $ANTLR end rule__LoopedAlternativeModel__Group__4


    // $ANTLR start rule__LoopedAlternativeModel__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1880:1: rule__LoopedAlternativeModel__Group__4__Impl : ( '}' ) ;
    public final void rule__LoopedAlternativeModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1884:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1885:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1885:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1886:1: '}'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LoopedAlternativeModel__Group__4__Impl3839); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__Group__4__Impl


    // $ANTLR start rule__LoopedAlternativeModel__Group_0_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1909:1: rule__LoopedAlternativeModel__Group_0_4__0 : rule__LoopedAlternativeModel__Group_0_4__0__Impl rule__LoopedAlternativeModel__Group_0_4__1 ;
    public final void rule__LoopedAlternativeModel__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1913:1: ( rule__LoopedAlternativeModel__Group_0_4__0__Impl rule__LoopedAlternativeModel__Group_0_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1914:2: rule__LoopedAlternativeModel__Group_0_4__0__Impl rule__LoopedAlternativeModel__Group_0_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0__Impl_in_rule__LoopedAlternativeModel__Group_0_4__03880);
            rule__LoopedAlternativeModel__Group_0_4__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1_in_rule__LoopedAlternativeModel__Group_0_4__03883);
            rule__LoopedAlternativeModel__Group_0_4__1();
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
    // $ANTLR end rule__LoopedAlternativeModel__Group_0_4__0


    // $ANTLR start rule__LoopedAlternativeModel__Group_0_4__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1921:1: rule__LoopedAlternativeModel__Group_0_4__0__Impl : ( 'before' ) ;
    public final void rule__LoopedAlternativeModel__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1925:1: ( ( 'before' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1926:1: ( 'before' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1926:1: ( 'before' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1927:1: 'before'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LoopedAlternativeModel__Group_0_4__0__Impl3911); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__Group_0_4__0__Impl


    // $ANTLR start rule__LoopedAlternativeModel__Group_0_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1940:1: rule__LoopedAlternativeModel__Group_0_4__1 : rule__LoopedAlternativeModel__Group_0_4__1__Impl ;
    public final void rule__LoopedAlternativeModel__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1944:1: ( rule__LoopedAlternativeModel__Group_0_4__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1945:2: rule__LoopedAlternativeModel__Group_0_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1__Impl_in_rule__LoopedAlternativeModel__Group_0_4__13942);
            rule__LoopedAlternativeModel__Group_0_4__1__Impl();
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
    // $ANTLR end rule__LoopedAlternativeModel__Group_0_4__1


    // $ANTLR start rule__LoopedAlternativeModel__Group_0_4__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1951:1: rule__LoopedAlternativeModel__Group_0_4__1__Impl : ( ( 'after' )* ) ;
    public final void rule__LoopedAlternativeModel__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1955:1: ( ( ( 'after' )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1956:1: ( ( 'after' )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1956:1: ( ( 'after' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1957:1: ( 'after' )*
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1958:1: ( 'after' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1959:2: 'after'
            	    {
            	    match(input,24,FollowSets000.FOLLOW_24_in_rule__LoopedAlternativeModel__Group_0_4__1__Impl3971); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__Group_0_4__1__Impl


    // $ANTLR start rule__Bug304681Model__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1974:1: rule__Bug304681Model__Group__0 : rule__Bug304681Model__Group__0__Impl rule__Bug304681Model__Group__1 ;
    public final void rule__Bug304681Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1978:1: ( rule__Bug304681Model__Group__0__Impl rule__Bug304681Model__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1979:2: rule__Bug304681Model__Group__0__Impl rule__Bug304681Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__0__Impl_in_rule__Bug304681Model__Group__04008);
            rule__Bug304681Model__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__1_in_rule__Bug304681Model__Group__04011);
            rule__Bug304681Model__Group__1();
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
    // $ANTLR end rule__Bug304681Model__Group__0


    // $ANTLR start rule__Bug304681Model__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1986:1: rule__Bug304681Model__Group__0__Impl : ( '{' ) ;
    public final void rule__Bug304681Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1990:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1991:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1991:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1992:1: '{'
            {
             before(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Bug304681Model__Group__0__Impl4039); 
             after(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group__0__Impl


    // $ANTLR start rule__Bug304681Model__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2005:1: rule__Bug304681Model__Group__1 : rule__Bug304681Model__Group__1__Impl rule__Bug304681Model__Group__2 ;
    public final void rule__Bug304681Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2009:1: ( rule__Bug304681Model__Group__1__Impl rule__Bug304681Model__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2010:2: rule__Bug304681Model__Group__1__Impl rule__Bug304681Model__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__1__Impl_in_rule__Bug304681Model__Group__14070);
            rule__Bug304681Model__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__14073);
            rule__Bug304681Model__Group__2();
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
    // $ANTLR end rule__Bug304681Model__Group__1


    // $ANTLR start rule__Bug304681Model__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2017:1: rule__Bug304681Model__Group__1__Impl : ( ( rule__Bug304681Model__UnorderedGroup_1 ) ) ;
    public final void rule__Bug304681Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2021:1: ( ( ( rule__Bug304681Model__UnorderedGroup_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2022:1: ( ( rule__Bug304681Model__UnorderedGroup_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2022:1: ( ( rule__Bug304681Model__UnorderedGroup_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2023:1: ( rule__Bug304681Model__UnorderedGroup_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2024:1: ( rule__Bug304681Model__UnorderedGroup_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2024:2: rule__Bug304681Model__UnorderedGroup_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1_in_rule__Bug304681Model__Group__1__Impl4100);
            rule__Bug304681Model__UnorderedGroup_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group__1__Impl


    // $ANTLR start rule__Bug304681Model__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2034:1: rule__Bug304681Model__Group__2 : rule__Bug304681Model__Group__2__Impl ;
    public final void rule__Bug304681Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2038:1: ( rule__Bug304681Model__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2039:2: rule__Bug304681Model__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__2__Impl_in_rule__Bug304681Model__Group__24130);
            rule__Bug304681Model__Group__2__Impl();
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
    // $ANTLR end rule__Bug304681Model__Group__2


    // $ANTLR start rule__Bug304681Model__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2045:1: rule__Bug304681Model__Group__2__Impl : ( '}' ) ;
    public final void rule__Bug304681Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2049:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2050:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2050:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2051:1: '}'
            {
             before(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Bug304681Model__Group__2__Impl4158); 
             after(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group__2__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2070:1: rule__Bug304681Model__Group_1_0__0 : rule__Bug304681Model__Group_1_0__0__Impl rule__Bug304681Model__Group_1_0__1 ;
    public final void rule__Bug304681Model__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2074:1: ( rule__Bug304681Model__Group_1_0__0__Impl rule__Bug304681Model__Group_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2075:2: rule__Bug304681Model__Group_1_0__0__Impl rule__Bug304681Model__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__0__Impl_in_rule__Bug304681Model__Group_1_0__04195);
            rule__Bug304681Model__Group_1_0__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__1_in_rule__Bug304681Model__Group_1_0__04198);
            rule__Bug304681Model__Group_1_0__1();
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
    // $ANTLR end rule__Bug304681Model__Group_1_0__0


    // $ANTLR start rule__Bug304681Model__Group_1_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2082:1: rule__Bug304681Model__Group_1_0__0__Impl : ( 'short' ) ;
    public final void rule__Bug304681Model__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2086:1: ( ( 'short' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2087:1: ( 'short' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2087:1: ( 'short' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2088:1: 'short'
            {
             before(grammarAccess.getBug304681ModelAccess().getShortKeyword_1_0_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Bug304681Model__Group_1_0__0__Impl4226); 
             after(grammarAccess.getBug304681ModelAccess().getShortKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_0__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2101:1: rule__Bug304681Model__Group_1_0__1 : rule__Bug304681Model__Group_1_0__1__Impl rule__Bug304681Model__Group_1_0__2 ;
    public final void rule__Bug304681Model__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2105:1: ( rule__Bug304681Model__Group_1_0__1__Impl rule__Bug304681Model__Group_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2106:2: rule__Bug304681Model__Group_1_0__1__Impl rule__Bug304681Model__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__1__Impl_in_rule__Bug304681Model__Group_1_0__14257);
            rule__Bug304681Model__Group_1_0__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__2_in_rule__Bug304681Model__Group_1_0__14260);
            rule__Bug304681Model__Group_1_0__2();
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
    // $ANTLR end rule__Bug304681Model__Group_1_0__1


    // $ANTLR start rule__Bug304681Model__Group_1_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2113:1: rule__Bug304681Model__Group_1_0__1__Impl : ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) ) ;
    public final void rule__Bug304681Model__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2117:1: ( ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2118:1: ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2118:1: ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2119:1: ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_1_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2120:1: ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2120:2: rule__Bug304681Model__ShortDescriptionAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_1_0_1_in_rule__Bug304681Model__Group_1_0__1__Impl4287);
            rule__Bug304681Model__ShortDescriptionAssignment_1_0_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_0__1__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2130:1: rule__Bug304681Model__Group_1_0__2 : rule__Bug304681Model__Group_1_0__2__Impl ;
    public final void rule__Bug304681Model__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2134:1: ( rule__Bug304681Model__Group_1_0__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2135:2: rule__Bug304681Model__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__2__Impl_in_rule__Bug304681Model__Group_1_0__24317);
            rule__Bug304681Model__Group_1_0__2__Impl();
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
    // $ANTLR end rule__Bug304681Model__Group_1_0__2


    // $ANTLR start rule__Bug304681Model__Group_1_0__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2141:1: rule__Bug304681Model__Group_1_0__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2145:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2146:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2146:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2147:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_0_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_0__2__Impl4345); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_0__2__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2166:1: rule__Bug304681Model__Group_1_1__0 : rule__Bug304681Model__Group_1_1__0__Impl rule__Bug304681Model__Group_1_1__1 ;
    public final void rule__Bug304681Model__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2170:1: ( rule__Bug304681Model__Group_1_1__0__Impl rule__Bug304681Model__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2171:2: rule__Bug304681Model__Group_1_1__0__Impl rule__Bug304681Model__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__0__Impl_in_rule__Bug304681Model__Group_1_1__04382);
            rule__Bug304681Model__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__1_in_rule__Bug304681Model__Group_1_1__04385);
            rule__Bug304681Model__Group_1_1__1();
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
    // $ANTLR end rule__Bug304681Model__Group_1_1__0


    // $ANTLR start rule__Bug304681Model__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2178:1: rule__Bug304681Model__Group_1_1__0__Impl : ( 'long' ) ;
    public final void rule__Bug304681Model__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2182:1: ( ( 'long' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2183:1: ( 'long' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2183:1: ( 'long' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2184:1: 'long'
            {
             before(grammarAccess.getBug304681ModelAccess().getLongKeyword_1_1_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Bug304681Model__Group_1_1__0__Impl4413); 
             after(grammarAccess.getBug304681ModelAccess().getLongKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_1__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2197:1: rule__Bug304681Model__Group_1_1__1 : rule__Bug304681Model__Group_1_1__1__Impl rule__Bug304681Model__Group_1_1__2 ;
    public final void rule__Bug304681Model__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2201:1: ( rule__Bug304681Model__Group_1_1__1__Impl rule__Bug304681Model__Group_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2202:2: rule__Bug304681Model__Group_1_1__1__Impl rule__Bug304681Model__Group_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__1__Impl_in_rule__Bug304681Model__Group_1_1__14444);
            rule__Bug304681Model__Group_1_1__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__2_in_rule__Bug304681Model__Group_1_1__14447);
            rule__Bug304681Model__Group_1_1__2();
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
    // $ANTLR end rule__Bug304681Model__Group_1_1__1


    // $ANTLR start rule__Bug304681Model__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2209:1: rule__Bug304681Model__Group_1_1__1__Impl : ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) ) ;
    public final void rule__Bug304681Model__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2213:1: ( ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2214:1: ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2214:1: ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2215:1: ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2216:1: ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2216:2: rule__Bug304681Model__LongDescriptionAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_1_1_1_in_rule__Bug304681Model__Group_1_1__1__Impl4474);
            rule__Bug304681Model__LongDescriptionAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_1__1__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2226:1: rule__Bug304681Model__Group_1_1__2 : rule__Bug304681Model__Group_1_1__2__Impl ;
    public final void rule__Bug304681Model__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2230:1: ( rule__Bug304681Model__Group_1_1__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2231:2: rule__Bug304681Model__Group_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__2__Impl_in_rule__Bug304681Model__Group_1_1__24504);
            rule__Bug304681Model__Group_1_1__2__Impl();
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
    // $ANTLR end rule__Bug304681Model__Group_1_1__2


    // $ANTLR start rule__Bug304681Model__Group_1_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2237:1: rule__Bug304681Model__Group_1_1__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2241:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2242:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2242:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2243:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_1_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_1__2__Impl4532); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_1__2__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2262:1: rule__Bug304681Model__Group_1_2__0 : rule__Bug304681Model__Group_1_2__0__Impl rule__Bug304681Model__Group_1_2__1 ;
    public final void rule__Bug304681Model__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2266:1: ( rule__Bug304681Model__Group_1_2__0__Impl rule__Bug304681Model__Group_1_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2267:2: rule__Bug304681Model__Group_1_2__0__Impl rule__Bug304681Model__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__0__Impl_in_rule__Bug304681Model__Group_1_2__04569);
            rule__Bug304681Model__Group_1_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__1_in_rule__Bug304681Model__Group_1_2__04572);
            rule__Bug304681Model__Group_1_2__1();
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
    // $ANTLR end rule__Bug304681Model__Group_1_2__0


    // $ANTLR start rule__Bug304681Model__Group_1_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2274:1: rule__Bug304681Model__Group_1_2__0__Impl : ( 'uid' ) ;
    public final void rule__Bug304681Model__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2278:1: ( ( 'uid' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2279:1: ( 'uid' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2279:1: ( 'uid' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2280:1: 'uid'
            {
             before(grammarAccess.getBug304681ModelAccess().getUidKeyword_1_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Bug304681Model__Group_1_2__0__Impl4600); 
             after(grammarAccess.getBug304681ModelAccess().getUidKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_2__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2293:1: rule__Bug304681Model__Group_1_2__1 : rule__Bug304681Model__Group_1_2__1__Impl rule__Bug304681Model__Group_1_2__2 ;
    public final void rule__Bug304681Model__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2297:1: ( rule__Bug304681Model__Group_1_2__1__Impl rule__Bug304681Model__Group_1_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2298:2: rule__Bug304681Model__Group_1_2__1__Impl rule__Bug304681Model__Group_1_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__1__Impl_in_rule__Bug304681Model__Group_1_2__14631);
            rule__Bug304681Model__Group_1_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__2_in_rule__Bug304681Model__Group_1_2__14634);
            rule__Bug304681Model__Group_1_2__2();
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
    // $ANTLR end rule__Bug304681Model__Group_1_2__1


    // $ANTLR start rule__Bug304681Model__Group_1_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2305:1: rule__Bug304681Model__Group_1_2__1__Impl : ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) ) ;
    public final void rule__Bug304681Model__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2309:1: ( ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2310:1: ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2310:1: ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2311:1: ( rule__Bug304681Model__UidAssignment_1_2_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getUidAssignment_1_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2312:1: ( rule__Bug304681Model__UidAssignment_1_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2312:2: rule__Bug304681Model__UidAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UidAssignment_1_2_1_in_rule__Bug304681Model__Group_1_2__1__Impl4661);
            rule__Bug304681Model__UidAssignment_1_2_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getUidAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_2__1__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2322:1: rule__Bug304681Model__Group_1_2__2 : rule__Bug304681Model__Group_1_2__2__Impl ;
    public final void rule__Bug304681Model__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2326:1: ( rule__Bug304681Model__Group_1_2__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2327:2: rule__Bug304681Model__Group_1_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__2__Impl_in_rule__Bug304681Model__Group_1_2__24691);
            rule__Bug304681Model__Group_1_2__2__Impl();
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
    // $ANTLR end rule__Bug304681Model__Group_1_2__2


    // $ANTLR start rule__Bug304681Model__Group_1_2__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2333:1: rule__Bug304681Model__Group_1_2__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2337:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2338:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2338:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2339:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_2_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_2__2__Impl4719); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_2__2__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2358:1: rule__Bug304681Model__Group_1_3__0 : rule__Bug304681Model__Group_1_3__0__Impl rule__Bug304681Model__Group_1_3__1 ;
    public final void rule__Bug304681Model__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2362:1: ( rule__Bug304681Model__Group_1_3__0__Impl rule__Bug304681Model__Group_1_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2363:2: rule__Bug304681Model__Group_1_3__0__Impl rule__Bug304681Model__Group_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_3__0__Impl_in_rule__Bug304681Model__Group_1_3__04756);
            rule__Bug304681Model__Group_1_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_3__1_in_rule__Bug304681Model__Group_1_3__04759);
            rule__Bug304681Model__Group_1_3__1();
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
    // $ANTLR end rule__Bug304681Model__Group_1_3__0


    // $ANTLR start rule__Bug304681Model__Group_1_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2370:1: rule__Bug304681Model__Group_1_3__0__Impl : ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) ) ;
    public final void rule__Bug304681Model__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2374:1: ( ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2375:1: ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2375:1: ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2376:1: ( rule__Bug304681Model__FlagAssignment_1_3_0 )
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagAssignment_1_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2377:1: ( rule__Bug304681Model__FlagAssignment_1_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2377:2: rule__Bug304681Model__FlagAssignment_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FlagAssignment_1_3_0_in_rule__Bug304681Model__Group_1_3__0__Impl4786);
            rule__Bug304681Model__FlagAssignment_1_3_0();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getFlagAssignment_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_3__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_1_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2387:1: rule__Bug304681Model__Group_1_3__1 : rule__Bug304681Model__Group_1_3__1__Impl ;
    public final void rule__Bug304681Model__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2391:1: ( rule__Bug304681Model__Group_1_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2392:2: rule__Bug304681Model__Group_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_3__1__Impl_in_rule__Bug304681Model__Group_1_3__14816);
            rule__Bug304681Model__Group_1_3__1__Impl();
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
    // $ANTLR end rule__Bug304681Model__Group_1_3__1


    // $ANTLR start rule__Bug304681Model__Group_1_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2398:1: rule__Bug304681Model__Group_1_3__1__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2402:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2403:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2403:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2404:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_3_1()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_3__1__Impl4844); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_1_3__1__Impl


    // $ANTLR start rule__Bug304681Attribute__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2421:1: rule__Bug304681Attribute__Group__0 : rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1 ;
    public final void rule__Bug304681Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2425:1: ( rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2426:2: rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__0__Impl_in_rule__Bug304681Attribute__Group__04879);
            rule__Bug304681Attribute__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__04882);
            rule__Bug304681Attribute__Group__1();
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
    // $ANTLR end rule__Bug304681Attribute__Group__0


    // $ANTLR start rule__Bug304681Attribute__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2433:1: rule__Bug304681Attribute__Group__0__Impl : ( 'attr' ) ;
    public final void rule__Bug304681Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2437:1: ( ( 'attr' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2438:1: ( 'attr' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2438:1: ( 'attr' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2439:1: 'attr'
            {
             before(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__Bug304681Attribute__Group__0__Impl4910); 
             after(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Attribute__Group__0__Impl


    // $ANTLR start rule__Bug304681Attribute__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2452:1: rule__Bug304681Attribute__Group__1 : rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2 ;
    public final void rule__Bug304681Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2456:1: ( rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2457:2: rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__1__Impl_in_rule__Bug304681Attribute__Group__14941);
            rule__Bug304681Attribute__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__14944);
            rule__Bug304681Attribute__Group__2();
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
    // $ANTLR end rule__Bug304681Attribute__Group__1


    // $ANTLR start rule__Bug304681Attribute__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2464:1: rule__Bug304681Attribute__Group__1__Impl : ( ( rule__Bug304681Attribute__NameAssignment_1 ) ) ;
    public final void rule__Bug304681Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2468:1: ( ( ( rule__Bug304681Attribute__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2469:1: ( ( rule__Bug304681Attribute__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2469:1: ( ( rule__Bug304681Attribute__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2470:1: ( rule__Bug304681Attribute__NameAssignment_1 )
            {
             before(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2471:1: ( rule__Bug304681Attribute__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2471:2: rule__Bug304681Attribute__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__1__Impl4971);
            rule__Bug304681Attribute__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Attribute__Group__1__Impl


    // $ANTLR start rule__Bug304681Attribute__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2481:1: rule__Bug304681Attribute__Group__2 : rule__Bug304681Attribute__Group__2__Impl ;
    public final void rule__Bug304681Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2485:1: ( rule__Bug304681Attribute__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2486:2: rule__Bug304681Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__2__Impl_in_rule__Bug304681Attribute__Group__25001);
            rule__Bug304681Attribute__Group__2__Impl();
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
    // $ANTLR end rule__Bug304681Attribute__Group__2


    // $ANTLR start rule__Bug304681Attribute__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2492:1: rule__Bug304681Attribute__Group__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2496:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2497:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2497:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2498:1: ';'
            {
             before(grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Attribute__Group__2__Impl5029); 
             after(grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Attribute__Group__2__Impl


    // $ANTLR start rule__Bug304681Reference__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2517:1: rule__Bug304681Reference__Group__0 : rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1 ;
    public final void rule__Bug304681Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2521:1: ( rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2522:2: rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__0__Impl_in_rule__Bug304681Reference__Group__05066);
            rule__Bug304681Reference__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__05069);
            rule__Bug304681Reference__Group__1();
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
    // $ANTLR end rule__Bug304681Reference__Group__0


    // $ANTLR start rule__Bug304681Reference__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2529:1: rule__Bug304681Reference__Group__0__Impl : ( 'ref' ) ;
    public final void rule__Bug304681Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2533:1: ( ( 'ref' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2534:1: ( 'ref' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2534:1: ( 'ref' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2535:1: 'ref'
            {
             before(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Bug304681Reference__Group__0__Impl5097); 
             after(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Reference__Group__0__Impl


    // $ANTLR start rule__Bug304681Reference__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2548:1: rule__Bug304681Reference__Group__1 : rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2 ;
    public final void rule__Bug304681Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2552:1: ( rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2553:2: rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__1__Impl_in_rule__Bug304681Reference__Group__15128);
            rule__Bug304681Reference__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__15131);
            rule__Bug304681Reference__Group__2();
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
    // $ANTLR end rule__Bug304681Reference__Group__1


    // $ANTLR start rule__Bug304681Reference__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2560:1: rule__Bug304681Reference__Group__1__Impl : ( ( rule__Bug304681Reference__NameAssignment_1 ) ) ;
    public final void rule__Bug304681Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2564:1: ( ( ( rule__Bug304681Reference__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2565:1: ( ( rule__Bug304681Reference__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2565:1: ( ( rule__Bug304681Reference__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2566:1: ( rule__Bug304681Reference__NameAssignment_1 )
            {
             before(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2567:1: ( rule__Bug304681Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2567:2: rule__Bug304681Reference__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__1__Impl5158);
            rule__Bug304681Reference__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Reference__Group__1__Impl


    // $ANTLR start rule__Bug304681Reference__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2577:1: rule__Bug304681Reference__Group__2 : rule__Bug304681Reference__Group__2__Impl ;
    public final void rule__Bug304681Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2581:1: ( rule__Bug304681Reference__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2582:2: rule__Bug304681Reference__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__2__Impl_in_rule__Bug304681Reference__Group__25188);
            rule__Bug304681Reference__Group__2__Impl();
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
    // $ANTLR end rule__Bug304681Reference__Group__2


    // $ANTLR start rule__Bug304681Reference__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2588:1: rule__Bug304681Reference__Group__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2592:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2593:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2593:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2594:1: ';'
            {
             before(grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Reference__Group__2__Impl5216); 
             after(grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Reference__Group__2__Impl


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2614:1: rule__SimpleModel__UnorderedGroup_0 : ( rule__SimpleModel__UnorderedGroup_0__0 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2619:1: ( ( rule__SimpleModel__UnorderedGroup_0__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2620:2: ( rule__SimpleModel__UnorderedGroup_0__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2620:2: ( rule__SimpleModel__UnorderedGroup_0__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( LA17_0 >=11 && LA17_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt17=1;
            }
            else if ( LA17_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt17=1;
            }
            else if ( LA17_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt17=1;
            }
            else if ( LA17_0 >=33 && LA17_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2620:2: rule__SimpleModel__UnorderedGroup_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_rule__SimpleModel__UnorderedGroup_05254);
                    rule__SimpleModel__UnorderedGroup_0__0();
                    _fsp--;


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

            	getUnorderedGroupHelper().leave(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__UnorderedGroup_0


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2630:1: rule__SimpleModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) ) ;
    public final void rule__SimpleModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2635:1: ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2636:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2636:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )
            int alt18=4;
            int LA18_0 = input.LA(1);

            if ( LA18_0 >=11 && LA18_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt18=1;
            }
            else if ( LA18_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt18=2;
            }
            else if ( LA18_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt18=3;
            }
            else if ( LA18_0 >=33 && LA18_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt18=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2636:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2638:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2638:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2639:5: {...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2639:108: ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2640:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2646:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2648:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2649:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2649:8: rule__SimpleModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_0__Impl5341);
                    rule__SimpleModel__VisibilityAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2655:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2655:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2656:5: {...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2656:108: ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2657:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2663:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2665:7: ( rule__SimpleModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2666:7: ( rule__SimpleModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2666:8: rule__SimpleModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_0__Impl5432);
                    rule__SimpleModel__StaticAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2672:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2672:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2673:5: {...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2673:108: ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2674:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2680:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2683:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2683:8: rule__SimpleModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_0__Impl5523);
                    rule__SimpleModel__SynchronizedAssignment_0_2();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2689:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2689:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2690:5: {...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2690:108: ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2691:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2697:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2699:7: ( rule__SimpleModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2700:7: ( rule__SimpleModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2700:8: rule__SimpleModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_0__Impl5614);
                    rule__SimpleModel__Alternatives_0_3();
                    _fsp--;


                    }

                     after(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__UnorderedGroup_0__Impl


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2715:1: rule__SimpleModel__UnorderedGroup_0__0 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2719:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2720:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__05673);
            rule__SimpleModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2721:2: ( rule__SimpleModel__UnorderedGroup_0__1 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( LA19_0 >=11 && LA19_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt19=1;
            }
            else if ( LA19_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt19=1;
            }
            else if ( LA19_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt19=1;
            }
            else if ( LA19_0 >=33 && LA19_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2721:2: rule__SimpleModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_rule__SimpleModel__UnorderedGroup_0__05676);
                    rule__SimpleModel__UnorderedGroup_0__1();
                    _fsp--;


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
    // $ANTLR end rule__SimpleModel__UnorderedGroup_0__0


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2728:1: rule__SimpleModel__UnorderedGroup_0__1 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2732:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2733:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__15701);
            rule__SimpleModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2734:2: ( rule__SimpleModel__UnorderedGroup_0__2 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( LA20_0 >=11 && LA20_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt20=1;
            }
            else if ( LA20_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt20=1;
            }
            else if ( LA20_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt20=1;
            }
            else if ( LA20_0 >=33 && LA20_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2734:2: rule__SimpleModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_rule__SimpleModel__UnorderedGroup_0__15704);
                    rule__SimpleModel__UnorderedGroup_0__2();
                    _fsp--;


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
    // $ANTLR end rule__SimpleModel__UnorderedGroup_0__1


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2741:1: rule__SimpleModel__UnorderedGroup_0__2 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2745:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2746:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__25729);
            rule__SimpleModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2747:2: ( rule__SimpleModel__UnorderedGroup_0__3 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( LA21_0 >=11 && LA21_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt21=1;
            }
            else if ( LA21_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt21=1;
            }
            else if ( LA21_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt21=1;
            }
            else if ( LA21_0 >=33 && LA21_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2747:2: rule__SimpleModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_rule__SimpleModel__UnorderedGroup_0__25732);
                    rule__SimpleModel__UnorderedGroup_0__3();
                    _fsp--;


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
    // $ANTLR end rule__SimpleModel__UnorderedGroup_0__2


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2754:1: rule__SimpleModel__UnorderedGroup_0__3 : rule__SimpleModel__UnorderedGroup_0__Impl ;
    public final void rule__SimpleModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2758:1: ( rule__SimpleModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2759:2: rule__SimpleModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__35757);
            rule__SimpleModel__UnorderedGroup_0__Impl();
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
    // $ANTLR end rule__SimpleModel__UnorderedGroup_0__3


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2774:1: rule__MandatoryModel__UnorderedGroup_0 : rule__MandatoryModel__UnorderedGroup_0__0 {...}?;
    public final void rule__MandatoryModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2779:1: ( rule__MandatoryModel__UnorderedGroup_0__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2780:2: rule__MandatoryModel__UnorderedGroup_0__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__0_in_rule__MandatoryModel__UnorderedGroup_05789);
            rule__MandatoryModel__UnorderedGroup_0__0();
            _fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()) ) {
                throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__UnorderedGroup_0


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2791:1: rule__MandatoryModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) ) ;
    public final void rule__MandatoryModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2796:1: ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2797:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2797:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )
            int alt22=4;
            int LA22_0 = input.LA(1);

            if ( LA22_0 >=11 && LA22_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt22=1;
            }
            else if ( LA22_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                alt22=2;
            }
            else if ( LA22_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                alt22=3;
            }
            else if ( LA22_0 >=33 && LA22_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt22=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2797:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2799:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2799:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2800:5: {...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2800:111: ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2801:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2807:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2809:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2810:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2810:8: rule__MandatoryModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_0__Impl5878);
                    rule__MandatoryModel__VisibilityAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2816:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2816:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2817:5: {...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2817:111: ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2818:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2824:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2826:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2827:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2827:8: rule__MandatoryModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_0__Impl5969);
                    rule__MandatoryModel__StaticAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2833:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2833:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2834:5: {...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2834:111: ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2835:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2841:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2843:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2844:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2844:8: rule__MandatoryModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_0__Impl6060);
                    rule__MandatoryModel__SynchronizedAssignment_0_2();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2850:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2850:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2851:5: {...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2851:111: ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2852:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2858:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2860:7: ( rule__MandatoryModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2861:7: ( rule__MandatoryModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2861:8: rule__MandatoryModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_0__Impl6151);
                    rule__MandatoryModel__Alternatives_0_3();
                    _fsp--;


                    }

                     after(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__UnorderedGroup_0__Impl


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2876:1: rule__MandatoryModel__UnorderedGroup_0__0 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2880:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2881:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__06210);
            rule__MandatoryModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2882:2: ( rule__MandatoryModel__UnorderedGroup_0__1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( LA23_0 >=11 && LA23_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt23=1;
            }
            else if ( LA23_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                alt23=1;
            }
            else if ( LA23_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                alt23=1;
            }
            else if ( LA23_0 >=33 && LA23_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2882:2: rule__MandatoryModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_rule__MandatoryModel__UnorderedGroup_0__06213);
                    rule__MandatoryModel__UnorderedGroup_0__1();
                    _fsp--;


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
    // $ANTLR end rule__MandatoryModel__UnorderedGroup_0__0


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2889:1: rule__MandatoryModel__UnorderedGroup_0__1 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2893:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2894:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__16238);
            rule__MandatoryModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2895:2: ( rule__MandatoryModel__UnorderedGroup_0__2 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( LA24_0 >=11 && LA24_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                alt24=1;
            }
            else if ( LA24_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                alt24=1;
            }
            else if ( LA24_0 >=33 && LA24_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2895:2: rule__MandatoryModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_rule__MandatoryModel__UnorderedGroup_0__16241);
                    rule__MandatoryModel__UnorderedGroup_0__2();
                    _fsp--;


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
    // $ANTLR end rule__MandatoryModel__UnorderedGroup_0__1


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2902:1: rule__MandatoryModel__UnorderedGroup_0__2 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2906:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2907:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__26266);
            rule__MandatoryModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2908:2: ( rule__MandatoryModel__UnorderedGroup_0__3 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( LA25_0 >=11 && LA25_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                alt25=1;
            }
            else if ( LA25_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                alt25=1;
            }
            else if ( LA25_0 >=33 && LA25_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2908:2: rule__MandatoryModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_rule__MandatoryModel__UnorderedGroup_0__26269);
                    rule__MandatoryModel__UnorderedGroup_0__3();
                    _fsp--;


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
    // $ANTLR end rule__MandatoryModel__UnorderedGroup_0__2


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2915:1: rule__MandatoryModel__UnorderedGroup_0__3 : rule__MandatoryModel__UnorderedGroup_0__Impl ;
    public final void rule__MandatoryModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2919:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2920:2: rule__MandatoryModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__36294);
            rule__MandatoryModel__UnorderedGroup_0__Impl();
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
    // $ANTLR end rule__MandatoryModel__UnorderedGroup_0__3


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2935:1: rule__LoopedModel__UnorderedGroup_0 : ( rule__LoopedModel__UnorderedGroup_0__0 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2940:1: ( ( rule__LoopedModel__UnorderedGroup_0__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: ( rule__LoopedModel__UnorderedGroup_0__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: ( rule__LoopedModel__UnorderedGroup_0__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( LA26_0 >=11 && LA26_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt26=1;
            }
            else if ( LA26_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt26=1;
            }
            else if ( LA26_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt26=1;
            }
            else if ( LA26_0 >=33 && LA26_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: rule__LoopedModel__UnorderedGroup_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_rule__LoopedModel__UnorderedGroup_06326);
                    rule__LoopedModel__UnorderedGroup_0__0();
                    _fsp--;


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

            	getUnorderedGroupHelper().leave(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__UnorderedGroup_0


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2951:1: rule__LoopedModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) ) ;
    public final void rule__LoopedModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2956:1: ( ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2957:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2957:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )
            int alt31=4;
            int LA31_0 = input.LA(1);

            if ( LA31_0 >=11 && LA31_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt31=1;
            }
            else if ( LA31_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt31=2;
            }
            else if ( LA31_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt31=3;
            }
            else if ( LA31_0 >=33 && LA31_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt31=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2957:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2959:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2959:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2960:5: {...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2960:108: ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2961:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2967:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2968:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2968:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2969:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2970:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2970:8: rule__LoopedModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6414);
                    rule__LoopedModel__VisibilityAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2973:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2975:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
                    loop27:
                    do {
                        int alt27=2;
                        switch ( input.LA(1) ) {
                        case 11:
                            {
                            int LA27_1 = input.LA(2);

                            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                                alt27=1;
                            }


                            }
                            break;
                        case 12:
                            {
                            int LA27_2 = input.LA(2);

                            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                                alt27=1;
                            }


                            }
                            break;
                        case 13:
                            {
                            int LA27_3 = input.LA(2);

                            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                                alt27=1;
                            }


                            }
                            break;

                        }

                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2975:8: rule__LoopedModel__VisibilityAssignment_0_0
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6454);
                    	    rule__LoopedModel__VisibilityAssignment_0_0();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                     after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2981:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2981:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2982:5: {...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2982:108: ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2983:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2989:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2990:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2990:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2991:7: ( rule__LoopedModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2992:7: ( rule__LoopedModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2992:8: rule__LoopedModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6553);
                    rule__LoopedModel__StaticAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2995:6: ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2996:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2997:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==31) ) {
                            int LA28_2 = input.LA(2);

                            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                                alt28=1;
                            }


                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2997:8: rule__LoopedModel__StaticAssignment_0_1
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6593);
                    	    rule__LoopedModel__StaticAssignment_0_1();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                     after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3004:5: {...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3004:108: ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3005:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3011:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3012:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3012:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3013:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3014:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3014:8: rule__LoopedModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6692);
                    rule__LoopedModel__SynchronizedAssignment_0_2();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3017:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3018:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3019:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==32) ) {
                            int LA29_3 = input.LA(2);

                            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                                alt29=1;
                            }


                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3019:8: rule__LoopedModel__SynchronizedAssignment_0_2
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6732);
                    	    rule__LoopedModel__SynchronizedAssignment_0_2();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                     after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:4: ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:4: ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3026:5: {...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3026:108: ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3027:6: ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3033:6: ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3034:6: ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3034:6: ( ( rule__LoopedModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3035:7: ( rule__LoopedModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3036:7: ( rule__LoopedModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3036:8: rule__LoopedModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6831);
                    rule__LoopedModel__Alternatives_0_3();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3039:6: ( ( rule__LoopedModel__Alternatives_0_3 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3040:7: ( rule__LoopedModel__Alternatives_0_3 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3041:7: ( rule__LoopedModel__Alternatives_0_3 )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==33) ) {
                            int LA30_4 = input.LA(2);

                            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                                alt30=1;
                            }


                        }
                        else if ( (LA30_0==34) ) {
                            int LA30_5 = input.LA(2);

                            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                                alt30=1;
                            }


                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3041:8: rule__LoopedModel__Alternatives_0_3
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6871);
                    	    rule__LoopedModel__Alternatives_0_3();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                     after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 

                    }


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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__UnorderedGroup_0__Impl


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3056:1: rule__LoopedModel__UnorderedGroup_0__0 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3060:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3061:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__06937);
            rule__LoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3062:2: ( rule__LoopedModel__UnorderedGroup_0__1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( LA32_0 >=11 && LA32_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt32=1;
            }
            else if ( LA32_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt32=1;
            }
            else if ( LA32_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt32=1;
            }
            else if ( LA32_0 >=33 && LA32_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3062:2: rule__LoopedModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_rule__LoopedModel__UnorderedGroup_0__06940);
                    rule__LoopedModel__UnorderedGroup_0__1();
                    _fsp--;


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
    // $ANTLR end rule__LoopedModel__UnorderedGroup_0__0


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3069:1: rule__LoopedModel__UnorderedGroup_0__1 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3073:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__16965);
            rule__LoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3075:2: ( rule__LoopedModel__UnorderedGroup_0__2 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( LA33_0 >=11 && LA33_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt33=1;
            }
            else if ( LA33_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt33=1;
            }
            else if ( LA33_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt33=1;
            }
            else if ( LA33_0 >=33 && LA33_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3075:2: rule__LoopedModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_rule__LoopedModel__UnorderedGroup_0__16968);
                    rule__LoopedModel__UnorderedGroup_0__2();
                    _fsp--;


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
    // $ANTLR end rule__LoopedModel__UnorderedGroup_0__1


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3082:1: rule__LoopedModel__UnorderedGroup_0__2 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3086:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3087:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__26993);
            rule__LoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3088:2: ( rule__LoopedModel__UnorderedGroup_0__3 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( LA34_0 >=11 && LA34_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt34=1;
            }
            else if ( LA34_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt34=1;
            }
            else if ( LA34_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt34=1;
            }
            else if ( LA34_0 >=33 && LA34_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3088:2: rule__LoopedModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_rule__LoopedModel__UnorderedGroup_0__26996);
                    rule__LoopedModel__UnorderedGroup_0__3();
                    _fsp--;


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
    // $ANTLR end rule__LoopedModel__UnorderedGroup_0__2


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3095:1: rule__LoopedModel__UnorderedGroup_0__3 : rule__LoopedModel__UnorderedGroup_0__Impl ;
    public final void rule__LoopedModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3099:1: ( rule__LoopedModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3100:2: rule__LoopedModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__37021);
            rule__LoopedModel__UnorderedGroup_0__Impl();
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
    // $ANTLR end rule__LoopedModel__UnorderedGroup_0__3


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3115:1: rule__GroupLoopedModel__UnorderedGroup_0 : rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?;
    public final void rule__GroupLoopedModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3120:1: ( rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3121:2: rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__0_in_rule__GroupLoopedModel__UnorderedGroup_07053);
            rule__GroupLoopedModel__UnorderedGroup_0__0();
            _fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {
                throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__UnorderedGroup_0


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3132:1: rule__GroupLoopedModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) ) ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3137:1: ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3138:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3138:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )
            int alt35=4;
            int LA35_0 = input.LA(1);

            if ( LA35_0 >=11 && LA35_0<=13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt35=1;
            }
            else if ( LA35_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt35=2;
            }
            else if ( LA35_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt35=3;
            }
            else if ( LA35_0 >=33 && LA35_0<=34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt35=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3138:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3140:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3140:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3141:5: {...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3141:113: ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3142:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3148:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3150:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3151:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3151:8: rule__GroupLoopedModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7142);
                    rule__GroupLoopedModel__VisibilityAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3157:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3157:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3158:5: {...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3158:113: ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3159:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3165:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3167:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3168:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3168:8: rule__GroupLoopedModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7233);
                    rule__GroupLoopedModel__StaticAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3174:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3174:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3175:5: {...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3175:113: ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3176:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3182:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3184:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3185:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3185:8: rule__GroupLoopedModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7324);
                    rule__GroupLoopedModel__SynchronizedAssignment_0_2();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3191:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3191:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3192:5: {...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3192:113: ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3193:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3199:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3201:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3202:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3202:8: rule__GroupLoopedModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7415);
                    rule__GroupLoopedModel__Alternatives_0_3();
                    _fsp--;


                    }

                     after(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__UnorderedGroup_0__Impl


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3217:1: rule__GroupLoopedModel__UnorderedGroup_0__0 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3221:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3222:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__07474);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3223:2: ( rule__GroupLoopedModel__UnorderedGroup_0__1 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( LA36_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA36_1 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt36=1;
                }
            }
            else if ( LA36_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA36_2 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt36=1;
                }
            }
            else if ( LA36_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA36_3 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt36=1;
                }
            }
            else if ( LA36_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                int LA36_4 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt36=1;
                }
            }
            else if ( LA36_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                int LA36_5 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt36=1;
                }
            }
            else if ( LA36_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                int LA36_6 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt36=1;
                }
            }
            else if ( LA36_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                int LA36_7 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3223:2: rule__GroupLoopedModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_rule__GroupLoopedModel__UnorderedGroup_0__07477);
                    rule__GroupLoopedModel__UnorderedGroup_0__1();
                    _fsp--;


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
    // $ANTLR end rule__GroupLoopedModel__UnorderedGroup_0__0


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3230:1: rule__GroupLoopedModel__UnorderedGroup_0__1 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3234:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3235:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__17502);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3236:2: ( rule__GroupLoopedModel__UnorderedGroup_0__2 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( LA37_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA37_1 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt37=1;
                }
            }
            else if ( LA37_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA37_2 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt37=1;
                }
            }
            else if ( LA37_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA37_3 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt37=1;
                }
            }
            else if ( LA37_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                int LA37_4 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt37=1;
                }
            }
            else if ( LA37_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                int LA37_5 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt37=1;
                }
            }
            else if ( LA37_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                int LA37_6 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt37=1;
                }
            }
            else if ( LA37_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                int LA37_7 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3236:2: rule__GroupLoopedModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_rule__GroupLoopedModel__UnorderedGroup_0__17505);
                    rule__GroupLoopedModel__UnorderedGroup_0__2();
                    _fsp--;


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
    // $ANTLR end rule__GroupLoopedModel__UnorderedGroup_0__1


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3243:1: rule__GroupLoopedModel__UnorderedGroup_0__2 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3247:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3248:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__27530);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3249:2: ( rule__GroupLoopedModel__UnorderedGroup_0__3 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( LA38_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA38_1 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt38=1;
                }
            }
            else if ( LA38_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA38_2 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt38=1;
                }
            }
            else if ( LA38_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                int LA38_3 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt38=1;
                }
            }
            else if ( LA38_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                int LA38_4 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt38=1;
                }
            }
            else if ( LA38_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                int LA38_5 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt38=1;
                }
            }
            else if ( LA38_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                int LA38_6 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt38=1;
                }
            }
            else if ( LA38_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                int LA38_7 = input.LA(2);

                if ( getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3249:2: rule__GroupLoopedModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_rule__GroupLoopedModel__UnorderedGroup_0__27533);
                    rule__GroupLoopedModel__UnorderedGroup_0__3();
                    _fsp--;


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
    // $ANTLR end rule__GroupLoopedModel__UnorderedGroup_0__2


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3256:1: rule__GroupLoopedModel__UnorderedGroup_0__3 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3260:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3261:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__37558);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();
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
    // $ANTLR end rule__GroupLoopedModel__UnorderedGroup_0__3


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3276:1: rule__Bug304681Model__UnorderedGroup_1 : ( rule__Bug304681Model__UnorderedGroup_1__0 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3281:1: ( ( rule__Bug304681Model__UnorderedGroup_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: ( rule__Bug304681Model__UnorderedGroup_1__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: ( rule__Bug304681Model__UnorderedGroup_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( LA39_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1) ) {
                alt39=1;
            }
            else if ( LA39_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2) ) {
                alt39=1;
            }
            else if ( LA39_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3) ) {
                alt39=1;
            }
            else if ( LA39_0 >=29 && LA39_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: rule__Bug304681Model__UnorderedGroup_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__0_in_rule__Bug304681Model__UnorderedGroup_17590);
                    rule__Bug304681Model__UnorderedGroup_1__0();
                    _fsp--;


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

            	getUnorderedGroupHelper().leave(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_1


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3292:1: rule__Bug304681Model__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) ) ) ) ;
    public final void rule__Bug304681Model__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3297:1: ( ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3298:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3298:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) ) ) )
            int alt41=5;
            int LA41_0 = input.LA(1);

            if ( LA41_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0) ) {
                alt41=1;
            }
            else if ( LA41_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1) ) {
                alt41=2;
            }
            else if ( LA41_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2) ) {
                alt41=3;
            }
            else if ( LA41_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3) ) {
                alt41=4;
            }
            else if ( LA41_0 >=29 && LA41_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                alt41=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3298:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) ) ) )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3300:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3300:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3301:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3301:111: ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3302:6: ( ( rule__Bug304681Model__Group_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3308:6: ( ( rule__Bug304681Model__Group_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3310:7: ( rule__Bug304681Model__Group_1_0__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3311:7: ( rule__Bug304681Model__Group_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3311:8: rule__Bug304681Model__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7677);
                    rule__Bug304681Model__Group_1_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3317:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3317:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3318:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3318:111: ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3319:6: ( ( rule__Bug304681Model__Group_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3325:6: ( ( rule__Bug304681Model__Group_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3327:7: ( rule__Bug304681Model__Group_1_1__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3328:7: ( rule__Bug304681Model__Group_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3328:8: rule__Bug304681Model__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7768);
                    rule__Bug304681Model__Group_1_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_1_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3334:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3334:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3335:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3335:111: ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3336:6: ( ( rule__Bug304681Model__Group_1_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3342:6: ( ( rule__Bug304681Model__Group_1_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3344:7: ( rule__Bug304681Model__Group_1_2__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_1_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3345:7: ( rule__Bug304681Model__Group_1_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3345:8: rule__Bug304681Model__Group_1_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7859);
                    rule__Bug304681Model__Group_1_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_1_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3351:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3351:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3352:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3352:111: ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3353:6: ( ( rule__Bug304681Model__Group_1_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3359:6: ( ( rule__Bug304681Model__Group_1_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3361:7: ( rule__Bug304681Model__Group_1_3__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_1_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3362:7: ( rule__Bug304681Model__Group_1_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3362:8: rule__Bug304681Model__Group_1_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_3__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7950);
                    rule__Bug304681Model__Group_1_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_1_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3368:4: ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3368:4: ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3369:5: {...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3369:111: ( ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3370:6: ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3376:6: ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3377:6: ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3377:6: ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3378:7: ( rule__Bug304681Model__FeaturesAssignment_1_4 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_1_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3379:7: ( rule__Bug304681Model__FeaturesAssignment_1_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3379:8: rule__Bug304681Model__FeaturesAssignment_1_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_1_4_in_rule__Bug304681Model__UnorderedGroup_1__Impl8042);
                    rule__Bug304681Model__FeaturesAssignment_1_4();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_1_4()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3382:6: ( ( rule__Bug304681Model__FeaturesAssignment_1_4 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3383:7: ( rule__Bug304681Model__FeaturesAssignment_1_4 )*
                    {
                     before(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_1_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3384:7: ( rule__Bug304681Model__FeaturesAssignment_1_4 )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==29) ) {
                            int LA40_5 = input.LA(2);

                            if ( (LA40_5==RULE_ID) ) {
                                int LA40_8 = input.LA(3);

                                if ( (LA40_8==26) ) {
                                    int LA40_10 = input.LA(4);

                                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                                        alt40=1;
                                    }


                                }


                            }


                        }
                        else if ( (LA40_0==30) ) {
                            int LA40_6 = input.LA(2);

                            if ( (LA40_6==RULE_ID) ) {
                                int LA40_9 = input.LA(3);

                                if ( (LA40_9==26) ) {
                                    int LA40_11 = input.LA(4);

                                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                                        alt40=1;
                                    }


                                }


                            }


                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3384:8: rule__Bug304681Model__FeaturesAssignment_1_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_1_4_in_rule__Bug304681Model__UnorderedGroup_1__Impl8082);
                    	    rule__Bug304681Model__FeaturesAssignment_1_4();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                     after(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_1_4()); 

                    }


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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_1__Impl


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3399:1: rule__Bug304681Model__UnorderedGroup_1__0 : rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__1 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3403:1: ( rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3404:2: rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__08148);
            rule__Bug304681Model__UnorderedGroup_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3405:2: ( rule__Bug304681Model__UnorderedGroup_1__1 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( LA42_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0) ) {
                alt42=1;
            }
            else if ( LA42_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1) ) {
                alt42=1;
            }
            else if ( LA42_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2) ) {
                alt42=1;
            }
            else if ( LA42_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3) ) {
                alt42=1;
            }
            else if ( LA42_0 >=29 && LA42_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3405:2: rule__Bug304681Model__UnorderedGroup_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__1_in_rule__Bug304681Model__UnorderedGroup_1__08151);
                    rule__Bug304681Model__UnorderedGroup_1__1();
                    _fsp--;


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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_1__0


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3412:1: rule__Bug304681Model__UnorderedGroup_1__1 : rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__2 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3416:1: ( rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3417:2: rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__18176);
            rule__Bug304681Model__UnorderedGroup_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3418:2: ( rule__Bug304681Model__UnorderedGroup_1__2 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( LA43_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1) ) {
                alt43=1;
            }
            else if ( LA43_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2) ) {
                alt43=1;
            }
            else if ( LA43_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3) ) {
                alt43=1;
            }
            else if ( LA43_0 >=29 && LA43_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3418:2: rule__Bug304681Model__UnorderedGroup_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__2_in_rule__Bug304681Model__UnorderedGroup_1__18179);
                    rule__Bug304681Model__UnorderedGroup_1__2();
                    _fsp--;


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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_1__1


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3425:1: rule__Bug304681Model__UnorderedGroup_1__2 : rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__3 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3429:1: ( rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3430:2: rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__28204);
            rule__Bug304681Model__UnorderedGroup_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3431:2: ( rule__Bug304681Model__UnorderedGroup_1__3 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1) ) {
                alt44=1;
            }
            else if ( LA44_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2) ) {
                alt44=1;
            }
            else if ( LA44_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3) ) {
                alt44=1;
            }
            else if ( LA44_0 >=29 && LA44_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3431:2: rule__Bug304681Model__UnorderedGroup_1__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__3_in_rule__Bug304681Model__UnorderedGroup_1__28207);
                    rule__Bug304681Model__UnorderedGroup_1__3();
                    _fsp--;


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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_1__2


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3438:1: rule__Bug304681Model__UnorderedGroup_1__3 : rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__4 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3442:1: ( rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3443:2: rule__Bug304681Model__UnorderedGroup_1__Impl ( rule__Bug304681Model__UnorderedGroup_1__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__38232);
            rule__Bug304681Model__UnorderedGroup_1__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3444:2: ( rule__Bug304681Model__UnorderedGroup_1__4 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1) ) {
                alt45=1;
            }
            else if ( LA45_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2) ) {
                alt45=1;
            }
            else if ( LA45_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3) ) {
                alt45=1;
            }
            else if ( LA45_0 >=29 && LA45_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3444:2: rule__Bug304681Model__UnorderedGroup_1__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__4_in_rule__Bug304681Model__UnorderedGroup_1__38235);
                    rule__Bug304681Model__UnorderedGroup_1__4();
                    _fsp--;


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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_1__3


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3451:1: rule__Bug304681Model__UnorderedGroup_1__4 : rule__Bug304681Model__UnorderedGroup_1__Impl ;
    public final void rule__Bug304681Model__UnorderedGroup_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3455:1: ( rule__Bug304681Model__UnorderedGroup_1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3456:2: rule__Bug304681Model__UnorderedGroup_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__48260);
            rule__Bug304681Model__UnorderedGroup_1__Impl();
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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_1__4


    // $ANTLR start rule__Model__FirstAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3473:1: rule__Model__FirstAssignment_0_1 : ( ruleSimpleModel ) ;
    public final void rule__Model__FirstAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3477:1: ( ( ruleSimpleModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3478:1: ( ruleSimpleModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3478:1: ( ruleSimpleModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3479:1: ruleSimpleModel
            {
             before(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_18298);
            ruleSimpleModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__FirstAssignment_0_1


    // $ANTLR start rule__Model__SecondAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3488:1: rule__Model__SecondAssignment_1_1 : ( ruleMandatoryModel ) ;
    public final void rule__Model__SecondAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3492:1: ( ( ruleMandatoryModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3493:1: ( ruleMandatoryModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3493:1: ( ruleMandatoryModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3494:1: ruleMandatoryModel
            {
             before(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_18329);
            ruleMandatoryModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__SecondAssignment_1_1


    // $ANTLR start rule__Model__ThrirdAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3503:1: rule__Model__ThrirdAssignment_2_1 : ( ruleLoopedModel ) ;
    public final void rule__Model__ThrirdAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3507:1: ( ( ruleLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3508:1: ( ruleLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3508:1: ( ruleLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3509:1: ruleLoopedModel
            {
             before(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_18360);
            ruleLoopedModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ThrirdAssignment_2_1


    // $ANTLR start rule__Model__ForthAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3518:1: rule__Model__ForthAssignment_3_1 : ( ruleGroupLoopedModel ) ;
    public final void rule__Model__ForthAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3522:1: ( ( ruleGroupLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3523:1: ( ruleGroupLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3523:1: ( ruleGroupLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3524:1: ruleGroupLoopedModel
            {
             before(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_18391);
            ruleGroupLoopedModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ForthAssignment_3_1


    // $ANTLR start rule__Model__FifthAssignment_4_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3533:1: rule__Model__FifthAssignment_4_1 : ( ruleLoopedAlternativeModel ) ;
    public final void rule__Model__FifthAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3537:1: ( ( ruleLoopedAlternativeModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3538:1: ( ruleLoopedAlternativeModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3538:1: ( ruleLoopedAlternativeModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3539:1: ruleLoopedAlternativeModel
            {
             before(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_18422);
            ruleLoopedAlternativeModel();
            _fsp--;

             after(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__FifthAssignment_4_1


    // $ANTLR start rule__Model__ModelAssignment_5_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3548:1: rule__Model__ModelAssignment_5_1 : ( ruleBug304681Model ) ;
    public final void rule__Model__ModelAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3552:1: ( ( ruleBug304681Model ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3553:1: ( ruleBug304681Model )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3553:1: ( ruleBug304681Model )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3554:1: ruleBug304681Model
            {
             before(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_18453);
            ruleBug304681Model();
            _fsp--;

             after(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ModelAssignment_5_1


    // $ANTLR start rule__SimpleModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3563:1: rule__SimpleModel__VisibilityAssignment_0_0 : ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__SimpleModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3567:1: ( ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3568:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3568:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3569:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3570:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3570:2: rule__SimpleModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_08484);
            rule__SimpleModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__VisibilityAssignment_0_0


    // $ANTLR start rule__SimpleModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3579:1: rule__SimpleModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__SimpleModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3583:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3584:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3584:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3585:1: ( 'static' )
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3586:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3587:1: 'static'
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_18522); 
             after(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__StaticAssignment_0_1


    // $ANTLR start rule__SimpleModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3602:1: rule__SimpleModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__SimpleModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3606:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3607:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3607:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3608:1: ( 'synchronized' )
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3609:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3610:1: 'synchronized'
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_28566); 
             after(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__SimpleModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3625:1: rule__SimpleModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__SimpleModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3629:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3630:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3630:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3631:1: ( 'abstract' )
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3632:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3633:1: 'abstract'
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_08610); 
             after(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__SimpleModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3648:1: rule__SimpleModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__SimpleModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3652:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3653:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3653:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3654:1: ( 'final' )
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3655:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3656:1: 'final'
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_18654); 
             after(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__FinalAssignment_0_3_1


    // $ANTLR start rule__SimpleModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3671:1: rule__SimpleModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3675:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3676:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3676:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3677:1: RULE_ID
            {
             before(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_28693); 
             after(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleModel__NameAssignment_2


    // $ANTLR start rule__MandatoryModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3686:1: rule__MandatoryModel__VisibilityAssignment_0_0 : ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__MandatoryModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3690:1: ( ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3691:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3691:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3692:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3693:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3693:2: rule__MandatoryModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_08724);
            rule__MandatoryModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__VisibilityAssignment_0_0


    // $ANTLR start rule__MandatoryModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3702:1: rule__MandatoryModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__MandatoryModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3706:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3707:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3707:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3708:1: ( 'static' )
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3709:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3710:1: 'static'
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_18762); 
             after(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__StaticAssignment_0_1


    // $ANTLR start rule__MandatoryModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3725:1: rule__MandatoryModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__MandatoryModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3729:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3730:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3730:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3731:1: ( 'synchronized' )
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3732:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3733:1: 'synchronized'
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_28806); 
             after(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__MandatoryModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3748:1: rule__MandatoryModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__MandatoryModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3752:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3753:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3753:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3754:1: ( 'abstract' )
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3755:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3756:1: 'abstract'
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_08850); 
             after(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__MandatoryModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3771:1: rule__MandatoryModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__MandatoryModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3775:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3776:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3776:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3777:1: ( 'final' )
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3778:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3779:1: 'final'
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_18894); 
             after(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__FinalAssignment_0_3_1


    // $ANTLR start rule__MandatoryModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3794:1: rule__MandatoryModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__MandatoryModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3798:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3799:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3799:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3800:1: RULE_ID
            {
             before(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_28933); 
             after(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MandatoryModel__NameAssignment_2


    // $ANTLR start rule__LoopedModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3809:1: rule__LoopedModel__VisibilityAssignment_0_0 : ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__LoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3813:1: ( ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3814:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3814:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3815:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3816:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3816:2: rule__LoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_08964);
            rule__LoopedModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__VisibilityAssignment_0_0


    // $ANTLR start rule__LoopedModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3825:1: rule__LoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__LoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3829:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3830:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3830:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3831:1: ( 'static' )
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3832:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3833:1: 'static'
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_19002); 
             after(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__StaticAssignment_0_1


    // $ANTLR start rule__LoopedModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3848:1: rule__LoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__LoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3852:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3853:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3853:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3854:1: ( 'synchronized' )
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3855:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3856:1: 'synchronized'
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_29046); 
             after(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__LoopedModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3871:1: rule__LoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__LoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3875:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3876:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3876:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3877:1: ( 'abstract' )
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3878:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3879:1: 'abstract'
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_09090); 
             after(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__LoopedModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3894:1: rule__LoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__LoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3898:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3899:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3899:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3900:1: ( 'final' )
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3901:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3902:1: 'final'
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_19134); 
             after(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__FinalAssignment_0_3_1


    // $ANTLR start rule__LoopedModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3917:1: rule__LoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__LoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3921:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3922:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3922:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3923:1: RULE_ID
            {
             before(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_29173); 
             after(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedModel__NameAssignment_2


    // $ANTLR start rule__GroupLoopedModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3932:1: rule__GroupLoopedModel__VisibilityAssignment_0_0 : ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__GroupLoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3936:1: ( ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3937:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3937:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3938:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3939:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3939:2: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_09204);
            rule__GroupLoopedModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__VisibilityAssignment_0_0


    // $ANTLR start rule__GroupLoopedModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3948:1: rule__GroupLoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__GroupLoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3952:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3953:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3953:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3954:1: ( 'static' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3955:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3956:1: 'static'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_19242); 
             after(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__StaticAssignment_0_1


    // $ANTLR start rule__GroupLoopedModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3971:1: rule__GroupLoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__GroupLoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3975:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3976:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3976:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3977:1: ( 'synchronized' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3978:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3979:1: 'synchronized'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_29286); 
             after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__GroupLoopedModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3994:1: rule__GroupLoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__GroupLoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3998:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3999:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3999:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4000:1: ( 'abstract' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4001:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4002:1: 'abstract'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_09330); 
             after(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__GroupLoopedModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4017:1: rule__GroupLoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__GroupLoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4021:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4022:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4022:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4023:1: ( 'final' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4024:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4025:1: 'final'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_19374); 
             after(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__FinalAssignment_0_3_1


    // $ANTLR start rule__GroupLoopedModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4040:1: rule__GroupLoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__GroupLoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4044:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4045:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4045:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4046:1: RULE_ID
            {
             before(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_29413); 
             after(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GroupLoopedModel__NameAssignment_2


    // $ANTLR start rule__LoopedAlternativeModel__VisibilityAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4055:1: rule__LoopedAlternativeModel__VisibilityAssignment_0_0 : ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__LoopedAlternativeModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4059:1: ( ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4060:1: ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4060:1: ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4061:1: ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4062:1: ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4062:2: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_09444);
            rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAlternatives_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__VisibilityAssignment_0_0


    // $ANTLR start rule__LoopedAlternativeModel__StaticAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4071:1: rule__LoopedAlternativeModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__LoopedAlternativeModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4075:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4076:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4076:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4077:1: ( 'static' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4078:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4079:1: 'static'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_19482); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 

            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__StaticAssignment_0_1


    // $ANTLR start rule__LoopedAlternativeModel__SynchronizedAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4094:1: rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__LoopedAlternativeModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4098:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4099:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4099:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4100:1: ( 'synchronized' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4101:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4102:1: 'synchronized'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_29526); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__SynchronizedAssignment_0_2


    // $ANTLR start rule__LoopedAlternativeModel__AbstractAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4117:1: rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__LoopedAlternativeModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4121:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4122:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4122:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4123:1: ( 'abstract' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4124:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4125:1: 'abstract'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_09570); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__AbstractAssignment_0_3_0


    // $ANTLR start rule__LoopedAlternativeModel__FinalAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4140:1: rule__LoopedAlternativeModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__LoopedAlternativeModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4144:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4145:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4145:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4146:1: ( 'final' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4147:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4148:1: 'final'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_19614); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__FinalAssignment_0_3_1


    // $ANTLR start rule__LoopedAlternativeModel__NameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4163:1: rule__LoopedAlternativeModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__LoopedAlternativeModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4167:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4168:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4168:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4169:1: RULE_ID
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_29653); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LoopedAlternativeModel__NameAssignment_2


    // $ANTLR start rule__Bug304681Model__ShortDescriptionAssignment_1_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4178:1: rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__ShortDescriptionAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4182:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4183:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4183:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4184:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_1_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_1_0_19684); 
             after(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__ShortDescriptionAssignment_1_0_1


    // $ANTLR start rule__Bug304681Model__LongDescriptionAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4193:1: rule__Bug304681Model__LongDescriptionAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__LongDescriptionAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4197:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4198:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4198:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4199:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_1_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_1_1_19715); 
             after(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__LongDescriptionAssignment_1_1_1


    // $ANTLR start rule__Bug304681Model__UidAssignment_1_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4208:1: rule__Bug304681Model__UidAssignment_1_2_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__UidAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4212:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4213:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4213:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4214:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_1_2_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_1_2_19746); 
             after(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__UidAssignment_1_2_1


    // $ANTLR start rule__Bug304681Model__FlagAssignment_1_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4223:1: rule__Bug304681Model__FlagAssignment_1_3_0 : ( ( 'flag' ) ) ;
    public final void rule__Bug304681Model__FlagAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4227:1: ( ( ( 'flag' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4228:1: ( ( 'flag' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4228:1: ( ( 'flag' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4229:1: ( 'flag' )
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_1_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4230:1: ( 'flag' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4231:1: 'flag'
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_1_3_0_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_1_3_09782); 
             after(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_1_3_0_0()); 

            }

             after(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_1_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__FlagAssignment_1_3_0


    // $ANTLR start rule__Bug304681Model__FeaturesAssignment_1_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4246:1: rule__Bug304681Model__FeaturesAssignment_1_4 : ( ruleBug304681Feature ) ;
    public final void rule__Bug304681Model__FeaturesAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4250:1: ( ( ruleBug304681Feature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4251:1: ( ruleBug304681Feature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4251:1: ( ruleBug304681Feature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4252:1: ruleBug304681Feature
            {
             before(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_1_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_1_49821);
            ruleBug304681Feature();
            _fsp--;

             after(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__FeaturesAssignment_1_4


    // $ANTLR start rule__Bug304681Attribute__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4261:1: rule__Bug304681Attribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Bug304681Attribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4265:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4266:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4266:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4267:1: RULE_ID
            {
             before(grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_19852); 
             after(grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Attribute__NameAssignment_1


    // $ANTLR start rule__Bug304681Reference__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4276:1: rule__Bug304681Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Bug304681Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4280:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4281:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4281:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4282:1: RULE_ID
            {
             before(grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_19883); 
             after(grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Reference__NameAssignment_1


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleModel128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__0_in_ruleSimpleModel154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryModel188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__0_in_ruleMandatoryModel214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedModel248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__0_in_ruleLoopedModel274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupLoopedModel308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__0_in_ruleGroupLoopedModel334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedAlternativeModel368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__0_in_ruleLoopedAlternativeModel394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Model428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__0_in_ruleBug304681Model454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Feature488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Feature__Alternatives_in_ruleBug304681Feature514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Attribute548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__0_in_ruleBug304681Attribute574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Reference608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__0_in_ruleBug304681Reference634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_4__0_in_rule__Model__Alternatives742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_5__0_in_rule__Model__Alternatives760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__SimpleModel__VisibilityAlternatives_0_0_0794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__SimpleModel__VisibilityAlternatives_0_0_0814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SimpleModel__VisibilityAlternatives_0_0_0834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__AbstractAssignment_0_3_0_in_rule__SimpleModel__Alternatives_0_3868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__FinalAssignment_0_3_1_in_rule__SimpleModel__Alternatives_0_3886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__AbstractAssignment_0_3_0_in_rule__MandatoryModel__Alternatives_0_3994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__FinalAssignment_0_3_1_in_rule__MandatoryModel__Alternatives_0_31012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LoopedModel__VisibilityAlternatives_0_0_01046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LoopedModel__VisibilityAlternatives_0_0_01066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LoopedModel__VisibilityAlternatives_0_0_01086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__AbstractAssignment_0_3_0_in_rule__LoopedModel__Alternatives_0_31120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__FinalAssignment_0_3_1_in_rule__LoopedModel__Alternatives_0_31138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__AbstractAssignment_0_3_0_in_rule__GroupLoopedModel__Alternatives_0_31246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__FinalAssignment_0_3_1_in_rule__GroupLoopedModel__Alternatives_0_31264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__VisibilityAssignment_0_0_in_rule__LoopedAlternativeModel__Alternatives_01297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__StaticAssignment_0_1_in_rule__LoopedAlternativeModel__Alternatives_01315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__SynchronizedAssignment_0_2_in_rule__LoopedAlternativeModel__Alternatives_01333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_3_in_rule__LoopedAlternativeModel__Alternatives_01351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0_in_rule__LoopedAlternativeModel__Alternatives_01369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__AbstractAssignment_0_3_0_in_rule__LoopedAlternativeModel__Alternatives_0_31477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__FinalAssignment_0_3_1_in_rule__LoopedAlternativeModel__Alternatives_0_31495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_rule__Bug304681Feature__Alternatives1528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_rule__Bug304681Feature__Alternatives1545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__01575 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group_0__0__Impl1606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__11637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__1__Impl1664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__01698 = new BitSet(new long[]{0x0000000780003800L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_1__0__Impl1729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__1__Impl1787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__01821 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__Group_2__0__Impl1852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__11883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__1__Impl1910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__0__Impl_in_rule__Model__Group_3__01944 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__Group_3__0__Impl1975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__1__Impl_in_rule__Model__Group_3__12006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__1__Impl2033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_4__0__Impl_in_rule__Model__Group_4__02067 = new BitSet(new long[]{0x0000000780903800L});
        public static final BitSet FOLLOW_rule__Model__Group_4__1_in_rule__Model__Group_4__02070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Model__Group_4__0__Impl2098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_4__1__Impl_in_rule__Model__Group_4__12129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FifthAssignment_4_1_in_rule__Model__Group_4__1__Impl2156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_5__0__Impl_in_rule__Model__Group_5__02190 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Model__Group_5__1_in_rule__Model__Group_5__02193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Model__Group_5__0__Impl2221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_5__1__Impl_in_rule__Model__Group_5__12252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ModelAssignment_5_1_in_rule__Model__Group_5__1__Impl2279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__0__Impl_in_rule__SimpleModel__Group__02313 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__02316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__0__Impl2343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__1__Impl_in_rule__SimpleModel__Group__12373 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__12376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SimpleModel__Group__1__Impl2404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__2__Impl_in_rule__SimpleModel__Group__22435 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__22438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__2__Impl2465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__3__Impl_in_rule__SimpleModel__Group__32495 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__32498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SimpleModel__Group__3__Impl2526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__4__Impl_in_rule__SimpleModel__Group__42557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SimpleModel__Group__4__Impl2585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__0__Impl_in_rule__MandatoryModel__Group__02626 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__02629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__0__Impl2656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__1__Impl_in_rule__MandatoryModel__Group__12686 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__12689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__MandatoryModel__Group__1__Impl2717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__2__Impl_in_rule__MandatoryModel__Group__22748 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__22751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__2__Impl2778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__3__Impl_in_rule__MandatoryModel__Group__32808 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__32811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MandatoryModel__Group__3__Impl2839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__4__Impl_in_rule__MandatoryModel__Group__42870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__MandatoryModel__Group__4__Impl2898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__0__Impl_in_rule__LoopedModel__Group__02939 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__02942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__0__Impl2969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__1__Impl_in_rule__LoopedModel__Group__12999 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__13002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LoopedModel__Group__1__Impl3030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__2__Impl_in_rule__LoopedModel__Group__23061 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__23064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__2__Impl3091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__3__Impl_in_rule__LoopedModel__Group__33121 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__33124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LoopedModel__Group__3__Impl3152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__4__Impl_in_rule__LoopedModel__Group__43183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LoopedModel__Group__4__Impl3211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__0__Impl_in_rule__GroupLoopedModel__Group__03252 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__03255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__0__Impl3282 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__1__Impl_in_rule__GroupLoopedModel__Group__13313 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__13316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__GroupLoopedModel__Group__1__Impl3344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__2__Impl_in_rule__GroupLoopedModel__Group__23375 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__23378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__2__Impl3405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__3__Impl_in_rule__GroupLoopedModel__Group__33435 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__33438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__GroupLoopedModel__Group__3__Impl3466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__4__Impl_in_rule__GroupLoopedModel__Group__43497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__GroupLoopedModel__Group__4__Impl3525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__0__Impl_in_rule__LoopedAlternativeModel__Group__03566 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__1_in_rule__LoopedAlternativeModel__Group__03569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_in_rule__LoopedAlternativeModel__Group__0__Impl3596 = new BitSet(new long[]{0x0000000780803802L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__1__Impl_in_rule__LoopedAlternativeModel__Group__13627 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__2_in_rule__LoopedAlternativeModel__Group__13630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LoopedAlternativeModel__Group__1__Impl3658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__2__Impl_in_rule__LoopedAlternativeModel__Group__23689 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__3_in_rule__LoopedAlternativeModel__Group__23692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__NameAssignment_2_in_rule__LoopedAlternativeModel__Group__2__Impl3719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__3__Impl_in_rule__LoopedAlternativeModel__Group__33749 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__4_in_rule__LoopedAlternativeModel__Group__33752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LoopedAlternativeModel__Group__3__Impl3780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__4__Impl_in_rule__LoopedAlternativeModel__Group__43811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LoopedAlternativeModel__Group__4__Impl3839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0__Impl_in_rule__LoopedAlternativeModel__Group_0_4__03880 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1_in_rule__LoopedAlternativeModel__Group_0_4__03883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LoopedAlternativeModel__Group_0_4__0__Impl3911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1__Impl_in_rule__LoopedAlternativeModel__Group_0_4__13942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LoopedAlternativeModel__Group_0_4__1__Impl3971 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__0__Impl_in_rule__Bug304681Model__Group__04008 = new BitSet(new long[]{0x000000087A400000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__1_in_rule__Bug304681Model__Group__04011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Bug304681Model__Group__0__Impl4039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__1__Impl_in_rule__Bug304681Model__Group__14070 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__14073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1_in_rule__Bug304681Model__Group__1__Impl4100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__2__Impl_in_rule__Bug304681Model__Group__24130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Bug304681Model__Group__2__Impl4158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__0__Impl_in_rule__Bug304681Model__Group_1_0__04195 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__1_in_rule__Bug304681Model__Group_1_0__04198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Bug304681Model__Group_1_0__0__Impl4226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__1__Impl_in_rule__Bug304681Model__Group_1_0__14257 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__2_in_rule__Bug304681Model__Group_1_0__14260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_1_0_1_in_rule__Bug304681Model__Group_1_0__1__Impl4287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__2__Impl_in_rule__Bug304681Model__Group_1_0__24317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_0__2__Impl4345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__0__Impl_in_rule__Bug304681Model__Group_1_1__04382 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__1_in_rule__Bug304681Model__Group_1_1__04385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Bug304681Model__Group_1_1__0__Impl4413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__1__Impl_in_rule__Bug304681Model__Group_1_1__14444 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__2_in_rule__Bug304681Model__Group_1_1__14447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_1_1_1_in_rule__Bug304681Model__Group_1_1__1__Impl4474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__2__Impl_in_rule__Bug304681Model__Group_1_1__24504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_1__2__Impl4532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__0__Impl_in_rule__Bug304681Model__Group_1_2__04569 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__1_in_rule__Bug304681Model__Group_1_2__04572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Bug304681Model__Group_1_2__0__Impl4600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__1__Impl_in_rule__Bug304681Model__Group_1_2__14631 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__2_in_rule__Bug304681Model__Group_1_2__14634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UidAssignment_1_2_1_in_rule__Bug304681Model__Group_1_2__1__Impl4661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__2__Impl_in_rule__Bug304681Model__Group_1_2__24691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_2__2__Impl4719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_3__0__Impl_in_rule__Bug304681Model__Group_1_3__04756 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_3__1_in_rule__Bug304681Model__Group_1_3__04759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FlagAssignment_1_3_0_in_rule__Bug304681Model__Group_1_3__0__Impl4786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_3__1__Impl_in_rule__Bug304681Model__Group_1_3__14816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_3__1__Impl4844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__0__Impl_in_rule__Bug304681Attribute__Group__04879 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__04882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__Bug304681Attribute__Group__0__Impl4910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__1__Impl_in_rule__Bug304681Attribute__Group__14941 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__14944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__1__Impl4971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__2__Impl_in_rule__Bug304681Attribute__Group__25001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Attribute__Group__2__Impl5029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__0__Impl_in_rule__Bug304681Reference__Group__05066 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__05069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Bug304681Reference__Group__0__Impl5097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__1__Impl_in_rule__Bug304681Reference__Group__15128 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__15131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__1__Impl5158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__2__Impl_in_rule__Bug304681Reference__Group__25188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Reference__Group__2__Impl5216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_rule__SimpleModel__UnorderedGroup_05254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_0__Impl5341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_0__Impl5432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_0__Impl5523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_0__Impl5614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__05673 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_rule__SimpleModel__UnorderedGroup_0__05676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__15701 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_rule__SimpleModel__UnorderedGroup_0__15704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__25729 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_rule__SimpleModel__UnorderedGroup_0__25732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__35757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__0_in_rule__MandatoryModel__UnorderedGroup_05789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_0__Impl5878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_0__Impl5969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_0__Impl6060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_0__Impl6151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__06210 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_rule__MandatoryModel__UnorderedGroup_0__06213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__16238 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_rule__MandatoryModel__UnorderedGroup_0__16241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__26266 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_rule__MandatoryModel__UnorderedGroup_0__26269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__36294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_rule__LoopedModel__UnorderedGroup_06326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6414 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6454 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6553 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6593 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6692 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6732 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6831 = new BitSet(new long[]{0x0000000600000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6871 = new BitSet(new long[]{0x0000000600000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__06937 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_rule__LoopedModel__UnorderedGroup_0__06940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__16965 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_rule__LoopedModel__UnorderedGroup_0__16968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__26993 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_rule__LoopedModel__UnorderedGroup_0__26996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__37021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__0_in_rule__GroupLoopedModel__UnorderedGroup_07053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__07474 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_rule__GroupLoopedModel__UnorderedGroup_0__07477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__17502 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_rule__GroupLoopedModel__UnorderedGroup_0__17505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__27530 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_rule__GroupLoopedModel__UnorderedGroup_0__27533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__37558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__0_in_rule__Bug304681Model__UnorderedGroup_17590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_3__0_in_rule__Bug304681Model__UnorderedGroup_1__Impl7950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_1_4_in_rule__Bug304681Model__UnorderedGroup_1__Impl8042 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_1_4_in_rule__Bug304681Model__UnorderedGroup_1__Impl8082 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__08148 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__1_in_rule__Bug304681Model__UnorderedGroup_1__08151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__18176 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__2_in_rule__Bug304681Model__UnorderedGroup_1__18179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__28204 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__3_in_rule__Bug304681Model__UnorderedGroup_1__28207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__38232 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__4_in_rule__Bug304681Model__UnorderedGroup_1__38235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1__Impl_in_rule__Bug304681Model__UnorderedGroup_1__48260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_18298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_18329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_18360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_18391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_18422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_18453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_08484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_18522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_28566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_08610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_18654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_28693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_08724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_18762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_28806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_08850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_18894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_28933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_08964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_19002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_29046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_09090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_19134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_29173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_09204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_19242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_29286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_09330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_19374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_29413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_09444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_19482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_29526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_09570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_19614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_29653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_1_0_19684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_1_1_19715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_1_2_19746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_1_3_09782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_1_49821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_19852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_19883 = new BitSet(new long[]{0x0000000000000002L});
    }


}