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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug303200TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalBug303200TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LT", "RULE_ID", "RULE_WS", "';'", "'function'", "'['", "']'", "'('", "')'", "','", "'{'", "'}'", "'.'"
    };
    public static final int RULE_LT=4;
    public static final int RULE_ID=5;
    public static final int RULE_WS=6;
    public static final int EOF=-1;

        public InternalBug303200TestLanguageParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[164+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g"; }


     
     	private Bug303200TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug303200TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleProgram
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:61:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:62:1: ( ruleProgram EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:63:1: ruleProgram EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram67);
            ruleProgram();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getProgramRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram74); if (failed) return ;

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
    // $ANTLR end entryRuleProgram


    // $ANTLR start ruleProgram
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:70:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:74:2: ( ( ( rule__Program__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:75:1: ( ( rule__Program__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:75:1: ( ( rule__Program__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:76:1: ( rule__Program__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:77:1: ( rule__Program__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:77:2: rule__Program__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__0_in_ruleProgram100);
            rule__Program__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getGroup()); 
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
    // $ANTLR end ruleProgram


    // $ANTLR start entryRuleProgramDirective
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:89:1: entryRuleProgramDirective : ruleProgramDirective EOF ;
    public final void entryRuleProgramDirective() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:90:1: ( ruleProgramDirective EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:91:1: ruleProgramDirective EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramDirectiveRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProgramDirective_in_entryRuleProgramDirective127);
            ruleProgramDirective();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getProgramDirectiveRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgramDirective134); if (failed) return ;

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
    // $ANTLR end entryRuleProgramDirective


    // $ANTLR start ruleProgramDirective
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:98:1: ruleProgramDirective : ( ( rule__ProgramDirective__Alternatives ) ) ;
    public final void ruleProgramDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:102:2: ( ( ( rule__ProgramDirective__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:103:1: ( ( rule__ProgramDirective__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:103:1: ( ( rule__ProgramDirective__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:104:1: ( rule__ProgramDirective__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramDirectiveAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:105:1: ( rule__ProgramDirective__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:105:2: rule__ProgramDirective__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProgramDirective__Alternatives_in_ruleProgramDirective160);
            rule__ProgramDirective__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramDirectiveAccess().getAlternatives()); 
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
    // $ANTLR end ruleProgramDirective


    // $ANTLR start entryRuleFunctionDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:117:1: entryRuleFunctionDefinition : ruleFunctionDefinition EOF ;
    public final void entryRuleFunctionDefinition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:118:1: ( ruleFunctionDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:119:1: ruleFunctionDefinition EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition187);
            ruleFunctionDefinition();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFunctionDefinition194); if (failed) return ;

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
    // $ANTLR end entryRuleFunctionDefinition


    // $ANTLR start ruleFunctionDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:126:1: ruleFunctionDefinition : ( ( rule__FunctionDefinition__Group__0 ) ) ;
    public final void ruleFunctionDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:130:2: ( ( ( rule__FunctionDefinition__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:131:1: ( ( rule__FunctionDefinition__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:131:1: ( ( rule__FunctionDefinition__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:132:1: ( rule__FunctionDefinition__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:133:1: ( rule__FunctionDefinition__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:133:2: rule__FunctionDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__0_in_ruleFunctionDefinition220);
            rule__FunctionDefinition__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getGroup()); 
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
    // $ANTLR end ruleFunctionDefinition


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:145:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:146:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:147:1: ruleAttribute EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute247);
            ruleAttribute();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute254); if (failed) return ;

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:154:1: ruleAttribute : ( ( rule__Attribute__Alternatives ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:158:2: ( ( ( rule__Attribute__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:159:1: ( ( rule__Attribute__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:159:1: ( ( rule__Attribute__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:160:1: ( rule__Attribute__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:161:1: ( rule__Attribute__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:161:2: rule__Attribute__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Alternatives_in_ruleAttribute280);
            rule__Attribute__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getAlternatives()); 
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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleParameters
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:173:1: entryRuleParameters : ruleParameters EOF ;
    public final void entryRuleParameters() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:174:1: ( ruleParameters EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:175:1: ruleParameters EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameters_in_entryRuleParameters307);
            ruleParameters();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameters314); if (failed) return ;

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
    // $ANTLR end entryRuleParameters


    // $ANTLR start ruleParameters
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:182:1: ruleParameters : ( ( rule__Parameters__Group__0 ) ) ;
    public final void ruleParameters() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:186:2: ( ( ( rule__Parameters__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:187:1: ( ( rule__Parameters__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:187:1: ( ( rule__Parameters__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:188:1: ( rule__Parameters__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:189:1: ( rule__Parameters__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:189:2: rule__Parameters__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__0_in_ruleParameters340);
            rule__Parameters__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getGroup()); 
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
    // $ANTLR end ruleParameters


    // $ANTLR start entryRuleBlock
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:201:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:202:1: ( ruleBlock EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:203:1: ruleBlock EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_entryRuleBlock367);
            ruleBlock();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getBlockRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBlock374); if (failed) return ;

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
    // $ANTLR end entryRuleBlock


    // $ANTLR start ruleBlock
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:210:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:214:2: ( ( ( rule__Block__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:215:1: ( ( rule__Block__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:215:1: ( ( rule__Block__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:216:1: ( rule__Block__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:217:1: ( rule__Block__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:217:2: rule__Block__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__0_in_ruleBlock400);
            rule__Block__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getGroup()); 
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
    // $ANTLR end ruleBlock


    // $ANTLR start entryRuleStatement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:229:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:230:1: ( ruleStatement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:231:1: ruleStatement EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStatement_in_entryRuleStatement427);
            ruleStatement();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStatementRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStatement434); if (failed) return ;

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
    // $ANTLR end entryRuleStatement


    // $ANTLR start ruleStatement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:238:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:242:2: ( ( ( rule__Statement__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:243:1: ( ( rule__Statement__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:243:1: ( ( rule__Statement__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:244:1: ( rule__Statement__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:245:1: ( rule__Statement__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:245:2: rule__Statement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Alternatives_in_ruleStatement460);
            rule__Statement__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getAlternatives()); 
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
    // $ANTLR end ruleStatement


    // $ANTLR start entryRulePostfixExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:257:1: entryRulePostfixExpression : rulePostfixExpression EOF ;
    public final void entryRulePostfixExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:258:1: ( rulePostfixExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:259:1: rulePostfixExpression EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression487);
            rulePostfixExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePostfixExpression494); if (failed) return ;

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
    // $ANTLR end entryRulePostfixExpression


    // $ANTLR start rulePostfixExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:266:1: rulePostfixExpression : ( ( rule__PostfixExpression__Group__0 ) ) ;
    public final void rulePostfixExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:270:2: ( ( ( rule__PostfixExpression__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:271:1: ( ( rule__PostfixExpression__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:271:1: ( ( rule__PostfixExpression__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:272:1: ( rule__PostfixExpression__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:273:1: ( rule__PostfixExpression__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:273:2: rule__PostfixExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group__0_in_rulePostfixExpression520);
            rule__PostfixExpression__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getGroup()); 
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
    // $ANTLR end rulePostfixExpression


    // $ANTLR start entryRuleListExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:285:1: entryRuleListExpression : ruleListExpression EOF ;
    public final void entryRuleListExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:286:1: ( ruleListExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:287:1: ruleListExpression EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListExpression_in_entryRuleListExpression547);
            ruleListExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListExpression554); if (failed) return ;

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
    // $ANTLR end entryRuleListExpression


    // $ANTLR start ruleListExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:294:1: ruleListExpression : ( ( rule__ListExpression__Group__0 ) ) ;
    public final void ruleListExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:298:2: ( ( ( rule__ListExpression__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:299:1: ( ( rule__ListExpression__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:299:1: ( ( rule__ListExpression__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:300:1: ( rule__ListExpression__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:301:1: ( rule__ListExpression__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:301:2: rule__ListExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group__0_in_ruleListExpression580);
            rule__ListExpression__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getGroup()); 
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
    // $ANTLR end ruleListExpression


    // $ANTLR start entryRulePropertyOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:313:1: entryRulePropertyOperator : rulePropertyOperator EOF ;
    public final void entryRulePropertyOperator() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:314:1: ( rulePropertyOperator EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:315:1: rulePropertyOperator EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyOperator_in_entryRulePropertyOperator607);
            rulePropertyOperator();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyOperator614); if (failed) return ;

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
    // $ANTLR end entryRulePropertyOperator


    // $ANTLR start rulePropertyOperator
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:322:1: rulePropertyOperator : ( ( rule__PropertyOperator__Alternatives ) ) ;
    public final void rulePropertyOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:326:2: ( ( ( rule__PropertyOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:327:1: ( ( rule__PropertyOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:327:1: ( ( rule__PropertyOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:328:1: ( rule__PropertyOperator__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:329:1: ( rule__PropertyOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:329:2: rule__PropertyOperator__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Alternatives_in_rulePropertyOperator640);
            rule__PropertyOperator__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getAlternatives()); 
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
    // $ANTLR end rulePropertyOperator


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:341:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:342:1: ( rulePrimaryExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:343:1: rulePrimaryExpression EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression667);
            rulePrimaryExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpression674); if (failed) return ;

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
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:350:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:354:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:355:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:355:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:356:1: ( rule__PrimaryExpression__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:357:1: ( rule__PrimaryExpression__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:357:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression700);
            rule__PrimaryExpression__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
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
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start rule__ProgramDirective__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:369:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );
    public final void rule__ProgramDirective__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:373:1: ( ( ruleFunctionDefinition ) | ( ruleStatement ) )
            int alt1=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA1_1 = input.LA(2);

                if ( (synpred1()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("369:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 9:
                {
                alt1=1;
                }
                break;
            case 8:
                {
                int LA1_3 = input.LA(2);

                if ( (synpred1()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("369:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );", 1, 3, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("369:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:374:1: ( ruleFunctionDefinition )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:374:1: ( ruleFunctionDefinition )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:375:1: ruleFunctionDefinition
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getProgramDirectiveAccess().getFunctionDefinitionParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFunctionDefinition_in_rule__ProgramDirective__Alternatives736);
                    ruleFunctionDefinition();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getProgramDirectiveAccess().getFunctionDefinitionParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:380:6: ( ruleStatement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:380:6: ( ruleStatement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:381:1: ruleStatement
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getProgramDirectiveAccess().getStatementParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_rule__ProgramDirective__Alternatives753);
                    ruleStatement();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getProgramDirectiveAccess().getStatementParserRuleCall_1()); 
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
    // $ANTLR end rule__ProgramDirective__Alternatives


    // $ANTLR start rule__Attribute__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:391:1: rule__Attribute__Alternatives : ( ( ( rule__Attribute__IdentAssignment_0 ) ) | ( ( rule__Attribute__Group_1__0 ) ) );
    public final void rule__Attribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:395:1: ( ( ( rule__Attribute__IdentAssignment_0 ) ) | ( ( rule__Attribute__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==9) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("391:1: rule__Attribute__Alternatives : ( ( ( rule__Attribute__IdentAssignment_0 ) ) | ( ( rule__Attribute__Group_1__0 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:396:1: ( ( rule__Attribute__IdentAssignment_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:396:1: ( ( rule__Attribute__IdentAssignment_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:397:1: ( rule__Attribute__IdentAssignment_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAttributeAccess().getIdentAssignment_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:398:1: ( rule__Attribute__IdentAssignment_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:398:2: rule__Attribute__IdentAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute__IdentAssignment_0_in_rule__Attribute__Alternatives785);
                    rule__Attribute__IdentAssignment_0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getAttributeAccess().getIdentAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:402:6: ( ( rule__Attribute__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:402:6: ( ( rule__Attribute__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:403:1: ( rule__Attribute__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAttributeAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:404:1: ( rule__Attribute__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:404:2: rule__Attribute__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__0_in_rule__Attribute__Alternatives803);
                    rule__Attribute__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getAttributeAccess().getGroup_1()); 
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
    // $ANTLR end rule__Attribute__Alternatives


    // $ANTLR start rule__Statement__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:413:1: rule__Statement__Alternatives : ( ( ruleBlock ) | ( ( rule__Statement__Group_1__0 ) ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:417:1: ( ( ruleBlock ) | ( ( rule__Statement__Group_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID||LA3_0==8) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("413:1: rule__Statement__Alternatives : ( ( ruleBlock ) | ( ( rule__Statement__Group_1__0 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:418:1: ( ruleBlock )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:418:1: ( ruleBlock )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:419:1: ruleBlock
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getBlockParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBlock_in_rule__Statement__Alternatives836);
                    ruleBlock();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getBlockParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:424:6: ( ( rule__Statement__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:424:6: ( ( rule__Statement__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:425:1: ( rule__Statement__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:426:1: ( rule__Statement__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:426:2: rule__Statement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__0_in_rule__Statement__Alternatives853);
                    rule__Statement__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getGroup_1()); 
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
    // $ANTLR end rule__Statement__Alternatives


    // $ANTLR start rule__Statement__Alternatives_1_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:435:1: rule__Statement__Alternatives_1_2 : ( ( ';' ) | ( RULE_LT ) );
    public final void rule__Statement__Alternatives_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:439:1: ( ( ';' ) | ( RULE_LT ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==7) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_LT) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("435:1: rule__Statement__Alternatives_1_2 : ( ( ';' ) | ( RULE_LT ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:440:1: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:440:1: ( ';' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:441:1: ';'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getSemicolonKeyword_1_2_0()); 
                    }
                    match(input,7,FollowSets000.FOLLOW_7_in_rule__Statement__Alternatives_1_2887); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getSemicolonKeyword_1_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:448:6: ( RULE_LT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:448:6: ( RULE_LT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:449:1: RULE_LT
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getLTTerminalRuleCall_1_2_1()); 
                    }
                    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Statement__Alternatives_1_2906); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getLTTerminalRuleCall_1_2_1()); 
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
    // $ANTLR end rule__Statement__Alternatives_1_2


    // $ANTLR start rule__PostfixExpression__Alternatives_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:459:1: rule__PostfixExpression__Alternatives_1 : ( ( ( rule__PostfixExpression__Group_1_0__0 ) ) | ( ( rule__PostfixExpression__Group_1_1__0 ) ) );
    public final void rule__PostfixExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:463:1: ( ( ( rule__PostfixExpression__Group_1_0__0 ) ) | ( ( rule__PostfixExpression__Group_1_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:464:1: ( ( rule__PostfixExpression__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:464:1: ( ( rule__PostfixExpression__Group_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:465:1: ( rule__PostfixExpression__Group_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPostfixExpressionAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:466:1: ( rule__PostfixExpression__Group_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:466:2: rule__PostfixExpression__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__0_in_rule__PostfixExpression__Alternatives_1938);
                    rule__PostfixExpression__Group_1_0__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getPostfixExpressionAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:470:6: ( ( rule__PostfixExpression__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:470:6: ( ( rule__PostfixExpression__Group_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:471:1: ( rule__PostfixExpression__Group_1_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPostfixExpressionAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:472:1: ( rule__PostfixExpression__Group_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:472:2: rule__PostfixExpression__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__0_in_rule__PostfixExpression__Alternatives_1956);
                    rule__PostfixExpression__Group_1_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getPostfixExpressionAccess().getGroup_1_1()); 
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
    // $ANTLR end rule__PostfixExpression__Alternatives_1


    // $ANTLR start rule__PropertyOperator__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:481:1: rule__PropertyOperator__Alternatives : ( ( ( rule__PropertyOperator__Group_0__0 ) ) | ( ( rule__PropertyOperator__Group_1__0 ) ) );
    public final void rule__PropertyOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:485:1: ( ( ( rule__PropertyOperator__Group_0__0 ) ) | ( ( rule__PropertyOperator__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==9) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("481:1: rule__PropertyOperator__Alternatives : ( ( ( rule__PropertyOperator__Group_0__0 ) ) | ( ( rule__PropertyOperator__Group_1__0 ) ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:486:1: ( ( rule__PropertyOperator__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:486:1: ( ( rule__PropertyOperator__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:487:1: ( rule__PropertyOperator__Group_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPropertyOperatorAccess().getGroup_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:488:1: ( rule__PropertyOperator__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:488:2: rule__PropertyOperator__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__0_in_rule__PropertyOperator__Alternatives989);
                    rule__PropertyOperator__Group_0__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getPropertyOperatorAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:492:6: ( ( rule__PropertyOperator__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:492:6: ( ( rule__PropertyOperator__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:493:1: ( rule__PropertyOperator__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPropertyOperatorAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:494:1: ( rule__PropertyOperator__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:494:2: rule__PropertyOperator__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__0_in_rule__PropertyOperator__Alternatives1007);
                    rule__PropertyOperator__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getPropertyOperatorAccess().getGroup_1()); 
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
    // $ANTLR end rule__PropertyOperator__Alternatives


    // $ANTLR start rule__PrimaryExpression__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:503:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:507:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==8) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("503:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:508:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:508:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:509:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:510:1: ( rule__PrimaryExpression__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:510:2: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives1040);
                    rule__PrimaryExpression__Group_0__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:514:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:514:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:515:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:516:1: ( rule__PrimaryExpression__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:516:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives1058);
                    rule__PrimaryExpression__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
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
    // $ANTLR end rule__PrimaryExpression__Alternatives


    // $ANTLR start rule__Program__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:527:1: rule__Program__Group__0 : ( () ) rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:531:1: ( ( () ) rule__Program__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:532:1: ( () ) rule__Program__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:532:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:533:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:534:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:536:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getProgramAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01103);
            rule__Program__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Program__Group__0


    // $ANTLR start rule__Program__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:547:1: rule__Program__Group__1 : ( ( rule__Program__Group_1__0 )* ) rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:551:1: ( ( ( rule__Program__Group_1__0 )* ) rule__Program__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:552:1: ( ( rule__Program__Group_1__0 )* ) rule__Program__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:552:1: ( ( rule__Program__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:553:1: ( rule__Program__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:554:1: ( rule__Program__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:554:2: rule__Program__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Program__Group_1__0_in_rule__Program__Group__11131);
            	    rule__Program__Group_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getGroup_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__2_in_rule__Program__Group__11141);
            rule__Program__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Program__Group__1


    // $ANTLR start rule__Program__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:565:1: rule__Program__Group__2 : ( ( RULE_LT )* ) ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:569:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:570:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:570:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:571:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getLTTerminalRuleCall_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:572:1: ( RULE_LT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_LT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:572:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Program__Group__21170); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getLTTerminalRuleCall_2()); 
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
    // $ANTLR end rule__Program__Group__2


    // $ANTLR start rule__Program__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:588:1: rule__Program__Group_1__0 : ( ( RULE_LT )* ) rule__Program__Group_1__1 ;
    public final void rule__Program__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:592:1: ( ( ( RULE_LT )* ) rule__Program__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:593:1: ( ( RULE_LT )* ) rule__Program__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:593:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:594:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getLTTerminalRuleCall_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:595:1: ( RULE_LT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_LT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:595:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Program__Group_1__01212); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getLTTerminalRuleCall_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Program__Group_1__1_in_rule__Program__Group_1__01222);
            rule__Program__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Program__Group_1__0


    // $ANTLR start rule__Program__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:606:1: rule__Program__Group_1__1 : ( ( rule__Program__DirectivesAssignment_1_1 ) ) ;
    public final void rule__Program__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:610:1: ( ( ( rule__Program__DirectivesAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:611:1: ( ( rule__Program__DirectivesAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:611:1: ( ( rule__Program__DirectivesAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:612:1: ( rule__Program__DirectivesAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getDirectivesAssignment_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:613:1: ( rule__Program__DirectivesAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:613:2: rule__Program__DirectivesAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__DirectivesAssignment_1_1_in_rule__Program__Group_1__11250);
            rule__Program__DirectivesAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getDirectivesAssignment_1_1()); 
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
    // $ANTLR end rule__Program__Group_1__1


    // $ANTLR start rule__FunctionDefinition__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:627:1: rule__FunctionDefinition__Group__0 : ( ( rule__FunctionDefinition__AttributesAssignment_0 )* ) rule__FunctionDefinition__Group__1 ;
    public final void rule__FunctionDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:631:1: ( ( ( rule__FunctionDefinition__AttributesAssignment_0 )* ) rule__FunctionDefinition__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:632:1: ( ( rule__FunctionDefinition__AttributesAssignment_0 )* ) rule__FunctionDefinition__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:632:1: ( ( rule__FunctionDefinition__AttributesAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:633:1: ( rule__FunctionDefinition__AttributesAssignment_0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getAttributesAssignment_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:634:1: ( rule__FunctionDefinition__AttributesAssignment_0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==9) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:634:2: rule__FunctionDefinition__AttributesAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__AttributesAssignment_0_in_rule__FunctionDefinition__Group__01288);
            	    rule__FunctionDefinition__AttributesAssignment_0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getAttributesAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__1_in_rule__FunctionDefinition__Group__01298);
            rule__FunctionDefinition__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__0


    // $ANTLR start rule__FunctionDefinition__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:645:1: rule__FunctionDefinition__Group__1 : ( 'function' ) rule__FunctionDefinition__Group__2 ;
    public final void rule__FunctionDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:649:1: ( ( 'function' ) rule__FunctionDefinition__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:650:1: ( 'function' ) rule__FunctionDefinition__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:650:1: ( 'function' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:651:1: 'function'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getFunctionKeyword_1()); 
            }
            match(input,8,FollowSets000.FOLLOW_8_in_rule__FunctionDefinition__Group__11327); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getFunctionKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__2_in_rule__FunctionDefinition__Group__11337);
            rule__FunctionDefinition__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__1


    // $ANTLR start rule__FunctionDefinition__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:665:1: rule__FunctionDefinition__Group__2 : ( ( RULE_LT )* ) rule__FunctionDefinition__Group__3 ;
    public final void rule__FunctionDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:669:1: ( ( ( RULE_LT )* ) rule__FunctionDefinition__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:670:1: ( ( RULE_LT )* ) rule__FunctionDefinition__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:670:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:671:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:672:1: ( RULE_LT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_LT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:672:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__21366); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__3_in_rule__FunctionDefinition__Group__21376);
            rule__FunctionDefinition__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__2


    // $ANTLR start rule__FunctionDefinition__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:683:1: rule__FunctionDefinition__Group__3 : ( ( rule__FunctionDefinition__NameAssignment_3 ) ) rule__FunctionDefinition__Group__4 ;
    public final void rule__FunctionDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:687:1: ( ( ( rule__FunctionDefinition__NameAssignment_3 ) ) rule__FunctionDefinition__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:688:1: ( ( rule__FunctionDefinition__NameAssignment_3 ) ) rule__FunctionDefinition__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:688:1: ( ( rule__FunctionDefinition__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:689:1: ( rule__FunctionDefinition__NameAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getNameAssignment_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:690:1: ( rule__FunctionDefinition__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:690:2: rule__FunctionDefinition__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__NameAssignment_3_in_rule__FunctionDefinition__Group__31404);
            rule__FunctionDefinition__NameAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getNameAssignment_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__4_in_rule__FunctionDefinition__Group__31413);
            rule__FunctionDefinition__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__3


    // $ANTLR start rule__FunctionDefinition__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:701:1: rule__FunctionDefinition__Group__4 : ( ( RULE_LT )* ) rule__FunctionDefinition__Group__5 ;
    public final void rule__FunctionDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:705:1: ( ( ( RULE_LT )* ) rule__FunctionDefinition__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:706:1: ( ( RULE_LT )* ) rule__FunctionDefinition__Group__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:706:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:707:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:708:1: ( RULE_LT )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_LT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:708:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__41442); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__5_in_rule__FunctionDefinition__Group__41452);
            rule__FunctionDefinition__Group__5();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__4


    // $ANTLR start rule__FunctionDefinition__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:719:1: rule__FunctionDefinition__Group__5 : ( ( rule__FunctionDefinition__ParamsAssignment_5 ) ) rule__FunctionDefinition__Group__6 ;
    public final void rule__FunctionDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:723:1: ( ( ( rule__FunctionDefinition__ParamsAssignment_5 ) ) rule__FunctionDefinition__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:724:1: ( ( rule__FunctionDefinition__ParamsAssignment_5 ) ) rule__FunctionDefinition__Group__6
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:724:1: ( ( rule__FunctionDefinition__ParamsAssignment_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:725:1: ( rule__FunctionDefinition__ParamsAssignment_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getParamsAssignment_5()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:726:1: ( rule__FunctionDefinition__ParamsAssignment_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:726:2: rule__FunctionDefinition__ParamsAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__ParamsAssignment_5_in_rule__FunctionDefinition__Group__51480);
            rule__FunctionDefinition__ParamsAssignment_5();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getParamsAssignment_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__6_in_rule__FunctionDefinition__Group__51489);
            rule__FunctionDefinition__Group__6();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__5


    // $ANTLR start rule__FunctionDefinition__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:737:1: rule__FunctionDefinition__Group__6 : ( ( RULE_LT )* ) rule__FunctionDefinition__Group__7 ;
    public final void rule__FunctionDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:741:1: ( ( ( RULE_LT )* ) rule__FunctionDefinition__Group__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:742:1: ( ( RULE_LT )* ) rule__FunctionDefinition__Group__7
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:742:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:743:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_6()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:744:1: ( RULE_LT )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_LT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:744:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__61518); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_6()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__7_in_rule__FunctionDefinition__Group__61528);
            rule__FunctionDefinition__Group__7();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__6


    // $ANTLR start rule__FunctionDefinition__Group__7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:755:1: rule__FunctionDefinition__Group__7 : ( ( rule__FunctionDefinition__BodyAssignment_7 ) ) ;
    public final void rule__FunctionDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:759:1: ( ( ( rule__FunctionDefinition__BodyAssignment_7 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:760:1: ( ( rule__FunctionDefinition__BodyAssignment_7 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:760:1: ( ( rule__FunctionDefinition__BodyAssignment_7 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:761:1: ( rule__FunctionDefinition__BodyAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getBodyAssignment_7()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:762:1: ( rule__FunctionDefinition__BodyAssignment_7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:762:2: rule__FunctionDefinition__BodyAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__BodyAssignment_7_in_rule__FunctionDefinition__Group__71556);
            rule__FunctionDefinition__BodyAssignment_7();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getBodyAssignment_7()); 
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
    // $ANTLR end rule__FunctionDefinition__Group__7


    // $ANTLR start rule__Attribute__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:788:1: rule__Attribute__Group_1__0 : ( () ) rule__Attribute__Group_1__1 ;
    public final void rule__Attribute__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:792:1: ( ( () ) rule__Attribute__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:793:1: ( () ) rule__Attribute__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:793:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:794:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getBracketAttributeAction_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:795:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:797:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getBracketAttributeAction_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__1_in_rule__Attribute__Group_1__01616);
            rule__Attribute__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__0


    // $ANTLR start rule__Attribute__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:808:1: rule__Attribute__Group_1__1 : ( '[' ) rule__Attribute__Group_1__2 ;
    public final void rule__Attribute__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:812:1: ( ( '[' ) rule__Attribute__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:813:1: ( '[' ) rule__Attribute__Group_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:813:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:814:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_1_1()); 
            }
            match(input,9,FollowSets000.FOLLOW_9_in_rule__Attribute__Group_1__11645); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__2_in_rule__Attribute__Group_1__11655);
            rule__Attribute__Group_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__1


    // $ANTLR start rule__Attribute__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:828:1: rule__Attribute__Group_1__2 : ( ( RULE_LT )* ) rule__Attribute__Group_1__3 ;
    public final void rule__Attribute__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:832:1: ( ( ( RULE_LT )* ) rule__Attribute__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:833:1: ( ( RULE_LT )* ) rule__Attribute__Group_1__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:833:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:834:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:835:1: ( RULE_LT )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_LT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:835:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Attribute__Group_1__21684); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__3_in_rule__Attribute__Group_1__21694);
            rule__Attribute__Group_1__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__2


    // $ANTLR start rule__Attribute__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:846:1: rule__Attribute__Group_1__3 : ( ( rule__Attribute__ExpressionAssignment_1_3 ) ) rule__Attribute__Group_1__4 ;
    public final void rule__Attribute__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:850:1: ( ( ( rule__Attribute__ExpressionAssignment_1_3 ) ) rule__Attribute__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:851:1: ( ( rule__Attribute__ExpressionAssignment_1_3 ) ) rule__Attribute__Group_1__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:851:1: ( ( rule__Attribute__ExpressionAssignment_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:852:1: ( rule__Attribute__ExpressionAssignment_1_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getExpressionAssignment_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:853:1: ( rule__Attribute__ExpressionAssignment_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:853:2: rule__Attribute__ExpressionAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__ExpressionAssignment_1_3_in_rule__Attribute__Group_1__31722);
            rule__Attribute__ExpressionAssignment_1_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getExpressionAssignment_1_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__4_in_rule__Attribute__Group_1__31731);
            rule__Attribute__Group_1__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__3


    // $ANTLR start rule__Attribute__Group_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:864:1: rule__Attribute__Group_1__4 : ( ( RULE_LT )* ) rule__Attribute__Group_1__5 ;
    public final void rule__Attribute__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:868:1: ( ( ( RULE_LT )* ) rule__Attribute__Group_1__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:869:1: ( ( RULE_LT )* ) rule__Attribute__Group_1__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:869:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:870:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:871:1: ( RULE_LT )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_LT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:871:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Attribute__Group_1__41760); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__5_in_rule__Attribute__Group_1__41770);
            rule__Attribute__Group_1__5();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__4


    // $ANTLR start rule__Attribute__Group_1__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:882:1: rule__Attribute__Group_1__5 : ( ']' ) ;
    public final void rule__Attribute__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:886:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:887:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:887:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:888:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_1_5()); 
            }
            match(input,10,FollowSets000.FOLLOW_10_in_rule__Attribute__Group_1__51799); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_1_5()); 
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
    // $ANTLR end rule__Attribute__Group_1__5


    // $ANTLR start rule__Parameters__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:913:1: rule__Parameters__Group__0 : ( () ) rule__Parameters__Group__1 ;
    public final void rule__Parameters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:917:1: ( ( () ) rule__Parameters__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:918:1: ( () ) rule__Parameters__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:918:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:919:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParametersAction_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:920:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:922:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParametersAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__1_in_rule__Parameters__Group__01856);
            rule__Parameters__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group__0


    // $ANTLR start rule__Parameters__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:933:1: rule__Parameters__Group__1 : ( '(' ) rule__Parameters__Group__2 ;
    public final void rule__Parameters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:937:1: ( ( '(' ) rule__Parameters__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:938:1: ( '(' ) rule__Parameters__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:938:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:939:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Parameters__Group__11885); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getLeftParenthesisKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__2_in_rule__Parameters__Group__11895);
            rule__Parameters__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group__1


    // $ANTLR start rule__Parameters__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:953:1: rule__Parameters__Group__2 : ( ( RULE_LT )* ) rule__Parameters__Group__3 ;
    public final void rule__Parameters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:957:1: ( ( ( RULE_LT )* ) rule__Parameters__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:958:1: ( ( RULE_LT )* ) rule__Parameters__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:958:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:959:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:960:1: ( RULE_LT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_LT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:960:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group__21924); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getLTTerminalRuleCall_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__3_in_rule__Parameters__Group__21934);
            rule__Parameters__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group__2


    // $ANTLR start rule__Parameters__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:971:1: rule__Parameters__Group__3 : ( ( rule__Parameters__Group_3__0 )? ) rule__Parameters__Group__4 ;
    public final void rule__Parameters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:975:1: ( ( ( rule__Parameters__Group_3__0 )? ) rule__Parameters__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:976:1: ( ( rule__Parameters__Group_3__0 )? ) rule__Parameters__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:976:1: ( ( rule__Parameters__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:977:1: ( rule__Parameters__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getGroup_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:978:1: ( rule__Parameters__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:978:2: rule__Parameters__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__0_in_rule__Parameters__Group__31962);
                    rule__Parameters__Group_3__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getGroup_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__4_in_rule__Parameters__Group__31972);
            rule__Parameters__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group__3


    // $ANTLR start rule__Parameters__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:989:1: rule__Parameters__Group__4 : ( ')' ) ;
    public final void rule__Parameters__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:993:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:994:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:994:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:995:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Parameters__Group__42001); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getRightParenthesisKeyword_4()); 
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
    // $ANTLR end rule__Parameters__Group__4


    // $ANTLR start rule__Parameters__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1018:1: rule__Parameters__Group_3__0 : ( ( rule__Parameters__ParamsAssignment_3_0 ) ) rule__Parameters__Group_3__1 ;
    public final void rule__Parameters__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1022:1: ( ( ( rule__Parameters__ParamsAssignment_3_0 ) ) rule__Parameters__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1023:1: ( ( rule__Parameters__ParamsAssignment_3_0 ) ) rule__Parameters__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1023:1: ( ( rule__Parameters__ParamsAssignment_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1024:1: ( rule__Parameters__ParamsAssignment_3_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsAssignment_3_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1025:1: ( rule__Parameters__ParamsAssignment_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1025:2: rule__Parameters__ParamsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__ParamsAssignment_3_0_in_rule__Parameters__Group_3__02046);
            rule__Parameters__ParamsAssignment_3_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParamsAssignment_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__1_in_rule__Parameters__Group_3__02055);
            rule__Parameters__Group_3__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group_3__0


    // $ANTLR start rule__Parameters__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1036:1: rule__Parameters__Group_3__1 : ( ( RULE_LT )* ) rule__Parameters__Group_3__2 ;
    public final void rule__Parameters__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1040:1: ( ( ( RULE_LT )* ) rule__Parameters__Group_3__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1041:1: ( ( RULE_LT )* ) rule__Parameters__Group_3__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1041:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1042:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1043:1: ( RULE_LT )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_LT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1043:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group_3__12084); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__2_in_rule__Parameters__Group_3__12094);
            rule__Parameters__Group_3__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group_3__1


    // $ANTLR start rule__Parameters__Group_3__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1054:1: rule__Parameters__Group_3__2 : ( ( rule__Parameters__Group_3_2__0 )* ) ;
    public final void rule__Parameters__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1058:1: ( ( ( rule__Parameters__Group_3_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1059:1: ( ( rule__Parameters__Group_3_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1059:1: ( ( rule__Parameters__Group_3_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1060:1: ( rule__Parameters__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1061:1: ( rule__Parameters__Group_3_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==13) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1061:2: rule__Parameters__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__0_in_rule__Parameters__Group_3__22122);
            	    rule__Parameters__Group_3_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getGroup_3_2()); 
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
    // $ANTLR end rule__Parameters__Group_3__2


    // $ANTLR start rule__Parameters__Group_3_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1077:1: rule__Parameters__Group_3_2__0 : ( ',' ) rule__Parameters__Group_3_2__1 ;
    public final void rule__Parameters__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1081:1: ( ( ',' ) rule__Parameters__Group_3_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1082:1: ( ',' ) rule__Parameters__Group_3_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1082:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1083:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Parameters__Group_3_2__02164); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getCommaKeyword_3_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__1_in_rule__Parameters__Group_3_2__02174);
            rule__Parameters__Group_3_2__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group_3_2__0


    // $ANTLR start rule__Parameters__Group_3_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1097:1: rule__Parameters__Group_3_2__1 : ( ( RULE_LT )* ) rule__Parameters__Group_3_2__2 ;
    public final void rule__Parameters__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1101:1: ( ( ( RULE_LT )* ) rule__Parameters__Group_3_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1102:1: ( ( RULE_LT )* ) rule__Parameters__Group_3_2__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1102:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1103:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1104:1: ( RULE_LT )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_LT) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1104:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__12203); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__2_in_rule__Parameters__Group_3_2__12213);
            rule__Parameters__Group_3_2__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group_3_2__1


    // $ANTLR start rule__Parameters__Group_3_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1115:1: rule__Parameters__Group_3_2__2 : ( ( rule__Parameters__ParamsAssignment_3_2_2 ) ) rule__Parameters__Group_3_2__3 ;
    public final void rule__Parameters__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1119:1: ( ( ( rule__Parameters__ParamsAssignment_3_2_2 ) ) rule__Parameters__Group_3_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1120:1: ( ( rule__Parameters__ParamsAssignment_3_2_2 ) ) rule__Parameters__Group_3_2__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1120:1: ( ( rule__Parameters__ParamsAssignment_3_2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1121:1: ( rule__Parameters__ParamsAssignment_3_2_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsAssignment_3_2_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1122:1: ( rule__Parameters__ParamsAssignment_3_2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1122:2: rule__Parameters__ParamsAssignment_3_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__ParamsAssignment_3_2_2_in_rule__Parameters__Group_3_2__22241);
            rule__Parameters__ParamsAssignment_3_2_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParamsAssignment_3_2_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__3_in_rule__Parameters__Group_3_2__22250);
            rule__Parameters__Group_3_2__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group_3_2__2


    // $ANTLR start rule__Parameters__Group_3_2__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1133:1: rule__Parameters__Group_3_2__3 : ( ( RULE_LT )* ) ;
    public final void rule__Parameters__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1137:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1138:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1138:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1139:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1140:1: ( RULE_LT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_LT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1140:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__32279); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_3()); 
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
    // $ANTLR end rule__Parameters__Group_3_2__3


    // $ANTLR start rule__Block__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1158:1: rule__Block__Group__0 : ( () ) rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1162:1: ( ( () ) rule__Block__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1163:1: ( () ) rule__Block__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1163:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1164:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getBlockAction_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1165:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1167:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getBlockAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__1_in_rule__Block__Group__02332);
            rule__Block__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group__0


    // $ANTLR start rule__Block__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1178:1: rule__Block__Group__1 : ( '{' ) rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1182:1: ( ( '{' ) rule__Block__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1183:1: ( '{' ) rule__Block__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1183:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1184:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Block__Group__12361); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__2_in_rule__Block__Group__12371);
            rule__Block__Group__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group__1


    // $ANTLR start rule__Block__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1198:1: rule__Block__Group__2 : ( ( rule__Block__Group_2__0 )* ) rule__Block__Group__3 ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1202:1: ( ( ( rule__Block__Group_2__0 )* ) rule__Block__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1203:1: ( ( rule__Block__Group_2__0 )* ) rule__Block__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1203:1: ( ( rule__Block__Group_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1204:1: ( rule__Block__Group_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getGroup_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1205:1: ( rule__Block__Group_2__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1205:2: rule__Block__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Block__Group_2__0_in_rule__Block__Group__22399);
            	    rule__Block__Group_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getGroup_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__3_in_rule__Block__Group__22409);
            rule__Block__Group__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group__2


    // $ANTLR start rule__Block__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1216:1: rule__Block__Group__3 : ( ( RULE_LT )* ) rule__Block__Group__4 ;
    public final void rule__Block__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1220:1: ( ( ( RULE_LT )* ) rule__Block__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1221:1: ( ( RULE_LT )* ) rule__Block__Group__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1221:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1222:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getLTTerminalRuleCall_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1223:1: ( RULE_LT )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_LT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1223:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Block__Group__32438); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getLTTerminalRuleCall_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__4_in_rule__Block__Group__32448);
            rule__Block__Group__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group__3


    // $ANTLR start rule__Block__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1234:1: rule__Block__Group__4 : ( '}' ) ;
    public final void rule__Block__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1238:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1239:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1239:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1240:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Block__Group__42477); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end rule__Block__Group__4


    // $ANTLR start rule__Block__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1263:1: rule__Block__Group_2__0 : ( ( RULE_LT )* ) rule__Block__Group_2__1 ;
    public final void rule__Block__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1267:1: ( ( ( RULE_LT )* ) rule__Block__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1268:1: ( ( RULE_LT )* ) rule__Block__Group_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1268:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1269:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getLTTerminalRuleCall_2_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1270:1: ( RULE_LT )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_LT) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1270:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Block__Group_2__02523); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getLTTerminalRuleCall_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Block__Group_2__1_in_rule__Block__Group_2__02533);
            rule__Block__Group_2__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group_2__0


    // $ANTLR start rule__Block__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1281:1: rule__Block__Group_2__1 : ( ( rule__Block__DirectivesAssignment_2_1 ) ) ;
    public final void rule__Block__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1285:1: ( ( ( rule__Block__DirectivesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1286:1: ( ( rule__Block__DirectivesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1286:1: ( ( rule__Block__DirectivesAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1287:1: ( rule__Block__DirectivesAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getDirectivesAssignment_2_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1288:1: ( rule__Block__DirectivesAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1288:2: rule__Block__DirectivesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__DirectivesAssignment_2_1_in_rule__Block__Group_2__12561);
            rule__Block__DirectivesAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getDirectivesAssignment_2_1()); 
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
    // $ANTLR end rule__Block__Group_2__1


    // $ANTLR start rule__Statement__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1302:1: rule__Statement__Group_1__0 : ( () ) rule__Statement__Group_1__1 ;
    public final void rule__Statement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1306:1: ( ( () ) rule__Statement__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1307:1: ( () ) rule__Statement__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1307:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1308:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getExpressionStatementAction_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1309:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1311:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getExpressionStatementAction_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__1_in_rule__Statement__Group_1__02609);
            rule__Statement__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statement__Group_1__0


    // $ANTLR start rule__Statement__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1322:1: rule__Statement__Group_1__1 : ( ( rule__Statement__ExpressionAssignment_1_1 ) ) rule__Statement__Group_1__2 ;
    public final void rule__Statement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1326:1: ( ( ( rule__Statement__ExpressionAssignment_1_1 ) ) rule__Statement__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1327:1: ( ( rule__Statement__ExpressionAssignment_1_1 ) ) rule__Statement__Group_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1327:1: ( ( rule__Statement__ExpressionAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1328:1: ( rule__Statement__ExpressionAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getExpressionAssignment_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1329:1: ( rule__Statement__ExpressionAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1329:2: rule__Statement__ExpressionAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__ExpressionAssignment_1_1_in_rule__Statement__Group_1__12637);
            rule__Statement__ExpressionAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getExpressionAssignment_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__2_in_rule__Statement__Group_1__12646);
            rule__Statement__Group_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statement__Group_1__1


    // $ANTLR start rule__Statement__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1340:1: rule__Statement__Group_1__2 : ( ( rule__Statement__Alternatives_1_2 ) ) ;
    public final void rule__Statement__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1344:1: ( ( ( rule__Statement__Alternatives_1_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1345:1: ( ( rule__Statement__Alternatives_1_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1345:1: ( ( rule__Statement__Alternatives_1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1346:1: ( rule__Statement__Alternatives_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getAlternatives_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1347:1: ( rule__Statement__Alternatives_1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1347:2: rule__Statement__Alternatives_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Alternatives_1_2_in_rule__Statement__Group_1__22674);
            rule__Statement__Alternatives_1_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getAlternatives_1_2()); 
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
    // $ANTLR end rule__Statement__Group_1__2


    // $ANTLR start rule__PostfixExpression__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1363:1: rule__PostfixExpression__Group__0 : ( rulePrimaryExpression ) rule__PostfixExpression__Group__1 ;
    public final void rule__PostfixExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1367:1: ( ( rulePrimaryExpression ) rule__PostfixExpression__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1368:1: ( rulePrimaryExpression ) rule__PostfixExpression__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1368:1: ( rulePrimaryExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1369:1: rulePrimaryExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpression_in_rule__PostfixExpression__Group__02714);
            rulePrimaryExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group__1_in_rule__PostfixExpression__Group__02722);
            rule__PostfixExpression__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group__0


    // $ANTLR start rule__PostfixExpression__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1381:1: rule__PostfixExpression__Group__1 : ( ( rule__PostfixExpression__Alternatives_1 )* ) ;
    public final void rule__PostfixExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1385:1: ( ( ( rule__PostfixExpression__Alternatives_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1386:1: ( ( rule__PostfixExpression__Alternatives_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1386:1: ( ( rule__PostfixExpression__Alternatives_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1387:1: ( rule__PostfixExpression__Alternatives_1 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1388:1: ( rule__PostfixExpression__Alternatives_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_LT) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred26()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==9||LA26_0==11||LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1388:2: rule__PostfixExpression__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Alternatives_1_in_rule__PostfixExpression__Group__12750);
            	    rule__PostfixExpression__Alternatives_1();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getAlternatives_1()); 
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
    // $ANTLR end rule__PostfixExpression__Group__1


    // $ANTLR start rule__PostfixExpression__Group_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1402:1: rule__PostfixExpression__Group_1_0__0 : ( () ) rule__PostfixExpression__Group_1_0__1 ;
    public final void rule__PostfixExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1406:1: ( ( () ) rule__PostfixExpression__Group_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1407:1: ( () ) rule__PostfixExpression__Group_1_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1407:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1408:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionExpressionAction_1_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1409:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1411:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionExpressionAction_1_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__1_in_rule__PostfixExpression__Group_1_0__02799);
            rule__PostfixExpression__Group_1_0__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_0__0


    // $ANTLR start rule__PostfixExpression__Group_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1422:1: rule__PostfixExpression__Group_1_0__1 : ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_0__2 ;
    public final void rule__PostfixExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1426:1: ( ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1427:1: ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1427:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1428:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1429:1: ( RULE_LT )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_LT) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1429:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_0__12828); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_0_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__2_in_rule__PostfixExpression__Group_1_0__12838);
            rule__PostfixExpression__Group_1_0__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_0__1


    // $ANTLR start rule__PostfixExpression__Group_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1440:1: rule__PostfixExpression__Group_1_0__2 : ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) ) ;
    public final void rule__PostfixExpression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1444:1: ( ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1445:1: ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1445:1: ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1446:1: ( rule__PostfixExpression__PropertyAssignment_1_0_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPropertyAssignment_1_0_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1447:1: ( rule__PostfixExpression__PropertyAssignment_1_0_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1447:2: rule__PostfixExpression__PropertyAssignment_1_0_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__PropertyAssignment_1_0_2_in_rule__PostfixExpression__Group_1_0__22866);
            rule__PostfixExpression__PropertyAssignment_1_0_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getPropertyAssignment_1_0_2()); 
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
    // $ANTLR end rule__PostfixExpression__Group_1_0__2


    // $ANTLR start rule__PostfixExpression__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1463:1: rule__PostfixExpression__Group_1_1__0 : ( () ) rule__PostfixExpression__Group_1_1__1 ;
    public final void rule__PostfixExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1467:1: ( ( () ) rule__PostfixExpression__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1468:1: ( () ) rule__PostfixExpression__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1468:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1469:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getInvocationExpressionAction_1_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1470:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1472:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getInvocationExpressionAction_1_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__1_in_rule__PostfixExpression__Group_1_1__02916);
            rule__PostfixExpression__Group_1_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__0


    // $ANTLR start rule__PostfixExpression__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1483:1: rule__PostfixExpression__Group_1_1__1 : ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_1__2 ;
    public final void rule__PostfixExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1487:1: ( ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1488:1: ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1488:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1489:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1490:1: ( RULE_LT )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_LT) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1490:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__12945); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__2_in_rule__PostfixExpression__Group_1_1__12955);
            rule__PostfixExpression__Group_1_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__1


    // $ANTLR start rule__PostfixExpression__Group_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1501:1: rule__PostfixExpression__Group_1_1__2 : ( '(' ) rule__PostfixExpression__Group_1_1__3 ;
    public final void rule__PostfixExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1505:1: ( ( '(' ) rule__PostfixExpression__Group_1_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1506:1: ( '(' ) rule__PostfixExpression__Group_1_1__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1506:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1507:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLeftParenthesisKeyword_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_11_in_rule__PostfixExpression__Group_1_1__22984); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getLeftParenthesisKeyword_1_1_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__3_in_rule__PostfixExpression__Group_1_1__22994);
            rule__PostfixExpression__Group_1_1__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__2


    // $ANTLR start rule__PostfixExpression__Group_1_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1521:1: rule__PostfixExpression__Group_1_1__3 : ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_1__4 ;
    public final void rule__PostfixExpression__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1525:1: ( ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1526:1: ( ( RULE_LT )* ) rule__PostfixExpression__Group_1_1__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1526:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1527:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1528:1: ( RULE_LT )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_LT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1528:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__33023); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__4_in_rule__PostfixExpression__Group_1_1__33033);
            rule__PostfixExpression__Group_1_1__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__3


    // $ANTLR start rule__PostfixExpression__Group_1_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1539:1: rule__PostfixExpression__Group_1_1__4 : ( ( rule__PostfixExpression__Group_1_1_4__0 )? ) rule__PostfixExpression__Group_1_1__5 ;
    public final void rule__PostfixExpression__Group_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1543:1: ( ( ( rule__PostfixExpression__Group_1_1_4__0 )? ) rule__PostfixExpression__Group_1_1__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1544:1: ( ( rule__PostfixExpression__Group_1_1_4__0 )? ) rule__PostfixExpression__Group_1_1__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1544:1: ( ( rule__PostfixExpression__Group_1_1_4__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1545:1: ( rule__PostfixExpression__Group_1_1_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getGroup_1_1_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1546:1: ( rule__PostfixExpression__Group_1_1_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID||LA30_0==8) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1546:2: rule__PostfixExpression__Group_1_1_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1_4__0_in_rule__PostfixExpression__Group_1_1__43061);
                    rule__PostfixExpression__Group_1_1_4__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getGroup_1_1_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__5_in_rule__PostfixExpression__Group_1_1__43071);
            rule__PostfixExpression__Group_1_1__5();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__4


    // $ANTLR start rule__PostfixExpression__Group_1_1__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1557:1: rule__PostfixExpression__Group_1_1__5 : ( ')' ) ;
    public final void rule__PostfixExpression__Group_1_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1561:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1562:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1562:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1563:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getRightParenthesisKeyword_1_1_5()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__PostfixExpression__Group_1_1__53100); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getRightParenthesisKeyword_1_1_5()); 
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
    // $ANTLR end rule__PostfixExpression__Group_1_1__5


    // $ANTLR start rule__PostfixExpression__Group_1_1_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1588:1: rule__PostfixExpression__Group_1_1_4__0 : ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) ) rule__PostfixExpression__Group_1_1_4__1 ;
    public final void rule__PostfixExpression__Group_1_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1592:1: ( ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) ) rule__PostfixExpression__Group_1_1_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1593:1: ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) ) rule__PostfixExpression__Group_1_1_4__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1593:1: ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1594:1: ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getArgumentsAssignment_1_1_4_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1595:1: ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1595:2: rule__PostfixExpression__ArgumentsAssignment_1_1_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__ArgumentsAssignment_1_1_4_0_in_rule__PostfixExpression__Group_1_1_4__03147);
            rule__PostfixExpression__ArgumentsAssignment_1_1_4_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getArgumentsAssignment_1_1_4_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1_4__1_in_rule__PostfixExpression__Group_1_1_4__03156);
            rule__PostfixExpression__Group_1_1_4__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1_4__0


    // $ANTLR start rule__PostfixExpression__Group_1_1_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1606:1: rule__PostfixExpression__Group_1_1_4__1 : ( ( RULE_LT )* ) ;
    public final void rule__PostfixExpression__Group_1_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1610:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1611:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1611:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1612:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_4_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1613:1: ( RULE_LT )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_LT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1613:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1_4__13185); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_4_1()); 
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
    // $ANTLR end rule__PostfixExpression__Group_1_1_4__1


    // $ANTLR start rule__ListExpression__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1627:1: rule__ListExpression__Group__0 : ( ( rule__ListExpression__ExpressionsAssignment_0 ) ) rule__ListExpression__Group__1 ;
    public final void rule__ListExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1631:1: ( ( ( rule__ListExpression__ExpressionsAssignment_0 ) ) rule__ListExpression__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1632:1: ( ( rule__ListExpression__ExpressionsAssignment_0 ) ) rule__ListExpression__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1632:1: ( ( rule__ListExpression__ExpressionsAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1633:1: ( rule__ListExpression__ExpressionsAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsAssignment_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1634:1: ( rule__ListExpression__ExpressionsAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1634:2: rule__ListExpression__ExpressionsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__ExpressionsAssignment_0_in_rule__ListExpression__Group__03224);
            rule__ListExpression__ExpressionsAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getExpressionsAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group__1_in_rule__ListExpression__Group__03233);
            rule__ListExpression__Group__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ListExpression__Group__0


    // $ANTLR start rule__ListExpression__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1645:1: rule__ListExpression__Group__1 : ( ( rule__ListExpression__Group_1__0 )* ) ;
    public final void rule__ListExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1649:1: ( ( ( rule__ListExpression__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1650:1: ( ( rule__ListExpression__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1650:1: ( ( rule__ListExpression__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1651:1: ( rule__ListExpression__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getGroup_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1652:1: ( rule__ListExpression__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1652:2: rule__ListExpression__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__0_in_rule__ListExpression__Group__13261);
            	    rule__ListExpression__Group_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getGroup_1()); 
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
    // $ANTLR end rule__ListExpression__Group__1


    // $ANTLR start rule__ListExpression__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1666:1: rule__ListExpression__Group_1__0 : ( ( RULE_LT )* ) rule__ListExpression__Group_1__1 ;
    public final void rule__ListExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1670:1: ( ( ( RULE_LT )* ) rule__ListExpression__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1671:1: ( ( RULE_LT )* ) rule__ListExpression__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1671:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1672:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1673:1: ( RULE_LT )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_LT) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1673:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__03301); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__1_in_rule__ListExpression__Group_1__03311);
            rule__ListExpression__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ListExpression__Group_1__0


    // $ANTLR start rule__ListExpression__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1684:1: rule__ListExpression__Group_1__1 : ( ',' ) rule__ListExpression__Group_1__2 ;
    public final void rule__ListExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1688:1: ( ( ',' ) rule__ListExpression__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1689:1: ( ',' ) rule__ListExpression__Group_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1689:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1690:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getCommaKeyword_1_1()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ListExpression__Group_1__13340); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getCommaKeyword_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__2_in_rule__ListExpression__Group_1__13350);
            rule__ListExpression__Group_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ListExpression__Group_1__1


    // $ANTLR start rule__ListExpression__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1704:1: rule__ListExpression__Group_1__2 : ( ( RULE_LT )* ) rule__ListExpression__Group_1__3 ;
    public final void rule__ListExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1708:1: ( ( ( RULE_LT )* ) rule__ListExpression__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1709:1: ( ( RULE_LT )* ) rule__ListExpression__Group_1__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1709:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1710:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1711:1: ( RULE_LT )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_LT) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1711:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__23379); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__3_in_rule__ListExpression__Group_1__23389);
            rule__ListExpression__Group_1__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ListExpression__Group_1__2


    // $ANTLR start rule__ListExpression__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1722:1: rule__ListExpression__Group_1__3 : ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) ) ;
    public final void rule__ListExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1726:1: ( ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1727:1: ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1727:1: ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1728:1: ( rule__ListExpression__ExpressionsAssignment_1_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsAssignment_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1729:1: ( rule__ListExpression__ExpressionsAssignment_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1729:2: rule__ListExpression__ExpressionsAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__ExpressionsAssignment_1_3_in_rule__ListExpression__Group_1__33417);
            rule__ListExpression__ExpressionsAssignment_1_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getExpressionsAssignment_1_3()); 
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
    // $ANTLR end rule__ListExpression__Group_1__3


    // $ANTLR start rule__PropertyOperator__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1747:1: rule__PropertyOperator__Group_0__0 : ( '.' ) rule__PropertyOperator__Group_0__1 ;
    public final void rule__PropertyOperator__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1751:1: ( ( '.' ) rule__PropertyOperator__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1752:1: ( '.' ) rule__PropertyOperator__Group_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1752:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1753:1: '.'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getFullStopKeyword_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__PropertyOperator__Group_0__03460); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getFullStopKeyword_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__1_in_rule__PropertyOperator__Group_0__03470);
            rule__PropertyOperator__Group_0__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_0__0


    // $ANTLR start rule__PropertyOperator__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1767:1: rule__PropertyOperator__Group_0__1 : ( ( RULE_LT )* ) rule__PropertyOperator__Group_0__2 ;
    public final void rule__PropertyOperator__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1771:1: ( ( ( RULE_LT )* ) rule__PropertyOperator__Group_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1772:1: ( ( RULE_LT )* ) rule__PropertyOperator__Group_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1772:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1773:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1774:1: ( RULE_LT )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_LT) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1774:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_0__13499); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_0_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__2_in_rule__PropertyOperator__Group_0__13509);
            rule__PropertyOperator__Group_0__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_0__1


    // $ANTLR start rule__PropertyOperator__Group_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1785:1: rule__PropertyOperator__Group_0__2 : ( ( rule__PropertyOperator__NameAssignment_0_2 ) ) ;
    public final void rule__PropertyOperator__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1789:1: ( ( ( rule__PropertyOperator__NameAssignment_0_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1790:1: ( ( rule__PropertyOperator__NameAssignment_0_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1790:1: ( ( rule__PropertyOperator__NameAssignment_0_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1791:1: ( rule__PropertyOperator__NameAssignment_0_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getNameAssignment_0_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1792:1: ( rule__PropertyOperator__NameAssignment_0_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1792:2: rule__PropertyOperator__NameAssignment_0_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__NameAssignment_0_2_in_rule__PropertyOperator__Group_0__23537);
            rule__PropertyOperator__NameAssignment_0_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getNameAssignment_0_2()); 
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
    // $ANTLR end rule__PropertyOperator__Group_0__2


    // $ANTLR start rule__PropertyOperator__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1808:1: rule__PropertyOperator__Group_1__0 : ( '[' ) rule__PropertyOperator__Group_1__1 ;
    public final void rule__PropertyOperator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1812:1: ( ( '[' ) rule__PropertyOperator__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1813:1: ( '[' ) rule__PropertyOperator__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1813:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1814:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,9,FollowSets000.FOLLOW_9_in_rule__PropertyOperator__Group_1__03578); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getLeftSquareBracketKeyword_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__1_in_rule__PropertyOperator__Group_1__03588);
            rule__PropertyOperator__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_1__0


    // $ANTLR start rule__PropertyOperator__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1828:1: rule__PropertyOperator__Group_1__1 : ( ( RULE_LT )* ) rule__PropertyOperator__Group_1__2 ;
    public final void rule__PropertyOperator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1832:1: ( ( ( RULE_LT )* ) rule__PropertyOperator__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1833:1: ( ( RULE_LT )* ) rule__PropertyOperator__Group_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1833:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1834:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1835:1: ( RULE_LT )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_LT) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1835:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__13617); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__2_in_rule__PropertyOperator__Group_1__13627);
            rule__PropertyOperator__Group_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_1__1


    // $ANTLR start rule__PropertyOperator__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1846:1: rule__PropertyOperator__Group_1__2 : ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) ) rule__PropertyOperator__Group_1__3 ;
    public final void rule__PropertyOperator__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1850:1: ( ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) ) rule__PropertyOperator__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1851:1: ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) ) rule__PropertyOperator__Group_1__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1851:1: ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1852:1: ( rule__PropertyOperator__ExpressionsAssignment_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getExpressionsAssignment_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1853:1: ( rule__PropertyOperator__ExpressionsAssignment_1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1853:2: rule__PropertyOperator__ExpressionsAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__ExpressionsAssignment_1_2_in_rule__PropertyOperator__Group_1__23655);
            rule__PropertyOperator__ExpressionsAssignment_1_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getExpressionsAssignment_1_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__3_in_rule__PropertyOperator__Group_1__23664);
            rule__PropertyOperator__Group_1__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_1__2


    // $ANTLR start rule__PropertyOperator__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1864:1: rule__PropertyOperator__Group_1__3 : ( ( RULE_LT )* ) rule__PropertyOperator__Group_1__4 ;
    public final void rule__PropertyOperator__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1868:1: ( ( ( RULE_LT )* ) rule__PropertyOperator__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1869:1: ( ( RULE_LT )* ) rule__PropertyOperator__Group_1__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1869:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1870:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1871:1: ( RULE_LT )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_LT) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1871:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__33693); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__4_in_rule__PropertyOperator__Group_1__33703);
            rule__PropertyOperator__Group_1__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_1__3


    // $ANTLR start rule__PropertyOperator__Group_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1882:1: rule__PropertyOperator__Group_1__4 : ( ']' ) ;
    public final void rule__PropertyOperator__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1886:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1887:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1887:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1888:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getRightSquareBracketKeyword_1_4()); 
            }
            match(input,10,FollowSets000.FOLLOW_10_in_rule__PropertyOperator__Group_1__43732); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getRightSquareBracketKeyword_1_4()); 
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
    // $ANTLR end rule__PropertyOperator__Group_1__4


    // $ANTLR start rule__PrimaryExpression__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1911:1: rule__PrimaryExpression__Group_0__0 : ( () ) rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1915:1: ( ( () ) rule__PrimaryExpression__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1916:1: ( () ) rule__PrimaryExpression__Group_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1916:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1917:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getIdentifierAction_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1918:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1920:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getIdentifierAction_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__03787);
            rule__PrimaryExpression__Group_0__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_0__0


    // $ANTLR start rule__PrimaryExpression__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1931:1: rule__PrimaryExpression__Group_0__1 : ( ( rule__PrimaryExpression__NameAssignment_0_1 ) ) ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1935:1: ( ( ( rule__PrimaryExpression__NameAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1936:1: ( ( rule__PrimaryExpression__NameAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1936:1: ( ( rule__PrimaryExpression__NameAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1937:1: ( rule__PrimaryExpression__NameAssignment_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getNameAssignment_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1938:1: ( rule__PrimaryExpression__NameAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1938:2: rule__PrimaryExpression__NameAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__NameAssignment_0_1_in_rule__PrimaryExpression__Group_0__13815);
            rule__PrimaryExpression__NameAssignment_0_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getNameAssignment_0_1()); 
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
    // $ANTLR end rule__PrimaryExpression__Group_0__1


    // $ANTLR start rule__PrimaryExpression__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1952:1: rule__PrimaryExpression__Group_1__0 : ( () ) rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1956:1: ( ( () ) rule__PrimaryExpression__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1957:1: ( () ) rule__PrimaryExpression__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1957:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1958:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getFunctionExpressionAction_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1959:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1961:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getFunctionExpressionAction_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__03863);
            rule__PrimaryExpression__Group_1__1();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__0


    // $ANTLR start rule__PrimaryExpression__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1972:1: rule__PrimaryExpression__Group_1__1 : ( 'function' ) rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1976:1: ( ( 'function' ) rule__PrimaryExpression__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1977:1: ( 'function' ) rule__PrimaryExpression__Group_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1977:1: ( 'function' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1978:1: 'function'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getFunctionKeyword_1_1()); 
            }
            match(input,8,FollowSets000.FOLLOW_8_in_rule__PrimaryExpression__Group_1__13892); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getFunctionKeyword_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__13902);
            rule__PrimaryExpression__Group_1__2();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__1


    // $ANTLR start rule__PrimaryExpression__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1992:1: rule__PrimaryExpression__Group_1__2 : ( ( RULE_LT )* ) rule__PrimaryExpression__Group_1__3 ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1996:1: ( ( ( RULE_LT )* ) rule__PrimaryExpression__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1997:1: ( ( RULE_LT )* ) rule__PrimaryExpression__Group_1__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1997:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1998:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1999:1: ( RULE_LT )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_LT) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1999:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__23931); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__3_in_rule__PrimaryExpression__Group_1__23941);
            rule__PrimaryExpression__Group_1__3();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__2


    // $ANTLR start rule__PrimaryExpression__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2010:1: rule__PrimaryExpression__Group_1__3 : ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) ) rule__PrimaryExpression__Group_1__4 ;
    public final void rule__PrimaryExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2014:1: ( ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) ) rule__PrimaryExpression__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2015:1: ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) ) rule__PrimaryExpression__Group_1__4
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2015:1: ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2016:1: ( rule__PrimaryExpression__ParamsAssignment_1_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getParamsAssignment_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2017:1: ( rule__PrimaryExpression__ParamsAssignment_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2017:2: rule__PrimaryExpression__ParamsAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__ParamsAssignment_1_3_in_rule__PrimaryExpression__Group_1__33969);
            rule__PrimaryExpression__ParamsAssignment_1_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getParamsAssignment_1_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__4_in_rule__PrimaryExpression__Group_1__33978);
            rule__PrimaryExpression__Group_1__4();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__3


    // $ANTLR start rule__PrimaryExpression__Group_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2028:1: rule__PrimaryExpression__Group_1__4 : ( ( RULE_LT )* ) rule__PrimaryExpression__Group_1__5 ;
    public final void rule__PrimaryExpression__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2032:1: ( ( ( RULE_LT )* ) rule__PrimaryExpression__Group_1__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2033:1: ( ( RULE_LT )* ) rule__PrimaryExpression__Group_1__5
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2033:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2034:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2035:1: ( RULE_LT )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_LT) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2035:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__44007); if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__5_in_rule__PrimaryExpression__Group_1__44017);
            rule__PrimaryExpression__Group_1__5();
            _fsp--;
            if (failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__4


    // $ANTLR start rule__PrimaryExpression__Group_1__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2046:1: rule__PrimaryExpression__Group_1__5 : ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) ) ;
    public final void rule__PrimaryExpression__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2050:1: ( ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2051:1: ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2051:1: ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2052:1: ( rule__PrimaryExpression__BodyAssignment_1_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getBodyAssignment_1_5()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2053:1: ( rule__PrimaryExpression__BodyAssignment_1_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2053:2: rule__PrimaryExpression__BodyAssignment_1_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__BodyAssignment_1_5_in_rule__PrimaryExpression__Group_1__54045);
            rule__PrimaryExpression__BodyAssignment_1_5();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getBodyAssignment_1_5()); 
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
    // $ANTLR end rule__PrimaryExpression__Group_1__5


    // $ANTLR start rule__Program__DirectivesAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2076:1: rule__Program__DirectivesAssignment_1_1 : ( ruleProgramDirective ) ;
    public final void rule__Program__DirectivesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2080:1: ( ( ruleProgramDirective ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2081:1: ( ruleProgramDirective )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2081:1: ( ruleProgramDirective )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2082:1: ruleProgramDirective
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getDirectivesProgramDirectiveParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProgramDirective_in_rule__Program__DirectivesAssignment_1_14092);
            ruleProgramDirective();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getDirectivesProgramDirectiveParserRuleCall_1_1_0()); 
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
    // $ANTLR end rule__Program__DirectivesAssignment_1_1


    // $ANTLR start rule__FunctionDefinition__AttributesAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2091:1: rule__FunctionDefinition__AttributesAssignment_0 : ( ruleAttribute ) ;
    public final void rule__FunctionDefinition__AttributesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2095:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2096:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2096:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2097:1: ruleAttribute
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getAttributesAttributeParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__FunctionDefinition__AttributesAssignment_04123);
            ruleAttribute();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getAttributesAttributeParserRuleCall_0_0()); 
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
    // $ANTLR end rule__FunctionDefinition__AttributesAssignment_0


    // $ANTLR start rule__FunctionDefinition__NameAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2106:1: rule__FunctionDefinition__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__FunctionDefinition__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2110:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2111:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2111:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2112:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FunctionDefinition__NameAssignment_34154); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_3_0()); 
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
    // $ANTLR end rule__FunctionDefinition__NameAssignment_3


    // $ANTLR start rule__FunctionDefinition__ParamsAssignment_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2121:1: rule__FunctionDefinition__ParamsAssignment_5 : ( ruleParameters ) ;
    public final void rule__FunctionDefinition__ParamsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2125:1: ( ( ruleParameters ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2126:1: ( ruleParameters )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2126:1: ( ruleParameters )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2127:1: ruleParameters
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getParamsParametersParserRuleCall_5_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameters_in_rule__FunctionDefinition__ParamsAssignment_54185);
            ruleParameters();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getParamsParametersParserRuleCall_5_0()); 
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
    // $ANTLR end rule__FunctionDefinition__ParamsAssignment_5


    // $ANTLR start rule__FunctionDefinition__BodyAssignment_7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2136:1: rule__FunctionDefinition__BodyAssignment_7 : ( ruleBlock ) ;
    public final void rule__FunctionDefinition__BodyAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2140:1: ( ( ruleBlock ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2141:1: ( ruleBlock )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2141:1: ( ruleBlock )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2142:1: ruleBlock
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getBodyBlockParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_rule__FunctionDefinition__BodyAssignment_74216);
            ruleBlock();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getBodyBlockParserRuleCall_7_0()); 
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
    // $ANTLR end rule__FunctionDefinition__BodyAssignment_7


    // $ANTLR start rule__Attribute__IdentAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2151:1: rule__Attribute__IdentAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__IdentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2155:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2156:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2156:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2157:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getIdentIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__IdentAssignment_04247); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getIdentIDTerminalRuleCall_0_0()); 
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
    // $ANTLR end rule__Attribute__IdentAssignment_0


    // $ANTLR start rule__Attribute__ExpressionAssignment_1_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2166:1: rule__Attribute__ExpressionAssignment_1_3 : ( rulePostfixExpression ) ;
    public final void rule__Attribute__ExpressionAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2170:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2171:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2171:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2172:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getExpressionPostfixExpressionParserRuleCall_1_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__Attribute__ExpressionAssignment_1_34278);
            rulePostfixExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getExpressionPostfixExpressionParserRuleCall_1_3_0()); 
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
    // $ANTLR end rule__Attribute__ExpressionAssignment_1_3


    // $ANTLR start rule__Parameters__ParamsAssignment_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2181:1: rule__Parameters__ParamsAssignment_3_0 : ( RULE_ID ) ;
    public final void rule__Parameters__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2185:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2186:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2186:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2187:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_0_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_04309); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_0_0()); 
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
    // $ANTLR end rule__Parameters__ParamsAssignment_3_0


    // $ANTLR start rule__Parameters__ParamsAssignment_3_2_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2196:1: rule__Parameters__ParamsAssignment_3_2_2 : ( RULE_ID ) ;
    public final void rule__Parameters__ParamsAssignment_3_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2200:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2201:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2201:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2202:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_2_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_2_24340); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_2_2_0()); 
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
    // $ANTLR end rule__Parameters__ParamsAssignment_3_2_2


    // $ANTLR start rule__Block__DirectivesAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2211:1: rule__Block__DirectivesAssignment_2_1 : ( ruleStatement ) ;
    public final void rule__Block__DirectivesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2215:1: ( ( ruleStatement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2216:1: ( ruleStatement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2216:1: ( ruleStatement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2217:1: ruleStatement
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getDirectivesStatementParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStatement_in_rule__Block__DirectivesAssignment_2_14371);
            ruleStatement();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getDirectivesStatementParserRuleCall_2_1_0()); 
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
    // $ANTLR end rule__Block__DirectivesAssignment_2_1


    // $ANTLR start rule__Statement__ExpressionAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2226:1: rule__Statement__ExpressionAssignment_1_1 : ( rulePostfixExpression ) ;
    public final void rule__Statement__ExpressionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2230:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2231:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2231:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2232:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getExpressionPostfixExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__Statement__ExpressionAssignment_1_14402);
            rulePostfixExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getExpressionPostfixExpressionParserRuleCall_1_1_0()); 
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
    // $ANTLR end rule__Statement__ExpressionAssignment_1_1


    // $ANTLR start rule__PostfixExpression__PropertyAssignment_1_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2241:1: rule__PostfixExpression__PropertyAssignment_1_0_2 : ( rulePropertyOperator ) ;
    public final void rule__PostfixExpression__PropertyAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2245:1: ( ( rulePropertyOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2246:1: ( rulePropertyOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2246:1: ( rulePropertyOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2247:1: rulePropertyOperator
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPropertyPropertyOperatorParserRuleCall_1_0_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyOperator_in_rule__PostfixExpression__PropertyAssignment_1_0_24433);
            rulePropertyOperator();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getPropertyPropertyOperatorParserRuleCall_1_0_2_0()); 
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
    // $ANTLR end rule__PostfixExpression__PropertyAssignment_1_0_2


    // $ANTLR start rule__PostfixExpression__ArgumentsAssignment_1_1_4_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2256:1: rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 : ( ruleListExpression ) ;
    public final void rule__PostfixExpression__ArgumentsAssignment_1_1_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2260:1: ( ( ruleListExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2261:1: ( ruleListExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2261:1: ( ruleListExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2262:1: ruleListExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getArgumentsListExpressionParserRuleCall_1_1_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListExpression_in_rule__PostfixExpression__ArgumentsAssignment_1_1_4_04464);
            ruleListExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getArgumentsListExpressionParserRuleCall_1_1_4_0_0()); 
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
    // $ANTLR end rule__PostfixExpression__ArgumentsAssignment_1_1_4_0


    // $ANTLR start rule__ListExpression__ExpressionsAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2271:1: rule__ListExpression__ExpressionsAssignment_0 : ( rulePostfixExpression ) ;
    public final void rule__ListExpression__ExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2275:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2276:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2276:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2277:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_04495);
            rulePostfixExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_0_0()); 
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
    // $ANTLR end rule__ListExpression__ExpressionsAssignment_0


    // $ANTLR start rule__ListExpression__ExpressionsAssignment_1_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2286:1: rule__ListExpression__ExpressionsAssignment_1_3 : ( rulePostfixExpression ) ;
    public final void rule__ListExpression__ExpressionsAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2290:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2291:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2291:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2292:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_1_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_1_34526);
            rulePostfixExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_1_3_0()); 
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
    // $ANTLR end rule__ListExpression__ExpressionsAssignment_1_3


    // $ANTLR start rule__PropertyOperator__NameAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2301:1: rule__PropertyOperator__NameAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__PropertyOperator__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2305:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2306:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2306:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2307:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getNameIDTerminalRuleCall_0_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__PropertyOperator__NameAssignment_0_24557); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getNameIDTerminalRuleCall_0_2_0()); 
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
    // $ANTLR end rule__PropertyOperator__NameAssignment_0_2


    // $ANTLR start rule__PropertyOperator__ExpressionsAssignment_1_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2316:1: rule__PropertyOperator__ExpressionsAssignment_1_2 : ( ruleListExpression ) ;
    public final void rule__PropertyOperator__ExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2320:1: ( ( ruleListExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2321:1: ( ruleListExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2321:1: ( ruleListExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2322:1: ruleListExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getExpressionsListExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListExpression_in_rule__PropertyOperator__ExpressionsAssignment_1_24588);
            ruleListExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getExpressionsListExpressionParserRuleCall_1_2_0()); 
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
    // $ANTLR end rule__PropertyOperator__ExpressionsAssignment_1_2


    // $ANTLR start rule__PrimaryExpression__NameAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2331:1: rule__PrimaryExpression__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__PrimaryExpression__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2335:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2336:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2336:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2337:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__PrimaryExpression__NameAssignment_0_14619); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getNameIDTerminalRuleCall_0_1_0()); 
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
    // $ANTLR end rule__PrimaryExpression__NameAssignment_0_1


    // $ANTLR start rule__PrimaryExpression__ParamsAssignment_1_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2346:1: rule__PrimaryExpression__ParamsAssignment_1_3 : ( ruleParameters ) ;
    public final void rule__PrimaryExpression__ParamsAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2350:1: ( ( ruleParameters ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2351:1: ( ruleParameters )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2351:1: ( ruleParameters )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2352:1: ruleParameters
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getParamsParametersParserRuleCall_1_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameters_in_rule__PrimaryExpression__ParamsAssignment_1_34650);
            ruleParameters();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getParamsParametersParserRuleCall_1_3_0()); 
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
    // $ANTLR end rule__PrimaryExpression__ParamsAssignment_1_3


    // $ANTLR start rule__PrimaryExpression__BodyAssignment_1_5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2361:1: rule__PrimaryExpression__BodyAssignment_1_5 : ( ruleBlock ) ;
    public final void rule__PrimaryExpression__BodyAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2365:1: ( ( ruleBlock ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2366:1: ( ruleBlock )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2366:1: ( ruleBlock )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2367:1: ruleBlock
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getBodyBlockParserRuleCall_1_5_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_rule__PrimaryExpression__BodyAssignment_1_54681);
            ruleBlock();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getBodyBlockParserRuleCall_1_5_0()); 
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
    // $ANTLR end rule__PrimaryExpression__BodyAssignment_1_5

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:374:1: ( ( ruleFunctionDefinition ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:374:1: ( ruleFunctionDefinition )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:374:1: ( ruleFunctionDefinition )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:375:1: ruleFunctionDefinition
        {
        if ( backtracking==0 ) {
           before(grammarAccess.getProgramDirectiveAccess().getFunctionDefinitionParserRuleCall_0()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleFunctionDefinition_in_synpred1736);
        ruleFunctionDefinition();
        _fsp--;
        if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred26
    public final void synpred26_fragment() throws RecognitionException {   
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1388:2: ( rule__PostfixExpression__Alternatives_1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1388:2: rule__PostfixExpression__Alternatives_1
        {
        pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Alternatives_1_in_synpred262750);
        rule__PostfixExpression__Alternatives_1();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred26

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred26() {
        backtracking++;
        int start = input.mark();
        try {
            synpred26_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA5_eotS =
        "\4\uffff";
    static final String DFA5_eofS =
        "\4\uffff";
    static final String DFA5_minS =
        "\2\4\2\uffff";
    static final String DFA5_maxS =
        "\2\20\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\4\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\4\uffff\1\2\1\uffff\1\3\4\uffff\1\2",
            "\1\1\4\uffff\1\2\1\uffff\1\3\4\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "459:1: rule__PostfixExpression__Alternatives_1 : ( ( ( rule__PostfixExpression__Group_1_0__0 ) ) | ( ( rule__PostfixExpression__Group_1_1__0 ) ) );";
        }
    }
    static final String DFA8_eotS =
        "\4\uffff";
    static final String DFA8_eofS =
        "\2\2\2\uffff";
    static final String DFA8_minS =
        "\2\4\2\uffff";
    static final String DFA8_maxS =
        "\2\16\2\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA8_specialS =
        "\4\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\1\3\2\uffff\2\3\4\uffff\1\3",
            "\1\1\1\3\2\uffff\2\3\4\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 554:1: ( rule__Program__Group_1__0 )*";
        }
    }
    static final String DFA23_eotS =
        "\4\uffff";
    static final String DFA23_eofS =
        "\4\uffff";
    static final String DFA23_minS =
        "\2\4\2\uffff";
    static final String DFA23_maxS =
        "\2\17\2\uffff";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA23_specialS =
        "\4\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\1\3\2\uffff\1\3\5\uffff\1\3\1\2",
            "\1\1\1\3\2\uffff\1\3\5\uffff\1\3\1\2",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 1205:1: ( rule__Block__Group_2__0 )*";
        }
    }
    static final String DFA32_eotS =
        "\4\uffff";
    static final String DFA32_eofS =
        "\1\1\1\uffff\1\1\1\uffff";
    static final String DFA32_minS =
        "\1\4\1\uffff\1\4\1\uffff";
    static final String DFA32_maxS =
        "\1\15\1\uffff\1\15\1\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\2\1\uffff\1\1";
    static final String DFA32_specialS =
        "\4\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\2\5\uffff\1\1\1\uffff\1\1\1\3",
            "",
            "\1\2\5\uffff\1\1\1\uffff\1\1\1\3",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "()* loopback of 1652:1: ( rule__ListExpression__Group_1__0 )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group__0_in_ruleProgram100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgramDirective_in_entryRuleProgramDirective127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgramDirective134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProgramDirective__Alternatives_in_ruleProgramDirective160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__0_in_ruleFunctionDefinition220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute247 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Alternatives_in_ruleAttribute280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameters_in_entryRuleParameters307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameters314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group__0_in_ruleParameters340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock367 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBlock374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__Group__0_in_ruleBlock400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStatement434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Alternatives_in_ruleStatement460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group__0_in_rulePostfixExpression520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListExpression_in_entryRuleListExpression547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListExpression554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__Group__0_in_ruleListExpression580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyOperator_in_entryRulePropertyOperator607 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyOperator614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Alternatives_in_rulePropertyOperator640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionDefinition_in_rule__ProgramDirective__Alternatives736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_rule__ProgramDirective__Alternatives753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__IdentAssignment_0_in_rule__Attribute__Alternatives785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__0_in_rule__Attribute__Alternatives803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_rule__Statement__Alternatives836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__0_in_rule__Statement__Alternatives853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_7_in_rule__Statement__Alternatives_1_2887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Statement__Alternatives_1_2906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__0_in_rule__PostfixExpression__Alternatives_1938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__0_in_rule__PostfixExpression__Alternatives_1956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__0_in_rule__PropertyOperator__Alternatives989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__0_in_rule__PropertyOperator__Alternatives1007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives1040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives1058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group_1__0_in_rule__Program__Group__11131 = new BitSet(new long[]{0x0000000000004332L});
        public static final BitSet FOLLOW_rule__Program__Group__2_in_rule__Program__Group__11141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Program__Group__21170 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Program__Group_1__01212 = new BitSet(new long[]{0x0000000000004330L});
        public static final BitSet FOLLOW_rule__Program__Group_1__1_in_rule__Program__Group_1__01222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__DirectivesAssignment_1_1_in_rule__Program__Group_1__11250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__AttributesAssignment_0_in_rule__FunctionDefinition__Group__01288 = new BitSet(new long[]{0x0000000000000320L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__1_in_rule__FunctionDefinition__Group__01298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_rule__FunctionDefinition__Group__11327 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__2_in_rule__FunctionDefinition__Group__11337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__21366 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__3_in_rule__FunctionDefinition__Group__21376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__NameAssignment_3_in_rule__FunctionDefinition__Group__31404 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__4_in_rule__FunctionDefinition__Group__31413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__41442 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__5_in_rule__FunctionDefinition__Group__41452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__ParamsAssignment_5_in_rule__FunctionDefinition__Group__51480 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__6_in_rule__FunctionDefinition__Group__51489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__61518 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__7_in_rule__FunctionDefinition__Group__61528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__BodyAssignment_7_in_rule__FunctionDefinition__Group__71556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__1_in_rule__Attribute__Group_1__01616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_9_in_rule__Attribute__Group_1__11645 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__2_in_rule__Attribute__Group_1__11655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Attribute__Group_1__21684 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__3_in_rule__Attribute__Group_1__21694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__ExpressionAssignment_1_3_in_rule__Attribute__Group_1__31722 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__4_in_rule__Attribute__Group_1__31731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Attribute__Group_1__41760 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__5_in_rule__Attribute__Group_1__41770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_10_in_rule__Attribute__Group_1__51799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group__1_in_rule__Parameters__Group__01856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Parameters__Group__11885 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Parameters__Group__2_in_rule__Parameters__Group__11895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group__21924 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Parameters__Group__3_in_rule__Parameters__Group__21934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__0_in_rule__Parameters__Group__31962 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Parameters__Group__4_in_rule__Parameters__Group__31972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Parameters__Group__42001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__ParamsAssignment_3_0_in_rule__Parameters__Group_3__02046 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__1_in_rule__Parameters__Group_3__02055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group_3__12084 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__2_in_rule__Parameters__Group_3__12094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__0_in_rule__Parameters__Group_3__22122 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_rule__Parameters__Group_3_2__02164 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__1_in_rule__Parameters__Group_3_2__02174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__12203 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__2_in_rule__Parameters__Group_3_2__12213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__ParamsAssignment_3_2_2_in_rule__Parameters__Group_3_2__22241 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__3_in_rule__Parameters__Group_3_2__22250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__32279 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Block__Group__1_in_rule__Block__Group__02332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Block__Group__12361 = new BitSet(new long[]{0x000000000000C130L});
        public static final BitSet FOLLOW_rule__Block__Group__2_in_rule__Block__Group__12371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__Group_2__0_in_rule__Block__Group__22399 = new BitSet(new long[]{0x000000000000C130L});
        public static final BitSet FOLLOW_rule__Block__Group__3_in_rule__Block__Group__22409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Block__Group__32438 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__Block__Group__4_in_rule__Block__Group__32448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Block__Group__42477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Block__Group_2__02523 = new BitSet(new long[]{0x0000000000004130L});
        public static final BitSet FOLLOW_rule__Block__Group_2__1_in_rule__Block__Group_2__02533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__DirectivesAssignment_2_1_in_rule__Block__Group_2__12561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__1_in_rule__Statement__Group_1__02609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__ExpressionAssignment_1_1_in_rule__Statement__Group_1__12637 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__2_in_rule__Statement__Group_1__12646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Alternatives_1_2_in_rule__Statement__Group_1__22674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__PostfixExpression__Group__02714 = new BitSet(new long[]{0x0000000000010A12L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group__1_in_rule__PostfixExpression__Group__02722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Alternatives_1_in_rule__PostfixExpression__Group__12750 = new BitSet(new long[]{0x0000000000010A12L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__1_in_rule__PostfixExpression__Group_1_0__02799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_0__12828 = new BitSet(new long[]{0x0000000000010210L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__2_in_rule__PostfixExpression__Group_1_0__12838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__PropertyAssignment_1_0_2_in_rule__PostfixExpression__Group_1_0__22866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__1_in_rule__PostfixExpression__Group_1_1__02916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__12945 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__2_in_rule__PostfixExpression__Group_1_1__12955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__PostfixExpression__Group_1_1__22984 = new BitSet(new long[]{0x0000000000001130L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__3_in_rule__PostfixExpression__Group_1_1__22994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__33023 = new BitSet(new long[]{0x0000000000001130L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__4_in_rule__PostfixExpression__Group_1_1__33033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1_4__0_in_rule__PostfixExpression__Group_1_1__43061 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__5_in_rule__PostfixExpression__Group_1_1__43071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__PostfixExpression__Group_1_1__53100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__ArgumentsAssignment_1_1_4_0_in_rule__PostfixExpression__Group_1_1_4__03147 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1_4__1_in_rule__PostfixExpression__Group_1_1_4__03156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1_4__13185 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ListExpression__ExpressionsAssignment_0_in_rule__ListExpression__Group__03224 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_rule__ListExpression__Group__1_in_rule__ListExpression__Group__03233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__0_in_rule__ListExpression__Group__13261 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__03301 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__1_in_rule__ListExpression__Group_1__03311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ListExpression__Group_1__13340 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__2_in_rule__ListExpression__Group_1__13350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__23379 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__3_in_rule__ListExpression__Group_1__23389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__ExpressionsAssignment_1_3_in_rule__ListExpression__Group_1__33417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__PropertyOperator__Group_0__03460 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__1_in_rule__PropertyOperator__Group_0__03470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_0__13499 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__2_in_rule__PropertyOperator__Group_0__13509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__NameAssignment_0_2_in_rule__PropertyOperator__Group_0__23537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_9_in_rule__PropertyOperator__Group_1__03578 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__1_in_rule__PropertyOperator__Group_1__03588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__13617 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__2_in_rule__PropertyOperator__Group_1__13627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__ExpressionsAssignment_1_2_in_rule__PropertyOperator__Group_1__23655 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__3_in_rule__PropertyOperator__Group_1__23664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__33693 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__4_in_rule__PropertyOperator__Group_1__33703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_10_in_rule__PropertyOperator__Group_1__43732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__03787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__NameAssignment_0_1_in_rule__PrimaryExpression__Group_0__13815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__03863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_rule__PrimaryExpression__Group_1__13892 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__13902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__23931 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__3_in_rule__PrimaryExpression__Group_1__23941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__ParamsAssignment_1_3_in_rule__PrimaryExpression__Group_1__33969 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__4_in_rule__PrimaryExpression__Group_1__33978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__44007 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__5_in_rule__PrimaryExpression__Group_1__44017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__BodyAssignment_1_5_in_rule__PrimaryExpression__Group_1__54045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgramDirective_in_rule__Program__DirectivesAssignment_1_14092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__FunctionDefinition__AttributesAssignment_04123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FunctionDefinition__NameAssignment_34154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameters_in_rule__FunctionDefinition__ParamsAssignment_54185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_rule__FunctionDefinition__BodyAssignment_74216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__IdentAssignment_04247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__Attribute__ExpressionAssignment_1_34278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_04309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_2_24340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_rule__Block__DirectivesAssignment_2_14371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__Statement__ExpressionAssignment_1_14402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyOperator_in_rule__PostfixExpression__PropertyAssignment_1_0_24433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListExpression_in_rule__PostfixExpression__ArgumentsAssignment_1_1_4_04464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_04495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_1_34526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyOperator__NameAssignment_0_24557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListExpression_in_rule__PropertyOperator__ExpressionsAssignment_1_24588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__NameAssignment_0_14619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameters_in_rule__PrimaryExpression__ParamsAssignment_1_34650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_rule__PrimaryExpression__BodyAssignment_1_54681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionDefinition_in_synpred1736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Alternatives_1_in_synpred262750 = new BitSet(new long[]{0x0000000000000002L});
    }


}