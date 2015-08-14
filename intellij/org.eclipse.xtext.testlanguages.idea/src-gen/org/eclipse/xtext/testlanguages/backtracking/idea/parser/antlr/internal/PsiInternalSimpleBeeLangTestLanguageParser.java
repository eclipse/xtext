package org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.testlanguages.backtracking.services.SimpleBeeLangTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
interface PsiInternalSimpleBeeLangTestLanguageParserSignatures {
     void entryRuleDelegateModel() throws RecognitionException;
     void ruleDelegateModel() throws RecognitionException;
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
     void synpred2_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred9_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred10_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred11_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred12_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred13_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred14_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred15_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred16_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred17_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred18_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred20_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred21_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred22_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred26_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred27_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred28_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred29_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred30_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred32_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred33_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred34_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred35_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred36_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred42_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred69_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred71_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred85_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred86_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred87_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred89_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred92_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred93_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred99_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred101_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred102_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred103_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred105_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred106_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred108_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred109_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred112_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred113_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred127_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred128_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred135_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred137_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
}

@SuppressWarnings("all")
abstract class PsiInternalSimpleBeeLangTestLanguageParser1 extends AbstractPsiAntlrParser implements PsiInternalSimpleBeeLangTestLanguageParserSignatures {

        PsiInternalSimpleBeeLangTestLanguageParser1(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalSimpleBeeLangTestLanguageParser1(TokenStream input, RecognizerSharedState state) {
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


    public String[] getTokenNames() { return PsiInternalSimpleBeeLangTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSimpleBeeLangTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected SimpleBeeLangTestLanguageGrammarAccess grammarAccess;

    	protected SimpleBeeLangTestLanguageElementTypeProvider elementTypeProvider;



    	@Override
    	protected String getFirstRuleName() {
    		return "DelegateModel";
    	}





    // Delegated rules

    public final boolean synpred11_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
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
            return "()* loopback of 245:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*";
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
        "\1\5\1\uffff\2\5\1\uffff\1\20\2\5\2\20\1\5\1\0\3\5\1\20\1\5\1\67\1\5\1\0\1\5\2\20\1\5\1\45\1\5\1\20\1\5\1\67\2\5\1\20\3\5\1\45\2\5\1\20\1\45\1\0\1\20\2\5\1\45\1\0";
    static final String DFA27_maxS =
        "\1\115\1\uffff\1\114\1\115\1\uffff\1\104\1\114\1\115\2\104\1\114\1\0\1\43\1\115\1\114\1\104\1\5\1\67\1\45\1\0\2\115\1\104\1\44\1\45\1\5\1\45\1\5\1\67\1\115\1\114\1\45\2\5\1\44\1\45\1\5\2\115\1\45\1\0\1\45\2\5\1\45\1\0";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\51\uffff";
    static final String DFA27_specialS =
        "\13\uffff\1\2\7\uffff\1\0\24\uffff\1\3\4\uffff\1\1}>";
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
            "\1\4\12\uffff\1\35\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\36\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\31\1\uffff\7\4\1\uffff\4\4",
            "\1\37\36\uffff\1\40",
            "\1\21",
            "\1\41",
            "\1\42\24\uffff\1\34",
            "\1\43",
            "\1\44",
            "\1\45\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\46\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\27\24\uffff\1\21",
            "\1\47",
            "\1\50",
            "\1\51\36\uffff\1\52",
            "\1\34",
            "\1\53",
            "\1\4\12\uffff\1\35\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\36\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\21",
            "\1\uffff",
            "\1\42\24\uffff\1\34",
            "\1\54",
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
            return "1455:2: ( ruleClosureParameter | ruleParameter )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_19 = input.LA(1);

                         
                        int index27_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_45 = input.LA(1);

                         
                        int index27_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_45);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_40 = input.LA(1);

                         
                        int index27_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_40);
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
            return "1999:2: ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression )";
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
                        if ( (synpred69_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 2;}

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
        "\2\uffff\1\1\1\10\1\7\1\6\1\4\1\2\1\3\1\0\1\5\1\uffff}>";
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
            return "()* loopback of 2690:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_3);
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
            return "3334:2: ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression )";
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
                        if ( (synpred106_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 14;}

                        else if ( (synpred108_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 15;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_4 = input.LA(1);

                         
                        int index73_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 3;}

                        else if ( (synpred112_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 16;}

                         
                        input.seek(index73_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_13 = input.LA(1);

                         
                        int index73_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 17;}

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
            return "3888:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?";
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
                        if ( (synpred127_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 37;}

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
        "\6\uffff\1\4\7\uffff\1\4\2\uffff\1\4\16\uffff\3\4\16\uffff\2\4\7\uffff";
    static final String DFA90_minS =
        "\2\5\3\uffff\2\5\1\20\1\5\1\67\2\5\1\20\1\5\1\20\1\45\1\5\1\20\1\5\1\0\2\5\1\20\3\5\1\20\1\5\1\67\1\5\1\0\1\45\1\20\1\5\1\20\1\5\1\45\1\5\1\20\1\5\1\67\2\5\1\20\3\5\1\45\1\5\1\20\1\5\1\45\1\0\1\20\2\5\1\45\1\0";
    static final String DFA90_maxS =
        "\1\115\1\114\3\uffff\1\114\1\115\1\104\1\5\1\67\1\114\2\115\1\44\1\104\1\45\1\5\1\104\1\114\1\0\1\43\1\5\1\45\1\5\1\114\1\115\1\104\1\5\1\67\1\45\1\0\1\45\2\115\1\104\1\44\1\45\1\5\1\45\1\5\1\67\1\114\1\115\1\45\2\5\1\44\1\45\1\5\2\115\1\45\1\0\1\45\2\5\1\45\1\0";
    static final String DFA90_acceptS =
        "\2\uffff\1\1\1\2\1\3\65\uffff";
    static final String DFA90_specialS =
        "\23\uffff\1\0\12\uffff\1\1\25\uffff\1\3\4\uffff\1\2}>";
    static final String[] DFA90_transitionS = {
            "\1\2\35\uffff\1\2\1\3\50\uffff\1\1",
            "\1\6\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\13\uffff\1\4\1\uffff\1\5\21\uffff\2\4\1\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "",
            "",
            "",
            "\1\7\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\10\1\11\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\14\12\uffff\1\13\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\17\4\1\12\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\15\17\uffff\1\4\2\uffff\1\4\1\uffff\1\16\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\17",
            "\1\20",
            "\1\21\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\23\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\22\1\24\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\2\3\uffff\1\4\21\uffff\1\4\46\uffff\1\2",
            "\1\26\36\uffff\1\25",
            "\1\4\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\20\1\uffff\7\4\1\uffff\4\4",
            "\1\11",
            "\1\27",
            "\1\31\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\30\1\4\4\uffff\7\4\1\uffff\4\4",
            "\1\32\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\33\1\34\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\uffff",
            "\1\36\35\uffff\1\35",
            "\1\37",
            "\1\15\24\uffff\1\11",
            "\1\14",
            "\1\40\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\41\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\43\17\uffff\1\4\2\uffff\1\4\1\uffff\1\42\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\44",
            "\1\45",
            "\1\46\36\uffff\1\47\1\50",
            "\1\uffff",
            "\1\11",
            "\1\13\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\4\12\uffff\1\52\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\51\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\45\1\uffff\7\4\1\uffff\4\4",
            "\1\53\36\uffff\1\54",
            "\1\34",
            "\1\55",
            "\1\56\24\uffff\1\50",
            "\1\57",
            "\1\60",
            "\1\61\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\62\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\43\24\uffff\1\34",
            "\1\63",
            "\1\64",
            "\1\65\36\uffff\1\66",
            "\1\50",
            "\1\67",
            "\1\13\3\uffff\1\4\13\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\4\12\uffff\1\52\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\51\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\34",
            "\1\uffff",
            "\1\56\24\uffff\1\50",
            "\1\70",
            "\1\71",
            "\1\50",
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
            return "4202:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_19 = input.LA(1);

                         
                        int index90_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_30 = input.LA(1);

                         
                        int index90_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_30);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_52 = input.LA(1);

                         
                        int index90_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_52);
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
            return "4333:2: ( ruleBlockExpressionWithoutBrackets | ruleExpression )";
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
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_4 = input.LA(1);

                         
                        int index91_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_7 = input.LA(1);

                         
                        int index91_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_8 = input.LA(1);

                         
                        int index91_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA91_17 = input.LA(1);

                         
                        int index91_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_17);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA91_18 = input.LA(1);

                         
                        int index91_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_18);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA91_19 = input.LA(1);

                         
                        int index91_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA91_20 = input.LA(1);

                         
                        int index91_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA91_21 = input.LA(1);

                         
                        int index91_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalSimpleBeeLangTestLanguage()) ) {s = 1;}

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
abstract class PsiInternalSimpleBeeLangTestLanguageParser2 extends PsiInternalSimpleBeeLangTestLanguageParser1 {

        PsiInternalSimpleBeeLangTestLanguageParser2(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalSimpleBeeLangTestLanguageParser2(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleDelegateModel"
    // PsiInternalSimpleBeeLangTestLanguage.g:60:1: entryRuleDelegateModel : ruleDelegateModel EOF ;
    public final void entryRuleDelegateModel() throws RecognitionException {
        int entryRuleDelegateModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:60:23: ( ruleDelegateModel EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:61:2: ruleDelegateModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDelegateModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDelegateModel();

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
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleDelegateModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // PsiInternalSimpleBeeLangTestLanguage.g:66:1: ruleDelegateModel : ruleModel ;
    public final void ruleDelegateModel() throws RecognitionException {
        int ruleDelegateModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:66:18: ( ruleModel )
            // PsiInternalSimpleBeeLangTestLanguage.g:67:2: ruleModel
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getDelegateModel_ModelParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleModel();

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
            if ( state.backtracking>0 ) { memoize(input, 2, ruleDelegateModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // PsiInternalSimpleBeeLangTestLanguage.g:80:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        int entryRuleModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:80:15: ( ruleModel EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:81:2: ruleModel EOF
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
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalSimpleBeeLangTestLanguage.g:86:1: ruleModel : ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final void ruleModel() throws RecognitionException {
        int ruleModel_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:86:10: ( ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:87:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:87:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
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

                if ( (synpred2_PsiInternalSimpleBeeLangTestLanguage()) ) {
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:88:3: ( (lv_units_0_0= ruleUnit ) )*
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:88:3: ( (lv_units_0_0= ruleUnit ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_DOCUMENTATION||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:89:4: (lv_units_0_0= ruleUnit )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:89:4: (lv_units_0_0= ruleUnit )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:90:5: lv_units_0_0= ruleUnit
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:100:3: ( (lv_functions_1_0= ruleFunction ) )*
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:100:3: ( (lv_functions_1_0= ruleFunction ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=RULE_DOCUMENTATION && LA2_0<=RULE_ID)||(LA2_0>=33 && LA2_0<=34)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:101:4: (lv_functions_1_0= ruleFunction )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:101:4: (lv_functions_1_0= ruleFunction )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:102:5: lv_functions_1_0= ruleFunction
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
            if ( state.backtracking>0 ) { memoize(input, 4, ruleModel_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnit"
    // PsiInternalSimpleBeeLangTestLanguage.g:115:1: entryRuleUnit : ruleUnit EOF ;
    public final void entryRuleUnit() throws RecognitionException {
        int entryRuleUnit_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:119:2: ( ruleUnit EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:120:2: ruleUnit EOF
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
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // PsiInternalSimpleBeeLangTestLanguage.g:128:1: ruleUnit : ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:132:2: ( ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:133:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:133:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            // PsiInternalSimpleBeeLangTestLanguage.g:134:3: () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}'
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:134:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:135:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnit_UnitAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:143:3: ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOCUMENTATION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:144:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:144:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    // PsiInternalSimpleBeeLangTestLanguage.g:145:5: lv_documentation_1_0= RULE_DOCUMENTATION
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
            // PsiInternalSimpleBeeLangTestLanguage.g:161:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:162:4: (lv_name_3_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:162:4: (lv_name_3_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:163:5: lv_name_3_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:172:3: (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:173:4: otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_VersionKeyword_4_0ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:180:4: ( (lv_version_5_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:181:5: (lv_version_5_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:181:5: (lv_version_5_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:182:6: lv_version_5_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:192:3: (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:193:4: otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_ImplementsKeyword_5_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:200:4: ( (lv_implements_7_0= ruleSimpleTypeRef ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:201:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:201:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    // PsiInternalSimpleBeeLangTestLanguage.g:202:6: lv_implements_7_0= ruleSimpleTypeRef
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:211:4: (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:212:5: otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getUnit_CommaKeyword_5_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_8);
                    	      				
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:219:5: ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:220:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:220:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:221:7: lv_implements_9_0= ruleSimpleTypeRef
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
            // PsiInternalSimpleBeeLangTestLanguage.g:239:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:240:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:240:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:241:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getUnitAccess().getUnorderedGroup_7());
            // PsiInternalSimpleBeeLangTestLanguage.g:244:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:245:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:245:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=7;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:246:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:246:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:247:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:247:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:248:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:251:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:251:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:251:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:251:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:265:9: ( (lv_sourceLocation_14_0= rulePath ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:266:10: (lv_sourceLocation_14_0= rulePath )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:266:10: (lv_sourceLocation_14_0= rulePath )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:267:11: lv_sourceLocation_14_0= rulePath
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:289:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:289:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:290:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:290:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:291:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:294:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:294:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:294:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:294:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:308:9: ( (lv_outputLocation_18_0= rulePath ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:309:10: (lv_outputLocation_18_0= rulePath )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:309:10: (lv_outputLocation_18_0= rulePath )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:310:11: lv_outputLocation_18_0= rulePath
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:333:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:333:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:334:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:337:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==22) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((synpred11_PsiInternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:337:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:337:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:337:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
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
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:351:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:352:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    {
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:352:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:353:11: lv_providedCapabilities_22_0= ruleProvidedCapability
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:375:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:375:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:376:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:376:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:377:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:380:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==23) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((synpred13_PsiInternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:380:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:380:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:380:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
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
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:394:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:395:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    {
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:395:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:396:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:418:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:418:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:419:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:419:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:420:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:423:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==23) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((synpred15_PsiInternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:423:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:423:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:423:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
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
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:444:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:445:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    {
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:445:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:446:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:468:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:468:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:469:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:469:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:470:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:473:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        switch ( input.LA(1) ) {
            	        case RULE_DOCUMENTATION:
            	            {
            	            int LA12_2 = input.LA(2);

            	            if ( ((synpred17_PsiInternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA12_3 = input.LA(2);

            	            if ( ((synpred17_PsiInternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 33:
            	            {
            	            int LA12_4 = input.LA(2);

            	            if ( ((synpred17_PsiInternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 34:
            	            {
            	            int LA12_5 = input.LA(2);

            	            if ( ((synpred17_PsiInternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt12) {
            	    	case 1 :
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:473:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return ;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:473:19: ( (lv_functions_33_0= ruleFunction ) )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:473:20: (lv_functions_33_0= ruleFunction )
            	    	    {
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:473:20: (lv_functions_33_0= ruleFunction )
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:474:10: lv_functions_33_0= ruleFunction
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
            if ( state.backtracking>0 ) { memoize(input, 6, ruleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleProvidedCapability"
    // PsiInternalSimpleBeeLangTestLanguage.g:509:1: entryRuleProvidedCapability : ruleProvidedCapability EOF ;
    public final void entryRuleProvidedCapability() throws RecognitionException {
        int entryRuleProvidedCapability_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:513:2: ( ruleProvidedCapability EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:514:2: ruleProvidedCapability EOF
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
            if ( state.backtracking>0 ) { memoize(input, 7, entryRuleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleProvidedCapability"


    // $ANTLR start "ruleProvidedCapability"
    // PsiInternalSimpleBeeLangTestLanguage.g:522:1: ruleProvidedCapability : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:526:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:527:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:527:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            // PsiInternalSimpleBeeLangTestLanguage.g:528:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:528:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:529:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getProvidedCapability_ProvidedCapabilityAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:537:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:538:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:538:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:539:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:539:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:540:6: lv_nameSpace_1_0= RULE_ID
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:550:4: otherlv_2= 'unit'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:558:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:559:4: otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_LeftCurlyBracketKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_18); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:566:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:567:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:567:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:568:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());
                    // PsiInternalSimpleBeeLangTestLanguage.g:571:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    // PsiInternalSimpleBeeLangTestLanguage.g:572:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:572:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:573:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:573:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:574:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:574:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:575:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:578:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:578:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:578:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:578:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:592:10: ( (lv_condExpr_7_0= ruleExpression ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:593:11: (lv_condExpr_7_0= ruleExpression )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:593:11: (lv_condExpr_7_0= ruleExpression )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:594:12: lv_condExpr_7_0= ruleExpression
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:616:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:616:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:617:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:617:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:618:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:621:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:621:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:621:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:621:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:635:10: ( (lv_name_11_0= RULE_ID ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:636:11: (lv_name_11_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:636:11: (lv_name_11_0= RULE_ID )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:637:12: lv_name_11_0= RULE_ID
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:659:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:659:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:660:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:660:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:661:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:664:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:664:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:664:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:664:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:678:10: ( (lv_version_15_0= RULE_ID ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:679:11: (lv_version_15_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:679:11: (lv_version_15_0= RULE_ID )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:680:12: lv_version_15_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 8, ruleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleProvidedCapability"


    // $ANTLR start "entryRuleAliasedRequiredCapability"
    // PsiInternalSimpleBeeLangTestLanguage.g:725:1: entryRuleAliasedRequiredCapability : ruleAliasedRequiredCapability EOF ;
    public final void entryRuleAliasedRequiredCapability() throws RecognitionException {
        int entryRuleAliasedRequiredCapability_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:729:2: ( ruleAliasedRequiredCapability EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:730:2: ruleAliasedRequiredCapability EOF
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
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleAliasedRequiredCapability"


    // $ANTLR start "ruleAliasedRequiredCapability"
    // PsiInternalSimpleBeeLangTestLanguage.g:738:1: ruleAliasedRequiredCapability : ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:742:2: ( ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:743:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:743:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:744:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:744:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:745:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:745:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:746:5: (lv_nameSpace_0_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:746:5: (lv_nameSpace_0_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:747:6: lv_nameSpace_0_0= RULE_ID
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:757:4: otherlv_1= 'unit'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:765:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:766:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:766:4: (lv_name_2_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:767:5: lv_name_2_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:776:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:777:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAliasedRequiredCapability_AsKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:784:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:785:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:785:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:786:6: lv_alias_4_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:796:3: (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            // PsiInternalSimpleBeeLangTestLanguage.g:797:4: otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getAliasedRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_5);
              			
            }
            // PsiInternalSimpleBeeLangTestLanguage.g:804:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:805:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:805:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:806:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalSimpleBeeLangTestLanguage.g:809:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:810:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:810:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:811:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:811:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:812:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:812:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:813:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:816:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:816:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:816:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:816:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:830:10: ( (lv_condExpr_9_0= ruleExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:831:11: (lv_condExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:831:11: (lv_condExpr_9_0= ruleExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:832:12: lv_condExpr_9_0= ruleExpression
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:854:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:854:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:855:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:855:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:856:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:859:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:859:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:859:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:859:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:859:21: ( (lv_greedy_11_0= 'greedy' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:860:11: (lv_greedy_11_0= 'greedy' )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:860:11: (lv_greedy_11_0= 'greedy' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:861:12: lv_greedy_11_0= 'greedy'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:883:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:883:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:884:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:884:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:885:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:888:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:888:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:888:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:888:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:902:10: ( (lv_min_15_0= RULE_INT ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:903:11: (lv_min_15_0= RULE_INT )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:903:11: (lv_min_15_0= RULE_INT )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:904:12: lv_min_15_0= RULE_INT
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:926:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:926:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:927:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:927:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:928:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:931:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:931:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:931:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:931:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:945:10: ( (lv_max_19_0= RULE_INT ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:946:11: (lv_max_19_0= RULE_INT )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:946:11: (lv_max_19_0= RULE_INT )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:947:12: lv_max_19_0= RULE_INT
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:970:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:970:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:971:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:974:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:974:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:974:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:974:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:988:10: ( (lv_versionRange_23_0= RULE_ID ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:989:11: (lv_versionRange_23_0= RULE_ID )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:989:11: (lv_versionRange_23_0= RULE_ID )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:990:12: lv_versionRange_23_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 10, ruleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleAliasedRequiredCapability"


    // $ANTLR start "entryRuleRequiredCapability"
    // PsiInternalSimpleBeeLangTestLanguage.g:1034:1: entryRuleRequiredCapability : ruleRequiredCapability EOF ;
    public final void entryRuleRequiredCapability() throws RecognitionException {
        int entryRuleRequiredCapability_StartIndex = input.index();

        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1038:2: ( ruleRequiredCapability EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1039:2: ruleRequiredCapability EOF
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
            if ( state.backtracking>0 ) { memoize(input, 11, entryRuleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleRequiredCapability"


    // $ANTLR start "ruleRequiredCapability"
    // PsiInternalSimpleBeeLangTestLanguage.g:1047:1: ruleRequiredCapability : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1051:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1052:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1052:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1053:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1053:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:1054:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getRequiredCapability_RequiredCapabilityAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:1062:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1063:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1063:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1064:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1064:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1065:6: lv_nameSpace_1_0= RULE_ID
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1075:4: otherlv_2= 'unit'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1083:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1084:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1084:4: (lv_name_3_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:1085:5: lv_name_3_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1094:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            // PsiInternalSimpleBeeLangTestLanguage.g:1095:4: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_4);
              			
            }
            // PsiInternalSimpleBeeLangTestLanguage.g:1102:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1103:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1103:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1104:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalSimpleBeeLangTestLanguage.g:1107:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:1108:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1108:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1109:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1109:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1110:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1110:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1111:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1114:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1114:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1114:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1114:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1128:10: ( (lv_condExpr_8_0= ruleExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1129:11: (lv_condExpr_8_0= ruleExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1129:11: (lv_condExpr_8_0= ruleExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1130:12: lv_condExpr_8_0= ruleExpression
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1152:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1152:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1153:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1153:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1154:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1157:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1157:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1157:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1157:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1157:21: ( (lv_greedy_10_0= 'greedy' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1158:11: (lv_greedy_10_0= 'greedy' )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1158:11: (lv_greedy_10_0= 'greedy' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1159:12: lv_greedy_10_0= 'greedy'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1181:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1181:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1182:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1182:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1183:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1186:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1186:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1186:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1186:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1200:10: ( (lv_min_14_0= RULE_INT ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1201:11: (lv_min_14_0= RULE_INT )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1201:11: (lv_min_14_0= RULE_INT )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1202:12: lv_min_14_0= RULE_INT
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1224:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1224:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1225:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1225:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1226:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1229:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1229:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1229:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1229:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1243:10: ( (lv_max_18_0= RULE_INT ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1244:11: (lv_max_18_0= RULE_INT )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1244:11: (lv_max_18_0= RULE_INT )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1245:12: lv_max_18_0= RULE_INT
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1267:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1267:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1268:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1268:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1269:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1272:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1272:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1272:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1272:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1286:10: ( (lv_versionRange_22_0= RULE_ID ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1287:11: (lv_versionRange_22_0= RULE_ID )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1287:11: (lv_versionRange_22_0= RULE_ID )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1288:12: lv_versionRange_22_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 12, ruleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleRequiredCapability"


    // $ANTLR start "entryRulePath"
    // PsiInternalSimpleBeeLangTestLanguage.g:1332:1: entryRulePath : rulePath EOF ;
    public final void entryRulePath() throws RecognitionException {
        int entryRulePath_StartIndex = input.index();

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1334:2: ( rulePath EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1335:2: rulePath EOF
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
            if ( state.backtracking>0 ) { memoize(input, 13, entryRulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // PsiInternalSimpleBeeLangTestLanguage.g:1343:1: rulePath : (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) ;
    public final void rulePath() throws RecognitionException {
        int rulePath_StartIndex = input.index();
        Token this_STRING_0=null;
        Token kw=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1345:2: ( (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1346:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1346:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1347:3: this_STRING_0= RULE_STRING
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1355:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1355:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1356:4: (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )?
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1356:4: (kw= '/' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==32) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // PsiInternalSimpleBeeLangTestLanguage.g:1357:5: kw= '/'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1372:4: (kw= '/' ruleQID )*
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:1373:5: kw= '/' ruleQID
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:1388:4: (kw= '/' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==32) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // PsiInternalSimpleBeeLangTestLanguage.g:1389:5: kw= '/'
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
            if ( state.backtracking>0 ) { memoize(input, 14, rulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleParameterList"
    // PsiInternalSimpleBeeLangTestLanguage.g:1405:1: entryRuleParameterList : ruleParameterList EOF ;
    public final void entryRuleParameterList() throws RecognitionException {
        int entryRuleParameterList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1405:23: ( ruleParameterList EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1406:2: ruleParameterList EOF
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
            if ( state.backtracking>0 ) { memoize(input, 15, entryRuleParameterList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // PsiInternalSimpleBeeLangTestLanguage.g:1411:1: ruleParameterList : ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) ;
    public final void ruleParameterList() throws RecognitionException {
        int ruleParameterList_StartIndex = input.index();
        Token otherlv_1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1411:18: ( ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1412:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1412:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:1413:3: ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1413:3: ( (lv_parameters_0_0= ruleFirstParameter ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1414:4: (lv_parameters_0_0= ruleFirstParameter )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1414:4: (lv_parameters_0_0= ruleFirstParameter )
            // PsiInternalSimpleBeeLangTestLanguage.g:1415:5: lv_parameters_0_0= ruleFirstParameter
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1424:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1425:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getParameterList_CommaKeyword_1_0ElementType());
            	      			
            	    }
            	    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_27); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_1);
            	      			
            	    }
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1432:4: ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1433:5: (lv_parameters_2_0= ruleFirstParameter )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1433:5: (lv_parameters_2_0= ruleFirstParameter )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:1434:6: lv_parameters_2_0= ruleFirstParameter
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
            if ( state.backtracking>0 ) { memoize(input, 16, ruleParameterList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleFirstParameter"
    // PsiInternalSimpleBeeLangTestLanguage.g:1448:1: entryRuleFirstParameter : ruleFirstParameter EOF ;
    public final void entryRuleFirstParameter() throws RecognitionException {
        int entryRuleFirstParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1448:24: ( ruleFirstParameter EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1449:2: ruleFirstParameter EOF
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
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleFirstParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFirstParameter"


    // $ANTLR start "ruleFirstParameter"
    // PsiInternalSimpleBeeLangTestLanguage.g:1454:1: ruleFirstParameter : ( ruleClosureParameter | ruleParameter ) ;
    public final void ruleFirstParameter() throws RecognitionException {
        int ruleFirstParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1454:19: ( ( ruleClosureParameter | ruleParameter ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1455:2: ( ruleClosureParameter | ruleParameter )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1455:2: ( ruleClosureParameter | ruleParameter )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:1456:3: ruleClosureParameter
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1467:3: ruleParameter
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
            if ( state.backtracking>0 ) { memoize(input, 18, ruleFirstParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFirstParameter"


    // $ANTLR start "entryRuleParameter"
    // PsiInternalSimpleBeeLangTestLanguage.g:1481:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        int entryRuleParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1481:19: ( ruleParameter EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1482:2: ruleParameter EOF
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
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // PsiInternalSimpleBeeLangTestLanguage.g:1487:1: ruleParameter : ( (lv_expr_0_0= ruleExpression ) ) ;
    public final void ruleParameter() throws RecognitionException {
        int ruleParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1487:14: ( ( (lv_expr_0_0= ruleExpression ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1488:2: ( (lv_expr_0_0= ruleExpression ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1488:2: ( (lv_expr_0_0= ruleExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1489:3: (lv_expr_0_0= ruleExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1489:3: (lv_expr_0_0= ruleExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:1490:4: lv_expr_0_0= ruleExpression
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
            if ( state.backtracking>0 ) { memoize(input, 20, ruleParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleClosureParameter"
    // PsiInternalSimpleBeeLangTestLanguage.g:1502:1: entryRuleClosureParameter : ruleClosureParameter EOF ;
    public final void entryRuleClosureParameter() throws RecognitionException {
        int entryRuleClosureParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1502:26: ( ruleClosureParameter EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1503:2: ruleClosureParameter EOF
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
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleClosureParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleClosureParameter"


    // $ANTLR start "ruleClosureParameter"
    // PsiInternalSimpleBeeLangTestLanguage.g:1508:1: ruleClosureParameter : ( (lv_expr_0_0= ruleClosureExpression ) ) ;
    public final void ruleClosureParameter() throws RecognitionException {
        int ruleClosureParameter_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1508:21: ( ( (lv_expr_0_0= ruleClosureExpression ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1509:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1509:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1510:3: (lv_expr_0_0= ruleClosureExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1510:3: (lv_expr_0_0= ruleClosureExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:1511:4: lv_expr_0_0= ruleClosureExpression
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
            if ( state.backtracking>0 ) { memoize(input, 22, ruleClosureParameter_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleClosureParameter"


    // $ANTLR start "entryRuleParameterDeclaration"
    // PsiInternalSimpleBeeLangTestLanguage.g:1523:1: entryRuleParameterDeclaration : ruleParameterDeclaration EOF ;
    public final void entryRuleParameterDeclaration() throws RecognitionException {
        int entryRuleParameterDeclaration_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1523:30: ( ruleParameterDeclaration EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1524:2: ruleParameterDeclaration EOF
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
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleParameterDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // PsiInternalSimpleBeeLangTestLanguage.g:1529:1: ruleParameterDeclaration : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleParameterDeclaration() throws RecognitionException {
        int ruleParameterDeclaration_StartIndex = input.index();
        Token lv_name_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1529:25: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1530:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1530:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1531:3: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1531:3: ( (lv_type_0_0= ruleTypeRef ) )?
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1532:4: (lv_type_0_0= ruleTypeRef )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1532:4: (lv_type_0_0= ruleTypeRef )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1533:5: lv_type_0_0= ruleTypeRef
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1542:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1543:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1543:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:1544:5: lv_name_1_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 24, ruleParameterDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleFunction"
    // PsiInternalSimpleBeeLangTestLanguage.g:1557:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        int entryRuleFunction_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1557:18: ( ruleFunction EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1558:2: ruleFunction EOF
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
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // PsiInternalSimpleBeeLangTestLanguage.g:1563:1: ruleFunction : ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1563:13: ( ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1564:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1564:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1565:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1565:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_DOCUMENTATION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:1566:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1566:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1567:5: lv_documentation_0_0= RULE_DOCUMENTATION
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1576:3: ( (lv_visibility_1_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:1577:4: (lv_visibility_1_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1577:4: (lv_visibility_1_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1578:5: lv_visibility_1_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1587:3: ( (lv_final_2_0= 'final' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:1588:4: (lv_final_2_0= 'final' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1588:4: (lv_final_2_0= 'final' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1589:5: lv_final_2_0= 'final'
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
            // PsiInternalSimpleBeeLangTestLanguage.g:1605:3: ( (lv_returnType_4_0= ruleTypeRef ) )?
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1606:4: (lv_returnType_4_0= ruleTypeRef )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1606:4: (lv_returnType_4_0= ruleTypeRef )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1607:5: lv_returnType_4_0= ruleTypeRef
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1616:3: ( (lv_name_5_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1617:4: (lv_name_5_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1617:4: (lv_name_5_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:1618:5: lv_name_5_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1627:3: (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:1628:4: otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_LeftParenthesisKeyword_6_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,35,FollowSets000.FOLLOW_33); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:1635:4: ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )?
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
                            // PsiInternalSimpleBeeLangTestLanguage.g:1636:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:1636:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1637:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:1637:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1638:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:1638:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1639:8: lv_parameters_7_0= ruleParameterDeclaration
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

                            // PsiInternalSimpleBeeLangTestLanguage.g:1648:6: (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )*
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
                            	    // PsiInternalSimpleBeeLangTestLanguage.g:1649:7: otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_8);
                            	      						
                            	    }
                            	    // PsiInternalSimpleBeeLangTestLanguage.g:1656:7: ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    // PsiInternalSimpleBeeLangTestLanguage.g:1657:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    {
                            	    // PsiInternalSimpleBeeLangTestLanguage.g:1657:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    // PsiInternalSimpleBeeLangTestLanguage.g:1658:9: lv_parameters_9_0= ruleParameterDeclaration
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

                            // PsiInternalSimpleBeeLangTestLanguage.g:1668:6: (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==16) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1669:7: otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    {
                                    if ( state.backtracking==0 ) {

                                      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_2_0ElementType());
                                      						
                                    }
                                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                                    if ( state.backtracking==0 ) {

                                      							doneLeaf(otherlv_10);
                                      						
                                    }
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1676:7: ( (lv_varArgs_11_0= '...' ) )
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1677:8: (lv_varArgs_11_0= '...' )
                                    {
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1677:8: (lv_varArgs_11_0= '...' )
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1678:9: lv_varArgs_11_0= '...'
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

                                    // PsiInternalSimpleBeeLangTestLanguage.g:1687:7: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1688:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    {
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1688:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    // PsiInternalSimpleBeeLangTestLanguage.g:1689:9: lv_parameters_12_0= ruleParameterDeclaration
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
                            // PsiInternalSimpleBeeLangTestLanguage.g:1701:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:1701:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1702:6: ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:1702:6: ( (lv_varArgs_13_0= '...' ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1703:7: (lv_varArgs_13_0= '...' )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:1703:7: (lv_varArgs_13_0= '...' )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1704:8: lv_varArgs_13_0= '...'
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

                            // PsiInternalSimpleBeeLangTestLanguage.g:1713:6: ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1714:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:1714:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            // PsiInternalSimpleBeeLangTestLanguage.g:1715:8: lv_parameters_14_0= ruleParameterDeclaration
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1734:3: (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:1735:4: otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_WhenKeyword_7_0ElementType());
                      			
                    }
                    otherlv_16=(Token)match(input,26,FollowSets000.FOLLOW_39); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_16);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:1742:4: ( (lv_guard_17_0= ruleGuardExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1743:5: (lv_guard_17_0= ruleGuardExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1743:5: (lv_guard_17_0= ruleGuardExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1744:6: lv_guard_17_0= ruleGuardExpression
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

            // PsiInternalSimpleBeeLangTestLanguage.g:1754:3: ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1755:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1755:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1756:5: otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_ColonKeyword_8_0_0ElementType());
                      				
                    }
                    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_18);
                      				
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:1763:5: ( (lv_funcExpr_19_0= ruleExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1764:6: (lv_funcExpr_19_0= ruleExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1764:6: (lv_funcExpr_19_0= ruleExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1765:7: lv_funcExpr_19_0= ruleExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1783:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1783:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1784:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1784:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1785:6: lv_funcExpr_21_0= ruleBlockExpression
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
            if ( state.backtracking>0 ) { memoize(input, 26, ruleFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGuardExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:1799:1: entryRuleGuardExpression : ruleGuardExpression EOF ;
    public final void entryRuleGuardExpression() throws RecognitionException {
        int entryRuleGuardExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1799:25: ( ruleGuardExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1800:2: ruleGuardExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleGuardExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleGuardExpression"


    // $ANTLR start "ruleGuardExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:1805:1: ruleGuardExpression : ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) ;
    public final void ruleGuardExpression() throws RecognitionException {
        int ruleGuardExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1805:20: ( ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1806:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1806:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1807:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1807:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1808:4: otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getGuardExpression_ColonKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:1815:4: ( (lv_guardExpr_1_0= ruleExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1816:5: (lv_guardExpr_1_0= ruleExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1816:5: (lv_guardExpr_1_0= ruleExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1817:6: lv_guardExpr_1_0= ruleExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1835:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1835:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1836:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:1836:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:1837:5: lv_guardExpr_3_0= ruleBlockExpression
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
            if ( state.backtracking>0 ) { memoize(input, 28, ruleGuardExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleGuardExpression"


    // $ANTLR start "entryRuleAssignmentOperator"
    // PsiInternalSimpleBeeLangTestLanguage.g:1850:1: entryRuleAssignmentOperator : ruleAssignmentOperator EOF ;
    public final void entryRuleAssignmentOperator() throws RecognitionException {
        int entryRuleAssignmentOperator_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1850:28: ( ruleAssignmentOperator EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1851:2: ruleAssignmentOperator EOF
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
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleAssignmentOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // PsiInternalSimpleBeeLangTestLanguage.g:1856:1: ruleAssignmentOperator : (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) ;
    public final void ruleAssignmentOperator() throws RecognitionException {
        int ruleAssignmentOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1856:23: ( (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1857:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1857:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1858:3: kw= '='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1866:3: kw= '+='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1874:3: kw= '-='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1882:3: kw= '*='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1890:3: kw= '/='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1898:3: kw= '%='
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
            if ( state.backtracking>0 ) { memoize(input, 30, ruleAssignmentOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // PsiInternalSimpleBeeLangTestLanguage.g:1909:1: entryRuleRelationalOperator : ruleRelationalOperator EOF ;
    public final void entryRuleRelationalOperator() throws RecognitionException {
        int entryRuleRelationalOperator_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1909:28: ( ruleRelationalOperator EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1910:2: ruleRelationalOperator EOF
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
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleRelationalOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // PsiInternalSimpleBeeLangTestLanguage.g:1915:1: ruleRelationalOperator : (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final void ruleRelationalOperator() throws RecognitionException {
        int ruleRelationalOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1915:23: ( (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1916:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1916:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1917:3: kw= '~='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1925:3: kw= '=='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1933:3: kw= '==='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1941:3: kw= '!='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1949:3: kw= '!=='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1957:3: kw= '>='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1965:3: kw= '<='
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1973:3: kw= '>'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:1981:3: kw= '<'
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
            if ( state.backtracking>0 ) { memoize(input, 32, ruleRelationalOperator_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleTopLevelExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:1992:1: entryRuleTopLevelExpression : ruleTopLevelExpression EOF ;
    public final void entryRuleTopLevelExpression() throws RecognitionException {
        int entryRuleTopLevelExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1992:28: ( ruleTopLevelExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:1993:2: ruleTopLevelExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleTopLevelExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleTopLevelExpression"


    // $ANTLR start "ruleTopLevelExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:1998:1: ruleTopLevelExpression : ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression ) ;
    public final void ruleTopLevelExpression() throws RecognitionException {
        int ruleTopLevelExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:1998:23: ( ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:1999:2: ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:1999:2: ( ruleVarDeclaration | ruleValDeclaration | ruleAssignmentExpression )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:2000:3: ruleVarDeclaration
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2011:3: ruleValDeclaration
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2022:3: ruleAssignmentExpression
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
            if ( state.backtracking>0 ) { memoize(input, 34, ruleTopLevelExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleTopLevelExpression"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2036:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        int entryRuleExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2036:20: ( ruleExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2037:2: ruleExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2042:1: ruleExpression : ruleAssignmentExpression ;
    public final void ruleExpression() throws RecognitionException {
        int ruleExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2042:15: ( ruleAssignmentExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:2043:2: ruleAssignmentExpression
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
            if ( state.backtracking>0 ) { memoize(input, 36, ruleExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2056:1: entryRuleAssignmentExpression : ruleAssignmentExpression EOF ;
    public final void entryRuleAssignmentExpression() throws RecognitionException {
        int entryRuleAssignmentExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2056:30: ( ruleAssignmentExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2057:2: ruleAssignmentExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleAssignmentExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2062:1: ruleAssignmentExpression : ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final void ruleAssignmentExpression() throws RecognitionException {
        int ruleAssignmentExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2062:25: ( ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2063:2: ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2063:2: ( ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            // PsiInternalSimpleBeeLangTestLanguage.g:2064:3: ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2074:3: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            int alt43=2;
            switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA43_1 = input.LA(2);

                    if ( (synpred71_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 39:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred71_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred71_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred71_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA43_5 = input.LA(2);

                    if ( (synpred71_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA43_6 = input.LA(2);

                    if ( (synpred71_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
            }

            switch (alt43) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:2075:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2075:4: ()
                    // PsiInternalSimpleBeeLangTestLanguage.g:2076:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getAssignmentExpression_AssignmentExpressionLeftExprAction_1_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalSimpleBeeLangTestLanguage.g:2084:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2085:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2085:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2086:6: lv_functionName_2_0= ruleAssignmentOperator
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:2095:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2096:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2096:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2097:6: lv_rightExpr_3_0= ruleAssignmentExpression
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
            if ( state.backtracking>0 ) { memoize(input, 38, ruleAssignmentExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleVarDeclaration"
    // PsiInternalSimpleBeeLangTestLanguage.g:2111:1: entryRuleVarDeclaration : ruleVarDeclaration EOF ;
    public final void entryRuleVarDeclaration() throws RecognitionException {
        int entryRuleVarDeclaration_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2111:24: ( ruleVarDeclaration EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2112:2: ruleVarDeclaration EOF
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
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleVarDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // PsiInternalSimpleBeeLangTestLanguage.g:2117:1: ruleVarDeclaration : ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) ;
    public final void ruleVarDeclaration() throws RecognitionException {
        int ruleVarDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2117:19: ( ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2118:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2118:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            // PsiInternalSimpleBeeLangTestLanguage.g:2119:3: () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2119:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:2120:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getVarDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:2128:3: ( (lv_final_1_0= 'final' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==33) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:2129:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2129:4: (lv_final_1_0= 'final' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2130:5: lv_final_1_0= 'final'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:2139:3: ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2140:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2140:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2141:5: otherlv_2= 'var'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2149:5: ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2149:5: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2150:6: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2150:6: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2151:7: lv_type_3_0= ruleTypeRef
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

            // PsiInternalSimpleBeeLangTestLanguage.g:2161:4: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2162:5: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2162:5: (lv_name_4_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:2163:6: lv_name_4_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:2173:3: (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:2174:4: otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getVarDeclaration_EqualsSignKeyword_3_0ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:2181:4: ( (lv_valueExpr_6_0= ruleExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2182:5: (lv_valueExpr_6_0= ruleExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2182:5: (lv_valueExpr_6_0= ruleExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2183:6: lv_valueExpr_6_0= ruleExpression
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
            if ( state.backtracking>0 ) { memoize(input, 40, ruleVarDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleValDeclaration"
    // PsiInternalSimpleBeeLangTestLanguage.g:2197:1: entryRuleValDeclaration : ruleValDeclaration EOF ;
    public final void entryRuleValDeclaration() throws RecognitionException {
        int entryRuleValDeclaration_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2197:24: ( ruleValDeclaration EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2198:2: ruleValDeclaration EOF
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
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleValDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleValDeclaration"


    // $ANTLR start "ruleValDeclaration"
    // PsiInternalSimpleBeeLangTestLanguage.g:2203:1: ruleValDeclaration : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) ;
    public final void ruleValDeclaration() throws RecognitionException {
        int ruleValDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token lv_immutable_2_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2203:19: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2204:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2204:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2205:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2205:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:2206:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:2214:3: ( (lv_final_1_0= 'final' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==33) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:2215:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2215:4: (lv_final_1_0= 'final' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2216:5: lv_final_1_0= 'final'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:2225:3: ( (lv_immutable_2_0= 'val' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2226:4: (lv_immutable_2_0= 'val' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2226:4: (lv_immutable_2_0= 'val' )
            // PsiInternalSimpleBeeLangTestLanguage.g:2227:5: lv_immutable_2_0= 'val'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:2236:3: ( (lv_type_3_0= ruleTypeRef ) )?
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2237:4: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2237:4: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2238:5: lv_type_3_0= ruleTypeRef
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

            // PsiInternalSimpleBeeLangTestLanguage.g:2247:3: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2248:4: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2248:4: (lv_name_4_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:2249:5: lv_name_4_0= RULE_ID
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2265:3: ( (lv_valueExpr_6_0= ruleExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2266:4: (lv_valueExpr_6_0= ruleExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2266:4: (lv_valueExpr_6_0= ruleExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:2267:5: lv_valueExpr_6_0= ruleExpression
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
            if ( state.backtracking>0 ) { memoize(input, 42, ruleValDeclaration_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleValDeclaration"


    // $ANTLR start "entryRuleTypeRef"
    // PsiInternalSimpleBeeLangTestLanguage.g:2280:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        int entryRuleTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2280:17: ( ruleTypeRef EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2281:2: ruleTypeRef EOF
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
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // PsiInternalSimpleBeeLangTestLanguage.g:2286:1: ruleTypeRef : ( ruleClosureTypeRef | ruleSimpleTypeRef ) ;
    public final void ruleTypeRef() throws RecognitionException {
        int ruleTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2286:12: ( ( ruleClosureTypeRef | ruleSimpleTypeRef ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2287:2: ( ruleClosureTypeRef | ruleSimpleTypeRef )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2287:2: ( ruleClosureTypeRef | ruleSimpleTypeRef )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2288:3: ruleClosureTypeRef
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2299:3: ruleSimpleTypeRef
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
            if ( state.backtracking>0 ) { memoize(input, 44, ruleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleSimpleTypeRef"
    // PsiInternalSimpleBeeLangTestLanguage.g:2313:1: entryRuleSimpleTypeRef : ruleSimpleTypeRef EOF ;
    public final void entryRuleSimpleTypeRef() throws RecognitionException {
        int entryRuleSimpleTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2313:23: ( ruleSimpleTypeRef EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2314:2: ruleSimpleTypeRef EOF
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
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleSimpleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleTypeRef"


    // $ANTLR start "ruleSimpleTypeRef"
    // PsiInternalSimpleBeeLangTestLanguage.g:2319:1: ruleSimpleTypeRef : ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) ;
    public final void ruleSimpleTypeRef() throws RecognitionException {
        int ruleSimpleTypeRef_StartIndex = input.index();
        Token lv_rawType_0_0=null;
        Token otherlv_1=null;
        Token lv_actualArgumentsList_2_0=null;
        Token otherlv_3=null;
        Token lv_actualArgumentsList_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2319:18: ( ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2320:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2320:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            // PsiInternalSimpleBeeLangTestLanguage.g:2321:3: ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2321:3: ( (lv_rawType_0_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2322:4: (lv_rawType_0_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2322:4: (lv_rawType_0_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:2323:5: lv_rawType_0_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:2332:3: (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:2333:4: otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSimpleTypeRef_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:2340:4: ( (lv_actualArgumentsList_2_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2341:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2341:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2342:6: lv_actualArgumentsList_2_0= RULE_ID
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:2351:4: (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==16) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2352:5: otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getSimpleTypeRef_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2359:5: ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2360:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2360:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2361:7: lv_actualArgumentsList_4_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 46, ruleSimpleTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleSimpleTypeRef"


    // $ANTLR start "entryRuleClosureTypeRef"
    // PsiInternalSimpleBeeLangTestLanguage.g:2383:1: entryRuleClosureTypeRef : ruleClosureTypeRef EOF ;
    public final void entryRuleClosureTypeRef() throws RecognitionException {
        int entryRuleClosureTypeRef_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2383:24: ( ruleClosureTypeRef EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2384:2: ruleClosureTypeRef EOF
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
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleClosureTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleClosureTypeRef"


    // $ANTLR start "ruleClosureTypeRef"
    // PsiInternalSimpleBeeLangTestLanguage.g:2389:1: ruleClosureTypeRef : (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2389:19: ( (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2390:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2390:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2391:3: otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_47); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSimpleBeeLangTestLanguage.g:2398:3: ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )?
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2399:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2399:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2400:5: ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2400:5: ( (lv_parameterTypes_1_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2401:6: (lv_parameterTypes_1_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2401:6: (lv_parameterTypes_1_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2402:7: lv_parameterTypes_1_0= RULE_ID
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:2411:5: (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )*
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2412:6: otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_1_0ElementType());
                    	      					
                    	    }
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      						doneLeaf(otherlv_2);
                    	      					
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2419:6: ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2420:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2420:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:2421:8: lv_parameterTypes_3_0= RULE_ID
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:2431:5: (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==16) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // PsiInternalSimpleBeeLangTestLanguage.g:2432:6: otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) )
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_2_0ElementType());
                              					
                            }
                            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(otherlv_4);
                              					
                            }
                            // PsiInternalSimpleBeeLangTestLanguage.g:2439:6: ( (lv_varArgs_5_0= '...' ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:2440:7: (lv_varArgs_5_0= '...' )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:2440:7: (lv_varArgs_5_0= '...' )
                            // PsiInternalSimpleBeeLangTestLanguage.g:2441:8: lv_varArgs_5_0= '...'
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

                            // PsiInternalSimpleBeeLangTestLanguage.g:2450:6: ( (lv_parameterTypes_6_0= RULE_ID ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:2451:7: (lv_parameterTypes_6_0= RULE_ID )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:2451:7: (lv_parameterTypes_6_0= RULE_ID )
                            // PsiInternalSimpleBeeLangTestLanguage.g:2452:8: lv_parameterTypes_6_0= RULE_ID
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2464:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2464:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2465:5: ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2465:5: ( (lv_varArgs_7_0= '...' ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2466:6: (lv_varArgs_7_0= '...' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2466:6: (lv_varArgs_7_0= '...' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2467:7: lv_varArgs_7_0= '...'
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:2476:5: ( (lv_parameterTypes_8_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2477:6: (lv_parameterTypes_8_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2477:6: (lv_parameterTypes_8_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2478:7: lv_parameterTypes_8_0= RULE_ID
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2503:3: ( (lv_returnType_11_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2504:4: (lv_returnType_11_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2504:4: (lv_returnType_11_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:2505:5: lv_returnType_11_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 48, ruleClosureTypeRef_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleClosureTypeRef"


    // $ANTLR start "entryRuleCachedExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2518:1: entryRuleCachedExpression : ruleCachedExpression EOF ;
    public final void entryRuleCachedExpression() throws RecognitionException {
        int entryRuleCachedExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2518:26: ( ruleCachedExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2519:2: ruleCachedExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleCachedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleCachedExpression"


    // $ANTLR start "ruleCachedExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2524:1: ruleCachedExpression : ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression ) ;
    public final void ruleCachedExpression() throws RecognitionException {
        int ruleCachedExpression_StartIndex = input.index();
        Token otherlv_1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2524:21: ( ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2525:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2525:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | ruleOrExpression )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2526:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2526:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2527:4: () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2527:4: ()
                    // PsiInternalSimpleBeeLangTestLanguage.g:2528:5: 
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2543:4: ( (lv_expr_2_0= ruleOrExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2544:5: (lv_expr_2_0= ruleOrExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:2544:5: (lv_expr_2_0= ruleOrExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:2545:6: lv_expr_2_0= ruleOrExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2556:3: ruleOrExpression
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
            if ( state.backtracking>0 ) { memoize(input, 50, ruleCachedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleCachedExpression"


    // $ANTLR start "entryRuleOrExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2570:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        int entryRuleOrExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2570:22: ( ruleOrExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2571:2: ruleOrExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleOrExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2576:1: ruleOrExpression : ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) ;
    public final void ruleOrExpression() throws RecognitionException {
        int ruleOrExpression_StartIndex = input.index();
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2576:17: ( ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2577:2: ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2577:2: ( ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:2578:3: ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2588:3: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==57) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred85_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2589:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2589:4: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2590:5: 
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2605:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2606:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2606:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2607:6: lv_rightExpr_3_0= ruleAndExpression
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
            if ( state.backtracking>0 ) { memoize(input, 52, ruleOrExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2621:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        int entryRuleAndExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2621:23: ( ruleAndExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2622:2: ruleAndExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleAndExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2627:1: ruleAndExpression : ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) ;
    public final void ruleAndExpression() throws RecognitionException {
        int ruleAndExpression_StartIndex = input.index();
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2627:18: ( ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2628:2: ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2628:2: ( ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:2629:3: ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2639:3: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==58) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred86_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2640:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2640:4: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2641:5: 
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2656:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2657:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2657:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2658:6: lv_rightExpr_3_0= ruleRelationalExpression
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
            if ( state.backtracking>0 ) { memoize(input, 54, ruleAndExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2672:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        int entryRuleRelationalExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2672:30: ( ruleRelationalExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2673:2: ruleRelationalExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleRelationalExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2678:1: ruleRelationalExpression : ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final void ruleRelationalExpression() throws RecognitionException {
        int ruleRelationalExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2678:25: ( ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2679:2: ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2679:2: ( ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:2680:3: ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2690:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2691:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2691:4: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2692:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getRelationalExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2700:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2701:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2701:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2702:6: lv_functionName_2_0= ruleRelationalOperator
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

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2711:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2712:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2712:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2713:6: lv_rightExpr_3_0= ruleAdditiveExpression
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
            if ( state.backtracking>0 ) { memoize(input, 56, ruleRelationalExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2727:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        int entryRuleAdditiveExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2727:28: ( ruleAdditiveExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2728:2: ruleAdditiveExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleAdditiveExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2733:1: ruleAdditiveExpression : ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {
        int ruleAdditiveExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2733:23: ( ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2734:2: ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2734:2: ( ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:2735:3: ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2745:3: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==59) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred89_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==60) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred89_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2746:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2746:4: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2747:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAdditiveExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2755:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2756:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2756:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2757:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2757:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
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
            	            // PsiInternalSimpleBeeLangTestLanguage.g:2758:7: lv_functionName_2_1= '+'
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
            	            // PsiInternalSimpleBeeLangTestLanguage.g:2766:7: lv_functionName_2_2= '-'
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

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2776:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2777:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2777:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2778:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
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
            if ( state.backtracking>0 ) { memoize(input, 58, ruleAdditiveExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2792:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        int entryRuleMultiplicativeExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2792:34: ( ruleMultiplicativeExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2793:2: ruleMultiplicativeExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleMultiplicativeExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2798:1: ruleMultiplicativeExpression : ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {
        int ruleMultiplicativeExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2798:29: ( ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2799:2: ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2799:2: ( ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:2800:3: ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2810:3: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred92_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred92_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 62:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred92_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2811:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2811:4: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2812:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getMultiplicativeExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2820:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2821:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2821:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2822:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2822:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
            	            // PsiInternalSimpleBeeLangTestLanguage.g:2823:7: lv_functionName_2_1= '*'
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
            	            // PsiInternalSimpleBeeLangTestLanguage.g:2831:7: lv_functionName_2_2= '/'
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
            	            // PsiInternalSimpleBeeLangTestLanguage.g:2839:7: lv_functionName_2_3= '%'
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

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2849:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2850:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2850:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2851:6: lv_rightExpr_3_0= ruleSetExpression
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
            if ( state.backtracking>0 ) { memoize(input, 60, ruleMultiplicativeExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleSetExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2865:1: entryRuleSetExpression : ruleSetExpression EOF ;
    public final void entryRuleSetExpression() throws RecognitionException {
        int entryRuleSetExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2865:23: ( ruleSetExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2866:2: ruleSetExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleSetExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleSetExpression"


    // $ANTLR start "ruleSetExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2871:1: ruleSetExpression : ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) ;
    public final void ruleSetExpression() throws RecognitionException {
        int ruleSetExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2871:18: ( ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2872:2: ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2872:2: ( ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:2873:3: ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:2883:3: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==63) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred93_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2884:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2884:4: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2885:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getSetExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      				
            	    }

            	    }

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2893:4: ( (lv_functionName_2_0= '..' ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2894:5: (lv_functionName_2_0= '..' )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2894:5: (lv_functionName_2_0= '..' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2895:6: lv_functionName_2_0= '..'
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

            	    // PsiInternalSimpleBeeLangTestLanguage.g:2904:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2905:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2905:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:2906:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
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
            if ( state.backtracking>0 ) { memoize(input, 62, ruleSetExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleSetExpression"


    // $ANTLR start "entryRuleUnaryOrInfixExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2920:1: entryRuleUnaryOrInfixExpression : ruleUnaryOrInfixExpression EOF ;
    public final void entryRuleUnaryOrInfixExpression() throws RecognitionException {
        int entryRuleUnaryOrInfixExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2920:32: ( ruleUnaryOrInfixExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2921:2: ruleUnaryOrInfixExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleUnaryOrInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOrInfixExpression"


    // $ANTLR start "ruleUnaryOrInfixExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2926:1: ruleUnaryOrInfixExpression : ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression ) ;
    public final void ruleUnaryOrInfixExpression() throws RecognitionException {
        int ruleUnaryOrInfixExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2926:27: ( ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2927:2: ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2927:2: ( rulePostopExpression | ruleUnaryExpression | rulePreopExpression )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2928:3: rulePostopExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2939:3: ruleUnaryExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2950:3: rulePreopExpression
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
            if ( state.backtracking>0 ) { memoize(input, 64, ruleUnaryOrInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleUnaryOrInfixExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2964:1: entryRuleUnaryExpression : ruleUnaryExpression EOF ;
    public final void entryRuleUnaryExpression() throws RecognitionException {
        int entryRuleUnaryExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2964:25: ( ruleUnaryExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:2965:2: ruleUnaryExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 65, entryRuleUnaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:2970:1: ruleUnaryExpression : ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final void ruleUnaryExpression() throws RecognitionException {
        int ruleUnaryExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:2970:20: ( ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2971:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2971:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2972:3: () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2972:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:2973:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnaryExpression_UnaryOpExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:2981:3: ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2982:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2982:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:2983:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:2983:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2984:6: lv_functionName_1_1= '!'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:2992:6: lv_functionName_1_2= '-'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3002:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3003:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3003:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:3004:5: lv_expr_2_0= ruleInfixExpression
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
            if ( state.backtracking>0 ) { memoize(input, 66, ruleUnaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePreopExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3017:1: entryRulePreopExpression : rulePreopExpression EOF ;
    public final void entryRulePreopExpression() throws RecognitionException {
        int entryRulePreopExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3017:25: ( rulePreopExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3018:2: rulePreopExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 67, entryRulePreopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePreopExpression"


    // $ANTLR start "rulePreopExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3023:1: rulePreopExpression : ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final void rulePreopExpression() throws RecognitionException {
        int rulePreopExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3023:20: ( ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3024:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3024:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3025:3: () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3025:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:3026:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPreopExpression_UnaryPreOpExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:3034:3: ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3035:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3035:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3036:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3036:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3037:6: lv_functionName_1_1= '++'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3045:6: lv_functionName_1_2= '--'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3055:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3056:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3056:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:3057:5: lv_expr_2_0= ruleInfixExpression
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
            if ( state.backtracking>0 ) { memoize(input, 68, rulePreopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "rulePreopExpression"


    // $ANTLR start "entryRulePostopExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3070:1: entryRulePostopExpression : rulePostopExpression EOF ;
    public final void entryRulePostopExpression() throws RecognitionException {
        int entryRulePostopExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3070:26: ( rulePostopExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3071:2: rulePostopExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 69, entryRulePostopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePostopExpression"


    // $ANTLR start "rulePostopExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3076:1: rulePostopExpression : ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) ;
    public final void rulePostopExpression() throws RecognitionException {
        int rulePostopExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3076:21: ( ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3077:2: ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3077:2: ( ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            // PsiInternalSimpleBeeLangTestLanguage.g:3078:3: ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3088:3: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==66) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred99_PsiInternalSimpleBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            else if ( (LA68_0==65) ) {
                int LA68_2 = input.LA(2);

                if ( (synpred99_PsiInternalSimpleBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:3089:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3089:4: ()
                    // PsiInternalSimpleBeeLangTestLanguage.g:3090:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPostopExpression_UnaryPostOpExpressionExprAction_1_0ElementType());
                      					doneComposite();
                      				
                    }

                    }

                    // PsiInternalSimpleBeeLangTestLanguage.g:3098:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3099:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3099:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3100:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3100:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
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
                            // PsiInternalSimpleBeeLangTestLanguage.g:3101:7: lv_functionName_2_1= '--'
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
                            // PsiInternalSimpleBeeLangTestLanguage.g:3109:7: lv_functionName_2_2= '++'
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
            if ( state.backtracking>0 ) { memoize(input, 70, rulePostopExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "rulePostopExpression"


    // $ANTLR start "entryRuleInfixExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3124:1: entryRuleInfixExpression : ruleInfixExpression EOF ;
    public final void entryRuleInfixExpression() throws RecognitionException {
        int entryRuleInfixExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3124:25: ( ruleInfixExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3125:2: ruleInfixExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleInfixExpression"


    // $ANTLR start "ruleInfixExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3130:1: ruleInfixExpression : ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3130:20: ( ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3131:2: ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3131:2: ( ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:3132:3: ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3142:3: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==67) ) {
                    int LA70_2 = input.LA(2);

                    if ( (synpred101_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt70=1;
                    }
                    else if ( (synpred103_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt70=3;
                    }


                }
                else if ( (LA70_0==68) ) {
                    int LA70_3 = input.LA(2);

                    if ( (synpred102_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt70=2;
                    }


                }


                switch (alt70) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3143:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3143:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3144:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3144:5: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3145:6: 
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3160:5: ( (lv_name_3_0= RULE_ID ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3161:6: (lv_name_3_0= RULE_ID )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3161:6: (lv_name_3_0= RULE_ID )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3162:7: lv_name_3_0= RULE_ID
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3178:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==RULE_ID||LA69_0==RULE_STRING||LA69_0==13||(LA69_0>=17 && LA69_0<=18)||LA69_0==21||(LA69_0>=35 && LA69_0<=36)||LA69_0==52||LA69_0==56||LA69_0==60||(LA69_0>=64 && LA69_0<=66)||LA69_0==70||(LA69_0>=72 && LA69_0<=77)) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // PsiInternalSimpleBeeLangTestLanguage.g:3179:6: (lv_parameterList_5_0= ruleParameterList )
            	            {
            	            // PsiInternalSimpleBeeLangTestLanguage.g:3179:6: (lv_parameterList_5_0= ruleParameterList )
            	            // PsiInternalSimpleBeeLangTestLanguage.g:3180:7: lv_parameterList_5_0= ruleParameterList
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3198:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3198:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3199:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3199:5: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3200:6: 
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3215:5: ( (lv_indexExpr_9_0= ruleExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3216:6: (lv_indexExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3216:6: (lv_indexExpr_9_0= ruleExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3217:7: lv_indexExpr_9_0= ruleExpression
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3235:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3235:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3236:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3236:5: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3237:6: 
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3252:5: ( (lv_featureName_13_0= RULE_ID ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3253:6: (lv_featureName_13_0= RULE_ID )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3253:6: (lv_featureName_13_0= RULE_ID )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3254:7: lv_featureName_13_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 72, ruleInfixExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleInfixExpression"


    // $ANTLR start "entryRuleCallExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3269:1: entryRuleCallExpression : ruleCallExpression EOF ;
    public final void entryRuleCallExpression() throws RecognitionException {
        int entryRuleCallExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3269:24: ( ruleCallExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3270:2: ruleCallExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 73, entryRuleCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleCallExpression"


    // $ANTLR start "ruleCallExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3275:1: ruleCallExpression : ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) ;
    public final void ruleCallExpression() throws RecognitionException {
        int ruleCallExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3275:19: ( ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3276:2: ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3276:2: ( rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:3277:3: rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3287:3: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==35) ) {
                    int LA72_2 = input.LA(2);

                    if ( (synpred105_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3288:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3288:4: ()
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3289:5: 
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3304:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==RULE_ID||LA71_0==RULE_STRING||LA71_0==13||(LA71_0>=17 && LA71_0<=18)||LA71_0==21||(LA71_0>=35 && LA71_0<=36)||LA71_0==52||LA71_0==56||LA71_0==60||(LA71_0>=64 && LA71_0<=66)||LA71_0==70||(LA71_0>=72 && LA71_0<=77)) ) {
            	        alt71=1;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // PsiInternalSimpleBeeLangTestLanguage.g:3305:5: (lv_parameterList_3_0= ruleParameterList )
            	            {
            	            // PsiInternalSimpleBeeLangTestLanguage.g:3305:5: (lv_parameterList_3_0= ruleParameterList )
            	            // PsiInternalSimpleBeeLangTestLanguage.g:3306:6: lv_parameterList_3_0= ruleParameterList
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
            if ( state.backtracking>0 ) { memoize(input, 74, ruleCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3327:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        int entryRulePrimaryExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3327:27: ( rulePrimaryExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3328:2: rulePrimaryExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 75, entryRulePrimaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3333:1: rulePrimaryExpression : ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression ) ;
    public final void rulePrimaryExpression() throws RecognitionException {
        int rulePrimaryExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3333:22: ( ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3334:2: ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3334:2: ( ruleFeatureCall | ruleConstructorCallExpression | ruleValue | ruleLiteral | ruleKeywordVariables | ruleParanthesizedExpression | ruleBlockExpression | ruleWithExpression | ruleWithContextExpression )
            int alt73=9;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:3335:3: ruleFeatureCall
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3346:3: ruleConstructorCallExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3357:3: ruleValue
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3368:3: ruleLiteral
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3379:3: ruleKeywordVariables
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3390:3: ruleParanthesizedExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3401:3: ruleBlockExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3412:3: ruleWithExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3423:3: ruleWithContextExpression
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
            if ( state.backtracking>0 ) { memoize(input, 76, rulePrimaryExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleWithExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3437:1: entryRuleWithExpression : ruleWithExpression EOF ;
    public final void entryRuleWithExpression() throws RecognitionException {
        int entryRuleWithExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3437:24: ( ruleWithExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3438:2: ruleWithExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleWithExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleWithExpression"


    // $ANTLR start "ruleWithExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3443:1: ruleWithExpression : (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3443:19: ( (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3444:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3444:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3445:3: otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithExpression_WithKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_62); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalSimpleBeeLangTestLanguage.g:3452:3: ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:3453:4: ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3453:4: ( (lv_referencedAdvice_1_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3454:5: (lv_referencedAdvice_1_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3454:5: (lv_referencedAdvice_1_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3455:6: lv_referencedAdvice_1_0= RULE_ID
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:3464:4: (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==16) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:3465:5: otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getWithExpression_CommaKeyword_1_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_2);
                    	      				
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:3472:5: ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:3473:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:3473:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:3474:7: lv_referencedAdvice_3_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3485:3: ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3486:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3486:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3487:5: otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_ColonKeyword_2_0_0ElementType());
                      				
                    }
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_4);
                      				
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:3494:5: ( (lv_funcExpr_5_0= ruleExpression ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3495:6: (lv_funcExpr_5_0= ruleExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3495:6: (lv_funcExpr_5_0= ruleExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3496:7: lv_funcExpr_5_0= ruleExpression
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3507:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3507:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3508:5: otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_LeftCurlyBracketKeyword_2_1_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_64); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:3515:5: ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3516:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3516:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3517:7: lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets
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
            if ( state.backtracking>0 ) { memoize(input, 78, ruleWithExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleWithExpression"


    // $ANTLR start "entryRuleWithContextExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3539:1: entryRuleWithContextExpression : ruleWithContextExpression EOF ;
    public final void entryRuleWithContextExpression() throws RecognitionException {
        int entryRuleWithContextExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3539:31: ( ruleWithContextExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3540:2: ruleWithContextExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleWithContextExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleWithContextExpression"


    // $ANTLR start "ruleWithContextExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3545:1: ruleWithContextExpression : (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) ;
    public final void ruleWithContextExpression() throws RecognitionException {
        int ruleWithContextExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3545:26: ( (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3546:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3546:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3547:3: otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) )
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3561:3: ( (lv_expr_2_0= ruleExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3562:4: (lv_expr_2_0= ruleExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3562:4: (lv_expr_2_0= ruleExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:3563:5: lv_expr_2_0= ruleExpression
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3572:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==28) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:3573:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getWithContextExpression_AsKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:3580:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3581:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3581:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3582:6: lv_alias_4_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3592:3: ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3593:4: (lv_contextBlock_5_0= ruleBlockExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3593:4: (lv_contextBlock_5_0= ruleBlockExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:3594:5: lv_contextBlock_5_0= ruleBlockExpression
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
            if ( state.backtracking>0 ) { memoize(input, 80, ruleWithContextExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleWithContextExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3607:1: entryRuleBlockExpression : ruleBlockExpression EOF ;
    public final void entryRuleBlockExpression() throws RecognitionException {
        int entryRuleBlockExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3607:25: ( ruleBlockExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3608:2: ruleBlockExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3613:1: ruleBlockExpression : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final void ruleBlockExpression() throws RecognitionException {
        int ruleBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3613:20: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3614:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3614:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // PsiInternalSimpleBeeLangTestLanguage.g:3615:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3615:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:3616:4: 
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3631:3: ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==RULE_STRING||LA78_0==13||(LA78_0>=17 && LA78_0<=18)||LA78_0==21||LA78_0==33||LA78_0==35||(LA78_0>=53 && LA78_0<=54)||LA78_0==56||LA78_0==60||(LA78_0>=64 && LA78_0<=66)||LA78_0==70||(LA78_0>=72 && LA78_0<=76)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3632:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';'
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3632:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3633:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3633:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:3634:6: lv_expressions_2_0= ruleTopLevelExpression
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
            if ( state.backtracking>0 ) { memoize(input, 82, ruleBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleValue"
    // PsiInternalSimpleBeeLangTestLanguage.g:3662:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        int entryRuleValue_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3662:15: ( ruleValue EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3663:2: ruleValue EOF
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
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleValue_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // PsiInternalSimpleBeeLangTestLanguage.g:3668:1: ruleValue : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleValue() throws RecognitionException {
        int ruleValue_StartIndex = input.index();
        Token lv_name_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3668:10: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3669:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3669:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3670:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3670:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:3671:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValue_VariableExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:3679:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3680:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3680:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:3681:5: lv_name_1_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 84, ruleValue_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleKeywordVariables"
    // PsiInternalSimpleBeeLangTestLanguage.g:3694:1: entryRuleKeywordVariables : ruleKeywordVariables EOF ;
    public final void entryRuleKeywordVariables() throws RecognitionException {
        int entryRuleKeywordVariables_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3694:26: ( ruleKeywordVariables EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3695:2: ruleKeywordVariables EOF
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
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleKeywordVariables_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleKeywordVariables"


    // $ANTLR start "ruleKeywordVariables"
    // PsiInternalSimpleBeeLangTestLanguage.g:3700:1: ruleKeywordVariables : ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3700:21: ( ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3701:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3701:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3702:3: () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3702:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:3703:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getKeywordVariables_VariableExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:3711:3: ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3712:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3712:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3713:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3713:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3714:6: lv_name_1_1= 'input'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3722:6: lv_name_1_2= 'output'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3730:6: lv_name_1_3= 'source'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3738:6: lv_name_1_4= 'properties'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3746:6: lv_name_1_5= 'builder'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3754:6: lv_name_1_6= 'unit'
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3762:6: lv_name_1_7= 'this'
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
            if ( state.backtracking>0 ) { memoize(input, 86, ruleKeywordVariables_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleKeywordVariables"


    // $ANTLR start "entryRuleFeatureCall"
    // PsiInternalSimpleBeeLangTestLanguage.g:3776:1: entryRuleFeatureCall : ruleFeatureCall EOF ;
    public final void entryRuleFeatureCall() throws RecognitionException {
        int entryRuleFeatureCall_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3776:21: ( ruleFeatureCall EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3777:2: ruleFeatureCall EOF
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
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleFeatureCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // PsiInternalSimpleBeeLangTestLanguage.g:3782:1: ruleFeatureCall : ruleOperationCall ;
    public final void ruleFeatureCall() throws RecognitionException {
        int ruleFeatureCall_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3782:16: ( ruleOperationCall )
            // PsiInternalSimpleBeeLangTestLanguage.g:3783:2: ruleOperationCall
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
            if ( state.backtracking>0 ) { memoize(input, 88, ruleFeatureCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleOperationCall"
    // PsiInternalSimpleBeeLangTestLanguage.g:3796:1: entryRuleOperationCall : ruleOperationCall EOF ;
    public final void entryRuleOperationCall() throws RecognitionException {
        int entryRuleOperationCall_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3796:23: ( ruleOperationCall EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3797:2: ruleOperationCall EOF
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
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleOperationCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // PsiInternalSimpleBeeLangTestLanguage.g:3802:1: ruleOperationCall : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) ;
    public final void ruleOperationCall() throws RecognitionException {
        int ruleOperationCall_StartIndex = input.index();
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3802:18: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3803:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3803:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            // PsiInternalSimpleBeeLangTestLanguage.g:3804:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3804:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:3805:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getOperationCall_CallNamedFunctionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:3813:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3814:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3814:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:3815:5: lv_name_1_0= RULE_ID
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3831:3: ( (lv_parameterList_3_0= ruleParameterList ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||LA80_0==RULE_STRING||LA80_0==13||(LA80_0>=17 && LA80_0<=18)||LA80_0==21||(LA80_0>=35 && LA80_0<=36)||LA80_0==52||LA80_0==56||LA80_0==60||(LA80_0>=64 && LA80_0<=66)||LA80_0==70||(LA80_0>=72 && LA80_0<=77)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:3832:4: (lv_parameterList_3_0= ruleParameterList )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3832:4: (lv_parameterList_3_0= ruleParameterList )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3833:5: lv_parameterList_3_0= ruleParameterList
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
            if ( state.backtracking>0 ) { memoize(input, 90, ruleOperationCall_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleConstructorCallExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3853:1: entryRuleConstructorCallExpression : ruleConstructorCallExpression EOF ;
    public final void entryRuleConstructorCallExpression() throws RecognitionException {
        int entryRuleConstructorCallExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3853:35: ( ruleConstructorCallExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3854:2: ruleConstructorCallExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleConstructorCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleConstructorCallExpression"


    // $ANTLR start "ruleConstructorCallExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3859:1: ruleConstructorCallExpression : ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) ;
    public final void ruleConstructorCallExpression() throws RecognitionException {
        int ruleConstructorCallExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_typeExpr_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3859:30: ( ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3860:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3860:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            // PsiInternalSimpleBeeLangTestLanguage.g:3861:3: () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3861:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:3862:4: 
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3877:3: ( (lv_typeExpr_2_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3878:4: (lv_typeExpr_2_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3878:4: (lv_typeExpr_2_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:3879:5: lv_typeExpr_2_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3888:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:3889:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:3896:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID||LA81_0==RULE_STRING||LA81_0==13||(LA81_0>=17 && LA81_0<=18)||LA81_0==21||(LA81_0>=35 && LA81_0<=36)||LA81_0==52||LA81_0==56||LA81_0==60||(LA81_0>=64 && LA81_0<=66)||LA81_0==70||(LA81_0>=72 && LA81_0<=77)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // PsiInternalSimpleBeeLangTestLanguage.g:3897:5: (lv_parameterList_4_0= ruleParameterList )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:3897:5: (lv_parameterList_4_0= ruleParameterList )
                            // PsiInternalSimpleBeeLangTestLanguage.g:3898:6: lv_parameterList_4_0= ruleParameterList
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3915:3: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==28) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ID) ) {
                    int LA83_3 = input.LA(3);

                    if ( (synpred128_PsiInternalSimpleBeeLangTestLanguage()) ) {
                        alt83=1;
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:3916:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:3923:4: ( (lv_alias_7_0= RULE_ID ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3924:5: (lv_alias_7_0= RULE_ID )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3924:5: (lv_alias_7_0= RULE_ID )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3925:6: lv_alias_7_0= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:3935:3: ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:3936:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:3936:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    // PsiInternalSimpleBeeLangTestLanguage.g:3937:5: lv_contextBlock_8_0= ruleInitializationBlockExpression
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
            if ( state.backtracking>0 ) { memoize(input, 92, ruleConstructorCallExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleConstructorCallExpression"


    // $ANTLR start "entryRuleInitializationBlockExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3950:1: entryRuleInitializationBlockExpression : ruleInitializationBlockExpression EOF ;
    public final void entryRuleInitializationBlockExpression() throws RecognitionException {
        int entryRuleInitializationBlockExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3950:39: ( ruleInitializationBlockExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:3951:2: ruleInitializationBlockExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleInitializationBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleInitializationBlockExpression"


    // $ANTLR start "ruleInitializationBlockExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:3956:1: ruleInitializationBlockExpression : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) ;
    public final void ruleInitializationBlockExpression() throws RecognitionException {
        int ruleInitializationBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:3956:34: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3957:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3957:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            // PsiInternalSimpleBeeLangTestLanguage.g:3958:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}'
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3958:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:3959:4: 
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
            // PsiInternalSimpleBeeLangTestLanguage.g:3974:3: ( (lv_expressions_2_0= ruleInitializationExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:3975:4: (lv_expressions_2_0= ruleInitializationExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:3975:4: (lv_expressions_2_0= ruleInitializationExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:3976:5: lv_expressions_2_0= ruleInitializationExpression
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
            if ( state.backtracking>0 ) { memoize(input, 94, ruleInitializationBlockExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleInitializationBlockExpression"


    // $ANTLR start "entryRuleInitializationExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:4003:1: entryRuleInitializationExpression : ruleInitializationExpression EOF ;
    public final void entryRuleInitializationExpression() throws RecognitionException {
        int entryRuleInitializationExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4003:34: ( ruleInitializationExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4004:2: ruleInitializationExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleInitializationExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleInitializationExpression"


    // $ANTLR start "ruleInitializationExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:4009:1: ruleInitializationExpression : ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) ;
    public final void ruleInitializationExpression() throws RecognitionException {
        int ruleInitializationExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4009:29: ( ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4010:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4010:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4011:3: () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4011:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:4012:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getInitializationExpression_AssignmentExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:4020:3: ( (lv_leftExpr_1_0= ruleFeatureOfThis ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4021:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4021:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            // PsiInternalSimpleBeeLangTestLanguage.g:4022:5: lv_leftExpr_1_0= ruleFeatureOfThis
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

            // PsiInternalSimpleBeeLangTestLanguage.g:4031:3: ( (lv_functionName_2_0= ':' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4032:4: (lv_functionName_2_0= ':' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4032:4: (lv_functionName_2_0= ':' )
            // PsiInternalSimpleBeeLangTestLanguage.g:4033:5: lv_functionName_2_0= ':'
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

            // PsiInternalSimpleBeeLangTestLanguage.g:4042:3: ( (lv_rightExpr_3_0= ruleExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4043:4: (lv_rightExpr_3_0= ruleExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4043:4: (lv_rightExpr_3_0= ruleExpression )
            // PsiInternalSimpleBeeLangTestLanguage.g:4044:5: lv_rightExpr_3_0= ruleExpression
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
            if ( state.backtracking>0 ) { memoize(input, 96, ruleInitializationExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleInitializationExpression"


    // $ANTLR start "entryRuleFeatureOfThis"
    // PsiInternalSimpleBeeLangTestLanguage.g:4057:1: entryRuleFeatureOfThis : ruleFeatureOfThis EOF ;
    public final void entryRuleFeatureOfThis() throws RecognitionException {
        int entryRuleFeatureOfThis_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4057:23: ( ruleFeatureOfThis EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4058:2: ruleFeatureOfThis EOF
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
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleFeatureOfThis_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleFeatureOfThis"


    // $ANTLR start "ruleFeatureOfThis"
    // PsiInternalSimpleBeeLangTestLanguage.g:4063:1: ruleFeatureOfThis : ( () ( (lv_featureName_1_0= RULE_ID ) ) ) ;
    public final void ruleFeatureOfThis() throws RecognitionException {
        int ruleFeatureOfThis_StartIndex = input.index();
        Token lv_featureName_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4063:18: ( ( () ( (lv_featureName_1_0= RULE_ID ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4064:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4064:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4065:3: () ( (lv_featureName_1_0= RULE_ID ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4065:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:4066:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getFeatureOfThis_FeatureExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:4074:3: ( (lv_featureName_1_0= RULE_ID ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4075:4: (lv_featureName_1_0= RULE_ID )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4075:4: (lv_featureName_1_0= RULE_ID )
            // PsiInternalSimpleBeeLangTestLanguage.g:4076:5: lv_featureName_1_0= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 98, ruleFeatureOfThis_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleFeatureOfThis"


    // $ANTLR start "entryRuleLiteral"
    // PsiInternalSimpleBeeLangTestLanguage.g:4089:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        int entryRuleLiteral_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4089:17: ( ruleLiteral EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4090:2: ruleLiteral EOF
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
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // PsiInternalSimpleBeeLangTestLanguage.g:4095:1: ruleLiteral : ( ruleValueLiteral | ruleLiteralFunction ) ;
    public final void ruleLiteral() throws RecognitionException {
        int ruleLiteral_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4095:12: ( ( ruleValueLiteral | ruleLiteralFunction ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4096:2: ( ruleValueLiteral | ruleLiteralFunction )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4096:2: ( ruleValueLiteral | ruleLiteralFunction )
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:4097:3: ruleValueLiteral
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:4108:3: ruleLiteralFunction
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
            if ( state.backtracking>0 ) { memoize(input, 100, ruleLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleLiteral"

}

@SuppressWarnings("all")
abstract class PsiInternalSimpleBeeLangTestLanguageParser3 extends PsiInternalSimpleBeeLangTestLanguageParser2 {

        PsiInternalSimpleBeeLangTestLanguageParser3(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalSimpleBeeLangTestLanguageParser3(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleLiteralFunction"
    // PsiInternalSimpleBeeLangTestLanguage.g:4122:1: entryRuleLiteralFunction : ruleLiteralFunction EOF ;
    public final void entryRuleLiteralFunction() throws RecognitionException {
        int entryRuleLiteralFunction_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4122:25: ( ruleLiteralFunction EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4123:2: ruleLiteralFunction EOF
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
            if ( state.backtracking>0 ) { memoize(input, 101, entryRuleLiteralFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralFunction"


    // $ANTLR start "ruleLiteralFunction"
    // PsiInternalSimpleBeeLangTestLanguage.g:4128:1: ruleLiteralFunction : (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' ) ;
    public final void ruleLiteralFunction() throws RecognitionException {
        int ruleLiteralFunction_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4128:20: ( (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4129:2: (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4129:2: (otherlv_0= '{' ruleClosureExpression otherlv_2= '}' )
            // PsiInternalSimpleBeeLangTestLanguage.g:4130:3: otherlv_0= '{' ruleClosureExpression otherlv_2= '}'
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
            if ( state.backtracking>0 ) { memoize(input, 102, ruleLiteralFunction_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleLiteralFunction"


    // $ANTLR start "entryRuleClosureExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:4158:1: entryRuleClosureExpression : ruleClosureExpression EOF ;
    public final void entryRuleClosureExpression() throws RecognitionException {
        int entryRuleClosureExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4158:27: ( ruleClosureExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4159:2: ruleClosureExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 103, entryRuleClosureExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleClosureExpression"


    // $ANTLR start "ruleClosureExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:4164:1: ruleClosureExpression : ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4164:22: ( ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4165:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4165:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4166:3: () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4166:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:4167:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getClosureExpression_FunctionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:4175:3: (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==52) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:4176:4: otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getClosureExpression_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_31); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalSimpleBeeLangTestLanguage.g:4183:4: ( (lv_returnType_2_0= ruleTypeRef ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4184:5: (lv_returnType_2_0= ruleTypeRef )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4184:5: (lv_returnType_2_0= ruleTypeRef )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4185:6: lv_returnType_2_0= ruleTypeRef
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

            // PsiInternalSimpleBeeLangTestLanguage.g:4202:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?
            int alt90=3;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:4203:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4203:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4204:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4204:5: (otherlv_4= '|' )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==77) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // PsiInternalSimpleBeeLangTestLanguage.g:4205:6: otherlv_4= '|'
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:4213:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4214:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4214:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4215:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4215:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4216:8: lv_parameters_5_0= ruleParameterDeclaration
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:4225:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:4226:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_1_0ElementType());
                    	      						
                    	    }
                    	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_6);
                    	      						
                    	    }
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:4233:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:4234:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    {
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:4234:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    // PsiInternalSimpleBeeLangTestLanguage.g:4235:9: lv_parameters_7_0= ruleParameterDeclaration
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:4245:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==16) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // PsiInternalSimpleBeeLangTestLanguage.g:4246:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_2_0ElementType());
                              						
                            }
                            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_8);
                              						
                            }
                            // PsiInternalSimpleBeeLangTestLanguage.g:4253:7: ( (lv_varArgs_9_0= '...' ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:4254:8: (lv_varArgs_9_0= '...' )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:4254:8: (lv_varArgs_9_0= '...' )
                            // PsiInternalSimpleBeeLangTestLanguage.g:4255:9: lv_varArgs_9_0= '...'
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

                            // PsiInternalSimpleBeeLangTestLanguage.g:4264:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            // PsiInternalSimpleBeeLangTestLanguage.g:4265:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            {
                            // PsiInternalSimpleBeeLangTestLanguage.g:4265:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            // PsiInternalSimpleBeeLangTestLanguage.g:4266:9: lv_parameters_10_0= ruleParameterDeclaration
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:4279:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4279:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4280:5: ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4280:5: ( (lv_varArgs_11_0= '...' ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4281:6: (lv_varArgs_11_0= '...' )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4281:6: (lv_varArgs_11_0= '...' )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4282:7: lv_varArgs_11_0= '...'
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

                    // PsiInternalSimpleBeeLangTestLanguage.g:4291:5: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4292:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    {
                    // PsiInternalSimpleBeeLangTestLanguage.g:4292:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    // PsiInternalSimpleBeeLangTestLanguage.g:4293:7: lv_parameters_12_0= ruleParameterDeclaration
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
            // PsiInternalSimpleBeeLangTestLanguage.g:4311:3: ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4312:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4312:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            // PsiInternalSimpleBeeLangTestLanguage.g:4313:5: lv_funcExpr_14_0= ruleOneOrManyExpressions
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
            if ( state.backtracking>0 ) { memoize(input, 104, ruleClosureExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleClosureExpression"


    // $ANTLR start "entryRuleOneOrManyExpressions"
    // PsiInternalSimpleBeeLangTestLanguage.g:4326:1: entryRuleOneOrManyExpressions : ruleOneOrManyExpressions EOF ;
    public final void entryRuleOneOrManyExpressions() throws RecognitionException {
        int entryRuleOneOrManyExpressions_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4326:30: ( ruleOneOrManyExpressions EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4327:2: ruleOneOrManyExpressions EOF
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
            if ( state.backtracking>0 ) { memoize(input, 105, entryRuleOneOrManyExpressions_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleOneOrManyExpressions"


    // $ANTLR start "ruleOneOrManyExpressions"
    // PsiInternalSimpleBeeLangTestLanguage.g:4332:1: ruleOneOrManyExpressions : ( ruleBlockExpressionWithoutBrackets | ruleExpression ) ;
    public final void ruleOneOrManyExpressions() throws RecognitionException {
        int ruleOneOrManyExpressions_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4332:25: ( ( ruleBlockExpressionWithoutBrackets | ruleExpression ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4333:2: ( ruleBlockExpressionWithoutBrackets | ruleExpression )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4333:2: ( ruleBlockExpressionWithoutBrackets | ruleExpression )
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // PsiInternalSimpleBeeLangTestLanguage.g:4334:3: ruleBlockExpressionWithoutBrackets
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
                    // PsiInternalSimpleBeeLangTestLanguage.g:4345:3: ruleExpression
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
            if ( state.backtracking>0 ) { memoize(input, 106, ruleOneOrManyExpressions_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleOneOrManyExpressions"


    // $ANTLR start "entryRuleBlockExpressionWithoutBrackets"
    // PsiInternalSimpleBeeLangTestLanguage.g:4359:1: entryRuleBlockExpressionWithoutBrackets : ruleBlockExpressionWithoutBrackets EOF ;
    public final void entryRuleBlockExpressionWithoutBrackets() throws RecognitionException {
        int entryRuleBlockExpressionWithoutBrackets_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4359:40: ( ruleBlockExpressionWithoutBrackets EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4360:2: ruleBlockExpressionWithoutBrackets EOF
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
            if ( state.backtracking>0 ) { memoize(input, 107, entryRuleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleBlockExpressionWithoutBrackets"


    // $ANTLR start "ruleBlockExpressionWithoutBrackets"
    // PsiInternalSimpleBeeLangTestLanguage.g:4365:1: ruleBlockExpressionWithoutBrackets : ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) ;
    public final void ruleBlockExpressionWithoutBrackets() throws RecognitionException {
        int ruleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4365:35: ( ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4366:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4366:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            // PsiInternalSimpleBeeLangTestLanguage.g:4367:3: () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4367:3: ()
            // PsiInternalSimpleBeeLangTestLanguage.g:4368:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBlockExpressionWithoutBrackets_ChainedExpressionAction_0ElementType());
              				doneComposite();
              			
            }

            }

            // PsiInternalSimpleBeeLangTestLanguage.g:4376:3: ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4377:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';'
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4377:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4378:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4378:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4379:6: lv_expressions_1_0= ruleTopLevelExpression
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
            if ( state.backtracking>0 ) { memoize(input, 108, ruleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleBlockExpressionWithoutBrackets"


    // $ANTLR start "entryRuleValueLiteral"
    // PsiInternalSimpleBeeLangTestLanguage.g:4400:1: entryRuleValueLiteral : ruleValueLiteral EOF ;
    public final void entryRuleValueLiteral() throws RecognitionException {
        int entryRuleValueLiteral_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4400:22: ( ruleValueLiteral EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4401:2: ruleValueLiteral EOF
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
            if ( state.backtracking>0 ) { memoize(input, 109, entryRuleValueLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleValueLiteral"


    // $ANTLR start "ruleValueLiteral"
    // PsiInternalSimpleBeeLangTestLanguage.g:4406:1: ruleValueLiteral : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final void ruleValueLiteral() throws RecognitionException {
        int ruleValueLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4406:17: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4407:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4407:2: ( (lv_value_0_0= RULE_STRING ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4408:3: (lv_value_0_0= RULE_STRING )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4408:3: (lv_value_0_0= RULE_STRING )
            // PsiInternalSimpleBeeLangTestLanguage.g:4409:4: lv_value_0_0= RULE_STRING
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
            if ( state.backtracking>0 ) { memoize(input, 110, ruleValueLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleValueLiteral"


    // $ANTLR start "entryRuleParanthesizedExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:4421:1: entryRuleParanthesizedExpression : ruleParanthesizedExpression EOF ;
    public final void entryRuleParanthesizedExpression() throws RecognitionException {
        int entryRuleParanthesizedExpression_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4421:33: ( ruleParanthesizedExpression EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4422:2: ruleParanthesizedExpression EOF
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
            if ( state.backtracking>0 ) { memoize(input, 111, entryRuleParanthesizedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleParanthesizedExpression"


    // $ANTLR start "ruleParanthesizedExpression"
    // PsiInternalSimpleBeeLangTestLanguage.g:4427:1: ruleParanthesizedExpression : (otherlv_0= '(' ruleExpression otherlv_2= ')' ) ;
    public final void ruleParanthesizedExpression() throws RecognitionException {
        int ruleParanthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4427:28: ( (otherlv_0= '(' ruleExpression otherlv_2= ')' ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4428:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4428:2: (otherlv_0= '(' ruleExpression otherlv_2= ')' )
            // PsiInternalSimpleBeeLangTestLanguage.g:4429:3: otherlv_0= '(' ruleExpression otherlv_2= ')'
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
            if ( state.backtracking>0 ) { memoize(input, 112, ruleParanthesizedExpression_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "ruleParanthesizedExpression"


    // $ANTLR start "entryRuleQID"
    // PsiInternalSimpleBeeLangTestLanguage.g:4457:1: entryRuleQID : ruleQID EOF ;
    public final void entryRuleQID() throws RecognitionException {
        int entryRuleQID_StartIndex = input.index();

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 113) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4459:2: ( ruleQID EOF )
            // PsiInternalSimpleBeeLangTestLanguage.g:4460:2: ruleQID EOF
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
            if ( state.backtracking>0 ) { memoize(input, 113, entryRuleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // PsiInternalSimpleBeeLangTestLanguage.g:4468:1: ruleQID : (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 114) ) { return ; }
            // PsiInternalSimpleBeeLangTestLanguage.g:4470:2: ( (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) )
            // PsiInternalSimpleBeeLangTestLanguage.g:4471:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            {
            // PsiInternalSimpleBeeLangTestLanguage.g:4471:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            // PsiInternalSimpleBeeLangTestLanguage.g:4472:3: this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalSimpleBeeLangTestLanguage.g:4479:3: (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )*
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4480:4: this_INT_1= RULE_INT
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4488:4: this_HEX_2= RULE_HEX
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4496:4: this_ID_3= RULE_ID
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

            // PsiInternalSimpleBeeLangTestLanguage.g:4504:3: (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==67) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4505:4: kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
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
            	    // PsiInternalSimpleBeeLangTestLanguage.g:4519:4: (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
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
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:4520:5: this_INT_6= RULE_INT
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
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:4528:5: this_HEX_7= RULE_HEX
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
            	    	    // PsiInternalSimpleBeeLangTestLanguage.g:4536:5: this_ID_8= RULE_ID
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
            if ( state.backtracking>0 ) { memoize(input, 114, ruleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleQID"

    // $ANTLR start synpred2_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred2_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:88:3: ( ( (lv_units_0_0= ruleUnit ) )* )
        // PsiInternalSimpleBeeLangTestLanguage.g:88:3: ( (lv_units_0_0= ruleUnit ) )*
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:88:3: ( (lv_units_0_0= ruleUnit ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_DOCUMENTATION||LA96_0==13) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // PsiInternalSimpleBeeLangTestLanguage.g:89:4: (lv_units_0_0= ruleUnit )
        	    {
        	    // PsiInternalSimpleBeeLangTestLanguage.g:89:4: (lv_units_0_0= ruleUnit )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:90:5: lv_units_0_0= ruleUnit
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
    // $ANTLR end synpred2_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred9_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred9_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:246:4: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:246:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:246:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:247:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:247:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:248:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
        // PsiInternalSimpleBeeLangTestLanguage.g:251:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:251:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:251:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:251:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_SourceKeyword_7_0_0ElementType());
          								
        }
        otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:265:9: ( (lv_sourceLocation_14_0= rulePath ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:266:10: (lv_sourceLocation_14_0= rulePath )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:266:10: (lv_sourceLocation_14_0= rulePath )
        // PsiInternalSimpleBeeLangTestLanguage.g:267:11: lv_sourceLocation_14_0= rulePath
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
    // $ANTLR end synpred9_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred10_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred10_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:289:4: ( ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:289:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:289:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:290:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:290:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:291:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
        // PsiInternalSimpleBeeLangTestLanguage.g:294:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:294:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:294:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:294:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_OutputKeyword_7_1_0ElementType());
          								
        }
        otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:308:9: ( (lv_outputLocation_18_0= rulePath ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:309:10: (lv_outputLocation_18_0= rulePath )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:309:10: (lv_outputLocation_18_0= rulePath )
        // PsiInternalSimpleBeeLangTestLanguage.g:310:11: lv_outputLocation_18_0= rulePath
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
    // $ANTLR end synpred10_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred11_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred11_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:337:10: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:337:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:337:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:337:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
          								
        }
        otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:351:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:352:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:352:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        // PsiInternalSimpleBeeLangTestLanguage.g:353:11: lv_providedCapabilities_22_0= ruleProvidedCapability
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
    // $ANTLR end synpred11_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred12_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred12_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:332:4: ( ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:332:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:333:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:333:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        // PsiInternalSimpleBeeLangTestLanguage.g:334:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
        // PsiInternalSimpleBeeLangTestLanguage.g:337:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
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
        	    // PsiInternalSimpleBeeLangTestLanguage.g:337:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred12_PsiInternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalSimpleBeeLangTestLanguage.g:337:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:337:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
        	      								
        	    }
        	    otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalSimpleBeeLangTestLanguage.g:351:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:352:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    {
        	    // PsiInternalSimpleBeeLangTestLanguage.g:352:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:353:11: lv_providedCapabilities_22_0= ruleProvidedCapability
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
    // $ANTLR end synpred12_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred13_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred13_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:380:10: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:380:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:380:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:380:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
          								
        }
        otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:394:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:395:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:395:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        // PsiInternalSimpleBeeLangTestLanguage.g:396:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
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
    // $ANTLR end synpred13_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred14_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred14_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:375:4: ( ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:375:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:375:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:376:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred14_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:376:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        // PsiInternalSimpleBeeLangTestLanguage.g:377:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
        // PsiInternalSimpleBeeLangTestLanguage.g:380:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
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
        	    // PsiInternalSimpleBeeLangTestLanguage.g:380:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred14_PsiInternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalSimpleBeeLangTestLanguage.g:380:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:380:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
        	      								
        	    }
        	    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalSimpleBeeLangTestLanguage.g:394:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:395:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    {
        	    // PsiInternalSimpleBeeLangTestLanguage.g:395:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:396:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
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
    // $ANTLR end synpred14_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred15_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred15_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:423:10: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:423:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:423:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:423:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
          								
        }
        otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:444:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:445:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:445:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        // PsiInternalSimpleBeeLangTestLanguage.g:446:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
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
    // $ANTLR end synpred15_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred16_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred16_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:418:4: ( ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:418:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:418:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:419:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:419:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        // PsiInternalSimpleBeeLangTestLanguage.g:420:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
        // PsiInternalSimpleBeeLangTestLanguage.g:423:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
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
        	    // PsiInternalSimpleBeeLangTestLanguage.g:423:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred16_PsiInternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalSimpleBeeLangTestLanguage.g:423:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:423:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
        	      								
        	    }
        	    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        	    otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalSimpleBeeLangTestLanguage.g:444:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:445:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    {
        	    // PsiInternalSimpleBeeLangTestLanguage.g:445:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:446:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
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
    // $ANTLR end synpred16_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred17_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred17_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:473:10: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:473:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:473:19: ( (lv_functions_33_0= ruleFunction ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:473:20: (lv_functions_33_0= ruleFunction )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:473:20: (lv_functions_33_0= ruleFunction )
        // PsiInternalSimpleBeeLangTestLanguage.g:474:10: lv_functions_33_0= ruleFunction
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
    // $ANTLR end synpred17_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred18_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred18_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:468:4: ( ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:468:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:468:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:469:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred18_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:469:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        // PsiInternalSimpleBeeLangTestLanguage.g:470:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
        // PsiInternalSimpleBeeLangTestLanguage.g:473:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
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
        	    // PsiInternalSimpleBeeLangTestLanguage.g:473:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred18_PsiInternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalSimpleBeeLangTestLanguage.g:473:19: ( (lv_functions_33_0= ruleFunction ) )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:473:20: (lv_functions_33_0= ruleFunction )
        	    {
        	    // PsiInternalSimpleBeeLangTestLanguage.g:473:20: (lv_functions_33_0= ruleFunction )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:474:10: lv_functions_33_0= ruleFunction
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
    // $ANTLR end synpred18_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred20_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred20_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:573:5: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:573:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:573:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:574:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:574:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:575:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
        // PsiInternalSimpleBeeLangTestLanguage.g:578:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:578:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:578:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:578:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_WhenKeyword_2_1_0_0ElementType());
          									
        }
        otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:592:10: ( (lv_condExpr_7_0= ruleExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:593:11: (lv_condExpr_7_0= ruleExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:593:11: (lv_condExpr_7_0= ruleExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:594:12: lv_condExpr_7_0= ruleExpression
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
    // $ANTLR end synpred20_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred21_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred21_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:616:5: ( ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:616:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:616:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:617:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:617:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:618:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
        // PsiInternalSimpleBeeLangTestLanguage.g:621:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:621:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:621:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:621:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_NameKeyword_2_1_1_0ElementType());
          									
        }
        otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:635:10: ( (lv_name_11_0= RULE_ID ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:636:11: (lv_name_11_0= RULE_ID )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:636:11: (lv_name_11_0= RULE_ID )
        // PsiInternalSimpleBeeLangTestLanguage.g:637:12: lv_name_11_0= RULE_ID
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
    // $ANTLR end synpred21_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred22_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred22_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:659:5: ( ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:659:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:659:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:660:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:660:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:661:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
        // PsiInternalSimpleBeeLangTestLanguage.g:664:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:664:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:664:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:664:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_VersionKeyword_2_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:678:10: ( (lv_version_15_0= RULE_ID ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:679:11: (lv_version_15_0= RULE_ID )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:679:11: (lv_version_15_0= RULE_ID )
        // PsiInternalSimpleBeeLangTestLanguage.g:680:12: lv_version_15_0= RULE_ID
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
    // $ANTLR end synpred22_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred26_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred26_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:811:5: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:811:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:811:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:812:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:812:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:813:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalSimpleBeeLangTestLanguage.g:816:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:816:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:816:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:816:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:830:10: ( (lv_condExpr_9_0= ruleExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:831:11: (lv_condExpr_9_0= ruleExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:831:11: (lv_condExpr_9_0= ruleExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:832:12: lv_condExpr_9_0= ruleExpression
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
    // $ANTLR end synpred26_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred27_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred27_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:854:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:854:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:854:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:855:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:855:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:856:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalSimpleBeeLangTestLanguage.g:859:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:859:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:859:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:859:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:859:21: ( (lv_greedy_11_0= 'greedy' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:860:11: (lv_greedy_11_0= 'greedy' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:860:11: (lv_greedy_11_0= 'greedy' )
        // PsiInternalSimpleBeeLangTestLanguage.g:861:12: lv_greedy_11_0= 'greedy'
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
    // $ANTLR end synpred27_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred28_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred28_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:883:5: ( ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:883:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:883:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:884:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:884:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:885:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalSimpleBeeLangTestLanguage.g:888:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:888:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:888:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:888:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:902:10: ( (lv_min_15_0= RULE_INT ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:903:11: (lv_min_15_0= RULE_INT )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:903:11: (lv_min_15_0= RULE_INT )
        // PsiInternalSimpleBeeLangTestLanguage.g:904:12: lv_min_15_0= RULE_INT
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
    // $ANTLR end synpred28_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred29_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred29_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:926:5: ( ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:926:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:926:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:927:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:927:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:928:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalSimpleBeeLangTestLanguage.g:931:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:931:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:931:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:931:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:945:10: ( (lv_max_19_0= RULE_INT ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:946:11: (lv_max_19_0= RULE_INT )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:946:11: (lv_max_19_0= RULE_INT )
        // PsiInternalSimpleBeeLangTestLanguage.g:947:12: lv_max_19_0= RULE_INT
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
    // $ANTLR end synpred29_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred30_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred30_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:969:5: ( ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:970:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:970:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:971:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalSimpleBeeLangTestLanguage.g:974:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:974:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:974:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:974:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_21=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:988:10: ( (lv_versionRange_23_0= RULE_ID ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:989:11: (lv_versionRange_23_0= RULE_ID )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:989:11: (lv_versionRange_23_0= RULE_ID )
        // PsiInternalSimpleBeeLangTestLanguage.g:990:12: lv_versionRange_23_0= RULE_ID
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
    // $ANTLR end synpred30_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred32_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred32_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:1109:5: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1109:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1109:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1110:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1110:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1111:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalSimpleBeeLangTestLanguage.g:1114:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1114:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1114:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:1114:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:1128:10: ( (lv_condExpr_8_0= ruleExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1129:11: (lv_condExpr_8_0= ruleExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1129:11: (lv_condExpr_8_0= ruleExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:1130:12: lv_condExpr_8_0= ruleExpression
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
    // $ANTLR end synpred32_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred33_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred33_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:1152:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1152:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1152:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1153:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1153:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1154:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalSimpleBeeLangTestLanguage.g:1157:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1157:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1157:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:1157:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1157:21: ( (lv_greedy_10_0= 'greedy' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1158:11: (lv_greedy_10_0= 'greedy' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1158:11: (lv_greedy_10_0= 'greedy' )
        // PsiInternalSimpleBeeLangTestLanguage.g:1159:12: lv_greedy_10_0= 'greedy'
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
    // $ANTLR end synpred33_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred34_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred34_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:1181:5: ( ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1181:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1181:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1182:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1182:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1183:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalSimpleBeeLangTestLanguage.g:1186:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1186:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1186:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:1186:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:1200:10: ( (lv_min_14_0= RULE_INT ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1201:11: (lv_min_14_0= RULE_INT )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1201:11: (lv_min_14_0= RULE_INT )
        // PsiInternalSimpleBeeLangTestLanguage.g:1202:12: lv_min_14_0= RULE_INT
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
    // $ANTLR end synpred34_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred35_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred35_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:1224:5: ( ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1224:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1224:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1225:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1225:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1226:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalSimpleBeeLangTestLanguage.g:1229:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1229:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1229:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:1229:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_16=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:1243:10: ( (lv_max_18_0= RULE_INT ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1244:11: (lv_max_18_0= RULE_INT )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1244:11: (lv_max_18_0= RULE_INT )
        // PsiInternalSimpleBeeLangTestLanguage.g:1245:12: lv_max_18_0= RULE_INT
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
    // $ANTLR end synpred35_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred36_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred36_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:1267:5: ( ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1267:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1267:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1268:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1268:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1269:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalSimpleBeeLangTestLanguage.g:1272:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1272:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalSimpleBeeLangTestLanguage", "true");
        }
        // PsiInternalSimpleBeeLangTestLanguage.g:1272:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        // PsiInternalSimpleBeeLangTestLanguage.g:1272:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:1286:10: ( (lv_versionRange_22_0= RULE_ID ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:1287:11: (lv_versionRange_22_0= RULE_ID )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:1287:11: (lv_versionRange_22_0= RULE_ID )
        // PsiInternalSimpleBeeLangTestLanguage.g:1288:12: lv_versionRange_22_0= RULE_ID
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
    // $ANTLR end synpred36_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred42_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred42_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:1456:3: ( ruleClosureParameter )
        // PsiInternalSimpleBeeLangTestLanguage.g:1456:3: ruleClosureParameter
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
    // $ANTLR end synpred42_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred69_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred69_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:2000:3: ( ruleVarDeclaration )
        // PsiInternalSimpleBeeLangTestLanguage.g:2000:3: ruleVarDeclaration
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
    // $ANTLR end synpred69_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred71_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred71_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:2075:4: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2075:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2075:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:2076:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalSimpleBeeLangTestLanguage.g:2084:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2085:5: (lv_functionName_2_0= ruleAssignmentOperator )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2085:5: (lv_functionName_2_0= ruleAssignmentOperator )
        // PsiInternalSimpleBeeLangTestLanguage.g:2086:6: lv_functionName_2_0= ruleAssignmentOperator
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

        // PsiInternalSimpleBeeLangTestLanguage.g:2095:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2096:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2096:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:2097:6: lv_rightExpr_3_0= ruleAssignmentExpression
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
    // $ANTLR end synpred71_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred85_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred85_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:2589:4: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2589:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2589:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:2590:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:2605:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2606:5: (lv_rightExpr_3_0= ruleAndExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2606:5: (lv_rightExpr_3_0= ruleAndExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:2607:6: lv_rightExpr_3_0= ruleAndExpression
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
    // $ANTLR end synpred85_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred86_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred86_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:2640:4: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2640:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2640:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:2641:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:2656:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2657:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2657:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:2658:6: lv_rightExpr_3_0= ruleRelationalExpression
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
    // $ANTLR end synpred86_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred87_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred87_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:2691:4: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2691:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2691:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:2692:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalSimpleBeeLangTestLanguage.g:2700:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2701:5: (lv_functionName_2_0= ruleRelationalOperator )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2701:5: (lv_functionName_2_0= ruleRelationalOperator )
        // PsiInternalSimpleBeeLangTestLanguage.g:2702:6: lv_functionName_2_0= ruleRelationalOperator
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

        // PsiInternalSimpleBeeLangTestLanguage.g:2711:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2712:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2712:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:2713:6: lv_rightExpr_3_0= ruleAdditiveExpression
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
    // $ANTLR end synpred87_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred89_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred89_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:2746:4: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2746:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2746:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:2747:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalSimpleBeeLangTestLanguage.g:2755:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2756:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2756:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2757:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2757:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
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
                // PsiInternalSimpleBeeLangTestLanguage.g:2758:7: lv_functionName_2_1= '+'
                {
                lv_functionName_2_1=(Token)match(input,59,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalSimpleBeeLangTestLanguage.g:2766:7: lv_functionName_2_2= '-'
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

        // PsiInternalSimpleBeeLangTestLanguage.g:2776:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2777:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2777:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:2778:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
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
    // $ANTLR end synpred89_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred92_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred92_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:2811:4: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2811:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2811:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:2812:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalSimpleBeeLangTestLanguage.g:2820:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2821:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2821:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2822:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2822:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
                // PsiInternalSimpleBeeLangTestLanguage.g:2823:7: lv_functionName_2_1= '*'
                {
                lv_functionName_2_1=(Token)match(input,61,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalSimpleBeeLangTestLanguage.g:2831:7: lv_functionName_2_2= '/'
                {
                lv_functionName_2_2=(Token)match(input,32,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 3 :
                // PsiInternalSimpleBeeLangTestLanguage.g:2839:7: lv_functionName_2_3= '%'
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

        // PsiInternalSimpleBeeLangTestLanguage.g:2849:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2850:5: (lv_rightExpr_3_0= ruleSetExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2850:5: (lv_rightExpr_3_0= ruleSetExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:2851:6: lv_rightExpr_3_0= ruleSetExpression
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
    // $ANTLR end synpred92_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred93_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred93_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:2884:4: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2884:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2884:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:2885:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalSimpleBeeLangTestLanguage.g:2893:4: ( (lv_functionName_2_0= '..' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2894:5: (lv_functionName_2_0= '..' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2894:5: (lv_functionName_2_0= '..' )
        // PsiInternalSimpleBeeLangTestLanguage.g:2895:6: lv_functionName_2_0= '..'
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSetExpression_FunctionNameFullStopFullStopKeyword_1_1_0ElementType());
          					
        }
        lv_functionName_2_0=(Token)match(input,63,FollowSets000.FOLLOW_19); if (state.failed) return ;

        }


        }

        // PsiInternalSimpleBeeLangTestLanguage.g:2904:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:2905:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:2905:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:2906:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
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
    // $ANTLR end synpred93_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred99_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred99_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:3089:4: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3089:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3089:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:3090:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalSimpleBeeLangTestLanguage.g:3098:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3099:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3099:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3100:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3100:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
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
                // PsiInternalSimpleBeeLangTestLanguage.g:3101:7: lv_functionName_2_1= '--'
                {
                lv_functionName_2_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalSimpleBeeLangTestLanguage.g:3109:7: lv_functionName_2_2= '++'
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
    // $ANTLR end synpred99_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred101_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred101_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:3143:4: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3143:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3143:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        // PsiInternalSimpleBeeLangTestLanguage.g:3144:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3144:5: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:3145:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:3160:5: ( (lv_name_3_0= RULE_ID ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3161:6: (lv_name_3_0= RULE_ID )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3161:6: (lv_name_3_0= RULE_ID )
        // PsiInternalSimpleBeeLangTestLanguage.g:3162:7: lv_name_3_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          							markLeaf(elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType());
          						
        }
        lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:3178:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==RULE_ID||LA114_0==RULE_STRING||LA114_0==13||(LA114_0>=17 && LA114_0<=18)||LA114_0==21||(LA114_0>=35 && LA114_0<=36)||LA114_0==52||LA114_0==56||LA114_0==60||(LA114_0>=64 && LA114_0<=66)||LA114_0==70||(LA114_0>=72 && LA114_0<=77)) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // PsiInternalSimpleBeeLangTestLanguage.g:3179:6: (lv_parameterList_5_0= ruleParameterList )
                {
                // PsiInternalSimpleBeeLangTestLanguage.g:3179:6: (lv_parameterList_5_0= ruleParameterList )
                // PsiInternalSimpleBeeLangTestLanguage.g:3180:7: lv_parameterList_5_0= ruleParameterList
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
    // $ANTLR end synpred101_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred102_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred102_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token otherlv_10=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:3198:4: ( ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3198:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3198:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        // PsiInternalSimpleBeeLangTestLanguage.g:3199:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3199:5: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:3200:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_8=(Token)match(input,68,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:3215:5: ( (lv_indexExpr_9_0= ruleExpression ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3216:6: (lv_indexExpr_9_0= ruleExpression )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3216:6: (lv_indexExpr_9_0= ruleExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:3217:7: lv_indexExpr_9_0= ruleExpression
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
    // $ANTLR end synpred102_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred103_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred103_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:3235:4: ( ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3235:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3235:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3236:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3236:5: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:3237:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_12=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:3252:5: ( (lv_featureName_13_0= RULE_ID ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3253:6: (lv_featureName_13_0= RULE_ID )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3253:6: (lv_featureName_13_0= RULE_ID )
        // PsiInternalSimpleBeeLangTestLanguage.g:3254:7: lv_featureName_13_0= RULE_ID
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
    // $ANTLR end synpred103_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred105_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred105_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:3288:4: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
        // PsiInternalSimpleBeeLangTestLanguage.g:3288:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3288:4: ()
        // PsiInternalSimpleBeeLangTestLanguage.g:3289:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:3304:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==RULE_ID||LA115_0==RULE_STRING||LA115_0==13||(LA115_0>=17 && LA115_0<=18)||LA115_0==21||(LA115_0>=35 && LA115_0<=36)||LA115_0==52||LA115_0==56||LA115_0==60||(LA115_0>=64 && LA115_0<=66)||LA115_0==70||(LA115_0>=72 && LA115_0<=77)) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // PsiInternalSimpleBeeLangTestLanguage.g:3305:5: (lv_parameterList_3_0= ruleParameterList )
                {
                // PsiInternalSimpleBeeLangTestLanguage.g:3305:5: (lv_parameterList_3_0= ruleParameterList )
                // PsiInternalSimpleBeeLangTestLanguage.g:3306:6: lv_parameterList_3_0= ruleParameterList
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
    // $ANTLR end synpred105_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred106_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred106_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:3335:3: ( ruleFeatureCall )
        // PsiInternalSimpleBeeLangTestLanguage.g:3335:3: ruleFeatureCall
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
    // $ANTLR end synpred106_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred108_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred108_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:3357:3: ( ruleValue )
        // PsiInternalSimpleBeeLangTestLanguage.g:3357:3: ruleValue
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
    // $ANTLR end synpred108_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred109_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred109_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:3368:3: ( ruleLiteral )
        // PsiInternalSimpleBeeLangTestLanguage.g:3368:3: ruleLiteral
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
    // $ANTLR end synpred109_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred112_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred112_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:3401:3: ( ruleBlockExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:3401:3: ruleBlockExpression
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
    // $ANTLR end synpred112_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred113_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred113_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:3412:3: ( ruleWithExpression )
        // PsiInternalSimpleBeeLangTestLanguage.g:3412:3: ruleWithExpression
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
    // $ANTLR end synpred113_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred127_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred127_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:3889:4: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )
        // PsiInternalSimpleBeeLangTestLanguage.g:3889:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
          			
        }
        otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:3896:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==RULE_STRING||LA117_0==13||(LA117_0>=17 && LA117_0<=18)||LA117_0==21||(LA117_0>=35 && LA117_0<=36)||LA117_0==52||LA117_0==56||LA117_0==60||(LA117_0>=64 && LA117_0<=66)||LA117_0==70||(LA117_0>=72 && LA117_0<=77)) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // PsiInternalSimpleBeeLangTestLanguage.g:3897:5: (lv_parameterList_4_0= ruleParameterList )
                {
                // PsiInternalSimpleBeeLangTestLanguage.g:3897:5: (lv_parameterList_4_0= ruleParameterList )
                // PsiInternalSimpleBeeLangTestLanguage.g:3898:6: lv_parameterList_4_0= ruleParameterList
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
    // $ANTLR end synpred127_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred128_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred128_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:3916:4: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3916:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
          			
        }
        otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalSimpleBeeLangTestLanguage.g:3923:4: ( (lv_alias_7_0= RULE_ID ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:3924:5: (lv_alias_7_0= RULE_ID )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:3924:5: (lv_alias_7_0= RULE_ID )
        // PsiInternalSimpleBeeLangTestLanguage.g:3925:6: lv_alias_7_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getConstructorCallExpression_AliasIDTerminalRuleCall_4_1_0ElementType());
          					
        }
        lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred128_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred135_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred135_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;

        // PsiInternalSimpleBeeLangTestLanguage.g:4203:4: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:4203:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:4203:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:4204:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:4204:5: (otherlv_4= '|' )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==77) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // PsiInternalSimpleBeeLangTestLanguage.g:4205:6: otherlv_4= '|'
                {
                otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }
                break;

        }

        // PsiInternalSimpleBeeLangTestLanguage.g:4213:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        // PsiInternalSimpleBeeLangTestLanguage.g:4214:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:4214:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
        // PsiInternalSimpleBeeLangTestLanguage.g:4215:7: (lv_parameters_5_0= ruleParameterDeclaration )
        {
        // PsiInternalSimpleBeeLangTestLanguage.g:4215:7: (lv_parameters_5_0= ruleParameterDeclaration )
        // PsiInternalSimpleBeeLangTestLanguage.g:4216:8: lv_parameters_5_0= ruleParameterDeclaration
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

        // PsiInternalSimpleBeeLangTestLanguage.g:4225:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
        	    // PsiInternalSimpleBeeLangTestLanguage.g:4226:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    {
        	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
        	    // PsiInternalSimpleBeeLangTestLanguage.g:4233:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:4234:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    {
        	    // PsiInternalSimpleBeeLangTestLanguage.g:4234:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    // PsiInternalSimpleBeeLangTestLanguage.g:4235:9: lv_parameters_7_0= ruleParameterDeclaration
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

        // PsiInternalSimpleBeeLangTestLanguage.g:4245:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==16) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // PsiInternalSimpleBeeLangTestLanguage.g:4246:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                {
                otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                // PsiInternalSimpleBeeLangTestLanguage.g:4253:7: ( (lv_varArgs_9_0= '...' ) )
                // PsiInternalSimpleBeeLangTestLanguage.g:4254:8: (lv_varArgs_9_0= '...' )
                {
                // PsiInternalSimpleBeeLangTestLanguage.g:4254:8: (lv_varArgs_9_0= '...' )
                // PsiInternalSimpleBeeLangTestLanguage.g:4255:9: lv_varArgs_9_0= '...'
                {
                if ( state.backtracking==0 ) {

                  									markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0ElementType());
                  								
                }
                lv_varArgs_9_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }


                }

                // PsiInternalSimpleBeeLangTestLanguage.g:4264:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                // PsiInternalSimpleBeeLangTestLanguage.g:4265:8: (lv_parameters_10_0= ruleParameterDeclaration )
                {
                // PsiInternalSimpleBeeLangTestLanguage.g:4265:8: (lv_parameters_10_0= ruleParameterDeclaration )
                // PsiInternalSimpleBeeLangTestLanguage.g:4266:9: lv_parameters_10_0= ruleParameterDeclaration
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
    // $ANTLR end synpred135_PsiInternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred137_PsiInternalSimpleBeeLangTestLanguage
    public final void synpred137_PsiInternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        // PsiInternalSimpleBeeLangTestLanguage.g:4334:3: ( ruleBlockExpressionWithoutBrackets )
        // PsiInternalSimpleBeeLangTestLanguage.g:4334:3: ruleBlockExpressionWithoutBrackets
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
    // $ANTLR end synpred137_PsiInternalSimpleBeeLangTestLanguage

}

@SuppressWarnings("all")
public class PsiInternalSimpleBeeLangTestLanguageParser extends PsiInternalSimpleBeeLangTestLanguageParser3 {



        public PsiInternalSimpleBeeLangTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSimpleBeeLangTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[259+1];
             
             
        }
        


    	public PsiInternalSimpleBeeLangTestLanguageParser(PsiBuilder builder, TokenStream input, SimpleBeeLangTestLanguageElementTypeProvider elementTypeProvider, SimpleBeeLangTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}
}
