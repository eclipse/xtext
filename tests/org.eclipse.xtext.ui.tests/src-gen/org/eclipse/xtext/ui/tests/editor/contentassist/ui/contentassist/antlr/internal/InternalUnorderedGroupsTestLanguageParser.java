package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public'", "'private'", "'protected'", "'1'", "'2'", "'3'", "'4'", "'5'", "'bug304681'", "'class'", "'{'", "'}'", "'before'", "'after'", "'short'", "';'", "'long'", "'uid'", "'attr'", "'ref'", "'static'", "'synchronized'", "'abstract'", "'final'", "'flag'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnorderedGroupsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnorderedGroupsTestLanguageParser.tokenNames; }
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




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:63:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel67);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel74); if (state.failed) return ;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:77:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:77:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel100);
            rule__Model__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getAlternatives()); 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSimpleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:89:1: entryRuleSimpleModel : ruleSimpleModel EOF ;
    public final void entryRuleSimpleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:90:1: ( ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:91:1: ruleSimpleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel127);
            ruleSimpleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleModel134); if (state.failed) return ;

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
    // $ANTLR end "entryRuleSimpleModel"


    // $ANTLR start "ruleSimpleModel"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:105:1: ( rule__SimpleModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:105:2: rule__SimpleModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__0_in_ruleSimpleModel160);
            rule__SimpleModel__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getGroup()); 
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
    // $ANTLR end "ruleSimpleModel"


    // $ANTLR start "entryRuleMandatoryModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:117:1: entryRuleMandatoryModel : ruleMandatoryModel EOF ;
    public final void entryRuleMandatoryModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:118:1: ( ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:119:1: ruleMandatoryModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel187);
            ruleMandatoryModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryModel194); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMandatoryModel"


    // $ANTLR start "ruleMandatoryModel"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:133:1: ( rule__MandatoryModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:133:2: rule__MandatoryModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__0_in_ruleMandatoryModel220);
            rule__MandatoryModel__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getGroup()); 
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
    // $ANTLR end "ruleMandatoryModel"


    // $ANTLR start "entryRuleLoopedModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:145:1: entryRuleLoopedModel : ruleLoopedModel EOF ;
    public final void entryRuleLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:146:1: ( ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:147:1: ruleLoopedModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel247);
            ruleLoopedModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedModel254); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLoopedModel"


    // $ANTLR start "ruleLoopedModel"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:161:1: ( rule__LoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:161:2: rule__LoopedModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__0_in_ruleLoopedModel280);
            rule__LoopedModel__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getGroup()); 
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
    // $ANTLR end "ruleLoopedModel"


    // $ANTLR start "entryRuleGroupLoopedModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:173:1: entryRuleGroupLoopedModel : ruleGroupLoopedModel EOF ;
    public final void entryRuleGroupLoopedModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:174:1: ( ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:175:1: ruleGroupLoopedModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel307);
            ruleGroupLoopedModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupLoopedModel314); if (state.failed) return ;

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
    // $ANTLR end "entryRuleGroupLoopedModel"


    // $ANTLR start "ruleGroupLoopedModel"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:189:1: ( rule__GroupLoopedModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:189:2: rule__GroupLoopedModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__0_in_ruleGroupLoopedModel340);
            rule__GroupLoopedModel__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getGroup()); 
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
    // $ANTLR end "ruleGroupLoopedModel"


    // $ANTLR start "entryRuleLoopedAlternativeModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:201:1: entryRuleLoopedAlternativeModel : ruleLoopedAlternativeModel EOF ;
    public final void entryRuleLoopedAlternativeModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:202:1: ( ruleLoopedAlternativeModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:203:1: ruleLoopedAlternativeModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel367);
            ruleLoopedAlternativeModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedAlternativeModel374); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLoopedAlternativeModel"


    // $ANTLR start "ruleLoopedAlternativeModel"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:217:1: ( rule__LoopedAlternativeModel__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:217:2: rule__LoopedAlternativeModel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__0_in_ruleLoopedAlternativeModel400);
            rule__LoopedAlternativeModel__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getGroup()); 
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
    // $ANTLR end "ruleLoopedAlternativeModel"


    // $ANTLR start "entryRuleBug304681Model"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:229:1: entryRuleBug304681Model : ruleBug304681Model EOF ;
    public final void entryRuleBug304681Model() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:230:1: ( ruleBug304681Model EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:231:1: ruleBug304681Model EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model427);
            ruleBug304681Model();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Model434); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBug304681Model"


    // $ANTLR start "ruleBug304681Model"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:245:1: ( rule__Bug304681Model__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:245:2: rule__Bug304681Model__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__0_in_ruleBug304681Model460);
            rule__Bug304681Model__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getGroup()); 
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
    // $ANTLR end "ruleBug304681Model"


    // $ANTLR start "entryRuleBug304681Feature"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:257:1: entryRuleBug304681Feature : ruleBug304681Feature EOF ;
    public final void entryRuleBug304681Feature() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:258:1: ( ruleBug304681Feature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:259:1: ruleBug304681Feature EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681FeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature487);
            ruleBug304681Feature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681FeatureRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Feature494); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBug304681Feature"


    // $ANTLR start "ruleBug304681Feature"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681FeatureAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:273:1: ( rule__Bug304681Feature__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:273:2: rule__Bug304681Feature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Feature__Alternatives_in_ruleBug304681Feature520);
            rule__Bug304681Feature__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681FeatureAccess().getAlternatives()); 
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
    // $ANTLR end "ruleBug304681Feature"


    // $ANTLR start "entryRuleBug304681Attribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:285:1: entryRuleBug304681Attribute : ruleBug304681Attribute EOF ;
    public final void entryRuleBug304681Attribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:286:1: ( ruleBug304681Attribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:287:1: ruleBug304681Attribute EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681AttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute547);
            ruleBug304681Attribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681AttributeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Attribute554); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBug304681Attribute"


    // $ANTLR start "ruleBug304681Attribute"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681AttributeAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:301:1: ( rule__Bug304681Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:301:2: rule__Bug304681Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__0_in_ruleBug304681Attribute580);
            rule__Bug304681Attribute__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681AttributeAccess().getGroup()); 
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
    // $ANTLR end "ruleBug304681Attribute"


    // $ANTLR start "entryRuleBug304681Reference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:313:1: entryRuleBug304681Reference : ruleBug304681Reference EOF ;
    public final void entryRuleBug304681Reference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:314:1: ( ruleBug304681Reference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ruleBug304681Reference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference607);
            ruleBug304681Reference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ReferenceRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Reference614); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBug304681Reference"


    // $ANTLR start "ruleBug304681Reference"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ReferenceAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:329:1: ( rule__Bug304681Reference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:329:2: rule__Bug304681Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__0_in_ruleBug304681Reference640);
            rule__Bug304681Reference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ReferenceAccess().getGroup()); 
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
    // $ANTLR end "ruleBug304681Reference"


    // $ANTLR start "rule__Model__Alternatives"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:346:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:346:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:347:1: ( rule__Model__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:348:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:348:2: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives676);
                    rule__Model__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:352:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:352:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:353:1: ( rule__Model__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:354:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:354:2: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives694);
                    rule__Model__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:358:6: ( ( rule__Model__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:358:6: ( ( rule__Model__Group_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:359:1: ( rule__Model__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:360:1: ( rule__Model__Group_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:360:2: rule__Model__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives712);
                    rule__Model__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:364:6: ( ( rule__Model__Group_3__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:364:6: ( ( rule__Model__Group_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:365:1: ( rule__Model__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:366:1: ( rule__Model__Group_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:366:2: rule__Model__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives730);
                    rule__Model__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:6: ( ( rule__Model__Group_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:370:6: ( ( rule__Model__Group_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:371:1: ( rule__Model__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_4()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:372:1: ( rule__Model__Group_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:372:2: rule__Model__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__0_in_rule__Model__Alternatives748);
                    rule__Model__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:376:6: ( ( rule__Model__Group_5__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:376:6: ( ( rule__Model__Group_5__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:377:1: ( rule__Model__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_5()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:378:1: ( rule__Model__Group_5__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:378:2: rule__Model__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__0_in_rule__Model__Alternatives766);
                    rule__Model__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_5()); 
                    }

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
    // $ANTLR end "rule__Model__Alternatives"


    // $ANTLR start "rule__SimpleModel__VisibilityAlternatives_0_0_0"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:392:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:392:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:393:1: 'public'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__SimpleModel__VisibilityAlternatives_0_0_0800); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:400:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:400:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:401:1: 'private'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__SimpleModel__VisibilityAlternatives_0_0_0820); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:408:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:408:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:409:1: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__SimpleModel__VisibilityAlternatives_0_0_0840); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }

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
    // $ANTLR end "rule__SimpleModel__VisibilityAlternatives_0_0_0"


    // $ANTLR start "rule__SimpleModel__Alternatives_0_3"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:426:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:426:1: ( ( rule__SimpleModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:427:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:428:1: ( rule__SimpleModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:428:2: rule__SimpleModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__AbstractAssignment_0_3_0_in_rule__SimpleModel__Alternatives_0_3874);
                    rule__SimpleModel__AbstractAssignment_0_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:432:6: ( ( rule__SimpleModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:433:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:434:1: ( rule__SimpleModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:434:2: rule__SimpleModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__FinalAssignment_0_3_1_in_rule__SimpleModel__Alternatives_0_3892);
                    rule__SimpleModel__FinalAssignment_0_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1()); 
                    }

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
    // $ANTLR end "rule__SimpleModel__Alternatives_0_3"


    // $ANTLR start "rule__MandatoryModel__VisibilityAlternatives_0_0_0"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:449:1: 'public'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0926); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:456:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:456:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:457:1: 'private'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0946); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:464:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:464:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:465:1: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0966); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }

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
    // $ANTLR end "rule__MandatoryModel__VisibilityAlternatives_0_0_0"


    // $ANTLR start "rule__MandatoryModel__Alternatives_0_3"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:482:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:482:1: ( ( rule__MandatoryModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:483:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:484:1: ( rule__MandatoryModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:484:2: rule__MandatoryModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__AbstractAssignment_0_3_0_in_rule__MandatoryModel__Alternatives_0_31000);
                    rule__MandatoryModel__AbstractAssignment_0_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:488:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:488:6: ( ( rule__MandatoryModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:489:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:490:1: ( rule__MandatoryModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:490:2: rule__MandatoryModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__FinalAssignment_0_3_1_in_rule__MandatoryModel__Alternatives_0_31018);
                    rule__MandatoryModel__FinalAssignment_0_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1()); 
                    }

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
    // $ANTLR end "rule__MandatoryModel__Alternatives_0_3"


    // $ANTLR start "rule__LoopedModel__VisibilityAlternatives_0_0_0"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:504:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:504:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:505:1: 'public'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LoopedModel__VisibilityAlternatives_0_0_01052); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:512:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:512:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:513:1: 'private'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__LoopedModel__VisibilityAlternatives_0_0_01072); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:520:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:520:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:521:1: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__LoopedModel__VisibilityAlternatives_0_0_01092); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }

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
    // $ANTLR end "rule__LoopedModel__VisibilityAlternatives_0_0_0"


    // $ANTLR start "rule__LoopedModel__Alternatives_0_3"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:538:1: ( ( rule__LoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:539:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:540:1: ( rule__LoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:540:2: rule__LoopedModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__AbstractAssignment_0_3_0_in_rule__LoopedModel__Alternatives_0_31126);
                    rule__LoopedModel__AbstractAssignment_0_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:544:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:544:6: ( ( rule__LoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:545:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:546:1: ( rule__LoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:546:2: rule__LoopedModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__FinalAssignment_0_3_1_in_rule__LoopedModel__Alternatives_0_31144);
                    rule__LoopedModel__FinalAssignment_0_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    }

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
    // $ANTLR end "rule__LoopedModel__Alternatives_0_3"


    // $ANTLR start "rule__GroupLoopedModel__VisibilityAlternatives_0_0_0"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:560:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:560:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:561:1: 'public'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01178); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:568:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:569:1: 'private'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01198); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:576:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:576:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:577:1: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01218); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }

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
    // $ANTLR end "rule__GroupLoopedModel__VisibilityAlternatives_0_0_0"


    // $ANTLR start "rule__GroupLoopedModel__Alternatives_0_3"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:594:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:594:1: ( ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:595:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:596:1: ( rule__GroupLoopedModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:596:2: rule__GroupLoopedModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__AbstractAssignment_0_3_0_in_rule__GroupLoopedModel__Alternatives_0_31252);
                    rule__GroupLoopedModel__AbstractAssignment_0_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:600:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:600:6: ( ( rule__GroupLoopedModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:601:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:602:1: ( rule__GroupLoopedModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:602:2: rule__GroupLoopedModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__FinalAssignment_0_3_1_in_rule__GroupLoopedModel__Alternatives_0_31270);
                    rule__GroupLoopedModel__FinalAssignment_0_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1()); 
                    }

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
    // $ANTLR end "rule__GroupLoopedModel__Alternatives_0_3"


    // $ANTLR start "rule__LoopedAlternativeModel__Alternatives_0"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:616:1: ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:616:1: ( ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:617:1: ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAssignment_0_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:618:1: ( rule__LoopedAlternativeModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:618:2: rule__LoopedAlternativeModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__VisibilityAssignment_0_0_in_rule__LoopedAlternativeModel__Alternatives_01303);
                    rule__LoopedAlternativeModel__VisibilityAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:622:6: ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:622:6: ( ( rule__LoopedAlternativeModel__StaticAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:623:1: ( rule__LoopedAlternativeModel__StaticAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getStaticAssignment_0_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:624:1: ( rule__LoopedAlternativeModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:624:2: rule__LoopedAlternativeModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__StaticAssignment_0_1_in_rule__LoopedAlternativeModel__Alternatives_01321);
                    rule__LoopedAlternativeModel__StaticAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getStaticAssignment_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:628:6: ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:628:6: ( ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:629:1: ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedAssignment_0_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:630:1: ( rule__LoopedAlternativeModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:630:2: rule__LoopedAlternativeModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__SynchronizedAssignment_0_2_in_rule__LoopedAlternativeModel__Alternatives_01339);
                    rule__LoopedAlternativeModel__SynchronizedAssignment_0_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedAssignment_0_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:634:6: ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:634:6: ( ( rule__LoopedAlternativeModel__Alternatives_0_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:1: ( rule__LoopedAlternativeModel__Alternatives_0_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:1: ( rule__LoopedAlternativeModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:636:2: rule__LoopedAlternativeModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_3_in_rule__LoopedAlternativeModel__Alternatives_01357);
                    rule__LoopedAlternativeModel__Alternatives_0_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:640:6: ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:640:6: ( ( rule__LoopedAlternativeModel__Group_0_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:641:1: ( rule__LoopedAlternativeModel__Group_0_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getGroup_0_4()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:642:1: ( rule__LoopedAlternativeModel__Group_0_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:642:2: rule__LoopedAlternativeModel__Group_0_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0_in_rule__LoopedAlternativeModel__Alternatives_01375);
                    rule__LoopedAlternativeModel__Group_0_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getGroup_0_4()); 
                    }

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
    // $ANTLR end "rule__LoopedAlternativeModel__Alternatives_0"


    // $ANTLR start "rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:656:1: ( 'public' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:656:1: ( 'public' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:657:1: 'public'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01409); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:6: ( 'private' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:6: ( 'private' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:665:1: 'private'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01429); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:672:6: ( 'protected' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:672:6: ( 'protected' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:673:1: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01449); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityProtectedKeyword_0_0_0_2()); 
                    }

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
    // $ANTLR end "rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0"


    // $ANTLR start "rule__LoopedAlternativeModel__Alternatives_0_3"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:690:1: ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:690:1: ( ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:691:1: ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAssignment_0_3_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:692:1: ( rule__LoopedAlternativeModel__AbstractAssignment_0_3_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:692:2: rule__LoopedAlternativeModel__AbstractAssignment_0_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__AbstractAssignment_0_3_0_in_rule__LoopedAlternativeModel__Alternatives_0_31483);
                    rule__LoopedAlternativeModel__AbstractAssignment_0_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAssignment_0_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:6: ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:6: ( ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:1: ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedAlternativeModelAccess().getFinalAssignment_0_3_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:1: ( rule__LoopedAlternativeModel__FinalAssignment_0_3_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:2: rule__LoopedAlternativeModel__FinalAssignment_0_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__FinalAssignment_0_3_1_in_rule__LoopedAlternativeModel__Alternatives_0_31501);
                    rule__LoopedAlternativeModel__FinalAssignment_0_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedAlternativeModelAccess().getFinalAssignment_0_3_1()); 
                    }

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
    // $ANTLR end "rule__LoopedAlternativeModel__Alternatives_0_3"


    // $ANTLR start "rule__Bug304681Feature__Alternatives"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:712:1: ( ruleBug304681Attribute )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:712:1: ( ruleBug304681Attribute )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:713:1: ruleBug304681Attribute
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_rule__Bug304681Feature__Alternatives1534);
                    ruleBug304681Attribute();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:718:6: ( ruleBug304681Reference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:718:6: ( ruleBug304681Reference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:719:1: ruleBug304681Reference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_rule__Bug304681Feature__Alternatives1551);
                    ruleBug304681Reference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__Bug304681Feature__Alternatives"


    // $ANTLR start "rule__Model__Group_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:731:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__01581);
            rule__Model__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01584);
            rule__Model__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__0"


    // $ANTLR start "rule__Model__Group_0__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_0__0__Impl1612); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
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
    // $ANTLR end "rule__Model__Group_0__0__Impl"


    // $ANTLR start "rule__Model__Group_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:762:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:766:1: ( rule__Model__Group_0__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:767:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__11643);
            rule__Model__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_0__1"


    // $ANTLR start "rule__Model__Group_0__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getFirstAssignment_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:780:1: ( rule__Model__FirstAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:780:2: rule__Model__FirstAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__1__Impl1670);
            rule__Model__FirstAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getFirstAssignment_0_1()); 
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
    // $ANTLR end "rule__Model__Group_0__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:794:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:798:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:799:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__01704);
            rule__Model__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01707);
            rule__Model__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_1__0__Impl1735); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
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
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:825:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:829:1: ( rule__Model__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:830:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11766);
            rule__Model__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSecondAssignment_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:843:1: ( rule__Model__SecondAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:843:2: rule__Model__SecondAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__1__Impl1793);
            rule__Model__SecondAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSecondAssignment_1_1()); 
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
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__Model__Group_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:857:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:861:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:862:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__01827);
            rule__Model__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01830);
            rule__Model__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0"


    // $ANTLR start "rule__Model__Group_2__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__Group_2__0__Impl1858); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitThreeKeyword_2_0()); 
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
    // $ANTLR end "rule__Model__Group_2__0__Impl"


    // $ANTLR start "rule__Model__Group_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:888:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:892:1: ( rule__Model__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:893:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__11889);
            rule__Model__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1"


    // $ANTLR start "rule__Model__Group_2__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getThrirdAssignment_2_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:906:1: ( rule__Model__ThrirdAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:906:2: rule__Model__ThrirdAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__1__Impl1916);
            rule__Model__ThrirdAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getThrirdAssignment_2_1()); 
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
    // $ANTLR end "rule__Model__Group_2__1__Impl"


    // $ANTLR start "rule__Model__Group_3__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:920:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:924:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:925:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__0__Impl_in_rule__Model__Group_3__01950);
            rule__Model__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01953);
            rule__Model__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__0"


    // $ANTLR start "rule__Model__Group_3__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__Group_3__0__Impl1981); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitFourKeyword_3_0()); 
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
    // $ANTLR end "rule__Model__Group_3__0__Impl"


    // $ANTLR start "rule__Model__Group_3__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:951:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:955:1: ( rule__Model__Group_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:956:2: rule__Model__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__1__Impl_in_rule__Model__Group_3__12012);
            rule__Model__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__1"


    // $ANTLR start "rule__Model__Group_3__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getForthAssignment_3_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:969:1: ( rule__Model__ForthAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:969:2: rule__Model__ForthAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__1__Impl2039);
            rule__Model__ForthAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getForthAssignment_3_1()); 
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
    // $ANTLR end "rule__Model__Group_3__1__Impl"


    // $ANTLR start "rule__Model__Group_4__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:983:1: rule__Model__Group_4__0 : rule__Model__Group_4__0__Impl rule__Model__Group_4__1 ;
    public final void rule__Model__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:987:1: ( rule__Model__Group_4__0__Impl rule__Model__Group_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:988:2: rule__Model__Group_4__0__Impl rule__Model__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__0__Impl_in_rule__Model__Group_4__02073);
            rule__Model__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__1_in_rule__Model__Group_4__02076);
            rule__Model__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__0"


    // $ANTLR start "rule__Model__Group_4__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Model__Group_4__0__Impl2104); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitFiveKeyword_4_0()); 
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
    // $ANTLR end "rule__Model__Group_4__0__Impl"


    // $ANTLR start "rule__Model__Group_4__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1014:1: rule__Model__Group_4__1 : rule__Model__Group_4__1__Impl ;
    public final void rule__Model__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: ( rule__Model__Group_4__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:2: rule__Model__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_4__1__Impl_in_rule__Model__Group_4__12135);
            rule__Model__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__1"


    // $ANTLR start "rule__Model__Group_4__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getFifthAssignment_4_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1032:1: ( rule__Model__FifthAssignment_4_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1032:2: rule__Model__FifthAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__FifthAssignment_4_1_in_rule__Model__Group_4__1__Impl2162);
            rule__Model__FifthAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getFifthAssignment_4_1()); 
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
    // $ANTLR end "rule__Model__Group_4__1__Impl"


    // $ANTLR start "rule__Model__Group_5__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1046:1: rule__Model__Group_5__0 : rule__Model__Group_5__0__Impl rule__Model__Group_5__1 ;
    public final void rule__Model__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1050:1: ( rule__Model__Group_5__0__Impl rule__Model__Group_5__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1051:2: rule__Model__Group_5__0__Impl rule__Model__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__0__Impl_in_rule__Model__Group_5__02196);
            rule__Model__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__1_in_rule__Model__Group_5__02199);
            rule__Model__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_5__0"


    // $ANTLR start "rule__Model__Group_5__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getBug304681Keyword_5_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Model__Group_5__0__Impl2227); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getBug304681Keyword_5_0()); 
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
    // $ANTLR end "rule__Model__Group_5__0__Impl"


    // $ANTLR start "rule__Model__Group_5__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1077:1: rule__Model__Group_5__1 : rule__Model__Group_5__1__Impl ;
    public final void rule__Model__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1081:1: ( rule__Model__Group_5__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1082:2: rule__Model__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_5__1__Impl_in_rule__Model__Group_5__12258);
            rule__Model__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_5__1"


    // $ANTLR start "rule__Model__Group_5__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getModelAssignment_5_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1095:1: ( rule__Model__ModelAssignment_5_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1095:2: rule__Model__ModelAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ModelAssignment_5_1_in_rule__Model__Group_5__1__Impl2285);
            rule__Model__ModelAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getModelAssignment_5_1()); 
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
    // $ANTLR end "rule__Model__Group_5__1__Impl"


    // $ANTLR start "rule__SimpleModel__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1109:1: rule__SimpleModel__Group__0 : rule__SimpleModel__Group__0__Impl rule__SimpleModel__Group__1 ;
    public final void rule__SimpleModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1113:1: ( rule__SimpleModel__Group__0__Impl rule__SimpleModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1114:2: rule__SimpleModel__Group__0__Impl rule__SimpleModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__0__Impl_in_rule__SimpleModel__Group__02319);
            rule__SimpleModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__02322);
            rule__SimpleModel__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleModel__Group__0"


    // $ANTLR start "rule__SimpleModel__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1128:1: ( rule__SimpleModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1128:2: rule__SimpleModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__0__Impl2349);
            rule__SimpleModel__UnorderedGroup_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()); 
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
    // $ANTLR end "rule__SimpleModel__Group__0__Impl"


    // $ANTLR start "rule__SimpleModel__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1138:1: rule__SimpleModel__Group__1 : rule__SimpleModel__Group__1__Impl rule__SimpleModel__Group__2 ;
    public final void rule__SimpleModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1142:1: ( rule__SimpleModel__Group__1__Impl rule__SimpleModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1143:2: rule__SimpleModel__Group__1__Impl rule__SimpleModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__1__Impl_in_rule__SimpleModel__Group__12379);
            rule__SimpleModel__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__12382);
            rule__SimpleModel__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleModel__Group__1"


    // $ANTLR start "rule__SimpleModel__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__SimpleModel__Group__1__Impl2410); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getClassKeyword_1()); 
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
    // $ANTLR end "rule__SimpleModel__Group__1__Impl"


    // $ANTLR start "rule__SimpleModel__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1169:1: rule__SimpleModel__Group__2 : rule__SimpleModel__Group__2__Impl rule__SimpleModel__Group__3 ;
    public final void rule__SimpleModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1173:1: ( rule__SimpleModel__Group__2__Impl rule__SimpleModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1174:2: rule__SimpleModel__Group__2__Impl rule__SimpleModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__2__Impl_in_rule__SimpleModel__Group__22441);
            rule__SimpleModel__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__22444);
            rule__SimpleModel__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleModel__Group__2"


    // $ANTLR start "rule__SimpleModel__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1188:1: ( rule__SimpleModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1188:2: rule__SimpleModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__2__Impl2471);
            rule__SimpleModel__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__SimpleModel__Group__2__Impl"


    // $ANTLR start "rule__SimpleModel__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1198:1: rule__SimpleModel__Group__3 : rule__SimpleModel__Group__3__Impl rule__SimpleModel__Group__4 ;
    public final void rule__SimpleModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1202:1: ( rule__SimpleModel__Group__3__Impl rule__SimpleModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1203:2: rule__SimpleModel__Group__3__Impl rule__SimpleModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__3__Impl_in_rule__SimpleModel__Group__32501);
            rule__SimpleModel__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__32504);
            rule__SimpleModel__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleModel__Group__3"


    // $ANTLR start "rule__SimpleModel__Group__3__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__SimpleModel__Group__3__Impl2532); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__SimpleModel__Group__3__Impl"


    // $ANTLR start "rule__SimpleModel__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:1: rule__SimpleModel__Group__4 : rule__SimpleModel__Group__4__Impl ;
    public final void rule__SimpleModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:1: ( rule__SimpleModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:2: rule__SimpleModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Group__4__Impl_in_rule__SimpleModel__Group__42563);
            rule__SimpleModel__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleModel__Group__4"


    // $ANTLR start "rule__SimpleModel__Group__4__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__SimpleModel__Group__4__Impl2591); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__SimpleModel__Group__4__Impl"


    // $ANTLR start "rule__MandatoryModel__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1269:1: rule__MandatoryModel__Group__0 : rule__MandatoryModel__Group__0__Impl rule__MandatoryModel__Group__1 ;
    public final void rule__MandatoryModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1273:1: ( rule__MandatoryModel__Group__0__Impl rule__MandatoryModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1274:2: rule__MandatoryModel__Group__0__Impl rule__MandatoryModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__0__Impl_in_rule__MandatoryModel__Group__02632);
            rule__MandatoryModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__02635);
            rule__MandatoryModel__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryModel__Group__0"


    // $ANTLR start "rule__MandatoryModel__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1288:1: ( rule__MandatoryModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1288:2: rule__MandatoryModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__0__Impl2662);
            rule__MandatoryModel__UnorderedGroup_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()); 
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
    // $ANTLR end "rule__MandatoryModel__Group__0__Impl"


    // $ANTLR start "rule__MandatoryModel__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1298:1: rule__MandatoryModel__Group__1 : rule__MandatoryModel__Group__1__Impl rule__MandatoryModel__Group__2 ;
    public final void rule__MandatoryModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1302:1: ( rule__MandatoryModel__Group__1__Impl rule__MandatoryModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1303:2: rule__MandatoryModel__Group__1__Impl rule__MandatoryModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__1__Impl_in_rule__MandatoryModel__Group__12692);
            rule__MandatoryModel__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__12695);
            rule__MandatoryModel__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryModel__Group__1"


    // $ANTLR start "rule__MandatoryModel__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__MandatoryModel__Group__1__Impl2723); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getClassKeyword_1()); 
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
    // $ANTLR end "rule__MandatoryModel__Group__1__Impl"


    // $ANTLR start "rule__MandatoryModel__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1329:1: rule__MandatoryModel__Group__2 : rule__MandatoryModel__Group__2__Impl rule__MandatoryModel__Group__3 ;
    public final void rule__MandatoryModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1333:1: ( rule__MandatoryModel__Group__2__Impl rule__MandatoryModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1334:2: rule__MandatoryModel__Group__2__Impl rule__MandatoryModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__2__Impl_in_rule__MandatoryModel__Group__22754);
            rule__MandatoryModel__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__22757);
            rule__MandatoryModel__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryModel__Group__2"


    // $ANTLR start "rule__MandatoryModel__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1348:1: ( rule__MandatoryModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1348:2: rule__MandatoryModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__2__Impl2784);
            rule__MandatoryModel__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__MandatoryModel__Group__2__Impl"


    // $ANTLR start "rule__MandatoryModel__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1358:1: rule__MandatoryModel__Group__3 : rule__MandatoryModel__Group__3__Impl rule__MandatoryModel__Group__4 ;
    public final void rule__MandatoryModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1362:1: ( rule__MandatoryModel__Group__3__Impl rule__MandatoryModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1363:2: rule__MandatoryModel__Group__3__Impl rule__MandatoryModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__3__Impl_in_rule__MandatoryModel__Group__32814);
            rule__MandatoryModel__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__32817);
            rule__MandatoryModel__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryModel__Group__3"


    // $ANTLR start "rule__MandatoryModel__Group__3__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__MandatoryModel__Group__3__Impl2845); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__MandatoryModel__Group__3__Impl"


    // $ANTLR start "rule__MandatoryModel__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1389:1: rule__MandatoryModel__Group__4 : rule__MandatoryModel__Group__4__Impl ;
    public final void rule__MandatoryModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1393:1: ( rule__MandatoryModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1394:2: rule__MandatoryModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Group__4__Impl_in_rule__MandatoryModel__Group__42876);
            rule__MandatoryModel__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryModel__Group__4"


    // $ANTLR start "rule__MandatoryModel__Group__4__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__MandatoryModel__Group__4__Impl2904); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__MandatoryModel__Group__4__Impl"


    // $ANTLR start "rule__LoopedModel__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1429:1: rule__LoopedModel__Group__0 : rule__LoopedModel__Group__0__Impl rule__LoopedModel__Group__1 ;
    public final void rule__LoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1433:1: ( rule__LoopedModel__Group__0__Impl rule__LoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1434:2: rule__LoopedModel__Group__0__Impl rule__LoopedModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__0__Impl_in_rule__LoopedModel__Group__02945);
            rule__LoopedModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__02948);
            rule__LoopedModel__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedModel__Group__0"


    // $ANTLR start "rule__LoopedModel__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1448:1: ( rule__LoopedModel__UnorderedGroup_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1448:2: rule__LoopedModel__UnorderedGroup_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__0__Impl2975);
            rule__LoopedModel__UnorderedGroup_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()); 
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
    // $ANTLR end "rule__LoopedModel__Group__0__Impl"


    // $ANTLR start "rule__LoopedModel__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1458:1: rule__LoopedModel__Group__1 : rule__LoopedModel__Group__1__Impl rule__LoopedModel__Group__2 ;
    public final void rule__LoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1462:1: ( rule__LoopedModel__Group__1__Impl rule__LoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1463:2: rule__LoopedModel__Group__1__Impl rule__LoopedModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__1__Impl_in_rule__LoopedModel__Group__13005);
            rule__LoopedModel__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__13008);
            rule__LoopedModel__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedModel__Group__1"


    // $ANTLR start "rule__LoopedModel__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LoopedModel__Group__1__Impl3036); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getClassKeyword_1()); 
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
    // $ANTLR end "rule__LoopedModel__Group__1__Impl"


    // $ANTLR start "rule__LoopedModel__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1489:1: rule__LoopedModel__Group__2 : rule__LoopedModel__Group__2__Impl rule__LoopedModel__Group__3 ;
    public final void rule__LoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1493:1: ( rule__LoopedModel__Group__2__Impl rule__LoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1494:2: rule__LoopedModel__Group__2__Impl rule__LoopedModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__2__Impl_in_rule__LoopedModel__Group__23067);
            rule__LoopedModel__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__23070);
            rule__LoopedModel__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedModel__Group__2"


    // $ANTLR start "rule__LoopedModel__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1508:1: ( rule__LoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1508:2: rule__LoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__2__Impl3097);
            rule__LoopedModel__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__LoopedModel__Group__2__Impl"


    // $ANTLR start "rule__LoopedModel__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1518:1: rule__LoopedModel__Group__3 : rule__LoopedModel__Group__3__Impl rule__LoopedModel__Group__4 ;
    public final void rule__LoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1522:1: ( rule__LoopedModel__Group__3__Impl rule__LoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1523:2: rule__LoopedModel__Group__3__Impl rule__LoopedModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__3__Impl_in_rule__LoopedModel__Group__33127);
            rule__LoopedModel__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__33130);
            rule__LoopedModel__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedModel__Group__3"


    // $ANTLR start "rule__LoopedModel__Group__3__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LoopedModel__Group__3__Impl3158); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__LoopedModel__Group__3__Impl"


    // $ANTLR start "rule__LoopedModel__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1549:1: rule__LoopedModel__Group__4 : rule__LoopedModel__Group__4__Impl ;
    public final void rule__LoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1553:1: ( rule__LoopedModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1554:2: rule__LoopedModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Group__4__Impl_in_rule__LoopedModel__Group__43189);
            rule__LoopedModel__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedModel__Group__4"


    // $ANTLR start "rule__LoopedModel__Group__4__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LoopedModel__Group__4__Impl3217); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__LoopedModel__Group__4__Impl"


    // $ANTLR start "rule__GroupLoopedModel__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1589:1: rule__GroupLoopedModel__Group__0 : rule__GroupLoopedModel__Group__0__Impl rule__GroupLoopedModel__Group__1 ;
    public final void rule__GroupLoopedModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1593:1: ( rule__GroupLoopedModel__Group__0__Impl rule__GroupLoopedModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1594:2: rule__GroupLoopedModel__Group__0__Impl rule__GroupLoopedModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__0__Impl_in_rule__GroupLoopedModel__Group__03258);
            rule__GroupLoopedModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__03261);
            rule__GroupLoopedModel__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupLoopedModel__Group__0"


    // $ANTLR start "rule__GroupLoopedModel__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1608:1: ( rule__GroupLoopedModel__UnorderedGroup_0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( LA14_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt14=1;
                }
                else if ( LA14_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1608:2: rule__GroupLoopedModel__UnorderedGroup_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__0__Impl3288);
            	    rule__GroupLoopedModel__UnorderedGroup_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()); 
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
    // $ANTLR end "rule__GroupLoopedModel__Group__0__Impl"


    // $ANTLR start "rule__GroupLoopedModel__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1618:1: rule__GroupLoopedModel__Group__1 : rule__GroupLoopedModel__Group__1__Impl rule__GroupLoopedModel__Group__2 ;
    public final void rule__GroupLoopedModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1622:1: ( rule__GroupLoopedModel__Group__1__Impl rule__GroupLoopedModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1623:2: rule__GroupLoopedModel__Group__1__Impl rule__GroupLoopedModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__1__Impl_in_rule__GroupLoopedModel__Group__13319);
            rule__GroupLoopedModel__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__13322);
            rule__GroupLoopedModel__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupLoopedModel__Group__1"


    // $ANTLR start "rule__GroupLoopedModel__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__GroupLoopedModel__Group__1__Impl3350); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1()); 
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
    // $ANTLR end "rule__GroupLoopedModel__Group__1__Impl"


    // $ANTLR start "rule__GroupLoopedModel__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1649:1: rule__GroupLoopedModel__Group__2 : rule__GroupLoopedModel__Group__2__Impl rule__GroupLoopedModel__Group__3 ;
    public final void rule__GroupLoopedModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1653:1: ( rule__GroupLoopedModel__Group__2__Impl rule__GroupLoopedModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1654:2: rule__GroupLoopedModel__Group__2__Impl rule__GroupLoopedModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__2__Impl_in_rule__GroupLoopedModel__Group__23381);
            rule__GroupLoopedModel__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__23384);
            rule__GroupLoopedModel__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupLoopedModel__Group__2"


    // $ANTLR start "rule__GroupLoopedModel__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1668:1: ( rule__GroupLoopedModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1668:2: rule__GroupLoopedModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__2__Impl3411);
            rule__GroupLoopedModel__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__GroupLoopedModel__Group__2__Impl"


    // $ANTLR start "rule__GroupLoopedModel__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1678:1: rule__GroupLoopedModel__Group__3 : rule__GroupLoopedModel__Group__3__Impl rule__GroupLoopedModel__Group__4 ;
    public final void rule__GroupLoopedModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1682:1: ( rule__GroupLoopedModel__Group__3__Impl rule__GroupLoopedModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:2: rule__GroupLoopedModel__Group__3__Impl rule__GroupLoopedModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__3__Impl_in_rule__GroupLoopedModel__Group__33441);
            rule__GroupLoopedModel__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__33444);
            rule__GroupLoopedModel__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupLoopedModel__Group__3"


    // $ANTLR start "rule__GroupLoopedModel__Group__3__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__GroupLoopedModel__Group__3__Impl3472); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__GroupLoopedModel__Group__3__Impl"


    // $ANTLR start "rule__GroupLoopedModel__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1709:1: rule__GroupLoopedModel__Group__4 : rule__GroupLoopedModel__Group__4__Impl ;
    public final void rule__GroupLoopedModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1713:1: ( rule__GroupLoopedModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1714:2: rule__GroupLoopedModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Group__4__Impl_in_rule__GroupLoopedModel__Group__43503);
            rule__GroupLoopedModel__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupLoopedModel__Group__4"


    // $ANTLR start "rule__GroupLoopedModel__Group__4__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__GroupLoopedModel__Group__4__Impl3531); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__GroupLoopedModel__Group__4__Impl"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1749:1: rule__LoopedAlternativeModel__Group__0 : rule__LoopedAlternativeModel__Group__0__Impl rule__LoopedAlternativeModel__Group__1 ;
    public final void rule__LoopedAlternativeModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1753:1: ( rule__LoopedAlternativeModel__Group__0__Impl rule__LoopedAlternativeModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1754:2: rule__LoopedAlternativeModel__Group__0__Impl rule__LoopedAlternativeModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__0__Impl_in_rule__LoopedAlternativeModel__Group__03572);
            rule__LoopedAlternativeModel__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__1_in_rule__LoopedAlternativeModel__Group__03575);
            rule__LoopedAlternativeModel__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedAlternativeModel__Group__0"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0()); 
            }
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
            	    pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_in_rule__LoopedAlternativeModel__Group__0__Impl3602);
            	    rule__LoopedAlternativeModel__Alternatives_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__Group__0__Impl"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1778:1: rule__LoopedAlternativeModel__Group__1 : rule__LoopedAlternativeModel__Group__1__Impl rule__LoopedAlternativeModel__Group__2 ;
    public final void rule__LoopedAlternativeModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1782:1: ( rule__LoopedAlternativeModel__Group__1__Impl rule__LoopedAlternativeModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1783:2: rule__LoopedAlternativeModel__Group__1__Impl rule__LoopedAlternativeModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__1__Impl_in_rule__LoopedAlternativeModel__Group__13633);
            rule__LoopedAlternativeModel__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__2_in_rule__LoopedAlternativeModel__Group__13636);
            rule__LoopedAlternativeModel__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedAlternativeModel__Group__1"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LoopedAlternativeModel__Group__1__Impl3664); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__Group__1__Impl"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1809:1: rule__LoopedAlternativeModel__Group__2 : rule__LoopedAlternativeModel__Group__2__Impl rule__LoopedAlternativeModel__Group__3 ;
    public final void rule__LoopedAlternativeModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1813:1: ( rule__LoopedAlternativeModel__Group__2__Impl rule__LoopedAlternativeModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1814:2: rule__LoopedAlternativeModel__Group__2__Impl rule__LoopedAlternativeModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__2__Impl_in_rule__LoopedAlternativeModel__Group__23695);
            rule__LoopedAlternativeModel__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__3_in_rule__LoopedAlternativeModel__Group__23698);
            rule__LoopedAlternativeModel__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedAlternativeModel__Group__2"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1828:1: ( rule__LoopedAlternativeModel__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1828:2: rule__LoopedAlternativeModel__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__NameAssignment_2_in_rule__LoopedAlternativeModel__Group__2__Impl3725);
            rule__LoopedAlternativeModel__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getNameAssignment_2()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__Group__2__Impl"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1838:1: rule__LoopedAlternativeModel__Group__3 : rule__LoopedAlternativeModel__Group__3__Impl rule__LoopedAlternativeModel__Group__4 ;
    public final void rule__LoopedAlternativeModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:1: ( rule__LoopedAlternativeModel__Group__3__Impl rule__LoopedAlternativeModel__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1843:2: rule__LoopedAlternativeModel__Group__3__Impl rule__LoopedAlternativeModel__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__3__Impl_in_rule__LoopedAlternativeModel__Group__33755);
            rule__LoopedAlternativeModel__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__4_in_rule__LoopedAlternativeModel__Group__33758);
            rule__LoopedAlternativeModel__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedAlternativeModel__Group__3"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__3__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LoopedAlternativeModel__Group__3__Impl3786); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__Group__3__Impl"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1869:1: rule__LoopedAlternativeModel__Group__4 : rule__LoopedAlternativeModel__Group__4__Impl ;
    public final void rule__LoopedAlternativeModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1873:1: ( rule__LoopedAlternativeModel__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1874:2: rule__LoopedAlternativeModel__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group__4__Impl_in_rule__LoopedAlternativeModel__Group__43817);
            rule__LoopedAlternativeModel__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedAlternativeModel__Group__4"


    // $ANTLR start "rule__LoopedAlternativeModel__Group__4__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LoopedAlternativeModel__Group__4__Impl3845); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__Group__4__Impl"


    // $ANTLR start "rule__LoopedAlternativeModel__Group_0_4__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1909:1: rule__LoopedAlternativeModel__Group_0_4__0 : rule__LoopedAlternativeModel__Group_0_4__0__Impl rule__LoopedAlternativeModel__Group_0_4__1 ;
    public final void rule__LoopedAlternativeModel__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1913:1: ( rule__LoopedAlternativeModel__Group_0_4__0__Impl rule__LoopedAlternativeModel__Group_0_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1914:2: rule__LoopedAlternativeModel__Group_0_4__0__Impl rule__LoopedAlternativeModel__Group_0_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0__Impl_in_rule__LoopedAlternativeModel__Group_0_4__03886);
            rule__LoopedAlternativeModel__Group_0_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1_in_rule__LoopedAlternativeModel__Group_0_4__03889);
            rule__LoopedAlternativeModel__Group_0_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedAlternativeModel__Group_0_4__0"


    // $ANTLR start "rule__LoopedAlternativeModel__Group_0_4__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LoopedAlternativeModel__Group_0_4__0__Impl3917); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__Group_0_4__0__Impl"


    // $ANTLR start "rule__LoopedAlternativeModel__Group_0_4__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1940:1: rule__LoopedAlternativeModel__Group_0_4__1 : rule__LoopedAlternativeModel__Group_0_4__1__Impl ;
    public final void rule__LoopedAlternativeModel__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1944:1: ( rule__LoopedAlternativeModel__Group_0_4__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1945:2: rule__LoopedAlternativeModel__Group_0_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1__Impl_in_rule__LoopedAlternativeModel__Group_0_4__13948);
            rule__LoopedAlternativeModel__Group_0_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedAlternativeModel__Group_0_4__1"


    // $ANTLR start "rule__LoopedAlternativeModel__Group_0_4__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1()); 
            }
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
            	    match(input,24,FollowSets000.FOLLOW_24_in_rule__LoopedAlternativeModel__Group_0_4__1__Impl3977); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__Group_0_4__1__Impl"


    // $ANTLR start "rule__Bug304681Model__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1974:1: rule__Bug304681Model__Group__0 : rule__Bug304681Model__Group__0__Impl rule__Bug304681Model__Group__1 ;
    public final void rule__Bug304681Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1978:1: ( rule__Bug304681Model__Group__0__Impl rule__Bug304681Model__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1979:2: rule__Bug304681Model__Group__0__Impl rule__Bug304681Model__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__0__Impl_in_rule__Bug304681Model__Group__04014);
            rule__Bug304681Model__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__1_in_rule__Bug304681Model__Group__04017);
            rule__Bug304681Model__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group__0"


    // $ANTLR start "rule__Bug304681Model__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1993:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1995:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group__0__Impl"


    // $ANTLR start "rule__Bug304681Model__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2005:1: rule__Bug304681Model__Group__1 : rule__Bug304681Model__Group__1__Impl rule__Bug304681Model__Group__2 ;
    public final void rule__Bug304681Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2009:1: ( rule__Bug304681Model__Group__1__Impl rule__Bug304681Model__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2010:2: rule__Bug304681Model__Group__1__Impl rule__Bug304681Model__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__1__Impl_in_rule__Bug304681Model__Group__14075);
            rule__Bug304681Model__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__14078);
            rule__Bug304681Model__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group__1"


    // $ANTLR start "rule__Bug304681Model__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Bug304681Model__Group__1__Impl4106); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_1()); 
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
    // $ANTLR end "rule__Bug304681Model__Group__1__Impl"


    // $ANTLR start "rule__Bug304681Model__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2036:1: rule__Bug304681Model__Group__2 : rule__Bug304681Model__Group__2__Impl rule__Bug304681Model__Group__3 ;
    public final void rule__Bug304681Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2040:1: ( rule__Bug304681Model__Group__2__Impl rule__Bug304681Model__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2041:2: rule__Bug304681Model__Group__2__Impl rule__Bug304681Model__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__2__Impl_in_rule__Bug304681Model__Group__24137);
            rule__Bug304681Model__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__3_in_rule__Bug304681Model__Group__24140);
            rule__Bug304681Model__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group__2"


    // $ANTLR start "rule__Bug304681Model__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2055:1: ( rule__Bug304681Model__UnorderedGroup_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2055:2: rule__Bug304681Model__UnorderedGroup_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2_in_rule__Bug304681Model__Group__2__Impl4167);
            rule__Bug304681Model__UnorderedGroup_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2()); 
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
    // $ANTLR end "rule__Bug304681Model__Group__2__Impl"


    // $ANTLR start "rule__Bug304681Model__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2065:1: rule__Bug304681Model__Group__3 : rule__Bug304681Model__Group__3__Impl ;
    public final void rule__Bug304681Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2069:1: ( rule__Bug304681Model__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2070:2: rule__Bug304681Model__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group__3__Impl_in_rule__Bug304681Model__Group__34197);
            rule__Bug304681Model__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group__3"


    // $ANTLR start "rule__Bug304681Model__Group__3__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Bug304681Model__Group__3__Impl4225); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__Bug304681Model__Group__3__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2103:1: rule__Bug304681Model__Group_2_0__0 : rule__Bug304681Model__Group_2_0__0__Impl rule__Bug304681Model__Group_2_0__1 ;
    public final void rule__Bug304681Model__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2107:1: ( rule__Bug304681Model__Group_2_0__0__Impl rule__Bug304681Model__Group_2_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2108:2: rule__Bug304681Model__Group_2_0__0__Impl rule__Bug304681Model__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__0__Impl_in_rule__Bug304681Model__Group_2_0__04264);
            rule__Bug304681Model__Group_2_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__1_in_rule__Bug304681Model__Group_2_0__04267);
            rule__Bug304681Model__Group_2_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_0__0"


    // $ANTLR start "rule__Bug304681Model__Group_2_0__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getShortKeyword_2_0_0()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Bug304681Model__Group_2_0__0__Impl4295); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getShortKeyword_2_0_0()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_0__0__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2134:1: rule__Bug304681Model__Group_2_0__1 : rule__Bug304681Model__Group_2_0__1__Impl rule__Bug304681Model__Group_2_0__2 ;
    public final void rule__Bug304681Model__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2138:1: ( rule__Bug304681Model__Group_2_0__1__Impl rule__Bug304681Model__Group_2_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2139:2: rule__Bug304681Model__Group_2_0__1__Impl rule__Bug304681Model__Group_2_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__1__Impl_in_rule__Bug304681Model__Group_2_0__14326);
            rule__Bug304681Model__Group_2_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__2_in_rule__Bug304681Model__Group_2_0__14329);
            rule__Bug304681Model__Group_2_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_0__1"


    // $ANTLR start "rule__Bug304681Model__Group_2_0__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_2_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2153:1: ( rule__Bug304681Model__ShortDescriptionAssignment_2_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2153:2: rule__Bug304681Model__ShortDescriptionAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_2_0_1_in_rule__Bug304681Model__Group_2_0__1__Impl4356);
            rule__Bug304681Model__ShortDescriptionAssignment_2_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_2_0_1()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_0__1__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2163:1: rule__Bug304681Model__Group_2_0__2 : rule__Bug304681Model__Group_2_0__2__Impl ;
    public final void rule__Bug304681Model__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2167:1: ( rule__Bug304681Model__Group_2_0__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2168:2: rule__Bug304681Model__Group_2_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__2__Impl_in_rule__Bug304681Model__Group_2_0__24386);
            rule__Bug304681Model__Group_2_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_0__2"


    // $ANTLR start "rule__Bug304681Model__Group_2_0__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_0_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_0__2__Impl4414); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_0_2()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_0__2__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2199:1: rule__Bug304681Model__Group_2_1__0 : rule__Bug304681Model__Group_2_1__0__Impl rule__Bug304681Model__Group_2_1__1 ;
    public final void rule__Bug304681Model__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2203:1: ( rule__Bug304681Model__Group_2_1__0__Impl rule__Bug304681Model__Group_2_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2204:2: rule__Bug304681Model__Group_2_1__0__Impl rule__Bug304681Model__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__0__Impl_in_rule__Bug304681Model__Group_2_1__04451);
            rule__Bug304681Model__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__1_in_rule__Bug304681Model__Group_2_1__04454);
            rule__Bug304681Model__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_1__0"


    // $ANTLR start "rule__Bug304681Model__Group_2_1__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getLongKeyword_2_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Bug304681Model__Group_2_1__0__Impl4482); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getLongKeyword_2_1_0()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_1__0__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2230:1: rule__Bug304681Model__Group_2_1__1 : rule__Bug304681Model__Group_2_1__1__Impl rule__Bug304681Model__Group_2_1__2 ;
    public final void rule__Bug304681Model__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2234:1: ( rule__Bug304681Model__Group_2_1__1__Impl rule__Bug304681Model__Group_2_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2235:2: rule__Bug304681Model__Group_2_1__1__Impl rule__Bug304681Model__Group_2_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__1__Impl_in_rule__Bug304681Model__Group_2_1__14513);
            rule__Bug304681Model__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__2_in_rule__Bug304681Model__Group_2_1__14516);
            rule__Bug304681Model__Group_2_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_1__1"


    // $ANTLR start "rule__Bug304681Model__Group_2_1__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_2_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2249:1: ( rule__Bug304681Model__LongDescriptionAssignment_2_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2249:2: rule__Bug304681Model__LongDescriptionAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_2_1_1_in_rule__Bug304681Model__Group_2_1__1__Impl4543);
            rule__Bug304681Model__LongDescriptionAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_2_1_1()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_1__1__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_1__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2259:1: rule__Bug304681Model__Group_2_1__2 : rule__Bug304681Model__Group_2_1__2__Impl ;
    public final void rule__Bug304681Model__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2263:1: ( rule__Bug304681Model__Group_2_1__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2264:2: rule__Bug304681Model__Group_2_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__2__Impl_in_rule__Bug304681Model__Group_2_1__24573);
            rule__Bug304681Model__Group_2_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_1__2"


    // $ANTLR start "rule__Bug304681Model__Group_2_1__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_1_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_1__2__Impl4601); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_1_2()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_1__2__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2295:1: rule__Bug304681Model__Group_2_2__0 : rule__Bug304681Model__Group_2_2__0__Impl rule__Bug304681Model__Group_2_2__1 ;
    public final void rule__Bug304681Model__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2299:1: ( rule__Bug304681Model__Group_2_2__0__Impl rule__Bug304681Model__Group_2_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2300:2: rule__Bug304681Model__Group_2_2__0__Impl rule__Bug304681Model__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__0__Impl_in_rule__Bug304681Model__Group_2_2__04638);
            rule__Bug304681Model__Group_2_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__1_in_rule__Bug304681Model__Group_2_2__04641);
            rule__Bug304681Model__Group_2_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_2__0"


    // $ANTLR start "rule__Bug304681Model__Group_2_2__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getUidKeyword_2_2_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Bug304681Model__Group_2_2__0__Impl4669); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getUidKeyword_2_2_0()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_2__0__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2326:1: rule__Bug304681Model__Group_2_2__1 : rule__Bug304681Model__Group_2_2__1__Impl rule__Bug304681Model__Group_2_2__2 ;
    public final void rule__Bug304681Model__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2330:1: ( rule__Bug304681Model__Group_2_2__1__Impl rule__Bug304681Model__Group_2_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2331:2: rule__Bug304681Model__Group_2_2__1__Impl rule__Bug304681Model__Group_2_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__1__Impl_in_rule__Bug304681Model__Group_2_2__14700);
            rule__Bug304681Model__Group_2_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__2_in_rule__Bug304681Model__Group_2_2__14703);
            rule__Bug304681Model__Group_2_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_2__1"


    // $ANTLR start "rule__Bug304681Model__Group_2_2__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getUidAssignment_2_2_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2345:1: ( rule__Bug304681Model__UidAssignment_2_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2345:2: rule__Bug304681Model__UidAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UidAssignment_2_2_1_in_rule__Bug304681Model__Group_2_2__1__Impl4730);
            rule__Bug304681Model__UidAssignment_2_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getUidAssignment_2_2_1()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_2__1__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_2__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2355:1: rule__Bug304681Model__Group_2_2__2 : rule__Bug304681Model__Group_2_2__2__Impl ;
    public final void rule__Bug304681Model__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2359:1: ( rule__Bug304681Model__Group_2_2__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2360:2: rule__Bug304681Model__Group_2_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__2__Impl_in_rule__Bug304681Model__Group_2_2__24760);
            rule__Bug304681Model__Group_2_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_2__2"


    // $ANTLR start "rule__Bug304681Model__Group_2_2__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_2_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_2__2__Impl4788); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_2_2()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_2__2__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_3__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2391:1: rule__Bug304681Model__Group_2_3__0 : rule__Bug304681Model__Group_2_3__0__Impl rule__Bug304681Model__Group_2_3__1 ;
    public final void rule__Bug304681Model__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2395:1: ( rule__Bug304681Model__Group_2_3__0__Impl rule__Bug304681Model__Group_2_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2396:2: rule__Bug304681Model__Group_2_3__0__Impl rule__Bug304681Model__Group_2_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__0__Impl_in_rule__Bug304681Model__Group_2_3__04825);
            rule__Bug304681Model__Group_2_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__1_in_rule__Bug304681Model__Group_2_3__04828);
            rule__Bug304681Model__Group_2_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_3__0"


    // $ANTLR start "rule__Bug304681Model__Group_2_3__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getFlagAssignment_2_3_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2410:1: ( rule__Bug304681Model__FlagAssignment_2_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2410:2: rule__Bug304681Model__FlagAssignment_2_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FlagAssignment_2_3_0_in_rule__Bug304681Model__Group_2_3__0__Impl4855);
            rule__Bug304681Model__FlagAssignment_2_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getFlagAssignment_2_3_0()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_3__0__Impl"


    // $ANTLR start "rule__Bug304681Model__Group_2_3__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2420:1: rule__Bug304681Model__Group_2_3__1 : rule__Bug304681Model__Group_2_3__1__Impl ;
    public final void rule__Bug304681Model__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2424:1: ( rule__Bug304681Model__Group_2_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2425:2: rule__Bug304681Model__Group_2_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__1__Impl_in_rule__Bug304681Model__Group_2_3__14885);
            rule__Bug304681Model__Group_2_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__Group_2_3__1"


    // $ANTLR start "rule__Bug304681Model__Group_2_3__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_3_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Model__Group_2_3__1__Impl4913); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_3_1()); 
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
    // $ANTLR end "rule__Bug304681Model__Group_2_3__1__Impl"


    // $ANTLR start "rule__Bug304681Attribute__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2454:1: rule__Bug304681Attribute__Group__0 : rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1 ;
    public final void rule__Bug304681Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2458:1: ( rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2459:2: rule__Bug304681Attribute__Group__0__Impl rule__Bug304681Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__0__Impl_in_rule__Bug304681Attribute__Group__04948);
            rule__Bug304681Attribute__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__04951);
            rule__Bug304681Attribute__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Attribute__Group__0"


    // $ANTLR start "rule__Bug304681Attribute__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__Bug304681Attribute__Group__0__Impl4979); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0()); 
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
    // $ANTLR end "rule__Bug304681Attribute__Group__0__Impl"


    // $ANTLR start "rule__Bug304681Attribute__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2485:1: rule__Bug304681Attribute__Group__1 : rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2 ;
    public final void rule__Bug304681Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2489:1: ( rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2490:2: rule__Bug304681Attribute__Group__1__Impl rule__Bug304681Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__1__Impl_in_rule__Bug304681Attribute__Group__15010);
            rule__Bug304681Attribute__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__15013);
            rule__Bug304681Attribute__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Attribute__Group__1"


    // $ANTLR start "rule__Bug304681Attribute__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2504:1: ( rule__Bug304681Attribute__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2504:2: rule__Bug304681Attribute__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__1__Impl5040);
            rule__Bug304681Attribute__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__Bug304681Attribute__Group__1__Impl"


    // $ANTLR start "rule__Bug304681Attribute__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2514:1: rule__Bug304681Attribute__Group__2 : rule__Bug304681Attribute__Group__2__Impl ;
    public final void rule__Bug304681Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2518:1: ( rule__Bug304681Attribute__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2519:2: rule__Bug304681Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Attribute__Group__2__Impl_in_rule__Bug304681Attribute__Group__25070);
            rule__Bug304681Attribute__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Attribute__Group__2"


    // $ANTLR start "rule__Bug304681Attribute__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Attribute__Group__2__Impl5098); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2()); 
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
    // $ANTLR end "rule__Bug304681Attribute__Group__2__Impl"


    // $ANTLR start "rule__Bug304681Reference__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2550:1: rule__Bug304681Reference__Group__0 : rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1 ;
    public final void rule__Bug304681Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2554:1: ( rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2555:2: rule__Bug304681Reference__Group__0__Impl rule__Bug304681Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__0__Impl_in_rule__Bug304681Reference__Group__05135);
            rule__Bug304681Reference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__05138);
            rule__Bug304681Reference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Reference__Group__0"


    // $ANTLR start "rule__Bug304681Reference__Group__0__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__Bug304681Reference__Group__0__Impl5166); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0()); 
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
    // $ANTLR end "rule__Bug304681Reference__Group__0__Impl"


    // $ANTLR start "rule__Bug304681Reference__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2581:1: rule__Bug304681Reference__Group__1 : rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2 ;
    public final void rule__Bug304681Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2585:1: ( rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2586:2: rule__Bug304681Reference__Group__1__Impl rule__Bug304681Reference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__1__Impl_in_rule__Bug304681Reference__Group__15197);
            rule__Bug304681Reference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__15200);
            rule__Bug304681Reference__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Reference__Group__1"


    // $ANTLR start "rule__Bug304681Reference__Group__1__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2600:1: ( rule__Bug304681Reference__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2600:2: rule__Bug304681Reference__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__1__Impl5227);
            rule__Bug304681Reference__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__Bug304681Reference__Group__1__Impl"


    // $ANTLR start "rule__Bug304681Reference__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2610:1: rule__Bug304681Reference__Group__2 : rule__Bug304681Reference__Group__2__Impl ;
    public final void rule__Bug304681Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2614:1: ( rule__Bug304681Reference__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2615:2: rule__Bug304681Reference__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Reference__Group__2__Impl_in_rule__Bug304681Reference__Group__25257);
            rule__Bug304681Reference__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Reference__Group__2"


    // $ANTLR start "rule__Bug304681Reference__Group__2__Impl"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Bug304681Reference__Group__2__Impl5285); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2()); 
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
    // $ANTLR end "rule__Bug304681Reference__Group__2__Impl"


    // $ANTLR start "rule__SimpleModel__UnorderedGroup_0"
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

            if ( LA17_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt17=1;
            }
            else if ( LA17_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt17=1;
            }
            else if ( LA17_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt17=1;
            }
            else if ( LA17_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt17=1;
            }
            else if ( LA17_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt17=1;
            }
            else if ( LA17_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt17=1;
            }
            else if ( LA17_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__SimpleModel__UnorderedGroup_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_rule__SimpleModel__UnorderedGroup_05323);
                    rule__SimpleModel__UnorderedGroup_0__0();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__SimpleModel__UnorderedGroup_0"


    // $ANTLR start "rule__SimpleModel__UnorderedGroup_0__Impl"
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

            if ( LA18_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt18=1;
            }
            else if ( LA18_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt18=1;
            }
            else if ( LA18_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:8: rule__SimpleModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_0__Impl5410);
                    rule__SimpleModel__VisibilityAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2699:7: ( rule__SimpleModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2699:8: rule__SimpleModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_0__Impl5501);
                    rule__SimpleModel__StaticAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2716:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2716:8: rule__SimpleModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_0__Impl5592);
                    rule__SimpleModel__SynchronizedAssignment_0_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2733:7: ( rule__SimpleModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2733:8: rule__SimpleModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_0__Impl5683);
                    rule__SimpleModel__Alternatives_0_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpleModelAccess().getAlternatives_0_3()); 
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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleModel__UnorderedGroup_0__Impl"


    // $ANTLR start "rule__SimpleModel__UnorderedGroup_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2748:1: rule__SimpleModel__UnorderedGroup_0__0 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2752:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2753:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__05742);
            rule__SimpleModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2754:2: ( rule__SimpleModel__UnorderedGroup_0__1 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( LA19_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt19=1;
            }
            else if ( LA19_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt19=1;
            }
            else if ( LA19_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt19=1;
            }
            else if ( LA19_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt19=1;
            }
            else if ( LA19_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt19=1;
            }
            else if ( LA19_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt19=1;
            }
            else if ( LA19_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__SimpleModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_rule__SimpleModel__UnorderedGroup_0__05745);
                    rule__SimpleModel__UnorderedGroup_0__1();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__SimpleModel__UnorderedGroup_0__0"


    // $ANTLR start "rule__SimpleModel__UnorderedGroup_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2761:1: rule__SimpleModel__UnorderedGroup_0__1 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2765:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2766:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__15770);
            rule__SimpleModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2767:2: ( rule__SimpleModel__UnorderedGroup_0__2 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( LA20_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt20=1;
            }
            else if ( LA20_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt20=1;
            }
            else if ( LA20_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt20=1;
            }
            else if ( LA20_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt20=1;
            }
            else if ( LA20_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt20=1;
            }
            else if ( LA20_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt20=1;
            }
            else if ( LA20_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__SimpleModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_rule__SimpleModel__UnorderedGroup_0__15773);
                    rule__SimpleModel__UnorderedGroup_0__2();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__SimpleModel__UnorderedGroup_0__1"


    // $ANTLR start "rule__SimpleModel__UnorderedGroup_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2774:1: rule__SimpleModel__UnorderedGroup_0__2 : rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )? ;
    public final void rule__SimpleModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2778:1: ( rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2779:2: rule__SimpleModel__UnorderedGroup_0__Impl ( rule__SimpleModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__25798);
            rule__SimpleModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2780:2: ( rule__SimpleModel__UnorderedGroup_0__3 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( LA21_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt21=1;
            }
            else if ( LA21_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt21=1;
            }
            else if ( LA21_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                alt21=1;
            }
            else if ( LA21_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                alt21=1;
            }
            else if ( LA21_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                alt21=1;
            }
            else if ( LA21_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt21=1;
            }
            else if ( LA21_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__SimpleModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_rule__SimpleModel__UnorderedGroup_0__25801);
                    rule__SimpleModel__UnorderedGroup_0__3();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__SimpleModel__UnorderedGroup_0__2"


    // $ANTLR start "rule__SimpleModel__UnorderedGroup_0__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2787:1: rule__SimpleModel__UnorderedGroup_0__3 : rule__SimpleModel__UnorderedGroup_0__Impl ;
    public final void rule__SimpleModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2791:1: ( rule__SimpleModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2792:2: rule__SimpleModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__35826);
            rule__SimpleModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleModel__UnorderedGroup_0__3"


    // $ANTLR start "rule__MandatoryModel__UnorderedGroup_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2807:1: rule__MandatoryModel__UnorderedGroup_0 : rule__MandatoryModel__UnorderedGroup_0__0 {...}?;
    public final void rule__MandatoryModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2812:1: ( rule__MandatoryModel__UnorderedGroup_0__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2813:2: rule__MandatoryModel__UnorderedGroup_0__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__0_in_rule__MandatoryModel__UnorderedGroup_05858);
            rule__MandatoryModel__UnorderedGroup_0__0();

            state._fsp--;
            if (state.failed) return ;
            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
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
    // $ANTLR end "rule__MandatoryModel__UnorderedGroup_0"


    // $ANTLR start "rule__MandatoryModel__UnorderedGroup_0__Impl"
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

            if ( LA22_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt22=1;
            }
            else if ( LA22_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt22=1;
            }
            else if ( LA22_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2843:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2843:8: rule__MandatoryModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_0__Impl5947);
                    rule__MandatoryModel__VisibilityAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2860:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2860:8: rule__MandatoryModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_0__Impl6038);
                    rule__MandatoryModel__StaticAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2877:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2877:8: rule__MandatoryModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_0__Impl6129);
                    rule__MandatoryModel__SynchronizedAssignment_0_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2894:7: ( rule__MandatoryModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2894:8: rule__MandatoryModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_0__Impl6220);
                    rule__MandatoryModel__Alternatives_0_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3()); 
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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryModel__UnorderedGroup_0__Impl"


    // $ANTLR start "rule__MandatoryModel__UnorderedGroup_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2909:1: rule__MandatoryModel__UnorderedGroup_0__0 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2913:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2914:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__06279);
            rule__MandatoryModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2915:2: ( rule__MandatoryModel__UnorderedGroup_0__1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( LA23_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt23=1;
            }
            else if ( LA23_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt23=1;
            }
            else if ( LA23_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt23=1;
            }
            else if ( LA23_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                alt23=1;
            }
            else if ( LA23_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                alt23=1;
            }
            else if ( LA23_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt23=1;
            }
            else if ( LA23_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__MandatoryModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_rule__MandatoryModel__UnorderedGroup_0__06282);
                    rule__MandatoryModel__UnorderedGroup_0__1();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__MandatoryModel__UnorderedGroup_0__0"


    // $ANTLR start "rule__MandatoryModel__UnorderedGroup_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2922:1: rule__MandatoryModel__UnorderedGroup_0__1 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2926:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2927:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__16307);
            rule__MandatoryModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2928:2: ( rule__MandatoryModel__UnorderedGroup_0__2 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( LA24_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                alt24=1;
            }
            else if ( LA24_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                alt24=1;
            }
            else if ( LA24_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt24=1;
            }
            else if ( LA24_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__MandatoryModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_rule__MandatoryModel__UnorderedGroup_0__16310);
                    rule__MandatoryModel__UnorderedGroup_0__2();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__MandatoryModel__UnorderedGroup_0__1"


    // $ANTLR start "rule__MandatoryModel__UnorderedGroup_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2935:1: rule__MandatoryModel__UnorderedGroup_0__2 : rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )? ;
    public final void rule__MandatoryModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2939:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2940:2: rule__MandatoryModel__UnorderedGroup_0__Impl ( rule__MandatoryModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__26335);
            rule__MandatoryModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: ( rule__MandatoryModel__UnorderedGroup_0__3 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( LA25_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                alt25=1;
            }
            else if ( LA25_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                alt25=1;
            }
            else if ( LA25_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt25=1;
            }
            else if ( LA25_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__MandatoryModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_rule__MandatoryModel__UnorderedGroup_0__26338);
                    rule__MandatoryModel__UnorderedGroup_0__3();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__MandatoryModel__UnorderedGroup_0__2"


    // $ANTLR start "rule__MandatoryModel__UnorderedGroup_0__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2948:1: rule__MandatoryModel__UnorderedGroup_0__3 : rule__MandatoryModel__UnorderedGroup_0__Impl ;
    public final void rule__MandatoryModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2952:1: ( rule__MandatoryModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2953:2: rule__MandatoryModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__36363);
            rule__MandatoryModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryModel__UnorderedGroup_0__3"


    // $ANTLR start "rule__LoopedModel__UnorderedGroup_0"
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

            if ( LA26_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt26=1;
            }
            else if ( LA26_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt26=1;
            }
            else if ( LA26_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt26=1;
            }
            else if ( LA26_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt26=1;
            }
            else if ( LA26_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt26=1;
            }
            else if ( LA26_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt26=1;
            }
            else if ( LA26_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__LoopedModel__UnorderedGroup_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_rule__LoopedModel__UnorderedGroup_06395);
                    rule__LoopedModel__UnorderedGroup_0__0();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__LoopedModel__UnorderedGroup_0"


    // $ANTLR start "rule__LoopedModel__UnorderedGroup_0__Impl"
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

            if ( LA31_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt31=1;
            }
            else if ( LA31_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt31=1;
            }
            else if ( LA31_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:8: rule__LoopedModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6483);
                    rule__LoopedModel__VisibilityAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    }

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3006:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3007:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
                    loop27:
                    do {
                        int alt27=2;
                        switch ( input.LA(1) ) {
                        case 11:
                            {
                            int LA27_1 = input.LA(2);

                            if ( (synpred43_InternalUnorderedGroupsTestLanguage()) ) {
                                alt27=1;
                            }


                            }
                            break;
                        case 12:
                            {
                            int LA27_2 = input.LA(2);

                            if ( (synpred43_InternalUnorderedGroupsTestLanguage()) ) {
                                alt27=1;
                            }


                            }
                            break;
                        case 13:
                            {
                            int LA27_3 = input.LA(2);

                            if ( (synpred43_InternalUnorderedGroupsTestLanguage()) ) {
                                alt27=1;
                            }


                            }
                            break;

                        }

                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:8: rule__LoopedModel__VisibilityAssignment_0_0
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6523);
                    	    rule__LoopedModel__VisibilityAssignment_0_0();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:7: ( rule__LoopedModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:8: rule__LoopedModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6622);
                    rule__LoopedModel__StaticAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    }

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3028:6: ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3029:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==31) ) {
                            int LA28_2 = input.LA(2);

                            if ( (synpred45_InternalUnorderedGroupsTestLanguage()) ) {
                                alt28=1;
                            }


                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:8: rule__LoopedModel__StaticAssignment_0_1
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6662);
                    	    rule__LoopedModel__StaticAssignment_0_1();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3047:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3047:8: rule__LoopedModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6761);
                    rule__LoopedModel__SynchronizedAssignment_0_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    }

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3050:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3051:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==32) ) {
                            int LA29_2 = input.LA(2);

                            if ( (synpred47_InternalUnorderedGroupsTestLanguage()) ) {
                                alt29=1;
                            }


                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:8: rule__LoopedModel__SynchronizedAssignment_0_2
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6801);
                    	    rule__LoopedModel__SynchronizedAssignment_0_2();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3069:7: ( rule__LoopedModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3069:8: rule__LoopedModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6900);
                    rule__LoopedModel__Alternatives_0_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    }

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3072:6: ( ( rule__LoopedModel__Alternatives_0_3 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3073:7: ( rule__LoopedModel__Alternatives_0_3 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:7: ( rule__LoopedModel__Alternatives_0_3 )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==33) ) {
                            int LA30_2 = input.LA(2);

                            if ( (synpred49_InternalUnorderedGroupsTestLanguage()) ) {
                                alt30=1;
                            }


                        }
                        else if ( (LA30_0==34) ) {
                            int LA30_3 = input.LA(2);

                            if ( (synpred49_InternalUnorderedGroupsTestLanguage()) ) {
                                alt30=1;
                            }


                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:8: rule__LoopedModel__Alternatives_0_3
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6940);
                    	    rule__LoopedModel__Alternatives_0_3();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopedModelAccess().getAlternatives_0_3()); 
                    }

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
    // $ANTLR end "rule__LoopedModel__UnorderedGroup_0__Impl"


    // $ANTLR start "rule__LoopedModel__UnorderedGroup_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3089:1: rule__LoopedModel__UnorderedGroup_0__0 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3093:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3094:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__07006);
            rule__LoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3095:2: ( rule__LoopedModel__UnorderedGroup_0__1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( LA32_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt32=1;
            }
            else if ( LA32_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt32=1;
            }
            else if ( LA32_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt32=1;
            }
            else if ( LA32_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt32=1;
            }
            else if ( LA32_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt32=1;
            }
            else if ( LA32_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt32=1;
            }
            else if ( LA32_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__LoopedModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_rule__LoopedModel__UnorderedGroup_0__07009);
                    rule__LoopedModel__UnorderedGroup_0__1();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__LoopedModel__UnorderedGroup_0__0"


    // $ANTLR start "rule__LoopedModel__UnorderedGroup_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3102:1: rule__LoopedModel__UnorderedGroup_0__1 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3106:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3107:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__17034);
            rule__LoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3108:2: ( rule__LoopedModel__UnorderedGroup_0__2 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( LA33_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt33=1;
            }
            else if ( LA33_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt33=1;
            }
            else if ( LA33_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt33=1;
            }
            else if ( LA33_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt33=1;
            }
            else if ( LA33_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt33=1;
            }
            else if ( LA33_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt33=1;
            }
            else if ( LA33_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__LoopedModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_rule__LoopedModel__UnorderedGroup_0__17037);
                    rule__LoopedModel__UnorderedGroup_0__2();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__LoopedModel__UnorderedGroup_0__1"


    // $ANTLR start "rule__LoopedModel__UnorderedGroup_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3115:1: rule__LoopedModel__UnorderedGroup_0__2 : rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )? ;
    public final void rule__LoopedModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3119:1: ( rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3120:2: rule__LoopedModel__UnorderedGroup_0__Impl ( rule__LoopedModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__27062);
            rule__LoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3121:2: ( rule__LoopedModel__UnorderedGroup_0__3 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( LA34_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt34=1;
            }
            else if ( LA34_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt34=1;
            }
            else if ( LA34_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt34=1;
            }
            else if ( LA34_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                alt34=1;
            }
            else if ( LA34_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                alt34=1;
            }
            else if ( LA34_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt34=1;
            }
            else if ( LA34_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__LoopedModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_rule__LoopedModel__UnorderedGroup_0__27065);
                    rule__LoopedModel__UnorderedGroup_0__3();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__LoopedModel__UnorderedGroup_0__2"


    // $ANTLR start "rule__LoopedModel__UnorderedGroup_0__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3128:1: rule__LoopedModel__UnorderedGroup_0__3 : rule__LoopedModel__UnorderedGroup_0__Impl ;
    public final void rule__LoopedModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3132:1: ( rule__LoopedModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3133:2: rule__LoopedModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__37090);
            rule__LoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LoopedModel__UnorderedGroup_0__3"


    // $ANTLR start "rule__GroupLoopedModel__UnorderedGroup_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3148:1: rule__GroupLoopedModel__UnorderedGroup_0 : rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?;
    public final void rule__GroupLoopedModel__UnorderedGroup_0() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3153:1: ( rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3154:2: rule__GroupLoopedModel__UnorderedGroup_0__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__0_in_rule__GroupLoopedModel__UnorderedGroup_07122);
            rule__GroupLoopedModel__UnorderedGroup_0__0();

            state._fsp--;
            if (state.failed) return ;
            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
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
    // $ANTLR end "rule__GroupLoopedModel__UnorderedGroup_0"


    // $ANTLR start "rule__GroupLoopedModel__UnorderedGroup_0__Impl"
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

            if ( LA35_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt35=1;
            }
            else if ( LA35_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                alt35=1;
            }
            else if ( LA35_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3184:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3184:8: rule__GroupLoopedModel__VisibilityAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7211);
                    rule__GroupLoopedModel__VisibilityAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3201:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3201:8: rule__GroupLoopedModel__StaticAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7302);
                    rule__GroupLoopedModel__StaticAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3218:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3218:8: rule__GroupLoopedModel__SynchronizedAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7393);
                    rule__GroupLoopedModel__SynchronizedAssignment_0_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3235:7: ( rule__GroupLoopedModel__Alternatives_0_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3235:8: rule__GroupLoopedModel__Alternatives_0_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7484);
                    rule__GroupLoopedModel__Alternatives_0_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3()); 
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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupLoopedModel__UnorderedGroup_0__Impl"


    // $ANTLR start "rule__GroupLoopedModel__UnorderedGroup_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3250:1: rule__GroupLoopedModel__UnorderedGroup_0__0 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3254:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3255:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__07543);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3256:2: ( rule__GroupLoopedModel__UnorderedGroup_0__1 )?
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__GroupLoopedModel__UnorderedGroup_0__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_rule__GroupLoopedModel__UnorderedGroup_0__07546);
                    rule__GroupLoopedModel__UnorderedGroup_0__1();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__GroupLoopedModel__UnorderedGroup_0__0"


    // $ANTLR start "rule__GroupLoopedModel__UnorderedGroup_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3263:1: rule__GroupLoopedModel__UnorderedGroup_0__1 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3267:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3268:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__17571);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3269:2: ( rule__GroupLoopedModel__UnorderedGroup_0__2 )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__GroupLoopedModel__UnorderedGroup_0__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_rule__GroupLoopedModel__UnorderedGroup_0__17574);
                    rule__GroupLoopedModel__UnorderedGroup_0__2();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__GroupLoopedModel__UnorderedGroup_0__1"


    // $ANTLR start "rule__GroupLoopedModel__UnorderedGroup_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3276:1: rule__GroupLoopedModel__UnorderedGroup_0__2 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )? ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3280:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3281:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl ( rule__GroupLoopedModel__UnorderedGroup_0__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__27599);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: ( rule__GroupLoopedModel__UnorderedGroup_0__3 )?
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__GroupLoopedModel__UnorderedGroup_0__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_rule__GroupLoopedModel__UnorderedGroup_0__27602);
                    rule__GroupLoopedModel__UnorderedGroup_0__3();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__GroupLoopedModel__UnorderedGroup_0__2"


    // $ANTLR start "rule__GroupLoopedModel__UnorderedGroup_0__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3289:1: rule__GroupLoopedModel__UnorderedGroup_0__3 : rule__GroupLoopedModel__UnorderedGroup_0__Impl ;
    public final void rule__GroupLoopedModel__UnorderedGroup_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3293:1: ( rule__GroupLoopedModel__UnorderedGroup_0__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3294:2: rule__GroupLoopedModel__UnorderedGroup_0__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__37627);
            rule__GroupLoopedModel__UnorderedGroup_0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupLoopedModel__UnorderedGroup_0__3"


    // $ANTLR start "rule__Bug304681Model__UnorderedGroup_2"
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
            else if ( LA39_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt39=1;
            }
            else if ( LA39_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__Bug304681Model__UnorderedGroup_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__0_in_rule__Bug304681Model__UnorderedGroup_27659);
                    rule__Bug304681Model__UnorderedGroup_2__0();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__Bug304681Model__UnorderedGroup_2"


    // $ANTLR start "rule__Bug304681Model__UnorderedGroup_2__Impl"
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681ModelAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3344:7: ( rule__Bug304681Model__Group_2_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3344:8: rule__Bug304681Model__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7746);
                    rule__Bug304681Model__Group_2_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681ModelAccess().getGroup_2_0()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681ModelAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3361:7: ( rule__Bug304681Model__Group_2_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3361:8: rule__Bug304681Model__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7837);
                    rule__Bug304681Model__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681ModelAccess().getGroup_2_1()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681ModelAccess().getGroup_2_2()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3378:7: ( rule__Bug304681Model__Group_2_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3378:8: rule__Bug304681Model__Group_2_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7928);
                    rule__Bug304681Model__Group_2_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681ModelAccess().getGroup_2_2()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681ModelAccess().getGroup_2_3()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3395:7: ( rule__Bug304681Model__Group_2_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3395:8: rule__Bug304681Model__Group_2_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl8019);
                    rule__Bug304681Model__Group_2_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681ModelAccess().getGroup_2_3()); 
                    }

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
                        if (state.backtracking>0) {state.failed=true; return ;}
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
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3412:7: ( rule__Bug304681Model__FeaturesAssignment_2_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3412:8: rule__Bug304681Model__FeaturesAssignment_2_4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8111);
                    rule__Bug304681Model__FeaturesAssignment_2_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 
                    }

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3415:6: ( ( rule__Bug304681Model__FeaturesAssignment_2_4 )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3416:7: ( rule__Bug304681Model__FeaturesAssignment_2_4 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3417:7: ( rule__Bug304681Model__FeaturesAssignment_2_4 )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==29) ) {
                            int LA40_2 = input.LA(2);

                            if ( (LA40_2==RULE_ID) ) {
                                int LA40_4 = input.LA(3);

                                if ( (LA40_4==26) ) {
                                    int LA40_6 = input.LA(4);

                                    if ( (synpred64_InternalUnorderedGroupsTestLanguage()) ) {
                                        alt40=1;
                                    }


                                }


                            }


                        }
                        else if ( (LA40_0==30) ) {
                            int LA40_3 = input.LA(2);

                            if ( (LA40_3==RULE_ID) ) {
                                int LA40_5 = input.LA(3);

                                if ( (LA40_5==26) ) {
                                    int LA40_7 = input.LA(4);

                                    if ( (synpred64_InternalUnorderedGroupsTestLanguage()) ) {
                                        alt40=1;
                                    }


                                }


                            }


                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3417:8: rule__Bug304681Model__FeaturesAssignment_2_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8151);
                    	    rule__Bug304681Model__FeaturesAssignment_2_4();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4()); 
                    }

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
    // $ANTLR end "rule__Bug304681Model__UnorderedGroup_2__Impl"


    // $ANTLR start "rule__Bug304681Model__UnorderedGroup_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3432:1: rule__Bug304681Model__UnorderedGroup_2__0 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__1 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3436:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3437:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__08217);
            rule__Bug304681Model__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
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
            else if ( LA42_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt42=1;
            }
            else if ( LA42_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__Bug304681Model__UnorderedGroup_2__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__1_in_rule__Bug304681Model__UnorderedGroup_2__08220);
                    rule__Bug304681Model__UnorderedGroup_2__1();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__Bug304681Model__UnorderedGroup_2__0"


    // $ANTLR start "rule__Bug304681Model__UnorderedGroup_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3445:1: rule__Bug304681Model__UnorderedGroup_2__1 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__2 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3449:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3450:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__18245);
            rule__Bug304681Model__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
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
            else if ( LA43_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt43=1;
            }
            else if ( LA43_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__Bug304681Model__UnorderedGroup_2__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__2_in_rule__Bug304681Model__UnorderedGroup_2__18248);
                    rule__Bug304681Model__UnorderedGroup_2__2();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__Bug304681Model__UnorderedGroup_2__1"


    // $ANTLR start "rule__Bug304681Model__UnorderedGroup_2__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3458:1: rule__Bug304681Model__UnorderedGroup_2__2 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__3 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3462:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3463:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__28273);
            rule__Bug304681Model__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
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
            else if ( LA44_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt44=1;
            }
            else if ( LA44_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__Bug304681Model__UnorderedGroup_2__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__3_in_rule__Bug304681Model__UnorderedGroup_2__28276);
                    rule__Bug304681Model__UnorderedGroup_2__3();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__Bug304681Model__UnorderedGroup_2__2"


    // $ANTLR start "rule__Bug304681Model__UnorderedGroup_2__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3471:1: rule__Bug304681Model__UnorderedGroup_2__3 : rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__4 )? ;
    public final void rule__Bug304681Model__UnorderedGroup_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3475:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3476:2: rule__Bug304681Model__UnorderedGroup_2__Impl ( rule__Bug304681Model__UnorderedGroup_2__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__38301);
            rule__Bug304681Model__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;
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
            else if ( LA45_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt45=1;
            }
            else if ( LA45_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:0:0: rule__Bug304681Model__UnorderedGroup_2__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__4_in_rule__Bug304681Model__UnorderedGroup_2__38304);
                    rule__Bug304681Model__UnorderedGroup_2__4();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "rule__Bug304681Model__UnorderedGroup_2__3"


    // $ANTLR start "rule__Bug304681Model__UnorderedGroup_2__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3484:1: rule__Bug304681Model__UnorderedGroup_2__4 : rule__Bug304681Model__UnorderedGroup_2__Impl ;
    public final void rule__Bug304681Model__UnorderedGroup_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3488:1: ( rule__Bug304681Model__UnorderedGroup_2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3489:2: rule__Bug304681Model__UnorderedGroup_2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__48329);
            rule__Bug304681Model__UnorderedGroup_2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bug304681Model__UnorderedGroup_2__4"


    // $ANTLR start "rule__Model__FirstAssignment_0_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_18367);
            ruleSimpleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0()); 
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
    // $ANTLR end "rule__Model__FirstAssignment_0_1"


    // $ANTLR start "rule__Model__SecondAssignment_1_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_18398);
            ruleMandatoryModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Model__SecondAssignment_1_1"


    // $ANTLR start "rule__Model__ThrirdAssignment_2_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_18429);
            ruleLoopedModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__Model__ThrirdAssignment_2_1"


    // $ANTLR start "rule__Model__ForthAssignment_3_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_18460);
            ruleGroupLoopedModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__Model__ForthAssignment_3_1"


    // $ANTLR start "rule__Model__FifthAssignment_4_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_18491);
            ruleLoopedAlternativeModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0()); 
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
    // $ANTLR end "rule__Model__FifthAssignment_4_1"


    // $ANTLR start "rule__Model__ModelAssignment_5_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_18522);
            ruleBug304681Model();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0()); 
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
    // $ANTLR end "rule__Model__ModelAssignment_5_1"


    // $ANTLR start "rule__SimpleModel__VisibilityAssignment_0_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3603:1: ( rule__SimpleModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3603:2: rule__SimpleModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_08553);
            rule__SimpleModel__VisibilityAlternatives_0_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0()); 
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
    // $ANTLR end "rule__SimpleModel__VisibilityAssignment_0_0"


    // $ANTLR start "rule__SimpleModel__StaticAssignment_0_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3619:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3620:1: 'static'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_18591); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0()); 
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
    // $ANTLR end "rule__SimpleModel__StaticAssignment_0_1"


    // $ANTLR start "rule__SimpleModel__SynchronizedAssignment_0_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3642:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3643:1: 'synchronized'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_28635); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
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
    // $ANTLR end "rule__SimpleModel__SynchronizedAssignment_0_2"


    // $ANTLR start "rule__SimpleModel__AbstractAssignment_0_3_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3665:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3666:1: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_08679); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
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
    // $ANTLR end "rule__SimpleModel__AbstractAssignment_0_3_0"


    // $ANTLR start "rule__SimpleModel__FinalAssignment_0_3_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3688:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3689:1: 'final'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_18723); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0()); 
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
    // $ANTLR end "rule__SimpleModel__FinalAssignment_0_3_1"


    // $ANTLR start "rule__SimpleModel__NameAssignment_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_28762); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__SimpleModel__NameAssignment_2"


    // $ANTLR start "rule__MandatoryModel__VisibilityAssignment_0_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3726:1: ( rule__MandatoryModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3726:2: rule__MandatoryModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_08793);
            rule__MandatoryModel__VisibilityAlternatives_0_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0()); 
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
    // $ANTLR end "rule__MandatoryModel__VisibilityAssignment_0_0"


    // $ANTLR start "rule__MandatoryModel__StaticAssignment_0_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3742:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3743:1: 'static'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_18831); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0()); 
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
    // $ANTLR end "rule__MandatoryModel__StaticAssignment_0_1"


    // $ANTLR start "rule__MandatoryModel__SynchronizedAssignment_0_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3765:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3766:1: 'synchronized'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_28875); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
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
    // $ANTLR end "rule__MandatoryModel__SynchronizedAssignment_0_2"


    // $ANTLR start "rule__MandatoryModel__AbstractAssignment_0_3_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3788:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3789:1: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_08919); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
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
    // $ANTLR end "rule__MandatoryModel__AbstractAssignment_0_3_0"


    // $ANTLR start "rule__MandatoryModel__FinalAssignment_0_3_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3811:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3812:1: 'final'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_18963); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0()); 
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
    // $ANTLR end "rule__MandatoryModel__FinalAssignment_0_3_1"


    // $ANTLR start "rule__MandatoryModel__NameAssignment_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_29002); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__MandatoryModel__NameAssignment_2"


    // $ANTLR start "rule__LoopedModel__VisibilityAssignment_0_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3849:1: ( rule__LoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3849:2: rule__LoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_09033);
            rule__LoopedModel__VisibilityAlternatives_0_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
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
    // $ANTLR end "rule__LoopedModel__VisibilityAssignment_0_0"


    // $ANTLR start "rule__LoopedModel__StaticAssignment_0_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3865:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3866:1: 'static'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_19071); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
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
    // $ANTLR end "rule__LoopedModel__StaticAssignment_0_1"


    // $ANTLR start "rule__LoopedModel__SynchronizedAssignment_0_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3888:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3889:1: 'synchronized'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_29115); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
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
    // $ANTLR end "rule__LoopedModel__SynchronizedAssignment_0_2"


    // $ANTLR start "rule__LoopedModel__AbstractAssignment_0_3_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3911:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3912:1: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_09159); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
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
    // $ANTLR end "rule__LoopedModel__AbstractAssignment_0_3_0"


    // $ANTLR start "rule__LoopedModel__FinalAssignment_0_3_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3934:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3935:1: 'final'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_19203); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
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
    // $ANTLR end "rule__LoopedModel__FinalAssignment_0_3_1"


    // $ANTLR start "rule__LoopedModel__NameAssignment_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_29242); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__LoopedModel__NameAssignment_2"


    // $ANTLR start "rule__GroupLoopedModel__VisibilityAssignment_0_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3972:1: ( rule__GroupLoopedModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3972:2: rule__GroupLoopedModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_09273);
            rule__GroupLoopedModel__VisibilityAlternatives_0_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0()); 
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
    // $ANTLR end "rule__GroupLoopedModel__VisibilityAssignment_0_0"


    // $ANTLR start "rule__GroupLoopedModel__StaticAssignment_0_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3988:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3989:1: 'static'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_19311); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0()); 
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
    // $ANTLR end "rule__GroupLoopedModel__StaticAssignment_0_1"


    // $ANTLR start "rule__GroupLoopedModel__SynchronizedAssignment_0_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4011:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4012:1: 'synchronized'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_29355); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
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
    // $ANTLR end "rule__GroupLoopedModel__SynchronizedAssignment_0_2"


    // $ANTLR start "rule__GroupLoopedModel__AbstractAssignment_0_3_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4034:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4035:1: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_09399); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
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
    // $ANTLR end "rule__GroupLoopedModel__AbstractAssignment_0_3_0"


    // $ANTLR start "rule__GroupLoopedModel__FinalAssignment_0_3_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4057:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4058:1: 'final'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_19443); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0()); 
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
    // $ANTLR end "rule__GroupLoopedModel__FinalAssignment_0_3_1"


    // $ANTLR start "rule__GroupLoopedModel__NameAssignment_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_29482); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__GroupLoopedModel__NameAssignment_2"


    // $ANTLR start "rule__LoopedAlternativeModel__VisibilityAssignment_0_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAlternatives_0_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4095:1: ( rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4095:2: rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_09513);
            rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAlternatives_0_0_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__VisibilityAssignment_0_0"


    // $ANTLR start "rule__LoopedAlternativeModel__StaticAssignment_0_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4111:1: ( 'static' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4112:1: 'static'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_19551); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__StaticAssignment_0_1"


    // $ANTLR start "rule__LoopedAlternativeModel__SynchronizedAssignment_0_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4134:1: ( 'synchronized' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4135:1: 'synchronized'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_29595); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__SynchronizedAssignment_0_2"


    // $ANTLR start "rule__LoopedAlternativeModel__AbstractAssignment_0_3_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4157:1: ( 'abstract' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4158:1: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_09639); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__AbstractAssignment_0_3_0"


    // $ANTLR start "rule__LoopedAlternativeModel__FinalAssignment_0_3_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4180:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4181:1: 'final'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_19683); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__FinalAssignment_0_3_1"


    // $ANTLR start "rule__LoopedAlternativeModel__NameAssignment_2"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_29722); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__LoopedAlternativeModel__NameAssignment_2"


    // $ANTLR start "rule__Bug304681Model__ShortDescriptionAssignment_2_0_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_2_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_2_0_19753); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_2_0_1_0()); 
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
    // $ANTLR end "rule__Bug304681Model__ShortDescriptionAssignment_2_0_1"


    // $ANTLR start "rule__Bug304681Model__LongDescriptionAssignment_2_1_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_2_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_2_1_19784); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_2_1_1_0()); 
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
    // $ANTLR end "rule__Bug304681Model__LongDescriptionAssignment_2_1_1"


    // $ANTLR start "rule__Bug304681Model__UidAssignment_2_2_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_2_2_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_2_2_19815); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_2_2_1_0()); 
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
    // $ANTLR end "rule__Bug304681Model__UidAssignment_2_2_1"


    // $ANTLR start "rule__Bug304681Model__FlagAssignment_2_3_0"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4263:1: ( 'flag' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:4264:1: 'flag'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 
            }
            match(input,35,FollowSets000.FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_2_3_09851); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0()); 
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
    // $ANTLR end "rule__Bug304681Model__FlagAssignment_2_3_0"


    // $ANTLR start "rule__Bug304681Model__FeaturesAssignment_2_4"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_2_49890);
            ruleBug304681Feature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0()); 
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
    // $ANTLR end "rule__Bug304681Model__FeaturesAssignment_2_4"


    // $ANTLR start "rule__Bug304681Attribute__NameAssignment_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_19921); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Bug304681Attribute__NameAssignment_1"


    // $ANTLR start "rule__Bug304681Reference__NameAssignment_1"
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
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_19952); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Bug304681Reference__NameAssignment_1"

    // $ANTLR start synpred26_InternalUnorderedGroupsTestLanguage
    public final void synpred26_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1608:2: ( rule__GroupLoopedModel__UnorderedGroup_0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1608:2: rule__GroupLoopedModel__UnorderedGroup_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_synpred26_InternalUnorderedGroupsTestLanguage3288);
        rule__GroupLoopedModel__UnorderedGroup_0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred29_InternalUnorderedGroupsTestLanguage
    public final void synpred29_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2653:2: ( rule__SimpleModel__UnorderedGroup_0__0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2653:2: rule__SimpleModel__UnorderedGroup_0__0
        {
        pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_synpred29_InternalUnorderedGroupsTestLanguage5323);
        rule__SimpleModel__UnorderedGroup_0__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred30_InternalUnorderedGroupsTestLanguage
    public final void synpred30_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2671:4: ( ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2671:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2671:4: ({...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2672:5: {...}? => ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2672:108: ( ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2673:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2679:6: ( ( rule__SimpleModel__VisibilityAssignment_0_0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2681:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:7: ( rule__SimpleModel__VisibilityAssignment_0_0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2682:8: rule__SimpleModel__VisibilityAssignment_0_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_synpred30_InternalUnorderedGroupsTestLanguage5410);
        rule__SimpleModel__VisibilityAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred30_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred31_InternalUnorderedGroupsTestLanguage
    public final void synpred31_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2688:4: ( ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2688:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2688:4: ({...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2689:5: {...}? => ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred31_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2689:108: ( ( ( rule__SimpleModel__StaticAssignment_0_1 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2690:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2696:6: ( ( rule__SimpleModel__StaticAssignment_0_1 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2698:7: ( rule__SimpleModel__StaticAssignment_0_1 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2699:7: ( rule__SimpleModel__StaticAssignment_0_1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2699:8: rule__SimpleModel__StaticAssignment_0_1
        {
        pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_synpred31_InternalUnorderedGroupsTestLanguage5501);
        rule__SimpleModel__StaticAssignment_0_1();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred31_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred32_InternalUnorderedGroupsTestLanguage
    public final void synpred32_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2705:4: ( ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2705:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2705:4: ({...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2706:5: {...}? => ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2706:108: ( ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2707:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2713:6: ( ( rule__SimpleModel__SynchronizedAssignment_0_2 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2715:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2716:7: ( rule__SimpleModel__SynchronizedAssignment_0_2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2716:8: rule__SimpleModel__SynchronizedAssignment_0_2
        {
        pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_synpred32_InternalUnorderedGroupsTestLanguage5592);
        rule__SimpleModel__SynchronizedAssignment_0_2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred32_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred33_InternalUnorderedGroupsTestLanguage
    public final void synpred33_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2754:2: ( rule__SimpleModel__UnorderedGroup_0__1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2754:2: rule__SimpleModel__UnorderedGroup_0__1
        {
        pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_synpred33_InternalUnorderedGroupsTestLanguage5745);
        rule__SimpleModel__UnorderedGroup_0__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred34_InternalUnorderedGroupsTestLanguage
    public final void synpred34_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2767:2: ( rule__SimpleModel__UnorderedGroup_0__2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2767:2: rule__SimpleModel__UnorderedGroup_0__2
        {
        pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_synpred34_InternalUnorderedGroupsTestLanguage5773);
        rule__SimpleModel__UnorderedGroup_0__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred35_InternalUnorderedGroupsTestLanguage
    public final void synpred35_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2780:2: ( rule__SimpleModel__UnorderedGroup_0__3 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2780:2: rule__SimpleModel__UnorderedGroup_0__3
        {
        pushFollow(FollowSets000.FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_synpred35_InternalUnorderedGroupsTestLanguage5801);
        rule__SimpleModel__UnorderedGroup_0__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred36_InternalUnorderedGroupsTestLanguage
    public final void synpred36_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2832:4: ( ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2832:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2832:4: ({...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2833:5: {...}? => ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2833:111: ( ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2834:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2840:6: ( ( rule__MandatoryModel__VisibilityAssignment_0_0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2842:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2843:7: ( rule__MandatoryModel__VisibilityAssignment_0_0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2843:8: rule__MandatoryModel__VisibilityAssignment_0_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_synpred36_InternalUnorderedGroupsTestLanguage5947);
        rule__MandatoryModel__VisibilityAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred36_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred37_InternalUnorderedGroupsTestLanguage
    public final void synpred37_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2849:4: ( ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2849:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2849:4: ({...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2850:5: {...}? => ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred37_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2850:111: ( ( ( rule__MandatoryModel__StaticAssignment_0_1 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2851:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2857:6: ( ( rule__MandatoryModel__StaticAssignment_0_1 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2859:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2860:7: ( rule__MandatoryModel__StaticAssignment_0_1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2860:8: rule__MandatoryModel__StaticAssignment_0_1
        {
        pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_synpred37_InternalUnorderedGroupsTestLanguage6038);
        rule__MandatoryModel__StaticAssignment_0_1();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred37_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred38_InternalUnorderedGroupsTestLanguage
    public final void synpred38_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2866:4: ( ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2866:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2866:4: ({...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2867:5: {...}? => ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred38_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2867:111: ( ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2868:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2874:6: ( ( rule__MandatoryModel__SynchronizedAssignment_0_2 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2876:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2877:7: ( rule__MandatoryModel__SynchronizedAssignment_0_2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2877:8: rule__MandatoryModel__SynchronizedAssignment_0_2
        {
        pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_synpred38_InternalUnorderedGroupsTestLanguage6129);
        rule__MandatoryModel__SynchronizedAssignment_0_2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred38_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred39_InternalUnorderedGroupsTestLanguage
    public final void synpred39_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2915:2: ( rule__MandatoryModel__UnorderedGroup_0__1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2915:2: rule__MandatoryModel__UnorderedGroup_0__1
        {
        pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_synpred39_InternalUnorderedGroupsTestLanguage6282);
        rule__MandatoryModel__UnorderedGroup_0__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred40_InternalUnorderedGroupsTestLanguage
    public final void synpred40_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2928:2: ( rule__MandatoryModel__UnorderedGroup_0__2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2928:2: rule__MandatoryModel__UnorderedGroup_0__2
        {
        pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_synpred40_InternalUnorderedGroupsTestLanguage6310);
        rule__MandatoryModel__UnorderedGroup_0__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred41_InternalUnorderedGroupsTestLanguage
    public final void synpred41_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: ( rule__MandatoryModel__UnorderedGroup_0__3 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2941:2: rule__MandatoryModel__UnorderedGroup_0__3
        {
        pushFollow(FollowSets000.FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_synpred41_InternalUnorderedGroupsTestLanguage6338);
        rule__MandatoryModel__UnorderedGroup_0__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred42_InternalUnorderedGroupsTestLanguage
    public final void synpred42_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:2: ( rule__LoopedModel__UnorderedGroup_0__0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2974:2: rule__LoopedModel__UnorderedGroup_0__0
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_synpred42_InternalUnorderedGroupsTestLanguage6395);
        rule__LoopedModel__UnorderedGroup_0__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred43_InternalUnorderedGroupsTestLanguage
    public final void synpred43_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:8: ( rule__LoopedModel__VisibilityAssignment_0_0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:8: rule__LoopedModel__VisibilityAssignment_0_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_synpred43_InternalUnorderedGroupsTestLanguage6523);
        rule__LoopedModel__VisibilityAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred44_InternalUnorderedGroupsTestLanguage
    public final void synpred44_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2992:4: ( ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2992:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2992:4: ({...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2993:5: {...}? => ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred44_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2993:108: ( ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2994:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3000:6: ( ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3001:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) ) ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3001:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3002:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3003:8: rule__LoopedModel__VisibilityAssignment_0_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_synpred44_InternalUnorderedGroupsTestLanguage6483);
        rule__LoopedModel__VisibilityAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3006:6: ( ( rule__LoopedModel__VisibilityAssignment_0_0 )* )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3007:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:7: ( rule__LoopedModel__VisibilityAssignment_0_0 )*
        loop46:
        do {
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=11 && LA46_0<=13)) ) {
                alt46=1;
            }


            switch (alt46) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3008:8: rule__LoopedModel__VisibilityAssignment_0_0
        	    {
        	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_synpred44_InternalUnorderedGroupsTestLanguage6523);
        	    rule__LoopedModel__VisibilityAssignment_0_0();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop46;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred44_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred45_InternalUnorderedGroupsTestLanguage
    public final void synpred45_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:8: ( rule__LoopedModel__StaticAssignment_0_1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:8: rule__LoopedModel__StaticAssignment_0_1
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_synpred45_InternalUnorderedGroupsTestLanguage6662);
        rule__LoopedModel__StaticAssignment_0_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred46_InternalUnorderedGroupsTestLanguage
    public final void synpred46_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3014:4: ( ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3014:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3014:4: ({...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3015:5: {...}? => ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred46_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3015:108: ( ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3016:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3022:6: ( ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3023:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) ) ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3023:6: ( ( rule__LoopedModel__StaticAssignment_0_1 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3024:7: ( rule__LoopedModel__StaticAssignment_0_1 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:7: ( rule__LoopedModel__StaticAssignment_0_1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3025:8: rule__LoopedModel__StaticAssignment_0_1
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_synpred46_InternalUnorderedGroupsTestLanguage6622);
        rule__LoopedModel__StaticAssignment_0_1();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3028:6: ( ( rule__LoopedModel__StaticAssignment_0_1 )* )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3029:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:7: ( rule__LoopedModel__StaticAssignment_0_1 )*
        loop47:
        do {
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==31) ) {
                alt47=1;
            }


            switch (alt47) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3030:8: rule__LoopedModel__StaticAssignment_0_1
        	    {
        	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_synpred46_InternalUnorderedGroupsTestLanguage6662);
        	    rule__LoopedModel__StaticAssignment_0_1();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop47;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred46_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred47_InternalUnorderedGroupsTestLanguage
    public final void synpred47_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:8: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:8: rule__LoopedModel__SynchronizedAssignment_0_2
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_synpred47_InternalUnorderedGroupsTestLanguage6801);
        rule__LoopedModel__SynchronizedAssignment_0_2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred48_InternalUnorderedGroupsTestLanguage
    public final void synpred48_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3036:4: ( ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3036:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3036:4: ({...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3037:5: {...}? => ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred48_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3037:108: ( ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3038:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3044:6: ( ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3045:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) ) ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3045:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3046:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3047:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3047:8: rule__LoopedModel__SynchronizedAssignment_0_2
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_synpred48_InternalUnorderedGroupsTestLanguage6761);
        rule__LoopedModel__SynchronizedAssignment_0_2();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3050:6: ( ( rule__LoopedModel__SynchronizedAssignment_0_2 )* )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3051:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:7: ( rule__LoopedModel__SynchronizedAssignment_0_2 )*
        loop48:
        do {
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==32) ) {
                alt48=1;
            }


            switch (alt48) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3052:8: rule__LoopedModel__SynchronizedAssignment_0_2
        	    {
        	    pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_synpred48_InternalUnorderedGroupsTestLanguage6801);
        	    rule__LoopedModel__SynchronizedAssignment_0_2();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop48;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred48_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred49_InternalUnorderedGroupsTestLanguage
    public final void synpred49_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:8: ( rule__LoopedModel__Alternatives_0_3 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3074:8: rule__LoopedModel__Alternatives_0_3
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__Alternatives_0_3_in_synpred49_InternalUnorderedGroupsTestLanguage6940);
        rule__LoopedModel__Alternatives_0_3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred50_InternalUnorderedGroupsTestLanguage
    public final void synpred50_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3095:2: ( rule__LoopedModel__UnorderedGroup_0__1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3095:2: rule__LoopedModel__UnorderedGroup_0__1
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_synpred50_InternalUnorderedGroupsTestLanguage7009);
        rule__LoopedModel__UnorderedGroup_0__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred51_InternalUnorderedGroupsTestLanguage
    public final void synpred51_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3108:2: ( rule__LoopedModel__UnorderedGroup_0__2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3108:2: rule__LoopedModel__UnorderedGroup_0__2
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_synpred51_InternalUnorderedGroupsTestLanguage7037);
        rule__LoopedModel__UnorderedGroup_0__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred52_InternalUnorderedGroupsTestLanguage
    public final void synpred52_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3121:2: ( rule__LoopedModel__UnorderedGroup_0__3 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3121:2: rule__LoopedModel__UnorderedGroup_0__3
        {
        pushFollow(FollowSets000.FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_synpred52_InternalUnorderedGroupsTestLanguage7065);
        rule__LoopedModel__UnorderedGroup_0__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred53_InternalUnorderedGroupsTestLanguage
    public final void synpred53_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3173:4: ( ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3173:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3173:4: ({...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3174:5: {...}? => ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred53_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3174:113: ( ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3175:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3181:6: ( ( rule__GroupLoopedModel__VisibilityAssignment_0_0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3183:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3184:7: ( rule__GroupLoopedModel__VisibilityAssignment_0_0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3184:8: rule__GroupLoopedModel__VisibilityAssignment_0_0
        {
        pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_synpred53_InternalUnorderedGroupsTestLanguage7211);
        rule__GroupLoopedModel__VisibilityAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred53_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred54_InternalUnorderedGroupsTestLanguage
    public final void synpred54_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3190:4: ( ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3190:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3190:4: ({...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3191:5: {...}? => ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred54_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3191:113: ( ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3192:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3198:6: ( ( rule__GroupLoopedModel__StaticAssignment_0_1 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3200:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3201:7: ( rule__GroupLoopedModel__StaticAssignment_0_1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3201:8: rule__GroupLoopedModel__StaticAssignment_0_1
        {
        pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_synpred54_InternalUnorderedGroupsTestLanguage7302);
        rule__GroupLoopedModel__StaticAssignment_0_1();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred54_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred55_InternalUnorderedGroupsTestLanguage
    public final void synpred55_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3207:4: ( ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3207:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3207:4: ({...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3208:5: {...}? => ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred55_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3208:113: ( ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3209:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3215:6: ( ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3217:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3218:7: ( rule__GroupLoopedModel__SynchronizedAssignment_0_2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3218:8: rule__GroupLoopedModel__SynchronizedAssignment_0_2
        {
        pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_synpred55_InternalUnorderedGroupsTestLanguage7393);
        rule__GroupLoopedModel__SynchronizedAssignment_0_2();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred55_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred56_InternalUnorderedGroupsTestLanguage
    public final void synpred56_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3256:2: ( rule__GroupLoopedModel__UnorderedGroup_0__1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3256:2: rule__GroupLoopedModel__UnorderedGroup_0__1
        {
        pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_synpred56_InternalUnorderedGroupsTestLanguage7546);
        rule__GroupLoopedModel__UnorderedGroup_0__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred57_InternalUnorderedGroupsTestLanguage
    public final void synpred57_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3269:2: ( rule__GroupLoopedModel__UnorderedGroup_0__2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3269:2: rule__GroupLoopedModel__UnorderedGroup_0__2
        {
        pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_synpred57_InternalUnorderedGroupsTestLanguage7574);
        rule__GroupLoopedModel__UnorderedGroup_0__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred58_InternalUnorderedGroupsTestLanguage
    public final void synpred58_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: ( rule__GroupLoopedModel__UnorderedGroup_0__3 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3282:2: rule__GroupLoopedModel__UnorderedGroup_0__3
        {
        pushFollow(FollowSets000.FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_synpred58_InternalUnorderedGroupsTestLanguage7602);
        rule__GroupLoopedModel__UnorderedGroup_0__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred59_InternalUnorderedGroupsTestLanguage
    public final void synpred59_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3315:2: ( rule__Bug304681Model__UnorderedGroup_2__0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3315:2: rule__Bug304681Model__UnorderedGroup_2__0
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__0_in_synpred59_InternalUnorderedGroupsTestLanguage7659);
        rule__Bug304681Model__UnorderedGroup_2__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred60_InternalUnorderedGroupsTestLanguage
    public final void synpred60_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3333:4: ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3333:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3333:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3334:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred60_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3334:111: ( ( ( rule__Bug304681Model__Group_2_0__0 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3335:6: ( ( rule__Bug304681Model__Group_2_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3341:6: ( ( rule__Bug304681Model__Group_2_0__0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3343:7: ( rule__Bug304681Model__Group_2_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getBug304681ModelAccess().getGroup_2_0()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3344:7: ( rule__Bug304681Model__Group_2_0__0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3344:8: rule__Bug304681Model__Group_2_0__0
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_0__0_in_synpred60_InternalUnorderedGroupsTestLanguage7746);
        rule__Bug304681Model__Group_2_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred60_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred61_InternalUnorderedGroupsTestLanguage
    public final void synpred61_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3350:4: ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3350:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3350:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3351:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred61_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3351:111: ( ( ( rule__Bug304681Model__Group_2_1__0 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3352:6: ( ( rule__Bug304681Model__Group_2_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3358:6: ( ( rule__Bug304681Model__Group_2_1__0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3360:7: ( rule__Bug304681Model__Group_2_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getBug304681ModelAccess().getGroup_2_1()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3361:7: ( rule__Bug304681Model__Group_2_1__0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3361:8: rule__Bug304681Model__Group_2_1__0
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_1__0_in_synpred61_InternalUnorderedGroupsTestLanguage7837);
        rule__Bug304681Model__Group_2_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred61_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred62_InternalUnorderedGroupsTestLanguage
    public final void synpred62_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3367:4: ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3367:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3367:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3368:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred62_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3368:111: ( ( ( rule__Bug304681Model__Group_2_2__0 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3369:6: ( ( rule__Bug304681Model__Group_2_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3375:6: ( ( rule__Bug304681Model__Group_2_2__0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3377:7: ( rule__Bug304681Model__Group_2_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getBug304681ModelAccess().getGroup_2_2()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3378:7: ( rule__Bug304681Model__Group_2_2__0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3378:8: rule__Bug304681Model__Group_2_2__0
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_2__0_in_synpred62_InternalUnorderedGroupsTestLanguage7928);
        rule__Bug304681Model__Group_2_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred62_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred63_InternalUnorderedGroupsTestLanguage
    public final void synpred63_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3384:4: ( ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3384:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3384:4: ({...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3385:5: {...}? => ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred63_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3385:111: ( ( ( rule__Bug304681Model__Group_2_3__0 ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3386:6: ( ( rule__Bug304681Model__Group_2_3__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3392:6: ( ( rule__Bug304681Model__Group_2_3__0 ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3394:7: ( rule__Bug304681Model__Group_2_3__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getBug304681ModelAccess().getGroup_2_3()); 
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3395:7: ( rule__Bug304681Model__Group_2_3__0 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3395:8: rule__Bug304681Model__Group_2_3__0
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__Group_2_3__0_in_synpred63_InternalUnorderedGroupsTestLanguage8019);
        rule__Bug304681Model__Group_2_3__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred63_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred64_InternalUnorderedGroupsTestLanguage
    public final void synpred64_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3417:8: ( rule__Bug304681Model__FeaturesAssignment_2_4 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3417:8: rule__Bug304681Model__FeaturesAssignment_2_4
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_synpred64_InternalUnorderedGroupsTestLanguage8151);
        rule__Bug304681Model__FeaturesAssignment_2_4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred65_InternalUnorderedGroupsTestLanguage
    public final void synpred65_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3438:2: ( rule__Bug304681Model__UnorderedGroup_2__1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3438:2: rule__Bug304681Model__UnorderedGroup_2__1
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__1_in_synpred65_InternalUnorderedGroupsTestLanguage8220);
        rule__Bug304681Model__UnorderedGroup_2__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred66_InternalUnorderedGroupsTestLanguage
    public final void synpred66_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3451:2: ( rule__Bug304681Model__UnorderedGroup_2__2 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3451:2: rule__Bug304681Model__UnorderedGroup_2__2
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__2_in_synpred66_InternalUnorderedGroupsTestLanguage8248);
        rule__Bug304681Model__UnorderedGroup_2__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred67_InternalUnorderedGroupsTestLanguage
    public final void synpred67_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3464:2: ( rule__Bug304681Model__UnorderedGroup_2__3 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3464:2: rule__Bug304681Model__UnorderedGroup_2__3
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__3_in_synpred67_InternalUnorderedGroupsTestLanguage8276);
        rule__Bug304681Model__UnorderedGroup_2__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred68_InternalUnorderedGroupsTestLanguage
    public final void synpred68_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3477:2: ( rule__Bug304681Model__UnorderedGroup_2__4 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalUnorderedGroupsTestLanguage.g:3477:2: rule__Bug304681Model__UnorderedGroup_2__4
        {
        pushFollow(FollowSets000.FOLLOW_rule__Bug304681Model__UnorderedGroup_2__4_in_synpred68_InternalUnorderedGroupsTestLanguage8304);
        rule__Bug304681Model__UnorderedGroup_2__4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_InternalUnorderedGroupsTestLanguage

    // Delegated rules

    public final boolean synpred35_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA36 dfa36 = new DFA36(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA36_eotS =
        "\12\uffff";
    static final String DFA36_eofS =
        "\1\10\11\uffff";
    static final String DFA36_minS =
        "\1\13\7\0\2\uffff";
    static final String DFA36_maxS =
        "\1\42\7\0\2\uffff";
    static final String DFA36_acceptS =
        "\10\uffff\1\2\1\1";
    static final String DFA36_specialS =
        "\1\7\1\4\1\0\1\6\1\3\1\2\1\1\1\5\2\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\2\1\3\6\uffff\1\10\12\uffff\1\4\1\5\1\6\1\7",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "3256:2: ( rule__GroupLoopedModel__UnorderedGroup_0__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred56_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_6 = input.LA(1);

                         
                        int index36_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred56_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 8;}

                         
                        input.seek(index36_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_5 = input.LA(1);

                         
                        int index36_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred56_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 8;}

                         
                        input.seek(index36_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA36_4 = input.LA(1);

                         
                        int index36_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred56_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 8;}

                         
                        input.seek(index36_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA36_1 = input.LA(1);

                         
                        int index36_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred56_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index36_1);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA36_7 = input.LA(1);

                         
                        int index36_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred56_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 8;}

                         
                        input.seek(index36_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA36_3 = input.LA(1);

                         
                        int index36_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred56_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index36_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA36_0 = input.LA(1);

                         
                        int index36_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA36_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 1;}

                        else if ( LA36_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 2;}

                        else if ( LA36_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 3;}

                        else if ( LA36_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 4;}

                        else if ( LA36_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 5;}

                        else if ( LA36_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 6;}

                        else if ( LA36_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 7;}

                        else if ( (LA36_0==EOF||LA36_0==20) ) {s = 8;}

                         
                        input.seek(index36_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\12\uffff";
    static final String DFA37_eofS =
        "\1\10\11\uffff";
    static final String DFA37_minS =
        "\1\13\7\0\2\uffff";
    static final String DFA37_maxS =
        "\1\42\7\0\2\uffff";
    static final String DFA37_acceptS =
        "\10\uffff\1\2\1\1";
    static final String DFA37_specialS =
        "\1\7\1\1\1\4\1\0\1\2\1\3\1\5\1\6\2\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1\1\2\1\3\6\uffff\1\10\12\uffff\1\4\1\5\1\6\1\7",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "3269:2: ( rule__GroupLoopedModel__UnorderedGroup_0__2 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_3 = input.LA(1);

                         
                        int index37_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred57_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index37_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred57_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_4 = input.LA(1);

                         
                        int index37_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred57_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 8;}

                         
                        input.seek(index37_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_5 = input.LA(1);

                         
                        int index37_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred57_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 8;}

                         
                        input.seek(index37_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred57_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA37_6 = input.LA(1);

                         
                        int index37_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred57_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 8;}

                         
                        input.seek(index37_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA37_7 = input.LA(1);

                         
                        int index37_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred57_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 8;}

                         
                        input.seek(index37_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA37_0 = input.LA(1);

                         
                        int index37_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA37_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 1;}

                        else if ( LA37_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 2;}

                        else if ( LA37_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 3;}

                        else if ( LA37_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 4;}

                        else if ( LA37_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 5;}

                        else if ( LA37_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 6;}

                        else if ( LA37_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 7;}

                        else if ( (LA37_0==EOF||LA37_0==20) ) {s = 8;}

                         
                        input.seek(index37_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\12\uffff";
    static final String DFA38_eofS =
        "\1\10\11\uffff";
    static final String DFA38_minS =
        "\1\13\7\0\2\uffff";
    static final String DFA38_maxS =
        "\1\42\7\0\2\uffff";
    static final String DFA38_acceptS =
        "\10\uffff\1\2\1\1";
    static final String DFA38_specialS =
        "\1\5\1\7\1\1\1\6\1\3\1\4\1\0\1\2\2\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\1\2\1\3\6\uffff\1\10\12\uffff\1\4\1\5\1\6\1\7",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "3282:2: ( rule__GroupLoopedModel__UnorderedGroup_0__3 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_6 = input.LA(1);

                         
                        int index38_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred58_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 8;}

                         
                        input.seek(index38_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_2 = input.LA(1);

                         
                        int index38_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred58_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index38_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA38_7 = input.LA(1);

                         
                        int index38_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred58_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 8;}

                         
                        input.seek(index38_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA38_4 = input.LA(1);

                         
                        int index38_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred58_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 8;}

                         
                        input.seek(index38_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA38_5 = input.LA(1);

                         
                        int index38_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred58_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 8;}

                         
                        input.seek(index38_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA38_0 = input.LA(1);

                         
                        int index38_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA38_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 1;}

                        else if ( LA38_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 2;}

                        else if ( LA38_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 3;}

                        else if ( LA38_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 4;}

                        else if ( LA38_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 5;}

                        else if ( LA38_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 6;}

                        else if ( LA38_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 7;}

                        else if ( (LA38_0==EOF||LA38_0==20) ) {s = 8;}

                         
                        input.seek(index38_0);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA38_3 = input.LA(1);

                         
                        int index38_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred58_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index38_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA38_1 = input.LA(1);

                         
                        int index38_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred58_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 8;}

                         
                        input.seek(index38_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleModel134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__0_in_ruleSimpleModel160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryModel194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__0_in_ruleMandatoryModel220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedModel254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__0_in_ruleLoopedModel280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupLoopedModel314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__0_in_ruleGroupLoopedModel340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedAlternativeModel374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__0_in_ruleLoopedAlternativeModel400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Model434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__0_in_ruleBug304681Model460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Feature494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Feature__Alternatives_in_ruleBug304681Feature520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Attribute554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__0_in_ruleBug304681Attribute580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference607 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Reference614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__0_in_ruleBug304681Reference640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_4__0_in_rule__Model__Alternatives748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_5__0_in_rule__Model__Alternatives766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__SimpleModel__VisibilityAlternatives_0_0_0800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__SimpleModel__VisibilityAlternatives_0_0_0820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SimpleModel__VisibilityAlternatives_0_0_0840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__AbstractAssignment_0_3_0_in_rule__SimpleModel__Alternatives_0_3874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__FinalAssignment_0_3_1_in_rule__SimpleModel__Alternatives_0_3892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__MandatoryModel__VisibilityAlternatives_0_0_0966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__AbstractAssignment_0_3_0_in_rule__MandatoryModel__Alternatives_0_31000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__FinalAssignment_0_3_1_in_rule__MandatoryModel__Alternatives_0_31018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LoopedModel__VisibilityAlternatives_0_0_01052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LoopedModel__VisibilityAlternatives_0_0_01072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LoopedModel__VisibilityAlternatives_0_0_01092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__AbstractAssignment_0_3_0_in_rule__LoopedModel__Alternatives_0_31126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__FinalAssignment_0_3_1_in_rule__LoopedModel__Alternatives_0_31144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__GroupLoopedModel__VisibilityAlternatives_0_0_01218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__AbstractAssignment_0_3_0_in_rule__GroupLoopedModel__Alternatives_0_31252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__FinalAssignment_0_3_1_in_rule__GroupLoopedModel__Alternatives_0_31270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__VisibilityAssignment_0_0_in_rule__LoopedAlternativeModel__Alternatives_01303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__StaticAssignment_0_1_in_rule__LoopedAlternativeModel__Alternatives_01321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__SynchronizedAssignment_0_2_in_rule__LoopedAlternativeModel__Alternatives_01339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_3_in_rule__LoopedAlternativeModel__Alternatives_01357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0_in_rule__LoopedAlternativeModel__Alternatives_01375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_01449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__AbstractAssignment_0_3_0_in_rule__LoopedAlternativeModel__Alternatives_0_31483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__FinalAssignment_0_3_1_in_rule__LoopedAlternativeModel__Alternatives_0_31501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_rule__Bug304681Feature__Alternatives1534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_rule__Bug304681Feature__Alternatives1551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__01581 = new BitSet(new long[]{0x0000000780003800L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__01584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group_0__0__Impl1612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__11643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FirstAssignment_0_1_in_rule__Model__Group_0__1__Impl1670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__01704 = new BitSet(new long[]{0x0000000780003800L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_1__0__Impl1735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__SecondAssignment_1_1_in_rule__Model__Group_1__1__Impl1793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__01827 = new BitSet(new long[]{0x0000000780003800L});
        public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__01830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__Group_2__0__Impl1858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__11889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ThrirdAssignment_2_1_in_rule__Model__Group_2__1__Impl1916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__0__Impl_in_rule__Model__Group_3__01950 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__01953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__Group_3__0__Impl1981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__1__Impl_in_rule__Model__Group_3__12012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ForthAssignment_3_1_in_rule__Model__Group_3__1__Impl2039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_4__0__Impl_in_rule__Model__Group_4__02073 = new BitSet(new long[]{0x0000000780903800L});
        public static final BitSet FOLLOW_rule__Model__Group_4__1_in_rule__Model__Group_4__02076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Model__Group_4__0__Impl2104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_4__1__Impl_in_rule__Model__Group_4__12135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__FifthAssignment_4_1_in_rule__Model__Group_4__1__Impl2162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_5__0__Impl_in_rule__Model__Group_5__02196 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Model__Group_5__1_in_rule__Model__Group_5__02199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Model__Group_5__0__Impl2227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_5__1__Impl_in_rule__Model__Group_5__12258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ModelAssignment_5_1_in_rule__Model__Group_5__1__Impl2285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__0__Impl_in_rule__SimpleModel__Group__02319 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__1_in_rule__SimpleModel__Group__02322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0_in_rule__SimpleModel__Group__0__Impl2349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__1__Impl_in_rule__SimpleModel__Group__12379 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__2_in_rule__SimpleModel__Group__12382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SimpleModel__Group__1__Impl2410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__2__Impl_in_rule__SimpleModel__Group__22441 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__3_in_rule__SimpleModel__Group__22444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__NameAssignment_2_in_rule__SimpleModel__Group__2__Impl2471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__3__Impl_in_rule__SimpleModel__Group__32501 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__4_in_rule__SimpleModel__Group__32504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SimpleModel__Group__3__Impl2532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Group__4__Impl_in_rule__SimpleModel__Group__42563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SimpleModel__Group__4__Impl2591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__0__Impl_in_rule__MandatoryModel__Group__02632 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__1_in_rule__MandatoryModel__Group__02635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0_in_rule__MandatoryModel__Group__0__Impl2662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__1__Impl_in_rule__MandatoryModel__Group__12692 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__2_in_rule__MandatoryModel__Group__12695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__MandatoryModel__Group__1__Impl2723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__2__Impl_in_rule__MandatoryModel__Group__22754 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__3_in_rule__MandatoryModel__Group__22757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__NameAssignment_2_in_rule__MandatoryModel__Group__2__Impl2784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__3__Impl_in_rule__MandatoryModel__Group__32814 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__4_in_rule__MandatoryModel__Group__32817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MandatoryModel__Group__3__Impl2845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Group__4__Impl_in_rule__MandatoryModel__Group__42876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__MandatoryModel__Group__4__Impl2904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__0__Impl_in_rule__LoopedModel__Group__02945 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__1_in_rule__LoopedModel__Group__02948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0_in_rule__LoopedModel__Group__0__Impl2975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__1__Impl_in_rule__LoopedModel__Group__13005 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__2_in_rule__LoopedModel__Group__13008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LoopedModel__Group__1__Impl3036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__2__Impl_in_rule__LoopedModel__Group__23067 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__3_in_rule__LoopedModel__Group__23070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__NameAssignment_2_in_rule__LoopedModel__Group__2__Impl3097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__3__Impl_in_rule__LoopedModel__Group__33127 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__4_in_rule__LoopedModel__Group__33130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LoopedModel__Group__3__Impl3158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Group__4__Impl_in_rule__LoopedModel__Group__43189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LoopedModel__Group__4__Impl3217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__0__Impl_in_rule__GroupLoopedModel__Group__03258 = new BitSet(new long[]{0x0000000780103800L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__1_in_rule__GroupLoopedModel__Group__03261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_rule__GroupLoopedModel__Group__0__Impl3288 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__1__Impl_in_rule__GroupLoopedModel__Group__13319 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__2_in_rule__GroupLoopedModel__Group__13322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__GroupLoopedModel__Group__1__Impl3350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__2__Impl_in_rule__GroupLoopedModel__Group__23381 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__3_in_rule__GroupLoopedModel__Group__23384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__NameAssignment_2_in_rule__GroupLoopedModel__Group__2__Impl3411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__3__Impl_in_rule__GroupLoopedModel__Group__33441 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__4_in_rule__GroupLoopedModel__Group__33444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__GroupLoopedModel__Group__3__Impl3472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Group__4__Impl_in_rule__GroupLoopedModel__Group__43503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__GroupLoopedModel__Group__4__Impl3531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__0__Impl_in_rule__LoopedAlternativeModel__Group__03572 = new BitSet(new long[]{0x0000000780903800L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__1_in_rule__LoopedAlternativeModel__Group__03575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Alternatives_0_in_rule__LoopedAlternativeModel__Group__0__Impl3602 = new BitSet(new long[]{0x0000000780803802L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__1__Impl_in_rule__LoopedAlternativeModel__Group__13633 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__2_in_rule__LoopedAlternativeModel__Group__13636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LoopedAlternativeModel__Group__1__Impl3664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__2__Impl_in_rule__LoopedAlternativeModel__Group__23695 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__3_in_rule__LoopedAlternativeModel__Group__23698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__NameAssignment_2_in_rule__LoopedAlternativeModel__Group__2__Impl3725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__3__Impl_in_rule__LoopedAlternativeModel__Group__33755 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__4_in_rule__LoopedAlternativeModel__Group__33758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LoopedAlternativeModel__Group__3__Impl3786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group__4__Impl_in_rule__LoopedAlternativeModel__Group__43817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LoopedAlternativeModel__Group__4__Impl3845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__0__Impl_in_rule__LoopedAlternativeModel__Group_0_4__03886 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1_in_rule__LoopedAlternativeModel__Group_0_4__03889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LoopedAlternativeModel__Group_0_4__0__Impl3917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__Group_0_4__1__Impl_in_rule__LoopedAlternativeModel__Group_0_4__13948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LoopedAlternativeModel__Group_0_4__1__Impl3977 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__0__Impl_in_rule__Bug304681Model__Group__04014 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__1_in_rule__Bug304681Model__Group__04017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__1__Impl_in_rule__Bug304681Model__Group__14075 = new BitSet(new long[]{0x000000087A000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__2_in_rule__Bug304681Model__Group__14078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Bug304681Model__Group__1__Impl4106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__2__Impl_in_rule__Bug304681Model__Group__24137 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__3_in_rule__Bug304681Model__Group__24140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2_in_rule__Bug304681Model__Group__2__Impl4167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group__3__Impl_in_rule__Bug304681Model__Group__34197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Bug304681Model__Group__3__Impl4225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__0__Impl_in_rule__Bug304681Model__Group_2_0__04264 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__1_in_rule__Bug304681Model__Group_2_0__04267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Bug304681Model__Group_2_0__0__Impl4295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__1__Impl_in_rule__Bug304681Model__Group_2_0__14326 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__2_in_rule__Bug304681Model__Group_2_0__14329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__ShortDescriptionAssignment_2_0_1_in_rule__Bug304681Model__Group_2_0__1__Impl4356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__2__Impl_in_rule__Bug304681Model__Group_2_0__24386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_0__2__Impl4414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__0__Impl_in_rule__Bug304681Model__Group_2_1__04451 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__1_in_rule__Bug304681Model__Group_2_1__04454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Bug304681Model__Group_2_1__0__Impl4482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__1__Impl_in_rule__Bug304681Model__Group_2_1__14513 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__2_in_rule__Bug304681Model__Group_2_1__14516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__LongDescriptionAssignment_2_1_1_in_rule__Bug304681Model__Group_2_1__1__Impl4543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__2__Impl_in_rule__Bug304681Model__Group_2_1__24573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_1__2__Impl4601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__0__Impl_in_rule__Bug304681Model__Group_2_2__04638 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__1_in_rule__Bug304681Model__Group_2_2__04641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Bug304681Model__Group_2_2__0__Impl4669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__1__Impl_in_rule__Bug304681Model__Group_2_2__14700 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__2_in_rule__Bug304681Model__Group_2_2__14703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UidAssignment_2_2_1_in_rule__Bug304681Model__Group_2_2__1__Impl4730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__2__Impl_in_rule__Bug304681Model__Group_2_2__24760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_2__2__Impl4788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__0__Impl_in_rule__Bug304681Model__Group_2_3__04825 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__1_in_rule__Bug304681Model__Group_2_3__04828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FlagAssignment_2_3_0_in_rule__Bug304681Model__Group_2_3__0__Impl4855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__1__Impl_in_rule__Bug304681Model__Group_2_3__14885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Model__Group_2_3__1__Impl4913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__0__Impl_in_rule__Bug304681Attribute__Group__04948 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__1_in_rule__Bug304681Attribute__Group__04951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__Bug304681Attribute__Group__0__Impl4979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__1__Impl_in_rule__Bug304681Attribute__Group__15010 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__2_in_rule__Bug304681Attribute__Group__15013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__NameAssignment_1_in_rule__Bug304681Attribute__Group__1__Impl5040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Attribute__Group__2__Impl_in_rule__Bug304681Attribute__Group__25070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Attribute__Group__2__Impl5098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__0__Impl_in_rule__Bug304681Reference__Group__05135 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__1_in_rule__Bug304681Reference__Group__05138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__Bug304681Reference__Group__0__Impl5166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__1__Impl_in_rule__Bug304681Reference__Group__15197 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__2_in_rule__Bug304681Reference__Group__15200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__NameAssignment_1_in_rule__Bug304681Reference__Group__1__Impl5227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Reference__Group__2__Impl_in_rule__Bug304681Reference__Group__25257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Bug304681Reference__Group__2__Impl5285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_rule__SimpleModel__UnorderedGroup_05323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_rule__SimpleModel__UnorderedGroup_0__Impl5410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_rule__SimpleModel__UnorderedGroup_0__Impl5501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_rule__SimpleModel__UnorderedGroup_0__Impl5592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__Alternatives_0_3_in_rule__SimpleModel__UnorderedGroup_0__Impl5683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__05742 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_rule__SimpleModel__UnorderedGroup_0__05745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__15770 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_rule__SimpleModel__UnorderedGroup_0__15773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__25798 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_rule__SimpleModel__UnorderedGroup_0__25801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__Impl_in_rule__SimpleModel__UnorderedGroup_0__35826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__0_in_rule__MandatoryModel__UnorderedGroup_05858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_rule__MandatoryModel__UnorderedGroup_0__Impl5947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_rule__MandatoryModel__UnorderedGroup_0__Impl6038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_rule__MandatoryModel__UnorderedGroup_0__Impl6129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__Alternatives_0_3_in_rule__MandatoryModel__UnorderedGroup_0__Impl6220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__06279 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_rule__MandatoryModel__UnorderedGroup_0__06282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__16307 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_rule__MandatoryModel__UnorderedGroup_0__16310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__26335 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_rule__MandatoryModel__UnorderedGroup_0__26338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__Impl_in_rule__MandatoryModel__UnorderedGroup_0__36363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_rule__LoopedModel__UnorderedGroup_06395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6483 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_rule__LoopedModel__UnorderedGroup_0__Impl6523 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6622 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_rule__LoopedModel__UnorderedGroup_0__Impl6662 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6761 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_rule__LoopedModel__UnorderedGroup_0__Impl6801 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6900 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_rule__LoopedModel__UnorderedGroup_0__Impl6940 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__07006 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_rule__LoopedModel__UnorderedGroup_0__07009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__17034 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_rule__LoopedModel__UnorderedGroup_0__17037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__27062 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_rule__LoopedModel__UnorderedGroup_0__27065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__Impl_in_rule__LoopedModel__UnorderedGroup_0__37090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__0_in_rule__GroupLoopedModel__UnorderedGroup_07122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__Alternatives_0_3_in_rule__GroupLoopedModel__UnorderedGroup_0__Impl7484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__07543 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_rule__GroupLoopedModel__UnorderedGroup_0__07546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__17571 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_rule__GroupLoopedModel__UnorderedGroup_0__17574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__27599 = new BitSet(new long[]{0x0000000780003802L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_rule__GroupLoopedModel__UnorderedGroup_0__27602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__Impl_in_rule__GroupLoopedModel__UnorderedGroup_0__37627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__0_in_rule__Bug304681Model__UnorderedGroup_27659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl7928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__0_in_rule__Bug304681Model__UnorderedGroup_2__Impl8019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8111 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_rule__Bug304681Model__UnorderedGroup_2__Impl8151 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__08217 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__1_in_rule__Bug304681Model__UnorderedGroup_2__08220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__18245 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__2_in_rule__Bug304681Model__UnorderedGroup_2__18248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__28273 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__3_in_rule__Bug304681Model__UnorderedGroup_2__28276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__38301 = new BitSet(new long[]{0x000000087A000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__4_in_rule__Bug304681Model__UnorderedGroup_2__38304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__Impl_in_rule__Bug304681Model__UnorderedGroup_2__48329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_rule__Model__FirstAssignment_0_18367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_rule__Model__SecondAssignment_1_18398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_rule__Model__ThrirdAssignment_2_18429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_rule__Model__ForthAssignment_3_18460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_rule__Model__FifthAssignment_4_18491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_rule__Model__ModelAssignment_5_18522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAlternatives_0_0_0_in_rule__SimpleModel__VisibilityAssignment_0_08553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SimpleModel__StaticAssignment_0_18591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SimpleModel__SynchronizedAssignment_0_28635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SimpleModel__AbstractAssignment_0_3_08679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SimpleModel__FinalAssignment_0_3_18723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleModel__NameAssignment_28762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAlternatives_0_0_0_in_rule__MandatoryModel__VisibilityAssignment_0_08793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MandatoryModel__StaticAssignment_0_18831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__MandatoryModel__SynchronizedAssignment_0_28875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__MandatoryModel__AbstractAssignment_0_3_08919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__MandatoryModel__FinalAssignment_0_3_18963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MandatoryModel__NameAssignment_29002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAlternatives_0_0_0_in_rule__LoopedModel__VisibilityAssignment_0_09033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedModel__StaticAssignment_0_19071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedModel__SynchronizedAssignment_0_29115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedModel__AbstractAssignment_0_3_09159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedModel__FinalAssignment_0_3_19203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedModel__NameAssignment_29242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAlternatives_0_0_0_in_rule__GroupLoopedModel__VisibilityAssignment_0_09273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__GroupLoopedModel__StaticAssignment_0_19311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__GroupLoopedModel__SynchronizedAssignment_0_29355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__GroupLoopedModel__AbstractAssignment_0_3_09399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__GroupLoopedModel__FinalAssignment_0_3_19443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__GroupLoopedModel__NameAssignment_29482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0_in_rule__LoopedAlternativeModel__VisibilityAssignment_0_09513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LoopedAlternativeModel__StaticAssignment_0_19551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LoopedAlternativeModel__SynchronizedAssignment_0_29595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LoopedAlternativeModel__AbstractAssignment_0_3_09639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LoopedAlternativeModel__FinalAssignment_0_3_19683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__LoopedAlternativeModel__NameAssignment_29722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__ShortDescriptionAssignment_2_0_19753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__LongDescriptionAssignment_2_1_19784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Bug304681Model__UidAssignment_2_2_19815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__Bug304681Model__FlagAssignment_2_3_09851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_rule__Bug304681Model__FeaturesAssignment_2_49890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Attribute__NameAssignment_19921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Bug304681Reference__NameAssignment_19952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0_in_synpred26_InternalUnorderedGroupsTestLanguage3288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__0_in_synpred29_InternalUnorderedGroupsTestLanguage5323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__VisibilityAssignment_0_0_in_synpred30_InternalUnorderedGroupsTestLanguage5410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__StaticAssignment_0_1_in_synpred31_InternalUnorderedGroupsTestLanguage5501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__SynchronizedAssignment_0_2_in_synpred32_InternalUnorderedGroupsTestLanguage5592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__1_in_synpred33_InternalUnorderedGroupsTestLanguage5745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__2_in_synpred34_InternalUnorderedGroupsTestLanguage5773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SimpleModel__UnorderedGroup_0__3_in_synpred35_InternalUnorderedGroupsTestLanguage5801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__VisibilityAssignment_0_0_in_synpred36_InternalUnorderedGroupsTestLanguage5947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__StaticAssignment_0_1_in_synpred37_InternalUnorderedGroupsTestLanguage6038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__SynchronizedAssignment_0_2_in_synpred38_InternalUnorderedGroupsTestLanguage6129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__1_in_synpred39_InternalUnorderedGroupsTestLanguage6282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__2_in_synpred40_InternalUnorderedGroupsTestLanguage6310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MandatoryModel__UnorderedGroup_0__3_in_synpred41_InternalUnorderedGroupsTestLanguage6338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__0_in_synpred42_InternalUnorderedGroupsTestLanguage6395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_synpred43_InternalUnorderedGroupsTestLanguage6523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_synpred44_InternalUnorderedGroupsTestLanguage6483 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__VisibilityAssignment_0_0_in_synpred44_InternalUnorderedGroupsTestLanguage6523 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_synpred45_InternalUnorderedGroupsTestLanguage6662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_synpred46_InternalUnorderedGroupsTestLanguage6622 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__StaticAssignment_0_1_in_synpred46_InternalUnorderedGroupsTestLanguage6662 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_synpred47_InternalUnorderedGroupsTestLanguage6801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_synpred48_InternalUnorderedGroupsTestLanguage6761 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__SynchronizedAssignment_0_2_in_synpred48_InternalUnorderedGroupsTestLanguage6801 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__Alternatives_0_3_in_synpred49_InternalUnorderedGroupsTestLanguage6940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__1_in_synpred50_InternalUnorderedGroupsTestLanguage7009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__2_in_synpred51_InternalUnorderedGroupsTestLanguage7037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LoopedModel__UnorderedGroup_0__3_in_synpred52_InternalUnorderedGroupsTestLanguage7065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__VisibilityAssignment_0_0_in_synpred53_InternalUnorderedGroupsTestLanguage7211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__StaticAssignment_0_1_in_synpred54_InternalUnorderedGroupsTestLanguage7302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__SynchronizedAssignment_0_2_in_synpred55_InternalUnorderedGroupsTestLanguage7393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__1_in_synpred56_InternalUnorderedGroupsTestLanguage7546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__2_in_synpred57_InternalUnorderedGroupsTestLanguage7574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__GroupLoopedModel__UnorderedGroup_0__3_in_synpred58_InternalUnorderedGroupsTestLanguage7602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__0_in_synpred59_InternalUnorderedGroupsTestLanguage7659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_0__0_in_synpred60_InternalUnorderedGroupsTestLanguage7746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_1__0_in_synpred61_InternalUnorderedGroupsTestLanguage7837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_2__0_in_synpred62_InternalUnorderedGroupsTestLanguage7928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__Group_2_3__0_in_synpred63_InternalUnorderedGroupsTestLanguage8019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__FeaturesAssignment_2_4_in_synpred64_InternalUnorderedGroupsTestLanguage8151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__1_in_synpred65_InternalUnorderedGroupsTestLanguage8220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__2_in_synpred66_InternalUnorderedGroupsTestLanguage8248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__3_in_synpred67_InternalUnorderedGroupsTestLanguage8276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Bug304681Model__UnorderedGroup_2__4_in_synpred68_InternalUnorderedGroupsTestLanguage8304 = new BitSet(new long[]{0x0000000000000002L});
    }


}