package org.eclipse.xtext.testlanguages.backtracking.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.backtracking.services.SimpleBeeLangTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
interface InternalSimpleBeeLangTestLanguageParserSignatures {
     EObject entryRuleDelegateModel() throws RecognitionException;
     EObject ruleDelegateModel() throws RecognitionException;
     EObject entryRuleModel() throws RecognitionException;
     EObject ruleModel() throws RecognitionException;
     EObject entryRuleUnit() throws RecognitionException;
     EObject ruleUnit() throws RecognitionException;
     EObject entryRuleProvidedCapability() throws RecognitionException;
     EObject ruleProvidedCapability() throws RecognitionException;
     EObject entryRuleAliasedRequiredCapability() throws RecognitionException;
     EObject ruleAliasedRequiredCapability() throws RecognitionException;
     EObject entryRuleRequiredCapability() throws RecognitionException;
     EObject ruleRequiredCapability() throws RecognitionException;
     AntlrDatatypeRuleToken rulePath() throws RecognitionException;
     EObject entryRuleParameterList() throws RecognitionException;
     EObject ruleParameterList() throws RecognitionException;
     EObject entryRuleFirstParameter() throws RecognitionException;
     EObject ruleFirstParameter() throws RecognitionException;
     EObject entryRuleParameter() throws RecognitionException;
     EObject ruleParameter() throws RecognitionException;
     EObject entryRuleClosureParameter() throws RecognitionException;
     EObject ruleClosureParameter() throws RecognitionException;
     EObject entryRuleParameterDeclaration() throws RecognitionException;
     EObject ruleParameterDeclaration() throws RecognitionException;
     EObject entryRuleFunction() throws RecognitionException;
     EObject ruleFunction() throws RecognitionException;
     EObject entryRuleGuardExpression() throws RecognitionException;
     EObject ruleGuardExpression() throws RecognitionException;
     AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException;
     AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException;
     EObject entryRuleTopLevelExpression() throws RecognitionException;
     EObject ruleTopLevelExpression() throws RecognitionException;
     EObject entryRuleExpression() throws RecognitionException;
     EObject ruleExpression() throws RecognitionException;
     EObject entryRuleAssignmentExpression() throws RecognitionException;
     EObject ruleAssignmentExpression() throws RecognitionException;
     EObject entryRuleVarDeclaration() throws RecognitionException;
     EObject ruleVarDeclaration() throws RecognitionException;
     EObject entryRuleValDeclaration() throws RecognitionException;
     EObject ruleValDeclaration() throws RecognitionException;
     EObject entryRuleTypeRef() throws RecognitionException;
     EObject ruleTypeRef() throws RecognitionException;
     EObject entryRuleSimpleTypeRef() throws RecognitionException;
     EObject ruleSimpleTypeRef() throws RecognitionException;
     EObject entryRuleClosureTypeRef() throws RecognitionException;
     EObject ruleClosureTypeRef() throws RecognitionException;
     EObject entryRuleCachedExpression() throws RecognitionException;
     EObject ruleCachedExpression() throws RecognitionException;
     EObject entryRuleOrExpression() throws RecognitionException;
     EObject ruleOrExpression() throws RecognitionException;
     EObject entryRuleAndExpression() throws RecognitionException;
     EObject ruleAndExpression() throws RecognitionException;
     EObject entryRuleRelationalExpression() throws RecognitionException;
     EObject ruleRelationalExpression() throws RecognitionException;
     EObject entryRuleAdditiveExpression() throws RecognitionException;
     EObject ruleAdditiveExpression() throws RecognitionException;
     EObject entryRuleMultiplicativeExpression() throws RecognitionException;
     EObject ruleMultiplicativeExpression() throws RecognitionException;
     EObject entryRuleSetExpression() throws RecognitionException;
     EObject ruleSetExpression() throws RecognitionException;
     EObject entryRuleUnaryOrInfixExpression() throws RecognitionException;
     EObject ruleUnaryOrInfixExpression() throws RecognitionException;
     EObject entryRuleUnaryExpression() throws RecognitionException;
     EObject ruleUnaryExpression() throws RecognitionException;
     EObject entryRulePreopExpression() throws RecognitionException;
     EObject rulePreopExpression() throws RecognitionException;
     EObject entryRulePostopExpression() throws RecognitionException;
     EObject rulePostopExpression() throws RecognitionException;
     EObject entryRuleInfixExpression() throws RecognitionException;
     EObject ruleInfixExpression() throws RecognitionException;
     EObject entryRuleCallExpression() throws RecognitionException;
     EObject ruleCallExpression() throws RecognitionException;
     EObject entryRulePrimaryExpression() throws RecognitionException;
     EObject rulePrimaryExpression() throws RecognitionException;
     EObject entryRuleWithExpression() throws RecognitionException;
     EObject ruleWithExpression() throws RecognitionException;
     EObject entryRuleWithContextExpression() throws RecognitionException;
     EObject ruleWithContextExpression() throws RecognitionException;
     EObject entryRuleBlockExpression() throws RecognitionException;
     EObject ruleBlockExpression() throws RecognitionException;
     EObject entryRuleValue() throws RecognitionException;
     EObject ruleValue() throws RecognitionException;
     EObject entryRuleKeywordVariables() throws RecognitionException;
     EObject ruleKeywordVariables() throws RecognitionException;
     EObject entryRuleFeatureCall() throws RecognitionException;
     EObject ruleFeatureCall() throws RecognitionException;
     EObject entryRuleOperationCall() throws RecognitionException;
     EObject ruleOperationCall() throws RecognitionException;
     EObject entryRuleConstructorCallExpression() throws RecognitionException;
     EObject ruleConstructorCallExpression() throws RecognitionException;
     EObject entryRuleInitializationBlockExpression() throws RecognitionException;
     EObject ruleInitializationBlockExpression() throws RecognitionException;
     EObject entryRuleInitializationExpression() throws RecognitionException;
     EObject ruleInitializationExpression() throws RecognitionException;
     EObject entryRuleFeatureOfThis() throws RecognitionException;
     EObject ruleFeatureOfThis() throws RecognitionException;
     EObject entryRuleLiteral() throws RecognitionException;
     EObject ruleLiteral() throws RecognitionException;
     EObject entryRuleLiteralFunction() throws RecognitionException;
     EObject ruleLiteralFunction() throws RecognitionException;
     EObject entryRuleClosureExpression() throws RecognitionException;
     EObject ruleClosureExpression() throws RecognitionException;
     EObject entryRuleOneOrManyExpressions() throws RecognitionException;
     EObject ruleOneOrManyExpressions() throws RecognitionException;
     EObject entryRuleBlockExpressionWithoutBrackets() throws RecognitionException;
     EObject ruleBlockExpressionWithoutBrackets() throws RecognitionException;
     EObject entryRuleValueLiteral() throws RecognitionException;
     EObject ruleValueLiteral() throws RecognitionException;
     EObject entryRuleParanthesizedExpression() throws RecognitionException;
     EObject ruleParanthesizedExpression() throws RecognitionException;
     AntlrDatatypeRuleToken ruleQID() throws RecognitionException;
     void synpred2_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred9_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred10_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred11_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred12_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred13_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred14_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred15_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred16_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred17_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred18_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred20_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred21_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred22_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred26_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred27_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred28_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred29_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred30_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred32_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred33_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred34_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred35_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred36_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred42_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred69_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred71_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred85_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred86_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred87_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred89_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred92_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred93_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred99_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred101_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred102_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred103_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred105_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred106_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred108_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred109_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred112_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred113_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred127_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred128_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred135_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
     void synpred137_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException;   
}

@SuppressWarnings("all")
abstract class InternalSimpleBeeLangTestLanguageParser1 extends AbstractInternalAntlrParser implements InternalSimpleBeeLangTestLanguageParserSignatures {

        InternalSimpleBeeLangTestLanguageParser1(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        InternalSimpleBeeLangTestLanguageParser1(TokenStream input, RecognizerSharedState state) {
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


    public String[] getTokenNames() { return InternalSimpleBeeLangTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimpleBeeLangTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	protected SimpleBeeLangTestLanguageGrammarAccess grammarAccess;



        @Override
        protected String getFirstRuleName() {
        	return "DelegateModel";
       	}

       	@Override
       	protected SimpleBeeLangTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}





    // Delegated rules

    public final boolean synpred108_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalSimpleBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalSimpleBeeLangTestLanguage_fragment(); // can never throw exception
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
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\1\3\1\uffff\4\6\1\4\1\5";
    static final String dfa_5s = "\1\0\4\uffff\1\1\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\6\1\7\14\uffff\1\2\2\uffff\1\3\1\4\1\5\1\uffff\1\1\7\uffff\1\10\1\11",
            "",
            "",
            "",
            "",
            "\1\12\4\uffff\1\13",
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
            return "()* loopback of 317:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*";
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
                        if ( LA13_5 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {s = 10;}

                        else if ( LA13_5 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {s = 11;}

                         
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
    static final String dfa_8s = "\3\uffff\1\4\4\uffff\2\4\12\uffff\2\4\1\uffff\1\4\15\uffff\2\4\7\uffff";
    static final String dfa_9s = "\1\5\1\uffff\2\5\1\uffff\1\20\2\5\2\20\1\5\1\0\3\5\1\20\1\5\1\67\1\5\1\0\1\5\1\20\1\5\1\20\1\45\1\5\1\20\1\5\1\67\3\5\1\20\2\5\1\45\1\5\1\20\1\5\1\45\1\0\1\20\2\5\1\45\1\0";
    static final String dfa_10s = "\1\115\1\uffff\1\114\1\115\1\uffff\1\104\1\114\1\115\2\104\1\114\1\0\1\43\1\115\1\114\1\104\1\5\1\67\1\45\1\0\2\115\1\44\1\104\1\45\1\5\1\45\1\5\1\67\1\114\1\115\1\5\1\45\1\5\1\44\1\45\1\5\2\115\1\45\1\0\1\45\2\5\1\45\1\0";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\2\51\uffff";
    static final String dfa_12s = "\13\uffff\1\1\7\uffff\1\2\24\uffff\1\0\4\uffff\1\3}>";
    static final String[] dfa_13s = {
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
            "\1\26\17\uffff\1\4\2\uffff\1\4\1\uffff\1\27\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\30",
            "\1\31",
            "\1\32\36\uffff\1\33\1\34",
            "\1\uffff",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\40\36\uffff\1\37",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\31\1\uffff\7\4\1\uffff\4\4",
            "\1\21",
            "\1\41",
            "\1\42\24\uffff\1\34",
            "\1\43",
            "\1\44",
            "\1\45\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\46\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\47",
            "\1\26\24\uffff\1\21",
            "\1\50",
            "\1\51\36\uffff\1\52",
            "\1\34",
            "\1\53",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\21",
            "\1\uffff",
            "\1\42\24\uffff\1\34",
            "\1\54",
            "\1\55",
            "\1\34",
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
            return "1570:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )";
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
                        if ( (synpred42_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_40);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_19 = input.LA(1);

                         
                        int index27_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_19);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_45 = input.LA(1);

                         
                        int index27_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_45);
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
            return "2253:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )";
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
                        if ( (synpred69_InternalSimpleBeeLangTestLanguage()) ) {s = 2;}

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
    static final String dfa_25s = "\2\uffff\1\4\1\0\1\7\1\3\1\2\1\5\1\1\1\6\1\10\1\uffff}>";
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
            return "()* loopback of 3153:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalSimpleBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_10);
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
            return "3993:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )";
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
                        if ( (synpred106_InternalSimpleBeeLangTestLanguage()) ) {s = 14;}

                        else if ( (synpred108_InternalSimpleBeeLangTestLanguage()) ) {s = 15;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_4 = input.LA(1);

                         
                        int index73_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_InternalSimpleBeeLangTestLanguage()) ) {s = 3;}

                        else if ( (synpred112_InternalSimpleBeeLangTestLanguage()) ) {s = 16;}

                         
                        input.seek(index73_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_13 = input.LA(1);

                         
                        int index73_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalSimpleBeeLangTestLanguage()) ) {s = 17;}

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
            return "4687:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?";
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
                        if ( (synpred127_InternalSimpleBeeLangTestLanguage()) ) {s = 37;}

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
    static final String dfa_41s = "\5\uffff\1\6\7\uffff\1\6\3\uffff\1\6\16\uffff\3\6\16\uffff\2\6\7\uffff";
    static final String dfa_42s = "\2\5\2\uffff\2\5\1\uffff\1\20\1\5\1\67\1\5\1\20\1\5\1\20\1\5\1\45\1\5\1\20\1\5\1\0\2\5\1\20\3\5\1\20\1\5\1\67\1\5\1\0\1\45\1\5\2\20\1\5\1\45\1\5\1\20\1\5\1\67\2\5\1\20\3\5\1\45\1\5\1\20\1\5\1\45\1\0\1\20\2\5\1\45\1\0";
    static final String dfa_43s = "\1\115\1\114\2\uffff\1\114\1\115\1\uffff\1\104\1\5\1\67\1\114\2\115\1\104\1\44\1\45\1\5\1\104\1\114\1\0\1\43\1\5\1\45\1\5\1\115\1\114\1\104\1\5\1\67\1\45\1\0\1\45\2\115\1\104\1\44\1\45\1\5\1\45\1\5\1\67\1\114\1\115\1\45\2\5\1\44\1\45\1\5\2\115\1\45\1\0\1\45\2\5\1\45\1\0";
    static final String dfa_44s = "\2\uffff\1\1\1\2\2\uffff\1\3\63\uffff";
    static final String dfa_45s = "\23\uffff\1\0\12\uffff\1\1\25\uffff\1\3\4\uffff\1\2}>";
    static final String[] dfa_46s = {
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
            "\1\23\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\22\1\24\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\6\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\20\6\2\uffff\1\20\1\uffff\7\6\1\uffff\4\6",
            "\1\26\36\uffff\1\25",
            "\1\11",
            "\1\27",
            "\1\30\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\31\1\6\4\uffff\7\6\1\uffff\4\6",
            "\1\32\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\1\33\1\34\22\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\uffff",
            "\1\36\35\uffff\1\35",
            "\1\37",
            "\1\16\24\uffff\1\11",
            "\1\13",
            "\1\40\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\2\6\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\41\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\43\17\uffff\1\6\2\uffff\1\6\1\uffff\1\42\17\6\4\uffff\7\6\1\uffff\4\6",
            "\1\44",
            "\1\45",
            "\1\46\36\uffff\1\47\1\50",
            "\1\uffff",
            "\1\11",
            "\1\6\12\uffff\1\52\17\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\51\1\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\6",
            "\1\14\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\20\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "\1\6\17\uffff\1\6\2\uffff\1\6\1\uffff\20\6\2\uffff\1\45\1\uffff\7\6\1\uffff\4\6",
            "\1\53\36\uffff\1\54",
            "\1\34",
            "\1\55",
            "\1\56\24\uffff\1\50",
            "\1\57",
            "\1\60",
            "\1\61\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\62\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\2\6\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\43\24\uffff\1\34",
            "\1\63",
            "\1\64",
            "\1\65\36\uffff\1\66",
            "\1\50",
            "\1\67",
            "\1\14\3\uffff\1\6\13\uffff\1\6\2\uffff\1\6\1\uffff\20\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "\1\6\12\uffff\1\52\17\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\51\1\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\6",
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
            return "5085:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?";
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
                        if ( (synpred135_InternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_30 = input.LA(1);

                         
                        int index90_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_30);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_52 = input.LA(1);

                         
                        int index90_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalSimpleBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
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
            return "5257:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )";
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
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_4 = input.LA(1);

                         
                        int index91_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_7 = input.LA(1);

                         
                        int index91_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_8 = input.LA(1);

                         
                        int index91_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA91_17 = input.LA(1);

                         
                        int index91_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_17);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA91_18 = input.LA(1);

                         
                        int index91_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_18);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA91_19 = input.LA(1);

                         
                        int index91_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA91_20 = input.LA(1);

                         
                        int index91_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA91_21 = input.LA(1);

                         
                        int index91_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalSimpleBeeLangTestLanguage()) ) {s = 1;}

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
abstract class InternalSimpleBeeLangTestLanguageParser2 extends InternalSimpleBeeLangTestLanguageParser1 {

