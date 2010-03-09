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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:62:1: ruleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:76:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:76:2: rule__Model__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:88:1: entryRuleSimpleModel : ruleSimpleModel EOF ;
    public final void entryRuleSimpleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:1: ( ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:90:1: ruleSimpleModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:97:1: ruleSimpleModel : ( ( rule__SimpleModel__Group__0 ) ) ;
    public final void ruleSimpleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:101:2: ( ( ( rule__SimpleModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:102:1: ( ( rule__SimpleModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:102:1: ( ( rule__SimpleModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:103:1: ( rule__SimpleModel__Group__0 )
            {
             before(grammarAccess.getSimpleModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:104:1: ( rule__SimpleModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:104:2: rule__SimpleModel__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:116:1: entryRuleMandatoryModel : ruleMandatoryModel EOF ;
    public final void entryRuleMandatoryModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:117:1: ( ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:118:1: ruleMandatoryModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:125:1: ruleMandatoryModel : ( ( rule__MandatoryModel__Group__0 ) ) ;
    public final void ruleMandatoryModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:129:2: ( ( ( rule__MandatoryModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:130:1: ( ( rule__MandatoryModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:130:1: ( ( rule__MandatoryModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:131:1: ( rule__MandatoryModel__Group__0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:132:1: ( rule__MandatoryModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:132:2: rule__MandatoryModel__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:144:1: entryRuleLoopedModel : ruleLoopedModel EOF ;
    public final void entryRuleLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:145:1: ( ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:146:1: ruleLoopedModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:153:1: ruleLoopedModel : ( ( rule__LoopedModel__Group__0 ) ) ;
    public final void ruleLoopedModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:157:2: ( ( ( rule__LoopedModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:158:1: ( ( rule__LoopedModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:158:1: ( ( rule__LoopedModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:159:1: ( rule__LoopedModel__Group__0 )
            {
             before(grammarAccess.getLoopedModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:160:1: ( rule__LoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:160:2: rule__LoopedModel__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:172:1: entryRuleGroupLoopedModel : ruleGroupLoopedModel EOF ;
    public final void entryRuleGroupLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:173:1: ( ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:1: ruleGroupLoopedModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:181:1: ruleGroupLoopedModel : ( ( rule__GroupLoopedModel__Group__0 ) ) ;
    public final void ruleGroupLoopedModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:185:2: ( ( ( rule__GroupLoopedModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:186:1: ( ( rule__GroupLoopedModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:186:1: ( ( rule__GroupLoopedModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:187:1: ( rule__GroupLoopedModel__Group__0 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:188:1: ( rule__GroupLoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:188:2: rule__GroupLoopedModel__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:200:1: entryRuleLoopedAlternativeModel : ruleLoopedAlternativeModel EOF ;
    public final void entryRuleLoopedAlternativeModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:201:1: ( ruleLoopedAlternativeModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:202:1: ruleLoopedAlternativeModel EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:209:1: ruleLoopedAlternativeModel : ( ( rule__LoopedAlternativeModel__Group__0 ) ) ;
    public final void ruleLoopedAlternativeModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:213:2: ( ( ( rule__LoopedAlternativeModel__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:214:1: ( ( rule__LoopedAlternativeModel__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:214:1: ( ( rule__LoopedAlternativeModel__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:215:1: ( rule__LoopedAlternativeModel__Group__0 )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:216:1: ( rule__LoopedAlternativeModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:216:2: rule__LoopedAlternativeModel__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:228:1: entryRuleBug304681Model : ruleBug304681Model EOF ;
    public final void entryRuleBug304681Model() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:229:1: ( ruleBug304681Model EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:230:1: ruleBug304681Model EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:237:1: ruleBug304681Model : ( ( rule__Bug304681Model__Group__0 ) ) ;
    public final void ruleBug304681Model() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:241:2: ( ( ( rule__Bug304681Model__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:242:1: ( ( rule__Bug304681Model__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:242:1: ( ( rule__Bug304681Model__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:243:1: ( rule__Bug304681Model__Group__0 )
            {
             before(grammarAccess.getBug304681ModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:244:1: ( rule__Bug304681Model__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:244:2: rule__Bug304681Model__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:256:1: entryRuleBug304681Feature : ruleBug304681Feature EOF ;
    public final void entryRuleBug304681Feature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:257:1: ( ruleBug304681Feature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:258:1: ruleBug304681Feature EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:265:1: ruleBug304681Feature : ( ( rule__Bug304681Feature__Alternatives ) ) ;
    public final void ruleBug304681Feature() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:269:2: ( ( ( rule__Bug304681Feature__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:270:1: ( ( rule__Bug304681Feature__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:270:1: ( ( rule__Bug304681Feature__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:271:1: ( rule__Bug304681Feature__Alternatives )
            {
             before(grammarAccess.getBug304681FeatureAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:272:1: ( rule__Bug304681Feature__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:272:2: rule__Bug304681Feature__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:284:1: entryRuleBug304681Attribute : ruleBug304681Attribute EOF ;
    public final void entryRuleBug304681Attribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:285:1: ( ruleBug304681Attribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:286:1: ruleBug304681Attribute EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:293:1: ruleBug304681Attribute : ( ( rule__Bug304681Attribute__Group__0 ) ) ;
    public final void ruleBug304681Attribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:297:2: ( ( ( rule__Bug304681Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:298:1: ( ( rule__Bug304681Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:298:1: ( ( rule__Bug304681Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:299:1: ( rule__Bug304681Attribute__Group__0 )
            {
             before(grammarAccess.getBug304681AttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:1: ( rule__Bug304681Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:2: rule__Bug304681Attribute__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:312:1: entryRuleBug304681Reference : ruleBug304681Reference EOF ;
    public final void entryRuleBug304681Reference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:313:1: ( ruleBug304681Reference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:314:1: ruleBug304681Reference EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:321:1: ruleBug304681Reference : ( ( rule__Bug304681Reference__Group__0 ) ) ;
    public final void ruleBug304681Reference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:325:2: ( ( ( rule__Bug304681Reference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:326:1: ( ( rule__Bug304681Reference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:326:1: ( ( rule__Bug304681Reference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:327:1: ( rule__Bug304681Reference__Group__0 )
            {
             before(grammarAccess.getBug304681ReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:328:1: ( rule__Bug304681Reference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:328:2: rule__Bug304681Reference__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:340:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:344:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) )
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
                    new NoViableAltException("340:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:345:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:345:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:346:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:347:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:347:2: rule__Model__Group_0__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:351:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:351:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:352:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:353:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:353:2: rule__Model__Group_1__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:357:6: ( ( rule__Model__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:357:6: ( ( rule__Model__Group_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:358:1: ( rule__Model__Group_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:359:1: ( rule__Model__Group_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:359:2: rule__Model__Group_2__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:363:6: ( ( rule__Model__Group_3__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:363:6: ( ( rule__Model__Group_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:364:1: ( rule__Model__Group_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:365:1: ( rule__Model__Group_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:365:2: rule__Model__Group_3__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:369:6: ( ( rule__Model__Group_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:369:6: ( ( rule__Model__Group_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:1: ( rule__Model__Group_4__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:371:1: ( rule__Model__Group_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:371:2: rule__Model__Group_4__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:375:6: ( ( rule__Model__Group_5__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:375:6: ( ( rule__Model__Group_5__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:376:1: ( rule__Model__Group_5__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_5()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:377:1: ( rule__Model__Group_5__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:377:2: rule__Model__Group_5__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:386:1: rule__SimpleModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__SimpleModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:390:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
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
                    new NoViableAltException("386:1: rule__SimpleModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:391:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:391:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:392:1: 'public'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__SimpleModel__VisibilityAlternatives_0_0_0794); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:399:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:399:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:400:1: 'private'
                    {
                     before(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__SimpleModel__VisibilityAlternatives_0_0_0814); 
                     after(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:407:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:407:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:408:1: 'protected'
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:420:1: rule__SimpleModel__Alternatives_0_3 : ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__SimpleModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:424:1: ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) )
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
                    new NoViableAltException("420:1: rule__SimpleModel__Alternatives_0_3 : ( ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:425:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:425:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:426:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:427:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:427:2: rule__SimpleModel__AbstractAssignment_0_3_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:431:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:431:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:433:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:433:2: rule__SimpleModel__FinalAssignment_0_3_1
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:442:1: rule__MandatoryModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__MandatoryModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:446:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
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
                    new NoViableAltException("442:1: rule__MandatoryModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:1: 'public'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0920); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:455:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:455:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:456:1: 'private'
                    {
                     before(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0940); 
                     after(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:463:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:463:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:464:1: 'protected'
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:476:1: rule__MandatoryModel__Alternatives_0_3 : ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__MandatoryModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:480:1: ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) )
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
                    new NoViableAltException("476:1: rule__MandatoryModel__Alternatives_0_3 : ( ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:481:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:481:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:482:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:483:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:483:2: rule__MandatoryModel__AbstractAssignment_0_3_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:487:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:488:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:489:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:489:2: rule__MandatoryModel__FinalAssignment_0_3_1
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:498:1: rule__LoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__LoopedModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:502:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
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
                    new NoViableAltException("498:1: rule__LoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:503:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:503:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:504:1: 'public'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LoopedModel__VisibilityAlternatives_0_0_01046); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:511:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:511:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:512:1: 'private'
                    {
                     before(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__LoopedModel__VisibilityAlternatives_0_0_01066); 
                     after(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:519:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:519:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:520:1: 'protected'
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:532:1: rule__LoopedModel__Alternatives_0_3 : ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__LoopedModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:536:1: ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) )
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
                    new NoViableAltException("532:1: rule__LoopedModel__Alternatives_0_3 : ( ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:537:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:537:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:539:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:539:2: rule__LoopedModel__AbstractAssignment_0_3_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:543:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:543:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:544:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:545:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:545:2: rule__LoopedModel__FinalAssignment_0_3_1
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:554:1: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__GroupLoopedModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:558:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
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
                    new NoViableAltException("554:1: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:559:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:559:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:560:1: 'public'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01172); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:567:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:1: 'private'
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01192); 
                     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:575:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:575:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:576:1: 'protected'
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:588:1: rule__GroupLoopedModel__Alternatives_0_3 : ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__GroupLoopedModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:592:1: ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) )
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
                    new NoViableAltException("588:1: rule__GroupLoopedModel__Alternatives_0_3 : ( ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:593:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:593:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:594:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:595:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:595:2: rule__GroupLoopedModel__AbstractAssignment_0_3_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:599:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:599:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:600:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:601:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:601:2: rule__GroupLoopedModel__FinalAssignment_0_3_1
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:610:1: rule__LoopedAlternativeModel__Alternatives_0 : ( ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) ) | ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) ) | ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) ) | ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) ) | ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) ) );
    public final void rule__LoopedAlternativeModel__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:614:1: ( ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) ) | ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) ) | ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) ) | ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) ) | ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) ) )
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
                    new NoViableAltException("610:1: rule__LoopedAlternativeModel__Alternatives_0 : ( ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) ) | ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) ) | ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) ) | ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) ) | ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:615:1: ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:615:1: ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:616:1: ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:617:1: ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:617:2: rule__LoopedAlternativeModel__VisibilityAssignment_0_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:621:6: ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:621:6: ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:622:1: ( rule__LoopedAlternativeModel__StaticAssignment_0_1 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getStaticAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:623:1: ( rule__LoopedAlternativeModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:623:2: rule__LoopedAlternativeModel__StaticAssignment_0_1
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:627:6: ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:627:6: ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:628:1: ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:1: ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:2: rule__LoopedAlternativeModel__SynchronizedAssignment_0_2
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:633:6: ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:633:6: ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:634:1: ( rule__LoopedAlternativeModel__Alternatives_0_3 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:1: ( rule__LoopedAlternativeModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:2: rule__LoopedAlternativeModel__Alternatives_0_3
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:639:6: ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:639:6: ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:640:1: ( rule__LoopedAlternativeModel__Group_0_4__0 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getGroup_0_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:641:1: ( rule__LoopedAlternativeModel__Group_0_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:641:2: rule__LoopedAlternativeModel__Group_0_4__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:650:1: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );
    public final void rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:654:1: ( ( 'public' ) | ( 'private' ) | ( 'protected' ) )
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
                    new NoViableAltException("650:1: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 : ( ( 'public' ) | ( 'private' ) | ( 'protected' ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:655:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:655:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:656:1: 'public'
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01403); 
                     after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:663:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:663:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:1: 'private'
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01423); 
                     after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:671:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:671:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:672:1: 'protected'
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:684:1: rule__LoopedAlternativeModel__Alternatives_0_3 : ( ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) ) );
    public final void rule__LoopedAlternativeModel__Alternatives_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:688:1: ( ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) ) )
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
                    new NoViableAltException("684:1: rule__LoopedAlternativeModel__Alternatives_0_3 : ( ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) ) | ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) ) );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:689:1: ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:689:1: ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:690:1: ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAssignment_0_3_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:691:1: ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:691:2: rule__LoopedAlternativeModel__AbstractAssignment_0_3_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:695:6: ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:695:6: ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:1: ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 )
                    {
                     before(grammarAccess.getLoopedAlternativeModelAccess().getFinalAssignment_0_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:1: ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:2: rule__LoopedAlternativeModel__FinalAssignment_0_3_1
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:706:1: rule__Bug304681Feature__Alternatives : ( ( ruleBug304681Attribute ) | ( ruleBug304681Reference ) );
    public final void rule__Bug304681Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:710:1: ( ( ruleBug304681Attribute ) | ( ruleBug304681Reference ) )
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
                    new NoViableAltException("706:1: rule__Bug304681Feature__Alternatives : ( ( ruleBug304681Attribute ) | ( ruleBug304681Reference ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:711:1: ( ruleBug304681Attribute )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:711:1: ( ruleBug304681Attribute )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:712:1: ruleBug304681Attribute
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:717:6: ( ruleBug304681Reference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:717:6: ( ruleBug304681Reference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:718:1: ruleBug304681Reference
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:730:1: rule__Model__Group_0__0 : ( '1' ) rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:1: ( ( '1' ) rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: ( '1' ) rule__Model__Group_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: ( '1' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:1: '1'
            {
             before(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_0__01580); 
             after(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01590);
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


    // $ANTLR start rule__Model__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:750:1: rule__Model__Group_0__1 : ( ( rule__Model__FirstAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:754:1: ( ( ( rule__Model__FirstAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:755:1: ( ( rule__Model__FirstAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:755:1: ( ( rule__Model__FirstAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:756:1: ( rule__Model__FirstAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getFirstAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:1: ( rule__Model__FirstAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:2: rule__Model__FirstAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__11618);
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
    // $ANTLR end rule__Model__Group_0__1


    // $ANTLR start rule__Model__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:771:1: rule__Model__Group_1__0 : ( '2' ) rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:775:1: ( ( '2' ) rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:776:1: ( '2' ) rule__Model__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:776:1: ( '2' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:777:1: '2'
            {
             before(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_1__01657); 
             after(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01667);
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


    // $ANTLR start rule__Model__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:791:1: rule__Model__Group_1__1 : ( ( rule__Model__SecondAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:795:1: ( ( ( rule__Model__SecondAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:796:1: ( ( rule__Model__SecondAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:796:1: ( ( rule__Model__SecondAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:797:1: ( rule__Model__SecondAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getSecondAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:798:1: ( rule__Model__SecondAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:798:2: rule__Model__SecondAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__11695);
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
    // $ANTLR end rule__Model__Group_1__1


    // $ANTLR start rule__Model__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:812:1: rule__Model__Group_2__0 : ( '3' ) rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:816:1: ( ( '3' ) rule__Model__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:817:1: ( '3' ) rule__Model__Group_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:817:1: ( '3' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:818:1: '3'
            {
             before(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__Group_2__01734); 
             after(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01744);
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


    // $ANTLR start rule__Model__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:832:1: rule__Model__Group_2__1 : ( ( rule__Model__ThrirdAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:836:1: ( ( ( rule__Model__ThrirdAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:837:1: ( ( rule__Model__ThrirdAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:837:1: ( ( rule__Model__ThrirdAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:838:1: ( rule__Model__ThrirdAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getThrirdAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:839:1: ( rule__Model__ThrirdAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:839:2: rule__Model__ThrirdAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__11772);
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
    // $ANTLR end rule__Model__Group_2__1


    // $ANTLR start rule__Model__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:853:1: rule__Model__Group_3__0 : ( '4' ) rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:857:1: ( ( '4' ) rule__Model__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:858:1: ( '4' ) rule__Model__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:858:1: ( '4' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:859:1: '4'
            {
             before(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__Group_3__01811); 
             after(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01821);
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


    // $ANTLR start rule__Model__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:873:1: rule__Model__Group_3__1 : ( ( rule__Model__ForthAssignment_3_1 ) ) ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:877:1: ( ( ( rule__Model__ForthAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:878:1: ( ( rule__Model__ForthAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:878:1: ( ( rule__Model__ForthAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:879:1: ( rule__Model__ForthAssignment_3_1 )
            {
             before(grammarAccess.getModelAccess().getForthAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( rule__Model__ForthAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:2: rule__Model__ForthAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__11849);
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
    // $ANTLR end rule__Model__Group_3__1


    // $ANTLR start rule__Model__Group_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:894:1: rule__Model__Group_4__0 : ( '5' ) rule__Model__Group_4__1 ;
    public final void rule__Model__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:898:1: ( ( '5' ) rule__Model__Group_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:899:1: ( '5' ) rule__Model__Group_4__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:899:1: ( '5' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:900:1: '5'
            {
             before(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Model__Group_4__01888); 
             after(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__1_in_rule__Model__Group_4__01898);
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


    // $ANTLR start rule__Model__Group_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:914:1: rule__Model__Group_4__1 : ( ( rule__Model__FifthAssignment_4_1 ) ) ;
    public final void rule__Model__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:918:1: ( ( ( rule__Model__FifthAssignment_4_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:919:1: ( ( rule__Model__FifthAssignment_4_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:919:1: ( ( rule__Model__FifthAssignment_4_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:920:1: ( rule__Model__FifthAssignment_4_1 )
            {
             before(grammarAccess.getModelAccess().getFifthAssignment_4_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:921:1: ( rule__Model__FifthAssignment_4_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:921:2: rule__Model__FifthAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__FifthAssignment_4_1_in_rule__Model__Group_4__11926);
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
    // $ANTLR end rule__Model__Group_4__1


    // $ANTLR start rule__Model__Group_5__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:935:1: rule__Model__Group_5__0 : ( 'bug304681' ) rule__Model__Group_5__1 ;
    public final void rule__Model__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:939:1: ( ( 'bug304681' ) rule__Model__Group_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:940:1: ( 'bug304681' ) rule__Model__Group_5__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:940:1: ( 'bug304681' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:941:1: 'bug304681'
            {
             before(grammarAccess.getModelAccess().getBug304681Keyword_5_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Model__Group_5__01965); 
             after(grammarAccess.getModelAccess().getBug304681Keyword_5_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__1_in_rule__Model__Group_5__01975);
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


    // $ANTLR start rule__Model__Group_5__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:955:1: rule__Model__Group_5__1 : ( ( rule__Model__ModelAssignment_5_1 ) ) ;
    public final void rule__Model__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:959:1: ( ( ( rule__Model__ModelAssignment_5_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:960:1: ( ( rule__Model__ModelAssignment_5_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:960:1: ( ( rule__Model__ModelAssignment_5_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:961:1: ( rule__Model__ModelAssignment_5_1 )
            {
             before(grammarAccess.getModelAccess().getModelAssignment_5_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:962:1: ( rule__Model__ModelAssignment_5_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:962:2: rule__Model__ModelAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ModelAssignment_5_1_in_rule__Model__Group_5__12003);
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
    // $ANTLR end rule__Model__Group_5__1


    // $ANTLR start rule__SimpleModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:976:1: rule__SimpleModel__Group__0 : ( ( rule__SimpleModel__UnorderedGroup_0 ) ) rule__SimpleModel__Group__1 ;
    public final void rule__SimpleModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:980:1: ( ( ( rule__SimpleModel__UnorderedGroup_0 ) ) rule__SimpleModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:981:1: ( ( rule__SimpleModel__UnorderedGroup_0 ) ) rule__SimpleModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:981:1: ( ( rule__SimpleModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:982:1: ( rule__SimpleModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:983:1: ( rule__SimpleModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:983:2: rule__SimpleModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__02041);
            rule__SimpleModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__02050);
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


    // $ANTLR start rule__SimpleModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:994:1: rule__SimpleModel__Group__1 : ( 'class' ) rule__SimpleModel__Group__2 ;
    public final void rule__SimpleModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:998:1: ( ( 'class' ) rule__SimpleModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:999:1: ( 'class' ) rule__SimpleModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:999:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1000:1: 'class'
            {
             before(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__SimpleModel__Group__12079); 
             after(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__12089);
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


    // $ANTLR start rule__SimpleModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1014:1: rule__SimpleModel__Group__2 : ( ( rule__SimpleModel__NameAssignment_2 ) ) rule__SimpleModel__Group__3 ;
    public final void rule__SimpleModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: ( ( ( rule__SimpleModel__NameAssignment_2 ) ) rule__SimpleModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:1: ( ( rule__SimpleModel__NameAssignment_2 ) ) rule__SimpleModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:1: ( ( rule__SimpleModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1020:1: ( rule__SimpleModel__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1021:1: ( rule__SimpleModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1021:2: rule__SimpleModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__22117);
            rule__SimpleModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__22126);
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


    // $ANTLR start rule__SimpleModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1032:1: rule__SimpleModel__Group__3 : ( '{' ) rule__SimpleModel__Group__4 ;
    public final void rule__SimpleModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1036:1: ( ( '{' ) rule__SimpleModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1037:1: ( '{' ) rule__SimpleModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1037:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1038:1: '{'
            {
             before(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__SimpleModel__Group__32155); 
             after(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__32165);
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


    // $ANTLR start rule__SimpleModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1052:1: rule__SimpleModel__Group__4 : ( '}' ) ;
    public final void rule__SimpleModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1056:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1057:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1057:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1058:1: '}'
            {
             before(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__SimpleModel__Group__42194); 
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
    // $ANTLR end rule__SimpleModel__Group__4


    // $ANTLR start rule__MandatoryModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1081:1: rule__MandatoryModel__Group__0 : ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) rule__MandatoryModel__Group__1 ;
    public final void rule__MandatoryModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1085:1: ( ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) rule__MandatoryModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1086:1: ( ( rule__MandatoryModel__UnorderedGroup_0 ) ) rule__MandatoryModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1086:1: ( ( rule__MandatoryModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1087:1: ( rule__MandatoryModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:1: ( rule__MandatoryModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1088:2: rule__MandatoryModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__02239);
            rule__MandatoryModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__02248);
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


    // $ANTLR start rule__MandatoryModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1099:1: rule__MandatoryModel__Group__1 : ( 'class' ) rule__MandatoryModel__Group__2 ;
    public final void rule__MandatoryModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1103:1: ( ( 'class' ) rule__MandatoryModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1104:1: ( 'class' ) rule__MandatoryModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1104:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1105:1: 'class'
            {
             before(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__MandatoryModel__Group__12277); 
             after(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__12287);
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


    // $ANTLR start rule__MandatoryModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1119:1: rule__MandatoryModel__Group__2 : ( ( rule__MandatoryModel__NameAssignment_2 ) ) rule__MandatoryModel__Group__3 ;
    public final void rule__MandatoryModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1123:1: ( ( ( rule__MandatoryModel__NameAssignment_2 ) ) rule__MandatoryModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1124:1: ( ( rule__MandatoryModel__NameAssignment_2 ) ) rule__MandatoryModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1124:1: ( ( rule__MandatoryModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1125:1: ( rule__MandatoryModel__NameAssignment_2 )
            {
             before(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1126:1: ( rule__MandatoryModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1126:2: rule__MandatoryModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__22315);
            rule__MandatoryModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__22324);
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


    // $ANTLR start rule__MandatoryModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1137:1: rule__MandatoryModel__Group__3 : ( '{' ) rule__MandatoryModel__Group__4 ;
    public final void rule__MandatoryModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1141:1: ( ( '{' ) rule__MandatoryModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1142:1: ( '{' ) rule__MandatoryModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1142:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1143:1: '{'
            {
             before(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__MandatoryModel__Group__32353); 
             after(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__32363);
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


    // $ANTLR start rule__MandatoryModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1157:1: rule__MandatoryModel__Group__4 : ( '}' ) ;
    public final void rule__MandatoryModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1161:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1162:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1162:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1163:1: '}'
            {
             before(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__MandatoryModel__Group__42392); 
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
    // $ANTLR end rule__MandatoryModel__Group__4


    // $ANTLR start rule__LoopedModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1186:1: rule__LoopedModel__Group__0 : ( ( rule__LoopedModel__UnorderedGroup_0 ) ) rule__LoopedModel__Group__1 ;
    public final void rule__LoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1190:1: ( ( ( rule__LoopedModel__UnorderedGroup_0 ) ) rule__LoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1191:1: ( ( rule__LoopedModel__UnorderedGroup_0 ) ) rule__LoopedModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1191:1: ( ( rule__LoopedModel__UnorderedGroup_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1192:1: ( rule__LoopedModel__UnorderedGroup_0 )
            {
             before(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1193:1: ( rule__LoopedModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1193:2: rule__LoopedModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__02437);
            rule__LoopedModel__UnorderedGroup_0();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__02446);
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


    // $ANTLR start rule__LoopedModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1204:1: rule__LoopedModel__Group__1 : ( 'class' ) rule__LoopedModel__Group__2 ;
    public final void rule__LoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1208:1: ( ( 'class' ) rule__LoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1209:1: ( 'class' ) rule__LoopedModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1209:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1210:1: 'class'
            {
             before(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LoopedModel__Group__12475); 
             after(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__12485);
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


    // $ANTLR start rule__LoopedModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1224:1: rule__LoopedModel__Group__2 : ( ( rule__LoopedModel__NameAssignment_2 ) ) rule__LoopedModel__Group__3 ;
    public final void rule__LoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:1: ( ( ( rule__LoopedModel__NameAssignment_2 ) ) rule__LoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:1: ( ( rule__LoopedModel__NameAssignment_2 ) ) rule__LoopedModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:1: ( ( rule__LoopedModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1230:1: ( rule__LoopedModel__NameAssignment_2 )
            {
             before(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1231:1: ( rule__LoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1231:2: rule__LoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__22513);
            rule__LoopedModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__22522);
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


    // $ANTLR start rule__LoopedModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1242:1: rule__LoopedModel__Group__3 : ( '{' ) rule__LoopedModel__Group__4 ;
    public final void rule__LoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1246:1: ( ( '{' ) rule__LoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1247:1: ( '{' ) rule__LoopedModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1247:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1248:1: '{'
            {
             before(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LoopedModel__Group__32551); 
             after(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__32561);
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


    // $ANTLR start rule__LoopedModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1262:1: rule__LoopedModel__Group__4 : ( '}' ) ;
    public final void rule__LoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1266:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1267:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1267:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1268:1: '}'
            {
             before(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LoopedModel__Group__42590); 
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
    // $ANTLR end rule__LoopedModel__Group__4


    // $ANTLR start rule__GroupLoopedModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1291:1: rule__GroupLoopedModel__Group__0 : ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) rule__GroupLoopedModel__Group__1 ;
    public final void rule__GroupLoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1295:1: ( ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) rule__GroupLoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1296:1: ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* ) rule__GroupLoopedModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1296:1: ( ( rule__GroupLoopedModel__UnorderedGroup_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1297:1: ( rule__GroupLoopedModel__UnorderedGroup_0 )*
            {
             before(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1298:1: ( rule__GroupLoopedModel__UnorderedGroup_0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==20) ) {
                    int LA14_1 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0>=11 && LA14_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt14=1;
                }
                else if ( (LA14_0==31) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt14=1;
                }
                else if ( (LA14_0==32) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt14=1;
                }
                else if ( ((LA14_0>=33 && LA14_0<=34)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1298:2: rule__GroupLoopedModel__UnorderedGroup_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__02635);
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

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__02645);
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


    // $ANTLR start rule__GroupLoopedModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1309:1: rule__GroupLoopedModel__Group__1 : ( 'class' ) rule__GroupLoopedModel__Group__2 ;
    public final void rule__GroupLoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1313:1: ( ( 'class' ) rule__GroupLoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1314:1: ( 'class' ) rule__GroupLoopedModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1314:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1315:1: 'class'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__GroupLoopedModel__Group__12674); 
             after(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__12684);
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


    // $ANTLR start rule__GroupLoopedModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1329:1: rule__GroupLoopedModel__Group__2 : ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) rule__GroupLoopedModel__Group__3 ;
    public final void rule__GroupLoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1333:1: ( ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) rule__GroupLoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1334:1: ( ( rule__GroupLoopedModel__NameAssignment_2 ) ) rule__GroupLoopedModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1334:1: ( ( rule__GroupLoopedModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1335:1: ( rule__GroupLoopedModel__NameAssignment_2 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1336:1: ( rule__GroupLoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1336:2: rule__GroupLoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__22712);
            rule__GroupLoopedModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__22721);
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


    // $ANTLR start rule__GroupLoopedModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1347:1: rule__GroupLoopedModel__Group__3 : ( '{' ) rule__GroupLoopedModel__Group__4 ;
    public final void rule__GroupLoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1351:1: ( ( '{' ) rule__GroupLoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1352:1: ( '{' ) rule__GroupLoopedModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1352:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1353:1: '{'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__GroupLoopedModel__Group__32750); 
             after(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__32760);
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


    // $ANTLR start rule__GroupLoopedModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1367:1: rule__GroupLoopedModel__Group__4 : ( '}' ) ;
    public final void rule__GroupLoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1371:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1372:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1372:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1373:1: '}'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GroupLoopedModel__Group__42789); 
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
    // $ANTLR end rule__GroupLoopedModel__Group__4


    // $ANTLR start rule__LoopedAlternativeModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1396:1: rule__LoopedAlternativeModel__Group__0 : ( ( rule__LoopedAlternativeModel__Alternatives_0 )* ) rule__LoopedAlternativeModel__Group__1 ;
    public final void rule__LoopedAlternativeModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1400:1: ( ( ( rule__LoopedAlternativeModel__Alternatives_0 )* ) rule__LoopedAlternativeModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1401:1: ( ( rule__LoopedAlternativeModel__Alternatives_0 )* ) rule__LoopedAlternativeModel__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1401:1: ( ( rule__LoopedAlternativeModel__Alternatives_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1402:1: ( rule__LoopedAlternativeModel__Alternatives_0 )*
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1403:1: ( rule__LoopedAlternativeModel__Alternatives_0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=11 && LA15_0<=13)||LA15_0==23||(LA15_0>=31 && LA15_0<=34)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1403:2: rule__LoopedAlternativeModel__Alternatives_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_in_rule__LoopedAlternativeModel__Group__02834);
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

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__1_in_rule__LoopedAlternativeModel__Group__02844);
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


    // $ANTLR start rule__LoopedAlternativeModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1414:1: rule__LoopedAlternativeModel__Group__1 : ( 'class' ) rule__LoopedAlternativeModel__Group__2 ;
    public final void rule__LoopedAlternativeModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1418:1: ( ( 'class' ) rule__LoopedAlternativeModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: ( 'class' ) rule__LoopedAlternativeModel__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: ( 'class' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1420:1: 'class'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LoopedAlternativeModel__Group__12873); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__2_in_rule__LoopedAlternativeModel__Group__12883);
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


    // $ANTLR start rule__LoopedAlternativeModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1434:1: rule__LoopedAlternativeModel__Group__2 : ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) ) rule__LoopedAlternativeModel__Group__3 ;
    public final void rule__LoopedAlternativeModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1438:1: ( ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) ) rule__LoopedAlternativeModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1439:1: ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) ) rule__LoopedAlternativeModel__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1439:1: ( ( rule__LoopedAlternativeModel__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1440:1: ( rule__LoopedAlternativeModel__NameAssignment_2 )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1441:1: ( rule__LoopedAlternativeModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1441:2: rule__LoopedAlternativeModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__NameAssignment_2_in_rule__LoopedAlternativeModel__Group__22911);
            rule__LoopedAlternativeModel__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLoopedAlternativeModelAccess().getNameAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__3_in_rule__LoopedAlternativeModel__Group__22920);
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


    // $ANTLR start rule__LoopedAlternativeModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1452:1: rule__LoopedAlternativeModel__Group__3 : ( '{' ) rule__LoopedAlternativeModel__Group__4 ;
    public final void rule__LoopedAlternativeModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1456:1: ( ( '{' ) rule__LoopedAlternativeModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1457:1: ( '{' ) rule__LoopedAlternativeModel__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1457:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1458:1: '{'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LoopedAlternativeModel__Group__32949); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__4_in_rule__LoopedAlternativeModel__Group__32959);
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


    // $ANTLR start rule__LoopedAlternativeModel__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1472:1: rule__LoopedAlternativeModel__Group__4 : ( '}' ) ;
    public final void rule__LoopedAlternativeModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1476:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1477:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1477:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1478:1: '}'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LoopedAlternativeModel__Group__42988); 
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
    // $ANTLR end rule__LoopedAlternativeModel__Group__4


    // $ANTLR start rule__LoopedAlternativeModel__Group_0_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1501:1: rule__LoopedAlternativeModel__Group_0_4__0 : ( 'before' ) rule__LoopedAlternativeModel__Group_0_4__1 ;
    public final void rule__LoopedAlternativeModel__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1505:1: ( ( 'before' ) rule__LoopedAlternativeModel__Group_0_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:1: ( 'before' ) rule__LoopedAlternativeModel__Group_0_4__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1506:1: ( 'before' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1507:1: 'before'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LoopedAlternativeModel__Group_0_4__03034); 
             after(grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1_in_rule__LoopedAlternativeModel__Group_0_4__03044);
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


    // $ANTLR start rule__LoopedAlternativeModel__Group_0_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1521:1: rule__LoopedAlternativeModel__Group_0_4__1 : ( ( 'after' )* ) ;
    public final void rule__LoopedAlternativeModel__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1525:1: ( ( ( 'after' )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1526:1: ( ( 'after' )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1526:1: ( ( 'after' )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1527:1: ( 'after' )*
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1528:1: ( 'after' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==24) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1529:2: 'after'
            	    {
            	    match(input,24,FollowSets000.FOLLOW_24_in_rule__LoopedAlternativeModel__Group_0_4__13074); 

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
    // $ANTLR end rule__LoopedAlternativeModel__Group_0_4__1


    // $ANTLR start rule__Bug304681Model__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1544:1: rule__Bug304681Model__Group__0 : ( '{' ) rule__Bug304681Model__Group__1 ;
    public final void rule__Bug304681Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1548:1: ( ( '{' ) rule__Bug304681Model__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1549:1: ( '{' ) rule__Bug304681Model__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1549:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1550:1: '{'
            {
             before(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Bug304681Model__Group__03116); 
             after(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__1_in_rule__Bug304681Model__Group__03126);
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


    // $ANTLR start rule__Bug304681Model__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1564:1: rule__Bug304681Model__Group__1 : ( ( rule__Bug304681Model__UnorderedGroup_1 ) ) rule__Bug304681Model__Group__2 ;
    public final void rule__Bug304681Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1568:1: ( ( ( rule__Bug304681Model__UnorderedGroup_1 ) ) rule__Bug304681Model__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1569:1: ( ( rule__Bug304681Model__UnorderedGroup_1 ) ) rule__Bug304681Model__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1569:1: ( ( rule__Bug304681Model__UnorderedGroup_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1570:1: ( rule__Bug304681Model__UnorderedGroup_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1571:1: ( rule__Bug304681Model__UnorderedGroup_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1571:2: rule__Bug304681Model__UnorderedGroup_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_1_in_rule__Bug304681Model__Group__13154);
            rule__Bug304681Model__UnorderedGroup_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__13163);
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


    // $ANTLR start rule__Bug304681Model__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1582:1: rule__Bug304681Model__Group__2 : ( '}' ) ;
    public final void rule__Bug304681Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1586:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1587:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1587:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1588:1: '}'
            {
             before(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Bug304681Model__Group__23192); 
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
    // $ANTLR end rule__Bug304681Model__Group__2


    // $ANTLR start rule__Bug304681Model__Group_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1607:1: rule__Bug304681Model__Group_1_0__0 : ( 'short' ) rule__Bug304681Model__Group_1_0__1 ;
    public final void rule__Bug304681Model__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1611:1: ( ( 'short' ) rule__Bug304681Model__Group_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1612:1: ( 'short' ) rule__Bug304681Model__Group_1_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1612:1: ( 'short' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1613:1: 'short'
            {
             before(grammarAccess.getBug304681ModelAccess().getShortKeyword_1_0_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Bug304681Model__Group_1_0__03234); 
             after(grammarAccess.getBug304681ModelAccess().getShortKeyword_1_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__1_in_rule__Bug304681Model__Group_1_0__03244);
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


    // $ANTLR start rule__Bug304681Model__Group_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1627:1: rule__Bug304681Model__Group_1_0__1 : ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) ) rule__Bug304681Model__Group_1_0__2 ;
    public final void rule__Bug304681Model__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1631:1: ( ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) ) rule__Bug304681Model__Group_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1632:1: ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) ) rule__Bug304681Model__Group_1_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1632:1: ( ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1633:1: ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_1_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1634:1: ( rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1634:2: rule__Bug304681Model__ShortDescriptionAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_1_0_1_in_rule__Bug304681Model__Group_1_0__13272);
            rule__Bug304681Model__ShortDescriptionAssignment_1_0_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_1_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__2_in_rule__Bug304681Model__Group_1_0__13281);
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


    // $ANTLR start rule__Bug304681Model__Group_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1645:1: rule__Bug304681Model__Group_1_0__2 : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1649:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1650:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1650:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1651:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_0_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_0__23310); 
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
    // $ANTLR end rule__Bug304681Model__Group_1_0__2


    // $ANTLR start rule__Bug304681Model__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1670:1: rule__Bug304681Model__Group_1_1__0 : ( 'long' ) rule__Bug304681Model__Group_1_1__1 ;
    public final void rule__Bug304681Model__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:1: ( ( 'long' ) rule__Bug304681Model__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1675:1: ( 'long' ) rule__Bug304681Model__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1675:1: ( 'long' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1676:1: 'long'
            {
             before(grammarAccess.getBug304681ModelAccess().getLongKeyword_1_1_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Bug304681Model__Group_1_1__03352); 
             after(grammarAccess.getBug304681ModelAccess().getLongKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__1_in_rule__Bug304681Model__Group_1_1__03362);
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


    // $ANTLR start rule__Bug304681Model__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1690:1: rule__Bug304681Model__Group_1_1__1 : ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) ) rule__Bug304681Model__Group_1_1__2 ;
    public final void rule__Bug304681Model__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1694:1: ( ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) ) rule__Bug304681Model__Group_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1695:1: ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) ) rule__Bug304681Model__Group_1_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1695:1: ( ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1696:1: ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1697:1: ( rule__Bug304681Model__LongDescriptionAssignment_1_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1697:2: rule__Bug304681Model__LongDescriptionAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_1_1_1_in_rule__Bug304681Model__Group_1_1__13390);
            rule__Bug304681Model__LongDescriptionAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_1_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__2_in_rule__Bug304681Model__Group_1_1__13399);
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


    // $ANTLR start rule__Bug304681Model__Group_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1708:1: rule__Bug304681Model__Group_1_1__2 : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1712:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1713:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1713:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1714:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_1_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_1__23428); 
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
    // $ANTLR end rule__Bug304681Model__Group_1_1__2


    // $ANTLR start rule__Bug304681Model__Group_1_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1733:1: rule__Bug304681Model__Group_1_2__0 : ( 'uid' ) rule__Bug304681Model__Group_1_2__1 ;
    public final void rule__Bug304681Model__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1737:1: ( ( 'uid' ) rule__Bug304681Model__Group_1_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1738:1: ( 'uid' ) rule__Bug304681Model__Group_1_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1738:1: ( 'uid' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1739:1: 'uid'
            {
             before(grammarAccess.getBug304681ModelAccess().getUidKeyword_1_2_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Bug304681Model__Group_1_2__03470); 
             after(grammarAccess.getBug304681ModelAccess().getUidKeyword_1_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__1_in_rule__Bug304681Model__Group_1_2__03480);
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


    // $ANTLR start rule__Bug304681Model__Group_1_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1753:1: rule__Bug304681Model__Group_1_2__1 : ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) ) rule__Bug304681Model__Group_1_2__2 ;
    public final void rule__Bug304681Model__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1757:1: ( ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) ) rule__Bug304681Model__Group_1_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1758:1: ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) ) rule__Bug304681Model__Group_1_2__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1758:1: ( ( rule__Bug304681Model__UidAssignment_1_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1759:1: ( rule__Bug304681Model__UidAssignment_1_2_1 )
            {
             before(grammarAccess.getBug304681ModelAccess().getUidAssignment_1_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1760:1: ( rule__Bug304681Model__UidAssignment_1_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1760:2: rule__Bug304681Model__UidAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UidAssignment_1_2_1_in_rule__Bug304681Model__Group_1_2__13508);
            rule__Bug304681Model__UidAssignment_1_2_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getUidAssignment_1_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__2_in_rule__Bug304681Model__Group_1_2__13517);
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


    // $ANTLR start rule__Bug304681Model__Group_1_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1771:1: rule__Bug304681Model__Group_1_2__2 : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1775:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1776:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1776:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1777:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_2_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_2__23546); 
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
    // $ANTLR end rule__Bug304681Model__Group_1_2__2


    // $ANTLR start rule__Bug304681Model__Group_1_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1796:1: rule__Bug304681Model__Group_1_3__0 : ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) ) rule__Bug304681Model__Group_1_3__1 ;
    public final void rule__Bug304681Model__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1800:1: ( ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) ) rule__Bug304681Model__Group_1_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1801:1: ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) ) rule__Bug304681Model__Group_1_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1801:1: ( ( rule__Bug304681Model__FlagAssignment_1_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1802:1: ( rule__Bug304681Model__FlagAssignment_1_3_0 )
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagAssignment_1_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1803:1: ( rule__Bug304681Model__FlagAssignment_1_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1803:2: rule__Bug304681Model__FlagAssignment_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FlagAssignment_1_3_0_in_rule__Bug304681Model__Group_1_3__03587);
            rule__Bug304681Model__FlagAssignment_1_3_0();
            _fsp--;


            }

             after(grammarAccess.getBug304681ModelAccess().getFlagAssignment_1_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_3__1_in_rule__Bug304681Model__Group_1_3__03596);
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


    // $ANTLR start rule__Bug304681Model__Group_1_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1814:1: rule__Bug304681Model__Group_1_3__1 : ( ';' ) ;
    public final void rule__Bug304681Model__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1818:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1819:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1819:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1820:1: ';'
            {
             before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_1_3_1()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_1_3__13625); 
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
    // $ANTLR end rule__Bug304681Model__Group_1_3__1


    // $ANTLR start rule__Bug304681Attribute__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1837:1: rule__Bug304681Attribute__Group__0 : ( 'attr' ) rule__Bug304681Attribute__Group__1 ;
    public final void rule__Bug304681Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1841:1: ( ( 'attr' ) rule__Bug304681Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:1: ( 'attr' ) rule__Bug304681Attribute__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:1: ( 'attr' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1843:1: 'attr'
            {
             before(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__Bug304681Attribute__Group__03665); 
             after(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__03675);
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


    // $ANTLR start rule__Bug304681Attribute__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1857:1: rule__Bug304681Attribute__Group__1 : ( ( rule__Bug304681Attribute__NameAssignment_1 ) ) rule__Bug304681Attribute__Group__2 ;
    public final void rule__Bug304681Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1861:1: ( ( ( rule__Bug304681Attribute__NameAssignment_1 ) ) rule__Bug304681Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1862:1: ( ( rule__Bug304681Attribute__NameAssignment_1 ) ) rule__Bug304681Attribute__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1862:1: ( ( rule__Bug304681Attribute__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1863:1: ( rule__Bug304681Attribute__NameAssignment_1 )
            {
             before(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1864:1: ( rule__Bug304681Attribute__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1864:2: rule__Bug304681Attribute__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__13703);
            rule__Bug304681Attribute__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__13712);
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


    // $ANTLR start rule__Bug304681Attribute__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1875:1: rule__Bug304681Attribute__Group__2 : ( ';' ) ;
    public final void rule__Bug304681Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1879:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1880:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1880:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1881:1: ';'
            {
             before(grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Attribute__Group__23741); 
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
    // $ANTLR end rule__Bug304681Attribute__Group__2


    // $ANTLR start rule__Bug304681Reference__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1900:1: rule__Bug304681Reference__Group__0 : ( 'ref' ) rule__Bug304681Reference__Group__1 ;
    public final void rule__Bug304681Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1904:1: ( ( 'ref' ) rule__Bug304681Reference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1905:1: ( 'ref' ) rule__Bug304681Reference__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1905:1: ( 'ref' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1906:1: 'ref'
            {
             before(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Bug304681Reference__Group__03783); 
             after(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__03793);
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


    // $ANTLR start rule__Bug304681Reference__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1920:1: rule__Bug304681Reference__Group__1 : ( ( rule__Bug304681Reference__NameAssignment_1 ) ) rule__Bug304681Reference__Group__2 ;
    public final void rule__Bug304681Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1924:1: ( ( ( rule__Bug304681Reference__NameAssignment_1 ) ) rule__Bug304681Reference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1925:1: ( ( rule__Bug304681Reference__NameAssignment_1 ) ) rule__Bug304681Reference__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1925:1: ( ( rule__Bug304681Reference__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1926:1: ( rule__Bug304681Reference__NameAssignment_1 )
            {
             before(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1927:1: ( rule__Bug304681Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1927:2: rule__Bug304681Reference__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__13821);
            rule__Bug304681Reference__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__13830);
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


    // $ANTLR start rule__Bug304681Reference__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1938:1: rule__Bug304681Reference__Group__2 : ( ';' ) ;
    public final void rule__Bug304681Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1942:1: ( ( ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1943:1: ( ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1943:1: ( ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1944:1: ';'
            {
             before(grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Reference__Group__23859); 
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
    // $ANTLR end rule__Bug304681Reference__Group__2


    // $ANTLR start rule__SimpleModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1964:1: rule__SimpleModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* ) ;
    public final void rule__SimpleModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1969:1: ( ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1970:2: ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1970:2: ( ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1971:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1971:3: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) ) )*
            loop17:
            do {
                int alt17=5;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=11 && LA17_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0))) {
                    alt17=1;
                }
                else if ( (LA17_0==31) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1))) {
                    alt17=2;
                }
                else if ( (LA17_0==32) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2))) {
                    alt17=3;
                }
                else if ( ((LA17_0>=33 && LA17_0<=34)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3))) {
                    alt17=4;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1973:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1973:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1974:5: {...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1974:108: ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1975:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1978:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1979:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1980:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1980:8: rule__SimpleModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_03947);
            	    rule__SimpleModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1989:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1989:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1990:5: {...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1990:108: ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1991:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1994:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1995:7: ( rule__SimpleModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1996:7: ( rule__SimpleModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1996:8: rule__SimpleModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_04031);
            	    rule__SimpleModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2005:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2005:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2006:5: {...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2006:108: ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2007:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2010:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2011:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2012:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2012:8: rule__SimpleModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_04115);
            	    rule__SimpleModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2021:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2021:4: ({...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2022:5: {...}? => ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__SimpleModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2022:108: ( ( ( rule__SimpleModel__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2023:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2026:6: ( ( rule__SimpleModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2027:7: ( rule__SimpleModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2028:7: ( rule__SimpleModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2028:8: rule__SimpleModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_04199);
            	    rule__SimpleModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


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


    // $ANTLR start rule__MandatoryModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2048:1: rule__MandatoryModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )* {...}?) ;
    public final void rule__MandatoryModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2053:1: ( ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )* {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2054:2: ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )* {...}?)
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2054:2: ( ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )* {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2055:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )* {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2055:3: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) ) )*
            loop18:
            do {
                int alt18=5;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=11 && LA18_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0))) {
                    alt18=1;
                }
                else if ( (LA18_0==31) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1))) {
                    alt18=2;
                }
                else if ( (LA18_0==32) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2))) {
                    alt18=3;
                }
                else if ( ((LA18_0>=33 && LA18_0<=34)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3))) {
                    alt18=4;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2057:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2057:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2058:5: {...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2058:111: ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2059:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2062:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2063:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2064:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2064:8: rule__MandatoryModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_04322);
            	    rule__MandatoryModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2073:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2073:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2074:5: {...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2074:111: ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2075:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2078:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2079:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2080:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2080:8: rule__MandatoryModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_04406);
            	    rule__MandatoryModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2089:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2089:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2090:5: {...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2090:111: ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2091:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2094:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2095:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2096:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2096:8: rule__MandatoryModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_04490);
            	    rule__MandatoryModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2105:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2105:4: ({...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2106:5: {...}? => ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2106:111: ( ( ( rule__MandatoryModel__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2107:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2110:6: ( ( rule__MandatoryModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2111:7: ( rule__MandatoryModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2112:7: ( rule__MandatoryModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2112:8: rule__MandatoryModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_04574);
            	    rule__MandatoryModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( !(getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())) ) {
                throw new FailedPredicateException(input, "rule__MandatoryModel__UnorderedGroup_0", "getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())");
            }

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


    // $ANTLR start rule__LoopedModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2133:1: rule__LoopedModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) ) )* ) ;
    public final void rule__LoopedModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2138:1: ( ( ( ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2139:2: ( ( ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2139:2: ( ( ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2140:3: ( ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2140:3: ( ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) ) )*
            loop19:
            do {
                int alt19=5;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=11 && LA19_0<=13)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    alt19=1;
                }
                else if ( (LA19_0==31) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    alt19=2;
                }
                else if ( (LA19_0==32) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    alt19=3;
                }
                else if ( ((LA19_0>=33 && LA19_0<=34)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    alt19=4;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2142:4: ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2142:4: ({...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2143:5: {...}? => ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2143:108: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2144:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2147:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2148:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2149:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2149:8: rule__LoopedModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_04703);
            	    rule__LoopedModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2158:4: ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2158:4: ({...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2159:5: {...}? => ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2159:108: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2160:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2163:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2164:7: ( rule__LoopedModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2165:7: ( rule__LoopedModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2165:8: rule__LoopedModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_04787);
            	    rule__LoopedModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2174:4: ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2174:4: ({...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2175:5: {...}? => ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2175:108: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2176:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2179:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2180:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2181:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2181:8: rule__LoopedModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_04871);
            	    rule__LoopedModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2190:4: ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2190:4: ({...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2191:5: {...}? => ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__LoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2191:108: ( ( ( rule__LoopedModel__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2192:6: ( ( rule__LoopedModel__Alternatives_0_3 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2195:6: ( ( rule__LoopedModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2196:7: ( rule__LoopedModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2197:7: ( rule__LoopedModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2197:8: rule__LoopedModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_04955);
            	    rule__LoopedModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


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


    // $ANTLR start rule__GroupLoopedModel__UnorderedGroup_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2217:1: rule__GroupLoopedModel__UnorderedGroup_0 : ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )* {...}?) ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2222:1: ( ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )* {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2223:2: ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )* {...}?)
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2223:2: ( ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )* {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2224:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )* {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2224:3: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) | ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) ) )*
            loop20:
            do {
                int alt20=5;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==11) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    int LA20_2 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==12) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    int LA20_3 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==13) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0))) {
                    int LA20_4 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==31) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1))) {
                    int LA20_5 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
                        alt20=2;
                    }


                }
                else if ( (LA20_0==32) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2))) {
                    int LA20_6 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
                        alt20=3;
                    }


                }
                else if ( (LA20_0==33) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    int LA20_7 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
                        alt20=4;
                    }


                }
                else if ( (LA20_0==34) && (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3))) {
                    int LA20_8 = input.LA(2);

                    if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
                        alt20=4;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2226:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2226:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2227:5: {...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2227:113: ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2228:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2231:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2232:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2233:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2233:8: rule__GroupLoopedModel__VisibilityAssignment_0_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_05078);
            	    rule__GroupLoopedModel__VisibilityAssignment_0_0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2242:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2242:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2243:5: {...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2243:113: ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2244:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2247:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2248:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2249:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2249:8: rule__GroupLoopedModel__StaticAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_05162);
            	    rule__GroupLoopedModel__StaticAssignment_0_1();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2258:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2258:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2259:5: {...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2259:113: ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2260:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2263:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2264:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2265:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2265:8: rule__GroupLoopedModel__SynchronizedAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_05246);
            	    rule__GroupLoopedModel__SynchronizedAssignment_0_2();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2274:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2274:4: ({...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2275:5: {...}? => ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2275:113: ( ( ( rule__GroupLoopedModel__Alternatives_0_3 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2276:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2279:6: ( ( rule__GroupLoopedModel__Alternatives_0_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2280:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
            	    {
            	     before(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2281:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2281:8: rule__GroupLoopedModel__Alternatives_0_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_05330);
            	    rule__GroupLoopedModel__Alternatives_0_3();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( !(getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())) ) {
                throw new FailedPredicateException(input, "rule__GroupLoopedModel__UnorderedGroup_0", "getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())");
            }

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


    // $ANTLR start rule__Bug304681Model__UnorderedGroup_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2302:1: rule__Bug304681Model__UnorderedGroup_1 : ( ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) ) )* ) ;
    public final void rule__Bug304681Model__UnorderedGroup_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2307:1: ( ( ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2308:2: ( ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2308:2: ( ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2309:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2309:3: ( ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) ) )*
            loop21:
            do {
                int alt21=6;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0))) {
                    alt21=1;
                }
                else if ( (LA21_0==27) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1))) {
                    alt21=2;
                }
                else if ( (LA21_0==28) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2))) {
                    alt21=3;
                }
                else if ( (LA21_0==35) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3))) {
                    alt21=4;
                }
                else if ( ((LA21_0>=29 && LA21_0<=30)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4))) {
                    alt21=5;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2311:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2311:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2312:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0)) ) {
            	        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2312:111: ( ( ( rule__Bug304681Model__Group_1_0__0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2313:6: ( ( rule__Bug304681Model__Group_1_0__0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2316:6: ( ( rule__Bug304681Model__Group_1_0__0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2317:7: ( rule__Bug304681Model__Group_1_0__0 )
            	    {
            	     before(grammarAccess.getBug304681ModelAccess().getGroup_1_0()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2318:7: ( rule__Bug304681Model__Group_1_0__0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2318:8: rule__Bug304681Model__Group_1_0__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_0__0_in_rule__Bug304681Model__UnorderedGroup_15459);
            	    rule__Bug304681Model__Group_1_0__0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getBug304681ModelAccess().getGroup_1_0()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2327:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2327:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2328:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1)) ) {
            	        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2328:111: ( ( ( rule__Bug304681Model__Group_1_1__0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2329:6: ( ( rule__Bug304681Model__Group_1_1__0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2332:6: ( ( rule__Bug304681Model__Group_1_1__0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2333:7: ( rule__Bug304681Model__Group_1_1__0 )
            	    {
            	     before(grammarAccess.getBug304681ModelAccess().getGroup_1_1()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2334:7: ( rule__Bug304681Model__Group_1_1__0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2334:8: rule__Bug304681Model__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_1__0_in_rule__Bug304681Model__UnorderedGroup_15543);
            	    rule__Bug304681Model__Group_1_1__0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getBug304681ModelAccess().getGroup_1_1()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2343:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2343:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2344:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2)) ) {
            	        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2344:111: ( ( ( rule__Bug304681Model__Group_1_2__0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2345:6: ( ( rule__Bug304681Model__Group_1_2__0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2348:6: ( ( rule__Bug304681Model__Group_1_2__0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2349:7: ( rule__Bug304681Model__Group_1_2__0 )
            	    {
            	     before(grammarAccess.getBug304681ModelAccess().getGroup_1_2()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2350:7: ( rule__Bug304681Model__Group_1_2__0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2350:8: rule__Bug304681Model__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_2__0_in_rule__Bug304681Model__UnorderedGroup_15627);
            	    rule__Bug304681Model__Group_1_2__0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getBug304681ModelAccess().getGroup_1_2()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2359:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2359:4: ({...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2360:5: {...}? => ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3)) ) {
            	        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2360:111: ( ( ( rule__Bug304681Model__Group_1_3__0 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2361:6: ( ( rule__Bug304681Model__Group_1_3__0 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2364:6: ( ( rule__Bug304681Model__Group_1_3__0 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2365:7: ( rule__Bug304681Model__Group_1_3__0 )
            	    {
            	     before(grammarAccess.getBug304681ModelAccess().getGroup_1_3()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2366:7: ( rule__Bug304681Model__Group_1_3__0 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2366:8: rule__Bug304681Model__Group_1_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_1_3__0_in_rule__Bug304681Model__UnorderedGroup_15711);
            	    rule__Bug304681Model__Group_1_3__0();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getBug304681ModelAccess().getGroup_1_3()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2375:4: ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2375:4: ({...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2376:5: {...}? => ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4)) ) {
            	        throw new FailedPredicateException(input, "rule__Bug304681Model__UnorderedGroup_1", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2376:111: ( ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2377:6: ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1(), 4);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2380:6: ( ( rule__Bug304681Model__FeaturesAssignment_1_4 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2381:7: ( rule__Bug304681Model__FeaturesAssignment_1_4 )
            	    {
            	     before(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_1_4()); 
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2382:7: ( rule__Bug304681Model__FeaturesAssignment_1_4 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2382:8: rule__Bug304681Model__FeaturesAssignment_1_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_1_4_in_rule__Bug304681Model__UnorderedGroup_15795);
            	    rule__Bug304681Model__FeaturesAssignment_1_4();
            	    _fsp--;


            	    }

            	     after(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_1_4()); 

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


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


    // $ANTLR start rule__Model__FirstAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2402:1: rule__Model__FirstAssignment_0_1 : ( ruleSimpleModel ) ;
    public final void rule__Model__FirstAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2406:1: ( ( ruleSimpleModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2407:1: ( ruleSimpleModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2407:1: ( ruleSimpleModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2408:1: ruleSimpleModel
            {
             before(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_15872);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2417:1: rule__Model__SecondAssignment_1_1 : ( ruleMandatoryModel ) ;
    public final void rule__Model__SecondAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2421:1: ( ( ruleMandatoryModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2422:1: ( ruleMandatoryModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2422:1: ( ruleMandatoryModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2423:1: ruleMandatoryModel
            {
             before(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_15903);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2432:1: rule__Model__ThrirdAssignment_2_1 : ( ruleLoopedModel ) ;
    public final void rule__Model__ThrirdAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2436:1: ( ( ruleLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2437:1: ( ruleLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2437:1: ( ruleLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2438:1: ruleLoopedModel
            {
             before(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_15934);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2447:1: rule__Model__ForthAssignment_3_1 : ( ruleGroupLoopedModel ) ;
    public final void rule__Model__ForthAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2451:1: ( ( ruleGroupLoopedModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2452:1: ( ruleGroupLoopedModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2452:1: ( ruleGroupLoopedModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2453:1: ruleGroupLoopedModel
            {
             before(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_15965);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2462:1: rule__Model__FifthAssignment_4_1 : ( ruleLoopedAlternativeModel ) ;
    public final void rule__Model__FifthAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2466:1: ( ( ruleLoopedAlternativeModel ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2467:1: ( ruleLoopedAlternativeModel )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2467:1: ( ruleLoopedAlternativeModel )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2468:1: ruleLoopedAlternativeModel
            {
             before(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_15996);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2477:1: rule__Model__ModelAssignment_5_1 : ( ruleBug304681Model ) ;
    public final void rule__Model__ModelAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2481:1: ( ( ruleBug304681Model ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2482:1: ( ruleBug304681Model )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2482:1: ( ruleBug304681Model )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2483:1: ruleBug304681Model
            {
             before(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_16027);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2492:1: rule__SimpleModel__VisibilityAssignment_0_0 : ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__SimpleModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2496:1: ( ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2497:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2497:1: ( ( rule__SimpleModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2498:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2499:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2499:2: rule__SimpleModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_06058);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2508:1: rule__SimpleModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__SimpleModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2512:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2513:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2513:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2514:1: ( 'static' )
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2515:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2516:1: 'static'
            {
             before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_16096); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2531:1: rule__SimpleModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__SimpleModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2535:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2536:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2536:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2537:1: ( 'synchronized' )
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2538:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2539:1: 'synchronized'
            {
             before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_26140); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2554:1: rule__SimpleModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__SimpleModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2558:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2559:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2559:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2560:1: ( 'abstract' )
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2561:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2562:1: 'abstract'
            {
             before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_06184); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2577:1: rule__SimpleModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__SimpleModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2581:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2582:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2582:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2583:1: ( 'final' )
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2584:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2585:1: 'final'
            {
             before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_16228); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2600:1: rule__SimpleModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2604:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2605:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2605:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2606:1: RULE_ID
            {
             before(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_26267); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2615:1: rule__MandatoryModel__VisibilityAssignment_0_0 : ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__MandatoryModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2619:1: ( ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2620:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2620:1: ( ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2621:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2622:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2622:2: rule__MandatoryModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_06298);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2631:1: rule__MandatoryModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__MandatoryModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2635:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2636:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2636:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2637:1: ( 'static' )
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2638:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2639:1: 'static'
            {
             before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_16336); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2654:1: rule__MandatoryModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__MandatoryModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2658:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2659:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2659:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2660:1: ( 'synchronized' )
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2661:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2662:1: 'synchronized'
            {
             before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_26380); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2677:1: rule__MandatoryModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__MandatoryModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2681:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2683:1: ( 'abstract' )
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2684:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2685:1: 'abstract'
            {
             before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_06424); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2700:1: rule__MandatoryModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__MandatoryModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2704:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2705:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2705:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2706:1: ( 'final' )
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2707:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2708:1: 'final'
            {
             before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_16468); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2723:1: rule__MandatoryModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__MandatoryModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2727:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2728:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2728:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2729:1: RULE_ID
            {
             before(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_26507); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2738:1: rule__LoopedModel__VisibilityAssignment_0_0 : ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__LoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2742:1: ( ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2743:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2743:1: ( ( rule__LoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2744:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2745:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2745:2: rule__LoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_06538);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2754:1: rule__LoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__LoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2758:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2759:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2759:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2760:1: ( 'static' )
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2761:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2762:1: 'static'
            {
             before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_16576); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2777:1: rule__LoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__LoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2781:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2782:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2782:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2783:1: ( 'synchronized' )
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2784:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2785:1: 'synchronized'
            {
             before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_26620); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2800:1: rule__LoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__LoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2804:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2805:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2805:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2806:1: ( 'abstract' )
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2807:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2808:1: 'abstract'
            {
             before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_06664); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2823:1: rule__LoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__LoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2827:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2828:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2828:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2829:1: ( 'final' )
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2830:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2831:1: 'final'
            {
             before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_16708); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2846:1: rule__LoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__LoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2850:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2851:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2851:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2852:1: RULE_ID
            {
             before(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_26747); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2861:1: rule__GroupLoopedModel__VisibilityAssignment_0_0 : ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__GroupLoopedModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2865:1: ( ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2866:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2866:1: ( ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2867:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2868:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2868:2: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_06778);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2877:1: rule__GroupLoopedModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__GroupLoopedModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2881:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2882:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2882:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2883:1: ( 'static' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2884:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2885:1: 'static'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_16816); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2900:1: rule__GroupLoopedModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__GroupLoopedModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2904:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2905:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2905:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2906:1: ( 'synchronized' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2907:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2908:1: 'synchronized'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_26860); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2923:1: rule__GroupLoopedModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__GroupLoopedModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2927:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2928:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2928:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2929:1: ( 'abstract' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2930:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2931:1: 'abstract'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_06904); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2946:1: rule__GroupLoopedModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__GroupLoopedModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2950:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2951:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2951:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2952:1: ( 'final' )
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2953:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2954:1: 'final'
            {
             before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_16948); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2969:1: rule__GroupLoopedModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__GroupLoopedModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2973:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2975:1: RULE_ID
            {
             before(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_26987); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2984:1: rule__LoopedAlternativeModel__VisibilityAssignment_0_0 : ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) ) ;
    public final void rule__LoopedAlternativeModel__VisibilityAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2988:1: ( ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2989:1: ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2989:1: ( ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2990:1: ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAlternatives_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2991:1: ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2991:2: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_07018);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3000:1: rule__LoopedAlternativeModel__StaticAssignment_0_1 : ( ( 'static' ) ) ;
    public final void rule__LoopedAlternativeModel__StaticAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3004:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3005:1: ( ( 'static' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3005:1: ( ( 'static' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3006:1: ( 'static' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3007:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:1: 'static'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_17056); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3023:1: rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 : ( ( 'synchronized' ) ) ;
    public final void rule__LoopedAlternativeModel__SynchronizedAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3027:1: ( ( ( 'synchronized' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3028:1: ( ( 'synchronized' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3028:1: ( ( 'synchronized' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3029:1: ( 'synchronized' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3031:1: 'synchronized'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_27100); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3046:1: rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 : ( ( 'abstract' ) ) ;
    public final void rule__LoopedAlternativeModel__AbstractAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3050:1: ( ( ( 'abstract' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3051:1: ( ( 'abstract' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3051:1: ( ( 'abstract' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:1: ( 'abstract' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3053:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3054:1: 'abstract'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_07144); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3069:1: rule__LoopedAlternativeModel__FinalAssignment_0_3_1 : ( ( 'final' ) ) ;
    public final void rule__LoopedAlternativeModel__FinalAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3073:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3075:1: ( 'final' )
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3076:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3077:1: 'final'
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_17188); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3092:1: rule__LoopedAlternativeModel__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__LoopedAlternativeModel__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3096:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3097:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3097:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3098:1: RULE_ID
            {
             before(grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_27227); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3107:1: rule__Bug304681Model__ShortDescriptionAssignment_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__ShortDescriptionAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3111:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3112:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3112:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3113:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_1_0_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_1_0_17258); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3122:1: rule__Bug304681Model__LongDescriptionAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__LongDescriptionAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3126:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3127:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3127:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3128:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_1_1_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_1_1_17289); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3137:1: rule__Bug304681Model__UidAssignment_1_2_1 : ( RULE_STRING ) ;
    public final void rule__Bug304681Model__UidAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3141:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3142:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3142:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3143:1: RULE_STRING
            {
             before(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_1_2_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_1_2_17320); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3152:1: rule__Bug304681Model__FlagAssignment_1_3_0 : ( ( 'flag' ) ) ;
    public final void rule__Bug304681Model__FlagAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3156:1: ( ( ( 'flag' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3157:1: ( ( 'flag' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3157:1: ( ( 'flag' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3158:1: ( 'flag' )
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_1_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3159:1: ( 'flag' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3160:1: 'flag'
            {
             before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_1_3_0_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_1_3_07356); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3175:1: rule__Bug304681Model__FeaturesAssignment_1_4 : ( ruleBug304681Feature ) ;
    public final void rule__Bug304681Model__FeaturesAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3179:1: ( ( ruleBug304681Feature ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3180:1: ( ruleBug304681Feature )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3180:1: ( ruleBug304681Feature )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3181:1: ruleBug304681Feature
            {
             before(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_1_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_1_47395);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3190:1: rule__Bug304681Attribute__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Bug304681Attribute__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3194:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3195:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3195:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3196:1: RULE_ID
            {
             before(grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_17426); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3205:1: rule__Bug304681Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Bug304681Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3209:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3210:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3210:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3211:1: RULE_ID
            {
             before(grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_17457); 
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
        public static final BitSet FOLLOW_14_in_rule__Model__Group_0__01580 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__11618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_1__01657 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__11695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__Group_2__01734 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__11772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__Group_3__01811 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__11849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Model__Group_4__01888 = new BitSet(new long[]{0x0000000780903800L});
        public static final BitSet FOLLOW_rule__Model__Group_4__1_in_rule__Model__Group_4__01898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FifthAssignment_4_1_in_rule__Model__Group_4__11926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Model__Group_5__01965 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Model__Group_5__1_in_rule__Model__Group_5__01975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ModelAssignment_5_1_in_rule__Model__Group_5__12003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__02041 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__02050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SimpleModel__Group__12079 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__12089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__22117 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__22126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SimpleModel__Group__32155 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__32165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SimpleModel__Group__42194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__02239 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__02248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__MandatoryModel__Group__12277 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__12287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__22315 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__22324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MandatoryModel__Group__32353 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__32363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__MandatoryModel__Group__42392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__02437 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__02446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LoopedModel__Group__12475 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__12485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__22513 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__22522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LoopedModel__Group__32551 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__32561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LoopedModel__Group__42590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__02635 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__02645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__GroupLoopedModel__Group__12674 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__12684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__22712 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__22721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__GroupLoopedModel__Group__32750 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__32760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__GroupLoopedModel__Group__42789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_in_rule__LoopedAlternativeModel__Group__02834 = new BitSet(new long[]{0x0000000780903800L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__1_in_rule__LoopedAlternativeModel__Group__02844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LoopedAlternativeModel__Group__12873 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__2_in_rule__LoopedAlternativeModel__Group__12883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__NameAssignment_2_in_rule__LoopedAlternativeModel__Group__22911 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__3_in_rule__LoopedAlternativeModel__Group__22920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LoopedAlternativeModel__Group__32949 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__4_in_rule__LoopedAlternativeModel__Group__32959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LoopedAlternativeModel__Group__42988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LoopedAlternativeModel__Group_0_4__03034 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1_in_rule__LoopedAlternativeModel__Group_0_4__03044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LoopedAlternativeModel__Group_0_4__13074 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_21_in_rule__Bug304681Model__Group__03116 = new BitSet(new long[]{0x000000087A400000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__1_in_rule__Bug304681Model__Group__03126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_1_in_rule__Bug304681Model__Group__13154 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__13163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Bug304681Model__Group__23192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Bug304681Model__Group_1_0__03234 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__1_in_rule__Bug304681Model__Group_1_0__03244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_1_0_1_in_rule__Bug304681Model__Group_1_0__13272 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__2_in_rule__Bug304681Model__Group_1_0__13281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_0__23310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Bug304681Model__Group_1_1__03352 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__1_in_rule__Bug304681Model__Group_1_1__03362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_1_1_1_in_rule__Bug304681Model__Group_1_1__13390 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__2_in_rule__Bug304681Model__Group_1_1__13399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_1__23428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Bug304681Model__Group_1_2__03470 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__1_in_rule__Bug304681Model__Group_1_2__03480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UidAssignment_1_2_1_in_rule__Bug304681Model__Group_1_2__13508 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__2_in_rule__Bug304681Model__Group_1_2__13517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_2__23546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FlagAssignment_1_3_0_in_rule__Bug304681Model__Group_1_3__03587 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_3__1_in_rule__Bug304681Model__Group_1_3__03596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_1_3__13625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__Bug304681Attribute__Group__03665 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__03675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__13703 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__13712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Attribute__Group__23741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Bug304681Reference__Group__03783 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__03793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__13821 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__13830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Reference__Group__23859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_03947 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_04031 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_04115 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_04199 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_04322 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_04406 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_04490 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_04574 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_04703 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_04787 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_04871 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_04955 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_05078 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_05162 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_05246 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_05330 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_0__0_in_rule__Bug304681Model__UnorderedGroup_15459 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_1__0_in_rule__Bug304681Model__UnorderedGroup_15543 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_2__0_in_rule__Bug304681Model__UnorderedGroup_15627 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_1_3__0_in_rule__Bug304681Model__UnorderedGroup_15711 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_1_4_in_rule__Bug304681Model__UnorderedGroup_15795 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_15872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_15903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_15934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_15965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_15996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_16027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_06058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_16096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_26140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_06184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_16228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_26267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_06298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_16336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_26380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_06424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_16468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_26507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_06538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_16576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_26620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_06664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_16708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_26747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_06778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_16816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_26860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_06904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_16948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_26987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_07018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_17056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_27100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_07144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_17188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_27227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_1_0_17258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_1_1_17289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_1_2_17320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_1_3_07356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_1_47395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_17426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_17457 = new BitSet(new long[]{0x0000000000000002L});
    }


}