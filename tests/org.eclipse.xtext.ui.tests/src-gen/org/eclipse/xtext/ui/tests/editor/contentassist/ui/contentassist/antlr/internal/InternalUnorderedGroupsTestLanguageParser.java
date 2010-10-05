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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1986:1: rule__Bug304681Model__Group__0__Impl : ( () ) ;
    public final void rule__Bug304681Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1990:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1991:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1991:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1992:1: ()
            {
             before(grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1993:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1995:1: 
            {
            }

             after(grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0()); 

            }


            }

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
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__1__Impl_in_rule__Bug304681Model__Group__14069);
            rule__Bug304681Model__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__14072);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2017:1: rule__Bug304681Model__Group__1__Impl : ( '{' ) ;
    public final void rule__Bug304681Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2021:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2022:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2022:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2023:1: '{'
            {
             before(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Bug304681Model__Group__1__Impl4100); 
             after(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2036:1: rule__Bug304681Model__Group__2 : rule__Bug304681Model__Group__2__Impl rule__Bug304681Model__Group__3 ;
    public final void rule__Bug304681Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2040:1: ( rule__Bug304681Model__Group__2__Impl rule__Bug304681Model__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2041:2: rule__Bug304681Model__Group__2__Impl rule__Bug304681Model__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__2__Impl_in_rule__Bug304681Model__Group__24131);
            rule__Bug304681Model__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__3_in_rule__Bug304681Model__Group__24134);
            rule__Bug304681Model__Group__3();
            _fsp--;


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2048:1: rule__Bug304681Model__Group__2__Impl : ( ( rule__Bug304681Model__UnorderedGroup_2 ) ) ;
    public final void rule__Bug304681Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2052:1: ( ( ( rule__Bug304681Model__UnorderedGroup_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2053:1: ( ( rule__Bug304681Model__UnorderedGroup_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2053:1: ( ( rule__Bug304681Model__UnorderedGroup_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2054:1: ( rule__Bug304681Model__UnorderedGroup_2 )
            {
             before(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2055:1: ( rule__Bug304681Model__UnorderedGroup_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2055:2: rule__Bug304681Model__UnorderedGroup_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2_in_rule__Bug304681Model__Group__2__Impl4161);
            rule__Bug304681Model__UnorderedGroup_2();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2()); 

            }


            }

        }
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


    // $ANTLR start rule__Bug304681Model__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2065:1: rule__Bug304681Model__Group__3 : rule__Bug304681Model__Group__3__Impl ;
    public final void rule__Bug304681Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2069:1: ( rule__Bug304681Model__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2070:2: rule__Bug304681Model__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__3__Impl_in_rule__Bug304681Model__Group__34191);
            rule__Bug304681Model__Group__3__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group__3


    // $ANTLR start rule__Bug304681Model__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2076:1: rule__Bug304681Model__Group__3__Impl : ( '}' ) ;
    public final void rule__Bug304681Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2080:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2081:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2081:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2082:1: '}'
            {
             before(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_3()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Bug304681Model__Group__3__Impl4219); 
             after(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group__3__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2103:1: rule__Bug304681Model__Group_2_0__0 : rule__Bug304681Model__Group_2_0__0__Impl rule__Bug304681Model__Group_2_0__1 ;
    public final void rule__Bug304681Model__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2107:1: ( rule__Bug304681Model__Group_2_0__0__Impl rule__Bug304681Model__Group_2_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2108:2: rule__Bug304681Model__Group_2_0__0__Impl rule__Bug304681Model__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__0__Impl_in_rule__Bug304681Model__Group_2_0__04258);
            rule__Bug304681Model__Group_2_0__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__1_in_rule__Bug304681Model__Group_2_0__04261);
            rule__Bug304681Model__Group_2_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_0__0


    // $ANTLR start rule__Bug304681Model__Group_2_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2115:1: rule__Bug304681Model__Group_2_0__0__Impl : ( 'short' ) ;
    public final void rule__Bug304681Model__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2119:1: ( ( 'short' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2120:1: ( 'short' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2120:1: ( 'short' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2121:1: 'short'
            {
             before(grammarAccess.getBug304681ModelAccess().getShortKeyword_2_0_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Bug304681Model__Group_2_0__0__Impl4289); 
             after(grammarAccess.getBug304681ModelAccess().getShortKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_0__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2134:1: rule__Bug304681Model__Group_2_0__1 : rule__Bug304681Model__Group_2_0__1__Impl rule__Bug304681Model__Group_2_0__2 ;
    public final void rule__Bug304681Model__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2138:1: ( rule__Bug304681Model__Group_2_0__1__Impl rule__Bug304681Model__Group_2_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2139:2: rule__Bug304681Model__Group_2_0__1__Impl rule__Bug304681Model__Group_2_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__1__Impl_in_rule__Bug304681Model__Group_2_0__14320);
            rule__Bug304681Model__Group_2_0__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__2_in_rule__Bug304681Model__Group_2_0__14323);
            rule__Bug304681Model__Group_2_0__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_0__1


    // $ANTLR start rule__Bug304681Model__Group_2_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2146:1: rule__Bug304681Model__Group_2_0__1__Impl : ( ( rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 ) ) ;
    public final void rule__Bug304681Model__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2150:1: ( ( ( rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2151:1: ( ( rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2151:1: ( ( rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2152:1: ( rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_2_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2153:1: ( rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2153:2: rule__Bug304681Model__ShortDescriptionAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_2_0_1_in_rule__Bug304681Model__Group_2_0__1__Impl4350);
            rule__Bug304681Model__ShortDescriptionAssignment_2_0_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_0__1__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2163:1: rule__Bug304681Model__Group_2_0__2 : rule__Bug304681Model__Group_2_0__2__Impl ;
    public final void rule__Bug304681Model__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2167:1: ( rule__Bug304681Model__Group_2_0__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2168:2: rule__Bug304681Model__Group_2_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__2__Impl_in_rule__Bug304681Model__Group_2_0__24380);
            rule__Bug304681Model__Group_2_0__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_0__2


    // $ANTLR start rule__Bug304681Model__Group_2_0__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2174:1: rule__Bug304681Model__Group_2_0__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2178:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2179:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2179:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2180:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_0_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_0__2__Impl4408); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_0__2__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2199:1: rule__Bug304681Model__Group_2_1__0 : rule__Bug304681Model__Group_2_1__0__Impl rule__Bug304681Model__Group_2_1__1 ;
    public final void rule__Bug304681Model__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2203:1: ( rule__Bug304681Model__Group_2_1__0__Impl rule__Bug304681Model__Group_2_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2204:2: rule__Bug304681Model__Group_2_1__0__Impl rule__Bug304681Model__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__0__Impl_in_rule__Bug304681Model__Group_2_1__04445);
            rule__Bug304681Model__Group_2_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__1_in_rule__Bug304681Model__Group_2_1__04448);
            rule__Bug304681Model__Group_2_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_1__0


    // $ANTLR start rule__Bug304681Model__Group_2_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2211:1: rule__Bug304681Model__Group_2_1__0__Impl : ( 'long' ) ;
    public final void rule__Bug304681Model__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2215:1: ( ( 'long' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2216:1: ( 'long' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2216:1: ( 'long' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2217:1: 'long'
            {
             before(grammarAccess.getBug304681ModelAccess().getLongKeyword_2_1_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Bug304681Model__Group_2_1__0__Impl4476); 
             after(grammarAccess.getBug304681ModelAccess().getLongKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_1__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2230:1: rule__Bug304681Model__Group_2_1__1 : rule__Bug304681Model__Group_2_1__1__Impl rule__Bug304681Model__Group_2_1__2 ;
    public final void rule__Bug304681Model__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2234:1: ( rule__Bug304681Model__Group_2_1__1__Impl rule__Bug304681Model__Group_2_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2235:2: rule__Bug304681Model__Group_2_1__1__Impl rule__Bug304681Model__Group_2_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__1__Impl_in_rule__Bug304681Model__Group_2_1__14507);
            rule__Bug304681Model__Group_2_1__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__2_in_rule__Bug304681Model__Group_2_1__14510);
            rule__Bug304681Model__Group_2_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_1__1


    // $ANTLR start rule__Bug304681Model__Group_2_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2242:1: rule__Bug304681Model__Group_2_1__1__Impl : ( ( rule__Bug304681Model__LongDescriptionAssignment_2_1_1 ) ) ;
    public final void rule__Bug304681Model__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2246:1: ( ( ( rule__Bug304681Model__LongDescriptionAssignment_2_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2247:1: ( ( rule__Bug304681Model__LongDescriptionAssignment_2_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2247:1: ( ( rule__Bug304681Model__LongDescriptionAssignment_2_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2248:1: ( rule__Bug304681Model__LongDescriptionAssignment_2_1_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_2_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2249:1: ( rule__Bug304681Model__LongDescriptionAssignment_2_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2249:2: rule__Bug304681Model__LongDescriptionAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_2_1_1_in_rule__Bug304681Model__Group_2_1__1__Impl4537);
            rule__Bug304681Model__LongDescriptionAssignment_2_1_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_1__1__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2259:1: rule__Bug304681Model__Group_2_1__2 : rule__Bug304681Model__Group_2_1__2__Impl ;
    public final void rule__Bug304681Model__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2263:1: ( rule__Bug304681Model__Group_2_1__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2264:2: rule__Bug304681Model__Group_2_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__2__Impl_in_rule__Bug304681Model__Group_2_1__24567);
            rule__Bug304681Model__Group_2_1__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_1__2


    // $ANTLR start rule__Bug304681Model__Group_2_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2270:1: rule__Bug304681Model__Group_2_1__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2274:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2275:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2275:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2276:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_1_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_1__2__Impl4595); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_1__2__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2295:1: rule__Bug304681Model__Group_2_2__0 : rule__Bug304681Model__Group_2_2__0__Impl rule__Bug304681Model__Group_2_2__1 ;
    public final void rule__Bug304681Model__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2299:1: ( rule__Bug304681Model__Group_2_2__0__Impl rule__Bug304681Model__Group_2_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2300:2: rule__Bug304681Model__Group_2_2__0__Impl rule__Bug304681Model__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__0__Impl_in_rule__Bug304681Model__Group_2_2__04632);
            rule__Bug304681Model__Group_2_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__1_in_rule__Bug304681Model__Group_2_2__04635);
            rule__Bug304681Model__Group_2_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_2__0


    // $ANTLR start rule__Bug304681Model__Group_2_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2307:1: rule__Bug304681Model__Group_2_2__0__Impl : ( 'uid' ) ;
    public final void rule__Bug304681Model__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2311:1: ( ( 'uid' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2312:1: ( 'uid' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2312:1: ( 'uid' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2313:1: 'uid'
            {
             before(grammarAccess.getBug304681ModelAccess().getUidKeyword_2_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Bug304681Model__Group_2_2__0__Impl4663); 
             after(grammarAccess.getBug304681ModelAccess().getUidKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_2__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2326:1: rule__Bug304681Model__Group_2_2__1 : rule__Bug304681Model__Group_2_2__1__Impl rule__Bug304681Model__Group_2_2__2 ;
    public final void rule__Bug304681Model__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2330:1: ( rule__Bug304681Model__Group_2_2__1__Impl rule__Bug304681Model__Group_2_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2331:2: rule__Bug304681Model__Group_2_2__1__Impl rule__Bug304681Model__Group_2_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__1__Impl_in_rule__Bug304681Model__Group_2_2__14694);
            rule__Bug304681Model__Group_2_2__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__2_in_rule__Bug304681Model__Group_2_2__14697);
            rule__Bug304681Model__Group_2_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_2__1


    // $ANTLR start rule__Bug304681Model__Group_2_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2338:1: rule__Bug304681Model__Group_2_2__1__Impl : ( ( rule__Bug304681Model__UidAssignment_2_2_1 ) ) ;
    public final void rule__Bug304681Model__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2342:1: ( ( ( rule__Bug304681Model__UidAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2343:1: ( ( rule__Bug304681Model__UidAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2343:1: ( ( rule__Bug304681Model__UidAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2344:1: ( rule__Bug304681Model__UidAssignment_2_2_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getUidAssignment_2_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2345:1: ( rule__Bug304681Model__UidAssignment_2_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2345:2: rule__Bug304681Model__UidAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UidAssignment_2_2_1_in_rule__Bug304681Model__Group_2_2__1__Impl4724);
            rule__Bug304681Model__UidAssignment_2_2_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getUidAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_2__1__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2355:1: rule__Bug304681Model__Group_2_2__2 : rule__Bug304681Model__Group_2_2__2__Impl ;
    public final void rule__Bug304681Model__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2359:1: ( rule__Bug304681Model__Group_2_2__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2360:2: rule__Bug304681Model__Group_2_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__2__Impl_in_rule__Bug304681Model__Group_2_2__24754);
            rule__Bug304681Model__Group_2_2__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_2__2


    // $ANTLR start rule__Bug304681Model__Group_2_2__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2366:1: rule__Bug304681Model__Group_2_2__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2370:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2371:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2371:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2372:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_2_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_2__2__Impl4782); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_2__2__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2391:1: rule__Bug304681Model__Group_2_3__0 : rule__Bug304681Model__Group_2_3__0__Impl rule__Bug304681Model__Group_2_3__1 ;
    public final void rule__Bug304681Model__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2395:1: ( rule__Bug304681Model__Group_2_3__0__Impl rule__Bug304681Model__Group_2_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2396:2: rule__Bug304681Model__Group_2_3__0__Impl rule__Bug304681Model__Group_2_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__0__Impl_in_rule__Bug304681Model__Group_2_3__04819);
            rule__Bug304681Model__Group_2_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__1_in_rule__Bug304681Model__Group_2_3__04822);
            rule__Bug304681Model__Group_2_3__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_3__0


    // $ANTLR start rule__Bug304681Model__Group_2_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2403:1: rule__Bug304681Model__Group_2_3__0__Impl : ( ( rule__Bug304681Model__FlagAssignment_2_3_0 ) ) ;
    public final void rule__Bug304681Model__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2407:1: ( ( ( rule__Bug304681Model__FlagAssignment_2_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2408:1: ( ( rule__Bug304681Model__FlagAssignment_2_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2408:1: ( ( rule__Bug304681Model__FlagAssignment_2_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2409:1: ( rule__Bug304681Model__FlagAssignment_2_3_0 )
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagAssignment_2_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2410:1: ( rule__Bug304681Model__FlagAssignment_2_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2410:2: rule__Bug304681Model__FlagAssignment_2_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FlagAssignment_2_3_0_in_rule__Bug304681Model__Group_2_3__0__Impl4849);
            rule__Bug304681Model__FlagAssignment_2_3_0();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getFlagAssignment_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_3__0__Impl


    // $ANTLR start rule__Bug304681Model__Group_2_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2420:1: rule__Bug304681Model__Group_2_3__1 : rule__Bug304681Model__Group_2_3__1__Impl ;
    public final void rule__Bug304681Model__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2424:1: ( rule__Bug304681Model__Group_2_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2425:2: rule__Bug304681Model__Group_2_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__1__Impl_in_rule__Bug304681Model__Group_2_3__14879);
            rule__Bug304681Model__Group_2_3__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_3__1


    // $ANTLR start rule__Bug304681Model__Group_2_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2431:1: rule__Bug304681Model__Group_2_3__1__Impl : ( ';' ) ;
    public final void rule__Bug304681Model__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2435:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2436:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2436:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2437:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_3_1()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_3__1__Impl4907); 
             after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__Group_2_3__1__Impl


    // $ANTLR start rule__Bug304681Attribute__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2454:1: rule__Bug304681Attribute__Group__0 : rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1 ;
    public final void rule__Bug304681Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2458:1: ( rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2459:2: rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__0__Impl_in_rule__Bug304681Attribute__Group__04942);
            rule__Bug304681Attribute__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__04945);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2466:1: rule__Bug304681Attribute__Group__0__Impl : ( 'attr' ) ;
    public final void rule__Bug304681Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2470:1: ( ( 'attr' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2471:1: ( 'attr' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2471:1: ( 'attr' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2472:1: 'attr'
            {
             before(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__Bug304681Attribute__Group__0__Impl4973); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2485:1: rule__Bug304681Attribute__Group__1 : rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2 ;
    public final void rule__Bug304681Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2489:1: ( rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2490:2: rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__1__Impl_in_rule__Bug304681Attribute__Group__15004);
            rule__Bug304681Attribute__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__15007);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2497:1: rule__Bug304681Attribute__Group__1__Impl : ( ( rule__Bug304681Attribute__NameAssignment_1 ) ) ;
    public final void rule__Bug304681Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2501:1: ( ( ( rule__Bug304681Attribute__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2502:1: ( ( rule__Bug304681Attribute__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2502:1: ( ( rule__Bug304681Attribute__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2503:1: ( rule__Bug304681Attribute__NameAssignment_1 )
            {
             before(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2504:1: ( rule__Bug304681Attribute__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2504:2: rule__Bug304681Attribute__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__1__Impl5034);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2514:1: rule__Bug304681Attribute__Group__2 : rule__Bug304681Attribute__Group__2__Impl ;
    public final void rule__Bug304681Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2518:1: ( rule__Bug304681Attribute__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2519:2: rule__Bug304681Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__2__Impl_in_rule__Bug304681Attribute__Group__25064);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2525:1: rule__Bug304681Attribute__Group__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2529:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2530:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2530:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2531:1: ';'
            {
             before(grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Attribute__Group__2__Impl5092); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2550:1: rule__Bug304681Reference__Group__0 : rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1 ;
    public final void rule__Bug304681Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2554:1: ( rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2555:2: rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__0__Impl_in_rule__Bug304681Reference__Group__05129);
            rule__Bug304681Reference__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__05132);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2562:1: rule__Bug304681Reference__Group__0__Impl : ( 'ref' ) ;
    public final void rule__Bug304681Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2566:1: ( ( 'ref' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2567:1: ( 'ref' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2567:1: ( 'ref' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2568:1: 'ref'
            {
             before(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Bug304681Reference__Group__0__Impl5160); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2581:1: rule__Bug304681Reference__Group__1 : rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2 ;
    public final void rule__Bug304681Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2585:1: ( rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2586:2: rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__1__Impl_in_rule__Bug304681Reference__Group__15191);
            rule__Bug304681Reference__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__15194);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2593:1: rule__Bug304681Reference__Group__1__Impl : ( ( rule__Bug304681Reference__NameAssignment_1 ) ) ;
    public final void rule__Bug304681Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2597:1: ( ( ( rule__Bug304681Reference__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2598:1: ( ( rule__Bug304681Reference__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2598:1: ( ( rule__Bug304681Reference__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2599:1: ( rule__Bug304681Reference__NameAssignment_1 )
            {
             before(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2600:1: ( rule__Bug304681Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2600:2: rule__Bug304681Reference__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__1__Impl5221);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2610:1: rule__Bug304681Reference__Group__2 : rule__Bug304681Reference__Group__2__Impl ;
    public final void rule__Bug304681Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2614:1: ( rule__Bug304681Reference__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2615:2: rule__Bug304681Reference__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__2__Impl_in_rule__Bug304681Reference__Group__25251);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2621:1: rule__Bug304681Reference__Group__2__Impl : ( ';' ) ;
    public final void rule__Bug304681Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2625:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2626:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2626:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2627:1: ';'
            {
             before(grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Reference__Group__2__Impl5279); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2647:1: rule__SimpleModel__UnorderedGroup_0 : ( rule__SimpleModel__UnorderedGroup_0__0 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2652:1: ( ( rule__SimpleModel__UnorderedGroup_0__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2653:2: ( rule__SimpleModel__UnorderedGroup_0__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2653:2: ( rule__SimpleModel__UnorderedGroup_0__0 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2653:2: rule__SimpleModel__UnorderedGroup_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_rule__SimpleModel__UnorderedGroup_05317);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2663:1: rule__SimpleModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) ) ;
    public final void rule__SimpleModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2668:1: ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2669:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2669:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )
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
                    new NoViableAltException("2669:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2671:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2671:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2672:5: {...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2672:108: ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2673:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2679:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2681:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:8: rule__SimpleModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_0__Impl5404);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2688:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2688:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2689:5: {...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2689:108: ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2690:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2696:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2698:7: ( rule__SimpleModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2699:7: ( rule__SimpleModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2699:8: rule__SimpleModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_0__Impl5495);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2705:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2705:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2706:5: {...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2706:108: ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2707:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2713:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2715:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2716:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2716:8: rule__SimpleModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_0__Impl5586);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2722:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2722:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2723:5: {...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2723:108: ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2724:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2730:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2732:7: ( rule__SimpleModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2733:7: ( rule__SimpleModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2733:8: rule__SimpleModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_0__Impl5677);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2748:1: rule__SimpleModel__UnorderedGroup_0__0 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2752:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2753:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__05736);
            rule__SimpleModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2754:2: ( rule__SimpleModel__UnorderedGroup_0__1 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2754:2: rule__SimpleModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_rule__SimpleModel__UnorderedGroup_0__05739);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2761:1: rule__SimpleModel__UnorderedGroup_0__1 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2765:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2766:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__15764);
            rule__SimpleModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2767:2: ( rule__SimpleModel__UnorderedGroup_0__2 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2767:2: rule__SimpleModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_rule__SimpleModel__UnorderedGroup_0__15767);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2774:1: rule__SimpleModel__UnorderedGroup_0__2 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2778:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2779:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__25792);
            rule__SimpleModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2780:2: ( rule__SimpleModel__UnorderedGroup_0__3 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2780:2: rule__SimpleModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_rule__SimpleModel__UnorderedGroup_0__25795);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2787:1: rule__SimpleModel__UnorderedGroup_0__3 : rule__SimpleModel__UnorderedGroup_0__Impl ;
    public final void rule__SimpleModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2791:1: ( rule__SimpleModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2792:2: rule__SimpleModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__35820);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2807:1: rule__MandatoryModel__UnorderedGroup_0 : rule__MandatoryModel__UnorderedGroup_0__0 {...}?;
    public final void rule__MandatoryModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2812:1: ( rule__MandatoryModel__UnorderedGroup_0__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2813:2: rule__MandatoryModel__UnorderedGroup_0__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__0_in_rule__MandatoryModel__UnorderedGroup_05852);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2824:1: rule__MandatoryModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) ) ;
    public final void rule__MandatoryModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2829:1: ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2830:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2830:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )
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
                    new NoViableAltException("2830:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2832:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2832:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2833:5: {...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2833:111: ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2834:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2840:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2842:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2843:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2843:8: rule__MandatoryModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_0__Impl5941);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2849:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2849:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2850:5: {...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2850:111: ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2851:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2857:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2859:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2860:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2860:8: rule__MandatoryModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_0__Impl6032);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2866:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2866:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2867:5: {...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2867:111: ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2868:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2874:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2876:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2877:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2877:8: rule__MandatoryModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_0__Impl6123);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2883:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2883:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2884:5: {...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2884:111: ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2885:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2891:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2893:7: ( rule__MandatoryModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2894:7: ( rule__MandatoryModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2894:8: rule__MandatoryModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_0__Impl6214);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2909:1: rule__MandatoryModel__UnorderedGroup_0__0 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2913:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2914:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__06273);
            rule__MandatoryModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2915:2: ( rule__MandatoryModel__UnorderedGroup_0__1 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2915:2: rule__MandatoryModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_rule__MandatoryModel__UnorderedGroup_0__06276);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2922:1: rule__MandatoryModel__UnorderedGroup_0__1 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2926:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2927:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__16301);
            rule__MandatoryModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2928:2: ( rule__MandatoryModel__UnorderedGroup_0__2 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2928:2: rule__MandatoryModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_rule__MandatoryModel__UnorderedGroup_0__16304);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2935:1: rule__MandatoryModel__UnorderedGroup_0__2 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2939:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2940:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__26329);
            rule__MandatoryModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: ( rule__MandatoryModel__UnorderedGroup_0__3 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: rule__MandatoryModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_rule__MandatoryModel__UnorderedGroup_0__26332);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2948:1: rule__MandatoryModel__UnorderedGroup_0__3 : rule__MandatoryModel__UnorderedGroup_0__Impl ;
    public final void rule__MandatoryModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2952:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2953:2: rule__MandatoryModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__36357);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2968:1: rule__LoopedModel__UnorderedGroup_0 : ( rule__LoopedModel__UnorderedGroup_0__0 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2973:1: ( ( rule__LoopedModel__UnorderedGroup_0__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:2: ( rule__LoopedModel__UnorderedGroup_0__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:2: ( rule__LoopedModel__UnorderedGroup_0__0 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:2: rule__LoopedModel__UnorderedGroup_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_rule__LoopedModel__UnorderedGroup_06389);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2984:1: rule__LoopedModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) ) ;
    public final void rule__LoopedModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2989:1: ( ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2990:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2990:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )
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
                    new NoViableAltException("2990:3: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) | ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) ) )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2992:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2992:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2993:5: {...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2993:108: ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2994:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3000:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3001:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3001:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3002:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:8: rule__LoopedModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6477);
                    rule__LoopedModel__VisibilityAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3006:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3007:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:8: rule__LoopedModel__VisibilityAssignment_0_0
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6517);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3014:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3014:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3015:5: {...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3015:108: ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3016:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3022:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3023:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3023:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3024:7: ( rule__LoopedModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:7: ( rule__LoopedModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:8: rule__LoopedModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6616);
                    rule__LoopedModel__StaticAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3028:6: ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3029:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:8: rule__LoopedModel__StaticAssignment_0_1
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6656);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3036:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3036:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3037:5: {...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3037:108: ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3038:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3044:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3045:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3045:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3046:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3047:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3047:8: rule__LoopedModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6755);
                    rule__LoopedModel__SynchronizedAssignment_0_2();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3050:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3051:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:8: rule__LoopedModel__SynchronizedAssignment_0_2
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6795);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3058:4: ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3058:4: ({...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3059:5: {...}? => ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3059:108: ( ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3060:6: ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3066:6: ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3067:6: ( ( rule__LoopedModel__Alternatives_0_3 ) ) ( ( rule__LoopedModel__Alternatives_0_3 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3067:6: ( ( rule__LoopedModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3068:7: ( rule__LoopedModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3069:7: ( rule__LoopedModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3069:8: rule__LoopedModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6894);
                    rule__LoopedModel__Alternatives_0_3();
                    _fsp--;


                    }

                     after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3072:6: ( ( rule__LoopedModel__Alternatives_0_3 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3073:7: ( rule__LoopedModel__Alternatives_0_3 )*
                    {
                     before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:7: ( rule__LoopedModel__Alternatives_0_3 )*
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
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:8: rule__LoopedModel__Alternatives_0_3
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6934);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3089:1: rule__LoopedModel__UnorderedGroup_0__0 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3093:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3094:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__07000);
            rule__LoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3095:2: ( rule__LoopedModel__UnorderedGroup_0__1 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3095:2: rule__LoopedModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_rule__LoopedModel__UnorderedGroup_0__07003);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3102:1: rule__LoopedModel__UnorderedGroup_0__1 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3106:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3107:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__17028);
            rule__LoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3108:2: ( rule__LoopedModel__UnorderedGroup_0__2 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3108:2: rule__LoopedModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_rule__LoopedModel__UnorderedGroup_0__17031);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3115:1: rule__LoopedModel__UnorderedGroup_0__2 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3119:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3120:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__27056);
            rule__LoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3121:2: ( rule__LoopedModel__UnorderedGroup_0__3 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3121:2: rule__LoopedModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_rule__LoopedModel__UnorderedGroup_0__27059);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3128:1: rule__LoopedModel__UnorderedGroup_0__3 : rule__LoopedModel__UnorderedGroup_0__Impl ;
    public final void rule__LoopedModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3132:1: ( rule__LoopedModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3133:2: rule__LoopedModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__37084);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3148:1: rule__GroupLoopedModel__UnorderedGroup_0 : rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?;
    public final void rule__GroupLoopedModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3153:1: ( rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3154:2: rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__0_in_rule__GroupLoopedModel__UnorderedGroup_07116);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3165:1: rule__GroupLoopedModel__UnorderedGroup_0__Impl : ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) ) ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3170:1: ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3171:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3171:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )
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
                    new NoViableAltException("3171:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3173:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3173:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3174:5: {...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3174:113: ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3175:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3181:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3183:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3184:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3184:8: rule__GroupLoopedModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7205);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3190:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3190:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3191:5: {...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3191:113: ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3192:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3198:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3200:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3201:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3201:8: rule__GroupLoopedModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7296);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3207:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3207:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3208:5: {...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3208:113: ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3209:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3215:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3217:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3218:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3218:8: rule__GroupLoopedModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7387);
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3224:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3224:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3225:5: {...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3225:113: ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3226:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3232:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3234:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3235:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3235:8: rule__GroupLoopedModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7478);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3250:1: rule__GroupLoopedModel__UnorderedGroup_0__0 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3254:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3255:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__07537);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3256:2: ( rule__GroupLoopedModel__UnorderedGroup_0__1 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3256:2: rule__GroupLoopedModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_rule__GroupLoopedModel__UnorderedGroup_0__07540);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3263:1: rule__GroupLoopedModel__UnorderedGroup_0__1 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3267:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3268:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__17565);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3269:2: ( rule__GroupLoopedModel__UnorderedGroup_0__2 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3269:2: rule__GroupLoopedModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_rule__GroupLoopedModel__UnorderedGroup_0__17568);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3276:1: rule__GroupLoopedModel__UnorderedGroup_0__2 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3280:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3281:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__27593);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: ( rule__GroupLoopedModel__UnorderedGroup_0__3 )?
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: rule__GroupLoopedModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_rule__GroupLoopedModel__UnorderedGroup_0__27596);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3289:1: rule__GroupLoopedModel__UnorderedGroup_0__3 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3293:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3294:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__37621);
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


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3309:1: rule__Bug304681Model__UnorderedGroup_2 : ( rule__Bug304681Model__UnorderedGroup_2__0 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3314:1: ( ( rule__Bug304681Model__UnorderedGroup_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3315:2: ( rule__Bug304681Model__UnorderedGroup_2__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3315:2: ( rule__Bug304681Model__UnorderedGroup_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( LA39_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                alt39=1;
            }
            else if ( LA39_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                alt39=1;
            }
            else if ( LA39_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                alt39=1;
            }
            else if ( LA39_0 >=29 && LA39_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3315:2: rule__Bug304681Model__UnorderedGroup_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__0_in_rule__Bug304681Model__UnorderedGroup_27653);
                    rule__Bug304681Model__UnorderedGroup_2__0();
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

            	getUnorderedGroupHelper().leave(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_2


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3325:1: rule__Bug304681Model__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) ) ) ) ;
    public final void rule__Bug304681Model__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3330:1: ( ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3331:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3331:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) ) ) )
            int alt41=5;
            int LA41_0 = input.LA(1);

            if ( LA41_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                alt41=1;
            }
            else if ( LA41_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                alt41=2;
            }
            else if ( LA41_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                alt41=3;
            }
            else if ( LA41_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                alt41=4;
            }
            else if ( LA41_0 >=29 && LA41_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt41=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3331:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) ) ) )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3333:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3333:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3334:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3334:111: ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3335:6: ( ( rule__Bug304681Model__Group_2_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3341:6: ( ( rule__Bug304681Model__Group_2_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3343:7: ( rule__Bug304681Model__Group_2_0__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_2_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3344:7: ( rule__Bug304681Model__Group_2_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3344:8: rule__Bug304681Model__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7740);
                    rule__Bug304681Model__Group_2_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_2_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3350:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3350:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3351:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3351:111: ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3352:6: ( ( rule__Bug304681Model__Group_2_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3358:6: ( ( rule__Bug304681Model__Group_2_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3360:7: ( rule__Bug304681Model__Group_2_1__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_2_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3361:7: ( rule__Bug304681Model__Group_2_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3361:8: rule__Bug304681Model__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7831);
                    rule__Bug304681Model__Group_2_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_2_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3367:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3367:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3368:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3368:111: ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3369:6: ( ( rule__Bug304681Model__Group_2_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3375:6: ( ( rule__Bug304681Model__Group_2_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3377:7: ( rule__Bug304681Model__Group_2_2__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_2_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3378:7: ( rule__Bug304681Model__Group_2_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3378:8: rule__Bug304681Model__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7922);
                    rule__Bug304681Model__Group_2_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_2_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3384:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3384:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3385:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3385:111: ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3386:6: ( ( rule__Bug304681Model__Group_2_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3392:6: ( ( rule__Bug304681Model__Group_2_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3394:7: ( rule__Bug304681Model__Group_2_3__0 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getGroup_2_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3395:7: ( rule__Bug304681Model__Group_2_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3395:8: rule__Bug304681Model__Group_2_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl8013);
                    rule__Bug304681Model__Group_2_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getGroup_2_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3401:4: ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3401:4: ({...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3402:5: {...}? => ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3402:111: ( ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3403:6: ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3409:6: ( ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3410:6: ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) ) ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3410:6: ( ( rule__Bug304681Model__FeaturesAssignment_2_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3411:7: ( rule__Bug304681Model__FeaturesAssignment_2_4 )
                    {
                     before(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3412:7: ( rule__Bug304681Model__FeaturesAssignment_2_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3412:8: rule__Bug304681Model__FeaturesAssignment_2_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8105);
                    rule__Bug304681Model__FeaturesAssignment_2_4();
                    _fsp--;


                    }

                     after(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3415:6: ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3416:7: ( rule__Bug304681Model__FeaturesAssignment_2_4 )*
                    {
                     before(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3417:7: ( rule__Bug304681Model__FeaturesAssignment_2_4 )*
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

                                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
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

                                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                                        alt40=1;
                                    }


                                }


                            }


                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3417:8: rule__Bug304681Model__FeaturesAssignment_2_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8145);
                    	    rule__Bug304681Model__FeaturesAssignment_2_4();
                    	    _fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                     after(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_2__Impl


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3432:1: rule__Bug304681Model__UnorderedGroup_2__0 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__1 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3436:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3437:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__08211);
            rule__Bug304681Model__UnorderedGroup_2__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3438:2: ( rule__Bug304681Model__UnorderedGroup_2__1 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( LA42_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                alt42=1;
            }
            else if ( LA42_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                alt42=1;
            }
            else if ( LA42_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                alt42=1;
            }
            else if ( LA42_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                alt42=1;
            }
            else if ( LA42_0 >=29 && LA42_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3438:2: rule__Bug304681Model__UnorderedGroup_2__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__1_in_rule__Bug304681Model__UnorderedGroup_2__08214);
                    rule__Bug304681Model__UnorderedGroup_2__1();
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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_2__0


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3445:1: rule__Bug304681Model__UnorderedGroup_2__1 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__2 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3449:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3450:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__18239);
            rule__Bug304681Model__UnorderedGroup_2__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3451:2: ( rule__Bug304681Model__UnorderedGroup_2__2 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( LA43_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                alt43=1;
            }
            else if ( LA43_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                alt43=1;
            }
            else if ( LA43_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                alt43=1;
            }
            else if ( LA43_0 >=29 && LA43_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3451:2: rule__Bug304681Model__UnorderedGroup_2__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__2_in_rule__Bug304681Model__UnorderedGroup_2__18242);
                    rule__Bug304681Model__UnorderedGroup_2__2();
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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_2__1


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3458:1: rule__Bug304681Model__UnorderedGroup_2__2 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__3 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3462:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3463:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__28267);
            rule__Bug304681Model__UnorderedGroup_2__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3464:2: ( rule__Bug304681Model__UnorderedGroup_2__3 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                alt44=1;
            }
            else if ( LA44_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                alt44=1;
            }
            else if ( LA44_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                alt44=1;
            }
            else if ( LA44_0 >=29 && LA44_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3464:2: rule__Bug304681Model__UnorderedGroup_2__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__3_in_rule__Bug304681Model__UnorderedGroup_2__28270);
                    rule__Bug304681Model__UnorderedGroup_2__3();
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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_2__2


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_2__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3471:1: rule__Bug304681Model__UnorderedGroup_2__3 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__4 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3475:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3476:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__38295);
            rule__Bug304681Model__UnorderedGroup_2__Impl();
            _fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3477:2: ( rule__Bug304681Model__UnorderedGroup_2__4 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                alt45=1;
            }
            else if ( LA45_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                alt45=1;
            }
            else if ( LA45_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                alt45=1;
            }
            else if ( LA45_0 >=29 && LA45_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3477:2: rule__Bug304681Model__UnorderedGroup_2__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__4_in_rule__Bug304681Model__UnorderedGroup_2__38298);
                    rule__Bug304681Model__UnorderedGroup_2__4();
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
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_2__3


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_2__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3484:1: rule__Bug304681Model__UnorderedGroup_2__4 : rule__Bug304681Model__UnorderedGroup_2__Impl ;
    public final void rule__Bug304681Model__UnorderedGroup_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3488:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3489:2: rule__Bug304681Model__UnorderedGroup_2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__48323);
            rule__Bug304681Model__UnorderedGroup_2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__UnorderedGroup_2__4


    // $ANTLR start rule__Model__FirstAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3506:1: rule__Model__FirstAssignment_0_1 : ( ruleSimpleModel ) ;
    public final void rule__Model__FirstAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3510:1: ( ( ruleSimpleModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3511:1: ( ruleSimpleModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3511:1: ( ruleSimpleModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3512:1: ruleSimpleModel
            {
             before(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_18361);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3521:1: rule__Model__SecondAssignment_1_1 : ( ruleMandatoryModel ) ;
    public final void rule__Model__SecondAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3525:1: ( ( ruleMandatoryModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3526:1: ( ruleMandatoryModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3526:1: ( ruleMandatoryModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3527:1: ruleMandatoryModel
            {
             before(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_18392);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3536:1: rule__Model__ThrirdAssignment_2_1 : ( ruleLoopedModel ) ;
    public final void rule__Model__ThrirdAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3540:1: ( ( ruleLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3541:1: ( ruleLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3541:1: ( ruleLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3542:1: ruleLoopedModel
            {
             before(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_18423);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3551:1: rule__Model__ForthAssignment_3_1 : ( ruleGroupLoopedModel ) ;
    public final void rule__Model__ForthAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3555:1: ( ( ruleGroupLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3556:1: ( ruleGroupLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3556:1: ( ruleGroupLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3557:1: ruleGroupLoopedModel
            {
             before(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_18454);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3566:1: rule__Model__FifthAssignment_4_1 : ( ruleLoopedAlternativeModel ) ;
    public final void rule__Model__FifthAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3570:1: ( ( ruleLoopedAlternativeModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3571:1: ( ruleLoopedAlternativeModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3571:1: ( ruleLoopedAlternativeModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3572:1: ruleLoopedAlternativeModel
            {
             before(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_18485);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3581:1: rule__Model__ModelAssignment_5_1 : ( ruleBug304681Model ) ;
    public final void rule__Model__ModelAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3585:1: ( ( ruleBug304681Model ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3586:1: ( ruleBug304681Model )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3586:1: ( ruleBug304681Model )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3587:1: ruleBug304681Model
            {
             before(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_18516);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3596:1: rule__SimpleModel__VisibilityAssignment_0_0 : ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__SimpleModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3600:1: ( ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3601:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3601:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3602:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3603:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3603:2: rule__SimpleModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_08547);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3612:1: rule__SimpleModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__SimpleModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3616:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3617:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3617:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3618:1: ( 'static' )
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3619:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3620:1: 'static'
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_18585); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3635:1: rule__SimpleModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__SimpleModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3639:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3640:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3640:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3641:1: ( 'synchronized' )
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3642:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3643:1: 'synchronized'
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_28629); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3658:1: rule__SimpleModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__SimpleModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3662:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3663:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3663:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3664:1: ( 'abstract' )
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3665:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3666:1: 'abstract'
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_08673); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3681:1: rule__SimpleModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__SimpleModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3685:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3686:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3686:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3687:1: ( 'final' )
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3688:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3689:1: 'final'
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_18717); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3704:1: rule__SimpleModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3708:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3709:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3709:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3710:1: RULE_ID
            {
             before(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_28756); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3719:1: rule__MandatoryModel__VisibilityAssignment_0_0 : ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__MandatoryModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3723:1: ( ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3724:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3724:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3725:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3726:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3726:2: rule__MandatoryModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_08787);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3735:1: rule__MandatoryModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__MandatoryModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3739:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3740:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3740:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3741:1: ( 'static' )
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3742:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3743:1: 'static'
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_18825); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3758:1: rule__MandatoryModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__MandatoryModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3762:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3763:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3763:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3764:1: ( 'synchronized' )
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3765:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3766:1: 'synchronized'
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_28869); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3781:1: rule__MandatoryModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__MandatoryModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3785:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3786:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3786:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3787:1: ( 'abstract' )
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3788:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3789:1: 'abstract'
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_08913); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3804:1: rule__MandatoryModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__MandatoryModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3808:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3809:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3809:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3810:1: ( 'final' )
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3811:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3812:1: 'final'
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_18957); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3827:1: rule__MandatoryModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__MandatoryModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3831:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3832:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3832:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3833:1: RULE_ID
            {
             before(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_28996); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3842:1: rule__LoopedModel__VisibilityAssignment_0_0 : ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__LoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3846:1: ( ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3847:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3847:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3848:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3849:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3849:2: rule__LoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_09027);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3858:1: rule__LoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__LoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3862:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3863:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3863:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3864:1: ( 'static' )
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3865:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3866:1: 'static'
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_19065); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3881:1: rule__LoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__LoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3885:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3886:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3886:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3887:1: ( 'synchronized' )
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3888:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3889:1: 'synchronized'
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_29109); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3904:1: rule__LoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__LoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3908:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3909:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3909:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3910:1: ( 'abstract' )
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3911:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3912:1: 'abstract'
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_09153); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3927:1: rule__LoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__LoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3931:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3932:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3932:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3933:1: ( 'final' )
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3934:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3935:1: 'final'
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_19197); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3950:1: rule__LoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__LoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3954:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3955:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3955:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3956:1: RULE_ID
            {
             before(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_29236); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3965:1: rule__GroupLoopedModel__VisibilityAssignment_0_0 : ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__GroupLoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3969:1: ( ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3970:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3970:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3971:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3972:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3972:2: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_09267);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3981:1: rule__GroupLoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__GroupLoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3985:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3986:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3986:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3987:1: ( 'static' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3988:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3989:1: 'static'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_19305); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4004:1: rule__GroupLoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__GroupLoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4008:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4009:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4009:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4010:1: ( 'synchronized' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4011:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4012:1: 'synchronized'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_29349); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4027:1: rule__GroupLoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__GroupLoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4031:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4032:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4032:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4033:1: ( 'abstract' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4034:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4035:1: 'abstract'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_09393); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4050:1: rule__GroupLoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__GroupLoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4054:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4055:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4055:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4056:1: ( 'final' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4057:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4058:1: 'final'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_19437); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4073:1: rule__GroupLoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__GroupLoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4077:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4078:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4078:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4079:1: RULE_ID
            {
             before(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_29476); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4088:1: rule__LoopedAlternativeModel__VisibilityAssignment_0_0 : ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__LoopedAlternativeModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4092:1: ( ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4093:1: ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4093:1: ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4094:1: ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4095:1: ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4095:2: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_09507);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4104:1: rule__LoopedAlternativeModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__LoopedAlternativeModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4108:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4109:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4109:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4110:1: ( 'static' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4111:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4112:1: 'static'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_19545); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4127:1: rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__LoopedAlternativeModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4131:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4132:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4132:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4133:1: ( 'synchronized' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4134:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4135:1: 'synchronized'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_29589); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4150:1: rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__LoopedAlternativeModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4154:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4155:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4155:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4156:1: ( 'abstract' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4157:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4158:1: 'abstract'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_09633); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4173:1: rule__LoopedAlternativeModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__LoopedAlternativeModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4177:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4178:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4178:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4179:1: ( 'final' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4180:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4181:1: 'final'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_19677); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4196:1: rule__LoopedAlternativeModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__LoopedAlternativeModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4200:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4201:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4201:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4202:1: RULE_ID
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_29716); 
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


    // $ANTLR start rule__Bug304681Model__ShortDescriptionAssignment_2_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4211:1: rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__ShortDescriptionAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4215:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4216:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4216:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4217:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_2_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_2_0_19747); 
             after(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__ShortDescriptionAssignment_2_0_1


    // $ANTLR start rule__Bug304681Model__LongDescriptionAssignment_2_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4226:1: rule__Bug304681Model__LongDescriptionAssignment_2_1_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__LongDescriptionAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4230:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4231:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4231:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4232:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_2_1_19778); 
             after(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__LongDescriptionAssignment_2_1_1


    // $ANTLR start rule__Bug304681Model__UidAssignment_2_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4241:1: rule__Bug304681Model__UidAssignment_2_2_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__UidAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4245:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4246:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4246:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4247:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_2_2_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_2_2_19809); 
             after(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__UidAssignment_2_2_1


    // $ANTLR start rule__Bug304681Model__FlagAssignment_2_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4256:1: rule__Bug304681Model__FlagAssignment_2_3_0 : ( ( 'flag' ) ) ;
    public final void rule__Bug304681Model__FlagAssignment_2_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4260:1: ( ( ( 'flag' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4261:1: ( ( 'flag' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4261:1: ( ( 'flag' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4262:1: ( 'flag' )
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4263:1: ( 'flag' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4264:1: 'flag'
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_2_3_09845); 
             after(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 

            }

             after(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__FlagAssignment_2_3_0


    // $ANTLR start rule__Bug304681Model__FeaturesAssignment_2_4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4279:1: rule__Bug304681Model__FeaturesAssignment_2_4 : ( ruleBug304681Feature ) ;
    public final void rule__Bug304681Model__FeaturesAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4283:1: ( ( ruleBug304681Feature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4284:1: ( ruleBug304681Feature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4284:1: ( ruleBug304681Feature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4285:1: ruleBug304681Feature
            {
             before(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_2_49884);
            ruleBug304681Feature();
            _fsp--;

             after(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Bug304681Model__FeaturesAssignment_2_4


    // $ANTLR start rule__Bug304681Attribute__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4294:1: rule__Bug304681Attribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Bug304681Attribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4298:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4299:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4299:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4300:1: RULE_ID
            {
             before(grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_19915); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4309:1: rule__Bug304681Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Bug304681Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4313:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4314:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4314:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4315:1: RULE_ID
            {
             before(grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_19946); 
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
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__0__Impl_in_rule__Bug304681Model__Group__04008 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__1_in_rule__Bug304681Model__Group__04011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__1__Impl_in_rule__Bug304681Model__Group__14069 = new BitSet(new long[]{0x000000087A400000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__14072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Bug304681Model__Group__1__Impl4100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__2__Impl_in_rule__Bug304681Model__Group__24131 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__3_in_rule__Bug304681Model__Group__24134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2_in_rule__Bug304681Model__Group__2__Impl4161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__3__Impl_in_rule__Bug304681Model__Group__34191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Bug304681Model__Group__3__Impl4219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__0__Impl_in_rule__Bug304681Model__Group_2_0__04258 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__1_in_rule__Bug304681Model__Group_2_0__04261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Bug304681Model__Group_2_0__0__Impl4289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__1__Impl_in_rule__Bug304681Model__Group_2_0__14320 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__2_in_rule__Bug304681Model__Group_2_0__14323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_2_0_1_in_rule__Bug304681Model__Group_2_0__1__Impl4350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__2__Impl_in_rule__Bug304681Model__Group_2_0__24380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_0__2__Impl4408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__0__Impl_in_rule__Bug304681Model__Group_2_1__04445 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__1_in_rule__Bug304681Model__Group_2_1__04448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Bug304681Model__Group_2_1__0__Impl4476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__1__Impl_in_rule__Bug304681Model__Group_2_1__14507 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__2_in_rule__Bug304681Model__Group_2_1__14510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_2_1_1_in_rule__Bug304681Model__Group_2_1__1__Impl4537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__2__Impl_in_rule__Bug304681Model__Group_2_1__24567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_1__2__Impl4595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__0__Impl_in_rule__Bug304681Model__Group_2_2__04632 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__1_in_rule__Bug304681Model__Group_2_2__04635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Bug304681Model__Group_2_2__0__Impl4663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__1__Impl_in_rule__Bug304681Model__Group_2_2__14694 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__2_in_rule__Bug304681Model__Group_2_2__14697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UidAssignment_2_2_1_in_rule__Bug304681Model__Group_2_2__1__Impl4724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__2__Impl_in_rule__Bug304681Model__Group_2_2__24754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_2__2__Impl4782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__0__Impl_in_rule__Bug304681Model__Group_2_3__04819 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__1_in_rule__Bug304681Model__Group_2_3__04822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FlagAssignment_2_3_0_in_rule__Bug304681Model__Group_2_3__0__Impl4849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__1__Impl_in_rule__Bug304681Model__Group_2_3__14879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_3__1__Impl4907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__0__Impl_in_rule__Bug304681Attribute__Group__04942 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__04945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__Bug304681Attribute__Group__0__Impl4973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__1__Impl_in_rule__Bug304681Attribute__Group__15004 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__15007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__1__Impl5034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__2__Impl_in_rule__Bug304681Attribute__Group__25064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Attribute__Group__2__Impl5092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__0__Impl_in_rule__Bug304681Reference__Group__05129 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__05132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Bug304681Reference__Group__0__Impl5160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__1__Impl_in_rule__Bug304681Reference__Group__15191 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__15194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__1__Impl5221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__2__Impl_in_rule__Bug304681Reference__Group__25251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Reference__Group__2__Impl5279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_rule__SimpleModel__UnorderedGroup_05317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_0__Impl5404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_0__Impl5495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_0__Impl5586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_0__Impl5677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__05736 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_rule__SimpleModel__UnorderedGroup_0__05739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__15764 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_rule__SimpleModel__UnorderedGroup_0__15767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__25792 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_rule__SimpleModel__UnorderedGroup_0__25795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__35820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__0_in_rule__MandatoryModel__UnorderedGroup_05852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_0__Impl5941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_0__Impl6032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_0__Impl6123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_0__Impl6214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__06273 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_rule__MandatoryModel__UnorderedGroup_0__06276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__16301 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_rule__MandatoryModel__UnorderedGroup_0__16304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__26329 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_rule__MandatoryModel__UnorderedGroup_0__26332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__36357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_rule__LoopedModel__UnorderedGroup_06389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6477 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6517 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6616 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6656 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6755 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6795 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6894 = new BitSet(new long[]{0x0000000600000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6934 = new BitSet(new long[]{0x0000000600000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__07000 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_rule__LoopedModel__UnorderedGroup_0__07003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__17028 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_rule__LoopedModel__UnorderedGroup_0__17031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__27056 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_rule__LoopedModel__UnorderedGroup_0__27059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__37084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__0_in_rule__GroupLoopedModel__UnorderedGroup_07116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__07537 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_rule__GroupLoopedModel__UnorderedGroup_0__07540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__17565 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_rule__GroupLoopedModel__UnorderedGroup_0__17568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__27593 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_rule__GroupLoopedModel__UnorderedGroup_0__27596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__37621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__0_in_rule__Bug304681Model__UnorderedGroup_27653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl8013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8105 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8145 = new BitSet(new long[]{0x0000000060000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__08211 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__1_in_rule__Bug304681Model__UnorderedGroup_2__08214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__18239 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__2_in_rule__Bug304681Model__UnorderedGroup_2__18242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__28267 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__3_in_rule__Bug304681Model__UnorderedGroup_2__28270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__38295 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__4_in_rule__Bug304681Model__UnorderedGroup_2__38298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__48323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_18361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_18392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_18423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_18454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_18485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_18516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_08547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_18585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_28629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_08673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_18717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_28756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_08787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_18825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_28869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_08913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_18957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_28996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_09027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_19065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_29109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_09153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_19197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_29236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_09267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_19305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_29349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_09393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_19437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_29476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_09507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_19545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_29589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_09633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_19677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_29716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_2_0_19747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_2_1_19778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_2_2_19809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_2_3_09845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_2_49884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_19915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_19946 = new BitSet(new long[]{0x0000000000000002L});
    }


}