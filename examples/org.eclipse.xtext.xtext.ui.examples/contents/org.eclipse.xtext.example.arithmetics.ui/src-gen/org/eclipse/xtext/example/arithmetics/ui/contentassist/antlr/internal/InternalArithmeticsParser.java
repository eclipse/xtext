package org.eclipse.xtext.example.arithmetics.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalArithmeticsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NUMBER", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'import'", "'.'", "'*'", "'def'", "':'", "';'", "'('", "')'", "','", "'+'", "'-'", "'/'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_NUMBER=5;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalArithmeticsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g"; }


     
     	private ArithmeticsGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ArithmeticsGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleModule
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:60:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:61:1: ( ruleModule EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:62:1: ruleModule EOF
            {
             before(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule61);
            ruleModule();
            _fsp--;

             after(grammarAccess.getModuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule68); 

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
    // $ANTLR end entryRuleModule


    // $ANTLR start ruleModule
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:69:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:73:2: ( ( ( rule__Module__Group__0 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:74:1: ( ( rule__Module__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:74:1: ( ( rule__Module__Group__0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:75:1: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:76:1: ( rule__Module__Group__0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:76:2: rule__Module__Group__0
            {
            pushFollow(FOLLOW_rule__Module__Group__0_in_ruleModule94);
            rule__Module__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModule


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:88:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:89:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:90:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport121);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport128); 

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
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:97:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:101:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:102:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:102:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:103:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:104:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:104:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport154);
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


    // $ANTLR start entryRuleImportName
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:116:1: entryRuleImportName : ruleImportName EOF ;
    public final void entryRuleImportName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:117:1: ( ruleImportName EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:118:1: ruleImportName EOF
            {
             before(grammarAccess.getImportNameRule()); 
            pushFollow(FOLLOW_ruleImportName_in_entryRuleImportName181);
            ruleImportName();
            _fsp--;

             after(grammarAccess.getImportNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportName188); 

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
    // $ANTLR end entryRuleImportName


    // $ANTLR start ruleImportName
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:125:1: ruleImportName : ( ( rule__ImportName__Group__0 ) ) ;
    public final void ruleImportName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:129:2: ( ( ( rule__ImportName__Group__0 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:130:1: ( ( rule__ImportName__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:130:1: ( ( rule__ImportName__Group__0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:131:1: ( rule__ImportName__Group__0 )
            {
             before(grammarAccess.getImportNameAccess().getGroup()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:132:1: ( rule__ImportName__Group__0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:132:2: rule__ImportName__Group__0
            {
            pushFollow(FOLLOW_rule__ImportName__Group__0_in_ruleImportName214);
            rule__ImportName__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleImportName


    // $ANTLR start entryRuleStatement
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:144:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:145:1: ( ruleStatement EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:146:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement241);
            ruleStatement();
            _fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement248); 

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
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:153:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:157:2: ( ( ( rule__Statement__Alternatives ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:158:1: ( ( rule__Statement__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:158:1: ( ( rule__Statement__Alternatives ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:159:1: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:160:1: ( rule__Statement__Alternatives )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:160:2: rule__Statement__Alternatives
            {
            pushFollow(FOLLOW_rule__Statement__Alternatives_in_ruleStatement274);
            rule__Statement__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getStatementAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start entryRuleDefinition
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:172:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:173:1: ( ruleDefinition EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:174:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition301);
            ruleDefinition();
            _fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition308); 

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
    // $ANTLR end entryRuleDefinition


    // $ANTLR start ruleDefinition
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:181:1: ruleDefinition : ( ( rule__Definition__Group__0 ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:185:2: ( ( ( rule__Definition__Group__0 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:186:1: ( ( rule__Definition__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:186:1: ( ( rule__Definition__Group__0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:187:1: ( rule__Definition__Group__0 )
            {
             before(grammarAccess.getDefinitionAccess().getGroup()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:188:1: ( rule__Definition__Group__0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:188:2: rule__Definition__Group__0
            {
            pushFollow(FOLLOW_rule__Definition__Group__0_in_ruleDefinition334);
            rule__Definition__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleDefinition


    // $ANTLR start entryRuleDeclaredParameter
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:200:1: entryRuleDeclaredParameter : ruleDeclaredParameter EOF ;
    public final void entryRuleDeclaredParameter() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:201:1: ( ruleDeclaredParameter EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:202:1: ruleDeclaredParameter EOF
            {
             before(grammarAccess.getDeclaredParameterRule()); 
            pushFollow(FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter361);
            ruleDeclaredParameter();
            _fsp--;

             after(grammarAccess.getDeclaredParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaredParameter368); 

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
    // $ANTLR end entryRuleDeclaredParameter


    // $ANTLR start ruleDeclaredParameter
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:209:1: ruleDeclaredParameter : ( ( rule__DeclaredParameter__NameAssignment ) ) ;
    public final void ruleDeclaredParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:213:2: ( ( ( rule__DeclaredParameter__NameAssignment ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:214:1: ( ( rule__DeclaredParameter__NameAssignment ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:214:1: ( ( rule__DeclaredParameter__NameAssignment ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:215:1: ( rule__DeclaredParameter__NameAssignment )
            {
             before(grammarAccess.getDeclaredParameterAccess().getNameAssignment()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:216:1: ( rule__DeclaredParameter__NameAssignment )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:216:2: rule__DeclaredParameter__NameAssignment
            {
            pushFollow(FOLLOW_rule__DeclaredParameter__NameAssignment_in_ruleDeclaredParameter394);
            rule__DeclaredParameter__NameAssignment();
            _fsp--;


            }

             after(grammarAccess.getDeclaredParameterAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleDeclaredParameter


    // $ANTLR start entryRuleEvaluation
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:230:1: entryRuleEvaluation : ruleEvaluation EOF ;
    public final void entryRuleEvaluation() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:231:1: ( ruleEvaluation EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:232:1: ruleEvaluation EOF
            {
             before(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_ruleEvaluation_in_entryRuleEvaluation423);
            ruleEvaluation();
            _fsp--;

             after(grammarAccess.getEvaluationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvaluation430); 

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
    // $ANTLR end entryRuleEvaluation


    // $ANTLR start ruleEvaluation
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:239:1: ruleEvaluation : ( ( rule__Evaluation__Group__0 ) ) ;
    public final void ruleEvaluation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:243:2: ( ( ( rule__Evaluation__Group__0 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:244:1: ( ( rule__Evaluation__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:244:1: ( ( rule__Evaluation__Group__0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:245:1: ( rule__Evaluation__Group__0 )
            {
             before(grammarAccess.getEvaluationAccess().getGroup()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:246:1: ( rule__Evaluation__Group__0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:246:2: rule__Evaluation__Group__0
            {
            pushFollow(FOLLOW_rule__Evaluation__Group__0_in_ruleEvaluation456);
            rule__Evaluation__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEvaluationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEvaluation


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:258:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:259:1: ( ruleExpression EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:260:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression483);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression490); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:267:1: ruleExpression : ( ruleAddition ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:271:2: ( ( ruleAddition ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:272:1: ( ruleAddition )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:272:1: ( ruleAddition )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:273:1: ruleAddition
            {
             before(grammarAccess.getExpressionAccess().getAdditionParserRuleCall()); 
            pushFollow(FOLLOW_ruleAddition_in_ruleExpression516);
            ruleAddition();
            _fsp--;

             after(grammarAccess.getExpressionAccess().getAdditionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleAddition
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:286:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:287:1: ( ruleAddition EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:288:1: ruleAddition EOF
            {
             before(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition542);
            ruleAddition();
            _fsp--;

             after(grammarAccess.getAdditionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition549); 

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
    // $ANTLR end entryRuleAddition


    // $ANTLR start ruleAddition
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:295:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:299:2: ( ( ( rule__Addition__Group__0 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:300:1: ( ( rule__Addition__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:300:1: ( ( rule__Addition__Group__0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:301:1: ( rule__Addition__Group__0 )
            {
             before(grammarAccess.getAdditionAccess().getGroup()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:302:1: ( rule__Addition__Group__0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:302:2: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_rule__Addition__Group__0_in_ruleAddition575);
            rule__Addition__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAdditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAddition


    // $ANTLR start entryRuleMultiplication
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:314:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:315:1: ( ruleMultiplication EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:316:1: ruleMultiplication EOF
            {
             before(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication602);
            ruleMultiplication();
            _fsp--;

             after(grammarAccess.getMultiplicationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication609); 

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
    // $ANTLR end entryRuleMultiplication


    // $ANTLR start ruleMultiplication
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:323:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:327:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:328:1: ( ( rule__Multiplication__Group__0 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:328:1: ( ( rule__Multiplication__Group__0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:329:1: ( rule__Multiplication__Group__0 )
            {
             before(grammarAccess.getMultiplicationAccess().getGroup()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:330:1: ( rule__Multiplication__Group__0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:330:2: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication635);
            rule__Multiplication__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleMultiplication


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:342:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:343:1: ( rulePrimaryExpression EOF )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:344:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression662);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression669); 

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
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:351:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:355:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:356:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:356:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:357:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:358:1: ( rule__PrimaryExpression__Alternatives )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:358:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression695);
            rule__PrimaryExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start rule__Statement__Alternatives
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:370:1: rule__Statement__Alternatives : ( ( ruleDefinition ) | ( ruleEvaluation ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:374:1: ( ( ruleDefinition ) | ( ruleEvaluation ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==16) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_NUMBER)||LA1_0==19) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("370:1: rule__Statement__Alternatives : ( ( ruleDefinition ) | ( ruleEvaluation ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:375:1: ( ruleDefinition )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:375:1: ( ruleDefinition )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:376:1: ruleDefinition
                    {
                     before(grammarAccess.getStatementAccess().getDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDefinition_in_rule__Statement__Alternatives731);
                    ruleDefinition();
                    _fsp--;

                     after(grammarAccess.getStatementAccess().getDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:381:6: ( ruleEvaluation )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:381:6: ( ruleEvaluation )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:382:1: ruleEvaluation
                    {
                     before(grammarAccess.getStatementAccess().getEvaluationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEvaluation_in_rule__Statement__Alternatives748);
                    ruleEvaluation();
                    _fsp--;

                     after(grammarAccess.getStatementAccess().getEvaluationParserRuleCall_1()); 

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


    // $ANTLR start rule__Addition__Alternatives_1_0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:393:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:397:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==22) ) {
                alt2=1;
            }
            else if ( (LA2_0==23) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("393:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:398:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:398:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:399:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:400:1: ( rule__Addition__Group_1_0_0__0 )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:400:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0781);
                    rule__Addition__Group_1_0_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:404:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:404:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:405:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:406:1: ( rule__Addition__Group_1_0_1__0 )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:406:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0799);
                    rule__Addition__Group_1_0_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 

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
    // $ANTLR end rule__Addition__Alternatives_1_0


    // $ANTLR start rule__Multiplication__Alternatives_1_0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:415:1: rule__Multiplication__Alternatives_1_0 : ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) );
    public final void rule__Multiplication__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:419:1: ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==24) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("415:1: rule__Multiplication__Alternatives_1_0 : ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:420:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:420:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:421:1: ( rule__Multiplication__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:422:1: ( rule__Multiplication__Group_1_0_0__0 )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:422:2: rule__Multiplication__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_0832);
                    rule__Multiplication__Group_1_0_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:426:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:426:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:427:1: ( rule__Multiplication__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:428:1: ( rule__Multiplication__Group_1_0_1__0 )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:428:2: rule__Multiplication__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_0850);
                    rule__Multiplication__Group_1_0_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 

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
    // $ANTLR end rule__Multiplication__Alternatives_1_0


    // $ANTLR start rule__PrimaryExpression__Alternatives
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:437:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ( rule__PrimaryExpression__Group_2__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:441:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ( rule__PrimaryExpression__Group_2__0 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case RULE_NUMBER:
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
                    new NoViableAltException("437:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ( rule__PrimaryExpression__Group_2__0 ) ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:442:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:442:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:443:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:444:1: ( rule__PrimaryExpression__Group_0__0 )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:444:2: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives883);
                    rule__PrimaryExpression__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:448:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:448:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:449:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:450:1: ( rule__PrimaryExpression__Group_1__0 )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:450:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives901);
                    rule__PrimaryExpression__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:454:6: ( ( rule__PrimaryExpression__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:454:6: ( ( rule__PrimaryExpression__Group_2__0 ) )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:455:1: ( rule__PrimaryExpression__Group_2__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:456:1: ( rule__PrimaryExpression__Group_2__0 )
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:456:2: rule__PrimaryExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_2__0_in_rule__PrimaryExpression__Alternatives919);
                    rule__PrimaryExpression__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_2()); 

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


    // $ANTLR start rule__Module__Group__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:467:1: rule__Module__Group__0 : ( 'module' ) rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:471:1: ( ( 'module' ) rule__Module__Group__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:472:1: ( 'module' ) rule__Module__Group__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:472:1: ( 'module' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:473:1: 'module'
            {
             before(grammarAccess.getModuleAccess().getModuleKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__Module__Group__0955); 
             after(grammarAccess.getModuleAccess().getModuleKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__0965);
            rule__Module__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Module__Group__0


    // $ANTLR start rule__Module__Group__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:487:1: rule__Module__Group__1 : ( ( rule__Module__NameAssignment_1 ) ) rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:491:1: ( ( ( rule__Module__NameAssignment_1 ) ) rule__Module__Group__2 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:492:1: ( ( rule__Module__NameAssignment_1 ) ) rule__Module__Group__2
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:492:1: ( ( rule__Module__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:493:1: ( rule__Module__NameAssignment_1 )
            {
             before(grammarAccess.getModuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:494:1: ( rule__Module__NameAssignment_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:494:2: rule__Module__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Module__NameAssignment_1_in_rule__Module__Group__1993);
            rule__Module__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getModuleAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Module__Group__2_in_rule__Module__Group__11002);
            rule__Module__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Module__Group__1


    // $ANTLR start rule__Module__Group__2
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:505:1: rule__Module__Group__2 : ( ( rule__Module__ImportsAssignment_2 )* ) rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:509:1: ( ( ( rule__Module__ImportsAssignment_2 )* ) rule__Module__Group__3 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:510:1: ( ( rule__Module__ImportsAssignment_2 )* ) rule__Module__Group__3
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:510:1: ( ( rule__Module__ImportsAssignment_2 )* )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:511:1: ( rule__Module__ImportsAssignment_2 )*
            {
             before(grammarAccess.getModuleAccess().getImportsAssignment_2()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:512:1: ( rule__Module__ImportsAssignment_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:512:2: rule__Module__ImportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Module__ImportsAssignment_2_in_rule__Module__Group__21030);
            	    rule__Module__ImportsAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getImportsAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__Module__Group__3_in_rule__Module__Group__21040);
            rule__Module__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Module__Group__2


    // $ANTLR start rule__Module__Group__3
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:523:1: rule__Module__Group__3 : ( ( rule__Module__StatementsAssignment_3 )* ) ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:527:1: ( ( ( rule__Module__StatementsAssignment_3 )* ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:528:1: ( ( rule__Module__StatementsAssignment_3 )* )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:528:1: ( ( rule__Module__StatementsAssignment_3 )* )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:529:1: ( rule__Module__StatementsAssignment_3 )*
            {
             before(grammarAccess.getModuleAccess().getStatementsAssignment_3()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:530:1: ( rule__Module__StatementsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_NUMBER)||LA6_0==16||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:530:2: rule__Module__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Module__StatementsAssignment_3_in_rule__Module__Group__31068);
            	    rule__Module__StatementsAssignment_3();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getStatementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Module__Group__3


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:548:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:552:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:553:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:553:1: ( 'import' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:554:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Import__Group__01112); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01122);
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
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:568:1: rule__Import__Group__1 : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:572:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:573:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:573:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:574:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:575:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:575:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__11150);
            rule__Import__ImportedNamespaceAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start rule__ImportName__Group__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:589:1: rule__ImportName__Group__0 : ( RULE_ID ) rule__ImportName__Group__1 ;
    public final void rule__ImportName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:593:1: ( ( RULE_ID ) rule__ImportName__Group__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:594:1: ( RULE_ID ) rule__ImportName__Group__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:594:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:595:1: RULE_ID
            {
             before(grammarAccess.getImportNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ImportName__Group__01188); 
             after(grammarAccess.getImportNameAccess().getIDTerminalRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__ImportName__Group__1_in_rule__ImportName__Group__01196);
            rule__ImportName__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ImportName__Group__0


    // $ANTLR start rule__ImportName__Group__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:607:1: rule__ImportName__Group__1 : ( ( rule__ImportName__Group_1__0 )? ) ;
    public final void rule__ImportName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:611:1: ( ( ( rule__ImportName__Group_1__0 )? ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:612:1: ( ( rule__ImportName__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:612:1: ( ( rule__ImportName__Group_1__0 )? )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:613:1: ( rule__ImportName__Group_1__0 )?
            {
             before(grammarAccess.getImportNameAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:614:1: ( rule__ImportName__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:614:2: rule__ImportName__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ImportName__Group_1__0_in_rule__ImportName__Group__11224);
                    rule__ImportName__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImportNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ImportName__Group__1


    // $ANTLR start rule__ImportName__Group_1__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:628:1: rule__ImportName__Group_1__0 : ( '.' ) rule__ImportName__Group_1__1 ;
    public final void rule__ImportName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:632:1: ( ( '.' ) rule__ImportName__Group_1__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:633:1: ( '.' ) rule__ImportName__Group_1__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:633:1: ( '.' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:634:1: '.'
            {
             before(grammarAccess.getImportNameAccess().getFullStopKeyword_1_0()); 
            match(input,14,FOLLOW_14_in_rule__ImportName__Group_1__01264); 
             after(grammarAccess.getImportNameAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__ImportName__Group_1__1_in_rule__ImportName__Group_1__01274);
            rule__ImportName__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ImportName__Group_1__0


    // $ANTLR start rule__ImportName__Group_1__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:648:1: rule__ImportName__Group_1__1 : ( '*' ) ;
    public final void rule__ImportName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:652:1: ( ( '*' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:653:1: ( '*' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:653:1: ( '*' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:654:1: '*'
            {
             before(grammarAccess.getImportNameAccess().getAsteriskKeyword_1_1()); 
            match(input,15,FOLLOW_15_in_rule__ImportName__Group_1__11303); 
             after(grammarAccess.getImportNameAccess().getAsteriskKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ImportName__Group_1__1


    // $ANTLR start rule__Definition__Group__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:671:1: rule__Definition__Group__0 : ( 'def' ) rule__Definition__Group__1 ;
    public final void rule__Definition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:675:1: ( ( 'def' ) rule__Definition__Group__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:676:1: ( 'def' ) rule__Definition__Group__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:676:1: ( 'def' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:677:1: 'def'
            {
             before(grammarAccess.getDefinitionAccess().getDefKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Definition__Group__01343); 
             after(grammarAccess.getDefinitionAccess().getDefKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group__1_in_rule__Definition__Group__01353);
            rule__Definition__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group__0


    // $ANTLR start rule__Definition__Group__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:691:1: rule__Definition__Group__1 : ( ( rule__Definition__NameAssignment_1 ) ) rule__Definition__Group__2 ;
    public final void rule__Definition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:695:1: ( ( ( rule__Definition__NameAssignment_1 ) ) rule__Definition__Group__2 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:696:1: ( ( rule__Definition__NameAssignment_1 ) ) rule__Definition__Group__2
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:696:1: ( ( rule__Definition__NameAssignment_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:697:1: ( rule__Definition__NameAssignment_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:698:1: ( rule__Definition__NameAssignment_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:698:2: rule__Definition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_in_rule__Definition__Group__11381);
            rule__Definition__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group__2_in_rule__Definition__Group__11390);
            rule__Definition__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group__1


    // $ANTLR start rule__Definition__Group__2
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:709:1: rule__Definition__Group__2 : ( ( rule__Definition__Group_2__0 )? ) rule__Definition__Group__3 ;
    public final void rule__Definition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:713:1: ( ( ( rule__Definition__Group_2__0 )? ) rule__Definition__Group__3 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:714:1: ( ( rule__Definition__Group_2__0 )? ) rule__Definition__Group__3
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:714:1: ( ( rule__Definition__Group_2__0 )? )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:715:1: ( rule__Definition__Group_2__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_2()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:716:1: ( rule__Definition__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:716:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Group__21418);
                    rule__Definition__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDefinitionAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group__3_in_rule__Definition__Group__21428);
            rule__Definition__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group__2


    // $ANTLR start rule__Definition__Group__3
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:727:1: rule__Definition__Group__3 : ( ':' ) rule__Definition__Group__4 ;
    public final void rule__Definition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:731:1: ( ( ':' ) rule__Definition__Group__4 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:732:1: ( ':' ) rule__Definition__Group__4
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:732:1: ( ':' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:733:1: ':'
            {
             before(grammarAccess.getDefinitionAccess().getColonKeyword_3()); 
            match(input,17,FOLLOW_17_in_rule__Definition__Group__31457); 
             after(grammarAccess.getDefinitionAccess().getColonKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group__4_in_rule__Definition__Group__31467);
            rule__Definition__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group__3


    // $ANTLR start rule__Definition__Group__4
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:747:1: rule__Definition__Group__4 : ( ( rule__Definition__ExprAssignment_4 ) ) rule__Definition__Group__5 ;
    public final void rule__Definition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:751:1: ( ( ( rule__Definition__ExprAssignment_4 ) ) rule__Definition__Group__5 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:752:1: ( ( rule__Definition__ExprAssignment_4 ) ) rule__Definition__Group__5
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:752:1: ( ( rule__Definition__ExprAssignment_4 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:753:1: ( rule__Definition__ExprAssignment_4 )
            {
             before(grammarAccess.getDefinitionAccess().getExprAssignment_4()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:754:1: ( rule__Definition__ExprAssignment_4 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:754:2: rule__Definition__ExprAssignment_4
            {
            pushFollow(FOLLOW_rule__Definition__ExprAssignment_4_in_rule__Definition__Group__41495);
            rule__Definition__ExprAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getExprAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group__5_in_rule__Definition__Group__41504);
            rule__Definition__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group__4


    // $ANTLR start rule__Definition__Group__5
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:765:1: rule__Definition__Group__5 : ( ';' ) ;
    public final void rule__Definition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:769:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:770:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:770:1: ( ';' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:771:1: ';'
            {
             before(grammarAccess.getDefinitionAccess().getSemicolonKeyword_5()); 
            match(input,18,FOLLOW_18_in_rule__Definition__Group__51533); 
             after(grammarAccess.getDefinitionAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group__5


    // $ANTLR start rule__Definition__Group_2__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:796:1: rule__Definition__Group_2__0 : ( '(' ) rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:800:1: ( ( '(' ) rule__Definition__Group_2__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:801:1: ( '(' ) rule__Definition__Group_2__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:801:1: ( '(' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:802:1: '('
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,19,FOLLOW_19_in_rule__Definition__Group_2__01581); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__01591);
            rule__Definition__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group_2__0


    // $ANTLR start rule__Definition__Group_2__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:816:1: rule__Definition__Group_2__1 : ( ( rule__Definition__ArgsAssignment_2_1 ) ) rule__Definition__Group_2__2 ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:820:1: ( ( ( rule__Definition__ArgsAssignment_2_1 ) ) rule__Definition__Group_2__2 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:821:1: ( ( rule__Definition__ArgsAssignment_2_1 ) ) rule__Definition__Group_2__2
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:821:1: ( ( rule__Definition__ArgsAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:822:1: ( rule__Definition__ArgsAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getArgsAssignment_2_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:823:1: ( rule__Definition__ArgsAssignment_2_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:823:2: rule__Definition__ArgsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__ArgsAssignment_2_1_in_rule__Definition__Group_2__11619);
            rule__Definition__ArgsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getArgsAssignment_2_1()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group_2__2_in_rule__Definition__Group_2__11628);
            rule__Definition__Group_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group_2__1


    // $ANTLR start rule__Definition__Group_2__2
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:834:1: rule__Definition__Group_2__2 : ( ( rule__Definition__Group_2_2__0 )* ) rule__Definition__Group_2__3 ;
    public final void rule__Definition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:838:1: ( ( ( rule__Definition__Group_2_2__0 )* ) rule__Definition__Group_2__3 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:839:1: ( ( rule__Definition__Group_2_2__0 )* ) rule__Definition__Group_2__3
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:839:1: ( ( rule__Definition__Group_2_2__0 )* )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:840:1: ( rule__Definition__Group_2_2__0 )*
            {
             before(grammarAccess.getDefinitionAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:841:1: ( rule__Definition__Group_2_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:841:2: rule__Definition__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Definition__Group_2_2__0_in_rule__Definition__Group_2__21656);
            	    rule__Definition__Group_2_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getDefinitionAccess().getGroup_2_2()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group_2__3_in_rule__Definition__Group_2__21666);
            rule__Definition__Group_2__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group_2__2


    // $ANTLR start rule__Definition__Group_2__3
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:852:1: rule__Definition__Group_2__3 : ( ')' ) ;
    public final void rule__Definition__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:856:1: ( ( ')' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:857:1: ( ')' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:857:1: ( ')' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:858:1: ')'
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_2_3()); 
            match(input,20,FOLLOW_20_in_rule__Definition__Group_2__31695); 
             after(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group_2__3


    // $ANTLR start rule__Definition__Group_2_2__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:879:1: rule__Definition__Group_2_2__0 : ( ',' ) rule__Definition__Group_2_2__1 ;
    public final void rule__Definition__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:883:1: ( ( ',' ) rule__Definition__Group_2_2__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:884:1: ( ',' ) rule__Definition__Group_2_2__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:884:1: ( ',' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:885:1: ','
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_2_2_0()); 
            match(input,21,FOLLOW_21_in_rule__Definition__Group_2_2__01739); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_2_2_0()); 

            }

            pushFollow(FOLLOW_rule__Definition__Group_2_2__1_in_rule__Definition__Group_2_2__01749);
            rule__Definition__Group_2_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group_2_2__0


    // $ANTLR start rule__Definition__Group_2_2__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:899:1: rule__Definition__Group_2_2__1 : ( ( rule__Definition__ArgsAssignment_2_2_1 ) ) ;
    public final void rule__Definition__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:903:1: ( ( ( rule__Definition__ArgsAssignment_2_2_1 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:904:1: ( ( rule__Definition__ArgsAssignment_2_2_1 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:904:1: ( ( rule__Definition__ArgsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:905:1: ( rule__Definition__ArgsAssignment_2_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getArgsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:906:1: ( rule__Definition__ArgsAssignment_2_2_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:906:2: rule__Definition__ArgsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__Definition__ArgsAssignment_2_2_1_in_rule__Definition__Group_2_2__11777);
            rule__Definition__ArgsAssignment_2_2_1();
            _fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getArgsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__Group_2_2__1


    // $ANTLR start rule__Evaluation__Group__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:920:1: rule__Evaluation__Group__0 : ( ( rule__Evaluation__ExpressionAssignment_0 ) ) rule__Evaluation__Group__1 ;
    public final void rule__Evaluation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:924:1: ( ( ( rule__Evaluation__ExpressionAssignment_0 ) ) rule__Evaluation__Group__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:925:1: ( ( rule__Evaluation__ExpressionAssignment_0 ) ) rule__Evaluation__Group__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:925:1: ( ( rule__Evaluation__ExpressionAssignment_0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:926:1: ( rule__Evaluation__ExpressionAssignment_0 )
            {
             before(grammarAccess.getEvaluationAccess().getExpressionAssignment_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:927:1: ( rule__Evaluation__ExpressionAssignment_0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:927:2: rule__Evaluation__ExpressionAssignment_0
            {
            pushFollow(FOLLOW_rule__Evaluation__ExpressionAssignment_0_in_rule__Evaluation__Group__01815);
            rule__Evaluation__ExpressionAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getEvaluationAccess().getExpressionAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Evaluation__Group__1_in_rule__Evaluation__Group__01824);
            rule__Evaluation__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Evaluation__Group__0


    // $ANTLR start rule__Evaluation__Group__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:938:1: rule__Evaluation__Group__1 : ( ';' ) ;
    public final void rule__Evaluation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:942:1: ( ( ';' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:943:1: ( ';' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:943:1: ( ';' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:944:1: ';'
            {
             before(grammarAccess.getEvaluationAccess().getSemicolonKeyword_1()); 
            match(input,18,FOLLOW_18_in_rule__Evaluation__Group__11853); 
             after(grammarAccess.getEvaluationAccess().getSemicolonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Evaluation__Group__1


    // $ANTLR start rule__Addition__Group__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:961:1: rule__Addition__Group__0 : ( ruleMultiplication ) rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:965:1: ( ( ruleMultiplication ) rule__Addition__Group__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:966:1: ( ruleMultiplication ) rule__Addition__Group__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:966:1: ( ruleMultiplication )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:967:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__Group__01892);
            ruleMultiplication();
            _fsp--;

             after(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__01900);
            rule__Addition__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group__0


    // $ANTLR start rule__Addition__Group__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:979:1: rule__Addition__Group__1 : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:983:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:984:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:984:1: ( ( rule__Addition__Group_1__0 )* )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:985:1: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:986:1: ( rule__Addition__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=22 && LA10_0<=23)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:986:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__11928);
            	    rule__Addition__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getAdditionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group__1


    // $ANTLR start rule__Addition__Group_1__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1000:1: rule__Addition__Group_1__0 : ( ( rule__Addition__Alternatives_1_0 ) ) rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1004:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) rule__Addition__Group_1__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1005:1: ( ( rule__Addition__Alternatives_1_0 ) ) rule__Addition__Group_1__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1005:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1006:1: ( rule__Addition__Alternatives_1_0 )
            {
             before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1007:1: ( rule__Addition__Alternatives_1_0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1007:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__01967);
            rule__Addition__Alternatives_1_0();
            _fsp--;


            }

             after(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 

            }

            pushFollow(FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__01976);
            rule__Addition__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group_1__0


    // $ANTLR start rule__Addition__Group_1__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1018:1: rule__Addition__Group_1__1 : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1022:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1023:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1023:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1024:1: ( rule__Addition__RightAssignment_1_1 )
            {
             before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1025:1: ( rule__Addition__RightAssignment_1_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1025:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__12004);
            rule__Addition__RightAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group_1__1


    // $ANTLR start rule__Addition__Group_1_0_0__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1039:1: rule__Addition__Group_1_0_0__0 : ( () ) rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1043:1: ( ( () ) rule__Addition__Group_1_0_0__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1044:1: ( () ) rule__Addition__Group_1_0_0__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1044:1: ( () )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1045:1: ()
            {
             before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1046:1: ()
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1048:1: 
            {
            }

             after(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 

            }

            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__02052);
            rule__Addition__Group_1_0_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group_1_0_0__0


    // $ANTLR start rule__Addition__Group_1_0_0__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1059:1: rule__Addition__Group_1_0_0__1 : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1063:1: ( ( '+' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1064:1: ( '+' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1064:1: ( '+' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1065:1: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            match(input,22,FOLLOW_22_in_rule__Addition__Group_1_0_0__12081); 
             after(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group_1_0_0__1


    // $ANTLR start rule__Addition__Group_1_0_1__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1082:1: rule__Addition__Group_1_0_1__0 : ( () ) rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1086:1: ( ( () ) rule__Addition__Group_1_0_1__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1087:1: ( () ) rule__Addition__Group_1_0_1__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1087:1: ( () )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1088:1: ()
            {
             before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1089:1: ()
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1091:1: 
            {
            }

             after(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 

            }

            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__02130);
            rule__Addition__Group_1_0_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group_1_0_1__0


    // $ANTLR start rule__Addition__Group_1_0_1__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1102:1: rule__Addition__Group_1_0_1__1 : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1106:1: ( ( '-' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1107:1: ( '-' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1107:1: ( '-' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1108:1: '-'
            {
             before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            match(input,23,FOLLOW_23_in_rule__Addition__Group_1_0_1__12159); 
             after(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__Group_1_0_1__1


    // $ANTLR start rule__Multiplication__Group__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1125:1: rule__Multiplication__Group__0 : ( rulePrimaryExpression ) rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1129:1: ( ( rulePrimaryExpression ) rule__Multiplication__Group__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1130:1: ( rulePrimaryExpression ) rule__Multiplication__Group__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1130:1: ( rulePrimaryExpression )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1131:1: rulePrimaryExpression
            {
             before(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Multiplication__Group__02198);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__02206);
            rule__Multiplication__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group__0


    // $ANTLR start rule__Multiplication__Group__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1143:1: rule__Multiplication__Group__1 : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1147:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1148:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1148:1: ( ( rule__Multiplication__Group_1__0 )* )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1149:1: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1150:1: ( rule__Multiplication__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15||LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1150:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__12234);
            	    rule__Multiplication__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getMultiplicationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group__1


    // $ANTLR start rule__Multiplication__Group_1__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1164:1: rule__Multiplication__Group_1__0 : ( ( rule__Multiplication__Alternatives_1_0 ) ) rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1168:1: ( ( ( rule__Multiplication__Alternatives_1_0 ) ) rule__Multiplication__Group_1__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1169:1: ( ( rule__Multiplication__Alternatives_1_0 ) ) rule__Multiplication__Group_1__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1169:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1170:1: ( rule__Multiplication__Alternatives_1_0 )
            {
             before(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1171:1: ( rule__Multiplication__Alternatives_1_0 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1171:2: rule__Multiplication__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__02273);
            rule__Multiplication__Alternatives_1_0();
            _fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 

            }

            pushFollow(FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__02282);
            rule__Multiplication__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group_1__0


    // $ANTLR start rule__Multiplication__Group_1__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1182:1: rule__Multiplication__Group_1__1 : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1186:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1187:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1187:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1188:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1189:1: ( rule__Multiplication__RightAssignment_1_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1189:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__12310);
            rule__Multiplication__RightAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group_1__1


    // $ANTLR start rule__Multiplication__Group_1_0_0__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1203:1: rule__Multiplication__Group_1_0_0__0 : ( () ) rule__Multiplication__Group_1_0_0__1 ;
    public final void rule__Multiplication__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1207:1: ( ( () ) rule__Multiplication__Group_1_0_0__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1208:1: ( () ) rule__Multiplication__Group_1_0_0__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1208:1: ( () )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1209:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1210:1: ()
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1212:1: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 

            }

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__02358);
            rule__Multiplication__Group_1_0_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group_1_0_0__0


    // $ANTLR start rule__Multiplication__Group_1_0_0__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1223:1: rule__Multiplication__Group_1_0_0__1 : ( '*' ) ;
    public final void rule__Multiplication__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1227:1: ( ( '*' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1228:1: ( '*' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1228:1: ( '*' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1229:1: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 
            match(input,15,FOLLOW_15_in_rule__Multiplication__Group_1_0_0__12387); 
             after(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group_1_0_0__1


    // $ANTLR start rule__Multiplication__Group_1_0_1__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1246:1: rule__Multiplication__Group_1_0_1__0 : ( () ) rule__Multiplication__Group_1_0_1__1 ;
    public final void rule__Multiplication__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1250:1: ( ( () ) rule__Multiplication__Group_1_0_1__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1251:1: ( () ) rule__Multiplication__Group_1_0_1__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1251:1: ( () )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1252:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1253:1: ()
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1255:1: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 

            }

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__02436);
            rule__Multiplication__Group_1_0_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group_1_0_1__0


    // $ANTLR start rule__Multiplication__Group_1_0_1__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1266:1: rule__Multiplication__Group_1_0_1__1 : ( '/' ) ;
    public final void rule__Multiplication__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1270:1: ( ( '/' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1271:1: ( '/' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1271:1: ( '/' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1272:1: '/'
            {
             before(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 
            match(input,24,FOLLOW_24_in_rule__Multiplication__Group_1_0_1__12465); 
             after(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__Group_1_0_1__1


    // $ANTLR start rule__PrimaryExpression__Group_0__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1289:1: rule__PrimaryExpression__Group_0__0 : ( '(' ) rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1293:1: ( ( '(' ) rule__PrimaryExpression__Group_0__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1294:1: ( '(' ) rule__PrimaryExpression__Group_0__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1294:1: ( '(' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1295:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,19,FOLLOW_19_in_rule__PrimaryExpression__Group_0__02505); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02515);
            rule__PrimaryExpression__Group_0__1();
            _fsp--;


            }

        }
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
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1309:1: rule__PrimaryExpression__Group_0__1 : ( ruleExpression ) rule__PrimaryExpression__Group_0__2 ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1313:1: ( ( ruleExpression ) rule__PrimaryExpression__Group_0__2 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1314:1: ( ruleExpression ) rule__PrimaryExpression__Group_0__2
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1314:1: ( ruleExpression )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1315:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_0__12543);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__2_in_rule__PrimaryExpression__Group_0__12551);
            rule__PrimaryExpression__Group_0__2();
            _fsp--;


            }

        }
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


    // $ANTLR start rule__PrimaryExpression__Group_0__2
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1327:1: rule__PrimaryExpression__Group_0__2 : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1331:1: ( ( ')' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1332:1: ( ')' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1332:1: ( ')' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1333:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,20,FOLLOW_20_in_rule__PrimaryExpression__Group_0__22580); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_0__2


    // $ANTLR start rule__PrimaryExpression__Group_1__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1352:1: rule__PrimaryExpression__Group_1__0 : ( () ) rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1356:1: ( ( () ) rule__PrimaryExpression__Group_1__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1357:1: ( () ) rule__PrimaryExpression__Group_1__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1357:1: ( () )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1358:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1359:1: ()
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1361:1: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02631);
            rule__PrimaryExpression__Group_1__1();
            _fsp--;


            }

        }
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
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1372:1: rule__PrimaryExpression__Group_1__1 : ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) ) ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1376:1: ( ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1377:1: ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1377:1: ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1378:1: ( rule__PrimaryExpression__ValueAssignment_1_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_1_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1379:1: ( rule__PrimaryExpression__ValueAssignment_1_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1379:2: rule__PrimaryExpression__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__ValueAssignment_1_1_in_rule__PrimaryExpression__Group_1__12659);
            rule__PrimaryExpression__ValueAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_1_1()); 

            }


            }

        }
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


    // $ANTLR start rule__PrimaryExpression__Group_2__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1393:1: rule__PrimaryExpression__Group_2__0 : ( () ) rule__PrimaryExpression__Group_2__1 ;
    public final void rule__PrimaryExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1397:1: ( ( () ) rule__PrimaryExpression__Group_2__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1398:1: ( () ) rule__PrimaryExpression__Group_2__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1398:1: ( () )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1399:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1400:1: ()
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1402:1: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_2__1_in_rule__PrimaryExpression__Group_2__02707);
            rule__PrimaryExpression__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2__0


    // $ANTLR start rule__PrimaryExpression__Group_2__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1413:1: rule__PrimaryExpression__Group_2__1 : ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) ) rule__PrimaryExpression__Group_2__2 ;
    public final void rule__PrimaryExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1417:1: ( ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) ) rule__PrimaryExpression__Group_2__2 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1418:1: ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) ) rule__PrimaryExpression__Group_2__2
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1418:1: ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1419:1: ( rule__PrimaryExpression__FuncAssignment_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAssignment_2_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1420:1: ( rule__PrimaryExpression__FuncAssignment_2_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1420:2: rule__PrimaryExpression__FuncAssignment_2_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__FuncAssignment_2_1_in_rule__PrimaryExpression__Group_2__12735);
            rule__PrimaryExpression__FuncAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getFuncAssignment_2_1()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_2__2_in_rule__PrimaryExpression__Group_2__12744);
            rule__PrimaryExpression__Group_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2__1


    // $ANTLR start rule__PrimaryExpression__Group_2__2
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1431:1: rule__PrimaryExpression__Group_2__2 : ( ( rule__PrimaryExpression__Group_2_2__0 )? ) ;
    public final void rule__PrimaryExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1435:1: ( ( ( rule__PrimaryExpression__Group_2_2__0 )? ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1436:1: ( ( rule__PrimaryExpression__Group_2_2__0 )? )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1436:1: ( ( rule__PrimaryExpression__Group_2_2__0 )? )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1437:1: ( rule__PrimaryExpression__Group_2_2__0 )?
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1438:1: ( rule__PrimaryExpression__Group_2_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1438:2: rule__PrimaryExpression__Group_2_2__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_2_2__0_in_rule__PrimaryExpression__Group_2__22772);
                    rule__PrimaryExpression__Group_2_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2__2


    // $ANTLR start rule__PrimaryExpression__Group_2_2__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1454:1: rule__PrimaryExpression__Group_2_2__0 : ( '(' ) rule__PrimaryExpression__Group_2_2__1 ;
    public final void rule__PrimaryExpression__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1458:1: ( ( '(' ) rule__PrimaryExpression__Group_2_2__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1459:1: ( '(' ) rule__PrimaryExpression__Group_2_2__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1459:1: ( '(' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1460:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0()); 
            match(input,19,FOLLOW_19_in_rule__PrimaryExpression__Group_2_2__02814); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_2_2__1_in_rule__PrimaryExpression__Group_2_2__02824);
            rule__PrimaryExpression__Group_2_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2_2__0


    // $ANTLR start rule__PrimaryExpression__Group_2_2__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1474:1: rule__PrimaryExpression__Group_2_2__1 : ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) ) rule__PrimaryExpression__Group_2_2__2 ;
    public final void rule__PrimaryExpression__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1478:1: ( ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) ) rule__PrimaryExpression__Group_2_2__2 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1479:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) ) rule__PrimaryExpression__Group_2_2__2
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1479:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1480:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1481:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1481:2: rule__PrimaryExpression__ArgsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__ArgsAssignment_2_2_1_in_rule__PrimaryExpression__Group_2_2__12852);
            rule__PrimaryExpression__ArgsAssignment_2_2_1();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_1()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_2_2__2_in_rule__PrimaryExpression__Group_2_2__12861);
            rule__PrimaryExpression__Group_2_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2_2__1


    // $ANTLR start rule__PrimaryExpression__Group_2_2__2
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1492:1: rule__PrimaryExpression__Group_2_2__2 : ( ( rule__PrimaryExpression__Group_2_2_2__0 )* ) rule__PrimaryExpression__Group_2_2__3 ;
    public final void rule__PrimaryExpression__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1496:1: ( ( ( rule__PrimaryExpression__Group_2_2_2__0 )* ) rule__PrimaryExpression__Group_2_2__3 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1497:1: ( ( rule__PrimaryExpression__Group_2_2_2__0 )* ) rule__PrimaryExpression__Group_2_2__3
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1497:1: ( ( rule__PrimaryExpression__Group_2_2_2__0 )* )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1498:1: ( rule__PrimaryExpression__Group_2_2_2__0 )*
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2_2()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1499:1: ( rule__PrimaryExpression__Group_2_2_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==21) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1499:2: rule__PrimaryExpression__Group_2_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__PrimaryExpression__Group_2_2_2__0_in_rule__PrimaryExpression__Group_2_2__22889);
            	    rule__PrimaryExpression__Group_2_2_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2_2()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_2_2__3_in_rule__PrimaryExpression__Group_2_2__22899);
            rule__PrimaryExpression__Group_2_2__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2_2__2


    // $ANTLR start rule__PrimaryExpression__Group_2_2__3
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1510:1: rule__PrimaryExpression__Group_2_2__3 : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_2_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1514:1: ( ( ')' ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1515:1: ( ')' )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1515:1: ( ')' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1516:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2_3()); 
            match(input,20,FOLLOW_20_in_rule__PrimaryExpression__Group_2_2__32928); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2_2__3


    // $ANTLR start rule__PrimaryExpression__Group_2_2_2__0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1537:1: rule__PrimaryExpression__Group_2_2_2__0 : ( ',' ) rule__PrimaryExpression__Group_2_2_2__1 ;
    public final void rule__PrimaryExpression__Group_2_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1541:1: ( ( ',' ) rule__PrimaryExpression__Group_2_2_2__1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1542:1: ( ',' ) rule__PrimaryExpression__Group_2_2_2__1
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1542:1: ( ',' )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1543:1: ','
            {
             before(grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_2_0()); 
            match(input,21,FOLLOW_21_in_rule__PrimaryExpression__Group_2_2_2__02972); 
             after(grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_2_0()); 

            }

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_2_2_2__1_in_rule__PrimaryExpression__Group_2_2_2__02982);
            rule__PrimaryExpression__Group_2_2_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2_2_2__0


    // $ANTLR start rule__PrimaryExpression__Group_2_2_2__1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1557:1: rule__PrimaryExpression__Group_2_2_2__1 : ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) ) ;
    public final void rule__PrimaryExpression__Group_2_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1561:1: ( ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1562:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1562:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1563:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_2_1()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1564:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1564:2: rule__PrimaryExpression__ArgsAssignment_2_2_2_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__ArgsAssignment_2_2_2_1_in_rule__PrimaryExpression__Group_2_2_2__13010);
            rule__PrimaryExpression__ArgsAssignment_2_2_2_1();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_2_2_2__1


    // $ANTLR start rule__Module__NameAssignment_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1579:1: rule__Module__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Module__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1583:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1584:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1584:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1585:1: RULE_ID
            {
             before(grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Module__NameAssignment_13049); 
             after(grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Module__NameAssignment_1


    // $ANTLR start rule__Module__ImportsAssignment_2
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1594:1: rule__Module__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__Module__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1598:1: ( ( ruleImport ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1599:1: ( ruleImport )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1599:1: ( ruleImport )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1600:1: ruleImport
            {
             before(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Module__ImportsAssignment_23080);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Module__ImportsAssignment_2


    // $ANTLR start rule__Module__StatementsAssignment_3
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1609:1: rule__Module__StatementsAssignment_3 : ( ruleStatement ) ;
    public final void rule__Module__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1613:1: ( ( ruleStatement ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1614:1: ( ruleStatement )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1614:1: ( ruleStatement )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1615:1: ruleStatement
            {
             before(grammarAccess.getModuleAccess().getStatementsStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Module__StatementsAssignment_33111);
            ruleStatement();
            _fsp--;

             after(grammarAccess.getModuleAccess().getStatementsStatementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Module__StatementsAssignment_3


    // $ANTLR start rule__Import__ImportedNamespaceAssignment_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1624:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1628:1: ( ( ruleImportName ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1629:1: ( ruleImportName )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1629:1: ( ruleImportName )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1630:1: ruleImportName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleImportName_in_rule__Import__ImportedNamespaceAssignment_13142);
            ruleImportName();
            _fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceImportNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__ImportedNamespaceAssignment_1


    // $ANTLR start rule__Definition__NameAssignment_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1639:1: rule__Definition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1643:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1644:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1644:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1645:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_13173); 
             after(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__NameAssignment_1


    // $ANTLR start rule__Definition__ArgsAssignment_2_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1654:1: rule__Definition__ArgsAssignment_2_1 : ( ruleDeclaredParameter ) ;
    public final void rule__Definition__ArgsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1658:1: ( ( ruleDeclaredParameter ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1659:1: ( ruleDeclaredParameter )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1659:1: ( ruleDeclaredParameter )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1660:1: ruleDeclaredParameter
            {
             before(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleDeclaredParameter_in_rule__Definition__ArgsAssignment_2_13204);
            ruleDeclaredParameter();
            _fsp--;

             after(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__ArgsAssignment_2_1


    // $ANTLR start rule__Definition__ArgsAssignment_2_2_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1669:1: rule__Definition__ArgsAssignment_2_2_1 : ( ruleDeclaredParameter ) ;
    public final void rule__Definition__ArgsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1673:1: ( ( ruleDeclaredParameter ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1674:1: ( ruleDeclaredParameter )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1674:1: ( ruleDeclaredParameter )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1675:1: ruleDeclaredParameter
            {
             before(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleDeclaredParameter_in_rule__Definition__ArgsAssignment_2_2_13235);
            ruleDeclaredParameter();
            _fsp--;

             after(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__ArgsAssignment_2_2_1


    // $ANTLR start rule__Definition__ExprAssignment_4
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1684:1: rule__Definition__ExprAssignment_4 : ( ruleExpression ) ;
    public final void rule__Definition__ExprAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1688:1: ( ( ruleExpression ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1689:1: ( ruleExpression )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1689:1: ( ruleExpression )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1690:1: ruleExpression
            {
             before(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Definition__ExprAssignment_43266);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Definition__ExprAssignment_4


    // $ANTLR start rule__DeclaredParameter__NameAssignment
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1699:1: rule__DeclaredParameter__NameAssignment : ( RULE_ID ) ;
    public final void rule__DeclaredParameter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1703:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1704:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1704:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1705:1: RULE_ID
            {
             before(grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclaredParameter__NameAssignment3297); 
             after(grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DeclaredParameter__NameAssignment


    // $ANTLR start rule__Evaluation__ExpressionAssignment_0
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1714:1: rule__Evaluation__ExpressionAssignment_0 : ( ruleExpression ) ;
    public final void rule__Evaluation__ExpressionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1718:1: ( ( ruleExpression ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1719:1: ( ruleExpression )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1719:1: ( ruleExpression )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1720:1: ruleExpression
            {
             before(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Evaluation__ExpressionAssignment_03328);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Evaluation__ExpressionAssignment_0


    // $ANTLR start rule__Addition__RightAssignment_1_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1729:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1733:1: ( ( ruleMultiplication ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1734:1: ( ruleMultiplication )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1734:1: ( ruleMultiplication )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1735:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_13359);
            ruleMultiplication();
            _fsp--;

             after(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Addition__RightAssignment_1_1


    // $ANTLR start rule__Multiplication__RightAssignment_1_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1744:1: rule__Multiplication__RightAssignment_1_1 : ( rulePrimaryExpression ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1748:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1749:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1749:1: ( rulePrimaryExpression )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1750:1: rulePrimaryExpression
            {
             before(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Multiplication__RightAssignment_1_13390);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Multiplication__RightAssignment_1_1


    // $ANTLR start rule__PrimaryExpression__ValueAssignment_1_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1759:1: rule__PrimaryExpression__ValueAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__PrimaryExpression__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1763:1: ( ( RULE_NUMBER ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1764:1: ( RULE_NUMBER )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1764:1: ( RULE_NUMBER )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1765:1: RULE_NUMBER
            {
             before(grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__PrimaryExpression__ValueAssignment_1_13421); 
             after(grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__ValueAssignment_1_1


    // $ANTLR start rule__PrimaryExpression__FuncAssignment_2_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1774:1: rule__PrimaryExpression__FuncAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__PrimaryExpression__FuncAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1778:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1779:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1779:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1780:1: ( RULE_ID )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1781:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1782:1: RULE_ID
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryExpression__FuncAssignment_2_13456); 
             after(grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__FuncAssignment_2_1


    // $ANTLR start rule__PrimaryExpression__ArgsAssignment_2_2_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1793:1: rule__PrimaryExpression__ArgsAssignment_2_2_1 : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__ArgsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1797:1: ( ( ruleExpression ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1798:1: ( ruleExpression )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1798:1: ( ruleExpression )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1799:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__PrimaryExpression__ArgsAssignment_2_2_13491);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__ArgsAssignment_2_2_1


    // $ANTLR start rule__PrimaryExpression__ArgsAssignment_2_2_2_1
    // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1808:1: rule__PrimaryExpression__ArgsAssignment_2_2_2_1 : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__ArgsAssignment_2_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1812:1: ( ( ruleExpression ) )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1813:1: ( ruleExpression )
            {
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1813:1: ( ruleExpression )
            // ../org.eclipse.xtext.example.arithmetics.ui/src-gen/org/eclipse/xtext/example/arithmetics/ui/contentassist/antlr/internal/InternalArithmetics.g:1814:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__PrimaryExpression__ArgsAssignment_2_2_2_13522);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__ArgsAssignment_2_2_2_1


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0_in_ruleModule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportName_in_entryRuleImportName181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportName188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportName__Group__0_in_ruleImportName214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Alternatives_in_ruleStatement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group__0_in_ruleDefinition334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_entryRuleDeclaredParameter361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaredParameter368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclaredParameter__NameAssignment_in_ruleDeclaredParameter394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvaluation_in_entryRuleEvaluation423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvaluation430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Evaluation__Group__0_in_ruleEvaluation456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleExpression516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0_in_ruleAddition575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Statement__Alternatives731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvaluation_in_rule__Statement__Alternatives748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_0781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_0799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_0832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_0850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2__0_in_rule__PrimaryExpression__Alternatives919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Module__Group__0955 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__0965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAssignment_1_in_rule__Module__Group__1993 = new BitSet(new long[]{0x0000000000092032L});
    public static final BitSet FOLLOW_rule__Module__Group__2_in_rule__Module__Group__11002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__ImportsAssignment_2_in_rule__Module__Group__21030 = new BitSet(new long[]{0x0000000000092032L});
    public static final BitSet FOLLOW_rule__Module__Group__3_in_rule__Module__Group__21040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__StatementsAssignment_3_in_rule__Module__Group__31068 = new BitSet(new long[]{0x0000000000090032L});
    public static final BitSet FOLLOW_13_in_rule__Import__Group__01112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__01122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__11150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ImportName__Group__01188 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__ImportName__Group__1_in_rule__ImportName__Group__01196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ImportName__Group_1__0_in_rule__ImportName__Group__11224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ImportName__Group_1__01264 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ImportName__Group_1__1_in_rule__ImportName__Group_1__01274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ImportName__Group_1__11303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Definition__Group__01343 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Definition__Group__1_in_rule__Definition__Group__01353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_in_rule__Definition__Group__11381 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_rule__Definition__Group__2_in_rule__Definition__Group__11390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Group__21418 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Definition__Group__3_in_rule__Definition__Group__21428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Definition__Group__31457 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_rule__Definition__Group__4_in_rule__Definition__Group__31467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__ExprAssignment_4_in_rule__Definition__Group__41495 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Definition__Group__5_in_rule__Definition__Group__41504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Definition__Group__51533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Definition__Group_2__01581 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__01591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__ArgsAssignment_2_1_in_rule__Definition__Group_2__11619 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__2_in_rule__Definition__Group_2__11628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2_2__0_in_rule__Definition__Group_2__21656 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__3_in_rule__Definition__Group_2__21666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Definition__Group_2__31695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Definition__Group_2_2__01739 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Definition__Group_2_2__1_in_rule__Definition__Group_2_2__01749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__ArgsAssignment_2_2_1_in_rule__Definition__Group_2_2__11777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Evaluation__ExpressionAssignment_0_in_rule__Evaluation__Group__01815 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Evaluation__Group__1_in_rule__Evaluation__Group__01824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Evaluation__Group__11853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__Group__01892 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__01900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__11928 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__01967 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__01976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__12004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__02052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Addition__Group_1_0_0__12081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__02130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Addition__Group_1_0_1__12159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Multiplication__Group__02198 = new BitSet(new long[]{0x0000000001008002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__02206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__12234 = new BitSet(new long[]{0x0000000001008002L});
    public static final BitSet FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__02273 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__02282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__12310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__02358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Multiplication__Group_1_0_0__12387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__02436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Multiplication__Group_1_0_1__12465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PrimaryExpression__Group_0__02505 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_0__12543 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__2_in_rule__PrimaryExpression__Group_0__12551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PrimaryExpression__Group_0__22580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__ValueAssignment_1_1_in_rule__PrimaryExpression__Group_1__12659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2__1_in_rule__PrimaryExpression__Group_2__02707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__FuncAssignment_2_1_in_rule__PrimaryExpression__Group_2__12735 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2__2_in_rule__PrimaryExpression__Group_2__12744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2_2__0_in_rule__PrimaryExpression__Group_2__22772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PrimaryExpression__Group_2_2__02814 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2_2__1_in_rule__PrimaryExpression__Group_2_2__02824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__ArgsAssignment_2_2_1_in_rule__PrimaryExpression__Group_2_2__12852 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2_2__2_in_rule__PrimaryExpression__Group_2_2__12861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2_2_2__0_in_rule__PrimaryExpression__Group_2_2__22889 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2_2__3_in_rule__PrimaryExpression__Group_2_2__22899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PrimaryExpression__Group_2_2__32928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PrimaryExpression__Group_2_2_2__02972 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_2_2_2__1_in_rule__PrimaryExpression__Group_2_2_2__02982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__ArgsAssignment_2_2_2_1_in_rule__PrimaryExpression__Group_2_2_2__13010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Module__NameAssignment_13049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Module__ImportsAssignment_23080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Module__StatementsAssignment_33111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportName_in_rule__Import__ImportedNamespaceAssignment_13142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_13173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_rule__Definition__ArgsAssignment_2_13204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaredParameter_in_rule__Definition__ArgsAssignment_2_2_13235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Definition__ExprAssignment_43266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclaredParameter__NameAssignment3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Evaluation__ExpressionAssignment_03328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_13359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Multiplication__RightAssignment_1_13390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__PrimaryExpression__ValueAssignment_1_13421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__FuncAssignment_2_13456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__PrimaryExpression__ArgsAssignment_2_2_13491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__PrimaryExpression__ArgsAssignment_2_2_2_13522 = new BitSet(new long[]{0x0000000000000002L});

}