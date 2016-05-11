package org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.testlanguages.backtracking.services.ExBeeLangTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
interface PsiInternalExBeeLangTestLanguageParserSignatures {
     Boolean entryRuleDelegateModel() throws RecognitionException;
     Boolean ruleDelegateModel() throws RecognitionException;
     Boolean entryRuleModel() throws RecognitionException;
     Boolean ruleModel() throws RecognitionException;
     Boolean entryRuleUnit() throws RecognitionException;
     Boolean ruleUnit() throws RecognitionException;
     Boolean entryRuleProvidedCapability() throws RecognitionException;
     Boolean ruleProvidedCapability() throws RecognitionException;
     Boolean entryRuleAliasedRequiredCapability() throws RecognitionException;
     Boolean ruleAliasedRequiredCapability() throws RecognitionException;
     Boolean entryRuleRequiredCapability() throws RecognitionException;
     Boolean ruleRequiredCapability() throws RecognitionException;
     Boolean entryRulePath() throws RecognitionException;
     Boolean rulePath() throws RecognitionException;
     Boolean entryRuleParameterList() throws RecognitionException;
     Boolean ruleParameterList() throws RecognitionException;
     Boolean entryRuleFirstParameter() throws RecognitionException;
     Boolean ruleFirstParameter() throws RecognitionException;
     Boolean entryRuleParameter() throws RecognitionException;
     Boolean ruleParameter() throws RecognitionException;
     Boolean entryRuleClosureParameter() throws RecognitionException;
     Boolean ruleClosureParameter() throws RecognitionException;
     Boolean entryRuleParameterDeclaration() throws RecognitionException;
     Boolean ruleParameterDeclaration() throws RecognitionException;
     Boolean entryRuleFunction() throws RecognitionException;
     Boolean ruleFunction() throws RecognitionException;
     Boolean entryRuleGuardExpression() throws RecognitionException;
     Boolean ruleGuardExpression() throws RecognitionException;
     Boolean entryRuleAssignmentOperator() throws RecognitionException;
     Boolean ruleAssignmentOperator() throws RecognitionException;
     Boolean entryRuleRelationalOperator() throws RecognitionException;
     Boolean ruleRelationalOperator() throws RecognitionException;
     Boolean entryRuleTopLevelExpression() throws RecognitionException;
     Boolean ruleTopLevelExpression() throws RecognitionException;
     Boolean entryRuleExpression() throws RecognitionException;
     Boolean ruleExpression() throws RecognitionException;
     Boolean entryRuleAssignmentExpression() throws RecognitionException;
     Boolean ruleAssignmentExpression() throws RecognitionException;
     Boolean entryRuleVarDeclaration() throws RecognitionException;
     Boolean ruleVarDeclaration() throws RecognitionException;
     Boolean entryRuleValDeclaration() throws RecognitionException;
     Boolean ruleValDeclaration() throws RecognitionException;
     Boolean entryRuleTypeRef() throws RecognitionException;
     Boolean ruleTypeRef() throws RecognitionException;
     Boolean entryRuleSimpleTypeRef() throws RecognitionException;
     Boolean ruleSimpleTypeRef() throws RecognitionException;
     Boolean entryRuleClosureTypeRef() throws RecognitionException;
     Boolean ruleClosureTypeRef() throws RecognitionException;
     Boolean entryRuleCachedExpression() throws RecognitionException;
     Boolean ruleCachedExpression() throws RecognitionException;
     Boolean entryRuleOrExpression() throws RecognitionException;
     Boolean ruleOrExpression() throws RecognitionException;
     Boolean entryRuleAndExpression() throws RecognitionException;
     Boolean ruleAndExpression() throws RecognitionException;
     Boolean entryRuleRelationalExpression() throws RecognitionException;
     Boolean ruleRelationalExpression() throws RecognitionException;
     Boolean entryRuleAdditiveExpression() throws RecognitionException;
     Boolean ruleAdditiveExpression() throws RecognitionException;
     Boolean entryRuleMultiplicativeExpression() throws RecognitionException;
     Boolean ruleMultiplicativeExpression() throws RecognitionException;
     Boolean entryRuleSetExpression() throws RecognitionException;
     Boolean ruleSetExpression() throws RecognitionException;
     Boolean entryRuleUnaryOrInfixExpression() throws RecognitionException;
     Boolean ruleUnaryOrInfixExpression() throws RecognitionException;
     Boolean entryRuleUnaryExpression() throws RecognitionException;
     Boolean ruleUnaryExpression() throws RecognitionException;
     Boolean entryRulePreopExpression() throws RecognitionException;
     Boolean rulePreopExpression() throws RecognitionException;
     Boolean entryRulePostopExpression() throws RecognitionException;
     Boolean rulePostopExpression() throws RecognitionException;
     Boolean entryRuleInfixExpression() throws RecognitionException;
     Boolean ruleInfixExpression() throws RecognitionException;
     Boolean entryRuleCallExpression() throws RecognitionException;
     Boolean ruleCallExpression() throws RecognitionException;
     Boolean entryRulePrimaryExpression() throws RecognitionException;
     Boolean rulePrimaryExpression() throws RecognitionException;
     Boolean entryRuleWithExpression() throws RecognitionException;
     Boolean ruleWithExpression() throws RecognitionException;
     Boolean entryRuleWithContextExpression() throws RecognitionException;
     Boolean ruleWithContextExpression() throws RecognitionException;
     Boolean entryRuleBlockExpression() throws RecognitionException;
     Boolean ruleBlockExpression() throws RecognitionException;
     Boolean entryRuleValue() throws RecognitionException;
     Boolean ruleValue() throws RecognitionException;
     Boolean entryRuleKeywordVariables() throws RecognitionException;
     Boolean ruleKeywordVariables() throws RecognitionException;
     Boolean entryRuleFeatureCall() throws RecognitionException;
     Boolean ruleFeatureCall() throws RecognitionException;
     Boolean entryRuleOperationCall() throws RecognitionException;
     Boolean ruleOperationCall() throws RecognitionException;
     Boolean entryRuleConstructorCallExpression() throws RecognitionException;
     Boolean ruleConstructorCallExpression() throws RecognitionException;
     Boolean entryRuleInitializationBlockExpression() throws RecognitionException;
     Boolean ruleInitializationBlockExpression() throws RecognitionException;
     Boolean entryRuleInitializationExpression() throws RecognitionException;
     Boolean ruleInitializationExpression() throws RecognitionException;
     Boolean entryRuleFeatureOfThis() throws RecognitionException;
     Boolean ruleFeatureOfThis() throws RecognitionException;
     Boolean entryRuleLiteral() throws RecognitionException;
     Boolean ruleLiteral() throws RecognitionException;
     Boolean entryRuleLiteralFunction() throws RecognitionException;
     Boolean ruleLiteralFunction() throws RecognitionException;
     Boolean entryRuleClosureExpression() throws RecognitionException;
     Boolean ruleClosureExpression() throws RecognitionException;
     Boolean entryRuleOneOrManyExpressions() throws RecognitionException;
     Boolean ruleOneOrManyExpressions() throws RecognitionException;
     Boolean entryRuleBlockExpressionWithoutBrackets() throws RecognitionException;
     Boolean ruleBlockExpressionWithoutBrackets() throws RecognitionException;
     Boolean entryRuleValueLiteral() throws RecognitionException;
     Boolean ruleValueLiteral() throws RecognitionException;
     Boolean entryRuleParanthesizedExpression() throws RecognitionException;
     Boolean ruleParanthesizedExpression() throws RecognitionException;
     Boolean entryRuleQID() throws RecognitionException;
     Boolean ruleQID() throws RecognitionException;
     void synpred2_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred9_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred10_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred11_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred12_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred13_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred14_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred15_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred16_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred17_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred18_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred20_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred21_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred22_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred26_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred27_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred28_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred29_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred30_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred32_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred33_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred34_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred35_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred36_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred42_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred69_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred71_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred85_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred86_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred87_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred89_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred92_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred93_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred99_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred101_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred102_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred103_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred105_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred106_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred108_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred109_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred112_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred113_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred127_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred128_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred135_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred137_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException;   
}

@SuppressWarnings("all")
abstract class PsiInternalExBeeLangTestLanguageParser1 extends AbstractPsiAntlrParser implements PsiInternalExBeeLangTestLanguageParserSignatures {

