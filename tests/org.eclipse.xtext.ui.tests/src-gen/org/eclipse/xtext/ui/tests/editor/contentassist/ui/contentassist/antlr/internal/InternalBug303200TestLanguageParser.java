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
            ruleMemo = new HashMap[240+1];
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:62:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:63:1: ( ruleProgram EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:64:1: ruleProgram EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:71:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:75:2: ( ( ( rule__Program__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:76:1: ( ( rule__Program__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:76:1: ( ( rule__Program__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:77:1: ( rule__Program__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:78:1: ( rule__Program__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:78:2: rule__Program__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:90:1: entryRuleProgramDirective : ruleProgramDirective EOF ;
    public final void entryRuleProgramDirective() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:91:1: ( ruleProgramDirective EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:92:1: ruleProgramDirective EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:99:1: ruleProgramDirective : ( ( rule__ProgramDirective__Alternatives ) ) ;
    public final void ruleProgramDirective() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:103:2: ( ( ( rule__ProgramDirective__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:104:1: ( ( rule__ProgramDirective__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:104:1: ( ( rule__ProgramDirective__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:105:1: ( rule__ProgramDirective__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramDirectiveAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:106:1: ( rule__ProgramDirective__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:106:2: rule__ProgramDirective__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:118:1: entryRuleFunctionDefinition : ruleFunctionDefinition EOF ;
    public final void entryRuleFunctionDefinition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:119:1: ( ruleFunctionDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:120:1: ruleFunctionDefinition EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:127:1: ruleFunctionDefinition : ( ( rule__FunctionDefinition__Group__0 ) ) ;
    public final void ruleFunctionDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:131:2: ( ( ( rule__FunctionDefinition__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:132:1: ( ( rule__FunctionDefinition__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:132:1: ( ( rule__FunctionDefinition__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:133:1: ( rule__FunctionDefinition__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:134:1: ( rule__FunctionDefinition__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:134:2: rule__FunctionDefinition__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:146:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:147:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:148:1: ruleAttribute EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:155:1: ruleAttribute : ( ( rule__Attribute__Alternatives ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:159:2: ( ( ( rule__Attribute__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:160:1: ( ( rule__Attribute__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:160:1: ( ( rule__Attribute__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:161:1: ( rule__Attribute__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:162:1: ( rule__Attribute__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:162:2: rule__Attribute__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:174:1: entryRuleParameters : ruleParameters EOF ;
    public final void entryRuleParameters() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:175:1: ( ruleParameters EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:176:1: ruleParameters EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:183:1: ruleParameters : ( ( rule__Parameters__Group__0 ) ) ;
    public final void ruleParameters() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:187:2: ( ( ( rule__Parameters__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:188:1: ( ( rule__Parameters__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:188:1: ( ( rule__Parameters__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:189:1: ( rule__Parameters__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:190:1: ( rule__Parameters__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:190:2: rule__Parameters__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:202:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:203:1: ( ruleBlock EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:204:1: ruleBlock EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:211:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:215:2: ( ( ( rule__Block__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:216:1: ( ( rule__Block__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:216:1: ( ( rule__Block__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:217:1: ( rule__Block__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:218:1: ( rule__Block__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:218:2: rule__Block__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:230:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:231:1: ( ruleStatement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:232:1: ruleStatement EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:239:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:243:2: ( ( ( rule__Statement__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:244:1: ( ( rule__Statement__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:244:1: ( ( rule__Statement__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:245:1: ( rule__Statement__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:246:1: ( rule__Statement__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:246:2: rule__Statement__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:258:1: entryRulePostfixExpression : rulePostfixExpression EOF ;
    public final void entryRulePostfixExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:259:1: ( rulePostfixExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:260:1: rulePostfixExpression EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:267:1: rulePostfixExpression : ( ( rule__PostfixExpression__Group__0 ) ) ;
    public final void rulePostfixExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:271:2: ( ( ( rule__PostfixExpression__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:272:1: ( ( rule__PostfixExpression__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:272:1: ( ( rule__PostfixExpression__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:273:1: ( rule__PostfixExpression__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:274:1: ( rule__PostfixExpression__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:274:2: rule__PostfixExpression__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:286:1: entryRuleListExpression : ruleListExpression EOF ;
    public final void entryRuleListExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:287:1: ( ruleListExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:288:1: ruleListExpression EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:295:1: ruleListExpression : ( ( rule__ListExpression__Group__0 ) ) ;
    public final void ruleListExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:299:2: ( ( ( rule__ListExpression__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:300:1: ( ( rule__ListExpression__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:300:1: ( ( rule__ListExpression__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:301:1: ( rule__ListExpression__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getGroup()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:302:1: ( rule__ListExpression__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:302:2: rule__ListExpression__Group__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:314:1: entryRulePropertyOperator : rulePropertyOperator EOF ;
    public final void entryRulePropertyOperator() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:315:1: ( rulePropertyOperator EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:316:1: rulePropertyOperator EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:323:1: rulePropertyOperator : ( ( rule__PropertyOperator__Alternatives ) ) ;
    public final void rulePropertyOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:327:2: ( ( ( rule__PropertyOperator__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:328:1: ( ( rule__PropertyOperator__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:328:1: ( ( rule__PropertyOperator__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:329:1: ( rule__PropertyOperator__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:330:1: ( rule__PropertyOperator__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:330:2: rule__PropertyOperator__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:342:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:343:1: ( rulePrimaryExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:344:1: rulePrimaryExpression EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:351:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:355:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:356:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:356:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:357:1: ( rule__PrimaryExpression__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:358:1: ( rule__PrimaryExpression__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:358:2: rule__PrimaryExpression__Alternatives
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:370:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );
    public final void rule__ProgramDirective__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:374:1: ( ( ruleFunctionDefinition ) | ( ruleStatement ) )
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
                        new NoViableAltException("370:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );", 1, 1, input);

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
                        new NoViableAltException("370:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );", 1, 3, input);

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
                    new NoViableAltException("370:1: rule__ProgramDirective__Alternatives : ( ( ruleFunctionDefinition ) | ( ruleStatement ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:375:1: ( ruleFunctionDefinition )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:375:1: ( ruleFunctionDefinition )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:376:1: ruleFunctionDefinition
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:381:6: ( ruleStatement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:381:6: ( ruleStatement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:382:1: ruleStatement
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:392:1: rule__Attribute__Alternatives : ( ( ( rule__Attribute__IdentAssignment_0 ) ) | ( ( rule__Attribute__Group_1__0 ) ) );
    public final void rule__Attribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:396:1: ( ( ( rule__Attribute__IdentAssignment_0 ) ) | ( ( rule__Attribute__Group_1__0 ) ) )
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
                    new NoViableAltException("392:1: rule__Attribute__Alternatives : ( ( ( rule__Attribute__IdentAssignment_0 ) ) | ( ( rule__Attribute__Group_1__0 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:397:1: ( ( rule__Attribute__IdentAssignment_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:397:1: ( ( rule__Attribute__IdentAssignment_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:398:1: ( rule__Attribute__IdentAssignment_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAttributeAccess().getIdentAssignment_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:399:1: ( rule__Attribute__IdentAssignment_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:399:2: rule__Attribute__IdentAssignment_0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:403:6: ( ( rule__Attribute__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:403:6: ( ( rule__Attribute__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:404:1: ( rule__Attribute__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getAttributeAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:405:1: ( rule__Attribute__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:405:2: rule__Attribute__Group_1__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:414:1: rule__Statement__Alternatives : ( ( ruleBlock ) | ( ( rule__Statement__Group_1__0 ) ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:418:1: ( ( ruleBlock ) | ( ( rule__Statement__Group_1__0 ) ) )
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
                    new NoViableAltException("414:1: rule__Statement__Alternatives : ( ( ruleBlock ) | ( ( rule__Statement__Group_1__0 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:419:1: ( ruleBlock )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:419:1: ( ruleBlock )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:420:1: ruleBlock
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:425:6: ( ( rule__Statement__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:425:6: ( ( rule__Statement__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:426:1: ( rule__Statement__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:427:1: ( rule__Statement__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:427:2: rule__Statement__Group_1__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:436:1: rule__Statement__Alternatives_1_2 : ( ( ';' ) | ( RULE_LT ) );
    public final void rule__Statement__Alternatives_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:440:1: ( ( ';' ) | ( RULE_LT ) )
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
                    new NoViableAltException("436:1: rule__Statement__Alternatives_1_2 : ( ( ';' ) | ( RULE_LT ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:441:1: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:441:1: ( ';' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:442:1: ';'
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:449:6: ( RULE_LT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:449:6: ( RULE_LT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:450:1: RULE_LT
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:460:1: rule__PostfixExpression__Alternatives_1 : ( ( ( rule__PostfixExpression__Group_1_0__0 ) ) | ( ( rule__PostfixExpression__Group_1_1__0 ) ) );
    public final void rule__PostfixExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:464:1: ( ( ( rule__PostfixExpression__Group_1_0__0 ) ) | ( ( rule__PostfixExpression__Group_1_1__0 ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:465:1: ( ( rule__PostfixExpression__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:465:1: ( ( rule__PostfixExpression__Group_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:466:1: ( rule__PostfixExpression__Group_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPostfixExpressionAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:467:1: ( rule__PostfixExpression__Group_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:467:2: rule__PostfixExpression__Group_1_0__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:471:6: ( ( rule__PostfixExpression__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:471:6: ( ( rule__PostfixExpression__Group_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:472:1: ( rule__PostfixExpression__Group_1_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPostfixExpressionAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:473:1: ( rule__PostfixExpression__Group_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:473:2: rule__PostfixExpression__Group_1_1__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:482:1: rule__PropertyOperator__Alternatives : ( ( ( rule__PropertyOperator__Group_0__0 ) ) | ( ( rule__PropertyOperator__Group_1__0 ) ) );
    public final void rule__PropertyOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:486:1: ( ( ( rule__PropertyOperator__Group_0__0 ) ) | ( ( rule__PropertyOperator__Group_1__0 ) ) )
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
                    new NoViableAltException("482:1: rule__PropertyOperator__Alternatives : ( ( ( rule__PropertyOperator__Group_0__0 ) ) | ( ( rule__PropertyOperator__Group_1__0 ) ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:487:1: ( ( rule__PropertyOperator__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:487:1: ( ( rule__PropertyOperator__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:488:1: ( rule__PropertyOperator__Group_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPropertyOperatorAccess().getGroup_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:489:1: ( rule__PropertyOperator__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:489:2: rule__PropertyOperator__Group_0__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:493:6: ( ( rule__PropertyOperator__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:493:6: ( ( rule__PropertyOperator__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:494:1: ( rule__PropertyOperator__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPropertyOperatorAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:495:1: ( rule__PropertyOperator__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:495:2: rule__PropertyOperator__Group_1__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:504:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:508:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) )
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
                    new NoViableAltException("504:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:509:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:509:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:510:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:511:1: ( rule__PrimaryExpression__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:511:2: rule__PrimaryExpression__Group_0__0
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:515:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:515:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:516:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:517:1: ( rule__PrimaryExpression__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:517:2: rule__PrimaryExpression__Group_1__0
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:528:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:532:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:533:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01089);
            rule__Program__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01092);
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


    // $ANTLR start rule__Program__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:540:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:544:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:545:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:545:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:546:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:547:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:549:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getProgramAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Program__Group__0__Impl


    // $ANTLR start rule__Program__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:559:1: rule__Program__Group__1 : rule__Program__Group__1__Impl rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:563:1: ( rule__Program__Group__1__Impl rule__Program__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:564:2: rule__Program__Group__1__Impl rule__Program__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11150);
            rule__Program__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__2_in_rule__Program__Group__11153);
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


    // $ANTLR start rule__Program__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:571:1: rule__Program__Group__1__Impl : ( ( rule__Program__Group_1__0 )* ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:575:1: ( ( ( rule__Program__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:576:1: ( ( rule__Program__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:576:1: ( ( rule__Program__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:577:1: ( rule__Program__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:578:1: ( rule__Program__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:578:2: rule__Program__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Program__Group_1__0_in_rule__Program__Group__1__Impl1180);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Program__Group__1__Impl


    // $ANTLR start rule__Program__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:588:1: rule__Program__Group__2 : rule__Program__Group__2__Impl ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:592:1: ( rule__Program__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:593:2: rule__Program__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__2__Impl_in_rule__Program__Group__21211);
            rule__Program__Group__2__Impl();
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
    // $ANTLR end rule__Program__Group__2


    // $ANTLR start rule__Program__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:599:1: rule__Program__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Program__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:603:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:604:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:604:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:605:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getLTTerminalRuleCall_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:606:1: ( RULE_LT )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_LT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:606:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Program__Group__2__Impl1239); if (failed) return ;

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
    // $ANTLR end rule__Program__Group__2__Impl


    // $ANTLR start rule__Program__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:622:1: rule__Program__Group_1__0 : rule__Program__Group_1__0__Impl rule__Program__Group_1__1 ;
    public final void rule__Program__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:626:1: ( rule__Program__Group_1__0__Impl rule__Program__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:627:2: rule__Program__Group_1__0__Impl rule__Program__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group_1__0__Impl_in_rule__Program__Group_1__01276);
            rule__Program__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group_1__1_in_rule__Program__Group_1__01279);
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


    // $ANTLR start rule__Program__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:634:1: rule__Program__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Program__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:638:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:639:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:639:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:640:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getLTTerminalRuleCall_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:641:1: ( RULE_LT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_LT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:641:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Program__Group_1__0__Impl1307); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Program__Group_1__0__Impl


    // $ANTLR start rule__Program__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:651:1: rule__Program__Group_1__1 : rule__Program__Group_1__1__Impl ;
    public final void rule__Program__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:655:1: ( rule__Program__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:656:2: rule__Program__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group_1__1__Impl_in_rule__Program__Group_1__11338);
            rule__Program__Group_1__1__Impl();
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
    // $ANTLR end rule__Program__Group_1__1


    // $ANTLR start rule__Program__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:662:1: rule__Program__Group_1__1__Impl : ( ( rule__Program__DirectivesAssignment_1_1 ) ) ;
    public final void rule__Program__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:666:1: ( ( ( rule__Program__DirectivesAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:667:1: ( ( rule__Program__DirectivesAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:667:1: ( ( rule__Program__DirectivesAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:668:1: ( rule__Program__DirectivesAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getDirectivesAssignment_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:669:1: ( rule__Program__DirectivesAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:669:2: rule__Program__DirectivesAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__DirectivesAssignment_1_1_in_rule__Program__Group_1__1__Impl1365);
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
    // $ANTLR end rule__Program__Group_1__1__Impl


    // $ANTLR start rule__FunctionDefinition__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:683:1: rule__FunctionDefinition__Group__0 : rule__FunctionDefinition__Group__0__Impl rule__FunctionDefinition__Group__1 ;
    public final void rule__FunctionDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:687:1: ( rule__FunctionDefinition__Group__0__Impl rule__FunctionDefinition__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:688:2: rule__FunctionDefinition__Group__0__Impl rule__FunctionDefinition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__0__Impl_in_rule__FunctionDefinition__Group__01399);
            rule__FunctionDefinition__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__1_in_rule__FunctionDefinition__Group__01402);
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


    // $ANTLR start rule__FunctionDefinition__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:695:1: rule__FunctionDefinition__Group__0__Impl : ( ( rule__FunctionDefinition__AttributesAssignment_0 )* ) ;
    public final void rule__FunctionDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:699:1: ( ( ( rule__FunctionDefinition__AttributesAssignment_0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:700:1: ( ( rule__FunctionDefinition__AttributesAssignment_0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:700:1: ( ( rule__FunctionDefinition__AttributesAssignment_0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:701:1: ( rule__FunctionDefinition__AttributesAssignment_0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getAttributesAssignment_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:702:1: ( rule__FunctionDefinition__AttributesAssignment_0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==9) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:702:2: rule__FunctionDefinition__AttributesAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__AttributesAssignment_0_in_rule__FunctionDefinition__Group__0__Impl1429);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__0__Impl


    // $ANTLR start rule__FunctionDefinition__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:712:1: rule__FunctionDefinition__Group__1 : rule__FunctionDefinition__Group__1__Impl rule__FunctionDefinition__Group__2 ;
    public final void rule__FunctionDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:716:1: ( rule__FunctionDefinition__Group__1__Impl rule__FunctionDefinition__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:717:2: rule__FunctionDefinition__Group__1__Impl rule__FunctionDefinition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__1__Impl_in_rule__FunctionDefinition__Group__11460);
            rule__FunctionDefinition__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__2_in_rule__FunctionDefinition__Group__11463);
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


    // $ANTLR start rule__FunctionDefinition__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:724:1: rule__FunctionDefinition__Group__1__Impl : ( 'function' ) ;
    public final void rule__FunctionDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:728:1: ( ( 'function' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:729:1: ( 'function' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:729:1: ( 'function' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:730:1: 'function'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getFunctionKeyword_1()); 
            }
            match(input,8,FollowSets000.FOLLOW_8_in_rule__FunctionDefinition__Group__1__Impl1491); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getFunctionKeyword_1()); 
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
    // $ANTLR end rule__FunctionDefinition__Group__1__Impl


    // $ANTLR start rule__FunctionDefinition__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:743:1: rule__FunctionDefinition__Group__2 : rule__FunctionDefinition__Group__2__Impl rule__FunctionDefinition__Group__3 ;
    public final void rule__FunctionDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:747:1: ( rule__FunctionDefinition__Group__2__Impl rule__FunctionDefinition__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:748:2: rule__FunctionDefinition__Group__2__Impl rule__FunctionDefinition__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__2__Impl_in_rule__FunctionDefinition__Group__21522);
            rule__FunctionDefinition__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__3_in_rule__FunctionDefinition__Group__21525);
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


    // $ANTLR start rule__FunctionDefinition__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:755:1: rule__FunctionDefinition__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FunctionDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:759:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:760:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:760:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:761:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:762:1: ( RULE_LT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_LT) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:762:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__2__Impl1553); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__2__Impl


    // $ANTLR start rule__FunctionDefinition__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:772:1: rule__FunctionDefinition__Group__3 : rule__FunctionDefinition__Group__3__Impl rule__FunctionDefinition__Group__4 ;
    public final void rule__FunctionDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:776:1: ( rule__FunctionDefinition__Group__3__Impl rule__FunctionDefinition__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:777:2: rule__FunctionDefinition__Group__3__Impl rule__FunctionDefinition__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__3__Impl_in_rule__FunctionDefinition__Group__31584);
            rule__FunctionDefinition__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__4_in_rule__FunctionDefinition__Group__31587);
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


    // $ANTLR start rule__FunctionDefinition__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:784:1: rule__FunctionDefinition__Group__3__Impl : ( ( rule__FunctionDefinition__NameAssignment_3 ) ) ;
    public final void rule__FunctionDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:788:1: ( ( ( rule__FunctionDefinition__NameAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:789:1: ( ( rule__FunctionDefinition__NameAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:789:1: ( ( rule__FunctionDefinition__NameAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:790:1: ( rule__FunctionDefinition__NameAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getNameAssignment_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:791:1: ( rule__FunctionDefinition__NameAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:791:2: rule__FunctionDefinition__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__NameAssignment_3_in_rule__FunctionDefinition__Group__3__Impl1614);
            rule__FunctionDefinition__NameAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getNameAssignment_3()); 
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
    // $ANTLR end rule__FunctionDefinition__Group__3__Impl


    // $ANTLR start rule__FunctionDefinition__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:801:1: rule__FunctionDefinition__Group__4 : rule__FunctionDefinition__Group__4__Impl rule__FunctionDefinition__Group__5 ;
    public final void rule__FunctionDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:805:1: ( rule__FunctionDefinition__Group__4__Impl rule__FunctionDefinition__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:806:2: rule__FunctionDefinition__Group__4__Impl rule__FunctionDefinition__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__4__Impl_in_rule__FunctionDefinition__Group__41644);
            rule__FunctionDefinition__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__5_in_rule__FunctionDefinition__Group__41647);
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


    // $ANTLR start rule__FunctionDefinition__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:813:1: rule__FunctionDefinition__Group__4__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FunctionDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:817:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:818:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:818:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:819:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:820:1: ( RULE_LT )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_LT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:820:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__4__Impl1675); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__4__Impl


    // $ANTLR start rule__FunctionDefinition__Group__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:830:1: rule__FunctionDefinition__Group__5 : rule__FunctionDefinition__Group__5__Impl rule__FunctionDefinition__Group__6 ;
    public final void rule__FunctionDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:834:1: ( rule__FunctionDefinition__Group__5__Impl rule__FunctionDefinition__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:835:2: rule__FunctionDefinition__Group__5__Impl rule__FunctionDefinition__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__5__Impl_in_rule__FunctionDefinition__Group__51706);
            rule__FunctionDefinition__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__6_in_rule__FunctionDefinition__Group__51709);
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


    // $ANTLR start rule__FunctionDefinition__Group__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:842:1: rule__FunctionDefinition__Group__5__Impl : ( ( rule__FunctionDefinition__ParamsAssignment_5 ) ) ;
    public final void rule__FunctionDefinition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:846:1: ( ( ( rule__FunctionDefinition__ParamsAssignment_5 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:847:1: ( ( rule__FunctionDefinition__ParamsAssignment_5 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:847:1: ( ( rule__FunctionDefinition__ParamsAssignment_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:848:1: ( rule__FunctionDefinition__ParamsAssignment_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getParamsAssignment_5()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:849:1: ( rule__FunctionDefinition__ParamsAssignment_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:849:2: rule__FunctionDefinition__ParamsAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__ParamsAssignment_5_in_rule__FunctionDefinition__Group__5__Impl1736);
            rule__FunctionDefinition__ParamsAssignment_5();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getFunctionDefinitionAccess().getParamsAssignment_5()); 
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
    // $ANTLR end rule__FunctionDefinition__Group__5__Impl


    // $ANTLR start rule__FunctionDefinition__Group__6
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:859:1: rule__FunctionDefinition__Group__6 : rule__FunctionDefinition__Group__6__Impl rule__FunctionDefinition__Group__7 ;
    public final void rule__FunctionDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:863:1: ( rule__FunctionDefinition__Group__6__Impl rule__FunctionDefinition__Group__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:864:2: rule__FunctionDefinition__Group__6__Impl rule__FunctionDefinition__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__6__Impl_in_rule__FunctionDefinition__Group__61766);
            rule__FunctionDefinition__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__7_in_rule__FunctionDefinition__Group__61769);
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


    // $ANTLR start rule__FunctionDefinition__Group__6__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:871:1: rule__FunctionDefinition__Group__6__Impl : ( ( RULE_LT )* ) ;
    public final void rule__FunctionDefinition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:875:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:876:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:876:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:877:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getLTTerminalRuleCall_6()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:878:1: ( RULE_LT )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_LT) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:878:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__6__Impl1797); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FunctionDefinition__Group__6__Impl


    // $ANTLR start rule__FunctionDefinition__Group__7
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:888:1: rule__FunctionDefinition__Group__7 : rule__FunctionDefinition__Group__7__Impl ;
    public final void rule__FunctionDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:892:1: ( rule__FunctionDefinition__Group__7__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:893:2: rule__FunctionDefinition__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__Group__7__Impl_in_rule__FunctionDefinition__Group__71828);
            rule__FunctionDefinition__Group__7__Impl();
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
    // $ANTLR end rule__FunctionDefinition__Group__7


    // $ANTLR start rule__FunctionDefinition__Group__7__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:899:1: rule__FunctionDefinition__Group__7__Impl : ( ( rule__FunctionDefinition__BodyAssignment_7 ) ) ;
    public final void rule__FunctionDefinition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:903:1: ( ( ( rule__FunctionDefinition__BodyAssignment_7 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:904:1: ( ( rule__FunctionDefinition__BodyAssignment_7 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:904:1: ( ( rule__FunctionDefinition__BodyAssignment_7 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:905:1: ( rule__FunctionDefinition__BodyAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getBodyAssignment_7()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:906:1: ( rule__FunctionDefinition__BodyAssignment_7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:906:2: rule__FunctionDefinition__BodyAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__FunctionDefinition__BodyAssignment_7_in_rule__FunctionDefinition__Group__7__Impl1855);
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
    // $ANTLR end rule__FunctionDefinition__Group__7__Impl


    // $ANTLR start rule__Attribute__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:932:1: rule__Attribute__Group_1__0 : rule__Attribute__Group_1__0__Impl rule__Attribute__Group_1__1 ;
    public final void rule__Attribute__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:936:1: ( rule__Attribute__Group_1__0__Impl rule__Attribute__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:937:2: rule__Attribute__Group_1__0__Impl rule__Attribute__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__0__Impl_in_rule__Attribute__Group_1__01901);
            rule__Attribute__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__1_in_rule__Attribute__Group_1__01904);
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


    // $ANTLR start rule__Attribute__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:944:1: rule__Attribute__Group_1__0__Impl : ( () ) ;
    public final void rule__Attribute__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:948:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:949:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:949:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:950:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getBracketAttributeAction_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:951:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:953:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getBracketAttributeAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__0__Impl


    // $ANTLR start rule__Attribute__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:963:1: rule__Attribute__Group_1__1 : rule__Attribute__Group_1__1__Impl rule__Attribute__Group_1__2 ;
    public final void rule__Attribute__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:967:1: ( rule__Attribute__Group_1__1__Impl rule__Attribute__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:968:2: rule__Attribute__Group_1__1__Impl rule__Attribute__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__1__Impl_in_rule__Attribute__Group_1__11962);
            rule__Attribute__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__2_in_rule__Attribute__Group_1__11965);
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


    // $ANTLR start rule__Attribute__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:975:1: rule__Attribute__Group_1__1__Impl : ( '[' ) ;
    public final void rule__Attribute__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:979:1: ( ( '[' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:980:1: ( '[' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:980:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:981:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_1_1()); 
            }
            match(input,9,FollowSets000.FOLLOW_9_in_rule__Attribute__Group_1__1__Impl1993); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_1_1()); 
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
    // $ANTLR end rule__Attribute__Group_1__1__Impl


    // $ANTLR start rule__Attribute__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:994:1: rule__Attribute__Group_1__2 : rule__Attribute__Group_1__2__Impl rule__Attribute__Group_1__3 ;
    public final void rule__Attribute__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:998:1: ( rule__Attribute__Group_1__2__Impl rule__Attribute__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:999:2: rule__Attribute__Group_1__2__Impl rule__Attribute__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__2__Impl_in_rule__Attribute__Group_1__22024);
            rule__Attribute__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__3_in_rule__Attribute__Group_1__22027);
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


    // $ANTLR start rule__Attribute__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1006:1: rule__Attribute__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Attribute__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1010:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1011:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1011:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1012:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1013:1: ( RULE_LT )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_LT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1013:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Attribute__Group_1__2__Impl2055); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__2__Impl


    // $ANTLR start rule__Attribute__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1023:1: rule__Attribute__Group_1__3 : rule__Attribute__Group_1__3__Impl rule__Attribute__Group_1__4 ;
    public final void rule__Attribute__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1027:1: ( rule__Attribute__Group_1__3__Impl rule__Attribute__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1028:2: rule__Attribute__Group_1__3__Impl rule__Attribute__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__3__Impl_in_rule__Attribute__Group_1__32086);
            rule__Attribute__Group_1__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__4_in_rule__Attribute__Group_1__32089);
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


    // $ANTLR start rule__Attribute__Group_1__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1035:1: rule__Attribute__Group_1__3__Impl : ( ( rule__Attribute__ExpressionAssignment_1_3 ) ) ;
    public final void rule__Attribute__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1039:1: ( ( ( rule__Attribute__ExpressionAssignment_1_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1040:1: ( ( rule__Attribute__ExpressionAssignment_1_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1040:1: ( ( rule__Attribute__ExpressionAssignment_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1041:1: ( rule__Attribute__ExpressionAssignment_1_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getExpressionAssignment_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1042:1: ( rule__Attribute__ExpressionAssignment_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1042:2: rule__Attribute__ExpressionAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__ExpressionAssignment_1_3_in_rule__Attribute__Group_1__3__Impl2116);
            rule__Attribute__ExpressionAssignment_1_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getExpressionAssignment_1_3()); 
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
    // $ANTLR end rule__Attribute__Group_1__3__Impl


    // $ANTLR start rule__Attribute__Group_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1052:1: rule__Attribute__Group_1__4 : rule__Attribute__Group_1__4__Impl rule__Attribute__Group_1__5 ;
    public final void rule__Attribute__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1056:1: ( rule__Attribute__Group_1__4__Impl rule__Attribute__Group_1__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1057:2: rule__Attribute__Group_1__4__Impl rule__Attribute__Group_1__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__4__Impl_in_rule__Attribute__Group_1__42146);
            rule__Attribute__Group_1__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__5_in_rule__Attribute__Group_1__42149);
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


    // $ANTLR start rule__Attribute__Group_1__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1064:1: rule__Attribute__Group_1__4__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Attribute__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1068:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1069:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1069:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1070:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getLTTerminalRuleCall_1_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1071:1: ( RULE_LT )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_LT) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1071:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Attribute__Group_1__4__Impl2177); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__Group_1__4__Impl


    // $ANTLR start rule__Attribute__Group_1__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1081:1: rule__Attribute__Group_1__5 : rule__Attribute__Group_1__5__Impl ;
    public final void rule__Attribute__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1085:1: ( rule__Attribute__Group_1__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1086:2: rule__Attribute__Group_1__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group_1__5__Impl_in_rule__Attribute__Group_1__52208);
            rule__Attribute__Group_1__5__Impl();
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
    // $ANTLR end rule__Attribute__Group_1__5


    // $ANTLR start rule__Attribute__Group_1__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1092:1: rule__Attribute__Group_1__5__Impl : ( ']' ) ;
    public final void rule__Attribute__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1096:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1097:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1097:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1098:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_1_5()); 
            }
            match(input,10,FollowSets000.FOLLOW_10_in_rule__Attribute__Group_1__5__Impl2236); if (failed) return ;
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
    // $ANTLR end rule__Attribute__Group_1__5__Impl


    // $ANTLR start rule__Parameters__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1123:1: rule__Parameters__Group__0 : rule__Parameters__Group__0__Impl rule__Parameters__Group__1 ;
    public final void rule__Parameters__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1127:1: ( rule__Parameters__Group__0__Impl rule__Parameters__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1128:2: rule__Parameters__Group__0__Impl rule__Parameters__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__0__Impl_in_rule__Parameters__Group__02279);
            rule__Parameters__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__1_in_rule__Parameters__Group__02282);
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


    // $ANTLR start rule__Parameters__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1135:1: rule__Parameters__Group__0__Impl : ( () ) ;
    public final void rule__Parameters__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1139:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1140:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1140:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1141:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParametersAction_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1142:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1144:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParametersAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group__0__Impl


    // $ANTLR start rule__Parameters__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1154:1: rule__Parameters__Group__1 : rule__Parameters__Group__1__Impl rule__Parameters__Group__2 ;
    public final void rule__Parameters__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1158:1: ( rule__Parameters__Group__1__Impl rule__Parameters__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1159:2: rule__Parameters__Group__1__Impl rule__Parameters__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__1__Impl_in_rule__Parameters__Group__12340);
            rule__Parameters__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__2_in_rule__Parameters__Group__12343);
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


    // $ANTLR start rule__Parameters__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1166:1: rule__Parameters__Group__1__Impl : ( '(' ) ;
    public final void rule__Parameters__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1170:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1171:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1171:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1172:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Parameters__Group__1__Impl2371); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getLeftParenthesisKeyword_1()); 
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
    // $ANTLR end rule__Parameters__Group__1__Impl


    // $ANTLR start rule__Parameters__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1185:1: rule__Parameters__Group__2 : rule__Parameters__Group__2__Impl rule__Parameters__Group__3 ;
    public final void rule__Parameters__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1189:1: ( rule__Parameters__Group__2__Impl rule__Parameters__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1190:2: rule__Parameters__Group__2__Impl rule__Parameters__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__2__Impl_in_rule__Parameters__Group__22402);
            rule__Parameters__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__3_in_rule__Parameters__Group__22405);
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


    // $ANTLR start rule__Parameters__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1197:1: rule__Parameters__Group__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Parameters__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1201:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1202:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1202:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1203:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1204:1: ( RULE_LT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_LT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1204:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group__2__Impl2433); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group__2__Impl


    // $ANTLR start rule__Parameters__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1214:1: rule__Parameters__Group__3 : rule__Parameters__Group__3__Impl rule__Parameters__Group__4 ;
    public final void rule__Parameters__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1218:1: ( rule__Parameters__Group__3__Impl rule__Parameters__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1219:2: rule__Parameters__Group__3__Impl rule__Parameters__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__3__Impl_in_rule__Parameters__Group__32464);
            rule__Parameters__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__4_in_rule__Parameters__Group__32467);
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


    // $ANTLR start rule__Parameters__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1226:1: rule__Parameters__Group__3__Impl : ( ( rule__Parameters__Group_3__0 )? ) ;
    public final void rule__Parameters__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1230:1: ( ( ( rule__Parameters__Group_3__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1231:1: ( ( rule__Parameters__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1231:1: ( ( rule__Parameters__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1232:1: ( rule__Parameters__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getGroup_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1233:1: ( rule__Parameters__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1233:2: rule__Parameters__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__0_in_rule__Parameters__Group__3__Impl2494);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group__3__Impl


    // $ANTLR start rule__Parameters__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1243:1: rule__Parameters__Group__4 : rule__Parameters__Group__4__Impl ;
    public final void rule__Parameters__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1247:1: ( rule__Parameters__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1248:2: rule__Parameters__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group__4__Impl_in_rule__Parameters__Group__42525);
            rule__Parameters__Group__4__Impl();
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
    // $ANTLR end rule__Parameters__Group__4


    // $ANTLR start rule__Parameters__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1254:1: rule__Parameters__Group__4__Impl : ( ')' ) ;
    public final void rule__Parameters__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1258:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1259:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1259:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1260:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Parameters__Group__4__Impl2553); if (failed) return ;
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
    // $ANTLR end rule__Parameters__Group__4__Impl


    // $ANTLR start rule__Parameters__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1283:1: rule__Parameters__Group_3__0 : rule__Parameters__Group_3__0__Impl rule__Parameters__Group_3__1 ;
    public final void rule__Parameters__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1287:1: ( rule__Parameters__Group_3__0__Impl rule__Parameters__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1288:2: rule__Parameters__Group_3__0__Impl rule__Parameters__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__0__Impl_in_rule__Parameters__Group_3__02594);
            rule__Parameters__Group_3__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__1_in_rule__Parameters__Group_3__02597);
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


    // $ANTLR start rule__Parameters__Group_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1295:1: rule__Parameters__Group_3__0__Impl : ( ( rule__Parameters__ParamsAssignment_3_0 ) ) ;
    public final void rule__Parameters__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1299:1: ( ( ( rule__Parameters__ParamsAssignment_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1300:1: ( ( rule__Parameters__ParamsAssignment_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1300:1: ( ( rule__Parameters__ParamsAssignment_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1301:1: ( rule__Parameters__ParamsAssignment_3_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsAssignment_3_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1302:1: ( rule__Parameters__ParamsAssignment_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1302:2: rule__Parameters__ParamsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__ParamsAssignment_3_0_in_rule__Parameters__Group_3__0__Impl2624);
            rule__Parameters__ParamsAssignment_3_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParamsAssignment_3_0()); 
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
    // $ANTLR end rule__Parameters__Group_3__0__Impl


    // $ANTLR start rule__Parameters__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1312:1: rule__Parameters__Group_3__1 : rule__Parameters__Group_3__1__Impl rule__Parameters__Group_3__2 ;
    public final void rule__Parameters__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1316:1: ( rule__Parameters__Group_3__1__Impl rule__Parameters__Group_3__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1317:2: rule__Parameters__Group_3__1__Impl rule__Parameters__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__1__Impl_in_rule__Parameters__Group_3__12654);
            rule__Parameters__Group_3__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__2_in_rule__Parameters__Group_3__12657);
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


    // $ANTLR start rule__Parameters__Group_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1324:1: rule__Parameters__Group_3__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Parameters__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1328:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1329:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1329:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1330:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1331:1: ( RULE_LT )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_LT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1331:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group_3__1__Impl2685); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group_3__1__Impl


    // $ANTLR start rule__Parameters__Group_3__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1341:1: rule__Parameters__Group_3__2 : rule__Parameters__Group_3__2__Impl ;
    public final void rule__Parameters__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1345:1: ( rule__Parameters__Group_3__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1346:2: rule__Parameters__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3__2__Impl_in_rule__Parameters__Group_3__22716);
            rule__Parameters__Group_3__2__Impl();
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
    // $ANTLR end rule__Parameters__Group_3__2


    // $ANTLR start rule__Parameters__Group_3__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1352:1: rule__Parameters__Group_3__2__Impl : ( ( rule__Parameters__Group_3_2__0 )* ) ;
    public final void rule__Parameters__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1356:1: ( ( ( rule__Parameters__Group_3_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1357:1: ( ( rule__Parameters__Group_3_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1357:1: ( ( rule__Parameters__Group_3_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1358:1: ( rule__Parameters__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1359:1: ( rule__Parameters__Group_3_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==13) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1359:2: rule__Parameters__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__0_in_rule__Parameters__Group_3__2__Impl2743);
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
    // $ANTLR end rule__Parameters__Group_3__2__Impl


    // $ANTLR start rule__Parameters__Group_3_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1375:1: rule__Parameters__Group_3_2__0 : rule__Parameters__Group_3_2__0__Impl rule__Parameters__Group_3_2__1 ;
    public final void rule__Parameters__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1379:1: ( rule__Parameters__Group_3_2__0__Impl rule__Parameters__Group_3_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1380:2: rule__Parameters__Group_3_2__0__Impl rule__Parameters__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__0__Impl_in_rule__Parameters__Group_3_2__02780);
            rule__Parameters__Group_3_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__1_in_rule__Parameters__Group_3_2__02783);
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


    // $ANTLR start rule__Parameters__Group_3_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1387:1: rule__Parameters__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Parameters__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1391:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1392:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1392:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1393:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Parameters__Group_3_2__0__Impl2811); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getCommaKeyword_3_2_0()); 
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
    // $ANTLR end rule__Parameters__Group_3_2__0__Impl


    // $ANTLR start rule__Parameters__Group_3_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1406:1: rule__Parameters__Group_3_2__1 : rule__Parameters__Group_3_2__1__Impl rule__Parameters__Group_3_2__2 ;
    public final void rule__Parameters__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1410:1: ( rule__Parameters__Group_3_2__1__Impl rule__Parameters__Group_3_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1411:2: rule__Parameters__Group_3_2__1__Impl rule__Parameters__Group_3_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__1__Impl_in_rule__Parameters__Group_3_2__12842);
            rule__Parameters__Group_3_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__2_in_rule__Parameters__Group_3_2__12845);
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


    // $ANTLR start rule__Parameters__Group_3_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1418:1: rule__Parameters__Group_3_2__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Parameters__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1422:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1423:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1423:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1424:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1425:1: ( RULE_LT )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_LT) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1425:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__1__Impl2873); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Parameters__Group_3_2__1__Impl


    // $ANTLR start rule__Parameters__Group_3_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1435:1: rule__Parameters__Group_3_2__2 : rule__Parameters__Group_3_2__2__Impl rule__Parameters__Group_3_2__3 ;
    public final void rule__Parameters__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1439:1: ( rule__Parameters__Group_3_2__2__Impl rule__Parameters__Group_3_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1440:2: rule__Parameters__Group_3_2__2__Impl rule__Parameters__Group_3_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__2__Impl_in_rule__Parameters__Group_3_2__22904);
            rule__Parameters__Group_3_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__3_in_rule__Parameters__Group_3_2__22907);
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


    // $ANTLR start rule__Parameters__Group_3_2__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1447:1: rule__Parameters__Group_3_2__2__Impl : ( ( rule__Parameters__ParamsAssignment_3_2_2 ) ) ;
    public final void rule__Parameters__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1451:1: ( ( ( rule__Parameters__ParamsAssignment_3_2_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1452:1: ( ( rule__Parameters__ParamsAssignment_3_2_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1452:1: ( ( rule__Parameters__ParamsAssignment_3_2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1453:1: ( rule__Parameters__ParamsAssignment_3_2_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsAssignment_3_2_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1454:1: ( rule__Parameters__ParamsAssignment_3_2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1454:2: rule__Parameters__ParamsAssignment_3_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__ParamsAssignment_3_2_2_in_rule__Parameters__Group_3_2__2__Impl2934);
            rule__Parameters__ParamsAssignment_3_2_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getParametersAccess().getParamsAssignment_3_2_2()); 
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
    // $ANTLR end rule__Parameters__Group_3_2__2__Impl


    // $ANTLR start rule__Parameters__Group_3_2__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1464:1: rule__Parameters__Group_3_2__3 : rule__Parameters__Group_3_2__3__Impl ;
    public final void rule__Parameters__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1468:1: ( rule__Parameters__Group_3_2__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1469:2: rule__Parameters__Group_3_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameters__Group_3_2__3__Impl_in_rule__Parameters__Group_3_2__32964);
            rule__Parameters__Group_3_2__3__Impl();
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
    // $ANTLR end rule__Parameters__Group_3_2__3


    // $ANTLR start rule__Parameters__Group_3_2__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1475:1: rule__Parameters__Group_3_2__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Parameters__Group_3_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1479:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1480:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1480:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1481:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getLTTerminalRuleCall_3_2_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1482:1: ( RULE_LT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_LT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1482:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__3__Impl2992); if (failed) return ;

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
    // $ANTLR end rule__Parameters__Group_3_2__3__Impl


    // $ANTLR start rule__Block__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1500:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1504:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1505:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__03031);
            rule__Block__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__1_in_rule__Block__Group__03034);
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


    // $ANTLR start rule__Block__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1512:1: rule__Block__Group__0__Impl : ( () ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1516:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1517:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1517:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1518:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getBlockAction_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1519:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1521:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getBlockAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group__0__Impl


    // $ANTLR start rule__Block__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1531:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1535:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1536:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__13092);
            rule__Block__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__2_in_rule__Block__Group__13095);
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


    // $ANTLR start rule__Block__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1543:1: rule__Block__Group__1__Impl : ( '{' ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1547:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1548:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1548:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1549:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Block__Group__1__Impl3123); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
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
    // $ANTLR end rule__Block__Group__1__Impl


    // $ANTLR start rule__Block__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1562:1: rule__Block__Group__2 : rule__Block__Group__2__Impl rule__Block__Group__3 ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1566:1: ( rule__Block__Group__2__Impl rule__Block__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1567:2: rule__Block__Group__2__Impl rule__Block__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__23154);
            rule__Block__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__3_in_rule__Block__Group__23157);
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


    // $ANTLR start rule__Block__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1574:1: rule__Block__Group__2__Impl : ( ( rule__Block__Group_2__0 )* ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1578:1: ( ( ( rule__Block__Group_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1579:1: ( ( rule__Block__Group_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1579:1: ( ( rule__Block__Group_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1580:1: ( rule__Block__Group_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getGroup_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1581:1: ( rule__Block__Group_2__0 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1581:2: rule__Block__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Block__Group_2__0_in_rule__Block__Group__2__Impl3184);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group__2__Impl


    // $ANTLR start rule__Block__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1591:1: rule__Block__Group__3 : rule__Block__Group__3__Impl rule__Block__Group__4 ;
    public final void rule__Block__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1595:1: ( rule__Block__Group__3__Impl rule__Block__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1596:2: rule__Block__Group__3__Impl rule__Block__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__33215);
            rule__Block__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__4_in_rule__Block__Group__33218);
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


    // $ANTLR start rule__Block__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1603:1: rule__Block__Group__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Block__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1607:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1608:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1608:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1609:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getLTTerminalRuleCall_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1610:1: ( RULE_LT )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_LT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1610:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Block__Group__3__Impl3246); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group__3__Impl


    // $ANTLR start rule__Block__Group__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1620:1: rule__Block__Group__4 : rule__Block__Group__4__Impl ;
    public final void rule__Block__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1624:1: ( rule__Block__Group__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1625:2: rule__Block__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group__4__Impl_in_rule__Block__Group__43277);
            rule__Block__Group__4__Impl();
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
    // $ANTLR end rule__Block__Group__4


    // $ANTLR start rule__Block__Group__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1631:1: rule__Block__Group__4__Impl : ( '}' ) ;
    public final void rule__Block__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1635:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1636:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1636:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1637:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Block__Group__4__Impl3305); if (failed) return ;
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
    // $ANTLR end rule__Block__Group__4__Impl


    // $ANTLR start rule__Block__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1660:1: rule__Block__Group_2__0 : rule__Block__Group_2__0__Impl rule__Block__Group_2__1 ;
    public final void rule__Block__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1664:1: ( rule__Block__Group_2__0__Impl rule__Block__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1665:2: rule__Block__Group_2__0__Impl rule__Block__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group_2__0__Impl_in_rule__Block__Group_2__03346);
            rule__Block__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group_2__1_in_rule__Block__Group_2__03349);
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


    // $ANTLR start rule__Block__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1672:1: rule__Block__Group_2__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__Block__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1676:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1677:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1677:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1678:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getLTTerminalRuleCall_2_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1679:1: ( RULE_LT )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_LT) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1679:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__Block__Group_2__0__Impl3377); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Block__Group_2__0__Impl


    // $ANTLR start rule__Block__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1689:1: rule__Block__Group_2__1 : rule__Block__Group_2__1__Impl ;
    public final void rule__Block__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1693:1: ( rule__Block__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1694:2: rule__Block__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__Group_2__1__Impl_in_rule__Block__Group_2__13408);
            rule__Block__Group_2__1__Impl();
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
    // $ANTLR end rule__Block__Group_2__1


    // $ANTLR start rule__Block__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1700:1: rule__Block__Group_2__1__Impl : ( ( rule__Block__DirectivesAssignment_2_1 ) ) ;
    public final void rule__Block__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1704:1: ( ( ( rule__Block__DirectivesAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1705:1: ( ( rule__Block__DirectivesAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1705:1: ( ( rule__Block__DirectivesAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1706:1: ( rule__Block__DirectivesAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getDirectivesAssignment_2_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1707:1: ( rule__Block__DirectivesAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1707:2: rule__Block__DirectivesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Block__DirectivesAssignment_2_1_in_rule__Block__Group_2__1__Impl3435);
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
    // $ANTLR end rule__Block__Group_2__1__Impl


    // $ANTLR start rule__Statement__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1721:1: rule__Statement__Group_1__0 : rule__Statement__Group_1__0__Impl rule__Statement__Group_1__1 ;
    public final void rule__Statement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1725:1: ( rule__Statement__Group_1__0__Impl rule__Statement__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1726:2: rule__Statement__Group_1__0__Impl rule__Statement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__0__Impl_in_rule__Statement__Group_1__03469);
            rule__Statement__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__1_in_rule__Statement__Group_1__03472);
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


    // $ANTLR start rule__Statement__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1733:1: rule__Statement__Group_1__0__Impl : ( () ) ;
    public final void rule__Statement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1737:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1738:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1738:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1739:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getExpressionStatementAction_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1740:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1742:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getExpressionStatementAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Statement__Group_1__0__Impl


    // $ANTLR start rule__Statement__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1752:1: rule__Statement__Group_1__1 : rule__Statement__Group_1__1__Impl rule__Statement__Group_1__2 ;
    public final void rule__Statement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1756:1: ( rule__Statement__Group_1__1__Impl rule__Statement__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1757:2: rule__Statement__Group_1__1__Impl rule__Statement__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__1__Impl_in_rule__Statement__Group_1__13530);
            rule__Statement__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__2_in_rule__Statement__Group_1__13533);
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


    // $ANTLR start rule__Statement__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1764:1: rule__Statement__Group_1__1__Impl : ( ( rule__Statement__ExpressionAssignment_1_1 ) ) ;
    public final void rule__Statement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1768:1: ( ( ( rule__Statement__ExpressionAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1769:1: ( ( rule__Statement__ExpressionAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1769:1: ( ( rule__Statement__ExpressionAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1770:1: ( rule__Statement__ExpressionAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getExpressionAssignment_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1771:1: ( rule__Statement__ExpressionAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1771:2: rule__Statement__ExpressionAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__ExpressionAssignment_1_1_in_rule__Statement__Group_1__1__Impl3560);
            rule__Statement__ExpressionAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getExpressionAssignment_1_1()); 
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
    // $ANTLR end rule__Statement__Group_1__1__Impl


    // $ANTLR start rule__Statement__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1781:1: rule__Statement__Group_1__2 : rule__Statement__Group_1__2__Impl ;
    public final void rule__Statement__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1785:1: ( rule__Statement__Group_1__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1786:2: rule__Statement__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Group_1__2__Impl_in_rule__Statement__Group_1__23590);
            rule__Statement__Group_1__2__Impl();
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
    // $ANTLR end rule__Statement__Group_1__2


    // $ANTLR start rule__Statement__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1792:1: rule__Statement__Group_1__2__Impl : ( ( rule__Statement__Alternatives_1_2 ) ) ;
    public final void rule__Statement__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1796:1: ( ( ( rule__Statement__Alternatives_1_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1797:1: ( ( rule__Statement__Alternatives_1_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1797:1: ( ( rule__Statement__Alternatives_1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1798:1: ( rule__Statement__Alternatives_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getAlternatives_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1799:1: ( rule__Statement__Alternatives_1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1799:2: rule__Statement__Alternatives_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Statement__Alternatives_1_2_in_rule__Statement__Group_1__2__Impl3617);
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
    // $ANTLR end rule__Statement__Group_1__2__Impl


    // $ANTLR start rule__PostfixExpression__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1815:1: rule__PostfixExpression__Group__0 : rule__PostfixExpression__Group__0__Impl rule__PostfixExpression__Group__1 ;
    public final void rule__PostfixExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1819:1: ( rule__PostfixExpression__Group__0__Impl rule__PostfixExpression__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1820:2: rule__PostfixExpression__Group__0__Impl rule__PostfixExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group__0__Impl_in_rule__PostfixExpression__Group__03653);
            rule__PostfixExpression__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group__1_in_rule__PostfixExpression__Group__03656);
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


    // $ANTLR start rule__PostfixExpression__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1827:1: rule__PostfixExpression__Group__0__Impl : ( rulePrimaryExpression ) ;
    public final void rule__PostfixExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1831:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1832:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1832:1: ( rulePrimaryExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1833:1: rulePrimaryExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpression_in_rule__PostfixExpression__Group__0__Impl3683);
            rulePrimaryExpression();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
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
    // $ANTLR end rule__PostfixExpression__Group__0__Impl


    // $ANTLR start rule__PostfixExpression__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1844:1: rule__PostfixExpression__Group__1 : rule__PostfixExpression__Group__1__Impl ;
    public final void rule__PostfixExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1848:1: ( rule__PostfixExpression__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1849:2: rule__PostfixExpression__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group__1__Impl_in_rule__PostfixExpression__Group__13712);
            rule__PostfixExpression__Group__1__Impl();
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
    // $ANTLR end rule__PostfixExpression__Group__1


    // $ANTLR start rule__PostfixExpression__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1855:1: rule__PostfixExpression__Group__1__Impl : ( ( rule__PostfixExpression__Alternatives_1 )* ) ;
    public final void rule__PostfixExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1859:1: ( ( ( rule__PostfixExpression__Alternatives_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1860:1: ( ( rule__PostfixExpression__Alternatives_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1860:1: ( ( rule__PostfixExpression__Alternatives_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1861:1: ( rule__PostfixExpression__Alternatives_1 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1862:1: ( rule__PostfixExpression__Alternatives_1 )*
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1862:2: rule__PostfixExpression__Alternatives_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Alternatives_1_in_rule__PostfixExpression__Group__1__Impl3739);
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
    // $ANTLR end rule__PostfixExpression__Group__1__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1876:1: rule__PostfixExpression__Group_1_0__0 : rule__PostfixExpression__Group_1_0__0__Impl rule__PostfixExpression__Group_1_0__1 ;
    public final void rule__PostfixExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1880:1: ( rule__PostfixExpression__Group_1_0__0__Impl rule__PostfixExpression__Group_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1881:2: rule__PostfixExpression__Group_1_0__0__Impl rule__PostfixExpression__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__0__Impl_in_rule__PostfixExpression__Group_1_0__03774);
            rule__PostfixExpression__Group_1_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__1_in_rule__PostfixExpression__Group_1_0__03777);
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


    // $ANTLR start rule__PostfixExpression__Group_1_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1888:1: rule__PostfixExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__PostfixExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1892:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1893:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1893:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1894:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionExpressionAction_1_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1895:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1897:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionExpressionAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_0__0__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1907:1: rule__PostfixExpression__Group_1_0__1 : rule__PostfixExpression__Group_1_0__1__Impl rule__PostfixExpression__Group_1_0__2 ;
    public final void rule__PostfixExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1911:1: ( rule__PostfixExpression__Group_1_0__1__Impl rule__PostfixExpression__Group_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1912:2: rule__PostfixExpression__Group_1_0__1__Impl rule__PostfixExpression__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__1__Impl_in_rule__PostfixExpression__Group_1_0__13835);
            rule__PostfixExpression__Group_1_0__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__2_in_rule__PostfixExpression__Group_1_0__13838);
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


    // $ANTLR start rule__PostfixExpression__Group_1_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1919:1: rule__PostfixExpression__Group_1_0__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PostfixExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1923:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1924:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1924:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1925:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1926:1: ( RULE_LT )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_LT) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1926:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_0__1__Impl3866); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_0__1__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1936:1: rule__PostfixExpression__Group_1_0__2 : rule__PostfixExpression__Group_1_0__2__Impl ;
    public final void rule__PostfixExpression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1940:1: ( rule__PostfixExpression__Group_1_0__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1941:2: rule__PostfixExpression__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_0__2__Impl_in_rule__PostfixExpression__Group_1_0__23897);
            rule__PostfixExpression__Group_1_0__2__Impl();
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
    // $ANTLR end rule__PostfixExpression__Group_1_0__2


    // $ANTLR start rule__PostfixExpression__Group_1_0__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1947:1: rule__PostfixExpression__Group_1_0__2__Impl : ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) ) ;
    public final void rule__PostfixExpression__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1951:1: ( ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1952:1: ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1952:1: ( ( rule__PostfixExpression__PropertyAssignment_1_0_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1953:1: ( rule__PostfixExpression__PropertyAssignment_1_0_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPropertyAssignment_1_0_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1954:1: ( rule__PostfixExpression__PropertyAssignment_1_0_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1954:2: rule__PostfixExpression__PropertyAssignment_1_0_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__PropertyAssignment_1_0_2_in_rule__PostfixExpression__Group_1_0__2__Impl3924);
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
    // $ANTLR end rule__PostfixExpression__Group_1_0__2__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1970:1: rule__PostfixExpression__Group_1_1__0 : rule__PostfixExpression__Group_1_1__0__Impl rule__PostfixExpression__Group_1_1__1 ;
    public final void rule__PostfixExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1974:1: ( rule__PostfixExpression__Group_1_1__0__Impl rule__PostfixExpression__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1975:2: rule__PostfixExpression__Group_1_1__0__Impl rule__PostfixExpression__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__0__Impl_in_rule__PostfixExpression__Group_1_1__03960);
            rule__PostfixExpression__Group_1_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__1_in_rule__PostfixExpression__Group_1_1__03963);
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


    // $ANTLR start rule__PostfixExpression__Group_1_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1982:1: rule__PostfixExpression__Group_1_1__0__Impl : ( () ) ;
    public final void rule__PostfixExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1986:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1987:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1987:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1988:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getInvocationExpressionAction_1_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1989:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1991:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getInvocationExpressionAction_1_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__0__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2001:1: rule__PostfixExpression__Group_1_1__1 : rule__PostfixExpression__Group_1_1__1__Impl rule__PostfixExpression__Group_1_1__2 ;
    public final void rule__PostfixExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2005:1: ( rule__PostfixExpression__Group_1_1__1__Impl rule__PostfixExpression__Group_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2006:2: rule__PostfixExpression__Group_1_1__1__Impl rule__PostfixExpression__Group_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__1__Impl_in_rule__PostfixExpression__Group_1_1__14021);
            rule__PostfixExpression__Group_1_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__2_in_rule__PostfixExpression__Group_1_1__14024);
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


    // $ANTLR start rule__PostfixExpression__Group_1_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2013:1: rule__PostfixExpression__Group_1_1__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PostfixExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2017:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2018:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2018:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2019:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2020:1: ( RULE_LT )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_LT) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2020:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__1__Impl4052); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__1__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2030:1: rule__PostfixExpression__Group_1_1__2 : rule__PostfixExpression__Group_1_1__2__Impl rule__PostfixExpression__Group_1_1__3 ;
    public final void rule__PostfixExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2034:1: ( rule__PostfixExpression__Group_1_1__2__Impl rule__PostfixExpression__Group_1_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2035:2: rule__PostfixExpression__Group_1_1__2__Impl rule__PostfixExpression__Group_1_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__2__Impl_in_rule__PostfixExpression__Group_1_1__24083);
            rule__PostfixExpression__Group_1_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__3_in_rule__PostfixExpression__Group_1_1__24086);
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


    // $ANTLR start rule__PostfixExpression__Group_1_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2042:1: rule__PostfixExpression__Group_1_1__2__Impl : ( '(' ) ;
    public final void rule__PostfixExpression__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2046:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2047:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2047:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2048:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLeftParenthesisKeyword_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_11_in_rule__PostfixExpression__Group_1_1__2__Impl4114); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getLeftParenthesisKeyword_1_1_2()); 
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
    // $ANTLR end rule__PostfixExpression__Group_1_1__2__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2061:1: rule__PostfixExpression__Group_1_1__3 : rule__PostfixExpression__Group_1_1__3__Impl rule__PostfixExpression__Group_1_1__4 ;
    public final void rule__PostfixExpression__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2065:1: ( rule__PostfixExpression__Group_1_1__3__Impl rule__PostfixExpression__Group_1_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2066:2: rule__PostfixExpression__Group_1_1__3__Impl rule__PostfixExpression__Group_1_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__3__Impl_in_rule__PostfixExpression__Group_1_1__34145);
            rule__PostfixExpression__Group_1_1__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__4_in_rule__PostfixExpression__Group_1_1__34148);
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


    // $ANTLR start rule__PostfixExpression__Group_1_1__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2073:1: rule__PostfixExpression__Group_1_1__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PostfixExpression__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2077:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2078:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2078:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2079:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2080:1: ( RULE_LT )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_LT) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2080:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__3__Impl4176); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__3__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2090:1: rule__PostfixExpression__Group_1_1__4 : rule__PostfixExpression__Group_1_1__4__Impl rule__PostfixExpression__Group_1_1__5 ;
    public final void rule__PostfixExpression__Group_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2094:1: ( rule__PostfixExpression__Group_1_1__4__Impl rule__PostfixExpression__Group_1_1__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2095:2: rule__PostfixExpression__Group_1_1__4__Impl rule__PostfixExpression__Group_1_1__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__4__Impl_in_rule__PostfixExpression__Group_1_1__44207);
            rule__PostfixExpression__Group_1_1__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__5_in_rule__PostfixExpression__Group_1_1__44210);
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


    // $ANTLR start rule__PostfixExpression__Group_1_1__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2102:1: rule__PostfixExpression__Group_1_1__4__Impl : ( ( rule__PostfixExpression__Group_1_1_4__0 )? ) ;
    public final void rule__PostfixExpression__Group_1_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2106:1: ( ( ( rule__PostfixExpression__Group_1_1_4__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2107:1: ( ( rule__PostfixExpression__Group_1_1_4__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2107:1: ( ( rule__PostfixExpression__Group_1_1_4__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2108:1: ( rule__PostfixExpression__Group_1_1_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getGroup_1_1_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2109:1: ( rule__PostfixExpression__Group_1_1_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID||LA30_0==8) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2109:2: rule__PostfixExpression__Group_1_1_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1_4__0_in_rule__PostfixExpression__Group_1_1__4__Impl4237);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PostfixExpression__Group_1_1__4__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2119:1: rule__PostfixExpression__Group_1_1__5 : rule__PostfixExpression__Group_1_1__5__Impl ;
    public final void rule__PostfixExpression__Group_1_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2123:1: ( rule__PostfixExpression__Group_1_1__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2124:2: rule__PostfixExpression__Group_1_1__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1__5__Impl_in_rule__PostfixExpression__Group_1_1__54268);
            rule__PostfixExpression__Group_1_1__5__Impl();
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
    // $ANTLR end rule__PostfixExpression__Group_1_1__5


    // $ANTLR start rule__PostfixExpression__Group_1_1__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2130:1: rule__PostfixExpression__Group_1_1__5__Impl : ( ')' ) ;
    public final void rule__PostfixExpression__Group_1_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2134:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2135:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2135:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2136:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getRightParenthesisKeyword_1_1_5()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__PostfixExpression__Group_1_1__5__Impl4296); if (failed) return ;
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
    // $ANTLR end rule__PostfixExpression__Group_1_1__5__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2161:1: rule__PostfixExpression__Group_1_1_4__0 : rule__PostfixExpression__Group_1_1_4__0__Impl rule__PostfixExpression__Group_1_1_4__1 ;
    public final void rule__PostfixExpression__Group_1_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2165:1: ( rule__PostfixExpression__Group_1_1_4__0__Impl rule__PostfixExpression__Group_1_1_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2166:2: rule__PostfixExpression__Group_1_1_4__0__Impl rule__PostfixExpression__Group_1_1_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1_4__0__Impl_in_rule__PostfixExpression__Group_1_1_4__04339);
            rule__PostfixExpression__Group_1_1_4__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1_4__1_in_rule__PostfixExpression__Group_1_1_4__04342);
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


    // $ANTLR start rule__PostfixExpression__Group_1_1_4__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2173:1: rule__PostfixExpression__Group_1_1_4__0__Impl : ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) ) ;
    public final void rule__PostfixExpression__Group_1_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2177:1: ( ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2178:1: ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2178:1: ( ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2179:1: ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getArgumentsAssignment_1_1_4_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2180:1: ( rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2180:2: rule__PostfixExpression__ArgumentsAssignment_1_1_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__ArgumentsAssignment_1_1_4_0_in_rule__PostfixExpression__Group_1_1_4__0__Impl4369);
            rule__PostfixExpression__ArgumentsAssignment_1_1_4_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPostfixExpressionAccess().getArgumentsAssignment_1_1_4_0()); 
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
    // $ANTLR end rule__PostfixExpression__Group_1_1_4__0__Impl


    // $ANTLR start rule__PostfixExpression__Group_1_1_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2190:1: rule__PostfixExpression__Group_1_1_4__1 : rule__PostfixExpression__Group_1_1_4__1__Impl ;
    public final void rule__PostfixExpression__Group_1_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2194:1: ( rule__PostfixExpression__Group_1_1_4__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2195:2: rule__PostfixExpression__Group_1_1_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Group_1_1_4__1__Impl_in_rule__PostfixExpression__Group_1_1_4__14399);
            rule__PostfixExpression__Group_1_1_4__1__Impl();
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
    // $ANTLR end rule__PostfixExpression__Group_1_1_4__1


    // $ANTLR start rule__PostfixExpression__Group_1_1_4__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2201:1: rule__PostfixExpression__Group_1_1_4__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PostfixExpression__Group_1_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2205:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2206:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2206:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2207:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getLTTerminalRuleCall_1_1_4_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2208:1: ( RULE_LT )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_LT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2208:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1_4__1__Impl4427); if (failed) return ;

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
    // $ANTLR end rule__PostfixExpression__Group_1_1_4__1__Impl


    // $ANTLR start rule__ListExpression__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2222:1: rule__ListExpression__Group__0 : rule__ListExpression__Group__0__Impl rule__ListExpression__Group__1 ;
    public final void rule__ListExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2226:1: ( rule__ListExpression__Group__0__Impl rule__ListExpression__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2227:2: rule__ListExpression__Group__0__Impl rule__ListExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group__0__Impl_in_rule__ListExpression__Group__04462);
            rule__ListExpression__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group__1_in_rule__ListExpression__Group__04465);
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


    // $ANTLR start rule__ListExpression__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2234:1: rule__ListExpression__Group__0__Impl : ( ( rule__ListExpression__ExpressionsAssignment_0 ) ) ;
    public final void rule__ListExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2238:1: ( ( ( rule__ListExpression__ExpressionsAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2239:1: ( ( rule__ListExpression__ExpressionsAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2239:1: ( ( rule__ListExpression__ExpressionsAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2240:1: ( rule__ListExpression__ExpressionsAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsAssignment_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2241:1: ( rule__ListExpression__ExpressionsAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2241:2: rule__ListExpression__ExpressionsAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__ExpressionsAssignment_0_in_rule__ListExpression__Group__0__Impl4492);
            rule__ListExpression__ExpressionsAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getExpressionsAssignment_0()); 
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
    // $ANTLR end rule__ListExpression__Group__0__Impl


    // $ANTLR start rule__ListExpression__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2251:1: rule__ListExpression__Group__1 : rule__ListExpression__Group__1__Impl ;
    public final void rule__ListExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2255:1: ( rule__ListExpression__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2256:2: rule__ListExpression__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group__1__Impl_in_rule__ListExpression__Group__14522);
            rule__ListExpression__Group__1__Impl();
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
    // $ANTLR end rule__ListExpression__Group__1


    // $ANTLR start rule__ListExpression__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2262:1: rule__ListExpression__Group__1__Impl : ( ( rule__ListExpression__Group_1__0 )* ) ;
    public final void rule__ListExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2266:1: ( ( ( rule__ListExpression__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2267:1: ( ( rule__ListExpression__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2267:1: ( ( rule__ListExpression__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2268:1: ( rule__ListExpression__Group_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getGroup_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2269:1: ( rule__ListExpression__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2269:2: rule__ListExpression__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__0_in_rule__ListExpression__Group__1__Impl4549);
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
    // $ANTLR end rule__ListExpression__Group__1__Impl


    // $ANTLR start rule__ListExpression__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2283:1: rule__ListExpression__Group_1__0 : rule__ListExpression__Group_1__0__Impl rule__ListExpression__Group_1__1 ;
    public final void rule__ListExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2287:1: ( rule__ListExpression__Group_1__0__Impl rule__ListExpression__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2288:2: rule__ListExpression__Group_1__0__Impl rule__ListExpression__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__0__Impl_in_rule__ListExpression__Group_1__04584);
            rule__ListExpression__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__1_in_rule__ListExpression__Group_1__04587);
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


    // $ANTLR start rule__ListExpression__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2295:1: rule__ListExpression__Group_1__0__Impl : ( ( RULE_LT )* ) ;
    public final void rule__ListExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2299:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2300:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2300:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2301:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2302:1: ( RULE_LT )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_LT) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2302:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__0__Impl4615); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ListExpression__Group_1__0__Impl


    // $ANTLR start rule__ListExpression__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2312:1: rule__ListExpression__Group_1__1 : rule__ListExpression__Group_1__1__Impl rule__ListExpression__Group_1__2 ;
    public final void rule__ListExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2316:1: ( rule__ListExpression__Group_1__1__Impl rule__ListExpression__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2317:2: rule__ListExpression__Group_1__1__Impl rule__ListExpression__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__1__Impl_in_rule__ListExpression__Group_1__14646);
            rule__ListExpression__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__2_in_rule__ListExpression__Group_1__14649);
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


    // $ANTLR start rule__ListExpression__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2324:1: rule__ListExpression__Group_1__1__Impl : ( ',' ) ;
    public final void rule__ListExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2328:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2329:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2329:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2330:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getCommaKeyword_1_1()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ListExpression__Group_1__1__Impl4677); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getListExpressionAccess().getCommaKeyword_1_1()); 
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
    // $ANTLR end rule__ListExpression__Group_1__1__Impl


    // $ANTLR start rule__ListExpression__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2343:1: rule__ListExpression__Group_1__2 : rule__ListExpression__Group_1__2__Impl rule__ListExpression__Group_1__3 ;
    public final void rule__ListExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2347:1: ( rule__ListExpression__Group_1__2__Impl rule__ListExpression__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2348:2: rule__ListExpression__Group_1__2__Impl rule__ListExpression__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__2__Impl_in_rule__ListExpression__Group_1__24708);
            rule__ListExpression__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__3_in_rule__ListExpression__Group_1__24711);
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


    // $ANTLR start rule__ListExpression__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2355:1: rule__ListExpression__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__ListExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2359:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2360:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2360:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2361:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getLTTerminalRuleCall_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2362:1: ( RULE_LT )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_LT) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2362:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__2__Impl4739); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ListExpression__Group_1__2__Impl


    // $ANTLR start rule__ListExpression__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2372:1: rule__ListExpression__Group_1__3 : rule__ListExpression__Group_1__3__Impl ;
    public final void rule__ListExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2376:1: ( rule__ListExpression__Group_1__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2377:2: rule__ListExpression__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__Group_1__3__Impl_in_rule__ListExpression__Group_1__34770);
            rule__ListExpression__Group_1__3__Impl();
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
    // $ANTLR end rule__ListExpression__Group_1__3


    // $ANTLR start rule__ListExpression__Group_1__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2383:1: rule__ListExpression__Group_1__3__Impl : ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) ) ;
    public final void rule__ListExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2387:1: ( ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2388:1: ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2388:1: ( ( rule__ListExpression__ExpressionsAssignment_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2389:1: ( rule__ListExpression__ExpressionsAssignment_1_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsAssignment_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2390:1: ( rule__ListExpression__ExpressionsAssignment_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2390:2: rule__ListExpression__ExpressionsAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ListExpression__ExpressionsAssignment_1_3_in_rule__ListExpression__Group_1__3__Impl4797);
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
    // $ANTLR end rule__ListExpression__Group_1__3__Impl


    // $ANTLR start rule__PropertyOperator__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2408:1: rule__PropertyOperator__Group_0__0 : rule__PropertyOperator__Group_0__0__Impl rule__PropertyOperator__Group_0__1 ;
    public final void rule__PropertyOperator__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2412:1: ( rule__PropertyOperator__Group_0__0__Impl rule__PropertyOperator__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2413:2: rule__PropertyOperator__Group_0__0__Impl rule__PropertyOperator__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__0__Impl_in_rule__PropertyOperator__Group_0__04835);
            rule__PropertyOperator__Group_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__1_in_rule__PropertyOperator__Group_0__04838);
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


    // $ANTLR start rule__PropertyOperator__Group_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2420:1: rule__PropertyOperator__Group_0__0__Impl : ( '.' ) ;
    public final void rule__PropertyOperator__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2424:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2425:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2425:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2426:1: '.'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getFullStopKeyword_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__PropertyOperator__Group_0__0__Impl4866); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getFullStopKeyword_0_0()); 
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
    // $ANTLR end rule__PropertyOperator__Group_0__0__Impl


    // $ANTLR start rule__PropertyOperator__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2439:1: rule__PropertyOperator__Group_0__1 : rule__PropertyOperator__Group_0__1__Impl rule__PropertyOperator__Group_0__2 ;
    public final void rule__PropertyOperator__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2443:1: ( rule__PropertyOperator__Group_0__1__Impl rule__PropertyOperator__Group_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2444:2: rule__PropertyOperator__Group_0__1__Impl rule__PropertyOperator__Group_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__1__Impl_in_rule__PropertyOperator__Group_0__14897);
            rule__PropertyOperator__Group_0__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__2_in_rule__PropertyOperator__Group_0__14900);
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


    // $ANTLR start rule__PropertyOperator__Group_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2451:1: rule__PropertyOperator__Group_0__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PropertyOperator__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2455:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2456:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2456:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2457:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2458:1: ( RULE_LT )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_LT) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2458:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_0__1__Impl4928); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_0__1__Impl


    // $ANTLR start rule__PropertyOperator__Group_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2468:1: rule__PropertyOperator__Group_0__2 : rule__PropertyOperator__Group_0__2__Impl ;
    public final void rule__PropertyOperator__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2472:1: ( rule__PropertyOperator__Group_0__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2473:2: rule__PropertyOperator__Group_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_0__2__Impl_in_rule__PropertyOperator__Group_0__24959);
            rule__PropertyOperator__Group_0__2__Impl();
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
    // $ANTLR end rule__PropertyOperator__Group_0__2


    // $ANTLR start rule__PropertyOperator__Group_0__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2479:1: rule__PropertyOperator__Group_0__2__Impl : ( ( rule__PropertyOperator__NameAssignment_0_2 ) ) ;
    public final void rule__PropertyOperator__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2483:1: ( ( ( rule__PropertyOperator__NameAssignment_0_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2484:1: ( ( rule__PropertyOperator__NameAssignment_0_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2484:1: ( ( rule__PropertyOperator__NameAssignment_0_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2485:1: ( rule__PropertyOperator__NameAssignment_0_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getNameAssignment_0_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2486:1: ( rule__PropertyOperator__NameAssignment_0_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2486:2: rule__PropertyOperator__NameAssignment_0_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__NameAssignment_0_2_in_rule__PropertyOperator__Group_0__2__Impl4986);
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
    // $ANTLR end rule__PropertyOperator__Group_0__2__Impl


    // $ANTLR start rule__PropertyOperator__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2502:1: rule__PropertyOperator__Group_1__0 : rule__PropertyOperator__Group_1__0__Impl rule__PropertyOperator__Group_1__1 ;
    public final void rule__PropertyOperator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2506:1: ( rule__PropertyOperator__Group_1__0__Impl rule__PropertyOperator__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2507:2: rule__PropertyOperator__Group_1__0__Impl rule__PropertyOperator__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__0__Impl_in_rule__PropertyOperator__Group_1__05022);
            rule__PropertyOperator__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__1_in_rule__PropertyOperator__Group_1__05025);
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


    // $ANTLR start rule__PropertyOperator__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2514:1: rule__PropertyOperator__Group_1__0__Impl : ( '[' ) ;
    public final void rule__PropertyOperator__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2518:1: ( ( '[' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2519:1: ( '[' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2519:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2520:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,9,FollowSets000.FOLLOW_9_in_rule__PropertyOperator__Group_1__0__Impl5053); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getLeftSquareBracketKeyword_1_0()); 
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
    // $ANTLR end rule__PropertyOperator__Group_1__0__Impl


    // $ANTLR start rule__PropertyOperator__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2533:1: rule__PropertyOperator__Group_1__1 : rule__PropertyOperator__Group_1__1__Impl rule__PropertyOperator__Group_1__2 ;
    public final void rule__PropertyOperator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2537:1: ( rule__PropertyOperator__Group_1__1__Impl rule__PropertyOperator__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2538:2: rule__PropertyOperator__Group_1__1__Impl rule__PropertyOperator__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__1__Impl_in_rule__PropertyOperator__Group_1__15084);
            rule__PropertyOperator__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__2_in_rule__PropertyOperator__Group_1__15087);
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


    // $ANTLR start rule__PropertyOperator__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2545:1: rule__PropertyOperator__Group_1__1__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PropertyOperator__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2549:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2550:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2550:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2551:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2552:1: ( RULE_LT )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_LT) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2552:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__1__Impl5115); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_1__1__Impl


    // $ANTLR start rule__PropertyOperator__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2562:1: rule__PropertyOperator__Group_1__2 : rule__PropertyOperator__Group_1__2__Impl rule__PropertyOperator__Group_1__3 ;
    public final void rule__PropertyOperator__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2566:1: ( rule__PropertyOperator__Group_1__2__Impl rule__PropertyOperator__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2567:2: rule__PropertyOperator__Group_1__2__Impl rule__PropertyOperator__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__2__Impl_in_rule__PropertyOperator__Group_1__25146);
            rule__PropertyOperator__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__3_in_rule__PropertyOperator__Group_1__25149);
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


    // $ANTLR start rule__PropertyOperator__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2574:1: rule__PropertyOperator__Group_1__2__Impl : ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) ) ;
    public final void rule__PropertyOperator__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2578:1: ( ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2579:1: ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2579:1: ( ( rule__PropertyOperator__ExpressionsAssignment_1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2580:1: ( rule__PropertyOperator__ExpressionsAssignment_1_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getExpressionsAssignment_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2581:1: ( rule__PropertyOperator__ExpressionsAssignment_1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2581:2: rule__PropertyOperator__ExpressionsAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__ExpressionsAssignment_1_2_in_rule__PropertyOperator__Group_1__2__Impl5176);
            rule__PropertyOperator__ExpressionsAssignment_1_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPropertyOperatorAccess().getExpressionsAssignment_1_2()); 
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
    // $ANTLR end rule__PropertyOperator__Group_1__2__Impl


    // $ANTLR start rule__PropertyOperator__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2591:1: rule__PropertyOperator__Group_1__3 : rule__PropertyOperator__Group_1__3__Impl rule__PropertyOperator__Group_1__4 ;
    public final void rule__PropertyOperator__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2595:1: ( rule__PropertyOperator__Group_1__3__Impl rule__PropertyOperator__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2596:2: rule__PropertyOperator__Group_1__3__Impl rule__PropertyOperator__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__3__Impl_in_rule__PropertyOperator__Group_1__35206);
            rule__PropertyOperator__Group_1__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__4_in_rule__PropertyOperator__Group_1__35209);
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


    // $ANTLR start rule__PropertyOperator__Group_1__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2603:1: rule__PropertyOperator__Group_1__3__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PropertyOperator__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2607:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2608:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2608:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2609:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getLTTerminalRuleCall_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2610:1: ( RULE_LT )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_LT) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2610:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__3__Impl5237); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyOperator__Group_1__3__Impl


    // $ANTLR start rule__PropertyOperator__Group_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2620:1: rule__PropertyOperator__Group_1__4 : rule__PropertyOperator__Group_1__4__Impl ;
    public final void rule__PropertyOperator__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2624:1: ( rule__PropertyOperator__Group_1__4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2625:2: rule__PropertyOperator__Group_1__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PropertyOperator__Group_1__4__Impl_in_rule__PropertyOperator__Group_1__45268);
            rule__PropertyOperator__Group_1__4__Impl();
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
    // $ANTLR end rule__PropertyOperator__Group_1__4


    // $ANTLR start rule__PropertyOperator__Group_1__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2631:1: rule__PropertyOperator__Group_1__4__Impl : ( ']' ) ;
    public final void rule__PropertyOperator__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2635:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2636:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2636:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2637:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getRightSquareBracketKeyword_1_4()); 
            }
            match(input,10,FollowSets000.FOLLOW_10_in_rule__PropertyOperator__Group_1__4__Impl5296); if (failed) return ;
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
    // $ANTLR end rule__PropertyOperator__Group_1__4__Impl


    // $ANTLR start rule__PrimaryExpression__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2660:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2664:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2665:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__05337);
            rule__PrimaryExpression__Group_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__05340);
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


    // $ANTLR start rule__PrimaryExpression__Group_0__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2672:1: rule__PrimaryExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2676:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2677:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2677:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2678:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getIdentifierAction_0_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2679:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2681:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getIdentifierAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_0__0__Impl


    // $ANTLR start rule__PrimaryExpression__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2691:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2695:1: ( rule__PrimaryExpression__Group_0__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2696:2: rule__PrimaryExpression__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__15398);
            rule__PrimaryExpression__Group_0__1__Impl();
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
    // $ANTLR end rule__PrimaryExpression__Group_0__1


    // $ANTLR start rule__PrimaryExpression__Group_0__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2702:1: rule__PrimaryExpression__Group_0__1__Impl : ( ( rule__PrimaryExpression__NameAssignment_0_1 ) ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2706:1: ( ( ( rule__PrimaryExpression__NameAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2707:1: ( ( rule__PrimaryExpression__NameAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2707:1: ( ( rule__PrimaryExpression__NameAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2708:1: ( rule__PrimaryExpression__NameAssignment_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getNameAssignment_0_1()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2709:1: ( rule__PrimaryExpression__NameAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2709:2: rule__PrimaryExpression__NameAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__NameAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl5425);
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
    // $ANTLR end rule__PrimaryExpression__Group_0__1__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2723:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2727:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2728:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__05459);
            rule__PrimaryExpression__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__05462);
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


    // $ANTLR start rule__PrimaryExpression__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2735:1: rule__PrimaryExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2739:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2740:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2740:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2741:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getFunctionExpressionAction_1_0()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2742:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2744:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getFunctionExpressionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__0__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2754:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2758:1: ( rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2759:2: rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__15520);
            rule__PrimaryExpression__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__15523);
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


    // $ANTLR start rule__PrimaryExpression__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2766:1: rule__PrimaryExpression__Group_1__1__Impl : ( 'function' ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2770:1: ( ( 'function' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2771:1: ( 'function' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2771:1: ( 'function' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2772:1: 'function'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getFunctionKeyword_1_1()); 
            }
            match(input,8,FollowSets000.FOLLOW_8_in_rule__PrimaryExpression__Group_1__1__Impl5551); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getFunctionKeyword_1_1()); 
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
    // $ANTLR end rule__PrimaryExpression__Group_1__1__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2785:1: rule__PrimaryExpression__Group_1__2 : rule__PrimaryExpression__Group_1__2__Impl rule__PrimaryExpression__Group_1__3 ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2789:1: ( rule__PrimaryExpression__Group_1__2__Impl rule__PrimaryExpression__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2790:2: rule__PrimaryExpression__Group_1__2__Impl rule__PrimaryExpression__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__25582);
            rule__PrimaryExpression__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__3_in_rule__PrimaryExpression__Group_1__25585);
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


    // $ANTLR start rule__PrimaryExpression__Group_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2797:1: rule__PrimaryExpression__Group_1__2__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PrimaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2801:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2802:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2802:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2803:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_2()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2804:1: ( RULE_LT )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_LT) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2804:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__2__Impl5613); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__2__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2814:1: rule__PrimaryExpression__Group_1__3 : rule__PrimaryExpression__Group_1__3__Impl rule__PrimaryExpression__Group_1__4 ;
    public final void rule__PrimaryExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2818:1: ( rule__PrimaryExpression__Group_1__3__Impl rule__PrimaryExpression__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2819:2: rule__PrimaryExpression__Group_1__3__Impl rule__PrimaryExpression__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__3__Impl_in_rule__PrimaryExpression__Group_1__35644);
            rule__PrimaryExpression__Group_1__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__4_in_rule__PrimaryExpression__Group_1__35647);
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


    // $ANTLR start rule__PrimaryExpression__Group_1__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2826:1: rule__PrimaryExpression__Group_1__3__Impl : ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) ) ;
    public final void rule__PrimaryExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2830:1: ( ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2831:1: ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2831:1: ( ( rule__PrimaryExpression__ParamsAssignment_1_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2832:1: ( rule__PrimaryExpression__ParamsAssignment_1_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getParamsAssignment_1_3()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2833:1: ( rule__PrimaryExpression__ParamsAssignment_1_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2833:2: rule__PrimaryExpression__ParamsAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__ParamsAssignment_1_3_in_rule__PrimaryExpression__Group_1__3__Impl5674);
            rule__PrimaryExpression__ParamsAssignment_1_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getPrimaryExpressionAccess().getParamsAssignment_1_3()); 
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
    // $ANTLR end rule__PrimaryExpression__Group_1__3__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__4
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2843:1: rule__PrimaryExpression__Group_1__4 : rule__PrimaryExpression__Group_1__4__Impl rule__PrimaryExpression__Group_1__5 ;
    public final void rule__PrimaryExpression__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2847:1: ( rule__PrimaryExpression__Group_1__4__Impl rule__PrimaryExpression__Group_1__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2848:2: rule__PrimaryExpression__Group_1__4__Impl rule__PrimaryExpression__Group_1__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__4__Impl_in_rule__PrimaryExpression__Group_1__45704);
            rule__PrimaryExpression__Group_1__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__5_in_rule__PrimaryExpression__Group_1__45707);
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


    // $ANTLR start rule__PrimaryExpression__Group_1__4__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2855:1: rule__PrimaryExpression__Group_1__4__Impl : ( ( RULE_LT )* ) ;
    public final void rule__PrimaryExpression__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2859:1: ( ( ( RULE_LT )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2860:1: ( ( RULE_LT )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2860:1: ( ( RULE_LT )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2861:1: ( RULE_LT )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getLTTerminalRuleCall_1_4()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2862:1: ( RULE_LT )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_LT) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2862:3: RULE_LT
            	    {
            	    match(input,RULE_LT,FollowSets000.FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__4__Impl5735); if (failed) return ;

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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_1__4__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__5
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2872:1: rule__PrimaryExpression__Group_1__5 : rule__PrimaryExpression__Group_1__5__Impl ;
    public final void rule__PrimaryExpression__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2876:1: ( rule__PrimaryExpression__Group_1__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2877:2: rule__PrimaryExpression__Group_1__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__Group_1__5__Impl_in_rule__PrimaryExpression__Group_1__55766);
            rule__PrimaryExpression__Group_1__5__Impl();
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
    // $ANTLR end rule__PrimaryExpression__Group_1__5


    // $ANTLR start rule__PrimaryExpression__Group_1__5__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2883:1: rule__PrimaryExpression__Group_1__5__Impl : ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) ) ;
    public final void rule__PrimaryExpression__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2887:1: ( ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2888:1: ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2888:1: ( ( rule__PrimaryExpression__BodyAssignment_1_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2889:1: ( rule__PrimaryExpression__BodyAssignment_1_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getBodyAssignment_1_5()); 
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2890:1: ( rule__PrimaryExpression__BodyAssignment_1_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2890:2: rule__PrimaryExpression__BodyAssignment_1_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__PrimaryExpression__BodyAssignment_1_5_in_rule__PrimaryExpression__Group_1__5__Impl5793);
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
    // $ANTLR end rule__PrimaryExpression__Group_1__5__Impl


    // $ANTLR start rule__Program__DirectivesAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2913:1: rule__Program__DirectivesAssignment_1_1 : ( ruleProgramDirective ) ;
    public final void rule__Program__DirectivesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2917:1: ( ( ruleProgramDirective ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2918:1: ( ruleProgramDirective )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2918:1: ( ruleProgramDirective )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2919:1: ruleProgramDirective
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getDirectivesProgramDirectiveParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProgramDirective_in_rule__Program__DirectivesAssignment_1_15840);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2928:1: rule__FunctionDefinition__AttributesAssignment_0 : ( ruleAttribute ) ;
    public final void rule__FunctionDefinition__AttributesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2932:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2933:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2933:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2934:1: ruleAttribute
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getAttributesAttributeParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__FunctionDefinition__AttributesAssignment_05871);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2943:1: rule__FunctionDefinition__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__FunctionDefinition__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2947:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2948:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2948:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2949:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__FunctionDefinition__NameAssignment_35902); if (failed) return ;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2958:1: rule__FunctionDefinition__ParamsAssignment_5 : ( ruleParameters ) ;
    public final void rule__FunctionDefinition__ParamsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2962:1: ( ( ruleParameters ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2963:1: ( ruleParameters )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2963:1: ( ruleParameters )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2964:1: ruleParameters
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getParamsParametersParserRuleCall_5_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameters_in_rule__FunctionDefinition__ParamsAssignment_55933);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2973:1: rule__FunctionDefinition__BodyAssignment_7 : ( ruleBlock ) ;
    public final void rule__FunctionDefinition__BodyAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2977:1: ( ( ruleBlock ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2978:1: ( ruleBlock )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2978:1: ( ruleBlock )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2979:1: ruleBlock
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getFunctionDefinitionAccess().getBodyBlockParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_rule__FunctionDefinition__BodyAssignment_75964);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2988:1: rule__Attribute__IdentAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__IdentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2992:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2993:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2993:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:2994:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getIdentIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__IdentAssignment_05995); if (failed) return ;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3003:1: rule__Attribute__ExpressionAssignment_1_3 : ( rulePostfixExpression ) ;
    public final void rule__Attribute__ExpressionAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3007:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3008:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3008:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3009:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getExpressionPostfixExpressionParserRuleCall_1_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__Attribute__ExpressionAssignment_1_36026);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3018:1: rule__Parameters__ParamsAssignment_3_0 : ( RULE_ID ) ;
    public final void rule__Parameters__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3022:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3023:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3023:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3024:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_0_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_06057); if (failed) return ;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3033:1: rule__Parameters__ParamsAssignment_3_2_2 : ( RULE_ID ) ;
    public final void rule__Parameters__ParamsAssignment_3_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3037:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3038:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3038:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3039:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getParametersAccess().getParamsIDTerminalRuleCall_3_2_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_2_26088); if (failed) return ;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3048:1: rule__Block__DirectivesAssignment_2_1 : ( ruleStatement ) ;
    public final void rule__Block__DirectivesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3052:1: ( ( ruleStatement ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3053:1: ( ruleStatement )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3053:1: ( ruleStatement )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3054:1: ruleStatement
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getDirectivesStatementParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStatement_in_rule__Block__DirectivesAssignment_2_16119);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3063:1: rule__Statement__ExpressionAssignment_1_1 : ( rulePostfixExpression ) ;
    public final void rule__Statement__ExpressionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3067:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3068:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3068:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3069:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getExpressionPostfixExpressionParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__Statement__ExpressionAssignment_1_16150);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3078:1: rule__PostfixExpression__PropertyAssignment_1_0_2 : ( rulePropertyOperator ) ;
    public final void rule__PostfixExpression__PropertyAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3082:1: ( ( rulePropertyOperator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3083:1: ( rulePropertyOperator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3083:1: ( rulePropertyOperator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3084:1: rulePropertyOperator
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getPropertyPropertyOperatorParserRuleCall_1_0_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyOperator_in_rule__PostfixExpression__PropertyAssignment_1_0_26181);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3093:1: rule__PostfixExpression__ArgumentsAssignment_1_1_4_0 : ( ruleListExpression ) ;
    public final void rule__PostfixExpression__ArgumentsAssignment_1_1_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3097:1: ( ( ruleListExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3098:1: ( ruleListExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3098:1: ( ruleListExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3099:1: ruleListExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPostfixExpressionAccess().getArgumentsListExpressionParserRuleCall_1_1_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListExpression_in_rule__PostfixExpression__ArgumentsAssignment_1_1_4_06212);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3108:1: rule__ListExpression__ExpressionsAssignment_0 : ( rulePostfixExpression ) ;
    public final void rule__ListExpression__ExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3112:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3113:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3113:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3114:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_06243);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3123:1: rule__ListExpression__ExpressionsAssignment_1_3 : ( rulePostfixExpression ) ;
    public final void rule__ListExpression__ExpressionsAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3127:1: ( ( rulePostfixExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3128:1: ( rulePostfixExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3128:1: ( rulePostfixExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3129:1: rulePostfixExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getListExpressionAccess().getExpressionsPostfixExpressionParserRuleCall_1_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_1_36274);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3138:1: rule__PropertyOperator__NameAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__PropertyOperator__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3142:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3143:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3143:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3144:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getNameIDTerminalRuleCall_0_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__PropertyOperator__NameAssignment_0_26305); if (failed) return ;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3153:1: rule__PropertyOperator__ExpressionsAssignment_1_2 : ( ruleListExpression ) ;
    public final void rule__PropertyOperator__ExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3157:1: ( ( ruleListExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3158:1: ( ruleListExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3158:1: ( ruleListExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3159:1: ruleListExpression
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPropertyOperatorAccess().getExpressionsListExpressionParserRuleCall_1_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListExpression_in_rule__PropertyOperator__ExpressionsAssignment_1_26336);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3168:1: rule__PrimaryExpression__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__PrimaryExpression__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3172:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3173:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3173:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3174:1: RULE_ID
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__PrimaryExpression__NameAssignment_0_16367); if (failed) return ;
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3183:1: rule__PrimaryExpression__ParamsAssignment_1_3 : ( ruleParameters ) ;
    public final void rule__PrimaryExpression__ParamsAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3187:1: ( ( ruleParameters ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3188:1: ( ruleParameters )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3188:1: ( ruleParameters )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3189:1: ruleParameters
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getParamsParametersParserRuleCall_1_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameters_in_rule__PrimaryExpression__ParamsAssignment_1_36398);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3198:1: rule__PrimaryExpression__BodyAssignment_1_5 : ( ruleBlock ) ;
    public final void rule__PrimaryExpression__BodyAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3202:1: ( ( ruleBlock ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3203:1: ( ruleBlock )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3203:1: ( ruleBlock )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:3204:1: ruleBlock
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getPrimaryExpressionAccess().getBodyBlockParserRuleCall_1_5_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_rule__PrimaryExpression__BodyAssignment_1_56429);
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:375:1: ( ( ruleFunctionDefinition ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:375:1: ( ruleFunctionDefinition )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:375:1: ( ruleFunctionDefinition )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:376:1: ruleFunctionDefinition
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
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1862:2: ( rule__PostfixExpression__Alternatives_1 )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug303200TestLanguage.g:1862:2: rule__PostfixExpression__Alternatives_1
        {
        pushFollow(FollowSets000.FOLLOW_rule__PostfixExpression__Alternatives_1_in_synpred263739);
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
            return "460:1: rule__PostfixExpression__Alternatives_1 : ( ( ( rule__PostfixExpression__Group_1_0__0 ) ) | ( ( rule__PostfixExpression__Group_1_1__0 ) ) );";
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
            return "()* loopback of 578:1: ( rule__Program__Group_1__0 )*";
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
            return "()* loopback of 1581:1: ( rule__Block__Group_2__0 )*";
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
            return "()* loopback of 2269:1: ( rule__ListExpression__Group_1__0 )*";
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
        public static final BitSet FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01089 = new BitSet(new long[]{0x0000000000004332L});
        public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11150 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Program__Group__2_in_rule__Program__Group__11153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group_1__0_in_rule__Program__Group__1__Impl1180 = new BitSet(new long[]{0x0000000000004332L});
        public static final BitSet FOLLOW_rule__Program__Group__2__Impl_in_rule__Program__Group__21211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Program__Group__2__Impl1239 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Program__Group_1__0__Impl_in_rule__Program__Group_1__01276 = new BitSet(new long[]{0x0000000000004320L});
        public static final BitSet FOLLOW_rule__Program__Group_1__1_in_rule__Program__Group_1__01279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Program__Group_1__0__Impl1307 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Program__Group_1__1__Impl_in_rule__Program__Group_1__11338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__DirectivesAssignment_1_1_in_rule__Program__Group_1__1__Impl1365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__0__Impl_in_rule__FunctionDefinition__Group__01399 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__1_in_rule__FunctionDefinition__Group__01402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__AttributesAssignment_0_in_rule__FunctionDefinition__Group__0__Impl1429 = new BitSet(new long[]{0x0000000000000222L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__1__Impl_in_rule__FunctionDefinition__Group__11460 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__2_in_rule__FunctionDefinition__Group__11463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_rule__FunctionDefinition__Group__1__Impl1491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__2__Impl_in_rule__FunctionDefinition__Group__21522 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__3_in_rule__FunctionDefinition__Group__21525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__2__Impl1553 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__3__Impl_in_rule__FunctionDefinition__Group__31584 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__4_in_rule__FunctionDefinition__Group__31587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__NameAssignment_3_in_rule__FunctionDefinition__Group__3__Impl1614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__4__Impl_in_rule__FunctionDefinition__Group__41644 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__5_in_rule__FunctionDefinition__Group__41647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__4__Impl1675 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__5__Impl_in_rule__FunctionDefinition__Group__51706 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__6_in_rule__FunctionDefinition__Group__51709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__ParamsAssignment_5_in_rule__FunctionDefinition__Group__5__Impl1736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__6__Impl_in_rule__FunctionDefinition__Group__61766 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__7_in_rule__FunctionDefinition__Group__61769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__FunctionDefinition__Group__6__Impl1797 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__Group__7__Impl_in_rule__FunctionDefinition__Group__71828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FunctionDefinition__BodyAssignment_7_in_rule__FunctionDefinition__Group__7__Impl1855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__0__Impl_in_rule__Attribute__Group_1__01901 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__1_in_rule__Attribute__Group_1__01904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__1__Impl_in_rule__Attribute__Group_1__11962 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__2_in_rule__Attribute__Group_1__11965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_9_in_rule__Attribute__Group_1__1__Impl1993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__2__Impl_in_rule__Attribute__Group_1__22024 = new BitSet(new long[]{0x0000000000000120L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__3_in_rule__Attribute__Group_1__22027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Attribute__Group_1__2__Impl2055 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__3__Impl_in_rule__Attribute__Group_1__32086 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__4_in_rule__Attribute__Group_1__32089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__ExpressionAssignment_1_3_in_rule__Attribute__Group_1__3__Impl2116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__4__Impl_in_rule__Attribute__Group_1__42146 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__5_in_rule__Attribute__Group_1__42149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Attribute__Group_1__4__Impl2177 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Attribute__Group_1__5__Impl_in_rule__Attribute__Group_1__52208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_10_in_rule__Attribute__Group_1__5__Impl2236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group__0__Impl_in_rule__Parameters__Group__02279 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Parameters__Group__1_in_rule__Parameters__Group__02282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group__1__Impl_in_rule__Parameters__Group__12340 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_rule__Parameters__Group__2_in_rule__Parameters__Group__12343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Parameters__Group__1__Impl2371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group__2__Impl_in_rule__Parameters__Group__22402 = new BitSet(new long[]{0x0000000000001020L});
        public static final BitSet FOLLOW_rule__Parameters__Group__3_in_rule__Parameters__Group__22405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group__2__Impl2433 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Parameters__Group__3__Impl_in_rule__Parameters__Group__32464 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Parameters__Group__4_in_rule__Parameters__Group__32467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__0_in_rule__Parameters__Group__3__Impl2494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group__4__Impl_in_rule__Parameters__Group__42525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Parameters__Group__4__Impl2553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__0__Impl_in_rule__Parameters__Group_3__02594 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__1_in_rule__Parameters__Group_3__02597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__ParamsAssignment_3_0_in_rule__Parameters__Group_3__0__Impl2624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__1__Impl_in_rule__Parameters__Group_3__12654 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__2_in_rule__Parameters__Group_3__12657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group_3__1__Impl2685 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3__2__Impl_in_rule__Parameters__Group_3__22716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__0_in_rule__Parameters__Group_3__2__Impl2743 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__0__Impl_in_rule__Parameters__Group_3_2__02780 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__1_in_rule__Parameters__Group_3_2__02783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Parameters__Group_3_2__0__Impl2811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__1__Impl_in_rule__Parameters__Group_3_2__12842 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__2_in_rule__Parameters__Group_3_2__12845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__1__Impl2873 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__2__Impl_in_rule__Parameters__Group_3_2__22904 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__3_in_rule__Parameters__Group_3_2__22907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__ParamsAssignment_3_2_2_in_rule__Parameters__Group_3_2__2__Impl2934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameters__Group_3_2__3__Impl_in_rule__Parameters__Group_3_2__32964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Parameters__Group_3_2__3__Impl2992 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__03031 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Block__Group__1_in_rule__Block__Group__03034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__13092 = new BitSet(new long[]{0x000000000000C130L});
        public static final BitSet FOLLOW_rule__Block__Group__2_in_rule__Block__Group__13095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Block__Group__1__Impl3123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__23154 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__Block__Group__3_in_rule__Block__Group__23157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__Group_2__0_in_rule__Block__Group__2__Impl3184 = new BitSet(new long[]{0x0000000000004132L});
        public static final BitSet FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__33215 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Block__Group__4_in_rule__Block__Group__33218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Block__Group__3__Impl3246 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Block__Group__4__Impl_in_rule__Block__Group__43277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Block__Group__4__Impl3305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__Group_2__0__Impl_in_rule__Block__Group_2__03346 = new BitSet(new long[]{0x0000000000004120L});
        public static final BitSet FOLLOW_rule__Block__Group_2__1_in_rule__Block__Group_2__03349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__Block__Group_2__0__Impl3377 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__Block__Group_2__1__Impl_in_rule__Block__Group_2__13408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Block__DirectivesAssignment_2_1_in_rule__Block__Group_2__1__Impl3435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__0__Impl_in_rule__Statement__Group_1__03469 = new BitSet(new long[]{0x0000000000000120L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__1_in_rule__Statement__Group_1__03472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__1__Impl_in_rule__Statement__Group_1__13530 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__2_in_rule__Statement__Group_1__13533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__ExpressionAssignment_1_1_in_rule__Statement__Group_1__1__Impl3560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Group_1__2__Impl_in_rule__Statement__Group_1__23590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Statement__Alternatives_1_2_in_rule__Statement__Group_1__2__Impl3617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group__0__Impl_in_rule__PostfixExpression__Group__03653 = new BitSet(new long[]{0x0000000000010A12L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group__1_in_rule__PostfixExpression__Group__03656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__PostfixExpression__Group__0__Impl3683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group__1__Impl_in_rule__PostfixExpression__Group__13712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Alternatives_1_in_rule__PostfixExpression__Group__1__Impl3739 = new BitSet(new long[]{0x0000000000010A12L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__0__Impl_in_rule__PostfixExpression__Group_1_0__03774 = new BitSet(new long[]{0x0000000000010210L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__1_in_rule__PostfixExpression__Group_1_0__03777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__1__Impl_in_rule__PostfixExpression__Group_1_0__13835 = new BitSet(new long[]{0x0000000000010200L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__2_in_rule__PostfixExpression__Group_1_0__13838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_0__1__Impl3866 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_0__2__Impl_in_rule__PostfixExpression__Group_1_0__23897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__PropertyAssignment_1_0_2_in_rule__PostfixExpression__Group_1_0__2__Impl3924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__0__Impl_in_rule__PostfixExpression__Group_1_1__03960 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__1_in_rule__PostfixExpression__Group_1_1__03963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__1__Impl_in_rule__PostfixExpression__Group_1_1__14021 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__2_in_rule__PostfixExpression__Group_1_1__14024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__1__Impl4052 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__2__Impl_in_rule__PostfixExpression__Group_1_1__24083 = new BitSet(new long[]{0x0000000000001130L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__3_in_rule__PostfixExpression__Group_1_1__24086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__PostfixExpression__Group_1_1__2__Impl4114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__3__Impl_in_rule__PostfixExpression__Group_1_1__34145 = new BitSet(new long[]{0x0000000000001120L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__4_in_rule__PostfixExpression__Group_1_1__34148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1__3__Impl4176 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__4__Impl_in_rule__PostfixExpression__Group_1_1__44207 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__5_in_rule__PostfixExpression__Group_1_1__44210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1_4__0_in_rule__PostfixExpression__Group_1_1__4__Impl4237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1__5__Impl_in_rule__PostfixExpression__Group_1_1__54268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__PostfixExpression__Group_1_1__5__Impl4296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1_4__0__Impl_in_rule__PostfixExpression__Group_1_1_4__04339 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1_4__1_in_rule__PostfixExpression__Group_1_1_4__04342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__ArgumentsAssignment_1_1_4_0_in_rule__PostfixExpression__Group_1_1_4__0__Impl4369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Group_1_1_4__1__Impl_in_rule__PostfixExpression__Group_1_1_4__14399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PostfixExpression__Group_1_1_4__1__Impl4427 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ListExpression__Group__0__Impl_in_rule__ListExpression__Group__04462 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_rule__ListExpression__Group__1_in_rule__ListExpression__Group__04465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__ExpressionsAssignment_0_in_rule__ListExpression__Group__0__Impl4492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__Group__1__Impl_in_rule__ListExpression__Group__14522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__0_in_rule__ListExpression__Group__1__Impl4549 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__0__Impl_in_rule__ListExpression__Group_1__04584 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__1_in_rule__ListExpression__Group_1__04587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__0__Impl4615 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__1__Impl_in_rule__ListExpression__Group_1__14646 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__2_in_rule__ListExpression__Group_1__14649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ListExpression__Group_1__1__Impl4677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__2__Impl_in_rule__ListExpression__Group_1__24708 = new BitSet(new long[]{0x0000000000000120L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__3_in_rule__ListExpression__Group_1__24711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__ListExpression__Group_1__2__Impl4739 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ListExpression__Group_1__3__Impl_in_rule__ListExpression__Group_1__34770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ListExpression__ExpressionsAssignment_1_3_in_rule__ListExpression__Group_1__3__Impl4797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__0__Impl_in_rule__PropertyOperator__Group_0__04835 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__1_in_rule__PropertyOperator__Group_0__04838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__PropertyOperator__Group_0__0__Impl4866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__1__Impl_in_rule__PropertyOperator__Group_0__14897 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__2_in_rule__PropertyOperator__Group_0__14900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_0__1__Impl4928 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_0__2__Impl_in_rule__PropertyOperator__Group_0__24959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__NameAssignment_0_2_in_rule__PropertyOperator__Group_0__2__Impl4986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__0__Impl_in_rule__PropertyOperator__Group_1__05022 = new BitSet(new long[]{0x0000000000000130L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__1_in_rule__PropertyOperator__Group_1__05025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_9_in_rule__PropertyOperator__Group_1__0__Impl5053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__1__Impl_in_rule__PropertyOperator__Group_1__15084 = new BitSet(new long[]{0x0000000000000120L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__2_in_rule__PropertyOperator__Group_1__15087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__1__Impl5115 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__2__Impl_in_rule__PropertyOperator__Group_1__25146 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__3_in_rule__PropertyOperator__Group_1__25149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__ExpressionsAssignment_1_2_in_rule__PropertyOperator__Group_1__2__Impl5176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__3__Impl_in_rule__PropertyOperator__Group_1__35206 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__4_in_rule__PropertyOperator__Group_1__35209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PropertyOperator__Group_1__3__Impl5237 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PropertyOperator__Group_1__4__Impl_in_rule__PropertyOperator__Group_1__45268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_10_in_rule__PropertyOperator__Group_1__4__Impl5296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__05337 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__05340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__15398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__NameAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl5425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__05459 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__05462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__15520 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__15523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_rule__PrimaryExpression__Group_1__1__Impl5551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__25582 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__3_in_rule__PrimaryExpression__Group_1__25585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__2__Impl5613 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__3__Impl_in_rule__PrimaryExpression__Group_1__35644 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__4_in_rule__PrimaryExpression__Group_1__35647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__ParamsAssignment_1_3_in_rule__PrimaryExpression__Group_1__3__Impl5674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__4__Impl_in_rule__PrimaryExpression__Group_1__45704 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__5_in_rule__PrimaryExpression__Group_1__45707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_LT_in_rule__PrimaryExpression__Group_1__4__Impl5735 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__5__Impl_in_rule__PrimaryExpression__Group_1__55766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PrimaryExpression__BodyAssignment_1_5_in_rule__PrimaryExpression__Group_1__5__Impl5793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgramDirective_in_rule__Program__DirectivesAssignment_1_15840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__FunctionDefinition__AttributesAssignment_05871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__FunctionDefinition__NameAssignment_35902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameters_in_rule__FunctionDefinition__ParamsAssignment_55933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_rule__FunctionDefinition__BodyAssignment_75964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__IdentAssignment_05995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__Attribute__ExpressionAssignment_1_36026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_06057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameters__ParamsAssignment_3_2_26088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_rule__Block__DirectivesAssignment_2_16119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__Statement__ExpressionAssignment_1_16150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyOperator_in_rule__PostfixExpression__PropertyAssignment_1_0_26181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListExpression_in_rule__PostfixExpression__ArgumentsAssignment_1_1_4_06212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_06243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePostfixExpression_in_rule__ListExpression__ExpressionsAssignment_1_36274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyOperator__NameAssignment_0_26305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListExpression_in_rule__PropertyOperator__ExpressionsAssignment_1_26336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__NameAssignment_0_16367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameters_in_rule__PrimaryExpression__ParamsAssignment_1_36398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_rule__PrimaryExpression__BodyAssignment_1_56429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionDefinition_in_synpred1736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__PostfixExpression__Alternatives_1_in_synpred263739 = new BitSet(new long[]{0x0000000000000002L});
    }


}