        InternalSimpleBeeLangTestLanguageParser2(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        InternalSimpleBeeLangTestLanguageParser2(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleDelegateModel"
    // InternalSimpleBeeLangTestLanguage.g:72:1: entryRuleDelegateModel returns [EObject current=null] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final EObject entryRuleDelegateModel() throws RecognitionException {
        EObject current = null;
        int entryRuleDelegateModel_StartIndex = input.index();
        EObject iv_ruleDelegateModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:72:54: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // InternalSimpleBeeLangTestLanguage.g:73:2: iv_ruleDelegateModel= ruleDelegateModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDelegateModelRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleDelegateModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleDelegateModel"


    // $ANTLR start "ruleDelegateModel"
    // InternalSimpleBeeLangTestLanguage.g:79:1: ruleDelegateModel returns [EObject current=null] : this_Model_0= ruleModel ;
    public final EObject ruleDelegateModel() throws RecognitionException {
        EObject current = null;
        int ruleDelegateModel_StartIndex = input.index();
        EObject this_Model_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:85:2: (this_Model_0= ruleModel )
            // InternalSimpleBeeLangTestLanguage.g:86:2: this_Model_0= ruleModel
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getDelegateModelAccess().getModelParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_Model_0=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Model_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleDelegateModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleDelegateModel"


    // $ANTLR start "entryRuleModel"
    // InternalSimpleBeeLangTestLanguage.g:100:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;
        int entryRuleModel_StartIndex = input.index();
        EObject iv_ruleModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:100:46: (iv_ruleModel= ruleModel EOF )
            // InternalSimpleBeeLangTestLanguage.g:101:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSimpleBeeLangTestLanguage.g:107:1: ruleModel returns [EObject current=null] : ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;
        int ruleModel_StartIndex = input.index();
        EObject lv_units_0_0 = null;

        EObject lv_functions_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:113:2: ( ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:114:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:114:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
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

                if ( (synpred2_InternalSimpleBeeLangTestLanguage()) ) {
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
                    // InternalSimpleBeeLangTestLanguage.g:115:3: ( (lv_units_0_0= ruleUnit ) )*
                    {
                    // InternalSimpleBeeLangTestLanguage.g:115:3: ( (lv_units_0_0= ruleUnit ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_DOCUMENTATION||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalSimpleBeeLangTestLanguage.g:116:4: (lv_units_0_0= ruleUnit )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:116:4: (lv_units_0_0= ruleUnit )
                    	    // InternalSimpleBeeLangTestLanguage.g:117:5: lv_units_0_0= ruleUnit
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getModelAccess().getUnitsUnitParserRuleCall_0_0());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_units_0_0=ruleUnit();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					if (current==null) {
                    	      						current = createModelElementForParent(grammarAccess.getModelRule());
                    	      					}
                    	      					add(
                    	      						current,
                    	      						"units",
                    	      						lv_units_0_0,
                    	      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Unit");
                    	      					afterParserOrEnumRuleCall();
                    	      				
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
                    // InternalSimpleBeeLangTestLanguage.g:135:3: ( (lv_functions_1_0= ruleFunction ) )*
                    {
                    // InternalSimpleBeeLangTestLanguage.g:135:3: ( (lv_functions_1_0= ruleFunction ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=RULE_DOCUMENTATION && LA2_0<=RULE_ID)||(LA2_0>=33 && LA2_0<=34)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalSimpleBeeLangTestLanguage.g:136:4: (lv_functions_1_0= ruleFunction )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:136:4: (lv_functions_1_0= ruleFunction )
                    	    // InternalSimpleBeeLangTestLanguage.g:137:5: lv_functions_1_0= ruleFunction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getModelAccess().getFunctionsFunctionParserRuleCall_1_0());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_functions_1_0=ruleFunction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					if (current==null) {
                    	      						current = createModelElementForParent(grammarAccess.getModelRule());
                    	      					}
                    	      					add(
                    	      						current,
                    	      						"functions",
                    	      						lv_functions_1_0,
                    	      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Function");
                    	      					afterParserOrEnumRuleCall();
                    	      				
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnit"
    // InternalSimpleBeeLangTestLanguage.g:158:1: entryRuleUnit returns [EObject current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final EObject entryRuleUnit() throws RecognitionException {
        EObject current = null;
        int entryRuleUnit_StartIndex = input.index();
        EObject iv_ruleUnit = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:162:2: (iv_ruleUnit= ruleUnit EOF )
            // InternalSimpleBeeLangTestLanguage.g:163:2: iv_ruleUnit= ruleUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // InternalSimpleBeeLangTestLanguage.g:172:1: ruleUnit returns [EObject current=null] : ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) ;
    public final EObject ruleUnit() throws RecognitionException {
        EObject current = null;
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
        EObject lv_implements_7_0 = null;

        EObject lv_implements_9_0 = null;

        AntlrDatatypeRuleToken lv_sourceLocation_14_0 = null;

        AntlrDatatypeRuleToken lv_outputLocation_18_0 = null;

        EObject lv_providedCapabilities_22_0 = null;

        EObject lv_requiredCapabilities_26_0 = null;

        EObject lv_metaRequiredCapabilities_31_0 = null;

        EObject lv_functions_33_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:181:2: ( ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) )
            // InternalSimpleBeeLangTestLanguage.g:182:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            {
            // InternalSimpleBeeLangTestLanguage.g:182:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            // InternalSimpleBeeLangTestLanguage.g:183:3: () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}'
            {
            // InternalSimpleBeeLangTestLanguage.g:183:3: ()
            // InternalSimpleBeeLangTestLanguage.g:184:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUnitAccess().getUnitAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:193:3: ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOCUMENTATION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:194:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:194:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    // InternalSimpleBeeLangTestLanguage.g:195:5: lv_documentation_1_0= RULE_DOCUMENTATION
                    {
                    lv_documentation_1_0=(Token)match(input,RULE_DOCUMENTATION,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_documentation_1_0, grammarAccess.getUnitAccess().getDocumentationDOCUMENTATIONTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnitRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"documentation",
                      						lv_documentation_1_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.DOCUMENTATION");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUnitAccess().getUnitKeyword_2());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:215:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:216:4: (lv_name_3_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:216:4: (lv_name_3_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:217:5: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_3_0, grammarAccess.getUnitAccess().getNameIDTerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getUnitRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_3_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:233:3: (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:234:4: otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getUnitAccess().getVersionKeyword_4_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:238:4: ( (lv_version_5_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:239:5: (lv_version_5_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:239:5: (lv_version_5_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:240:6: lv_version_5_0= RULE_ID
                    {
                    lv_version_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_version_5_0, grammarAccess.getUnitAccess().getVersionIDTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnitRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"version",
                      							lv_version_5_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:257:3: (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:258:4: otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getUnitAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:262:4: ( (lv_implements_7_0= ruleSimpleTypeRef ) )
                    // InternalSimpleBeeLangTestLanguage.g:263:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:263:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    // InternalSimpleBeeLangTestLanguage.g:264:6: lv_implements_7_0= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnitAccess().getImplementsSimpleTypeRefParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_implements_7_0=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnitRule());
                      						}
                      						add(
                      							current,
                      							"implements",
                      							lv_implements_7_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.SimpleTypeRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:281:4: (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalSimpleBeeLangTestLanguage.g:282:5: otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    {
                    	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getUnitAccess().getCommaKeyword_5_2_0());
                    	      				
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:286:5: ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:287:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:287:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    // InternalSimpleBeeLangTestLanguage.g:288:7: lv_implements_9_0= ruleSimpleTypeRef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getUnitAccess().getImplementsSimpleTypeRefParserRuleCall_5_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_10);
                    	    lv_implements_9_0=ruleSimpleTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getUnitRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"implements",
                    	      								lv_implements_9_0,
                    	      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.SimpleTypeRef");
                    	      							afterParserOrEnumRuleCall();
                    	      						
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

            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getUnitAccess().getLeftCurlyBracketKeyword_6());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:311:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // InternalSimpleBeeLangTestLanguage.g:312:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:312:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:313:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getUnitAccess().getUnorderedGroup_7());
            // InternalSimpleBeeLangTestLanguage.g:316:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:317:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            {
            // InternalSimpleBeeLangTestLanguage.g:317:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=7;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:318:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:318:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:319:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:319:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:320:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
            	    // InternalSimpleBeeLangTestLanguage.g:323:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:323:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:323:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:323:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
            	    {
            	    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_12, grammarAccess.getUnitAccess().getSourceKeyword_7_0_0());
            	      								
            	    }
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_13, grammarAccess.getUnitAccess().getColonKeyword_7_0_1());
            	      								
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:331:9: ( (lv_sourceLocation_14_0= rulePath ) )
            	    // InternalSimpleBeeLangTestLanguage.g:332:10: (lv_sourceLocation_14_0= rulePath )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:332:10: (lv_sourceLocation_14_0= rulePath )
            	    // InternalSimpleBeeLangTestLanguage.g:333:11: lv_sourceLocation_14_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											newCompositeNode(grammarAccess.getUnitAccess().getSourceLocationPathParserRuleCall_7_0_2_0());
            	      										
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_sourceLocation_14_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											if (current==null) {
            	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	      											}
            	      											set(
            	      												current,
            	      												"sourceLocation",
            	      												lv_sourceLocation_14_0,
            	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Path");
            	      											afterParserOrEnumRuleCall();
            	      										
            	    }

            	    }


            	    }

            	    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_15, grammarAccess.getUnitAccess().getSemicolonKeyword_7_0_3());
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleBeeLangTestLanguage.g:360:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:360:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:361:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:361:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:362:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
            	    // InternalSimpleBeeLangTestLanguage.g:365:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:365:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:365:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:365:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
            	    {
            	    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_16, grammarAccess.getUnitAccess().getOutputKeyword_7_1_0());
            	      								
            	    }
            	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_17, grammarAccess.getUnitAccess().getColonKeyword_7_1_1());
            	      								
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:373:9: ( (lv_outputLocation_18_0= rulePath ) )
            	    // InternalSimpleBeeLangTestLanguage.g:374:10: (lv_outputLocation_18_0= rulePath )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:374:10: (lv_outputLocation_18_0= rulePath )
            	    // InternalSimpleBeeLangTestLanguage.g:375:11: lv_outputLocation_18_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											newCompositeNode(grammarAccess.getUnitAccess().getOutputLocationPathParserRuleCall_7_1_2_0());
            	      										
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_outputLocation_18_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											if (current==null) {
            	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	      											}
            	      											set(
            	      												current,
            	      												"outputLocation",
            	      												lv_outputLocation_18_0,
            	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Path");
            	      											afterParserOrEnumRuleCall();
            	      										
            	    }

            	    }


            	    }

            	    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_19, grammarAccess.getUnitAccess().getSemicolonKeyword_7_1_3());
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSimpleBeeLangTestLanguage.g:402:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:402:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    // InternalSimpleBeeLangTestLanguage.g:403:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:403:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    // InternalSimpleBeeLangTestLanguage.g:404:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
            	    // InternalSimpleBeeLangTestLanguage.g:407:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==22) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((synpred11_InternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalSimpleBeeLangTestLanguage.g:407:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalSimpleBeeLangTestLanguage.g:407:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    // InternalSimpleBeeLangTestLanguage.g:407:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
            	    	    {
            	    	    otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_20, grammarAccess.getUnitAccess().getProvidesKeyword_7_2_0());
            	    	      								
            	    	    }
            	    	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_21, grammarAccess.getUnitAccess().getColonKeyword_7_2_1());
            	    	      								
            	    	    }
            	    	    // InternalSimpleBeeLangTestLanguage.g:415:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
            	    	    // InternalSimpleBeeLangTestLanguage.g:416:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    {
            	    	    // InternalSimpleBeeLangTestLanguage.g:416:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    // InternalSimpleBeeLangTestLanguage.g:417:11: lv_providedCapabilities_22_0= ruleProvidedCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getUnitAccess().getProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    lv_providedCapabilities_22_0=ruleProvidedCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      											}
            	    	      											add(
            	    	      												current,
            	    	      												"providedCapabilities",
            	    	      												lv_providedCapabilities_22_0,
            	    	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ProvidedCapability");
            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_23, grammarAccess.getUnitAccess().getSemicolonKeyword_7_2_3());
            	    	      								
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
            	    // InternalSimpleBeeLangTestLanguage.g:444:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:444:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    // InternalSimpleBeeLangTestLanguage.g:445:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:445:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    // InternalSimpleBeeLangTestLanguage.g:446:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
            	    // InternalSimpleBeeLangTestLanguage.g:449:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==23) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((synpred13_InternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalSimpleBeeLangTestLanguage.g:449:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalSimpleBeeLangTestLanguage.g:449:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    // InternalSimpleBeeLangTestLanguage.g:449:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
            	    	    {
            	    	    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_24, grammarAccess.getUnitAccess().getRequiresKeyword_7_3_0());
            	    	      								
            	    	    }
            	    	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_25, grammarAccess.getUnitAccess().getColonKeyword_7_3_1());
            	    	      								
            	    	    }
            	    	    // InternalSimpleBeeLangTestLanguage.g:457:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
            	    	    // InternalSimpleBeeLangTestLanguage.g:458:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    {
            	    	    // InternalSimpleBeeLangTestLanguage.g:458:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    // InternalSimpleBeeLangTestLanguage.g:459:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getUnitAccess().getRequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      											}
            	    	      											add(
            	    	      												current,
            	    	      												"requiredCapabilities",
            	    	      												lv_requiredCapabilities_26_0,
            	    	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AliasedRequiredCapability");
            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_27, grammarAccess.getUnitAccess().getSemicolonKeyword_7_3_3());
            	    	      								
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
            	    // InternalSimpleBeeLangTestLanguage.g:486:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:486:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    // InternalSimpleBeeLangTestLanguage.g:487:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:487:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    // InternalSimpleBeeLangTestLanguage.g:488:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
            	    // InternalSimpleBeeLangTestLanguage.g:491:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==23) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((synpred15_InternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalSimpleBeeLangTestLanguage.g:491:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalSimpleBeeLangTestLanguage.g:491:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    // InternalSimpleBeeLangTestLanguage.g:491:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
            	    	    {
            	    	    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_28, grammarAccess.getUnitAccess().getRequiresKeyword_7_4_0());
            	    	      								
            	    	    }
            	    	    otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_29, grammarAccess.getUnitAccess().getEnvKeyword_7_4_1());
            	    	      								
            	    	    }
            	    	    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_30, grammarAccess.getUnitAccess().getColonKeyword_7_4_2());
            	    	      								
            	    	    }
            	    	    // InternalSimpleBeeLangTestLanguage.g:503:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
            	    	    // InternalSimpleBeeLangTestLanguage.g:504:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    {
            	    	    // InternalSimpleBeeLangTestLanguage.g:504:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    // InternalSimpleBeeLangTestLanguage.g:505:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											newCompositeNode(grammarAccess.getUnitAccess().getMetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0());
            	    	      										
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_14);
            	    	    lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											if (current==null) {
            	    	      												current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      											}
            	    	      											add(
            	    	      												current,
            	    	      												"metaRequiredCapabilities",
            	    	      												lv_metaRequiredCapabilities_31_0,
            	    	      												"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.RequiredCapability");
            	    	      											afterParserOrEnumRuleCall();
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_32, grammarAccess.getUnitAccess().getSemicolonKeyword_7_4_4());
            	    	      								
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
            	    // InternalSimpleBeeLangTestLanguage.g:532:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:532:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    // InternalSimpleBeeLangTestLanguage.g:533:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:533:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    // InternalSimpleBeeLangTestLanguage.g:534:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
            	    // InternalSimpleBeeLangTestLanguage.g:537:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        switch ( input.LA(1) ) {
            	        case RULE_DOCUMENTATION:
            	            {
            	            int LA12_2 = input.LA(2);

            	            if ( ((synpred17_InternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA12_3 = input.LA(2);

            	            if ( ((synpred17_InternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 33:
            	            {
            	            int LA12_4 = input.LA(2);

            	            if ( ((synpred17_InternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 34:
            	            {
            	            int LA12_5 = input.LA(2);

            	            if ( ((synpred17_InternalSimpleBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalSimpleBeeLangTestLanguage.g:537:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalSimpleBeeLangTestLanguage.g:537:19: ( (lv_functions_33_0= ruleFunction ) )
            	    	    // InternalSimpleBeeLangTestLanguage.g:537:20: (lv_functions_33_0= ruleFunction )
            	    	    {
            	    	    // InternalSimpleBeeLangTestLanguage.g:537:20: (lv_functions_33_0= ruleFunction )
            	    	    // InternalSimpleBeeLangTestLanguage.g:538:10: lv_functions_33_0= ruleFunction
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      										newCompositeNode(grammarAccess.getUnitAccess().getFunctionsFunctionParserRuleCall_7_5_0());
            	    	      									
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_11);
            	    	    lv_functions_33_0=ruleFunction();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      										if (current==null) {
            	    	      											current = createModelElementForParent(grammarAccess.getUnitRule());
            	    	      										}
            	    	      										add(
            	    	      											current,
            	    	      											"functions",
            	    	      											lv_functions_33_0,
            	    	      											"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Function");
            	    	      										afterParserOrEnumRuleCall();
            	    	      									
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

            otherlv_34=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_34, grammarAccess.getUnitAccess().getRightCurlyBracketKeyword_8());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleProvidedCapability"
    // InternalSimpleBeeLangTestLanguage.g:578:1: entryRuleProvidedCapability returns [EObject current=null] : iv_ruleProvidedCapability= ruleProvidedCapability EOF ;
    public final EObject entryRuleProvidedCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleProvidedCapability_StartIndex = input.index();
        EObject iv_ruleProvidedCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:582:2: (iv_ruleProvidedCapability= ruleProvidedCapability EOF )
            // InternalSimpleBeeLangTestLanguage.g:583:2: iv_ruleProvidedCapability= ruleProvidedCapability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProvidedCapabilityRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRuleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleProvidedCapability"


    // $ANTLR start "ruleProvidedCapability"
    // InternalSimpleBeeLangTestLanguage.g:592:1: ruleProvidedCapability returns [EObject current=null] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) ;
    public final EObject ruleProvidedCapability() throws RecognitionException {
        EObject current = null;
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
        EObject lv_condExpr_7_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:601:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) )
            // InternalSimpleBeeLangTestLanguage.g:602:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            {
            // InternalSimpleBeeLangTestLanguage.g:602:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            // InternalSimpleBeeLangTestLanguage.g:603:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            {
            // InternalSimpleBeeLangTestLanguage.g:603:3: ()
            // InternalSimpleBeeLangTestLanguage.g:604:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getProvidedCapabilityAccess().getProvidedCapabilityAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:613:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
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
                    // InternalSimpleBeeLangTestLanguage.g:614:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:614:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:615:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:615:5: (lv_nameSpace_1_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:616:6: lv_nameSpace_1_0= RULE_ID
                    {
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nameSpace_1_0, grammarAccess.getProvidedCapabilityAccess().getNameSpaceIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getProvidedCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nameSpace",
                      							lv_nameSpace_1_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:633:4: otherlv_2= 'unit'
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getProvidedCapabilityAccess().getUnitKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:638:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:639:4: otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}'
                    {
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getProvidedCapabilityAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:643:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) )
                    // InternalSimpleBeeLangTestLanguage.g:644:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:644:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    // InternalSimpleBeeLangTestLanguage.g:645:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());
                    // InternalSimpleBeeLangTestLanguage.g:648:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    // InternalSimpleBeeLangTestLanguage.g:649:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?
                    {
                    // InternalSimpleBeeLangTestLanguage.g:649:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+
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
                    	    // InternalSimpleBeeLangTestLanguage.g:650:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:650:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:651:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:651:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:652:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
                    	    // InternalSimpleBeeLangTestLanguage.g:655:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:655:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:655:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    // InternalSimpleBeeLangTestLanguage.g:655:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
                    	    {
                    	    otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_5, grammarAccess.getProvidedCapabilityAccess().getWhenKeyword_2_1_0_0());
                    	      									
                    	    }
                    	    otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_6, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_0_1());
                    	      									
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:663:10: ( (lv_condExpr_7_0= ruleExpression ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:664:11: (lv_condExpr_7_0= ruleExpression )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:664:11: (lv_condExpr_7_0= ruleExpression )
                    	    // InternalSimpleBeeLangTestLanguage.g:665:12: lv_condExpr_7_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												newCompositeNode(grammarAccess.getProvidedCapabilityAccess().getCondExprExpressionParserRuleCall_2_1_0_2_0());
                    	      											
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    lv_condExpr_7_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												if (current==null) {
                    	      													current = createModelElementForParent(grammarAccess.getProvidedCapabilityRule());
                    	      												}
                    	      												set(
                    	      													current,
                    	      													"condExpr",
                    	      													lv_condExpr_7_0,
                    	      													"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                    	      												afterParserOrEnumRuleCall();
                    	      											
                    	    }

                    	    }


                    	    }

                    	    otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_8, grammarAccess.getProvidedCapabilityAccess().getSemicolonKeyword_2_1_0_3());
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalSimpleBeeLangTestLanguage.g:692:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:692:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:693:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:693:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:694:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
                    	    // InternalSimpleBeeLangTestLanguage.g:697:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:697:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:697:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    // InternalSimpleBeeLangTestLanguage.g:697:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
                    	    {
                    	    otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_9, grammarAccess.getProvidedCapabilityAccess().getNameKeyword_2_1_1_0());
                    	      									
                    	    }
                    	    otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_10, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_1_1());
                    	      									
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:705:10: ( (lv_name_11_0= RULE_ID ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:706:11: (lv_name_11_0= RULE_ID )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:706:11: (lv_name_11_0= RULE_ID )
                    	    // InternalSimpleBeeLangTestLanguage.g:707:12: lv_name_11_0= RULE_ID
                    	    {
                    	    lv_name_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												newLeafNode(lv_name_11_0, grammarAccess.getProvidedCapabilityAccess().getNameIDTerminalRuleCall_2_1_1_2_0());
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												if (current==null) {
                    	      													current = createModelElement(grammarAccess.getProvidedCapabilityRule());
                    	      												}
                    	      												setWithLastConsumed(
                    	      													current,
                    	      													"name",
                    	      													lv_name_11_0,
                    	      													"org.eclipse.xtext.common.Terminals.ID");
                    	      											
                    	    }

                    	    }


                    	    }

                    	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_12, grammarAccess.getProvidedCapabilityAccess().getSemicolonKeyword_2_1_1_3());
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalSimpleBeeLangTestLanguage.g:733:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:733:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:734:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:734:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:735:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
                    	    // InternalSimpleBeeLangTestLanguage.g:738:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:738:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:738:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    // InternalSimpleBeeLangTestLanguage.g:738:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
                    	    {
                    	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_13, grammarAccess.getProvidedCapabilityAccess().getVersionKeyword_2_1_2_0());
                    	      									
                    	    }
                    	    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_14, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_2_1());
                    	      									
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:746:10: ( (lv_version_15_0= RULE_ID ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:747:11: (lv_version_15_0= RULE_ID )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:747:11: (lv_version_15_0= RULE_ID )
                    	    // InternalSimpleBeeLangTestLanguage.g:748:12: lv_version_15_0= RULE_ID
                    	    {
                    	    lv_version_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												newLeafNode(lv_version_15_0, grammarAccess.getProvidedCapabilityAccess().getVersionIDTerminalRuleCall_2_1_2_2_0());
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												if (current==null) {
                    	      													current = createModelElement(grammarAccess.getProvidedCapabilityRule());
                    	      												}
                    	      												setWithLastConsumed(
                    	      													current,
                    	      													"version",
                    	      													lv_version_15_0,
                    	      													"org.eclipse.xtext.common.Terminals.ID");
                    	      											
                    	    }

                    	    }


                    	    }

                    	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_16, grammarAccess.getProvidedCapabilityAccess().getSemicolonKeyword_2_1_2_3());
                    	      									
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

                    otherlv_17=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getProvidedCapabilityAccess().getRightCurlyBracketKeyword_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, ruleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleProvidedCapability"


    // $ANTLR start "entryRuleAliasedRequiredCapability"
    // InternalSimpleBeeLangTestLanguage.g:794:1: entryRuleAliasedRequiredCapability returns [EObject current=null] : iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF ;
    public final EObject entryRuleAliasedRequiredCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleAliasedRequiredCapability_StartIndex = input.index();
        EObject iv_ruleAliasedRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:798:2: (iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF )
            // InternalSimpleBeeLangTestLanguage.g:799:2: iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAliasedRequiredCapabilityRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleAliasedRequiredCapability"


    // $ANTLR start "ruleAliasedRequiredCapability"
    // InternalSimpleBeeLangTestLanguage.g:808:1: ruleAliasedRequiredCapability returns [EObject current=null] : ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) ;
    public final EObject ruleAliasedRequiredCapability() throws RecognitionException {
        EObject current = null;
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
        EObject lv_condExpr_9_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:817:2: ( ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) )
            // InternalSimpleBeeLangTestLanguage.g:818:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:818:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            // InternalSimpleBeeLangTestLanguage.g:819:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            {
            // InternalSimpleBeeLangTestLanguage.g:819:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' )
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
                    // InternalSimpleBeeLangTestLanguage.g:820:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:820:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:821:5: (lv_nameSpace_0_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:821:5: (lv_nameSpace_0_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:822:6: lv_nameSpace_0_0= RULE_ID
                    {
                    lv_nameSpace_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nameSpace_0_0, grammarAccess.getAliasedRequiredCapabilityAccess().getNameSpaceIDTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nameSpace",
                      							lv_nameSpace_0_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:839:4: otherlv_1= 'unit'
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAliasedRequiredCapabilityAccess().getUnitKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:844:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:845:4: (lv_name_2_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:845:4: (lv_name_2_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:846:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getAliasedRequiredCapabilityAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:862:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:863:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAliasedRequiredCapabilityAccess().getAsKeyword_2_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:867:4: ( (lv_alias_4_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:868:5: (lv_alias_4_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:868:5: (lv_alias_4_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:869:6: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_4_0, grammarAccess.getAliasedRequiredCapabilityAccess().getAliasIDTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_4_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:886:3: (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            // InternalSimpleBeeLangTestLanguage.g:887:4: otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}'
            {
            otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getAliasedRequiredCapabilityAccess().getLeftCurlyBracketKeyword_3_0());
              			
            }
            // InternalSimpleBeeLangTestLanguage.g:891:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) )
            // InternalSimpleBeeLangTestLanguage.g:892:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:892:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:893:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // InternalSimpleBeeLangTestLanguage.g:896:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:897:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            {
            // InternalSimpleBeeLangTestLanguage.g:897:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
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
            	    // InternalSimpleBeeLangTestLanguage.g:898:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:898:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:899:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:899:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:900:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // InternalSimpleBeeLangTestLanguage.g:903:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:903:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:903:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:903:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
            	    {
            	    otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_7, grammarAccess.getAliasedRequiredCapabilityAccess().getWhenKeyword_3_1_0_0());
            	      									
            	    }
            	    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_8, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_0_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:911:10: ( (lv_condExpr_9_0= ruleExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:912:11: (lv_condExpr_9_0= ruleExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:912:11: (lv_condExpr_9_0= ruleExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:913:12: lv_condExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												newCompositeNode(grammarAccess.getAliasedRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
            	      											
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_condExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElementForParent(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												set(
            	      													current,
            	      													"condExpr",
            	      													lv_condExpr_9_0,
            	      													"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
            	      												afterParserOrEnumRuleCall();
            	      											
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_10, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_0_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleBeeLangTestLanguage.g:940:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:940:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:941:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:941:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:942:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // InternalSimpleBeeLangTestLanguage.g:945:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:945:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:945:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:945:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:945:21: ( (lv_greedy_11_0= 'greedy' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:946:11: (lv_greedy_11_0= 'greedy' )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:946:11: (lv_greedy_11_0= 'greedy' )
            	    // InternalSimpleBeeLangTestLanguage.g:947:12: lv_greedy_11_0= 'greedy'
            	    {
            	    lv_greedy_11_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_greedy_11_0, grammarAccess.getAliasedRequiredCapabilityAccess().getGreedyGreedyKeyword_3_1_1_0_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(current, "greedy", true, "greedy");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_12, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_1_1());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:970:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:970:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:971:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // InternalSimpleBeeLangTestLanguage.g:974:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:974:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:974:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:974:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_13, grammarAccess.getAliasedRequiredCapabilityAccess().getRequiresMinKeyword_3_1_2_0());
            	      									
            	    }
            	    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_14, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_2_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:982:10: ( (lv_min_15_0= RULE_INT ) )
            	    // InternalSimpleBeeLangTestLanguage.g:983:11: (lv_min_15_0= RULE_INT )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:983:11: (lv_min_15_0= RULE_INT )
            	    // InternalSimpleBeeLangTestLanguage.g:984:12: lv_min_15_0= RULE_INT
            	    {
            	    lv_min_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_min_15_0, grammarAccess.getAliasedRequiredCapabilityAccess().getMinINTTerminalRuleCall_3_1_2_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"min",
            	      													lv_min_15_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_16, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_2_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSimpleBeeLangTestLanguage.g:1010:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1010:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1011:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1011:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1012:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // InternalSimpleBeeLangTestLanguage.g:1015:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1015:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1015:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:1015:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
            	    {
            	    otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_17, grammarAccess.getAliasedRequiredCapabilityAccess().getRequiresMaxKeyword_3_1_3_0());
            	      									
            	    }
            	    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_18, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_3_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1023:10: ( (lv_max_19_0= RULE_INT ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1024:11: (lv_max_19_0= RULE_INT )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1024:11: (lv_max_19_0= RULE_INT )
            	    // InternalSimpleBeeLangTestLanguage.g:1025:12: lv_max_19_0= RULE_INT
            	    {
            	    lv_max_19_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_max_19_0, grammarAccess.getAliasedRequiredCapabilityAccess().getMaxINTTerminalRuleCall_3_1_3_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"max",
            	      													lv_max_19_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_20, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_3_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalSimpleBeeLangTestLanguage.g:1051:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1051:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1052:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1052:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1053:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // InternalSimpleBeeLangTestLanguage.g:1056:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1056:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1056:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:1056:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
            	    {
            	    otherlv_21=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_21, grammarAccess.getAliasedRequiredCapabilityAccess().getVersionKeyword_3_1_4_0());
            	      									
            	    }
            	    otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_22, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_4_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1064:10: ( (lv_versionRange_23_0= RULE_ID ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1065:11: (lv_versionRange_23_0= RULE_ID )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1065:11: (lv_versionRange_23_0= RULE_ID )
            	    // InternalSimpleBeeLangTestLanguage.g:1066:12: lv_versionRange_23_0= RULE_ID
            	    {
            	    lv_versionRange_23_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_versionRange_23_0, grammarAccess.getAliasedRequiredCapabilityAccess().getVersionRangeIDTerminalRuleCall_3_1_4_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"versionRange",
            	      													lv_versionRange_23_0,
            	      													"org.eclipse.xtext.common.Terminals.ID");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_24, grammarAccess.getAliasedRequiredCapabilityAccess().getSemicolonKeyword_3_1_4_3());
            	      									
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

            otherlv_25=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_25, grammarAccess.getAliasedRequiredCapabilityAccess().getRightCurlyBracketKeyword_3_2());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, ruleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleAliasedRequiredCapability"


    // $ANTLR start "entryRuleRequiredCapability"
    // InternalSimpleBeeLangTestLanguage.g:1111:1: entryRuleRequiredCapability returns [EObject current=null] : iv_ruleRequiredCapability= ruleRequiredCapability EOF ;
    public final EObject entryRuleRequiredCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleRequiredCapability_StartIndex = input.index();
        EObject iv_ruleRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1115:2: (iv_ruleRequiredCapability= ruleRequiredCapability EOF )
            // InternalSimpleBeeLangTestLanguage.g:1116:2: iv_ruleRequiredCapability= ruleRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequiredCapabilityRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRuleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredCapability"


    // $ANTLR start "ruleRequiredCapability"
    // InternalSimpleBeeLangTestLanguage.g:1125:1: ruleRequiredCapability returns [EObject current=null] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) ;
    public final EObject ruleRequiredCapability() throws RecognitionException {
        EObject current = null;
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
        EObject lv_condExpr_8_0 = null;



        	enterRule();
        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1134:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1135:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1135:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            // InternalSimpleBeeLangTestLanguage.g:1136:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            {
            // InternalSimpleBeeLangTestLanguage.g:1136:3: ()
            // InternalSimpleBeeLangTestLanguage.g:1137:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRequiredCapabilityAccess().getRequiredCapabilityAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:1146:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
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
                    // InternalSimpleBeeLangTestLanguage.g:1147:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1147:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:1148:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1148:5: (lv_nameSpace_1_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:1149:6: lv_nameSpace_1_0= RULE_ID
                    {
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nameSpace_1_0, grammarAccess.getRequiredCapabilityAccess().getNameSpaceIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRequiredCapabilityRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nameSpace",
                      							lv_nameSpace_1_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:1166:4: otherlv_2= 'unit'
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRequiredCapabilityAccess().getUnitKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:1171:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:1172:4: (lv_name_3_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:1172:4: (lv_name_3_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:1173:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getRequiredCapabilityAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRequiredCapabilityRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:1189:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            // InternalSimpleBeeLangTestLanguage.g:1190:4: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}'
            {
            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getRequiredCapabilityAccess().getLeftCurlyBracketKeyword_3_0());
              			
            }
            // InternalSimpleBeeLangTestLanguage.g:1194:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1195:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1195:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:1196:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // InternalSimpleBeeLangTestLanguage.g:1199:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:1200:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            {
            // InternalSimpleBeeLangTestLanguage.g:1200:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
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
            	    // InternalSimpleBeeLangTestLanguage.g:1201:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1201:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1202:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1202:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1203:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // InternalSimpleBeeLangTestLanguage.g:1206:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1206:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1206:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:1206:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
            	    {
            	    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_6, grammarAccess.getRequiredCapabilityAccess().getWhenKeyword_3_1_0_0());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_7, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_0_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1214:10: ( (lv_condExpr_8_0= ruleExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1215:11: (lv_condExpr_8_0= ruleExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1215:11: (lv_condExpr_8_0= ruleExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:1216:12: lv_condExpr_8_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												newCompositeNode(grammarAccess.getRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
            	      											
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_condExpr_8_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElementForParent(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												set(
            	      													current,
            	      													"condExpr",
            	      													lv_condExpr_8_0,
            	      													"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
            	      												afterParserOrEnumRuleCall();
            	      											
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_9, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_0_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleBeeLangTestLanguage.g:1243:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1243:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1244:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1244:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1245:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // InternalSimpleBeeLangTestLanguage.g:1248:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1248:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1248:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:1248:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1248:21: ( (lv_greedy_10_0= 'greedy' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1249:11: (lv_greedy_10_0= 'greedy' )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1249:11: (lv_greedy_10_0= 'greedy' )
            	    // InternalSimpleBeeLangTestLanguage.g:1250:12: lv_greedy_10_0= 'greedy'
            	    {
            	    lv_greedy_10_0=(Token)match(input,29,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_greedy_10_0, grammarAccess.getRequiredCapabilityAccess().getGreedyGreedyKeyword_3_1_1_0_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(current, "greedy", true, "greedy");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_11, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_1_1());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSimpleBeeLangTestLanguage.g:1272:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1272:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1273:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1273:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1274:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // InternalSimpleBeeLangTestLanguage.g:1277:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1277:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1277:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:1277:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
            	    {
            	    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_12, grammarAccess.getRequiredCapabilityAccess().getRequiresMinKeyword_3_1_2_0());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_13, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_2_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1285:10: ( (lv_min_14_0= RULE_INT ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1286:11: (lv_min_14_0= RULE_INT )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1286:11: (lv_min_14_0= RULE_INT )
            	    // InternalSimpleBeeLangTestLanguage.g:1287:12: lv_min_14_0= RULE_INT
            	    {
            	    lv_min_14_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_min_14_0, grammarAccess.getRequiredCapabilityAccess().getMinINTTerminalRuleCall_3_1_2_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"min",
            	      													lv_min_14_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_15, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_2_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalSimpleBeeLangTestLanguage.g:1313:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1313:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1314:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1314:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1315:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // InternalSimpleBeeLangTestLanguage.g:1318:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1318:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1318:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:1318:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
            	    {
            	    otherlv_16=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_16, grammarAccess.getRequiredCapabilityAccess().getRequiresMaxKeyword_3_1_3_0());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_17, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_3_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1326:10: ( (lv_max_18_0= RULE_INT ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1327:11: (lv_max_18_0= RULE_INT )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1327:11: (lv_max_18_0= RULE_INT )
            	    // InternalSimpleBeeLangTestLanguage.g:1328:12: lv_max_18_0= RULE_INT
            	    {
            	    lv_max_18_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_max_18_0, grammarAccess.getRequiredCapabilityAccess().getMaxINTTerminalRuleCall_3_1_3_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"max",
            	      													lv_max_18_0,
            	      													"org.eclipse.xtext.common.Terminals.INT");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_19, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_3_3());
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalSimpleBeeLangTestLanguage.g:1354:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1354:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1355:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1355:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1356:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // InternalSimpleBeeLangTestLanguage.g:1359:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1359:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1359:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    // InternalSimpleBeeLangTestLanguage.g:1359:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
            	    {
            	    otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_20, grammarAccess.getRequiredCapabilityAccess().getVersionKeyword_3_1_4_0());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_21, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_4_1());
            	      									
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1367:10: ( (lv_versionRange_22_0= RULE_ID ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1368:11: (lv_versionRange_22_0= RULE_ID )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1368:11: (lv_versionRange_22_0= RULE_ID )
            	    // InternalSimpleBeeLangTestLanguage.g:1369:12: lv_versionRange_22_0= RULE_ID
            	    {
            	    lv_versionRange_22_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_versionRange_22_0, grammarAccess.getRequiredCapabilityAccess().getVersionRangeIDTerminalRuleCall_3_1_4_2_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(
            	      													current,
            	      													"versionRange",
            	      													lv_versionRange_22_0,
            	      													"org.eclipse.xtext.common.Terminals.ID");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_23, grammarAccess.getRequiredCapabilityAccess().getSemicolonKeyword_3_1_4_3());
            	      									
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

            otherlv_24=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_24, grammarAccess.getRequiredCapabilityAccess().getRightCurlyBracketKeyword_3_2());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, ruleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleRequiredCapability"


    // $ANTLR start "entryRulePath"
    // InternalSimpleBeeLangTestLanguage.g:1414:1: entryRulePath returns [String current=null] : iv_rulePath= rulePath EOF ;
    public final String entryRulePath() throws RecognitionException {
        String current = null;
        int entryRulePath_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_rulePath = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1416:2: (iv_rulePath= rulePath EOF )
            // InternalSimpleBeeLangTestLanguage.g:1417:2: iv_rulePath= rulePath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePath.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalSimpleBeeLangTestLanguage.g:1426:1: rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) ) ;
    public final AntlrDatatypeRuleToken rulePath() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int rulePath_StartIndex = input.index();
        Token this_STRING_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_QID_2 = null;

        AntlrDatatypeRuleToken this_QID_4 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1433:2: ( (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1434:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1434:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? ) )
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
                    // InternalSimpleBeeLangTestLanguage.g:1435:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_0, grammarAccess.getPathAccess().getSTRINGTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:1443:3: ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1443:3: ( (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )? )
                    // InternalSimpleBeeLangTestLanguage.g:1444:4: (kw= '/' )? this_QID_2= ruleQID (kw= '/' this_QID_4= ruleQID )* (kw= '/' )?
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1444:4: (kw= '/' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==32) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalSimpleBeeLangTestLanguage.g:1445:5: kw= '/'
                            {
                            kw=(Token)match(input,32,FollowSets000.FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getPathAccess().getSolidusKeyword_1_0());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPathAccess().getQIDParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    this_QID_2=ruleQID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_QID_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:1461:4: (kw= '/' this_QID_4= ruleQID )*
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
                    	    // InternalSimpleBeeLangTestLanguage.g:1462:5: kw= '/' this_QID_4= ruleQID
                    	    {
                    	    kw=(Token)match(input,32,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(kw);
                    	      					newLeafNode(kw, grammarAccess.getPathAccess().getSolidusKeyword_1_2_0());
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					newCompositeNode(grammarAccess.getPathAccess().getQIDParserRuleCall_1_2_1());
                    	      				
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    this_QID_4=ruleQID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					current.merge(this_QID_4);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					afterParserOrEnumRuleCall();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // InternalSimpleBeeLangTestLanguage.g:1478:4: (kw= '/' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==32) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalSimpleBeeLangTestLanguage.g:1479:5: kw= '/'
                            {
                            kw=(Token)match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getPathAccess().getSolidusKeyword_1_3());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, rulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleParameterList"
    // InternalSimpleBeeLangTestLanguage.g:1493:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;
        int entryRuleParameterList_StartIndex = input.index();
        EObject iv_ruleParameterList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1493:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalSimpleBeeLangTestLanguage.g:1494:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRuleParameterList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalSimpleBeeLangTestLanguage.g:1500:1: ruleParameterList returns [EObject current=null] : ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;
        int ruleParameterList_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1506:2: ( ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:1507:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:1507:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:1508:3: ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            {
            // InternalSimpleBeeLangTestLanguage.g:1508:3: ( (lv_parameters_0_0= ruleFirstParameter ) )
            // InternalSimpleBeeLangTestLanguage.g:1509:4: (lv_parameters_0_0= ruleFirstParameter )
            {
            // InternalSimpleBeeLangTestLanguage.g:1509:4: (lv_parameters_0_0= ruleFirstParameter )
            // InternalSimpleBeeLangTestLanguage.g:1510:5: lv_parameters_0_0= ruleFirstParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParametersFirstParameterParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_parameters_0_0=ruleFirstParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterListRule());
              					}
              					add(
              						current,
              						"parameters",
              						lv_parameters_0_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.FirstParameter");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:1527:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:1528:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:1532:4: ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    // InternalSimpleBeeLangTestLanguage.g:1533:5: (lv_parameters_2_0= ruleFirstParameter )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:1533:5: (lv_parameters_2_0= ruleFirstParameter )
            	    // InternalSimpleBeeLangTestLanguage.g:1534:6: lv_parameters_2_0= ruleFirstParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParametersFirstParameterParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_26);
            	    lv_parameters_2_0=ruleFirstParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getParameterListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameters",
            	      							lv_parameters_2_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.FirstParameter");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, ruleParameterList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleFirstParameter"
    // InternalSimpleBeeLangTestLanguage.g:1556:1: entryRuleFirstParameter returns [EObject current=null] : iv_ruleFirstParameter= ruleFirstParameter EOF ;
    public final EObject entryRuleFirstParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleFirstParameter_StartIndex = input.index();
        EObject iv_ruleFirstParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1556:55: (iv_ruleFirstParameter= ruleFirstParameter EOF )
            // InternalSimpleBeeLangTestLanguage.g:1557:2: iv_ruleFirstParameter= ruleFirstParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstParameterRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleFirstParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFirstParameter"


    // $ANTLR start "ruleFirstParameter"
    // InternalSimpleBeeLangTestLanguage.g:1563:1: ruleFirstParameter returns [EObject current=null] : (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) ;
    public final EObject ruleFirstParameter() throws RecognitionException {
        EObject current = null;
        int ruleFirstParameter_StartIndex = input.index();
        EObject this_ClosureParameter_0 = null;

        EObject this_Parameter_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1569:2: ( (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) )
            // InternalSimpleBeeLangTestLanguage.g:1570:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            {
            // InternalSimpleBeeLangTestLanguage.g:1570:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:1571:3: this_ClosureParameter_0= ruleClosureParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFirstParameterAccess().getClosureParameterParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClosureParameter_0=ruleClosureParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureParameter_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:1583:3: this_Parameter_1= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFirstParameterAccess().getParameterParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Parameter_1=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Parameter_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, ruleFirstParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFirstParameter"


    // $ANTLR start "entryRuleParameter"
    // InternalSimpleBeeLangTestLanguage.g:1598:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleParameter_StartIndex = input.index();
        EObject iv_ruleParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1598:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSimpleBeeLangTestLanguage.g:1599:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSimpleBeeLangTestLanguage.g:1605:1: ruleParameter returns [EObject current=null] : ( (lv_expr_0_0= ruleExpression ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;
        int ruleParameter_StartIndex = input.index();
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1611:2: ( ( (lv_expr_0_0= ruleExpression ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1612:2: ( (lv_expr_0_0= ruleExpression ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1612:2: ( (lv_expr_0_0= ruleExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:1613:3: (lv_expr_0_0= ruleExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:1613:3: (lv_expr_0_0= ruleExpression )
            // InternalSimpleBeeLangTestLanguage.g:1614:4: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterAccess().getExprExpressionParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterRule());
              				}
              				set(
              					current,
              					"expr",
              					lv_expr_0_0,
              					"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, ruleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleClosureParameter"
    // InternalSimpleBeeLangTestLanguage.g:1634:1: entryRuleClosureParameter returns [EObject current=null] : iv_ruleClosureParameter= ruleClosureParameter EOF ;
    public final EObject entryRuleClosureParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureParameter_StartIndex = input.index();
        EObject iv_ruleClosureParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1634:57: (iv_ruleClosureParameter= ruleClosureParameter EOF )
            // InternalSimpleBeeLangTestLanguage.g:1635:2: iv_ruleClosureParameter= ruleClosureParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosureParameterRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureParameter"


    // $ANTLR start "ruleClosureParameter"
    // InternalSimpleBeeLangTestLanguage.g:1641:1: ruleClosureParameter returns [EObject current=null] : ( (lv_expr_0_0= ruleClosureExpression ) ) ;
    public final EObject ruleClosureParameter() throws RecognitionException {
        EObject current = null;
        int ruleClosureParameter_StartIndex = input.index();
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1647:2: ( ( (lv_expr_0_0= ruleClosureExpression ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1648:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1648:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:1649:3: (lv_expr_0_0= ruleClosureExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:1649:3: (lv_expr_0_0= ruleClosureExpression )
            // InternalSimpleBeeLangTestLanguage.g:1650:4: lv_expr_0_0= ruleClosureExpression
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getClosureParameterAccess().getExprClosureExpressionParserRuleCall_0());
              			
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_0_0=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getClosureParameterRule());
              				}
              				set(
              					current,
              					"expr",
              					lv_expr_0_0,
              					"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ClosureExpression");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, ruleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureParameter"


    // $ANTLR start "entryRuleParameterDeclaration"
    // InternalSimpleBeeLangTestLanguage.g:1670:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleParameterDeclaration_StartIndex = input.index();
        EObject iv_ruleParameterDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1670:61: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // InternalSimpleBeeLangTestLanguage.g:1671:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterDeclarationRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleParameterDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // InternalSimpleBeeLangTestLanguage.g:1677:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleParameterDeclaration_StartIndex = input.index();
        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1683:2: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1684:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1684:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1685:3: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1685:3: ( (lv_type_0_0= ruleTypeRef ) )?
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
                    // InternalSimpleBeeLangTestLanguage.g:1686:4: (lv_type_0_0= ruleTypeRef )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1686:4: (lv_type_0_0= ruleTypeRef )
                    // InternalSimpleBeeLangTestLanguage.g:1687:5: lv_type_0_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getParameterDeclarationAccess().getTypeTypeRefParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_type_0_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getParameterDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"type",
                      						lv_type_0_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:1704:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:1705:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:1705:4: (lv_name_1_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:1706:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getParameterDeclarationAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, ruleParameterDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleFunction"
    // InternalSimpleBeeLangTestLanguage.g:1726:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;
        int entryRuleFunction_StartIndex = input.index();
        EObject iv_ruleFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1726:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalSimpleBeeLangTestLanguage.g:1727:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalSimpleBeeLangTestLanguage.g:1733:1: ruleFunction returns [EObject current=null] : ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;
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
        EObject lv_returnType_4_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_9_0 = null;

        EObject lv_parameters_12_0 = null;

        EObject lv_parameters_14_0 = null;

        EObject lv_guard_17_0 = null;

        EObject lv_funcExpr_19_0 = null;

        EObject lv_funcExpr_21_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:1739:2: ( ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1740:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1740:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:1741:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:1741:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_DOCUMENTATION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:1742:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1742:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    // InternalSimpleBeeLangTestLanguage.g:1743:5: lv_documentation_0_0= RULE_DOCUMENTATION
                    {
                    lv_documentation_0_0=(Token)match(input,RULE_DOCUMENTATION,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_documentation_0_0, grammarAccess.getFunctionAccess().getDocumentationDOCUMENTATIONTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"documentation",
                      						lv_documentation_0_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.DOCUMENTATION");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:1759:3: ( (lv_visibility_1_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:1760:4: (lv_visibility_1_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1760:4: (lv_visibility_1_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:1761:5: lv_visibility_1_0= RULE_ID
                    {
                    lv_visibility_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_visibility_1_0, grammarAccess.getFunctionAccess().getVisibilityIDTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"visibility",
                      						lv_visibility_1_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:1777:3: ( (lv_final_2_0= 'final' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:1778:4: (lv_final_2_0= 'final' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1778:4: (lv_final_2_0= 'final' )
                    // InternalSimpleBeeLangTestLanguage.g:1779:5: lv_final_2_0= 'final'
                    {
                    lv_final_2_0=(Token)match(input,33,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_2_0, grammarAccess.getFunctionAccess().getFinalFinalKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionRule());
                      					}
                      					setWithLastConsumed(current, "final", true, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getFunctionKeyword_3());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:1795:3: ( (lv_returnType_4_0= ruleTypeRef ) )?
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
                    // InternalSimpleBeeLangTestLanguage.g:1796:4: (lv_returnType_4_0= ruleTypeRef )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1796:4: (lv_returnType_4_0= ruleTypeRef )
                    // InternalSimpleBeeLangTestLanguage.g:1797:5: lv_returnType_4_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeTypeRefParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_returnType_4_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionRule());
                      					}
                      					set(
                      						current,
                      						"returnType",
                      						lv_returnType_4_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:1814:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:1815:4: (lv_name_5_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:1815:4: (lv_name_5_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:1816:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_5_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_5_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_5_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:1832:3: (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:1833:4: otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')'
                    {
                    otherlv_6=(Token)match(input,35,FollowSets000.FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:1837:4: ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )?
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
                            // InternalSimpleBeeLangTestLanguage.g:1838:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:1838:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            // InternalSimpleBeeLangTestLanguage.g:1839:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            {
                            // InternalSimpleBeeLangTestLanguage.g:1839:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                            // InternalSimpleBeeLangTestLanguage.g:1840:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:1840:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            // InternalSimpleBeeLangTestLanguage.g:1841:8: lv_parameters_7_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_0_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_34);
                            lv_parameters_7_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getFunctionRule());
                              								}
                              								add(
                              									current,
                              									"parameters",
                              									lv_parameters_7_0,
                              									"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalSimpleBeeLangTestLanguage.g:1858:6: (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )*
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
                            	    // InternalSimpleBeeLangTestLanguage.g:1859:7: otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    {
                            	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_8, grammarAccess.getFunctionAccess().getCommaKeyword_6_1_0_1_0());
                            	      						
                            	    }
                            	    // InternalSimpleBeeLangTestLanguage.g:1863:7: ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    // InternalSimpleBeeLangTestLanguage.g:1864:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    {
                            	    // InternalSimpleBeeLangTestLanguage.g:1864:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    // InternalSimpleBeeLangTestLanguage.g:1865:9: lv_parameters_9_0= ruleParameterDeclaration
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_0_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_34);
                            	    lv_parameters_9_0=ruleParameterDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getFunctionRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"parameters",
                            	      										lv_parameters_9_0,
                            	      										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);

                            // InternalSimpleBeeLangTestLanguage.g:1883:6: (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==16) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // InternalSimpleBeeLangTestLanguage.g:1884:7: otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    {
                                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_10, grammarAccess.getFunctionAccess().getCommaKeyword_6_1_0_2_0());
                                      						
                                    }
                                    // InternalSimpleBeeLangTestLanguage.g:1888:7: ( (lv_varArgs_11_0= '...' ) )
                                    // InternalSimpleBeeLangTestLanguage.g:1889:8: (lv_varArgs_11_0= '...' )
                                    {
                                    // InternalSimpleBeeLangTestLanguage.g:1889:8: (lv_varArgs_11_0= '...' )
                                    // InternalSimpleBeeLangTestLanguage.g:1890:9: lv_varArgs_11_0= '...'
                                    {
                                    lv_varArgs_11_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_varArgs_11_0, grammarAccess.getFunctionAccess().getVarArgsFullStopFullStopFullStopKeyword_6_1_0_2_1_0());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getFunctionRule());
                                      									}
                                      									setWithLastConsumed(current, "varArgs", true, "...");
                                      								
                                    }

                                    }


                                    }

                                    // InternalSimpleBeeLangTestLanguage.g:1902:7: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    // InternalSimpleBeeLangTestLanguage.g:1903:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    {
                                    // InternalSimpleBeeLangTestLanguage.g:1903:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    // InternalSimpleBeeLangTestLanguage.g:1904:9: lv_parameters_12_0= ruleParameterDeclaration
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_0_2_2_0());
                                      								
                                    }
                                    pushFollow(FollowSets000.FOLLOW_37);
                                    lv_parameters_12_0=ruleParameterDeclaration();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getFunctionRule());
                                      									}
                                      									add(
                                      										current,
                                      										"parameters",
                                      										lv_parameters_12_0,
                                      										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                                      									afterParserOrEnumRuleCall();
                                      								
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
                            // InternalSimpleBeeLangTestLanguage.g:1924:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:1924:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            // InternalSimpleBeeLangTestLanguage.g:1925:6: ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:1925:6: ( (lv_varArgs_13_0= '...' ) )
                            // InternalSimpleBeeLangTestLanguage.g:1926:7: (lv_varArgs_13_0= '...' )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:1926:7: (lv_varArgs_13_0= '...' )
                            // InternalSimpleBeeLangTestLanguage.g:1927:8: lv_varArgs_13_0= '...'
                            {
                            lv_varArgs_13_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_varArgs_13_0, grammarAccess.getFunctionAccess().getVarArgsFullStopFullStopFullStopKeyword_6_1_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getFunctionRule());
                              								}
                              								setWithLastConsumed(current, "varArgs", true, "...");
                              							
                            }

                            }


                            }

                            // InternalSimpleBeeLangTestLanguage.g:1939:6: ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            // InternalSimpleBeeLangTestLanguage.g:1940:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:1940:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            // InternalSimpleBeeLangTestLanguage.g:1941:8: lv_parameters_14_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getFunctionAccess().getParametersParameterDeclarationParserRuleCall_6_1_1_1_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            lv_parameters_14_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getFunctionRule());
                              								}
                              								add(
                              									current,
                              									"parameters",
                              									lv_parameters_14_0,
                              									"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }


                            }
                            break;

                    }

                    otherlv_15=(Token)match(input,37,FollowSets000.FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_6_2());
                      			
                    }

                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:1965:3: (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:1966:4: otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) )
                    {
                    otherlv_16=(Token)match(input,26,FollowSets000.FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getFunctionAccess().getWhenKeyword_7_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:1970:4: ( (lv_guard_17_0= ruleGuardExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:1971:5: (lv_guard_17_0= ruleGuardExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1971:5: (lv_guard_17_0= ruleGuardExpression )
                    // InternalSimpleBeeLangTestLanguage.g:1972:6: lv_guard_17_0= ruleGuardExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionAccess().getGuardGuardExpressionParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    lv_guard_17_0=ruleGuardExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionRule());
                      						}
                      						set(
                      							current,
                      							"guard",
                      							lv_guard_17_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.GuardExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:1990:3: ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
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
                    // InternalSimpleBeeLangTestLanguage.g:1991:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1991:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    // InternalSimpleBeeLangTestLanguage.g:1992:5: otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';'
                    {
                    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_18, grammarAccess.getFunctionAccess().getColonKeyword_8_0_0());
                      				
                    }
                    // InternalSimpleBeeLangTestLanguage.g:1996:5: ( (lv_funcExpr_19_0= ruleExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:1997:6: (lv_funcExpr_19_0= ruleExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:1997:6: (lv_funcExpr_19_0= ruleExpression )
                    // InternalSimpleBeeLangTestLanguage.g:1998:7: lv_funcExpr_19_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getFunctionAccess().getFuncExprExpressionParserRuleCall_8_0_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_funcExpr_19_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getFunctionRule());
                      							}
                      							set(
                      								current,
                      								"funcExpr",
                      								lv_funcExpr_19_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_20, grammarAccess.getFunctionAccess().getSemicolonKeyword_8_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2021:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2021:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:2022:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2022:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    // InternalSimpleBeeLangTestLanguage.g:2023:6: lv_funcExpr_21_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionAccess().getFuncExprBlockExpressionParserRuleCall_8_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_funcExpr_21_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionRule());
                      						}
                      						set(
                      							current,
                      							"funcExpr",
                      							lv_funcExpr_21_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, ruleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGuardExpression"
    // InternalSimpleBeeLangTestLanguage.g:2045:1: entryRuleGuardExpression returns [EObject current=null] : iv_ruleGuardExpression= ruleGuardExpression EOF ;
    public final EObject entryRuleGuardExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleGuardExpression_StartIndex = input.index();
        EObject iv_ruleGuardExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2045:56: (iv_ruleGuardExpression= ruleGuardExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:2046:2: iv_ruleGuardExpression= ruleGuardExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGuardExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardExpression"


    // $ANTLR start "ruleGuardExpression"
    // InternalSimpleBeeLangTestLanguage.g:2052:1: ruleGuardExpression returns [EObject current=null] : ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleGuardExpression() throws RecognitionException {
        EObject current = null;
        int ruleGuardExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_guardExpr_1_0 = null;

        EObject lv_guardExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2058:2: ( ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:2059:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:2059:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
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
                    // InternalSimpleBeeLangTestLanguage.g:2060:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2060:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    // InternalSimpleBeeLangTestLanguage.g:2061:4: otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';'
                    {
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getGuardExpressionAccess().getColonKeyword_0_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:2065:4: ( (lv_guardExpr_1_0= ruleExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:2066:5: (lv_guardExpr_1_0= ruleExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2066:5: (lv_guardExpr_1_0= ruleExpression )
                    // InternalSimpleBeeLangTestLanguage.g:2067:6: lv_guardExpr_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getGuardExpressionAccess().getGuardExprExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_guardExpr_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getGuardExpressionRule());
                      						}
                      						set(
                      							current,
                      							"guardExpr",
                      							lv_guardExpr_1_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getGuardExpressionAccess().getSemicolonKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2090:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2090:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:2091:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2091:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    // InternalSimpleBeeLangTestLanguage.g:2092:5: lv_guardExpr_3_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getGuardExpressionAccess().getGuardExprBlockExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_guardExpr_3_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getGuardExpressionRule());
                      					}
                      					set(
                      						current,
                      						"guardExpr",
                      						lv_guardExpr_3_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, ruleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleGuardExpression"


    // $ANTLR start "entryRuleAssignmentOperator"
    // InternalSimpleBeeLangTestLanguage.g:2113:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;
        int entryRuleAssignmentOperator_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2113:58: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // InternalSimpleBeeLangTestLanguage.g:2114:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleAssignmentOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // InternalSimpleBeeLangTestLanguage.g:2120:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleAssignmentOperator_StartIndex = input.index();
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2126:2: ( (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) )
            // InternalSimpleBeeLangTestLanguage.g:2127:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            {
            // InternalSimpleBeeLangTestLanguage.g:2127:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
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
                    // InternalSimpleBeeLangTestLanguage.g:2128:3: kw= '='
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2134:3: kw= '+='
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleBeeLangTestLanguage.g:2140:3: kw= '-='
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getHyphenMinusEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSimpleBeeLangTestLanguage.g:2146:3: kw= '*='
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getAsteriskEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSimpleBeeLangTestLanguage.g:2152:3: kw= '/='
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getSolidusEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSimpleBeeLangTestLanguage.g:2158:3: kw= '%='
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPercentSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, ruleAssignmentOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // InternalSimpleBeeLangTestLanguage.g:2167:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;
        int entryRuleRelationalOperator_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2167:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalSimpleBeeLangTestLanguage.g:2168:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleRelationalOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalSimpleBeeLangTestLanguage.g:2174:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleRelationalOperator_StartIndex = input.index();
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2180:2: ( (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // InternalSimpleBeeLangTestLanguage.g:2181:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // InternalSimpleBeeLangTestLanguage.g:2181:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
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
                    // InternalSimpleBeeLangTestLanguage.g:2182:3: kw= '~='
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getTildeEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2188:3: kw= '=='
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getEqualsSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleBeeLangTestLanguage.g:2194:3: kw= '==='
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSimpleBeeLangTestLanguage.g:2200:3: kw= '!='
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getExclamationMarkEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSimpleBeeLangTestLanguage.g:2206:3: kw= '!=='
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getExclamationMarkEqualsSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSimpleBeeLangTestLanguage.g:2212:3: kw= '>='
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalSimpleBeeLangTestLanguage.g:2218:3: kw= '<='
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalSimpleBeeLangTestLanguage.g:2224:3: kw= '>'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalSimpleBeeLangTestLanguage.g:2230:3: kw= '<'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_8());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, ruleRelationalOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleTopLevelExpression"
    // InternalSimpleBeeLangTestLanguage.g:2239:1: entryRuleTopLevelExpression returns [EObject current=null] : iv_ruleTopLevelExpression= ruleTopLevelExpression EOF ;
    public final EObject entryRuleTopLevelExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleTopLevelExpression_StartIndex = input.index();
        EObject iv_ruleTopLevelExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2239:59: (iv_ruleTopLevelExpression= ruleTopLevelExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:2240:2: iv_ruleTopLevelExpression= ruleTopLevelExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopLevelExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleTopLevelExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelExpression"


    // $ANTLR start "ruleTopLevelExpression"
    // InternalSimpleBeeLangTestLanguage.g:2246:1: ruleTopLevelExpression returns [EObject current=null] : (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) ;
    public final EObject ruleTopLevelExpression() throws RecognitionException {
        EObject current = null;
        int ruleTopLevelExpression_StartIndex = input.index();
        EObject this_VarDeclaration_0 = null;

        EObject this_ValDeclaration_1 = null;

        EObject this_AssignmentExpression_2 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2252:2: ( (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:2253:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:2253:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:2254:3: this_VarDeclaration_0= ruleVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTopLevelExpressionAccess().getVarDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_VarDeclaration_0=ruleVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VarDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2266:3: this_ValDeclaration_1= ruleValDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTopLevelExpressionAccess().getValDeclarationParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ValDeclaration_1=ruleValDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValDeclaration_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleBeeLangTestLanguage.g:2278:3: this_AssignmentExpression_2= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTopLevelExpressionAccess().getAssignmentExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AssignmentExpression_2=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignmentExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, ruleTopLevelExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTopLevelExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalSimpleBeeLangTestLanguage.g:2293:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleExpression_StartIndex = input.index();
        EObject iv_ruleExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2293:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:2294:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalSimpleBeeLangTestLanguage.g:2300:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;
        int ruleExpression_StartIndex = input.index();
        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2306:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalSimpleBeeLangTestLanguage.g:2307:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, ruleExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalSimpleBeeLangTestLanguage.g:2321:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAssignmentExpression_StartIndex = input.index();
        EObject iv_ruleAssignmentExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2321:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:2322:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleAssignmentExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalSimpleBeeLangTestLanguage.g:2328:1: ruleAssignmentExpression returns [EObject current=null] : (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;
        int ruleAssignmentExpression_StartIndex = input.index();
        EObject this_CachedExpression_0 = null;

        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2334:2: ( (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) )
            // InternalSimpleBeeLangTestLanguage.g:2335:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            {
            // InternalSimpleBeeLangTestLanguage.g:2335:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            // InternalSimpleBeeLangTestLanguage.g:2336:3: this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getCachedExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_40);
            this_CachedExpression_0=ruleCachedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CachedExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:2347:3: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            int alt43=2;
            switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA43_1 = input.LA(2);

                    if ( (synpred71_InternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 39:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred71_InternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred71_InternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred71_InternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA43_5 = input.LA(2);

                    if ( (synpred71_InternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA43_6 = input.LA(2);

                    if ( (synpred71_InternalSimpleBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
            }

            switch (alt43) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:2348:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2348:4: ()
                    // InternalSimpleBeeLangTestLanguage.g:2349:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLeftExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSimpleBeeLangTestLanguage.g:2358:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
                    // InternalSimpleBeeLangTestLanguage.g:2359:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2359:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    // InternalSimpleBeeLangTestLanguage.g:2360:6: lv_functionName_2_0= ruleAssignmentOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getFunctionNameAssignmentOperatorParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_19);
                    lv_functionName_2_0=ruleAssignmentOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"functionName",
                      							lv_functionName_2_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AssignmentOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:2377:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:2378:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2378:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    // InternalSimpleBeeLangTestLanguage.g:2379:6: lv_rightExpr_3_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightExprAssignmentExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_rightExpr_3_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"rightExpr",
                      							lv_rightExpr_3_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AssignmentExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, ruleAssignmentExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleVarDeclaration"
    // InternalSimpleBeeLangTestLanguage.g:2401:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleVarDeclaration_StartIndex = input.index();
        EObject iv_ruleVarDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2401:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalSimpleBeeLangTestLanguage.g:2402:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarDeclarationRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleVarDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // InternalSimpleBeeLangTestLanguage.g:2408:1: ruleVarDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleVarDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        EObject lv_type_3_0 = null;

        EObject lv_valueExpr_6_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2414:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) )
            // InternalSimpleBeeLangTestLanguage.g:2415:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            {
            // InternalSimpleBeeLangTestLanguage.g:2415:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            // InternalSimpleBeeLangTestLanguage.g:2416:3: () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            {
            // InternalSimpleBeeLangTestLanguage.g:2416:3: ()
            // InternalSimpleBeeLangTestLanguage.g:2417:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarDeclarationAccess().getDefValueAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:2426:3: ( (lv_final_1_0= 'final' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==33) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:2427:4: (lv_final_1_0= 'final' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2427:4: (lv_final_1_0= 'final' )
                    // InternalSimpleBeeLangTestLanguage.g:2428:5: lv_final_1_0= 'final'
                    {
                    lv_final_1_0=(Token)match(input,33,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_1_0, grammarAccess.getVarDeclarationAccess().getFinalFinalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVarDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "final", true, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:2440:3: ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) )
            // InternalSimpleBeeLangTestLanguage.g:2441:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:2441:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) )
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
                    // InternalSimpleBeeLangTestLanguage.g:2442:5: otherlv_2= 'var'
                    {
                    otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getVarDeclarationAccess().getVarKeyword_2_0_0());
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2447:5: ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2447:5: ( (lv_type_3_0= ruleTypeRef ) )
                    // InternalSimpleBeeLangTestLanguage.g:2448:6: (lv_type_3_0= ruleTypeRef )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2448:6: (lv_type_3_0= ruleTypeRef )
                    // InternalSimpleBeeLangTestLanguage.g:2449:7: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarDeclarationAccess().getTypeTypeRefParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarDeclarationRule());
                      							}
                      							set(
                      								current,
                      								"type",
                      								lv_type_3_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:2467:4: ( (lv_name_4_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:2468:5: (lv_name_4_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:2468:5: (lv_name_4_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:2469:6: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(lv_name_4_0, grammarAccess.getVarDeclarationAccess().getNameIDTerminalRuleCall_2_1_0());
              					
            }
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getVarDeclarationRule());
              						}
              						setWithLastConsumed(
              							current,
              							"name",
              							lv_name_4_0,
              							"org.eclipse.xtext.common.Terminals.ID");
              					
            }

            }


            }


            }

            // InternalSimpleBeeLangTestLanguage.g:2486:3: (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:2487:4: otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getVarDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:2491:4: ( (lv_valueExpr_6_0= ruleExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:2492:5: (lv_valueExpr_6_0= ruleExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2492:5: (lv_valueExpr_6_0= ruleExpression )
                    // InternalSimpleBeeLangTestLanguage.g:2493:6: lv_valueExpr_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarDeclarationAccess().getValueExprExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_valueExpr_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"valueExpr",
                      							lv_valueExpr_6_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, ruleVarDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleValDeclaration"
    // InternalSimpleBeeLangTestLanguage.g:2515:1: entryRuleValDeclaration returns [EObject current=null] : iv_ruleValDeclaration= ruleValDeclaration EOF ;
    public final EObject entryRuleValDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleValDeclaration_StartIndex = input.index();
        EObject iv_ruleValDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2515:55: (iv_ruleValDeclaration= ruleValDeclaration EOF )
            // InternalSimpleBeeLangTestLanguage.g:2516:2: iv_ruleValDeclaration= ruleValDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValDeclarationRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleValDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValDeclaration"


    // $ANTLR start "ruleValDeclaration"
    // InternalSimpleBeeLangTestLanguage.g:2522:1: ruleValDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) ;
    public final EObject ruleValDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleValDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token lv_immutable_2_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        EObject lv_type_3_0 = null;

        EObject lv_valueExpr_6_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2528:2: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:2529:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:2529:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            // InternalSimpleBeeLangTestLanguage.g:2530:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:2530:3: ()
            // InternalSimpleBeeLangTestLanguage.g:2531:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValDeclarationAccess().getDefValueAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:2540:3: ( (lv_final_1_0= 'final' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==33) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:2541:4: (lv_final_1_0= 'final' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2541:4: (lv_final_1_0= 'final' )
                    // InternalSimpleBeeLangTestLanguage.g:2542:5: lv_final_1_0= 'final'
                    {
                    lv_final_1_0=(Token)match(input,33,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_1_0, grammarAccess.getValDeclarationAccess().getFinalFinalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getValDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "final", true, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:2554:3: ( (lv_immutable_2_0= 'val' ) )
            // InternalSimpleBeeLangTestLanguage.g:2555:4: (lv_immutable_2_0= 'val' )
            {
            // InternalSimpleBeeLangTestLanguage.g:2555:4: (lv_immutable_2_0= 'val' )
            // InternalSimpleBeeLangTestLanguage.g:2556:5: lv_immutable_2_0= 'val'
            {
            lv_immutable_2_0=(Token)match(input,54,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_immutable_2_0, grammarAccess.getValDeclarationAccess().getImmutableValKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValDeclarationRule());
              					}
              					setWithLastConsumed(current, "immutable", true, "val");
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:2568:3: ( (lv_type_3_0= ruleTypeRef ) )?
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
                    // InternalSimpleBeeLangTestLanguage.g:2569:4: (lv_type_3_0= ruleTypeRef )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2569:4: (lv_type_3_0= ruleTypeRef )
                    // InternalSimpleBeeLangTestLanguage.g:2570:5: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getValDeclarationAccess().getTypeTypeRefParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getValDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"type",
                      						lv_type_3_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:2587:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:2588:4: (lv_name_4_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:2588:4: (lv_name_4_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:2589:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getValDeclarationAccess().getNameIDTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getValDeclarationAccess().getEqualsSignKeyword_5());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:2609:3: ( (lv_valueExpr_6_0= ruleExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:2610:4: (lv_valueExpr_6_0= ruleExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:2610:4: (lv_valueExpr_6_0= ruleExpression )
            // InternalSimpleBeeLangTestLanguage.g:2611:5: lv_valueExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getValDeclarationAccess().getValueExprExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_valueExpr_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getValDeclarationRule());
              					}
              					set(
              						current,
              						"valueExpr",
              						lv_valueExpr_6_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, ruleValDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValDeclaration"


    // $ANTLR start "entryRuleTypeRef"
    // InternalSimpleBeeLangTestLanguage.g:2632:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleTypeRef_StartIndex = input.index();
        EObject iv_ruleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2632:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalSimpleBeeLangTestLanguage.g:2633:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalSimpleBeeLangTestLanguage.g:2639:1: ruleTypeRef returns [EObject current=null] : (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;
        int ruleTypeRef_StartIndex = input.index();
        EObject this_ClosureTypeRef_0 = null;

        EObject this_SimpleTypeRef_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2645:2: ( (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) )
            // InternalSimpleBeeLangTestLanguage.g:2646:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            {
            // InternalSimpleBeeLangTestLanguage.g:2646:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
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
                    // InternalSimpleBeeLangTestLanguage.g:2647:3: this_ClosureTypeRef_0= ruleClosureTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRefAccess().getClosureTypeRefParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClosureTypeRef_0=ruleClosureTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureTypeRef_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2659:3: this_SimpleTypeRef_1= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeRefAccess().getSimpleTypeRefParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimpleTypeRef_1=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SimpleTypeRef_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, ruleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleSimpleTypeRef"
    // InternalSimpleBeeLangTestLanguage.g:2674:1: entryRuleSimpleTypeRef returns [EObject current=null] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final EObject entryRuleSimpleTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleSimpleTypeRef_StartIndex = input.index();
        EObject iv_ruleSimpleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2674:54: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // InternalSimpleBeeLangTestLanguage.g:2675:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleTypeRefRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleSimpleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleTypeRef"


    // $ANTLR start "ruleSimpleTypeRef"
    // InternalSimpleBeeLangTestLanguage.g:2681:1: ruleSimpleTypeRef returns [EObject current=null] : ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleSimpleTypeRef() throws RecognitionException {
        EObject current = null;
        int ruleSimpleTypeRef_StartIndex = input.index();
        Token lv_rawType_0_0=null;
        Token otherlv_1=null;
        Token lv_actualArgumentsList_2_0=null;
        Token otherlv_3=null;
        Token lv_actualArgumentsList_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2687:2: ( ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) )
            // InternalSimpleBeeLangTestLanguage.g:2688:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            {
            // InternalSimpleBeeLangTestLanguage.g:2688:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            // InternalSimpleBeeLangTestLanguage.g:2689:3: ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            {
            // InternalSimpleBeeLangTestLanguage.g:2689:3: ( (lv_rawType_0_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:2690:4: (lv_rawType_0_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:2690:4: (lv_rawType_0_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:2691:5: lv_rawType_0_0= RULE_ID
            {
            lv_rawType_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_rawType_0_0, grammarAccess.getSimpleTypeRefAccess().getRawTypeIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSimpleTypeRefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"rawType",
              						lv_rawType_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:2707:3: (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:2708:4: otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSimpleTypeRefAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:2712:4: ( (lv_actualArgumentsList_2_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:2713:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2713:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:2714:6: lv_actualArgumentsList_2_0= RULE_ID
                    {
                    lv_actualArgumentsList_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_actualArgumentsList_2_0, grammarAccess.getSimpleTypeRefAccess().getActualArgumentsListIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSimpleTypeRefRule());
                      						}
                      						addWithLastConsumed(
                      							current,
                      							"actualArgumentsList",
                      							lv_actualArgumentsList_2_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:2730:4: (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==16) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalSimpleBeeLangTestLanguage.g:2731:5: otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getSimpleTypeRefAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:2735:5: ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:2736:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:2736:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    // InternalSimpleBeeLangTestLanguage.g:2737:7: lv_actualArgumentsList_4_0= RULE_ID
                    	    {
                    	    lv_actualArgumentsList_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(lv_actualArgumentsList_4_0, grammarAccess.getSimpleTypeRefAccess().getActualArgumentsListIDTerminalRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getSimpleTypeRefRule());
                    	      							}
                    	      							addWithLastConsumed(
                    	      								current,
                    	      								"actualArgumentsList",
                    	      								lv_actualArgumentsList_4_0,
                    	      								"org.eclipse.xtext.common.Terminals.ID");
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,51,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getSimpleTypeRefAccess().getGreaterThanSignKeyword_1_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, ruleSimpleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleSimpleTypeRef"


    // $ANTLR start "entryRuleClosureTypeRef"
    // InternalSimpleBeeLangTestLanguage.g:2763:1: entryRuleClosureTypeRef returns [EObject current=null] : iv_ruleClosureTypeRef= ruleClosureTypeRef EOF ;
    public final EObject entryRuleClosureTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureTypeRef_StartIndex = input.index();
        EObject iv_ruleClosureTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2763:55: (iv_ruleClosureTypeRef= ruleClosureTypeRef EOF )
            // InternalSimpleBeeLangTestLanguage.g:2764:2: iv_ruleClosureTypeRef= ruleClosureTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosureTypeRefRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleClosureTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureTypeRef"


    // $ANTLR start "ruleClosureTypeRef"
    // InternalSimpleBeeLangTestLanguage.g:2770:1: ruleClosureTypeRef returns [EObject current=null] : (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) ;
    public final EObject ruleClosureTypeRef() throws RecognitionException {
        EObject current = null;
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


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2776:2: ( (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:2777:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:2777:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            // InternalSimpleBeeLangTestLanguage.g:2778:3: otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClosureTypeRefAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:2782:3: ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )?
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
                    // InternalSimpleBeeLangTestLanguage.g:2783:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2783:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    // InternalSimpleBeeLangTestLanguage.g:2784:5: ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2784:5: ( (lv_parameterTypes_1_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:2785:6: (lv_parameterTypes_1_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2785:6: (lv_parameterTypes_1_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:2786:7: lv_parameterTypes_1_0= RULE_ID
                    {
                    lv_parameterTypes_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_parameterTypes_1_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureTypeRefRule());
                      							}
                      							addWithLastConsumed(
                      								current,
                      								"parameterTypes",
                      								lv_parameterTypes_1_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:2802:5: (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )*
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
                    	    // InternalSimpleBeeLangTestLanguage.g:2803:6: otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_2, grammarAccess.getClosureTypeRefAccess().getCommaKeyword_1_0_1_0());
                    	      					
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:2807:6: ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:2808:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:2808:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    // InternalSimpleBeeLangTestLanguage.g:2809:8: lv_parameterTypes_3_0= RULE_ID
                    	    {
                    	    lv_parameterTypes_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								newLeafNode(lv_parameterTypes_3_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_0_1_1_0());
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElement(grammarAccess.getClosureTypeRefRule());
                    	      								}
                    	      								addWithLastConsumed(
                    	      									current,
                    	      									"parameterTypes",
                    	      									lv_parameterTypes_3_0,
                    	      									"org.eclipse.xtext.common.Terminals.ID");
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    // InternalSimpleBeeLangTestLanguage.g:2826:5: (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==16) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalSimpleBeeLangTestLanguage.g:2827:6: otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getClosureTypeRefAccess().getCommaKeyword_1_0_2_0());
                              					
                            }
                            // InternalSimpleBeeLangTestLanguage.g:2831:6: ( (lv_varArgs_5_0= '...' ) )
                            // InternalSimpleBeeLangTestLanguage.g:2832:7: (lv_varArgs_5_0= '...' )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:2832:7: (lv_varArgs_5_0= '...' )
                            // InternalSimpleBeeLangTestLanguage.g:2833:8: lv_varArgs_5_0= '...'
                            {
                            lv_varArgs_5_0=(Token)match(input,36,FollowSets000.FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_varArgs_5_0, grammarAccess.getClosureTypeRefAccess().getVarArgsFullStopFullStopFullStopKeyword_1_0_2_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getClosureTypeRefRule());
                              								}
                              								setWithLastConsumed(current, "varArgs", true, "...");
                              							
                            }

                            }


                            }

                            // InternalSimpleBeeLangTestLanguage.g:2845:6: ( (lv_parameterTypes_6_0= RULE_ID ) )
                            // InternalSimpleBeeLangTestLanguage.g:2846:7: (lv_parameterTypes_6_0= RULE_ID )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:2846:7: (lv_parameterTypes_6_0= RULE_ID )
                            // InternalSimpleBeeLangTestLanguage.g:2847:8: lv_parameterTypes_6_0= RULE_ID
                            {
                            lv_parameterTypes_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_parameterTypes_6_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_0_2_2_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getClosureTypeRefRule());
                              								}
                              								addWithLastConsumed(
                              									current,
                              									"parameterTypes",
                              									lv_parameterTypes_6_0,
                              									"org.eclipse.xtext.common.Terminals.ID");
                              							
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
                    // InternalSimpleBeeLangTestLanguage.g:2866:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2866:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    // InternalSimpleBeeLangTestLanguage.g:2867:5: ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2867:5: ( (lv_varArgs_7_0= '...' ) )
                    // InternalSimpleBeeLangTestLanguage.g:2868:6: (lv_varArgs_7_0= '...' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2868:6: (lv_varArgs_7_0= '...' )
                    // InternalSimpleBeeLangTestLanguage.g:2869:7: lv_varArgs_7_0= '...'
                    {
                    lv_varArgs_7_0=(Token)match(input,36,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_varArgs_7_0, grammarAccess.getClosureTypeRefAccess().getVarArgsFullStopFullStopFullStopKeyword_1_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureTypeRefRule());
                      							}
                      							setWithLastConsumed(current, "varArgs", true, "...");
                      						
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:2881:5: ( (lv_parameterTypes_8_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:2882:6: (lv_parameterTypes_8_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2882:6: (lv_parameterTypes_8_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:2883:7: lv_parameterTypes_8_0= RULE_ID
                    {
                    lv_parameterTypes_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_parameterTypes_8_0, grammarAccess.getClosureTypeRefAccess().getParameterTypesIDTerminalRuleCall_1_1_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureTypeRefRule());
                      							}
                      							addWithLastConsumed(
                      								current,
                      								"parameterTypes",
                      								lv_parameterTypes_8_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,37,FollowSets000.FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getClosureTypeRefAccess().getRightParenthesisKeyword_2());
              		
            }
            otherlv_10=(Token)match(input,55,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getClosureTypeRefAccess().getEqualsSignGreaterThanSignKeyword_3());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:2909:3: ( (lv_returnType_11_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:2910:4: (lv_returnType_11_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:2910:4: (lv_returnType_11_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:2911:5: lv_returnType_11_0= RULE_ID
            {
            lv_returnType_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_returnType_11_0, grammarAccess.getClosureTypeRefAccess().getReturnTypeIDTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getClosureTypeRefRule());
              					}
              					setWithLastConsumed(
              						current,
              						"returnType",
              						lv_returnType_11_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, ruleClosureTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureTypeRef"


    // $ANTLR start "entryRuleCachedExpression"
    // InternalSimpleBeeLangTestLanguage.g:2931:1: entryRuleCachedExpression returns [EObject current=null] : iv_ruleCachedExpression= ruleCachedExpression EOF ;
    public final EObject entryRuleCachedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleCachedExpression_StartIndex = input.index();
        EObject iv_ruleCachedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2931:57: (iv_ruleCachedExpression= ruleCachedExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:2932:2: iv_ruleCachedExpression= ruleCachedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCachedExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleCachedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCachedExpression"


    // $ANTLR start "ruleCachedExpression"
    // InternalSimpleBeeLangTestLanguage.g:2938:1: ruleCachedExpression returns [EObject current=null] : ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) ;
    public final EObject ruleCachedExpression() throws RecognitionException {
        EObject current = null;
        int ruleCachedExpression_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;

        EObject this_OrExpression_3 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2944:2: ( ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:2945:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:2945:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
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
                    // InternalSimpleBeeLangTestLanguage.g:2946:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2946:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    // InternalSimpleBeeLangTestLanguage.g:2947:4: () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2947:4: ()
                    // InternalSimpleBeeLangTestLanguage.g:2948:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCachedExpressionAccess().getCachedExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCachedExpressionAccess().getCachedKeyword_0_1());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:2961:4: ( (lv_expr_2_0= ruleOrExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:2962:5: (lv_expr_2_0= ruleOrExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:2962:5: (lv_expr_2_0= ruleOrExpression )
                    // InternalSimpleBeeLangTestLanguage.g:2963:6: lv_expr_2_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCachedExpressionAccess().getExprOrExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_2_0=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCachedExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_2_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.OrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:2982:3: this_OrExpression_3= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCachedExpressionAccess().getOrExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_OrExpression_3=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OrExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, ruleCachedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleCachedExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalSimpleBeeLangTestLanguage.g:2997:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleOrExpression_StartIndex = input.index();
        EObject iv_ruleOrExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:2997:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:2998:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalSimpleBeeLangTestLanguage.g:3004:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;
        int ruleOrExpression_StartIndex = input.index();
        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3010:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3011:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3011:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:3012:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_49);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3023:3: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==57) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred85_InternalSimpleBeeLangTestLanguage()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3024:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3024:4: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3025:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrExpressionAccess().getOrExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:3038:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3039:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3039:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:3040:6: lv_rightExpr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightExprAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_49);
            	    lv_rightExpr_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, ruleOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalSimpleBeeLangTestLanguage.g:3062:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAndExpression_StartIndex = input.index();
        EObject iv_ruleAndExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3062:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3063:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalSimpleBeeLangTestLanguage.g:3069:1: ruleAndExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;
        int ruleAndExpression_StartIndex = input.index();
        Token otherlv_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3075:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3076:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3076:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:3077:3: this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_50);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3088:3: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==58) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred86_InternalSimpleBeeLangTestLanguage()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3089:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3089:4: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3090:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndExpressionAccess().getAndExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:3103:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3104:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3104:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:3105:6: lv_rightExpr_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightExprRelationalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_50);
            	    lv_rightExpr_3_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.RelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, ruleAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalSimpleBeeLangTestLanguage.g:3127:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleRelationalExpression_StartIndex = input.index();
        EObject iv_ruleRelationalExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3127:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3128:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalSimpleBeeLangTestLanguage.g:3134:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;
        int ruleRelationalExpression_StartIndex = input.index();
        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3140:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3141:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3141:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:3142:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_51);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3153:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3154:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3154:4: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3155:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRelationalExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3164:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3165:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3165:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    // InternalSimpleBeeLangTestLanguage.g:3166:6: lv_functionName_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getFunctionNameRelationalOperatorParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    lv_functionName_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"functionName",
            	      							lv_functionName_2_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.RelationalOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3183:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3184:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3184:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:3185:6: lv_rightExpr_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightExprAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_51);
            	    lv_rightExpr_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, ruleRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalSimpleBeeLangTestLanguage.g:3207:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAdditiveExpression_StartIndex = input.index();
        EObject iv_ruleAdditiveExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3207:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3208:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalSimpleBeeLangTestLanguage.g:3214:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;
        int ruleAdditiveExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3220:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3221:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3221:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:3222:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_52);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3233:3: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==59) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred89_InternalSimpleBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==60) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred89_InternalSimpleBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3234:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3234:4: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3235:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3244:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3245:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3245:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3246:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3246:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
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
            	            // InternalSimpleBeeLangTestLanguage.g:3247:7: lv_functionName_2_1= '+'
            	            {
            	            lv_functionName_2_1=(Token)match(input,59,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_1, grammarAccess.getAdditiveExpressionAccess().getFunctionNamePlusSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalSimpleBeeLangTestLanguage.g:3258:7: lv_functionName_2_2= '-'
            	            {
            	            lv_functionName_2_2=(Token)match(input,60,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_2, grammarAccess.getAdditiveExpressionAccess().getFunctionNameHyphenMinusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3271:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3272:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3272:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:3273:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightExprMultiplicativeExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_52);
            	    lv_rightExpr_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.MultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, ruleAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalSimpleBeeLangTestLanguage.g:3295:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleMultiplicativeExpression_StartIndex = input.index();
        EObject iv_ruleMultiplicativeExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3295:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3296:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalSimpleBeeLangTestLanguage.g:3302:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        int ruleMultiplicativeExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        EObject this_SetExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3308:2: ( (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3309:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3309:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:3310:3: this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getSetExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_53);
            this_SetExpression_0=ruleSetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SetExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3321:3: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred92_InternalSimpleBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred92_InternalSimpleBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 62:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred92_InternalSimpleBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3322:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3322:4: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3323:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3332:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3333:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3333:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3334:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3334:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
            	            // InternalSimpleBeeLangTestLanguage.g:3335:7: lv_functionName_2_1= '*'
            	            {
            	            lv_functionName_2_1=(Token)match(input,61,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_1, grammarAccess.getMultiplicativeExpressionAccess().getFunctionNameAsteriskKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalSimpleBeeLangTestLanguage.g:3346:7: lv_functionName_2_2= '/'
            	            {
            	            lv_functionName_2_2=(Token)match(input,32,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_2, grammarAccess.getMultiplicativeExpressionAccess().getFunctionNameSolidusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalSimpleBeeLangTestLanguage.g:3357:7: lv_functionName_2_3= '%'
            	            {
            	            lv_functionName_2_3=(Token)match(input,62,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_functionName_2_3, grammarAccess.getMultiplicativeExpressionAccess().getFunctionNamePercentSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "functionName", lv_functionName_2_3, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3370:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3371:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3371:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:3372:6: lv_rightExpr_3_0= ruleSetExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightExprSetExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_53);
            	    lv_rightExpr_3_0=ruleSetExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.SetExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, ruleMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleSetExpression"
    // InternalSimpleBeeLangTestLanguage.g:3394:1: entryRuleSetExpression returns [EObject current=null] : iv_ruleSetExpression= ruleSetExpression EOF ;
    public final EObject entryRuleSetExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleSetExpression_StartIndex = input.index();
        EObject iv_ruleSetExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3394:54: (iv_ruleSetExpression= ruleSetExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3395:2: iv_ruleSetExpression= ruleSetExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleSetExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSetExpression"


    // $ANTLR start "ruleSetExpression"
    // InternalSimpleBeeLangTestLanguage.g:3401:1: ruleSetExpression returns [EObject current=null] : (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) ;
    public final EObject ruleSetExpression() throws RecognitionException {
        EObject current = null;
        int ruleSetExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        EObject this_UnaryOrInfixExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3407:2: ( (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3408:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3408:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:3409:3: this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSetExpressionAccess().getUnaryOrInfixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_54);
            this_UnaryOrInfixExpression_0=ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryOrInfixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3420:3: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==63) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred93_InternalSimpleBeeLangTestLanguage()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3421:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3421:4: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3422:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSetExpressionAccess().getBinaryOpExpressionLeftExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3431:4: ( (lv_functionName_2_0= '..' ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3432:5: (lv_functionName_2_0= '..' )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3432:5: (lv_functionName_2_0= '..' )
            	    // InternalSimpleBeeLangTestLanguage.g:3433:6: lv_functionName_2_0= '..'
            	    {
            	    lv_functionName_2_0=(Token)match(input,63,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_functionName_2_0, grammarAccess.getSetExpressionAccess().getFunctionNameFullStopFullStopKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getSetExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "functionName", lv_functionName_2_0, "..");
            	      					
            	    }

            	    }


            	    }

            	    // InternalSimpleBeeLangTestLanguage.g:3445:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3446:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3446:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:3447:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSetExpressionAccess().getRightExprUnaryOrInfixExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_54);
            	    lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSetExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightExpr",
            	      							lv_rightExpr_3_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.UnaryOrInfixExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, ruleSetExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleSetExpression"


    // $ANTLR start "entryRuleUnaryOrInfixExpression"
    // InternalSimpleBeeLangTestLanguage.g:3469:1: entryRuleUnaryOrInfixExpression returns [EObject current=null] : iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF ;
    public final EObject entryRuleUnaryOrInfixExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleUnaryOrInfixExpression_StartIndex = input.index();
        EObject iv_ruleUnaryOrInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3469:63: (iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3470:2: iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOrInfixExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleUnaryOrInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOrInfixExpression"


    // $ANTLR start "ruleUnaryOrInfixExpression"
    // InternalSimpleBeeLangTestLanguage.g:3476:1: ruleUnaryOrInfixExpression returns [EObject current=null] : (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) ;
    public final EObject ruleUnaryOrInfixExpression() throws RecognitionException {
        EObject current = null;
        int ruleUnaryOrInfixExpression_StartIndex = input.index();
        EObject this_PostopExpression_0 = null;

        EObject this_UnaryExpression_1 = null;

        EObject this_PreopExpression_2 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3482:2: ( (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:3483:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:3483:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
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
                    // InternalSimpleBeeLangTestLanguage.g:3484:3: this_PostopExpression_0= rulePostopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOrInfixExpressionAccess().getPostopExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PostopExpression_0=rulePostopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostopExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:3496:3: this_UnaryExpression_1= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOrInfixExpressionAccess().getUnaryExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_UnaryExpression_1=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleBeeLangTestLanguage.g:3508:3: this_PreopExpression_2= rulePreopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryOrInfixExpressionAccess().getPreopExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_PreopExpression_2=rulePreopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PreopExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, ruleUnaryOrInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOrInfixExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalSimpleBeeLangTestLanguage.g:3523:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleUnaryExpression_StartIndex = input.index();
        EObject iv_ruleUnaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3523:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3524:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, entryRuleUnaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalSimpleBeeLangTestLanguage.g:3530:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;
        int ruleUnaryExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3536:2: ( ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:3537:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:3537:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // InternalSimpleBeeLangTestLanguage.g:3538:3: () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:3538:3: ()
            // InternalSimpleBeeLangTestLanguage.g:3539:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUnaryExpressionAccess().getUnaryOpExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:3548:3: ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) )
            // InternalSimpleBeeLangTestLanguage.g:3549:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:3549:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            // InternalSimpleBeeLangTestLanguage.g:3550:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            {
            // InternalSimpleBeeLangTestLanguage.g:3550:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
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
                    // InternalSimpleBeeLangTestLanguage.g:3551:6: lv_functionName_1_1= '!'
                    {
                    lv_functionName_1_1=(Token)match(input,64,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_1, grammarAccess.getUnaryExpressionAccess().getFunctionNameExclamationMarkKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:3562:6: lv_functionName_1_2= '-'
                    {
                    lv_functionName_1_2=(Token)match(input,60,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_2, grammarAccess.getUnaryExpressionAccess().getFunctionNameHyphenMinusKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getUnaryExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalSimpleBeeLangTestLanguage.g:3575:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:3576:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:3576:4: (lv_expr_2_0= ruleInfixExpression )
            // InternalSimpleBeeLangTestLanguage.g:3577:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprInfixExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InfixExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, ruleUnaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePreopExpression"
    // InternalSimpleBeeLangTestLanguage.g:3598:1: entryRulePreopExpression returns [EObject current=null] : iv_rulePreopExpression= rulePreopExpression EOF ;
    public final EObject entryRulePreopExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePreopExpression_StartIndex = input.index();
        EObject iv_rulePreopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3598:56: (iv_rulePreopExpression= rulePreopExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3599:2: iv_rulePreopExpression= rulePreopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPreopExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, entryRulePreopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePreopExpression"


    // $ANTLR start "rulePreopExpression"
    // InternalSimpleBeeLangTestLanguage.g:3605:1: rulePreopExpression returns [EObject current=null] : ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final EObject rulePreopExpression() throws RecognitionException {
        EObject current = null;
        int rulePreopExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3611:2: ( ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:3612:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:3612:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // InternalSimpleBeeLangTestLanguage.g:3613:3: () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:3613:3: ()
            // InternalSimpleBeeLangTestLanguage.g:3614:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPreopExpressionAccess().getUnaryPreOpExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:3623:3: ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) )
            // InternalSimpleBeeLangTestLanguage.g:3624:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:3624:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            // InternalSimpleBeeLangTestLanguage.g:3625:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            {
            // InternalSimpleBeeLangTestLanguage.g:3625:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
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
                    // InternalSimpleBeeLangTestLanguage.g:3626:6: lv_functionName_1_1= '++'
                    {
                    lv_functionName_1_1=(Token)match(input,65,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_1, grammarAccess.getPreopExpressionAccess().getFunctionNamePlusSignPlusSignKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPreopExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:3637:6: lv_functionName_1_2= '--'
                    {
                    lv_functionName_1_2=(Token)match(input,66,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_functionName_1_2, grammarAccess.getPreopExpressionAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPreopExpressionRule());
                      						}
                      						setWithLastConsumed(current, "functionName", lv_functionName_1_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalSimpleBeeLangTestLanguage.g:3650:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:3651:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:3651:4: (lv_expr_2_0= ruleInfixExpression )
            // InternalSimpleBeeLangTestLanguage.g:3652:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPreopExpressionAccess().getExprInfixExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPreopExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InfixExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, rulePreopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePreopExpression"


    // $ANTLR start "entryRulePostopExpression"
    // InternalSimpleBeeLangTestLanguage.g:3673:1: entryRulePostopExpression returns [EObject current=null] : iv_rulePostopExpression= rulePostopExpression EOF ;
    public final EObject entryRulePostopExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePostopExpression_StartIndex = input.index();
        EObject iv_rulePostopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3673:57: (iv_rulePostopExpression= rulePostopExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3674:2: iv_rulePostopExpression= rulePostopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostopExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, entryRulePostopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePostopExpression"


    // $ANTLR start "rulePostopExpression"
    // InternalSimpleBeeLangTestLanguage.g:3680:1: rulePostopExpression returns [EObject current=null] : (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) ;
    public final EObject rulePostopExpression() throws RecognitionException {
        EObject current = null;
        int rulePostopExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject this_InfixExpression_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3686:2: ( (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) )
            // InternalSimpleBeeLangTestLanguage.g:3687:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            {
            // InternalSimpleBeeLangTestLanguage.g:3687:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            // InternalSimpleBeeLangTestLanguage.g:3688:3: this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPostopExpressionAccess().getInfixExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_56);
            this_InfixExpression_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InfixExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3699:3: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==66) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred99_InternalSimpleBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            else if ( (LA68_0==65) ) {
                int LA68_2 = input.LA(2);

                if ( (synpred99_InternalSimpleBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:3700:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:3700:4: ()
                    // InternalSimpleBeeLangTestLanguage.g:3701:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getPostopExpressionAccess().getUnaryPostOpExpressionExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSimpleBeeLangTestLanguage.g:3710:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    // InternalSimpleBeeLangTestLanguage.g:3711:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:3711:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    // InternalSimpleBeeLangTestLanguage.g:3712:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:3712:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
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
                            // InternalSimpleBeeLangTestLanguage.g:3713:7: lv_functionName_2_1= '--'
                            {
                            lv_functionName_2_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_functionName_2_1, grammarAccess.getPostopExpressionAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPostopExpressionRule());
                              							}
                              							setWithLastConsumed(current, "functionName", lv_functionName_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalSimpleBeeLangTestLanguage.g:3724:7: lv_functionName_2_2= '++'
                            {
                            lv_functionName_2_2=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_functionName_2_2, grammarAccess.getPostopExpressionAccess().getFunctionNamePlusSignPlusSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getPostopExpressionRule());
                              							}
                              							setWithLastConsumed(current, "functionName", lv_functionName_2_2, null);
                              						
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, rulePostopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePostopExpression"


    // $ANTLR start "entryRuleInfixExpression"
    // InternalSimpleBeeLangTestLanguage.g:3742:1: entryRuleInfixExpression returns [EObject current=null] : iv_ruleInfixExpression= ruleInfixExpression EOF ;
    public final EObject entryRuleInfixExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInfixExpression_StartIndex = input.index();
        EObject iv_ruleInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3742:56: (iv_ruleInfixExpression= ruleInfixExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3743:2: iv_ruleInfixExpression= ruleInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixExpression"


    // $ANTLR start "ruleInfixExpression"
    // InternalSimpleBeeLangTestLanguage.g:3749:1: ruleInfixExpression returns [EObject current=null] : (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) ;
    public final EObject ruleInfixExpression() throws RecognitionException {
        EObject current = null;
        int ruleInfixExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;
        EObject this_CallExpression_0 = null;

        EObject lv_parameterList_5_0 = null;

        EObject lv_indexExpr_9_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3755:2: ( (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3756:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3756:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            // InternalSimpleBeeLangTestLanguage.g:3757:3: this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getInfixExpressionAccess().getCallExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_57);
            this_CallExpression_0=ruleCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CallExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3768:3: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==67) ) {
                    int LA70_2 = input.LA(2);

                    if ( (synpred101_InternalSimpleBeeLangTestLanguage()) ) {
                        alt70=1;
                    }
                    else if ( (synpred103_InternalSimpleBeeLangTestLanguage()) ) {
                        alt70=3;
                    }


                }
                else if ( (LA70_0==68) ) {
                    int LA70_3 = input.LA(2);

                    if ( (synpred102_InternalSimpleBeeLangTestLanguage()) ) {
                        alt70=2;
                    }


                }


                switch (alt70) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3769:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3769:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    // InternalSimpleBeeLangTestLanguage.g:3770:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3770:5: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3771:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getInfixExpressionAccess().getCallFeatureFuncExprAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getInfixExpressionAccess().getFullStopKeyword_1_0_1());
            	      				
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:3784:5: ( (lv_name_3_0= RULE_ID ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3785:6: (lv_name_3_0= RULE_ID )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3785:6: (lv_name_3_0= RULE_ID )
            	    // InternalSimpleBeeLangTestLanguage.g:3786:7: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_name_3_0, grammarAccess.getInfixExpressionAccess().getNameIDTerminalRuleCall_1_0_2_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getInfixExpressionRule());
            	      							}
            	      							setWithLastConsumed(
            	      								current,
            	      								"name",
            	      								lv_name_3_0,
            	      								"org.eclipse.xtext.common.Terminals.ID");
            	      						
            	    }

            	    }


            	    }

            	    otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getInfixExpressionAccess().getLeftParenthesisKeyword_1_0_3());
            	      				
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:3806:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==RULE_ID||LA69_0==RULE_STRING||LA69_0==13||(LA69_0>=17 && LA69_0<=18)||LA69_0==21||(LA69_0>=35 && LA69_0<=36)||LA69_0==52||LA69_0==56||LA69_0==60||(LA69_0>=64 && LA69_0<=66)||LA69_0==70||(LA69_0>=72 && LA69_0<=77)) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // InternalSimpleBeeLangTestLanguage.g:3807:6: (lv_parameterList_5_0= ruleParameterList )
            	            {
            	            // InternalSimpleBeeLangTestLanguage.g:3807:6: (lv_parameterList_5_0= ruleParameterList )
            	            // InternalSimpleBeeLangTestLanguage.g:3808:7: lv_parameterList_5_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getInfixExpressionAccess().getParameterListParameterListParserRuleCall_1_0_4_0());
            	              						
            	            }
            	            pushFollow(FollowSets000.FOLLOW_37);
            	            lv_parameterList_5_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getInfixExpressionRule());
            	              							}
            	              							set(
            	              								current,
            	              								"parameterList",
            	              								lv_parameterList_5_0,
            	              								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getInfixExpressionAccess().getRightParenthesisKeyword_1_0_5());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleBeeLangTestLanguage.g:3831:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3831:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    // InternalSimpleBeeLangTestLanguage.g:3832:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3832:5: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3833:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getInfixExpressionAccess().getAtExpressionObjExprAction_1_1_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_8=(Token)match(input,68,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_8, grammarAccess.getInfixExpressionAccess().getLeftSquareBracketKeyword_1_1_1());
            	      				
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:3846:5: ( (lv_indexExpr_9_0= ruleExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3847:6: (lv_indexExpr_9_0= ruleExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3847:6: (lv_indexExpr_9_0= ruleExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:3848:7: lv_indexExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getInfixExpressionAccess().getIndexExprExpressionParserRuleCall_1_1_2_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_60);
            	    lv_indexExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getInfixExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"indexExpr",
            	      								lv_indexExpr_9_0,
            	      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,69,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getInfixExpressionAccess().getRightSquareBracketKeyword_1_1_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSimpleBeeLangTestLanguage.g:3871:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3871:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3872:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3872:5: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3873:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getInfixExpressionAccess().getFeatureExpressionObjExprAction_1_2_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_12=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_12, grammarAccess.getInfixExpressionAccess().getFullStopKeyword_1_2_1());
            	      				
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:3886:5: ( (lv_featureName_13_0= RULE_ID ) )
            	    // InternalSimpleBeeLangTestLanguage.g:3887:6: (lv_featureName_13_0= RULE_ID )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3887:6: (lv_featureName_13_0= RULE_ID )
            	    // InternalSimpleBeeLangTestLanguage.g:3888:7: lv_featureName_13_0= RULE_ID
            	    {
            	    lv_featureName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_featureName_13_0, grammarAccess.getInfixExpressionAccess().getFeatureNameIDTerminalRuleCall_1_2_2_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getInfixExpressionRule());
            	      							}
            	      							setWithLastConsumed(
            	      								current,
            	      								"featureName",
            	      								lv_featureName_13_0,
            	      								"org.eclipse.xtext.common.Terminals.ID");
            	      						
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, ruleInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInfixExpression"


    // $ANTLR start "entryRuleCallExpression"
    // InternalSimpleBeeLangTestLanguage.g:3910:1: entryRuleCallExpression returns [EObject current=null] : iv_ruleCallExpression= ruleCallExpression EOF ;
    public final EObject entryRuleCallExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleCallExpression_StartIndex = input.index();
        EObject iv_ruleCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3910:55: (iv_ruleCallExpression= ruleCallExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3911:2: iv_ruleCallExpression= ruleCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, entryRuleCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCallExpression"


    // $ANTLR start "ruleCallExpression"
    // InternalSimpleBeeLangTestLanguage.g:3917:1: ruleCallExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) ;
    public final EObject ruleCallExpression() throws RecognitionException {
        EObject current = null;
        int ruleCallExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_parameterList_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3923:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) )
            // InternalSimpleBeeLangTestLanguage.g:3924:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:3924:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            // InternalSimpleBeeLangTestLanguage.g:3925:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCallExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_61);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:3936:3: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==35) ) {
                    int LA72_2 = input.LA(2);

                    if ( (synpred105_InternalSimpleBeeLangTestLanguage()) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:3937:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:3937:4: ()
            	    // InternalSimpleBeeLangTestLanguage.g:3938:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCallExpressionAccess().getCallFunctionFuncExprAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_1());
            	      			
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:3951:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==RULE_ID||LA71_0==RULE_STRING||LA71_0==13||(LA71_0>=17 && LA71_0<=18)||LA71_0==21||(LA71_0>=35 && LA71_0<=36)||LA71_0==52||LA71_0==56||LA71_0==60||(LA71_0>=64 && LA71_0<=66)||LA71_0==70||(LA71_0>=72 && LA71_0<=77)) ) {
            	        alt71=1;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // InternalSimpleBeeLangTestLanguage.g:3952:5: (lv_parameterList_3_0= ruleParameterList )
            	            {
            	            // InternalSimpleBeeLangTestLanguage.g:3952:5: (lv_parameterList_3_0= ruleParameterList )
            	            // InternalSimpleBeeLangTestLanguage.g:3953:6: lv_parameterList_3_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              						newCompositeNode(grammarAccess.getCallExpressionAccess().getParameterListParameterListParserRuleCall_1_2_0());
            	              					
            	            }
            	            pushFollow(FollowSets000.FOLLOW_37);
            	            lv_parameterList_3_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						if (current==null) {
            	              							current = createModelElementForParent(grammarAccess.getCallExpressionRule());
            	              						}
            	              						set(
            	              							current,
            	              							"parameterList",
            	              							lv_parameterList_3_0,
            	              							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
            	              						afterParserOrEnumRuleCall();
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_61); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getCallExpressionAccess().getRightParenthesisKeyword_1_3());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, ruleCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalSimpleBeeLangTestLanguage.g:3979:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePrimaryExpression_StartIndex = input.index();
        EObject iv_rulePrimaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3979:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:3980:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, entryRulePrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalSimpleBeeLangTestLanguage.g:3986:1: rulePrimaryExpression returns [EObject current=null] : (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;
        int rulePrimaryExpression_StartIndex = input.index();
        EObject this_FeatureCall_0 = null;

        EObject this_ConstructorCallExpression_1 = null;

        EObject this_Value_2 = null;

        EObject this_Literal_3 = null;

        EObject this_KeywordVariables_4 = null;

        EObject this_ParanthesizedExpression_5 = null;

        EObject this_BlockExpression_6 = null;

        EObject this_WithExpression_7 = null;

        EObject this_WithContextExpression_8 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:3992:2: ( (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:3993:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:3993:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            int alt73=9;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:3994:3: this_FeatureCall_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FeatureCall_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCall_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:4006:3: this_ConstructorCallExpression_1= ruleConstructorCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstructorCallExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ConstructorCallExpression_1=ruleConstructorCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstructorCallExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleBeeLangTestLanguage.g:4018:3: this_Value_2= ruleValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Value_2=ruleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Value_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSimpleBeeLangTestLanguage.g:4030:3: this_Literal_3= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Literal_3=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSimpleBeeLangTestLanguage.g:4042:3: this_KeywordVariables_4= ruleKeywordVariables
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getKeywordVariablesParserRuleCall_4());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_KeywordVariables_4=ruleKeywordVariables();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_KeywordVariables_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSimpleBeeLangTestLanguage.g:4054:3: this_ParanthesizedExpression_5= ruleParanthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParanthesizedExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ParanthesizedExpression_5=ruleParanthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParanthesizedExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalSimpleBeeLangTestLanguage.g:4066:3: this_BlockExpression_6= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBlockExpressionParserRuleCall_6());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BlockExpression_6=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpression_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalSimpleBeeLangTestLanguage.g:4078:3: this_WithExpression_7= ruleWithExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getWithExpressionParserRuleCall_7());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithExpression_7=ruleWithExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithExpression_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalSimpleBeeLangTestLanguage.g:4090:3: this_WithContextExpression_8= ruleWithContextExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getWithContextExpressionParserRuleCall_8());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_WithContextExpression_8=ruleWithContextExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithContextExpression_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, rulePrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleWithExpression"
    // InternalSimpleBeeLangTestLanguage.g:4105:1: entryRuleWithExpression returns [EObject current=null] : iv_ruleWithExpression= ruleWithExpression EOF ;
    public final EObject entryRuleWithExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleWithExpression_StartIndex = input.index();
        EObject iv_ruleWithExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4105:55: (iv_ruleWithExpression= ruleWithExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:4106:2: iv_ruleWithExpression= ruleWithExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWithExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleWithExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithExpression"


    // $ANTLR start "ruleWithExpression"
    // InternalSimpleBeeLangTestLanguage.g:4112:1: ruleWithExpression returns [EObject current=null] : (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) ;
    public final EObject ruleWithExpression() throws RecognitionException {
        EObject current = null;
        int ruleWithExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_referencedAdvice_1_0=null;
        Token otherlv_2=null;
        Token lv_referencedAdvice_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_funcExpr_5_0 = null;

        EObject lv_funcExpr_7_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4118:2: ( (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4119:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4119:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4120:3: otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            {
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWithExpressionAccess().getWithKeyword_0());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:4124:3: ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:4125:4: ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4125:4: ( (lv_referencedAdvice_1_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:4126:5: (lv_referencedAdvice_1_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4126:5: (lv_referencedAdvice_1_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:4127:6: lv_referencedAdvice_1_0= RULE_ID
                    {
                    lv_referencedAdvice_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_referencedAdvice_1_0, grammarAccess.getWithExpressionAccess().getReferencedAdviceIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getWithExpressionRule());
                      						}
                      						addWithLastConsumed(
                      							current,
                      							"referencedAdvice",
                      							lv_referencedAdvice_1_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:4143:4: (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==16) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalSimpleBeeLangTestLanguage.g:4144:5: otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_2, grammarAccess.getWithExpressionAccess().getCommaKeyword_1_1_0());
                    	      				
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:4148:5: ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:4149:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:4149:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    // InternalSimpleBeeLangTestLanguage.g:4150:7: lv_referencedAdvice_3_0= RULE_ID
                    	    {
                    	    lv_referencedAdvice_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_63); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(lv_referencedAdvice_3_0, grammarAccess.getWithExpressionAccess().getReferencedAdviceIDTerminalRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getWithExpressionRule());
                    	      							}
                    	      							addWithLastConsumed(
                    	      								current,
                    	      								"referencedAdvice",
                    	      								lv_referencedAdvice_3_0,
                    	      								"org.eclipse.xtext.common.Terminals.ID");
                    	      						
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

            // InternalSimpleBeeLangTestLanguage.g:4168:3: ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
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
                    // InternalSimpleBeeLangTestLanguage.g:4169:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4169:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    // InternalSimpleBeeLangTestLanguage.g:4170:5: otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getWithExpressionAccess().getColonKeyword_2_0_0());
                      				
                    }
                    // InternalSimpleBeeLangTestLanguage.g:4174:5: ( (lv_funcExpr_5_0= ruleExpression ) )
                    // InternalSimpleBeeLangTestLanguage.g:4175:6: (lv_funcExpr_5_0= ruleExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4175:6: (lv_funcExpr_5_0= ruleExpression )
                    // InternalSimpleBeeLangTestLanguage.g:4176:7: lv_funcExpr_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getWithExpressionAccess().getFuncExprExpressionParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_funcExpr_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getWithExpressionRule());
                      							}
                      							set(
                      								current,
                      								"funcExpr",
                      								lv_funcExpr_5_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:4195:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4195:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    // InternalSimpleBeeLangTestLanguage.g:4196:5: otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getWithExpressionAccess().getLeftCurlyBracketKeyword_2_1_0());
                      				
                    }
                    // InternalSimpleBeeLangTestLanguage.g:4200:5: ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) )
                    // InternalSimpleBeeLangTestLanguage.g:4201:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4201:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    // InternalSimpleBeeLangTestLanguage.g:4202:7: lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getWithExpressionAccess().getFuncExprBlockExpressionWithoutBracketsParserRuleCall_2_1_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_65);
                    lv_funcExpr_7_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getWithExpressionRule());
                      							}
                      							set(
                      								current,
                      								"funcExpr",
                      								lv_funcExpr_7_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpressionWithoutBrackets");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getWithExpressionAccess().getRightCurlyBracketKeyword_2_1_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, ruleWithExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleWithExpression"


    // $ANTLR start "entryRuleWithContextExpression"
    // InternalSimpleBeeLangTestLanguage.g:4229:1: entryRuleWithContextExpression returns [EObject current=null] : iv_ruleWithContextExpression= ruleWithContextExpression EOF ;
    public final EObject entryRuleWithContextExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleWithContextExpression_StartIndex = input.index();
        EObject iv_ruleWithContextExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4229:62: (iv_ruleWithContextExpression= ruleWithContextExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:4230:2: iv_ruleWithContextExpression= ruleWithContextExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWithContextExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleWithContextExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithContextExpression"


    // $ANTLR start "ruleWithContextExpression"
    // InternalSimpleBeeLangTestLanguage.g:4236:1: ruleWithContextExpression returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleWithContextExpression() throws RecognitionException {
        EObject current = null;
        int ruleWithContextExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;
        EObject lv_expr_2_0 = null;

        EObject lv_contextBlock_5_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4242:2: ( (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4243:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4243:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4244:3: otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            {
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWithContextExpressionAccess().getWithKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWithContextExpressionAccess().getContextKeyword_1());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:4252:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:4253:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:4253:4: (lv_expr_2_0= ruleExpression )
            // InternalSimpleBeeLangTestLanguage.g:4254:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWithContextExpressionAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_21);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWithContextExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:4271:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==28) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:4272:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getWithContextExpressionAccess().getAsKeyword_3_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:4276:4: ( (lv_alias_4_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:4277:5: (lv_alias_4_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4277:5: (lv_alias_4_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:4278:6: lv_alias_4_0= RULE_ID
                    {
                    lv_alias_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_4_0, grammarAccess.getWithContextExpressionAccess().getAliasIDTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getWithContextExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_4_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:4295:3: ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:4296:4: (lv_contextBlock_5_0= ruleBlockExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:4296:4: (lv_contextBlock_5_0= ruleBlockExpression )
            // InternalSimpleBeeLangTestLanguage.g:4297:5: lv_contextBlock_5_0= ruleBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWithContextExpressionAccess().getContextBlockBlockExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_contextBlock_5_0=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWithContextExpressionRule());
              					}
              					set(
              						current,
              						"contextBlock",
              						lv_contextBlock_5_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.BlockExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, ruleWithContextExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleWithContextExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // InternalSimpleBeeLangTestLanguage.g:4318:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleBlockExpression_StartIndex = input.index();
        EObject iv_ruleBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4318:56: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:4319:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // InternalSimpleBeeLangTestLanguage.g:4325:1: ruleBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;
        int ruleBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4331:2: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // InternalSimpleBeeLangTestLanguage.g:4332:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // InternalSimpleBeeLangTestLanguage.g:4332:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // InternalSimpleBeeLangTestLanguage.g:4333:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            // InternalSimpleBeeLangTestLanguage.g:4333:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4334:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockExpressionAccess().getChainedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:4347:3: ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==RULE_STRING||LA78_0==13||(LA78_0>=17 && LA78_0<=18)||LA78_0==21||LA78_0==33||LA78_0==35||(LA78_0>=53 && LA78_0<=54)||LA78_0==56||LA78_0==60||(LA78_0>=64 && LA78_0<=66)||LA78_0==70||(LA78_0>=72 && LA78_0<=76)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:4348:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';'
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:4348:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:4349:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:4349:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:4350:6: lv_expressions_2_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockExpressionAccess().getExpressionsTopLevelExpressionParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_expressions_2_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_2_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TopLevelExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_67); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_2_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 82, ruleBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleValue"
    // InternalSimpleBeeLangTestLanguage.g:4380:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;
        int entryRuleValue_StartIndex = input.index();
        EObject iv_ruleValue = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4380:46: (iv_ruleValue= ruleValue EOF )
            // InternalSimpleBeeLangTestLanguage.g:4381:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalSimpleBeeLangTestLanguage.g:4387:1: ruleValue returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;
        int ruleValue_StartIndex = input.index();
        Token lv_name_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4393:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4394:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4394:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4395:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4395:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4396:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValueAccess().getVariableExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:4405:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:4406:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:4406:4: (lv_name_1_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:4407:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getValueAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValueRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 84, ruleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleKeywordVariables"
    // InternalSimpleBeeLangTestLanguage.g:4427:1: entryRuleKeywordVariables returns [EObject current=null] : iv_ruleKeywordVariables= ruleKeywordVariables EOF ;
    public final EObject entryRuleKeywordVariables() throws RecognitionException {
        EObject current = null;
        int entryRuleKeywordVariables_StartIndex = input.index();
        EObject iv_ruleKeywordVariables = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4427:57: (iv_ruleKeywordVariables= ruleKeywordVariables EOF )
            // InternalSimpleBeeLangTestLanguage.g:4428:2: iv_ruleKeywordVariables= ruleKeywordVariables EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeywordVariablesRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleKeywordVariables_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordVariables"


    // $ANTLR start "ruleKeywordVariables"
    // InternalSimpleBeeLangTestLanguage.g:4434:1: ruleKeywordVariables returns [EObject current=null] : ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) ;
    public final EObject ruleKeywordVariables() throws RecognitionException {
        EObject current = null;
        int ruleKeywordVariables_StartIndex = input.index();
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4440:2: ( ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4441:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4441:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4442:3: () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4442:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4443:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeywordVariablesAccess().getVariableExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:4452:3: ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4453:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4453:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            // InternalSimpleBeeLangTestLanguage.g:4454:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            {
            // InternalSimpleBeeLangTestLanguage.g:4454:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
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
                    // InternalSimpleBeeLangTestLanguage.g:4455:6: lv_name_1_1= 'input'
                    {
                    lv_name_1_1=(Token)match(input,72,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_1, grammarAccess.getKeywordVariablesAccess().getNameInputKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:4466:6: lv_name_1_2= 'output'
                    {
                    lv_name_1_2=(Token)match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_2, grammarAccess.getKeywordVariablesAccess().getNameOutputKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalSimpleBeeLangTestLanguage.g:4477:6: lv_name_1_3= 'source'
                    {
                    lv_name_1_3=(Token)match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_3, grammarAccess.getKeywordVariablesAccess().getNameSourceKeyword_1_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalSimpleBeeLangTestLanguage.g:4488:6: lv_name_1_4= 'properties'
                    {
                    lv_name_1_4=(Token)match(input,73,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_4, grammarAccess.getKeywordVariablesAccess().getNamePropertiesKeyword_1_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_4, null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalSimpleBeeLangTestLanguage.g:4499:6: lv_name_1_5= 'builder'
                    {
                    lv_name_1_5=(Token)match(input,74,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_5, grammarAccess.getKeywordVariablesAccess().getNameBuilderKeyword_1_0_4());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_5, null);
                      					
                    }

                    }
                    break;
                case 6 :
                    // InternalSimpleBeeLangTestLanguage.g:4510:6: lv_name_1_6= 'unit'
                    {
                    lv_name_1_6=(Token)match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_6, grammarAccess.getKeywordVariablesAccess().getNameUnitKeyword_1_0_5());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_6, null);
                      					
                    }

                    }
                    break;
                case 7 :
                    // InternalSimpleBeeLangTestLanguage.g:4521:6: lv_name_1_7= 'this'
                    {
                    lv_name_1_7=(Token)match(input,75,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_1_7, grammarAccess.getKeywordVariablesAccess().getNameThisKeyword_1_0_6());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeywordVariablesRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_1_7, null);
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, ruleKeywordVariables_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleKeywordVariables"


    // $ANTLR start "entryRuleFeatureCall"
    // InternalSimpleBeeLangTestLanguage.g:4538:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;
        int entryRuleFeatureCall_StartIndex = input.index();
        EObject iv_ruleFeatureCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4538:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalSimpleBeeLangTestLanguage.g:4539:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalSimpleBeeLangTestLanguage.g:4545:1: ruleFeatureCall returns [EObject current=null] : this_OperationCall_0= ruleOperationCall ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;
        int ruleFeatureCall_StartIndex = input.index();
        EObject this_OperationCall_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4551:2: (this_OperationCall_0= ruleOperationCall )
            // InternalSimpleBeeLangTestLanguage.g:4552:2: this_OperationCall_0= ruleOperationCall
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getFeatureCallAccess().getOperationCallParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_OperationCall_0=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OperationCall_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, ruleFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleOperationCall"
    // InternalSimpleBeeLangTestLanguage.g:4566:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;
        int entryRuleOperationCall_StartIndex = input.index();
        EObject iv_ruleOperationCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4566:54: (iv_ruleOperationCall= ruleOperationCall EOF )
            // InternalSimpleBeeLangTestLanguage.g:4567:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationCallRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleOperationCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // InternalSimpleBeeLangTestLanguage.g:4573:1: ruleOperationCall returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;
        int ruleOperationCall_StartIndex = input.index();
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_parameterList_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4579:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) )
            // InternalSimpleBeeLangTestLanguage.g:4580:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            {
            // InternalSimpleBeeLangTestLanguage.g:4580:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            // InternalSimpleBeeLangTestLanguage.g:4581:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            {
            // InternalSimpleBeeLangTestLanguage.g:4581:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4582:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getOperationCallAccess().getCallNamedFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:4591:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:4592:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:4592:4: (lv_name_1_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:4593:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getOperationCallAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOperationCallRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:4613:3: ( (lv_parameterList_3_0= ruleParameterList ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||LA80_0==RULE_STRING||LA80_0==13||(LA80_0>=17 && LA80_0<=18)||LA80_0==21||(LA80_0>=35 && LA80_0<=36)||LA80_0==52||LA80_0==56||LA80_0==60||(LA80_0>=64 && LA80_0<=66)||LA80_0==70||(LA80_0>=72 && LA80_0<=77)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:4614:4: (lv_parameterList_3_0= ruleParameterList )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4614:4: (lv_parameterList_3_0= ruleParameterList )
                    // InternalSimpleBeeLangTestLanguage.g:4615:5: lv_parameterList_3_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getOperationCallAccess().getParameterListParameterListParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_37);
                    lv_parameterList_3_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getOperationCallRule());
                      					}
                      					set(
                      						current,
                      						"parameterList",
                      						lv_parameterList_3_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, ruleOperationCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleConstructorCallExpression"
    // InternalSimpleBeeLangTestLanguage.g:4640:1: entryRuleConstructorCallExpression returns [EObject current=null] : iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF ;
    public final EObject entryRuleConstructorCallExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleConstructorCallExpression_StartIndex = input.index();
        EObject iv_ruleConstructorCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4640:66: (iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:4641:2: iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorCallExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleConstructorCallExpression"


    // $ANTLR start "ruleConstructorCallExpression"
    // InternalSimpleBeeLangTestLanguage.g:4647:1: ruleConstructorCallExpression returns [EObject current=null] : ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) ;
    public final EObject ruleConstructorCallExpression() throws RecognitionException {
        EObject current = null;
        int ruleConstructorCallExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_typeExpr_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_alias_7_0=null;
        EObject lv_parameterList_4_0 = null;

        EObject lv_contextBlock_8_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4653:2: ( ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) )
            // InternalSimpleBeeLangTestLanguage.g:4654:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            {
            // InternalSimpleBeeLangTestLanguage.g:4654:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            // InternalSimpleBeeLangTestLanguage.g:4655:3: () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            {
            // InternalSimpleBeeLangTestLanguage.g:4655:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4656:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getConstructorCallExpressionAccess().getCreateExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstructorCallExpressionAccess().getNewKeyword_1());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:4669:3: ( (lv_typeExpr_2_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:4670:4: (lv_typeExpr_2_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:4670:4: (lv_typeExpr_2_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:4671:5: lv_typeExpr_2_0= RULE_ID
            {
            lv_typeExpr_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_typeExpr_2_0, grammarAccess.getConstructorCallExpressionAccess().getTypeExprIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstructorCallExpressionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"typeExpr",
              						lv_typeExpr_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:4687:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:4688:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getConstructorCallExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:4692:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID||LA81_0==RULE_STRING||LA81_0==13||(LA81_0>=17 && LA81_0<=18)||LA81_0==21||(LA81_0>=35 && LA81_0<=36)||LA81_0==52||LA81_0==56||LA81_0==60||(LA81_0>=64 && LA81_0<=66)||LA81_0==70||(LA81_0>=72 && LA81_0<=77)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalSimpleBeeLangTestLanguage.g:4693:5: (lv_parameterList_4_0= ruleParameterList )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:4693:5: (lv_parameterList_4_0= ruleParameterList )
                            // InternalSimpleBeeLangTestLanguage.g:4694:6: lv_parameterList_4_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getConstructorCallExpressionAccess().getParameterListParameterListParserRuleCall_3_1_0());
                              					
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            lv_parameterList_4_0=ruleParameterList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getConstructorCallExpressionRule());
                              						}
                              						set(
                              							current,
                              							"parameterList",
                              							lv_parameterList_4_0,
                              							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterList");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getConstructorCallExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:4716:3: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==28) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ID) ) {
                    int LA83_3 = input.LA(3);

                    if ( (synpred128_InternalSimpleBeeLangTestLanguage()) ) {
                        alt83=1;
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:4717:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getConstructorCallExpressionAccess().getAsKeyword_4_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:4721:4: ( (lv_alias_7_0= RULE_ID ) )
                    // InternalSimpleBeeLangTestLanguage.g:4722:5: (lv_alias_7_0= RULE_ID )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4722:5: (lv_alias_7_0= RULE_ID )
                    // InternalSimpleBeeLangTestLanguage.g:4723:6: lv_alias_7_0= RULE_ID
                    {
                    lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_7_0, grammarAccess.getConstructorCallExpressionAccess().getAliasIDTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getConstructorCallExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_7_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:4740:3: ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
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
                    // InternalSimpleBeeLangTestLanguage.g:4741:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:4741:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    // InternalSimpleBeeLangTestLanguage.g:4742:5: lv_contextBlock_8_0= ruleInitializationBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstructorCallExpressionAccess().getContextBlockInitializationBlockExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_contextBlock_8_0=ruleInitializationBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getConstructorCallExpressionRule());
                      					}
                      					set(
                      						current,
                      						"contextBlock",
                      						lv_contextBlock_8_0,
                      						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InitializationBlockExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, ruleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleConstructorCallExpression"


    // $ANTLR start "entryRuleInitializationBlockExpression"
    // InternalSimpleBeeLangTestLanguage.g:4763:1: entryRuleInitializationBlockExpression returns [EObject current=null] : iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF ;
    public final EObject entryRuleInitializationBlockExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInitializationBlockExpression_StartIndex = input.index();
        EObject iv_ruleInitializationBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4763:70: (iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:4764:2: iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitializationBlockExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleInitializationBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationBlockExpression"


    // $ANTLR start "ruleInitializationBlockExpression"
    // InternalSimpleBeeLangTestLanguage.g:4770:1: ruleInitializationBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) ;
    public final EObject ruleInitializationBlockExpression() throws RecognitionException {
        EObject current = null;
        int ruleInitializationBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4776:2: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) )
            // InternalSimpleBeeLangTestLanguage.g:4777:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            {
            // InternalSimpleBeeLangTestLanguage.g:4777:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            // InternalSimpleBeeLangTestLanguage.g:4778:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}'
            {
            // InternalSimpleBeeLangTestLanguage.g:4778:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4779:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInitializationBlockExpressionAccess().getChainedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInitializationBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:4792:3: ( (lv_expressions_2_0= ruleInitializationExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:4793:4: (lv_expressions_2_0= ruleInitializationExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:4793:4: (lv_expressions_2_0= ruleInitializationExpression )
            // InternalSimpleBeeLangTestLanguage.g:4794:5: lv_expressions_2_0= ruleInitializationExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitializationBlockExpressionAccess().getExpressionsInitializationExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_14);
            lv_expressions_2_0=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInitializationBlockExpressionRule());
              					}
              					add(
              						current,
              						"expressions",
              						lv_expressions_2_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.InitializationExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,20,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInitializationBlockExpressionAccess().getSemicolonKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getInitializationBlockExpressionAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 94, ruleInitializationBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInitializationBlockExpression"


    // $ANTLR start "entryRuleInitializationExpression"
    // InternalSimpleBeeLangTestLanguage.g:4823:1: entryRuleInitializationExpression returns [EObject current=null] : iv_ruleInitializationExpression= ruleInitializationExpression EOF ;
    public final EObject entryRuleInitializationExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInitializationExpression_StartIndex = input.index();
        EObject iv_ruleInitializationExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4823:65: (iv_ruleInitializationExpression= ruleInitializationExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:4824:2: iv_ruleInitializationExpression= ruleInitializationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitializationExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleInitializationExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationExpression"


    // $ANTLR start "ruleInitializationExpression"
    // InternalSimpleBeeLangTestLanguage.g:4830:1: ruleInitializationExpression returns [EObject current=null] : ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleInitializationExpression() throws RecognitionException {
        EObject current = null;
        int ruleInitializationExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        EObject lv_leftExpr_1_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4836:2: ( ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4837:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4837:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4838:3: () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4838:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4839:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInitializationExpressionAccess().getAssignmentExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:4848:3: ( (lv_leftExpr_1_0= ruleFeatureOfThis ) )
            // InternalSimpleBeeLangTestLanguage.g:4849:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            {
            // InternalSimpleBeeLangTestLanguage.g:4849:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            // InternalSimpleBeeLangTestLanguage.g:4850:5: lv_leftExpr_1_0= ruleFeatureOfThis
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitializationExpressionAccess().getLeftExprFeatureOfThisParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
            lv_leftExpr_1_0=ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInitializationExpressionRule());
              					}
              					set(
              						current,
              						"leftExpr",
              						lv_leftExpr_1_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.FeatureOfThis");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:4867:3: ( (lv_functionName_2_0= ':' ) )
            // InternalSimpleBeeLangTestLanguage.g:4868:4: (lv_functionName_2_0= ':' )
            {
            // InternalSimpleBeeLangTestLanguage.g:4868:4: (lv_functionName_2_0= ':' )
            // InternalSimpleBeeLangTestLanguage.g:4869:5: lv_functionName_2_0= ':'
            {
            lv_functionName_2_0=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_functionName_2_0, grammarAccess.getInitializationExpressionAccess().getFunctionNameColonKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInitializationExpressionRule());
              					}
              					setWithLastConsumed(current, "functionName", lv_functionName_2_0, ":");
              				
            }

            }


            }

            // InternalSimpleBeeLangTestLanguage.g:4881:3: ( (lv_rightExpr_3_0= ruleExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:4882:4: (lv_rightExpr_3_0= ruleExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:4882:4: (lv_rightExpr_3_0= ruleExpression )
            // InternalSimpleBeeLangTestLanguage.g:4883:5: lv_rightExpr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInitializationExpressionAccess().getRightExprExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_rightExpr_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInitializationExpressionRule());
              					}
              					set(
              						current,
              						"rightExpr",
              						lv_rightExpr_3_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 96, ruleInitializationExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInitializationExpression"


    // $ANTLR start "entryRuleFeatureOfThis"
    // InternalSimpleBeeLangTestLanguage.g:4904:1: entryRuleFeatureOfThis returns [EObject current=null] : iv_ruleFeatureOfThis= ruleFeatureOfThis EOF ;
    public final EObject entryRuleFeatureOfThis() throws RecognitionException {
        EObject current = null;
        int entryRuleFeatureOfThis_StartIndex = input.index();
        EObject iv_ruleFeatureOfThis = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4904:54: (iv_ruleFeatureOfThis= ruleFeatureOfThis EOF )
            // InternalSimpleBeeLangTestLanguage.g:4905:2: iv_ruleFeatureOfThis= ruleFeatureOfThis EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureOfThisRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleFeatureOfThis_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureOfThis"


    // $ANTLR start "ruleFeatureOfThis"
    // InternalSimpleBeeLangTestLanguage.g:4911:1: ruleFeatureOfThis returns [EObject current=null] : ( () ( (lv_featureName_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFeatureOfThis() throws RecognitionException {
        EObject current = null;
        int ruleFeatureOfThis_StartIndex = input.index();
        Token lv_featureName_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4917:2: ( ( () ( (lv_featureName_1_0= RULE_ID ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4918:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4918:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            // InternalSimpleBeeLangTestLanguage.g:4919:3: () ( (lv_featureName_1_0= RULE_ID ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:4919:3: ()
            // InternalSimpleBeeLangTestLanguage.g:4920:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFeatureOfThisAccess().getFeatureExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:4929:3: ( (lv_featureName_1_0= RULE_ID ) )
            // InternalSimpleBeeLangTestLanguage.g:4930:4: (lv_featureName_1_0= RULE_ID )
            {
            // InternalSimpleBeeLangTestLanguage.g:4930:4: (lv_featureName_1_0= RULE_ID )
            // InternalSimpleBeeLangTestLanguage.g:4931:5: lv_featureName_1_0= RULE_ID
            {
            lv_featureName_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_featureName_1_0, grammarAccess.getFeatureOfThisAccess().getFeatureNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFeatureOfThisRule());
              					}
              					setWithLastConsumed(
              						current,
              						"featureName",
              						lv_featureName_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 98, ruleFeatureOfThis_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFeatureOfThis"


    // $ANTLR start "entryRuleLiteral"
    // InternalSimpleBeeLangTestLanguage.g:4951:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteral_StartIndex = input.index();
        EObject iv_ruleLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4951:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalSimpleBeeLangTestLanguage.g:4952:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalSimpleBeeLangTestLanguage.g:4958:1: ruleLiteral returns [EObject current=null] : (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;
        int ruleLiteral_StartIndex = input.index();
        EObject this_ValueLiteral_0 = null;

        EObject this_LiteralFunction_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4964:2: ( (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) )
            // InternalSimpleBeeLangTestLanguage.g:4965:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            {
            // InternalSimpleBeeLangTestLanguage.g:4965:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
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
                    // InternalSimpleBeeLangTestLanguage.g:4966:3: this_ValueLiteral_0= ruleValueLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getValueLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ValueLiteral_0=ruleValueLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValueLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:4978:3: this_LiteralFunction_1= ruleLiteralFunction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getLiteralFunctionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralFunction_1=ruleLiteralFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralFunction_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, ruleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"

}

@SuppressWarnings("all")
abstract class InternalSimpleBeeLangTestLanguageParser3 extends InternalSimpleBeeLangTestLanguageParser2 {

        InternalSimpleBeeLangTestLanguageParser3(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        InternalSimpleBeeLangTestLanguageParser3(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleLiteralFunction"
    // InternalSimpleBeeLangTestLanguage.g:4993:1: entryRuleLiteralFunction returns [EObject current=null] : iv_ruleLiteralFunction= ruleLiteralFunction EOF ;
    public final EObject entryRuleLiteralFunction() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteralFunction_StartIndex = input.index();
        EObject iv_ruleLiteralFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:4993:56: (iv_ruleLiteralFunction= ruleLiteralFunction EOF )
            // InternalSimpleBeeLangTestLanguage.g:4994:2: iv_ruleLiteralFunction= ruleLiteralFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralFunctionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, entryRuleLiteralFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFunction"


    // $ANTLR start "ruleLiteralFunction"
    // InternalSimpleBeeLangTestLanguage.g:5000:1: ruleLiteralFunction returns [EObject current=null] : (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) ;
    public final EObject ruleLiteralFunction() throws RecognitionException {
        EObject current = null;
        int ruleLiteralFunction_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_ClosureExpression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5006:2: ( (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) )
            // InternalSimpleBeeLangTestLanguage.g:5007:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            {
            // InternalSimpleBeeLangTestLanguage.g:5007:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            // InternalSimpleBeeLangTestLanguage.g:5008:3: otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLiteralFunctionAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLiteralFunctionAccess().getClosureExpressionParserRuleCall_1());
              		
            }
            pushFollow(FollowSets000.FOLLOW_65);
            this_ClosureExpression_1=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ClosureExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLiteralFunctionAccess().getRightCurlyBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 102, ruleLiteralFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteralFunction"


    // $ANTLR start "entryRuleClosureExpression"
    // InternalSimpleBeeLangTestLanguage.g:5031:1: entryRuleClosureExpression returns [EObject current=null] : iv_ruleClosureExpression= ruleClosureExpression EOF ;
    public final EObject entryRuleClosureExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureExpression_StartIndex = input.index();
        EObject iv_ruleClosureExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5031:58: (iv_ruleClosureExpression= ruleClosureExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:5032:2: iv_ruleClosureExpression= ruleClosureExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosureExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, entryRuleClosureExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureExpression"


    // $ANTLR start "ruleClosureExpression"
    // InternalSimpleBeeLangTestLanguage.g:5038:1: ruleClosureExpression returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) ;
    public final EObject ruleClosureExpression() throws RecognitionException {
        EObject current = null;
        int ruleClosureExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        Token lv_varArgs_11_0=null;
        Token otherlv_13=null;
        EObject lv_returnType_2_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_parameters_12_0 = null;

        EObject lv_funcExpr_14_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5044:2: ( ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) )
            // InternalSimpleBeeLangTestLanguage.g:5045:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:5045:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            // InternalSimpleBeeLangTestLanguage.g:5046:3: () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:5046:3: ()
            // InternalSimpleBeeLangTestLanguage.g:5047:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getClosureExpressionAccess().getFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:5056:3: (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==52) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:5057:4: otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>'
                    {
                    otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getClosureExpressionAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalSimpleBeeLangTestLanguage.g:5061:4: ( (lv_returnType_2_0= ruleTypeRef ) )
                    // InternalSimpleBeeLangTestLanguage.g:5062:5: (lv_returnType_2_0= ruleTypeRef )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5062:5: (lv_returnType_2_0= ruleTypeRef )
                    // InternalSimpleBeeLangTestLanguage.g:5063:6: lv_returnType_2_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getClosureExpressionAccess().getReturnTypeTypeRefParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_71);
                    lv_returnType_2_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                      						}
                      						set(
                      							current,
                      							"returnType",
                      							lv_returnType_2_0,
                      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TypeRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getClosureExpressionAccess().getGreaterThanSignKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalSimpleBeeLangTestLanguage.g:5085:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?
            int alt90=3;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:5086:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5086:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    // InternalSimpleBeeLangTestLanguage.g:5087:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5087:5: (otherlv_4= '|' )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==77) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalSimpleBeeLangTestLanguage.g:5088:6: otherlv_4= '|'
                            {
                            otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getClosureExpressionAccess().getVerticalLineKeyword_2_0_0());
                              					
                            }

                            }
                            break;

                    }

                    // InternalSimpleBeeLangTestLanguage.g:5093:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    // InternalSimpleBeeLangTestLanguage.g:5094:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5094:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    // InternalSimpleBeeLangTestLanguage.g:5095:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5095:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    // InternalSimpleBeeLangTestLanguage.g:5096:8: lv_parameters_5_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_0_0());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_73);
                    lv_parameters_5_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                      								}
                      								add(
                      									current,
                      									"parameters",
                      									lv_parameters_5_0,
                      									"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:5113:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
                    	    // InternalSimpleBeeLangTestLanguage.g:5114:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    {
                    	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_6, grammarAccess.getClosureExpressionAccess().getCommaKeyword_2_0_1_1_0());
                    	      						
                    	    }
                    	    // InternalSimpleBeeLangTestLanguage.g:5118:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    // InternalSimpleBeeLangTestLanguage.g:5119:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    {
                    	    // InternalSimpleBeeLangTestLanguage.g:5119:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    // InternalSimpleBeeLangTestLanguage.g:5120:9: lv_parameters_7_0= ruleParameterDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0());
                    	      								
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_73);
                    	    lv_parameters_7_0=ruleParameterDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									if (current==null) {
                    	      										current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                    	      									}
                    	      									add(
                    	      										current,
                    	      										"parameters",
                    	      										lv_parameters_7_0,
                    	      										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                    	      									afterParserOrEnumRuleCall();
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
                        }
                    } while (true);

                    // InternalSimpleBeeLangTestLanguage.g:5138:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==16) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalSimpleBeeLangTestLanguage.g:5139:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            {
                            otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_8, grammarAccess.getClosureExpressionAccess().getCommaKeyword_2_0_1_2_0());
                              						
                            }
                            // InternalSimpleBeeLangTestLanguage.g:5143:7: ( (lv_varArgs_9_0= '...' ) )
                            // InternalSimpleBeeLangTestLanguage.g:5144:8: (lv_varArgs_9_0= '...' )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:5144:8: (lv_varArgs_9_0= '...' )
                            // InternalSimpleBeeLangTestLanguage.g:5145:9: lv_varArgs_9_0= '...'
                            {
                            lv_varArgs_9_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(lv_varArgs_9_0, grammarAccess.getClosureExpressionAccess().getVarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0());
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getClosureExpressionRule());
                              									}
                              									setWithLastConsumed(current, "varArgs", true, "...");
                              								
                            }

                            }


                            }

                            // InternalSimpleBeeLangTestLanguage.g:5157:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            // InternalSimpleBeeLangTestLanguage.g:5158:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            {
                            // InternalSimpleBeeLangTestLanguage.g:5158:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            // InternalSimpleBeeLangTestLanguage.g:5159:9: lv_parameters_10_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0());
                              								
                            }
                            pushFollow(FollowSets000.FOLLOW_74);
                            lv_parameters_10_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                              									}
                              									add(
                              										current,
                              										"parameters",
                              										lv_parameters_10_0,
                              										"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                              									afterParserOrEnumRuleCall();
                              								
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
                    // InternalSimpleBeeLangTestLanguage.g:5180:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5180:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    // InternalSimpleBeeLangTestLanguage.g:5181:5: ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5181:5: ( (lv_varArgs_11_0= '...' ) )
                    // InternalSimpleBeeLangTestLanguage.g:5182:6: (lv_varArgs_11_0= '...' )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5182:6: (lv_varArgs_11_0= '...' )
                    // InternalSimpleBeeLangTestLanguage.g:5183:7: lv_varArgs_11_0= '...'
                    {
                    lv_varArgs_11_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_varArgs_11_0, grammarAccess.getClosureExpressionAccess().getVarArgsFullStopFullStopFullStopKeyword_2_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureExpressionRule());
                      							}
                      							setWithLastConsumed(current, "varArgs", true, "...");
                      						
                    }

                    }


                    }

                    // InternalSimpleBeeLangTestLanguage.g:5195:5: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    // InternalSimpleBeeLangTestLanguage.g:5196:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    {
                    // InternalSimpleBeeLangTestLanguage.g:5196:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    // InternalSimpleBeeLangTestLanguage.g:5197:7: lv_parameters_12_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_1_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_74);
                    lv_parameters_12_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
                      							}
                      							add(
                      								current,
                      								"parameters",
                      								lv_parameters_12_0,
                      								"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.ParameterDeclaration");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,77,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getClosureExpressionAccess().getVerticalLineKeyword_3());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:5220:3: ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            // InternalSimpleBeeLangTestLanguage.g:5221:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            {
            // InternalSimpleBeeLangTestLanguage.g:5221:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            // InternalSimpleBeeLangTestLanguage.g:5222:5: lv_funcExpr_14_0= ruleOneOrManyExpressions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClosureExpressionAccess().getFuncExprOneOrManyExpressionsParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_funcExpr_14_0=ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getClosureExpressionRule());
              					}
              					set(
              						current,
              						"funcExpr",
              						lv_funcExpr_14_0,
              						"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.OneOrManyExpressions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 104, ruleClosureExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureExpression"


    // $ANTLR start "entryRuleOneOrManyExpressions"
    // InternalSimpleBeeLangTestLanguage.g:5243:1: entryRuleOneOrManyExpressions returns [EObject current=null] : iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF ;
    public final EObject entryRuleOneOrManyExpressions() throws RecognitionException {
        EObject current = null;
        int entryRuleOneOrManyExpressions_StartIndex = input.index();
        EObject iv_ruleOneOrManyExpressions = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5243:61: (iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF )
            // InternalSimpleBeeLangTestLanguage.g:5244:2: iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOneOrManyExpressionsRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, entryRuleOneOrManyExpressions_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOneOrManyExpressions"


    // $ANTLR start "ruleOneOrManyExpressions"
    // InternalSimpleBeeLangTestLanguage.g:5250:1: ruleOneOrManyExpressions returns [EObject current=null] : (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) ;
    public final EObject ruleOneOrManyExpressions() throws RecognitionException {
        EObject current = null;
        int ruleOneOrManyExpressions_StartIndex = input.index();
        EObject this_BlockExpressionWithoutBrackets_0 = null;

        EObject this_Expression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5256:2: ( (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) )
            // InternalSimpleBeeLangTestLanguage.g:5257:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            {
            // InternalSimpleBeeLangTestLanguage.g:5257:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalSimpleBeeLangTestLanguage.g:5258:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOneOrManyExpressionsAccess().getBlockExpressionWithoutBracketsParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BlockExpressionWithoutBrackets_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpressionWithoutBrackets_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSimpleBeeLangTestLanguage.g:5270:3: this_Expression_1= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOneOrManyExpressionsAccess().getExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Expression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 106, ruleOneOrManyExpressions_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOneOrManyExpressions"


    // $ANTLR start "entryRuleBlockExpressionWithoutBrackets"
    // InternalSimpleBeeLangTestLanguage.g:5285:1: entryRuleBlockExpressionWithoutBrackets returns [EObject current=null] : iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF ;
    public final EObject entryRuleBlockExpressionWithoutBrackets() throws RecognitionException {
        EObject current = null;
        int entryRuleBlockExpressionWithoutBrackets_StartIndex = input.index();
        EObject iv_ruleBlockExpressionWithoutBrackets = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5285:71: (iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF )
            // InternalSimpleBeeLangTestLanguage.g:5286:2: iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionWithoutBracketsRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, entryRuleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpressionWithoutBrackets"


    // $ANTLR start "ruleBlockExpressionWithoutBrackets"
    // InternalSimpleBeeLangTestLanguage.g:5292:1: ruleBlockExpressionWithoutBrackets returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) ;
    public final EObject ruleBlockExpressionWithoutBrackets() throws RecognitionException {
        EObject current = null;
        int ruleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5298:2: ( ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) )
            // InternalSimpleBeeLangTestLanguage.g:5299:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            {
            // InternalSimpleBeeLangTestLanguage.g:5299:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            // InternalSimpleBeeLangTestLanguage.g:5300:3: () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            {
            // InternalSimpleBeeLangTestLanguage.g:5300:3: ()
            // InternalSimpleBeeLangTestLanguage.g:5301:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockExpressionWithoutBracketsAccess().getChainedExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSimpleBeeLangTestLanguage.g:5310:3: ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
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
            	    // InternalSimpleBeeLangTestLanguage.g:5311:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';'
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:5311:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) )
            	    // InternalSimpleBeeLangTestLanguage.g:5312:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    {
            	    // InternalSimpleBeeLangTestLanguage.g:5312:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    // InternalSimpleBeeLangTestLanguage.g:5313:6: lv_expressions_1_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockExpressionWithoutBracketsAccess().getExpressionsTopLevelExpressionParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    lv_expressions_1_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockExpressionWithoutBracketsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_1_0,
            	      							"org.eclipse.xtext.testlanguages.backtracking.BeeLangTestLanguage.TopLevelExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_75); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getBlockExpressionWithoutBracketsAccess().getSemicolonKeyword_1_1());
            	      			
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 108, ruleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpressionWithoutBrackets"


    // $ANTLR start "entryRuleValueLiteral"
    // InternalSimpleBeeLangTestLanguage.g:5339:1: entryRuleValueLiteral returns [EObject current=null] : iv_ruleValueLiteral= ruleValueLiteral EOF ;
    public final EObject entryRuleValueLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleValueLiteral_StartIndex = input.index();
        EObject iv_ruleValueLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5339:53: (iv_ruleValueLiteral= ruleValueLiteral EOF )
            // InternalSimpleBeeLangTestLanguage.g:5340:2: iv_ruleValueLiteral= ruleValueLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueLiteralRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, entryRuleValueLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValueLiteral"


    // $ANTLR start "ruleValueLiteral"
    // InternalSimpleBeeLangTestLanguage.g:5346:1: ruleValueLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleValueLiteral() throws RecognitionException {
        EObject current = null;
        int ruleValueLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5352:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalSimpleBeeLangTestLanguage.g:5353:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalSimpleBeeLangTestLanguage.g:5353:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalSimpleBeeLangTestLanguage.g:5354:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalSimpleBeeLangTestLanguage.g:5354:3: (lv_value_0_0= RULE_STRING )
            // InternalSimpleBeeLangTestLanguage.g:5355:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getValueLiteralAccess().getValueSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getValueLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.xtext.common.Terminals.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 110, ruleValueLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValueLiteral"


    // $ANTLR start "entryRuleParanthesizedExpression"
    // InternalSimpleBeeLangTestLanguage.g:5374:1: entryRuleParanthesizedExpression returns [EObject current=null] : iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF ;
    public final EObject entryRuleParanthesizedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleParanthesizedExpression_StartIndex = input.index();
        EObject iv_ruleParanthesizedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5374:64: (iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF )
            // InternalSimpleBeeLangTestLanguage.g:5375:2: iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParanthesizedExpressionRule()); 
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
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, entryRuleParanthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParanthesizedExpression"


    // $ANTLR start "ruleParanthesizedExpression"
    // InternalSimpleBeeLangTestLanguage.g:5381:1: ruleParanthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParanthesizedExpression() throws RecognitionException {
        EObject current = null;
        int ruleParanthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5387:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // InternalSimpleBeeLangTestLanguage.g:5388:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // InternalSimpleBeeLangTestLanguage.g:5388:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // InternalSimpleBeeLangTestLanguage.g:5389:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParanthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getParanthesizedExpressionAccess().getExpressionParserRuleCall_1());
              		
            }
            pushFollow(FollowSets000.FOLLOW_37);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParanthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 112, ruleParanthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParanthesizedExpression"


    // $ANTLR start "entryRuleQID"
    // InternalSimpleBeeLangTestLanguage.g:5412:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;
        int entryRuleQID_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleQID = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 113) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5414:2: (iv_ruleQID= ruleQID EOF )
            // InternalSimpleBeeLangTestLanguage.g:5415:2: iv_ruleQID= ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQID=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 113, entryRuleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // InternalSimpleBeeLangTestLanguage.g:5424:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
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


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 114) ) { return current; }
            // InternalSimpleBeeLangTestLanguage.g:5431:2: ( (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) )
            // InternalSimpleBeeLangTestLanguage.g:5432:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            {
            // InternalSimpleBeeLangTestLanguage.g:5432:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            // InternalSimpleBeeLangTestLanguage.g:5433:3: this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalSimpleBeeLangTestLanguage.g:5440:3: (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )*
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
            	    // InternalSimpleBeeLangTestLanguage.g:5441:4: this_INT_1= RULE_INT
            	    {
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_INT_1);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_INT_1, grammarAccess.getQIDAccess().getINTTerminalRuleCall_1_0());
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleBeeLangTestLanguage.g:5449:4: this_HEX_2= RULE_HEX
            	    {
            	    this_HEX_2=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_HEX_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_HEX_2, grammarAccess.getQIDAccess().getHEXTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalSimpleBeeLangTestLanguage.g:5457:4: this_ID_3= RULE_ID
            	    {
            	    this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_3);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_3, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            // InternalSimpleBeeLangTestLanguage.g:5465:3: (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==67) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalSimpleBeeLangTestLanguage.g:5466:4: kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    {
            	    kw=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_2_0());
            	      			
            	    }
            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_5);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_5, grammarAccess.getQIDAccess().getIDTerminalRuleCall_2_1());
            	      			
            	    }
            	    // InternalSimpleBeeLangTestLanguage.g:5478:4: (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
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
            	    	    // InternalSimpleBeeLangTestLanguage.g:5479:5: this_INT_6= RULE_INT
            	    	    {
            	    	    this_INT_6=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					current.merge(this_INT_6);
            	    	      				
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(this_INT_6, grammarAccess.getQIDAccess().getINTTerminalRuleCall_2_2_0());
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // InternalSimpleBeeLangTestLanguage.g:5487:5: this_HEX_7= RULE_HEX
            	    	    {
            	    	    this_HEX_7=(Token)match(input,RULE_HEX,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					current.merge(this_HEX_7);
            	    	      				
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(this_HEX_7, grammarAccess.getQIDAccess().getHEXTerminalRuleCall_2_2_1());
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // InternalSimpleBeeLangTestLanguage.g:5495:5: this_ID_8= RULE_ID
            	    	    {
            	    	    this_ID_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					current.merge(this_ID_8);
            	    	      				
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(this_ID_8, grammarAccess.getQIDAccess().getIDTerminalRuleCall_2_2_2());
            	    	      				
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

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 114, ruleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleQID"

    // $ANTLR start synpred2_InternalSimpleBeeLangTestLanguage
    public final void synpred2_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject lv_units_0_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:115:3: ( ( (lv_units_0_0= ruleUnit ) )* )
        // InternalSimpleBeeLangTestLanguage.g:115:3: ( (lv_units_0_0= ruleUnit ) )*
        {
        // InternalSimpleBeeLangTestLanguage.g:115:3: ( (lv_units_0_0= ruleUnit ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_DOCUMENTATION||LA96_0==13) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // InternalSimpleBeeLangTestLanguage.g:116:4: (lv_units_0_0= ruleUnit )
        	    {
        	    // InternalSimpleBeeLangTestLanguage.g:116:4: (lv_units_0_0= ruleUnit )
        	    // InternalSimpleBeeLangTestLanguage.g:117:5: lv_units_0_0= ruleUnit
        	    {
        	    if ( state.backtracking==0 ) {

        	      					newCompositeNode(grammarAccess.getModelAccess().getUnitsUnitParserRuleCall_0_0());
        	      				
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
    // $ANTLR end synpred2_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred9_InternalSimpleBeeLangTestLanguage
    public final void synpred9_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_sourceLocation_14_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:318:4: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:318:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:318:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:319:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
        }
        // InternalSimpleBeeLangTestLanguage.g:319:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:320:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
        // InternalSimpleBeeLangTestLanguage.g:323:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:323:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:323:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        // InternalSimpleBeeLangTestLanguage.g:323:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
        {
        otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:331:9: ( (lv_sourceLocation_14_0= rulePath ) )
        // InternalSimpleBeeLangTestLanguage.g:332:10: (lv_sourceLocation_14_0= rulePath )
        {
        // InternalSimpleBeeLangTestLanguage.g:332:10: (lv_sourceLocation_14_0= rulePath )
        // InternalSimpleBeeLangTestLanguage.g:333:11: lv_sourceLocation_14_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getSourceLocationPathParserRuleCall_7_0_2_0());
          										
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
    // $ANTLR end synpred9_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred10_InternalSimpleBeeLangTestLanguage
    public final void synpred10_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_outputLocation_18_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:360:4: ( ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:360:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:360:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:361:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
        }
        // InternalSimpleBeeLangTestLanguage.g:361:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:362:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
        // InternalSimpleBeeLangTestLanguage.g:365:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:365:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:365:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        // InternalSimpleBeeLangTestLanguage.g:365:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
        {
        otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:373:9: ( (lv_outputLocation_18_0= rulePath ) )
        // InternalSimpleBeeLangTestLanguage.g:374:10: (lv_outputLocation_18_0= rulePath )
        {
        // InternalSimpleBeeLangTestLanguage.g:374:10: (lv_outputLocation_18_0= rulePath )
        // InternalSimpleBeeLangTestLanguage.g:375:11: lv_outputLocation_18_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getOutputLocationPathParserRuleCall_7_1_2_0());
          										
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
    // $ANTLR end synpred10_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred11_InternalSimpleBeeLangTestLanguage
    public final void synpred11_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_providedCapabilities_22_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:407:10: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:407:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:407:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        // InternalSimpleBeeLangTestLanguage.g:407:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        {
        otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:415:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        // InternalSimpleBeeLangTestLanguage.g:416:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        {
        // InternalSimpleBeeLangTestLanguage.g:416:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        // InternalSimpleBeeLangTestLanguage.g:417:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0());
          										
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
    // $ANTLR end synpred11_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred12_InternalSimpleBeeLangTestLanguage
    public final void synpred12_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_providedCapabilities_22_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:402:4: ( ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) )
        // InternalSimpleBeeLangTestLanguage.g:402:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:402:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        // InternalSimpleBeeLangTestLanguage.g:403:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
        }
        // InternalSimpleBeeLangTestLanguage.g:403:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        // InternalSimpleBeeLangTestLanguage.g:404:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
        // InternalSimpleBeeLangTestLanguage.g:407:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
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
        	    // InternalSimpleBeeLangTestLanguage.g:407:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred12_InternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // InternalSimpleBeeLangTestLanguage.g:407:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    // InternalSimpleBeeLangTestLanguage.g:407:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        	    {
        	    otherlv_20=(Token)match(input,22,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // InternalSimpleBeeLangTestLanguage.g:415:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        	    // InternalSimpleBeeLangTestLanguage.g:416:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    {
        	    // InternalSimpleBeeLangTestLanguage.g:416:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    // InternalSimpleBeeLangTestLanguage.g:417:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											newCompositeNode(grammarAccess.getUnitAccess().getProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0());
        	      										
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
    // $ANTLR end synpred12_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred13_InternalSimpleBeeLangTestLanguage
    public final void synpred13_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_requiredCapabilities_26_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:449:10: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:449:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:449:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        // InternalSimpleBeeLangTestLanguage.g:449:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        {
        otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:457:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        // InternalSimpleBeeLangTestLanguage.g:458:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        {
        // InternalSimpleBeeLangTestLanguage.g:458:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        // InternalSimpleBeeLangTestLanguage.g:459:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getRequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0());
          										
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
    // $ANTLR end synpred13_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred14_InternalSimpleBeeLangTestLanguage
    public final void synpred14_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_requiredCapabilities_26_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:444:4: ( ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) )
        // InternalSimpleBeeLangTestLanguage.g:444:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:444:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        // InternalSimpleBeeLangTestLanguage.g:445:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred14_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
        }
        // InternalSimpleBeeLangTestLanguage.g:445:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        // InternalSimpleBeeLangTestLanguage.g:446:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
        // InternalSimpleBeeLangTestLanguage.g:449:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
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
        	    // InternalSimpleBeeLangTestLanguage.g:449:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred14_InternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // InternalSimpleBeeLangTestLanguage.g:449:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    // InternalSimpleBeeLangTestLanguage.g:449:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        	    {
        	    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_25=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // InternalSimpleBeeLangTestLanguage.g:457:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        	    // InternalSimpleBeeLangTestLanguage.g:458:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    {
        	    // InternalSimpleBeeLangTestLanguage.g:458:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    // InternalSimpleBeeLangTestLanguage.g:459:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											newCompositeNode(grammarAccess.getUnitAccess().getRequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0());
        	      										
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
    // $ANTLR end synpred14_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred15_InternalSimpleBeeLangTestLanguage
    public final void synpred15_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_metaRequiredCapabilities_31_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:491:10: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:491:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:491:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        // InternalSimpleBeeLangTestLanguage.g:491:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        {
        otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:503:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        // InternalSimpleBeeLangTestLanguage.g:504:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        {
        // InternalSimpleBeeLangTestLanguage.g:504:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        // InternalSimpleBeeLangTestLanguage.g:505:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											newCompositeNode(grammarAccess.getUnitAccess().getMetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0());
          										
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
    // $ANTLR end synpred15_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred16_InternalSimpleBeeLangTestLanguage
    public final void synpred16_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_metaRequiredCapabilities_31_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:486:4: ( ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) )
        // InternalSimpleBeeLangTestLanguage.g:486:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:486:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        // InternalSimpleBeeLangTestLanguage.g:487:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
        }
        // InternalSimpleBeeLangTestLanguage.g:487:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        // InternalSimpleBeeLangTestLanguage.g:488:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
        // InternalSimpleBeeLangTestLanguage.g:491:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
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
        	    // InternalSimpleBeeLangTestLanguage.g:491:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred16_InternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // InternalSimpleBeeLangTestLanguage.g:491:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    // InternalSimpleBeeLangTestLanguage.g:491:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        	    {
        	    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_16); if (state.failed) return ;
        	    otherlv_29=(Token)match(input,24,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // InternalSimpleBeeLangTestLanguage.g:503:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        	    // InternalSimpleBeeLangTestLanguage.g:504:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    {
        	    // InternalSimpleBeeLangTestLanguage.g:504:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    // InternalSimpleBeeLangTestLanguage.g:505:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											newCompositeNode(grammarAccess.getUnitAccess().getMetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0());
        	      										
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
    // $ANTLR end synpred16_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred17_InternalSimpleBeeLangTestLanguage
    public final void synpred17_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject lv_functions_33_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:537:10: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )
        // InternalSimpleBeeLangTestLanguage.g:537:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:537:19: ( (lv_functions_33_0= ruleFunction ) )
        // InternalSimpleBeeLangTestLanguage.g:537:20: (lv_functions_33_0= ruleFunction )
        {
        // InternalSimpleBeeLangTestLanguage.g:537:20: (lv_functions_33_0= ruleFunction )
        // InternalSimpleBeeLangTestLanguage.g:538:10: lv_functions_33_0= ruleFunction
        {
        if ( state.backtracking==0 ) {

          										newCompositeNode(grammarAccess.getUnitAccess().getFunctionsFunctionParserRuleCall_7_5_0());
          									
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_functions_33_0=ruleFunction();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred18_InternalSimpleBeeLangTestLanguage
    public final void synpred18_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject lv_functions_33_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:532:4: ( ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )
        // InternalSimpleBeeLangTestLanguage.g:532:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:532:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        // InternalSimpleBeeLangTestLanguage.g:533:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred18_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
        }
        // InternalSimpleBeeLangTestLanguage.g:533:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        // InternalSimpleBeeLangTestLanguage.g:534:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
        // InternalSimpleBeeLangTestLanguage.g:537:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
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
        	    // InternalSimpleBeeLangTestLanguage.g:537:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred18_InternalSimpleBeeLangTestLanguage", "true");
        	    }
        	    // InternalSimpleBeeLangTestLanguage.g:537:19: ( (lv_functions_33_0= ruleFunction ) )
        	    // InternalSimpleBeeLangTestLanguage.g:537:20: (lv_functions_33_0= ruleFunction )
        	    {
        	    // InternalSimpleBeeLangTestLanguage.g:537:20: (lv_functions_33_0= ruleFunction )
        	    // InternalSimpleBeeLangTestLanguage.g:538:10: lv_functions_33_0= ruleFunction
        	    {
        	    if ( state.backtracking==0 ) {

        	      										newCompositeNode(grammarAccess.getUnitAccess().getFunctionsFunctionParserRuleCall_7_5_0());
        	      									
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
    // $ANTLR end synpred18_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred20_InternalSimpleBeeLangTestLanguage
    public final void synpred20_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_condExpr_7_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:650:5: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:650:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:650:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:651:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
        }
        // InternalSimpleBeeLangTestLanguage.g:651:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:652:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
        // InternalSimpleBeeLangTestLanguage.g:655:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:655:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:655:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        // InternalSimpleBeeLangTestLanguage.g:655:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
        {
        otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:663:10: ( (lv_condExpr_7_0= ruleExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:664:11: (lv_condExpr_7_0= ruleExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:664:11: (lv_condExpr_7_0= ruleExpression )
        // InternalSimpleBeeLangTestLanguage.g:665:12: lv_condExpr_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												newCompositeNode(grammarAccess.getProvidedCapabilityAccess().getCondExprExpressionParserRuleCall_2_1_0_2_0());
          											
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
    // $ANTLR end synpred20_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred21_InternalSimpleBeeLangTestLanguage
    public final void synpred21_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;

        // InternalSimpleBeeLangTestLanguage.g:692:5: ( ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:692:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:692:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:693:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
        }
        // InternalSimpleBeeLangTestLanguage.g:693:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:694:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
        // InternalSimpleBeeLangTestLanguage.g:697:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:697:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:697:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        // InternalSimpleBeeLangTestLanguage.g:697:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
        {
        otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:705:10: ( (lv_name_11_0= RULE_ID ) )
        // InternalSimpleBeeLangTestLanguage.g:706:11: (lv_name_11_0= RULE_ID )
        {
        // InternalSimpleBeeLangTestLanguage.g:706:11: (lv_name_11_0= RULE_ID )
        // InternalSimpleBeeLangTestLanguage.g:707:12: lv_name_11_0= RULE_ID
        {
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
    // $ANTLR end synpred21_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred22_InternalSimpleBeeLangTestLanguage
    public final void synpred22_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;

        // InternalSimpleBeeLangTestLanguage.g:733:5: ( ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:733:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:733:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:734:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
        }
        // InternalSimpleBeeLangTestLanguage.g:734:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:735:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
        // InternalSimpleBeeLangTestLanguage.g:738:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:738:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:738:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        // InternalSimpleBeeLangTestLanguage.g:738:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
        {
        otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:746:10: ( (lv_version_15_0= RULE_ID ) )
        // InternalSimpleBeeLangTestLanguage.g:747:11: (lv_version_15_0= RULE_ID )
        {
        // InternalSimpleBeeLangTestLanguage.g:747:11: (lv_version_15_0= RULE_ID )
        // InternalSimpleBeeLangTestLanguage.g:748:12: lv_version_15_0= RULE_ID
        {
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
    // $ANTLR end synpred22_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred26_InternalSimpleBeeLangTestLanguage
    public final void synpred26_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_condExpr_9_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:898:5: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:898:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:898:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:899:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // InternalSimpleBeeLangTestLanguage.g:899:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:900:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // InternalSimpleBeeLangTestLanguage.g:903:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:903:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:903:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        // InternalSimpleBeeLangTestLanguage.g:903:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
        {
        otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:911:10: ( (lv_condExpr_9_0= ruleExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:912:11: (lv_condExpr_9_0= ruleExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:912:11: (lv_condExpr_9_0= ruleExpression )
        // InternalSimpleBeeLangTestLanguage.g:913:12: lv_condExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												newCompositeNode(grammarAccess.getAliasedRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
          											
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
    // $ANTLR end synpred26_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred27_InternalSimpleBeeLangTestLanguage
    public final void synpred27_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;

        // InternalSimpleBeeLangTestLanguage.g:940:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:940:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:940:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:941:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // InternalSimpleBeeLangTestLanguage.g:941:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:942:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // InternalSimpleBeeLangTestLanguage.g:945:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:945:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:945:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        // InternalSimpleBeeLangTestLanguage.g:945:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
        {
        // InternalSimpleBeeLangTestLanguage.g:945:21: ( (lv_greedy_11_0= 'greedy' ) )
        // InternalSimpleBeeLangTestLanguage.g:946:11: (lv_greedy_11_0= 'greedy' )
        {
        // InternalSimpleBeeLangTestLanguage.g:946:11: (lv_greedy_11_0= 'greedy' )
        // InternalSimpleBeeLangTestLanguage.g:947:12: lv_greedy_11_0= 'greedy'
        {
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
    // $ANTLR end synpred27_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred28_InternalSimpleBeeLangTestLanguage
    public final void synpred28_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;

        // InternalSimpleBeeLangTestLanguage.g:969:5: ( ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:969:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:970:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // InternalSimpleBeeLangTestLanguage.g:970:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:971:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // InternalSimpleBeeLangTestLanguage.g:974:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:974:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:974:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        // InternalSimpleBeeLangTestLanguage.g:974:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:982:10: ( (lv_min_15_0= RULE_INT ) )
        // InternalSimpleBeeLangTestLanguage.g:983:11: (lv_min_15_0= RULE_INT )
        {
        // InternalSimpleBeeLangTestLanguage.g:983:11: (lv_min_15_0= RULE_INT )
        // InternalSimpleBeeLangTestLanguage.g:984:12: lv_min_15_0= RULE_INT
        {
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
    // $ANTLR end synpred28_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred29_InternalSimpleBeeLangTestLanguage
    public final void synpred29_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;

        // InternalSimpleBeeLangTestLanguage.g:1010:5: ( ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1010:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:1010:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1011:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // InternalSimpleBeeLangTestLanguage.g:1011:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1012:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // InternalSimpleBeeLangTestLanguage.g:1015:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:1015:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:1015:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        // InternalSimpleBeeLangTestLanguage.g:1015:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
        {
        otherlv_17=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:1023:10: ( (lv_max_19_0= RULE_INT ) )
        // InternalSimpleBeeLangTestLanguage.g:1024:11: (lv_max_19_0= RULE_INT )
        {
        // InternalSimpleBeeLangTestLanguage.g:1024:11: (lv_max_19_0= RULE_INT )
        // InternalSimpleBeeLangTestLanguage.g:1025:12: lv_max_19_0= RULE_INT
        {
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
    // $ANTLR end synpred29_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred30_InternalSimpleBeeLangTestLanguage
    public final void synpred30_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;

        // InternalSimpleBeeLangTestLanguage.g:1051:5: ( ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1051:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:1051:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1052:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // InternalSimpleBeeLangTestLanguage.g:1052:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1053:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // InternalSimpleBeeLangTestLanguage.g:1056:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:1056:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:1056:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        // InternalSimpleBeeLangTestLanguage.g:1056:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
        {
        otherlv_21=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:1064:10: ( (lv_versionRange_23_0= RULE_ID ) )
        // InternalSimpleBeeLangTestLanguage.g:1065:11: (lv_versionRange_23_0= RULE_ID )
        {
        // InternalSimpleBeeLangTestLanguage.g:1065:11: (lv_versionRange_23_0= RULE_ID )
        // InternalSimpleBeeLangTestLanguage.g:1066:12: lv_versionRange_23_0= RULE_ID
        {
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
    // $ANTLR end synpred30_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred32_InternalSimpleBeeLangTestLanguage
    public final void synpred32_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_condExpr_8_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:1201:5: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1201:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:1201:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1202:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // InternalSimpleBeeLangTestLanguage.g:1202:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1203:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // InternalSimpleBeeLangTestLanguage.g:1206:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:1206:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:1206:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        // InternalSimpleBeeLangTestLanguage.g:1206:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:1214:10: ( (lv_condExpr_8_0= ruleExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:1215:11: (lv_condExpr_8_0= ruleExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:1215:11: (lv_condExpr_8_0= ruleExpression )
        // InternalSimpleBeeLangTestLanguage.g:1216:12: lv_condExpr_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												newCompositeNode(grammarAccess.getRequiredCapabilityAccess().getCondExprExpressionParserRuleCall_3_1_0_2_0());
          											
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
    // $ANTLR end synpred32_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred33_InternalSimpleBeeLangTestLanguage
    public final void synpred33_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;

        // InternalSimpleBeeLangTestLanguage.g:1243:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1243:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:1243:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1244:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // InternalSimpleBeeLangTestLanguage.g:1244:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1245:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // InternalSimpleBeeLangTestLanguage.g:1248:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:1248:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:1248:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        // InternalSimpleBeeLangTestLanguage.g:1248:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
        {
        // InternalSimpleBeeLangTestLanguage.g:1248:21: ( (lv_greedy_10_0= 'greedy' ) )
        // InternalSimpleBeeLangTestLanguage.g:1249:11: (lv_greedy_10_0= 'greedy' )
        {
        // InternalSimpleBeeLangTestLanguage.g:1249:11: (lv_greedy_10_0= 'greedy' )
        // InternalSimpleBeeLangTestLanguage.g:1250:12: lv_greedy_10_0= 'greedy'
        {
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
    // $ANTLR end synpred33_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred34_InternalSimpleBeeLangTestLanguage
    public final void synpred34_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;

        // InternalSimpleBeeLangTestLanguage.g:1272:5: ( ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1272:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:1272:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1273:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // InternalSimpleBeeLangTestLanguage.g:1273:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1274:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // InternalSimpleBeeLangTestLanguage.g:1277:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:1277:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:1277:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        // InternalSimpleBeeLangTestLanguage.g:1277:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
        {
        otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:1285:10: ( (lv_min_14_0= RULE_INT ) )
        // InternalSimpleBeeLangTestLanguage.g:1286:11: (lv_min_14_0= RULE_INT )
        {
        // InternalSimpleBeeLangTestLanguage.g:1286:11: (lv_min_14_0= RULE_INT )
        // InternalSimpleBeeLangTestLanguage.g:1287:12: lv_min_14_0= RULE_INT
        {
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
    // $ANTLR end synpred34_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred35_InternalSimpleBeeLangTestLanguage
    public final void synpred35_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;

        // InternalSimpleBeeLangTestLanguage.g:1313:5: ( ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1313:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:1313:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1314:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // InternalSimpleBeeLangTestLanguage.g:1314:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1315:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // InternalSimpleBeeLangTestLanguage.g:1318:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:1318:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:1318:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        // InternalSimpleBeeLangTestLanguage.g:1318:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
        {
        otherlv_16=(Token)match(input,31,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:1326:10: ( (lv_max_18_0= RULE_INT ) )
        // InternalSimpleBeeLangTestLanguage.g:1327:11: (lv_max_18_0= RULE_INT )
        {
        // InternalSimpleBeeLangTestLanguage.g:1327:11: (lv_max_18_0= RULE_INT )
        // InternalSimpleBeeLangTestLanguage.g:1328:12: lv_max_18_0= RULE_INT
        {
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
    // $ANTLR end synpred35_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred36_InternalSimpleBeeLangTestLanguage
    public final void synpred36_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;

        // InternalSimpleBeeLangTestLanguage.g:1354:5: ( ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1354:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:1354:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1355:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalSimpleBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // InternalSimpleBeeLangTestLanguage.g:1355:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:1356:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // InternalSimpleBeeLangTestLanguage.g:1359:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        // InternalSimpleBeeLangTestLanguage.g:1359:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalSimpleBeeLangTestLanguage", "true");
        }
        // InternalSimpleBeeLangTestLanguage.g:1359:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        // InternalSimpleBeeLangTestLanguage.g:1359:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
        {
        otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:1367:10: ( (lv_versionRange_22_0= RULE_ID ) )
        // InternalSimpleBeeLangTestLanguage.g:1368:11: (lv_versionRange_22_0= RULE_ID )
        {
        // InternalSimpleBeeLangTestLanguage.g:1368:11: (lv_versionRange_22_0= RULE_ID )
        // InternalSimpleBeeLangTestLanguage.g:1369:12: lv_versionRange_22_0= RULE_ID
        {
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
    // $ANTLR end synpred36_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred42_InternalSimpleBeeLangTestLanguage
    public final void synpred42_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_ClosureParameter_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:1571:3: (this_ClosureParameter_0= ruleClosureParameter )
        // InternalSimpleBeeLangTestLanguage.g:1571:3: this_ClosureParameter_0= ruleClosureParameter
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
    // $ANTLR end synpred42_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred69_InternalSimpleBeeLangTestLanguage
    public final void synpred69_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_VarDeclaration_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:2254:3: (this_VarDeclaration_0= ruleVarDeclaration )
        // InternalSimpleBeeLangTestLanguage.g:2254:3: this_VarDeclaration_0= ruleVarDeclaration
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
    // $ANTLR end synpred69_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred71_InternalSimpleBeeLangTestLanguage
    public final void synpred71_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:2348:4: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )
        // InternalSimpleBeeLangTestLanguage.g:2348:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:2348:4: ()
        // InternalSimpleBeeLangTestLanguage.g:2349:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSimpleBeeLangTestLanguage.g:2358:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
        // InternalSimpleBeeLangTestLanguage.g:2359:5: (lv_functionName_2_0= ruleAssignmentOperator )
        {
        // InternalSimpleBeeLangTestLanguage.g:2359:5: (lv_functionName_2_0= ruleAssignmentOperator )
        // InternalSimpleBeeLangTestLanguage.g:2360:6: lv_functionName_2_0= ruleAssignmentOperator
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getFunctionNameAssignmentOperatorParserRuleCall_1_1_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_19);
        lv_functionName_2_0=ruleAssignmentOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSimpleBeeLangTestLanguage.g:2377:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:2378:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:2378:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        // InternalSimpleBeeLangTestLanguage.g:2379:6: lv_rightExpr_3_0= ruleAssignmentExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightExprAssignmentExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleAssignmentExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred71_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred85_InternalSimpleBeeLangTestLanguage
    public final void synpred85_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3024:4: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3024:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3024:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3025:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:3038:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:3039:5: (lv_rightExpr_3_0= ruleAndExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:3039:5: (lv_rightExpr_3_0= ruleAndExpression )
        // InternalSimpleBeeLangTestLanguage.g:3040:6: lv_rightExpr_3_0= ruleAndExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightExprAndExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred85_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred86_InternalSimpleBeeLangTestLanguage
    public final void synpred86_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3089:4: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3089:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3089:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3090:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:3103:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:3104:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:3104:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        // InternalSimpleBeeLangTestLanguage.g:3105:6: lv_rightExpr_3_0= ruleRelationalExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightExprRelationalExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred86_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred87_InternalSimpleBeeLangTestLanguage
    public final void synpred87_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3154:4: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3154:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3154:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3155:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSimpleBeeLangTestLanguage.g:3164:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
        // InternalSimpleBeeLangTestLanguage.g:3165:5: (lv_functionName_2_0= ruleRelationalOperator )
        {
        // InternalSimpleBeeLangTestLanguage.g:3165:5: (lv_functionName_2_0= ruleRelationalOperator )
        // InternalSimpleBeeLangTestLanguage.g:3166:6: lv_functionName_2_0= ruleRelationalOperator
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getFunctionNameRelationalOperatorParserRuleCall_1_1_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_19);
        lv_functionName_2_0=ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSimpleBeeLangTestLanguage.g:3183:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:3184:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:3184:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        // InternalSimpleBeeLangTestLanguage.g:3185:6: lv_rightExpr_3_0= ruleAdditiveExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightExprAdditiveExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred87_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred89_InternalSimpleBeeLangTestLanguage
    public final void synpred89_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3234:4: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3234:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3234:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3235:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSimpleBeeLangTestLanguage.g:3244:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3245:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3245:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        // InternalSimpleBeeLangTestLanguage.g:3246:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        {
        // InternalSimpleBeeLangTestLanguage.g:3246:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
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
                // InternalSimpleBeeLangTestLanguage.g:3247:7: lv_functionName_2_1= '+'
                {
                lv_functionName_2_1=(Token)match(input,59,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSimpleBeeLangTestLanguage.g:3258:7: lv_functionName_2_2= '-'
                {
                lv_functionName_2_2=(Token)match(input,60,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalSimpleBeeLangTestLanguage.g:3271:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:3272:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:3272:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        // InternalSimpleBeeLangTestLanguage.g:3273:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightExprMultiplicativeExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred89_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred92_InternalSimpleBeeLangTestLanguage
    public final void synpred92_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3322:4: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3322:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3322:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3323:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSimpleBeeLangTestLanguage.g:3332:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3333:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3333:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        // InternalSimpleBeeLangTestLanguage.g:3334:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        {
        // InternalSimpleBeeLangTestLanguage.g:3334:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
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
                // InternalSimpleBeeLangTestLanguage.g:3335:7: lv_functionName_2_1= '*'
                {
                lv_functionName_2_1=(Token)match(input,61,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSimpleBeeLangTestLanguage.g:3346:7: lv_functionName_2_2= '/'
                {
                lv_functionName_2_2=(Token)match(input,32,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalSimpleBeeLangTestLanguage.g:3357:7: lv_functionName_2_3= '%'
                {
                lv_functionName_2_3=(Token)match(input,62,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalSimpleBeeLangTestLanguage.g:3370:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:3371:5: (lv_rightExpr_3_0= ruleSetExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:3371:5: (lv_rightExpr_3_0= ruleSetExpression )
        // InternalSimpleBeeLangTestLanguage.g:3372:6: lv_rightExpr_3_0= ruleSetExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightExprSetExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleSetExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred92_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred93_InternalSimpleBeeLangTestLanguage
    public final void synpred93_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3421:4: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3421:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3421:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3422:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSimpleBeeLangTestLanguage.g:3431:4: ( (lv_functionName_2_0= '..' ) )
        // InternalSimpleBeeLangTestLanguage.g:3432:5: (lv_functionName_2_0= '..' )
        {
        // InternalSimpleBeeLangTestLanguage.g:3432:5: (lv_functionName_2_0= '..' )
        // InternalSimpleBeeLangTestLanguage.g:3433:6: lv_functionName_2_0= '..'
        {
        lv_functionName_2_0=(Token)match(input,63,FollowSets000.FOLLOW_19); if (state.failed) return ;

        }


        }

        // InternalSimpleBeeLangTestLanguage.g:3445:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:3446:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:3446:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        // InternalSimpleBeeLangTestLanguage.g:3447:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getSetExpressionAccess().getRightExprUnaryOrInfixExpressionParserRuleCall_1_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred93_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred99_InternalSimpleBeeLangTestLanguage
    public final void synpred99_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // InternalSimpleBeeLangTestLanguage.g:3700:4: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3700:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3700:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3701:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSimpleBeeLangTestLanguage.g:3710:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3711:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3711:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        // InternalSimpleBeeLangTestLanguage.g:3712:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        {
        // InternalSimpleBeeLangTestLanguage.g:3712:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
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
                // InternalSimpleBeeLangTestLanguage.g:3713:7: lv_functionName_2_1= '--'
                {
                lv_functionName_2_1=(Token)match(input,66,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSimpleBeeLangTestLanguage.g:3724:7: lv_functionName_2_2= '++'
                {
                lv_functionName_2_2=(Token)match(input,65,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred99_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred101_InternalSimpleBeeLangTestLanguage
    public final void synpred101_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameterList_5_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3769:4: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) )
        // InternalSimpleBeeLangTestLanguage.g:3769:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        {
        // InternalSimpleBeeLangTestLanguage.g:3769:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        // InternalSimpleBeeLangTestLanguage.g:3770:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
        {
        // InternalSimpleBeeLangTestLanguage.g:3770:5: ()
        // InternalSimpleBeeLangTestLanguage.g:3771:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:3784:5: ( (lv_name_3_0= RULE_ID ) )
        // InternalSimpleBeeLangTestLanguage.g:3785:6: (lv_name_3_0= RULE_ID )
        {
        // InternalSimpleBeeLangTestLanguage.g:3785:6: (lv_name_3_0= RULE_ID )
        // InternalSimpleBeeLangTestLanguage.g:3786:7: lv_name_3_0= RULE_ID
        {
        lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:3806:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==RULE_ID||LA114_0==RULE_STRING||LA114_0==13||(LA114_0>=17 && LA114_0<=18)||LA114_0==21||(LA114_0>=35 && LA114_0<=36)||LA114_0==52||LA114_0==56||LA114_0==60||(LA114_0>=64 && LA114_0<=66)||LA114_0==70||(LA114_0>=72 && LA114_0<=77)) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // InternalSimpleBeeLangTestLanguage.g:3807:6: (lv_parameterList_5_0= ruleParameterList )
                {
                // InternalSimpleBeeLangTestLanguage.g:3807:6: (lv_parameterList_5_0= ruleParameterList )
                // InternalSimpleBeeLangTestLanguage.g:3808:7: lv_parameterList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getInfixExpressionAccess().getParameterListParameterListParserRuleCall_1_0_4_0());
                  						
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
    // $ANTLR end synpred101_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred102_InternalSimpleBeeLangTestLanguage
    public final void synpred102_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_indexExpr_9_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3831:4: ( ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) )
        // InternalSimpleBeeLangTestLanguage.g:3831:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        {
        // InternalSimpleBeeLangTestLanguage.g:3831:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        // InternalSimpleBeeLangTestLanguage.g:3832:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
        {
        // InternalSimpleBeeLangTestLanguage.g:3832:5: ()
        // InternalSimpleBeeLangTestLanguage.g:3833:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_8=(Token)match(input,68,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:3846:5: ( (lv_indexExpr_9_0= ruleExpression ) )
        // InternalSimpleBeeLangTestLanguage.g:3847:6: (lv_indexExpr_9_0= ruleExpression )
        {
        // InternalSimpleBeeLangTestLanguage.g:3847:6: (lv_indexExpr_9_0= ruleExpression )
        // InternalSimpleBeeLangTestLanguage.g:3848:7: lv_indexExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getInfixExpressionAccess().getIndexExprExpressionParserRuleCall_1_1_2_0());
          						
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
    // $ANTLR end synpred102_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred103_InternalSimpleBeeLangTestLanguage
    public final void synpred103_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        // InternalSimpleBeeLangTestLanguage.g:3871:4: ( ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3871:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3871:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        // InternalSimpleBeeLangTestLanguage.g:3872:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:3872:5: ()
        // InternalSimpleBeeLangTestLanguage.g:3873:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_12=(Token)match(input,67,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:3886:5: ( (lv_featureName_13_0= RULE_ID ) )
        // InternalSimpleBeeLangTestLanguage.g:3887:6: (lv_featureName_13_0= RULE_ID )
        {
        // InternalSimpleBeeLangTestLanguage.g:3887:6: (lv_featureName_13_0= RULE_ID )
        // InternalSimpleBeeLangTestLanguage.g:3888:7: lv_featureName_13_0= RULE_ID
        {
        lv_featureName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred103_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred105_InternalSimpleBeeLangTestLanguage
    public final void synpred105_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_parameterList_3_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3937:4: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
        // InternalSimpleBeeLangTestLanguage.g:3937:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
        {
        // InternalSimpleBeeLangTestLanguage.g:3937:4: ()
        // InternalSimpleBeeLangTestLanguage.g:3938:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:3951:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==RULE_ID||LA115_0==RULE_STRING||LA115_0==13||(LA115_0>=17 && LA115_0<=18)||LA115_0==21||(LA115_0>=35 && LA115_0<=36)||LA115_0==52||LA115_0==56||LA115_0==60||(LA115_0>=64 && LA115_0<=66)||LA115_0==70||(LA115_0>=72 && LA115_0<=77)) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // InternalSimpleBeeLangTestLanguage.g:3952:5: (lv_parameterList_3_0= ruleParameterList )
                {
                // InternalSimpleBeeLangTestLanguage.g:3952:5: (lv_parameterList_3_0= ruleParameterList )
                // InternalSimpleBeeLangTestLanguage.g:3953:6: lv_parameterList_3_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getCallExpressionAccess().getParameterListParameterListParserRuleCall_1_2_0());
                  					
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
    // $ANTLR end synpred105_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred106_InternalSimpleBeeLangTestLanguage
    public final void synpred106_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_FeatureCall_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:3994:3: (this_FeatureCall_0= ruleFeatureCall )
        // InternalSimpleBeeLangTestLanguage.g:3994:3: this_FeatureCall_0= ruleFeatureCall
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
    // $ANTLR end synpred106_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred108_InternalSimpleBeeLangTestLanguage
    public final void synpred108_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_Value_2 = null;


        // InternalSimpleBeeLangTestLanguage.g:4018:3: (this_Value_2= ruleValue )
        // InternalSimpleBeeLangTestLanguage.g:4018:3: this_Value_2= ruleValue
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
    // $ANTLR end synpred108_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred109_InternalSimpleBeeLangTestLanguage
    public final void synpred109_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_Literal_3 = null;


        // InternalSimpleBeeLangTestLanguage.g:4030:3: (this_Literal_3= ruleLiteral )
        // InternalSimpleBeeLangTestLanguage.g:4030:3: this_Literal_3= ruleLiteral
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
    // $ANTLR end synpred109_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred112_InternalSimpleBeeLangTestLanguage
    public final void synpred112_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_BlockExpression_6 = null;


        // InternalSimpleBeeLangTestLanguage.g:4066:3: (this_BlockExpression_6= ruleBlockExpression )
        // InternalSimpleBeeLangTestLanguage.g:4066:3: this_BlockExpression_6= ruleBlockExpression
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
    // $ANTLR end synpred112_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred113_InternalSimpleBeeLangTestLanguage
    public final void synpred113_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_WithExpression_7 = null;


        // InternalSimpleBeeLangTestLanguage.g:4078:3: (this_WithExpression_7= ruleWithExpression )
        // InternalSimpleBeeLangTestLanguage.g:4078:3: this_WithExpression_7= ruleWithExpression
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
    // $ANTLR end synpred113_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred127_InternalSimpleBeeLangTestLanguage
    public final void synpred127_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameterList_4_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:4688:4: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )
        // InternalSimpleBeeLangTestLanguage.g:4688:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
        {
        otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:4692:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==RULE_STRING||LA117_0==13||(LA117_0>=17 && LA117_0<=18)||LA117_0==21||(LA117_0>=35 && LA117_0<=36)||LA117_0==52||LA117_0==56||LA117_0==60||(LA117_0>=64 && LA117_0<=66)||LA117_0==70||(LA117_0>=72 && LA117_0<=77)) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // InternalSimpleBeeLangTestLanguage.g:4693:5: (lv_parameterList_4_0= ruleParameterList )
                {
                // InternalSimpleBeeLangTestLanguage.g:4693:5: (lv_parameterList_4_0= ruleParameterList )
                // InternalSimpleBeeLangTestLanguage.g:4694:6: lv_parameterList_4_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getConstructorCallExpressionAccess().getParameterListParameterListParserRuleCall_3_1_0());
                  					
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
    // $ANTLR end synpred127_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred128_InternalSimpleBeeLangTestLanguage
    public final void synpred128_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        // InternalSimpleBeeLangTestLanguage.g:4717:4: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )
        // InternalSimpleBeeLangTestLanguage.g:4717:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
        {
        otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalSimpleBeeLangTestLanguage.g:4721:4: ( (lv_alias_7_0= RULE_ID ) )
        // InternalSimpleBeeLangTestLanguage.g:4722:5: (lv_alias_7_0= RULE_ID )
        {
        // InternalSimpleBeeLangTestLanguage.g:4722:5: (lv_alias_7_0= RULE_ID )
        // InternalSimpleBeeLangTestLanguage.g:4723:6: lv_alias_7_0= RULE_ID
        {
        lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred128_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred135_InternalSimpleBeeLangTestLanguage
    public final void synpred135_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_10_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:5086:4: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) )
        // InternalSimpleBeeLangTestLanguage.g:5086:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        {
        // InternalSimpleBeeLangTestLanguage.g:5086:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        // InternalSimpleBeeLangTestLanguage.g:5087:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        {
        // InternalSimpleBeeLangTestLanguage.g:5087:5: (otherlv_4= '|' )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==77) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // InternalSimpleBeeLangTestLanguage.g:5088:6: otherlv_4= '|'
                {
                otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }
                break;

        }

        // InternalSimpleBeeLangTestLanguage.g:5093:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        // InternalSimpleBeeLangTestLanguage.g:5094:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        {
        // InternalSimpleBeeLangTestLanguage.g:5094:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
        // InternalSimpleBeeLangTestLanguage.g:5095:7: (lv_parameters_5_0= ruleParameterDeclaration )
        {
        // InternalSimpleBeeLangTestLanguage.g:5095:7: (lv_parameters_5_0= ruleParameterDeclaration )
        // InternalSimpleBeeLangTestLanguage.g:5096:8: lv_parameters_5_0= ruleParameterDeclaration
        {
        if ( state.backtracking==0 ) {

          								newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_0_0());
          							
        }
        pushFollow(FollowSets000.FOLLOW_26);
        lv_parameters_5_0=ruleParameterDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSimpleBeeLangTestLanguage.g:5113:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
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
        	    // InternalSimpleBeeLangTestLanguage.g:5114:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    {
        	    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_35); if (state.failed) return ;
        	    // InternalSimpleBeeLangTestLanguage.g:5118:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    // InternalSimpleBeeLangTestLanguage.g:5119:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    {
        	    // InternalSimpleBeeLangTestLanguage.g:5119:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    // InternalSimpleBeeLangTestLanguage.g:5120:9: lv_parameters_7_0= ruleParameterDeclaration
        	    {
        	    if ( state.backtracking==0 ) {

        	      									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0());
        	      								
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

        // InternalSimpleBeeLangTestLanguage.g:5138:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==16) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // InternalSimpleBeeLangTestLanguage.g:5139:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                {
                otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_36); if (state.failed) return ;
                // InternalSimpleBeeLangTestLanguage.g:5143:7: ( (lv_varArgs_9_0= '...' ) )
                // InternalSimpleBeeLangTestLanguage.g:5144:8: (lv_varArgs_9_0= '...' )
                {
                // InternalSimpleBeeLangTestLanguage.g:5144:8: (lv_varArgs_9_0= '...' )
                // InternalSimpleBeeLangTestLanguage.g:5145:9: lv_varArgs_9_0= '...'
                {
                lv_varArgs_9_0=(Token)match(input,36,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }


                }

                // InternalSimpleBeeLangTestLanguage.g:5157:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                // InternalSimpleBeeLangTestLanguage.g:5158:8: (lv_parameters_10_0= ruleParameterDeclaration )
                {
                // InternalSimpleBeeLangTestLanguage.g:5158:8: (lv_parameters_10_0= ruleParameterDeclaration )
                // InternalSimpleBeeLangTestLanguage.g:5159:9: lv_parameters_10_0= ruleParameterDeclaration
                {
                if ( state.backtracking==0 ) {

                  									newCompositeNode(grammarAccess.getClosureExpressionAccess().getParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0());
                  								
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
    // $ANTLR end synpred135_InternalSimpleBeeLangTestLanguage

    // $ANTLR start synpred137_InternalSimpleBeeLangTestLanguage
    public final void synpred137_InternalSimpleBeeLangTestLanguage_fragment() throws RecognitionException {   
        EObject this_BlockExpressionWithoutBrackets_0 = null;


        // InternalSimpleBeeLangTestLanguage.g:5258:3: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets )
        // InternalSimpleBeeLangTestLanguage.g:5258:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
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
    // $ANTLR end synpred137_InternalSimpleBeeLangTestLanguage

}

@SuppressWarnings("all")
public class InternalSimpleBeeLangTestLanguageParser extends InternalSimpleBeeLangTestLanguageParser3 {



        public InternalSimpleBeeLangTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleBeeLangTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[259+1];
             
             
        }
        


        public InternalSimpleBeeLangTestLanguageParser(TokenStream input, SimpleBeeLangTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
}