        PsiInternalExBeeLangTestLanguageParser1(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalExBeeLangTestLanguageParser1(TokenStream input, RecognizerSharedState state) {
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
    public static final int T__15=15;
    public static final int T__52=52;
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


    public String[] getTokenNames() { return PsiInternalExBeeLangTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalExBeeLangTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected ExBeeLangTestLanguageGrammarAccess grammarAccess;

    	protected ExBeeLangTestLanguageElementTypeProvider elementTypeProvider;



    	@Override
    	protected String getFirstRuleName() {
    		return "DelegateModel";
    	}





    // Delegated rules

    public final boolean synpred113_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_PsiInternalExBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_PsiInternalExBeeLangTestLanguage_fragment(); // can never throw exception
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
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\4\uffff\1\23\6\uffff";
    static final String dfa_3s = "\1\42\4\uffff\1\30\6\uffff";
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\1\3\1\uffff\4\6\1\5\1\4";
    static final String dfa_5s = "\1\0\4\uffff\1\1\6\uffff}>";
    static final String[] dfa_6s = {
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

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 287:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
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
                    case 1 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA13_5 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {s = 10;}

                        else if ( LA13_5 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {s = 11;}

                         
                        input.seek(index13_5);
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
    static final String dfa_7s = "\56\uffff";
    static final String dfa_8s = "\3\uffff\1\4\4\uffff\2\4\12\uffff\2\4\4\uffff\1\4\12\uffff\2\4\7\uffff";
    static final String dfa_9s = "\1\5\1\uffff\2\5\1\uffff\1\20\2\5\2\20\2\5\1\0\3\5\1\0\1\20\1\5\1\67\1\5\2\20\1\5\1\67\1\5\1\20\1\45\4\5\1\45\2\5\1\20\2\5\2\20\2\5\1\45\1\0\1\45\1\0";
    static final String dfa_10s = "\1\115\1\uffff\1\114\1\115\1\uffff\1\104\1\114\1\115\2\104\1\43\1\114\1\0\1\115\1\114\1\45\1\0\1\104\1\5\1\67\2\115\1\45\1\5\1\67\1\44\1\104\1\45\1\5\1\115\1\114\1\44\1\45\2\5\1\45\1\5\2\115\1\45\2\5\1\45\1\0\1\45\1\0";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\2\51\uffff";
    static final String dfa_12s = "\14\uffff\1\2\3\uffff\1\1\32\uffff\1\3\1\uffff\1\0}>";
    static final String[] dfa_13s = {
            "\1\3\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\2\1\1\17\uffff\1\1\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4\1\1",
            "",
            "\1\5\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\2\1\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\1\12\uffff\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\17\4\1\6\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "",
            "\1\1\17\uffff\1\4\2\uffff\1\4\1\uffff\1\10\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\11\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\14\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\13\1\12\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\1\1\uffff\7\4\1\uffff\4\4",
            "\1\15\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\16\1\4\4\uffff\7\4\1\uffff\4\4",
            "\1\20\35\uffff\1\17",
            "\1\21\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\22\1\23\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\uffff",
            "\1\24\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\25\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\26\36\uffff\1\27\1\30",
            "\1\uffff",
            "\1\31\17\uffff\1\4\2\uffff\1\4\1\uffff\1\32\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\33",
            "\1\34",
            "\1\4\12\uffff\1\35\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\36\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\37\24\uffff\1\30",
            "\1\40",
            "\1\41",
            "\1\43\36\uffff\1\42",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\34\1\uffff\7\4\1\uffff\4\4",
            "\1\23",
            "\1\44",
            "\1\45\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\46\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\47\36\uffff\1\50",
            "\1\30",
            "\1\51",
            "\1\52",
            "\1\31\24\uffff\1\23",
            "\1\53",
            "\1\4\12\uffff\1\35\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\36\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\37\24\uffff\1\30",
            "\1\54",
            "\1\55",
            "\1\23",
            "\1\uffff",
            "\1\30",
            "\1\uffff"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1651:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_45 = input.LA(1);

                         
                        int index27_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_45);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_16 = input.LA(1);

                         
                        int index27_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_16);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_12 = input.LA(1);

                         
                        int index27_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_43 = input.LA(1);

                         
                        int index27_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_43);
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
    static final String dfa_14s = "\15\uffff";
    static final String dfa_15s = "\4\uffff\1\6\4\uffff\2\6\2\uffff";
    static final String dfa_16s = "\2\5\1\uffff\2\5\2\uffff\1\20\1\5\1\24\1\20\1\5\1\0";
    static final String dfa_17s = "\1\114\1\66\1\uffff\1\114\1\104\2\uffff\1\104\1\114\2\104\1\114\1\0";
    static final String dfa_18s = "\2\uffff\1\1\2\uffff\1\2\1\3\6\uffff";
    static final String dfa_19s = "\14\uffff\1\0}>";
    static final String[] dfa_20s = {
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

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "2307:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )";
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
                        if ( (synpred69_PsiInternalExBeeLangTestLanguage()) ) {s = 2;}

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
    static final String dfa_21s = "\1\1\13\uffff";
    static final String dfa_22s = "\1\20\1\uffff\11\0\1\uffff";
    static final String dfa_23s = "\1\105\1\uffff\11\0\1\uffff";
    static final String dfa_24s = "\1\uffff\1\2\11\uffff\1\1";
    static final String dfa_25s = "\2\uffff\1\3\1\2\1\4\1\5\1\7\1\10\1\0\1\1\1\6\1\uffff}>";
    static final String[] dfa_26s = {
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
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_1;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "()* loopback of 3163:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalExBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_7);
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
    static final String dfa_27s = "\23\uffff";
    static final String dfa_28s = "\1\5\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String dfa_29s = "\1\114\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String dfa_30s = "\2\uffff\1\2\1\4\1\uffff\1\5\6\uffff\1\6\1\uffff\1\1\1\3\1\7\1\10\1\11";
    static final String dfa_31s = "\1\uffff\1\0\2\uffff\1\1\10\uffff\1\2\5\uffff}>";
    static final String[] dfa_32s = {
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

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "3971:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )";
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
                        if ( (synpred106_PsiInternalExBeeLangTestLanguage()) ) {s = 14;}

                        else if ( (synpred108_PsiInternalExBeeLangTestLanguage()) ) {s = 15;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_4 = input.LA(1);

                         
                        int index73_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_PsiInternalExBeeLangTestLanguage()) ) {s = 3;}

                        else if ( (synpred112_PsiInternalExBeeLangTestLanguage()) ) {s = 16;}

                         
                        input.seek(index73_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_13 = input.LA(1);

                         
                        int index73_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_PsiInternalExBeeLangTestLanguage()) ) {s = 17;}

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
    static final String dfa_33s = "\46\uffff";
    static final String dfa_34s = "\1\2\45\uffff";
    static final String dfa_35s = "\1\20\1\0\44\uffff";
    static final String dfa_36s = "\1\105\1\0\44\uffff";
    static final String dfa_37s = "\2\uffff\1\2\42\uffff\1\1";
    static final String dfa_38s = "\1\uffff\1\0\44\uffff}>";
    static final String[] dfa_39s = {
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

    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_33;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "4658:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?";
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
                        if ( (synpred127_PsiInternalExBeeLangTestLanguage()) ) {s = 37;}

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
    static final String dfa_40s = "\72\uffff";
    static final String dfa_41s = "\6\uffff\1\4\7\uffff\1\4\2\uffff\1\4\16\uffff\2\4\1\uffff\1\4\15\uffff\2\4\7\uffff";
    static final String dfa_42s = "\2\5\3\uffff\2\5\1\20\1\5\1\67\1\5\1\20\2\5\1\20\1\45\1\5\1\20\1\5\1\0\1\5\1\20\4\5\1\20\1\5\1\67\1\5\1\0\1\45\1\5\1\20\1\5\1\20\1\45\1\5\1\20\1\5\1\67\2\5\1\20\3\5\1\45\1\5\1\20\1\5\1\45\1\0\1\20\2\5\1\45\1\0";
    static final String dfa_43s = "\1\115\1\114\3\uffff\1\114\1\115\1\104\1\5\1\67\1\114\2\115\1\44\1\104\1\45\1\5\1\104\1\114\1\0\1\43\1\45\2\5\1\115\1\114\1\104\1\5\1\67\1\45\1\0\1\45\2\115\1\44\1\104\1\45\1\5\1\45\1\5\1\67\1\114\1\115\1\45\2\5\1\44\1\45\1\5\2\115\1\45\1\0\1\45\2\5\1\45\1\0";
    static final String dfa_44s = "\2\uffff\1\1\1\2\1\3\65\uffff";
    static final String dfa_45s = "\23\uffff\1\0\12\uffff\1\3\25\uffff\1\2\4\uffff\1\1}>";
    static final String[] dfa_46s = {
            "\1\2\35\uffff\1\2\1\3\50\uffff\1\1",
            "\1\6\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\13\uffff\1\4\1\uffff\1\5\21\uffff\2\4\1\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "",
            "",
            "",
            "\1\7\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\10\1\11\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\13\12\uffff\1\14\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\17\4\1\12\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\15\17\uffff\1\4\2\uffff\1\4\1\uffff\1\16\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\17",
            "\1\20",
            "\1\21\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\2\3\uffff\1\4\21\uffff\1\4\46\uffff\1\2",
            "\1\23\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\22\1\24\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\25\36\uffff\1\26",
            "\1\4\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\20\1\uffff\7\4\1\uffff\4\4",
            "\1\11",
            "\1\27",
            "\1\30\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\31\1\4\4\uffff\7\4\1\uffff\4\4",
            "\1\32\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\33\1\34\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\uffff",
            "\1\36\35\uffff\1\35",
            "\1\15\24\uffff\1\11",
            "\1\37",
            "\1\13",
            "\1\40\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\41\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\42\17\uffff\1\4\2\uffff\1\4\1\uffff\1\43\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\44",
            "\1\45",
            "\1\46\36\uffff\1\47\1\50",
            "\1\uffff",
            "\1\11",
            "\1\4\12\uffff\1\52\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\51\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\14\3\uffff\1\4\4\uffff\1\4\6\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\53\36\uffff\1\54",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\45\1\uffff\7\4\1\uffff\4\4",
            "\1\34",
            "\1\55",
            "\1\56\24\uffff\1\50",
            "\1\57",
            "\1\60",
            "\1\61\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\62\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\42\24\uffff\1\34",
            "\1\63",
            "\1\64",
            "\1\65\36\uffff\1\66",
            "\1\50",
            "\1\67",
            "\1\14\3\uffff\1\4\13\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\2",
            "\1\4\12\uffff\1\52\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\51\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\34",
            "\1\uffff",
            "\1\56\24\uffff\1\50",
            "\1\70",
            "\1\71",
            "\1\50",
            "\1\uffff"
    };

    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = dfa_40;
            this.eof = dfa_41;
            this.min = dfa_42;
            this.max = dfa_43;
            this.accept = dfa_44;
            this.special = dfa_45;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "5033:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?";
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
                        if ( (synpred135_PsiInternalExBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalExBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_52 = input.LA(1);

                         
                        int index90_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalExBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_52);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_30 = input.LA(1);

                         
                        int index90_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalExBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index90_30);
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
    static final String dfa_47s = "\27\uffff";
    static final String dfa_48s = "\1\5\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String dfa_49s = "\1\114\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String dfa_50s = "\1\uffff\1\1\24\uffff\1\2";
    static final String dfa_51s = "\3\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\uffff}>";
    static final String[] dfa_52s = {
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

    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final short[][] dfa_52 = unpackEncodedStringArray(dfa_52s);

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_47;
            this.eof = dfa_47;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_50;
            this.special = dfa_51;
            this.transition = dfa_52;
        }
        public String getDescription() {
            return "5198:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )";
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
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_4 = input.LA(1);

                         
                        int index91_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_7 = input.LA(1);

                         
                        int index91_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_8 = input.LA(1);

                         
                        int index91_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA91_17 = input.LA(1);

                         
                        int index91_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_17);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA91_18 = input.LA(1);

                         
                        int index91_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_18);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA91_19 = input.LA(1);

                         
                        int index91_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA91_20 = input.LA(1);

                         
                        int index91_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA91_21 = input.LA(1);

                         
                        int index91_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalExBeeLangTestLanguage()) ) {s = 1;}

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
abstract class PsiInternalExBeeLangTestLanguageParser2 extends PsiInternalExBeeLangTestLanguageParser1 {

        PsiInternalExBeeLangTestLanguageParser2(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalExBeeLangTestLanguageParser2(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleDelegateModel"
    // PsiInternalExBeeLangTestLanguage.g:60:1: entryRuleDelegateModel returns [Boolean current=false] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final Boolean entryRuleDelegateModel() throws RecognitionException {
        Boolean current = false;
        int entryRuleDelegateModel_StartIndex = input.index();
        Boolean iv_ruleDelegateModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:60:55: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // PsiInternalExBeeLangTestLanguage.g:61:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getDelegateModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDelegateModel=ruleDelegateModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDelegateModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleDelegateModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // PsiInternalExBeeLangTestLanguage.g:67:1: ruleDelegateModel returns [Boolean current=false] : this_Model_0= ruleModel ;
    public final Boolean ruleDelegateModel() throws RecognitionException {
        Boolean current = false;
        int ruleDelegateModel_StartIndex = input.index();
        Boolean this_Model_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:68:1: (this_Model_0= ruleModel )
            // PsiInternalExBeeLangTestLanguage.g:69:2: this_Model_0= ruleModel
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getDelegateModel_ModelParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Model_0=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Model_0;
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
        return current;
    }
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // PsiInternalExBeeLangTestLanguage.g:83:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;
        int entryRuleModel_StartIndex = input.index();
        Boolean iv_ruleModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:83:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalExBeeLangTestLanguage.g:84:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalExBeeLangTestLanguage.g:90:1: ruleModel returns [Boolean current=false] : ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;
        int ruleModel_StartIndex = input.index();
        Boolean lv_units_0_0 = null;

        Boolean lv_functions_1_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:91:1: ( ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:92:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:92:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            int alt3=2;
            switch ( input.LA(1) ) {
            case RULE_DOCUMENTATION:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==13) ) {
                    alt3=1;
                }
                else if ( (LA3_1==RULE_ID||(LA3_1>=33 && LA3_1<=34)) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
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

                if ( (synpred2_PsiInternalExBeeLangTestLanguage()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:93:3: ( (lv_units_0_0= ruleUnit ) )*
                    {
                    // PsiInternalExBeeLangTestLanguage.g:93:3: ( (lv_units_0_0= ruleUnit ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_DOCUMENTATION||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalExBeeLangTestLanguage.g:94:4: (lv_units_0_0= ruleUnit )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:94:4: (lv_units_0_0= ruleUnit )
                    	    // PsiInternalExBeeLangTestLanguage.g:95:5: lv_units_0_0= ruleUnit
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getModel_UnitsUnitParserRuleCall_0_0ElementType());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_units_0_0=ruleUnit();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      					if(!current) {
                    	      						associateWithSemanticElement();
                    	      						current = true;
                    	      					}
                    	      				
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
                    // PsiInternalExBeeLangTestLanguage.g:109:3: ( (lv_functions_1_0= ruleFunction ) )*
                    {
                    // PsiInternalExBeeLangTestLanguage.g:109:3: ( (lv_functions_1_0= ruleFunction ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=RULE_DOCUMENTATION && LA2_0<=RULE_ID)||(LA2_0>=33 && LA2_0<=34)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalExBeeLangTestLanguage.g:110:4: (lv_functions_1_0= ruleFunction )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:110:4: (lv_functions_1_0= ruleFunction )
                    	    // PsiInternalExBeeLangTestLanguage.g:111:5: lv_functions_1_0= ruleFunction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getModel_FunctionsFunctionParserRuleCall_1_0ElementType());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_functions_1_0=ruleFunction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      					if(!current) {
                    	      						associateWithSemanticElement();
                    	      						current = true;
                    	      					}
                    	      				
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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnit"
    // PsiInternalExBeeLangTestLanguage.g:128:1: entryRuleUnit returns [Boolean current=false] : iv_ruleUnit= ruleUnit EOF ;
    public final Boolean entryRuleUnit() throws RecognitionException {
        Boolean current = false;
        int entryRuleUnit_StartIndex = input.index();
        Boolean iv_ruleUnit = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:132:2: (iv_ruleUnit= ruleUnit EOF )
            // PsiInternalExBeeLangTestLanguage.g:133:2: iv_ruleUnit= ruleUnit EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnitElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnit=ruleUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnit; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // PsiInternalExBeeLangTestLanguage.g:142:1: ruleUnit returns [Boolean current=false] : ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) ;
    public final Boolean ruleUnit() throws RecognitionException {
        Boolean current = false;
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
        Boolean lv_implements_7_0 = null;

        Boolean lv_implements_9_0 = null;

        Boolean lv_sourceLocation_14_0 = null;

        Boolean lv_outputLocation_18_0 = null;

        Boolean lv_providedCapabilities_22_0 = null;

        Boolean lv_requiredCapabilities_26_0 = null;

        Boolean lv_metaRequiredCapabilities_31_0 = null;

        Boolean lv_functions_33_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:147:2: ( ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) )
            // PsiInternalExBeeLangTestLanguage.g:148:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            {
            // PsiInternalExBeeLangTestLanguage.g:148:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            // PsiInternalExBeeLangTestLanguage.g:149:3: () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}'
            {
            // PsiInternalExBeeLangTestLanguage.g:149:3: ()
            // PsiInternalExBeeLangTestLanguage.g:150:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnit_UnitAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:159:3: ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOCUMENTATION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:160:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:160:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    // PsiInternalExBeeLangTestLanguage.g:161:5: lv_documentation_1_0= RULE_DOCUMENTATION
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getUnit_DocumentationDOCUMENTATIONTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_documentation_1_0=(Token)match(input,RULE_DOCUMENTATION,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
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
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:183:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:184:4: (lv_name_3_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:184:4: (lv_name_3_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:185:5: lv_name_3_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getUnit_NameIDTerminalRuleCall_3_0ElementType());
                      				
                    }
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_name_3_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:200:3: (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:201:4: otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_VersionKeyword_4_0ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:208:4: ( (lv_version_5_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:209:5: (lv_version_5_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:209:5: (lv_version_5_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:210:6: lv_version_5_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnit_VersionIDTerminalRuleCall_4_1_0ElementType());
                      					
                    }
                    lv_version_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_version_5_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:226:3: (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:227:4: otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_ImplementsKeyword_5_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:234:4: ( (lv_implements_7_0= ruleSimpleTypeRef ) )
                    // PsiInternalExBeeLangTestLanguage.g:235:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:235:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    // PsiInternalExBeeLangTestLanguage.g:236:6: lv_implements_7_0= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getUnit_ImplementsSimpleTypeRefParserRuleCall_5_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_implements_7_0=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:249:4: (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // PsiInternalExBeeLangTestLanguage.g:250:5: otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getUnit_CommaKeyword_5_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_8);
                    	      				
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:257:5: ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:258:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:258:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    // PsiInternalExBeeLangTestLanguage.g:259:7: lv_implements_9_0= ruleSimpleTypeRef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getUnit_ImplementsSimpleTypeRefParserRuleCall_5_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_10);
                    	    lv_implements_9_0=ruleSimpleTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
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
            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:281:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // PsiInternalExBeeLangTestLanguage.g:282:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:282:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:283:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getUnitAccess().getUnorderedGroup_7());
            // PsiInternalExBeeLangTestLanguage.g:286:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:287:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            {
            // PsiInternalExBeeLangTestLanguage.g:287:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=7;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:288:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:288:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:289:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:289:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:290:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
            	    // PsiInternalExBeeLangTestLanguage.g:293:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:293:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:293:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:293:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SourceKeyword_7_0_0ElementType());
            	      								
            	    }
            	    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_12);
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_0_1ElementType());
            	      								
            	    }
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_13);
            	      								
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:307:9: ( (lv_sourceLocation_14_0= rulePath ) )
            	    // PsiInternalExBeeLangTestLanguage.g:308:10: (lv_sourceLocation_14_0= rulePath )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:308:10: (lv_sourceLocation_14_0= rulePath )
            	    // PsiInternalExBeeLangTestLanguage.g:309:11: lv_sourceLocation_14_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											markComposite(elementTypeProvider.getUnit_SourceLocationPathParserRuleCall_7_0_2_0ElementType());
            	      										
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_sourceLocation_14_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											doneComposite();
            	      											if(!current) {
            	      												associateWithSemanticElement();
            	      												current = true;
            	      											}
            	      										
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_0_3ElementType());
            	      								
            	    }
            	    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:335:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:335:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:336:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:336:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:337:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
            	    // PsiInternalExBeeLangTestLanguage.g:340:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:340:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:340:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:340:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_OutputKeyword_7_1_0ElementType());
            	      								
            	    }
            	    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_16);
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_1_1ElementType());
            	      								
            	    }
            	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_17);
            	      								
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:354:9: ( (lv_outputLocation_18_0= rulePath ) )
            	    // PsiInternalExBeeLangTestLanguage.g:355:10: (lv_outputLocation_18_0= rulePath )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:355:10: (lv_outputLocation_18_0= rulePath )
            	    // PsiInternalExBeeLangTestLanguage.g:356:11: lv_outputLocation_18_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											markComposite(elementTypeProvider.getUnit_OutputLocationPathParserRuleCall_7_1_2_0ElementType());
            	      										
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_outputLocation_18_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											doneComposite();
            	      											if(!current) {
            	      												associateWithSemanticElement();
            	      												current = true;
            	      											}
            	      										
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_1_3ElementType());
            	      								
            	    }
            	    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:382:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:382:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    // PsiInternalExBeeLangTestLanguage.g:383:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:383:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    // PsiInternalExBeeLangTestLanguage.g:384:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
            	    // PsiInternalExBeeLangTestLanguage.g:387:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==22) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((synpred11_PsiInternalExBeeLangTestLanguage()&&(true))) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // PsiInternalExBeeLangTestLanguage.g:387:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalExBeeLangTestLanguage.g:387:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    // PsiInternalExBeeLangTestLanguage.g:387:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_20);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_2_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_21);
            	    	      								
            	    	    }
            	    	    // PsiInternalExBeeLangTestLanguage.g:401:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
            	    	    // PsiInternalExBeeLangTestLanguage.g:402:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    {
            	    	    // PsiInternalExBeeLangTestLanguage.g:402:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    // PsiInternalExBeeLangTestLanguage.g:403:11: lv_providedCapabilities_22_0= ruleProvidedCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    lv_providedCapabilities_22_0=ruleProvidedCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      											if(!current) {
            	    	      												associateWithSemanticElement();
            	    	      												current = true;
            	    	      											}
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_2_3ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_23);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
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
            	    // PsiInternalExBeeLangTestLanguage.g:429:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:429:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    // PsiInternalExBeeLangTestLanguage.g:430:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:430:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    // PsiInternalExBeeLangTestLanguage.g:431:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
            	    // PsiInternalExBeeLangTestLanguage.g:434:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==23) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((synpred13_PsiInternalExBeeLangTestLanguage()&&(true))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // PsiInternalExBeeLangTestLanguage.g:434:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalExBeeLangTestLanguage.g:434:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    // PsiInternalExBeeLangTestLanguage.g:434:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_24);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_3_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_25);
            	    	      								
            	    	    }
            	    	    // PsiInternalExBeeLangTestLanguage.g:448:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
            	    	    // PsiInternalExBeeLangTestLanguage.g:449:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    {
            	    	    // PsiInternalExBeeLangTestLanguage.g:449:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    // PsiInternalExBeeLangTestLanguage.g:450:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      											if(!current) {
            	    	      												associateWithSemanticElement();
            	    	      												current = true;
            	    	      											}
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_3_3ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_27);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
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
            	    // PsiInternalExBeeLangTestLanguage.g:476:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:476:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    // PsiInternalExBeeLangTestLanguage.g:477:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:477:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    // PsiInternalExBeeLangTestLanguage.g:478:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
            	    // PsiInternalExBeeLangTestLanguage.g:481:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==23) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((synpred15_PsiInternalExBeeLangTestLanguage()&&(true))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // PsiInternalExBeeLangTestLanguage.g:481:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalExBeeLangTestLanguage.g:481:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    // PsiInternalExBeeLangTestLanguage.g:481:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_28);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_EnvKeyword_7_4_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_29);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_4_2ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_30);
            	    	      								
            	    	    }
            	    	    // PsiInternalExBeeLangTestLanguage.g:502:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
            	    	    // PsiInternalExBeeLangTestLanguage.g:503:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    {
            	    	    // PsiInternalExBeeLangTestLanguage.g:503:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    // PsiInternalExBeeLangTestLanguage.g:504:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      											if(!current) {
            	    	      												associateWithSemanticElement();
            	    	      												current = true;
            	    	      											}
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_4_4ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_32);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
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
            	    // PsiInternalExBeeLangTestLanguage.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    // PsiInternalExBeeLangTestLanguage.g:531:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:531:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    // PsiInternalExBeeLangTestLanguage.g:532:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
            	    // PsiInternalExBeeLangTestLanguage.g:535:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        switch ( input.LA(1) ) {
            	        case RULE_DOCUMENTATION:
            	            {
            	            int LA12_2 = input.LA(2);

            	            if ( ((synpred17_PsiInternalExBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA12_3 = input.LA(2);

            	            if ( ((synpred17_PsiInternalExBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 33:
            	            {
            	            int LA12_4 = input.LA(2);

            	            if ( ((synpred17_PsiInternalExBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 34:
            	            {
            	            int LA12_5 = input.LA(2);

            	            if ( ((synpred17_PsiInternalExBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt12) {
            	    	case 1 :
            	    	    // PsiInternalExBeeLangTestLanguage.g:535:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalExBeeLangTestLanguage.g:535:19: ( (lv_functions_33_0= ruleFunction ) )
            	    	    // PsiInternalExBeeLangTestLanguage.g:535:20: (lv_functions_33_0= ruleFunction )
            	    	    {
            	    	    // PsiInternalExBeeLangTestLanguage.g:535:20: (lv_functions_33_0= ruleFunction )
            	    	    // PsiInternalExBeeLangTestLanguage.g:536:10: lv_functions_33_0= ruleFunction
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
            	    	      									
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_11);
            	    	    lv_functions_33_0=ruleFunction();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      										doneComposite();
            	    	      										if(!current) {
            	    	      											associateWithSemanticElement();
            	    	      											current = true;
            	    	      										}
            	    	      									
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
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
            otherlv_34=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleProvidedCapability"
    // PsiInternalExBeeLangTestLanguage.g:575:1: entryRuleProvidedCapability returns [Boolean current=false] : iv_ruleProvidedCapability= ruleProvidedCapability EOF ;
    public final Boolean entryRuleProvidedCapability() throws RecognitionException {
        Boolean current = false;
        int entryRuleProvidedCapability_StartIndex = input.index();
        Boolean iv_ruleProvidedCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:579:2: (iv_ruleProvidedCapability= ruleProvidedCapability EOF )
            // PsiInternalExBeeLangTestLanguage.g:580:2: iv_ruleProvidedCapability= ruleProvidedCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getProvidedCapabilityElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProvidedCapability=ruleProvidedCapability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProvidedCapability; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
        return current;
    }
    // $ANTLR end "entryRuleProvidedCapability"


    // $ANTLR start "ruleProvidedCapability"
    // PsiInternalExBeeLangTestLanguage.g:589:1: ruleProvidedCapability returns [Boolean current=false] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) ;
    public final Boolean ruleProvidedCapability() throws RecognitionException {
        Boolean current = false;
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
        Boolean lv_condExpr_7_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:594:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) )
            // PsiInternalExBeeLangTestLanguage.g:595:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            {
            // PsiInternalExBeeLangTestLanguage.g:595:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            // PsiInternalExBeeLangTestLanguage.g:596:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            {
            // PsiInternalExBeeLangTestLanguage.g:596:3: ()
            // PsiInternalExBeeLangTestLanguage.g:597:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getProvidedCapability_ProvidedCapabilityAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:606:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==13) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:607:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:607:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:608:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:608:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:609:6: lv_nameSpace_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getProvidedCapability_NameSpaceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_1_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:625:4: otherlv_2= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_UnitKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:633:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:634:4: otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_LeftCurlyBracketKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:641:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) )
                    // PsiInternalExBeeLangTestLanguage.g:642:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:642:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    // PsiInternalExBeeLangTestLanguage.g:643:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());
                    // PsiInternalExBeeLangTestLanguage.g:646:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    // PsiInternalExBeeLangTestLanguage.g:647:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?
                    {
                    // PsiInternalExBeeLangTestLanguage.g:647:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+
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
                    	    // PsiInternalExBeeLangTestLanguage.g:648:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:648:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:649:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:649:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:650:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
                    	    // PsiInternalExBeeLangTestLanguage.g:653:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:653:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:653:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    // PsiInternalExBeeLangTestLanguage.g:653:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_WhenKeyword_2_1_0_0ElementType());
                    	      									
                    	    }
                    	    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_5);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_0_1ElementType());
                    	      									
                    	    }
                    	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_6);
                    	      									
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:667:10: ( (lv_condExpr_7_0= ruleExpression ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:668:11: (lv_condExpr_7_0= ruleExpression )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:668:11: (lv_condExpr_7_0= ruleExpression )
                    	    // PsiInternalExBeeLangTestLanguage.g:669:12: lv_condExpr_7_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markComposite(elementTypeProvider.getProvidedCapability_CondExprExpressionParserRuleCall_2_1_0_2_0ElementType());
                    	      											
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    lv_condExpr_7_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												doneComposite();
                    	      												if(!current) {
                    	      													associateWithSemanticElement();
                    	      													current = true;
                    	      												}
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_0_3ElementType());
                    	      									
                    	    }
                    	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return current;
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
                    	    // PsiInternalExBeeLangTestLanguage.g:695:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:695:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:696:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:696:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:697:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
                    	    // PsiInternalExBeeLangTestLanguage.g:700:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:700:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:700:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    // PsiInternalExBeeLangTestLanguage.g:700:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_NameKeyword_2_1_1_0ElementType());
                    	      									
                    	    }
                    	    otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_9);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_1_1ElementType());
                    	      									
                    	    }
                    	    otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_10);
                    	      									
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:714:10: ( (lv_name_11_0= RULE_ID ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:715:11: (lv_name_11_0= RULE_ID )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:715:11: (lv_name_11_0= RULE_ID )
                    	    // PsiInternalExBeeLangTestLanguage.g:716:12: lv_name_11_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markLeaf(elementTypeProvider.getProvidedCapability_NameIDTerminalRuleCall_2_1_1_2_0ElementType());
                    	      											
                    	    }
                    	    lv_name_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												if(!current) {
                    	      													associateWithSemanticElement();
                    	      													current = true;
                    	      												}
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												doneLeaf(lv_name_11_0);
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_1_3ElementType());
                    	      									
                    	    }
                    	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return current;
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
                    	    // PsiInternalExBeeLangTestLanguage.g:744:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:744:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:745:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:745:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:746:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
                    	    // PsiInternalExBeeLangTestLanguage.g:749:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:749:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:749:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    // PsiInternalExBeeLangTestLanguage.g:749:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_VersionKeyword_2_1_2_0ElementType());
                    	      									
                    	    }
                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_13);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_2_1ElementType());
                    	      									
                    	    }
                    	    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_14);
                    	      									
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:763:10: ( (lv_version_15_0= RULE_ID ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:764:11: (lv_version_15_0= RULE_ID )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:764:11: (lv_version_15_0= RULE_ID )
                    	    // PsiInternalExBeeLangTestLanguage.g:765:12: lv_version_15_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markLeaf(elementTypeProvider.getProvidedCapability_VersionIDTerminalRuleCall_2_1_2_2_0ElementType());
                    	      											
                    	    }
                    	    lv_version_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												if(!current) {
                    	      													associateWithSemanticElement();
                    	      													current = true;
                    	      												}
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												doneLeaf(lv_version_15_0);
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_2_3ElementType());
                    	      									
                    	    }
                    	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return current;
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
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()) ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canLeave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1())");
                    }

                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_RightCurlyBracketKeyword_2_2ElementType());
                      			
                    }
                    otherlv_17=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleProvidedCapability"


    // $ANTLR start "entryRuleAliasedRequiredCapability"
    // PsiInternalExBeeLangTestLanguage.g:816:1: entryRuleAliasedRequiredCapability returns [Boolean current=false] : iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF ;
    public final Boolean entryRuleAliasedRequiredCapability() throws RecognitionException {
        Boolean current = false;
        int entryRuleAliasedRequiredCapability_StartIndex = input.index();
        Boolean iv_ruleAliasedRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:820:2: (iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF )
            // PsiInternalExBeeLangTestLanguage.g:821:2: iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAliasedRequiredCapabilityElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAliasedRequiredCapability=ruleAliasedRequiredCapability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAliasedRequiredCapability; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
        return current;
    }
    // $ANTLR end "entryRuleAliasedRequiredCapability"


    // $ANTLR start "ruleAliasedRequiredCapability"
    // PsiInternalExBeeLangTestLanguage.g:830:1: ruleAliasedRequiredCapability returns [Boolean current=false] : ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) ;
    public final Boolean ruleAliasedRequiredCapability() throws RecognitionException {
        Boolean current = false;
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
        Boolean lv_condExpr_9_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:835:2: ( ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) )
            // PsiInternalExBeeLangTestLanguage.g:836:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:836:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            // PsiInternalExBeeLangTestLanguage.g:837:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            {
            // PsiInternalExBeeLangTestLanguage.g:837:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==13) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:838:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:838:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:839:5: (lv_nameSpace_0_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:839:5: (lv_nameSpace_0_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:840:6: lv_nameSpace_0_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getAliasedRequiredCapability_NameSpaceIDTerminalRuleCall_0_0_0ElementType());
                      					
                    }
                    lv_nameSpace_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_0_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:856:4: otherlv_1= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAliasedRequiredCapability_UnitKeyword_0_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:864:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:865:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:865:4: (lv_name_2_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:866:5: lv_name_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getAliasedRequiredCapability_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_2_0);
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:881:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:882:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAliasedRequiredCapability_AsKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:889:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:890:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:890:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:891:6: lv_alias_4_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getAliasedRequiredCapability_AliasIDTerminalRuleCall_2_1_0ElementType());
                      					
                    }
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_4_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:907:3: (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            // PsiInternalExBeeLangTestLanguage.g:908:4: otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getAliasedRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_5);
              			
            }
            // PsiInternalExBeeLangTestLanguage.g:915:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) )
            // PsiInternalExBeeLangTestLanguage.g:916:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:916:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:917:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalExBeeLangTestLanguage.g:920:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:921:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            {
            // PsiInternalExBeeLangTestLanguage.g:921:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
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
            	    // PsiInternalExBeeLangTestLanguage.g:922:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:922:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:923:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:923:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:924:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalExBeeLangTestLanguage.g:927:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:927:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:927:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:927:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_WhenKeyword_3_1_0_0ElementType());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_7);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_0_1ElementType());
            	      									
            	    }
            	    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_8);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:941:10: ( (lv_condExpr_9_0= ruleExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:942:11: (lv_condExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:942:11: (lv_condExpr_9_0= ruleExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:943:12: lv_condExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markComposite(elementTypeProvider.getAliasedRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
            	      											
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_condExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneComposite();
            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_0_3ElementType());
            	      									
            	    }
            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:970:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:970:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:971:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalExBeeLangTestLanguage.g:974:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:974:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:974:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:974:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:974:21: ( (lv_greedy_11_0= 'greedy' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:975:11: (lv_greedy_11_0= 'greedy' )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:975:11: (lv_greedy_11_0= 'greedy' )
            	    // PsiInternalExBeeLangTestLanguage.g:976:12: lv_greedy_11_0= 'greedy'
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
            	      											
            	    }
            	    lv_greedy_11_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_greedy_11_0);
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_1_1ElementType());
            	      									
            	    }
            	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:1004:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1004:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1005:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1005:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1006:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalExBeeLangTestLanguage.g:1009:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1009:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1009:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1009:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_13);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_2_1ElementType());
            	      									
            	    }
            	    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_14);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1023:10: ( (lv_min_15_0= RULE_INT ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1024:11: (lv_min_15_0= RULE_INT )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1024:11: (lv_min_15_0= RULE_INT )
            	    // PsiInternalExBeeLangTestLanguage.g:1025:12: lv_min_15_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
            	      											
            	    }
            	    lv_min_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_min_15_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_2_3ElementType());
            	      									
            	    }
            	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:1053:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1053:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1054:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1054:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1055:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalExBeeLangTestLanguage.g:1058:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1058:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1058:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1058:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_17);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_3_1ElementType());
            	      									
            	    }
            	    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_18);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1072:10: ( (lv_max_19_0= RULE_INT ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1073:11: (lv_max_19_0= RULE_INT )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1073:11: (lv_max_19_0= RULE_INT )
            	    // PsiInternalExBeeLangTestLanguage.g:1074:12: lv_max_19_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
            	      											
            	    }
            	    lv_max_19_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_max_19_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_3_3ElementType());
            	      									
            	    }
            	    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:1102:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1102:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1103:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1103:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1104:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalExBeeLangTestLanguage.g:1107:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1107:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1107:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1107:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionKeyword_3_1_4_0ElementType());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_21);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_4_1ElementType());
            	      									
            	    }
            	    otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_22);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1121:10: ( (lv_versionRange_23_0= RULE_ID ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1122:11: (lv_versionRange_23_0= RULE_ID )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1122:11: (lv_versionRange_23_0= RULE_ID )
            	    // PsiInternalExBeeLangTestLanguage.g:1123:12: lv_versionRange_23_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
            	      											
            	    }
            	    lv_versionRange_23_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_versionRange_23_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_4_3ElementType());
            	      									
            	    }
            	    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            otherlv_25=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleAliasedRequiredCapability"


    // $ANTLR start "entryRuleRequiredCapability"
    // PsiInternalExBeeLangTestLanguage.g:1173:1: entryRuleRequiredCapability returns [Boolean current=false] : iv_ruleRequiredCapability= ruleRequiredCapability EOF ;
    public final Boolean entryRuleRequiredCapability() throws RecognitionException {
        Boolean current = false;
        int entryRuleRequiredCapability_StartIndex = input.index();
        Boolean iv_ruleRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1177:2: (iv_ruleRequiredCapability= ruleRequiredCapability EOF )
            // PsiInternalExBeeLangTestLanguage.g:1178:2: iv_ruleRequiredCapability= ruleRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRequiredCapabilityElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRequiredCapability=ruleRequiredCapability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequiredCapability; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
        return current;
    }
    // $ANTLR end "entryRuleRequiredCapability"


    // $ANTLR start "ruleRequiredCapability"
    // PsiInternalExBeeLangTestLanguage.g:1187:1: ruleRequiredCapability returns [Boolean current=false] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) ;
    public final Boolean ruleRequiredCapability() throws RecognitionException {
        Boolean current = false;
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
        Boolean lv_condExpr_8_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1192:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1193:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1193:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            // PsiInternalExBeeLangTestLanguage.g:1194:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            {
            // PsiInternalExBeeLangTestLanguage.g:1194:3: ()
            // PsiInternalExBeeLangTestLanguage.g:1195:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getRequiredCapability_RequiredCapabilityAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:1204:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==13) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:1205:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1205:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:1206:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1206:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:1207:6: lv_nameSpace_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getRequiredCapability_NameSpaceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_1_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:1223:4: otherlv_2= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getRequiredCapability_UnitKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:1231:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:1232:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:1232:4: (lv_name_3_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:1233:5: lv_name_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getRequiredCapability_NameIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_3_0);
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:1248:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            // PsiInternalExBeeLangTestLanguage.g:1249:4: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_4);
              			
            }
            // PsiInternalExBeeLangTestLanguage.g:1256:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1257:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1257:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:1258:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalExBeeLangTestLanguage.g:1261:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:1262:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            {
            // PsiInternalExBeeLangTestLanguage.g:1262:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
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
            	    // PsiInternalExBeeLangTestLanguage.g:1263:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1263:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1264:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1264:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1265:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalExBeeLangTestLanguage.g:1268:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1268:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1268:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1268:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_WhenKeyword_3_1_0_0ElementType());
            	      									
            	    }
            	    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_6);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_0_1ElementType());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_7);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1282:10: ( (lv_condExpr_8_0= ruleExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1283:11: (lv_condExpr_8_0= ruleExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1283:11: (lv_condExpr_8_0= ruleExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:1284:12: lv_condExpr_8_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markComposite(elementTypeProvider.getRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
            	      											
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_condExpr_8_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneComposite();
            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_0_3ElementType());
            	      									
            	    }
            	    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:1310:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1310:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1311:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1311:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1312:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalExBeeLangTestLanguage.g:1315:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1315:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1315:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1315:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1315:21: ( (lv_greedy_10_0= 'greedy' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1316:11: (lv_greedy_10_0= 'greedy' )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1316:11: (lv_greedy_10_0= 'greedy' )
            	    // PsiInternalExBeeLangTestLanguage.g:1317:12: lv_greedy_10_0= 'greedy'
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
            	      											
            	    }
            	    lv_greedy_10_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_greedy_10_0);
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_1_1ElementType());
            	      									
            	    }
            	    otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:1345:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1345:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1346:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1346:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1347:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalExBeeLangTestLanguage.g:1350:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1350:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1350:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1350:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
            	      									
            	    }
            	    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_12);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_2_1ElementType());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_13);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1364:10: ( (lv_min_14_0= RULE_INT ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1365:11: (lv_min_14_0= RULE_INT )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1365:11: (lv_min_14_0= RULE_INT )
            	    // PsiInternalExBeeLangTestLanguage.g:1366:12: lv_min_14_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
            	      											
            	    }
            	    lv_min_14_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_min_14_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_2_3ElementType());
            	      									
            	    }
            	    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:1394:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1394:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1395:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1395:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1396:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalExBeeLangTestLanguage.g:1399:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1399:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1399:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1399:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
            	      									
            	    }
            	    otherlv_16=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_16);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_3_1ElementType());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_17);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1413:10: ( (lv_max_18_0= RULE_INT ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1414:11: (lv_max_18_0= RULE_INT )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1414:11: (lv_max_18_0= RULE_INT )
            	    // PsiInternalExBeeLangTestLanguage.g:1415:12: lv_max_18_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
            	      											
            	    }
            	    lv_max_18_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_max_18_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_3_3ElementType());
            	      									
            	    }
            	    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // PsiInternalExBeeLangTestLanguage.g:1443:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1443:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1444:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1444:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1445:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalExBeeLangTestLanguage.g:1448:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1448:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1448:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    // PsiInternalExBeeLangTestLanguage.g:1448:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_VersionKeyword_3_1_4_0ElementType());
            	      									
            	    }
            	    otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_20);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_4_1ElementType());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_21);
            	      									
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1462:10: ( (lv_versionRange_22_0= RULE_ID ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1463:11: (lv_versionRange_22_0= RULE_ID )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1463:11: (lv_versionRange_22_0= RULE_ID )
            	    // PsiInternalExBeeLangTestLanguage.g:1464:12: lv_versionRange_22_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
            	      											
            	    }
            	    lv_versionRange_22_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_versionRange_22_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_4_3ElementType());
            	      									
            	    }
            	    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            otherlv_24=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleRequiredCapability"


    // $ANTLR start "entryRulePath"
    // PsiInternalExBeeLangTestLanguage.g:1514:1: entryRulePath returns [Boolean current=false] : iv_rulePath= rulePath EOF ;
    public final Boolean entryRulePath() throws RecognitionException {
        Boolean current = false;
        int entryRulePath_StartIndex = input.index();
        Boolean iv_rulePath = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1516:2: (iv_rulePath= rulePath EOF )
            // PsiInternalExBeeLangTestLanguage.g:1517:2: iv_rulePath= rulePath EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPathElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePath; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // PsiInternalExBeeLangTestLanguage.g:1526:1: rulePath returns [Boolean current=false] : (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) ;
    public final Boolean rulePath() throws RecognitionException {
        Boolean current = false;
        int rulePath_StartIndex = input.index();
        Token this_STRING_0=null;
        Token kw=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1529:2: ( (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1530:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1530:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_STRING) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID||LA25_0==32) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:1531:3: this_STRING_0= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getPath_STRINGTerminalRuleCall_0ElementType());
                      		
                    }
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(this_STRING_0);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:1539:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1539:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    // PsiInternalExBeeLangTestLanguage.g:1540:4: (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )?
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1540:4: (kw= '/' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==32) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // PsiInternalExBeeLangTestLanguage.g:1541:5: kw= '/'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_0ElementType());
                              				
                            }
                            kw=(Token)match(input,32,FollowSets000.FOLLOW_13); if (state.failed) return current;
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
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:1556:4: (kw= '/' ruleQID )*
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
                    	    // PsiInternalExBeeLangTestLanguage.g:1557:5: kw= '/' ruleQID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    kw=(Token)match(input,32,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(kw);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getPath_QIDParserRuleCall_1_2_1ElementType());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    ruleQID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // PsiInternalExBeeLangTestLanguage.g:1572:4: (kw= '/' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==32) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // PsiInternalExBeeLangTestLanguage.g:1573:5: kw= '/'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_3ElementType());
                              				
                            }
                            kw=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleParameterList"
    // PsiInternalExBeeLangTestLanguage.g:1589:1: entryRuleParameterList returns [Boolean current=false] : iv_ruleParameterList= ruleParameterList EOF ;
    public final Boolean entryRuleParameterList() throws RecognitionException {
        Boolean current = false;
        int entryRuleParameterList_StartIndex = input.index();
        Boolean iv_ruleParameterList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1589:55: (iv_ruleParameterList= ruleParameterList EOF )
            // PsiInternalExBeeLangTestLanguage.g:1590:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterListElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRuleParameterList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // PsiInternalExBeeLangTestLanguage.g:1596:1: ruleParameterList returns [Boolean current=false] : ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) ;
    public final Boolean ruleParameterList() throws RecognitionException {
        Boolean current = false;
        int ruleParameterList_StartIndex = input.index();
        Token otherlv_1=null;
        Boolean lv_parameters_0_0 = null;

        Boolean lv_parameters_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1597:1: ( ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:1598:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:1598:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:1599:3: ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            {
            // PsiInternalExBeeLangTestLanguage.g:1599:3: ( (lv_parameters_0_0= ruleFirstParameter ) )
            // PsiInternalExBeeLangTestLanguage.g:1600:4: (lv_parameters_0_0= ruleFirstParameter )
            {
            // PsiInternalExBeeLangTestLanguage.g:1600:4: (lv_parameters_0_0= ruleFirstParameter )
            // PsiInternalExBeeLangTestLanguage.g:1601:5: lv_parameters_0_0= ruleFirstParameter
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getParameterList_ParametersFirstParameterParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_parameters_0_0=ruleFirstParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:1614:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:1615:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getParameterList_CommaKeyword_1_0ElementType());
            	      			
            	    }
            	    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_1);
            	      			
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:1622:4: ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    // PsiInternalExBeeLangTestLanguage.g:1623:5: (lv_parameters_2_0= ruleFirstParameter )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:1623:5: (lv_parameters_2_0= ruleFirstParameter )
            	    // PsiInternalExBeeLangTestLanguage.g:1624:6: lv_parameters_2_0= ruleFirstParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getParameterList_ParametersFirstParameterParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    lv_parameters_2_0=ruleFirstParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
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
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleFirstParameter"
    // PsiInternalExBeeLangTestLanguage.g:1642:1: entryRuleFirstParameter returns [Boolean current=false] : iv_ruleFirstParameter= ruleFirstParameter EOF ;
    public final Boolean entryRuleFirstParameter() throws RecognitionException {
        Boolean current = false;
        int entryRuleFirstParameter_StartIndex = input.index();
        Boolean iv_ruleFirstParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1642:56: (iv_ruleFirstParameter= ruleFirstParameter EOF )
            // PsiInternalExBeeLangTestLanguage.g:1643:2: iv_ruleFirstParameter= ruleFirstParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFirstParameterElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFirstParameter=ruleFirstParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleFirstParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFirstParameter"


    // $ANTLR start "ruleFirstParameter"
    // PsiInternalExBeeLangTestLanguage.g:1649:1: ruleFirstParameter returns [Boolean current=false] : (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) ;
    public final Boolean ruleFirstParameter() throws RecognitionException {
        Boolean current = false;
        int ruleFirstParameter_StartIndex = input.index();
        Boolean this_ClosureParameter_0 = null;

        Boolean this_Parameter_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1650:1: ( (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) )
            // PsiInternalExBeeLangTestLanguage.g:1651:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            {
            // PsiInternalExBeeLangTestLanguage.g:1651:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:1652:3: this_ClosureParameter_0= ruleClosureParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFirstParameter_ClosureParameterParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClosureParameter_0=ruleClosureParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureParameter_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:1664:3: this_Parameter_1= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFirstParameter_ParameterParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Parameter_1=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Parameter_1;
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
        return current;
    }
    // $ANTLR end "ruleFirstParameter"


    // $ANTLR start "entryRuleParameter"
    // PsiInternalExBeeLangTestLanguage.g:1679:1: entryRuleParameter returns [Boolean current=false] : iv_ruleParameter= ruleParameter EOF ;
    public final Boolean entryRuleParameter() throws RecognitionException {
        Boolean current = false;
        int entryRuleParameter_StartIndex = input.index();
        Boolean iv_ruleParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1679:51: (iv_ruleParameter= ruleParameter EOF )
            // PsiInternalExBeeLangTestLanguage.g:1680:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // PsiInternalExBeeLangTestLanguage.g:1686:1: ruleParameter returns [Boolean current=false] : ( (lv_expr_0_0= ruleExpression ) ) ;
    public final Boolean ruleParameter() throws RecognitionException {
        Boolean current = false;
        int ruleParameter_StartIndex = input.index();
        Boolean lv_expr_0_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1687:1: ( ( (lv_expr_0_0= ruleExpression ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1688:2: ( (lv_expr_0_0= ruleExpression ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1688:2: ( (lv_expr_0_0= ruleExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:1689:3: (lv_expr_0_0= ruleExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:1689:3: (lv_expr_0_0= ruleExpression )
            // PsiInternalExBeeLangTestLanguage.g:1690:4: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getParameter_ExprExpressionParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneComposite();
              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
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
            if ( state.backtracking>0 ) { memoize(input, 20, ruleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleClosureParameter"
    // PsiInternalExBeeLangTestLanguage.g:1706:1: entryRuleClosureParameter returns [Boolean current=false] : iv_ruleClosureParameter= ruleClosureParameter EOF ;
    public final Boolean entryRuleClosureParameter() throws RecognitionException {
        Boolean current = false;
        int entryRuleClosureParameter_StartIndex = input.index();
        Boolean iv_ruleClosureParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1706:58: (iv_ruleClosureParameter= ruleClosureParameter EOF )
            // PsiInternalExBeeLangTestLanguage.g:1707:2: iv_ruleClosureParameter= ruleClosureParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureParameterElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClosureParameter=ruleClosureParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosureParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureParameter"


    // $ANTLR start "ruleClosureParameter"
    // PsiInternalExBeeLangTestLanguage.g:1713:1: ruleClosureParameter returns [Boolean current=false] : ( (lv_expr_0_0= ruleClosureExpression ) ) ;
    public final Boolean ruleClosureParameter() throws RecognitionException {
        Boolean current = false;
        int ruleClosureParameter_StartIndex = input.index();
        Boolean lv_expr_0_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1714:1: ( ( (lv_expr_0_0= ruleClosureExpression ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1715:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1715:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:1716:3: (lv_expr_0_0= ruleClosureExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:1716:3: (lv_expr_0_0= ruleClosureExpression )
            // PsiInternalExBeeLangTestLanguage.g:1717:4: lv_expr_0_0= ruleClosureExpression
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getClosureParameter_ExprClosureExpressionParserRuleCall_0ElementType());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_0_0=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneComposite();
              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
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
            if ( state.backtracking>0 ) { memoize(input, 22, ruleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureParameter"


    // $ANTLR start "entryRuleParameterDeclaration"
    // PsiInternalExBeeLangTestLanguage.g:1733:1: entryRuleParameterDeclaration returns [Boolean current=false] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final Boolean entryRuleParameterDeclaration() throws RecognitionException {
        Boolean current = false;
        int entryRuleParameterDeclaration_StartIndex = input.index();
        Boolean iv_ruleParameterDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1733:62: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // PsiInternalExBeeLangTestLanguage.g:1734:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterDeclarationElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleParameterDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // PsiInternalExBeeLangTestLanguage.g:1740:1: ruleParameterDeclaration returns [Boolean current=false] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleParameterDeclaration() throws RecognitionException {
        Boolean current = false;
        int ruleParameterDeclaration_StartIndex = input.index();
        Token lv_name_1_0=null;
        Boolean lv_type_0_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1741:1: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1742:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1742:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1743:3: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1743:3: ( (lv_type_0_0= ruleTypeRef ) )?
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
                    // PsiInternalExBeeLangTestLanguage.g:1744:4: (lv_type_0_0= ruleTypeRef )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1744:4: (lv_type_0_0= ruleTypeRef )
                    // PsiInternalExBeeLangTestLanguage.g:1745:5: lv_type_0_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getParameterDeclaration_TypeTypeRefParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_type_0_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:1758:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:1759:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:1759:4: (lv_name_1_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:1760:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
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
        return current;
    }
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleFunction"
    // PsiInternalExBeeLangTestLanguage.g:1779:1: entryRuleFunction returns [Boolean current=false] : iv_ruleFunction= ruleFunction EOF ;
    public final Boolean entryRuleFunction() throws RecognitionException {
        Boolean current = false;
        int entryRuleFunction_StartIndex = input.index();
        Boolean iv_ruleFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1779:50: (iv_ruleFunction= ruleFunction EOF )
            // PsiInternalExBeeLangTestLanguage.g:1780:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFunctionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // PsiInternalExBeeLangTestLanguage.g:1786:1: ruleFunction returns [Boolean current=false] : ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) ;
    public final Boolean ruleFunction() throws RecognitionException {
        Boolean current = false;
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
        Boolean lv_returnType_4_0 = null;

        Boolean lv_parameters_7_0 = null;

        Boolean lv_parameters_9_0 = null;

        Boolean lv_parameters_12_0 = null;

        Boolean lv_parameters_14_0 = null;

        Boolean lv_guard_17_0 = null;

        Boolean lv_funcExpr_19_0 = null;

        Boolean lv_funcExpr_21_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:1787:1: ( ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1788:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1788:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:1789:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:1789:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_DOCUMENTATION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:1790:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1790:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    // PsiInternalExBeeLangTestLanguage.g:1791:5: lv_documentation_0_0= RULE_DOCUMENTATION
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_DocumentationDOCUMENTATIONTerminalRuleCall_0_0ElementType());
                      				
                    }
                    lv_documentation_0_0=(Token)match(input,RULE_DOCUMENTATION,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_documentation_0_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:1806:3: ( (lv_visibility_1_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:1807:4: (lv_visibility_1_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1807:4: (lv_visibility_1_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:1808:5: lv_visibility_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_VisibilityIDTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_visibility_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_visibility_1_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:1823:3: ( (lv_final_2_0= 'final' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:1824:4: (lv_final_2_0= 'final' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1824:4: (lv_final_2_0= 'final' )
                    // PsiInternalExBeeLangTestLanguage.g:1825:5: lv_final_2_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_FinalFinalKeyword_2_0ElementType());
                      				
                    }
                    lv_final_2_0=(Token)match(input,33,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_2_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFunction_FunctionKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:1847:3: ( (lv_returnType_4_0= ruleTypeRef ) )?
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
                    // PsiInternalExBeeLangTestLanguage.g:1848:4: (lv_returnType_4_0= ruleTypeRef )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:1848:4: (lv_returnType_4_0= ruleTypeRef )
                    // PsiInternalExBeeLangTestLanguage.g:1849:5: lv_returnType_4_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getFunction_ReturnTypeTypeRefParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_returnType_4_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:1862:3: ( (lv_name_5_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:1863:4: (lv_name_5_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:1863:4: (lv_name_5_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:1864:5: lv_name_5_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFunction_NameIDTerminalRuleCall_5_0ElementType());
              				
            }
            lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_5_0);
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:1879:3: (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:1880:4: otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_LeftParenthesisKeyword_6_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,35,FollowSets000.FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:1887:4: ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )?
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
                            // PsiInternalExBeeLangTestLanguage.g:1888:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:1888:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            // PsiInternalExBeeLangTestLanguage.g:1889:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            {
                            // PsiInternalExBeeLangTestLanguage.g:1889:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                            // PsiInternalExBeeLangTestLanguage.g:1890:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:1890:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            // PsiInternalExBeeLangTestLanguage.g:1891:8: lv_parameters_7_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_0_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_34);
                            lv_parameters_7_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalExBeeLangTestLanguage.g:1904:6: (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )*
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
                            	    // PsiInternalExBeeLangTestLanguage.g:1905:7: otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_8);
                            	      						
                            	    }
                            	    // PsiInternalExBeeLangTestLanguage.g:1912:7: ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    // PsiInternalExBeeLangTestLanguage.g:1913:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    {
                            	    // PsiInternalExBeeLangTestLanguage.g:1913:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    // PsiInternalExBeeLangTestLanguage.g:1914:9: lv_parameters_9_0= ruleParameterDeclaration
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_34);
                            	    lv_parameters_9_0=ruleParameterDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      									if(!current) {
                            	      										associateWithSemanticElement();
                            	      										current = true;
                            	      									}
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);

                            // PsiInternalExBeeLangTestLanguage.g:1928:6: (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==16) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // PsiInternalExBeeLangTestLanguage.g:1929:7: otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    {
                                    if ( state.backtracking==0 ) {

                                      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_2_0ElementType());
                                      						
                                    }
                                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							doneLeaf(otherlv_10);
                                      						
                                    }
                                    // PsiInternalExBeeLangTestLanguage.g:1936:7: ( (lv_varArgs_11_0= '...' ) )
                                    // PsiInternalExBeeLangTestLanguage.g:1937:8: (lv_varArgs_11_0= '...' )
                                    {
                                    // PsiInternalExBeeLangTestLanguage.g:1937:8: (lv_varArgs_11_0= '...' )
                                    // PsiInternalExBeeLangTestLanguage.g:1938:9: lv_varArgs_11_0= '...'
                                    {
                                    if ( state.backtracking==0 ) {

                                      									markLeaf(elementTypeProvider.getFunction_VarArgsFullStopFullStopFullStopKeyword_6_1_0_2_1_0ElementType());
                                      								
                                    }
                                    lv_varArgs_11_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									doneLeaf(lv_varArgs_11_0);
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (!current) {
                                      										associateWithSemanticElement();
                                      										current = true;
                                      									}
                                      								
                                    }

                                    }


                                    }

                                    // PsiInternalExBeeLangTestLanguage.g:1953:7: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    // PsiInternalExBeeLangTestLanguage.g:1954:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    {
                                    // PsiInternalExBeeLangTestLanguage.g:1954:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    // PsiInternalExBeeLangTestLanguage.g:1955:9: lv_parameters_12_0= ruleParameterDeclaration
                                    {
                                    if ( state.backtracking==0 ) {

                                      									markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_2_2_0ElementType());
                                      								
                                    }
                                    pushFollow(FollowSets000.FOLLOW_37);
                                    lv_parameters_12_0=ruleParameterDeclaration();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									doneComposite();
                                      									if(!current) {
                                      										associateWithSemanticElement();
                                      										current = true;
                                      									}
                                      								
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
                            // PsiInternalExBeeLangTestLanguage.g:1971:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:1971:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            // PsiInternalExBeeLangTestLanguage.g:1972:6: ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:1972:6: ( (lv_varArgs_13_0= '...' ) )
                            // PsiInternalExBeeLangTestLanguage.g:1973:7: (lv_varArgs_13_0= '...' )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:1973:7: (lv_varArgs_13_0= '...' )
                            // PsiInternalExBeeLangTestLanguage.g:1974:8: lv_varArgs_13_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getFunction_VarArgsFullStopFullStopFullStopKeyword_6_1_1_0_0ElementType());
                              							
                            }
                            lv_varArgs_13_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_varArgs_13_0);
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalExBeeLangTestLanguage.g:1989:6: ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            // PsiInternalExBeeLangTestLanguage.g:1990:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:1990:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            // PsiInternalExBeeLangTestLanguage.g:1991:8: lv_parameters_14_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_1_1_0ElementType());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            lv_parameters_14_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
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
                    otherlv_15=(Token)match(input,37,FollowSets000.FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_15);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:2014:3: (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2015:4: otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_WhenKeyword_7_0ElementType());
                      			
                    }
                    otherlv_16=(Token)match(input,26,FollowSets000.FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_16);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:2022:4: ( (lv_guard_17_0= ruleGuardExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2023:5: (lv_guard_17_0= ruleGuardExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2023:5: (lv_guard_17_0= ruleGuardExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2024:6: lv_guard_17_0= ruleGuardExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getFunction_GuardGuardExpressionParserRuleCall_7_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    lv_guard_17_0=ruleGuardExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:2038:3: ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            else if ( (LA38_0==17) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2039:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2039:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    // PsiInternalExBeeLangTestLanguage.g:2040:5: otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_ColonKeyword_8_0_0ElementType());
                      				
                    }
                    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_18);
                      				
                    }
                    // PsiInternalExBeeLangTestLanguage.g:2047:5: ( (lv_funcExpr_19_0= ruleExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2048:6: (lv_funcExpr_19_0= ruleExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2048:6: (lv_funcExpr_19_0= ruleExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2049:7: lv_funcExpr_19_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getFunction_FuncExprExpressionParserRuleCall_8_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_funcExpr_19_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_SemicolonKeyword_8_0_2ElementType());
                      				
                    }
                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_20);
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:2071:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2071:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2072:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2072:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2073:6: lv_funcExpr_21_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getFunction_FuncExprBlockExpressionParserRuleCall_8_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_funcExpr_21_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
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
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGuardExpression"
    // PsiInternalExBeeLangTestLanguage.g:2091:1: entryRuleGuardExpression returns [Boolean current=false] : iv_ruleGuardExpression= ruleGuardExpression EOF ;
    public final Boolean entryRuleGuardExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleGuardExpression_StartIndex = input.index();
        Boolean iv_ruleGuardExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2091:57: (iv_ruleGuardExpression= ruleGuardExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:2092:2: iv_ruleGuardExpression= ruleGuardExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getGuardExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGuardExpression=ruleGuardExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardExpression"


    // $ANTLR start "ruleGuardExpression"
    // PsiInternalExBeeLangTestLanguage.g:2098:1: ruleGuardExpression returns [Boolean current=false] : ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) ;
    public final Boolean ruleGuardExpression() throws RecognitionException {
        Boolean current = false;
        int ruleGuardExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_guardExpr_1_0 = null;

        Boolean lv_guardExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2099:1: ( ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:2100:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:2100:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) ) {
                alt39=1;
            }
            else if ( (LA39_0==17) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2101:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2101:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    // PsiInternalExBeeLangTestLanguage.g:2102:4: otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getGuardExpression_ColonKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:2109:4: ( (lv_guardExpr_1_0= ruleExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2110:5: (lv_guardExpr_1_0= ruleExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2110:5: (lv_guardExpr_1_0= ruleExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2111:6: lv_guardExpr_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getGuardExpression_GuardExprExpressionParserRuleCall_0_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_guardExpr_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getGuardExpression_SemicolonKeyword_0_2ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:2133:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2133:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2134:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2134:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2135:5: lv_guardExpr_3_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getGuardExpression_GuardExprBlockExpressionParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_guardExpr_3_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
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
            if ( state.backtracking>0 ) { memoize(input, 28, ruleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleGuardExpression"


    // $ANTLR start "entryRuleAssignmentOperator"
    // PsiInternalExBeeLangTestLanguage.g:2152:1: entryRuleAssignmentOperator returns [Boolean current=false] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final Boolean entryRuleAssignmentOperator() throws RecognitionException {
        Boolean current = false;
        int entryRuleAssignmentOperator_StartIndex = input.index();
        Boolean iv_ruleAssignmentOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2152:60: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // PsiInternalExBeeLangTestLanguage.g:2153:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAssignmentOperatorElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleAssignmentOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // PsiInternalExBeeLangTestLanguage.g:2159:1: ruleAssignmentOperator returns [Boolean current=false] : (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) ;
    public final Boolean ruleAssignmentOperator() throws RecognitionException {
        Boolean current = false;
        int ruleAssignmentOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2160:1: ( (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) )
            // PsiInternalExBeeLangTestLanguage.g:2161:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            {
            // PsiInternalExBeeLangTestLanguage.g:2161:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2162:3: kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_EqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:2170:3: kw= '+='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_PlusSignEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalExBeeLangTestLanguage.g:2178:3: kw= '-='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_HyphenMinusEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalExBeeLangTestLanguage.g:2186:3: kw= '*='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_AsteriskEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalExBeeLangTestLanguage.g:2194:3: kw= '/='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_SolidusEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalExBeeLangTestLanguage.g:2202:3: kw= '%='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_PercentSignEqualsSignKeyword_5ElementType());
                      		
                    }
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // PsiInternalExBeeLangTestLanguage.g:2213:1: entryRuleRelationalOperator returns [Boolean current=false] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final Boolean entryRuleRelationalOperator() throws RecognitionException {
        Boolean current = false;
        int entryRuleRelationalOperator_StartIndex = input.index();
        Boolean iv_ruleRelationalOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2213:60: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // PsiInternalExBeeLangTestLanguage.g:2214:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRelationalOperatorElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleRelationalOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // PsiInternalExBeeLangTestLanguage.g:2220:1: ruleRelationalOperator returns [Boolean current=false] : (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final Boolean ruleRelationalOperator() throws RecognitionException {
        Boolean current = false;
        int ruleRelationalOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2221:1: ( (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // PsiInternalExBeeLangTestLanguage.g:2222:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // PsiInternalExBeeLangTestLanguage.g:2222:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2223:3: kw= '~='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_TildeEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:2231:3: kw= '=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_EqualsSignEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalExBeeLangTestLanguage.g:2239:3: kw= '==='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalExBeeLangTestLanguage.g:2247:3: kw= '!='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_ExclamationMarkEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalExBeeLangTestLanguage.g:2255:3: kw= '!=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_ExclamationMarkEqualsSignEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalExBeeLangTestLanguage.g:2263:3: kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_GreaterThanSignEqualsSignKeyword_5ElementType());
                      		
                    }
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalExBeeLangTestLanguage.g:2271:3: kw= '<='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_LessThanSignEqualsSignKeyword_6ElementType());
                      		
                    }
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalExBeeLangTestLanguage.g:2279:3: kw= '>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_GreaterThanSignKeyword_7ElementType());
                      		
                    }
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalExBeeLangTestLanguage.g:2287:3: kw= '<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_LessThanSignKeyword_8ElementType());
                      		
                    }
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleTopLevelExpression"
    // PsiInternalExBeeLangTestLanguage.g:2298:1: entryRuleTopLevelExpression returns [Boolean current=false] : iv_ruleTopLevelExpression= ruleTopLevelExpression EOF ;
    public final Boolean entryRuleTopLevelExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleTopLevelExpression_StartIndex = input.index();
        Boolean iv_ruleTopLevelExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2298:60: (iv_ruleTopLevelExpression= ruleTopLevelExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:2299:2: iv_ruleTopLevelExpression= ruleTopLevelExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getTopLevelExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTopLevelExpression=ruleTopLevelExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopLevelExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleTopLevelExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelExpression"


    // $ANTLR start "ruleTopLevelExpression"
    // PsiInternalExBeeLangTestLanguage.g:2305:1: ruleTopLevelExpression returns [Boolean current=false] : (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) ;
    public final Boolean ruleTopLevelExpression() throws RecognitionException {
        Boolean current = false;
        int ruleTopLevelExpression_StartIndex = input.index();
        Boolean this_VarDeclaration_0 = null;

        Boolean this_ValDeclaration_1 = null;

        Boolean this_AssignmentExpression_2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2306:1: ( (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:2307:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:2307:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2308:3: this_VarDeclaration_0= ruleVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_VarDeclarationParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_VarDeclaration_0=ruleVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VarDeclaration_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:2320:3: this_ValDeclaration_1= ruleValDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_ValDeclarationParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ValDeclaration_1=ruleValDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValDeclaration_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalExBeeLangTestLanguage.g:2332:3: this_AssignmentExpression_2= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_AssignmentExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AssignmentExpression_2=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignmentExpression_2;
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
        return current;
    }
    // $ANTLR end "ruleTopLevelExpression"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalExBeeLangTestLanguage.g:2347:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleExpression_StartIndex = input.index();
        Boolean iv_ruleExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2347:52: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:2348:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalExBeeLangTestLanguage.g:2354:1: ruleExpression returns [Boolean current=false] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final Boolean ruleExpression() throws RecognitionException {
        Boolean current = false;
        int ruleExpression_StartIndex = input.index();
        Boolean this_AssignmentExpression_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2355:1: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // PsiInternalExBeeLangTestLanguage.g:2356:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getExpression_AssignmentExpressionParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
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
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // PsiInternalExBeeLangTestLanguage.g:2370:1: entryRuleAssignmentExpression returns [Boolean current=false] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final Boolean entryRuleAssignmentExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleAssignmentExpression_StartIndex = input.index();
        Boolean iv_ruleAssignmentExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2370:62: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:2371:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAssignmentExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleAssignmentExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // PsiInternalExBeeLangTestLanguage.g:2377:1: ruleAssignmentExpression returns [Boolean current=false] : (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final Boolean ruleAssignmentExpression() throws RecognitionException {
        Boolean current = false;
        int ruleAssignmentExpression_StartIndex = input.index();
        Boolean this_CachedExpression_0 = null;

        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2378:1: ( (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) )
            // PsiInternalExBeeLangTestLanguage.g:2379:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            {
            // PsiInternalExBeeLangTestLanguage.g:2379:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            // PsiInternalExBeeLangTestLanguage.g:2380:3: this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAssignmentExpression_CachedExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_40);
            this_CachedExpression_0=ruleCachedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CachedExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:2391:3: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            int alt43=2;
            switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA43_1 = input.LA(2);

                    if ( (synpred71_PsiInternalExBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 39:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred71_PsiInternalExBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred71_PsiInternalExBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred71_PsiInternalExBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA43_5 = input.LA(2);

                    if ( (synpred71_PsiInternalExBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA43_6 = input.LA(2);

                    if ( (synpred71_PsiInternalExBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
            }

            switch (alt43) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2392:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2392:4: ()
                    // PsiInternalExBeeLangTestLanguage.g:2393:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getAssignmentExpression_AssignmentExpressionLeftExprAction_1_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalExBeeLangTestLanguage.g:2402:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
                    // PsiInternalExBeeLangTestLanguage.g:2403:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2403:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    // PsiInternalExBeeLangTestLanguage.g:2404:6: lv_functionName_2_0= ruleAssignmentOperator
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getAssignmentExpression_FunctionNameAssignmentOperatorParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_19);
                    lv_functionName_2_0=ruleAssignmentOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:2417:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2418:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2418:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2419:6: lv_rightExpr_3_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getAssignmentExpression_RightExprAssignmentExpressionParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_rightExpr_3_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
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
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleVarDeclaration"
    // PsiInternalExBeeLangTestLanguage.g:2437:1: entryRuleVarDeclaration returns [Boolean current=false] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final Boolean entryRuleVarDeclaration() throws RecognitionException {
        Boolean current = false;
        int entryRuleVarDeclaration_StartIndex = input.index();
        Boolean iv_ruleVarDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2437:56: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // PsiInternalExBeeLangTestLanguage.g:2438:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getVarDeclarationElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVarDeclaration=ruleVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleVarDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // PsiInternalExBeeLangTestLanguage.g:2444:1: ruleVarDeclaration returns [Boolean current=false] : ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) ;
    public final Boolean ruleVarDeclaration() throws RecognitionException {
        Boolean current = false;
        int ruleVarDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_valueExpr_6_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2445:1: ( ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) )
            // PsiInternalExBeeLangTestLanguage.g:2446:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            {
            // PsiInternalExBeeLangTestLanguage.g:2446:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            // PsiInternalExBeeLangTestLanguage.g:2447:3: () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            {
            // PsiInternalExBeeLangTestLanguage.g:2447:3: ()
            // PsiInternalExBeeLangTestLanguage.g:2448:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getVarDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:2457:3: ( (lv_final_1_0= 'final' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==33) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2458:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2458:4: (lv_final_1_0= 'final' )
                    // PsiInternalExBeeLangTestLanguage.g:2459:5: lv_final_1_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getVarDeclaration_FinalFinalKeyword_1_0ElementType());
                      				
                    }
                    lv_final_1_0=(Token)match(input,33,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_1_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:2474:3: ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) )
            // PsiInternalExBeeLangTestLanguage.g:2475:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:2475:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==53) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_ID||LA45_0==35) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2476:5: otherlv_2= 'var'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getVarDeclaration_VarKeyword_2_0_0ElementType());
                      				
                    }
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_2);
                      				
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:2484:5: ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2484:5: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalExBeeLangTestLanguage.g:2485:6: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2485:6: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalExBeeLangTestLanguage.g:2486:7: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getVarDeclaration_TypeTypeRefParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:2500:4: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:2501:5: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:2501:5: (lv_name_4_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:2502:6: lv_name_4_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						markLeaf(elementTypeProvider.getVarDeclaration_NameIDTerminalRuleCall_2_1_0ElementType());
              					
            }
            lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if(!current) {
              							associateWithSemanticElement();
              							current = true;
              						}
              					
            }
            if ( state.backtracking==0 ) {

              						doneLeaf(lv_name_4_0);
              					
            }

            }


            }


            }

            // PsiInternalExBeeLangTestLanguage.g:2518:3: (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2519:4: otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getVarDeclaration_EqualsSignKeyword_3_0ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:2526:4: ( (lv_valueExpr_6_0= ruleExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2527:5: (lv_valueExpr_6_0= ruleExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2527:5: (lv_valueExpr_6_0= ruleExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2528:6: lv_valueExpr_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getVarDeclaration_ValueExprExpressionParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_valueExpr_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
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
        return current;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleValDeclaration"
    // PsiInternalExBeeLangTestLanguage.g:2546:1: entryRuleValDeclaration returns [Boolean current=false] : iv_ruleValDeclaration= ruleValDeclaration EOF ;
    public final Boolean entryRuleValDeclaration() throws RecognitionException {
        Boolean current = false;
        int entryRuleValDeclaration_StartIndex = input.index();
        Boolean iv_ruleValDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2546:56: (iv_ruleValDeclaration= ruleValDeclaration EOF )
            // PsiInternalExBeeLangTestLanguage.g:2547:2: iv_ruleValDeclaration= ruleValDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValDeclarationElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValDeclaration=ruleValDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleValDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValDeclaration"


    // $ANTLR start "ruleValDeclaration"
    // PsiInternalExBeeLangTestLanguage.g:2553:1: ruleValDeclaration returns [Boolean current=false] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) ;
    public final Boolean ruleValDeclaration() throws RecognitionException {
        Boolean current = false;
        int ruleValDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token lv_immutable_2_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_valueExpr_6_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2554:1: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:2555:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:2555:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            // PsiInternalExBeeLangTestLanguage.g:2556:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:2556:3: ()
            // PsiInternalExBeeLangTestLanguage.g:2557:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:2566:3: ( (lv_final_1_0= 'final' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==33) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2567:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2567:4: (lv_final_1_0= 'final' )
                    // PsiInternalExBeeLangTestLanguage.g:2568:5: lv_final_1_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getValDeclaration_FinalFinalKeyword_1_0ElementType());
                      				
                    }
                    lv_final_1_0=(Token)match(input,33,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_1_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:2583:3: ( (lv_immutable_2_0= 'val' ) )
            // PsiInternalExBeeLangTestLanguage.g:2584:4: (lv_immutable_2_0= 'val' )
            {
            // PsiInternalExBeeLangTestLanguage.g:2584:4: (lv_immutable_2_0= 'val' )
            // PsiInternalExBeeLangTestLanguage.g:2585:5: lv_immutable_2_0= 'val'
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValDeclaration_ImmutableValKeyword_2_0ElementType());
              				
            }
            lv_immutable_2_0=(Token)match(input,54,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_immutable_2_0);
              				
            }
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:2600:3: ( (lv_type_3_0= ruleTypeRef ) )?
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
                    // PsiInternalExBeeLangTestLanguage.g:2601:4: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2601:4: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalExBeeLangTestLanguage.g:2602:5: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getValDeclaration_TypeTypeRefParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:2615:3: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:2616:4: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:2616:4: (lv_name_4_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:2617:5: lv_name_4_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValDeclaration_NameIDTerminalRuleCall_4_0ElementType());
              				
            }
            lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_4_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getValDeclaration_EqualsSignKeyword_5ElementType());
              		
            }
            otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:2639:3: ( (lv_valueExpr_6_0= ruleExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:2640:4: (lv_valueExpr_6_0= ruleExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:2640:4: (lv_valueExpr_6_0= ruleExpression )
            // PsiInternalExBeeLangTestLanguage.g:2641:5: lv_valueExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getValDeclaration_ValueExprExpressionParserRuleCall_6_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_valueExpr_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
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
        return current;
    }
    // $ANTLR end "ruleValDeclaration"


    // $ANTLR start "entryRuleTypeRef"
    // PsiInternalExBeeLangTestLanguage.g:2658:1: entryRuleTypeRef returns [Boolean current=false] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final Boolean entryRuleTypeRef() throws RecognitionException {
        Boolean current = false;
        int entryRuleTypeRef_StartIndex = input.index();
        Boolean iv_ruleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2658:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // PsiInternalExBeeLangTestLanguage.g:2659:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getTypeRefElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // PsiInternalExBeeLangTestLanguage.g:2665:1: ruleTypeRef returns [Boolean current=false] : (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) ;
    public final Boolean ruleTypeRef() throws RecognitionException {
        Boolean current = false;
        int ruleTypeRef_StartIndex = input.index();
        Boolean this_ClosureTypeRef_0 = null;

        Boolean this_SimpleTypeRef_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2666:1: ( (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) )
            // PsiInternalExBeeLangTestLanguage.g:2667:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            {
            // PsiInternalExBeeLangTestLanguage.g:2667:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==35) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_ID) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2668:3: this_ClosureTypeRef_0= ruleClosureTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTypeRef_ClosureTypeRefParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClosureTypeRef_0=ruleClosureTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureTypeRef_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:2680:3: this_SimpleTypeRef_1= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTypeRef_SimpleTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimpleTypeRef_1=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SimpleTypeRef_1;
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
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleSimpleTypeRef"
    // PsiInternalExBeeLangTestLanguage.g:2695:1: entryRuleSimpleTypeRef returns [Boolean current=false] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final Boolean entryRuleSimpleTypeRef() throws RecognitionException {
        Boolean current = false;
        int entryRuleSimpleTypeRef_StartIndex = input.index();
        Boolean iv_ruleSimpleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2695:55: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // PsiInternalExBeeLangTestLanguage.g:2696:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSimpleTypeRefElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleTypeRef=ruleSimpleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleTypeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleSimpleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleTypeRef"


    // $ANTLR start "ruleSimpleTypeRef"
    // PsiInternalExBeeLangTestLanguage.g:2702:1: ruleSimpleTypeRef returns [Boolean current=false] : ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) ;
    public final Boolean ruleSimpleTypeRef() throws RecognitionException {
        Boolean current = false;
        int ruleSimpleTypeRef_StartIndex = input.index();
        Token lv_rawType_0_0=null;
        Token otherlv_1=null;
        Token lv_actualArgumentsList_2_0=null;
        Token otherlv_3=null;
        Token lv_actualArgumentsList_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2703:1: ( ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) )
            // PsiInternalExBeeLangTestLanguage.g:2704:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            {
            // PsiInternalExBeeLangTestLanguage.g:2704:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            // PsiInternalExBeeLangTestLanguage.g:2705:3: ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            {
            // PsiInternalExBeeLangTestLanguage.g:2705:3: ( (lv_rawType_0_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:2706:4: (lv_rawType_0_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:2706:4: (lv_rawType_0_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:2707:5: lv_rawType_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getSimpleTypeRef_RawTypeIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_rawType_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_rawType_0_0);
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:2722:3: (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2723:4: otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSimpleTypeRef_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:2730:4: ( (lv_actualArgumentsList_2_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:2731:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2731:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:2732:6: lv_actualArgumentsList_2_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSimpleTypeRef_ActualArgumentsListIDTerminalRuleCall_1_1_0ElementType());
                      					
                    }
                    lv_actualArgumentsList_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_actualArgumentsList_2_0);
                      					
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:2747:4: (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==16) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // PsiInternalExBeeLangTestLanguage.g:2748:5: otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getSimpleTypeRef_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:2755:5: ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:2756:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:2756:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    // PsiInternalExBeeLangTestLanguage.g:2757:7: lv_actualArgumentsList_4_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getSimpleTypeRef_ActualArgumentsListIDTerminalRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    lv_actualArgumentsList_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }
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
                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleSimpleTypeRef"


    // $ANTLR start "entryRuleClosureTypeRef"
    // PsiInternalExBeeLangTestLanguage.g:2785:1: entryRuleClosureTypeRef returns [Boolean current=false] : iv_ruleClosureTypeRef= ruleClosureTypeRef EOF ;
    public final Boolean entryRuleClosureTypeRef() throws RecognitionException {
        Boolean current = false;
        int entryRuleClosureTypeRef_StartIndex = input.index();
        Boolean iv_ruleClosureTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2785:56: (iv_ruleClosureTypeRef= ruleClosureTypeRef EOF )
            // PsiInternalExBeeLangTestLanguage.g:2786:2: iv_ruleClosureTypeRef= ruleClosureTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureTypeRefElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClosureTypeRef=ruleClosureTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosureTypeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleClosureTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureTypeRef"


    // $ANTLR start "ruleClosureTypeRef"
    // PsiInternalExBeeLangTestLanguage.g:2792:1: ruleClosureTypeRef returns [Boolean current=false] : (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) ;
    public final Boolean ruleClosureTypeRef() throws RecognitionException {
        Boolean current = false;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2793:1: ( (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:2794:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:2794:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            // PsiInternalExBeeLangTestLanguage.g:2795:3: otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:2802:3: ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )?
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
                    // PsiInternalExBeeLangTestLanguage.g:2803:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2803:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    // PsiInternalExBeeLangTestLanguage.g:2804:5: ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2804:5: ( (lv_parameterTypes_1_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:2805:6: (lv_parameterTypes_1_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2805:6: (lv_parameterTypes_1_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:2806:7: lv_parameterTypes_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_0_0ElementType());
                      						
                    }
                    lv_parameterTypes_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_parameterTypes_1_0);
                      						
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:2821:5: (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )*
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
                    	    // PsiInternalExBeeLangTestLanguage.g:2822:6: otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_1_0ElementType());
                    	      					
                    	    }
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						doneLeaf(otherlv_2);
                    	      					
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:2829:6: ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:2830:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:2830:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    // PsiInternalExBeeLangTestLanguage.g:2831:8: lv_parameterTypes_3_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_1_1_0ElementType());
                    	      							
                    	    }
                    	    lv_parameterTypes_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if(!current) {
                    	      									associateWithSemanticElement();
                    	      									current = true;
                    	      								}
                    	      							
                    	    }
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

                    // PsiInternalExBeeLangTestLanguage.g:2847:5: (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==16) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // PsiInternalExBeeLangTestLanguage.g:2848:6: otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) )
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_2_0ElementType());
                              					
                            }
                            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(otherlv_4);
                              					
                            }
                            // PsiInternalExBeeLangTestLanguage.g:2855:6: ( (lv_varArgs_5_0= '...' ) )
                            // PsiInternalExBeeLangTestLanguage.g:2856:7: (lv_varArgs_5_0= '...' )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:2856:7: (lv_varArgs_5_0= '...' )
                            // PsiInternalExBeeLangTestLanguage.g:2857:8: lv_varArgs_5_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getClosureTypeRef_VarArgsFullStopFullStopFullStopKeyword_1_0_2_1_0ElementType());
                              							
                            }
                            lv_varArgs_5_0=(Token)match(input,36,FollowSets000.FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_varArgs_5_0);
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalExBeeLangTestLanguage.g:2872:6: ( (lv_parameterTypes_6_0= RULE_ID ) )
                            // PsiInternalExBeeLangTestLanguage.g:2873:7: (lv_parameterTypes_6_0= RULE_ID )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:2873:7: (lv_parameterTypes_6_0= RULE_ID )
                            // PsiInternalExBeeLangTestLanguage.g:2874:8: lv_parameterTypes_6_0= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_2_2_0ElementType());
                              							
                            }
                            lv_parameterTypes_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }
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
                    // PsiInternalExBeeLangTestLanguage.g:2892:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2892:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    // PsiInternalExBeeLangTestLanguage.g:2893:5: ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2893:5: ( (lv_varArgs_7_0= '...' ) )
                    // PsiInternalExBeeLangTestLanguage.g:2894:6: (lv_varArgs_7_0= '...' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2894:6: (lv_varArgs_7_0= '...' )
                    // PsiInternalExBeeLangTestLanguage.g:2895:7: lv_varArgs_7_0= '...'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_VarArgsFullStopFullStopFullStopKeyword_1_1_0_0ElementType());
                      						
                    }
                    lv_varArgs_7_0=(Token)match(input,36,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_varArgs_7_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:2910:5: ( (lv_parameterTypes_8_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:2911:6: (lv_parameterTypes_8_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2911:6: (lv_parameterTypes_8_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:2912:7: lv_parameterTypes_8_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_1_1_0ElementType());
                      						
                    }
                    lv_parameterTypes_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
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
            otherlv_9=(Token)match(input,37,FollowSets000.FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_9);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_EqualsSignGreaterThanSignKeyword_3ElementType());
              		
            }
            otherlv_10=(Token)match(input,55,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:2943:3: ( (lv_returnType_11_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:2944:4: (lv_returnType_11_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:2944:4: (lv_returnType_11_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:2945:5: lv_returnType_11_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getClosureTypeRef_ReturnTypeIDTerminalRuleCall_4_0ElementType());
              				
            }
            lv_returnType_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
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
        return current;
    }
    // $ANTLR end "ruleClosureTypeRef"


    // $ANTLR start "entryRuleCachedExpression"
    // PsiInternalExBeeLangTestLanguage.g:2964:1: entryRuleCachedExpression returns [Boolean current=false] : iv_ruleCachedExpression= ruleCachedExpression EOF ;
    public final Boolean entryRuleCachedExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleCachedExpression_StartIndex = input.index();
        Boolean iv_ruleCachedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2964:58: (iv_ruleCachedExpression= ruleCachedExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:2965:2: iv_ruleCachedExpression= ruleCachedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getCachedExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCachedExpression=ruleCachedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCachedExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleCachedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCachedExpression"


    // $ANTLR start "ruleCachedExpression"
    // PsiInternalExBeeLangTestLanguage.g:2971:1: ruleCachedExpression returns [Boolean current=false] : ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) ;
    public final Boolean ruleCachedExpression() throws RecognitionException {
        Boolean current = false;
        int ruleCachedExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Boolean lv_expr_2_0 = null;

        Boolean this_OrExpression_3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:2972:1: ( ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:2973:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:2973:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_ID||LA55_0==RULE_STRING||LA55_0==13||(LA55_0>=17 && LA55_0<=18)||LA55_0==21||LA55_0==35||LA55_0==60||(LA55_0>=64 && LA55_0<=66)||LA55_0==70||(LA55_0>=72 && LA55_0<=76)) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:2974:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2974:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    // PsiInternalExBeeLangTestLanguage.g:2975:4: () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2975:4: ()
                    // PsiInternalExBeeLangTestLanguage.g:2976:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getCachedExpression_CachedExpressionAction_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getCachedExpression_CachedKeyword_0_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:2992:4: ( (lv_expr_2_0= ruleOrExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:2993:5: (lv_expr_2_0= ruleOrExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:2993:5: (lv_expr_2_0= ruleOrExpression )
                    // PsiInternalExBeeLangTestLanguage.g:2994:6: lv_expr_2_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getCachedExpression_ExprOrExpressionParserRuleCall_0_2_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_2_0=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:3009:3: this_OrExpression_3= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getCachedExpression_OrExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OrExpression_3=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OrExpression_3;
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
        return current;
    }
    // $ANTLR end "ruleCachedExpression"


    // $ANTLR start "entryRuleOrExpression"
    // PsiInternalExBeeLangTestLanguage.g:3024:1: entryRuleOrExpression returns [Boolean current=false] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final Boolean entryRuleOrExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleOrExpression_StartIndex = input.index();
        Boolean iv_ruleOrExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3024:54: (iv_ruleOrExpression= ruleOrExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3025:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOrExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // PsiInternalExBeeLangTestLanguage.g:3031:1: ruleOrExpression returns [Boolean current=false] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) ;
    public final Boolean ruleOrExpression() throws RecognitionException {
        Boolean current = false;
        int ruleOrExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Boolean this_AndExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3032:1: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3033:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3033:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:3034:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getOrExpression_AndExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_49);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3045:3: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==57) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred85_PsiInternalExBeeLangTestLanguage()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3046:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3046:4: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3047:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getOrExpression_OrExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getOrExpression_VerticalLineVerticalLineKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:3063:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3064:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3064:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:3065:6: lv_rightExpr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getOrExpression_RightExprAndExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_49);
            	    lv_rightExpr_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
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
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // PsiInternalExBeeLangTestLanguage.g:3083:1: entryRuleAndExpression returns [Boolean current=false] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final Boolean entryRuleAndExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleAndExpression_StartIndex = input.index();
        Boolean iv_ruleAndExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3083:55: (iv_ruleAndExpression= ruleAndExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3084:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAndExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // PsiInternalExBeeLangTestLanguage.g:3090:1: ruleAndExpression returns [Boolean current=false] : (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) ;
    public final Boolean ruleAndExpression() throws RecognitionException {
        Boolean current = false;
        int ruleAndExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Boolean this_RelationalExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3091:1: ( (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3092:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3092:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:3093:3: this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAndExpression_RelationalExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_50);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3104:3: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==58) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred86_PsiInternalExBeeLangTestLanguage()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3105:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3105:4: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3106:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAndExpression_AndExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAndExpression_AmpersandAmpersandKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:3122:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3123:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3123:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:3124:6: lv_rightExpr_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAndExpression_RightExprRelationalExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_50);
            	    lv_rightExpr_3_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
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
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // PsiInternalExBeeLangTestLanguage.g:3142:1: entryRuleRelationalExpression returns [Boolean current=false] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final Boolean entryRuleRelationalExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleRelationalExpression_StartIndex = input.index();
        Boolean iv_ruleRelationalExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3142:62: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3143:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRelationalExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // PsiInternalExBeeLangTestLanguage.g:3149:1: ruleRelationalExpression returns [Boolean current=false] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final Boolean ruleRelationalExpression() throws RecognitionException {
        Boolean current = false;
        int ruleRelationalExpression_StartIndex = input.index();
        Boolean this_AdditiveExpression_0 = null;

        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3150:1: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3151:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3151:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:3152:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getRelationalExpression_AdditiveExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_51);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3163:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3164:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3164:4: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3165:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getRelationalExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3174:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3175:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3175:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    // PsiInternalExBeeLangTestLanguage.g:3176:6: lv_functionName_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getRelationalExpression_FunctionNameRelationalOperatorParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_functionName_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3189:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3190:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3190:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:3191:6: lv_rightExpr_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getRelationalExpression_RightExprAdditiveExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_51);
            	    lv_rightExpr_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
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
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // PsiInternalExBeeLangTestLanguage.g:3209:1: entryRuleAdditiveExpression returns [Boolean current=false] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final Boolean entryRuleAdditiveExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleAdditiveExpression_StartIndex = input.index();
        Boolean iv_ruleAdditiveExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3209:60: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3210:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAdditiveExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // PsiInternalExBeeLangTestLanguage.g:3216:1: ruleAdditiveExpression returns [Boolean current=false] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final Boolean ruleAdditiveExpression() throws RecognitionException {
        Boolean current = false;
        int ruleAdditiveExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Boolean this_MultiplicativeExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3217:1: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3218:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3218:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:3219:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAdditiveExpression_MultiplicativeExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_52);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3230:3: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==59) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred89_PsiInternalExBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==60) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred89_PsiInternalExBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3231:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3231:4: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3232:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAdditiveExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3241:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3242:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3242:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3243:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3243:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==59) ) {
            	        alt59=1;
            	    }
            	    else if ( (LA59_0==60) ) {
            	        alt59=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 59, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // PsiInternalExBeeLangTestLanguage.g:3244:7: lv_functionName_2_1= '+'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNamePlusSignKeyword_1_1_0_0ElementType());
            	              						
            	            }
            	            lv_functionName_2_1=(Token)match(input,59,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_1);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalExBeeLangTestLanguage.g:3258:7: lv_functionName_2_2= '-'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNameHyphenMinusKeyword_1_1_0_1ElementType());
            	              						
            	            }
            	            lv_functionName_2_2=(Token)match(input,60,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_2);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3274:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3275:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3275:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:3276:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAdditiveExpression_RightExprMultiplicativeExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_52);
            	    lv_rightExpr_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
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
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // PsiInternalExBeeLangTestLanguage.g:3294:1: entryRuleMultiplicativeExpression returns [Boolean current=false] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final Boolean entryRuleMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleMultiplicativeExpression_StartIndex = input.index();
        Boolean iv_ruleMultiplicativeExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3294:66: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3295:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMultiplicativeExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // PsiInternalExBeeLangTestLanguage.g:3301:1: ruleMultiplicativeExpression returns [Boolean current=false] : (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) ;
    public final Boolean ruleMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;
        int ruleMultiplicativeExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        Boolean this_SetExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3302:1: ( (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3303:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3303:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:3304:3: this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getMultiplicativeExpression_SetExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_53);
            this_SetExpression_0=ruleSetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SetExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3315:3: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred92_PsiInternalExBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred92_PsiInternalExBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 62:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred92_PsiInternalExBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3316:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3316:4: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3317:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getMultiplicativeExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3326:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3327:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3327:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3328:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3328:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt61) {
            	        case 1 :
            	            // PsiInternalExBeeLangTestLanguage.g:3329:7: lv_functionName_2_1= '*'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNameAsteriskKeyword_1_1_0_0ElementType());
            	              						
            	            }
            	            lv_functionName_2_1=(Token)match(input,61,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_1);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalExBeeLangTestLanguage.g:3343:7: lv_functionName_2_2= '/'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNameSolidusKeyword_1_1_0_1ElementType());
            	              						
            	            }
            	            lv_functionName_2_2=(Token)match(input,32,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_2);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // PsiInternalExBeeLangTestLanguage.g:3357:7: lv_functionName_2_3= '%'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNamePercentSignKeyword_1_1_0_2ElementType());
            	              						
            	            }
            	            lv_functionName_2_3=(Token)match(input,62,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_3);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3373:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3374:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3374:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:3375:6: lv_rightExpr_3_0= ruleSetExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getMultiplicativeExpression_RightExprSetExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_53);
            	    lv_rightExpr_3_0=ruleSetExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
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
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleSetExpression"
    // PsiInternalExBeeLangTestLanguage.g:3393:1: entryRuleSetExpression returns [Boolean current=false] : iv_ruleSetExpression= ruleSetExpression EOF ;
    public final Boolean entryRuleSetExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleSetExpression_StartIndex = input.index();
        Boolean iv_ruleSetExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3393:55: (iv_ruleSetExpression= ruleSetExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3394:2: iv_ruleSetExpression= ruleSetExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSetExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSetExpression=ruleSetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleSetExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSetExpression"


    // $ANTLR start "ruleSetExpression"
    // PsiInternalExBeeLangTestLanguage.g:3400:1: ruleSetExpression returns [Boolean current=false] : (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) ;
    public final Boolean ruleSetExpression() throws RecognitionException {
        Boolean current = false;
        int ruleSetExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        Boolean this_UnaryOrInfixExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3401:1: ( (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3402:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3402:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:3403:3: this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getSetExpression_UnaryOrInfixExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_54);
            this_UnaryOrInfixExpression_0=ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryOrInfixExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3414:3: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==63) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred93_PsiInternalExBeeLangTestLanguage()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3415:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3415:4: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3416:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getSetExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3425:4: ( (lv_functionName_2_0= '..' ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3426:5: (lv_functionName_2_0= '..' )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3426:5: (lv_functionName_2_0= '..' )
            	    // PsiInternalExBeeLangTestLanguage.g:3427:6: lv_functionName_2_0= '..'
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markLeaf(elementTypeProvider.getSetExpression_FunctionNameFullStopFullStopKeyword_1_1_0ElementType());
            	      					
            	    }
            	    lv_functionName_2_0=(Token)match(input,63,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneLeaf(lv_functionName_2_0);
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalExBeeLangTestLanguage.g:3442:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3443:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3443:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:3444:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getSetExpression_RightExprUnaryOrInfixExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_54);
            	    lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
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
        return current;
    }
    // $ANTLR end "ruleSetExpression"


    // $ANTLR start "entryRuleUnaryOrInfixExpression"
    // PsiInternalExBeeLangTestLanguage.g:3462:1: entryRuleUnaryOrInfixExpression returns [Boolean current=false] : iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF ;
    public final Boolean entryRuleUnaryOrInfixExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleUnaryOrInfixExpression_StartIndex = input.index();
        Boolean iv_ruleUnaryOrInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3462:64: (iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3463:2: iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnaryOrInfixExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryOrInfixExpression=ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOrInfixExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleUnaryOrInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOrInfixExpression"


    // $ANTLR start "ruleUnaryOrInfixExpression"
    // PsiInternalExBeeLangTestLanguage.g:3469:1: ruleUnaryOrInfixExpression returns [Boolean current=false] : (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) ;
    public final Boolean ruleUnaryOrInfixExpression() throws RecognitionException {
        Boolean current = false;
        int ruleUnaryOrInfixExpression_StartIndex = input.index();
        Boolean this_PostopExpression_0 = null;

        Boolean this_UnaryExpression_1 = null;

        Boolean this_PreopExpression_2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3470:1: ( (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:3471:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:3471:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:3472:3: this_PostopExpression_0= rulePostopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_PostopExpressionParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PostopExpression_0=rulePostopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostopExpression_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:3484:3: this_UnaryExpression_1= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_UnaryExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnaryExpression_1=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalExBeeLangTestLanguage.g:3496:3: this_PreopExpression_2= rulePreopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_PreopExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PreopExpression_2=rulePreopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PreopExpression_2;
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
        return current;
    }
    // $ANTLR end "ruleUnaryOrInfixExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // PsiInternalExBeeLangTestLanguage.g:3511:1: entryRuleUnaryExpression returns [Boolean current=false] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final Boolean entryRuleUnaryExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleUnaryExpression_StartIndex = input.index();
        Boolean iv_ruleUnaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3511:57: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3512:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnaryExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, entryRuleUnaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // PsiInternalExBeeLangTestLanguage.g:3518:1: ruleUnaryExpression returns [Boolean current=false] : ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final Boolean ruleUnaryExpression() throws RecognitionException {
        Boolean current = false;
        int ruleUnaryExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        Boolean lv_expr_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3519:1: ( ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:3520:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:3520:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalExBeeLangTestLanguage.g:3521:3: () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:3521:3: ()
            // PsiInternalExBeeLangTestLanguage.g:3522:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnaryExpression_UnaryOpExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:3531:3: ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) )
            // PsiInternalExBeeLangTestLanguage.g:3532:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:3532:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            // PsiInternalExBeeLangTestLanguage.g:3533:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            {
            // PsiInternalExBeeLangTestLanguage.g:3533:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==64) ) {
                alt65=1;
            }
            else if ( (LA65_0==60) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:3534:6: lv_functionName_1_1= '!'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnaryExpression_FunctionNameExclamationMarkKeyword_1_0_0ElementType());
                      					
                    }
                    lv_functionName_1_1=(Token)match(input,64,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_1);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:3548:6: lv_functionName_1_2= '-'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnaryExpression_FunctionNameHyphenMinusKeyword_1_0_1ElementType());
                      					
                    }
                    lv_functionName_1_2=(Token)match(input,60,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_2);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalExBeeLangTestLanguage.g:3564:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:3565:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:3565:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalExBeeLangTestLanguage.g:3566:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getUnaryExpression_ExprInfixExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
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
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePreopExpression"
    // PsiInternalExBeeLangTestLanguage.g:3583:1: entryRulePreopExpression returns [Boolean current=false] : iv_rulePreopExpression= rulePreopExpression EOF ;
    public final Boolean entryRulePreopExpression() throws RecognitionException {
        Boolean current = false;
        int entryRulePreopExpression_StartIndex = input.index();
        Boolean iv_rulePreopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3583:57: (iv_rulePreopExpression= rulePreopExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3584:2: iv_rulePreopExpression= rulePreopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPreopExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePreopExpression=rulePreopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreopExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, entryRulePreopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePreopExpression"


    // $ANTLR start "rulePreopExpression"
    // PsiInternalExBeeLangTestLanguage.g:3590:1: rulePreopExpression returns [Boolean current=false] : ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final Boolean rulePreopExpression() throws RecognitionException {
        Boolean current = false;
        int rulePreopExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        Boolean lv_expr_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3591:1: ( ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:3592:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:3592:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalExBeeLangTestLanguage.g:3593:3: () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:3593:3: ()
            // PsiInternalExBeeLangTestLanguage.g:3594:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPreopExpression_UnaryPreOpExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:3603:3: ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) )
            // PsiInternalExBeeLangTestLanguage.g:3604:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:3604:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            // PsiInternalExBeeLangTestLanguage.g:3605:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            {
            // PsiInternalExBeeLangTestLanguage.g:3605:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==65) ) {
                alt66=1;
            }
            else if ( (LA66_0==66) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:3606:6: lv_functionName_1_1= '++'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPreopExpression_FunctionNamePlusSignPlusSignKeyword_1_0_0ElementType());
                      					
                    }
                    lv_functionName_1_1=(Token)match(input,65,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_1);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:3620:6: lv_functionName_1_2= '--'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPreopExpression_FunctionNameHyphenMinusHyphenMinusKeyword_1_0_1ElementType());
                      					
                    }
                    lv_functionName_1_2=(Token)match(input,66,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_2);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalExBeeLangTestLanguage.g:3636:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:3637:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:3637:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalExBeeLangTestLanguage.g:3638:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPreopExpression_ExprInfixExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
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
        return current;
    }
    // $ANTLR end "rulePreopExpression"


    // $ANTLR start "entryRulePostopExpression"
    // PsiInternalExBeeLangTestLanguage.g:3655:1: entryRulePostopExpression returns [Boolean current=false] : iv_rulePostopExpression= rulePostopExpression EOF ;
    public final Boolean entryRulePostopExpression() throws RecognitionException {
        Boolean current = false;
        int entryRulePostopExpression_StartIndex = input.index();
        Boolean iv_rulePostopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3655:58: (iv_rulePostopExpression= rulePostopExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3656:2: iv_rulePostopExpression= rulePostopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPostopExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePostopExpression=rulePostopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostopExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, entryRulePostopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePostopExpression"


    // $ANTLR start "rulePostopExpression"
    // PsiInternalExBeeLangTestLanguage.g:3662:1: rulePostopExpression returns [Boolean current=false] : (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) ;
    public final Boolean rulePostopExpression() throws RecognitionException {
        Boolean current = false;
        int rulePostopExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Boolean this_InfixExpression_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3663:1: ( (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) )
            // PsiInternalExBeeLangTestLanguage.g:3664:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            {
            // PsiInternalExBeeLangTestLanguage.g:3664:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            // PsiInternalExBeeLangTestLanguage.g:3665:3: this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPostopExpression_InfixExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_56);
            this_InfixExpression_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InfixExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3676:3: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==66) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred99_PsiInternalExBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            else if ( (LA68_0==65) ) {
                int LA68_2 = input.LA(2);

                if ( (synpred99_PsiInternalExBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:3677:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:3677:4: ()
                    // PsiInternalExBeeLangTestLanguage.g:3678:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPostopExpression_UnaryPostOpExpressionExprAction_1_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalExBeeLangTestLanguage.g:3687:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    // PsiInternalExBeeLangTestLanguage.g:3688:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:3688:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    // PsiInternalExBeeLangTestLanguage.g:3689:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:3689:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==66) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==65) ) {
                        alt67=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // PsiInternalExBeeLangTestLanguage.g:3690:7: lv_functionName_2_1= '--'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getPostopExpression_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_0ElementType());
                              						
                            }
                            lv_functionName_2_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_functionName_2_1);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }
                            break;
                        case 2 :
                            // PsiInternalExBeeLangTestLanguage.g:3704:7: lv_functionName_2_2= '++'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getPostopExpression_FunctionNamePlusSignPlusSignKeyword_1_1_0_1ElementType());
                              						
                            }
                            lv_functionName_2_2=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_functionName_2_2);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
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
        return current;
    }
    // $ANTLR end "rulePostopExpression"


    // $ANTLR start "entryRuleInfixExpression"
    // PsiInternalExBeeLangTestLanguage.g:3725:1: entryRuleInfixExpression returns [Boolean current=false] : iv_ruleInfixExpression= ruleInfixExpression EOF ;
    public final Boolean entryRuleInfixExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleInfixExpression_StartIndex = input.index();
        Boolean iv_ruleInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3725:57: (iv_ruleInfixExpression= ruleInfixExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3726:2: iv_ruleInfixExpression= ruleInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInfixExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInfixExpression=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixExpression"


    // $ANTLR start "ruleInfixExpression"
    // PsiInternalExBeeLangTestLanguage.g:3732:1: ruleInfixExpression returns [Boolean current=false] : (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) ;
    public final Boolean ruleInfixExpression() throws RecognitionException {
        Boolean current = false;
        int ruleInfixExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;
        Boolean this_CallExpression_0 = null;

        Boolean lv_parameterList_5_0 = null;

        Boolean lv_indexExpr_9_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3733:1: ( (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3734:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3734:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            // PsiInternalExBeeLangTestLanguage.g:3735:3: this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getInfixExpression_CallExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_57);
            this_CallExpression_0=ruleCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CallExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3746:3: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==67) ) {
                    int LA70_2 = input.LA(2);

                    if ( (synpred101_PsiInternalExBeeLangTestLanguage()) ) {
                        alt70=1;
                    }
                    else if ( (synpred103_PsiInternalExBeeLangTestLanguage()) ) {
                        alt70=3;
                    }


                }
                else if ( (LA70_0==68) ) {
                    int LA70_3 = input.LA(2);

                    if ( (synpred102_PsiInternalExBeeLangTestLanguage()) ) {
                        alt70=2;
                    }


                }


                switch (alt70) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3747:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3747:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    // PsiInternalExBeeLangTestLanguage.g:3748:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3748:5: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3749:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_CallFeatureFuncExprAction_1_0_0ElementType());
            	      						doneComposite();
            	      						associateWithSemanticElement();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_FullStopKeyword_1_0_1ElementType());
            	      				
            	    }
            	    otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_2);
            	      				
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:3765:5: ( (lv_name_3_0= RULE_ID ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3766:6: (lv_name_3_0= RULE_ID )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3766:6: (lv_name_3_0= RULE_ID )
            	    // PsiInternalExBeeLangTestLanguage.g:3767:7: lv_name_3_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType());
            	      						
            	    }
            	    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(lv_name_3_0);
            	      						
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_LeftParenthesisKeyword_1_0_3ElementType());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_4);
            	      				
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:3789:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==RULE_ID||LA69_0==RULE_STRING||LA69_0==13||(LA69_0>=17 && LA69_0<=18)||LA69_0==21||(LA69_0>=35 && LA69_0<=36)||LA69_0==52||LA69_0==56||LA69_0==60||(LA69_0>=64 && LA69_0<=66)||LA69_0==70||(LA69_0>=72 && LA69_0<=77)) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // PsiInternalExBeeLangTestLanguage.g:3790:6: (lv_parameterList_5_0= ruleParameterList )
            	            {
            	            // PsiInternalExBeeLangTestLanguage.g:3790:6: (lv_parameterList_5_0= ruleParameterList )
            	            // PsiInternalExBeeLangTestLanguage.g:3791:7: lv_parameterList_5_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markComposite(elementTypeProvider.getInfixExpression_ParameterListParameterListParserRuleCall_1_0_4_0ElementType());
            	              						
            	            }
            	            pushFollow(FollowSets000.FOLLOW_37);
            	            lv_parameterList_5_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneComposite();
            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_RightParenthesisKeyword_1_0_5ElementType());
            	      				
            	    }
            	    otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_6);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalExBeeLangTestLanguage.g:3813:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3813:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    // PsiInternalExBeeLangTestLanguage.g:3814:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3814:5: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3815:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_AtExpressionObjExprAction_1_1_0ElementType());
            	      						doneComposite();
            	      						associateWithSemanticElement();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_LeftSquareBracketKeyword_1_1_1ElementType());
            	      				
            	    }
            	    otherlv_8=(Token)match(input,68,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_8);
            	      				
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:3831:5: ( (lv_indexExpr_9_0= ruleExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3832:6: (lv_indexExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3832:6: (lv_indexExpr_9_0= ruleExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:3833:7: lv_indexExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getInfixExpression_IndexExprExpressionParserRuleCall_1_1_2_0ElementType());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_60);
            	    lv_indexExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_RightSquareBracketKeyword_1_1_3ElementType());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,69,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_10);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalExBeeLangTestLanguage.g:3855:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3855:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3856:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3856:5: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3857:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_FeatureExpressionObjExprAction_1_2_0ElementType());
            	      						doneComposite();
            	      						associateWithSemanticElement();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_FullStopKeyword_1_2_1ElementType());
            	      				
            	    }
            	    otherlv_12=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_12);
            	      				
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:3873:5: ( (lv_featureName_13_0= RULE_ID ) )
            	    // PsiInternalExBeeLangTestLanguage.g:3874:6: (lv_featureName_13_0= RULE_ID )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3874:6: (lv_featureName_13_0= RULE_ID )
            	    // PsiInternalExBeeLangTestLanguage.g:3875:7: lv_featureName_13_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getInfixExpression_FeatureNameIDTerminalRuleCall_1_2_2_0ElementType());
            	      						
            	    }
            	    lv_featureName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }
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
        return current;
    }
    // $ANTLR end "ruleInfixExpression"


    // $ANTLR start "entryRuleCallExpression"
    // PsiInternalExBeeLangTestLanguage.g:3896:1: entryRuleCallExpression returns [Boolean current=false] : iv_ruleCallExpression= ruleCallExpression EOF ;
    public final Boolean entryRuleCallExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleCallExpression_StartIndex = input.index();
        Boolean iv_ruleCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3896:56: (iv_ruleCallExpression= ruleCallExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3897:2: iv_ruleCallExpression= ruleCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getCallExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCallExpression=ruleCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, entryRuleCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCallExpression"


    // $ANTLR start "ruleCallExpression"
    // PsiInternalExBeeLangTestLanguage.g:3903:1: ruleCallExpression returns [Boolean current=false] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) ;
    public final Boolean ruleCallExpression() throws RecognitionException {
        Boolean current = false;
        int ruleCallExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean this_PrimaryExpression_0 = null;

        Boolean lv_parameterList_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3904:1: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) )
            // PsiInternalExBeeLangTestLanguage.g:3905:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:3905:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            // PsiInternalExBeeLangTestLanguage.g:3906:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getCallExpression_PrimaryExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FollowSets000.FOLLOW_61);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:3917:3: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==35) ) {
                    int LA72_2 = input.LA(2);

                    if ( (synpred105_PsiInternalExBeeLangTestLanguage()) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:3918:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:3918:4: ()
            	    // PsiInternalExBeeLangTestLanguage.g:3919:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getCallExpression_CallFunctionFuncExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getCallExpression_LeftParenthesisKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:3935:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==RULE_ID||LA71_0==RULE_STRING||LA71_0==13||(LA71_0>=17 && LA71_0<=18)||LA71_0==21||(LA71_0>=35 && LA71_0<=36)||LA71_0==52||LA71_0==56||LA71_0==60||(LA71_0>=64 && LA71_0<=66)||LA71_0==70||(LA71_0>=72 && LA71_0<=77)) ) {
            	        alt71=1;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // PsiInternalExBeeLangTestLanguage.g:3936:5: (lv_parameterList_3_0= ruleParameterList )
            	            {
            	            // PsiInternalExBeeLangTestLanguage.g:3936:5: (lv_parameterList_3_0= ruleParameterList )
            	            // PsiInternalExBeeLangTestLanguage.g:3937:6: lv_parameterList_3_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              						markComposite(elementTypeProvider.getCallExpression_ParameterListParameterListParserRuleCall_1_2_0ElementType());
            	              					
            	            }
            	            pushFollow(FollowSets000.FOLLOW_37);
            	            lv_parameterList_3_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneComposite();
            	              						if(!current) {
            	              							associateWithSemanticElement();
            	              							current = true;
            	              						}
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getCallExpression_RightParenthesisKeyword_1_3ElementType());
            	      			
            	    }
            	    otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_61); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // PsiInternalExBeeLangTestLanguage.g:3962:1: entryRulePrimaryExpression returns [Boolean current=false] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final Boolean entryRulePrimaryExpression() throws RecognitionException {
        Boolean current = false;
        int entryRulePrimaryExpression_StartIndex = input.index();
        Boolean iv_rulePrimaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3962:59: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:3963:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrimaryExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, entryRulePrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // PsiInternalExBeeLangTestLanguage.g:3969:1: rulePrimaryExpression returns [Boolean current=false] : (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) ;
    public final Boolean rulePrimaryExpression() throws RecognitionException {
        Boolean current = false;
        int rulePrimaryExpression_StartIndex = input.index();
        Boolean this_FeatureCall_0 = null;

        Boolean this_ConstructorCallExpression_1 = null;

        Boolean this_Value_2 = null;

        Boolean this_Literal_3 = null;

        Boolean this_KeywordVariables_4 = null;

        Boolean this_ParanthesizedExpression_5 = null;

        Boolean this_BlockExpression_6 = null;

        Boolean this_WithExpression_7 = null;

        Boolean this_WithContextExpression_8 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:3970:1: ( (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:3971:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:3971:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            int alt73=9;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:3972:3: this_FeatureCall_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_FeatureCallParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FeatureCall_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCall_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:3984:3: this_ConstructorCallExpression_1= ruleConstructorCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ConstructorCallExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ConstructorCallExpression_1=ruleConstructorCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstructorCallExpression_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalExBeeLangTestLanguage.g:3996:3: this_Value_2= ruleValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ValueParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Value_2=ruleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Value_2;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalExBeeLangTestLanguage.g:4008:3: this_Literal_3= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_LiteralParserRuleCall_3ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Literal_3=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_3;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalExBeeLangTestLanguage.g:4020:3: this_KeywordVariables_4= ruleKeywordVariables
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_KeywordVariablesParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_KeywordVariables_4=ruleKeywordVariables();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_KeywordVariables_4;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalExBeeLangTestLanguage.g:4032:3: this_ParanthesizedExpression_5= ruleParanthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ParanthesizedExpressionParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParanthesizedExpression_5=ruleParanthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParanthesizedExpression_5;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalExBeeLangTestLanguage.g:4044:3: this_BlockExpression_6= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_BlockExpressionParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BlockExpression_6=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpression_6;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalExBeeLangTestLanguage.g:4056:3: this_WithExpression_7= ruleWithExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_WithExpressionParserRuleCall_7ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithExpression_7=ruleWithExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithExpression_7;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalExBeeLangTestLanguage.g:4068:3: this_WithContextExpression_8= ruleWithContextExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_WithContextExpressionParserRuleCall_8ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithContextExpression_8=ruleWithContextExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithContextExpression_8;
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
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleWithExpression"
    // PsiInternalExBeeLangTestLanguage.g:4083:1: entryRuleWithExpression returns [Boolean current=false] : iv_ruleWithExpression= ruleWithExpression EOF ;
    public final Boolean entryRuleWithExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleWithExpression_StartIndex = input.index();
        Boolean iv_ruleWithExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4083:56: (iv_ruleWithExpression= ruleWithExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:4084:2: iv_ruleWithExpression= ruleWithExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getWithExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWithExpression=ruleWithExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWithExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleWithExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithExpression"


    // $ANTLR start "ruleWithExpression"
    // PsiInternalExBeeLangTestLanguage.g:4090:1: ruleWithExpression returns [Boolean current=false] : (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) ;
    public final Boolean ruleWithExpression() throws RecognitionException {
        Boolean current = false;
        int ruleWithExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_referencedAdvice_1_0=null;
        Token otherlv_2=null;
        Token lv_referencedAdvice_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Boolean lv_funcExpr_5_0 = null;

        Boolean lv_funcExpr_7_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4091:1: ( (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4092:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4092:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4093:3: otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithExpression_WithKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:4100:3: ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4101:4: ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4101:4: ( (lv_referencedAdvice_1_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:4102:5: (lv_referencedAdvice_1_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4102:5: (lv_referencedAdvice_1_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:4103:6: lv_referencedAdvice_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getWithExpression_ReferencedAdviceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_referencedAdvice_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_referencedAdvice_1_0);
                      					
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:4118:4: (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==16) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // PsiInternalExBeeLangTestLanguage.g:4119:5: otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getWithExpression_CommaKeyword_1_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_2);
                    	      				
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:4126:5: ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:4127:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:4127:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    // PsiInternalExBeeLangTestLanguage.g:4128:7: lv_referencedAdvice_3_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getWithExpression_ReferencedAdviceIDTerminalRuleCall_1_1_1_0ElementType());
                    	      						
                    	    }
                    	    lv_referencedAdvice_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_63); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }
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

            // PsiInternalExBeeLangTestLanguage.g:4145:3: ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==19) ) {
                alt76=1;
            }
            else if ( (LA76_0==17) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4146:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4146:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    // PsiInternalExBeeLangTestLanguage.g:4147:5: otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_ColonKeyword_2_0_0ElementType());
                      				
                    }
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_4);
                      				
                    }
                    // PsiInternalExBeeLangTestLanguage.g:4154:5: ( (lv_funcExpr_5_0= ruleExpression ) )
                    // PsiInternalExBeeLangTestLanguage.g:4155:6: (lv_funcExpr_5_0= ruleExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4155:6: (lv_funcExpr_5_0= ruleExpression )
                    // PsiInternalExBeeLangTestLanguage.g:4156:7: lv_funcExpr_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getWithExpression_FuncExprExpressionParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_funcExpr_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:4171:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4171:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    // PsiInternalExBeeLangTestLanguage.g:4172:5: otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_LeftCurlyBracketKeyword_2_1_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }
                    // PsiInternalExBeeLangTestLanguage.g:4179:5: ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) )
                    // PsiInternalExBeeLangTestLanguage.g:4180:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4180:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    // PsiInternalExBeeLangTestLanguage.g:4181:7: lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getWithExpression_FuncExprBlockExpressionWithoutBracketsParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_65);
                    lv_funcExpr_7_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_RightCurlyBracketKeyword_2_1_2ElementType());
                      				
                    }
                    otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleWithExpression"


    // $ANTLR start "entryRuleWithContextExpression"
    // PsiInternalExBeeLangTestLanguage.g:4207:1: entryRuleWithContextExpression returns [Boolean current=false] : iv_ruleWithContextExpression= ruleWithContextExpression EOF ;
    public final Boolean entryRuleWithContextExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleWithContextExpression_StartIndex = input.index();
        Boolean iv_ruleWithContextExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4207:63: (iv_ruleWithContextExpression= ruleWithContextExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:4208:2: iv_ruleWithContextExpression= ruleWithContextExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getWithContextExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWithContextExpression=ruleWithContextExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWithContextExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleWithContextExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithContextExpression"


    // $ANTLR start "ruleWithContextExpression"
    // PsiInternalExBeeLangTestLanguage.g:4214:1: ruleWithContextExpression returns [Boolean current=false] : (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) ;
    public final Boolean ruleWithContextExpression() throws RecognitionException {
        Boolean current = false;
        int ruleWithContextExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;
        Boolean lv_expr_2_0 = null;

        Boolean lv_contextBlock_5_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4215:1: ( (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4216:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4216:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4217:3: otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithContextExpression_WithKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithContextExpression_ContextKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:4231:3: ( (lv_expr_2_0= ruleExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:4232:4: (lv_expr_2_0= ruleExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:4232:4: (lv_expr_2_0= ruleExpression )
            // PsiInternalExBeeLangTestLanguage.g:4233:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getWithContextExpression_ExprExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_21);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:4246:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==28) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4247:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getWithContextExpression_AsKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:4254:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:4255:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4255:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:4256:6: lv_alias_4_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getWithContextExpression_AliasIDTerminalRuleCall_3_1_0ElementType());
                      					
                    }
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_4_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:4272:3: ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:4273:4: (lv_contextBlock_5_0= ruleBlockExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:4273:4: (lv_contextBlock_5_0= ruleBlockExpression )
            // PsiInternalExBeeLangTestLanguage.g:4274:5: lv_contextBlock_5_0= ruleBlockExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getWithContextExpression_ContextBlockBlockExpressionParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_contextBlock_5_0=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
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
        return current;
    }
    // $ANTLR end "ruleWithContextExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // PsiInternalExBeeLangTestLanguage.g:4291:1: entryRuleBlockExpression returns [Boolean current=false] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final Boolean entryRuleBlockExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleBlockExpression_StartIndex = input.index();
        Boolean iv_ruleBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4291:57: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:4292:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBlockExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBlockExpression=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // PsiInternalExBeeLangTestLanguage.g:4298:1: ruleBlockExpression returns [Boolean current=false] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final Boolean ruleBlockExpression() throws RecognitionException {
        Boolean current = false;
        int ruleBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_expressions_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4299:1: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // PsiInternalExBeeLangTestLanguage.g:4300:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // PsiInternalExBeeLangTestLanguage.g:4300:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // PsiInternalExBeeLangTestLanguage.g:4301:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            // PsiInternalExBeeLangTestLanguage.g:4301:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4302:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBlockExpression_ChainedExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:4318:3: ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==RULE_STRING||LA78_0==13||(LA78_0>=17 && LA78_0<=18)||LA78_0==21||LA78_0==33||LA78_0==35||(LA78_0>=53 && LA78_0<=54)||LA78_0==56||LA78_0==60||(LA78_0>=64 && LA78_0<=66)||LA78_0==70||(LA78_0>=72 && LA78_0<=76)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:4319:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';'
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:4319:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:4320:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:4320:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:4321:6: lv_expressions_2_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getBlockExpression_ExpressionsTopLevelExpressionParserRuleCall_2_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_expressions_2_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getBlockExpression_SemicolonKeyword_2_1ElementType());
            	      			
            	    }
            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_67); if (state.failed) return current;
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
            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleValue"
    // PsiInternalExBeeLangTestLanguage.g:4353:1: entryRuleValue returns [Boolean current=false] : iv_ruleValue= ruleValue EOF ;
    public final Boolean entryRuleValue() throws RecognitionException {
        Boolean current = false;
        int entryRuleValue_StartIndex = input.index();
        Boolean iv_ruleValue = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4353:47: (iv_ruleValue= ruleValue EOF )
            // PsiInternalExBeeLangTestLanguage.g:4354:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValueElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // PsiInternalExBeeLangTestLanguage.g:4360:1: ruleValue returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleValue() throws RecognitionException {
        Boolean current = false;
        int ruleValue_StartIndex = input.index();
        Token lv_name_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4361:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4362:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4362:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4363:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4363:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4364:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValue_VariableExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:4373:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:4374:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:4374:4: (lv_name_1_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:4375:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValue_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
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
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleKeywordVariables"
    // PsiInternalExBeeLangTestLanguage.g:4394:1: entryRuleKeywordVariables returns [Boolean current=false] : iv_ruleKeywordVariables= ruleKeywordVariables EOF ;
    public final Boolean entryRuleKeywordVariables() throws RecognitionException {
        Boolean current = false;
        int entryRuleKeywordVariables_StartIndex = input.index();
        Boolean iv_ruleKeywordVariables = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4394:58: (iv_ruleKeywordVariables= ruleKeywordVariables EOF )
            // PsiInternalExBeeLangTestLanguage.g:4395:2: iv_ruleKeywordVariables= ruleKeywordVariables EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getKeywordVariablesElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleKeywordVariables=ruleKeywordVariables();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeywordVariables; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleKeywordVariables_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordVariables"


    // $ANTLR start "ruleKeywordVariables"
    // PsiInternalExBeeLangTestLanguage.g:4401:1: ruleKeywordVariables returns [Boolean current=false] : ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) ;
    public final Boolean ruleKeywordVariables() throws RecognitionException {
        Boolean current = false;
        int ruleKeywordVariables_StartIndex = input.index();
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4402:1: ( ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4403:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4403:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4404:3: () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4404:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4405:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getKeywordVariables_VariableExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:4414:3: ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4415:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4415:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            // PsiInternalExBeeLangTestLanguage.g:4416:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            {
            // PsiInternalExBeeLangTestLanguage.g:4416:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4417:6: lv_name_1_1= 'input'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameInputKeyword_1_0_0ElementType());
                      					
                    }
                    lv_name_1_1=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_1);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:4431:6: lv_name_1_2= 'output'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameOutputKeyword_1_0_1ElementType());
                      					
                    }
                    lv_name_1_2=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_2);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalExBeeLangTestLanguage.g:4445:6: lv_name_1_3= 'source'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameSourceKeyword_1_0_2ElementType());
                      					
                    }
                    lv_name_1_3=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_3);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalExBeeLangTestLanguage.g:4459:6: lv_name_1_4= 'properties'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NamePropertiesKeyword_1_0_3ElementType());
                      					
                    }
                    lv_name_1_4=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_4);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalExBeeLangTestLanguage.g:4473:6: lv_name_1_5= 'builder'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameBuilderKeyword_1_0_4ElementType());
                      					
                    }
                    lv_name_1_5=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_5);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalExBeeLangTestLanguage.g:4487:6: lv_name_1_6= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameUnitKeyword_1_0_5ElementType());
                      					
                    }
                    lv_name_1_6=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_6);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalExBeeLangTestLanguage.g:4501:6: lv_name_1_7= 'this'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameThisKeyword_1_0_6ElementType());
                      					
                    }
                    lv_name_1_7=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_7);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
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
        return current;
    }
    // $ANTLR end "ruleKeywordVariables"


    // $ANTLR start "entryRuleFeatureCall"
    // PsiInternalExBeeLangTestLanguage.g:4521:1: entryRuleFeatureCall returns [Boolean current=false] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final Boolean entryRuleFeatureCall() throws RecognitionException {
        Boolean current = false;
        int entryRuleFeatureCall_StartIndex = input.index();
        Boolean iv_ruleFeatureCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4521:53: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // PsiInternalExBeeLangTestLanguage.g:4522:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureCallElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // PsiInternalExBeeLangTestLanguage.g:4528:1: ruleFeatureCall returns [Boolean current=false] : this_OperationCall_0= ruleOperationCall ;
    public final Boolean ruleFeatureCall() throws RecognitionException {
        Boolean current = false;
        int ruleFeatureCall_StartIndex = input.index();
        Boolean this_OperationCall_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4529:1: (this_OperationCall_0= ruleOperationCall )
            // PsiInternalExBeeLangTestLanguage.g:4530:2: this_OperationCall_0= ruleOperationCall
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getFeatureCall_OperationCallParserRuleCallElementType());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_OperationCall_0=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OperationCall_0;
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
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleOperationCall"
    // PsiInternalExBeeLangTestLanguage.g:4544:1: entryRuleOperationCall returns [Boolean current=false] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final Boolean entryRuleOperationCall() throws RecognitionException {
        Boolean current = false;
        int entryRuleOperationCall_StartIndex = input.index();
        Boolean iv_ruleOperationCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4544:55: (iv_ruleOperationCall= ruleOperationCall EOF )
            // PsiInternalExBeeLangTestLanguage.g:4545:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOperationCallElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperationCall=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationCall; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleOperationCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // PsiInternalExBeeLangTestLanguage.g:4551:1: ruleOperationCall returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) ;
    public final Boolean ruleOperationCall() throws RecognitionException {
        Boolean current = false;
        int ruleOperationCall_StartIndex = input.index();
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_parameterList_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4552:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) )
            // PsiInternalExBeeLangTestLanguage.g:4553:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            {
            // PsiInternalExBeeLangTestLanguage.g:4553:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            // PsiInternalExBeeLangTestLanguage.g:4554:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            {
            // PsiInternalExBeeLangTestLanguage.g:4554:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4555:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getOperationCall_CallNamedFunctionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:4564:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:4565:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:4565:4: (lv_name_1_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:4566:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getOperationCall_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperationCall_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:4588:3: ( (lv_parameterList_3_0= ruleParameterList ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||LA80_0==RULE_STRING||LA80_0==13||(LA80_0>=17 && LA80_0<=18)||LA80_0==21||(LA80_0>=35 && LA80_0<=36)||LA80_0==52||LA80_0==56||LA80_0==60||(LA80_0>=64 && LA80_0<=66)||LA80_0==70||(LA80_0>=72 && LA80_0<=77)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4589:4: (lv_parameterList_3_0= ruleParameterList )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4589:4: (lv_parameterList_3_0= ruleParameterList )
                    // PsiInternalExBeeLangTestLanguage.g:4590:5: lv_parameterList_3_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getOperationCall_ParameterListParameterListParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_37);
                    lv_parameterList_3_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperationCall_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleConstructorCallExpression"
    // PsiInternalExBeeLangTestLanguage.g:4614:1: entryRuleConstructorCallExpression returns [Boolean current=false] : iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF ;
    public final Boolean entryRuleConstructorCallExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleConstructorCallExpression_StartIndex = input.index();
        Boolean iv_ruleConstructorCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4614:67: (iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:4615:2: iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getConstructorCallExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConstructorCallExpression=ruleConstructorCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorCallExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleConstructorCallExpression"


    // $ANTLR start "ruleConstructorCallExpression"
    // PsiInternalExBeeLangTestLanguage.g:4621:1: ruleConstructorCallExpression returns [Boolean current=false] : ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) ;
    public final Boolean ruleConstructorCallExpression() throws RecognitionException {
        Boolean current = false;
        int ruleConstructorCallExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_typeExpr_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_alias_7_0=null;
        Boolean lv_parameterList_4_0 = null;

        Boolean lv_contextBlock_8_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4622:1: ( ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) )
            // PsiInternalExBeeLangTestLanguage.g:4623:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            {
            // PsiInternalExBeeLangTestLanguage.g:4623:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            // PsiInternalExBeeLangTestLanguage.g:4624:3: () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            {
            // PsiInternalExBeeLangTestLanguage.g:4624:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4625:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getConstructorCallExpression_CreateExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getConstructorCallExpression_NewKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:4641:3: ( (lv_typeExpr_2_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:4642:4: (lv_typeExpr_2_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:4642:4: (lv_typeExpr_2_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:4643:5: lv_typeExpr_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getConstructorCallExpression_TypeExprIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_typeExpr_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_typeExpr_2_0);
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:4658:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4659:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:4666:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID||LA81_0==RULE_STRING||LA81_0==13||(LA81_0>=17 && LA81_0<=18)||LA81_0==21||(LA81_0>=35 && LA81_0<=36)||LA81_0==52||LA81_0==56||LA81_0==60||(LA81_0>=64 && LA81_0<=66)||LA81_0==70||(LA81_0>=72 && LA81_0<=77)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // PsiInternalExBeeLangTestLanguage.g:4667:5: (lv_parameterList_4_0= ruleParameterList )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:4667:5: (lv_parameterList_4_0= ruleParameterList )
                            // PsiInternalExBeeLangTestLanguage.g:4668:6: lv_parameterList_4_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {

                              						markComposite(elementTypeProvider.getConstructorCallExpression_ParameterListParameterListParserRuleCall_3_1_0ElementType());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            lv_parameterList_4_0=ruleParameterList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						doneComposite();
                              						if(!current) {
                              							associateWithSemanticElement();
                              							current = true;
                              						}
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_RightParenthesisKeyword_3_2ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:4689:3: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==28) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ID) ) {
                    int LA83_3 = input.LA(3);

                    if ( (synpred128_PsiInternalExBeeLangTestLanguage()) ) {
                        alt83=1;
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4690:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:4697:4: ( (lv_alias_7_0= RULE_ID ) )
                    // PsiInternalExBeeLangTestLanguage.g:4698:5: (lv_alias_7_0= RULE_ID )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4698:5: (lv_alias_7_0= RULE_ID )
                    // PsiInternalExBeeLangTestLanguage.g:4699:6: lv_alias_7_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getConstructorCallExpression_AliasIDTerminalRuleCall_4_1_0ElementType());
                      					
                    }
                    lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_7_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:4715:3: ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
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
                    // PsiInternalExBeeLangTestLanguage.g:4716:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:4716:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    // PsiInternalExBeeLangTestLanguage.g:4717:5: lv_contextBlock_8_0= ruleInitializationBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getConstructorCallExpression_ContextBlockInitializationBlockExpressionParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_contextBlock_8_0=ruleInitializationBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
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
            if ( state.backtracking>0 ) { memoize(input, 92, ruleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleConstructorCallExpression"


    // $ANTLR start "entryRuleInitializationBlockExpression"
    // PsiInternalExBeeLangTestLanguage.g:4734:1: entryRuleInitializationBlockExpression returns [Boolean current=false] : iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF ;
    public final Boolean entryRuleInitializationBlockExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleInitializationBlockExpression_StartIndex = input.index();
        Boolean iv_ruleInitializationBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4734:71: (iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:4735:2: iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInitializationBlockExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInitializationBlockExpression=ruleInitializationBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitializationBlockExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleInitializationBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationBlockExpression"


    // $ANTLR start "ruleInitializationBlockExpression"
    // PsiInternalExBeeLangTestLanguage.g:4741:1: ruleInitializationBlockExpression returns [Boolean current=false] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) ;
    public final Boolean ruleInitializationBlockExpression() throws RecognitionException {
        Boolean current = false;
        int ruleInitializationBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_expressions_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4742:1: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) )
            // PsiInternalExBeeLangTestLanguage.g:4743:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            {
            // PsiInternalExBeeLangTestLanguage.g:4743:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            // PsiInternalExBeeLangTestLanguage.g:4744:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}'
            {
            // PsiInternalExBeeLangTestLanguage.g:4744:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4745:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getInitializationBlockExpression_ChainedExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:4761:3: ( (lv_expressions_2_0= ruleInitializationExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:4762:4: (lv_expressions_2_0= ruleInitializationExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:4762:4: (lv_expressions_2_0= ruleInitializationExpression )
            // PsiInternalExBeeLangTestLanguage.g:4763:5: lv_expressions_2_0= ruleInitializationExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationBlockExpression_ExpressionsInitializationExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_14);
            lv_expressions_2_0=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_SemicolonKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_RightCurlyBracketKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleInitializationBlockExpression"


    // $ANTLR start "entryRuleInitializationExpression"
    // PsiInternalExBeeLangTestLanguage.g:4794:1: entryRuleInitializationExpression returns [Boolean current=false] : iv_ruleInitializationExpression= ruleInitializationExpression EOF ;
    public final Boolean entryRuleInitializationExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleInitializationExpression_StartIndex = input.index();
        Boolean iv_ruleInitializationExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4794:66: (iv_ruleInitializationExpression= ruleInitializationExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:4795:2: iv_ruleInitializationExpression= ruleInitializationExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInitializationExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInitializationExpression=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitializationExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleInitializationExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationExpression"


    // $ANTLR start "ruleInitializationExpression"
    // PsiInternalExBeeLangTestLanguage.g:4801:1: ruleInitializationExpression returns [Boolean current=false] : ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) ;
    public final Boolean ruleInitializationExpression() throws RecognitionException {
        Boolean current = false;
        int ruleInitializationExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        Boolean lv_leftExpr_1_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4802:1: ( ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4803:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4803:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4804:3: () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4804:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4805:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getInitializationExpression_AssignmentExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:4814:3: ( (lv_leftExpr_1_0= ruleFeatureOfThis ) )
            // PsiInternalExBeeLangTestLanguage.g:4815:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            {
            // PsiInternalExBeeLangTestLanguage.g:4815:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            // PsiInternalExBeeLangTestLanguage.g:4816:5: lv_leftExpr_1_0= ruleFeatureOfThis
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationExpression_LeftExprFeatureOfThisParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
            lv_leftExpr_1_0=ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:4829:3: ( (lv_functionName_2_0= ':' ) )
            // PsiInternalExBeeLangTestLanguage.g:4830:4: (lv_functionName_2_0= ':' )
            {
            // PsiInternalExBeeLangTestLanguage.g:4830:4: (lv_functionName_2_0= ':' )
            // PsiInternalExBeeLangTestLanguage.g:4831:5: lv_functionName_2_0= ':'
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getInitializationExpression_FunctionNameColonKeyword_2_0ElementType());
              				
            }
            lv_functionName_2_0=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_functionName_2_0);
              				
            }
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalExBeeLangTestLanguage.g:4846:3: ( (lv_rightExpr_3_0= ruleExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:4847:4: (lv_rightExpr_3_0= ruleExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:4847:4: (lv_rightExpr_3_0= ruleExpression )
            // PsiInternalExBeeLangTestLanguage.g:4848:5: lv_rightExpr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationExpression_RightExprExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_rightExpr_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
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
        return current;
    }
    // $ANTLR end "ruleInitializationExpression"


    // $ANTLR start "entryRuleFeatureOfThis"
    // PsiInternalExBeeLangTestLanguage.g:4865:1: entryRuleFeatureOfThis returns [Boolean current=false] : iv_ruleFeatureOfThis= ruleFeatureOfThis EOF ;
    public final Boolean entryRuleFeatureOfThis() throws RecognitionException {
        Boolean current = false;
        int entryRuleFeatureOfThis_StartIndex = input.index();
        Boolean iv_ruleFeatureOfThis = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4865:55: (iv_ruleFeatureOfThis= ruleFeatureOfThis EOF )
            // PsiInternalExBeeLangTestLanguage.g:4866:2: iv_ruleFeatureOfThis= ruleFeatureOfThis EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureOfThisElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFeatureOfThis=ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureOfThis; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleFeatureOfThis_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureOfThis"


    // $ANTLR start "ruleFeatureOfThis"
    // PsiInternalExBeeLangTestLanguage.g:4872:1: ruleFeatureOfThis returns [Boolean current=false] : ( () ( (lv_featureName_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleFeatureOfThis() throws RecognitionException {
        Boolean current = false;
        int ruleFeatureOfThis_StartIndex = input.index();
        Token lv_featureName_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4873:1: ( ( () ( (lv_featureName_1_0= RULE_ID ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4874:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4874:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4875:3: () ( (lv_featureName_1_0= RULE_ID ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4875:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4876:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getFeatureOfThis_FeatureExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:4885:3: ( (lv_featureName_1_0= RULE_ID ) )
            // PsiInternalExBeeLangTestLanguage.g:4886:4: (lv_featureName_1_0= RULE_ID )
            {
            // PsiInternalExBeeLangTestLanguage.g:4886:4: (lv_featureName_1_0= RULE_ID )
            // PsiInternalExBeeLangTestLanguage.g:4887:5: lv_featureName_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFeatureOfThis_FeatureNameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_featureName_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
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
        return current;
    }
    // $ANTLR end "ruleFeatureOfThis"


    // $ANTLR start "entryRuleLiteral"
    // PsiInternalExBeeLangTestLanguage.g:4906:1: entryRuleLiteral returns [Boolean current=false] : iv_ruleLiteral= ruleLiteral EOF ;
    public final Boolean entryRuleLiteral() throws RecognitionException {
        Boolean current = false;
        int entryRuleLiteral_StartIndex = input.index();
        Boolean iv_ruleLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4906:49: (iv_ruleLiteral= ruleLiteral EOF )
            // PsiInternalExBeeLangTestLanguage.g:4907:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // PsiInternalExBeeLangTestLanguage.g:4913:1: ruleLiteral returns [Boolean current=false] : (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) ;
    public final Boolean ruleLiteral() throws RecognitionException {
        Boolean current = false;
        int ruleLiteral_StartIndex = input.index();
        Boolean this_ValueLiteral_0 = null;

        Boolean this_LiteralFunction_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4914:1: ( (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) )
            // PsiInternalExBeeLangTestLanguage.g:4915:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            {
            // PsiInternalExBeeLangTestLanguage.g:4915:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_STRING) ) {
                alt85=1;
            }
            else if ( (LA85_0==17) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:4916:3: this_ValueLiteral_0= ruleValueLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_ValueLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ValueLiteral_0=ruleValueLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValueLiteral_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:4928:3: this_LiteralFunction_1= ruleLiteralFunction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_LiteralFunctionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralFunction_1=ruleLiteralFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralFunction_1;
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
        return current;
    }
    // $ANTLR end "ruleLiteral"

}

@SuppressWarnings("all")
abstract class PsiInternalExBeeLangTestLanguageParser3 extends PsiInternalExBeeLangTestLanguageParser2 {

        PsiInternalExBeeLangTestLanguageParser3(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        PsiInternalExBeeLangTestLanguageParser3(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleLiteralFunction"
    // PsiInternalExBeeLangTestLanguage.g:4943:1: entryRuleLiteralFunction returns [Boolean current=false] : iv_ruleLiteralFunction= ruleLiteralFunction EOF ;
    public final Boolean entryRuleLiteralFunction() throws RecognitionException {
        Boolean current = false;
        int entryRuleLiteralFunction_StartIndex = input.index();
        Boolean iv_ruleLiteralFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4943:57: (iv_ruleLiteralFunction= ruleLiteralFunction EOF )
            // PsiInternalExBeeLangTestLanguage.g:4944:2: iv_ruleLiteralFunction= ruleLiteralFunction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralFunctionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralFunction=ruleLiteralFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralFunction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, entryRuleLiteralFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFunction"


    // $ANTLR start "ruleLiteralFunction"
    // PsiInternalExBeeLangTestLanguage.g:4950:1: ruleLiteralFunction returns [Boolean current=false] : (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) ;
    public final Boolean ruleLiteralFunction() throws RecognitionException {
        Boolean current = false;
        int ruleLiteralFunction_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_ClosureExpression_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4951:1: ( (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) )
            // PsiInternalExBeeLangTestLanguage.g:4952:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            {
            // PsiInternalExBeeLangTestLanguage.g:4952:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            // PsiInternalExBeeLangTestLanguage.g:4953:3: otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLiteralFunction_LeftCurlyBracketKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_70); if (state.failed) return current;
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
            this_ClosureExpression_1=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ClosureExpression_1;
              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLiteralFunction_RightCurlyBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleLiteralFunction"


    // $ANTLR start "entryRuleClosureExpression"
    // PsiInternalExBeeLangTestLanguage.g:4982:1: entryRuleClosureExpression returns [Boolean current=false] : iv_ruleClosureExpression= ruleClosureExpression EOF ;
    public final Boolean entryRuleClosureExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleClosureExpression_StartIndex = input.index();
        Boolean iv_ruleClosureExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4982:59: (iv_ruleClosureExpression= ruleClosureExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:4983:2: iv_ruleClosureExpression= ruleClosureExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClosureExpression=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosureExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, entryRuleClosureExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureExpression"


    // $ANTLR start "ruleClosureExpression"
    // PsiInternalExBeeLangTestLanguage.g:4989:1: ruleClosureExpression returns [Boolean current=false] : ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) ;
    public final Boolean ruleClosureExpression() throws RecognitionException {
        Boolean current = false;
        int ruleClosureExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        Token lv_varArgs_11_0=null;
        Token otherlv_13=null;
        Boolean lv_returnType_2_0 = null;

        Boolean lv_parameters_5_0 = null;

        Boolean lv_parameters_7_0 = null;

        Boolean lv_parameters_10_0 = null;

        Boolean lv_parameters_12_0 = null;

        Boolean lv_funcExpr_14_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:4990:1: ( ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4991:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4991:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            // PsiInternalExBeeLangTestLanguage.g:4992:3: () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:4992:3: ()
            // PsiInternalExBeeLangTestLanguage.g:4993:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getClosureExpression_FunctionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:5002:3: (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==52) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:5003:4: otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getClosureExpression_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalExBeeLangTestLanguage.g:5010:4: ( (lv_returnType_2_0= ruleTypeRef ) )
                    // PsiInternalExBeeLangTestLanguage.g:5011:5: (lv_returnType_2_0= ruleTypeRef )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5011:5: (lv_returnType_2_0= ruleTypeRef )
                    // PsiInternalExBeeLangTestLanguage.g:5012:6: lv_returnType_2_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getClosureExpression_ReturnTypeTypeRefParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_71);
                    lv_returnType_2_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getClosureExpression_GreaterThanSignKeyword_1_2ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalExBeeLangTestLanguage.g:5033:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?
            int alt90=3;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:5034:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5034:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    // PsiInternalExBeeLangTestLanguage.g:5035:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5035:5: (otherlv_4= '|' )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==77) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // PsiInternalExBeeLangTestLanguage.g:5036:6: otherlv_4= '|'
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getClosureExpression_VerticalLineKeyword_2_0_0ElementType());
                              					
                            }
                            otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(otherlv_4);
                              					
                            }

                            }
                            break;

                    }

                    // PsiInternalExBeeLangTestLanguage.g:5044:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    // PsiInternalExBeeLangTestLanguage.g:5045:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5045:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    // PsiInternalExBeeLangTestLanguage.g:5046:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5046:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    // PsiInternalExBeeLangTestLanguage.g:5047:8: lv_parameters_5_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_0_0ElementType());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_73);
                    lv_parameters_5_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:5060:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
                    	    // PsiInternalExBeeLangTestLanguage.g:5061:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_1_0ElementType());
                    	      						
                    	    }
                    	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_6);
                    	      						
                    	    }
                    	    // PsiInternalExBeeLangTestLanguage.g:5068:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    // PsiInternalExBeeLangTestLanguage.g:5069:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    {
                    	    // PsiInternalExBeeLangTestLanguage.g:5069:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    // PsiInternalExBeeLangTestLanguage.g:5070:9: lv_parameters_7_0= ruleParameterDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0ElementType());
                    	      								
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_73);
                    	    lv_parameters_7_0=ruleParameterDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									doneComposite();
                    	      									if(!current) {
                    	      										associateWithSemanticElement();
                    	      										current = true;
                    	      									}
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
                        }
                    } while (true);

                    // PsiInternalExBeeLangTestLanguage.g:5084:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==16) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // PsiInternalExBeeLangTestLanguage.g:5085:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_2_0ElementType());
                              						
                            }
                            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_8);
                              						
                            }
                            // PsiInternalExBeeLangTestLanguage.g:5092:7: ( (lv_varArgs_9_0= '...' ) )
                            // PsiInternalExBeeLangTestLanguage.g:5093:8: (lv_varArgs_9_0= '...' )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:5093:8: (lv_varArgs_9_0= '...' )
                            // PsiInternalExBeeLangTestLanguage.g:5094:9: lv_varArgs_9_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              									markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0ElementType());
                              								
                            }
                            lv_varArgs_9_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneLeaf(lv_varArgs_9_0);
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            // PsiInternalExBeeLangTestLanguage.g:5109:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            // PsiInternalExBeeLangTestLanguage.g:5110:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            {
                            // PsiInternalExBeeLangTestLanguage.g:5110:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            // PsiInternalExBeeLangTestLanguage.g:5111:9: lv_parameters_10_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0ElementType());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_74);
                            lv_parameters_10_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
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
                    // PsiInternalExBeeLangTestLanguage.g:5128:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5128:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    // PsiInternalExBeeLangTestLanguage.g:5129:5: ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5129:5: ( (lv_varArgs_11_0= '...' ) )
                    // PsiInternalExBeeLangTestLanguage.g:5130:6: (lv_varArgs_11_0= '...' )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5130:6: (lv_varArgs_11_0= '...' )
                    // PsiInternalExBeeLangTestLanguage.g:5131:7: lv_varArgs_11_0= '...'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_1_0_0ElementType());
                      						
                    }
                    lv_varArgs_11_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_varArgs_11_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalExBeeLangTestLanguage.g:5146:5: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    // PsiInternalExBeeLangTestLanguage.g:5147:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    {
                    // PsiInternalExBeeLangTestLanguage.g:5147:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    // PsiInternalExBeeLangTestLanguage.g:5148:7: lv_parameters_12_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_74);
                    lv_parameters_12_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
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
            otherlv_13=(Token)match(input,77,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_13);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:5170:3: ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            // PsiInternalExBeeLangTestLanguage.g:5171:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            {
            // PsiInternalExBeeLangTestLanguage.g:5171:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            // PsiInternalExBeeLangTestLanguage.g:5172:5: lv_funcExpr_14_0= ruleOneOrManyExpressions
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getClosureExpression_FuncExprOneOrManyExpressionsParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_funcExpr_14_0=ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
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
        return current;
    }
    // $ANTLR end "ruleClosureExpression"


    // $ANTLR start "entryRuleOneOrManyExpressions"
    // PsiInternalExBeeLangTestLanguage.g:5189:1: entryRuleOneOrManyExpressions returns [Boolean current=false] : iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF ;
    public final Boolean entryRuleOneOrManyExpressions() throws RecognitionException {
        Boolean current = false;
        int entryRuleOneOrManyExpressions_StartIndex = input.index();
        Boolean iv_ruleOneOrManyExpressions = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5189:62: (iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF )
            // PsiInternalExBeeLangTestLanguage.g:5190:2: iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOneOrManyExpressionsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOneOrManyExpressions=ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOneOrManyExpressions; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, entryRuleOneOrManyExpressions_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOneOrManyExpressions"


    // $ANTLR start "ruleOneOrManyExpressions"
    // PsiInternalExBeeLangTestLanguage.g:5196:1: ruleOneOrManyExpressions returns [Boolean current=false] : (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) ;
    public final Boolean ruleOneOrManyExpressions() throws RecognitionException {
        Boolean current = false;
        int ruleOneOrManyExpressions_StartIndex = input.index();
        Boolean this_BlockExpressionWithoutBrackets_0 = null;

        Boolean this_Expression_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5197:1: ( (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) )
            // PsiInternalExBeeLangTestLanguage.g:5198:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            {
            // PsiInternalExBeeLangTestLanguage.g:5198:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // PsiInternalExBeeLangTestLanguage.g:5199:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getOneOrManyExpressions_BlockExpressionWithoutBracketsParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BlockExpressionWithoutBrackets_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpressionWithoutBrackets_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalExBeeLangTestLanguage.g:5211:3: this_Expression_1= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getOneOrManyExpressions_ExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Expression_1;
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
        return current;
    }
    // $ANTLR end "ruleOneOrManyExpressions"


    // $ANTLR start "entryRuleBlockExpressionWithoutBrackets"
    // PsiInternalExBeeLangTestLanguage.g:5226:1: entryRuleBlockExpressionWithoutBrackets returns [Boolean current=false] : iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF ;
    public final Boolean entryRuleBlockExpressionWithoutBrackets() throws RecognitionException {
        Boolean current = false;
        int entryRuleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Boolean iv_ruleBlockExpressionWithoutBrackets = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5226:72: (iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF )
            // PsiInternalExBeeLangTestLanguage.g:5227:2: iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBlockExpressionWithoutBracketsElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBlockExpressionWithoutBrackets=ruleBlockExpressionWithoutBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpressionWithoutBrackets; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, entryRuleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpressionWithoutBrackets"


    // $ANTLR start "ruleBlockExpressionWithoutBrackets"
    // PsiInternalExBeeLangTestLanguage.g:5233:1: ruleBlockExpressionWithoutBrackets returns [Boolean current=false] : ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) ;
    public final Boolean ruleBlockExpressionWithoutBrackets() throws RecognitionException {
        Boolean current = false;
        int ruleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Token otherlv_2=null;
        Boolean lv_expressions_1_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5234:1: ( ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) )
            // PsiInternalExBeeLangTestLanguage.g:5235:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            {
            // PsiInternalExBeeLangTestLanguage.g:5235:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            // PsiInternalExBeeLangTestLanguage.g:5236:3: () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            {
            // PsiInternalExBeeLangTestLanguage.g:5236:3: ()
            // PsiInternalExBeeLangTestLanguage.g:5237:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBlockExpressionWithoutBrackets_ChainedExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalExBeeLangTestLanguage.g:5246:3: ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
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
            	    // PsiInternalExBeeLangTestLanguage.g:5247:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';'
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:5247:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) )
            	    // PsiInternalExBeeLangTestLanguage.g:5248:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalExBeeLangTestLanguage.g:5248:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    // PsiInternalExBeeLangTestLanguage.g:5249:6: lv_expressions_1_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getBlockExpressionWithoutBrackets_ExpressionsTopLevelExpressionParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_expressions_1_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getBlockExpressionWithoutBrackets_SemicolonKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_75); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt92 >= 1 ) break loop92;
            	    if (state.backtracking>0) {state.failed=true; return current;}
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
        return current;
    }
    // $ANTLR end "ruleBlockExpressionWithoutBrackets"


    // $ANTLR start "entryRuleValueLiteral"
    // PsiInternalExBeeLangTestLanguage.g:5274:1: entryRuleValueLiteral returns [Boolean current=false] : iv_ruleValueLiteral= ruleValueLiteral EOF ;
    public final Boolean entryRuleValueLiteral() throws RecognitionException {
        Boolean current = false;
        int entryRuleValueLiteral_StartIndex = input.index();
        Boolean iv_ruleValueLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5274:54: (iv_ruleValueLiteral= ruleValueLiteral EOF )
            // PsiInternalExBeeLangTestLanguage.g:5275:2: iv_ruleValueLiteral= ruleValueLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValueLiteralElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueLiteral=ruleValueLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, entryRuleValueLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValueLiteral"


    // $ANTLR start "ruleValueLiteral"
    // PsiInternalExBeeLangTestLanguage.g:5281:1: ruleValueLiteral returns [Boolean current=false] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final Boolean ruleValueLiteral() throws RecognitionException {
        Boolean current = false;
        int ruleValueLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5282:1: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // PsiInternalExBeeLangTestLanguage.g:5283:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // PsiInternalExBeeLangTestLanguage.g:5283:2: ( (lv_value_0_0= RULE_STRING ) )
            // PsiInternalExBeeLangTestLanguage.g:5284:3: (lv_value_0_0= RULE_STRING )
            {
            // PsiInternalExBeeLangTestLanguage.g:5284:3: (lv_value_0_0= RULE_STRING )
            // PsiInternalExBeeLangTestLanguage.g:5285:4: lv_value_0_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getValueLiteral_ValueSTRINGTerminalRuleCall_0ElementType());
              			
            }
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
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
        return current;
    }
    // $ANTLR end "ruleValueLiteral"


    // $ANTLR start "entryRuleParanthesizedExpression"
    // PsiInternalExBeeLangTestLanguage.g:5303:1: entryRuleParanthesizedExpression returns [Boolean current=false] : iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF ;
    public final Boolean entryRuleParanthesizedExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleParanthesizedExpression_StartIndex = input.index();
        Boolean iv_ruleParanthesizedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5303:65: (iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF )
            // PsiInternalExBeeLangTestLanguage.g:5304:2: iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParanthesizedExpressionElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParanthesizedExpression=ruleParanthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParanthesizedExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, entryRuleParanthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParanthesizedExpression"


    // $ANTLR start "ruleParanthesizedExpression"
    // PsiInternalExBeeLangTestLanguage.g:5310:1: ruleParanthesizedExpression returns [Boolean current=false] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final Boolean ruleParanthesizedExpression() throws RecognitionException {
        Boolean current = false;
        int ruleParanthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Expression_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5311:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // PsiInternalExBeeLangTestLanguage.g:5312:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // PsiInternalExBeeLangTestLanguage.g:5312:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // PsiInternalExBeeLangTestLanguage.g:5313:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getParanthesizedExpression_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_19); if (state.failed) return current;
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
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_1;
              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getParanthesizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleParanthesizedExpression"


    // $ANTLR start "entryRuleQID"
    // PsiInternalExBeeLangTestLanguage.g:5342:1: entryRuleQID returns [Boolean current=false] : iv_ruleQID= ruleQID EOF ;
    public final Boolean entryRuleQID() throws RecognitionException {
        Boolean current = false;
        int entryRuleQID_StartIndex = input.index();
        Boolean iv_ruleQID = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 113) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5344:2: (iv_ruleQID= ruleQID EOF )
            // PsiInternalExBeeLangTestLanguage.g:5345:2: iv_ruleQID= ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQIDElementType()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQID=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQID; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

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
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // PsiInternalExBeeLangTestLanguage.g:5354:1: ruleQID returns [Boolean current=false] : (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) ;
    public final Boolean ruleQID() throws RecognitionException {
        Boolean current = false;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 114) ) { return current; }
            // PsiInternalExBeeLangTestLanguage.g:5357:2: ( (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) )
            // PsiInternalExBeeLangTestLanguage.g:5358:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            {
            // PsiInternalExBeeLangTestLanguage.g:5358:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            // PsiInternalExBeeLangTestLanguage.g:5359:3: this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalExBeeLangTestLanguage.g:5366:3: (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )*
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
            	    // PsiInternalExBeeLangTestLanguage.g:5367:4: this_INT_1= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_INTTerminalRuleCall_1_0ElementType());
            	      			
            	    }
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_INT_1);
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // PsiInternalExBeeLangTestLanguage.g:5375:4: this_HEX_2= RULE_HEX
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_HEXTerminalRuleCall_1_1ElementType());
            	      			
            	    }
            	    this_HEX_2=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_HEX_2);
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // PsiInternalExBeeLangTestLanguage.g:5383:4: this_ID_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_1_2ElementType());
            	      			
            	    }
            	    this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_ID_3);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            // PsiInternalExBeeLangTestLanguage.g:5391:3: (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==67) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // PsiInternalExBeeLangTestLanguage.g:5392:4: kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_FullStopKeyword_2_0ElementType());
            	      			
            	    }
            	    kw=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(kw);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_2_1ElementType());
            	      			
            	    }
            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_ID_5);
            	      			
            	    }
            	    // PsiInternalExBeeLangTestLanguage.g:5406:4: (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
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
            	    	    // PsiInternalExBeeLangTestLanguage.g:5407:5: this_INT_6= RULE_INT
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_INTTerminalRuleCall_2_2_0ElementType());
            	    	      				
            	    	    }
            	    	    this_INT_6=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_INT_6);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // PsiInternalExBeeLangTestLanguage.g:5415:5: this_HEX_7= RULE_HEX
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_HEXTerminalRuleCall_2_2_1ElementType());
            	    	      				
            	    	    }
            	    	    this_HEX_7=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_HEX_7);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // PsiInternalExBeeLangTestLanguage.g:5423:5: this_ID_8= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_2_2_2ElementType());
            	    	      				
            	    	    }
            	    	    this_ID_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
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
        return current;
    }
    // $ANTLR end "ruleQID"

    // $ANTLR start synpred2_PsiInternalExBeeLangTestLanguage
    public final void synpred2_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_units_0_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:93:3: ( ( (lv_units_0_0= ruleUnit ) )* )
        // PsiInternalExBeeLangTestLanguage.g:93:3: ( (lv_units_0_0= ruleUnit ) )*
        {
        // PsiInternalExBeeLangTestLanguage.g:93:3: ( (lv_units_0_0= ruleUnit ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_DOCUMENTATION||LA96_0==13) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // PsiInternalExBeeLangTestLanguage.g:94:4: (lv_units_0_0= ruleUnit )
        	    {
        	    // PsiInternalExBeeLangTestLanguage.g:94:4: (lv_units_0_0= ruleUnit )
        	    // PsiInternalExBeeLangTestLanguage.g:95:5: lv_units_0_0= ruleUnit
        	    {
        	    if ( state.backtracking==0 ) {

        	      					markComposite(elementTypeProvider.getModel_UnitsUnitParserRuleCall_0_0ElementType());
        	      				
        	    }
        	    pushFollow(FollowSets000.FOLLOW_3);
        	    lv_units_0_0=ruleUnit();

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
    // $ANTLR end synpred2_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred9_PsiInternalExBeeLangTestLanguage
    public final void synpred9_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Boolean lv_sourceLocation_14_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:288:4: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:288:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:288:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:289:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
        }
        // PsiInternalExBeeLangTestLanguage.g:289:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:290:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
        // PsiInternalExBeeLangTestLanguage.g:293:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:293:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:293:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        // PsiInternalExBeeLangTestLanguage.g:293:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_SourceKeyword_7_0_0ElementType());
          								
        }
        otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:307:9: ( (lv_sourceLocation_14_0= rulePath ) )
        // PsiInternalExBeeLangTestLanguage.g:308:10: (lv_sourceLocation_14_0= rulePath )
        {
        // PsiInternalExBeeLangTestLanguage.g:308:10: (lv_sourceLocation_14_0= rulePath )
        // PsiInternalExBeeLangTestLanguage.g:309:11: lv_sourceLocation_14_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_SourceLocationPathParserRuleCall_7_0_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_sourceLocation_14_0=rulePath();

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
    // $ANTLR end synpred9_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred10_PsiInternalExBeeLangTestLanguage
    public final void synpred10_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Boolean lv_outputLocation_18_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:335:4: ( ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:335:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:335:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:336:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
        }
        // PsiInternalExBeeLangTestLanguage.g:336:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:337:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
        // PsiInternalExBeeLangTestLanguage.g:340:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:340:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:340:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        // PsiInternalExBeeLangTestLanguage.g:340:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_OutputKeyword_7_1_0ElementType());
          								
        }
        otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:354:9: ( (lv_outputLocation_18_0= rulePath ) )
        // PsiInternalExBeeLangTestLanguage.g:355:10: (lv_outputLocation_18_0= rulePath )
        {
        // PsiInternalExBeeLangTestLanguage.g:355:10: (lv_outputLocation_18_0= rulePath )
        // PsiInternalExBeeLangTestLanguage.g:356:11: lv_outputLocation_18_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_OutputLocationPathParserRuleCall_7_1_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_outputLocation_18_0=rulePath();

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
    // $ANTLR end synpred10_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred11_PsiInternalExBeeLangTestLanguage
    public final void synpred11_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Boolean lv_providedCapabilities_22_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:387:10: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:387:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:387:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        // PsiInternalExBeeLangTestLanguage.g:387:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
          								
        }
        otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:401:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        // PsiInternalExBeeLangTestLanguage.g:402:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        {
        // PsiInternalExBeeLangTestLanguage.g:402:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        // PsiInternalExBeeLangTestLanguage.g:403:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_providedCapabilities_22_0=ruleProvidedCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred12_PsiInternalExBeeLangTestLanguage
    public final void synpred12_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Boolean lv_providedCapabilities_22_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:382:4: ( ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) )
        // PsiInternalExBeeLangTestLanguage.g:382:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:382:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        // PsiInternalExBeeLangTestLanguage.g:383:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
        }
        // PsiInternalExBeeLangTestLanguage.g:383:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        // PsiInternalExBeeLangTestLanguage.g:384:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
        // PsiInternalExBeeLangTestLanguage.g:387:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
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
        	    // PsiInternalExBeeLangTestLanguage.g:387:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred12_PsiInternalExBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalExBeeLangTestLanguage.g:387:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    // PsiInternalExBeeLangTestLanguage.g:387:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
        	      								
        	    }
        	    otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalExBeeLangTestLanguage.g:401:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        	    // PsiInternalExBeeLangTestLanguage.g:402:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    {
        	    // PsiInternalExBeeLangTestLanguage.g:402:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    // PsiInternalExBeeLangTestLanguage.g:403:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
        	      										
        	    }
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    lv_providedCapabilities_22_0=ruleProvidedCapability();

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
    // $ANTLR end synpred12_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred13_PsiInternalExBeeLangTestLanguage
    public final void synpred13_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Boolean lv_requiredCapabilities_26_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:434:10: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:434:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:434:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        // PsiInternalExBeeLangTestLanguage.g:434:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
          								
        }
        otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:448:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        // PsiInternalExBeeLangTestLanguage.g:449:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        {
        // PsiInternalExBeeLangTestLanguage.g:449:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        // PsiInternalExBeeLangTestLanguage.g:450:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred14_PsiInternalExBeeLangTestLanguage
    public final void synpred14_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Boolean lv_requiredCapabilities_26_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:429:4: ( ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) )
        // PsiInternalExBeeLangTestLanguage.g:429:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:429:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        // PsiInternalExBeeLangTestLanguage.g:430:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred14_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
        }
        // PsiInternalExBeeLangTestLanguage.g:430:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        // PsiInternalExBeeLangTestLanguage.g:431:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
        // PsiInternalExBeeLangTestLanguage.g:434:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
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
        	    // PsiInternalExBeeLangTestLanguage.g:434:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred14_PsiInternalExBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalExBeeLangTestLanguage.g:434:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    // PsiInternalExBeeLangTestLanguage.g:434:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
        	      								
        	    }
        	    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalExBeeLangTestLanguage.g:448:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        	    // PsiInternalExBeeLangTestLanguage.g:449:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    {
        	    // PsiInternalExBeeLangTestLanguage.g:449:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    // PsiInternalExBeeLangTestLanguage.g:450:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
        	      										
        	    }
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

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
    // $ANTLR end synpred14_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred15_PsiInternalExBeeLangTestLanguage
    public final void synpred15_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Boolean lv_metaRequiredCapabilities_31_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:481:10: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:481:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:481:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        // PsiInternalExBeeLangTestLanguage.g:481:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
          								
        }
        otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:502:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        // PsiInternalExBeeLangTestLanguage.g:503:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        {
        // PsiInternalExBeeLangTestLanguage.g:503:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        // PsiInternalExBeeLangTestLanguage.g:504:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
          										
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred16_PsiInternalExBeeLangTestLanguage
    public final void synpred16_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Boolean lv_metaRequiredCapabilities_31_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:476:4: ( ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) )
        // PsiInternalExBeeLangTestLanguage.g:476:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:476:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        // PsiInternalExBeeLangTestLanguage.g:477:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
        }
        // PsiInternalExBeeLangTestLanguage.g:477:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        // PsiInternalExBeeLangTestLanguage.g:478:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
        // PsiInternalExBeeLangTestLanguage.g:481:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
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
        	    // PsiInternalExBeeLangTestLanguage.g:481:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred16_PsiInternalExBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalExBeeLangTestLanguage.g:481:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    // PsiInternalExBeeLangTestLanguage.g:481:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
        	      								
        	    }
        	    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        	    otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalExBeeLangTestLanguage.g:502:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        	    // PsiInternalExBeeLangTestLanguage.g:503:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    {
        	    // PsiInternalExBeeLangTestLanguage.g:503:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    // PsiInternalExBeeLangTestLanguage.g:504:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
        	      										
        	    }
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

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
    // $ANTLR end synpred16_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred17_PsiInternalExBeeLangTestLanguage
    public final void synpred17_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functions_33_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:535:10: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )
        // PsiInternalExBeeLangTestLanguage.g:535:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:535:19: ( (lv_functions_33_0= ruleFunction ) )
        // PsiInternalExBeeLangTestLanguage.g:535:20: (lv_functions_33_0= ruleFunction )
        {
        // PsiInternalExBeeLangTestLanguage.g:535:20: (lv_functions_33_0= ruleFunction )
        // PsiInternalExBeeLangTestLanguage.g:536:10: lv_functions_33_0= ruleFunction
        {
        if ( state.backtracking==0 ) {

          										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
          									
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_functions_33_0=ruleFunction();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred18_PsiInternalExBeeLangTestLanguage
    public final void synpred18_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functions_33_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:530:4: ( ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )
        // PsiInternalExBeeLangTestLanguage.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        // PsiInternalExBeeLangTestLanguage.g:531:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred18_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
        }
        // PsiInternalExBeeLangTestLanguage.g:531:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        // PsiInternalExBeeLangTestLanguage.g:532:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
        // PsiInternalExBeeLangTestLanguage.g:535:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
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
        	    // PsiInternalExBeeLangTestLanguage.g:535:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred18_PsiInternalExBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalExBeeLangTestLanguage.g:535:19: ( (lv_functions_33_0= ruleFunction ) )
        	    // PsiInternalExBeeLangTestLanguage.g:535:20: (lv_functions_33_0= ruleFunction )
        	    {
        	    // PsiInternalExBeeLangTestLanguage.g:535:20: (lv_functions_33_0= ruleFunction )
        	    // PsiInternalExBeeLangTestLanguage.g:536:10: lv_functions_33_0= ruleFunction
        	    {
        	    if ( state.backtracking==0 ) {

        	      										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
        	      									
        	    }
        	    pushFollow(FollowSets000.FOLLOW_4);
        	    lv_functions_33_0=ruleFunction();

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
    // $ANTLR end synpred18_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred20_PsiInternalExBeeLangTestLanguage
    public final void synpred20_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Boolean lv_condExpr_7_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:648:5: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:648:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:648:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:649:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
        }
        // PsiInternalExBeeLangTestLanguage.g:649:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:650:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
        // PsiInternalExBeeLangTestLanguage.g:653:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:653:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:653:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        // PsiInternalExBeeLangTestLanguage.g:653:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_WhenKeyword_2_1_0_0ElementType());
          									
        }
        otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:667:10: ( (lv_condExpr_7_0= ruleExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:668:11: (lv_condExpr_7_0= ruleExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:668:11: (lv_condExpr_7_0= ruleExpression )
        // PsiInternalExBeeLangTestLanguage.g:669:12: lv_condExpr_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getProvidedCapability_CondExprExpressionParserRuleCall_2_1_0_2_0ElementType());
          											
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_condExpr_7_0=ruleExpression();

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
    // $ANTLR end synpred20_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred21_PsiInternalExBeeLangTestLanguage
    public final void synpred21_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;

        // PsiInternalExBeeLangTestLanguage.g:695:5: ( ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:695:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:695:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:696:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
        }
        // PsiInternalExBeeLangTestLanguage.g:696:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:697:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
        // PsiInternalExBeeLangTestLanguage.g:700:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:700:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:700:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        // PsiInternalExBeeLangTestLanguage.g:700:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_NameKeyword_2_1_1_0ElementType());
          									
        }
        otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:714:10: ( (lv_name_11_0= RULE_ID ) )
        // PsiInternalExBeeLangTestLanguage.g:715:11: (lv_name_11_0= RULE_ID )
        {
        // PsiInternalExBeeLangTestLanguage.g:715:11: (lv_name_11_0= RULE_ID )
        // PsiInternalExBeeLangTestLanguage.g:716:12: lv_name_11_0= RULE_ID
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
    // $ANTLR end synpred21_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred22_PsiInternalExBeeLangTestLanguage
    public final void synpred22_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;

        // PsiInternalExBeeLangTestLanguage.g:744:5: ( ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:744:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:744:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:745:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
        }
        // PsiInternalExBeeLangTestLanguage.g:745:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:746:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
        // PsiInternalExBeeLangTestLanguage.g:749:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:749:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:749:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        // PsiInternalExBeeLangTestLanguage.g:749:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_VersionKeyword_2_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:763:10: ( (lv_version_15_0= RULE_ID ) )
        // PsiInternalExBeeLangTestLanguage.g:764:11: (lv_version_15_0= RULE_ID )
        {
        // PsiInternalExBeeLangTestLanguage.g:764:11: (lv_version_15_0= RULE_ID )
        // PsiInternalExBeeLangTestLanguage.g:765:12: lv_version_15_0= RULE_ID
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
    // $ANTLR end synpred22_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred26_PsiInternalExBeeLangTestLanguage
    public final void synpred26_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Boolean lv_condExpr_9_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:922:5: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:922:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:922:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:923:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalExBeeLangTestLanguage.g:923:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:924:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalExBeeLangTestLanguage.g:927:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:927:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:927:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        // PsiInternalExBeeLangTestLanguage.g:927:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:941:10: ( (lv_condExpr_9_0= ruleExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:942:11: (lv_condExpr_9_0= ruleExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:942:11: (lv_condExpr_9_0= ruleExpression )
        // PsiInternalExBeeLangTestLanguage.g:943:12: lv_condExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getAliasedRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
          											
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_condExpr_9_0=ruleExpression();

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
    // $ANTLR end synpred26_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred27_PsiInternalExBeeLangTestLanguage
    public final void synpred27_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;

        // PsiInternalExBeeLangTestLanguage.g:969:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:970:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalExBeeLangTestLanguage.g:970:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:971:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalExBeeLangTestLanguage.g:974:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:974:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:974:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        // PsiInternalExBeeLangTestLanguage.g:974:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
        {
        // PsiInternalExBeeLangTestLanguage.g:974:21: ( (lv_greedy_11_0= 'greedy' ) )
        // PsiInternalExBeeLangTestLanguage.g:975:11: (lv_greedy_11_0= 'greedy' )
        {
        // PsiInternalExBeeLangTestLanguage.g:975:11: (lv_greedy_11_0= 'greedy' )
        // PsiInternalExBeeLangTestLanguage.g:976:12: lv_greedy_11_0= 'greedy'
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
    // $ANTLR end synpred27_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred28_PsiInternalExBeeLangTestLanguage
    public final void synpred28_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;

        // PsiInternalExBeeLangTestLanguage.g:1004:5: ( ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1004:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1004:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1005:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1005:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1006:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalExBeeLangTestLanguage.g:1009:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1009:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1009:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1009:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:1023:10: ( (lv_min_15_0= RULE_INT ) )
        // PsiInternalExBeeLangTestLanguage.g:1024:11: (lv_min_15_0= RULE_INT )
        {
        // PsiInternalExBeeLangTestLanguage.g:1024:11: (lv_min_15_0= RULE_INT )
        // PsiInternalExBeeLangTestLanguage.g:1025:12: lv_min_15_0= RULE_INT
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
    // $ANTLR end synpred28_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred29_PsiInternalExBeeLangTestLanguage
    public final void synpred29_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;

        // PsiInternalExBeeLangTestLanguage.g:1053:5: ( ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1053:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1053:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1054:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1054:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1055:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalExBeeLangTestLanguage.g:1058:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1058:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1058:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1058:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:1072:10: ( (lv_max_19_0= RULE_INT ) )
        // PsiInternalExBeeLangTestLanguage.g:1073:11: (lv_max_19_0= RULE_INT )
        {
        // PsiInternalExBeeLangTestLanguage.g:1073:11: (lv_max_19_0= RULE_INT )
        // PsiInternalExBeeLangTestLanguage.g:1074:12: lv_max_19_0= RULE_INT
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
    // $ANTLR end synpred29_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred30_PsiInternalExBeeLangTestLanguage
    public final void synpred30_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;

        // PsiInternalExBeeLangTestLanguage.g:1102:5: ( ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1102:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1102:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1103:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1103:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1104:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalExBeeLangTestLanguage.g:1107:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1107:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1107:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1107:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_21=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:1121:10: ( (lv_versionRange_23_0= RULE_ID ) )
        // PsiInternalExBeeLangTestLanguage.g:1122:11: (lv_versionRange_23_0= RULE_ID )
        {
        // PsiInternalExBeeLangTestLanguage.g:1122:11: (lv_versionRange_23_0= RULE_ID )
        // PsiInternalExBeeLangTestLanguage.g:1123:12: lv_versionRange_23_0= RULE_ID
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
    // $ANTLR end synpred30_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred32_PsiInternalExBeeLangTestLanguage
    public final void synpred32_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Boolean lv_condExpr_8_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:1263:5: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1263:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1263:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1264:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1264:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1265:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalExBeeLangTestLanguage.g:1268:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1268:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1268:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1268:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:1282:10: ( (lv_condExpr_8_0= ruleExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:1283:11: (lv_condExpr_8_0= ruleExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:1283:11: (lv_condExpr_8_0= ruleExpression )
        // PsiInternalExBeeLangTestLanguage.g:1284:12: lv_condExpr_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
          											
        }
        pushFollow(FollowSets000.FOLLOW_14);
        lv_condExpr_8_0=ruleExpression();

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
    // $ANTLR end synpred32_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred33_PsiInternalExBeeLangTestLanguage
    public final void synpred33_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;

        // PsiInternalExBeeLangTestLanguage.g:1310:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1310:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1310:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1311:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1311:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1312:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalExBeeLangTestLanguage.g:1315:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1315:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1315:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1315:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
        {
        // PsiInternalExBeeLangTestLanguage.g:1315:21: ( (lv_greedy_10_0= 'greedy' ) )
        // PsiInternalExBeeLangTestLanguage.g:1316:11: (lv_greedy_10_0= 'greedy' )
        {
        // PsiInternalExBeeLangTestLanguage.g:1316:11: (lv_greedy_10_0= 'greedy' )
        // PsiInternalExBeeLangTestLanguage.g:1317:12: lv_greedy_10_0= 'greedy'
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
    // $ANTLR end synpred33_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred34_PsiInternalExBeeLangTestLanguage
    public final void synpred34_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;

        // PsiInternalExBeeLangTestLanguage.g:1345:5: ( ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1345:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1345:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1346:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1346:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1347:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalExBeeLangTestLanguage.g:1350:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1350:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1350:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1350:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:1364:10: ( (lv_min_14_0= RULE_INT ) )
        // PsiInternalExBeeLangTestLanguage.g:1365:11: (lv_min_14_0= RULE_INT )
        {
        // PsiInternalExBeeLangTestLanguage.g:1365:11: (lv_min_14_0= RULE_INT )
        // PsiInternalExBeeLangTestLanguage.g:1366:12: lv_min_14_0= RULE_INT
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
    // $ANTLR end synpred34_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred35_PsiInternalExBeeLangTestLanguage
    public final void synpred35_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;

        // PsiInternalExBeeLangTestLanguage.g:1394:5: ( ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1394:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1394:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1395:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1395:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1396:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalExBeeLangTestLanguage.g:1399:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1399:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1399:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1399:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_16=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:1413:10: ( (lv_max_18_0= RULE_INT ) )
        // PsiInternalExBeeLangTestLanguage.g:1414:11: (lv_max_18_0= RULE_INT )
        {
        // PsiInternalExBeeLangTestLanguage.g:1414:11: (lv_max_18_0= RULE_INT )
        // PsiInternalExBeeLangTestLanguage.g:1415:12: lv_max_18_0= RULE_INT
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
    // $ANTLR end synpred35_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred36_PsiInternalExBeeLangTestLanguage
    public final void synpred36_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;

        // PsiInternalExBeeLangTestLanguage.g:1443:5: ( ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1443:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:1443:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1444:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalExBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalExBeeLangTestLanguage.g:1444:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:1445:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalExBeeLangTestLanguage.g:1448:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        // PsiInternalExBeeLangTestLanguage.g:1448:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalExBeeLangTestLanguage", "true");
        }
        // PsiInternalExBeeLangTestLanguage.g:1448:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        // PsiInternalExBeeLangTestLanguage.g:1448:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:1462:10: ( (lv_versionRange_22_0= RULE_ID ) )
        // PsiInternalExBeeLangTestLanguage.g:1463:11: (lv_versionRange_22_0= RULE_ID )
        {
        // PsiInternalExBeeLangTestLanguage.g:1463:11: (lv_versionRange_22_0= RULE_ID )
        // PsiInternalExBeeLangTestLanguage.g:1464:12: lv_versionRange_22_0= RULE_ID
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
    // $ANTLR end synpred36_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred42_PsiInternalExBeeLangTestLanguage
    public final void synpred42_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_ClosureParameter_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:1652:3: (this_ClosureParameter_0= ruleClosureParameter )
        // PsiInternalExBeeLangTestLanguage.g:1652:3: this_ClosureParameter_0= ruleClosureParameter
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_ClosureParameter_0=ruleClosureParameter();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred69_PsiInternalExBeeLangTestLanguage
    public final void synpred69_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_VarDeclaration_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:2308:3: (this_VarDeclaration_0= ruleVarDeclaration )
        // PsiInternalExBeeLangTestLanguage.g:2308:3: this_VarDeclaration_0= ruleVarDeclaration
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_VarDeclaration_0=ruleVarDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred69_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred71_PsiInternalExBeeLangTestLanguage
    public final void synpred71_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:2392:4: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )
        // PsiInternalExBeeLangTestLanguage.g:2392:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:2392:4: ()
        // PsiInternalExBeeLangTestLanguage.g:2393:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalExBeeLangTestLanguage.g:2402:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
        // PsiInternalExBeeLangTestLanguage.g:2403:5: (lv_functionName_2_0= ruleAssignmentOperator )
        {
        // PsiInternalExBeeLangTestLanguage.g:2403:5: (lv_functionName_2_0= ruleAssignmentOperator )
        // PsiInternalExBeeLangTestLanguage.g:2404:6: lv_functionName_2_0= ruleAssignmentOperator
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAssignmentExpression_FunctionNameAssignmentOperatorParserRuleCall_1_1_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_19);
        lv_functionName_2_0=ruleAssignmentOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalExBeeLangTestLanguage.g:2417:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:2418:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:2418:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        // PsiInternalExBeeLangTestLanguage.g:2419:6: lv_rightExpr_3_0= ruleAssignmentExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAssignmentExpression_RightExprAssignmentExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleAssignmentExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred71_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred85_PsiInternalExBeeLangTestLanguage
    public final void synpred85_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3046:4: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3046:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3046:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3047:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:3063:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:3064:5: (lv_rightExpr_3_0= ruleAndExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:3064:5: (lv_rightExpr_3_0= ruleAndExpression )
        // PsiInternalExBeeLangTestLanguage.g:3065:6: lv_rightExpr_3_0= ruleAndExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getOrExpression_RightExprAndExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred85_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred86_PsiInternalExBeeLangTestLanguage
    public final void synpred86_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3105:4: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3105:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3105:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3106:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:3122:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:3123:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:3123:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        // PsiInternalExBeeLangTestLanguage.g:3124:6: lv_rightExpr_3_0= ruleRelationalExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAndExpression_RightExprRelationalExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred86_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred87_PsiInternalExBeeLangTestLanguage
    public final void synpred87_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3164:4: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3164:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3164:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3165:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalExBeeLangTestLanguage.g:3174:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
        // PsiInternalExBeeLangTestLanguage.g:3175:5: (lv_functionName_2_0= ruleRelationalOperator )
        {
        // PsiInternalExBeeLangTestLanguage.g:3175:5: (lv_functionName_2_0= ruleRelationalOperator )
        // PsiInternalExBeeLangTestLanguage.g:3176:6: lv_functionName_2_0= ruleRelationalOperator
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getRelationalExpression_FunctionNameRelationalOperatorParserRuleCall_1_1_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_19);
        lv_functionName_2_0=ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalExBeeLangTestLanguage.g:3189:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:3190:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:3190:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        // PsiInternalExBeeLangTestLanguage.g:3191:6: lv_rightExpr_3_0= ruleAdditiveExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getRelationalExpression_RightExprAdditiveExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred87_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred89_PsiInternalExBeeLangTestLanguage
    public final void synpred89_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3231:4: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3231:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3231:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3232:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalExBeeLangTestLanguage.g:3241:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3242:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3242:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        // PsiInternalExBeeLangTestLanguage.g:3243:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        {
        // PsiInternalExBeeLangTestLanguage.g:3243:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
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
                // PsiInternalExBeeLangTestLanguage.g:3244:7: lv_functionName_2_1= '+'
                {
                lv_functionName_2_1=(Token)match(input,59,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalExBeeLangTestLanguage.g:3258:7: lv_functionName_2_2= '-'
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

        // PsiInternalExBeeLangTestLanguage.g:3274:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:3275:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:3275:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        // PsiInternalExBeeLangTestLanguage.g:3276:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAdditiveExpression_RightExprMultiplicativeExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred89_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred92_PsiInternalExBeeLangTestLanguage
    public final void synpred92_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3316:4: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3316:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3316:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3317:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalExBeeLangTestLanguage.g:3326:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3327:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3327:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        // PsiInternalExBeeLangTestLanguage.g:3328:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        {
        // PsiInternalExBeeLangTestLanguage.g:3328:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
                // PsiInternalExBeeLangTestLanguage.g:3329:7: lv_functionName_2_1= '*'
                {
                lv_functionName_2_1=(Token)match(input,61,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalExBeeLangTestLanguage.g:3343:7: lv_functionName_2_2= '/'
                {
                lv_functionName_2_2=(Token)match(input,32,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 3 :
                // PsiInternalExBeeLangTestLanguage.g:3357:7: lv_functionName_2_3= '%'
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

        // PsiInternalExBeeLangTestLanguage.g:3373:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:3374:5: (lv_rightExpr_3_0= ruleSetExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:3374:5: (lv_rightExpr_3_0= ruleSetExpression )
        // PsiInternalExBeeLangTestLanguage.g:3375:6: lv_rightExpr_3_0= ruleSetExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getMultiplicativeExpression_RightExprSetExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleSetExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred92_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred93_PsiInternalExBeeLangTestLanguage
    public final void synpred93_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3415:4: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3415:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3415:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3416:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalExBeeLangTestLanguage.g:3425:4: ( (lv_functionName_2_0= '..' ) )
        // PsiInternalExBeeLangTestLanguage.g:3426:5: (lv_functionName_2_0= '..' )
        {
        // PsiInternalExBeeLangTestLanguage.g:3426:5: (lv_functionName_2_0= '..' )
        // PsiInternalExBeeLangTestLanguage.g:3427:6: lv_functionName_2_0= '..'
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSetExpression_FunctionNameFullStopFullStopKeyword_1_1_0ElementType());
          					
        }
        lv_functionName_2_0=(Token)match(input,63,FollowSets000.FOLLOW_19); if (state.failed) return ;

        }


        }

        // PsiInternalExBeeLangTestLanguage.g:3442:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:3443:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:3443:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        // PsiInternalExBeeLangTestLanguage.g:3444:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getSetExpression_RightExprUnaryOrInfixExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred93_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred99_PsiInternalExBeeLangTestLanguage
    public final void synpred99_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // PsiInternalExBeeLangTestLanguage.g:3677:4: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3677:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3677:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3678:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalExBeeLangTestLanguage.g:3687:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3688:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3688:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        // PsiInternalExBeeLangTestLanguage.g:3689:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        {
        // PsiInternalExBeeLangTestLanguage.g:3689:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
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
                // PsiInternalExBeeLangTestLanguage.g:3690:7: lv_functionName_2_1= '--'
                {
                lv_functionName_2_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalExBeeLangTestLanguage.g:3704:7: lv_functionName_2_2= '++'
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
    // $ANTLR end synpred99_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred101_PsiInternalExBeeLangTestLanguage
    public final void synpred101_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_parameterList_5_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3747:4: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) )
        // PsiInternalExBeeLangTestLanguage.g:3747:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        {
        // PsiInternalExBeeLangTestLanguage.g:3747:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        // PsiInternalExBeeLangTestLanguage.g:3748:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
        {
        // PsiInternalExBeeLangTestLanguage.g:3748:5: ()
        // PsiInternalExBeeLangTestLanguage.g:3749:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:3765:5: ( (lv_name_3_0= RULE_ID ) )
        // PsiInternalExBeeLangTestLanguage.g:3766:6: (lv_name_3_0= RULE_ID )
        {
        // PsiInternalExBeeLangTestLanguage.g:3766:6: (lv_name_3_0= RULE_ID )
        // PsiInternalExBeeLangTestLanguage.g:3767:7: lv_name_3_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          							markLeaf(elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType());
          						
        }
        lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:3789:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==RULE_ID||LA114_0==RULE_STRING||LA114_0==13||(LA114_0>=17 && LA114_0<=18)||LA114_0==21||(LA114_0>=35 && LA114_0<=36)||LA114_0==52||LA114_0==56||LA114_0==60||(LA114_0>=64 && LA114_0<=66)||LA114_0==70||(LA114_0>=72 && LA114_0<=77)) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // PsiInternalExBeeLangTestLanguage.g:3790:6: (lv_parameterList_5_0= ruleParameterList )
                {
                // PsiInternalExBeeLangTestLanguage.g:3790:6: (lv_parameterList_5_0= ruleParameterList )
                // PsiInternalExBeeLangTestLanguage.g:3791:7: lv_parameterList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  							markComposite(elementTypeProvider.getInfixExpression_ParameterListParameterListParserRuleCall_1_0_4_0ElementType());
                  						
                }
                pushFollow(FollowSets000.FOLLOW_37);
                lv_parameterList_5_0=ruleParameterList();

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
    // $ANTLR end synpred101_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred102_PsiInternalExBeeLangTestLanguage
    public final void synpred102_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token otherlv_10=null;
        Boolean lv_indexExpr_9_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3813:4: ( ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) )
        // PsiInternalExBeeLangTestLanguage.g:3813:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        {
        // PsiInternalExBeeLangTestLanguage.g:3813:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        // PsiInternalExBeeLangTestLanguage.g:3814:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
        {
        // PsiInternalExBeeLangTestLanguage.g:3814:5: ()
        // PsiInternalExBeeLangTestLanguage.g:3815:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_8=(Token)match(input,68,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:3831:5: ( (lv_indexExpr_9_0= ruleExpression ) )
        // PsiInternalExBeeLangTestLanguage.g:3832:6: (lv_indexExpr_9_0= ruleExpression )
        {
        // PsiInternalExBeeLangTestLanguage.g:3832:6: (lv_indexExpr_9_0= ruleExpression )
        // PsiInternalExBeeLangTestLanguage.g:3833:7: lv_indexExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          							markComposite(elementTypeProvider.getInfixExpression_IndexExprExpressionParserRuleCall_1_1_2_0ElementType());
          						
        }
        pushFollow(FollowSets000.FOLLOW_60);
        lv_indexExpr_9_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,69,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred102_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred103_PsiInternalExBeeLangTestLanguage
    public final void synpred103_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        // PsiInternalExBeeLangTestLanguage.g:3855:4: ( ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3855:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3855:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        // PsiInternalExBeeLangTestLanguage.g:3856:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:3856:5: ()
        // PsiInternalExBeeLangTestLanguage.g:3857:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_12=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:3873:5: ( (lv_featureName_13_0= RULE_ID ) )
        // PsiInternalExBeeLangTestLanguage.g:3874:6: (lv_featureName_13_0= RULE_ID )
        {
        // PsiInternalExBeeLangTestLanguage.g:3874:6: (lv_featureName_13_0= RULE_ID )
        // PsiInternalExBeeLangTestLanguage.g:3875:7: lv_featureName_13_0= RULE_ID
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
    // $ANTLR end synpred103_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred105_PsiInternalExBeeLangTestLanguage
    public final void synpred105_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_parameterList_3_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3918:4: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
        // PsiInternalExBeeLangTestLanguage.g:3918:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
        {
        // PsiInternalExBeeLangTestLanguage.g:3918:4: ()
        // PsiInternalExBeeLangTestLanguage.g:3919:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:3935:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==RULE_ID||LA115_0==RULE_STRING||LA115_0==13||(LA115_0>=17 && LA115_0<=18)||LA115_0==21||(LA115_0>=35 && LA115_0<=36)||LA115_0==52||LA115_0==56||LA115_0==60||(LA115_0>=64 && LA115_0<=66)||LA115_0==70||(LA115_0>=72 && LA115_0<=77)) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // PsiInternalExBeeLangTestLanguage.g:3936:5: (lv_parameterList_3_0= ruleParameterList )
                {
                // PsiInternalExBeeLangTestLanguage.g:3936:5: (lv_parameterList_3_0= ruleParameterList )
                // PsiInternalExBeeLangTestLanguage.g:3937:6: lv_parameterList_3_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						markComposite(elementTypeProvider.getCallExpression_ParameterListParameterListParserRuleCall_1_2_0ElementType());
                  					
                }
                pushFollow(FollowSets000.FOLLOW_37);
                lv_parameterList_3_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred106_PsiInternalExBeeLangTestLanguage
    public final void synpred106_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_FeatureCall_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:3972:3: (this_FeatureCall_0= ruleFeatureCall )
        // PsiInternalExBeeLangTestLanguage.g:3972:3: this_FeatureCall_0= ruleFeatureCall
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_FeatureCall_0=ruleFeatureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred108_PsiInternalExBeeLangTestLanguage
    public final void synpred108_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_Value_2 = null;


        // PsiInternalExBeeLangTestLanguage.g:3996:3: (this_Value_2= ruleValue )
        // PsiInternalExBeeLangTestLanguage.g:3996:3: this_Value_2= ruleValue
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_Value_2=ruleValue();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred108_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred109_PsiInternalExBeeLangTestLanguage
    public final void synpred109_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_Literal_3 = null;


        // PsiInternalExBeeLangTestLanguage.g:4008:3: (this_Literal_3= ruleLiteral )
        // PsiInternalExBeeLangTestLanguage.g:4008:3: this_Literal_3= ruleLiteral
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_Literal_3=ruleLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred109_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred112_PsiInternalExBeeLangTestLanguage
    public final void synpred112_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_BlockExpression_6 = null;


        // PsiInternalExBeeLangTestLanguage.g:4044:3: (this_BlockExpression_6= ruleBlockExpression )
        // PsiInternalExBeeLangTestLanguage.g:4044:3: this_BlockExpression_6= ruleBlockExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_BlockExpression_6=ruleBlockExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred113_PsiInternalExBeeLangTestLanguage
    public final void synpred113_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_WithExpression_7 = null;


        // PsiInternalExBeeLangTestLanguage.g:4056:3: (this_WithExpression_7= ruleWithExpression )
        // PsiInternalExBeeLangTestLanguage.g:4056:3: this_WithExpression_7= ruleWithExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_WithExpression_7=ruleWithExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred127_PsiInternalExBeeLangTestLanguage
    public final void synpred127_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean lv_parameterList_4_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:4659:4: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )
        // PsiInternalExBeeLangTestLanguage.g:4659:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
          			
        }
        otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:4666:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==RULE_STRING||LA117_0==13||(LA117_0>=17 && LA117_0<=18)||LA117_0==21||(LA117_0>=35 && LA117_0<=36)||LA117_0==52||LA117_0==56||LA117_0==60||(LA117_0>=64 && LA117_0<=66)||LA117_0==70||(LA117_0>=72 && LA117_0<=77)) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // PsiInternalExBeeLangTestLanguage.g:4667:5: (lv_parameterList_4_0= ruleParameterList )
                {
                // PsiInternalExBeeLangTestLanguage.g:4667:5: (lv_parameterList_4_0= ruleParameterList )
                // PsiInternalExBeeLangTestLanguage.g:4668:6: lv_parameterList_4_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						markComposite(elementTypeProvider.getConstructorCallExpression_ParameterListParameterListParserRuleCall_3_1_0ElementType());
                  					
                }
                pushFollow(FollowSets000.FOLLOW_37);
                lv_parameterList_4_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred127_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred128_PsiInternalExBeeLangTestLanguage
    public final void synpred128_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        // PsiInternalExBeeLangTestLanguage.g:4690:4: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )
        // PsiInternalExBeeLangTestLanguage.g:4690:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
          			
        }
        otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // PsiInternalExBeeLangTestLanguage.g:4697:4: ( (lv_alias_7_0= RULE_ID ) )
        // PsiInternalExBeeLangTestLanguage.g:4698:5: (lv_alias_7_0= RULE_ID )
        {
        // PsiInternalExBeeLangTestLanguage.g:4698:5: (lv_alias_7_0= RULE_ID )
        // PsiInternalExBeeLangTestLanguage.g:4699:6: lv_alias_7_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getConstructorCallExpression_AliasIDTerminalRuleCall_4_1_0ElementType());
          					
        }
        lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred128_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred135_PsiInternalExBeeLangTestLanguage
    public final void synpred135_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        Boolean lv_parameters_5_0 = null;

        Boolean lv_parameters_7_0 = null;

        Boolean lv_parameters_10_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:5034:4: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) )
        // PsiInternalExBeeLangTestLanguage.g:5034:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        {
        // PsiInternalExBeeLangTestLanguage.g:5034:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        // PsiInternalExBeeLangTestLanguage.g:5035:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        {
        // PsiInternalExBeeLangTestLanguage.g:5035:5: (otherlv_4= '|' )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==77) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // PsiInternalExBeeLangTestLanguage.g:5036:6: otherlv_4= '|'
                {
                otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }
                break;

        }

        // PsiInternalExBeeLangTestLanguage.g:5044:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        // PsiInternalExBeeLangTestLanguage.g:5045:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        {
        // PsiInternalExBeeLangTestLanguage.g:5045:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
        // PsiInternalExBeeLangTestLanguage.g:5046:7: (lv_parameters_5_0= ruleParameterDeclaration )
        {
        // PsiInternalExBeeLangTestLanguage.g:5046:7: (lv_parameters_5_0= ruleParameterDeclaration )
        // PsiInternalExBeeLangTestLanguage.g:5047:8: lv_parameters_5_0= ruleParameterDeclaration
        {
        if ( state.backtracking==0 ) {

          								markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_0_0ElementType());
          							
        }
        pushFollow(FollowSets000.FOLLOW_26);
        lv_parameters_5_0=ruleParameterDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalExBeeLangTestLanguage.g:5060:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
        	    // PsiInternalExBeeLangTestLanguage.g:5061:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    {
        	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
        	    // PsiInternalExBeeLangTestLanguage.g:5068:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    // PsiInternalExBeeLangTestLanguage.g:5069:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    {
        	    // PsiInternalExBeeLangTestLanguage.g:5069:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    // PsiInternalExBeeLangTestLanguage.g:5070:9: lv_parameters_7_0= ruleParameterDeclaration
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0ElementType());
        	      								
        	    }
        	    pushFollow(FollowSets000.FOLLOW_26);
        	    lv_parameters_7_0=ruleParameterDeclaration();

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

        // PsiInternalExBeeLangTestLanguage.g:5084:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==16) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // PsiInternalExBeeLangTestLanguage.g:5085:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                {
                otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                // PsiInternalExBeeLangTestLanguage.g:5092:7: ( (lv_varArgs_9_0= '...' ) )
                // PsiInternalExBeeLangTestLanguage.g:5093:8: (lv_varArgs_9_0= '...' )
                {
                // PsiInternalExBeeLangTestLanguage.g:5093:8: (lv_varArgs_9_0= '...' )
                // PsiInternalExBeeLangTestLanguage.g:5094:9: lv_varArgs_9_0= '...'
                {
                if ( state.backtracking==0 ) {

                  									markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0ElementType());
                  								
                }
                lv_varArgs_9_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }


                }

                // PsiInternalExBeeLangTestLanguage.g:5109:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                // PsiInternalExBeeLangTestLanguage.g:5110:8: (lv_parameters_10_0= ruleParameterDeclaration )
                {
                // PsiInternalExBeeLangTestLanguage.g:5110:8: (lv_parameters_10_0= ruleParameterDeclaration )
                // PsiInternalExBeeLangTestLanguage.g:5111:9: lv_parameters_10_0= ruleParameterDeclaration
                {
                if ( state.backtracking==0 ) {

                  									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0ElementType());
                  								
                }
                pushFollow(FollowSets000.FOLLOW_2);
                lv_parameters_10_0=ruleParameterDeclaration();

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
    // $ANTLR end synpred135_PsiInternalExBeeLangTestLanguage

    // $ANTLR start synpred137_PsiInternalExBeeLangTestLanguage
    public final void synpred137_PsiInternalExBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_BlockExpressionWithoutBrackets_0 = null;


        // PsiInternalExBeeLangTestLanguage.g:5199:3: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets )
        // PsiInternalExBeeLangTestLanguage.g:5199:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FollowSets000.FOLLOW_2);
        this_BlockExpressionWithoutBrackets_0=ruleBlockExpressionWithoutBrackets();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred137_PsiInternalExBeeLangTestLanguage

}

@SuppressWarnings("all")
public class PsiInternalExBeeLangTestLanguageParser extends PsiInternalExBeeLangTestLanguageParser3 {



        public PsiInternalExBeeLangTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalExBeeLangTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[259+1];
             
             
        }
        


    	public PsiInternalExBeeLangTestLanguageParser(PsiBuilder builder, TokenStream input, ExBeeLangTestLanguageElementTypeProvider elementTypeProvider, ExBeeLangTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
    		this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}
}
