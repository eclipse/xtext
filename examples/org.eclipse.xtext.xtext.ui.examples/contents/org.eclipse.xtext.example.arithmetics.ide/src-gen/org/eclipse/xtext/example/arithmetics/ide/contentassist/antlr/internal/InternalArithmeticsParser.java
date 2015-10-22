package org.eclipse.xtext.example.arithmetics.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArithmeticsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NUMBER", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'import'", "'def'", "':'", "';'", "'('", "')'", "','", "'+'", "'-'", "'*'", "'/'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_NUMBER=5;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // InternalArithmetics.g:52:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // InternalArithmetics.g:53:1: ( ruleModule EOF )
            // InternalArithmetics.g:54:1: ruleModule EOF
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
    // InternalArithmetics.g:61:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:65:2: ( ( ( rule__Module__Group__0 ) ) )
            // InternalArithmetics.g:66:2: ( ( rule__Module__Group__0 ) )
            {
            // InternalArithmetics.g:66:2: ( ( rule__Module__Group__0 ) )
            // InternalArithmetics.g:67:3: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // InternalArithmetics.g:68:3: ( rule__Module__Group__0 )
            // InternalArithmetics.g:68:4: rule__Module__Group__0
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
    // InternalArithmetics.g:77:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalArithmetics.g:78:1: ( ruleImport EOF )
            // InternalArithmetics.g:79:1: ruleImport EOF
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
    // InternalArithmetics.g:86:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:90:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalArithmetics.g:91:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalArithmetics.g:91:2: ( ( rule__Import__Group__0 ) )
            // InternalArithmetics.g:92:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalArithmetics.g:93:3: ( rule__Import__Group__0 )
            // InternalArithmetics.g:93:4: rule__Import__Group__0
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


    // $ANTLR start "entryRuleStatement"
    // InternalArithmetics.g:102:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalArithmetics.g:103:1: ( ruleStatement EOF )
            // InternalArithmetics.g:104:1: ruleStatement EOF
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
    // InternalArithmetics.g:111:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:115:2: ( ( ( rule__Statement__Alternatives ) ) )
            // InternalArithmetics.g:116:2: ( ( rule__Statement__Alternatives ) )
            {
            // InternalArithmetics.g:116:2: ( ( rule__Statement__Alternatives ) )
            // InternalArithmetics.g:117:3: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // InternalArithmetics.g:118:3: ( rule__Statement__Alternatives )
            // InternalArithmetics.g:118:4: rule__Statement__Alternatives
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
    // InternalArithmetics.g:127:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // InternalArithmetics.g:128:1: ( ruleDefinition EOF )
            // InternalArithmetics.g:129:1: ruleDefinition EOF
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
    // InternalArithmetics.g:136:1: ruleDefinition : ( ( rule__Definition__Group__0 ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:140:2: ( ( ( rule__Definition__Group__0 ) ) )
            // InternalArithmetics.g:141:2: ( ( rule__Definition__Group__0 ) )
            {
            // InternalArithmetics.g:141:2: ( ( rule__Definition__Group__0 ) )
            // InternalArithmetics.g:142:3: ( rule__Definition__Group__0 )
            {
             before(grammarAccess.getDefinitionAccess().getGroup()); 
            // InternalArithmetics.g:143:3: ( rule__Definition__Group__0 )
            // InternalArithmetics.g:143:4: rule__Definition__Group__0
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
    // InternalArithmetics.g:152:1: entryRuleDeclaredParameter : ruleDeclaredParameter EOF ;
    public final void entryRuleDeclaredParameter() throws RecognitionException {
        try {
            // InternalArithmetics.g:153:1: ( ruleDeclaredParameter EOF )
            // InternalArithmetics.g:154:1: ruleDeclaredParameter EOF
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
    // InternalArithmetics.g:161:1: ruleDeclaredParameter : ( ( rule__DeclaredParameter__NameAssignment ) ) ;
    public final void ruleDeclaredParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:165:2: ( ( ( rule__DeclaredParameter__NameAssignment ) ) )
            // InternalArithmetics.g:166:2: ( ( rule__DeclaredParameter__NameAssignment ) )
            {
            // InternalArithmetics.g:166:2: ( ( rule__DeclaredParameter__NameAssignment ) )
            // InternalArithmetics.g:167:3: ( rule__DeclaredParameter__NameAssignment )
            {
             before(grammarAccess.getDeclaredParameterAccess().getNameAssignment()); 
            // InternalArithmetics.g:168:3: ( rule__DeclaredParameter__NameAssignment )
            // InternalArithmetics.g:168:4: rule__DeclaredParameter__NameAssignment
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
    // InternalArithmetics.g:177:1: entryRuleEvaluation : ruleEvaluation EOF ;
    public final void entryRuleEvaluation() throws RecognitionException {
        try {
            // InternalArithmetics.g:178:1: ( ruleEvaluation EOF )
            // InternalArithmetics.g:179:1: ruleEvaluation EOF
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
    // InternalArithmetics.g:186:1: ruleEvaluation : ( ( rule__Evaluation__Group__0 ) ) ;
    public final void ruleEvaluation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:190:2: ( ( ( rule__Evaluation__Group__0 ) ) )
            // InternalArithmetics.g:191:2: ( ( rule__Evaluation__Group__0 ) )
            {
            // InternalArithmetics.g:191:2: ( ( rule__Evaluation__Group__0 ) )
            // InternalArithmetics.g:192:3: ( rule__Evaluation__Group__0 )
            {
             before(grammarAccess.getEvaluationAccess().getGroup()); 
            // InternalArithmetics.g:193:3: ( rule__Evaluation__Group__0 )
            // InternalArithmetics.g:193:4: rule__Evaluation__Group__0
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
    // InternalArithmetics.g:202:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalArithmetics.g:203:1: ( ruleExpression EOF )
            // InternalArithmetics.g:204:1: ruleExpression EOF
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
    // InternalArithmetics.g:211:1: ruleExpression : ( ruleAddition ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:215:2: ( ( ruleAddition ) )
            // InternalArithmetics.g:216:2: ( ruleAddition )
            {
            // InternalArithmetics.g:216:2: ( ruleAddition )
            // InternalArithmetics.g:217:3: ruleAddition
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
    // InternalArithmetics.g:227:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // InternalArithmetics.g:228:1: ( ruleAddition EOF )
            // InternalArithmetics.g:229:1: ruleAddition EOF
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
    // InternalArithmetics.g:236:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:240:2: ( ( ( rule__Addition__Group__0 ) ) )
            // InternalArithmetics.g:241:2: ( ( rule__Addition__Group__0 ) )
            {
            // InternalArithmetics.g:241:2: ( ( rule__Addition__Group__0 ) )
            // InternalArithmetics.g:242:3: ( rule__Addition__Group__0 )
            {
             before(grammarAccess.getAdditionAccess().getGroup()); 
            // InternalArithmetics.g:243:3: ( rule__Addition__Group__0 )
            // InternalArithmetics.g:243:4: rule__Addition__Group__0
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
    // InternalArithmetics.g:252:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // InternalArithmetics.g:253:1: ( ruleMultiplication EOF )
            // InternalArithmetics.g:254:1: ruleMultiplication EOF
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
    // InternalArithmetics.g:261:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:265:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // InternalArithmetics.g:266:2: ( ( rule__Multiplication__Group__0 ) )
            {
            // InternalArithmetics.g:266:2: ( ( rule__Multiplication__Group__0 ) )
            // InternalArithmetics.g:267:3: ( rule__Multiplication__Group__0 )
            {
             before(grammarAccess.getMultiplicationAccess().getGroup()); 
            // InternalArithmetics.g:268:3: ( rule__Multiplication__Group__0 )
            // InternalArithmetics.g:268:4: rule__Multiplication__Group__0
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
    // InternalArithmetics.g:277:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // InternalArithmetics.g:278:1: ( rulePrimaryExpression EOF )
            // InternalArithmetics.g:279:1: rulePrimaryExpression EOF
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
    // InternalArithmetics.g:286:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:290:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // InternalArithmetics.g:291:2: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // InternalArithmetics.g:291:2: ( ( rule__PrimaryExpression__Alternatives ) )
            // InternalArithmetics.g:292:3: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // InternalArithmetics.g:293:3: ( rule__PrimaryExpression__Alternatives )
            // InternalArithmetics.g:293:4: rule__PrimaryExpression__Alternatives
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
    // InternalArithmetics.g:301:1: rule__Statement__Alternatives : ( ( ruleDefinition ) | ( ruleEvaluation ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:305:1: ( ( ruleDefinition ) | ( ruleEvaluation ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_NUMBER)||LA1_0==17) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalArithmetics.g:306:2: ( ruleDefinition )
                    {
                    // InternalArithmetics.g:306:2: ( ruleDefinition )
                    // InternalArithmetics.g:307:3: ruleDefinition
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
                    // InternalArithmetics.g:312:2: ( ruleEvaluation )
                    {
                    // InternalArithmetics.g:312:2: ( ruleEvaluation )
                    // InternalArithmetics.g:313:3: ruleEvaluation
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
    // InternalArithmetics.g:322:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:326:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            else if ( (LA2_0==21) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalArithmetics.g:327:2: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // InternalArithmetics.g:327:2: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // InternalArithmetics.g:328:3: ( rule__Addition__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    // InternalArithmetics.g:329:3: ( rule__Addition__Group_1_0_0__0 )
                    // InternalArithmetics.g:329:4: rule__Addition__Group_1_0_0__0
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
                    // InternalArithmetics.g:333:2: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // InternalArithmetics.g:333:2: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // InternalArithmetics.g:334:3: ( rule__Addition__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    // InternalArithmetics.g:335:3: ( rule__Addition__Group_1_0_1__0 )
                    // InternalArithmetics.g:335:4: rule__Addition__Group_1_0_1__0
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
    // InternalArithmetics.g:343:1: rule__Multiplication__Alternatives_1_0 : ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) );
    public final void rule__Multiplication__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:347:1: ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==22) ) {
                alt3=1;
            }
            else if ( (LA3_0==23) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalArithmetics.g:348:2: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    {
                    // InternalArithmetics.g:348:2: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    // InternalArithmetics.g:349:3: ( rule__Multiplication__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 
                    // InternalArithmetics.g:350:3: ( rule__Multiplication__Group_1_0_0__0 )
                    // InternalArithmetics.g:350:4: rule__Multiplication__Group_1_0_0__0
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
                    // InternalArithmetics.g:354:2: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    {
                    // InternalArithmetics.g:354:2: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    // InternalArithmetics.g:355:3: ( rule__Multiplication__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 
                    // InternalArithmetics.g:356:3: ( rule__Multiplication__Group_1_0_1__0 )
                    // InternalArithmetics.g:356:4: rule__Multiplication__Group_1_0_1__0
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
    // InternalArithmetics.g:364:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ( rule__PrimaryExpression__Group_2__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:368:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ( rule__PrimaryExpression__Group_2__0 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 17:
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
                    // InternalArithmetics.g:369:2: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // InternalArithmetics.g:369:2: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // InternalArithmetics.g:370:3: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // InternalArithmetics.g:371:3: ( rule__PrimaryExpression__Group_0__0 )
                    // InternalArithmetics.g:371:4: rule__PrimaryExpression__Group_0__0
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
                    // InternalArithmetics.g:375:2: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // InternalArithmetics.g:375:2: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // InternalArithmetics.g:376:3: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // InternalArithmetics.g:377:3: ( rule__PrimaryExpression__Group_1__0 )
                    // InternalArithmetics.g:377:4: rule__PrimaryExpression__Group_1__0
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
                    // InternalArithmetics.g:381:2: ( ( rule__PrimaryExpression__Group_2__0 ) )
                    {
                    // InternalArithmetics.g:381:2: ( ( rule__PrimaryExpression__Group_2__0 ) )
                    // InternalArithmetics.g:382:3: ( rule__PrimaryExpression__Group_2__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_2()); 
                    // InternalArithmetics.g:383:3: ( rule__PrimaryExpression__Group_2__0 )
                    // InternalArithmetics.g:383:4: rule__PrimaryExpression__Group_2__0
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
    // InternalArithmetics.g:391:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:395:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // InternalArithmetics.g:396:2: rule__Module__Group__0__Impl rule__Module__Group__1
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
    // InternalArithmetics.g:403:1: rule__Module__Group__0__Impl : ( 'module' ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:407:1: ( ( 'module' ) )
            // InternalArithmetics.g:408:1: ( 'module' )
            {
            // InternalArithmetics.g:408:1: ( 'module' )
            // InternalArithmetics.g:409:2: 'module'
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
    // InternalArithmetics.g:418:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:422:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // InternalArithmetics.g:423:2: rule__Module__Group__1__Impl rule__Module__Group__2
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
    // InternalArithmetics.g:430:1: rule__Module__Group__1__Impl : ( ( rule__Module__NameAssignment_1 ) ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:434:1: ( ( ( rule__Module__NameAssignment_1 ) ) )
            // InternalArithmetics.g:435:1: ( ( rule__Module__NameAssignment_1 ) )
            {
            // InternalArithmetics.g:435:1: ( ( rule__Module__NameAssignment_1 ) )
            // InternalArithmetics.g:436:2: ( rule__Module__NameAssignment_1 )
            {
             before(grammarAccess.getModuleAccess().getNameAssignment_1()); 
            // InternalArithmetics.g:437:2: ( rule__Module__NameAssignment_1 )
            // InternalArithmetics.g:437:3: rule__Module__NameAssignment_1
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
    // InternalArithmetics.g:445:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:449:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // InternalArithmetics.g:450:2: rule__Module__Group__2__Impl rule__Module__Group__3
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
    // InternalArithmetics.g:457:1: rule__Module__Group__2__Impl : ( ( rule__Module__ImportsAssignment_2 )* ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:461:1: ( ( ( rule__Module__ImportsAssignment_2 )* ) )
            // InternalArithmetics.g:462:1: ( ( rule__Module__ImportsAssignment_2 )* )
            {
            // InternalArithmetics.g:462:1: ( ( rule__Module__ImportsAssignment_2 )* )
            // InternalArithmetics.g:463:2: ( rule__Module__ImportsAssignment_2 )*
            {
             before(grammarAccess.getModuleAccess().getImportsAssignment_2()); 
            // InternalArithmetics.g:464:2: ( rule__Module__ImportsAssignment_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalArithmetics.g:464:3: rule__Module__ImportsAssignment_2
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
    // InternalArithmetics.g:472:1: rule__Module__Group__3 : rule__Module__Group__3__Impl ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:476:1: ( rule__Module__Group__3__Impl )
            // InternalArithmetics.g:477:2: rule__Module__Group__3__Impl
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
    // InternalArithmetics.g:483:1: rule__Module__Group__3__Impl : ( ( rule__Module__StatementsAssignment_3 )* ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:487:1: ( ( ( rule__Module__StatementsAssignment_3 )* ) )
            // InternalArithmetics.g:488:1: ( ( rule__Module__StatementsAssignment_3 )* )
            {
            // InternalArithmetics.g:488:1: ( ( rule__Module__StatementsAssignment_3 )* )
            // InternalArithmetics.g:489:2: ( rule__Module__StatementsAssignment_3 )*
            {
             before(grammarAccess.getModuleAccess().getStatementsAssignment_3()); 
            // InternalArithmetics.g:490:2: ( rule__Module__StatementsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_NUMBER)||LA6_0==14||LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalArithmetics.g:490:3: rule__Module__StatementsAssignment_3
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
    // InternalArithmetics.g:499:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:503:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalArithmetics.g:504:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalArithmetics.g:511:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:515:1: ( ( 'import' ) )
            // InternalArithmetics.g:516:1: ( 'import' )
            {
            // InternalArithmetics.g:516:1: ( 'import' )
            // InternalArithmetics.g:517:2: 'import'
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
    // InternalArithmetics.g:526:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:530:1: ( rule__Import__Group__1__Impl )
            // InternalArithmetics.g:531:2: rule__Import__Group__1__Impl
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
    // InternalArithmetics.g:537:1: rule__Import__Group__1__Impl : ( ( rule__Import__ModuleAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:541:1: ( ( ( rule__Import__ModuleAssignment_1 ) ) )
            // InternalArithmetics.g:542:1: ( ( rule__Import__ModuleAssignment_1 ) )
            {
            // InternalArithmetics.g:542:1: ( ( rule__Import__ModuleAssignment_1 ) )
            // InternalArithmetics.g:543:2: ( rule__Import__ModuleAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getModuleAssignment_1()); 
            // InternalArithmetics.g:544:2: ( rule__Import__ModuleAssignment_1 )
            // InternalArithmetics.g:544:3: rule__Import__ModuleAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ModuleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getModuleAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Definition__Group__0"
    // InternalArithmetics.g:553:1: rule__Definition__Group__0 : rule__Definition__Group__0__Impl rule__Definition__Group__1 ;
    public final void rule__Definition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:557:1: ( rule__Definition__Group__0__Impl rule__Definition__Group__1 )
            // InternalArithmetics.g:558:2: rule__Definition__Group__0__Impl rule__Definition__Group__1
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
    // InternalArithmetics.g:565:1: rule__Definition__Group__0__Impl : ( 'def' ) ;
    public final void rule__Definition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:569:1: ( ( 'def' ) )
            // InternalArithmetics.g:570:1: ( 'def' )
            {
            // InternalArithmetics.g:570:1: ( 'def' )
            // InternalArithmetics.g:571:2: 'def'
            {
             before(grammarAccess.getDefinitionAccess().getDefKeyword_0()); 
            match(input,14,FOLLOW_2); 
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
    // InternalArithmetics.g:580:1: rule__Definition__Group__1 : rule__Definition__Group__1__Impl rule__Definition__Group__2 ;
    public final void rule__Definition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:584:1: ( rule__Definition__Group__1__Impl rule__Definition__Group__2 )
            // InternalArithmetics.g:585:2: rule__Definition__Group__1__Impl rule__Definition__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalArithmetics.g:592:1: rule__Definition__Group__1__Impl : ( ( rule__Definition__NameAssignment_1 ) ) ;
    public final void rule__Definition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:596:1: ( ( ( rule__Definition__NameAssignment_1 ) ) )
            // InternalArithmetics.g:597:1: ( ( rule__Definition__NameAssignment_1 ) )
            {
            // InternalArithmetics.g:597:1: ( ( rule__Definition__NameAssignment_1 ) )
            // InternalArithmetics.g:598:2: ( rule__Definition__NameAssignment_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1()); 
            // InternalArithmetics.g:599:2: ( rule__Definition__NameAssignment_1 )
            // InternalArithmetics.g:599:3: rule__Definition__NameAssignment_1
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
    // InternalArithmetics.g:607:1: rule__Definition__Group__2 : rule__Definition__Group__2__Impl rule__Definition__Group__3 ;
    public final void rule__Definition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:611:1: ( rule__Definition__Group__2__Impl rule__Definition__Group__3 )
            // InternalArithmetics.g:612:2: rule__Definition__Group__2__Impl rule__Definition__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalArithmetics.g:619:1: rule__Definition__Group__2__Impl : ( ( rule__Definition__Group_2__0 )? ) ;
    public final void rule__Definition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:623:1: ( ( ( rule__Definition__Group_2__0 )? ) )
            // InternalArithmetics.g:624:1: ( ( rule__Definition__Group_2__0 )? )
            {
            // InternalArithmetics.g:624:1: ( ( rule__Definition__Group_2__0 )? )
            // InternalArithmetics.g:625:2: ( rule__Definition__Group_2__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_2()); 
            // InternalArithmetics.g:626:2: ( rule__Definition__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalArithmetics.g:626:3: rule__Definition__Group_2__0
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
    // InternalArithmetics.g:634:1: rule__Definition__Group__3 : rule__Definition__Group__3__Impl rule__Definition__Group__4 ;
    public final void rule__Definition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:638:1: ( rule__Definition__Group__3__Impl rule__Definition__Group__4 )
            // InternalArithmetics.g:639:2: rule__Definition__Group__3__Impl rule__Definition__Group__4
            {
            pushFollow(FOLLOW_8);
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
    // InternalArithmetics.g:646:1: rule__Definition__Group__3__Impl : ( ':' ) ;
    public final void rule__Definition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:650:1: ( ( ':' ) )
            // InternalArithmetics.g:651:1: ( ':' )
            {
            // InternalArithmetics.g:651:1: ( ':' )
            // InternalArithmetics.g:652:2: ':'
            {
             before(grammarAccess.getDefinitionAccess().getColonKeyword_3()); 
            match(input,15,FOLLOW_2); 
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
    // InternalArithmetics.g:661:1: rule__Definition__Group__4 : rule__Definition__Group__4__Impl rule__Definition__Group__5 ;
    public final void rule__Definition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:665:1: ( rule__Definition__Group__4__Impl rule__Definition__Group__5 )
            // InternalArithmetics.g:666:2: rule__Definition__Group__4__Impl rule__Definition__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalArithmetics.g:673:1: rule__Definition__Group__4__Impl : ( ( rule__Definition__ExprAssignment_4 ) ) ;
    public final void rule__Definition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:677:1: ( ( ( rule__Definition__ExprAssignment_4 ) ) )
            // InternalArithmetics.g:678:1: ( ( rule__Definition__ExprAssignment_4 ) )
            {
            // InternalArithmetics.g:678:1: ( ( rule__Definition__ExprAssignment_4 ) )
            // InternalArithmetics.g:679:2: ( rule__Definition__ExprAssignment_4 )
            {
             before(grammarAccess.getDefinitionAccess().getExprAssignment_4()); 
            // InternalArithmetics.g:680:2: ( rule__Definition__ExprAssignment_4 )
            // InternalArithmetics.g:680:3: rule__Definition__ExprAssignment_4
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
    // InternalArithmetics.g:688:1: rule__Definition__Group__5 : rule__Definition__Group__5__Impl ;
    public final void rule__Definition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:692:1: ( rule__Definition__Group__5__Impl )
            // InternalArithmetics.g:693:2: rule__Definition__Group__5__Impl
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
    // InternalArithmetics.g:699:1: rule__Definition__Group__5__Impl : ( ';' ) ;
    public final void rule__Definition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:703:1: ( ( ';' ) )
            // InternalArithmetics.g:704:1: ( ';' )
            {
            // InternalArithmetics.g:704:1: ( ';' )
            // InternalArithmetics.g:705:2: ';'
            {
             before(grammarAccess.getDefinitionAccess().getSemicolonKeyword_5()); 
            match(input,16,FOLLOW_2); 
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
    // InternalArithmetics.g:715:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:719:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // InternalArithmetics.g:720:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
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
    // InternalArithmetics.g:727:1: rule__Definition__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:731:1: ( ( '(' ) )
            // InternalArithmetics.g:732:1: ( '(' )
            {
            // InternalArithmetics.g:732:1: ( '(' )
            // InternalArithmetics.g:733:2: '('
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalArithmetics.g:742:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl rule__Definition__Group_2__2 ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:746:1: ( rule__Definition__Group_2__1__Impl rule__Definition__Group_2__2 )
            // InternalArithmetics.g:747:2: rule__Definition__Group_2__1__Impl rule__Definition__Group_2__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalArithmetics.g:754:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__ArgsAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:758:1: ( ( ( rule__Definition__ArgsAssignment_2_1 ) ) )
            // InternalArithmetics.g:759:1: ( ( rule__Definition__ArgsAssignment_2_1 ) )
            {
            // InternalArithmetics.g:759:1: ( ( rule__Definition__ArgsAssignment_2_1 ) )
            // InternalArithmetics.g:760:2: ( rule__Definition__ArgsAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getArgsAssignment_2_1()); 
            // InternalArithmetics.g:761:2: ( rule__Definition__ArgsAssignment_2_1 )
            // InternalArithmetics.g:761:3: rule__Definition__ArgsAssignment_2_1
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
    // InternalArithmetics.g:769:1: rule__Definition__Group_2__2 : rule__Definition__Group_2__2__Impl rule__Definition__Group_2__3 ;
    public final void rule__Definition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:773:1: ( rule__Definition__Group_2__2__Impl rule__Definition__Group_2__3 )
            // InternalArithmetics.g:774:2: rule__Definition__Group_2__2__Impl rule__Definition__Group_2__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalArithmetics.g:781:1: rule__Definition__Group_2__2__Impl : ( ( rule__Definition__Group_2_2__0 )* ) ;
    public final void rule__Definition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:785:1: ( ( ( rule__Definition__Group_2_2__0 )* ) )
            // InternalArithmetics.g:786:1: ( ( rule__Definition__Group_2_2__0 )* )
            {
            // InternalArithmetics.g:786:1: ( ( rule__Definition__Group_2_2__0 )* )
            // InternalArithmetics.g:787:2: ( rule__Definition__Group_2_2__0 )*
            {
             before(grammarAccess.getDefinitionAccess().getGroup_2_2()); 
            // InternalArithmetics.g:788:2: ( rule__Definition__Group_2_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==19) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalArithmetics.g:788:3: rule__Definition__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Definition__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // InternalArithmetics.g:796:1: rule__Definition__Group_2__3 : rule__Definition__Group_2__3__Impl ;
    public final void rule__Definition__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:800:1: ( rule__Definition__Group_2__3__Impl )
            // InternalArithmetics.g:801:2: rule__Definition__Group_2__3__Impl
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
    // InternalArithmetics.g:807:1: rule__Definition__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Definition__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:811:1: ( ( ')' ) )
            // InternalArithmetics.g:812:1: ( ')' )
            {
            // InternalArithmetics.g:812:1: ( ')' )
            // InternalArithmetics.g:813:2: ')'
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_2_3()); 
            match(input,18,FOLLOW_2); 
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
    // InternalArithmetics.g:823:1: rule__Definition__Group_2_2__0 : rule__Definition__Group_2_2__0__Impl rule__Definition__Group_2_2__1 ;
    public final void rule__Definition__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:827:1: ( rule__Definition__Group_2_2__0__Impl rule__Definition__Group_2_2__1 )
            // InternalArithmetics.g:828:2: rule__Definition__Group_2_2__0__Impl rule__Definition__Group_2_2__1
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
    // InternalArithmetics.g:835:1: rule__Definition__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Definition__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:839:1: ( ( ',' ) )
            // InternalArithmetics.g:840:1: ( ',' )
            {
            // InternalArithmetics.g:840:1: ( ',' )
            // InternalArithmetics.g:841:2: ','
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_2_2_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalArithmetics.g:850:1: rule__Definition__Group_2_2__1 : rule__Definition__Group_2_2__1__Impl ;
    public final void rule__Definition__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:854:1: ( rule__Definition__Group_2_2__1__Impl )
            // InternalArithmetics.g:855:2: rule__Definition__Group_2_2__1__Impl
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
    // InternalArithmetics.g:861:1: rule__Definition__Group_2_2__1__Impl : ( ( rule__Definition__ArgsAssignment_2_2_1 ) ) ;
    public final void rule__Definition__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:865:1: ( ( ( rule__Definition__ArgsAssignment_2_2_1 ) ) )
            // InternalArithmetics.g:866:1: ( ( rule__Definition__ArgsAssignment_2_2_1 ) )
            {
            // InternalArithmetics.g:866:1: ( ( rule__Definition__ArgsAssignment_2_2_1 ) )
            // InternalArithmetics.g:867:2: ( rule__Definition__ArgsAssignment_2_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getArgsAssignment_2_2_1()); 
            // InternalArithmetics.g:868:2: ( rule__Definition__ArgsAssignment_2_2_1 )
            // InternalArithmetics.g:868:3: rule__Definition__ArgsAssignment_2_2_1
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
    // InternalArithmetics.g:877:1: rule__Evaluation__Group__0 : rule__Evaluation__Group__0__Impl rule__Evaluation__Group__1 ;
    public final void rule__Evaluation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:881:1: ( rule__Evaluation__Group__0__Impl rule__Evaluation__Group__1 )
            // InternalArithmetics.g:882:2: rule__Evaluation__Group__0__Impl rule__Evaluation__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalArithmetics.g:889:1: rule__Evaluation__Group__0__Impl : ( ( rule__Evaluation__ExpressionAssignment_0 ) ) ;
    public final void rule__Evaluation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:893:1: ( ( ( rule__Evaluation__ExpressionAssignment_0 ) ) )
            // InternalArithmetics.g:894:1: ( ( rule__Evaluation__ExpressionAssignment_0 ) )
            {
            // InternalArithmetics.g:894:1: ( ( rule__Evaluation__ExpressionAssignment_0 ) )
            // InternalArithmetics.g:895:2: ( rule__Evaluation__ExpressionAssignment_0 )
            {
             before(grammarAccess.getEvaluationAccess().getExpressionAssignment_0()); 
            // InternalArithmetics.g:896:2: ( rule__Evaluation__ExpressionAssignment_0 )
            // InternalArithmetics.g:896:3: rule__Evaluation__ExpressionAssignment_0
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
    // InternalArithmetics.g:904:1: rule__Evaluation__Group__1 : rule__Evaluation__Group__1__Impl ;
    public final void rule__Evaluation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:908:1: ( rule__Evaluation__Group__1__Impl )
            // InternalArithmetics.g:909:2: rule__Evaluation__Group__1__Impl
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
    // InternalArithmetics.g:915:1: rule__Evaluation__Group__1__Impl : ( ';' ) ;
    public final void rule__Evaluation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:919:1: ( ( ';' ) )
            // InternalArithmetics.g:920:1: ( ';' )
            {
            // InternalArithmetics.g:920:1: ( ';' )
            // InternalArithmetics.g:921:2: ';'
            {
             before(grammarAccess.getEvaluationAccess().getSemicolonKeyword_1()); 
            match(input,16,FOLLOW_2); 
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
    // InternalArithmetics.g:931:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:935:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // InternalArithmetics.g:936:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalArithmetics.g:943:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:947:1: ( ( ruleMultiplication ) )
            // InternalArithmetics.g:948:1: ( ruleMultiplication )
            {
            // InternalArithmetics.g:948:1: ( ruleMultiplication )
            // InternalArithmetics.g:949:2: ruleMultiplication
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
    // InternalArithmetics.g:958:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:962:1: ( rule__Addition__Group__1__Impl )
            // InternalArithmetics.g:963:2: rule__Addition__Group__1__Impl
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
    // InternalArithmetics.g:969:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:973:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // InternalArithmetics.g:974:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // InternalArithmetics.g:974:1: ( ( rule__Addition__Group_1__0 )* )
            // InternalArithmetics.g:975:2: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // InternalArithmetics.g:976:2: ( rule__Addition__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=20 && LA9_0<=21)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalArithmetics.g:976:3: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalArithmetics.g:985:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:989:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // InternalArithmetics.g:990:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalArithmetics.g:997:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1001:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // InternalArithmetics.g:1002:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // InternalArithmetics.g:1002:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // InternalArithmetics.g:1003:2: ( rule__Addition__Alternatives_1_0 )
            {
             before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            // InternalArithmetics.g:1004:2: ( rule__Addition__Alternatives_1_0 )
            // InternalArithmetics.g:1004:3: rule__Addition__Alternatives_1_0
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
    // InternalArithmetics.g:1012:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1016:1: ( rule__Addition__Group_1__1__Impl )
            // InternalArithmetics.g:1017:2: rule__Addition__Group_1__1__Impl
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
    // InternalArithmetics.g:1023:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1027:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // InternalArithmetics.g:1028:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // InternalArithmetics.g:1028:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // InternalArithmetics.g:1029:2: ( rule__Addition__RightAssignment_1_1 )
            {
             before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            // InternalArithmetics.g:1030:2: ( rule__Addition__RightAssignment_1_1 )
            // InternalArithmetics.g:1030:3: rule__Addition__RightAssignment_1_1
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
    // InternalArithmetics.g:1039:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1043:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // InternalArithmetics.g:1044:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalArithmetics.g:1051:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1055:1: ( ( () ) )
            // InternalArithmetics.g:1056:1: ( () )
            {
            // InternalArithmetics.g:1056:1: ( () )
            // InternalArithmetics.g:1057:2: ()
            {
             before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            // InternalArithmetics.g:1058:2: ()
            // InternalArithmetics.g:1058:3: 
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
    // InternalArithmetics.g:1066:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1070:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // InternalArithmetics.g:1071:2: rule__Addition__Group_1_0_0__1__Impl
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
    // InternalArithmetics.g:1077:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1081:1: ( ( '+' ) )
            // InternalArithmetics.g:1082:1: ( '+' )
            {
            // InternalArithmetics.g:1082:1: ( '+' )
            // InternalArithmetics.g:1083:2: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            match(input,20,FOLLOW_2); 
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
    // InternalArithmetics.g:1093:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1097:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // InternalArithmetics.g:1098:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalArithmetics.g:1105:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1109:1: ( ( () ) )
            // InternalArithmetics.g:1110:1: ( () )
            {
            // InternalArithmetics.g:1110:1: ( () )
            // InternalArithmetics.g:1111:2: ()
            {
             before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            // InternalArithmetics.g:1112:2: ()
            // InternalArithmetics.g:1112:3: 
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
    // InternalArithmetics.g:1120:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1124:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // InternalArithmetics.g:1125:2: rule__Addition__Group_1_0_1__1__Impl
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
    // InternalArithmetics.g:1131:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1135:1: ( ( '-' ) )
            // InternalArithmetics.g:1136:1: ( '-' )
            {
            // InternalArithmetics.g:1136:1: ( '-' )
            // InternalArithmetics.g:1137:2: '-'
            {
             before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalArithmetics.g:1147:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1151:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // InternalArithmetics.g:1152:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalArithmetics.g:1159:1: rule__Multiplication__Group__0__Impl : ( rulePrimaryExpression ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1163:1: ( ( rulePrimaryExpression ) )
            // InternalArithmetics.g:1164:1: ( rulePrimaryExpression )
            {
            // InternalArithmetics.g:1164:1: ( rulePrimaryExpression )
            // InternalArithmetics.g:1165:2: rulePrimaryExpression
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
    // InternalArithmetics.g:1174:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1178:1: ( rule__Multiplication__Group__1__Impl )
            // InternalArithmetics.g:1179:2: rule__Multiplication__Group__1__Impl
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
    // InternalArithmetics.g:1185:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1189:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // InternalArithmetics.g:1190:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // InternalArithmetics.g:1190:1: ( ( rule__Multiplication__Group_1__0 )* )
            // InternalArithmetics.g:1191:2: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // InternalArithmetics.g:1192:2: ( rule__Multiplication__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=22 && LA10_0<=23)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalArithmetics.g:1192:3: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalArithmetics.g:1201:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1205:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // InternalArithmetics.g:1206:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalArithmetics.g:1213:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Alternatives_1_0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1217:1: ( ( ( rule__Multiplication__Alternatives_1_0 ) ) )
            // InternalArithmetics.g:1218:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            {
            // InternalArithmetics.g:1218:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            // InternalArithmetics.g:1219:2: ( rule__Multiplication__Alternatives_1_0 )
            {
             before(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 
            // InternalArithmetics.g:1220:2: ( rule__Multiplication__Alternatives_1_0 )
            // InternalArithmetics.g:1220:3: rule__Multiplication__Alternatives_1_0
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
    // InternalArithmetics.g:1228:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1232:1: ( rule__Multiplication__Group_1__1__Impl )
            // InternalArithmetics.g:1233:2: rule__Multiplication__Group_1__1__Impl
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
    // InternalArithmetics.g:1239:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1243:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // InternalArithmetics.g:1244:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // InternalArithmetics.g:1244:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // InternalArithmetics.g:1245:2: ( rule__Multiplication__RightAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            // InternalArithmetics.g:1246:2: ( rule__Multiplication__RightAssignment_1_1 )
            // InternalArithmetics.g:1246:3: rule__Multiplication__RightAssignment_1_1
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
    // InternalArithmetics.g:1255:1: rule__Multiplication__Group_1_0_0__0 : rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 ;
    public final void rule__Multiplication__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1259:1: ( rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 )
            // InternalArithmetics.g:1260:2: rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalArithmetics.g:1267:1: rule__Multiplication__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1271:1: ( ( () ) )
            // InternalArithmetics.g:1272:1: ( () )
            {
            // InternalArithmetics.g:1272:1: ( () )
            // InternalArithmetics.g:1273:2: ()
            {
             before(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 
            // InternalArithmetics.g:1274:2: ()
            // InternalArithmetics.g:1274:3: 
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
    // InternalArithmetics.g:1282:1: rule__Multiplication__Group_1_0_0__1 : rule__Multiplication__Group_1_0_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1286:1: ( rule__Multiplication__Group_1_0_0__1__Impl )
            // InternalArithmetics.g:1287:2: rule__Multiplication__Group_1_0_0__1__Impl
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
    // InternalArithmetics.g:1293:1: rule__Multiplication__Group_1_0_0__1__Impl : ( '*' ) ;
    public final void rule__Multiplication__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1297:1: ( ( '*' ) )
            // InternalArithmetics.g:1298:1: ( '*' )
            {
            // InternalArithmetics.g:1298:1: ( '*' )
            // InternalArithmetics.g:1299:2: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalArithmetics.g:1309:1: rule__Multiplication__Group_1_0_1__0 : rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 ;
    public final void rule__Multiplication__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1313:1: ( rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 )
            // InternalArithmetics.g:1314:2: rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalArithmetics.g:1321:1: rule__Multiplication__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1325:1: ( ( () ) )
            // InternalArithmetics.g:1326:1: ( () )
            {
            // InternalArithmetics.g:1326:1: ( () )
            // InternalArithmetics.g:1327:2: ()
            {
             before(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 
            // InternalArithmetics.g:1328:2: ()
            // InternalArithmetics.g:1328:3: 
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
    // InternalArithmetics.g:1336:1: rule__Multiplication__Group_1_0_1__1 : rule__Multiplication__Group_1_0_1__1__Impl ;
    public final void rule__Multiplication__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1340:1: ( rule__Multiplication__Group_1_0_1__1__Impl )
            // InternalArithmetics.g:1341:2: rule__Multiplication__Group_1_0_1__1__Impl
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
    // InternalArithmetics.g:1347:1: rule__Multiplication__Group_1_0_1__1__Impl : ( '/' ) ;
    public final void rule__Multiplication__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1351:1: ( ( '/' ) )
            // InternalArithmetics.g:1352:1: ( '/' )
            {
            // InternalArithmetics.g:1352:1: ( '/' )
            // InternalArithmetics.g:1353:2: '/'
            {
             before(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 
            match(input,23,FOLLOW_2); 
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
    // InternalArithmetics.g:1363:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1367:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // InternalArithmetics.g:1368:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalArithmetics.g:1375:1: rule__PrimaryExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1379:1: ( ( '(' ) )
            // InternalArithmetics.g:1380:1: ( '(' )
            {
            // InternalArithmetics.g:1380:1: ( '(' )
            // InternalArithmetics.g:1381:2: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalArithmetics.g:1390:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1394:1: ( rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 )
            // InternalArithmetics.g:1395:2: rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalArithmetics.g:1402:1: rule__PrimaryExpression__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1406:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:1407:1: ( ruleExpression )
            {
            // InternalArithmetics.g:1407:1: ( ruleExpression )
            // InternalArithmetics.g:1408:2: ruleExpression
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
    // InternalArithmetics.g:1417:1: rule__PrimaryExpression__Group_0__2 : rule__PrimaryExpression__Group_0__2__Impl ;
    public final void rule__PrimaryExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1421:1: ( rule__PrimaryExpression__Group_0__2__Impl )
            // InternalArithmetics.g:1422:2: rule__PrimaryExpression__Group_0__2__Impl
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
    // InternalArithmetics.g:1428:1: rule__PrimaryExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1432:1: ( ( ')' ) )
            // InternalArithmetics.g:1433:1: ( ')' )
            {
            // InternalArithmetics.g:1433:1: ( ')' )
            // InternalArithmetics.g:1434:2: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,18,FOLLOW_2); 
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
    // InternalArithmetics.g:1444:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1448:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // InternalArithmetics.g:1449:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalArithmetics.g:1456:1: rule__PrimaryExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1460:1: ( ( () ) )
            // InternalArithmetics.g:1461:1: ( () )
            {
            // InternalArithmetics.g:1461:1: ( () )
            // InternalArithmetics.g:1462:2: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0()); 
            // InternalArithmetics.g:1463:2: ()
            // InternalArithmetics.g:1463:3: 
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
    // InternalArithmetics.g:1471:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1475:1: ( rule__PrimaryExpression__Group_1__1__Impl )
            // InternalArithmetics.g:1476:2: rule__PrimaryExpression__Group_1__1__Impl
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
    // InternalArithmetics.g:1482:1: rule__PrimaryExpression__Group_1__1__Impl : ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1486:1: ( ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) ) )
            // InternalArithmetics.g:1487:1: ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) )
            {
            // InternalArithmetics.g:1487:1: ( ( rule__PrimaryExpression__ValueAssignment_1_1 ) )
            // InternalArithmetics.g:1488:2: ( rule__PrimaryExpression__ValueAssignment_1_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_1_1()); 
            // InternalArithmetics.g:1489:2: ( rule__PrimaryExpression__ValueAssignment_1_1 )
            // InternalArithmetics.g:1489:3: rule__PrimaryExpression__ValueAssignment_1_1
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
    // InternalArithmetics.g:1498:1: rule__PrimaryExpression__Group_2__0 : rule__PrimaryExpression__Group_2__0__Impl rule__PrimaryExpression__Group_2__1 ;
    public final void rule__PrimaryExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1502:1: ( rule__PrimaryExpression__Group_2__0__Impl rule__PrimaryExpression__Group_2__1 )
            // InternalArithmetics.g:1503:2: rule__PrimaryExpression__Group_2__0__Impl rule__PrimaryExpression__Group_2__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalArithmetics.g:1510:1: rule__PrimaryExpression__Group_2__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1514:1: ( ( () ) )
            // InternalArithmetics.g:1515:1: ( () )
            {
            // InternalArithmetics.g:1515:1: ( () )
            // InternalArithmetics.g:1516:2: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFunctionCallAction_2_0()); 
            // InternalArithmetics.g:1517:2: ()
            // InternalArithmetics.g:1517:3: 
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
    // InternalArithmetics.g:1525:1: rule__PrimaryExpression__Group_2__1 : rule__PrimaryExpression__Group_2__1__Impl rule__PrimaryExpression__Group_2__2 ;
    public final void rule__PrimaryExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1529:1: ( rule__PrimaryExpression__Group_2__1__Impl rule__PrimaryExpression__Group_2__2 )
            // InternalArithmetics.g:1530:2: rule__PrimaryExpression__Group_2__1__Impl rule__PrimaryExpression__Group_2__2
            {
            pushFollow(FOLLOW_20);
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
    // InternalArithmetics.g:1537:1: rule__PrimaryExpression__Group_2__1__Impl : ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) ) ;
    public final void rule__PrimaryExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1541:1: ( ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) ) )
            // InternalArithmetics.g:1542:1: ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) )
            {
            // InternalArithmetics.g:1542:1: ( ( rule__PrimaryExpression__FuncAssignment_2_1 ) )
            // InternalArithmetics.g:1543:2: ( rule__PrimaryExpression__FuncAssignment_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAssignment_2_1()); 
            // InternalArithmetics.g:1544:2: ( rule__PrimaryExpression__FuncAssignment_2_1 )
            // InternalArithmetics.g:1544:3: rule__PrimaryExpression__FuncAssignment_2_1
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
    // InternalArithmetics.g:1552:1: rule__PrimaryExpression__Group_2__2 : rule__PrimaryExpression__Group_2__2__Impl ;
    public final void rule__PrimaryExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1556:1: ( rule__PrimaryExpression__Group_2__2__Impl )
            // InternalArithmetics.g:1557:2: rule__PrimaryExpression__Group_2__2__Impl
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
    // InternalArithmetics.g:1563:1: rule__PrimaryExpression__Group_2__2__Impl : ( ( rule__PrimaryExpression__Group_2_2__0 )? ) ;
    public final void rule__PrimaryExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1567:1: ( ( ( rule__PrimaryExpression__Group_2_2__0 )? ) )
            // InternalArithmetics.g:1568:1: ( ( rule__PrimaryExpression__Group_2_2__0 )? )
            {
            // InternalArithmetics.g:1568:1: ( ( rule__PrimaryExpression__Group_2_2__0 )? )
            // InternalArithmetics.g:1569:2: ( rule__PrimaryExpression__Group_2_2__0 )?
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2()); 
            // InternalArithmetics.g:1570:2: ( rule__PrimaryExpression__Group_2_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalArithmetics.g:1570:3: rule__PrimaryExpression__Group_2_2__0
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
    // InternalArithmetics.g:1579:1: rule__PrimaryExpression__Group_2_2__0 : rule__PrimaryExpression__Group_2_2__0__Impl rule__PrimaryExpression__Group_2_2__1 ;
    public final void rule__PrimaryExpression__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1583:1: ( rule__PrimaryExpression__Group_2_2__0__Impl rule__PrimaryExpression__Group_2_2__1 )
            // InternalArithmetics.g:1584:2: rule__PrimaryExpression__Group_2_2__0__Impl rule__PrimaryExpression__Group_2_2__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalArithmetics.g:1591:1: rule__PrimaryExpression__Group_2_2__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1595:1: ( ( '(' ) )
            // InternalArithmetics.g:1596:1: ( '(' )
            {
            // InternalArithmetics.g:1596:1: ( '(' )
            // InternalArithmetics.g:1597:2: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_2_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalArithmetics.g:1606:1: rule__PrimaryExpression__Group_2_2__1 : rule__PrimaryExpression__Group_2_2__1__Impl rule__PrimaryExpression__Group_2_2__2 ;
    public final void rule__PrimaryExpression__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1610:1: ( rule__PrimaryExpression__Group_2_2__1__Impl rule__PrimaryExpression__Group_2_2__2 )
            // InternalArithmetics.g:1611:2: rule__PrimaryExpression__Group_2_2__1__Impl rule__PrimaryExpression__Group_2_2__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalArithmetics.g:1618:1: rule__PrimaryExpression__Group_2_2__1__Impl : ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) ) ;
    public final void rule__PrimaryExpression__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1622:1: ( ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) ) )
            // InternalArithmetics.g:1623:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) )
            {
            // InternalArithmetics.g:1623:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_1 ) )
            // InternalArithmetics.g:1624:2: ( rule__PrimaryExpression__ArgsAssignment_2_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_1()); 
            // InternalArithmetics.g:1625:2: ( rule__PrimaryExpression__ArgsAssignment_2_2_1 )
            // InternalArithmetics.g:1625:3: rule__PrimaryExpression__ArgsAssignment_2_2_1
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
    // InternalArithmetics.g:1633:1: rule__PrimaryExpression__Group_2_2__2 : rule__PrimaryExpression__Group_2_2__2__Impl rule__PrimaryExpression__Group_2_2__3 ;
    public final void rule__PrimaryExpression__Group_2_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1637:1: ( rule__PrimaryExpression__Group_2_2__2__Impl rule__PrimaryExpression__Group_2_2__3 )
            // InternalArithmetics.g:1638:2: rule__PrimaryExpression__Group_2_2__2__Impl rule__PrimaryExpression__Group_2_2__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalArithmetics.g:1645:1: rule__PrimaryExpression__Group_2_2__2__Impl : ( ( rule__PrimaryExpression__Group_2_2_2__0 )* ) ;
    public final void rule__PrimaryExpression__Group_2_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1649:1: ( ( ( rule__PrimaryExpression__Group_2_2_2__0 )* ) )
            // InternalArithmetics.g:1650:1: ( ( rule__PrimaryExpression__Group_2_2_2__0 )* )
            {
            // InternalArithmetics.g:1650:1: ( ( rule__PrimaryExpression__Group_2_2_2__0 )* )
            // InternalArithmetics.g:1651:2: ( rule__PrimaryExpression__Group_2_2_2__0 )*
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2_2()); 
            // InternalArithmetics.g:1652:2: ( rule__PrimaryExpression__Group_2_2_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==19) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalArithmetics.g:1652:3: rule__PrimaryExpression__Group_2_2_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__PrimaryExpression__Group_2_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalArithmetics.g:1660:1: rule__PrimaryExpression__Group_2_2__3 : rule__PrimaryExpression__Group_2_2__3__Impl ;
    public final void rule__PrimaryExpression__Group_2_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1664:1: ( rule__PrimaryExpression__Group_2_2__3__Impl )
            // InternalArithmetics.g:1665:2: rule__PrimaryExpression__Group_2_2__3__Impl
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
    // InternalArithmetics.g:1671:1: rule__PrimaryExpression__Group_2_2__3__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_2_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1675:1: ( ( ')' ) )
            // InternalArithmetics.g:1676:1: ( ')' )
            {
            // InternalArithmetics.g:1676:1: ( ')' )
            // InternalArithmetics.g:1677:2: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2_3()); 
            match(input,18,FOLLOW_2); 
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
    // InternalArithmetics.g:1687:1: rule__PrimaryExpression__Group_2_2_2__0 : rule__PrimaryExpression__Group_2_2_2__0__Impl rule__PrimaryExpression__Group_2_2_2__1 ;
    public final void rule__PrimaryExpression__Group_2_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1691:1: ( rule__PrimaryExpression__Group_2_2_2__0__Impl rule__PrimaryExpression__Group_2_2_2__1 )
            // InternalArithmetics.g:1692:2: rule__PrimaryExpression__Group_2_2_2__0__Impl rule__PrimaryExpression__Group_2_2_2__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalArithmetics.g:1699:1: rule__PrimaryExpression__Group_2_2_2__0__Impl : ( ',' ) ;
    public final void rule__PrimaryExpression__Group_2_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1703:1: ( ( ',' ) )
            // InternalArithmetics.g:1704:1: ( ',' )
            {
            // InternalArithmetics.g:1704:1: ( ',' )
            // InternalArithmetics.g:1705:2: ','
            {
             before(grammarAccess.getPrimaryExpressionAccess().getCommaKeyword_2_2_2_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalArithmetics.g:1714:1: rule__PrimaryExpression__Group_2_2_2__1 : rule__PrimaryExpression__Group_2_2_2__1__Impl ;
    public final void rule__PrimaryExpression__Group_2_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1718:1: ( rule__PrimaryExpression__Group_2_2_2__1__Impl )
            // InternalArithmetics.g:1719:2: rule__PrimaryExpression__Group_2_2_2__1__Impl
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
    // InternalArithmetics.g:1725:1: rule__PrimaryExpression__Group_2_2_2__1__Impl : ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) ) ;
    public final void rule__PrimaryExpression__Group_2_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1729:1: ( ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) ) )
            // InternalArithmetics.g:1730:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) )
            {
            // InternalArithmetics.g:1730:1: ( ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 ) )
            // InternalArithmetics.g:1731:2: ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_2_1()); 
            // InternalArithmetics.g:1732:2: ( rule__PrimaryExpression__ArgsAssignment_2_2_2_1 )
            // InternalArithmetics.g:1732:3: rule__PrimaryExpression__ArgsAssignment_2_2_2_1
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
    // InternalArithmetics.g:1741:1: rule__Module__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Module__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1745:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:1746:2: ( RULE_ID )
            {
            // InternalArithmetics.g:1746:2: ( RULE_ID )
            // InternalArithmetics.g:1747:3: RULE_ID
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
    // InternalArithmetics.g:1756:1: rule__Module__ImportsAssignment_2 : ( ruleImport ) ;
    public final void rule__Module__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1760:1: ( ( ruleImport ) )
            // InternalArithmetics.g:1761:2: ( ruleImport )
            {
            // InternalArithmetics.g:1761:2: ( ruleImport )
            // InternalArithmetics.g:1762:3: ruleImport
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
    // InternalArithmetics.g:1771:1: rule__Module__StatementsAssignment_3 : ( ruleStatement ) ;
    public final void rule__Module__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1775:1: ( ( ruleStatement ) )
            // InternalArithmetics.g:1776:2: ( ruleStatement )
            {
            // InternalArithmetics.g:1776:2: ( ruleStatement )
            // InternalArithmetics.g:1777:3: ruleStatement
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


    // $ANTLR start "rule__Import__ModuleAssignment_1"
    // InternalArithmetics.g:1786:1: rule__Import__ModuleAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Import__ModuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1790:1: ( ( ( RULE_ID ) ) )
            // InternalArithmetics.g:1791:2: ( ( RULE_ID ) )
            {
            // InternalArithmetics.g:1791:2: ( ( RULE_ID ) )
            // InternalArithmetics.g:1792:3: ( RULE_ID )
            {
             before(grammarAccess.getImportAccess().getModuleModuleCrossReference_1_0()); 
            // InternalArithmetics.g:1793:3: ( RULE_ID )
            // InternalArithmetics.g:1794:4: RULE_ID
            {
             before(grammarAccess.getImportAccess().getModuleModuleIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getModuleModuleIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getImportAccess().getModuleModuleCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ModuleAssignment_1"


    // $ANTLR start "rule__Definition__NameAssignment_1"
    // InternalArithmetics.g:1805:1: rule__Definition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1809:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:1810:2: ( RULE_ID )
            {
            // InternalArithmetics.g:1810:2: ( RULE_ID )
            // InternalArithmetics.g:1811:3: RULE_ID
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
    // InternalArithmetics.g:1820:1: rule__Definition__ArgsAssignment_2_1 : ( ruleDeclaredParameter ) ;
    public final void rule__Definition__ArgsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1824:1: ( ( ruleDeclaredParameter ) )
            // InternalArithmetics.g:1825:2: ( ruleDeclaredParameter )
            {
            // InternalArithmetics.g:1825:2: ( ruleDeclaredParameter )
            // InternalArithmetics.g:1826:3: ruleDeclaredParameter
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
    // InternalArithmetics.g:1835:1: rule__Definition__ArgsAssignment_2_2_1 : ( ruleDeclaredParameter ) ;
    public final void rule__Definition__ArgsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1839:1: ( ( ruleDeclaredParameter ) )
            // InternalArithmetics.g:1840:2: ( ruleDeclaredParameter )
            {
            // InternalArithmetics.g:1840:2: ( ruleDeclaredParameter )
            // InternalArithmetics.g:1841:3: ruleDeclaredParameter
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
    // InternalArithmetics.g:1850:1: rule__Definition__ExprAssignment_4 : ( ruleExpression ) ;
    public final void rule__Definition__ExprAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1854:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:1855:2: ( ruleExpression )
            {
            // InternalArithmetics.g:1855:2: ( ruleExpression )
            // InternalArithmetics.g:1856:3: ruleExpression
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
    // InternalArithmetics.g:1865:1: rule__DeclaredParameter__NameAssignment : ( RULE_ID ) ;
    public final void rule__DeclaredParameter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1869:1: ( ( RULE_ID ) )
            // InternalArithmetics.g:1870:2: ( RULE_ID )
            {
            // InternalArithmetics.g:1870:2: ( RULE_ID )
            // InternalArithmetics.g:1871:3: RULE_ID
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
    // InternalArithmetics.g:1880:1: rule__Evaluation__ExpressionAssignment_0 : ( ruleExpression ) ;
    public final void rule__Evaluation__ExpressionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1884:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:1885:2: ( ruleExpression )
            {
            // InternalArithmetics.g:1885:2: ( ruleExpression )
            // InternalArithmetics.g:1886:3: ruleExpression
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
    // InternalArithmetics.g:1895:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1899:1: ( ( ruleMultiplication ) )
            // InternalArithmetics.g:1900:2: ( ruleMultiplication )
            {
            // InternalArithmetics.g:1900:2: ( ruleMultiplication )
            // InternalArithmetics.g:1901:3: ruleMultiplication
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
    // InternalArithmetics.g:1910:1: rule__Multiplication__RightAssignment_1_1 : ( rulePrimaryExpression ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1914:1: ( ( rulePrimaryExpression ) )
            // InternalArithmetics.g:1915:2: ( rulePrimaryExpression )
            {
            // InternalArithmetics.g:1915:2: ( rulePrimaryExpression )
            // InternalArithmetics.g:1916:3: rulePrimaryExpression
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
    // InternalArithmetics.g:1925:1: rule__PrimaryExpression__ValueAssignment_1_1 : ( RULE_NUMBER ) ;
    public final void rule__PrimaryExpression__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1929:1: ( ( RULE_NUMBER ) )
            // InternalArithmetics.g:1930:2: ( RULE_NUMBER )
            {
            // InternalArithmetics.g:1930:2: ( RULE_NUMBER )
            // InternalArithmetics.g:1931:3: RULE_NUMBER
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
    // InternalArithmetics.g:1940:1: rule__PrimaryExpression__FuncAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__PrimaryExpression__FuncAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1944:1: ( ( ( RULE_ID ) ) )
            // InternalArithmetics.g:1945:2: ( ( RULE_ID ) )
            {
            // InternalArithmetics.g:1945:2: ( ( RULE_ID ) )
            // InternalArithmetics.g:1946:3: ( RULE_ID )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFuncAbstractDefinitionCrossReference_2_1_0()); 
            // InternalArithmetics.g:1947:3: ( RULE_ID )
            // InternalArithmetics.g:1948:4: RULE_ID
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
    // InternalArithmetics.g:1959:1: rule__PrimaryExpression__ArgsAssignment_2_2_1 : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__ArgsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1963:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:1964:2: ( ruleExpression )
            {
            // InternalArithmetics.g:1964:2: ( ruleExpression )
            // InternalArithmetics.g:1965:3: ruleExpression
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
    // InternalArithmetics.g:1974:1: rule__PrimaryExpression__ArgsAssignment_2_2_2_1 : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__ArgsAssignment_2_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalArithmetics.g:1978:1: ( ( ruleExpression ) )
            // InternalArithmetics.g:1979:2: ( ruleExpression )
            {
            // InternalArithmetics.g:1979:2: ( ruleExpression )
            // InternalArithmetics.g:1980:3: ruleExpression
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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000026030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000024032L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000024030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});

}