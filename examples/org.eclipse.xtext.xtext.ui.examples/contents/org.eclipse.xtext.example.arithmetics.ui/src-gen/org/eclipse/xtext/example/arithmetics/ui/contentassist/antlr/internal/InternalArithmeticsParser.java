package org.eclipse.xtext.example.arithmetics.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArithmeticsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NUMBER", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'import'", "'.'", "'*'", "'def'", "':'", "';'", "'('", "')'", "','", "'+'", "'-'", "'/'"
    };
    public static final int RULE_ID=4;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int RULE_NUMBER=5;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalArithmeticsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalArithmeticsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalArithmeticsParser.tokenNames; }
    public String getGrammarFileName() { return "InternalArithmetics.g"; }


     
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




    // $ANTLR start "entryRuleModule"
    // InternalArithmetics.g:60:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // InternalArithmetics.g:61:1: ( ruleModule EOF )
            // InternalArithmetics.g:62:1: ruleModule EOF
            {
             before(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalArithmetics.g:69:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:73:2: ( ( ( rule__Module__Group__0 ) ) )
            // InternalArithmetics.g:74:1: ( ( rule__Module__Group__0 ) )
            {
            // InternalArithmetics.g:74:1: ( ( rule__Module__Group__0 ) )
            // InternalArithmetics.g:75:1: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // InternalArithmetics.g:76:1: ( rule__Module__Group__0 )
            // InternalArithmetics.g:76:2: rule__Module__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleImport"
    // InternalArithmetics.g:88:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalArithmetics.g:89:1: ( ruleImport EOF )
            // InternalArithmetics.g:90:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalArithmetics.g:97:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:101:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalArithmetics.g:102:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalArithmetics.g:102:1: ( ( rule__Import__Group__0 ) )
            // InternalArithmetics.g:103:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalArithmetics.g:104:1: ( rule__Import__Group__0 )
            // InternalArithmetics.g:104:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleImportName"
    // InternalArithmetics.g:116:1: entryRuleImportName : ruleImportName EOF ;
    public final void entryRuleImportName() throws RecognitionException {
        try {
            // InternalArithmetics.g:117:1: ( ruleImportName EOF )
            // InternalArithmetics.g:118:1: ruleImportName EOF
            {
             before(grammarAccess.getImportNameRule()); 
            pushFollow(FOLLOW_1);
            ruleImportName();

            state._fsp--;

             after(grammarAccess.getImportNameRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImportName"


    // $ANTLR start "ruleImportName"
    // InternalArithmetics.g:125:1: ruleImportName : ( ( rule__ImportName__Group__0 ) ) ;
    public final void ruleImportName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:129:2: ( ( ( rule__ImportName__Group__0 ) ) )
            // InternalArithmetics.g:130:1: ( ( rule__ImportName__Group__0 ) )
            {
            // InternalArithmetics.g:130:1: ( ( rule__ImportName__Group__0 ) )
            // InternalArithmetics.g:131:1: ( rule__ImportName__Group__0 )
            {
             before(grammarAccess.getImportNameAccess().getGroup()); 
            // InternalArithmetics.g:132:1: ( rule__ImportName__Group__0 )
            // InternalArithmetics.g:132:2: rule__ImportName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportName__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleImportName"


    // $ANTLR start "entryRuleStatement"
    // InternalArithmetics.g:144:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalArithmetics.g:145:1: ( ruleStatement EOF )
            // InternalArithmetics.g:146:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalArithmetics.g:153:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:157:2: ( ( ( rule__Statement__Alternatives ) ) )
            // InternalArithmetics.g:158:1: ( ( rule__Statement__Alternatives ) )
            {
            // InternalArithmetics.g:158:1: ( ( rule__Statement__Alternatives ) )
            // InternalArithmetics.g:159:1: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // InternalArithmetics.g:160:1: ( rule__Statement__Alternatives )
            // InternalArithmetics.g:160:2: rule__Statement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleDefinition"
    // InternalArithmetics.g:172:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // InternalArithmetics.g:173:1: ( ruleDefinition EOF )
            // InternalArithmetics.g:174:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalArithmetics.g:181:1: ruleDefinition : ( ( rule__Definition__Group__0 ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:185:2: ( ( ( rule__Definition__Group__0 ) ) )
            // InternalArithmetics.g:186:1: ( ( rule__Definition__Group__0 ) )
            {
            // InternalArithmetics.g:186:1: ( ( rule__Definition__Group__0 ) )
            // InternalArithmetics.g:187:1: ( rule__Definition__Group__0 )
            {
             before(grammarAccess.getDefinitionAccess().getGroup()); 
            // InternalArithmetics.g:188:1: ( rule__Definition__Group__0 )
            // InternalArithmetics.g:188:2: rule__Definition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Definition__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleDeclaredParameter"
    // InternalArithmetics.g:200:1: entryRuleDeclaredParameter : ruleDeclaredParameter EOF ;
    public final void entryRuleDeclaredParameter() throws RecognitionException {
        try {
            // InternalArithmetics.g:201:1: ( ruleDeclaredParameter EOF )
            // InternalArithmetics.g:202:1: ruleDeclaredParameter EOF
            {
             before(grammarAccess.getDeclaredParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclaredParameter();

            state._fsp--;

             after(grammarAccess.getDeclaredParameterRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDeclaredParameter"


    // $ANTLR start "ruleDeclaredParameter"
    // InternalArithmetics.g:209:1: ruleDeclaredParameter : ( ( rule__DeclaredParameter__NameAssignment ) ) ;
    public final void ruleDeclaredParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:213:2: ( ( ( rule__DeclaredParameter__NameAssignment ) ) )
            // InternalArithmetics.g:214:1: ( ( rule__DeclaredParameter__NameAssignment ) )
            {
            // InternalArithmetics.g:214:1: ( ( rule__DeclaredParameter__NameAssignment ) )
            // InternalArithmetics.g:215:1: ( rule__DeclaredParameter__NameAssignment )
            {
             before(grammarAccess.getDeclaredParameterAccess().getNameAssignment()); 
            // InternalArithmetics.g:216:1: ( rule__DeclaredParameter__NameAssignment )
            // InternalArithmetics.g:216:2: rule__DeclaredParameter__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DeclaredParameter__NameAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleDeclaredParameter"


    // $ANTLR start "entryRuleEvaluation"
    // InternalArithmetics.g:230:1: entryRuleEvaluation : ruleEvaluation EOF ;
    public final void entryRuleEvaluation() throws RecognitionException {
        try {
            // InternalArithmetics.g:231:1: ( ruleEvaluation EOF )
            // InternalArithmetics.g:232:1: ruleEvaluation EOF
            {
             before(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_1);
            ruleEvaluation();

            state._fsp--;

             after(grammarAccess.getEvaluationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // InternalArithmetics.g:239:1: ruleEvaluation : ( ( rule__Evaluation__Group__0 ) ) ;
    public final void ruleEvaluation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:243:2: ( ( ( rule__Evaluation__Group__0 ) ) )
            // InternalArithmetics.g:244:1: ( ( rule__Evaluation__Group__0 ) )
            {
            // InternalArithmetics.g:244:1: ( ( rule__Evaluation__Group__0 ) )
            // InternalArithmetics.g:245:1: ( rule__Evaluation__Group__0 )
            {
             before(grammarAccess.getEvaluationAccess().getGroup()); 
            // InternalArithmetics.g:246:1: ( rule__Evaluation__Group__0 )
            // InternalArithmetics.g:246:2: rule__Evaluation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Evaluation__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleExpression"
    // InternalArithmetics.g:258:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalArithmetics.g:259:1: ( ruleExpression EOF )
            // InternalArithmetics.g:260:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalArithmetics.g:267:1: ruleExpression : ( ruleAddition ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:271:2: ( ( ruleAddition ) )
            // InternalArithmetics.g:272:1: ( ruleAddition )
            {
            // InternalArithmetics.g:272:1: ( ruleAddition )
            // InternalArithmetics.g:273:1: ruleAddition
            {
             before(grammarAccess.getExpressionAccess().getAdditionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleAddition();

            state._fsp--;

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAddition"
    // InternalArithmetics.g:286:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // InternalArithmetics.g:287:1: ( ruleAddition EOF )
            // InternalArithmetics.g:288:1: ruleAddition EOF
            {
             before(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getAdditionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalArithmetics.g:295:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:299:2: ( ( ( rule__Addition__Group__0 ) ) )
            // InternalArithmetics.g:300:1: ( ( rule__Addition__Group__0 ) )
            {
            // InternalArithmetics.g:300:1: ( ( rule__Addition__Group__0 ) )
            // InternalArithmetics.g:301:1: ( rule__Addition__Group__0 )
            {
             before(grammarAccess.getAdditionAccess().getGroup()); 
            // InternalArithmetics.g:302:1: ( rule__Addition__Group__0 )
            // InternalArithmetics.g:302:2: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalArithmetics.g:314:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // InternalArithmetics.g:315:1: ( ruleMultiplication EOF )
            // InternalArithmetics.g:316:1: ruleMultiplication EOF
            {
             before(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getMultiplicationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalArithmetics.g:323:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:327:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // InternalArithmetics.g:328:1: ( ( rule__Multiplication__Group__0 ) )
            {
            // InternalArithmetics.g:328:1: ( ( rule__Multiplication__Group__0 ) )
            // InternalArithmetics.g:329:1: ( rule__Multiplication__Group__0 )
            {
             before(grammarAccess.getMultiplicationAccess().getGroup()); 
            // InternalArithmetics.g:330:1: ( rule__Multiplication__Group__0 )
            // InternalArithmetics.g:330:2: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalArithmetics.g:342:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // InternalArithmetics.g:343:1: ( rulePrimaryExpression EOF )
            // InternalArithmetics.g:344:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalArithmetics.g:351:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:355:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // InternalArithmetics.g:356:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // InternalArithmetics.g:356:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // InternalArithmetics.g:357:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // InternalArithmetics.g:358:1: ( rule__PrimaryExpression__Alternatives )
            // InternalArithmetics.g:358:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "rule__Statement__Alternatives"
    // InternalArithmetics.g:370:1: rule__Statement__Alternatives : ( ( ruleDefinition ) | ( ruleEvaluation ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:374:1: ( ( ruleDefinition ) | ( ruleEvaluation ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalArithmetics.g:375:1: ( ruleDefinition )
                    {
                    // InternalArithmetics.g:375:1: ( ruleDefinition )
                    // InternalArithmetics.g:376:1: ruleDefinition
                    {
                     before(grammarAccess.getStatementAccess().getDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDefinition();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArithmetics.g:381:6: ( ruleEvaluation )
                    {
                    // InternalArithmetics.g:381:6: ( ruleEvaluation )
                    // InternalArithmetics.g:382:1: ruleEvaluation
                    {
                     before(grammarAccess.getStatementAccess().getEvaluationParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEvaluation();

                    state._fsp--;

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
    // $ANTLR end "rule__Statement__Alternatives"


    // $ANTLR start "rule__Addition__Alternatives_1_0"
    // InternalArithmetics.g:393:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:397:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
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
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalArithmetics.g:398:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // InternalArithmetics.g:398:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // InternalArithmetics.g:399:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    // InternalArithmetics.g:400:1: ( rule__Addition__Group_1_0_0__0 )
                    // InternalArithmetics.g:400:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Addition__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArithmetics.g:404:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // InternalArithmetics.g:404:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // InternalArithmetics.g:405:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    // InternalArithmetics.g:406:1: ( rule__Addition__Group_1_0_1__0 )
                    // InternalArithmetics.g:406:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Addition__Group_1_0_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Addition__Alternatives_1_0"


    // $ANTLR start "rule__Multiplication__Alternatives_1_0"
    // InternalArithmetics.g:415:1: rule__Multiplication__Alternatives_1_0 : ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) );
    public final void rule__Multiplication__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:419:1: ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) )
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
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalArithmetics.g:420:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    {
                    // InternalArithmetics.g:420:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    // InternalArithmetics.g:421:1: ( rule__Multiplication__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 
                    // InternalArithmetics.g:422:1: ( rule__Multiplication__Group_1_0_0__0 )
                    // InternalArithmetics.g:422:2: rule__Multiplication__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Multiplication__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArithmetics.g:426:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    {
                    // InternalArithmetics.g:426:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    // InternalArithmetics.g:427:1: ( rule__Multiplication__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 
                    // InternalArithmetics.g:428:1: ( rule__Multiplication__Group_1_0_1__0 )
                    // InternalArithmetics.g:428:2: rule__Multiplication__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Multiplication__Group_1_0_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Multiplication__Alternatives_1_0"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // InternalArithmetics.g:437:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ( rule__PrimaryExpression__Group_2__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:441:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ( rule__PrimaryExpression__Group_2__0 ) ) )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalArithmetics.g:442:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // InternalArithmetics.g:442:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // InternalArithmetics.g:443:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // InternalArithmetics.g:444:1: ( rule__PrimaryExpression__Group_0__0 )
                    // InternalArithmetics.g:444:2: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalArithmetics.g:448:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // InternalArithmetics.g:448:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // InternalArithmetics.g:449:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // InternalArithmetics.g:450:1: ( rule__PrimaryExpression__Group_1__0 )
                    // InternalArithmetics.g:450:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalArithmetics.g:454:6: ( ( rule__PrimaryExpression__Group_2__0 ) )
                    {
                    // InternalArithmetics.g:454:6: ( ( rule__PrimaryExpression__Group_2__0 ) )
                    // InternalArithmetics.g:455:1: ( rule__PrimaryExpression__Group_2__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_2()); 
                    // InternalArithmetics.g:456:1: ( rule__PrimaryExpression__Group_2__0 )
                    // InternalArithmetics.g:456:2: rule__PrimaryExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__Module__Group__0"
    // InternalArithmetics.g:467:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:471:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // InternalArithmetics.g:472:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Module__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0"


    // $ANTLR start "rule__Module__Group__0__Impl"
    // InternalArithmetics.g:479:1: rule__Module__Group__0__Impl : ( 'module' ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:483:1: ( ( 'module' ) )
            // InternalArithmetics.g:484:1: ( 'module' )
            {
            // InternalArithmetics.g:484:1: ( 'module' )
            // InternalArithmetics.g:485:1: 'module'
            {
             before(grammarAccess.getModuleAccess().getModuleKeyword_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getModuleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // InternalArithmetics.g:498:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:502:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // InternalArithmetics.g:503:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Module__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1"


    // $ANTLR start "rule__Module__Group__1__Impl"
    // InternalArithmetics.g:510:1: rule__Module__Group__1__Impl : ( ( rule__Module__NameAssignment_1 ) ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:514:1: ( ( ( rule__Module__NameAssignment_1 ) ) )
            // InternalArithmetics.g:515:1: ( ( rule__Module__NameAssignment_1 ) )
            {
            // InternalArithmetics.g:515:1: ( ( rule__Module__NameAssignment_1 ) )
            // InternalArithmetics.g:516:1: ( rule__Module__NameAssignment_1 )
            {
             before(grammarAccess.getModuleAccess().getNameAssignment_1()); 
            // InternalArithmetics.g:517:1: ( rule__Module__NameAssignment_1 )
            // InternalArithmetics.g:517:2: rule__Module__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Module__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1__Impl"


    // $ANTLR start "rule__Module__Group__2"
    // InternalArithmetics.g:527:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:531:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // InternalArithmetics.g:532:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Module__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2"


    // $ANTLR start "rule__Module__Group__2__Impl"
    // InternalArithmetics.g:539:1: rule__Module__Group__2__Impl : ( ( rule__Module__ImportsAssignment_2 )* ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:543:1: ( ( ( rule__Module__ImportsAssignment_2 )* ) )
            // InternalArithmetics.g:544:1: ( ( rule__Module__ImportsAssignment_2 )* )
            {
            // InternalArithmetics.g:544:1: ( ( rule__Module__ImportsAssignment_2 )* )
            // InternalArithmetics.g:545:1: ( rule__Module__ImportsAssignment_2 )*
            {
             before(grammarAccess.getModuleAccess().getImportsAssignment_2()); 
            // InternalArithmetics.g:546:1: ( rule__Module__ImportsAssignment_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalArithmetics.g:546:2: rule__Module__ImportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Module__ImportsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getImportsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2__Impl"


    // $ANTLR start "rule__Module__Group__3"
    // InternalArithmetics.g:556:1: rule__Module__Group__3 : rule__Module__Group__3__Impl ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:560:1: ( rule__Module__Group__3__Impl )
            // InternalArithmetics.g:561:2: rule__Module__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3"


    // $ANTLR start "rule__Module__Group__3__Impl"
    // InternalArithmetics.g:567:1: rule__Module__Group__3__Impl : ( ( rule__Module__StatementsAssignment_3 )* ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:571:1: ( ( ( rule__Module__StatementsAssignment_3 )* ) )
            // InternalArithmetics.g:572:1: ( ( rule__Module__StatementsAssignment_3 )* )
            {
            // InternalArithmetics.g:572:1: ( ( rule__Module__StatementsAssignment_3 )* )
            // InternalArithmetics.g:573:1: ( rule__Module__StatementsAssignment_3 )*
            {
             before(grammarAccess.getModuleAccess().getStatementsAssignment_3()); 
            // InternalArithmetics.g:574:1: ( rule__Module__StatementsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_NUMBER)||LA6_0==16||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalArithmetics.g:574:2: rule__Module__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Module__StatementsAssignment_3();

            	    state._fsp--;


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
    // $ANTLR end "rule__Module__Group__3__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalArithmetics.g:592:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:596:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalArithmetics.g:597:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalArithmetics.g:604:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:608:1: ( ( 'import' ) )
            // InternalArithmetics.g:609:1: ( 'import' )
            {
            // InternalArithmetics.g:609:1: ( 'import' )
            // InternalArithmetics.g:610:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,13,FOLLOW_2); 
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
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalArithmetics.g:623:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:627:1: ( rule__Import__Group__1__Impl )
            // InternalArithmetics.g:628:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalArithmetics.g:634:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:638:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalArithmetics.g:639:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalArithmetics.g:639:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalArithmetics.g:640:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalArithmetics.g:641:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalArithmetics.g:641:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__ImportName__Group__0"
    // InternalArithmetics.g:655:1: rule__ImportName__Group__0 : rule__ImportName__Group__0__Impl rule__ImportName__Group__1 ;
    public final void rule__ImportName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:659:1: ( rule__ImportName__Group__0__Impl rule__ImportName__Group__1 )
            // InternalArithmetics.g:660:2: rule__ImportName__Group__0__Impl rule__ImportName__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__ImportName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportName__Group__0"


    // $ANTLR start "rule__ImportName__Group__0__Impl"
    // InternalArithmetics.g:667:1: rule__ImportName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__ImportName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:671:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:672:1: ( RULE_ID )
            {
            // InternalArithmetics.g:672:1: ( RULE_ID )
            // InternalArithmetics.g:673:1: RULE_ID
            {
             before(grammarAccess.getImportNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getImportNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportName__Group__0__Impl"


    // $ANTLR start "rule__ImportName__Group__1"
    // InternalArithmetics.g:684:1: rule__ImportName__Group__1 : rule__ImportName__Group__1__Impl ;
    public final void rule__ImportName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:688:1: ( rule__ImportName__Group__1__Impl )
            // InternalArithmetics.g:689:2: rule__ImportName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportName__Group__1"


    // $ANTLR start "rule__ImportName__Group__1__Impl"
    // InternalArithmetics.g:695:1: rule__ImportName__Group__1__Impl : ( ( rule__ImportName__Group_1__0 )? ) ;
    public final void rule__ImportName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:699:1: ( ( ( rule__ImportName__Group_1__0 )? ) )
            // InternalArithmetics.g:700:1: ( ( rule__ImportName__Group_1__0 )? )
            {
            // InternalArithmetics.g:700:1: ( ( rule__ImportName__Group_1__0 )? )
            // InternalArithmetics.g:701:1: ( rule__ImportName__Group_1__0 )?
            {
             before(grammarAccess.getImportNameAccess().getGroup_1()); 
            // InternalArithmetics.g:702:1: ( rule__ImportName__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalArithmetics.g:702:2: rule__ImportName__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ImportName__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ImportName__Group__1__Impl"


    // $ANTLR start "rule__ImportName__Group_1__0"
    // InternalArithmetics.g:716:1: rule__ImportName__Group_1__0 : rule__ImportName__Group_1__0__Impl rule__ImportName__Group_1__1 ;
    public final void rule__ImportName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:720:1: ( rule__ImportName__Group_1__0__Impl rule__ImportName__Group_1__1 )
            // InternalArithmetics.g:721:2: rule__ImportName__Group_1__0__Impl rule__ImportName__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__ImportName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImportName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportName__Group_1__0"


    // $ANTLR start "rule__ImportName__Group_1__0__Impl"
    // InternalArithmetics.g:728:1: rule__ImportName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ImportName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:732:1: ( ( '.' ) )
            // InternalArithmetics.g:733:1: ( '.' )
            {
            // InternalArithmetics.g:733:1: ( '.' )
            // InternalArithmetics.g:734:1: '.'
            {
             before(grammarAccess.getImportNameAccess().getFullStopKeyword_1_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getImportNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportName__Group_1__0__Impl"


    // $ANTLR start "rule__ImportName__Group_1__1"
    // InternalArithmetics.g:747:1: rule__ImportName__Group_1__1 : rule__ImportName__Group_1__1__Impl ;
    public final void rule__ImportName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:751:1: ( rule__ImportName__Group_1__1__Impl )
            // InternalArithmetics.g:752:2: rule__ImportName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportName__Group_1__1"


    // $ANTLR start "rule__ImportName__Group_1__1__Impl"
    // InternalArithmetics.g:758:1: rule__ImportName__Group_1__1__Impl : ( '*' ) ;
    public final void rule__ImportName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:762:1: ( ( '*' ) )
            // InternalArithmetics.g:763:1: ( '*' )
            {
            // InternalArithmetics.g:763:1: ( '*' )
            // InternalArithmetics.g:764:1: '*'
            {
             before(grammarAccess.getImportNameAccess().getAsteriskKeyword_1_1()); 
            match(input,15,FOLLOW_2); 
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
    // $ANTLR end "rule__ImportName__Group_1__1__Impl"


    // $ANTLR start "rule__Definition__Group__0"
    // InternalArithmetics.g:781:1: rule__Definition__Group__0 : rule__Definition__Group__0__Impl rule__Definition__Group__1 ;
    public final void rule__Definition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:785:1: ( rule__Definition__Group__0__Impl rule__Definition__Group__1 )
            // InternalArithmetics.g:786:2: rule__Definition__Group__0__Impl rule__Definition__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Definition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__0"


    // $ANTLR start "rule__Definition__Group__0__Impl"
    // InternalArithmetics.g:793:1: rule__Definition__Group__0__Impl : ( 'def' ) ;
    public final void rule__Definition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:797:1: ( ( 'def' ) )
            // InternalArithmetics.g:798:1: ( 'def' )
            {
            // InternalArithmetics.g:798:1: ( 'def' )
            // InternalArithmetics.g:799:1: 'def'
            {
             before(grammarAccess.getDefinitionAccess().getDefKeyword_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getDefinitionAccess().getDefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__0__Impl"


    // $ANTLR start "rule__Definition__Group__1"
    // InternalArithmetics.g:812:1: rule__Definition__Group__1 : rule__Definition__Group__1__Impl rule__Definition__Group__2 ;
    public final void rule__Definition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:816:1: ( rule__Definition__Group__1__Impl rule__Definition__Group__2 )
            // InternalArithmetics.g:817:2: rule__Definition__Group__1__Impl rule__Definition__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Definition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__1"


    // $ANTLR start "rule__Definition__Group__1__Impl"
    // InternalArithmetics.g:824:1: rule__Definition__Group__1__Impl : ( ( rule__Definition__NameAssignment_1 ) ) ;
    public final void rule__Definition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:828:1: ( ( ( rule__Definition__NameAssignment_1 ) ) )
            // InternalArithmetics.g:829:1: ( ( rule__Definition__NameAssignment_1 ) )
            {
            // InternalArithmetics.g:829:1: ( ( rule__Definition__NameAssignment_1 ) )
            // InternalArithmetics.g:830:1: ( rule__Definition__NameAssignment_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1()); 
            // InternalArithmetics.g:831:1: ( rule__Definition__NameAssignment_1 )
            // InternalArithmetics.g:831:2: rule__Definition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Definition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__1__Impl"


    // $ANTLR start "rule__Definition__Group__2"
    // InternalArithmetics.g:841:1: rule__Definition__Group__2 : rule__Definition__Group__2__Impl rule__Definition__Group__3 ;
    public final void rule__Definition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:845:1: ( rule__Definition__Group__2__Impl rule__Definition__Group__3 )
            // InternalArithmetics.g:846:2: rule__Definition__Group__2__Impl rule__Definition__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Definition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__2"


    // $ANTLR start "rule__Definition__Group__2__Impl"
    // InternalArithmetics.g:853:1: rule__Definition__Group__2__Impl : ( ( rule__Definition__Group_2__0 )? ) ;
    public final void rule__Definition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:857:1: ( ( ( rule__Definition__Group_2__0 )? ) )
            // InternalArithmetics.g:858:1: ( ( rule__Definition__Group_2__0 )? )
            {
            // InternalArithmetics.g:858:1: ( ( rule__Definition__Group_2__0 )? )
            // InternalArithmetics.g:859:1: ( rule__Definition__Group_2__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_2()); 
            // InternalArithmetics.g:860:1: ( rule__Definition__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalArithmetics.g:860:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDefinitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__2__Impl"


    // $ANTLR start "rule__Definition__Group__3"
    // InternalArithmetics.g:870:1: rule__Definition__Group__3 : rule__Definition__Group__3__Impl rule__Definition__Group__4 ;
    public final void rule__Definition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:874:1: ( rule__Definition__Group__3__Impl rule__Definition__Group__4 )
            // InternalArithmetics.g:875:2: rule__Definition__Group__3__Impl rule__Definition__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Definition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__3"


    // $ANTLR start "rule__Definition__Group__3__Impl"
    // InternalArithmetics.g:882:1: rule__Definition__Group__3__Impl : ( ':' ) ;
    public final void rule__Definition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:886:1: ( ( ':' ) )
            // InternalArithmetics.g:887:1: ( ':' )
            {
            // InternalArithmetics.g:887:1: ( ':' )
            // InternalArithmetics.g:888:1: ':'
            {
             before(grammarAccess.getDefinitionAccess().getColonKeyword_3()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getDefinitionAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__3__Impl"


    // $ANTLR start "rule__Definition__Group__4"
    // InternalArithmetics.g:901:1: rule__Definition__Group__4 : rule__Definition__Group__4__Impl rule__Definition__Group__5 ;
    public final void rule__Definition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:905:1: ( rule__Definition__Group__4__Impl rule__Definition__Group__5 )
            // InternalArithmetics.g:906:2: rule__Definition__Group__4__Impl rule__Definition__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__Definition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__4"


    // $ANTLR start "rule__Definition__Group__4__Impl"
    // InternalArithmetics.g:913:1: rule__Definition__Group__4__Impl : ( ( rule__Definition__ExprAssignment_4 ) ) ;
    public final void rule__Definition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:917:1: ( ( ( rule__Definition__ExprAssignment_4 ) ) )
            // InternalArithmetics.g:918:1: ( ( rule__Definition__ExprAssignment_4 ) )
            {
            // InternalArithmetics.g:918:1: ( ( rule__Definition__ExprAssignment_4 ) )
            // InternalArithmetics.g:919:1: ( rule__Definition__ExprAssignment_4 )
            {
             before(grammarAccess.getDefinitionAccess().getExprAssignment_4()); 
            // InternalArithmetics.g:920:1: ( rule__Definition__ExprAssignment_4 )
            // InternalArithmetics.g:920:2: rule__Definition__ExprAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Definition__ExprAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getExprAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__4__Impl"


    // $ANTLR start "rule__Definition__Group__5"
    // InternalArithmetics.g:930:1: rule__Definition__Group__5 : rule__Definition__Group__5__Impl ;
    public final void rule__Definition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:934:1: ( rule__Definition__Group__5__Impl )
            // InternalArithmetics.g:935:2: rule__Definition__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Definition__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__5"


    // $ANTLR start "rule__Definition__Group__5__Impl"
    // InternalArithmetics.g:941:1: rule__Definition__Group__5__Impl : ( ';' ) ;
    public final void rule__Definition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:945:1: ( ( ';' ) )
            // InternalArithmetics.g:946:1: ( ';' )
            {
            // InternalArithmetics.g:946:1: ( ';' )
            // InternalArithmetics.g:947:1: ';'
            {
             before(grammarAccess.getDefinitionAccess().getSemicolonKeyword_5()); 
            match(input,18,FOLLOW_2); 
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
    // $ANTLR end "rule__Definition__Group__5__Impl"


    // $ANTLR start "rule__Definition__Group_2__0"
    // InternalArithmetics.g:972:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:976:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // InternalArithmetics.g:977:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__0"


    // $ANTLR start "rule__Definition__Group_2__0__Impl"
    // InternalArithmetics.g:984:1: rule__Definition__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:988:1: ( ( '(' ) )
            // InternalArithmetics.g:989:1: ( '(' )
            {
            // InternalArithmetics.g:989:1: ( '(' )
            // InternalArithmetics.g:990:1: '('
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__0__Impl"


    // $ANTLR start "rule__Definition__Group_2__1"
    // InternalArithmetics.g:1003:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl rule__Definition__Group_2__2 ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1007:1: ( rule__Definition__Group_2__1__Impl rule__Definition__Group_2__2 )
            // InternalArithmetics.g:1008:2: rule__Definition__Group_2__1__Impl rule__Definition__Group_2__2
            {
            pushFollow(FOLLOW_12);
            rule__Definition__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__1"


    // $ANTLR start "rule__Definition__Group_2__1__Impl"
    // InternalArithmetics.g:1015:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__ArgsAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1019:1: ( ( ( rule__Definition__ArgsAssignment_2_1 ) ) )
            // InternalArithmetics.g:1020:1: ( ( rule__Definition__ArgsAssignment_2_1 ) )
            {
            // InternalArithmetics.g:1020:1: ( ( rule__Definition__ArgsAssignment_2_1 ) )
            // InternalArithmetics.g:1021:1: ( rule__Definition__ArgsAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getArgsAssignment_2_1()); 
            // InternalArithmetics.g:1022:1: ( rule__Definition__ArgsAssignment_2_1 )
            // InternalArithmetics.g:1022:2: rule__Definition__ArgsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Definition__ArgsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getArgsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__1__Impl"


    // $ANTLR start "rule__Definition__Group_2__2"
    // InternalArithmetics.g:1032:1: rule__Definition__Group_2__2 : rule__Definition__Group_2__2__Impl rule__Definition__Group_2__3 ;
    public final void rule__Definition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1036:1: ( rule__Definition__Group_2__2__Impl rule__Definition__Group_2__3 )
            // InternalArithmetics.g:1037:2: rule__Definition__Group_2__2__Impl rule__Definition__Group_2__3
            {
            pushFollow(FOLLOW_12);
            rule__Definition__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__2"


    // $ANTLR start "rule__Definition__Group_2__2__Impl"
    // InternalArithmetics.g:1044:1: rule__Definition__Group_2__2__Impl : ( ( rule__Definition__Group_2_2__0 )* ) ;
    public final void rule__Definition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1048:1: ( ( ( rule__Definition__Group_2_2__0 )* ) )
            // InternalArithmetics.g:1049:1: ( ( rule__Definition__Group_2_2__0 )* )
            {
            // InternalArithmetics.g:1049:1: ( ( rule__Definition__Group_2_2__0 )* )
            // InternalArithmetics.g:1050:1: ( rule__Definition__Group_2_2__0 )*
            {
             before(grammarAccess.getDefinitionAccess().getGroup_2_2()); 
            // InternalArithmetics.g:1051:1: ( rule__Definition__Group_2_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalArithmetics.g:1051:2: rule__Definition__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Definition__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getDefinitionAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__2__Impl"


    // $ANTLR start "rule__Definition__Group_2__3"
    // InternalArithmetics.g:1061:1: rule__Definition__Group_2__3 : rule__Definition__Group_2__3__Impl ;
    public final void rule__Definition__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1065:1: ( rule__Definition__Group_2__3__Impl )
            // InternalArithmetics.g:1066:2: rule__Definition__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Definition__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__3"


    // $ANTLR start "rule__Definition__Group_2__3__Impl"
    // InternalArithmetics.g:1072:1: rule__Definition__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Definition__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1076:1: ( ( ')' ) )
            // InternalArithmetics.g:1077:1: ( ')' )
            {
            // InternalArithmetics.g:1077:1: ( ')' )
            // InternalArithmetics.g:1078:1: ')'
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_2_3()); 
            match(input,20,FOLLOW_2); 
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
    // $ANTLR end "rule__Definition__Group_2__3__Impl"


    // $ANTLR start "rule__Definition__Group_2_2__0"
    // InternalArithmetics.g:1099:1: rule__Definition__Group_2_2__0 : rule__Definition__Group_2_2__0__Impl rule__Definition__Group_2_2__1 ;
    public final void rule__Definition__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1103:1: ( rule__Definition__Group_2_2__0__Impl rule__Definition__Group_2_2__1 )
            // InternalArithmetics.g:1104:2: rule__Definition__Group_2_2__0__Impl rule__Definition__Group_2_2__1
            {
            pushFollow(FOLLOW_3);
            rule__Definition__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2_2__0"


    // $ANTLR start "rule__Definition__Group_2_2__0__Impl"
    // InternalArithmetics.g:1111:1: rule__Definition__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Definition__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1115:1: ( ( ',' ) )
            // InternalArithmetics.g:1116:1: ( ',' )
            {
            // InternalArithmetics.g:1116:1: ( ',' )
            // InternalArithmetics.g:1117:1: ','
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_2_2_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2_2__0__Impl"


    // $ANTLR start "rule__Definition__Group_2_2__1"
    // InternalArithmetics.g:1130:1: rule__Definition__Group_2_2__1 : rule__Definition__Group_2_2__1__Impl ;
    public final void rule__Definition__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1134:1: ( rule__Definition__Group_2_2__1__Impl )
            // InternalArithmetics.g:1135:2: rule__Definition__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Definition__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2_2__1"


    // $ANTLR start "rule__Definition__Group_2_2__1__Impl"
    // InternalArithmetics.g:1141:1: rule__Definition__Group_2_2__1__Impl : ( ( rule__Definition__ArgsAssignment_2_2_1 ) ) ;
    public final void rule__Definition__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1145:1: ( ( ( rule__Definition__ArgsAssignment_2_2_1 ) ) )
            // InternalArithmetics.g:1146:1: ( ( rule__Definition__ArgsAssignment_2_2_1 ) )
            {
            // InternalArithmetics.g:1146:1: ( ( rule__Definition__ArgsAssignment_2_2_1 ) )
            // InternalArithmetics.g:1147:1: ( rule__Definition__ArgsAssignment_2_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getArgsAssignment_2_2_1()); 
            // InternalArithmetics.g:1148:1: ( rule__Definition__ArgsAssignment_2_2_1 )
            // InternalArithmetics.g:1148:2: rule__Definition__ArgsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Definition__ArgsAssignment_2_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__Definition__Group_2_2__1__Impl"


    // $ANTLR start "rule__Evaluation__Group__0"
    // InternalArithmetics.g:1162:1: rule__Evaluation__Group__0 : rule__Evaluation__Group__0__Impl rule__Evaluation__Group__1 ;
    public final void rule__Evaluation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1166:1: ( rule__Evaluation__Group__0__Impl rule__Evaluation__Group__1 )
            // InternalArithmetics.g:1167:2: rule__Evaluation__Group__0__Impl rule__Evaluation__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__Evaluation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Evaluation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Evaluation__Group__0"


    // $ANTLR start "rule__Evaluation__Group__0__Impl"
    // InternalArithmetics.g:1174:1: rule__Evaluation__Group__0__Impl : ( ( rule__Evaluation__ExpressionAssignment_0 ) ) ;
    public final void rule__Evaluation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1178:1: ( ( ( rule__Evaluation__ExpressionAssignment_0 ) ) )
            // InternalArithmetics.g:1179:1: ( ( rule__Evaluation__ExpressionAssignment_0 ) )
            {
            // InternalArithmetics.g:1179:1: ( ( rule__Evaluation__ExpressionAssignment_0 ) )
            // InternalArithmetics.g:1180:1: ( rule__Evaluation__ExpressionAssignment_0 )
            {
             before(grammarAccess.getEvaluationAccess().getExpressionAssignment_0()); 
            // InternalArithmetics.g:1181:1: ( rule__Evaluation__ExpressionAssignment_0 )
            // InternalArithmetics.g:1181:2: rule__Evaluation__ExpressionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Evaluation__ExpressionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEvaluationAccess().getExpressionAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Evaluation__Group__0__Impl"


    // $ANTLR start "rule__Evaluation__Group__1"
    // InternalArithmetics.g:1191:1: rule__Evaluation__Group__1 : rule__Evaluation__Group__1__Impl ;
    public final void rule__Evaluation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1195:1: ( rule__Evaluation__Group__1__Impl )
            // InternalArithmetics.g:1196:2: rule__Evaluation__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Evaluation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Evaluation__Group__1"


    // $ANTLR start "rule__Evaluation__Group__1__Impl"
    // InternalArithmetics.g:1202:1: rule__Evaluation__Group__1__Impl : ( ';' ) ;
    public final void rule__Evaluation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1206:1: ( ( ';' ) )
            // InternalArithmetics.g:1207:1: ( ';' )
            {
            // InternalArithmetics.g:1207:1: ( ';' )
            // InternalArithmetics.g:1208:1: ';'
            {
             before(grammarAccess.getEvaluationAccess().getSemicolonKeyword_1()); 
            match(input,18,FOLLOW_2); 
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
    // $ANTLR end "rule__Evaluation__Group__1__Impl"


    // $ANTLR start "rule__Addition__Group__0"
    // InternalArithmetics.g:1225:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1229:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // InternalArithmetics.g:1230:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Addition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Addition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__0"


    // $ANTLR start "rule__Addition__Group__0__Impl"
    // InternalArithmetics.g:1237:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1241:1: ( ( ruleMultiplication ) )
            // InternalArithmetics.g:1242:1: ( ruleMultiplication )
            {
            // InternalArithmetics.g:1242:1: ( ruleMultiplication )
            // InternalArithmetics.g:1243:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__0__Impl"


    // $ANTLR start "rule__Addition__Group__1"
    // InternalArithmetics.g:1254:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1258:1: ( rule__Addition__Group__1__Impl )
            // InternalArithmetics.g:1259:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__1"


    // $ANTLR start "rule__Addition__Group__1__Impl"
    // InternalArithmetics.g:1265:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1269:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // InternalArithmetics.g:1270:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // InternalArithmetics.g:1270:1: ( ( rule__Addition__Group_1__0 )* )
            // InternalArithmetics.g:1271:1: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // InternalArithmetics.g:1272:1: ( rule__Addition__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=22 && LA10_0<=23)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalArithmetics.g:1272:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__Addition__Group__1__Impl"


    // $ANTLR start "rule__Addition__Group_1__0"
    // InternalArithmetics.g:1286:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1290:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // InternalArithmetics.g:1291:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__0"


    // $ANTLR start "rule__Addition__Group_1__0__Impl"
    // InternalArithmetics.g:1298:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1302:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // InternalArithmetics.g:1303:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // InternalArithmetics.g:1303:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // InternalArithmetics.g:1304:1: ( rule__Addition__Alternatives_1_0 )
            {
             before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            // InternalArithmetics.g:1305:1: ( rule__Addition__Alternatives_1_0 )
            // InternalArithmetics.g:1305:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1__1"
    // InternalArithmetics.g:1315:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1319:1: ( rule__Addition__Group_1__1__Impl )
            // InternalArithmetics.g:1320:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__1"


    // $ANTLR start "rule__Addition__Group_1__1__Impl"
    // InternalArithmetics.g:1326:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1330:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // InternalArithmetics.g:1331:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // InternalArithmetics.g:1331:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // InternalArithmetics.g:1332:1: ( rule__Addition__RightAssignment_1_1 )
            {
             before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            // InternalArithmetics.g:1333:1: ( rule__Addition__RightAssignment_1_1 )
            // InternalArithmetics.g:1333:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Addition__RightAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__Addition__Group_1__1__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_0__0"
    // InternalArithmetics.g:1347:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1351:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // InternalArithmetics.g:1352:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_16);
            rule__Addition__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Addition__Group_1_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__0"


    // $ANTLR start "rule__Addition__Group_1_0_0__0__Impl"
    // InternalArithmetics.g:1359:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1363:1: ( ( () ) )
            // InternalArithmetics.g:1364:1: ( () )
            {
            // InternalArithmetics.g:1364:1: ( () )
            // InternalArithmetics.g:1365:1: ()
            {
             before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            // InternalArithmetics.g:1366:1: ()
            // InternalArithmetics.g:1368:1: 
            {
            }

             after(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_0__1"
    // InternalArithmetics.g:1378:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1382:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // InternalArithmetics.g:1383:2: rule__Addition__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1_0_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__1"


    // $ANTLR start "rule__Addition__Group_1_0_0__1__Impl"
    // InternalArithmetics.g:1389:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1393:1: ( ( '+' ) )
            // InternalArithmetics.g:1394:1: ( '+' )
            {
            // InternalArithmetics.g:1394:1: ( '+' )
            // InternalArithmetics.g:1395:1: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            match(input,22,FOLLOW_2); 
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
    // $ANTLR end "rule__Addition__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_1__0"
    // InternalArithmetics.g:1412:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1416:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // InternalArithmetics.g:1417:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_14);
            rule__Addition__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Addition__Group_1_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__0"


    // $ANTLR start "rule__Addition__Group_1_0_1__0__Impl"
    // InternalArithmetics.g:1424:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1428:1: ( ( () ) )
            // InternalArithmetics.g:1429:1: ( () )
            {
            // InternalArithmetics.g:1429:1: ( () )
            // InternalArithmetics.g:1430:1: ()
            {
             before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            // InternalArithmetics.g:1431:1: ()
            // InternalArithmetics.g:1433:1: 
            {
            }

             after(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_1__1"
    // InternalArithmetics.g:1443:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1447:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // InternalArithmetics.g:1448:2: rule__Addition__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Addition__Group_1_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__1"


    // $ANTLR start "rule__Addition__Group_1_0_1__1__Impl"
    // InternalArithmetics.g:1454:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1458:1: ( ( '-' ) )
            // InternalArithmetics.g:1459:1: ( '-' )
            {
            // InternalArithmetics.g:1459:1: ( '-' )
            // InternalArithmetics.g:1460:1: '-'
            {
             before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            match(input,23,FOLLOW_2); 
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
    // $ANTLR end "rule__Addition__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group__0"
    // InternalArithmetics.g:1477:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1481:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // InternalArithmetics.g:1482:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__0"


    // $ANTLR start "rule__Multiplication__Group__0__Impl"
    // InternalArithmetics.g:1489:1: rule__Multiplication__Group__0__Impl : ( rulePrimaryExpression ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1493:1: ( ( rulePrimaryExpression ) )
            // InternalArithmetics.g:1494:1: ( rulePrimaryExpression )
            {
            // InternalArithmetics.g:1494:1: ( rulePrimaryExpression )
            // InternalArithmetics.g:1495:1: rulePrimaryExpression
            {
             before(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__0__Impl"


    // $ANTLR start "rule__Multiplication__Group__1"
    // InternalArithmetics.g:1506:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1510:1: ( rule__Multiplication__Group__1__Impl )
            // InternalArithmetics.g:1511:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__1"


    // $ANTLR start "rule__Multiplication__Group__1__Impl"
    // InternalArithmetics.g:1517:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1521:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // InternalArithmetics.g:1522:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // InternalArithmetics.g:1522:1: ( ( rule__Multiplication__Group_1__0 )* )
            // InternalArithmetics.g:1523:1: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // InternalArithmetics.g:1524:1: ( rule__Multiplication__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15||LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalArithmetics.g:1524:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__Multiplication__Group__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__0"
    // InternalArithmetics.g:1538:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1542:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // InternalArithmetics.g:1543:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__0"


    // $ANTLR start "rule__Multiplication__Group_1__0__Impl"
    // InternalArithmetics.g:1550:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Alternatives_1_0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1554:1: ( ( ( rule__Multiplication__Alternatives_1_0 ) ) )
            // InternalArithmetics.g:1555:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            {
            // InternalArithmetics.g:1555:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            // InternalArithmetics.g:1556:1: ( rule__Multiplication__Alternatives_1_0 )
            {
             before(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 
            // InternalArithmetics.g:1557:1: ( rule__Multiplication__Alternatives_1_0 )
            // InternalArithmetics.g:1557:2: rule__Multiplication__Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__1"
    // InternalArithmetics.g:1567:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1571:1: ( rule__Multiplication__Group_1__1__Impl )
            // InternalArithmetics.g:1572:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__1"


    // $ANTLR start "rule__Multiplication__Group_1__1__Impl"
    // InternalArithmetics.g:1578:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1582:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // InternalArithmetics.g:1583:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // InternalArithmetics.g:1583:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // InternalArithmetics.g:1584:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            // InternalArithmetics.g:1585:1: ( rule__Multiplication__RightAssignment_1_1 )
            // InternalArithmetics.g:1585:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__RightAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__Multiplication__Group_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__0"
    // InternalArithmetics.g:1599:1: rule__Multiplication__Group_1_0_0__0 : rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 ;
    public final void rule__Multiplication__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1603:1: ( rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 )
            // InternalArithmetics.g:1604:2: rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1
            {
            pushFollow(FOLLOW_8);
            rule__Multiplication__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_0__0"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__0__Impl"
    // InternalArithmetics.g:1611:1: rule__Multiplication__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1615:1: ( ( () ) )
            // InternalArithmetics.g:1616:1: ( () )
            {
            // InternalArithmetics.g:1616:1: ( () )
            // InternalArithmetics.g:1617:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 
            // InternalArithmetics.g:1618:1: ()
            // InternalArithmetics.g:1620:1: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__1"
    // InternalArithmetics.g:1630:1: rule__Multiplication__Group_1_0_0__1 : rule__Multiplication__Group_1_0_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1634:1: ( rule__Multiplication__Group_1_0_0__1__Impl )
            // InternalArithmetics.g:1635:2: rule__Multiplication__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1_0_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_0__1"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__1__Impl"
    // InternalArithmetics.g:1641:1: rule__Multiplication__Group_1_0_0__1__Impl : ( '*' ) ;
    public final void rule__Multiplication__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1645:1: ( ( '*' ) )
            // InternalArithmetics.g:1646:1: ( '*' )
            {
            // InternalArithmetics.g:1646:1: ( '*' )
            // InternalArithmetics.g:1647:1: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 
            match(input,15,FOLLOW_2); 
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
    // $ANTLR end "rule__Multiplication__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__0"
    // InternalArithmetics.g:1664:1: rule__Multiplication__Group_1_0_1__0 : rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 ;
    public final void rule__Multiplication__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1668:1: ( rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 )
            // InternalArithmetics.g:1669:2: rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1
            {
            pushFollow(FOLLOW_17);
            rule__Multiplication__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_1__0"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__0__Impl"
    // InternalArithmetics.g:1676:1: rule__Multiplication__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1680:1: ( ( () ) )
            // InternalArithmetics.g:1681:1: ( () )
            {
            // InternalArithmetics.g:1681:1: ( () )
            // InternalArithmetics.g:1682:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 
            // InternalArithmetics.g:1683:1: ()
            // InternalArithmetics.g:1685:1: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__1"
    // InternalArithmetics.g:1695:1: rule__Multiplication__Group_1_0_1__1 : rule__Multiplication__Group_1_0_1__1__Impl ;
    public final void rule__Multiplication__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1699:1: ( rule__Multiplication__Group_1_0_1__1__Impl )
            // InternalArithmetics.g:1700:2: rule__Multiplication__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Multiplication__Group_1_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_1__1"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__1__Impl"
    // InternalArithmetics.g:1706:1: rule__Multiplication__Group_1_0_1__1__Impl : ( '/' ) ;
    public final void rule__Multiplication__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1710:1: ( ( '/' ) )
            // InternalArithmetics.g:1711:1: ( '/' )
            {
            // InternalArithmetics.g:1711:1: ( '/' )
            // InternalArithmetics.g:1712:1: '/'
            {
             before(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 
            match(input,24,FOLLOW_2); 
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
    // $ANTLR end "rule__Multiplication__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0"
    // InternalArithmetics.g:1729:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1733:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // InternalArithmetics.g:1734:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_10);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0__Impl"
    // InternalArithmetics.g:1741:1: rule__PrimaryExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1745:1: ( ( '(' ) )
            // InternalArithmetics.g:1746:1: ( '(' )
            {
            // InternalArithmetics.g:1746:1: ( '(' )
            // InternalArithmetics.g:1747:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1"
    // InternalArithmetics.g:1760:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1764:1: ( rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 )
            // InternalArithmetics.g:1765:2: rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2
            {
            pushFollow(FOLLOW_19);
            rule__PrimaryExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1__Impl"
    // InternalArithmetics.g:1772:1: rule__PrimaryExpression__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1776:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:1777:1: ( ruleExpression )
            {
            // InternalArithmetics.g:1777:1: ( ruleExpression )
            // InternalArithmetics.g:1778:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__2"
    // InternalArithmetics.g:1789:1: rule__PrimaryExpression__Group_0__2 : rule__PrimaryExpression__Group_0__2__Impl ;
    public final void rule__PrimaryExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1793:1: ( rule__PrimaryExpression__Group_0__2__Impl )
            // InternalArithmetics.g:1794:2: rule__PrimaryExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__2"


    // $ANTLR start "rule__PrimaryExpression__Group_0__2__Impl"
    // InternalArithmetics.g:1800:1: rule__PrimaryExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1804:1: ( ( ')' ) )
            // InternalArithmetics.g:1805:1: ( ')' )
            {
            // InternalArithmetics.g:1805:1: ( ')' )
            // InternalArithmetics.g:1806:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,20,FOLLOW_2); 
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
    // $ANTLR end "rule__PrimaryExpression__Group_0__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0"
    // InternalArithmetics.g:1825:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1829:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // InternalArithmetics.g:1830:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_20);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0__Impl"
    // InternalArithmetics.g:1837:1: rule__PrimaryExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1841:1: ( ( () ) )
            // InternalArithmetics.g:1842:1: ( () )
            {
            // InternalArithmetics.g:1842:1: ( () )
            // InternalArithmetics.g:1843:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0()); 
            // InternalArithmetics.g:1844:1: ()
            // InternalArithmetics.g:1846:1: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1"
    // InternalArithmetics.g:1856:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1860:1: ( rule__PrimaryExpression__Group_1__1__Impl )
            // InternalArithmetics.g:1861:2: rule__PrimaryExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1__Impl"
    // InternalArithmetics.g:1867:1: rule__PrimaryExpression__Group_1__1__Impl : ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1871:1: ( ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) ) )
            // InternalArithmetics.g:1872:1: ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) )
            {
            // InternalArithmetics.g:1872:1: ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) )
            // InternalArithmetics.g:1873:1: ( rule__PrimaryExpression__ValueAssignment_1_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_1_1()); 
            // InternalArithmetics.g:1874:1: ( rule__PrimaryExpression__ValueAssignment_1_1 )
            // InternalArithmetics.g:1874:2: rule__PrimaryExpression__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__ValueAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__PrimaryExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2__0"
    // InternalArithmetics.g:1888:1: rule__PrimaryExpression__Group_2__0 : rule__PrimaryExpression__Group_2__0__Impl rule__PrimaryExpression__Group_2__1 ;
    public final void rule__PrimaryExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1892:1: ( rule__PrimaryExpression__Group_2__0__Impl rule__PrimaryExpression__Group_2__1 )
            // InternalArithmetics.g:1893:2: rule__PrimaryExpression__Group_2__0__Impl rule__PrimaryExpression__Group_2__1
            {
            pushFollow(FOLLOW_10);
            rule__PrimaryExpression__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2__0"


    // $ANTLR start "rule__PrimaryExpression__Group_2__0__Impl"
    // InternalArithmetics.g:1900:1: rule__PrimaryExpression__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1904:1: ( ( () ) )
            // InternalArithmetics.g:1905:1: ( () )
            {
            // InternalArithmetics.g:1905:1: ( () )
            // InternalArithmetics.g:1906:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0()); 
            // InternalArithmetics.g:1907:1: ()
            // InternalArithmetics.g:1909:1: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2__1"
    // InternalArithmetics.g:1919:1: rule__PrimaryExpression__Group_2__1 : rule__PrimaryExpression__Group_2__1__Impl rule__PrimaryExpression__Group_2__2 ;
    public final void rule__PrimaryExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1923:1: ( rule__PrimaryExpression__Group_2__1__Impl rule__PrimaryExpression__Group_2__2 )
            // InternalArithmetics.g:1924:2: rule__PrimaryExpression__Group_2__1__Impl rule__PrimaryExpression__Group_2__2
            {
            pushFollow(FOLLOW_21);
            rule__PrimaryExpression__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2__1"


    // $ANTLR start "rule__PrimaryExpression__Group_2__1__Impl"
    // InternalArithmetics.g:1931:1: rule__PrimaryExpression__Group_2__1__Impl : ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) ) ;
    public final void rule__PrimaryExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1935:1: ( ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) ) )
            // InternalArithmetics.g:1936:1: ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) )
            {
            // InternalArithmetics.g:1936:1: ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) )
            // InternalArithmetics.g:1937:1: ( rule__PrimaryExpression__FuncAssignment_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAssignment_2_1()); 
            // InternalArithmetics.g:1938:1: ( rule__PrimaryExpression__FuncAssignment_2_1 )
            // InternalArithmetics.g:1938:2: rule__PrimaryExpression__FuncAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__FuncAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getFuncAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2__2"
    // InternalArithmetics.g:1948:1: rule__PrimaryExpression__Group_2__2 : rule__PrimaryExpression__Group_2__2__Impl ;
    public final void rule__PrimaryExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1952:1: ( rule__PrimaryExpression__Group_2__2__Impl )
            // InternalArithmetics.g:1953:2: rule__PrimaryExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2__2"


    // $ANTLR start "rule__PrimaryExpression__Group_2__2__Impl"
    // InternalArithmetics.g:1959:1: rule__PrimaryExpression__Group_2__2__Impl : ( ( rule__PrimaryExpression__Group_2_2__0 )? ) ;
    public final void rule__PrimaryExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1963:1: ( ( ( rule__PrimaryExpression__Group_2_2__0 )? ) )
            // InternalArithmetics.g:1964:1: ( ( rule__PrimaryExpression__Group_2_2__0 )? )
            {
            // InternalArithmetics.g:1964:1: ( ( rule__PrimaryExpression__Group_2_2__0 )? )
            // InternalArithmetics.g:1965:1: ( rule__PrimaryExpression__Group_2_2__0 )?
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2()); 
            // InternalArithmetics.g:1966:1: ( rule__PrimaryExpression__Group_2_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalArithmetics.g:1966:2: rule__PrimaryExpression__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_2_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__PrimaryExpression__Group_2__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__0"
    // InternalArithmetics.g:1982:1: rule__PrimaryExpression__Group_2_2__0 : rule__PrimaryExpression__Group_2_2__0__Impl rule__PrimaryExpression__Group_2_2__1 ;
    public final void rule__PrimaryExpression__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1986:1: ( rule__PrimaryExpression__Group_2_2__0__Impl rule__PrimaryExpression__Group_2_2__1 )
            // InternalArithmetics.g:1987:2: rule__PrimaryExpression__Group_2_2__0__Impl rule__PrimaryExpression__Group_2_2__1
            {
            pushFollow(FOLLOW_10);
            rule__PrimaryExpression__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__0"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__0__Impl"
    // InternalArithmetics.g:1994:1: rule__PrimaryExpression__Group_2_2__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:1998:1: ( ( '(' ) )
            // InternalArithmetics.g:1999:1: ( '(' )
            {
            // InternalArithmetics.g:1999:1: ( '(' )
            // InternalArithmetics.g:2000:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__1"
    // InternalArithmetics.g:2013:1: rule__PrimaryExpression__Group_2_2__1 : rule__PrimaryExpression__Group_2_2__1__Impl rule__PrimaryExpression__Group_2_2__2 ;
    public final void rule__PrimaryExpression__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2017:1: ( rule__PrimaryExpression__Group_2_2__1__Impl rule__PrimaryExpression__Group_2_2__2 )
            // InternalArithmetics.g:2018:2: rule__PrimaryExpression__Group_2_2__1__Impl rule__PrimaryExpression__Group_2_2__2
            {
            pushFollow(FOLLOW_12);
            rule__PrimaryExpression__Group_2_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__1"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__1__Impl"
    // InternalArithmetics.g:2025:1: rule__PrimaryExpression__Group_2_2__1__Impl : ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) ) ;
    public final void rule__PrimaryExpression__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2029:1: ( ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) ) )
            // InternalArithmetics.g:2030:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) )
            {
            // InternalArithmetics.g:2030:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) )
            // InternalArithmetics.g:2031:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_1()); 
            // InternalArithmetics.g:2032:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_1 )
            // InternalArithmetics.g:2032:2: rule__PrimaryExpression__ArgsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__ArgsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__2"
    // InternalArithmetics.g:2042:1: rule__PrimaryExpression__Group_2_2__2 : rule__PrimaryExpression__Group_2_2__2__Impl rule__PrimaryExpression__Group_2_2__3 ;
    public final void rule__PrimaryExpression__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2046:1: ( rule__PrimaryExpression__Group_2_2__2__Impl rule__PrimaryExpression__Group_2_2__3 )
            // InternalArithmetics.g:2047:2: rule__PrimaryExpression__Group_2_2__2__Impl rule__PrimaryExpression__Group_2_2__3
            {
            pushFollow(FOLLOW_12);
            rule__PrimaryExpression__Group_2_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__2"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__2__Impl"
    // InternalArithmetics.g:2054:1: rule__PrimaryExpression__Group_2_2__2__Impl : ( ( rule__PrimaryExpression__Group_2_2_2__0 )* ) ;
    public final void rule__PrimaryExpression__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2058:1: ( ( ( rule__PrimaryExpression__Group_2_2_2__0 )* ) )
            // InternalArithmetics.g:2059:1: ( ( rule__PrimaryExpression__Group_2_2_2__0 )* )
            {
            // InternalArithmetics.g:2059:1: ( ( rule__PrimaryExpression__Group_2_2_2__0 )* )
            // InternalArithmetics.g:2060:1: ( rule__PrimaryExpression__Group_2_2_2__0 )*
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2_2()); 
            // InternalArithmetics.g:2061:1: ( rule__PrimaryExpression__Group_2_2_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==21) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalArithmetics.g:2061:2: rule__PrimaryExpression__Group_2_2_2__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__PrimaryExpression__Group_2_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__3"
    // InternalArithmetics.g:2071:1: rule__PrimaryExpression__Group_2_2__3 : rule__PrimaryExpression__Group_2_2__3__Impl ;
    public final void rule__PrimaryExpression__Group_2_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2075:1: ( rule__PrimaryExpression__Group_2_2__3__Impl )
            // InternalArithmetics.g:2076:2: rule__PrimaryExpression__Group_2_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__3"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2__3__Impl"
    // InternalArithmetics.g:2082:1: rule__PrimaryExpression__Group_2_2__3__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_2_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2086:1: ( ( ')' ) )
            // InternalArithmetics.g:2087:1: ( ')' )
            {
            // InternalArithmetics.g:2087:1: ( ')' )
            // InternalArithmetics.g:2088:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2_3()); 
            match(input,20,FOLLOW_2); 
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
    // $ANTLR end "rule__PrimaryExpression__Group_2_2__3__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2_2__0"
    // InternalArithmetics.g:2109:1: rule__PrimaryExpression__Group_2_2_2__0 : rule__PrimaryExpression__Group_2_2_2__0__Impl rule__PrimaryExpression__Group_2_2_2__1 ;
    public final void rule__PrimaryExpression__Group_2_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2113:1: ( rule__PrimaryExpression__Group_2_2_2__0__Impl rule__PrimaryExpression__Group_2_2_2__1 )
            // InternalArithmetics.g:2114:2: rule__PrimaryExpression__Group_2_2_2__0__Impl rule__PrimaryExpression__Group_2_2_2__1
            {
            pushFollow(FOLLOW_10);
            rule__PrimaryExpression__Group_2_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2_2__0"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2_2__0__Impl"
    // InternalArithmetics.g:2121:1: rule__PrimaryExpression__Group_2_2_2__0__Impl : ( ',' ) ;
    public final void rule__PrimaryExpression__Group_2_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2125:1: ( ( ',' ) )
            // InternalArithmetics.g:2126:1: ( ',' )
            {
            // InternalArithmetics.g:2126:1: ( ',' )
            // InternalArithmetics.g:2127:1: ','
            {
             before(grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_2_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2_2__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2_2__1"
    // InternalArithmetics.g:2140:1: rule__PrimaryExpression__Group_2_2_2__1 : rule__PrimaryExpression__Group_2_2_2__1__Impl ;
    public final void rule__PrimaryExpression__Group_2_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2144:1: ( rule__PrimaryExpression__Group_2_2_2__1__Impl )
            // InternalArithmetics.g:2145:2: rule__PrimaryExpression__Group_2_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_2_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_2_2_2__1"


    // $ANTLR start "rule__PrimaryExpression__Group_2_2_2__1__Impl"
    // InternalArithmetics.g:2151:1: rule__PrimaryExpression__Group_2_2_2__1__Impl : ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) ) ;
    public final void rule__PrimaryExpression__Group_2_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2155:1: ( ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) ) )
            // InternalArithmetics.g:2156:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) )
            {
            // InternalArithmetics.g:2156:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) )
            // InternalArithmetics.g:2157:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_2_1()); 
            // InternalArithmetics.g:2158:1: ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 )
            // InternalArithmetics.g:2158:2: rule__PrimaryExpression__ArgsAssignment_2_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__ArgsAssignment_2_2_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__PrimaryExpression__Group_2_2_2__1__Impl"


    // $ANTLR start "rule__Module__NameAssignment_1"
    // InternalArithmetics.g:2173:1: rule__Module__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Module__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2177:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:2178:1: ( RULE_ID )
            {
            // InternalArithmetics.g:2178:1: ( RULE_ID )
            // InternalArithmetics.g:2179:1: RULE_ID
            {
             before(grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // $ANTLR end "rule__Module__NameAssignment_1"


    // $ANTLR start "rule__Module__ImportsAssignment_2"
    // InternalArithmetics.g:2188:1: rule__Module__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__Module__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2192:1: ( ( ruleImport ) )
            // InternalArithmetics.g:2193:1: ( ruleImport )
            {
            // InternalArithmetics.g:2193:1: ( ruleImport )
            // InternalArithmetics.g:2194:1: ruleImport
            {
             before(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

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
    // $ANTLR end "rule__Module__ImportsAssignment_2"


    // $ANTLR start "rule__Module__StatementsAssignment_3"
    // InternalArithmetics.g:2203:1: rule__Module__StatementsAssignment_3 : ( ruleStatement ) ;
    public final void rule__Module__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2207:1: ( ( ruleStatement ) )
            // InternalArithmetics.g:2208:1: ( ruleStatement )
            {
            // InternalArithmetics.g:2208:1: ( ruleStatement )
            // InternalArithmetics.g:2209:1: ruleStatement
            {
             before(grammarAccess.getModuleAccess().getStatementsStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

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
    // $ANTLR end "rule__Module__StatementsAssignment_3"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalArithmetics.g:2218:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleImportName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2222:1: ( ( ruleImportName ) )
            // InternalArithmetics.g:2223:1: ( ruleImportName )
            {
            // InternalArithmetics.g:2223:1: ( ruleImportName )
            // InternalArithmetics.g:2224:1: ruleImportName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceImportNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImportName();

            state._fsp--;

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
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Definition__NameAssignment_1"
    // InternalArithmetics.g:2233:1: rule__Definition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2237:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:2238:1: ( RULE_ID )
            {
            // InternalArithmetics.g:2238:1: ( RULE_ID )
            // InternalArithmetics.g:2239:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // $ANTLR end "rule__Definition__NameAssignment_1"


    // $ANTLR start "rule__Definition__ArgsAssignment_2_1"
    // InternalArithmetics.g:2248:1: rule__Definition__ArgsAssignment_2_1 : ( ruleDeclaredParameter ) ;
    public final void rule__Definition__ArgsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2252:1: ( ( ruleDeclaredParameter ) )
            // InternalArithmetics.g:2253:1: ( ruleDeclaredParameter )
            {
            // InternalArithmetics.g:2253:1: ( ruleDeclaredParameter )
            // InternalArithmetics.g:2254:1: ruleDeclaredParameter
            {
             before(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclaredParameter();

            state._fsp--;

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
    // $ANTLR end "rule__Definition__ArgsAssignment_2_1"


    // $ANTLR start "rule__Definition__ArgsAssignment_2_2_1"
    // InternalArithmetics.g:2263:1: rule__Definition__ArgsAssignment_2_2_1 : ( ruleDeclaredParameter ) ;
    public final void rule__Definition__ArgsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2267:1: ( ( ruleDeclaredParameter ) )
            // InternalArithmetics.g:2268:1: ( ruleDeclaredParameter )
            {
            // InternalArithmetics.g:2268:1: ( ruleDeclaredParameter )
            // InternalArithmetics.g:2269:1: ruleDeclaredParameter
            {
             before(grammarAccess.getDefinitionAccess().getArgsDeclaredParameterParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclaredParameter();

            state._fsp--;

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
    // $ANTLR end "rule__Definition__ArgsAssignment_2_2_1"


    // $ANTLR start "rule__Definition__ExprAssignment_4"
    // InternalArithmetics.g:2278:1: rule__Definition__ExprAssignment_4 : ( ruleExpression ) ;
    public final void rule__Definition__ExprAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2282:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:2283:1: ( ruleExpression )
            {
            // InternalArithmetics.g:2283:1: ( ruleExpression )
            // InternalArithmetics.g:2284:1: ruleExpression
            {
             before(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__Definition__ExprAssignment_4"


    // $ANTLR start "rule__DeclaredParameter__NameAssignment"
    // InternalArithmetics.g:2293:1: rule__DeclaredParameter__NameAssignment : ( RULE_ID ) ;
    public final void rule__DeclaredParameter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2297:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:2298:1: ( RULE_ID )
            {
            // InternalArithmetics.g:2298:1: ( RULE_ID )
            // InternalArithmetics.g:2299:1: RULE_ID
            {
             before(grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // $ANTLR end "rule__DeclaredParameter__NameAssignment"


    // $ANTLR start "rule__Evaluation__ExpressionAssignment_0"
    // InternalArithmetics.g:2308:1: rule__Evaluation__ExpressionAssignment_0 : ( ruleExpression ) ;
    public final void rule__Evaluation__ExpressionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2312:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:2313:1: ( ruleExpression )
            {
            // InternalArithmetics.g:2313:1: ( ruleExpression )
            // InternalArithmetics.g:2314:1: ruleExpression
            {
             before(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__Evaluation__ExpressionAssignment_0"


    // $ANTLR start "rule__Addition__RightAssignment_1_1"
    // InternalArithmetics.g:2323:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2327:1: ( ( ruleMultiplication ) )
            // InternalArithmetics.g:2328:1: ( ruleMultiplication )
            {
            // InternalArithmetics.g:2328:1: ( ruleMultiplication )
            // InternalArithmetics.g:2329:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiplication();

            state._fsp--;

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
    // $ANTLR end "rule__Addition__RightAssignment_1_1"


    // $ANTLR start "rule__Multiplication__RightAssignment_1_1"
    // InternalArithmetics.g:2338:1: rule__Multiplication__RightAssignment_1_1 : ( rulePrimaryExpression ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2342:1: ( ( rulePrimaryExpression ) )
            // InternalArithmetics.g:2343:1: ( rulePrimaryExpression )
            {
            // InternalArithmetics.g:2343:1: ( rulePrimaryExpression )
            // InternalArithmetics.g:2344:1: rulePrimaryExpression
            {
             before(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryExpression();

            state._fsp--;

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
    // $ANTLR end "rule__Multiplication__RightAssignment_1_1"


    // $ANTLR start "rule__PrimaryExpression__ValueAssignment_1_1"
    // InternalArithmetics.g:2353:1: rule__PrimaryExpression__ValueAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__PrimaryExpression__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2357:1: ( ( RULE_NUMBER ) )
            // InternalArithmetics.g:2358:1: ( RULE_NUMBER )
            {
            // InternalArithmetics.g:2358:1: ( RULE_NUMBER )
            // InternalArithmetics.g:2359:1: RULE_NUMBER
            {
             before(grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_2); 
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
    // $ANTLR end "rule__PrimaryExpression__ValueAssignment_1_1"


    // $ANTLR start "rule__PrimaryExpression__FuncAssignment_2_1"
    // InternalArithmetics.g:2368:1: rule__PrimaryExpression__FuncAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__PrimaryExpression__FuncAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2372:1: ( ( ( RULE_ID ) ) )
            // InternalArithmetics.g:2373:1: ( ( RULE_ID ) )
            {
            // InternalArithmetics.g:2373:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:2374:1: ( RULE_ID )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionCrossReference_2_1_0()); 
            // InternalArithmetics.g:2375:1: ( RULE_ID )
            // InternalArithmetics.g:2376:1: RULE_ID
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
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
    // $ANTLR end "rule__PrimaryExpression__FuncAssignment_2_1"


    // $ANTLR start "rule__PrimaryExpression__ArgsAssignment_2_2_1"
    // InternalArithmetics.g:2387:1: rule__PrimaryExpression__ArgsAssignment_2_2_1 : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__ArgsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2391:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:2392:1: ( ruleExpression )
            {
            // InternalArithmetics.g:2392:1: ( ruleExpression )
            // InternalArithmetics.g:2393:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__PrimaryExpression__ArgsAssignment_2_2_1"


    // $ANTLR start "rule__PrimaryExpression__ArgsAssignment_2_2_2_1"
    // InternalArithmetics.g:2402:1: rule__PrimaryExpression__ArgsAssignment_2_2_2_1 : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__ArgsAssignment_2_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalArithmetics.g:2406:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:2407:1: ( ruleExpression )
            {
            // InternalArithmetics.g:2407:1: ( ruleExpression )
            // InternalArithmetics.g:2408:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsExpressionParserRuleCall_2_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__PrimaryExpression__ArgsAssignment_2_2_2_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000092030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000090032L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000090030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001008002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000080000L});

}