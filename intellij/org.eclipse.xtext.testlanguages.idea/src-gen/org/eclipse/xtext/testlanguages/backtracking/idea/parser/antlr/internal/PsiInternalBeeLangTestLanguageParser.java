package org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.testlanguages.backtracking.services.BeeLangTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
interface PsiInternalBeeLangTestLanguageParserSignatures {
     void entryRuleModel() throws RecognitionException;
     void ruleModel() throws RecognitionException;
     void entryRuleUnit() throws RecognitionException;
     void ruleUnit() throws RecognitionException;
     void entryRuleProvidedCapability() throws RecognitionException;
     void ruleProvidedCapability() throws RecognitionException;
     void entryRuleAliasedRequiredCapability() throws RecognitionException;
     void ruleAliasedRequiredCapability() throws RecognitionException;
     void entryRuleRequiredCapability() throws RecognitionException;
     void ruleRequiredCapability() throws RecognitionException;
     void entryRulePath() throws RecognitionException;
     void rulePath() throws RecognitionException;
     void entryRuleParameterList() throws RecognitionException;
     void ruleParameterList() throws RecognitionException;
     void entryRuleFirstParameter() throws RecognitionException;
     void ruleFirstParameter() throws RecognitionException;
     void entryRuleParameter() throws RecognitionException;
     void ruleParameter() throws RecognitionException;
     void entryRuleClosureParameter() throws RecognitionException;
     void ruleClosureParameter() throws RecognitionException;
     void entryRuleParameterDeclaration() throws RecognitionException;
     void ruleParameterDeclaration() throws RecognitionException;
     void entryRuleFunction() throws RecognitionException;
     void ruleFunction() throws RecognitionException;
     void entryRuleGuardExpression() throws RecognitionException;
     void ruleGuardExpression() throws RecognitionException;
     void entryRuleAssignmentOperator() throws RecognitionException;
     void ruleAssignmentOperator() throws RecognitionException;
     void entryRuleRelationalOperator() throws RecognitionException;
     void ruleRelationalOperator() throws RecognitionException;
     void entryRuleTopLevelExpression() throws RecognitionException;
     void ruleTopLevelExpression() throws RecognitionException;
     void entryRuleExpression() throws RecognitionException;
     void ruleExpression() throws RecognitionException;
     void entryRuleAssignmentExpression() throws RecognitionException;
     void ruleAssignmentExpression() throws RecognitionException;
     void entryRuleVarDeclaration() throws RecognitionException;
     void ruleVarDeclaration() throws RecognitionException;
     void entryRuleValDeclaration() throws RecognitionException;
     void ruleValDeclaration() throws RecognitionException;
     void entryRuleTypeRef() throws RecognitionException;
     void ruleTypeRef() throws RecognitionException;
     void entryRuleSimpleTypeRef() throws RecognitionException;
     void ruleSimpleTypeRef() throws RecognitionException;
     void entryRuleClosureTypeRef() throws RecognitionException;
     void ruleClosureTypeRef() throws RecognitionException;
     void entryRuleCachedExpression() throws RecognitionException;
     void ruleCachedExpression() throws RecognitionException;
     void entryRuleOrExpression() throws RecognitionException;
     void ruleOrExpression() throws RecognitionException;
     void entryRuleAndExpression() throws RecognitionException;
     void ruleAndExpression() throws RecognitionException;
     void entryRuleRelationalExpression() throws RecognitionException;
     void ruleRelationalExpression() throws RecognitionException;
     void entryRuleAdditiveExpression() throws RecognitionException;
     void ruleAdditiveExpression() throws RecognitionException;
     void entryRuleMultiplicativeExpression() throws RecognitionException;
     void ruleMultiplicativeExpression() throws RecognitionException;
     void entryRuleSetExpression() throws RecognitionException;
     void ruleSetExpression() throws RecognitionException;
     void entryRuleUnaryOrInfixExpression() throws RecognitionException;
     void ruleUnaryOrInfixExpression() throws RecognitionException;
     void entryRuleUnaryExpression() throws RecognitionException;
     void ruleUnaryExpression() throws RecognitionException;
     void entryRulePreopExpression() throws RecognitionException;
     void rulePreopExpression() throws RecognitionException;
     void entryRulePostopExpression() throws RecognitionException;
     void rulePostopExpression() throws RecognitionException;
     void entryRuleInfixExpression() throws RecognitionException;
     void ruleInfixExpression() throws RecognitionException;
     void entryRuleCallExpression() throws RecognitionException;
     void ruleCallExpression() throws RecognitionException;
     void entryRulePrimaryExpression() throws RecognitionException;
     void rulePrimaryExpression() throws RecognitionException;
     void entryRuleWithExpression() throws RecognitionException;
     void ruleWithExpression() throws RecognitionException;
     void entryRuleWithContextExpression() throws RecognitionException;
     void ruleWithContextExpression() throws RecognitionException;
     void entryRuleBlockExpression() throws RecognitionException;
     void ruleBlockExpression() throws RecognitionException;
     void entryRuleValue() throws RecognitionException;
     void ruleValue() throws RecognitionException;
     void entryRuleKeywordVariables() throws RecognitionException;
     void ruleKeywordVariables() throws RecognitionException;
     void entryRuleFeatureCall() throws RecognitionException;
     void ruleFeatureCall() throws RecognitionException;
     void entryRuleOperationCall() throws RecognitionException;
     void ruleOperationCall() throws RecognitionException;
     void entryRuleConstructorCallExpression() throws RecognitionException;
     void ruleConstructorCallExpression() throws RecognitionException;
     void entryRuleInitializationBlockExpression() throws RecognitionException;
     void ruleInitializationBlockExpression() throws RecognitionException;
     void entryRuleInitializationExpression() throws RecognitionException;
     void ruleInitializationExpression() throws RecognitionException;
     void entryRuleFeatureOfThis() throws RecognitionException;
     void ruleFeatureOfThis() throws RecognitionException;
     void entryRuleLiteral() throws RecognitionException;
     void ruleLiteral() throws RecognitionException;
     void entryRuleLiteralFunction() throws RecognitionException;
     void ruleLiteralFunction() throws RecognitionException;
     void entryRuleClosureExpression() throws RecognitionException;
     void ruleClosureExpression() throws RecognitionException;
     void entryRuleOneOrManyExpressions() throws RecognitionException;
     void ruleOneOrManyExpressions() throws RecognitionException;
     void entryRuleBlockExpressionWithoutBrackets() throws RecognitionException;
     void ruleBlockExpressionWithoutBrackets() throws RecognitionException;
     void entryRuleValueLiteral() throws RecognitionException;
     void ruleValueLiteral() throws RecognitionException;
     void entryRuleParanthesizedExpression() throws RecognitionException;
     void ruleParanthesizedExpression() throws RecognitionException;
     void entryRuleQID() throws RecognitionException;
     void ruleQID() throws RecognitionException;
     void synpred2_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred9_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred10_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred11_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred12_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred13_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred14_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred15_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred16_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred17_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred18_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred20_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred21_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred22_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred26_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred27_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred28_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred29_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred30_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred32_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred33_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred34_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred35_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred36_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred42_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred69_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred71_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred85_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred86_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred87_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred89_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred92_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred93_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred99_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred101_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred102_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred103_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred105_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred106_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred108_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred109_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred112_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred113_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred127_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred128_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred135_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred137_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException;   
}

@SuppressWarnings("all")
abstract class PsiInternalBeeLangTestLanguageParser1 extends AbstractPsiAntlrParser implements PsiInternalBeeLangTestLanguageParserSignatures {

        PsiInternalBeeLangTestLanguageParser1(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalBeeLangTestLanguageParser1(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOCUMENTATION", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'unit'", "'version'", "'implements'", "','", "'{'", "'source'", "':'", "';'", "'output'", "'provides'", "'requires'", "'env'", "'}'", "'when'", "'name'", "'as'", "'greedy'", "'requires-min'", "'requires-max'", "'/'", "'final'", "'function'", "'('", "'...'", "')'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'~='", "'=='", "'==='", "'!='", "'!=='", "'>='", "'<='", "'>'", "'<'", "'var'", "'val'", "'=>'", "'cached'", "'||'", "'&&'", "'+'", "'-'", "'*'", "'%'", "'..'", "'!'", "'++'", "'--'", "'.'", "'['", "']'", "'with'", "'context'", "'input'", "'properties'", "'builder'", "'this'", "'new'", "'|'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=8;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int RULE_DOCUMENTATION=4;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__77=77;


    public String[] getTokenNames() { return PsiInternalBeeLangTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBeeLangTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected BeeLangTestLanguageGrammarAccess grammarAccess;

    	protected BeeLangTestLanguageElementTypeProvider elementTypeProvider;



    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}





    // Delegated rules

    public final boolean synpred102_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA91 dfa91 = new DFA91(this);
    static final String DFA13_eotS =
        "\14\uffff";
    static final String DFA13_eofS =
        "\14\uffff";
    static final String DFA13_minS =
        "\1\4\4\uffff\1\23\6\uffff";
    static final String DFA13_maxS =
        "\1\42\4\uffff\1\30\6\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\7\1\1\1\2\1\3\1\uffff\4\6\1\5\1\4";
    static final String DFA13_specialS =
        "\1\1\4\uffff\1\0\6\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\6\1\7\14\uffff\1\2\2\uffff\1\3\1\4\1\5\1\uffff\1\1\7\uffff\1\10\1\11",
            "",
            "",
            "",
            "",
            "\1\13\4\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "()* loopback of 225:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA13_5 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {s = 10;}

                        else if ( LA13_5 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {s = 11;}

                         
                        input.seek(index13_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_0 = input.LA(1);

                         
                        int index13_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA13_0==25) ) {s = 1;}

                        else if ( LA13_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {s = 2;}

                        else if ( LA13_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {s = 3;}

                        else if ( LA13_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {s = 4;}

                        else if ( (LA13_0==23) ) {s = 5;}

                        else if ( LA13_0 == RULE_DOCUMENTATION && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 6;}

                        else if ( LA13_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 7;}

                        else if ( LA13_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 8;}

                        else if ( LA13_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 9;}

                         
                        input.seek(index13_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA27_eotS =
        "\56\uffff";
    static final String DFA27_eofS =
        "\3\uffff\1\4\4\uffff\2\4\12\uffff\3\4\16\uffff\2\4\7\uffff";
    static final String DFA27_minS =
        "\1\5\1\uffff\2\5\1\uffff\1\20\2\5\2\20\1\5\1\0\3\5\1\20\1\5\1\67\1\5\1\0\1\5\2\20\1\5\1\45\1\5\1\20\1\5\1\67\3\5\1\20\2\5\1\45\1\5\1\20\1\5\1\45\1\0\1\5\1\20\1\5\1\45\1\0";
    static final String DFA27_maxS =
        "\1\115\1\uffff\1\114\1\115\1\uffff\1\104\1\114\1\115\2\104\1\114\1\0\1\43\1\115\1\114\1\104\1\5\1\67\1\45\1\0\2\115\1\104\1\44\1\45\1\5\1\45\1\5\1\67\1\114\1\115\1\5\1\45\1\5\1\44\1\45\1\5\2\115\1\45\1\0\1\5\1\45\1\5\1\45\1\0";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\51\uffff";
    static final String DFA27_specialS =
        "\13\uffff\1\3\7\uffff\1\1\24\uffff\1\0\4\uffff\1\2}>";
    static final String[] DFA27_transitionS = {
            "\1\3\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\2\1\1\17\uffff\1\1\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4\1\1",
            "",
            "\1\5\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\2\1\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\1\12\uffff\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\17\4\1\6\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "",
            "\1\1\17\uffff\1\4\2\uffff\1\4\1\uffff\1\10\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\11\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\13\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\12\1\14\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\1\1\uffff\7\4\1\uffff\4\4",
            "\1\15\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\16\1\4\4\uffff\7\4\1\uffff\4\4",
            "\1\17\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\20\1\21\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\uffff",
            "\1\23\35\uffff\1\22",
            "\1\24\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\25\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\27\17\uffff\1\4\2\uffff\1\4\1\uffff\1\26\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\30",
            "\1\31",
            "\1\32\36\uffff\1\33\1\34",
            "\1\uffff",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\31\1\uffff\7\4\1\uffff\4\4",
            "\1\40\36\uffff\1\37",
            "\1\21",
            "\1\41",
            "\1\42\24\uffff\1\34",
            "\1\43",
            "\1\44",
            "\1\45\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\46\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\47",
            "\1\27\24\uffff\1\21",
            "\1\50",
            "\1\52\36\uffff\1\51",
            "\1\34",
            "\1\53",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\21",
            "\1\uffff",
            "\1\54",
            "\1\42\24\uffff\1\34",
            "\1\55",
            "\1\34",
            "\1\uffff"
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1435:2: ( ruleClosureParameter | ruleParameter )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_40 = input.LA(1);

                         
                        int index27_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_40);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_19 = input.LA(1);

                         
                        int index27_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_19);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_45 = input.LA(1);

                         
                        int index27_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_45);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\15\uffff";
    static final String DFA42_eofS =
        "\4\uffff\1\6\4\uffff\2\6\2\uffff";
    static final String DFA42_minS =
        "\2\5\1\uffff\2\5\2\uffff\1\20\1\5\1\24\1\20\1\5\1\0";
    static final String DFA42_maxS =
        "\1\114\1\66\1\uffff\1\114\1\104\2\uffff\1\104\1\114\2\104\1\114\1\0";
    static final String DFA42_acceptS =
        "\2\uffff\1\1\2\uffff\1\2\1\3\6\uffff";
    static final String DFA42_specialS =
        "\14\uffff\1\0}>";
    static final String[] DFA42_transitionS = {
            "\1\4\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\13\uffff\1\1\1\uffff\1\3\21\uffff\1\2\1\5\1\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\2\35\uffff\1\2\21\uffff\1\2\1\5",
            "",
            "\1\7\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\2\2\22\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\2\16\uffff\1\6\13\uffff\1\6\2\uffff\1\6\2\uffff\16\6\1\10\4\uffff\7\6\1\uffff\4\6",
            "",
            "",
            "\1\2\17\uffff\1\6\2\uffff\1\6\1\uffff\1\11\17\6\4\uffff\7\6\1\uffff\4\6",
            "\1\12\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\6\13\uffff\1\6\2\uffff\1\6\2\uffff\17\6\2\uffff\1\2\1\uffff\7\6\1\uffff\4\6",
            "\1\2\3\uffff\1\6\13\uffff\1\6\2\uffff\1\6\2\uffff\15\6\1\13\1\6\4\uffff\7\6\1\uffff\4\6",
            "\1\14\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\uffff"
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "1979:2: ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred69_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA58_eotS =
        "\14\uffff";
    static final String DFA58_eofS =
        "\1\1\13\uffff";
    static final String DFA58_minS =
        "\1\20\1\uffff\11\0\1\uffff";
    static final String DFA58_maxS =
        "\1\105\1\uffff\11\0\1\uffff";
    static final String DFA58_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA58_specialS =
        "\2\uffff\1\3\1\2\1\1\1\0\1\10\1\7\1\5\1\4\1\6\1\uffff}>";
    static final String[] DFA58_transitionS = {
            "\2\1\2\uffff\1\1\4\uffff\1\1\2\uffff\1\1\3\uffff\1\1\2\uffff\1\1\1\uffff\7\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\4\uffff\7\1\1\uffff\5\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "()* loopback of 2670:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA73_eotS =
        "\23\uffff";
    static final String DFA73_eofS =
        "\23\uffff";
    static final String DFA73_minS =
        "\1\5\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String DFA73_maxS =
        "\1\114\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String DFA73_acceptS =
        "\2\uffff\1\2\1\4\1\uffff\1\5\6\uffff\1\6\1\uffff\1\1\1\3\1\7\1\10\1\11";
    static final String DFA73_specialS =
        "\1\uffff\1\0\2\uffff\1\1\10\uffff\1\2\5\uffff}>";
    static final String[] DFA73_transitionS = {
            "\1\1\1\uffff\1\3\5\uffff\1\5\3\uffff\1\4\1\5\2\uffff\1\5\15\uffff\1\14\42\uffff\1\15\1\uffff\4\5\1\2",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA73_eot = DFA.unpackEncodedString(DFA73_eotS);
    static final short[] DFA73_eof = DFA.unpackEncodedString(DFA73_eofS);
    static final char[] DFA73_min = DFA.unpackEncodedStringToUnsignedChars(DFA73_minS);
    static final char[] DFA73_max = DFA.unpackEncodedStringToUnsignedChars(DFA73_maxS);
    static final short[] DFA73_accept = DFA.unpackEncodedString(DFA73_acceptS);
    static final short[] DFA73_special = DFA.unpackEncodedString(DFA73_specialS);
    static final short[][] DFA73_transition;

    static {
        int numStates = DFA73_transitionS.length;
        DFA73_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA73_transition[i] = DFA.unpackEncodedString(DFA73_transitionS[i]);
        }
    }

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = DFA73_eot;
            this.eof = DFA73_eof;
            this.min = DFA73_min;
            this.max = DFA73_max;
            this.accept = DFA73_accept;
            this.special = DFA73_special;
            this.transition = DFA73_transition;
        }
        public String getDescription() {
            return "3314:2: ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA73_1 = input.LA(1);

                         
                        int index73_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_PsiInternalBeeLangTestLanguage()) ) {s = 14;}

                        else if ( (synpred108_PsiInternalBeeLangTestLanguage()) ) {s = 15;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_4 = input.LA(1);

                         
                        int index73_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_PsiInternalBeeLangTestLanguage()) ) {s = 3;}

                        else if ( (synpred112_PsiInternalBeeLangTestLanguage()) ) {s = 16;}

                         
                        input.seek(index73_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_13 = input.LA(1);

                         
                        int index73_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_PsiInternalBeeLangTestLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index73_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 73, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA82_eotS =
        "\46\uffff";
    static final String DFA82_eofS =
        "\1\2\45\uffff";
    static final String DFA82_minS =
        "\1\20\1\0\44\uffff";
    static final String DFA82_maxS =
        "\1\105\1\0\44\uffff";
    static final String DFA82_acceptS =
        "\2\uffff\1\2\42\uffff\1\1";
    static final String DFA82_specialS =
        "\1\uffff\1\0\44\uffff}>";
    static final String[] DFA82_transitionS = {
            "\2\2\2\uffff\1\2\4\uffff\1\2\2\uffff\1\2\3\uffff\1\2\2\uffff\1\1\1\uffff\20\2\4\uffff\7\2\1\uffff\5\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA82_eot = DFA.unpackEncodedString(DFA82_eotS);
    static final short[] DFA82_eof = DFA.unpackEncodedString(DFA82_eofS);
    static final char[] DFA82_min = DFA.unpackEncodedStringToUnsignedChars(DFA82_minS);
    static final char[] DFA82_max = DFA.unpackEncodedStringToUnsignedChars(DFA82_maxS);
    static final short[] DFA82_accept = DFA.unpackEncodedString(DFA82_acceptS);
    static final short[] DFA82_special = DFA.unpackEncodedString(DFA82_specialS);
    static final short[][] DFA82_transition;

    static {
        int numStates = DFA82_transitionS.length;
        DFA82_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA82_transition[i] = DFA.unpackEncodedString(DFA82_transitionS[i]);
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = DFA82_eot;
            this.eof = DFA82_eof;
            this.min = DFA82_min;
            this.max = DFA82_max;
            this.accept = DFA82_accept;
            this.special = DFA82_special;
            this.transition = DFA82_transition;
        }
        public String getDescription() {
            return "3868:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_PsiInternalBeeLangTestLanguage()) ) {s = 37;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA90_eotS =
        "\72\uffff";
    static final String DFA90_eofS =
        "\5\uffff\1\6\7\uffff\1\6\3\uffff\1\6\16\uffff\2\6\4\uffff\1\6\12\uffff\2\6\7\uffff";
    static final String DFA90_minS =
        "\2\5\2\uffff\2\5\1\uffff\1\20\1\5\1\67\1\5\1\20\1\5\1\20\1\5\1\45\1\5\1\20\2\5\1\0\1\20\5\5\1\0\1\20\1\5\1\67\1\45\1\5\2\20\1\5\1\67\1\5\1\20\1\45\4\5\1\45\1\5\1\20\3\5\2\20\2\5\1\45\1\0\1\45\1\0";
    static final String DFA90_maxS =
        "\1\115\1\114\2\uffff\1\114\1\115\1\uffff\1\104\1\5\1\67\1\114\2\115\1\104\1\44\1\45\1\5\1\104\1\43\1\114\1\0\1\45\2\5\1\115\1\114\1\45\1\0\1\104\1\5\1\67\1\45\2\115\1\45\1\5\1\67\1\44\1\104\1\45\1\5\1\115\1\114\1\44\1\45\1\5\1\45\2\5\2\115\1\45\2\5\1\45\1\0\1\45\1\0";
    static final String DFA90_acceptS =
        "\2\uffff\1\1\1\2\2\uffff\1\3\63\uffff";
    static final String DFA90_specialS =
        "\24\uffff\1\0\6\uffff\1\1\33\uffff\1\3\1\uffff\1\2}>";
    static final String[] DFA90_transitionS = {
            "\1\2\35\uffff\1\2\1\3\50\uffff\1\1",
            "\1\5\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\13\uffff\1\6\1\uffff\1\4\21\uffff\2\6\1\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "",
            "",
            "\1\7\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\1\10\1\11\22\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\13\12\uffff\1\14\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\17\6\1\12\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "",
            "\1\16\17\uffff\1\6\2\uffff\1\6\1\uffff\1\15\17\6\4\uffff\7\6\1\uffff\4\6",
            "\1\17",
            "\1\20",
            "\1\21\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\2\3\uffff\1\6\21\uffff\1\6\46\uffff\1\2",
            "\1\24\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\23\1\22\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\6\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\20\6\2\uffff\1\20\1\uffff\7\6\1\uffff\4\6",
            "\1\25\36\uffff\1\26",
            "\1\11",
            "\1\27",
            "\1\30\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\31\1\6\4\uffff\7\6\1\uffff\4\6",
            "\1\33\35\uffff\1\32",
            "\1\34\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\1\35\1\36\22\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\uffff",
            "\1\16\24\uffff\1\11",
            "\1\37",
            "\1\13",
            "\1\40\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\2\6\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\41\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\42\36\uffff\1\43\1\44",
            "\1\uffff",
            "\1\45\17\uffff\1\6\2\uffff\1\6\1\uffff\1\46\17\6\4\uffff\7\6\1\uffff\4\6",
            "\1\47",
            "\1\50",
            "\1\11",
            "\1\6\12\uffff\1\51\17\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\52\1\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\6",
            "\1\14\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\20\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "\1\53\24\uffff\1\44",
            "\1\54",
            "\1\55",
            "\1\56\36\uffff\1\57",
            "\1\6\17\uffff\1\6\2\uffff\1\6\1\uffff\20\6\2\uffff\1\50\1\uffff\7\6\1\uffff\4\6",
            "\1\36",
            "\1\60",
            "\1\61\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\2\6\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\62\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\63\36\uffff\1\64",
            "\1\44",
            "\1\65",
            "\1\45\24\uffff\1\36",
            "\1\66",
            "\1\67",
            "\1\6\12\uffff\1\51\17\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\52\1\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\6",
            "\1\14\3\uffff\1\6\13\uffff\1\6\2\uffff\1\6\1\uffff\20\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "\1\53\24\uffff\1\44",
            "\1\70",
            "\1\71",
            "\1\36",
            "\1\uffff",
            "\1\44",
            "\1\uffff"
    };

    static final short[] DFA90_eot = DFA.unpackEncodedString(DFA90_eotS);
    static final short[] DFA90_eof = DFA.unpackEncodedString(DFA90_eofS);
    static final char[] DFA90_min = DFA.unpackEncodedStringToUnsignedChars(DFA90_minS);
    static final char[] DFA90_max = DFA.unpackEncodedStringToUnsignedChars(DFA90_maxS);
    static final short[] DFA90_accept = DFA.unpackEncodedString(DFA90_acceptS);
    static final short[] DFA90_special = DFA.unpackEncodedString(DFA90_specialS);
    static final short[][] DFA90_transition;

    static {
        int numStates = DFA90_transitionS.length;
        DFA90_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA90_transition[i] = DFA.unpackEncodedString(DFA90_transitionS[i]);
        }
    }

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = DFA90_eot;
            this.eof = DFA90_eof;
            this.min = DFA90_min;
            this.max = DFA90_max;
            this.accept = DFA90_accept;
            this.special = DFA90_special;
            this.transition = DFA90_transition;
        }
        public String getDescription() {
            return "4182:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_20 = input.LA(1);

                         
                        int index90_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_20);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_27 = input.LA(1);

                         
                        int index90_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_27);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_55 = input.LA(1);

                         
                        int index90_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_55);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 90, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA91_eotS =
        "\27\uffff";
    static final String DFA91_eofS =
        "\27\uffff";
    static final String DFA91_minS =
        "\1\5\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String DFA91_maxS =
        "\1\114\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String DFA91_acceptS =
        "\1\uffff\1\1\24\uffff\1\2";
    static final String DFA91_specialS =
        "\3\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\uffff}>";
    static final String[] DFA91_transitionS = {
            "\1\4\1\uffff\1\10\5\uffff\1\17\3\uffff\1\11\1\14\2\uffff\1\13\13\uffff\1\1\1\uffff\1\3\21\uffff\2\1\1\uffff\1\6\3\uffff\1\23\3\uffff\1\22\1\24\1\25\3\uffff\1\21\1\uffff\1\12\1\15\1\16\1\20\1\7",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA91_eot = DFA.unpackEncodedString(DFA91_eotS);
    static final short[] DFA91_eof = DFA.unpackEncodedString(DFA91_eofS);
    static final char[] DFA91_min = DFA.unpackEncodedStringToUnsignedChars(DFA91_minS);
    static final char[] DFA91_max = DFA.unpackEncodedStringToUnsignedChars(DFA91_maxS);
    static final short[] DFA91_accept = DFA.unpackEncodedString(DFA91_acceptS);
    static final short[] DFA91_special = DFA.unpackEncodedString(DFA91_specialS);
    static final short[][] DFA91_transition;

    static {
        int numStates = DFA91_transitionS.length;
        DFA91_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA91_transition[i] = DFA.unpackEncodedString(DFA91_transitionS[i]);
        }
    }

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = DFA91_eot;
            this.eof = DFA91_eof;
            this.min = DFA91_min;
            this.max = DFA91_max;
            this.accept = DFA91_accept;
            this.special = DFA91_special;
            this.transition = DFA91_transition;
        }
        public String getDescription() {
            return "4313:2: ( ruleBlockExpressionWithoutBrackets | ruleExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA91_3 = input.LA(1);

                         
                        int index91_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_4 = input.LA(1);

                         
                        int index91_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_7 = input.LA(1);

                         
                        int index91_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_8 = input.LA(1);

                         
                        int index91_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA91_17 = input.LA(1);

                         
                        int index91_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_17);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA91_18 = input.LA(1);

                         
                        int index91_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_18);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA91_19 = input.LA(1);

                         
                        int index91_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA91_20 = input.LA(1);

                         
                        int index91_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA91_21 = input.LA(1);

                         
                        int index91_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 91, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    protected static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000600000032L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000002C020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000028000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000602E40030L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000001000000A0L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002020L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000C004000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x11000008002620A0L,0x0000000000001F47L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000E004000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010020000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000E6004000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x11100018002620A0L,0x0000000000003F47L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000600000020L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000600000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000020L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000008040A0000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000003800000020L,0x0000000000002000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000010000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000020L,0x0000000000002000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000040A0000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00000FC000000002L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000800000020L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000002L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0008000000010000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000003000000020L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0200000000000002L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x001FF00000000002L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x1800000000000002L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x6000000100000002L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00000008002620A0L,0x0000000000001F40L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x11100038002620A0L,0x0000000000003F47L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x00000000000A0020L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x00000000000B0000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x1160000A002620A0L,0x0000000000001F47L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x1160000A022620A0L,0x0000000000001F47L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000810020002L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000010020002L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0010001800000020L,0x0000000000002000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000001800000020L,0x0000000000002000L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000010000L,0x0000000000002000L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x1160000A002620A2L,0x0000000000001F47L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000162L,0x0000000000000008L});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000800002L});
    }


}

@SuppressWarnings("all")
abstract class PsiInternalBeeLangTestLanguageParser2 extends PsiInternalBeeLangTestLanguageParser1 {

        PsiInternalBeeLangTestLanguageParser2(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalBeeLangTestLanguageParser2(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleModel"
    // PsiInternalBeeLangTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        int entryRuleModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:60:15: ( ruleModel EOF )
            // PsiInternalBeeLangTestLanguage.g:61:2: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBeeLangTestLanguage.g:66:1: ruleModel : ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final void ruleModel() throws RecognitionException {
        int ruleModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:66:10: ( ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:67:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:67:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            int alt3=2;
            switch ( input.LA(1) ) {
            case RULE_DOCUMENTATION:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_ID||(LA3_1>=33 && LA3_1<=34)) ) {
                    alt3=2;
                }
                else if ( (LA3_1==13) ) {
                    alt3=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                alt3=1;
                }
                break;
            case EOF:
                {
                int LA3_3 = input.LA(2);

                if ( (synpred2_PsiInternalBeeLangTestLanguage()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 33:
            case 34:
                {
                alt3=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:68:3: ( (lv_units_0_0= ruleUnit ) )*
                    {
                    // PsiInternalBeeLangTestLanguage.g:68:3: ( (lv_units_0_0= ruleUnit ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_DOCUMENTATION||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:69:4: (lv_units_0_0= ruleUnit )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:69:4: (lv_units_0_0= ruleUnit )
                    	    // PsiInternalBeeLangTestLanguage.g:70:5: lv_units_0_0= ruleUnit
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getModel_UnitsUnitParserRuleCall_0_0ElementType());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    ruleUnit();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:80:3: ( (lv_functions_1_0= ruleFunction ) )*
                    {
                    // PsiInternalBeeLangTestLanguage.g:80:3: ( (lv_functions_1_0= ruleFunction ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=RULE_DOCUMENTATION && LA2_0<=RULE_ID)||(LA2_0>=33 && LA2_0<=34)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:81:4: (lv_functions_1_0= ruleFunction )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:81:4: (lv_functions_1_0= ruleFunction )
                    	    // PsiInternalBeeLangTestLanguage.g:82:5: lv_functions_1_0= ruleFunction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getModel_FunctionsFunctionParserRuleCall_1_0ElementType());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    ruleFunction();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


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
            if ( state.backtracking>0 ) { memoize(input, 2, ruleModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnit"
    // PsiInternalBeeLangTestLanguage.g:95:1: entryRuleUnit : ruleUnit EOF ;
    public final void entryRuleUnit() throws RecognitionException {
        int entryRuleUnit_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:99:2: ( ruleUnit EOF )
            // PsiInternalBeeLangTestLanguage.g:100:2: ruleUnit EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnitElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnit();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // PsiInternalBeeLangTestLanguage.g:108:1: ruleUnit : ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) ;
    public final void ruleUnit() throws RecognitionException {
        int ruleUnit_StartIndex = input.index();
        Token lv_documentation_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_version_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_34=null;


        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:112:2: ( ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:113:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:113:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            // PsiInternalBeeLangTestLanguage.g:114:3: () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}'
            {
            // PsiInternalBeeLangTestLanguage.g:114:3: ()
            // PsiInternalBeeLangTestLanguage.g:115:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnit_UnitAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:123:3: ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOCUMENTATION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:124:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalBeeLangTestLanguage.g:124:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    // PsiInternalBeeLangTestLanguage.g:125:5: lv_documentation_1_0= RULE_DOCUMENTATION
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getUnit_DocumentationDOCUMENTATIONTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_documentation_1_0=(Token)match(input,RULE_DOCUMENTATION,FollowSets000.FOLLOW_5); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_documentation_1_0);
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnit_UnitKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:141:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:142:4: (lv_name_3_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:142:4: (lv_name_3_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:143:5: lv_name_3_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getUnit_NameIDTerminalRuleCall_3_0ElementType());
                      				
                    }
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_name_3_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:152:3: (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:153:4: otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_VersionKeyword_4_0ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:160:4: ( (lv_version_5_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:161:5: (lv_version_5_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:161:5: (lv_version_5_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:162:6: lv_version_5_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnit_VersionIDTerminalRuleCall_4_1_0ElementType());
                      					
                    }
                    lv_version_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_version_5_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:172:3: (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:173:4: otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_ImplementsKeyword_5_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:180:4: ( (lv_implements_7_0= ruleSimpleTypeRef ) )
                    // PsiInternalBeeLangTestLanguage.g:181:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:181:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:182:6: lv_implements_7_0= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getUnit_ImplementsSimpleTypeRefParserRuleCall_5_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:191:4: (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:192:5: otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getUnit_CommaKeyword_5_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_8);
                    	      				
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:199:5: ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    // PsiInternalBeeLangTestLanguage.g:200:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:200:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    // PsiInternalBeeLangTestLanguage.g:201:7: lv_implements_9_0= ruleSimpleTypeRef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getUnit_ImplementsSimpleTypeRefParserRuleCall_5_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_10);
                    	    ruleSimpleTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnit_LeftCurlyBracketKeyword_6ElementType());
              		
            }
            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_11); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:219:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // PsiInternalBeeLangTestLanguage.g:220:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // PsiInternalBeeLangTestLanguage.g:220:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:221:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getUnitAccess().getUnorderedGroup_7());
            // PsiInternalBeeLangTestLanguage.g:224:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:225:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:225:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=7;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:226:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:226:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:227:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:227:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:228:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
            	    // PsiInternalBeeLangTestLanguage.g:231:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:231:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:231:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:231:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SourceKeyword_7_0_0ElementType());
            	      								
            	    }
            	    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_12);
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_0_1ElementType());
            	      								
            	    }
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_13);
            	      								
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:245:9: ( (lv_sourceLocation_14_0= rulePath ) )
            	    // PsiInternalBeeLangTestLanguage.g:246:10: (lv_sourceLocation_14_0= rulePath )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:246:10: (lv_sourceLocation_14_0= rulePath )
            	    // PsiInternalBeeLangTestLanguage.g:247:11: lv_sourceLocation_14_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											markComposite(elementTypeProvider.getUnit_SourceLocationPathParserRuleCall_7_0_2_0ElementType());
            	      										
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rulePath();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      											doneComposite();
            	      										
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_0_3ElementType());
            	      								
            	    }
            	    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_15);
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:269:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:269:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:270:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:270:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:271:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
            	    // PsiInternalBeeLangTestLanguage.g:274:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:274:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:274:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:274:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_OutputKeyword_7_1_0ElementType());
            	      								
            	    }
            	    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_16);
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_1_1ElementType());
            	      								
            	    }
            	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_17);
            	      								
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:288:9: ( (lv_outputLocation_18_0= rulePath ) )
            	    // PsiInternalBeeLangTestLanguage.g:289:10: (lv_outputLocation_18_0= rulePath )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:289:10: (lv_outputLocation_18_0= rulePath )
            	    // PsiInternalBeeLangTestLanguage.g:290:11: lv_outputLocation_18_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											markComposite(elementTypeProvider.getUnit_OutputLocationPathParserRuleCall_7_1_2_0ElementType());
            	      										
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rulePath();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      											doneComposite();
            	      										
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_1_3ElementType());
            	      								
            	    }
            	    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_19);
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:313:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:313:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:314:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
            	    // PsiInternalBeeLangTestLanguage.g:317:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==22) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((synpred11_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:317:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:317:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    // PsiInternalBeeLangTestLanguage.g:317:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_20);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_2_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_21);
            	    	      								
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:331:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:332:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:332:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    // PsiInternalBeeLangTestLanguage.g:333:11: lv_providedCapabilities_22_0= ruleProvidedCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    ruleProvidedCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_2_3ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_23);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalBeeLangTestLanguage.g:355:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:355:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:356:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:356:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:357:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
            	    // PsiInternalBeeLangTestLanguage.g:360:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==23) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((synpred13_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:360:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:360:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    // PsiInternalBeeLangTestLanguage.g:360:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_24);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_3_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_25);
            	    	      								
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:374:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:375:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:375:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    // PsiInternalBeeLangTestLanguage.g:376:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    ruleAliasedRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_3_3ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_27);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalBeeLangTestLanguage.g:398:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:398:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:399:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:399:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:400:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
            	    // PsiInternalBeeLangTestLanguage.g:403:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==23) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((synpred15_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:403:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:403:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    // PsiInternalBeeLangTestLanguage.g:403:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_28);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_EnvKeyword_7_4_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_29);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_4_2ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_30);
            	    	      								
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:424:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:425:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:425:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    // PsiInternalBeeLangTestLanguage.g:426:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    ruleRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_4_4ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_32);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // PsiInternalBeeLangTestLanguage.g:448:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:448:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:449:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:449:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:450:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
            	    // PsiInternalBeeLangTestLanguage.g:453:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        switch ( input.LA(1) ) {
            	        case RULE_DOCUMENTATION:
            	            {
            	            int LA12_2 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA12_3 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 33:
            	            {
            	            int LA12_4 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 34:
            	            {
            	            int LA12_5 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt12) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:453:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:453:19: ( (lv_functions_33_0= ruleFunction ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:453:20: (lv_functions_33_0= ruleFunction )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:453:20: (lv_functions_33_0= ruleFunction )
            	    	    // PsiInternalBeeLangTestLanguage.g:454:10: lv_functions_33_0= ruleFunction
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
            	    	      									
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_11);
            	    	    ruleFunction();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      										doneComposite();
            	    	      									
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnit_RightCurlyBracketKeyword_8ElementType());
              		
            }
            otherlv_34=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_34);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleProvidedCapability"
    // PsiInternalBeeLangTestLanguage.g:489:1: entryRuleProvidedCapability : ruleProvidedCapability EOF ;
    public final void entryRuleProvidedCapability() throws RecognitionException {
        int entryRuleProvidedCapability_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:493:2: ( ruleProvidedCapability EOF )
            // PsiInternalBeeLangTestLanguage.g:494:2: ruleProvidedCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getProvidedCapabilityElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleProvidedCapability();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleProvidedCapability"


    // $ANTLR start "ruleProvidedCapability"
    // PsiInternalBeeLangTestLanguage.g:502:1: ruleProvidedCapability : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) ;
    public final void ruleProvidedCapability() throws RecognitionException {
        int ruleProvidedCapability_StartIndex = input.index();
        Token lv_nameSpace_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;


        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:506:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) )
            // PsiInternalBeeLangTestLanguage.g:507:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            {
            // PsiInternalBeeLangTestLanguage.g:507:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            // PsiInternalBeeLangTestLanguage.g:508:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            {
            // PsiInternalBeeLangTestLanguage.g:508:3: ()
            // PsiInternalBeeLangTestLanguage.g:509:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getProvidedCapability_ProvidedCapabilityAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:517:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==13) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:518:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:518:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:519:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:519:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:520:6: lv_nameSpace_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getProvidedCapability_NameSpaceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_1_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:530:4: otherlv_2= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_UnitKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_17); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:538:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:539:4: otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_LeftCurlyBracketKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_18); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:546:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) )
                    // PsiInternalBeeLangTestLanguage.g:547:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:547:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    // PsiInternalBeeLangTestLanguage.g:548:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());
                    // PsiInternalBeeLangTestLanguage.g:551:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    // PsiInternalBeeLangTestLanguage.g:552:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?
                    {
                    // PsiInternalBeeLangTestLanguage.g:552:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=4;
                        int LA15_0 = input.LA(1);

                        if ( LA15_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                            alt15=1;
                        }
                        else if ( LA15_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                            alt15=2;
                        }
                        else if ( LA15_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                            alt15=3;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:553:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:553:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:554:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:554:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:555:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
                    	    // PsiInternalBeeLangTestLanguage.g:558:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    // PsiInternalBeeLangTestLanguage.g:558:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:558:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    // PsiInternalBeeLangTestLanguage.g:558:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_WhenKeyword_2_1_0_0ElementType());
                    	      									
                    	    }
                    	    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_5);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_0_1ElementType());
                    	      									
                    	    }
                    	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_6);
                    	      									
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:572:10: ( (lv_condExpr_7_0= ruleExpression ) )
                    	    // PsiInternalBeeLangTestLanguage.g:573:11: (lv_condExpr_7_0= ruleExpression )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:573:11: (lv_condExpr_7_0= ruleExpression )
                    	    // PsiInternalBeeLangTestLanguage.g:574:12: lv_condExpr_7_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markComposite(elementTypeProvider.getProvidedCapability_CondExprExpressionParserRuleCall_2_1_0_2_0ElementType());
                    	      											
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      												doneComposite();
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_0_3ElementType());
                    	      									
                    	    }
                    	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_8);
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalBeeLangTestLanguage.g:596:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:596:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:597:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:597:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:598:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
                    	    // PsiInternalBeeLangTestLanguage.g:601:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    // PsiInternalBeeLangTestLanguage.g:601:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:601:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    // PsiInternalBeeLangTestLanguage.g:601:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_NameKeyword_2_1_1_0ElementType());
                    	      									
                    	    }
                    	    otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_9);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_1_1ElementType());
                    	      									
                    	    }
                    	    otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_10);
                    	      									
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:615:10: ( (lv_name_11_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:616:11: (lv_name_11_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:616:11: (lv_name_11_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:617:12: lv_name_11_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markLeaf(elementTypeProvider.getProvidedCapability_NameIDTerminalRuleCall_2_1_1_2_0ElementType());
                    	      											
                    	    }
                    	    lv_name_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      												doneLeaf(lv_name_11_0);
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_1_3ElementType());
                    	      									
                    	    }
                    	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_12);
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // PsiInternalBeeLangTestLanguage.g:639:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:639:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:640:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:640:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:641:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
                    	    // PsiInternalBeeLangTestLanguage.g:644:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    // PsiInternalBeeLangTestLanguage.g:644:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:644:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    // PsiInternalBeeLangTestLanguage.g:644:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_VersionKeyword_2_1_2_0ElementType());
                    	      									
                    	    }
                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_13);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_2_1ElementType());
                    	      									
                    	    }
                    	    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_14);
                    	      									
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:658:10: ( (lv_version_15_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:659:11: (lv_version_15_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:659:11: (lv_version_15_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:660:12: lv_version_15_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markLeaf(elementTypeProvider.getProvidedCapability_VersionIDTerminalRuleCall_2_1_2_2_0ElementType());
                    	      											
                    	    }
                    	    lv_version_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      												doneLeaf(lv_version_15_0);
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_2_3ElementType());
                    	      									
                    	    }
                    	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_16);
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canLeave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1())");
                    }

                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_RightCurlyBracketKeyword_2_2ElementType());
                      			
                    }
                    otherlv_17=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_17);
                      			
                    }

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleProvidedCapability"


    // $ANTLR start "entryRuleAliasedRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:705:1: entryRuleAliasedRequiredCapability : ruleAliasedRequiredCapability EOF ;
    public final void entryRuleAliasedRequiredCapability() throws RecognitionException {
        int entryRuleAliasedRequiredCapability_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:709:2: ( ruleAliasedRequiredCapability EOF )
            // PsiInternalBeeLangTestLanguage.g:710:2: ruleAliasedRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAliasedRequiredCapabilityElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAliasedRequiredCapability();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRuleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleAliasedRequiredCapability"


    // $ANTLR start "ruleAliasedRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:718:1: ruleAliasedRequiredCapability : ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) ;
    public final void ruleAliasedRequiredCapability() throws RecognitionException {
        int ruleAliasedRequiredCapability_StartIndex = input.index();
        Token lv_nameSpace_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;
        Token otherlv_25=null;


        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:722:2: ( ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) )
            // PsiInternalBeeLangTestLanguage.g:723:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:723:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:724:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:724:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==13) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:725:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:725:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:726:5: (lv_nameSpace_0_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:726:5: (lv_nameSpace_0_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:727:6: lv_nameSpace_0_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getAliasedRequiredCapability_NameSpaceIDTerminalRuleCall_0_0_0ElementType());
                      					
                    }
                    lv_nameSpace_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_0_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:737:4: otherlv_1= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAliasedRequiredCapability_UnitKeyword_0_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:745:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:746:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:746:4: (lv_name_2_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:747:5: lv_name_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getAliasedRequiredCapability_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_2_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:756:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:757:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAliasedRequiredCapability_AsKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:764:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:765:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:765:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:766:6: lv_alias_4_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getAliasedRequiredCapability_AliasIDTerminalRuleCall_2_1_0ElementType());
                      					
                    }
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_4_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:776:3: (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            // PsiInternalBeeLangTestLanguage.g:777:4: otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getAliasedRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_5);
              			
            }
            // PsiInternalBeeLangTestLanguage.g:784:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) )
            // PsiInternalBeeLangTestLanguage.g:785:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            {
            // PsiInternalBeeLangTestLanguage.g:785:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:786:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalBeeLangTestLanguage.g:789:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:790:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:790:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            loop19:
            do {
                int alt19=6;
                int LA19_0 = input.LA(1);

                if ( LA19_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
                    alt19=1;
                }
                else if ( LA19_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
                    alt19=2;
                }
                else if ( LA19_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
                    alt19=3;
                }
                else if ( LA19_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
                    alt19=4;
                }
                else if ( LA19_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
                    alt19=5;
                }


                switch (alt19) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:791:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:791:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:792:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:792:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:793:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalBeeLangTestLanguage.g:796:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:796:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:796:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:796:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_WhenKeyword_3_1_0_0ElementType());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_7);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_0_1ElementType());
            	      									
            	    }
            	    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_8);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:810:10: ( (lv_condExpr_9_0= ruleExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:811:11: (lv_condExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:811:11: (lv_condExpr_9_0= ruleExpression )
            	    // PsiInternalBeeLangTestLanguage.g:812:12: lv_condExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markComposite(elementTypeProvider.getAliasedRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
            	      											
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneComposite();
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_0_3ElementType());
            	      									
            	    }
            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_10);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:834:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:834:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:835:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:835:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:836:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalBeeLangTestLanguage.g:839:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:839:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:839:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:839:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:839:21: ( (lv_greedy_11_0= 'greedy' ) )
            	    // PsiInternalBeeLangTestLanguage.g:840:11: (lv_greedy_11_0= 'greedy' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:840:11: (lv_greedy_11_0= 'greedy' )
            	    // PsiInternalBeeLangTestLanguage.g:841:12: lv_greedy_11_0= 'greedy'
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
            	      											
            	    }
            	    lv_greedy_11_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_greedy_11_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_1_1ElementType());
            	      									
            	    }
            	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_12);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:863:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:863:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:864:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:864:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:865:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalBeeLangTestLanguage.g:868:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:868:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:868:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:868:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_13);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_2_1ElementType());
            	      									
            	    }
            	    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_14);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:882:10: ( (lv_min_15_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:883:11: (lv_min_15_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:883:11: (lv_min_15_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:884:12: lv_min_15_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
            	      											
            	    }
            	    lv_min_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_min_15_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_2_3ElementType());
            	      									
            	    }
            	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_16);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalBeeLangTestLanguage.g:906:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:906:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:907:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:907:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:908:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalBeeLangTestLanguage.g:911:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:911:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:911:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:911:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_17);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_3_1ElementType());
            	      									
            	    }
            	    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_18);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:925:10: ( (lv_max_19_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:926:11: (lv_max_19_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:926:11: (lv_max_19_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:927:12: lv_max_19_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
            	      											
            	    }
            	    lv_max_19_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_max_19_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_3_3ElementType());
            	      									
            	    }
            	    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_20);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalBeeLangTestLanguage.g:949:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:949:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:950:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:950:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:951:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalBeeLangTestLanguage.g:954:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:954:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:954:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:954:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionKeyword_3_1_4_0ElementType());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_21);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_4_1ElementType());
            	      									
            	    }
            	    otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_22);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:968:10: ( (lv_versionRange_23_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:969:11: (lv_versionRange_23_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:969:11: (lv_versionRange_23_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:970:12: lv_versionRange_23_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
            	      											
            	    }
            	    lv_versionRange_23_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_versionRange_23_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_4_3ElementType());
            	      									
            	    }
            	    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_24);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

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

            getUnorderedGroupHelper().leave(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            }

            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getAliasedRequiredCapability_RightCurlyBracketKeyword_3_2ElementType());
              			
            }
            otherlv_25=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_25);
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, ruleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleAliasedRequiredCapability"


    // $ANTLR start "entryRuleRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:1014:1: entryRuleRequiredCapability : ruleRequiredCapability EOF ;
    public final void entryRuleRequiredCapability() throws RecognitionException {
        int entryRuleRequiredCapability_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1018:2: ( ruleRequiredCapability EOF )
            // PsiInternalBeeLangTestLanguage.g:1019:2: ruleRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRequiredCapabilityElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRequiredCapability();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleRequiredCapability"


    // $ANTLR start "ruleRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:1027:1: ruleRequiredCapability : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) ;
    public final void ruleRequiredCapability() throws RecognitionException {
        int ruleRequiredCapability_StartIndex = input.index();
        Token lv_nameSpace_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;
        Token otherlv_24=null;


        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1031:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) )
            // PsiInternalBeeLangTestLanguage.g:1032:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1032:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:1033:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:1033:3: ()
            // PsiInternalBeeLangTestLanguage.g:1034:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getRequiredCapability_RequiredCapabilityAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:1042:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==13) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1043:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1043:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:1044:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1044:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:1045:6: lv_nameSpace_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getRequiredCapability_NameSpaceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_1_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1055:4: otherlv_2= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getRequiredCapability_UnitKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1063:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:1064:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:1064:4: (lv_name_3_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:1065:5: lv_name_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getRequiredCapability_NameIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_3_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:1074:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            // PsiInternalBeeLangTestLanguage.g:1075:4: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_4);
              			
            }
            // PsiInternalBeeLangTestLanguage.g:1082:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) )
            // PsiInternalBeeLangTestLanguage.g:1083:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1083:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:1084:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalBeeLangTestLanguage.g:1087:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:1088:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:1088:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            loop21:
            do {
                int alt21=6;
                int LA21_0 = input.LA(1);

                if ( LA21_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
                    alt21=1;
                }
                else if ( LA21_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
                    alt21=2;
                }
                else if ( LA21_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
                    alt21=3;
                }
                else if ( LA21_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
                    alt21=4;
                }
                else if ( LA21_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
                    alt21=5;
                }


                switch (alt21) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:1089:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1089:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1090:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1090:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1091:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalBeeLangTestLanguage.g:1094:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1094:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1094:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1094:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_WhenKeyword_3_1_0_0ElementType());
            	      									
            	    }
            	    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_6);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_0_1ElementType());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_7);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1108:10: ( (lv_condExpr_8_0= ruleExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:1109:11: (lv_condExpr_8_0= ruleExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1109:11: (lv_condExpr_8_0= ruleExpression )
            	    // PsiInternalBeeLangTestLanguage.g:1110:12: lv_condExpr_8_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markComposite(elementTypeProvider.getRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
            	      											
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneComposite();
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_0_3ElementType());
            	      									
            	    }
            	    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_9);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:1132:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1132:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1133:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1133:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1134:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalBeeLangTestLanguage.g:1137:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1137:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1137:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1137:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1137:21: ( (lv_greedy_10_0= 'greedy' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1138:11: (lv_greedy_10_0= 'greedy' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1138:11: (lv_greedy_10_0= 'greedy' )
            	    // PsiInternalBeeLangTestLanguage.g:1139:12: lv_greedy_10_0= 'greedy'
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
            	      											
            	    }
            	    lv_greedy_10_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_greedy_10_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_1_1ElementType());
            	      									
            	    }
            	    otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_11);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:1161:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1161:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1162:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1162:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1163:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalBeeLangTestLanguage.g:1166:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1166:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1166:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1166:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
            	      									
            	    }
            	    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_12);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_2_1ElementType());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_13);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1180:10: ( (lv_min_14_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:1181:11: (lv_min_14_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1181:11: (lv_min_14_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:1182:12: lv_min_14_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
            	      											
            	    }
            	    lv_min_14_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_min_14_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_2_3ElementType());
            	      									
            	    }
            	    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_15);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalBeeLangTestLanguage.g:1204:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1204:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1205:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1205:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1206:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalBeeLangTestLanguage.g:1209:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1209:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1209:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1209:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
            	      									
            	    }
            	    otherlv_16=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_16);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_3_1ElementType());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_17);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1223:10: ( (lv_max_18_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:1224:11: (lv_max_18_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1224:11: (lv_max_18_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:1225:12: lv_max_18_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
            	      											
            	    }
            	    lv_max_18_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_max_18_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_3_3ElementType());
            	      									
            	    }
            	    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_19);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalBeeLangTestLanguage.g:1247:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1247:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1248:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1248:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1249:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalBeeLangTestLanguage.g:1252:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1252:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1252:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1252:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_VersionKeyword_3_1_4_0ElementType());
            	      									
            	    }
            	    otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_20);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_4_1ElementType());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_21);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1266:10: ( (lv_versionRange_22_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:1267:11: (lv_versionRange_22_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1267:11: (lv_versionRange_22_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:1268:12: lv_versionRange_22_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
            	      											
            	    }
            	    lv_versionRange_22_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_versionRange_22_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_4_3ElementType());
            	      									
            	    }
            	    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_23);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

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

            getUnorderedGroupHelper().leave(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            }

            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getRequiredCapability_RightCurlyBracketKeyword_3_2ElementType());
              			
            }
            otherlv_24=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_24);
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, ruleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleRequiredCapability"


    // $ANTLR start "entryRulePath"
    // PsiInternalBeeLangTestLanguage.g:1312:1: entryRulePath : rulePath EOF ;
    public final void entryRulePath() throws RecognitionException {
        int entryRulePath_StartIndex = input.index();

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1314:2: ( rulePath EOF )
            // PsiInternalBeeLangTestLanguage.g:1315:2: rulePath EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPathElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePath();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // PsiInternalBeeLangTestLanguage.g:1323:1: rulePath : (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) ;
    public final void rulePath() throws RecognitionException {
        int rulePath_StartIndex = input.index();
        Token this_STRING_0=null;
        Token kw=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1325:2: ( (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) )
            // PsiInternalBeeLangTestLanguage.g:1326:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1326:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_STRING) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID||LA25_0==32) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1327:3: this_STRING_0= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getPath_STRINGTerminalRuleCall_0ElementType());
                      		
                    }
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(this_STRING_0);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1335:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1335:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    // PsiInternalBeeLangTestLanguage.g:1336:4: (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )?
                    {
                    // PsiInternalBeeLangTestLanguage.g:1336:4: (kw= '/' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==32) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:1337:5: kw= '/'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_0ElementType());
                              				
                            }
                            kw=(Token)match(input,32,FollowSets000.FOLLOW_13); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getPath_QIDParserRuleCall_1_1ElementType());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    ruleQID();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:1352:4: (kw= '/' ruleQID )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==32) ) {
                            int LA23_1 = input.LA(2);

                            if ( (LA23_1==RULE_ID) ) {
                                alt23=1;
                            }


                        }


                        switch (alt23) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:1353:5: kw= '/' ruleQID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    kw=(Token)match(input,32,FollowSets000.FOLLOW_13); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(kw);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getPath_QIDParserRuleCall_1_2_1ElementType());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    ruleQID();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // PsiInternalBeeLangTestLanguage.g:1368:4: (kw= '/' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==32) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:1369:5: kw= '/'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_3ElementType());
                              				
                            }
                            kw=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

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
            if ( state.backtracking>0 ) { memoize(input, 12, rulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleParameterList"
    // PsiInternalBeeLangTestLanguage.g:1385:1: entryRuleParameterList : ruleParameterList EOF ;
    public final void entryRuleParameterList() throws RecognitionException {
        int entryRuleParameterList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1385:23: ( ruleParameterList EOF )
            // PsiInternalBeeLangTestLanguage.g:1386:2: ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterListElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameterList();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRuleParameterList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // PsiInternalBeeLangTestLanguage.g:1391:1: ruleParameterList : ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) ;
    public final void ruleParameterList() throws RecognitionException {
        int ruleParameterList_StartIndex = input.index();
        Token otherlv_1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1391:18: ( ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:1392:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:1392:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:1393:3: ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:1393:3: ( (lv_parameters_0_0= ruleFirstParameter ) )
            // PsiInternalBeeLangTestLanguage.g:1394:4: (lv_parameters_0_0= ruleFirstParameter )
            {
            // PsiInternalBeeLangTestLanguage.g:1394:4: (lv_parameters_0_0= ruleFirstParameter )
            // PsiInternalBeeLangTestLanguage.g:1395:5: lv_parameters_0_0= ruleFirstParameter
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getParameterList_ParametersFirstParameterParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_26);
            ruleFirstParameter();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:1404:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:1405:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getParameterList_CommaKeyword_1_0ElementType());
            	      			
            	    }
            	    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_1);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1412:4: ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    // PsiInternalBeeLangTestLanguage.g:1413:5: (lv_parameters_2_0= ruleFirstParameter )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1413:5: (lv_parameters_2_0= ruleFirstParameter )
            	    // PsiInternalBeeLangTestLanguage.g:1414:6: lv_parameters_2_0= ruleFirstParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getParameterList_ParametersFirstParameterParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    ruleFirstParameter();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
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
            if ( state.backtracking>0 ) { memoize(input, 14, ruleParameterList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleFirstParameter"
    // PsiInternalBeeLangTestLanguage.g:1428:1: entryRuleFirstParameter : ruleFirstParameter EOF ;
    public final void entryRuleFirstParameter() throws RecognitionException {
        int entryRuleFirstParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1428:24: ( ruleFirstParameter EOF )
            // PsiInternalBeeLangTestLanguage.g:1429:2: ruleFirstParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFirstParameterElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFirstParameter();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRuleFirstParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFirstParameter"


    // $ANTLR start "ruleFirstParameter"
    // PsiInternalBeeLangTestLanguage.g:1434:1: ruleFirstParameter : ( ruleClosureParameter | ruleParameter ) ;
    public final void ruleFirstParameter() throws RecognitionException {
        int ruleFirstParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1434:19: ( ( ruleClosureParameter | ruleParameter ) )
            // PsiInternalBeeLangTestLanguage.g:1435:2: ( ruleClosureParameter | ruleParameter )
            {
            // PsiInternalBeeLangTestLanguage.g:1435:2: ( ruleClosureParameter | ruleParameter )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1436:3: ruleClosureParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFirstParameter_ClosureParameterParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleClosureParameter();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1447:3: ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFirstParameter_ParameterParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParameter();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 16, ruleFirstParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFirstParameter"


    // $ANTLR start "entryRuleParameter"
    // PsiInternalBeeLangTestLanguage.g:1461:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        int entryRuleParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1461:19: ( ruleParameter EOF )
            // PsiInternalBeeLangTestLanguage.g:1462:2: ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameter();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // PsiInternalBeeLangTestLanguage.g:1467:1: ruleParameter : ( (lv_expr_0_0= ruleExpression ) ) ;
    public final void ruleParameter() throws RecognitionException {
        int ruleParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1467:14: ( ( (lv_expr_0_0= ruleExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:1468:2: ( (lv_expr_0_0= ruleExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1468:2: ( (lv_expr_0_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:1469:3: (lv_expr_0_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:1469:3: (lv_expr_0_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:1470:4: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getParameter_ExprExpressionParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneComposite();
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, ruleParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleClosureParameter"
    // PsiInternalBeeLangTestLanguage.g:1482:1: entryRuleClosureParameter : ruleClosureParameter EOF ;
    public final void entryRuleClosureParameter() throws RecognitionException {
        int entryRuleClosureParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1482:26: ( ruleClosureParameter EOF )
            // PsiInternalBeeLangTestLanguage.g:1483:2: ruleClosureParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureParameterElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClosureParameter();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleClosureParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleClosureParameter"


    // $ANTLR start "ruleClosureParameter"
    // PsiInternalBeeLangTestLanguage.g:1488:1: ruleClosureParameter : ( (lv_expr_0_0= ruleClosureExpression ) ) ;
    public final void ruleClosureParameter() throws RecognitionException {
        int ruleClosureParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1488:21: ( ( (lv_expr_0_0= ruleClosureExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:1489:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1489:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            // PsiInternalBeeLangTestLanguage.g:1490:3: (lv_expr_0_0= ruleClosureExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:1490:3: (lv_expr_0_0= ruleClosureExpression )
            // PsiInternalBeeLangTestLanguage.g:1491:4: lv_expr_0_0= ruleClosureExpression
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getClosureParameter_ExprClosureExpressionParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleClosureExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneComposite();
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, ruleClosureParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleClosureParameter"


    // $ANTLR start "entryRuleParameterDeclaration"
    // PsiInternalBeeLangTestLanguage.g:1503:1: entryRuleParameterDeclaration : ruleParameterDeclaration EOF ;
    public final void entryRuleParameterDeclaration() throws RecognitionException {
        int entryRuleParameterDeclaration_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1503:30: ( ruleParameterDeclaration EOF )
            // PsiInternalBeeLangTestLanguage.g:1504:2: ruleParameterDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterDeclarationElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameterDeclaration();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleParameterDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // PsiInternalBeeLangTestLanguage.g:1509:1: ruleParameterDeclaration : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleParameterDeclaration() throws RecognitionException {
        int ruleParameterDeclaration_StartIndex = input.index();
        Token lv_name_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1509:25: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:1510:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1510:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:1511:3: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1511:3: ( (lv_type_0_0= ruleTypeRef ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==35) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID) ) {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==RULE_ID||LA28_2==52) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1512:4: (lv_type_0_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1512:4: (lv_type_0_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:1513:5: lv_type_0_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getParameterDeclaration_TypeTypeRefParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1522:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:1523:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:1523:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:1524:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, ruleParameterDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleFunction"
    // PsiInternalBeeLangTestLanguage.g:1537:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        int entryRuleFunction_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1537:18: ( ruleFunction EOF )
            // PsiInternalBeeLangTestLanguage.g:1538:2: ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFunctionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFunction();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // PsiInternalBeeLangTestLanguage.g:1543:1: ruleFunction : ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) ;
    public final void ruleFunction() throws RecognitionException {
        int ruleFunction_StartIndex = input.index();
        Token lv_documentation_0_0=null;
        Token lv_visibility_1_0=null;
        Token lv_final_2_0=null;
        Token otherlv_3=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_varArgs_11_0=null;
        Token lv_varArgs_13_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1543:13: ( ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:1544:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1544:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:1545:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1545:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_DOCUMENTATION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1546:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1546:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    // PsiInternalBeeLangTestLanguage.g:1547:5: lv_documentation_0_0= RULE_DOCUMENTATION
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_DocumentationDOCUMENTATIONTerminalRuleCall_0_0ElementType());
                      				
                    }
                    lv_documentation_0_0=(Token)match(input,RULE_DOCUMENTATION,FollowSets000.FOLLOW_28); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_documentation_0_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1556:3: ( (lv_visibility_1_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1557:4: (lv_visibility_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1557:4: (lv_visibility_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:1558:5: lv_visibility_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_VisibilityIDTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_visibility_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_visibility_1_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1567:3: ( (lv_final_2_0= 'final' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1568:4: (lv_final_2_0= 'final' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1568:4: (lv_final_2_0= 'final' )
                    // PsiInternalBeeLangTestLanguage.g:1569:5: lv_final_2_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_FinalFinalKeyword_2_0ElementType());
                      				
                    }
                    lv_final_2_0=(Token)match(input,33,FollowSets000.FOLLOW_30); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_2_0);
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFunction_FunctionKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_31); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:1585:3: ( (lv_returnType_4_0= ruleTypeRef ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==35) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                int LA32_2 = input.LA(2);

                if ( (LA32_2==RULE_ID||LA32_2==52) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1586:4: (lv_returnType_4_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1586:4: (lv_returnType_4_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:1587:5: lv_returnType_4_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getFunction_ReturnTypeTypeRefParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1596:3: ( (lv_name_5_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:1597:4: (lv_name_5_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:1597:4: (lv_name_5_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:1598:5: lv_name_5_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFunction_NameIDTerminalRuleCall_5_0ElementType());
              				
            }
            lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_5_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:1607:3: (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1608:4: otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_LeftParenthesisKeyword_6_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,35,FollowSets000.FOLLOW_33); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:1615:4: ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )?
                    int alt35=3;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_ID||LA35_0==35) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==36) ) {
                        alt35=2;
                    }
                    switch (alt35) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:1616:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1616:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            // PsiInternalBeeLangTestLanguage.g:1617:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            {
                            // PsiInternalBeeLangTestLanguage.g:1617:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                            // PsiInternalBeeLangTestLanguage.g:1618:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1618:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            // PsiInternalBeeLangTestLanguage.g:1619:8: lv_parameters_7_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_34);
                            ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:1628:6: (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==16) ) {
                                    int LA33_1 = input.LA(2);

                                    if ( (LA33_1==RULE_ID||LA33_1==35) ) {
                                        alt33=1;
                                    }


                                }


                                switch (alt33) {
                            	case 1 :
                            	    // PsiInternalBeeLangTestLanguage.g:1629:7: otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_8);
                            	      						
                            	    }
                            	    // PsiInternalBeeLangTestLanguage.g:1636:7: ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    // PsiInternalBeeLangTestLanguage.g:1637:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    {
                            	    // PsiInternalBeeLangTestLanguage.g:1637:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    // PsiInternalBeeLangTestLanguage.g:1638:9: lv_parameters_9_0= ruleParameterDeclaration
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_34);
                            	    ruleParameterDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);

                            // PsiInternalBeeLangTestLanguage.g:1648:6: (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==16) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // PsiInternalBeeLangTestLanguage.g:1649:7: otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    {
                                    if ( state.backtracking==0 ) {

                                      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_2_0ElementType());
                                      						
                                    }
                                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      							doneLeaf(otherlv_10);
                                      						
                                    }
                                    // PsiInternalBeeLangTestLanguage.g:1656:7: ( (lv_varArgs_11_0= '...' ) )
                                    // PsiInternalBeeLangTestLanguage.g:1657:8: (lv_varArgs_11_0= '...' )
                                    {
                                    // PsiInternalBeeLangTestLanguage.g:1657:8: (lv_varArgs_11_0= '...' )
                                    // PsiInternalBeeLangTestLanguage.g:1658:9: lv_varArgs_11_0= '...'
                                    {
                                    if ( state.backtracking==0 ) {

                                      									markLeaf(elementTypeProvider.getFunction_VarArgsFullStopFullStopFullStopKeyword_6_1_0_2_1_0ElementType());
                                      								
                                    }
                                    lv_varArgs_11_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      									doneLeaf(lv_varArgs_11_0);
                                      								
                                    }

                                    }


                                    }

                                    // PsiInternalBeeLangTestLanguage.g:1667:7: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    // PsiInternalBeeLangTestLanguage.g:1668:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    {
                                    // PsiInternalBeeLangTestLanguage.g:1668:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    // PsiInternalBeeLangTestLanguage.g:1669:9: lv_parameters_12_0= ruleParameterDeclaration
                                    {
                                    if ( state.backtracking==0 ) {

                                      									markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_2_2_0ElementType());
                                      								
                                    }
                                    pushFollow(FollowSets000.FOLLOW_37);
                                    ruleParameterDeclaration();

                                    state._fsp--;
                                    if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      									doneComposite();
                                      								
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalBeeLangTestLanguage.g:1681:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1681:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            // PsiInternalBeeLangTestLanguage.g:1682:6: ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1682:6: ( (lv_varArgs_13_0= '...' ) )
                            // PsiInternalBeeLangTestLanguage.g:1683:7: (lv_varArgs_13_0= '...' )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1683:7: (lv_varArgs_13_0= '...' )
                            // PsiInternalBeeLangTestLanguage.g:1684:8: lv_varArgs_13_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getFunction_VarArgsFullStopFullStopFullStopKeyword_6_1_1_0_0ElementType());
                              							
                            }
                            lv_varArgs_13_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_varArgs_13_0);
                              							
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:1693:6: ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            // PsiInternalBeeLangTestLanguage.g:1694:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1694:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            // PsiInternalBeeLangTestLanguage.g:1695:8: lv_parameters_14_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_1_1_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_RightParenthesisKeyword_6_2ElementType());
                      			
                    }
                    otherlv_15=(Token)match(input,37,FollowSets000.FOLLOW_38); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_15);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1714:3: (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1715:4: otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_WhenKeyword_7_0ElementType());
                      			
                    }
                    otherlv_16=(Token)match(input,26,FollowSets000.FOLLOW_39); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_16);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:1722:4: ( (lv_guard_17_0= ruleGuardExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:1723:5: (lv_guard_17_0= ruleGuardExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1723:5: (lv_guard_17_0= ruleGuardExpression )
                    // PsiInternalBeeLangTestLanguage.g:1724:6: lv_guard_17_0= ruleGuardExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getFunction_GuardGuardExpressionParserRuleCall_7_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    ruleGuardExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1734:3: ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            else if ( (LA38_0==17) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1735:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1735:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    // PsiInternalBeeLangTestLanguage.g:1736:5: otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_ColonKeyword_8_0_0ElementType());
                      				
                    }
                    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_18);
                      				
                    }
                    // PsiInternalBeeLangTestLanguage.g:1743:5: ( (lv_funcExpr_19_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:1744:6: (lv_funcExpr_19_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1744:6: (lv_funcExpr_19_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:1745:7: lv_funcExpr_19_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getFunction_FuncExprExpressionParserRuleCall_8_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_SemicolonKeyword_8_0_2ElementType());
                      				
                    }
                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_20);
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1763:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1763:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:1764:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1764:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    // PsiInternalBeeLangTestLanguage.g:1765:6: lv_funcExpr_21_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getFunction_FuncExprBlockExpressionParserRuleCall_8_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, ruleFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGuardExpression"
    // PsiInternalBeeLangTestLanguage.g:1779:1: entryRuleGuardExpression : ruleGuardExpression EOF ;
    public final void entryRuleGuardExpression() throws RecognitionException {
        int entryRuleGuardExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1779:25: ( ruleGuardExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:1780:2: ruleGuardExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getGuardExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGuardExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleGuardExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleGuardExpression"


    // $ANTLR start "ruleGuardExpression"
    // PsiInternalBeeLangTestLanguage.g:1785:1: ruleGuardExpression : ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) ;
    public final void ruleGuardExpression() throws RecognitionException {
        int ruleGuardExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1785:20: ( ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:1786:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1786:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) ) {
                alt39=1;
            }
            else if ( (LA39_0==17) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1787:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1787:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    // PsiInternalBeeLangTestLanguage.g:1788:4: otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getGuardExpression_ColonKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:1795:4: ( (lv_guardExpr_1_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:1796:5: (lv_guardExpr_1_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1796:5: (lv_guardExpr_1_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:1797:6: lv_guardExpr_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getGuardExpression_GuardExprExpressionParserRuleCall_0_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getGuardExpression_SemicolonKeyword_0_2ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1815:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1815:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:1816:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1816:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    // PsiInternalBeeLangTestLanguage.g:1817:5: lv_guardExpr_3_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getGuardExpression_GuardExprBlockExpressionParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
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
            if ( state.backtracking>0 ) { memoize(input, 26, ruleGuardExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleGuardExpression"


    // $ANTLR start "entryRuleAssignmentOperator"
    // PsiInternalBeeLangTestLanguage.g:1830:1: entryRuleAssignmentOperator : ruleAssignmentOperator EOF ;
    public final void entryRuleAssignmentOperator() throws RecognitionException {
        int entryRuleAssignmentOperator_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1830:28: ( ruleAssignmentOperator EOF )
            // PsiInternalBeeLangTestLanguage.g:1831:2: ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAssignmentOperatorElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleAssignmentOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // PsiInternalBeeLangTestLanguage.g:1836:1: ruleAssignmentOperator : (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) ;
    public final void ruleAssignmentOperator() throws RecognitionException {
        int ruleAssignmentOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1836:23: ( (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) )
            // PsiInternalBeeLangTestLanguage.g:1837:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            {
            // PsiInternalBeeLangTestLanguage.g:1837:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt40=1;
                }
                break;
            case 39:
                {
                alt40=2;
                }
                break;
            case 40:
                {
                alt40=3;
                }
                break;
            case 41:
                {
                alt40=4;
                }
                break;
            case 42:
                {
                alt40=5;
                }
                break;
            case 43:
                {
                alt40=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1838:3: kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_EqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1846:3: kw= '+='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_PlusSignEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:1854:3: kw= '-='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_HyphenMinusEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:1862:3: kw= '*='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_AsteriskEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:1870:3: kw= '/='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_SolidusEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:1878:3: kw= '%='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_PercentSignEqualsSignKeyword_5ElementType());
                      		
                    }
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 28, ruleAssignmentOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // PsiInternalBeeLangTestLanguage.g:1889:1: entryRuleRelationalOperator : ruleRelationalOperator EOF ;
    public final void entryRuleRelationalOperator() throws RecognitionException {
        int entryRuleRelationalOperator_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1889:28: ( ruleRelationalOperator EOF )
            // PsiInternalBeeLangTestLanguage.g:1890:2: ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRelationalOperatorElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleRelationalOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // PsiInternalBeeLangTestLanguage.g:1895:1: ruleRelationalOperator : (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final void ruleRelationalOperator() throws RecognitionException {
        int ruleRelationalOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1895:23: ( (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // PsiInternalBeeLangTestLanguage.g:1896:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // PsiInternalBeeLangTestLanguage.g:1896:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt41=9;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt41=1;
                }
                break;
            case 45:
                {
                alt41=2;
                }
                break;
            case 46:
                {
                alt41=3;
                }
                break;
            case 47:
                {
                alt41=4;
                }
                break;
            case 48:
                {
                alt41=5;
                }
                break;
            case 49:
                {
                alt41=6;
                }
                break;
            case 50:
                {
                alt41=7;
                }
                break;
            case 51:
                {
                alt41=8;
                }
                break;
            case 52:
                {
                alt41=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1897:3: kw= '~='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_TildeEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1905:3: kw= '=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_EqualsSignEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:1913:3: kw= '==='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:1921:3: kw= '!='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_ExclamationMarkEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:1929:3: kw= '!=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_ExclamationMarkEqualsSignEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:1937:3: kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_GreaterThanSignEqualsSignKeyword_5ElementType());
                      		
                    }
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalBeeLangTestLanguage.g:1945:3: kw= '<='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_LessThanSignEqualsSignKeyword_6ElementType());
                      		
                    }
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalBeeLangTestLanguage.g:1953:3: kw= '>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_GreaterThanSignKeyword_7ElementType());
                      		
                    }
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalBeeLangTestLanguage.g:1961:3: kw= '<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_LessThanSignKeyword_8ElementType());
                      		
                    }
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 30, ruleRelationalOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleTopLevelExpression"
    // PsiInternalBeeLangTestLanguage.g:1972:1: entryRuleTopLevelExpression : ruleTopLevelExpression EOF ;
    public final void entryRuleTopLevelExpression() throws RecognitionException {
        int entryRuleTopLevelExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1972:28: ( ruleTopLevelExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:1973:2: ruleTopLevelExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getTopLevelExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTopLevelExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleTopLevelExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleTopLevelExpression"


    // $ANTLR start "ruleTopLevelExpression"
    // PsiInternalBeeLangTestLanguage.g:1978:1: ruleTopLevelExpression : ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression ) ;
    public final void ruleTopLevelExpression() throws RecognitionException {
        int ruleTopLevelExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:1978:23: ( ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression ) )
            // PsiInternalBeeLangTestLanguage.g:1979:2: ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:1979:2: ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1980:3: ruleVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_VarDeclarationParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleVarDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1991:3: ruleValDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_ValDeclarationParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleValDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:2002:3: ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_AssignmentExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 32, ruleTopLevelExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleTopLevelExpression"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalBeeLangTestLanguage.g:2016:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        int entryRuleExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2016:20: ( ruleExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2017:2: ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalBeeLangTestLanguage.g:2022:1: ruleExpression : ruleAssignmentExpression ;
    public final void ruleExpression() throws RecognitionException {
        int ruleExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2022:15: ( ruleAssignmentExpression )
            // PsiInternalBeeLangTestLanguage.g:2023:2: ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getExpression_AssignmentExpressionParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		doneComposite();
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, ruleExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // PsiInternalBeeLangTestLanguage.g:2036:1: entryRuleAssignmentExpression : ruleAssignmentExpression EOF ;
    public final void entryRuleAssignmentExpression() throws RecognitionException {
        int entryRuleAssignmentExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2036:30: ( ruleAssignmentExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2037:2: ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAssignmentExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleAssignmentExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // PsiInternalBeeLangTestLanguage.g:2042:1: ruleAssignmentExpression : ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final void ruleAssignmentExpression() throws RecognitionException {
        int ruleAssignmentExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2042:25: ( ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:2043:2: ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:2043:2: ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            // PsiInternalBeeLangTestLanguage.g:2044:3: ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAssignmentExpression_CachedExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_40);
            ruleCachedExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2054:3: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            int alt43=2;
            switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA43_1 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 39:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA43_5 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA43_6 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
            }

            switch (alt43) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2055:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2055:4: ()
                    // PsiInternalBeeLangTestLanguage.g:2056:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getAssignmentExpression_AssignmentExpressionLeftExprAction_1_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalBeeLangTestLanguage.g:2064:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
                    // PsiInternalBeeLangTestLanguage.g:2065:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2065:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    // PsiInternalBeeLangTestLanguage.g:2066:6: lv_functionName_2_0= ruleAssignmentOperator
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getAssignmentExpression_FunctionNameAssignmentOperatorParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_19);
                    ruleAssignmentOperator();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2075:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2076:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2076:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    // PsiInternalBeeLangTestLanguage.g:2077:6: lv_rightExpr_3_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getAssignmentExpression_RightExprAssignmentExpressionParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, ruleAssignmentExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleVarDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2091:1: entryRuleVarDeclaration : ruleVarDeclaration EOF ;
    public final void entryRuleVarDeclaration() throws RecognitionException {
        int entryRuleVarDeclaration_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2091:24: ( ruleVarDeclaration EOF )
            // PsiInternalBeeLangTestLanguage.g:2092:2: ruleVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getVarDeclarationElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleVarDeclaration();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleVarDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2097:1: ruleVarDeclaration : ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) ;
    public final void ruleVarDeclaration() throws RecognitionException {
        int ruleVarDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2097:19: ( ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:2098:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:2098:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            // PsiInternalBeeLangTestLanguage.g:2099:3: () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            {
            // PsiInternalBeeLangTestLanguage.g:2099:3: ()
            // PsiInternalBeeLangTestLanguage.g:2100:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getVarDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:2108:3: ( (lv_final_1_0= 'final' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==33) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2109:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2109:4: (lv_final_1_0= 'final' )
                    // PsiInternalBeeLangTestLanguage.g:2110:5: lv_final_1_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getVarDeclaration_FinalFinalKeyword_1_0ElementType());
                      				
                    }
                    lv_final_1_0=(Token)match(input,33,FollowSets000.FOLLOW_41); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_1_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2119:3: ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:2120:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2120:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==53) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_ID||LA45_0==35) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2121:5: otherlv_2= 'var'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getVarDeclaration_VarKeyword_2_0_0ElementType());
                      				
                    }
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_2);
                      				
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2129:5: ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2129:5: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalBeeLangTestLanguage.g:2130:6: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2130:6: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:2131:7: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getVarDeclaration_TypeTypeRefParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2141:4: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2142:5: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2142:5: (lv_name_4_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2143:6: lv_name_4_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						markLeaf(elementTypeProvider.getVarDeclaration_NameIDTerminalRuleCall_2_1_0ElementType());
              					
            }
            lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_42); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              						doneLeaf(lv_name_4_0);
              					
            }

            }


            }


            }

            // PsiInternalBeeLangTestLanguage.g:2153:3: (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2154:4: otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getVarDeclaration_EqualsSignKeyword_3_0ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:2161:4: ( (lv_valueExpr_6_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2162:5: (lv_valueExpr_6_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2162:5: (lv_valueExpr_6_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:2163:6: lv_valueExpr_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getVarDeclaration_ValueExprExpressionParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, ruleVarDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleValDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2177:1: entryRuleValDeclaration : ruleValDeclaration EOF ;
    public final void entryRuleValDeclaration() throws RecognitionException {
        int entryRuleValDeclaration_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2177:24: ( ruleValDeclaration EOF )
            // PsiInternalBeeLangTestLanguage.g:2178:2: ruleValDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValDeclarationElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleValDeclaration();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleValDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleValDeclaration"


    // $ANTLR start "ruleValDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2183:1: ruleValDeclaration : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) ;
    public final void ruleValDeclaration() throws RecognitionException {
        int ruleValDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token lv_immutable_2_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2183:19: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:2184:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2184:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:2185:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2185:3: ()
            // PsiInternalBeeLangTestLanguage.g:2186:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:2194:3: ( (lv_final_1_0= 'final' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==33) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2195:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2195:4: (lv_final_1_0= 'final' )
                    // PsiInternalBeeLangTestLanguage.g:2196:5: lv_final_1_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getValDeclaration_FinalFinalKeyword_1_0ElementType());
                      				
                    }
                    lv_final_1_0=(Token)match(input,33,FollowSets000.FOLLOW_43); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_1_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2205:3: ( (lv_immutable_2_0= 'val' ) )
            // PsiInternalBeeLangTestLanguage.g:2206:4: (lv_immutable_2_0= 'val' )
            {
            // PsiInternalBeeLangTestLanguage.g:2206:4: (lv_immutable_2_0= 'val' )
            // PsiInternalBeeLangTestLanguage.g:2207:5: lv_immutable_2_0= 'val'
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValDeclaration_ImmutableValKeyword_2_0ElementType());
              				
            }
            lv_immutable_2_0=(Token)match(input,54,FollowSets000.FOLLOW_31); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_immutable_2_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:2216:3: ( (lv_type_3_0= ruleTypeRef ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==35) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_ID) ) {
                int LA48_2 = input.LA(2);

                if ( (LA48_2==RULE_ID||LA48_2==52) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2217:4: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2217:4: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:2218:5: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getValDeclaration_TypeTypeRefParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2227:3: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2228:4: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2228:4: (lv_name_4_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2229:5: lv_name_4_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValDeclaration_NameIDTerminalRuleCall_4_0ElementType());
              				
            }
            lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_44); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_4_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getValDeclaration_EqualsSignKeyword_5ElementType());
              		
            }
            otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_19); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2245:3: ( (lv_valueExpr_6_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:2246:4: (lv_valueExpr_6_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:2246:4: (lv_valueExpr_6_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:2247:5: lv_valueExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getValDeclaration_ValueExprExpressionParserRuleCall_6_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, ruleValDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleValDeclaration"


    // $ANTLR start "entryRuleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2260:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        int entryRuleTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2260:17: ( ruleTypeRef EOF )
            // PsiInternalBeeLangTestLanguage.g:2261:2: ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getTypeRefElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2266:1: ruleTypeRef : ( ruleClosureTypeRef | ruleSimpleTypeRef ) ;
    public final void ruleTypeRef() throws RecognitionException {
        int ruleTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2266:12: ( ( ruleClosureTypeRef | ruleSimpleTypeRef ) )
            // PsiInternalBeeLangTestLanguage.g:2267:2: ( ruleClosureTypeRef | ruleSimpleTypeRef )
            {
            // PsiInternalBeeLangTestLanguage.g:2267:2: ( ruleClosureTypeRef | ruleSimpleTypeRef )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==35) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_ID) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2268:3: ruleClosureTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTypeRef_ClosureTypeRefParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleClosureTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2279:3: ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTypeRef_SimpleTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 42, ruleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleSimpleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2293:1: entryRuleSimpleTypeRef : ruleSimpleTypeRef EOF ;
    public final void entryRuleSimpleTypeRef() throws RecognitionException {
        int entryRuleSimpleTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2293:23: ( ruleSimpleTypeRef EOF )
            // PsiInternalBeeLangTestLanguage.g:2294:2: ruleSimpleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSimpleTypeRefElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSimpleTypeRef();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleSimpleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleTypeRef"


    // $ANTLR start "ruleSimpleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2299:1: ruleSimpleTypeRef : ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) ;
    public final void ruleSimpleTypeRef() throws RecognitionException {
        int ruleSimpleTypeRef_StartIndex = input.index();
        Token lv_rawType_0_0=null;
        Token otherlv_1=null;
        Token lv_actualArgumentsList_2_0=null;
        Token otherlv_3=null;
        Token lv_actualArgumentsList_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2299:18: ( ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) )
            // PsiInternalBeeLangTestLanguage.g:2300:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            {
            // PsiInternalBeeLangTestLanguage.g:2300:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            // PsiInternalBeeLangTestLanguage.g:2301:3: ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            {
            // PsiInternalBeeLangTestLanguage.g:2301:3: ( (lv_rawType_0_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2302:4: (lv_rawType_0_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2302:4: (lv_rawType_0_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2303:5: lv_rawType_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getSimpleTypeRef_RawTypeIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_rawType_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_45); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_rawType_0_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:2312:3: (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2313:4: otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSimpleTypeRef_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:2320:4: ( (lv_actualArgumentsList_2_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:2321:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2321:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:2322:6: lv_actualArgumentsList_2_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSimpleTypeRef_ActualArgumentsListIDTerminalRuleCall_1_1_0ElementType());
                      					
                    }
                    lv_actualArgumentsList_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_actualArgumentsList_2_0);
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2331:4: (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==16) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:2332:5: otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getSimpleTypeRef_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:2339:5: ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:2340:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:2340:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:2341:7: lv_actualArgumentsList_4_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getSimpleTypeRef_ActualArgumentsListIDTerminalRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    lv_actualArgumentsList_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(lv_actualArgumentsList_4_0);
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSimpleTypeRef_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, ruleSimpleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleSimpleTypeRef"


    // $ANTLR start "entryRuleClosureTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2363:1: entryRuleClosureTypeRef : ruleClosureTypeRef EOF ;
    public final void entryRuleClosureTypeRef() throws RecognitionException {
        int entryRuleClosureTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2363:24: ( ruleClosureTypeRef EOF )
            // PsiInternalBeeLangTestLanguage.g:2364:2: ruleClosureTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureTypeRefElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClosureTypeRef();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleClosureTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleClosureTypeRef"


    // $ANTLR start "ruleClosureTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2369:1: ruleClosureTypeRef : (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) ;
    public final void ruleClosureTypeRef() throws RecognitionException {
        int ruleClosureTypeRef_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_parameterTypes_1_0=null;
        Token otherlv_2=null;
        Token lv_parameterTypes_3_0=null;
        Token otherlv_4=null;
        Token lv_varArgs_5_0=null;
        Token lv_parameterTypes_6_0=null;
        Token lv_varArgs_7_0=null;
        Token lv_parameterTypes_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_returnType_11_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2369:19: ( (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:2370:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2370:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:2371:3: otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_47); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2378:3: ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )?
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==36) ) {
                alt54=2;
            }
            switch (alt54) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2379:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2379:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    // PsiInternalBeeLangTestLanguage.g:2380:5: ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    {
                    // PsiInternalBeeLangTestLanguage.g:2380:5: ( (lv_parameterTypes_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:2381:6: (lv_parameterTypes_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2381:6: (lv_parameterTypes_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:2382:7: lv_parameterTypes_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_0_0ElementType());
                      						
                    }
                    lv_parameterTypes_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_34); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_parameterTypes_1_0);
                      						
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2391:5: (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==16) ) {
                            int LA52_1 = input.LA(2);

                            if ( (LA52_1==RULE_ID) ) {
                                alt52=1;
                            }


                        }


                        switch (alt52) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:2392:6: otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_1_0ElementType());
                    	      					
                    	    }
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      						doneLeaf(otherlv_2);
                    	      					
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:2399:6: ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:2400:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:2400:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:2401:8: lv_parameterTypes_3_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_1_1_0ElementType());
                    	      							
                    	    }
                    	    lv_parameterTypes_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_34); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      								doneLeaf(lv_parameterTypes_3_0);
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    // PsiInternalBeeLangTestLanguage.g:2411:5: (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==16) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:2412:6: otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) )
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_2_0ElementType());
                              					
                            }
                            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(otherlv_4);
                              					
                            }
                            // PsiInternalBeeLangTestLanguage.g:2419:6: ( (lv_varArgs_5_0= '...' ) )
                            // PsiInternalBeeLangTestLanguage.g:2420:7: (lv_varArgs_5_0= '...' )
                            {
                            // PsiInternalBeeLangTestLanguage.g:2420:7: (lv_varArgs_5_0= '...' )
                            // PsiInternalBeeLangTestLanguage.g:2421:8: lv_varArgs_5_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getClosureTypeRef_VarArgsFullStopFullStopFullStopKeyword_1_0_2_1_0ElementType());
                              							
                            }
                            lv_varArgs_5_0=(Token)match(input,36,FollowSets000.FOLLOW_8); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_varArgs_5_0);
                              							
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:2430:6: ( (lv_parameterTypes_6_0= RULE_ID ) )
                            // PsiInternalBeeLangTestLanguage.g:2431:7: (lv_parameterTypes_6_0= RULE_ID )
                            {
                            // PsiInternalBeeLangTestLanguage.g:2431:7: (lv_parameterTypes_6_0= RULE_ID )
                            // PsiInternalBeeLangTestLanguage.g:2432:8: lv_parameterTypes_6_0= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_2_2_0ElementType());
                              							
                            }
                            lv_parameterTypes_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_parameterTypes_6_0);
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2444:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2444:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    // PsiInternalBeeLangTestLanguage.g:2445:5: ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2445:5: ( (lv_varArgs_7_0= '...' ) )
                    // PsiInternalBeeLangTestLanguage.g:2446:6: (lv_varArgs_7_0= '...' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2446:6: (lv_varArgs_7_0= '...' )
                    // PsiInternalBeeLangTestLanguage.g:2447:7: lv_varArgs_7_0= '...'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_VarArgsFullStopFullStopFullStopKeyword_1_1_0_0ElementType());
                      						
                    }
                    lv_varArgs_7_0=(Token)match(input,36,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_varArgs_7_0);
                      						
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2456:5: ( (lv_parameterTypes_8_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:2457:6: (lv_parameterTypes_8_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2457:6: (lv_parameterTypes_8_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:2458:7: lv_parameterTypes_8_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_1_1_0ElementType());
                      						
                    }
                    lv_parameterTypes_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_parameterTypes_8_0);
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_9=(Token)match(input,37,FollowSets000.FOLLOW_48); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_9);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_EqualsSignGreaterThanSignKeyword_3ElementType());
              		
            }
            otherlv_10=(Token)match(input,55,FollowSets000.FOLLOW_8); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2483:3: ( (lv_returnType_11_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2484:4: (lv_returnType_11_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2484:4: (lv_returnType_11_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2485:5: lv_returnType_11_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getClosureTypeRef_ReturnTypeIDTerminalRuleCall_4_0ElementType());
              				
            }
            lv_returnType_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_returnType_11_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, ruleClosureTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleClosureTypeRef"


    // $ANTLR start "entryRuleCachedExpression"
    // PsiInternalBeeLangTestLanguage.g:2498:1: entryRuleCachedExpression : ruleCachedExpression EOF ;
    public final void entryRuleCachedExpression() throws RecognitionException {
        int entryRuleCachedExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2498:26: ( ruleCachedExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2499:2: ruleCachedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getCachedExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCachedExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleCachedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleCachedExpression"


    // $ANTLR start "ruleCachedExpression"
    // PsiInternalBeeLangTestLanguage.g:2504:1: ruleCachedExpression : ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression ) ;
    public final void ruleCachedExpression() throws RecognitionException {
        int ruleCachedExpression_StartIndex = input.index();
        Token otherlv_1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2504:21: ( ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression ) )
            // PsiInternalBeeLangTestLanguage.g:2505:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:2505:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_ID||LA55_0==RULE_STRING||LA55_0==13||(LA55_0>=17 && LA55_0<=18)||LA55_0==21||LA55_0==35||LA55_0==60||(LA55_0>=64 && LA55_0<=66)||LA55_0==70||(LA55_0>=72 && LA55_0<=76)) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2506:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2506:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    // PsiInternalBeeLangTestLanguage.g:2507:4: () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2507:4: ()
                    // PsiInternalBeeLangTestLanguage.g:2508:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getCachedExpression_CachedExpressionAction_0_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getCachedExpression_CachedKeyword_0_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:2523:4: ( (lv_expr_2_0= ruleOrExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2524:5: (lv_expr_2_0= ruleOrExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2524:5: (lv_expr_2_0= ruleOrExpression )
                    // PsiInternalBeeLangTestLanguage.g:2525:6: lv_expr_2_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getCachedExpression_ExprOrExpressionParserRuleCall_0_2_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2536:3: ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getCachedExpression_OrExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 48, ruleCachedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleCachedExpression"


    // $ANTLR start "entryRuleOrExpression"
    // PsiInternalBeeLangTestLanguage.g:2550:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        int entryRuleOrExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2550:22: ( ruleOrExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2551:2: ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOrExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOrExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleOrExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // PsiInternalBeeLangTestLanguage.g:2556:1: ruleOrExpression : ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) ;
    public final void ruleOrExpression() throws RecognitionException {
        int ruleOrExpression_StartIndex = input.index();
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2556:17: ( ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:2557:2: ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:2557:2: ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:2558:3: ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getOrExpression_AndExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_49);
            ruleAndExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2568:3: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==57) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred85_PsiInternalBeeLangTestLanguage()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:2569:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2569:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:2570:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getOrExpression_OrExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getOrExpression_VerticalLineVerticalLineKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:2585:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:2586:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2586:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    // PsiInternalBeeLangTestLanguage.g:2587:6: lv_rightExpr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getOrExpression_RightExprAndExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_49);
            	    ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
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
            if ( state.backtracking>0 ) { memoize(input, 50, ruleOrExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // PsiInternalBeeLangTestLanguage.g:2601:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        int entryRuleAndExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2601:23: ( ruleAndExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2602:2: ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAndExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAndExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleAndExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // PsiInternalBeeLangTestLanguage.g:2607:1: ruleAndExpression : ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) ;
    public final void ruleAndExpression() throws RecognitionException {
        int ruleAndExpression_StartIndex = input.index();
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2607:18: ( ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:2608:2: ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:2608:2: ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:2609:3: ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAndExpression_RelationalExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_50);
            ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2619:3: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==58) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred86_PsiInternalBeeLangTestLanguage()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:2620:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2620:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:2621:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAndExpression_AndExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAndExpression_AmpersandAmpersandKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:2636:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:2637:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2637:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    // PsiInternalBeeLangTestLanguage.g:2638:6: lv_rightExpr_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAndExpression_RightExprRelationalExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_50);
            	    ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
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
            if ( state.backtracking>0 ) { memoize(input, 52, ruleAndExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // PsiInternalBeeLangTestLanguage.g:2652:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        int entryRuleRelationalExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2652:30: ( ruleRelationalExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2653:2: ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRelationalExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleRelationalExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // PsiInternalBeeLangTestLanguage.g:2658:1: ruleRelationalExpression : ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final void ruleRelationalExpression() throws RecognitionException {
        int ruleRelationalExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2658:25: ( ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:2659:2: ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:2659:2: ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:2660:3: ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getRelationalExpression_AdditiveExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_51);
            ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2670:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:2671:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2671:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:2672:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getRelationalExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2680:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
            	    // PsiInternalBeeLangTestLanguage.g:2681:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2681:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    // PsiInternalBeeLangTestLanguage.g:2682:6: lv_functionName_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getRelationalExpression_FunctionNameRelationalOperatorParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2691:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:2692:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2692:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    // PsiInternalBeeLangTestLanguage.g:2693:6: lv_rightExpr_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getRelationalExpression_RightExprAdditiveExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_51);
            	    ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
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
            if ( state.backtracking>0 ) { memoize(input, 54, ruleRelationalExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // PsiInternalBeeLangTestLanguage.g:2707:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        int entryRuleAdditiveExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2707:28: ( ruleAdditiveExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2708:2: ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAdditiveExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleAdditiveExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // PsiInternalBeeLangTestLanguage.g:2713:1: ruleAdditiveExpression : ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {
        int ruleAdditiveExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2713:23: ( ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:2714:2: ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:2714:2: ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:2715:3: ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAdditiveExpression_MultiplicativeExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_52);
            ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2725:3: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==59) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred89_PsiInternalBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==60) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred89_PsiInternalBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:2726:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2726:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:2727:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAdditiveExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2735:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:2736:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2736:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    // PsiInternalBeeLangTestLanguage.g:2737:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2737:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==59) ) {
            	        alt59=1;
            	    }
            	    else if ( (LA59_0==60) ) {
            	        alt59=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 59, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:2738:7: lv_functionName_2_1= '+'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNamePlusSignKeyword_1_1_0_0ElementType());
            	              						
            	            }
            	            lv_functionName_2_1=(Token)match(input,59,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_1);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalBeeLangTestLanguage.g:2746:7: lv_functionName_2_2= '-'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNameHyphenMinusKeyword_1_1_0_1ElementType());
            	              						
            	            }
            	            lv_functionName_2_2=(Token)match(input,60,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_2);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2756:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:2757:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2757:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    // PsiInternalBeeLangTestLanguage.g:2758:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAdditiveExpression_RightExprMultiplicativeExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_52);
            	    ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
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
            if ( state.backtracking>0 ) { memoize(input, 56, ruleAdditiveExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // PsiInternalBeeLangTestLanguage.g:2772:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        int entryRuleMultiplicativeExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2772:34: ( ruleMultiplicativeExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2773:2: ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMultiplicativeExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleMultiplicativeExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // PsiInternalBeeLangTestLanguage.g:2778:1: ruleMultiplicativeExpression : ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {
        int ruleMultiplicativeExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2778:29: ( ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:2779:2: ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:2779:2: ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:2780:3: ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getMultiplicativeExpression_SetExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_53);
            ruleSetExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2790:3: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred92_PsiInternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred92_PsiInternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 62:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred92_PsiInternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:2791:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2791:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:2792:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getMultiplicativeExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2800:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:2801:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2801:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    // PsiInternalBeeLangTestLanguage.g:2802:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2802:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    int alt61=3;
            	    switch ( input.LA(1) ) {
            	    case 61:
            	        {
            	        alt61=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt61=2;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt61=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt61) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:2803:7: lv_functionName_2_1= '*'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNameAsteriskKeyword_1_1_0_0ElementType());
            	              						
            	            }
            	            lv_functionName_2_1=(Token)match(input,61,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_1);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalBeeLangTestLanguage.g:2811:7: lv_functionName_2_2= '/'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNameSolidusKeyword_1_1_0_1ElementType());
            	              						
            	            }
            	            lv_functionName_2_2=(Token)match(input,32,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_2);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // PsiInternalBeeLangTestLanguage.g:2819:7: lv_functionName_2_3= '%'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNamePercentSignKeyword_1_1_0_2ElementType());
            	              						
            	            }
            	            lv_functionName_2_3=(Token)match(input,62,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_3);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2829:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:2830:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2830:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    // PsiInternalBeeLangTestLanguage.g:2831:6: lv_rightExpr_3_0= ruleSetExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getMultiplicativeExpression_RightExprSetExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_53);
            	    ruleSetExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
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
            if ( state.backtracking>0 ) { memoize(input, 58, ruleMultiplicativeExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleSetExpression"
    // PsiInternalBeeLangTestLanguage.g:2845:1: entryRuleSetExpression : ruleSetExpression EOF ;
    public final void entryRuleSetExpression() throws RecognitionException {
        int entryRuleSetExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2845:23: ( ruleSetExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2846:2: ruleSetExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSetExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSetExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleSetExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleSetExpression"


    // $ANTLR start "ruleSetExpression"
    // PsiInternalBeeLangTestLanguage.g:2851:1: ruleSetExpression : ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) ;
    public final void ruleSetExpression() throws RecognitionException {
        int ruleSetExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2851:18: ( ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:2852:2: ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:2852:2: ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:2853:3: ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getSetExpression_UnaryOrInfixExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_54);
            ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2863:3: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==63) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred93_PsiInternalBeeLangTestLanguage()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:2864:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2864:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:2865:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getSetExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2873:4: ( (lv_functionName_2_0= '..' ) )
            	    // PsiInternalBeeLangTestLanguage.g:2874:5: (lv_functionName_2_0= '..' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2874:5: (lv_functionName_2_0= '..' )
            	    // PsiInternalBeeLangTestLanguage.g:2875:6: lv_functionName_2_0= '..'
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markLeaf(elementTypeProvider.getSetExpression_FunctionNameFullStopFullStopKeyword_1_1_0ElementType());
            	      					
            	    }
            	    lv_functionName_2_0=(Token)match(input,63,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneLeaf(lv_functionName_2_0);
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:2884:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:2885:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:2885:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    // PsiInternalBeeLangTestLanguage.g:2886:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getSetExpression_RightExprUnaryOrInfixExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_54);
            	    ruleUnaryOrInfixExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
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
            if ( state.backtracking>0 ) { memoize(input, 60, ruleSetExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleSetExpression"


    // $ANTLR start "entryRuleUnaryOrInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:2900:1: entryRuleUnaryOrInfixExpression : ruleUnaryOrInfixExpression EOF ;
    public final void entryRuleUnaryOrInfixExpression() throws RecognitionException {
        int entryRuleUnaryOrInfixExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2900:32: ( ruleUnaryOrInfixExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2901:2: ruleUnaryOrInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnaryOrInfixExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleUnaryOrInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOrInfixExpression"


    // $ANTLR start "ruleUnaryOrInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:2906:1: ruleUnaryOrInfixExpression : ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression ) ;
    public final void ruleUnaryOrInfixExpression() throws RecognitionException {
        int ruleUnaryOrInfixExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2906:27: ( ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression ) )
            // PsiInternalBeeLangTestLanguage.g:2907:2: ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:2907:2: ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression )
            int alt64=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
            case 13:
            case 17:
            case 18:
            case 21:
            case 35:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
                {
                alt64=1;
                }
                break;
            case 60:
            case 64:
                {
                alt64=2;
                }
                break;
            case 65:
            case 66:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2908:3: rulePostopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_PostopExpressionParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePostopExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2919:3: ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_UnaryExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:2930:3: rulePreopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_PreopExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePreopExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 62, ruleUnaryOrInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleUnaryOrInfixExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // PsiInternalBeeLangTestLanguage.g:2944:1: entryRuleUnaryExpression : ruleUnaryExpression EOF ;
    public final void entryRuleUnaryExpression() throws RecognitionException {
        int entryRuleUnaryExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2944:25: ( ruleUnaryExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2945:2: ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnaryExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleUnaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // PsiInternalBeeLangTestLanguage.g:2950:1: ruleUnaryExpression : ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final void ruleUnaryExpression() throws RecognitionException {
        int ruleUnaryExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2950:20: ( ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:2951:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2951:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:2952:3: () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2952:3: ()
            // PsiInternalBeeLangTestLanguage.g:2953:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnaryExpression_UnaryOpExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:2961:3: ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) )
            // PsiInternalBeeLangTestLanguage.g:2962:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2962:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            // PsiInternalBeeLangTestLanguage.g:2963:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            {
            // PsiInternalBeeLangTestLanguage.g:2963:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==64) ) {
                alt65=1;
            }
            else if ( (LA65_0==60) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2964:6: lv_functionName_1_1= '!'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnaryExpression_FunctionNameExclamationMarkKeyword_1_0_0ElementType());
                      					
                    }
                    lv_functionName_1_1=(Token)match(input,64,FollowSets000.FOLLOW_55); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_1);
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2972:6: lv_functionName_1_2= '-'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnaryExpression_FunctionNameHyphenMinusKeyword_1_0_1ElementType());
                      					
                    }
                    lv_functionName_1_2=(Token)match(input,60,FollowSets000.FOLLOW_55); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_2);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalBeeLangTestLanguage.g:2982:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalBeeLangTestLanguage.g:2983:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:2983:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalBeeLangTestLanguage.g:2984:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getUnaryExpression_ExprInfixExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleInfixExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, ruleUnaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePreopExpression"
    // PsiInternalBeeLangTestLanguage.g:2997:1: entryRulePreopExpression : rulePreopExpression EOF ;
    public final void entryRulePreopExpression() throws RecognitionException {
        int entryRulePreopExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:2997:25: ( rulePreopExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2998:2: rulePreopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPreopExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePreopExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, entryRulePreopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePreopExpression"


    // $ANTLR start "rulePreopExpression"
    // PsiInternalBeeLangTestLanguage.g:3003:1: rulePreopExpression : ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final void rulePreopExpression() throws RecognitionException {
        int rulePreopExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3003:20: ( ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3004:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3004:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:3005:3: () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3005:3: ()
            // PsiInternalBeeLangTestLanguage.g:3006:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPreopExpression_UnaryPreOpExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:3014:3: ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) )
            // PsiInternalBeeLangTestLanguage.g:3015:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3015:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            // PsiInternalBeeLangTestLanguage.g:3016:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            {
            // PsiInternalBeeLangTestLanguage.g:3016:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==65) ) {
                alt66=1;
            }
            else if ( (LA66_0==66) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3017:6: lv_functionName_1_1= '++'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPreopExpression_FunctionNamePlusSignPlusSignKeyword_1_0_0ElementType());
                      					
                    }
                    lv_functionName_1_1=(Token)match(input,65,FollowSets000.FOLLOW_55); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_1);
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3025:6: lv_functionName_1_2= '--'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPreopExpression_FunctionNameHyphenMinusHyphenMinusKeyword_1_0_1ElementType());
                      					
                    }
                    lv_functionName_1_2=(Token)match(input,66,FollowSets000.FOLLOW_55); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_2);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalBeeLangTestLanguage.g:3035:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3036:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3036:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalBeeLangTestLanguage.g:3037:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPreopExpression_ExprInfixExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleInfixExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, rulePreopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "rulePreopExpression"


    // $ANTLR start "entryRulePostopExpression"
    // PsiInternalBeeLangTestLanguage.g:3050:1: entryRulePostopExpression : rulePostopExpression EOF ;
    public final void entryRulePostopExpression() throws RecognitionException {
        int entryRulePostopExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3050:26: ( rulePostopExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3051:2: rulePostopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPostopExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePostopExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, entryRulePostopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePostopExpression"


    // $ANTLR start "rulePostopExpression"
    // PsiInternalBeeLangTestLanguage.g:3056:1: rulePostopExpression : ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) ;
    public final void rulePostopExpression() throws RecognitionException {
        int rulePostopExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3056:21: ( ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:3057:2: ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:3057:2: ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            // PsiInternalBeeLangTestLanguage.g:3058:3: ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPostopExpression_InfixExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_56);
            ruleInfixExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3068:3: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==66) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred99_PsiInternalBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            else if ( (LA68_0==65) ) {
                int LA68_2 = input.LA(2);

                if ( (synpred99_PsiInternalBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3069:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3069:4: ()
                    // PsiInternalBeeLangTestLanguage.g:3070:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPostopExpression_UnaryPostOpExpressionExprAction_1_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalBeeLangTestLanguage.g:3078:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    // PsiInternalBeeLangTestLanguage.g:3079:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3079:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    // PsiInternalBeeLangTestLanguage.g:3080:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3080:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==66) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==65) ) {
                        alt67=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:3081:7: lv_functionName_2_1= '--'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getPostopExpression_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_0ElementType());
                              						
                            }
                            lv_functionName_2_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_functionName_2_1);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // PsiInternalBeeLangTestLanguage.g:3089:7: lv_functionName_2_2= '++'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getPostopExpression_FunctionNamePlusSignPlusSignKeyword_1_1_0_1ElementType());
                              						
                            }
                            lv_functionName_2_2=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_functionName_2_2);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, rulePostopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "rulePostopExpression"


    // $ANTLR start "entryRuleInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:3104:1: entryRuleInfixExpression : ruleInfixExpression EOF ;
    public final void entryRuleInfixExpression() throws RecognitionException {
        int entryRuleInfixExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3104:25: ( ruleInfixExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3105:2: ruleInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInfixExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInfixExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, entryRuleInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleInfixExpression"


    // $ANTLR start "ruleInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:3110:1: ruleInfixExpression : ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) ;
    public final void ruleInfixExpression() throws RecognitionException {
        int ruleInfixExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3110:20: ( ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3111:2: ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3111:2: ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3112:3: ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getInfixExpression_CallExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_57);
            ruleCallExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3122:3: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==67) ) {
                    int LA70_2 = input.LA(2);

                    if ( (synpred101_PsiInternalBeeLangTestLanguage()) ) {
                        alt70=1;
                    }
                    else if ( (synpred103_PsiInternalBeeLangTestLanguage()) ) {
                        alt70=3;
                    }


                }
                else if ( (LA70_0==68) ) {
                    int LA70_3 = input.LA(2);

                    if ( (synpred102_PsiInternalBeeLangTestLanguage()) ) {
                        alt70=2;
                    }


                }


                switch (alt70) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3123:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3123:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    // PsiInternalBeeLangTestLanguage.g:3124:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3124:5: ()
            	    // PsiInternalBeeLangTestLanguage.g:3125:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_CallFeatureFuncExprAction_1_0_0ElementType());
            	      						doneComposite();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_FullStopKeyword_1_0_1ElementType());
            	      				
            	    }
            	    otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_2);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3140:5: ( (lv_name_3_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:3141:6: (lv_name_3_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3141:6: (lv_name_3_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:3142:7: lv_name_3_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType());
            	      						
            	    }
            	    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(lv_name_3_0);
            	      						
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_LeftParenthesisKeyword_1_0_3ElementType());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_4);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3158:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==RULE_ID||LA69_0==RULE_STRING||LA69_0==13||(LA69_0>=17 && LA69_0<=18)||LA69_0==21||(LA69_0>=35 && LA69_0<=36)||LA69_0==52||LA69_0==56||LA69_0==60||(LA69_0>=64 && LA69_0<=66)||LA69_0==70||(LA69_0>=72 && LA69_0<=77)) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:3159:6: (lv_parameterList_5_0= ruleParameterList )
            	            {
            	            // PsiInternalBeeLangTestLanguage.g:3159:6: (lv_parameterList_5_0= ruleParameterList )
            	            // PsiInternalBeeLangTestLanguage.g:3160:7: lv_parameterList_5_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markComposite(elementTypeProvider.getInfixExpression_ParameterListParameterListParserRuleCall_1_0_4_0ElementType());
            	              						
            	            }
            	            pushFollow(FollowSets000.FOLLOW_37);
            	            ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              							doneComposite();
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_RightParenthesisKeyword_1_0_5ElementType());
            	      				
            	    }
            	    otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_57); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_6);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:3178:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3178:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    // PsiInternalBeeLangTestLanguage.g:3179:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3179:5: ()
            	    // PsiInternalBeeLangTestLanguage.g:3180:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_AtExpressionObjExprAction_1_1_0ElementType());
            	      						doneComposite();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_LeftSquareBracketKeyword_1_1_1ElementType());
            	      				
            	    }
            	    otherlv_8=(Token)match(input,68,FollowSets000.FOLLOW_19); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_8);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3195:5: ( (lv_indexExpr_9_0= ruleExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3196:6: (lv_indexExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3196:6: (lv_indexExpr_9_0= ruleExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3197:7: lv_indexExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getInfixExpression_IndexExprExpressionParserRuleCall_1_1_2_0ElementType());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_60);
            	    ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      						
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_RightSquareBracketKeyword_1_1_3ElementType());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,69,FollowSets000.FOLLOW_57); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_10);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:3215:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3215:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:3216:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3216:5: ()
            	    // PsiInternalBeeLangTestLanguage.g:3217:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_FeatureExpressionObjExprAction_1_2_0ElementType());
            	      						doneComposite();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_FullStopKeyword_1_2_1ElementType());
            	      				
            	    }
            	    otherlv_12=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_12);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3232:5: ( (lv_featureName_13_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:3233:6: (lv_featureName_13_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3233:6: (lv_featureName_13_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:3234:7: lv_featureName_13_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getInfixExpression_FeatureNameIDTerminalRuleCall_1_2_2_0ElementType());
            	      						
            	    }
            	    lv_featureName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_57); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(lv_featureName_13_0);
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
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
            if ( state.backtracking>0 ) { memoize(input, 70, ruleInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleInfixExpression"


    // $ANTLR start "entryRuleCallExpression"
    // PsiInternalBeeLangTestLanguage.g:3249:1: entryRuleCallExpression : ruleCallExpression EOF ;
    public final void entryRuleCallExpression() throws RecognitionException {
        int entryRuleCallExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3249:24: ( ruleCallExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3250:2: ruleCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getCallExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCallExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleCallExpression"


    // $ANTLR start "ruleCallExpression"
    // PsiInternalBeeLangTestLanguage.g:3255:1: ruleCallExpression : ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) ;
    public final void ruleCallExpression() throws RecognitionException {
        int ruleCallExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3255:19: ( ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) )
            // PsiInternalBeeLangTestLanguage.g:3256:2: ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3256:2: ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            // PsiInternalBeeLangTestLanguage.g:3257:3: rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getCallExpression_PrimaryExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_61);
            rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3267:3: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==35) ) {
                    int LA72_2 = input.LA(2);

                    if ( (synpred105_PsiInternalBeeLangTestLanguage()) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3268:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3268:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3269:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getCallExpression_CallFunctionFuncExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getCallExpression_LeftParenthesisKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3284:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==RULE_ID||LA71_0==RULE_STRING||LA71_0==13||(LA71_0>=17 && LA71_0<=18)||LA71_0==21||(LA71_0>=35 && LA71_0<=36)||LA71_0==52||LA71_0==56||LA71_0==60||(LA71_0>=64 && LA71_0<=66)||LA71_0==70||(LA71_0>=72 && LA71_0<=77)) ) {
            	        alt71=1;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:3285:5: (lv_parameterList_3_0= ruleParameterList )
            	            {
            	            // PsiInternalBeeLangTestLanguage.g:3285:5: (lv_parameterList_3_0= ruleParameterList )
            	            // PsiInternalBeeLangTestLanguage.g:3286:6: lv_parameterList_3_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              						markComposite(elementTypeProvider.getCallExpression_ParameterListParameterListParserRuleCall_1_2_0ElementType());
            	              					
            	            }
            	            pushFollow(FollowSets000.FOLLOW_37);
            	            ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return ;
            	            if ( state.backtracking==0 ) {

            	              						doneComposite();
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getCallExpression_RightParenthesisKeyword_1_3ElementType());
            	      			
            	    }
            	    otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_61); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_4);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop72;
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
            if ( state.backtracking>0 ) { memoize(input, 72, ruleCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // PsiInternalBeeLangTestLanguage.g:3307:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        int entryRulePrimaryExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3307:27: ( rulePrimaryExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3308:2: rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrimaryExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, entryRulePrimaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // PsiInternalBeeLangTestLanguage.g:3313:1: rulePrimaryExpression : ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression ) ;
    public final void rulePrimaryExpression() throws RecognitionException {
        int rulePrimaryExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3313:22: ( ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3314:2: ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3314:2: ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression )
            int alt73=9;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3315:3: ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_FeatureCallParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3326:3: ruleConstructorCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ConstructorCallExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleConstructorCallExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:3337:3: ruleValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ValueParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleValue();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:3348:3: ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_LiteralParserRuleCall_3ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:3359:3: ruleKeywordVariables
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_KeywordVariablesParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeywordVariables();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:3370:3: ruleParanthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ParanthesizedExpressionParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParanthesizedExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalBeeLangTestLanguage.g:3381:3: ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_BlockExpressionParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalBeeLangTestLanguage.g:3392:3: ruleWithExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_WithExpressionParserRuleCall_7ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWithExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalBeeLangTestLanguage.g:3403:3: ruleWithContextExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_WithContextExpressionParserRuleCall_8ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWithContextExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 74, rulePrimaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleWithExpression"
    // PsiInternalBeeLangTestLanguage.g:3417:1: entryRuleWithExpression : ruleWithExpression EOF ;
    public final void entryRuleWithExpression() throws RecognitionException {
        int entryRuleWithExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3417:24: ( ruleWithExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3418:2: ruleWithExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getWithExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWithExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, entryRuleWithExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleWithExpression"


    // $ANTLR start "ruleWithExpression"
    // PsiInternalBeeLangTestLanguage.g:3423:1: ruleWithExpression : (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) ;
    public final void ruleWithExpression() throws RecognitionException {
        int ruleWithExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_referencedAdvice_1_0=null;
        Token otherlv_2=null;
        Token lv_referencedAdvice_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3423:19: ( (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3424:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3424:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            // PsiInternalBeeLangTestLanguage.g:3425:3: otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithExpression_WithKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_62); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3432:3: ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3433:4: ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalBeeLangTestLanguage.g:3433:4: ( (lv_referencedAdvice_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:3434:5: (lv_referencedAdvice_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3434:5: (lv_referencedAdvice_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:3435:6: lv_referencedAdvice_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getWithExpression_ReferencedAdviceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_referencedAdvice_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_63); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_referencedAdvice_1_0);
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:3444:4: (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==16) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:3445:5: otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getWithExpression_CommaKeyword_1_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_2);
                    	      				
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:3452:5: ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:3453:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:3453:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:3454:7: lv_referencedAdvice_3_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getWithExpression_ReferencedAdviceIDTerminalRuleCall_1_1_1_0ElementType());
                    	      						
                    	    }
                    	    lv_referencedAdvice_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_63); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(lv_referencedAdvice_3_0);
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:3465:3: ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==19) ) {
                alt76=1;
            }
            else if ( (LA76_0==17) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3466:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3466:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    // PsiInternalBeeLangTestLanguage.g:3467:5: otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_ColonKeyword_2_0_0ElementType());
                      				
                    }
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_4);
                      				
                    }
                    // PsiInternalBeeLangTestLanguage.g:3474:5: ( (lv_funcExpr_5_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:3475:6: (lv_funcExpr_5_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3475:6: (lv_funcExpr_5_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:3476:7: lv_funcExpr_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getWithExpression_FuncExprExpressionParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3487:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3487:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    // PsiInternalBeeLangTestLanguage.g:3488:5: otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_LeftCurlyBracketKeyword_2_1_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_64); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }
                    // PsiInternalBeeLangTestLanguage.g:3495:5: ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) )
                    // PsiInternalBeeLangTestLanguage.g:3496:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3496:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    // PsiInternalBeeLangTestLanguage.g:3497:7: lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getWithExpression_FuncExprBlockExpressionWithoutBracketsParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_65);
                    ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_RightCurlyBracketKeyword_2_1_2ElementType());
                      				
                    }
                    otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_8);
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, ruleWithExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleWithExpression"


    // $ANTLR start "entryRuleWithContextExpression"
    // PsiInternalBeeLangTestLanguage.g:3519:1: entryRuleWithContextExpression : ruleWithContextExpression EOF ;
    public final void entryRuleWithContextExpression() throws RecognitionException {
        int entryRuleWithContextExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3519:31: ( ruleWithContextExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3520:2: ruleWithContextExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getWithContextExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWithContextExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleWithContextExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleWithContextExpression"


    // $ANTLR start "ruleWithContextExpression"
    // PsiInternalBeeLangTestLanguage.g:3525:1: ruleWithContextExpression : (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) ;
    public final void ruleWithContextExpression() throws RecognitionException {
        int ruleWithContextExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3525:26: ( (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3526:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3526:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:3527:3: otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithContextExpression_WithKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_66); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithContextExpression_ContextKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_19); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3541:3: ( (lv_expr_2_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3542:4: (lv_expr_2_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3542:4: (lv_expr_2_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:3543:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getWithContextExpression_ExprExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_21);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:3552:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==28) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3553:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getWithContextExpression_AsKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:3560:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:3561:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3561:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:3562:6: lv_alias_4_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getWithContextExpression_AliasIDTerminalRuleCall_3_1_0ElementType());
                      					
                    }
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_4_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:3572:3: ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3573:4: (lv_contextBlock_5_0= ruleBlockExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3573:4: (lv_contextBlock_5_0= ruleBlockExpression )
            // PsiInternalBeeLangTestLanguage.g:3574:5: lv_contextBlock_5_0= ruleBlockExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getWithContextExpression_ContextBlockBlockExpressionParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleBlockExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, ruleWithContextExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleWithContextExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:3587:1: entryRuleBlockExpression : ruleBlockExpression EOF ;
    public final void entryRuleBlockExpression() throws RecognitionException {
        int entryRuleBlockExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3587:25: ( ruleBlockExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3588:2: ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBlockExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBlockExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:3593:1: ruleBlockExpression : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final void ruleBlockExpression() throws RecognitionException {
        int ruleBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3593:20: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:3594:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:3594:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // PsiInternalBeeLangTestLanguage.g:3595:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            // PsiInternalBeeLangTestLanguage.g:3595:3: ()
            // PsiInternalBeeLangTestLanguage.g:3596:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBlockExpression_ChainedExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_67); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3611:3: ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==RULE_STRING||LA78_0==13||(LA78_0>=17 && LA78_0<=18)||LA78_0==21||LA78_0==33||LA78_0==35||(LA78_0>=53 && LA78_0<=54)||LA78_0==56||LA78_0==60||(LA78_0>=64 && LA78_0<=66)||LA78_0==70||(LA78_0>=72 && LA78_0<=76)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3612:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3612:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3613:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3613:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3614:6: lv_expressions_2_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getBlockExpression_ExpressionsTopLevelExpressionParserRuleCall_2_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getBlockExpression_SemicolonKeyword_2_1ElementType());
            	      			
            	    }
            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_67); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_3);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBlockExpression_RightCurlyBracketKeyword_3ElementType());
              		
            }
            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, ruleBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleValue"
    // PsiInternalBeeLangTestLanguage.g:3642:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        int entryRuleValue_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3642:15: ( ruleValue EOF )
            // PsiInternalBeeLangTestLanguage.g:3643:2: ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleValue_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // PsiInternalBeeLangTestLanguage.g:3648:1: ruleValue : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleValue() throws RecognitionException {
        int ruleValue_StartIndex = input.index();
        Token lv_name_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3648:10: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3649:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3649:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:3650:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3650:3: ()
            // PsiInternalBeeLangTestLanguage.g:3651:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValue_VariableExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:3659:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:3660:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:3660:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:3661:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValue_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 82, ruleValue_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleKeywordVariables"
    // PsiInternalBeeLangTestLanguage.g:3674:1: entryRuleKeywordVariables : ruleKeywordVariables EOF ;
    public final void entryRuleKeywordVariables() throws RecognitionException {
        int entryRuleKeywordVariables_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3674:26: ( ruleKeywordVariables EOF )
            // PsiInternalBeeLangTestLanguage.g:3675:2: ruleKeywordVariables EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getKeywordVariablesElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKeywordVariables();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleKeywordVariables_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleKeywordVariables"


    // $ANTLR start "ruleKeywordVariables"
    // PsiInternalBeeLangTestLanguage.g:3680:1: ruleKeywordVariables : ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) ;
    public final void ruleKeywordVariables() throws RecognitionException {
        int ruleKeywordVariables_StartIndex = input.index();
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3680:21: ( ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3681:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3681:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3682:3: () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3682:3: ()
            // PsiInternalBeeLangTestLanguage.g:3683:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getKeywordVariables_VariableExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:3691:3: ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            // PsiInternalBeeLangTestLanguage.g:3692:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3692:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            // PsiInternalBeeLangTestLanguage.g:3693:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            {
            // PsiInternalBeeLangTestLanguage.g:3693:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            int alt79=7;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt79=1;
                }
                break;
            case 21:
                {
                alt79=2;
                }
                break;
            case 18:
                {
                alt79=3;
                }
                break;
            case 73:
                {
                alt79=4;
                }
                break;
            case 74:
                {
                alt79=5;
                }
                break;
            case 13:
                {
                alt79=6;
                }
                break;
            case 75:
                {
                alt79=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3694:6: lv_name_1_1= 'input'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameInputKeyword_1_0_0ElementType());
                      					
                    }
                    lv_name_1_1=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_1);
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3702:6: lv_name_1_2= 'output'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameOutputKeyword_1_0_1ElementType());
                      					
                    }
                    lv_name_1_2=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_2);
                      					
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:3710:6: lv_name_1_3= 'source'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameSourceKeyword_1_0_2ElementType());
                      					
                    }
                    lv_name_1_3=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_3);
                      					
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:3718:6: lv_name_1_4= 'properties'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NamePropertiesKeyword_1_0_3ElementType());
                      					
                    }
                    lv_name_1_4=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_4);
                      					
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:3726:6: lv_name_1_5= 'builder'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameBuilderKeyword_1_0_4ElementType());
                      					
                    }
                    lv_name_1_5=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_5);
                      					
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:3734:6: lv_name_1_6= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameUnitKeyword_1_0_5ElementType());
                      					
                    }
                    lv_name_1_6=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_6);
                      					
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalBeeLangTestLanguage.g:3742:6: lv_name_1_7= 'this'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameThisKeyword_1_0_6ElementType());
                      					
                    }
                    lv_name_1_7=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_7);
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 84, ruleKeywordVariables_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleKeywordVariables"


    // $ANTLR start "entryRuleFeatureCall"
    // PsiInternalBeeLangTestLanguage.g:3756:1: entryRuleFeatureCall : ruleFeatureCall EOF ;
    public final void entryRuleFeatureCall() throws RecognitionException {
        int entryRuleFeatureCall_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3756:21: ( ruleFeatureCall EOF )
            // PsiInternalBeeLangTestLanguage.g:3757:2: ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureCallElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFeatureCall();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleFeatureCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // PsiInternalBeeLangTestLanguage.g:3762:1: ruleFeatureCall : ruleOperationCall ;
    public final void ruleFeatureCall() throws RecognitionException {
        int ruleFeatureCall_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3762:16: ( ruleOperationCall )
            // PsiInternalBeeLangTestLanguage.g:3763:2: ruleOperationCall
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getFeatureCall_OperationCallParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleOperationCall();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              		doneComposite();
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, ruleFeatureCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleOperationCall"
    // PsiInternalBeeLangTestLanguage.g:3776:1: entryRuleOperationCall : ruleOperationCall EOF ;
    public final void entryRuleOperationCall() throws RecognitionException {
        int entryRuleOperationCall_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3776:23: ( ruleOperationCall EOF )
            // PsiInternalBeeLangTestLanguage.g:3777:2: ruleOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOperationCallElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOperationCall();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleOperationCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // PsiInternalBeeLangTestLanguage.g:3782:1: ruleOperationCall : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) ;
    public final void ruleOperationCall() throws RecognitionException {
        int ruleOperationCall_StartIndex = input.index();
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3782:18: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) )
            // PsiInternalBeeLangTestLanguage.g:3783:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            {
            // PsiInternalBeeLangTestLanguage.g:3783:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            // PsiInternalBeeLangTestLanguage.g:3784:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            {
            // PsiInternalBeeLangTestLanguage.g:3784:3: ()
            // PsiInternalBeeLangTestLanguage.g:3785:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getOperationCall_CallNamedFunctionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:3793:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:3794:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:3794:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:3795:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getOperationCall_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperationCall_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3811:3: ( (lv_parameterList_3_0= ruleParameterList ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||LA80_0==RULE_STRING||LA80_0==13||(LA80_0>=17 && LA80_0<=18)||LA80_0==21||(LA80_0>=35 && LA80_0<=36)||LA80_0==52||LA80_0==56||LA80_0==60||(LA80_0>=64 && LA80_0<=66)||LA80_0==70||(LA80_0>=72 && LA80_0<=77)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3812:4: (lv_parameterList_3_0= ruleParameterList )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3812:4: (lv_parameterList_3_0= ruleParameterList )
                    // PsiInternalBeeLangTestLanguage.g:3813:5: lv_parameterList_3_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getOperationCall_ParameterListParameterListParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_37);
                    ruleParameterList();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperationCall_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, ruleOperationCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleConstructorCallExpression"
    // PsiInternalBeeLangTestLanguage.g:3833:1: entryRuleConstructorCallExpression : ruleConstructorCallExpression EOF ;
    public final void entryRuleConstructorCallExpression() throws RecognitionException {
        int entryRuleConstructorCallExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3833:35: ( ruleConstructorCallExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3834:2: ruleConstructorCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getConstructorCallExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConstructorCallExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleConstructorCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleConstructorCallExpression"


    // $ANTLR start "ruleConstructorCallExpression"
    // PsiInternalBeeLangTestLanguage.g:3839:1: ruleConstructorCallExpression : ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) ;
    public final void ruleConstructorCallExpression() throws RecognitionException {
        int ruleConstructorCallExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_typeExpr_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3839:30: ( ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:3840:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:3840:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            // PsiInternalBeeLangTestLanguage.g:3841:3: () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            {
            // PsiInternalBeeLangTestLanguage.g:3841:3: ()
            // PsiInternalBeeLangTestLanguage.g:3842:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getConstructorCallExpression_CreateExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getConstructorCallExpression_NewKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_8); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3857:3: ( (lv_typeExpr_2_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:3858:4: (lv_typeExpr_2_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:3858:4: (lv_typeExpr_2_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:3859:5: lv_typeExpr_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getConstructorCallExpression_TypeExprIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_typeExpr_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_68); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_typeExpr_2_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:3868:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3869:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:3876:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID||LA81_0==RULE_STRING||LA81_0==13||(LA81_0>=17 && LA81_0<=18)||LA81_0==21||(LA81_0>=35 && LA81_0<=36)||LA81_0==52||LA81_0==56||LA81_0==60||(LA81_0>=64 && LA81_0<=66)||LA81_0==70||(LA81_0>=72 && LA81_0<=77)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:3877:5: (lv_parameterList_4_0= ruleParameterList )
                            {
                            // PsiInternalBeeLangTestLanguage.g:3877:5: (lv_parameterList_4_0= ruleParameterList )
                            // PsiInternalBeeLangTestLanguage.g:3878:6: lv_parameterList_4_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {

                              						markComposite(elementTypeProvider.getConstructorCallExpression_ParameterListParameterListParserRuleCall_3_1_0ElementType());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            ruleParameterList();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              						doneComposite();
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_RightParenthesisKeyword_3_2ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_69); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:3895:3: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==28) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ID) ) {
                    int LA83_3 = input.LA(3);

                    if ( (synpred128_PsiInternalBeeLangTestLanguage()) ) {
                        alt83=1;
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3896:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:3903:4: ( (lv_alias_7_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:3904:5: (lv_alias_7_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3904:5: (lv_alias_7_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:3905:6: lv_alias_7_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getConstructorCallExpression_AliasIDTerminalRuleCall_4_1_0ElementType());
                      					
                    }
                    lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_7_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:3915:3: ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==17) ) {
                int LA84_1 = input.LA(2);

                if ( (LA84_1==RULE_ID) ) {
                    int LA84_3 = input.LA(3);

                    if ( (LA84_3==19) ) {
                        alt84=1;
                    }
                }
            }
            switch (alt84) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3916:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3916:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    // PsiInternalBeeLangTestLanguage.g:3917:5: lv_contextBlock_8_0= ruleInitializationBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getConstructorCallExpression_ContextBlockInitializationBlockExpressionParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleInitializationBlockExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, ruleConstructorCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleConstructorCallExpression"


    // $ANTLR start "entryRuleInitializationBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:3930:1: entryRuleInitializationBlockExpression : ruleInitializationBlockExpression EOF ;
    public final void entryRuleInitializationBlockExpression() throws RecognitionException {
        int entryRuleInitializationBlockExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3930:39: ( ruleInitializationBlockExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3931:2: ruleInitializationBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInitializationBlockExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInitializationBlockExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleInitializationBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleInitializationBlockExpression"


    // $ANTLR start "ruleInitializationBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:3936:1: ruleInitializationBlockExpression : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) ;
    public final void ruleInitializationBlockExpression() throws RecognitionException {
        int ruleInitializationBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3936:34: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:3937:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:3937:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            // PsiInternalBeeLangTestLanguage.g:3938:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}'
            {
            // PsiInternalBeeLangTestLanguage.g:3938:3: ()
            // PsiInternalBeeLangTestLanguage.g:3939:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getInitializationBlockExpression_ChainedExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3954:3: ( (lv_expressions_2_0= ruleInitializationExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3955:4: (lv_expressions_2_0= ruleInitializationExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3955:4: (lv_expressions_2_0= ruleInitializationExpression )
            // PsiInternalBeeLangTestLanguage.g:3956:5: lv_expressions_2_0= ruleInitializationExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationBlockExpression_ExpressionsInitializationExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_14);
            ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_SemicolonKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_65); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_RightCurlyBracketKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, ruleInitializationBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleInitializationBlockExpression"


    // $ANTLR start "entryRuleInitializationExpression"
    // PsiInternalBeeLangTestLanguage.g:3983:1: entryRuleInitializationExpression : ruleInitializationExpression EOF ;
    public final void entryRuleInitializationExpression() throws RecognitionException {
        int entryRuleInitializationExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3983:34: ( ruleInitializationExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3984:2: ruleInitializationExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInitializationExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleInitializationExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleInitializationExpression"


    // $ANTLR start "ruleInitializationExpression"
    // PsiInternalBeeLangTestLanguage.g:3989:1: ruleInitializationExpression : ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) ;
    public final void ruleInitializationExpression() throws RecognitionException {
        int ruleInitializationExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:3989:29: ( ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3990:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3990:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:3991:3: () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3991:3: ()
            // PsiInternalBeeLangTestLanguage.g:3992:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getInitializationExpression_AssignmentExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4000:3: ( (lv_leftExpr_1_0= ruleFeatureOfThis ) )
            // PsiInternalBeeLangTestLanguage.g:4001:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            {
            // PsiInternalBeeLangTestLanguage.g:4001:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            // PsiInternalBeeLangTestLanguage.g:4002:5: lv_leftExpr_1_0= ruleFeatureOfThis
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationExpression_LeftExprFeatureOfThisParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
            ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:4011:3: ( (lv_functionName_2_0= ':' ) )
            // PsiInternalBeeLangTestLanguage.g:4012:4: (lv_functionName_2_0= ':' )
            {
            // PsiInternalBeeLangTestLanguage.g:4012:4: (lv_functionName_2_0= ':' )
            // PsiInternalBeeLangTestLanguage.g:4013:5: lv_functionName_2_0= ':'
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getInitializationExpression_FunctionNameColonKeyword_2_0ElementType());
              				
            }
            lv_functionName_2_0=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_functionName_2_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:4022:3: ( (lv_rightExpr_3_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:4023:4: (lv_rightExpr_3_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:4023:4: (lv_rightExpr_3_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:4024:5: lv_rightExpr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationExpression_RightExprExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 94, ruleInitializationExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleInitializationExpression"


    // $ANTLR start "entryRuleFeatureOfThis"
    // PsiInternalBeeLangTestLanguage.g:4037:1: entryRuleFeatureOfThis : ruleFeatureOfThis EOF ;
    public final void entryRuleFeatureOfThis() throws RecognitionException {
        int entryRuleFeatureOfThis_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4037:23: ( ruleFeatureOfThis EOF )
            // PsiInternalBeeLangTestLanguage.g:4038:2: ruleFeatureOfThis EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureOfThisElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleFeatureOfThis_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureOfThis"


    // $ANTLR start "ruleFeatureOfThis"
    // PsiInternalBeeLangTestLanguage.g:4043:1: ruleFeatureOfThis : ( () ( (lv_featureName_1_0= RULE_ID ) ) ) ;
    public final void ruleFeatureOfThis() throws RecognitionException {
        int ruleFeatureOfThis_StartIndex = input.index();
        Token lv_featureName_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4043:18: ( ( () ( (lv_featureName_1_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4044:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4044:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:4045:3: () ( (lv_featureName_1_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4045:3: ()
            // PsiInternalBeeLangTestLanguage.g:4046:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getFeatureOfThis_FeatureExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4054:3: ( (lv_featureName_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:4055:4: (lv_featureName_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:4055:4: (lv_featureName_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:4056:5: lv_featureName_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFeatureOfThis_FeatureNameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_featureName_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_featureName_1_0);
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 96, ruleFeatureOfThis_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFeatureOfThis"


    // $ANTLR start "entryRuleLiteral"
    // PsiInternalBeeLangTestLanguage.g:4069:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        int entryRuleLiteral_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4069:17: ( ruleLiteral EOF )
            // PsiInternalBeeLangTestLanguage.g:4070:2: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // PsiInternalBeeLangTestLanguage.g:4075:1: ruleLiteral : ( ruleValueLiteral | ruleLiteralFunction ) ;
    public final void ruleLiteral() throws RecognitionException {
        int ruleLiteral_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4075:12: ( ( ruleValueLiteral | ruleLiteralFunction ) )
            // PsiInternalBeeLangTestLanguage.g:4076:2: ( ruleValueLiteral | ruleLiteralFunction )
            {
            // PsiInternalBeeLangTestLanguage.g:4076:2: ( ruleValueLiteral | ruleLiteralFunction )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_STRING) ) {
                alt85=1;
            }
            else if ( (LA85_0==17) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4077:3: ruleValueLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_ValueLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleValueLiteral();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:4088:3: ruleLiteralFunction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_LiteralFunctionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleLiteralFunction();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 98, ruleLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleLiteralFunction"
    // PsiInternalBeeLangTestLanguage.g:4102:1: entryRuleLiteralFunction : ruleLiteralFunction EOF ;
    public final void entryRuleLiteralFunction() throws RecognitionException {
        int entryRuleLiteralFunction_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4102:25: ( ruleLiteralFunction EOF )
            // PsiInternalBeeLangTestLanguage.g:4103:2: ruleLiteralFunction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralFunctionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteralFunction();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleLiteralFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralFunction"


    // $ANTLR start "ruleLiteralFunction"
    // PsiInternalBeeLangTestLanguage.g:4108:1: ruleLiteralFunction : (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' ) ;
    public final void ruleLiteralFunction() throws RecognitionException {
        int ruleLiteralFunction_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4108:20: ( (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:4109:2: (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:4109:2: (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' )
            // PsiInternalBeeLangTestLanguage.g:4110:3: otherlv_0= '{' ruleClosureExpression otherlv_2= '}'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLiteralFunction_LeftCurlyBracketKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_70); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getLiteralFunction_ClosureExpressionParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_65);
            ruleClosureExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLiteralFunction_RightCurlyBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, ruleLiteralFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleLiteralFunction"

}

@SuppressWarnings("all")
abstract class PsiInternalBeeLangTestLanguageParser3 extends PsiInternalBeeLangTestLanguageParser2 {

        PsiInternalBeeLangTestLanguageParser3(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalBeeLangTestLanguageParser3(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleClosureExpression"
    // PsiInternalBeeLangTestLanguage.g:4138:1: entryRuleClosureExpression : ruleClosureExpression EOF ;
    public final void entryRuleClosureExpression() throws RecognitionException {
        int entryRuleClosureExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4138:27: ( ruleClosureExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4139:2: ruleClosureExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleClosureExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, entryRuleClosureExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleClosureExpression"


    // $ANTLR start "ruleClosureExpression"
    // PsiInternalBeeLangTestLanguage.g:4144:1: ruleClosureExpression : ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) ;
    public final void ruleClosureExpression() throws RecognitionException {
        int ruleClosureExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        Token lv_varArgs_11_0=null;
        Token otherlv_13=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4144:22: ( ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4145:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4145:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            // PsiInternalBeeLangTestLanguage.g:4146:3: () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4146:3: ()
            // PsiInternalBeeLangTestLanguage.g:4147:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getClosureExpression_FunctionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4155:3: (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==52) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4156:4: otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getClosureExpression_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_31); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:4163:4: ( (lv_returnType_2_0= ruleTypeRef ) )
                    // PsiInternalBeeLangTestLanguage.g:4164:5: (lv_returnType_2_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4164:5: (lv_returnType_2_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:4165:6: lv_returnType_2_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getClosureExpression_ReturnTypeTypeRefParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_71);
                    ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getClosureExpression_GreaterThanSignKeyword_1_2ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_72); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:4182:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?
            int alt90=3;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4183:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4183:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    // PsiInternalBeeLangTestLanguage.g:4184:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4184:5: (otherlv_4= '|' )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==77) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:4185:6: otherlv_4= '|'
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getClosureExpression_VerticalLineKeyword_2_0_0ElementType());
                              					
                            }
                            otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_35); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(otherlv_4);
                              					
                            }

                            }
                            break;

                    }

                    // PsiInternalBeeLangTestLanguage.g:4193:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    // PsiInternalBeeLangTestLanguage.g:4194:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    {
                    // PsiInternalBeeLangTestLanguage.g:4194:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    // PsiInternalBeeLangTestLanguage.g:4195:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4195:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    // PsiInternalBeeLangTestLanguage.g:4196:8: lv_parameters_5_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_0_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_73);
                    ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      							
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:4205:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==16) ) {
                            int LA88_1 = input.LA(2);

                            if ( (LA88_1==RULE_ID||LA88_1==35) ) {
                                alt88=1;
                            }


                        }


                        switch (alt88) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:4206:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_1_0ElementType());
                    	      						
                    	    }
                    	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_6);
                    	      						
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:4213:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    // PsiInternalBeeLangTestLanguage.g:4214:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:4214:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    // PsiInternalBeeLangTestLanguage.g:4215:9: lv_parameters_7_0= ruleParameterDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0ElementType());
                    	      								
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_73);
                    	    ruleParameterDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      									doneComposite();
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
                        }
                    } while (true);

                    // PsiInternalBeeLangTestLanguage.g:4225:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==16) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:4226:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_2_0ElementType());
                              						
                            }
                            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_8);
                              						
                            }
                            // PsiInternalBeeLangTestLanguage.g:4233:7: ( (lv_varArgs_9_0= '...' ) )
                            // PsiInternalBeeLangTestLanguage.g:4234:8: (lv_varArgs_9_0= '...' )
                            {
                            // PsiInternalBeeLangTestLanguage.g:4234:8: (lv_varArgs_9_0= '...' )
                            // PsiInternalBeeLangTestLanguage.g:4235:9: lv_varArgs_9_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              									markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0ElementType());
                              								
                            }
                            lv_varArgs_9_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneLeaf(lv_varArgs_9_0);
                              								
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:4244:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            // PsiInternalBeeLangTestLanguage.g:4245:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            {
                            // PsiInternalBeeLangTestLanguage.g:4245:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            // PsiInternalBeeLangTestLanguage.g:4246:9: lv_parameters_10_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_74);
                            ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              								
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:4259:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4259:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    // PsiInternalBeeLangTestLanguage.g:4260:5: ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4260:5: ( (lv_varArgs_11_0= '...' ) )
                    // PsiInternalBeeLangTestLanguage.g:4261:6: (lv_varArgs_11_0= '...' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4261:6: (lv_varArgs_11_0= '...' )
                    // PsiInternalBeeLangTestLanguage.g:4262:7: lv_varArgs_11_0= '...'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_1_0_0ElementType());
                      						
                    }
                    lv_varArgs_11_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_varArgs_11_0);
                      						
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:4271:5: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    // PsiInternalBeeLangTestLanguage.g:4272:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4272:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    // PsiInternalBeeLangTestLanguage.g:4273:7: lv_parameters_12_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_74);
                    ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureExpression_VerticalLineKeyword_3ElementType());
              		
            }
            otherlv_13=(Token)match(input,77,FollowSets000.FOLLOW_64); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_13);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4291:3: ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            // PsiInternalBeeLangTestLanguage.g:4292:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            {
            // PsiInternalBeeLangTestLanguage.g:4292:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            // PsiInternalBeeLangTestLanguage.g:4293:5: lv_funcExpr_14_0= ruleOneOrManyExpressions
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getClosureExpression_FuncExprOneOrManyExpressionsParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              					doneComposite();
              				
            }

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 102, ruleClosureExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleClosureExpression"


    // $ANTLR start "entryRuleOneOrManyExpressions"
    // PsiInternalBeeLangTestLanguage.g:4306:1: entryRuleOneOrManyExpressions : ruleOneOrManyExpressions EOF ;
    public final void entryRuleOneOrManyExpressions() throws RecognitionException {
        int entryRuleOneOrManyExpressions_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4306:30: ( ruleOneOrManyExpressions EOF )
            // PsiInternalBeeLangTestLanguage.g:4307:2: ruleOneOrManyExpressions EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOneOrManyExpressionsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, entryRuleOneOrManyExpressions_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleOneOrManyExpressions"


    // $ANTLR start "ruleOneOrManyExpressions"
    // PsiInternalBeeLangTestLanguage.g:4312:1: ruleOneOrManyExpressions : ( ruleBlockExpressionWithoutBrackets | ruleExpression ) ;
    public final void ruleOneOrManyExpressions() throws RecognitionException {
        int ruleOneOrManyExpressions_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4312:25: ( ( ruleBlockExpressionWithoutBrackets | ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:4313:2: ( ruleBlockExpressionWithoutBrackets | ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:4313:2: ( ruleBlockExpressionWithoutBrackets | ruleExpression )
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4314:3: ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getOneOrManyExpressions_BlockExpressionWithoutBracketsParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:4325:3: ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getOneOrManyExpressions_ExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExpression();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 104, ruleOneOrManyExpressions_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleOneOrManyExpressions"


    // $ANTLR start "entryRuleBlockExpressionWithoutBrackets"
    // PsiInternalBeeLangTestLanguage.g:4339:1: entryRuleBlockExpressionWithoutBrackets : ruleBlockExpressionWithoutBrackets EOF ;
    public final void entryRuleBlockExpressionWithoutBrackets() throws RecognitionException {
        int entryRuleBlockExpressionWithoutBrackets_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4339:40: ( ruleBlockExpressionWithoutBrackets EOF )
            // PsiInternalBeeLangTestLanguage.g:4340:2: ruleBlockExpressionWithoutBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBlockExpressionWithoutBracketsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBlockExpressionWithoutBrackets();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, entryRuleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleBlockExpressionWithoutBrackets"


    // $ANTLR start "ruleBlockExpressionWithoutBrackets"
    // PsiInternalBeeLangTestLanguage.g:4345:1: ruleBlockExpressionWithoutBrackets : ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) ;
    public final void ruleBlockExpressionWithoutBrackets() throws RecognitionException {
        int ruleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4345:35: ( ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) )
            // PsiInternalBeeLangTestLanguage.g:4346:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            {
            // PsiInternalBeeLangTestLanguage.g:4346:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            // PsiInternalBeeLangTestLanguage.g:4347:3: () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            {
            // PsiInternalBeeLangTestLanguage.g:4347:3: ()
            // PsiInternalBeeLangTestLanguage.g:4348:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBlockExpressionWithoutBrackets_ChainedExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4356:3: ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==RULE_ID||LA92_0==RULE_STRING||LA92_0==13||(LA92_0>=17 && LA92_0<=18)||LA92_0==21||LA92_0==33||LA92_0==35||(LA92_0>=53 && LA92_0<=54)||LA92_0==56||LA92_0==60||(LA92_0>=64 && LA92_0<=66)||LA92_0==70||(LA92_0>=72 && LA92_0<=76)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:4357:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:4357:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:4358:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:4358:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    // PsiInternalBeeLangTestLanguage.g:4359:6: lv_expressions_1_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getBlockExpressionWithoutBrackets_ExpressionsTopLevelExpressionParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      					
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getBlockExpressionWithoutBrackets_SemicolonKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_75); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt92 >= 1 ) break loop92;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(92, input);
                        throw eee;
                }
                cnt92++;
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 106, ruleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleBlockExpressionWithoutBrackets"


    // $ANTLR start "entryRuleValueLiteral"
    // PsiInternalBeeLangTestLanguage.g:4380:1: entryRuleValueLiteral : ruleValueLiteral EOF ;
    public final void entryRuleValueLiteral() throws RecognitionException {
        int entryRuleValueLiteral_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4380:22: ( ruleValueLiteral EOF )
            // PsiInternalBeeLangTestLanguage.g:4381:2: ruleValueLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValueLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleValueLiteral();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, entryRuleValueLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleValueLiteral"


    // $ANTLR start "ruleValueLiteral"
    // PsiInternalBeeLangTestLanguage.g:4386:1: ruleValueLiteral : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final void ruleValueLiteral() throws RecognitionException {
        int ruleValueLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4386:17: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // PsiInternalBeeLangTestLanguage.g:4387:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4387:2: ( (lv_value_0_0= RULE_STRING ) )
            // PsiInternalBeeLangTestLanguage.g:4388:3: (lv_value_0_0= RULE_STRING )
            {
            // PsiInternalBeeLangTestLanguage.g:4388:3: (lv_value_0_0= RULE_STRING )
            // PsiInternalBeeLangTestLanguage.g:4389:4: lv_value_0_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getValueLiteral_ValueSTRINGTerminalRuleCall_0ElementType());
              			
            }
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(lv_value_0_0);
              			
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 108, ruleValueLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleValueLiteral"


    // $ANTLR start "entryRuleParanthesizedExpression"
    // PsiInternalBeeLangTestLanguage.g:4401:1: entryRuleParanthesizedExpression : ruleParanthesizedExpression EOF ;
    public final void entryRuleParanthesizedExpression() throws RecognitionException {
        int entryRuleParanthesizedExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4401:33: ( ruleParanthesizedExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4402:2: ruleParanthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParanthesizedExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParanthesizedExpression();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, entryRuleParanthesizedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParanthesizedExpression"


    // $ANTLR start "ruleParanthesizedExpression"
    // PsiInternalBeeLangTestLanguage.g:4407:1: ruleParanthesizedExpression : (otherlv_0= '(' ruleExpression otherlv_2= ')' ) ;
    public final void ruleParanthesizedExpression() throws RecognitionException {
        int ruleParanthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4407:28: ( (otherlv_0= '(' ruleExpression otherlv_2= ')' ) )
            // PsiInternalBeeLangTestLanguage.g:4408:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            {
            // PsiInternalBeeLangTestLanguage.g:4408:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            // PsiInternalBeeLangTestLanguage.g:4409:3: otherlv_0= '(' ruleExpression otherlv_2= ')'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getParanthesizedExpression_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_19); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getParanthesizedExpression_ExpressionParserRuleCall_1ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_37);
            ruleExpression();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getParanthesizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 110, ruleParanthesizedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParanthesizedExpression"


    // $ANTLR start "entryRuleQID"
    // PsiInternalBeeLangTestLanguage.g:4437:1: entryRuleQID : ruleQID EOF ;
    public final void entryRuleQID() throws RecognitionException {
        int entryRuleQID_StartIndex = input.index();

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4439:2: ( ruleQID EOF )
            // PsiInternalBeeLangTestLanguage.g:4440:2: ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQIDElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQID();

            state._fsp--;
            if (state.failed) return ;
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, entryRuleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // PsiInternalBeeLangTestLanguage.g:4448:1: ruleQID : (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) ;
    public final void ruleQID() throws RecognitionException {
        int ruleQID_StartIndex = input.index();
        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_HEX_2=null;
        Token this_ID_3=null;
        Token kw=null;
        Token this_ID_5=null;
        Token this_INT_6=null;
        Token this_HEX_7=null;
        Token this_ID_8=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return ; }
            // PsiInternalBeeLangTestLanguage.g:4450:2: ( (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) )
            // PsiInternalBeeLangTestLanguage.g:4451:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            {
            // PsiInternalBeeLangTestLanguage.g:4451:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            // PsiInternalBeeLangTestLanguage.g:4452:3: this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4459:3: (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )*
            loop93:
            do {
                int alt93=4;
                switch ( input.LA(1) ) {
                case RULE_INT:
                    {
                    alt93=1;
                    }
                    break;
                case RULE_HEX:
                    {
                    alt93=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt93=3;
                    }
                    break;

                }

                switch (alt93) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:4460:4: this_INT_1= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_INTTerminalRuleCall_1_0ElementType());
            	      			
            	    }
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_76); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_INT_1);
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:4468:4: this_HEX_2= RULE_HEX
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_HEXTerminalRuleCall_1_1ElementType());
            	      			
            	    }
            	    this_HEX_2=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_76); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_HEX_2);
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:4476:4: this_ID_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_1_2ElementType());
            	      			
            	    }
            	    this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_ID_3);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            // PsiInternalBeeLangTestLanguage.g:4484:3: (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==67) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:4485:4: kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_FullStopKeyword_2_0ElementType());
            	      			
            	    }
            	    kw=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(kw);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_2_1ElementType());
            	      			
            	    }
            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_ID_5);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:4499:4: (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    loop94:
            	    do {
            	        int alt94=4;
            	        switch ( input.LA(1) ) {
            	        case RULE_INT:
            	            {
            	            alt94=1;
            	            }
            	            break;
            	        case RULE_HEX:
            	            {
            	            alt94=2;
            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            alt94=3;
            	            }
            	            break;

            	        }

            	        switch (alt94) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:4500:5: this_INT_6= RULE_INT
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_INTTerminalRuleCall_2_2_0ElementType());
            	    	      				
            	    	    }
            	    	    this_INT_6=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_76); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_INT_6);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // PsiInternalBeeLangTestLanguage.g:4508:5: this_HEX_7= RULE_HEX
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_HEXTerminalRuleCall_2_2_1ElementType());
            	    	      				
            	    	    }
            	    	    this_HEX_7=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_76); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_HEX_7);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // PsiInternalBeeLangTestLanguage.g:4516:5: this_ID_8= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_2_2_2ElementType());
            	    	      				
            	    	    }
            	    	    this_ID_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return ;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_ID_8);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop94;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop95;
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
            if ( state.backtracking>0 ) { memoize(input, 112, ruleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleQID"

    // $ANTLR start synpred2_PsiInternalBeeLangTestLanguage
    public final void synpred2_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:68:3: ( ( (lv_units_0_0= ruleUnit ) )* )
        // PsiInternalBeeLangTestLanguage.g:68:3: ( (lv_units_0_0= ruleUnit ) )*
        {
        // PsiInternalBeeLangTestLanguage.g:68:3: ( (lv_units_0_0= ruleUnit ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_DOCUMENTATION||LA96_0==13) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:69:4: (lv_units_0_0= ruleUnit )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:69:4: (lv_units_0_0= ruleUnit )
        	    // PsiInternalBeeLangTestLanguage.g:70:5: lv_units_0_0= ruleUnit
        	    {
        	    if ( state.backtracking==0 ) {

        	      					markComposite(elementTypeProvider.getModel_UnitsUnitParserRuleCall_0_0ElementType());
        	      				
        	    }
        	    pushFollow(FollowSets000.FOLLOW_3);
        	    ruleUnit();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop96;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred2_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred9_PsiInternalBeeLangTestLanguage
    public final void synpred9_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;

        // PsiInternalBeeLangTestLanguage.g:226:4: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:226:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:226:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:227:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:227:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:228:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
        // PsiInternalBeeLangTestLanguage.g:231:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:231:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:231:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        // PsiInternalBeeLangTestLanguage.g:231:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_SourceKeyword_7_0_0ElementType());
          								
        }
        otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:245:9: ( (lv_sourceLocation_14_0= rulePath ) )
        // PsiInternalBeeLangTestLanguage.g:246:10: (lv_sourceLocation_14_0= rulePath )
        {
        // PsiInternalBeeLangTestLanguage.g:246:10: (lv_sourceLocation_14_0= rulePath )
        // PsiInternalBeeLangTestLanguage.g:247:11: lv_sourceLocation_14_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_SourceLocationPathParserRuleCall_7_0_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        rulePath();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred10_PsiInternalBeeLangTestLanguage
    public final void synpred10_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;

        // PsiInternalBeeLangTestLanguage.g:269:4: ( ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:269:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:269:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:270:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:270:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:271:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
        // PsiInternalBeeLangTestLanguage.g:274:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:274:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:274:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        // PsiInternalBeeLangTestLanguage.g:274:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_OutputKeyword_7_1_0ElementType());
          								
        }
        otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:288:9: ( (lv_outputLocation_18_0= rulePath ) )
        // PsiInternalBeeLangTestLanguage.g:289:10: (lv_outputLocation_18_0= rulePath )
        {
        // PsiInternalBeeLangTestLanguage.g:289:10: (lv_outputLocation_18_0= rulePath )
        // PsiInternalBeeLangTestLanguage.g:290:11: lv_outputLocation_18_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_OutputLocationPathParserRuleCall_7_1_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        rulePath();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred11_PsiInternalBeeLangTestLanguage
    public final void synpred11_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;

        // PsiInternalBeeLangTestLanguage.g:317:10: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:317:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:317:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        // PsiInternalBeeLangTestLanguage.g:317:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
          								
        }
        otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:331:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        // PsiInternalBeeLangTestLanguage.g:332:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        {
        // PsiInternalBeeLangTestLanguage.g:332:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        // PsiInternalBeeLangTestLanguage.g:333:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        ruleProvidedCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred12_PsiInternalBeeLangTestLanguage
    public final void synpred12_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;

        // PsiInternalBeeLangTestLanguage.g:312:4: ( ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:313:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:313:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        // PsiInternalBeeLangTestLanguage.g:314:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
        // PsiInternalBeeLangTestLanguage.g:317:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        int cnt98=0;
        loop98:
        do {
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==22) && ((true))) {
                alt98=1;
            }


            switch (alt98) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:317:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred12_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:317:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    // PsiInternalBeeLangTestLanguage.g:317:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
        	      								
        	    }
        	    otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:331:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        	    // PsiInternalBeeLangTestLanguage.g:332:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:332:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    // PsiInternalBeeLangTestLanguage.g:333:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
        	      										
        	    }
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    ruleProvidedCapability();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_77); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt98 >= 1 ) break loop98;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(98, input);
                    throw eee;
            }
            cnt98++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred12_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred13_PsiInternalBeeLangTestLanguage
    public final void synpred13_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;

        // PsiInternalBeeLangTestLanguage.g:360:10: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:360:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:360:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        // PsiInternalBeeLangTestLanguage.g:360:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
          								
        }
        otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:374:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        // PsiInternalBeeLangTestLanguage.g:375:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        {
        // PsiInternalBeeLangTestLanguage.g:375:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        // PsiInternalBeeLangTestLanguage.g:376:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        ruleAliasedRequiredCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred14_PsiInternalBeeLangTestLanguage
    public final void synpred14_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;

        // PsiInternalBeeLangTestLanguage.g:355:4: ( ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:355:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:355:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:356:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred14_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
        }
        // PsiInternalBeeLangTestLanguage.g:356:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        // PsiInternalBeeLangTestLanguage.g:357:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
        // PsiInternalBeeLangTestLanguage.g:360:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        int cnt99=0;
        loop99:
        do {
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==23) && ((true))) {
                alt99=1;
            }


            switch (alt99) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:360:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred14_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:360:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    // PsiInternalBeeLangTestLanguage.g:360:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
        	      								
        	    }
        	    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:374:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        	    // PsiInternalBeeLangTestLanguage.g:375:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:375:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    // PsiInternalBeeLangTestLanguage.g:376:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
        	      										
        	    }
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    ruleAliasedRequiredCapability();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_78); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt99 >= 1 ) break loop99;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(99, input);
                    throw eee;
            }
            cnt99++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred14_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred15_PsiInternalBeeLangTestLanguage
    public final void synpred15_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;

        // PsiInternalBeeLangTestLanguage.g:403:10: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:403:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:403:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        // PsiInternalBeeLangTestLanguage.g:403:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
          								
        }
        otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:424:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        // PsiInternalBeeLangTestLanguage.g:425:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        {
        // PsiInternalBeeLangTestLanguage.g:425:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        // PsiInternalBeeLangTestLanguage.g:426:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        ruleRequiredCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred16_PsiInternalBeeLangTestLanguage
    public final void synpred16_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;

        // PsiInternalBeeLangTestLanguage.g:398:4: ( ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:398:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:398:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:399:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
        }
        // PsiInternalBeeLangTestLanguage.g:399:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        // PsiInternalBeeLangTestLanguage.g:400:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
        // PsiInternalBeeLangTestLanguage.g:403:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        int cnt100=0;
        loop100:
        do {
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==23) && ((true))) {
                alt100=1;
            }


            switch (alt100) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:403:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred16_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:403:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    // PsiInternalBeeLangTestLanguage.g:403:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
        	      								
        	    }
        	    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        	    otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:424:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        	    // PsiInternalBeeLangTestLanguage.g:425:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:425:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    // PsiInternalBeeLangTestLanguage.g:426:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
        	      										
        	    }
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    ruleRequiredCapability();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_78); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt100 >= 1 ) break loop100;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(100, input);
                    throw eee;
            }
            cnt100++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred16_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred17_PsiInternalBeeLangTestLanguage
    public final void synpred17_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:453:10: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )
        // PsiInternalBeeLangTestLanguage.g:453:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:453:19: ( (lv_functions_33_0= ruleFunction ) )
        // PsiInternalBeeLangTestLanguage.g:453:20: (lv_functions_33_0= ruleFunction )
        {
        // PsiInternalBeeLangTestLanguage.g:453:20: (lv_functions_33_0= ruleFunction )
        // PsiInternalBeeLangTestLanguage.g:454:10: lv_functions_33_0= ruleFunction
        {
        if ( state.backtracking==0 ) {

          										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
          									
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleFunction();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred18_PsiInternalBeeLangTestLanguage
    public final void synpred18_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:448:4: ( ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:448:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:448:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:449:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred18_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
        }
        // PsiInternalBeeLangTestLanguage.g:449:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        // PsiInternalBeeLangTestLanguage.g:450:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
        // PsiInternalBeeLangTestLanguage.g:453:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        int cnt101=0;
        loop101:
        do {
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==RULE_DOCUMENTATION) && ((true))) {
                alt101=1;
            }
            else if ( (LA101_0==RULE_ID) && ((true))) {
                alt101=1;
            }
            else if ( (LA101_0==33) && ((true))) {
                alt101=1;
            }
            else if ( (LA101_0==34) && ((true))) {
                alt101=1;
            }


            switch (alt101) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:453:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred18_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:453:19: ( (lv_functions_33_0= ruleFunction ) )
        	    // PsiInternalBeeLangTestLanguage.g:453:20: (lv_functions_33_0= ruleFunction )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:453:20: (lv_functions_33_0= ruleFunction )
        	    // PsiInternalBeeLangTestLanguage.g:454:10: lv_functions_33_0= ruleFunction
        	    {
        	    if ( state.backtracking==0 ) {

        	      										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
        	      									
        	    }
        	    pushFollow(FollowSets000.FOLLOW_4);
        	    ruleFunction();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt101 >= 1 ) break loop101;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(101, input);
                    throw eee;
            }
            cnt101++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred18_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred20_PsiInternalBeeLangTestLanguage
    public final void synpred20_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

        // PsiInternalBeeLangTestLanguage.g:553:5: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:553:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:553:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:554:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:554:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:555:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
        // PsiInternalBeeLangTestLanguage.g:558:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:558:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:558:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        // PsiInternalBeeLangTestLanguage.g:558:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_WhenKeyword_2_1_0_0ElementType());
          									
        }
        otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:572:10: ( (lv_condExpr_7_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:573:11: (lv_condExpr_7_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:573:11: (lv_condExpr_7_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:574:12: lv_condExpr_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getProvidedCapability_CondExprExpressionParserRuleCall_2_1_0_2_0ElementType());
          											
        }
        pushFollow(FollowSets000.FOLLOW_14);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred20_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred21_PsiInternalBeeLangTestLanguage
    public final void synpred21_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;

        // PsiInternalBeeLangTestLanguage.g:596:5: ( ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:596:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:596:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:597:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:597:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:598:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
        // PsiInternalBeeLangTestLanguage.g:601:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:601:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:601:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        // PsiInternalBeeLangTestLanguage.g:601:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_NameKeyword_2_1_1_0ElementType());
          									
        }
        otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:615:10: ( (lv_name_11_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:616:11: (lv_name_11_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:616:11: (lv_name_11_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:617:12: lv_name_11_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getProvidedCapability_NameIDTerminalRuleCall_2_1_1_2_0ElementType());
          											
        }
        lv_name_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred21_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred22_PsiInternalBeeLangTestLanguage
    public final void synpred22_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;

        // PsiInternalBeeLangTestLanguage.g:639:5: ( ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:639:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:639:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:640:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:640:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:641:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
        // PsiInternalBeeLangTestLanguage.g:644:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:644:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:644:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        // PsiInternalBeeLangTestLanguage.g:644:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_VersionKeyword_2_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:658:10: ( (lv_version_15_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:659:11: (lv_version_15_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:659:11: (lv_version_15_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:660:12: lv_version_15_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getProvidedCapability_VersionIDTerminalRuleCall_2_1_2_2_0ElementType());
          											
        }
        lv_version_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred22_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred26_PsiInternalBeeLangTestLanguage
    public final void synpred26_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;

        // PsiInternalBeeLangTestLanguage.g:791:5: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:791:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:791:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:792:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:792:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:793:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalBeeLangTestLanguage.g:796:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:796:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:796:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        // PsiInternalBeeLangTestLanguage.g:796:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:810:10: ( (lv_condExpr_9_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:811:11: (lv_condExpr_9_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:811:11: (lv_condExpr_9_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:812:12: lv_condExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getAliasedRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
          											
        }
        pushFollow(FollowSets000.FOLLOW_14);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred26_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred27_PsiInternalBeeLangTestLanguage
    public final void synpred27_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;

        // PsiInternalBeeLangTestLanguage.g:834:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:834:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:834:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:835:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:835:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:836:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalBeeLangTestLanguage.g:839:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:839:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:839:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        // PsiInternalBeeLangTestLanguage.g:839:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
        {
        // PsiInternalBeeLangTestLanguage.g:839:21: ( (lv_greedy_11_0= 'greedy' ) )
        // PsiInternalBeeLangTestLanguage.g:840:11: (lv_greedy_11_0= 'greedy' )
        {
        // PsiInternalBeeLangTestLanguage.g:840:11: (lv_greedy_11_0= 'greedy' )
        // PsiInternalBeeLangTestLanguage.g:841:12: lv_greedy_11_0= 'greedy'
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
          											
        }
        lv_greedy_11_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred27_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred28_PsiInternalBeeLangTestLanguage
    public final void synpred28_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;

        // PsiInternalBeeLangTestLanguage.g:863:5: ( ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:863:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:863:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:864:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:864:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:865:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalBeeLangTestLanguage.g:868:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:868:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:868:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        // PsiInternalBeeLangTestLanguage.g:868:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:882:10: ( (lv_min_15_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:883:11: (lv_min_15_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:883:11: (lv_min_15_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:884:12: lv_min_15_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
          											
        }
        lv_min_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred28_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred29_PsiInternalBeeLangTestLanguage
    public final void synpred29_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;

        // PsiInternalBeeLangTestLanguage.g:906:5: ( ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:906:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:906:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:907:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalBeeLangTestLanguage.g:907:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:908:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalBeeLangTestLanguage.g:911:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:911:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:911:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        // PsiInternalBeeLangTestLanguage.g:911:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:925:10: ( (lv_max_19_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:926:11: (lv_max_19_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:926:11: (lv_max_19_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:927:12: lv_max_19_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
          											
        }
        lv_max_19_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred29_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred30_PsiInternalBeeLangTestLanguage
    public final void synpred30_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;

        // PsiInternalBeeLangTestLanguage.g:949:5: ( ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:949:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:949:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:950:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalBeeLangTestLanguage.g:950:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:951:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalBeeLangTestLanguage.g:954:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:954:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:954:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        // PsiInternalBeeLangTestLanguage.g:954:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_21=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:968:10: ( (lv_versionRange_23_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:969:11: (lv_versionRange_23_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:969:11: (lv_versionRange_23_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:970:12: lv_versionRange_23_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
          											
        }
        lv_versionRange_23_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred30_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred32_PsiInternalBeeLangTestLanguage
    public final void synpred32_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;

        // PsiInternalBeeLangTestLanguage.g:1089:5: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1089:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1089:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1090:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:1090:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1091:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalBeeLangTestLanguage.g:1094:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1094:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1094:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        // PsiInternalBeeLangTestLanguage.g:1094:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1108:10: ( (lv_condExpr_8_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:1109:11: (lv_condExpr_8_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:1109:11: (lv_condExpr_8_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:1110:12: lv_condExpr_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
          											
        }
        pushFollow(FollowSets000.FOLLOW_14);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred32_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred33_PsiInternalBeeLangTestLanguage
    public final void synpred33_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;

        // PsiInternalBeeLangTestLanguage.g:1132:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1132:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1132:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1133:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:1133:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1134:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalBeeLangTestLanguage.g:1137:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1137:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1137:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        // PsiInternalBeeLangTestLanguage.g:1137:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
        {
        // PsiInternalBeeLangTestLanguage.g:1137:21: ( (lv_greedy_10_0= 'greedy' ) )
        // PsiInternalBeeLangTestLanguage.g:1138:11: (lv_greedy_10_0= 'greedy' )
        {
        // PsiInternalBeeLangTestLanguage.g:1138:11: (lv_greedy_10_0= 'greedy' )
        // PsiInternalBeeLangTestLanguage.g:1139:12: lv_greedy_10_0= 'greedy'
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
          											
        }
        lv_greedy_10_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred33_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred34_PsiInternalBeeLangTestLanguage
    public final void synpred34_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;

        // PsiInternalBeeLangTestLanguage.g:1161:5: ( ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1161:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1161:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1162:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:1162:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1163:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalBeeLangTestLanguage.g:1166:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1166:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1166:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        // PsiInternalBeeLangTestLanguage.g:1166:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1180:10: ( (lv_min_14_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:1181:11: (lv_min_14_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:1181:11: (lv_min_14_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:1182:12: lv_min_14_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
          											
        }
        lv_min_14_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred34_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred35_PsiInternalBeeLangTestLanguage
    public final void synpred35_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;

        // PsiInternalBeeLangTestLanguage.g:1204:5: ( ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1204:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1204:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1205:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalBeeLangTestLanguage.g:1205:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1206:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalBeeLangTestLanguage.g:1209:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1209:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1209:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        // PsiInternalBeeLangTestLanguage.g:1209:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_16=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1223:10: ( (lv_max_18_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:1224:11: (lv_max_18_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:1224:11: (lv_max_18_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:1225:12: lv_max_18_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
          											
        }
        lv_max_18_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred35_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred36_PsiInternalBeeLangTestLanguage
    public final void synpred36_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;

        // PsiInternalBeeLangTestLanguage.g:1247:5: ( ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1247:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1247:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1248:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalBeeLangTestLanguage.g:1248:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1249:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalBeeLangTestLanguage.g:1252:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1252:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1252:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        // PsiInternalBeeLangTestLanguage.g:1252:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1266:10: ( (lv_versionRange_22_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:1267:11: (lv_versionRange_22_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:1267:11: (lv_versionRange_22_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:1268:12: lv_versionRange_22_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
          											
        }
        lv_versionRange_22_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred36_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred42_PsiInternalBeeLangTestLanguage
    public final void synpred42_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:1436:3: ( ruleClosureParameter )
        // PsiInternalBeeLangTestLanguage.g:1436:3: ruleClosureParameter
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleClosureParameter();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred69_PsiInternalBeeLangTestLanguage
    public final void synpred69_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:1980:3: ( ruleVarDeclaration )
        // PsiInternalBeeLangTestLanguage.g:1980:3: ruleVarDeclaration
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleVarDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred69_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred71_PsiInternalBeeLangTestLanguage
    public final void synpred71_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:2055:4: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2055:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2055:4: ()
        // PsiInternalBeeLangTestLanguage.g:2056:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:2064:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
        // PsiInternalBeeLangTestLanguage.g:2065:5: (lv_functionName_2_0= ruleAssignmentOperator )
        {
        // PsiInternalBeeLangTestLanguage.g:2065:5: (lv_functionName_2_0= ruleAssignmentOperator )
        // PsiInternalBeeLangTestLanguage.g:2066:6: lv_functionName_2_0= ruleAssignmentOperator
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAssignmentExpression_FunctionNameAssignmentOperatorParserRuleCall_1_1_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_19);
        ruleAssignmentOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:2075:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2076:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2076:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        // PsiInternalBeeLangTestLanguage.g:2077:6: lv_rightExpr_3_0= ruleAssignmentExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAssignmentExpression_RightExprAssignmentExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleAssignmentExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred71_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred85_PsiInternalBeeLangTestLanguage
    public final void synpred85_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalBeeLangTestLanguage.g:2569:4: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2569:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2569:4: ()
        // PsiInternalBeeLangTestLanguage.g:2570:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:2585:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2586:5: (lv_rightExpr_3_0= ruleAndExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2586:5: (lv_rightExpr_3_0= ruleAndExpression )
        // PsiInternalBeeLangTestLanguage.g:2587:6: lv_rightExpr_3_0= ruleAndExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getOrExpression_RightExprAndExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred85_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred86_PsiInternalBeeLangTestLanguage
    public final void synpred86_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalBeeLangTestLanguage.g:2620:4: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2620:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2620:4: ()
        // PsiInternalBeeLangTestLanguage.g:2621:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:2636:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2637:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2637:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        // PsiInternalBeeLangTestLanguage.g:2638:6: lv_rightExpr_3_0= ruleRelationalExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAndExpression_RightExprRelationalExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred86_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred87_PsiInternalBeeLangTestLanguage
    public final void synpred87_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:2671:4: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2671:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2671:4: ()
        // PsiInternalBeeLangTestLanguage.g:2672:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:2680:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
        // PsiInternalBeeLangTestLanguage.g:2681:5: (lv_functionName_2_0= ruleRelationalOperator )
        {
        // PsiInternalBeeLangTestLanguage.g:2681:5: (lv_functionName_2_0= ruleRelationalOperator )
        // PsiInternalBeeLangTestLanguage.g:2682:6: lv_functionName_2_0= ruleRelationalOperator
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getRelationalExpression_FunctionNameRelationalOperatorParserRuleCall_1_1_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_19);
        ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:2691:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2692:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2692:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        // PsiInternalBeeLangTestLanguage.g:2693:6: lv_rightExpr_3_0= ruleAdditiveExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getRelationalExpression_RightExprAdditiveExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred87_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred89_PsiInternalBeeLangTestLanguage
    public final void synpred89_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // PsiInternalBeeLangTestLanguage.g:2726:4: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2726:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2726:4: ()
        // PsiInternalBeeLangTestLanguage.g:2727:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:2735:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
        // PsiInternalBeeLangTestLanguage.g:2736:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2736:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        // PsiInternalBeeLangTestLanguage.g:2737:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        {
        // PsiInternalBeeLangTestLanguage.g:2737:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        int alt111=2;
        int LA111_0 = input.LA(1);

        if ( (LA111_0==59) ) {
            alt111=1;
        }
        else if ( (LA111_0==60) ) {
            alt111=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 111, 0, input);

            throw nvae;
        }
        switch (alt111) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:2738:7: lv_functionName_2_1= '+'
                {
                lv_functionName_2_1=(Token)match(input,59,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalBeeLangTestLanguage.g:2746:7: lv_functionName_2_2= '-'
                {
                if ( state.backtracking==0 ) {

                  							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNameHyphenMinusKeyword_1_1_0_1ElementType());
                  						
                }
                lv_functionName_2_2=(Token)match(input,60,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // PsiInternalBeeLangTestLanguage.g:2756:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2757:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2757:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        // PsiInternalBeeLangTestLanguage.g:2758:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAdditiveExpression_RightExprMultiplicativeExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred89_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred92_PsiInternalBeeLangTestLanguage
    public final void synpred92_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;

        // PsiInternalBeeLangTestLanguage.g:2791:4: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2791:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2791:4: ()
        // PsiInternalBeeLangTestLanguage.g:2792:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:2800:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
        // PsiInternalBeeLangTestLanguage.g:2801:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2801:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        // PsiInternalBeeLangTestLanguage.g:2802:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        {
        // PsiInternalBeeLangTestLanguage.g:2802:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        int alt112=3;
        switch ( input.LA(1) ) {
        case 61:
            {
            alt112=1;
            }
            break;
        case 32:
            {
            alt112=2;
            }
            break;
        case 62:
            {
            alt112=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 112, 0, input);

            throw nvae;
        }

        switch (alt112) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:2803:7: lv_functionName_2_1= '*'
                {
                lv_functionName_2_1=(Token)match(input,61,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalBeeLangTestLanguage.g:2811:7: lv_functionName_2_2= '/'
                {
                lv_functionName_2_2=(Token)match(input,32,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 3 :
                // PsiInternalBeeLangTestLanguage.g:2819:7: lv_functionName_2_3= '%'
                {
                if ( state.backtracking==0 ) {

                  							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNamePercentSignKeyword_1_1_0_2ElementType());
                  						
                }
                lv_functionName_2_3=(Token)match(input,62,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // PsiInternalBeeLangTestLanguage.g:2829:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2830:5: (lv_rightExpr_3_0= ruleSetExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2830:5: (lv_rightExpr_3_0= ruleSetExpression )
        // PsiInternalBeeLangTestLanguage.g:2831:6: lv_rightExpr_3_0= ruleSetExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getMultiplicativeExpression_RightExprSetExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleSetExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred92_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred93_PsiInternalBeeLangTestLanguage
    public final void synpred93_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;

        // PsiInternalBeeLangTestLanguage.g:2864:4: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2864:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2864:4: ()
        // PsiInternalBeeLangTestLanguage.g:2865:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:2873:4: ( (lv_functionName_2_0= '..' ) )
        // PsiInternalBeeLangTestLanguage.g:2874:5: (lv_functionName_2_0= '..' )
        {
        // PsiInternalBeeLangTestLanguage.g:2874:5: (lv_functionName_2_0= '..' )
        // PsiInternalBeeLangTestLanguage.g:2875:6: lv_functionName_2_0= '..'
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSetExpression_FunctionNameFullStopFullStopKeyword_1_1_0ElementType());
          					
        }
        lv_functionName_2_0=(Token)match(input,63,FollowSets000.FOLLOW_19); if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:2884:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2885:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2885:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        // PsiInternalBeeLangTestLanguage.g:2886:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getSetExpression_RightExprUnaryOrInfixExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleUnaryOrInfixExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred93_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred99_PsiInternalBeeLangTestLanguage
    public final void synpred99_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // PsiInternalBeeLangTestLanguage.g:3069:4: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:3069:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3069:4: ()
        // PsiInternalBeeLangTestLanguage.g:3070:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:3078:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        // PsiInternalBeeLangTestLanguage.g:3079:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3079:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        // PsiInternalBeeLangTestLanguage.g:3080:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        {
        // PsiInternalBeeLangTestLanguage.g:3080:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        int alt113=2;
        int LA113_0 = input.LA(1);

        if ( (LA113_0==66) ) {
            alt113=1;
        }
        else if ( (LA113_0==65) ) {
            alt113=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 113, 0, input);

            throw nvae;
        }
        switch (alt113) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3081:7: lv_functionName_2_1= '--'
                {
                lv_functionName_2_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalBeeLangTestLanguage.g:3089:7: lv_functionName_2_2= '++'
                {
                if ( state.backtracking==0 ) {

                  							markLeaf(elementTypeProvider.getPostopExpression_FunctionNamePlusSignPlusSignKeyword_1_1_0_1ElementType());
                  						
                }
                lv_functionName_2_2=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred99_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred101_PsiInternalBeeLangTestLanguage
    public final void synpred101_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        // PsiInternalBeeLangTestLanguage.g:3123:4: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) )
        // PsiInternalBeeLangTestLanguage.g:3123:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        {
        // PsiInternalBeeLangTestLanguage.g:3123:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        // PsiInternalBeeLangTestLanguage.g:3124:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
        {
        // PsiInternalBeeLangTestLanguage.g:3124:5: ()
        // PsiInternalBeeLangTestLanguage.g:3125:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3140:5: ( (lv_name_3_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:3141:6: (lv_name_3_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:3141:6: (lv_name_3_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:3142:7: lv_name_3_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          							markLeaf(elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType());
          						
        }
        lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3158:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==RULE_ID||LA114_0==RULE_STRING||LA114_0==13||(LA114_0>=17 && LA114_0<=18)||LA114_0==21||(LA114_0>=35 && LA114_0<=36)||LA114_0==52||LA114_0==56||LA114_0==60||(LA114_0>=64 && LA114_0<=66)||LA114_0==70||(LA114_0>=72 && LA114_0<=77)) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3159:6: (lv_parameterList_5_0= ruleParameterList )
                {
                // PsiInternalBeeLangTestLanguage.g:3159:6: (lv_parameterList_5_0= ruleParameterList )
                // PsiInternalBeeLangTestLanguage.g:3160:7: lv_parameterList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  							markComposite(elementTypeProvider.getInfixExpression_ParameterListParameterListParserRuleCall_1_0_4_0ElementType());
                  						
                }
                pushFollow(FollowSets000.FOLLOW_37);
                ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred101_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred102_PsiInternalBeeLangTestLanguage
    public final void synpred102_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token otherlv_10=null;

        // PsiInternalBeeLangTestLanguage.g:3178:4: ( ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) )
        // PsiInternalBeeLangTestLanguage.g:3178:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        {
        // PsiInternalBeeLangTestLanguage.g:3178:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        // PsiInternalBeeLangTestLanguage.g:3179:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
        {
        // PsiInternalBeeLangTestLanguage.g:3179:5: ()
        // PsiInternalBeeLangTestLanguage.g:3180:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_8=(Token)match(input,68,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3195:5: ( (lv_indexExpr_9_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3196:6: (lv_indexExpr_9_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3196:6: (lv_indexExpr_9_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:3197:7: lv_indexExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          							markComposite(elementTypeProvider.getInfixExpression_IndexExprExpressionParserRuleCall_1_1_2_0ElementType());
          						
        }
        pushFollow(FollowSets000.FOLLOW_60);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred102_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred103_PsiInternalBeeLangTestLanguage
    public final void synpred103_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        // PsiInternalBeeLangTestLanguage.g:3215:4: ( ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:3215:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3215:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        // PsiInternalBeeLangTestLanguage.g:3216:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3216:5: ()
        // PsiInternalBeeLangTestLanguage.g:3217:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_12=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3232:5: ( (lv_featureName_13_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:3233:6: (lv_featureName_13_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:3233:6: (lv_featureName_13_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:3234:7: lv_featureName_13_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          							markLeaf(elementTypeProvider.getInfixExpression_FeatureNameIDTerminalRuleCall_1_2_2_0ElementType());
          						
        }
        lv_featureName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred103_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred105_PsiInternalBeeLangTestLanguage
    public final void synpred105_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;

        // PsiInternalBeeLangTestLanguage.g:3268:4: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
        // PsiInternalBeeLangTestLanguage.g:3268:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
        {
        // PsiInternalBeeLangTestLanguage.g:3268:4: ()
        // PsiInternalBeeLangTestLanguage.g:3269:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3284:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==RULE_ID||LA115_0==RULE_STRING||LA115_0==13||(LA115_0>=17 && LA115_0<=18)||LA115_0==21||(LA115_0>=35 && LA115_0<=36)||LA115_0==52||LA115_0==56||LA115_0==60||(LA115_0>=64 && LA115_0<=66)||LA115_0==70||(LA115_0>=72 && LA115_0<=77)) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3285:5: (lv_parameterList_3_0= ruleParameterList )
                {
                // PsiInternalBeeLangTestLanguage.g:3285:5: (lv_parameterList_3_0= ruleParameterList )
                // PsiInternalBeeLangTestLanguage.g:3286:6: lv_parameterList_3_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						markComposite(elementTypeProvider.getCallExpression_ParameterListParameterListParserRuleCall_1_2_0ElementType());
                  					
                }
                pushFollow(FollowSets000.FOLLOW_37);
                ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred106_PsiInternalBeeLangTestLanguage
    public final void synpred106_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:3315:3: ( ruleFeatureCall )
        // PsiInternalBeeLangTestLanguage.g:3315:3: ruleFeatureCall
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleFeatureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred108_PsiInternalBeeLangTestLanguage
    public final void synpred108_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:3337:3: ( ruleValue )
        // PsiInternalBeeLangTestLanguage.g:3337:3: ruleValue
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleValue();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred108_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred109_PsiInternalBeeLangTestLanguage
    public final void synpred109_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:3348:3: ( ruleLiteral )
        // PsiInternalBeeLangTestLanguage.g:3348:3: ruleLiteral
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred109_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred112_PsiInternalBeeLangTestLanguage
    public final void synpred112_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:3381:3: ( ruleBlockExpression )
        // PsiInternalBeeLangTestLanguage.g:3381:3: ruleBlockExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleBlockExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred113_PsiInternalBeeLangTestLanguage
    public final void synpred113_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:3392:3: ( ruleWithExpression )
        // PsiInternalBeeLangTestLanguage.g:3392:3: ruleWithExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleWithExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred127_PsiInternalBeeLangTestLanguage
    public final void synpred127_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;

        // PsiInternalBeeLangTestLanguage.g:3869:4: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )
        // PsiInternalBeeLangTestLanguage.g:3869:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
          			
        }
        otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3876:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==RULE_STRING||LA117_0==13||(LA117_0>=17 && LA117_0<=18)||LA117_0==21||(LA117_0>=35 && LA117_0<=36)||LA117_0==52||LA117_0==56||LA117_0==60||(LA117_0>=64 && LA117_0<=66)||LA117_0==70||(LA117_0>=72 && LA117_0<=77)) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3877:5: (lv_parameterList_4_0= ruleParameterList )
                {
                // PsiInternalBeeLangTestLanguage.g:3877:5: (lv_parameterList_4_0= ruleParameterList )
                // PsiInternalBeeLangTestLanguage.g:3878:6: lv_parameterList_4_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						markComposite(elementTypeProvider.getConstructorCallExpression_ParameterListParameterListParserRuleCall_3_1_0ElementType());
                  					
                }
                pushFollow(FollowSets000.FOLLOW_37);
                ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred127_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred128_PsiInternalBeeLangTestLanguage
    public final void synpred128_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        // PsiInternalBeeLangTestLanguage.g:3896:4: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )
        // PsiInternalBeeLangTestLanguage.g:3896:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
          			
        }
        otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3903:4: ( (lv_alias_7_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:3904:5: (lv_alias_7_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:3904:5: (lv_alias_7_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:3905:6: lv_alias_7_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getConstructorCallExpression_AliasIDTerminalRuleCall_4_1_0ElementType());
          					
        }
        lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred128_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred135_PsiInternalBeeLangTestLanguage
    public final void synpred135_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;

        // PsiInternalBeeLangTestLanguage.g:4183:4: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) )
        // PsiInternalBeeLangTestLanguage.g:4183:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        {
        // PsiInternalBeeLangTestLanguage.g:4183:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        // PsiInternalBeeLangTestLanguage.g:4184:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        {
        // PsiInternalBeeLangTestLanguage.g:4184:5: (otherlv_4= '|' )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==77) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:4185:6: otherlv_4= '|'
                {
                otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }
                break;

        }

        // PsiInternalBeeLangTestLanguage.g:4193:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        // PsiInternalBeeLangTestLanguage.g:4194:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        {
        // PsiInternalBeeLangTestLanguage.g:4194:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
        // PsiInternalBeeLangTestLanguage.g:4195:7: (lv_parameters_5_0= ruleParameterDeclaration )
        {
        // PsiInternalBeeLangTestLanguage.g:4195:7: (lv_parameters_5_0= ruleParameterDeclaration )
        // PsiInternalBeeLangTestLanguage.g:4196:8: lv_parameters_5_0= ruleParameterDeclaration
        {
        if ( state.backtracking==0 ) {

          								markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_0_0ElementType());
          							
        }
        pushFollow(FollowSets000.FOLLOW_26);
        ruleParameterDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:4205:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
        loop119:
        do {
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==16) ) {
                int LA119_1 = input.LA(2);

                if ( (LA119_1==RULE_ID||LA119_1==35) ) {
                    alt119=1;
                }


            }


            switch (alt119) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:4206:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    {
        	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:4213:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    // PsiInternalBeeLangTestLanguage.g:4214:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:4214:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    // PsiInternalBeeLangTestLanguage.g:4215:9: lv_parameters_7_0= ruleParameterDeclaration
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0ElementType());
        	      								
        	    }
        	    pushFollow(FollowSets000.FOLLOW_26);
        	    ruleParameterDeclaration();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop119;
            }
        } while (true);

        // PsiInternalBeeLangTestLanguage.g:4225:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==16) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:4226:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                {
                otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                // PsiInternalBeeLangTestLanguage.g:4233:7: ( (lv_varArgs_9_0= '...' ) )
                // PsiInternalBeeLangTestLanguage.g:4234:8: (lv_varArgs_9_0= '...' )
                {
                // PsiInternalBeeLangTestLanguage.g:4234:8: (lv_varArgs_9_0= '...' )
                // PsiInternalBeeLangTestLanguage.g:4235:9: lv_varArgs_9_0= '...'
                {
                if ( state.backtracking==0 ) {

                  									markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0ElementType());
                  								
                }
                lv_varArgs_9_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }


                }

                // PsiInternalBeeLangTestLanguage.g:4244:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                // PsiInternalBeeLangTestLanguage.g:4245:8: (lv_parameters_10_0= ruleParameterDeclaration )
                {
                // PsiInternalBeeLangTestLanguage.g:4245:8: (lv_parameters_10_0= ruleParameterDeclaration )
                // PsiInternalBeeLangTestLanguage.g:4246:9: lv_parameters_10_0= ruleParameterDeclaration
                {
                if ( state.backtracking==0 ) {

                  									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0ElementType());
                  								
                }
                pushFollow(FollowSets000.FOLLOW_2);
                ruleParameterDeclaration();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred135_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred137_PsiInternalBeeLangTestLanguage
    public final void synpred137_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalBeeLangTestLanguage.g:4314:3: ( ruleBlockExpressionWithoutBrackets )
        // PsiInternalBeeLangTestLanguage.g:4314:3: ruleBlockExpressionWithoutBrackets
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        ruleBlockExpressionWithoutBrackets();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred137_PsiInternalBeeLangTestLanguage

}

@SuppressWarnings("all")
public class PsiInternalBeeLangTestLanguageParser extends PsiInternalBeeLangTestLanguageParser3 {



        public PsiInternalBeeLangTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBeeLangTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[257+1];
             
             
        }
        


    	public PsiInternalBeeLangTestLanguageParser(PsiBuilder builder, TokenStream input, BeeLangTestLanguageElementTypeProvider elementTypeProvider, BeeLangTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}
}
