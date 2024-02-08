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
import org.eclipse.xtext.testlanguages.backtracking.services.ExBeeLangTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
interface InternalExBeeLangTestLanguageParserSignatures {
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
     void synpred2_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred9_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred10_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred11_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred12_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred13_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred14_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred15_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred16_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred17_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred18_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred20_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred21_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred22_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred26_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred27_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred28_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred29_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred30_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred32_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred33_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred34_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred35_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred36_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred42_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred69_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred71_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred85_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred86_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred87_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred89_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred92_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred93_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred99_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred101_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred102_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred103_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred105_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred106_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred108_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred109_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred112_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred113_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred127_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred128_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred135_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
     void synpred137_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException;   
}

@SuppressWarnings("all")
abstract class InternalExBeeLangTestLanguageParser1 extends AbstractInternalAntlrParser implements InternalExBeeLangTestLanguageParserSignatures {

        InternalExBeeLangTestLanguageParser1(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        InternalExBeeLangTestLanguageParser1(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RequiresMax", "RequiresMin", "Implements", "Properties", "Function", "Provides", "Requires", "Builder", "Context", "Version", "Cached", "Greedy", "Output", "Source", "Final", "Input", "Name", "This", "Unit", "When", "With", "ExclamationMarkEqualsSignEqualsSign", "FullStopFullStopFullStop", "EqualsSignEqualsSignEqualsSign", "Env", "New", "Val", "Var", "ExclamationMarkEqualsSign", "PercentSignEqualsSign", "AmpersandAmpersand", "AsteriskEqualsSign", "PlusSignPlusSign", "PlusSignEqualsSign", "HyphenMinusHyphenMinus", "HyphenMinusEqualsSign", "FullStopFullStop", "SolidusEqualsSign", "LessThanSignEqualsSign", "EqualsSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "As", "VerticalLineVerticalLine", "TildeEqualsSign", "ExclamationMark", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_DOCUMENTATION", "RULE_HEX", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Val=30;
    public static final int HyphenMinusHyphenMinus=38;
    public static final int New=29;
    public static final int RULE_HEX=70;
    public static final int EqualsSignGreaterThanSign=44;
    public static final int Var=31;
    public static final int SolidusEqualsSign=41;
    public static final int Builder=11;
    public static final int Unit=22;
    public static final int FullStopFullStopFullStop=26;
    public static final int LessThanSign=61;
    public static final int Name=20;
    public static final int PercentSign=50;
    public static final int Implements=6;
    public static final int Input=19;
    public static final int LeftParenthesis=51;
    public static final int Version=13;
    public static final int FullStopFullStop=40;
    public static final int Cached=14;
    public static final int This=21;
    public static final int AsteriskEqualsSign=35;
    public static final int RightSquareBracket=65;
    public static final int ExclamationMark=49;
    public static final int ExclamationMarkEqualsSignEqualsSign=25;
    public static final int GreaterThanSign=63;
    public static final int RequiresMax=4;
    public static final int RULE_ID=71;
    public static final int Requires=10;
    public static final int RightParenthesis=52;
    public static final int RULE_DOCUMENTATION=69;
    public static final int EqualsSignEqualsSignEqualsSign=27;
    public static final int GreaterThanSignEqualsSign=45;
    public static final int RequiresMin=5;
    public static final int EqualsSignEqualsSign=43;
    public static final int VerticalLine=67;
    public static final int PlusSign=54;
    public static final int RULE_INT=72;
    public static final int RULE_ML_COMMENT=74;
    public static final int LeftSquareBracket=64;
    public static final int TildeEqualsSign=48;
    public static final int VerticalLineVerticalLine=47;
    public static final int RULE_STRING=73;
    public static final int Properties=7;
    public static final int Env=28;
    public static final int Source=17;
    public static final int With=24;
    public static final int RULE_SL_COMMENT=75;
    public static final int Function=8;
    public static final int Comma=55;
    public static final int EqualsSign=62;
    public static final int As=46;
    public static final int HyphenMinus=56;
    public static final int AmpersandAmpersand=34;
    public static final int Output=16;
    public static final int HyphenMinusEqualsSign=39;
    public static final int LessThanSignEqualsSign=42;
    public static final int Solidus=58;
    public static final int Colon=59;
    public static final int RightCurlyBracket=68;
    public static final int EOF=-1;
    public static final int Greedy=15;
    public static final int Final=18;
    public static final int Asterisk=53;
    public static final int PercentSignEqualsSign=33;
    public static final int PlusSignEqualsSign=37;
    public static final int Context=12;
    public static final int FullStop=57;
    public static final int RULE_WS=76;
    public static final int LeftCurlyBracket=66;
    public static final int RULE_ANY_OTHER=77;
    public static final int Provides=9;
    public static final int Semicolon=60;
    public static final int When=23;
    public static final int PlusSignPlusSign=36;
    public static final int ExclamationMarkEqualsSign=32;


    public String[] getTokenNames() { return InternalExBeeLangTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExBeeLangTestLanguageParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	protected ExBeeLangTestLanguageGrammarAccess grammarAccess;



        @Override
        protected String getFirstRuleName() {
        	return "DelegateModel";
       	}

       	@Override
       	protected ExBeeLangTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}





    // Delegated rules

    public final boolean synpred15_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_InternalExBeeLangTestLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalExBeeLangTestLanguageParser_fragment(); // can never throw exception
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
    static final String dfa_2s = "\1\10\4\uffff\1\34\6\uffff";
    static final String dfa_3s = "\1\107\4\uffff\1\73\6\uffff";
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\1\3\1\uffff\4\6\1\4\1\5";
    static final String dfa_5s = "\1\0\4\uffff\1\1\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\11\1\4\1\5\5\uffff\1\3\1\2\1\10\61\uffff\1\1\1\6\1\uffff\1\7",
            "",
            "",
            "",
            "",
            "\1\13\36\uffff\1\12",
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
            return "()* loopback of 315:6: ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*";
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
                        if ( (LA13_0==RightCurlyBracket) ) {s = 1;}

                        else if ( LA13_0 == Source && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {s = 2;}

                        else if ( LA13_0 == Output && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {s = 3;}

                        else if ( LA13_0 == Provides && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {s = 4;}

                        else if ( (LA13_0==Requires) ) {s = 5;}

                        else if ( LA13_0 == RULE_DOCUMENTATION && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 6;}

                        else if ( LA13_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 7;}

                        else if ( LA13_0 == Final && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 8;}

                        else if ( LA13_0 == Function && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 9;}

                         
                        input.seek(index13_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA13_5 == Colon && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {s = 10;}

                        else if ( LA13_5 == Env && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {s = 11;}

                         
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
    static final String dfa_9s = "\1\7\1\uffff\1\7\1\31\1\uffff\1\31\2\7\2\31\1\7\1\0\1\63\2\7\1\31\1\107\1\54\1\32\1\0\2\31\1\32\1\31\1\64\1\107\1\64\1\107\1\54\2\7\1\64\2\107\1\32\1\64\1\107\2\31\1\64\1\0\1\64\2\107\1\64\1\0";
    static final String dfa_10s = "\1\111\1\uffff\1\111\1\107\1\uffff\1\100\2\111\2\100\1\111\1\0\1\107\2\111\1\100\1\107\1\54\1\107\1\0\1\107\1\103\1\107\1\100\1\64\1\107\1\67\1\107\1\54\2\111\1\67\3\107\1\64\1\107\1\103\1\107\1\64\1\0\1\67\2\107\1\64\1\0";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\2\51\uffff";
    static final String dfa_12s = "\13\uffff\1\0\7\uffff\1\3\24\uffff\1\1\4\uffff\1\2}>";
    static final String[] dfa_13s = {
            "\1\4\3\uffff\1\4\2\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\1\2\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\2\4\uffff\1\4\4\uffff\1\1\4\uffff\1\4\1\1\3\uffff\1\3\1\uffff\1\4",
            "",
            "\1\4\3\uffff\1\4\2\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\1\2\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\4\1\1\3\uffff\1\4\11\uffff\1\4\4\uffff\1\5\1\uffff\1\4",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\5\4\1\7\3\4\2\uffff\1\6\3\4\2\uffff\1\1\3\uffff\1\1",
            "",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\10\2\4\1\1\3\4\2\uffff\4\4",
            "\1\4\3\uffff\1\4\4\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\4\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\4\4\uffff\1\4\11\uffff\1\4\4\uffff\1\11\1\uffff\1\4",
            "\1\4\3\uffff\1\4\2\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\14\2\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\12\4\uffff\1\4\4\uffff\1\4\4\uffff\2\4\3\uffff\1\13\1\uffff\1\4",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\1\1\4\1\uffff\2\4\1\uffff\11\4\2\uffff\4\4",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\5\4\1\15\3\4\2\uffff\2\4\1\16\1\4",
            "\1\4\3\uffff\1\4\2\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\20\2\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\4\1\21\3\uffff\1\4\11\uffff\1\4\4\uffff\1\17\1\uffff\1\4",
            "\1\uffff",
            "\1\22\23\uffff\1\23",
            "\1\4\3\uffff\1\4\2\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\4\4\uffff\1\4\4\uffff\1\4\4\uffff\2\4\3\uffff\1\24\1\uffff\1\4",
            "\1\4\3\uffff\1\4\4\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\4\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\4\4\uffff\1\4\11\uffff\1\4\4\uffff\1\25\1\uffff\1\4",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\27\2\4\1\26\3\4\2\uffff\4\4",
            "\1\30",
            "\1\31",
            "\1\33\31\uffff\1\34\22\uffff\1\32",
            "\1\uffff",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\5\4\1\36\3\4\2\uffff\2\4\1\35\1\4\2\uffff\1\4\3\uffff\1\4",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\5\4\1\7\3\4\2\uffff\4\4\2\uffff\1\1",
            "\1\40\54\uffff\1\37",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\31\1\4\1\uffff\2\4\1\uffff\11\4\2\uffff\4\4",
            "\1\21",
            "\1\41",
            "\1\34\2\uffff\1\42",
            "\1\43",
            "\1\44",
            "\1\4\3\uffff\1\4\4\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\4\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\4\4\uffff\1\4\11\uffff\1\4\4\uffff\1\45\1\uffff\1\4",
            "\1\4\3\uffff\1\4\2\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\6\uffff\1\4\1\uffff\1\4\12\uffff\1\4\1\uffff\1\4\4\uffff\1\4\4\uffff\1\4\4\uffff\2\4\3\uffff\1\46\1\uffff\1\4",
            "\1\21\2\uffff\1\26",
            "\1\47",
            "\1\50",
            "\1\52\54\uffff\1\51",
            "\1\34",
            "\1\53",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\5\4\1\7\3\4\2\uffff\4\4\2\uffff\1\1",
            "\1\4\1\uffff\1\4\4\uffff\14\4\1\uffff\1\4\1\uffff\2\4\1\uffff\5\4\1\36\3\4\2\uffff\2\4\1\35\1\4\2\uffff\1\4\3\uffff\1\4",
            "\1\21",
            "\1\uffff",
            "\1\34\2\uffff\1\42",
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
            return "1568:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_40 = input.LA(1);

                         
                        int index27_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_40);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_45 = input.LA(1);

                         
                        int index27_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_45);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_19 = input.LA(1);

                         
                        int index27_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_19);
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
    static final String dfa_16s = "\1\7\1\36\1\uffff\1\7\1\31\2\uffff\1\31\1\7\2\31\1\7\1\0";
    static final String dfa_17s = "\1\111\1\107\1\uffff\1\111\1\107\2\uffff\1\100\1\111\2\100\1\111\1\0";
    static final String dfa_18s = "\2\uffff\1\1\2\uffff\1\2\1\3\6\uffff";
    static final String dfa_19s = "\14\uffff\1\0}>";
    static final String[] dfa_20s = {
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\2\6\1\1\1\6\1\uffff\2\6\1\uffff\1\6\4\uffff\1\6\1\5\1\2\4\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\3\4\uffff\1\6\11\uffff\1\6\4\uffff\1\4\1\uffff\1\6",
            "\1\5\1\2\23\uffff\1\2\23\uffff\1\2",
            "",
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\1\2\2\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\1\2\3\uffff\1\6\11\uffff\1\6\4\uffff\1\7\1\uffff\1\6",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\2\6\1\uffff\3\6\1\uffff\1\6\1\10\3\6\6\uffff\1\2",
            "",
            "",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\11\2\6\1\2\3\6\2\uffff\4\6",
            "\1\6\3\uffff\1\6\4\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\4\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\4\uffff\1\6\11\uffff\1\6\4\uffff\1\12\1\uffff\1\6",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\2\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\2\6\1\uffff\3\6\1\uffff\5\6",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\2\6\1\2\3\6\1\uffff\3\6\1\13\1\6",
            "\1\6\3\uffff\1\6\4\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\4\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\4\uffff\1\6\11\uffff\1\6\4\uffff\1\14\1\uffff\1\6",
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
            return "2251:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )";
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
                        if ( (synpred69_InternalExBeeLangTestLanguageParser()) ) {s = 2;}

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
    static final String dfa_22s = "\1\31\1\uffff\11\0\1\uffff";
    static final String dfa_23s = "\1\104\1\uffff\11\0\1\uffff";
    static final String dfa_24s = "\1\uffff\1\2\11\uffff\1\1";
    static final String dfa_25s = "\2\uffff\1\0\1\4\1\1\1\5\1\2\1\6\1\3\1\7\1\10\1\uffff}>";
    static final String[] dfa_26s = {
            "\1\6\1\uffff\1\4\4\uffff\1\5\11\1\1\10\1\3\1\uffff\1\7\2\1\1\2\1\uffff\11\1\1\uffff\1\1\1\12\1\1\1\11\3\1\1\uffff\1\1",
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
            return "()* loopback of 3151:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalExBeeLangTestLanguageParser()) ) {s = 11;}

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
    static final String dfa_28s = "\1\7\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String dfa_29s = "\1\111\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String dfa_30s = "\2\uffff\1\2\1\4\1\uffff\1\5\6\uffff\1\6\1\uffff\1\1\1\3\1\7\1\10\1\11";
    static final String dfa_31s = "\1\uffff\1\0\2\uffff\1\1\10\uffff\1\2\5\uffff}>";
    static final String[] dfa_32s = {
            "\1\5\3\uffff\1\5\4\uffff\2\5\1\uffff\1\5\1\uffff\2\5\1\uffff\1\15\4\uffff\1\2\25\uffff\1\14\16\uffff\1\4\4\uffff\1\1\1\uffff\1\3",
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
            return "3991:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )";
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
                        if ( (synpred106_InternalExBeeLangTestLanguageParser()) ) {s = 14;}

                        else if ( (synpred108_InternalExBeeLangTestLanguageParser()) ) {s = 15;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_4 = input.LA(1);

                         
                        int index73_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_InternalExBeeLangTestLanguageParser()) ) {s = 3;}

                        else if ( (synpred112_InternalExBeeLangTestLanguageParser()) ) {s = 16;}

                         
                        input.seek(index73_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_13 = input.LA(1);

                         
                        int index73_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalExBeeLangTestLanguageParser()) ) {s = 17;}

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
    static final String dfa_35s = "\1\31\1\0\44\uffff";
    static final String dfa_36s = "\1\104\1\0\44\uffff";
    static final String dfa_37s = "\2\uffff\1\2\42\uffff\1\1";
    static final String dfa_38s = "\1\uffff\1\0\44\uffff}>";
    static final String[] dfa_39s = {
            "\1\2\1\uffff\1\2\4\uffff\14\2\1\uffff\4\2\1\uffff\1\2\1\1\7\2\1\uffff\7\2\1\uffff\1\2",
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
            return "4685:3: (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )?";
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
                        if ( (synpred127_InternalExBeeLangTestLanguageParser()) ) {s = 37;}

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
    static final String dfa_41s = "\5\uffff\1\6\7\uffff\1\6\6\uffff\1\6\14\uffff\1\6\5\uffff\2\6\15\uffff\2\6\2\uffff";
    static final String dfa_42s = "\1\32\1\7\2\uffff\1\7\1\31\1\uffff\1\31\1\107\1\54\2\7\1\67\1\31\1\32\1\64\1\107\1\7\1\0\1\63\1\31\1\64\2\107\1\31\1\107\1\54\1\32\1\0\2\7\1\64\1\32\1\31\1\64\1\107\1\64\1\107\1\54\2\31\1\107\1\64\1\107\1\32\1\64\1\107\2\7\1\64\1\0\1\64\2\107\2\31\1\64\1\0";
    static final String dfa_43s = "\1\107\1\111\2\uffff\1\111\1\107\1\uffff\1\100\1\107\1\54\2\111\1\103\1\104\1\107\1\64\1\107\1\111\1\0\1\107\1\104\1\67\2\107\1\100\1\107\1\54\1\107\1\0\2\111\1\64\1\107\1\100\1\64\1\107\1\67\1\107\1\54\1\104\2\107\1\67\2\107\1\64\1\107\2\111\1\64\1\0\1\67\2\107\1\103\1\107\1\64\1\0";
    static final String dfa_44s = "\2\uffff\1\1\1\2\2\uffff\1\3\63\uffff";
    static final String dfa_45s = "\22\uffff\1\1\11\uffff\1\3\25\uffff\1\2\6\uffff\1\0}>";
    static final String[] dfa_46s = {
            "\1\3\30\uffff\1\2\17\uffff\1\1\3\uffff\1\2",
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\4\6\1\uffff\2\6\1\uffff\1\6\4\uffff\3\6\4\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\4\4\uffff\1\6\11\uffff\1\6\4\uffff\1\5\1\uffff\1\6",
            "",
            "",
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\1\10\2\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\1\11\3\uffff\1\6\11\uffff\1\6\4\uffff\1\7\1\uffff\1\6",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\5\6\1\12\3\6\1\uffff\1\6\1\13\3\6\2\uffff\1\2\1\6\2\uffff\1\14",
            "",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\15\2\6\1\16\3\6\2\uffff\4\6",
            "\1\17",
            "\1\20",
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\1\23\2\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\21\4\uffff\1\6\4\uffff\1\6\4\uffff\2\6\3\uffff\1\22\1\uffff\1\6",
            "\1\6\3\uffff\1\6\4\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\4\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\4\uffff\1\6\11\uffff\1\6\4\uffff\1\24\1\uffff\1\6",
            "\1\2\4\uffff\1\6\1\uffff\1\6\4\uffff\1\2",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\20\1\6\1\uffff\2\6\1\uffff\11\6\1\uffff\5\6\3\uffff\1\6",
            "\1\26\54\uffff\1\25",
            "\1\11",
            "\1\27",
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\1\31\2\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\1\32\3\uffff\1\6\11\uffff\1\6\4\uffff\1\30\1\uffff\1\6",
            "\1\uffff",
            "\1\33\23\uffff\1\34",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\5\6\1\36\3\6\1\uffff\3\6\1\35\1\6\3\uffff\1\6",
            "\1\11\2\uffff\1\16",
            "\1\37",
            "\1\14",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\41\2\6\1\40\3\6\2\uffff\4\6",
            "\1\42",
            "\1\43",
            "\1\45\31\uffff\1\46\22\uffff\1\44",
            "\1\uffff",
            "\1\6\3\uffff\1\6\4\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\4\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\4\uffff\1\6\11\uffff\1\6\4\uffff\1\47\1\uffff\1\6",
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\1\6\2\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\4\uffff\1\6\4\uffff\1\6\4\uffff\2\6\3\uffff\1\50\1\uffff\1\6",
            "\1\11",
            "\1\51\54\uffff\1\52",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\43\1\6\1\uffff\2\6\1\uffff\11\6\2\uffff\4\6",
            "\1\32",
            "\1\53",
            "\1\46\2\uffff\1\54",
            "\1\55",
            "\1\56",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\5\6\1\12\3\6\1\uffff\5\6\2\uffff\1\2\1\6",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\5\6\1\60\3\6\2\uffff\2\6\1\57\1\6\2\uffff\1\6\3\uffff\1\6",
            "\1\61",
            "\1\32\2\uffff\1\40",
            "\1\62",
            "\1\64\54\uffff\1\63",
            "\1\46",
            "\1\65",
            "\1\6\3\uffff\1\6\4\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\4\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\4\uffff\1\6\11\uffff\1\6\4\uffff\1\66\1\uffff\1\6",
            "\1\6\3\uffff\1\6\2\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\2\6\1\uffff\1\6\1\uffff\1\6\2\uffff\1\6\6\uffff\1\6\1\uffff\1\6\12\uffff\1\6\1\uffff\1\6\4\uffff\1\6\4\uffff\1\6\4\uffff\2\6\3\uffff\1\67\1\uffff\1\6",
            "\1\32",
            "\1\uffff",
            "\1\46\2\uffff\1\54",
            "\1\70",
            "\1\71",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\5\6\1\12\3\6\1\uffff\5\6\2\uffff\1\2",
            "\1\6\1\uffff\1\6\4\uffff\14\6\1\uffff\1\6\1\uffff\2\6\1\uffff\5\6\1\60\3\6\2\uffff\2\6\1\57\1\6\2\uffff\1\6\3\uffff\1\6",
            "\1\46",
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
            return "5083:3: ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalExBeeLangTestLanguageParser()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_18 = input.LA(1);

                         
                        int index90_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalExBeeLangTestLanguageParser()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_50 = input.LA(1);

                         
                        int index90_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalExBeeLangTestLanguageParser()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_50);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_28 = input.LA(1);

                         
                        int index90_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_InternalExBeeLangTestLanguageParser()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_28);
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
    static final String dfa_48s = "\1\7\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String dfa_49s = "\1\111\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String dfa_50s = "\1\uffff\1\1\24\uffff\1\2";
    static final String dfa_51s = "\3\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\uffff}>";
    static final String[] dfa_52s = {
            "\1\15\3\uffff\1\16\2\uffff\1\6\1\uffff\1\13\1\14\1\1\1\12\1\uffff\1\20\1\17\1\uffff\1\21\4\uffff\1\7\2\1\4\uffff\1\24\1\uffff\1\25\12\uffff\1\22\1\uffff\1\3\4\uffff\1\23\11\uffff\1\11\4\uffff\1\4\1\uffff\1\10",
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
            return "5255:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )";
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
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_4 = input.LA(1);

                         
                        int index91_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_7 = input.LA(1);

                         
                        int index91_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_8 = input.LA(1);

                         
                        int index91_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA91_17 = input.LA(1);

                         
                        int index91_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_17);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA91_18 = input.LA(1);

                         
                        int index91_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_18);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA91_19 = input.LA(1);

                         
                        int index91_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA91_20 = input.LA(1);

                         
                        int index91_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA91_21 = input.LA(1);

                         
                        int index91_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_InternalExBeeLangTestLanguageParser()) ) {s = 1;}

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
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000020L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040102L,0x00000000000000A0L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002040L,0x0000000000000084L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002040L,0x0000000000000004L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000004L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000070700L,0x00000000000000B0L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0400000000000000L,0x0000000000000280L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000080L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000902000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x010A0050216B4880L,0x0000000000000284L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000902000L,0x0000000000000010L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000000080A030L,0x0000000000000010L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080000000000002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x210A0050256B4880L,0x000000000000028CL});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000040100L,0x0000000000000080L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000040100L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0808000000800000L,0x0000000000000004L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0018000004000000L,0x0000000000000088L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0090000000000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000088L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0800000000800000L,0x0000000000000004L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x400002AA00000002L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0008000080000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x4000000000000002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x8080000000000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0010000004000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000800000000002L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0xA0012C010A000002L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0140000000000002L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0424000000000002L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00080000216B0880L,0x0000000000000284L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000005000000002L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x211A0050256B4880L,0x000000000000028CL});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0008000000000002L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0800000000000000L,0x0000000000000084L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0880000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x010A0050E16F4880L,0x0000000000000284L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x010A0050E16F4880L,0x0000000000000294L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0008400000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000400000000002L,0x0000000000000004L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x2008000004000000L,0x0000000000000088L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0008000004000000L,0x0000000000000088L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x010A0050E16F4882L,0x0000000000000284L});
        public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0200000000000002L,0x00000000000001C0L});
        public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000202L});
        public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000402L});
    }


}

@SuppressWarnings("all")
abstract class InternalExBeeLangTestLanguageParser2 extends InternalExBeeLangTestLanguageParser1 {

        InternalExBeeLangTestLanguageParser2(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        InternalExBeeLangTestLanguageParser2(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleDelegateModel"
    // InternalExBeeLangTestLanguageParser.g:70:1: entryRuleDelegateModel returns [EObject current=null] : iv_ruleDelegateModel= ruleDelegateModel EOF ;
    public final EObject entryRuleDelegateModel() throws RecognitionException {
        EObject current = null;
        int entryRuleDelegateModel_StartIndex = input.index();
        EObject iv_ruleDelegateModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:70:54: (iv_ruleDelegateModel= ruleDelegateModel EOF )
            // InternalExBeeLangTestLanguageParser.g:71:2: iv_ruleDelegateModel= ruleDelegateModel EOF
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
    // InternalExBeeLangTestLanguageParser.g:77:1: ruleDelegateModel returns [EObject current=null] : this_Model_0= ruleModel ;
    public final EObject ruleDelegateModel() throws RecognitionException {
        EObject current = null;
        int ruleDelegateModel_StartIndex = input.index();
        EObject this_Model_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:83:2: (this_Model_0= ruleModel )
            // InternalExBeeLangTestLanguageParser.g:84:2: this_Model_0= ruleModel
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
    // InternalExBeeLangTestLanguageParser.g:98:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;
        int entryRuleModel_StartIndex = input.index();
        EObject iv_ruleModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:98:46: (iv_ruleModel= ruleModel EOF )
            // InternalExBeeLangTestLanguageParser.g:99:2: iv_ruleModel= ruleModel EOF
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
    // InternalExBeeLangTestLanguageParser.g:105:1: ruleModel returns [EObject current=null] : ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;
        int ruleModel_StartIndex = input.index();
        EObject lv_units_0_0 = null;

        EObject lv_functions_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:111:2: ( ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:112:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:112:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            int alt3=2;
            switch ( input.LA(1) ) {
            case RULE_DOCUMENTATION:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==Function||LA3_1==Final||LA3_1==RULE_ID) ) {
                    alt3=2;
                }
                else if ( (LA3_1==Unit) ) {
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
            case Unit:
                {
                alt3=1;
                }
                break;
            case EOF:
                {
                int LA3_3 = input.LA(2);

                if ( (synpred2_InternalExBeeLangTestLanguageParser()) ) {
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
            case Function:
            case Final:
            case RULE_ID:
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
                    // InternalExBeeLangTestLanguageParser.g:113:3: ( (lv_units_0_0= ruleUnit ) )*
                    {
                    // InternalExBeeLangTestLanguageParser.g:113:3: ( (lv_units_0_0= ruleUnit ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==Unit||LA1_0==RULE_DOCUMENTATION) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:114:4: (lv_units_0_0= ruleUnit )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:114:4: (lv_units_0_0= ruleUnit )
                    	    // InternalExBeeLangTestLanguageParser.g:115:5: lv_units_0_0= ruleUnit
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
                    // InternalExBeeLangTestLanguageParser.g:133:3: ( (lv_functions_1_0= ruleFunction ) )*
                    {
                    // InternalExBeeLangTestLanguageParser.g:133:3: ( (lv_functions_1_0= ruleFunction ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==Function||LA2_0==Final||LA2_0==RULE_DOCUMENTATION||LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:134:4: (lv_functions_1_0= ruleFunction )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:134:4: (lv_functions_1_0= ruleFunction )
                    	    // InternalExBeeLangTestLanguageParser.g:135:5: lv_functions_1_0= ruleFunction
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
    // InternalExBeeLangTestLanguageParser.g:156:1: entryRuleUnit returns [EObject current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final EObject entryRuleUnit() throws RecognitionException {
        EObject current = null;
        int entryRuleUnit_StartIndex = input.index();
        EObject iv_ruleUnit = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:160:2: (iv_ruleUnit= ruleUnit EOF )
            // InternalExBeeLangTestLanguageParser.g:161:2: iv_ruleUnit= ruleUnit EOF
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
    // InternalExBeeLangTestLanguageParser.g:170:1: ruleUnit returns [EObject current=null] : ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= Unit ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= Version ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= Implements ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= RightCurlyBracket ) ;
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
            // InternalExBeeLangTestLanguageParser.g:179:2: ( ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= Unit ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= Version ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= Implements ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= RightCurlyBracket ) )
            // InternalExBeeLangTestLanguageParser.g:180:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= Unit ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= Version ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= Implements ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= RightCurlyBracket )
            {
            // InternalExBeeLangTestLanguageParser.g:180:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= Unit ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= Version ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= Implements ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= RightCurlyBracket )
            // InternalExBeeLangTestLanguageParser.g:181:3: () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= Unit ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= Version ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= Implements ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= RightCurlyBracket
            {
            // InternalExBeeLangTestLanguageParser.g:181:3: ()
            // InternalExBeeLangTestLanguageParser.g:182:4: 
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

            // InternalExBeeLangTestLanguageParser.g:191:3: ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOCUMENTATION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:192:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    {
                    // InternalExBeeLangTestLanguageParser.g:192:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    // InternalExBeeLangTestLanguageParser.g:193:5: lv_documentation_1_0= RULE_DOCUMENTATION
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

            otherlv_2=(Token)match(input,Unit,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUnitAccess().getUnitKeyword_2());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:213:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:214:4: (lv_name_3_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:214:4: (lv_name_3_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:215:5: lv_name_3_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:231:3: (otherlv_4= Version ( (lv_version_5_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Version) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:232:4: otherlv_4= Version ( (lv_version_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,Version,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getUnitAccess().getVersionKeyword_4_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:236:4: ( (lv_version_5_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:237:5: (lv_version_5_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:237:5: (lv_version_5_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:238:6: lv_version_5_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:255:3: (otherlv_6= Implements ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Implements) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:256:4: otherlv_6= Implements ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    {
                    otherlv_6=(Token)match(input,Implements,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getUnitAccess().getImplementsKeyword_5_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:260:4: ( (lv_implements_7_0= ruleSimpleTypeRef ) )
                    // InternalExBeeLangTestLanguageParser.g:261:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    {
                    // InternalExBeeLangTestLanguageParser.g:261:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    // InternalExBeeLangTestLanguageParser.g:262:6: lv_implements_7_0= ruleSimpleTypeRef
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

                    // InternalExBeeLangTestLanguageParser.g:279:4: (otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==Comma) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:280:5: otherlv_8= Comma ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    {
                    	    otherlv_8=(Token)match(input,Comma,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getUnitAccess().getCommaKeyword_5_2_0());
                    	      				
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:284:5: ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    // InternalExBeeLangTestLanguageParser.g:285:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:285:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    // InternalExBeeLangTestLanguageParser.g:286:7: lv_implements_9_0= ruleSimpleTypeRef
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

            otherlv_10=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getUnitAccess().getLeftCurlyBracketKeyword_6());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:309:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // InternalExBeeLangTestLanguageParser.g:310:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // InternalExBeeLangTestLanguageParser.g:310:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:311:5: ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getUnitAccess().getUnorderedGroup_7());
            // InternalExBeeLangTestLanguageParser.g:314:5: ( ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:315:6: ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            {
            // InternalExBeeLangTestLanguageParser.g:315:6: ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=7;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:316:4: ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:316:4: ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:317:5: {...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:317:101: ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:318:6: ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
            	    // InternalExBeeLangTestLanguageParser.g:321:9: ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:321:10: {...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:321:19: (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:321:20: otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon
            	    {
            	    otherlv_12=(Token)match(input,Source,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_12, grammarAccess.getUnitAccess().getSourceKeyword_7_0_0());
            	      								
            	    }
            	    otherlv_13=(Token)match(input,Colon,FollowSets000.FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_13, grammarAccess.getUnitAccess().getColonKeyword_7_0_1());
            	      								
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:329:9: ( (lv_sourceLocation_14_0= rulePath ) )
            	    // InternalExBeeLangTestLanguageParser.g:330:10: (lv_sourceLocation_14_0= rulePath )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:330:10: (lv_sourceLocation_14_0= rulePath )
            	    // InternalExBeeLangTestLanguageParser.g:331:11: lv_sourceLocation_14_0= rulePath
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

            	    otherlv_15=(Token)match(input,Semicolon,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:358:4: ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:358:4: ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:359:5: {...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:359:101: ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:360:6: ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
            	    // InternalExBeeLangTestLanguageParser.g:363:9: ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:363:10: {...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:363:19: (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:363:20: otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon
            	    {
            	    otherlv_16=(Token)match(input,Output,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_16, grammarAccess.getUnitAccess().getOutputKeyword_7_1_0());
            	      								
            	    }
            	    otherlv_17=(Token)match(input,Colon,FollowSets000.FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									newLeafNode(otherlv_17, grammarAccess.getUnitAccess().getColonKeyword_7_1_1());
            	      								
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:371:9: ( (lv_outputLocation_18_0= rulePath ) )
            	    // InternalExBeeLangTestLanguageParser.g:372:10: (lv_outputLocation_18_0= rulePath )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:372:10: (lv_outputLocation_18_0= rulePath )
            	    // InternalExBeeLangTestLanguageParser.g:373:11: lv_outputLocation_18_0= rulePath
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

            	    otherlv_19=(Token)match(input,Semicolon,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:400:4: ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:400:4: ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) )
            	    // InternalExBeeLangTestLanguageParser.g:401:5: {...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:401:101: ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ )
            	    // InternalExBeeLangTestLanguageParser.g:402:6: ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
            	    // InternalExBeeLangTestLanguageParser.g:405:9: ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==Provides) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((synpred11_InternalExBeeLangTestLanguageParser()&&(true))) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalExBeeLangTestLanguageParser.g:405:10: {...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalExBeeLangTestLanguageParser.g:405:19: (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon )
            	    	    // InternalExBeeLangTestLanguageParser.g:405:20: otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon
            	    	    {
            	    	    otherlv_20=(Token)match(input,Provides,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_20, grammarAccess.getUnitAccess().getProvidesKeyword_7_2_0());
            	    	      								
            	    	    }
            	    	    otherlv_21=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_21, grammarAccess.getUnitAccess().getColonKeyword_7_2_1());
            	    	      								
            	    	    }
            	    	    // InternalExBeeLangTestLanguageParser.g:413:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
            	    	    // InternalExBeeLangTestLanguageParser.g:414:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    {
            	    	    // InternalExBeeLangTestLanguageParser.g:414:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    // InternalExBeeLangTestLanguageParser.g:415:11: lv_providedCapabilities_22_0= ruleProvidedCapability
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

            	    	    otherlv_23=(Token)match(input,Semicolon,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:442:4: ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:442:4: ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) )
            	    // InternalExBeeLangTestLanguageParser.g:443:5: {...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:443:101: ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ )
            	    // InternalExBeeLangTestLanguageParser.g:444:6: ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
            	    // InternalExBeeLangTestLanguageParser.g:447:9: ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==Requires) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((synpred13_InternalExBeeLangTestLanguageParser()&&(true))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalExBeeLangTestLanguageParser.g:447:10: {...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalExBeeLangTestLanguageParser.g:447:19: (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon )
            	    	    // InternalExBeeLangTestLanguageParser.g:447:20: otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon
            	    	    {
            	    	    otherlv_24=(Token)match(input,Requires,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_24, grammarAccess.getUnitAccess().getRequiresKeyword_7_3_0());
            	    	      								
            	    	    }
            	    	    otherlv_25=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_25, grammarAccess.getUnitAccess().getColonKeyword_7_3_1());
            	    	      								
            	    	    }
            	    	    // InternalExBeeLangTestLanguageParser.g:455:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
            	    	    // InternalExBeeLangTestLanguageParser.g:456:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    {
            	    	    // InternalExBeeLangTestLanguageParser.g:456:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    // InternalExBeeLangTestLanguageParser.g:457:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
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

            	    	    otherlv_27=(Token)match(input,Semicolon,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:484:4: ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:484:4: ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) )
            	    // InternalExBeeLangTestLanguageParser.g:485:5: {...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:485:101: ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ )
            	    // InternalExBeeLangTestLanguageParser.g:486:6: ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
            	    // InternalExBeeLangTestLanguageParser.g:489:9: ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==Requires) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((synpred15_InternalExBeeLangTestLanguageParser()&&(true))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalExBeeLangTestLanguageParser.g:489:10: {...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalExBeeLangTestLanguageParser.g:489:19: (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon )
            	    	    // InternalExBeeLangTestLanguageParser.g:489:20: otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon
            	    	    {
            	    	    otherlv_28=(Token)match(input,Requires,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_28, grammarAccess.getUnitAccess().getRequiresKeyword_7_4_0());
            	    	      								
            	    	    }
            	    	    otherlv_29=(Token)match(input,Env,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_29, grammarAccess.getUnitAccess().getEnvKeyword_7_4_1());
            	    	      								
            	    	    }
            	    	    otherlv_30=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									newLeafNode(otherlv_30, grammarAccess.getUnitAccess().getColonKeyword_7_4_2());
            	    	      								
            	    	    }
            	    	    // InternalExBeeLangTestLanguageParser.g:501:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
            	    	    // InternalExBeeLangTestLanguageParser.g:502:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    {
            	    	    // InternalExBeeLangTestLanguageParser.g:502:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    // InternalExBeeLangTestLanguageParser.g:503:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
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

            	    	    otherlv_32=(Token)match(input,Semicolon,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    // InternalExBeeLangTestLanguageParser.g:531:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:531:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    // InternalExBeeLangTestLanguageParser.g:532:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
            	    // InternalExBeeLangTestLanguageParser.g:535:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        switch ( input.LA(1) ) {
            	        case RULE_DOCUMENTATION:
            	            {
            	            int LA12_2 = input.LA(2);

            	            if ( ((synpred17_InternalExBeeLangTestLanguageParser()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA12_3 = input.LA(2);

            	            if ( ((synpred17_InternalExBeeLangTestLanguageParser()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case Final:
            	            {
            	            int LA12_4 = input.LA(2);

            	            if ( ((synpred17_InternalExBeeLangTestLanguageParser()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case Function:
            	            {
            	            int LA12_5 = input.LA(2);

            	            if ( ((synpred17_InternalExBeeLangTestLanguageParser()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalExBeeLangTestLanguageParser.g:535:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // InternalExBeeLangTestLanguageParser.g:535:19: ( (lv_functions_33_0= ruleFunction ) )
            	    	    // InternalExBeeLangTestLanguageParser.g:535:20: (lv_functions_33_0= ruleFunction )
            	    	    {
            	    	    // InternalExBeeLangTestLanguageParser.g:535:20: (lv_functions_33_0= ruleFunction )
            	    	    // InternalExBeeLangTestLanguageParser.g:536:10: lv_functions_33_0= ruleFunction
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

            otherlv_34=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:576:1: entryRuleProvidedCapability returns [EObject current=null] : iv_ruleProvidedCapability= ruleProvidedCapability EOF ;
    public final EObject entryRuleProvidedCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleProvidedCapability_StartIndex = input.index();
        EObject iv_ruleProvidedCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:580:2: (iv_ruleProvidedCapability= ruleProvidedCapability EOF )
            // InternalExBeeLangTestLanguageParser.g:581:2: iv_ruleProvidedCapability= ruleProvidedCapability EOF
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
    // InternalExBeeLangTestLanguageParser.g:590:1: ruleProvidedCapability returns [EObject current=null] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) (otherlv_3= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) ) otherlv_17= RightCurlyBracket )? ) ;
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
            // InternalExBeeLangTestLanguageParser.g:599:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) (otherlv_3= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) ) otherlv_17= RightCurlyBracket )? ) )
            // InternalExBeeLangTestLanguageParser.g:600:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) (otherlv_3= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) ) otherlv_17= RightCurlyBracket )? )
            {
            // InternalExBeeLangTestLanguageParser.g:600:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) (otherlv_3= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) ) otherlv_17= RightCurlyBracket )? )
            // InternalExBeeLangTestLanguageParser.g:601:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) (otherlv_3= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) ) otherlv_17= RightCurlyBracket )?
            {
            // InternalExBeeLangTestLanguageParser.g:601:3: ()
            // InternalExBeeLangTestLanguageParser.g:602:4: 
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

            // InternalExBeeLangTestLanguageParser.g:611:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==Unit) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:612:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:612:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:613:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:613:5: (lv_nameSpace_1_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:614:6: lv_nameSpace_1_0= RULE_ID
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
                    // InternalExBeeLangTestLanguageParser.g:631:4: otherlv_2= Unit
                    {
                    otherlv_2=(Token)match(input,Unit,FollowSets000.FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getProvidedCapabilityAccess().getUnitKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:636:3: (otherlv_3= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) ) otherlv_17= RightCurlyBracket )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LeftCurlyBracket) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:637:4: otherlv_3= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) ) otherlv_17= RightCurlyBracket
                    {
                    otherlv_3=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getProvidedCapabilityAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:641:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) ) )
                    // InternalExBeeLangTestLanguageParser.g:642:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:642:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?) )
                    // InternalExBeeLangTestLanguageParser.g:643:6: ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?)
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());
                    // InternalExBeeLangTestLanguageParser.g:646:6: ( ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?)
                    // InternalExBeeLangTestLanguageParser.g:647:7: ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+ {...}?
                    {
                    // InternalExBeeLangTestLanguageParser.g:647:7: ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=4;
                        int LA15_0 = input.LA(1);

                        if ( LA15_0 == When && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                            alt15=1;
                        }
                        else if ( LA15_0 == Name && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                            alt15=2;
                        }
                        else if ( LA15_0 == Version && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                            alt15=3;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:648:5: ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:648:5: ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) )
                    	    // InternalExBeeLangTestLanguageParser.g:649:6: {...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:649:118: ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) )
                    	    // InternalExBeeLangTestLanguageParser.g:650:7: ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
                    	    // InternalExBeeLangTestLanguageParser.g:653:10: ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) )
                    	    // InternalExBeeLangTestLanguageParser.g:653:11: {...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:653:20: (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon )
                    	    // InternalExBeeLangTestLanguageParser.g:653:21: otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon
                    	    {
                    	    otherlv_5=(Token)match(input,When,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_5, grammarAccess.getProvidedCapabilityAccess().getWhenKeyword_2_1_0_0());
                    	      									
                    	    }
                    	    otherlv_6=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_6, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_0_1());
                    	      									
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:661:10: ( (lv_condExpr_7_0= ruleExpression ) )
                    	    // InternalExBeeLangTestLanguageParser.g:662:11: (lv_condExpr_7_0= ruleExpression )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:662:11: (lv_condExpr_7_0= ruleExpression )
                    	    // InternalExBeeLangTestLanguageParser.g:663:12: lv_condExpr_7_0= ruleExpression
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

                    	    otherlv_8=(Token)match(input,Semicolon,FollowSets000.FOLLOW_20); if (state.failed) return current;
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
                    	    // InternalExBeeLangTestLanguageParser.g:690:5: ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:690:5: ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) )
                    	    // InternalExBeeLangTestLanguageParser.g:691:6: {...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:691:118: ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) )
                    	    // InternalExBeeLangTestLanguageParser.g:692:7: ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
                    	    // InternalExBeeLangTestLanguageParser.g:695:10: ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) )
                    	    // InternalExBeeLangTestLanguageParser.g:695:11: {...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:695:20: (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon )
                    	    // InternalExBeeLangTestLanguageParser.g:695:21: otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon
                    	    {
                    	    otherlv_9=(Token)match(input,Name,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_9, grammarAccess.getProvidedCapabilityAccess().getNameKeyword_2_1_1_0());
                    	      									
                    	    }
                    	    otherlv_10=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_10, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_1_1());
                    	      									
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:703:10: ( (lv_name_11_0= RULE_ID ) )
                    	    // InternalExBeeLangTestLanguageParser.g:704:11: (lv_name_11_0= RULE_ID )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:704:11: (lv_name_11_0= RULE_ID )
                    	    // InternalExBeeLangTestLanguageParser.g:705:12: lv_name_11_0= RULE_ID
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

                    	    otherlv_12=(Token)match(input,Semicolon,FollowSets000.FOLLOW_20); if (state.failed) return current;
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
                    	    // InternalExBeeLangTestLanguageParser.g:731:5: ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:731:5: ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) )
                    	    // InternalExBeeLangTestLanguageParser.g:732:6: {...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:732:118: ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) )
                    	    // InternalExBeeLangTestLanguageParser.g:733:7: ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
                    	    // InternalExBeeLangTestLanguageParser.g:736:10: ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) )
                    	    // InternalExBeeLangTestLanguageParser.g:736:11: {...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:736:20: (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon )
                    	    // InternalExBeeLangTestLanguageParser.g:736:21: otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon
                    	    {
                    	    otherlv_13=(Token)match(input,Version,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_13, grammarAccess.getProvidedCapabilityAccess().getVersionKeyword_2_1_2_0());
                    	      									
                    	    }
                    	    otherlv_14=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										newLeafNode(otherlv_14, grammarAccess.getProvidedCapabilityAccess().getColonKeyword_2_1_2_1());
                    	      									
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:744:10: ( (lv_version_15_0= RULE_ID ) )
                    	    // InternalExBeeLangTestLanguageParser.g:745:11: (lv_version_15_0= RULE_ID )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:745:11: (lv_version_15_0= RULE_ID )
                    	    // InternalExBeeLangTestLanguageParser.g:746:12: lv_version_15_0= RULE_ID
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

                    	    otherlv_16=(Token)match(input,Semicolon,FollowSets000.FOLLOW_20); if (state.failed) return current;
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

                    otherlv_17=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:792:1: entryRuleAliasedRequiredCapability returns [EObject current=null] : iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF ;
    public final EObject entryRuleAliasedRequiredCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleAliasedRequiredCapability_StartIndex = input.index();
        EObject iv_ruleAliasedRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:796:2: (iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF )
            // InternalExBeeLangTestLanguageParser.g:797:2: iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF
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
    // InternalExBeeLangTestLanguageParser.g:806:1: ruleAliasedRequiredCapability returns [EObject current=null] : ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= Unit ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) ) otherlv_25= RightCurlyBracket ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:815:2: ( ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= Unit ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) ) otherlv_25= RightCurlyBracket ) ) )
            // InternalExBeeLangTestLanguageParser.g:816:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= Unit ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) ) otherlv_25= RightCurlyBracket ) )
            {
            // InternalExBeeLangTestLanguageParser.g:816:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= Unit ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) ) otherlv_25= RightCurlyBracket ) )
            // InternalExBeeLangTestLanguageParser.g:817:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= Unit ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) ) otherlv_25= RightCurlyBracket )
            {
            // InternalExBeeLangTestLanguageParser.g:817:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= Unit )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==Unit) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:818:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:818:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:819:5: (lv_nameSpace_0_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:819:5: (lv_nameSpace_0_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:820:6: lv_nameSpace_0_0= RULE_ID
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
                    // InternalExBeeLangTestLanguageParser.g:837:4: otherlv_1= Unit
                    {
                    otherlv_1=(Token)match(input,Unit,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAliasedRequiredCapabilityAccess().getUnitKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:842:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:843:4: (lv_name_2_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:843:4: (lv_name_2_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:844:5: lv_name_2_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:860:3: (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==As) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:861:4: otherlv_3= As ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,As,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAliasedRequiredCapabilityAccess().getAsKeyword_2_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:865:4: ( (lv_alias_4_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:866:5: (lv_alias_4_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:866:5: (lv_alias_4_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:867:6: lv_alias_4_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:884:3: (otherlv_5= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) ) otherlv_25= RightCurlyBracket )
            // InternalExBeeLangTestLanguageParser.g:885:4: otherlv_5= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) ) otherlv_25= RightCurlyBracket
            {
            otherlv_5=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getAliasedRequiredCapabilityAccess().getLeftCurlyBracketKeyword_3_0());
              			
            }
            // InternalExBeeLangTestLanguageParser.g:889:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) ) )
            // InternalExBeeLangTestLanguageParser.g:890:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) )
            {
            // InternalExBeeLangTestLanguageParser.g:890:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:891:6: ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // InternalExBeeLangTestLanguageParser.g:894:6: ( ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:895:7: ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )*
            {
            // InternalExBeeLangTestLanguageParser.g:895:7: ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )*
            loop19:
            do {
                int alt19=6;
                int LA19_0 = input.LA(1);

                if ( LA19_0 == When && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
                    alt19=1;
                }
                else if ( LA19_0 == Greedy && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
                    alt19=2;
                }
                else if ( LA19_0 == RequiresMin && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
                    alt19=3;
                }
                else if ( LA19_0 == RequiresMax && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
                    alt19=4;
                }
                else if ( LA19_0 == Version && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
                    alt19=5;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:896:5: ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:896:5: ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:897:6: {...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:897:125: ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:898:7: ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // InternalExBeeLangTestLanguageParser.g:901:10: ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:901:11: {...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:901:20: (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:901:21: otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon
            	    {
            	    otherlv_7=(Token)match(input,When,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_7, grammarAccess.getAliasedRequiredCapabilityAccess().getWhenKeyword_3_1_0_0());
            	      									
            	    }
            	    otherlv_8=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_8, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_0_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:909:10: ( (lv_condExpr_9_0= ruleExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:910:11: (lv_condExpr_9_0= ruleExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:910:11: (lv_condExpr_9_0= ruleExpression )
            	    // InternalExBeeLangTestLanguageParser.g:911:12: lv_condExpr_9_0= ruleExpression
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

            	    otherlv_10=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:938:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:938:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:939:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:939:125: ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:940:7: ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // InternalExBeeLangTestLanguageParser.g:943:10: ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:943:11: {...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:943:20: ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:943:21: ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:943:21: ( (lv_greedy_11_0= Greedy ) )
            	    // InternalExBeeLangTestLanguageParser.g:944:11: (lv_greedy_11_0= Greedy )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:944:11: (lv_greedy_11_0= Greedy )
            	    // InternalExBeeLangTestLanguageParser.g:945:12: lv_greedy_11_0= Greedy
            	    {
            	    lv_greedy_11_0=(Token)match(input,Greedy,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_greedy_11_0, grammarAccess.getAliasedRequiredCapabilityAccess().getGreedyGreedyKeyword_3_1_1_0_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getAliasedRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(current, "greedy", lv_greedy_11_0 != null, "greedy");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_12=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:967:5: ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:967:5: ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:968:6: {...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:968:125: ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:969:7: ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // InternalExBeeLangTestLanguageParser.g:972:10: ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:972:11: {...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:972:20: (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:972:21: otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon
            	    {
            	    otherlv_13=(Token)match(input,RequiresMin,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_13, grammarAccess.getAliasedRequiredCapabilityAccess().getRequiresMinKeyword_3_1_2_0());
            	      									
            	    }
            	    otherlv_14=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_14, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_2_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:980:10: ( (lv_min_15_0= RULE_INT ) )
            	    // InternalExBeeLangTestLanguageParser.g:981:11: (lv_min_15_0= RULE_INT )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:981:11: (lv_min_15_0= RULE_INT )
            	    // InternalExBeeLangTestLanguageParser.g:982:12: lv_min_15_0= RULE_INT
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

            	    otherlv_16=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:1008:5: ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1008:5: ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1009:6: {...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1009:125: ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1010:7: ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // InternalExBeeLangTestLanguageParser.g:1013:10: ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:1013:11: {...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1013:20: (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:1013:21: otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon
            	    {
            	    otherlv_17=(Token)match(input,RequiresMax,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_17, grammarAccess.getAliasedRequiredCapabilityAccess().getRequiresMaxKeyword_3_1_3_0());
            	      									
            	    }
            	    otherlv_18=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_18, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_3_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1021:10: ( (lv_max_19_0= RULE_INT ) )
            	    // InternalExBeeLangTestLanguageParser.g:1022:11: (lv_max_19_0= RULE_INT )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1022:11: (lv_max_19_0= RULE_INT )
            	    // InternalExBeeLangTestLanguageParser.g:1023:12: lv_max_19_0= RULE_INT
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

            	    otherlv_20=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:1049:5: ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1049:5: ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1050:6: {...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1050:125: ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1051:7: ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // InternalExBeeLangTestLanguageParser.g:1054:10: ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:1054:11: {...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1054:20: (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:1054:21: otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon
            	    {
            	    otherlv_21=(Token)match(input,Version,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_21, grammarAccess.getAliasedRequiredCapabilityAccess().getVersionKeyword_3_1_4_0());
            	      									
            	    }
            	    otherlv_22=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_22, grammarAccess.getAliasedRequiredCapabilityAccess().getColonKeyword_3_1_4_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1062:10: ( (lv_versionRange_23_0= RULE_ID ) )
            	    // InternalExBeeLangTestLanguageParser.g:1063:11: (lv_versionRange_23_0= RULE_ID )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1063:11: (lv_versionRange_23_0= RULE_ID )
            	    // InternalExBeeLangTestLanguageParser.g:1064:12: lv_versionRange_23_0= RULE_ID
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

            	    otherlv_24=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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

            otherlv_25=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:1109:1: entryRuleRequiredCapability returns [EObject current=null] : iv_ruleRequiredCapability= ruleRequiredCapability EOF ;
    public final EObject entryRuleRequiredCapability() throws RecognitionException {
        EObject current = null;
        int entryRuleRequiredCapability_StartIndex = input.index();
        EObject iv_ruleRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1113:2: (iv_ruleRequiredCapability= ruleRequiredCapability EOF )
            // InternalExBeeLangTestLanguageParser.g:1114:2: iv_ruleRequiredCapability= ruleRequiredCapability EOF
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
    // InternalExBeeLangTestLanguageParser.g:1123:1: ruleRequiredCapability returns [EObject current=null] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) ) otherlv_24= RightCurlyBracket ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:1132:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) ) otherlv_24= RightCurlyBracket ) ) )
            // InternalExBeeLangTestLanguageParser.g:1133:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) ) otherlv_24= RightCurlyBracket ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1133:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) ) otherlv_24= RightCurlyBracket ) )
            // InternalExBeeLangTestLanguageParser.g:1134:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) ) otherlv_24= RightCurlyBracket )
            {
            // InternalExBeeLangTestLanguageParser.g:1134:3: ()
            // InternalExBeeLangTestLanguageParser.g:1135:4: 
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

            // InternalExBeeLangTestLanguageParser.g:1144:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= Unit )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==Unit) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:1145:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1145:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:1146:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1146:5: (lv_nameSpace_1_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:1147:6: lv_nameSpace_1_0= RULE_ID
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
                    // InternalExBeeLangTestLanguageParser.g:1164:4: otherlv_2= Unit
                    {
                    otherlv_2=(Token)match(input,Unit,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRequiredCapabilityAccess().getUnitKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:1169:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:1170:4: (lv_name_3_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:1170:4: (lv_name_3_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:1171:5: lv_name_3_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:1187:3: (otherlv_4= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) ) otherlv_24= RightCurlyBracket )
            // InternalExBeeLangTestLanguageParser.g:1188:4: otherlv_4= LeftCurlyBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) ) otherlv_24= RightCurlyBracket
            {
            otherlv_4=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getRequiredCapabilityAccess().getLeftCurlyBracketKeyword_3_0());
              			
            }
            // InternalExBeeLangTestLanguageParser.g:1192:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) ) )
            // InternalExBeeLangTestLanguageParser.g:1193:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1193:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:1194:6: ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // InternalExBeeLangTestLanguageParser.g:1197:6: ( ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:1198:7: ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )*
            {
            // InternalExBeeLangTestLanguageParser.g:1198:7: ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )*
            loop21:
            do {
                int alt21=6;
                int LA21_0 = input.LA(1);

                if ( LA21_0 == When && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
                    alt21=1;
                }
                else if ( LA21_0 == Greedy && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
                    alt21=2;
                }
                else if ( LA21_0 == RequiresMin && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
                    alt21=3;
                }
                else if ( LA21_0 == RequiresMax && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
                    alt21=4;
                }
                else if ( LA21_0 == Version && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
                    alt21=5;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:1199:5: ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1199:5: ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1200:6: {...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1200:118: ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1201:7: ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // InternalExBeeLangTestLanguageParser.g:1204:10: ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:1204:11: {...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1204:20: (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:1204:21: otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon
            	    {
            	    otherlv_6=(Token)match(input,When,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_6, grammarAccess.getRequiredCapabilityAccess().getWhenKeyword_3_1_0_0());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_7, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_0_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1212:10: ( (lv_condExpr_8_0= ruleExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:1213:11: (lv_condExpr_8_0= ruleExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1213:11: (lv_condExpr_8_0= ruleExpression )
            	    // InternalExBeeLangTestLanguageParser.g:1214:12: lv_condExpr_8_0= ruleExpression
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

            	    otherlv_9=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:1241:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1241:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1242:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1242:118: ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1243:7: ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // InternalExBeeLangTestLanguageParser.g:1246:10: ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:1246:11: {...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1246:20: ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:1246:21: ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1246:21: ( (lv_greedy_10_0= Greedy ) )
            	    // InternalExBeeLangTestLanguageParser.g:1247:11: (lv_greedy_10_0= Greedy )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1247:11: (lv_greedy_10_0= Greedy )
            	    // InternalExBeeLangTestLanguageParser.g:1248:12: lv_greedy_10_0= Greedy
            	    {
            	    lv_greedy_10_0=(Token)match(input,Greedy,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												newLeafNode(lv_greedy_10_0, grammarAccess.getRequiredCapabilityAccess().getGreedyGreedyKeyword_3_1_1_0_0());
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (current==null) {
            	      													current = createModelElement(grammarAccess.getRequiredCapabilityRule());
            	      												}
            	      												setWithLastConsumed(current, "greedy", lv_greedy_10_0 != null, "greedy");
            	      											
            	    }

            	    }


            	    }

            	    otherlv_11=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:1270:5: ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1270:5: ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1271:6: {...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1271:118: ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1272:7: ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // InternalExBeeLangTestLanguageParser.g:1275:10: ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:1275:11: {...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1275:20: (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:1275:21: otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon
            	    {
            	    otherlv_12=(Token)match(input,RequiresMin,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_12, grammarAccess.getRequiredCapabilityAccess().getRequiresMinKeyword_3_1_2_0());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_13, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_2_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1283:10: ( (lv_min_14_0= RULE_INT ) )
            	    // InternalExBeeLangTestLanguageParser.g:1284:11: (lv_min_14_0= RULE_INT )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1284:11: (lv_min_14_0= RULE_INT )
            	    // InternalExBeeLangTestLanguageParser.g:1285:12: lv_min_14_0= RULE_INT
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

            	    otherlv_15=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:1311:5: ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1311:5: ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1312:6: {...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1312:118: ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1313:7: ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // InternalExBeeLangTestLanguageParser.g:1316:10: ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:1316:11: {...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1316:20: (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:1316:21: otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon
            	    {
            	    otherlv_16=(Token)match(input,RequiresMax,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_16, grammarAccess.getRequiredCapabilityAccess().getRequiresMaxKeyword_3_1_3_0());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_17, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_3_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1324:10: ( (lv_max_18_0= RULE_INT ) )
            	    // InternalExBeeLangTestLanguageParser.g:1325:11: (lv_max_18_0= RULE_INT )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1325:11: (lv_max_18_0= RULE_INT )
            	    // InternalExBeeLangTestLanguageParser.g:1326:12: lv_max_18_0= RULE_INT
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

            	    otherlv_19=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:1352:5: ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1352:5: ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1353:6: {...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1353:118: ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:1354:7: ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // InternalExBeeLangTestLanguageParser.g:1357:10: ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) )
            	    // InternalExBeeLangTestLanguageParser.g:1357:11: {...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1357:20: (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon )
            	    // InternalExBeeLangTestLanguageParser.g:1357:21: otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon
            	    {
            	    otherlv_20=(Token)match(input,Version,FollowSets000.FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_20, grammarAccess.getRequiredCapabilityAccess().getVersionKeyword_3_1_4_0());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										newLeafNode(otherlv_21, grammarAccess.getRequiredCapabilityAccess().getColonKeyword_3_1_4_1());
            	      									
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1365:10: ( (lv_versionRange_22_0= RULE_ID ) )
            	    // InternalExBeeLangTestLanguageParser.g:1366:11: (lv_versionRange_22_0= RULE_ID )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1366:11: (lv_versionRange_22_0= RULE_ID )
            	    // InternalExBeeLangTestLanguageParser.g:1367:12: lv_versionRange_22_0= RULE_ID
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

            	    otherlv_23=(Token)match(input,Semicolon,FollowSets000.FOLLOW_23); if (state.failed) return current;
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

            otherlv_24=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:1412:1: entryRulePath returns [String current=null] : iv_rulePath= rulePath EOF ;
    public final String entryRulePath() throws RecognitionException {
        String current = null;
        int entryRulePath_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_rulePath = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1414:2: (iv_rulePath= rulePath EOF )
            // InternalExBeeLangTestLanguageParser.g:1415:2: iv_rulePath= rulePath EOF
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
    // InternalExBeeLangTestLanguageParser.g:1424:1: rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | ( (kw= Solidus )? this_QID_2= ruleQID (kw= Solidus this_QID_4= ruleQID )* (kw= Solidus )? ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:1431:2: ( (this_STRING_0= RULE_STRING | ( (kw= Solidus )? this_QID_2= ruleQID (kw= Solidus this_QID_4= ruleQID )* (kw= Solidus )? ) ) )
            // InternalExBeeLangTestLanguageParser.g:1432:2: (this_STRING_0= RULE_STRING | ( (kw= Solidus )? this_QID_2= ruleQID (kw= Solidus this_QID_4= ruleQID )* (kw= Solidus )? ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1432:2: (this_STRING_0= RULE_STRING | ( (kw= Solidus )? this_QID_2= ruleQID (kw= Solidus this_QID_4= ruleQID )* (kw= Solidus )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_STRING) ) {
                alt25=1;
            }
            else if ( (LA25_0==Solidus||LA25_0==RULE_ID) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:1433:3: this_STRING_0= RULE_STRING
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
                    // InternalExBeeLangTestLanguageParser.g:1441:3: ( (kw= Solidus )? this_QID_2= ruleQID (kw= Solidus this_QID_4= ruleQID )* (kw= Solidus )? )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1441:3: ( (kw= Solidus )? this_QID_2= ruleQID (kw= Solidus this_QID_4= ruleQID )* (kw= Solidus )? )
                    // InternalExBeeLangTestLanguageParser.g:1442:4: (kw= Solidus )? this_QID_2= ruleQID (kw= Solidus this_QID_4= ruleQID )* (kw= Solidus )?
                    {
                    // InternalExBeeLangTestLanguageParser.g:1442:4: (kw= Solidus )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==Solidus) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalExBeeLangTestLanguageParser.g:1443:5: kw= Solidus
                            {
                            kw=(Token)match(input,Solidus,FollowSets000.FOLLOW_13); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:1459:4: (kw= Solidus this_QID_4= ruleQID )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==Solidus) ) {
                            int LA23_1 = input.LA(2);

                            if ( (LA23_1==RULE_ID) ) {
                                alt23=1;
                            }


                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:1460:5: kw= Solidus this_QID_4= ruleQID
                    	    {
                    	    kw=(Token)match(input,Solidus,FollowSets000.FOLLOW_13); if (state.failed) return current;
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

                    // InternalExBeeLangTestLanguageParser.g:1476:4: (kw= Solidus )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==Solidus) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalExBeeLangTestLanguageParser.g:1477:5: kw= Solidus
                            {
                            kw=(Token)match(input,Solidus,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:1491:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;
        int entryRuleParameterList_StartIndex = input.index();
        EObject iv_ruleParameterList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1491:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalExBeeLangTestLanguageParser.g:1492:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalExBeeLangTestLanguageParser.g:1498:1: ruleParameterList returns [EObject current=null] : ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= Comma ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;
        int ruleParameterList_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1504:2: ( ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= Comma ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:1505:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= Comma ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:1505:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= Comma ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:1506:3: ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= Comma ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            {
            // InternalExBeeLangTestLanguageParser.g:1506:3: ( (lv_parameters_0_0= ruleFirstParameter ) )
            // InternalExBeeLangTestLanguageParser.g:1507:4: (lv_parameters_0_0= ruleFirstParameter )
            {
            // InternalExBeeLangTestLanguageParser.g:1507:4: (lv_parameters_0_0= ruleFirstParameter )
            // InternalExBeeLangTestLanguageParser.g:1508:5: lv_parameters_0_0= ruleFirstParameter
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

            // InternalExBeeLangTestLanguageParser.g:1525:3: (otherlv_1= Comma ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==Comma) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:1526:4: otherlv_1= Comma ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,Comma,FollowSets000.FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:1530:4: ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    // InternalExBeeLangTestLanguageParser.g:1531:5: (lv_parameters_2_0= ruleFirstParameter )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:1531:5: (lv_parameters_2_0= ruleFirstParameter )
            	    // InternalExBeeLangTestLanguageParser.g:1532:6: lv_parameters_2_0= ruleFirstParameter
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
    // InternalExBeeLangTestLanguageParser.g:1554:1: entryRuleFirstParameter returns [EObject current=null] : iv_ruleFirstParameter= ruleFirstParameter EOF ;
    public final EObject entryRuleFirstParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleFirstParameter_StartIndex = input.index();
        EObject iv_ruleFirstParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1554:55: (iv_ruleFirstParameter= ruleFirstParameter EOF )
            // InternalExBeeLangTestLanguageParser.g:1555:2: iv_ruleFirstParameter= ruleFirstParameter EOF
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
    // InternalExBeeLangTestLanguageParser.g:1561:1: ruleFirstParameter returns [EObject current=null] : (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) ;
    public final EObject ruleFirstParameter() throws RecognitionException {
        EObject current = null;
        int ruleFirstParameter_StartIndex = input.index();
        EObject this_ClosureParameter_0 = null;

        EObject this_Parameter_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1567:2: ( (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) )
            // InternalExBeeLangTestLanguageParser.g:1568:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            {
            // InternalExBeeLangTestLanguageParser.g:1568:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1569:3: this_ClosureParameter_0= ruleClosureParameter
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
                    // InternalExBeeLangTestLanguageParser.g:1581:3: this_Parameter_1= ruleParameter
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
    // InternalExBeeLangTestLanguageParser.g:1596:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleParameter_StartIndex = input.index();
        EObject iv_ruleParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1596:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalExBeeLangTestLanguageParser.g:1597:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalExBeeLangTestLanguageParser.g:1603:1: ruleParameter returns [EObject current=null] : ( (lv_expr_0_0= ruleExpression ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;
        int ruleParameter_StartIndex = input.index();
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1609:2: ( ( (lv_expr_0_0= ruleExpression ) ) )
            // InternalExBeeLangTestLanguageParser.g:1610:2: ( (lv_expr_0_0= ruleExpression ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1610:2: ( (lv_expr_0_0= ruleExpression ) )
            // InternalExBeeLangTestLanguageParser.g:1611:3: (lv_expr_0_0= ruleExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:1611:3: (lv_expr_0_0= ruleExpression )
            // InternalExBeeLangTestLanguageParser.g:1612:4: lv_expr_0_0= ruleExpression
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
    // InternalExBeeLangTestLanguageParser.g:1632:1: entryRuleClosureParameter returns [EObject current=null] : iv_ruleClosureParameter= ruleClosureParameter EOF ;
    public final EObject entryRuleClosureParameter() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureParameter_StartIndex = input.index();
        EObject iv_ruleClosureParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1632:57: (iv_ruleClosureParameter= ruleClosureParameter EOF )
            // InternalExBeeLangTestLanguageParser.g:1633:2: iv_ruleClosureParameter= ruleClosureParameter EOF
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
    // InternalExBeeLangTestLanguageParser.g:1639:1: ruleClosureParameter returns [EObject current=null] : ( (lv_expr_0_0= ruleClosureExpression ) ) ;
    public final EObject ruleClosureParameter() throws RecognitionException {
        EObject current = null;
        int ruleClosureParameter_StartIndex = input.index();
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1645:2: ( ( (lv_expr_0_0= ruleClosureExpression ) ) )
            // InternalExBeeLangTestLanguageParser.g:1646:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1646:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            // InternalExBeeLangTestLanguageParser.g:1647:3: (lv_expr_0_0= ruleClosureExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:1647:3: (lv_expr_0_0= ruleClosureExpression )
            // InternalExBeeLangTestLanguageParser.g:1648:4: lv_expr_0_0= ruleClosureExpression
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
    // InternalExBeeLangTestLanguageParser.g:1668:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleParameterDeclaration_StartIndex = input.index();
        EObject iv_ruleParameterDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1668:61: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // InternalExBeeLangTestLanguageParser.g:1669:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
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
    // InternalExBeeLangTestLanguageParser.g:1675:1: ruleParameterDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;
        int ruleParameterDeclaration_StartIndex = input.index();
        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1681:2: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:1682:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1682:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // InternalExBeeLangTestLanguageParser.g:1683:3: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1683:3: ( (lv_type_0_0= ruleTypeRef ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==LeftParenthesis) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID) ) {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==LessThanSign||LA28_2==RULE_ID) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1684:4: (lv_type_0_0= ruleTypeRef )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1684:4: (lv_type_0_0= ruleTypeRef )
                    // InternalExBeeLangTestLanguageParser.g:1685:5: lv_type_0_0= ruleTypeRef
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

            // InternalExBeeLangTestLanguageParser.g:1702:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:1703:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:1703:4: (lv_name_1_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:1704:5: lv_name_1_0= RULE_ID
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
    // InternalExBeeLangTestLanguageParser.g:1724:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;
        int entryRuleFunction_StartIndex = input.index();
        EObject iv_ruleFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:1724:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalExBeeLangTestLanguageParser.g:1725:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalExBeeLangTestLanguageParser.g:1731:1: ruleFunction returns [EObject current=null] : ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= Final ) )? otherlv_3= Function ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= LeftParenthesis ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= RightParenthesis )? (otherlv_16= When ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:1737:2: ( ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= Final ) )? otherlv_3= Function ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= LeftParenthesis ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= RightParenthesis )? (otherlv_16= When ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:1738:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= Final ) )? otherlv_3= Function ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= LeftParenthesis ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= RightParenthesis )? (otherlv_16= When ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1738:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= Final ) )? otherlv_3= Function ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= LeftParenthesis ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= RightParenthesis )? (otherlv_16= When ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:1739:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= Final ) )? otherlv_3= Function ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= LeftParenthesis ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= RightParenthesis )? (otherlv_16= When ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:1739:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_DOCUMENTATION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1740:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1740:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    // InternalExBeeLangTestLanguageParser.g:1741:5: lv_documentation_0_0= RULE_DOCUMENTATION
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

            // InternalExBeeLangTestLanguageParser.g:1757:3: ( (lv_visibility_1_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1758:4: (lv_visibility_1_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1758:4: (lv_visibility_1_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:1759:5: lv_visibility_1_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:1775:3: ( (lv_final_2_0= Final ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==Final) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1776:4: (lv_final_2_0= Final )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1776:4: (lv_final_2_0= Final )
                    // InternalExBeeLangTestLanguageParser.g:1777:5: lv_final_2_0= Final
                    {
                    lv_final_2_0=(Token)match(input,Final,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_2_0, grammarAccess.getFunctionAccess().getFinalFinalKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionRule());
                      					}
                      					setWithLastConsumed(current, "final", lv_final_2_0 != null, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,Function,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getFunctionKeyword_3());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:1793:3: ( (lv_returnType_4_0= ruleTypeRef ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LeftParenthesis) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                int LA32_2 = input.LA(2);

                if ( (LA32_2==LessThanSign||LA32_2==RULE_ID) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1794:4: (lv_returnType_4_0= ruleTypeRef )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1794:4: (lv_returnType_4_0= ruleTypeRef )
                    // InternalExBeeLangTestLanguageParser.g:1795:5: lv_returnType_4_0= ruleTypeRef
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

            // InternalExBeeLangTestLanguageParser.g:1812:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:1813:4: (lv_name_5_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:1813:4: (lv_name_5_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:1814:5: lv_name_5_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:1830:3: (otherlv_6= LeftParenthesis ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= RightParenthesis )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==LeftParenthesis) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1831:4: otherlv_6= LeftParenthesis ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= RightParenthesis
                    {
                    otherlv_6=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_6_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:1835:4: ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )?
                    int alt35=3;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==LeftParenthesis||LA35_0==RULE_ID) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==FullStopFullStopFullStop) ) {
                        alt35=2;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalExBeeLangTestLanguageParser.g:1836:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            {
                            // InternalExBeeLangTestLanguageParser.g:1836:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            // InternalExBeeLangTestLanguageParser.g:1837:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            {
                            // InternalExBeeLangTestLanguageParser.g:1837:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                            // InternalExBeeLangTestLanguageParser.g:1838:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            {
                            // InternalExBeeLangTestLanguageParser.g:1838:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            // InternalExBeeLangTestLanguageParser.g:1839:8: lv_parameters_7_0= ruleParameterDeclaration
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

                            // InternalExBeeLangTestLanguageParser.g:1856:6: (otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==Comma) ) {
                                    int LA33_1 = input.LA(2);

                                    if ( (LA33_1==LeftParenthesis||LA33_1==RULE_ID) ) {
                                        alt33=1;
                                    }


                                }


                                switch (alt33) {
                            	case 1 :
                            	    // InternalExBeeLangTestLanguageParser.g:1857:7: otherlv_8= Comma ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    {
                            	    otherlv_8=(Token)match(input,Comma,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_8, grammarAccess.getFunctionAccess().getCommaKeyword_6_1_0_1_0());
                            	      						
                            	    }
                            	    // InternalExBeeLangTestLanguageParser.g:1861:7: ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    // InternalExBeeLangTestLanguageParser.g:1862:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    {
                            	    // InternalExBeeLangTestLanguageParser.g:1862:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    // InternalExBeeLangTestLanguageParser.g:1863:9: lv_parameters_9_0= ruleParameterDeclaration
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

                            // InternalExBeeLangTestLanguageParser.g:1881:6: (otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==Comma) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // InternalExBeeLangTestLanguageParser.g:1882:7: otherlv_10= Comma ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    {
                                    otherlv_10=(Token)match(input,Comma,FollowSets000.FOLLOW_36); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_10, grammarAccess.getFunctionAccess().getCommaKeyword_6_1_0_2_0());
                                      						
                                    }
                                    // InternalExBeeLangTestLanguageParser.g:1886:7: ( (lv_varArgs_11_0= FullStopFullStopFullStop ) )
                                    // InternalExBeeLangTestLanguageParser.g:1887:8: (lv_varArgs_11_0= FullStopFullStopFullStop )
                                    {
                                    // InternalExBeeLangTestLanguageParser.g:1887:8: (lv_varArgs_11_0= FullStopFullStopFullStop )
                                    // InternalExBeeLangTestLanguageParser.g:1888:9: lv_varArgs_11_0= FullStopFullStopFullStop
                                    {
                                    lv_varArgs_11_0=(Token)match(input,FullStopFullStopFullStop,FollowSets000.FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									newLeafNode(lv_varArgs_11_0, grammarAccess.getFunctionAccess().getVarArgsFullStopFullStopFullStopKeyword_6_1_0_2_1_0());
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElement(grammarAccess.getFunctionRule());
                                      									}
                                      									setWithLastConsumed(current, "varArgs", lv_varArgs_11_0 != null, "...");
                                      								
                                    }

                                    }


                                    }

                                    // InternalExBeeLangTestLanguageParser.g:1900:7: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    // InternalExBeeLangTestLanguageParser.g:1901:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    {
                                    // InternalExBeeLangTestLanguageParser.g:1901:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    // InternalExBeeLangTestLanguageParser.g:1902:9: lv_parameters_12_0= ruleParameterDeclaration
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
                            // InternalExBeeLangTestLanguageParser.g:1922:5: ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            {
                            // InternalExBeeLangTestLanguageParser.g:1922:5: ( ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            // InternalExBeeLangTestLanguageParser.g:1923:6: ( (lv_varArgs_13_0= FullStopFullStopFullStop ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            {
                            // InternalExBeeLangTestLanguageParser.g:1923:6: ( (lv_varArgs_13_0= FullStopFullStopFullStop ) )
                            // InternalExBeeLangTestLanguageParser.g:1924:7: (lv_varArgs_13_0= FullStopFullStopFullStop )
                            {
                            // InternalExBeeLangTestLanguageParser.g:1924:7: (lv_varArgs_13_0= FullStopFullStopFullStop )
                            // InternalExBeeLangTestLanguageParser.g:1925:8: lv_varArgs_13_0= FullStopFullStopFullStop
                            {
                            lv_varArgs_13_0=(Token)match(input,FullStopFullStopFullStop,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_varArgs_13_0, grammarAccess.getFunctionAccess().getVarArgsFullStopFullStopFullStopKeyword_6_1_1_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getFunctionRule());
                              								}
                              								setWithLastConsumed(current, "varArgs", lv_varArgs_13_0 != null, "...");
                              							
                            }

                            }


                            }

                            // InternalExBeeLangTestLanguageParser.g:1937:6: ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            // InternalExBeeLangTestLanguageParser.g:1938:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            {
                            // InternalExBeeLangTestLanguageParser.g:1938:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            // InternalExBeeLangTestLanguageParser.g:1939:8: lv_parameters_14_0= ruleParameterDeclaration
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

                    otherlv_15=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_6_2());
                      			
                    }

                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:1963:3: (otherlv_16= When ( (lv_guard_17_0= ruleGuardExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==When) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:1964:4: otherlv_16= When ( (lv_guard_17_0= ruleGuardExpression ) )
                    {
                    otherlv_16=(Token)match(input,When,FollowSets000.FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getFunctionAccess().getWhenKeyword_7_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:1968:4: ( (lv_guard_17_0= ruleGuardExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:1969:5: (lv_guard_17_0= ruleGuardExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1969:5: (lv_guard_17_0= ruleGuardExpression )
                    // InternalExBeeLangTestLanguageParser.g:1970:6: lv_guard_17_0= ruleGuardExpression
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

            // InternalExBeeLangTestLanguageParser.g:1988:3: ( (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==Colon) ) {
                alt38=1;
            }
            else if ( (LA38_0==LeftCurlyBracket) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:1989:4: (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1989:4: (otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon )
                    // InternalExBeeLangTestLanguageParser.g:1990:5: otherlv_18= Colon ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= Semicolon
                    {
                    otherlv_18=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_18, grammarAccess.getFunctionAccess().getColonKeyword_8_0_0());
                      				
                    }
                    // InternalExBeeLangTestLanguageParser.g:1994:5: ( (lv_funcExpr_19_0= ruleExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:1995:6: (lv_funcExpr_19_0= ruleExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:1995:6: (lv_funcExpr_19_0= ruleExpression )
                    // InternalExBeeLangTestLanguageParser.g:1996:7: lv_funcExpr_19_0= ruleExpression
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

                    otherlv_20=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_20, grammarAccess.getFunctionAccess().getSemicolonKeyword_8_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExBeeLangTestLanguageParser.g:2019:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2019:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:2020:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2020:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    // InternalExBeeLangTestLanguageParser.g:2021:6: lv_funcExpr_21_0= ruleBlockExpression
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
    // InternalExBeeLangTestLanguageParser.g:2043:1: entryRuleGuardExpression returns [EObject current=null] : iv_ruleGuardExpression= ruleGuardExpression EOF ;
    public final EObject entryRuleGuardExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleGuardExpression_StartIndex = input.index();
        EObject iv_ruleGuardExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2043:56: (iv_ruleGuardExpression= ruleGuardExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:2044:2: iv_ruleGuardExpression= ruleGuardExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:2050:1: ruleGuardExpression returns [EObject current=null] : ( (otherlv_0= Colon ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= Semicolon ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:2056:2: ( ( (otherlv_0= Colon ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= Semicolon ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:2057:2: ( (otherlv_0= Colon ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= Semicolon ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:2057:2: ( (otherlv_0= Colon ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= Semicolon ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Colon) ) {
                alt39=1;
            }
            else if ( (LA39_0==LeftCurlyBracket) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:2058:3: (otherlv_0= Colon ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= Semicolon )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2058:3: (otherlv_0= Colon ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= Semicolon )
                    // InternalExBeeLangTestLanguageParser.g:2059:4: otherlv_0= Colon ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= Semicolon
                    {
                    otherlv_0=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getGuardExpressionAccess().getColonKeyword_0_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:2063:4: ( (lv_guardExpr_1_0= ruleExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:2064:5: (lv_guardExpr_1_0= ruleExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2064:5: (lv_guardExpr_1_0= ruleExpression )
                    // InternalExBeeLangTestLanguageParser.g:2065:6: lv_guardExpr_1_0= ruleExpression
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

                    otherlv_2=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getGuardExpressionAccess().getSemicolonKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExBeeLangTestLanguageParser.g:2088:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2088:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:2089:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2089:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    // InternalExBeeLangTestLanguageParser.g:2090:5: lv_guardExpr_3_0= ruleBlockExpression
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
    // InternalExBeeLangTestLanguageParser.g:2111:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;
        int entryRuleAssignmentOperator_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2111:58: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // InternalExBeeLangTestLanguageParser.g:2112:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
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
    // InternalExBeeLangTestLanguageParser.g:2118:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSign | kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleAssignmentOperator_StartIndex = input.index();
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2124:2: ( (kw= EqualsSign | kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign ) )
            // InternalExBeeLangTestLanguageParser.g:2125:2: (kw= EqualsSign | kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign )
            {
            // InternalExBeeLangTestLanguageParser.g:2125:2: (kw= EqualsSign | kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign )
            int alt40=6;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt40=1;
                }
                break;
            case PlusSignEqualsSign:
                {
                alt40=2;
                }
                break;
            case HyphenMinusEqualsSign:
                {
                alt40=3;
                }
                break;
            case AsteriskEqualsSign:
                {
                alt40=4;
                }
                break;
            case SolidusEqualsSign:
                {
                alt40=5;
                }
                break;
            case PercentSignEqualsSign:
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
                    // InternalExBeeLangTestLanguageParser.g:2126:3: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExBeeLangTestLanguageParser.g:2132:3: kw= PlusSignEqualsSign
                    {
                    kw=(Token)match(input,PlusSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getPlusSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExBeeLangTestLanguageParser.g:2138:3: kw= HyphenMinusEqualsSign
                    {
                    kw=(Token)match(input,HyphenMinusEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getHyphenMinusEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExBeeLangTestLanguageParser.g:2144:3: kw= AsteriskEqualsSign
                    {
                    kw=(Token)match(input,AsteriskEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getAsteriskEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExBeeLangTestLanguageParser.g:2150:3: kw= SolidusEqualsSign
                    {
                    kw=(Token)match(input,SolidusEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getSolidusEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExBeeLangTestLanguageParser.g:2156:3: kw= PercentSignEqualsSign
                    {
                    kw=(Token)match(input,PercentSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:2165:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;
        int entryRuleRelationalOperator_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2165:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalExBeeLangTestLanguageParser.g:2166:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalExBeeLangTestLanguageParser.g:2172:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= TildeEqualsSign | kw= EqualsSignEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleRelationalOperator_StartIndex = input.index();
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2178:2: ( (kw= TildeEqualsSign | kw= EqualsSignEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign ) )
            // InternalExBeeLangTestLanguageParser.g:2179:2: (kw= TildeEqualsSign | kw= EqualsSignEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign )
            {
            // InternalExBeeLangTestLanguageParser.g:2179:2: (kw= TildeEqualsSign | kw= EqualsSignEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= LessThanSign )
            int alt41=9;
            switch ( input.LA(1) ) {
            case TildeEqualsSign:
                {
                alt41=1;
                }
                break;
            case EqualsSignEqualsSign:
                {
                alt41=2;
                }
                break;
            case EqualsSignEqualsSignEqualsSign:
                {
                alt41=3;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt41=4;
                }
                break;
            case ExclamationMarkEqualsSignEqualsSign:
                {
                alt41=5;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt41=6;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt41=7;
                }
                break;
            case GreaterThanSign:
                {
                alt41=8;
                }
                break;
            case LessThanSign:
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
                    // InternalExBeeLangTestLanguageParser.g:2180:3: kw= TildeEqualsSign
                    {
                    kw=(Token)match(input,TildeEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getTildeEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExBeeLangTestLanguageParser.g:2186:3: kw= EqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getEqualsSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExBeeLangTestLanguageParser.g:2192:3: kw= EqualsSignEqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExBeeLangTestLanguageParser.g:2198:3: kw= ExclamationMarkEqualsSign
                    {
                    kw=(Token)match(input,ExclamationMarkEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getExclamationMarkEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExBeeLangTestLanguageParser.g:2204:3: kw= ExclamationMarkEqualsSignEqualsSign
                    {
                    kw=(Token)match(input,ExclamationMarkEqualsSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getExclamationMarkEqualsSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExBeeLangTestLanguageParser.g:2210:3: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExBeeLangTestLanguageParser.g:2216:3: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExBeeLangTestLanguageParser.g:2222:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalExBeeLangTestLanguageParser.g:2228:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:2237:1: entryRuleTopLevelExpression returns [EObject current=null] : iv_ruleTopLevelExpression= ruleTopLevelExpression EOF ;
    public final EObject entryRuleTopLevelExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleTopLevelExpression_StartIndex = input.index();
        EObject iv_ruleTopLevelExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2237:59: (iv_ruleTopLevelExpression= ruleTopLevelExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:2238:2: iv_ruleTopLevelExpression= ruleTopLevelExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:2244:1: ruleTopLevelExpression returns [EObject current=null] : (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) ;
    public final EObject ruleTopLevelExpression() throws RecognitionException {
        EObject current = null;
        int ruleTopLevelExpression_StartIndex = input.index();
        EObject this_VarDeclaration_0 = null;

        EObject this_ValDeclaration_1 = null;

        EObject this_AssignmentExpression_2 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2250:2: ( (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) )
            // InternalExBeeLangTestLanguageParser.g:2251:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:2251:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2252:3: this_VarDeclaration_0= ruleVarDeclaration
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
                    // InternalExBeeLangTestLanguageParser.g:2264:3: this_ValDeclaration_1= ruleValDeclaration
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
                    // InternalExBeeLangTestLanguageParser.g:2276:3: this_AssignmentExpression_2= ruleAssignmentExpression
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
    // InternalExBeeLangTestLanguageParser.g:2291:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleExpression_StartIndex = input.index();
        EObject iv_ruleExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2291:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:2292:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:2298:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;
        int ruleExpression_StartIndex = input.index();
        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2304:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalExBeeLangTestLanguageParser.g:2305:2: this_AssignmentExpression_0= ruleAssignmentExpression
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
    // InternalExBeeLangTestLanguageParser.g:2319:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAssignmentExpression_StartIndex = input.index();
        EObject iv_ruleAssignmentExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2319:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:2320:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:2326:1: ruleAssignmentExpression returns [EObject current=null] : (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;
        int ruleAssignmentExpression_StartIndex = input.index();
        EObject this_CachedExpression_0 = null;

        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2332:2: ( (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) )
            // InternalExBeeLangTestLanguageParser.g:2333:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            {
            // InternalExBeeLangTestLanguageParser.g:2333:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            // InternalExBeeLangTestLanguageParser.g:2334:3: this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
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
            // InternalExBeeLangTestLanguageParser.g:2345:3: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            int alt43=2;
            switch ( input.LA(1) ) {
                case EqualsSign:
                    {
                    int LA43_1 = input.LA(2);

                    if ( (synpred71_InternalExBeeLangTestLanguageParser()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case PlusSignEqualsSign:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred71_InternalExBeeLangTestLanguageParser()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case HyphenMinusEqualsSign:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred71_InternalExBeeLangTestLanguageParser()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case AsteriskEqualsSign:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred71_InternalExBeeLangTestLanguageParser()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case SolidusEqualsSign:
                    {
                    int LA43_5 = input.LA(2);

                    if ( (synpred71_InternalExBeeLangTestLanguageParser()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case PercentSignEqualsSign:
                    {
                    int LA43_6 = input.LA(2);

                    if ( (synpred71_InternalExBeeLangTestLanguageParser()) ) {
                        alt43=1;
                    }
                    }
                    break;
            }

            switch (alt43) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2346:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2346:4: ()
                    // InternalExBeeLangTestLanguageParser.g:2347:5: 
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

                    // InternalExBeeLangTestLanguageParser.g:2356:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
                    // InternalExBeeLangTestLanguageParser.g:2357:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2357:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    // InternalExBeeLangTestLanguageParser.g:2358:6: lv_functionName_2_0= ruleAssignmentOperator
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

                    // InternalExBeeLangTestLanguageParser.g:2375:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:2376:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2376:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    // InternalExBeeLangTestLanguageParser.g:2377:6: lv_rightExpr_3_0= ruleAssignmentExpression
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
    // InternalExBeeLangTestLanguageParser.g:2399:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleVarDeclaration_StartIndex = input.index();
        EObject iv_ruleVarDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2399:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalExBeeLangTestLanguageParser.g:2400:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
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
    // InternalExBeeLangTestLanguageParser.g:2406:1: ruleVarDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= Final ) )? ( (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) ;
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
            // InternalExBeeLangTestLanguageParser.g:2412:2: ( ( () ( (lv_final_1_0= Final ) )? ( (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) )
            // InternalExBeeLangTestLanguageParser.g:2413:2: ( () ( (lv_final_1_0= Final ) )? ( (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            {
            // InternalExBeeLangTestLanguageParser.g:2413:2: ( () ( (lv_final_1_0= Final ) )? ( (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            // InternalExBeeLangTestLanguageParser.g:2414:3: () ( (lv_final_1_0= Final ) )? ( (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            {
            // InternalExBeeLangTestLanguageParser.g:2414:3: ()
            // InternalExBeeLangTestLanguageParser.g:2415:4: 
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

            // InternalExBeeLangTestLanguageParser.g:2424:3: ( (lv_final_1_0= Final ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Final) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2425:4: (lv_final_1_0= Final )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2425:4: (lv_final_1_0= Final )
                    // InternalExBeeLangTestLanguageParser.g:2426:5: lv_final_1_0= Final
                    {
                    lv_final_1_0=(Token)match(input,Final,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_1_0, grammarAccess.getVarDeclarationAccess().getFinalFinalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVarDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "final", lv_final_1_0 != null, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:2438:3: ( (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) )
            // InternalExBeeLangTestLanguageParser.g:2439:4: (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) )
            {
            // InternalExBeeLangTestLanguageParser.g:2439:4: (otherlv_2= Var | ( (lv_type_3_0= ruleTypeRef ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Var) ) {
                alt45=1;
            }
            else if ( (LA45_0==LeftParenthesis||LA45_0==RULE_ID) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:2440:5: otherlv_2= Var
                    {
                    otherlv_2=(Token)match(input,Var,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getVarDeclarationAccess().getVarKeyword_2_0_0());
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalExBeeLangTestLanguageParser.g:2445:5: ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2445:5: ( (lv_type_3_0= ruleTypeRef ) )
                    // InternalExBeeLangTestLanguageParser.g:2446:6: (lv_type_3_0= ruleTypeRef )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2446:6: (lv_type_3_0= ruleTypeRef )
                    // InternalExBeeLangTestLanguageParser.g:2447:7: lv_type_3_0= ruleTypeRef
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

            // InternalExBeeLangTestLanguageParser.g:2465:4: ( (lv_name_4_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:2466:5: (lv_name_4_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:2466:5: (lv_name_4_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:2467:6: lv_name_4_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:2484:3: (otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==EqualsSign) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2485:4: otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) )
                    {
                    otherlv_5=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getVarDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:2489:4: ( (lv_valueExpr_6_0= ruleExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:2490:5: (lv_valueExpr_6_0= ruleExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2490:5: (lv_valueExpr_6_0= ruleExpression )
                    // InternalExBeeLangTestLanguageParser.g:2491:6: lv_valueExpr_6_0= ruleExpression
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
    // InternalExBeeLangTestLanguageParser.g:2513:1: entryRuleValDeclaration returns [EObject current=null] : iv_ruleValDeclaration= ruleValDeclaration EOF ;
    public final EObject entryRuleValDeclaration() throws RecognitionException {
        EObject current = null;
        int entryRuleValDeclaration_StartIndex = input.index();
        EObject iv_ruleValDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2513:55: (iv_ruleValDeclaration= ruleValDeclaration EOF )
            // InternalExBeeLangTestLanguageParser.g:2514:2: iv_ruleValDeclaration= ruleValDeclaration EOF
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
    // InternalExBeeLangTestLanguageParser.g:2520:1: ruleValDeclaration returns [EObject current=null] : ( () ( (lv_final_1_0= Final ) )? ( (lv_immutable_2_0= Val ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:2526:2: ( ( () ( (lv_final_1_0= Final ) )? ( (lv_immutable_2_0= Val ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:2527:2: ( () ( (lv_final_1_0= Final ) )? ( (lv_immutable_2_0= Val ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:2527:2: ( () ( (lv_final_1_0= Final ) )? ( (lv_immutable_2_0= Val ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) ) )
            // InternalExBeeLangTestLanguageParser.g:2528:3: () ( (lv_final_1_0= Final ) )? ( (lv_immutable_2_0= Val ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= EqualsSign ( (lv_valueExpr_6_0= ruleExpression ) )
            {
            // InternalExBeeLangTestLanguageParser.g:2528:3: ()
            // InternalExBeeLangTestLanguageParser.g:2529:4: 
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

            // InternalExBeeLangTestLanguageParser.g:2538:3: ( (lv_final_1_0= Final ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Final) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2539:4: (lv_final_1_0= Final )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2539:4: (lv_final_1_0= Final )
                    // InternalExBeeLangTestLanguageParser.g:2540:5: lv_final_1_0= Final
                    {
                    lv_final_1_0=(Token)match(input,Final,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_final_1_0, grammarAccess.getValDeclarationAccess().getFinalFinalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getValDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "final", lv_final_1_0 != null, "final");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:2552:3: ( (lv_immutable_2_0= Val ) )
            // InternalExBeeLangTestLanguageParser.g:2553:4: (lv_immutable_2_0= Val )
            {
            // InternalExBeeLangTestLanguageParser.g:2553:4: (lv_immutable_2_0= Val )
            // InternalExBeeLangTestLanguageParser.g:2554:5: lv_immutable_2_0= Val
            {
            lv_immutable_2_0=(Token)match(input,Val,FollowSets000.FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_immutable_2_0, grammarAccess.getValDeclarationAccess().getImmutableValKeyword_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getValDeclarationRule());
              					}
              					setWithLastConsumed(current, "immutable", lv_immutable_2_0 != null, "val");
              				
            }

            }


            }

            // InternalExBeeLangTestLanguageParser.g:2566:3: ( (lv_type_3_0= ruleTypeRef ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==LeftParenthesis) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_ID) ) {
                int LA48_2 = input.LA(2);

                if ( (LA48_2==LessThanSign||LA48_2==RULE_ID) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2567:4: (lv_type_3_0= ruleTypeRef )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2567:4: (lv_type_3_0= ruleTypeRef )
                    // InternalExBeeLangTestLanguageParser.g:2568:5: lv_type_3_0= ruleTypeRef
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

            // InternalExBeeLangTestLanguageParser.g:2585:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:2586:4: (lv_name_4_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:2586:4: (lv_name_4_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:2587:5: lv_name_4_0= RULE_ID
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

            otherlv_5=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getValDeclarationAccess().getEqualsSignKeyword_5());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:2607:3: ( (lv_valueExpr_6_0= ruleExpression ) )
            // InternalExBeeLangTestLanguageParser.g:2608:4: (lv_valueExpr_6_0= ruleExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:2608:4: (lv_valueExpr_6_0= ruleExpression )
            // InternalExBeeLangTestLanguageParser.g:2609:5: lv_valueExpr_6_0= ruleExpression
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
    // InternalExBeeLangTestLanguageParser.g:2630:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleTypeRef_StartIndex = input.index();
        EObject iv_ruleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2630:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalExBeeLangTestLanguageParser.g:2631:2: iv_ruleTypeRef= ruleTypeRef EOF
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
    // InternalExBeeLangTestLanguageParser.g:2637:1: ruleTypeRef returns [EObject current=null] : (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;
        int ruleTypeRef_StartIndex = input.index();
        EObject this_ClosureTypeRef_0 = null;

        EObject this_SimpleTypeRef_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2643:2: ( (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) )
            // InternalExBeeLangTestLanguageParser.g:2644:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            {
            // InternalExBeeLangTestLanguageParser.g:2644:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==LeftParenthesis) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:2645:3: this_ClosureTypeRef_0= ruleClosureTypeRef
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
                    // InternalExBeeLangTestLanguageParser.g:2657:3: this_SimpleTypeRef_1= ruleSimpleTypeRef
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
    // InternalExBeeLangTestLanguageParser.g:2672:1: entryRuleSimpleTypeRef returns [EObject current=null] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final EObject entryRuleSimpleTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleSimpleTypeRef_StartIndex = input.index();
        EObject iv_ruleSimpleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2672:54: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // InternalExBeeLangTestLanguageParser.g:2673:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
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
    // InternalExBeeLangTestLanguageParser.g:2679:1: ruleSimpleTypeRef returns [EObject current=null] : ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= LessThanSign ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= GreaterThanSign )? ) ;
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
            // InternalExBeeLangTestLanguageParser.g:2685:2: ( ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= LessThanSign ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= GreaterThanSign )? ) )
            // InternalExBeeLangTestLanguageParser.g:2686:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= LessThanSign ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= GreaterThanSign )? )
            {
            // InternalExBeeLangTestLanguageParser.g:2686:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= LessThanSign ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= GreaterThanSign )? )
            // InternalExBeeLangTestLanguageParser.g:2687:3: ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= LessThanSign ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= GreaterThanSign )?
            {
            // InternalExBeeLangTestLanguageParser.g:2687:3: ( (lv_rawType_0_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:2688:4: (lv_rawType_0_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:2688:4: (lv_rawType_0_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:2689:5: lv_rawType_0_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:2705:3: (otherlv_1= LessThanSign ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= GreaterThanSign )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==LessThanSign) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2706:4: otherlv_1= LessThanSign ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= GreaterThanSign
                    {
                    otherlv_1=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSimpleTypeRefAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:2710:4: ( (lv_actualArgumentsList_2_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:2711:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2711:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:2712:6: lv_actualArgumentsList_2_0= RULE_ID
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

                    // InternalExBeeLangTestLanguageParser.g:2728:4: (otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==Comma) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:2729:5: otherlv_3= Comma ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getSimpleTypeRefAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:2733:5: ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    // InternalExBeeLangTestLanguageParser.g:2734:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:2734:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    // InternalExBeeLangTestLanguageParser.g:2735:7: lv_actualArgumentsList_4_0= RULE_ID
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

                    otherlv_5=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:2761:1: entryRuleClosureTypeRef returns [EObject current=null] : iv_ruleClosureTypeRef= ruleClosureTypeRef EOF ;
    public final EObject entryRuleClosureTypeRef() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureTypeRef_StartIndex = input.index();
        EObject iv_ruleClosureTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2761:55: (iv_ruleClosureTypeRef= ruleClosureTypeRef EOF )
            // InternalExBeeLangTestLanguageParser.g:2762:2: iv_ruleClosureTypeRef= ruleClosureTypeRef EOF
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
    // InternalExBeeLangTestLanguageParser.g:2768:1: ruleClosureTypeRef returns [EObject current=null] : (otherlv_0= LeftParenthesis ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= RightParenthesis otherlv_10= EqualsSignGreaterThanSign ( (lv_returnType_11_0= RULE_ID ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:2774:2: ( (otherlv_0= LeftParenthesis ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= RightParenthesis otherlv_10= EqualsSignGreaterThanSign ( (lv_returnType_11_0= RULE_ID ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:2775:2: (otherlv_0= LeftParenthesis ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= RightParenthesis otherlv_10= EqualsSignGreaterThanSign ( (lv_returnType_11_0= RULE_ID ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:2775:2: (otherlv_0= LeftParenthesis ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= RightParenthesis otherlv_10= EqualsSignGreaterThanSign ( (lv_returnType_11_0= RULE_ID ) ) )
            // InternalExBeeLangTestLanguageParser.g:2776:3: otherlv_0= LeftParenthesis ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= RightParenthesis otherlv_10= EqualsSignGreaterThanSign ( (lv_returnType_11_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClosureTypeRefAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:2780:3: ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )?
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==FullStopFullStopFullStop) ) {
                alt54=2;
            }
            switch (alt54) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:2781:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2781:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    // InternalExBeeLangTestLanguageParser.g:2782:5: ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    {
                    // InternalExBeeLangTestLanguageParser.g:2782:5: ( (lv_parameterTypes_1_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:2783:6: (lv_parameterTypes_1_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2783:6: (lv_parameterTypes_1_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:2784:7: lv_parameterTypes_1_0= RULE_ID
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

                    // InternalExBeeLangTestLanguageParser.g:2800:5: (otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==Comma) ) {
                            int LA52_1 = input.LA(2);

                            if ( (LA52_1==RULE_ID) ) {
                                alt52=1;
                            }


                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:2801:6: otherlv_2= Comma ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,Comma,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_2, grammarAccess.getClosureTypeRefAccess().getCommaKeyword_1_0_1_0());
                    	      					
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:2805:6: ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    // InternalExBeeLangTestLanguageParser.g:2806:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:2806:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    // InternalExBeeLangTestLanguageParser.g:2807:8: lv_parameterTypes_3_0= RULE_ID
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

                    // InternalExBeeLangTestLanguageParser.g:2824:5: (otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==Comma) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalExBeeLangTestLanguageParser.g:2825:6: otherlv_4= Comma ( (lv_varArgs_5_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_6_0= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getClosureTypeRefAccess().getCommaKeyword_1_0_2_0());
                              					
                            }
                            // InternalExBeeLangTestLanguageParser.g:2829:6: ( (lv_varArgs_5_0= FullStopFullStopFullStop ) )
                            // InternalExBeeLangTestLanguageParser.g:2830:7: (lv_varArgs_5_0= FullStopFullStopFullStop )
                            {
                            // InternalExBeeLangTestLanguageParser.g:2830:7: (lv_varArgs_5_0= FullStopFullStopFullStop )
                            // InternalExBeeLangTestLanguageParser.g:2831:8: lv_varArgs_5_0= FullStopFullStopFullStop
                            {
                            lv_varArgs_5_0=(Token)match(input,FullStopFullStopFullStop,FollowSets000.FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_varArgs_5_0, grammarAccess.getClosureTypeRefAccess().getVarArgsFullStopFullStopFullStopKeyword_1_0_2_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getClosureTypeRefRule());
                              								}
                              								setWithLastConsumed(current, "varArgs", lv_varArgs_5_0 != null, "...");
                              							
                            }

                            }


                            }

                            // InternalExBeeLangTestLanguageParser.g:2843:6: ( (lv_parameterTypes_6_0= RULE_ID ) )
                            // InternalExBeeLangTestLanguageParser.g:2844:7: (lv_parameterTypes_6_0= RULE_ID )
                            {
                            // InternalExBeeLangTestLanguageParser.g:2844:7: (lv_parameterTypes_6_0= RULE_ID )
                            // InternalExBeeLangTestLanguageParser.g:2845:8: lv_parameterTypes_6_0= RULE_ID
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
                    // InternalExBeeLangTestLanguageParser.g:2864:4: ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2864:4: ( ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    // InternalExBeeLangTestLanguageParser.g:2865:5: ( (lv_varArgs_7_0= FullStopFullStopFullStop ) ) ( (lv_parameterTypes_8_0= RULE_ID ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2865:5: ( (lv_varArgs_7_0= FullStopFullStopFullStop ) )
                    // InternalExBeeLangTestLanguageParser.g:2866:6: (lv_varArgs_7_0= FullStopFullStopFullStop )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2866:6: (lv_varArgs_7_0= FullStopFullStopFullStop )
                    // InternalExBeeLangTestLanguageParser.g:2867:7: lv_varArgs_7_0= FullStopFullStopFullStop
                    {
                    lv_varArgs_7_0=(Token)match(input,FullStopFullStopFullStop,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_varArgs_7_0, grammarAccess.getClosureTypeRefAccess().getVarArgsFullStopFullStopFullStopKeyword_1_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureTypeRefRule());
                      							}
                      							setWithLastConsumed(current, "varArgs", lv_varArgs_7_0 != null, "...");
                      						
                    }

                    }


                    }

                    // InternalExBeeLangTestLanguageParser.g:2879:5: ( (lv_parameterTypes_8_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:2880:6: (lv_parameterTypes_8_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2880:6: (lv_parameterTypes_8_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:2881:7: lv_parameterTypes_8_0= RULE_ID
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

            otherlv_9=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getClosureTypeRefAccess().getRightParenthesisKeyword_2());
              		
            }
            otherlv_10=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getClosureTypeRefAccess().getEqualsSignGreaterThanSignKeyword_3());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:2907:3: ( (lv_returnType_11_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:2908:4: (lv_returnType_11_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:2908:4: (lv_returnType_11_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:2909:5: lv_returnType_11_0= RULE_ID
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
    // InternalExBeeLangTestLanguageParser.g:2929:1: entryRuleCachedExpression returns [EObject current=null] : iv_ruleCachedExpression= ruleCachedExpression EOF ;
    public final EObject entryRuleCachedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleCachedExpression_StartIndex = input.index();
        EObject iv_ruleCachedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2929:57: (iv_ruleCachedExpression= ruleCachedExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:2930:2: iv_ruleCachedExpression= ruleCachedExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:2936:1: ruleCachedExpression returns [EObject current=null] : ( ( () otherlv_1= Cached ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) ;
    public final EObject ruleCachedExpression() throws RecognitionException {
        EObject current = null;
        int ruleCachedExpression_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_expr_2_0 = null;

        EObject this_OrExpression_3 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2942:2: ( ( ( () otherlv_1= Cached ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) )
            // InternalExBeeLangTestLanguageParser.g:2943:2: ( ( () otherlv_1= Cached ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:2943:2: ( ( () otherlv_1= Cached ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==Cached) ) {
                alt55=1;
            }
            else if ( (LA55_0==Properties||LA55_0==Builder||(LA55_0>=Output && LA55_0<=Source)||LA55_0==Input||(LA55_0>=This && LA55_0<=Unit)||LA55_0==With||LA55_0==New||LA55_0==PlusSignPlusSign||LA55_0==HyphenMinusHyphenMinus||LA55_0==ExclamationMark||LA55_0==LeftParenthesis||LA55_0==HyphenMinus||LA55_0==LeftCurlyBracket||LA55_0==RULE_ID||LA55_0==RULE_STRING) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:2944:3: ( () otherlv_1= Cached ( (lv_expr_2_0= ruleOrExpression ) ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2944:3: ( () otherlv_1= Cached ( (lv_expr_2_0= ruleOrExpression ) ) )
                    // InternalExBeeLangTestLanguageParser.g:2945:4: () otherlv_1= Cached ( (lv_expr_2_0= ruleOrExpression ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2945:4: ()
                    // InternalExBeeLangTestLanguageParser.g:2946:5: 
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

                    otherlv_1=(Token)match(input,Cached,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCachedExpressionAccess().getCachedKeyword_0_1());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:2959:4: ( (lv_expr_2_0= ruleOrExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:2960:5: (lv_expr_2_0= ruleOrExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:2960:5: (lv_expr_2_0= ruleOrExpression )
                    // InternalExBeeLangTestLanguageParser.g:2961:6: lv_expr_2_0= ruleOrExpression
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
                    // InternalExBeeLangTestLanguageParser.g:2980:3: this_OrExpression_3= ruleOrExpression
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
    // InternalExBeeLangTestLanguageParser.g:2995:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleOrExpression_StartIndex = input.index();
        EObject iv_ruleOrExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:2995:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:2996:2: iv_ruleOrExpression= ruleOrExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3002:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;
        int ruleOrExpression_StartIndex = input.index();
        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3008:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:3009:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3009:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:3010:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
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
            // InternalExBeeLangTestLanguageParser.g:3021:3: ( () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==VerticalLineVerticalLine) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred85_InternalExBeeLangTestLanguageParser()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3022:4: () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3022:4: ()
            	    // InternalExBeeLangTestLanguageParser.g:3023:5: 
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

            	    otherlv_2=(Token)match(input,VerticalLineVerticalLine,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	      			
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:3036:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:3037:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3037:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    // InternalExBeeLangTestLanguageParser.g:3038:6: lv_rightExpr_3_0= ruleAndExpression
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
    // InternalExBeeLangTestLanguageParser.g:3060:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAndExpression_StartIndex = input.index();
        EObject iv_ruleAndExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3060:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3061:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3067:1: ruleAndExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;
        int ruleAndExpression_StartIndex = input.index();
        Token otherlv_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3073:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:3074:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3074:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:3075:3: this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
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
            // InternalExBeeLangTestLanguageParser.g:3086:3: ( () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==AmpersandAmpersand) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred86_InternalExBeeLangTestLanguageParser()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3087:4: () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3087:4: ()
            	    // InternalExBeeLangTestLanguageParser.g:3088:5: 
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

            	    otherlv_2=(Token)match(input,AmpersandAmpersand,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	      			
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:3101:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:3102:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3102:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    // InternalExBeeLangTestLanguageParser.g:3103:6: lv_rightExpr_3_0= ruleRelationalExpression
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
    // InternalExBeeLangTestLanguageParser.g:3125:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleRelationalExpression_StartIndex = input.index();
        EObject iv_ruleRelationalExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3125:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3126:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3132:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;
        int ruleRelationalExpression_StartIndex = input.index();
        EObject this_AdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3138:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:3139:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3139:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:3140:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
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
            // InternalExBeeLangTestLanguageParser.g:3151:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3152:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3152:4: ()
            	    // InternalExBeeLangTestLanguageParser.g:3153:5: 
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

            	    // InternalExBeeLangTestLanguageParser.g:3162:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
            	    // InternalExBeeLangTestLanguageParser.g:3163:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3163:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    // InternalExBeeLangTestLanguageParser.g:3164:6: lv_functionName_2_0= ruleRelationalOperator
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

            	    // InternalExBeeLangTestLanguageParser.g:3181:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:3182:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3182:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    // InternalExBeeLangTestLanguageParser.g:3183:6: lv_rightExpr_3_0= ruleAdditiveExpression
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
    // InternalExBeeLangTestLanguageParser.g:3205:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleAdditiveExpression_StartIndex = input.index();
        EObject iv_ruleAdditiveExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3205:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3206:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3212:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) ;
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
            // InternalExBeeLangTestLanguageParser.g:3218:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:3219:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3219:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:3220:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
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
            // InternalExBeeLangTestLanguageParser.g:3231:3: ( () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==PlusSign) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred89_InternalExBeeLangTestLanguageParser()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==HyphenMinus) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred89_InternalExBeeLangTestLanguageParser()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3232:4: () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3232:4: ()
            	    // InternalExBeeLangTestLanguageParser.g:3233:5: 
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

            	    // InternalExBeeLangTestLanguageParser.g:3242:4: ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:3243:5: ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3243:5: ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) )
            	    // InternalExBeeLangTestLanguageParser.g:3244:6: (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3244:6: (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus )
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==PlusSign) ) {
            	        alt59=1;
            	    }
            	    else if ( (LA59_0==HyphenMinus) ) {
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
            	            // InternalExBeeLangTestLanguageParser.g:3245:7: lv_functionName_2_1= PlusSign
            	            {
            	            lv_functionName_2_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_19); if (state.failed) return current;
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
            	            // InternalExBeeLangTestLanguageParser.g:3256:7: lv_functionName_2_2= HyphenMinus
            	            {
            	            lv_functionName_2_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_19); if (state.failed) return current;
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

            	    // InternalExBeeLangTestLanguageParser.g:3269:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:3270:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3270:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    // InternalExBeeLangTestLanguageParser.g:3271:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
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
    // InternalExBeeLangTestLanguageParser.g:3293:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleMultiplicativeExpression_StartIndex = input.index();
        EObject iv_ruleMultiplicativeExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3293:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3294:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3300:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) ;
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
            // InternalExBeeLangTestLanguageParser.g:3306:2: ( (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:3307:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3307:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:3308:3: this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
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
            // InternalExBeeLangTestLanguageParser.g:3319:3: ( () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case Asterisk:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred92_InternalExBeeLangTestLanguageParser()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case Solidus:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred92_InternalExBeeLangTestLanguageParser()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case PercentSign:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred92_InternalExBeeLangTestLanguageParser()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3320:4: () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3320:4: ()
            	    // InternalExBeeLangTestLanguageParser.g:3321:5: 
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

            	    // InternalExBeeLangTestLanguageParser.g:3330:4: ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:3331:5: ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3331:5: ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) )
            	    // InternalExBeeLangTestLanguageParser.g:3332:6: (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3332:6: (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign )
            	    int alt61=3;
            	    switch ( input.LA(1) ) {
            	    case Asterisk:
            	        {
            	        alt61=1;
            	        }
            	        break;
            	    case Solidus:
            	        {
            	        alt61=2;
            	        }
            	        break;
            	    case PercentSign:
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
            	            // InternalExBeeLangTestLanguageParser.g:3333:7: lv_functionName_2_1= Asterisk
            	            {
            	            lv_functionName_2_1=(Token)match(input,Asterisk,FollowSets000.FOLLOW_19); if (state.failed) return current;
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
            	            // InternalExBeeLangTestLanguageParser.g:3344:7: lv_functionName_2_2= Solidus
            	            {
            	            lv_functionName_2_2=(Token)match(input,Solidus,FollowSets000.FOLLOW_19); if (state.failed) return current;
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
            	            // InternalExBeeLangTestLanguageParser.g:3355:7: lv_functionName_2_3= PercentSign
            	            {
            	            lv_functionName_2_3=(Token)match(input,PercentSign,FollowSets000.FOLLOW_19); if (state.failed) return current;
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

            	    // InternalExBeeLangTestLanguageParser.g:3368:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:3369:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3369:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    // InternalExBeeLangTestLanguageParser.g:3370:6: lv_rightExpr_3_0= ruleSetExpression
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
    // InternalExBeeLangTestLanguageParser.g:3392:1: entryRuleSetExpression returns [EObject current=null] : iv_ruleSetExpression= ruleSetExpression EOF ;
    public final EObject entryRuleSetExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleSetExpression_StartIndex = input.index();
        EObject iv_ruleSetExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3392:54: (iv_ruleSetExpression= ruleSetExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3393:2: iv_ruleSetExpression= ruleSetExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3399:1: ruleSetExpression returns [EObject current=null] : (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) ;
    public final EObject ruleSetExpression() throws RecognitionException {
        EObject current = null;
        int ruleSetExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        EObject this_UnaryOrInfixExpression_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3405:2: ( (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:3406:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3406:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:3407:3: this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
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
            // InternalExBeeLangTestLanguageParser.g:3418:3: ( () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==FullStopFullStop) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred93_InternalExBeeLangTestLanguageParser()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3419:4: () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3419:4: ()
            	    // InternalExBeeLangTestLanguageParser.g:3420:5: 
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

            	    // InternalExBeeLangTestLanguageParser.g:3429:4: ( (lv_functionName_2_0= FullStopFullStop ) )
            	    // InternalExBeeLangTestLanguageParser.g:3430:5: (lv_functionName_2_0= FullStopFullStop )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3430:5: (lv_functionName_2_0= FullStopFullStop )
            	    // InternalExBeeLangTestLanguageParser.g:3431:6: lv_functionName_2_0= FullStopFullStop
            	    {
            	    lv_functionName_2_0=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_19); if (state.failed) return current;
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

            	    // InternalExBeeLangTestLanguageParser.g:3443:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:3444:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3444:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    // InternalExBeeLangTestLanguageParser.g:3445:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
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
    // InternalExBeeLangTestLanguageParser.g:3467:1: entryRuleUnaryOrInfixExpression returns [EObject current=null] : iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF ;
    public final EObject entryRuleUnaryOrInfixExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleUnaryOrInfixExpression_StartIndex = input.index();
        EObject iv_ruleUnaryOrInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3467:63: (iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3468:2: iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3474:1: ruleUnaryOrInfixExpression returns [EObject current=null] : (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) ;
    public final EObject ruleUnaryOrInfixExpression() throws RecognitionException {
        EObject current = null;
        int ruleUnaryOrInfixExpression_StartIndex = input.index();
        EObject this_PostopExpression_0 = null;

        EObject this_UnaryExpression_1 = null;

        EObject this_PreopExpression_2 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3480:2: ( (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) )
            // InternalExBeeLangTestLanguageParser.g:3481:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:3481:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
            int alt64=3;
            switch ( input.LA(1) ) {
            case Properties:
            case Builder:
            case Output:
            case Source:
            case Input:
            case This:
            case Unit:
            case With:
            case New:
            case LeftParenthesis:
            case LeftCurlyBracket:
            case RULE_ID:
            case RULE_STRING:
                {
                alt64=1;
                }
                break;
            case ExclamationMark:
            case HyphenMinus:
                {
                alt64=2;
                }
                break;
            case PlusSignPlusSign:
            case HyphenMinusHyphenMinus:
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
                    // InternalExBeeLangTestLanguageParser.g:3482:3: this_PostopExpression_0= rulePostopExpression
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
                    // InternalExBeeLangTestLanguageParser.g:3494:3: this_UnaryExpression_1= ruleUnaryExpression
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
                    // InternalExBeeLangTestLanguageParser.g:3506:3: this_PreopExpression_2= rulePreopExpression
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
    // InternalExBeeLangTestLanguageParser.g:3521:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleUnaryExpression_StartIndex = input.index();
        EObject iv_ruleUnaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3521:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3522:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3528:1: ruleUnaryExpression returns [EObject current=null] : ( () ( ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;
        int ruleUnaryExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3534:2: ( ( () ( ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:3535:2: ( () ( ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:3535:2: ( () ( ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // InternalExBeeLangTestLanguageParser.g:3536:3: () ( ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // InternalExBeeLangTestLanguageParser.g:3536:3: ()
            // InternalExBeeLangTestLanguageParser.g:3537:4: 
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

            // InternalExBeeLangTestLanguageParser.g:3546:3: ( ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) ) )
            // InternalExBeeLangTestLanguageParser.g:3547:4: ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) )
            {
            // InternalExBeeLangTestLanguageParser.g:3547:4: ( (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus ) )
            // InternalExBeeLangTestLanguageParser.g:3548:5: (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus )
            {
            // InternalExBeeLangTestLanguageParser.g:3548:5: (lv_functionName_1_1= ExclamationMark | lv_functionName_1_2= HyphenMinus )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==ExclamationMark) ) {
                alt65=1;
            }
            else if ( (LA65_0==HyphenMinus) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:3549:6: lv_functionName_1_1= ExclamationMark
                    {
                    lv_functionName_1_1=(Token)match(input,ExclamationMark,FollowSets000.FOLLOW_55); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:3560:6: lv_functionName_1_2= HyphenMinus
                    {
                    lv_functionName_1_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_55); if (state.failed) return current;
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

            // InternalExBeeLangTestLanguageParser.g:3573:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // InternalExBeeLangTestLanguageParser.g:3574:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:3574:4: (lv_expr_2_0= ruleInfixExpression )
            // InternalExBeeLangTestLanguageParser.g:3575:5: lv_expr_2_0= ruleInfixExpression
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
    // InternalExBeeLangTestLanguageParser.g:3596:1: entryRulePreopExpression returns [EObject current=null] : iv_rulePreopExpression= rulePreopExpression EOF ;
    public final EObject entryRulePreopExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePreopExpression_StartIndex = input.index();
        EObject iv_rulePreopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3596:56: (iv_rulePreopExpression= rulePreopExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3597:2: iv_rulePreopExpression= rulePreopExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3603:1: rulePreopExpression returns [EObject current=null] : ( () ( ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final EObject rulePreopExpression() throws RecognitionException {
        EObject current = null;
        int rulePreopExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3609:2: ( ( () ( ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:3610:2: ( () ( ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:3610:2: ( () ( ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // InternalExBeeLangTestLanguageParser.g:3611:3: () ( ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // InternalExBeeLangTestLanguageParser.g:3611:3: ()
            // InternalExBeeLangTestLanguageParser.g:3612:4: 
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

            // InternalExBeeLangTestLanguageParser.g:3621:3: ( ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) ) )
            // InternalExBeeLangTestLanguageParser.g:3622:4: ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) )
            {
            // InternalExBeeLangTestLanguageParser.g:3622:4: ( (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus ) )
            // InternalExBeeLangTestLanguageParser.g:3623:5: (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus )
            {
            // InternalExBeeLangTestLanguageParser.g:3623:5: (lv_functionName_1_1= PlusSignPlusSign | lv_functionName_1_2= HyphenMinusHyphenMinus )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==PlusSignPlusSign) ) {
                alt66=1;
            }
            else if ( (LA66_0==HyphenMinusHyphenMinus) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:3624:6: lv_functionName_1_1= PlusSignPlusSign
                    {
                    lv_functionName_1_1=(Token)match(input,PlusSignPlusSign,FollowSets000.FOLLOW_55); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:3635:6: lv_functionName_1_2= HyphenMinusHyphenMinus
                    {
                    lv_functionName_1_2=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_55); if (state.failed) return current;
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

            // InternalExBeeLangTestLanguageParser.g:3648:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // InternalExBeeLangTestLanguageParser.g:3649:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:3649:4: (lv_expr_2_0= ruleInfixExpression )
            // InternalExBeeLangTestLanguageParser.g:3650:5: lv_expr_2_0= ruleInfixExpression
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
    // InternalExBeeLangTestLanguageParser.g:3671:1: entryRulePostopExpression returns [EObject current=null] : iv_rulePostopExpression= rulePostopExpression EOF ;
    public final EObject entryRulePostopExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePostopExpression_StartIndex = input.index();
        EObject iv_rulePostopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3671:57: (iv_rulePostopExpression= rulePostopExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3672:2: iv_rulePostopExpression= rulePostopExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3678:1: rulePostopExpression returns [EObject current=null] : (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) ) )? ) ;
    public final EObject rulePostopExpression() throws RecognitionException {
        EObject current = null;
        int rulePostopExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject this_InfixExpression_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3684:2: ( (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) ) )? ) )
            // InternalExBeeLangTestLanguageParser.g:3685:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) ) )? )
            {
            // InternalExBeeLangTestLanguageParser.g:3685:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) ) )? )
            // InternalExBeeLangTestLanguageParser.g:3686:3: this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) ) )?
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
            // InternalExBeeLangTestLanguageParser.g:3697:3: ( () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==HyphenMinusHyphenMinus) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred99_InternalExBeeLangTestLanguageParser()) ) {
                    alt68=1;
                }
            }
            else if ( (LA68_0==PlusSignPlusSign) ) {
                int LA68_2 = input.LA(2);

                if ( (synpred99_InternalExBeeLangTestLanguageParser()) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:3698:4: () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:3698:4: ()
                    // InternalExBeeLangTestLanguageParser.g:3699:5: 
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

                    // InternalExBeeLangTestLanguageParser.g:3708:4: ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) )
                    // InternalExBeeLangTestLanguageParser.g:3709:5: ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:3709:5: ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) )
                    // InternalExBeeLangTestLanguageParser.g:3710:6: (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign )
                    {
                    // InternalExBeeLangTestLanguageParser.g:3710:6: (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==HyphenMinusHyphenMinus) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==PlusSignPlusSign) ) {
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
                            // InternalExBeeLangTestLanguageParser.g:3711:7: lv_functionName_2_1= HyphenMinusHyphenMinus
                            {
                            lv_functionName_2_1=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                            // InternalExBeeLangTestLanguageParser.g:3722:7: lv_functionName_2_2= PlusSignPlusSign
                            {
                            lv_functionName_2_2=(Token)match(input,PlusSignPlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:3740:1: entryRuleInfixExpression returns [EObject current=null] : iv_ruleInfixExpression= ruleInfixExpression EOF ;
    public final EObject entryRuleInfixExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInfixExpression_StartIndex = input.index();
        EObject iv_ruleInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3740:56: (iv_ruleInfixExpression= ruleInfixExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3741:2: iv_ruleInfixExpression= ruleInfixExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3747:1: ruleInfixExpression returns [EObject current=null] : (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis ) | ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket ) | ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) ;
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
            // InternalExBeeLangTestLanguageParser.g:3753:2: ( (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis ) | ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket ) | ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) )
            // InternalExBeeLangTestLanguageParser.g:3754:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis ) | ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket ) | ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3754:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis ) | ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket ) | ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            // InternalExBeeLangTestLanguageParser.g:3755:3: this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis ) | ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket ) | ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) ) )*
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
            // InternalExBeeLangTestLanguageParser.g:3766:3: ( ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis ) | ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket ) | ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==FullStop) ) {
                    int LA70_2 = input.LA(2);

                    if ( (synpred101_InternalExBeeLangTestLanguageParser()) ) {
                        alt70=1;
                    }
                    else if ( (synpred103_InternalExBeeLangTestLanguageParser()) ) {
                        alt70=3;
                    }


                }
                else if ( (LA70_0==LeftSquareBracket) ) {
                    int LA70_3 = input.LA(2);

                    if ( (synpred102_InternalExBeeLangTestLanguageParser()) ) {
                        alt70=2;
                    }


                }


                switch (alt70) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3767:4: ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3767:4: ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis )
            	    // InternalExBeeLangTestLanguageParser.g:3768:5: () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3768:5: ()
            	    // InternalExBeeLangTestLanguageParser.g:3769:6: 
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

            	    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getInfixExpressionAccess().getFullStopKeyword_1_0_1());
            	      				
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:3782:5: ( (lv_name_3_0= RULE_ID ) )
            	    // InternalExBeeLangTestLanguageParser.g:3783:6: (lv_name_3_0= RULE_ID )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3783:6: (lv_name_3_0= RULE_ID )
            	    // InternalExBeeLangTestLanguageParser.g:3784:7: lv_name_3_0= RULE_ID
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

            	    otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getInfixExpressionAccess().getLeftParenthesisKeyword_1_0_3());
            	      				
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:3804:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==Properties||LA69_0==Builder||LA69_0==Cached||(LA69_0>=Output && LA69_0<=Source)||LA69_0==Input||(LA69_0>=This && LA69_0<=Unit)||LA69_0==With||LA69_0==FullStopFullStopFullStop||LA69_0==New||LA69_0==PlusSignPlusSign||LA69_0==HyphenMinusHyphenMinus||LA69_0==ExclamationMark||LA69_0==LeftParenthesis||LA69_0==HyphenMinus||LA69_0==LessThanSign||(LA69_0>=LeftCurlyBracket && LA69_0<=VerticalLine)||LA69_0==RULE_ID||LA69_0==RULE_STRING) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // InternalExBeeLangTestLanguageParser.g:3805:6: (lv_parameterList_5_0= ruleParameterList )
            	            {
            	            // InternalExBeeLangTestLanguageParser.g:3805:6: (lv_parameterList_5_0= ruleParameterList )
            	            // InternalExBeeLangTestLanguageParser.g:3806:7: lv_parameterList_5_0= ruleParameterList
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

            	    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getInfixExpressionAccess().getRightParenthesisKeyword_1_0_5());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalExBeeLangTestLanguageParser.g:3829:4: ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3829:4: ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket )
            	    // InternalExBeeLangTestLanguageParser.g:3830:5: () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3830:5: ()
            	    // InternalExBeeLangTestLanguageParser.g:3831:6: 
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

            	    otherlv_8=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_8, grammarAccess.getInfixExpressionAccess().getLeftSquareBracketKeyword_1_1_1());
            	      				
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:3844:5: ( (lv_indexExpr_9_0= ruleExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:3845:6: (lv_indexExpr_9_0= ruleExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3845:6: (lv_indexExpr_9_0= ruleExpression )
            	    // InternalExBeeLangTestLanguageParser.g:3846:7: lv_indexExpr_9_0= ruleExpression
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

            	    otherlv_10=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getInfixExpressionAccess().getRightSquareBracketKeyword_1_1_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalExBeeLangTestLanguageParser.g:3869:4: ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3869:4: ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) )
            	    // InternalExBeeLangTestLanguageParser.g:3870:5: () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3870:5: ()
            	    // InternalExBeeLangTestLanguageParser.g:3871:6: 
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

            	    otherlv_12=(Token)match(input,FullStop,FollowSets000.FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_12, grammarAccess.getInfixExpressionAccess().getFullStopKeyword_1_2_1());
            	      				
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:3884:5: ( (lv_featureName_13_0= RULE_ID ) )
            	    // InternalExBeeLangTestLanguageParser.g:3885:6: (lv_featureName_13_0= RULE_ID )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3885:6: (lv_featureName_13_0= RULE_ID )
            	    // InternalExBeeLangTestLanguageParser.g:3886:7: lv_featureName_13_0= RULE_ID
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
    // InternalExBeeLangTestLanguageParser.g:3908:1: entryRuleCallExpression returns [EObject current=null] : iv_ruleCallExpression= ruleCallExpression EOF ;
    public final EObject entryRuleCallExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleCallExpression_StartIndex = input.index();
        EObject iv_ruleCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3908:55: (iv_ruleCallExpression= ruleCallExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3909:2: iv_ruleCallExpression= ruleCallExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3915:1: ruleCallExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )* ) ;
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
            // InternalExBeeLangTestLanguageParser.g:3921:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )* ) )
            // InternalExBeeLangTestLanguageParser.g:3922:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )* )
            {
            // InternalExBeeLangTestLanguageParser.g:3922:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )* )
            // InternalExBeeLangTestLanguageParser.g:3923:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )*
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
            // InternalExBeeLangTestLanguageParser.g:3934:3: ( () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==LeftParenthesis) ) {
                    int LA72_2 = input.LA(2);

                    if ( (synpred105_InternalExBeeLangTestLanguageParser()) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:3935:4: () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:3935:4: ()
            	    // InternalExBeeLangTestLanguageParser.g:3936:5: 
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

            	    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getCallExpressionAccess().getLeftParenthesisKeyword_1_1());
            	      			
            	    }
            	    // InternalExBeeLangTestLanguageParser.g:3949:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==Properties||LA71_0==Builder||LA71_0==Cached||(LA71_0>=Output && LA71_0<=Source)||LA71_0==Input||(LA71_0>=This && LA71_0<=Unit)||LA71_0==With||LA71_0==FullStopFullStopFullStop||LA71_0==New||LA71_0==PlusSignPlusSign||LA71_0==HyphenMinusHyphenMinus||LA71_0==ExclamationMark||LA71_0==LeftParenthesis||LA71_0==HyphenMinus||LA71_0==LessThanSign||(LA71_0>=LeftCurlyBracket && LA71_0<=VerticalLine)||LA71_0==RULE_ID||LA71_0==RULE_STRING) ) {
            	        alt71=1;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // InternalExBeeLangTestLanguageParser.g:3950:5: (lv_parameterList_3_0= ruleParameterList )
            	            {
            	            // InternalExBeeLangTestLanguageParser.g:3950:5: (lv_parameterList_3_0= ruleParameterList )
            	            // InternalExBeeLangTestLanguageParser.g:3951:6: lv_parameterList_3_0= ruleParameterList
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

            	    otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_61); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:3977:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;
        int entryRulePrimaryExpression_StartIndex = input.index();
        EObject iv_rulePrimaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:3977:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:3978:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:3984:1: rulePrimaryExpression returns [EObject current=null] : (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) ;
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
            // InternalExBeeLangTestLanguageParser.g:3990:2: ( (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) )
            // InternalExBeeLangTestLanguageParser.g:3991:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:3991:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            int alt73=9;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:3992:3: this_FeatureCall_0= ruleFeatureCall
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
                    // InternalExBeeLangTestLanguageParser.g:4004:3: this_ConstructorCallExpression_1= ruleConstructorCallExpression
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
                    // InternalExBeeLangTestLanguageParser.g:4016:3: this_Value_2= ruleValue
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
                    // InternalExBeeLangTestLanguageParser.g:4028:3: this_Literal_3= ruleLiteral
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
                    // InternalExBeeLangTestLanguageParser.g:4040:3: this_KeywordVariables_4= ruleKeywordVariables
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
                    // InternalExBeeLangTestLanguageParser.g:4052:3: this_ParanthesizedExpression_5= ruleParanthesizedExpression
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
                    // InternalExBeeLangTestLanguageParser.g:4064:3: this_BlockExpression_6= ruleBlockExpression
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
                    // InternalExBeeLangTestLanguageParser.g:4076:3: this_WithExpression_7= ruleWithExpression
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
                    // InternalExBeeLangTestLanguageParser.g:4088:3: this_WithContextExpression_8= ruleWithContextExpression
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
    // InternalExBeeLangTestLanguageParser.g:4103:1: entryRuleWithExpression returns [EObject current=null] : iv_ruleWithExpression= ruleWithExpression EOF ;
    public final EObject entryRuleWithExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleWithExpression_StartIndex = input.index();
        EObject iv_ruleWithExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4103:55: (iv_ruleWithExpression= ruleWithExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:4104:2: iv_ruleWithExpression= ruleWithExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:4110:1: ruleWithExpression returns [EObject current=null] : (otherlv_0= With ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:4116:2: ( (otherlv_0= With ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:4117:2: (otherlv_0= With ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4117:2: (otherlv_0= With ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket ) ) )
            // InternalExBeeLangTestLanguageParser.g:4118:3: otherlv_0= With ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket ) )
            {
            otherlv_0=(Token)match(input,With,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWithExpressionAccess().getWithKeyword_0());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:4122:3: ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:4123:4: ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    {
                    // InternalExBeeLangTestLanguageParser.g:4123:4: ( (lv_referencedAdvice_1_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:4124:5: (lv_referencedAdvice_1_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4124:5: (lv_referencedAdvice_1_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:4125:6: lv_referencedAdvice_1_0= RULE_ID
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

                    // InternalExBeeLangTestLanguageParser.g:4141:4: (otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==Comma) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:4142:5: otherlv_2= Comma ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    {
                    	    otherlv_2=(Token)match(input,Comma,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_2, grammarAccess.getWithExpressionAccess().getCommaKeyword_1_1_0());
                    	      				
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:4146:5: ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    // InternalExBeeLangTestLanguageParser.g:4147:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:4147:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    // InternalExBeeLangTestLanguageParser.g:4148:7: lv_referencedAdvice_3_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:4166:3: ( (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==Colon) ) {
                alt76=1;
            }
            else if ( (LA76_0==LeftCurlyBracket) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:4167:4: (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4167:4: (otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    // InternalExBeeLangTestLanguageParser.g:4168:5: otherlv_4= Colon ( (lv_funcExpr_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getWithExpressionAccess().getColonKeyword_2_0_0());
                      				
                    }
                    // InternalExBeeLangTestLanguageParser.g:4172:5: ( (lv_funcExpr_5_0= ruleExpression ) )
                    // InternalExBeeLangTestLanguageParser.g:4173:6: (lv_funcExpr_5_0= ruleExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4173:6: (lv_funcExpr_5_0= ruleExpression )
                    // InternalExBeeLangTestLanguageParser.g:4174:7: lv_funcExpr_5_0= ruleExpression
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
                    // InternalExBeeLangTestLanguageParser.g:4193:4: (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4193:4: (otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket )
                    // InternalExBeeLangTestLanguageParser.g:4194:5: otherlv_6= LeftCurlyBracket ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= RightCurlyBracket
                    {
                    otherlv_6=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getWithExpressionAccess().getLeftCurlyBracketKeyword_2_1_0());
                      				
                    }
                    // InternalExBeeLangTestLanguageParser.g:4198:5: ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) )
                    // InternalExBeeLangTestLanguageParser.g:4199:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4199:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    // InternalExBeeLangTestLanguageParser.g:4200:7: lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets
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

                    otherlv_8=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:4227:1: entryRuleWithContextExpression returns [EObject current=null] : iv_ruleWithContextExpression= ruleWithContextExpression EOF ;
    public final EObject entryRuleWithContextExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleWithContextExpression_StartIndex = input.index();
        EObject iv_ruleWithContextExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4227:62: (iv_ruleWithContextExpression= ruleWithContextExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:4228:2: iv_ruleWithContextExpression= ruleWithContextExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:4234:1: ruleWithContextExpression returns [EObject current=null] : (otherlv_0= With otherlv_1= Context ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:4240:2: ( (otherlv_0= With otherlv_1= Context ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:4241:2: (otherlv_0= With otherlv_1= Context ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4241:2: (otherlv_0= With otherlv_1= Context ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            // InternalExBeeLangTestLanguageParser.g:4242:3: otherlv_0= With otherlv_1= Context ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            {
            otherlv_0=(Token)match(input,With,FollowSets000.FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWithContextExpressionAccess().getWithKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,Context,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWithContextExpressionAccess().getContextKeyword_1());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:4250:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalExBeeLangTestLanguageParser.g:4251:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:4251:4: (lv_expr_2_0= ruleExpression )
            // InternalExBeeLangTestLanguageParser.g:4252:5: lv_expr_2_0= ruleExpression
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

            // InternalExBeeLangTestLanguageParser.g:4269:3: (otherlv_3= As ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==As) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:4270:4: otherlv_3= As ( (lv_alias_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,As,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getWithContextExpressionAccess().getAsKeyword_3_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:4274:4: ( (lv_alias_4_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:4275:5: (lv_alias_4_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4275:5: (lv_alias_4_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:4276:6: lv_alias_4_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:4293:3: ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            // InternalExBeeLangTestLanguageParser.g:4294:4: (lv_contextBlock_5_0= ruleBlockExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:4294:4: (lv_contextBlock_5_0= ruleBlockExpression )
            // InternalExBeeLangTestLanguageParser.g:4295:5: lv_contextBlock_5_0= ruleBlockExpression
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
    // InternalExBeeLangTestLanguageParser.g:4316:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleBlockExpression_StartIndex = input.index();
        EObject iv_ruleBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4316:56: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:4317:2: iv_ruleBlockExpression= ruleBlockExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:4323:1: ruleBlockExpression returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= Semicolon )* otherlv_4= RightCurlyBracket ) ;
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
            // InternalExBeeLangTestLanguageParser.g:4329:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= Semicolon )* otherlv_4= RightCurlyBracket ) )
            // InternalExBeeLangTestLanguageParser.g:4330:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= Semicolon )* otherlv_4= RightCurlyBracket )
            {
            // InternalExBeeLangTestLanguageParser.g:4330:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= Semicolon )* otherlv_4= RightCurlyBracket )
            // InternalExBeeLangTestLanguageParser.g:4331:3: () otherlv_1= LeftCurlyBracket ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= Semicolon )* otherlv_4= RightCurlyBracket
            {
            // InternalExBeeLangTestLanguageParser.g:4331:3: ()
            // InternalExBeeLangTestLanguageParser.g:4332:4: 
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

            otherlv_1=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:4345:3: ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= Semicolon )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==Properties||LA78_0==Builder||LA78_0==Cached||(LA78_0>=Output && LA78_0<=Input)||(LA78_0>=This && LA78_0<=Unit)||LA78_0==With||(LA78_0>=New && LA78_0<=Var)||LA78_0==PlusSignPlusSign||LA78_0==HyphenMinusHyphenMinus||LA78_0==ExclamationMark||LA78_0==LeftParenthesis||LA78_0==HyphenMinus||LA78_0==LeftCurlyBracket||LA78_0==RULE_ID||LA78_0==RULE_STRING) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:4346:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= Semicolon
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:4346:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:4347:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:4347:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    // InternalExBeeLangTestLanguageParser.g:4348:6: lv_expressions_2_0= ruleTopLevelExpression
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

            	    otherlv_3=(Token)match(input,Semicolon,FollowSets000.FOLLOW_67); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_2_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            otherlv_4=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:4378:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;
        int entryRuleValue_StartIndex = input.index();
        EObject iv_ruleValue = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4378:46: (iv_ruleValue= ruleValue EOF )
            // InternalExBeeLangTestLanguageParser.g:4379:2: iv_ruleValue= ruleValue EOF
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
    // InternalExBeeLangTestLanguageParser.g:4385:1: ruleValue returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;
        int ruleValue_StartIndex = input.index();
        Token lv_name_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4391:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:4392:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4392:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalExBeeLangTestLanguageParser.g:4393:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4393:3: ()
            // InternalExBeeLangTestLanguageParser.g:4394:4: 
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

            // InternalExBeeLangTestLanguageParser.g:4403:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:4404:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:4404:4: (lv_name_1_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:4405:5: lv_name_1_0= RULE_ID
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
    // InternalExBeeLangTestLanguageParser.g:4425:1: entryRuleKeywordVariables returns [EObject current=null] : iv_ruleKeywordVariables= ruleKeywordVariables EOF ;
    public final EObject entryRuleKeywordVariables() throws RecognitionException {
        EObject current = null;
        int entryRuleKeywordVariables_StartIndex = input.index();
        EObject iv_ruleKeywordVariables = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4425:57: (iv_ruleKeywordVariables= ruleKeywordVariables EOF )
            // InternalExBeeLangTestLanguageParser.g:4426:2: iv_ruleKeywordVariables= ruleKeywordVariables EOF
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
    // InternalExBeeLangTestLanguageParser.g:4432:1: ruleKeywordVariables returns [EObject current=null] : ( () ( ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:4438:2: ( ( () ( ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:4439:2: ( () ( ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4439:2: ( () ( ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:4440:3: () ( ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4440:3: ()
            // InternalExBeeLangTestLanguageParser.g:4441:4: 
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

            // InternalExBeeLangTestLanguageParser.g:4450:3: ( ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) ) )
            // InternalExBeeLangTestLanguageParser.g:4451:4: ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4451:4: ( (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This ) )
            // InternalExBeeLangTestLanguageParser.g:4452:5: (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This )
            {
            // InternalExBeeLangTestLanguageParser.g:4452:5: (lv_name_1_1= Input | lv_name_1_2= Output | lv_name_1_3= Source | lv_name_1_4= Properties | lv_name_1_5= Builder | lv_name_1_6= Unit | lv_name_1_7= This )
            int alt79=7;
            switch ( input.LA(1) ) {
            case Input:
                {
                alt79=1;
                }
                break;
            case Output:
                {
                alt79=2;
                }
                break;
            case Source:
                {
                alt79=3;
                }
                break;
            case Properties:
                {
                alt79=4;
                }
                break;
            case Builder:
                {
                alt79=5;
                }
                break;
            case Unit:
                {
                alt79=6;
                }
                break;
            case This:
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
                    // InternalExBeeLangTestLanguageParser.g:4453:6: lv_name_1_1= Input
                    {
                    lv_name_1_1=(Token)match(input,Input,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:4464:6: lv_name_1_2= Output
                    {
                    lv_name_1_2=(Token)match(input,Output,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:4475:6: lv_name_1_3= Source
                    {
                    lv_name_1_3=(Token)match(input,Source,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:4486:6: lv_name_1_4= Properties
                    {
                    lv_name_1_4=(Token)match(input,Properties,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:4497:6: lv_name_1_5= Builder
                    {
                    lv_name_1_5=(Token)match(input,Builder,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:4508:6: lv_name_1_6= Unit
                    {
                    lv_name_1_6=(Token)match(input,Unit,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
                    // InternalExBeeLangTestLanguageParser.g:4519:6: lv_name_1_7= This
                    {
                    lv_name_1_7=(Token)match(input,This,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:4536:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;
        int entryRuleFeatureCall_StartIndex = input.index();
        EObject iv_ruleFeatureCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4536:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalExBeeLangTestLanguageParser.g:4537:2: iv_ruleFeatureCall= ruleFeatureCall EOF
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
    // InternalExBeeLangTestLanguageParser.g:4543:1: ruleFeatureCall returns [EObject current=null] : this_OperationCall_0= ruleOperationCall ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;
        int ruleFeatureCall_StartIndex = input.index();
        EObject this_OperationCall_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4549:2: (this_OperationCall_0= ruleOperationCall )
            // InternalExBeeLangTestLanguageParser.g:4550:2: this_OperationCall_0= ruleOperationCall
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
    // InternalExBeeLangTestLanguageParser.g:4564:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;
        int entryRuleOperationCall_StartIndex = input.index();
        EObject iv_ruleOperationCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4564:54: (iv_ruleOperationCall= ruleOperationCall EOF )
            // InternalExBeeLangTestLanguageParser.g:4565:2: iv_ruleOperationCall= ruleOperationCall EOF
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
    // InternalExBeeLangTestLanguageParser.g:4571:1: ruleOperationCall returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis ) ;
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
            // InternalExBeeLangTestLanguageParser.g:4577:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis ) )
            // InternalExBeeLangTestLanguageParser.g:4578:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )
            {
            // InternalExBeeLangTestLanguageParser.g:4578:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )
            // InternalExBeeLangTestLanguageParser.g:4579:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis
            {
            // InternalExBeeLangTestLanguageParser.g:4579:3: ()
            // InternalExBeeLangTestLanguageParser.g:4580:4: 
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

            // InternalExBeeLangTestLanguageParser.g:4589:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:4590:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:4590:4: (lv_name_1_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:4591:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:4611:3: ( (lv_parameterList_3_0= ruleParameterList ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==Properties||LA80_0==Builder||LA80_0==Cached||(LA80_0>=Output && LA80_0<=Source)||LA80_0==Input||(LA80_0>=This && LA80_0<=Unit)||LA80_0==With||LA80_0==FullStopFullStopFullStop||LA80_0==New||LA80_0==PlusSignPlusSign||LA80_0==HyphenMinusHyphenMinus||LA80_0==ExclamationMark||LA80_0==LeftParenthesis||LA80_0==HyphenMinus||LA80_0==LessThanSign||(LA80_0>=LeftCurlyBracket && LA80_0<=VerticalLine)||LA80_0==RULE_ID||LA80_0==RULE_STRING) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:4612:4: (lv_parameterList_3_0= ruleParameterList )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4612:4: (lv_parameterList_3_0= ruleParameterList )
                    // InternalExBeeLangTestLanguageParser.g:4613:5: lv_parameterList_3_0= ruleParameterList
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

            otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:4638:1: entryRuleConstructorCallExpression returns [EObject current=null] : iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF ;
    public final EObject entryRuleConstructorCallExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleConstructorCallExpression_StartIndex = input.index();
        EObject iv_ruleConstructorCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4638:66: (iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:4639:2: iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:4645:1: ruleConstructorCallExpression returns [EObject current=null] : ( () otherlv_1= New ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )? (otherlv_6= As ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) ;
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
            // InternalExBeeLangTestLanguageParser.g:4651:2: ( ( () otherlv_1= New ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )? (otherlv_6= As ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) )
            // InternalExBeeLangTestLanguageParser.g:4652:2: ( () otherlv_1= New ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )? (otherlv_6= As ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            {
            // InternalExBeeLangTestLanguageParser.g:4652:2: ( () otherlv_1= New ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )? (otherlv_6= As ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            // InternalExBeeLangTestLanguageParser.g:4653:3: () otherlv_1= New ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )? (otherlv_6= As ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            {
            // InternalExBeeLangTestLanguageParser.g:4653:3: ()
            // InternalExBeeLangTestLanguageParser.g:4654:4: 
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

            otherlv_1=(Token)match(input,New,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstructorCallExpressionAccess().getNewKeyword_1());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:4667:3: ( (lv_typeExpr_2_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:4668:4: (lv_typeExpr_2_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:4668:4: (lv_typeExpr_2_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:4669:5: lv_typeExpr_2_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:4685:3: (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:4686:4: otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis
                    {
                    otherlv_3=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getConstructorCallExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:4690:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==Properties||LA81_0==Builder||LA81_0==Cached||(LA81_0>=Output && LA81_0<=Source)||LA81_0==Input||(LA81_0>=This && LA81_0<=Unit)||LA81_0==With||LA81_0==FullStopFullStopFullStop||LA81_0==New||LA81_0==PlusSignPlusSign||LA81_0==HyphenMinusHyphenMinus||LA81_0==ExclamationMark||LA81_0==LeftParenthesis||LA81_0==HyphenMinus||LA81_0==LessThanSign||(LA81_0>=LeftCurlyBracket && LA81_0<=VerticalLine)||LA81_0==RULE_ID||LA81_0==RULE_STRING) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalExBeeLangTestLanguageParser.g:4691:5: (lv_parameterList_4_0= ruleParameterList )
                            {
                            // InternalExBeeLangTestLanguageParser.g:4691:5: (lv_parameterList_4_0= ruleParameterList )
                            // InternalExBeeLangTestLanguageParser.g:4692:6: lv_parameterList_4_0= ruleParameterList
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

                    otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getConstructorCallExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:4714:3: (otherlv_6= As ( (lv_alias_7_0= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==As) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ID) ) {
                    int LA83_3 = input.LA(3);

                    if ( (synpred128_InternalExBeeLangTestLanguageParser()) ) {
                        alt83=1;
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:4715:4: otherlv_6= As ( (lv_alias_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,As,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getConstructorCallExpressionAccess().getAsKeyword_4_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:4719:4: ( (lv_alias_7_0= RULE_ID ) )
                    // InternalExBeeLangTestLanguageParser.g:4720:5: (lv_alias_7_0= RULE_ID )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4720:5: (lv_alias_7_0= RULE_ID )
                    // InternalExBeeLangTestLanguageParser.g:4721:6: lv_alias_7_0= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:4738:3: ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==LeftCurlyBracket) ) {
                int LA84_1 = input.LA(2);

                if ( (LA84_1==RULE_ID) ) {
                    int LA84_3 = input.LA(3);

                    if ( (LA84_3==Colon) ) {
                        alt84=1;
                    }
                }
            }
            switch (alt84) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:4739:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    {
                    // InternalExBeeLangTestLanguageParser.g:4739:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    // InternalExBeeLangTestLanguageParser.g:4740:5: lv_contextBlock_8_0= ruleInitializationBlockExpression
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
    // InternalExBeeLangTestLanguageParser.g:4761:1: entryRuleInitializationBlockExpression returns [EObject current=null] : iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF ;
    public final EObject entryRuleInitializationBlockExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInitializationBlockExpression_StartIndex = input.index();
        EObject iv_ruleInitializationBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4761:70: (iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:4762:2: iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:4768:1: ruleInitializationBlockExpression returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= Semicolon otherlv_4= RightCurlyBracket ) ;
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
            // InternalExBeeLangTestLanguageParser.g:4774:2: ( ( () otherlv_1= LeftCurlyBracket ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= Semicolon otherlv_4= RightCurlyBracket ) )
            // InternalExBeeLangTestLanguageParser.g:4775:2: ( () otherlv_1= LeftCurlyBracket ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= Semicolon otherlv_4= RightCurlyBracket )
            {
            // InternalExBeeLangTestLanguageParser.g:4775:2: ( () otherlv_1= LeftCurlyBracket ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= Semicolon otherlv_4= RightCurlyBracket )
            // InternalExBeeLangTestLanguageParser.g:4776:3: () otherlv_1= LeftCurlyBracket ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= Semicolon otherlv_4= RightCurlyBracket
            {
            // InternalExBeeLangTestLanguageParser.g:4776:3: ()
            // InternalExBeeLangTestLanguageParser.g:4777:4: 
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

            otherlv_1=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInitializationBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:4790:3: ( (lv_expressions_2_0= ruleInitializationExpression ) )
            // InternalExBeeLangTestLanguageParser.g:4791:4: (lv_expressions_2_0= ruleInitializationExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:4791:4: (lv_expressions_2_0= ruleInitializationExpression )
            // InternalExBeeLangTestLanguageParser.g:4792:5: lv_expressions_2_0= ruleInitializationExpression
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

            otherlv_3=(Token)match(input,Semicolon,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInitializationBlockExpressionAccess().getSemicolonKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:4821:1: entryRuleInitializationExpression returns [EObject current=null] : iv_ruleInitializationExpression= ruleInitializationExpression EOF ;
    public final EObject entryRuleInitializationExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleInitializationExpression_StartIndex = input.index();
        EObject iv_ruleInitializationExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4821:65: (iv_ruleInitializationExpression= ruleInitializationExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:4822:2: iv_ruleInitializationExpression= ruleInitializationExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:4828:1: ruleInitializationExpression returns [EObject current=null] : ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= Colon ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleInitializationExpression() throws RecognitionException {
        EObject current = null;
        int ruleInitializationExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        EObject lv_leftExpr_1_0 = null;

        EObject lv_rightExpr_3_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4834:2: ( ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= Colon ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:4835:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= Colon ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4835:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= Colon ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            // InternalExBeeLangTestLanguageParser.g:4836:3: () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= Colon ) ) ( (lv_rightExpr_3_0= ruleExpression ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4836:3: ()
            // InternalExBeeLangTestLanguageParser.g:4837:4: 
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

            // InternalExBeeLangTestLanguageParser.g:4846:3: ( (lv_leftExpr_1_0= ruleFeatureOfThis ) )
            // InternalExBeeLangTestLanguageParser.g:4847:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            {
            // InternalExBeeLangTestLanguageParser.g:4847:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            // InternalExBeeLangTestLanguageParser.g:4848:5: lv_leftExpr_1_0= ruleFeatureOfThis
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

            // InternalExBeeLangTestLanguageParser.g:4865:3: ( (lv_functionName_2_0= Colon ) )
            // InternalExBeeLangTestLanguageParser.g:4866:4: (lv_functionName_2_0= Colon )
            {
            // InternalExBeeLangTestLanguageParser.g:4866:4: (lv_functionName_2_0= Colon )
            // InternalExBeeLangTestLanguageParser.g:4867:5: lv_functionName_2_0= Colon
            {
            lv_functionName_2_0=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return current;
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

            // InternalExBeeLangTestLanguageParser.g:4879:3: ( (lv_rightExpr_3_0= ruleExpression ) )
            // InternalExBeeLangTestLanguageParser.g:4880:4: (lv_rightExpr_3_0= ruleExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:4880:4: (lv_rightExpr_3_0= ruleExpression )
            // InternalExBeeLangTestLanguageParser.g:4881:5: lv_rightExpr_3_0= ruleExpression
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
    // InternalExBeeLangTestLanguageParser.g:4902:1: entryRuleFeatureOfThis returns [EObject current=null] : iv_ruleFeatureOfThis= ruleFeatureOfThis EOF ;
    public final EObject entryRuleFeatureOfThis() throws RecognitionException {
        EObject current = null;
        int entryRuleFeatureOfThis_StartIndex = input.index();
        EObject iv_ruleFeatureOfThis = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4902:54: (iv_ruleFeatureOfThis= ruleFeatureOfThis EOF )
            // InternalExBeeLangTestLanguageParser.g:4903:2: iv_ruleFeatureOfThis= ruleFeatureOfThis EOF
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
    // InternalExBeeLangTestLanguageParser.g:4909:1: ruleFeatureOfThis returns [EObject current=null] : ( () ( (lv_featureName_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFeatureOfThis() throws RecognitionException {
        EObject current = null;
        int ruleFeatureOfThis_StartIndex = input.index();
        Token lv_featureName_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4915:2: ( ( () ( (lv_featureName_1_0= RULE_ID ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:4916:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4916:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            // InternalExBeeLangTestLanguageParser.g:4917:3: () ( (lv_featureName_1_0= RULE_ID ) )
            {
            // InternalExBeeLangTestLanguageParser.g:4917:3: ()
            // InternalExBeeLangTestLanguageParser.g:4918:4: 
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

            // InternalExBeeLangTestLanguageParser.g:4927:3: ( (lv_featureName_1_0= RULE_ID ) )
            // InternalExBeeLangTestLanguageParser.g:4928:4: (lv_featureName_1_0= RULE_ID )
            {
            // InternalExBeeLangTestLanguageParser.g:4928:4: (lv_featureName_1_0= RULE_ID )
            // InternalExBeeLangTestLanguageParser.g:4929:5: lv_featureName_1_0= RULE_ID
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
    // InternalExBeeLangTestLanguageParser.g:4949:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteral_StartIndex = input.index();
        EObject iv_ruleLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4949:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalExBeeLangTestLanguageParser.g:4950:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalExBeeLangTestLanguageParser.g:4956:1: ruleLiteral returns [EObject current=null] : (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;
        int ruleLiteral_StartIndex = input.index();
        EObject this_ValueLiteral_0 = null;

        EObject this_LiteralFunction_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4962:2: ( (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) )
            // InternalExBeeLangTestLanguageParser.g:4963:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            {
            // InternalExBeeLangTestLanguageParser.g:4963:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_STRING) ) {
                alt85=1;
            }
            else if ( (LA85_0==LeftCurlyBracket) ) {
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
                    // InternalExBeeLangTestLanguageParser.g:4964:3: this_ValueLiteral_0= ruleValueLiteral
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
                    // InternalExBeeLangTestLanguageParser.g:4976:3: this_LiteralFunction_1= ruleLiteralFunction
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
abstract class InternalExBeeLangTestLanguageParser3 extends InternalExBeeLangTestLanguageParser2 {

        InternalExBeeLangTestLanguageParser3(TokenStream input) {
            this(input, new RecognizerSharedState());
        }

        InternalExBeeLangTestLanguageParser3(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }

    // $ANTLR start "entryRuleLiteralFunction"
    // InternalExBeeLangTestLanguageParser.g:4991:1: entryRuleLiteralFunction returns [EObject current=null] : iv_ruleLiteralFunction= ruleLiteralFunction EOF ;
    public final EObject entryRuleLiteralFunction() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteralFunction_StartIndex = input.index();
        EObject iv_ruleLiteralFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:4991:56: (iv_ruleLiteralFunction= ruleLiteralFunction EOF )
            // InternalExBeeLangTestLanguageParser.g:4992:2: iv_ruleLiteralFunction= ruleLiteralFunction EOF
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
    // InternalExBeeLangTestLanguageParser.g:4998:1: ruleLiteralFunction returns [EObject current=null] : (otherlv_0= LeftCurlyBracket this_ClosureExpression_1= ruleClosureExpression otherlv_2= RightCurlyBracket ) ;
    public final EObject ruleLiteralFunction() throws RecognitionException {
        EObject current = null;
        int ruleLiteralFunction_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_ClosureExpression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5004:2: ( (otherlv_0= LeftCurlyBracket this_ClosureExpression_1= ruleClosureExpression otherlv_2= RightCurlyBracket ) )
            // InternalExBeeLangTestLanguageParser.g:5005:2: (otherlv_0= LeftCurlyBracket this_ClosureExpression_1= ruleClosureExpression otherlv_2= RightCurlyBracket )
            {
            // InternalExBeeLangTestLanguageParser.g:5005:2: (otherlv_0= LeftCurlyBracket this_ClosureExpression_1= ruleClosureExpression otherlv_2= RightCurlyBracket )
            // InternalExBeeLangTestLanguageParser.g:5006:3: otherlv_0= LeftCurlyBracket this_ClosureExpression_1= ruleClosureExpression otherlv_2= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_70); if (state.failed) return current;
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
            otherlv_2=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:5029:1: entryRuleClosureExpression returns [EObject current=null] : iv_ruleClosureExpression= ruleClosureExpression EOF ;
    public final EObject entryRuleClosureExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleClosureExpression_StartIndex = input.index();
        EObject iv_ruleClosureExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5029:58: (iv_ruleClosureExpression= ruleClosureExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:5030:2: iv_ruleClosureExpression= ruleClosureExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:5036:1: ruleClosureExpression returns [EObject current=null] : ( () (otherlv_1= LessThanSign ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= GreaterThanSign )? ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= VerticalLine ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) ;
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
            // InternalExBeeLangTestLanguageParser.g:5042:2: ( ( () (otherlv_1= LessThanSign ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= GreaterThanSign )? ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= VerticalLine ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) )
            // InternalExBeeLangTestLanguageParser.g:5043:2: ( () (otherlv_1= LessThanSign ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= GreaterThanSign )? ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= VerticalLine ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            {
            // InternalExBeeLangTestLanguageParser.g:5043:2: ( () (otherlv_1= LessThanSign ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= GreaterThanSign )? ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= VerticalLine ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            // InternalExBeeLangTestLanguageParser.g:5044:3: () (otherlv_1= LessThanSign ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= GreaterThanSign )? ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= VerticalLine ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            {
            // InternalExBeeLangTestLanguageParser.g:5044:3: ()
            // InternalExBeeLangTestLanguageParser.g:5045:4: 
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

            // InternalExBeeLangTestLanguageParser.g:5054:3: (otherlv_1= LessThanSign ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= GreaterThanSign )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==LessThanSign) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:5055:4: otherlv_1= LessThanSign ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= GreaterThanSign
                    {
                    otherlv_1=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getClosureExpressionAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalExBeeLangTestLanguageParser.g:5059:4: ( (lv_returnType_2_0= ruleTypeRef ) )
                    // InternalExBeeLangTestLanguageParser.g:5060:5: (lv_returnType_2_0= ruleTypeRef )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5060:5: (lv_returnType_2_0= ruleTypeRef )
                    // InternalExBeeLangTestLanguageParser.g:5061:6: lv_returnType_2_0= ruleTypeRef
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

                    otherlv_3=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getClosureExpressionAccess().getGreaterThanSignKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalExBeeLangTestLanguageParser.g:5083:3: ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?
            int alt90=3;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:5084:4: ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5084:4: ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    // InternalExBeeLangTestLanguageParser.g:5085:5: (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5085:5: (otherlv_4= VerticalLine )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==VerticalLine) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalExBeeLangTestLanguageParser.g:5086:6: otherlv_4= VerticalLine
                            {
                            otherlv_4=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getClosureExpressionAccess().getVerticalLineKeyword_2_0_0());
                              					
                            }

                            }
                            break;

                    }

                    // InternalExBeeLangTestLanguageParser.g:5091:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    // InternalExBeeLangTestLanguageParser.g:5092:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    {
                    // InternalExBeeLangTestLanguageParser.g:5092:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    // InternalExBeeLangTestLanguageParser.g:5093:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5093:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    // InternalExBeeLangTestLanguageParser.g:5094:8: lv_parameters_5_0= ruleParameterDeclaration
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

                    // InternalExBeeLangTestLanguageParser.g:5111:6: (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==Comma) ) {
                            int LA88_1 = input.LA(2);

                            if ( (LA88_1==LeftParenthesis||LA88_1==RULE_ID) ) {
                                alt88=1;
                            }


                        }


                        switch (alt88) {
                    	case 1 :
                    	    // InternalExBeeLangTestLanguageParser.g:5112:7: otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Comma,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_6, grammarAccess.getClosureExpressionAccess().getCommaKeyword_2_0_1_1_0());
                    	      						
                    	    }
                    	    // InternalExBeeLangTestLanguageParser.g:5116:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    // InternalExBeeLangTestLanguageParser.g:5117:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    {
                    	    // InternalExBeeLangTestLanguageParser.g:5117:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    // InternalExBeeLangTestLanguageParser.g:5118:9: lv_parameters_7_0= ruleParameterDeclaration
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

                    // InternalExBeeLangTestLanguageParser.g:5136:6: (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==Comma) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalExBeeLangTestLanguageParser.g:5137:7: otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            {
                            otherlv_8=(Token)match(input,Comma,FollowSets000.FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_8, grammarAccess.getClosureExpressionAccess().getCommaKeyword_2_0_1_2_0());
                              						
                            }
                            // InternalExBeeLangTestLanguageParser.g:5141:7: ( (lv_varArgs_9_0= FullStopFullStopFullStop ) )
                            // InternalExBeeLangTestLanguageParser.g:5142:8: (lv_varArgs_9_0= FullStopFullStopFullStop )
                            {
                            // InternalExBeeLangTestLanguageParser.g:5142:8: (lv_varArgs_9_0= FullStopFullStopFullStop )
                            // InternalExBeeLangTestLanguageParser.g:5143:9: lv_varArgs_9_0= FullStopFullStopFullStop
                            {
                            lv_varArgs_9_0=(Token)match(input,FullStopFullStopFullStop,FollowSets000.FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									newLeafNode(lv_varArgs_9_0, grammarAccess.getClosureExpressionAccess().getVarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0());
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getClosureExpressionRule());
                              									}
                              									setWithLastConsumed(current, "varArgs", lv_varArgs_9_0 != null, "...");
                              								
                            }

                            }


                            }

                            // InternalExBeeLangTestLanguageParser.g:5155:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            // InternalExBeeLangTestLanguageParser.g:5156:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            {
                            // InternalExBeeLangTestLanguageParser.g:5156:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            // InternalExBeeLangTestLanguageParser.g:5157:9: lv_parameters_10_0= ruleParameterDeclaration
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
                    // InternalExBeeLangTestLanguageParser.g:5178:4: ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5178:4: ( ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    // InternalExBeeLangTestLanguageParser.g:5179:5: ( (lv_varArgs_11_0= FullStopFullStopFullStop ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5179:5: ( (lv_varArgs_11_0= FullStopFullStopFullStop ) )
                    // InternalExBeeLangTestLanguageParser.g:5180:6: (lv_varArgs_11_0= FullStopFullStopFullStop )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5180:6: (lv_varArgs_11_0= FullStopFullStopFullStop )
                    // InternalExBeeLangTestLanguageParser.g:5181:7: lv_varArgs_11_0= FullStopFullStopFullStop
                    {
                    lv_varArgs_11_0=(Token)match(input,FullStopFullStopFullStop,FollowSets000.FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_varArgs_11_0, grammarAccess.getClosureExpressionAccess().getVarArgsFullStopFullStopFullStopKeyword_2_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getClosureExpressionRule());
                      							}
                      							setWithLastConsumed(current, "varArgs", lv_varArgs_11_0 != null, "...");
                      						
                    }

                    }


                    }

                    // InternalExBeeLangTestLanguageParser.g:5193:5: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    // InternalExBeeLangTestLanguageParser.g:5194:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    {
                    // InternalExBeeLangTestLanguageParser.g:5194:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    // InternalExBeeLangTestLanguageParser.g:5195:7: lv_parameters_12_0= ruleParameterDeclaration
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

            otherlv_13=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getClosureExpressionAccess().getVerticalLineKeyword_3());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:5218:3: ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            // InternalExBeeLangTestLanguageParser.g:5219:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            {
            // InternalExBeeLangTestLanguageParser.g:5219:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            // InternalExBeeLangTestLanguageParser.g:5220:5: lv_funcExpr_14_0= ruleOneOrManyExpressions
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
    // InternalExBeeLangTestLanguageParser.g:5241:1: entryRuleOneOrManyExpressions returns [EObject current=null] : iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF ;
    public final EObject entryRuleOneOrManyExpressions() throws RecognitionException {
        EObject current = null;
        int entryRuleOneOrManyExpressions_StartIndex = input.index();
        EObject iv_ruleOneOrManyExpressions = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5241:61: (iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF )
            // InternalExBeeLangTestLanguageParser.g:5242:2: iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF
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
    // InternalExBeeLangTestLanguageParser.g:5248:1: ruleOneOrManyExpressions returns [EObject current=null] : (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) ;
    public final EObject ruleOneOrManyExpressions() throws RecognitionException {
        EObject current = null;
        int ruleOneOrManyExpressions_StartIndex = input.index();
        EObject this_BlockExpressionWithoutBrackets_0 = null;

        EObject this_Expression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5254:2: ( (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) )
            // InternalExBeeLangTestLanguageParser.g:5255:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            {
            // InternalExBeeLangTestLanguageParser.g:5255:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalExBeeLangTestLanguageParser.g:5256:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
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
                    // InternalExBeeLangTestLanguageParser.g:5268:3: this_Expression_1= ruleExpression
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
    // InternalExBeeLangTestLanguageParser.g:5283:1: entryRuleBlockExpressionWithoutBrackets returns [EObject current=null] : iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF ;
    public final EObject entryRuleBlockExpressionWithoutBrackets() throws RecognitionException {
        EObject current = null;
        int entryRuleBlockExpressionWithoutBrackets_StartIndex = input.index();
        EObject iv_ruleBlockExpressionWithoutBrackets = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5283:71: (iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF )
            // InternalExBeeLangTestLanguageParser.g:5284:2: iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF
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
    // InternalExBeeLangTestLanguageParser.g:5290:1: ruleBlockExpressionWithoutBrackets returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= Semicolon )+ ) ;
    public final EObject ruleBlockExpressionWithoutBrackets() throws RecognitionException {
        EObject current = null;
        int ruleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5296:2: ( ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= Semicolon )+ ) )
            // InternalExBeeLangTestLanguageParser.g:5297:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= Semicolon )+ )
            {
            // InternalExBeeLangTestLanguageParser.g:5297:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= Semicolon )+ )
            // InternalExBeeLangTestLanguageParser.g:5298:3: () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= Semicolon )+
            {
            // InternalExBeeLangTestLanguageParser.g:5298:3: ()
            // InternalExBeeLangTestLanguageParser.g:5299:4: 
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

            // InternalExBeeLangTestLanguageParser.g:5308:3: ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= Semicolon )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==Properties||LA92_0==Builder||LA92_0==Cached||(LA92_0>=Output && LA92_0<=Input)||(LA92_0>=This && LA92_0<=Unit)||LA92_0==With||(LA92_0>=New && LA92_0<=Var)||LA92_0==PlusSignPlusSign||LA92_0==HyphenMinusHyphenMinus||LA92_0==ExclamationMark||LA92_0==LeftParenthesis||LA92_0==HyphenMinus||LA92_0==LeftCurlyBracket||LA92_0==RULE_ID||LA92_0==RULE_STRING) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:5309:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= Semicolon
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:5309:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) )
            	    // InternalExBeeLangTestLanguageParser.g:5310:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    {
            	    // InternalExBeeLangTestLanguageParser.g:5310:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    // InternalExBeeLangTestLanguageParser.g:5311:6: lv_expressions_1_0= ruleTopLevelExpression
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

            	    otherlv_2=(Token)match(input,Semicolon,FollowSets000.FOLLOW_75); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:5337:1: entryRuleValueLiteral returns [EObject current=null] : iv_ruleValueLiteral= ruleValueLiteral EOF ;
    public final EObject entryRuleValueLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleValueLiteral_StartIndex = input.index();
        EObject iv_ruleValueLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5337:53: (iv_ruleValueLiteral= ruleValueLiteral EOF )
            // InternalExBeeLangTestLanguageParser.g:5338:2: iv_ruleValueLiteral= ruleValueLiteral EOF
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
    // InternalExBeeLangTestLanguageParser.g:5344:1: ruleValueLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleValueLiteral() throws RecognitionException {
        EObject current = null;
        int ruleValueLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5350:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalExBeeLangTestLanguageParser.g:5351:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalExBeeLangTestLanguageParser.g:5351:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalExBeeLangTestLanguageParser.g:5352:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalExBeeLangTestLanguageParser.g:5352:3: (lv_value_0_0= RULE_STRING )
            // InternalExBeeLangTestLanguageParser.g:5353:4: lv_value_0_0= RULE_STRING
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
    // InternalExBeeLangTestLanguageParser.g:5372:1: entryRuleParanthesizedExpression returns [EObject current=null] : iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF ;
    public final EObject entryRuleParanthesizedExpression() throws RecognitionException {
        EObject current = null;
        int entryRuleParanthesizedExpression_StartIndex = input.index();
        EObject iv_ruleParanthesizedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5372:64: (iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF )
            // InternalExBeeLangTestLanguageParser.g:5373:2: iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF
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
    // InternalExBeeLangTestLanguageParser.g:5379:1: ruleParanthesizedExpression returns [EObject current=null] : (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis ) ;
    public final EObject ruleParanthesizedExpression() throws RecognitionException {
        EObject current = null;
        int ruleParanthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5385:2: ( (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis ) )
            // InternalExBeeLangTestLanguageParser.g:5386:2: (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis )
            {
            // InternalExBeeLangTestLanguageParser.g:5386:2: (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis )
            // InternalExBeeLangTestLanguageParser.g:5387:3: otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_19); if (state.failed) return current;
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
            otherlv_2=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
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
    // InternalExBeeLangTestLanguageParser.g:5410:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;
        int entryRuleQID_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleQID = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 113) ) { return current; }
            // InternalExBeeLangTestLanguageParser.g:5412:2: (iv_ruleQID= ruleQID EOF )
            // InternalExBeeLangTestLanguageParser.g:5413:2: iv_ruleQID= ruleQID EOF
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
    // InternalExBeeLangTestLanguageParser.g:5422:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= FullStop this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) ;
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
            // InternalExBeeLangTestLanguageParser.g:5429:2: ( (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= FullStop this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) )
            // InternalExBeeLangTestLanguageParser.g:5430:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= FullStop this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            {
            // InternalExBeeLangTestLanguageParser.g:5430:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= FullStop this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            // InternalExBeeLangTestLanguageParser.g:5431:3: this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= FullStop this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalExBeeLangTestLanguageParser.g:5438:3: (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )*
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
            	    // InternalExBeeLangTestLanguageParser.g:5439:4: this_INT_1= RULE_INT
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
            	    // InternalExBeeLangTestLanguageParser.g:5447:4: this_HEX_2= RULE_HEX
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
            	    // InternalExBeeLangTestLanguageParser.g:5455:4: this_ID_3= RULE_ID
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

            // InternalExBeeLangTestLanguageParser.g:5463:3: (kw= FullStop this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==FullStop) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalExBeeLangTestLanguageParser.g:5464:4: kw= FullStop this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    {
            	    kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_8); if (state.failed) return current;
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
            	    // InternalExBeeLangTestLanguageParser.g:5476:4: (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
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
            	    	    // InternalExBeeLangTestLanguageParser.g:5477:5: this_INT_6= RULE_INT
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
            	    	    // InternalExBeeLangTestLanguageParser.g:5485:5: this_HEX_7= RULE_HEX
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
            	    	    // InternalExBeeLangTestLanguageParser.g:5493:5: this_ID_8= RULE_ID
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

    // $ANTLR start synpred2_InternalExBeeLangTestLanguageParser
    public final void synpred2_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject lv_units_0_0 = null;


        // InternalExBeeLangTestLanguageParser.g:113:3: ( ( (lv_units_0_0= ruleUnit ) )* )
        // InternalExBeeLangTestLanguageParser.g:113:3: ( (lv_units_0_0= ruleUnit ) )*
        {
        // InternalExBeeLangTestLanguageParser.g:113:3: ( (lv_units_0_0= ruleUnit ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==Unit||LA96_0==RULE_DOCUMENTATION) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // InternalExBeeLangTestLanguageParser.g:114:4: (lv_units_0_0= ruleUnit )
        	    {
        	    // InternalExBeeLangTestLanguageParser.g:114:4: (lv_units_0_0= ruleUnit )
        	    // InternalExBeeLangTestLanguageParser.g:115:5: lv_units_0_0= ruleUnit
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
    // $ANTLR end synpred2_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred9_InternalExBeeLangTestLanguageParser
    public final void synpred9_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_sourceLocation_14_0 = null;


        // InternalExBeeLangTestLanguageParser.g:316:4: ( ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:316:4: ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:316:4: ({...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:317:5: {...}? => ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
        }
        // InternalExBeeLangTestLanguageParser.g:317:101: ( ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:318:6: ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
        // InternalExBeeLangTestLanguageParser.g:321:9: ({...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:321:10: {...}? => (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:321:19: (otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:321:20: otherlv_12= Source otherlv_13= Colon ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= Semicolon
        {
        otherlv_12=(Token)match(input,Source,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,Colon,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:329:9: ( (lv_sourceLocation_14_0= rulePath ) )
        // InternalExBeeLangTestLanguageParser.g:330:10: (lv_sourceLocation_14_0= rulePath )
        {
        // InternalExBeeLangTestLanguageParser.g:330:10: (lv_sourceLocation_14_0= rulePath )
        // InternalExBeeLangTestLanguageParser.g:331:11: lv_sourceLocation_14_0= rulePath
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

        otherlv_15=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred10_InternalExBeeLangTestLanguageParser
    public final void synpred10_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_outputLocation_18_0 = null;


        // InternalExBeeLangTestLanguageParser.g:358:4: ( ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:358:4: ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:358:4: ({...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:359:5: {...}? => ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
        }
        // InternalExBeeLangTestLanguageParser.g:359:101: ( ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:360:6: ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
        // InternalExBeeLangTestLanguageParser.g:363:9: ({...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:363:10: {...}? => (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:363:19: (otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:363:20: otherlv_16= Output otherlv_17= Colon ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= Semicolon
        {
        otherlv_16=(Token)match(input,Output,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,Colon,FollowSets000.FOLLOW_13); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:371:9: ( (lv_outputLocation_18_0= rulePath ) )
        // InternalExBeeLangTestLanguageParser.g:372:10: (lv_outputLocation_18_0= rulePath )
        {
        // InternalExBeeLangTestLanguageParser.g:372:10: (lv_outputLocation_18_0= rulePath )
        // InternalExBeeLangTestLanguageParser.g:373:11: lv_outputLocation_18_0= rulePath
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

        otherlv_19=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred11_InternalExBeeLangTestLanguageParser
    public final void synpred11_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_providedCapabilities_22_0 = null;


        // InternalExBeeLangTestLanguageParser.g:405:10: ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:405:10: {...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:405:19: (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:405:20: otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon
        {
        otherlv_20=(Token)match(input,Provides,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:413:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        // InternalExBeeLangTestLanguageParser.g:414:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        {
        // InternalExBeeLangTestLanguageParser.g:414:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        // InternalExBeeLangTestLanguageParser.g:415:11: lv_providedCapabilities_22_0= ruleProvidedCapability
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

        otherlv_23=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred12_InternalExBeeLangTestLanguageParser
    public final void synpred12_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_providedCapabilities_22_0 = null;


        // InternalExBeeLangTestLanguageParser.g:400:4: ( ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) ) )
        // InternalExBeeLangTestLanguageParser.g:400:4: ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) )
        {
        // InternalExBeeLangTestLanguageParser.g:400:4: ({...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ ) )
        // InternalExBeeLangTestLanguageParser.g:401:5: {...}? => ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
        }
        // InternalExBeeLangTestLanguageParser.g:401:101: ( ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+ )
        // InternalExBeeLangTestLanguageParser.g:402:6: ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
        // InternalExBeeLangTestLanguageParser.g:405:9: ({...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon ) )+
        int cnt98=0;
        loop98:
        do {
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==Provides) && ((true))) {
                alt98=1;
            }


            switch (alt98) {
        	case 1 :
        	    // InternalExBeeLangTestLanguageParser.g:405:10: {...}? => (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred12_InternalExBeeLangTestLanguageParser", "true");
        	    }
        	    // InternalExBeeLangTestLanguageParser.g:405:19: (otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon )
        	    // InternalExBeeLangTestLanguageParser.g:405:20: otherlv_20= Provides otherlv_21= Colon ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= Semicolon
        	    {
        	    otherlv_20=(Token)match(input,Provides,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_21=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // InternalExBeeLangTestLanguageParser.g:413:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        	    // InternalExBeeLangTestLanguageParser.g:414:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    {
        	    // InternalExBeeLangTestLanguageParser.g:414:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    // InternalExBeeLangTestLanguageParser.g:415:11: lv_providedCapabilities_22_0= ruleProvidedCapability
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

        	    otherlv_23=(Token)match(input,Semicolon,FollowSets000.FOLLOW_77); if (state.failed) return ;

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
    // $ANTLR end synpred12_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred13_InternalExBeeLangTestLanguageParser
    public final void synpred13_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_requiredCapabilities_26_0 = null;


        // InternalExBeeLangTestLanguageParser.g:447:10: ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:447:10: {...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:447:19: (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:447:20: otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon
        {
        otherlv_24=(Token)match(input,Requires,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_25=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:455:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        // InternalExBeeLangTestLanguageParser.g:456:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        {
        // InternalExBeeLangTestLanguageParser.g:456:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        // InternalExBeeLangTestLanguageParser.g:457:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
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

        otherlv_27=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred14_InternalExBeeLangTestLanguageParser
    public final void synpred14_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        EObject lv_requiredCapabilities_26_0 = null;


        // InternalExBeeLangTestLanguageParser.g:442:4: ( ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) ) )
        // InternalExBeeLangTestLanguageParser.g:442:4: ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) )
        {
        // InternalExBeeLangTestLanguageParser.g:442:4: ({...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ ) )
        // InternalExBeeLangTestLanguageParser.g:443:5: {...}? => ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred14_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
        }
        // InternalExBeeLangTestLanguageParser.g:443:101: ( ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+ )
        // InternalExBeeLangTestLanguageParser.g:444:6: ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
        // InternalExBeeLangTestLanguageParser.g:447:9: ({...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon ) )+
        int cnt99=0;
        loop99:
        do {
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==Requires) && ((true))) {
                alt99=1;
            }


            switch (alt99) {
        	case 1 :
        	    // InternalExBeeLangTestLanguageParser.g:447:10: {...}? => (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred14_InternalExBeeLangTestLanguageParser", "true");
        	    }
        	    // InternalExBeeLangTestLanguageParser.g:447:19: (otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon )
        	    // InternalExBeeLangTestLanguageParser.g:447:20: otherlv_24= Requires otherlv_25= Colon ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= Semicolon
        	    {
        	    otherlv_24=(Token)match(input,Requires,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_25=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // InternalExBeeLangTestLanguageParser.g:455:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        	    // InternalExBeeLangTestLanguageParser.g:456:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    {
        	    // InternalExBeeLangTestLanguageParser.g:456:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    // InternalExBeeLangTestLanguageParser.g:457:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
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

        	    otherlv_27=(Token)match(input,Semicolon,FollowSets000.FOLLOW_78); if (state.failed) return ;

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
    // $ANTLR end synpred14_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred15_InternalExBeeLangTestLanguageParser
    public final void synpred15_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_metaRequiredCapabilities_31_0 = null;


        // InternalExBeeLangTestLanguageParser.g:489:10: ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:489:10: {...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:489:19: (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:489:20: otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon
        {
        otherlv_28=(Token)match(input,Requires,FollowSets000.FOLLOW_16); if (state.failed) return ;
        otherlv_29=(Token)match(input,Env,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_30=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:501:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        // InternalExBeeLangTestLanguageParser.g:502:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        {
        // InternalExBeeLangTestLanguageParser.g:502:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        // InternalExBeeLangTestLanguageParser.g:503:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
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

        otherlv_32=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred16_InternalExBeeLangTestLanguageParser
    public final void synpred16_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_metaRequiredCapabilities_31_0 = null;


        // InternalExBeeLangTestLanguageParser.g:484:4: ( ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) ) )
        // InternalExBeeLangTestLanguageParser.g:484:4: ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) )
        {
        // InternalExBeeLangTestLanguageParser.g:484:4: ({...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ ) )
        // InternalExBeeLangTestLanguageParser.g:485:5: {...}? => ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
        }
        // InternalExBeeLangTestLanguageParser.g:485:101: ( ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+ )
        // InternalExBeeLangTestLanguageParser.g:486:6: ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
        // InternalExBeeLangTestLanguageParser.g:489:9: ({...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon ) )+
        int cnt100=0;
        loop100:
        do {
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==Requires) && ((true))) {
                alt100=1;
            }


            switch (alt100) {
        	case 1 :
        	    // InternalExBeeLangTestLanguageParser.g:489:10: {...}? => (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred16_InternalExBeeLangTestLanguageParser", "true");
        	    }
        	    // InternalExBeeLangTestLanguageParser.g:489:19: (otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon )
        	    // InternalExBeeLangTestLanguageParser.g:489:20: otherlv_28= Requires otherlv_29= Env otherlv_30= Colon ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= Semicolon
        	    {
        	    otherlv_28=(Token)match(input,Requires,FollowSets000.FOLLOW_16); if (state.failed) return ;
        	    otherlv_29=(Token)match(input,Env,FollowSets000.FOLLOW_12); if (state.failed) return ;
        	    otherlv_30=(Token)match(input,Colon,FollowSets000.FOLLOW_15); if (state.failed) return ;
        	    // InternalExBeeLangTestLanguageParser.g:501:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        	    // InternalExBeeLangTestLanguageParser.g:502:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    {
        	    // InternalExBeeLangTestLanguageParser.g:502:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    // InternalExBeeLangTestLanguageParser.g:503:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
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

        	    otherlv_32=(Token)match(input,Semicolon,FollowSets000.FOLLOW_78); if (state.failed) return ;

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
    // $ANTLR end synpred16_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred17_InternalExBeeLangTestLanguageParser
    public final void synpred17_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject lv_functions_33_0 = null;


        // InternalExBeeLangTestLanguageParser.g:535:10: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )
        // InternalExBeeLangTestLanguageParser.g:535:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:535:19: ( (lv_functions_33_0= ruleFunction ) )
        // InternalExBeeLangTestLanguageParser.g:535:20: (lv_functions_33_0= ruleFunction )
        {
        // InternalExBeeLangTestLanguageParser.g:535:20: (lv_functions_33_0= ruleFunction )
        // InternalExBeeLangTestLanguageParser.g:536:10: lv_functions_33_0= ruleFunction
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
    // $ANTLR end synpred17_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred18_InternalExBeeLangTestLanguageParser
    public final void synpred18_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject lv_functions_33_0 = null;


        // InternalExBeeLangTestLanguageParser.g:530:4: ( ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )
        // InternalExBeeLangTestLanguageParser.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        {
        // InternalExBeeLangTestLanguageParser.g:530:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        // InternalExBeeLangTestLanguageParser.g:531:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred18_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
        }
        // InternalExBeeLangTestLanguageParser.g:531:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        // InternalExBeeLangTestLanguageParser.g:532:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
        // InternalExBeeLangTestLanguageParser.g:535:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
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
            else if ( (LA101_0==Final) && ((true))) {
                alt101=1;
            }
            else if ( (LA101_0==Function) && ((true))) {
                alt101=1;
            }


            switch (alt101) {
        	case 1 :
        	    // InternalExBeeLangTestLanguageParser.g:535:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred18_InternalExBeeLangTestLanguageParser", "true");
        	    }
        	    // InternalExBeeLangTestLanguageParser.g:535:19: ( (lv_functions_33_0= ruleFunction ) )
        	    // InternalExBeeLangTestLanguageParser.g:535:20: (lv_functions_33_0= ruleFunction )
        	    {
        	    // InternalExBeeLangTestLanguageParser.g:535:20: (lv_functions_33_0= ruleFunction )
        	    // InternalExBeeLangTestLanguageParser.g:536:10: lv_functions_33_0= ruleFunction
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
    // $ANTLR end synpred18_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred20_InternalExBeeLangTestLanguageParser
    public final void synpred20_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_condExpr_7_0 = null;


        // InternalExBeeLangTestLanguageParser.g:648:5: ( ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:648:5: ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:648:5: ({...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:649:6: {...}? => ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
        }
        // InternalExBeeLangTestLanguageParser.g:649:118: ( ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:650:7: ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
        // InternalExBeeLangTestLanguageParser.g:653:10: ({...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:653:11: {...}? => (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:653:20: (otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:653:21: otherlv_5= When otherlv_6= Colon ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= Semicolon
        {
        otherlv_5=(Token)match(input,When,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_6=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:661:10: ( (lv_condExpr_7_0= ruleExpression ) )
        // InternalExBeeLangTestLanguageParser.g:662:11: (lv_condExpr_7_0= ruleExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:662:11: (lv_condExpr_7_0= ruleExpression )
        // InternalExBeeLangTestLanguageParser.g:663:12: lv_condExpr_7_0= ruleExpression
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

        otherlv_8=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred20_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred21_InternalExBeeLangTestLanguageParser
    public final void synpred21_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;

        // InternalExBeeLangTestLanguageParser.g:690:5: ( ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:690:5: ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:690:5: ({...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:691:6: {...}? => ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
        }
        // InternalExBeeLangTestLanguageParser.g:691:118: ( ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:692:7: ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
        // InternalExBeeLangTestLanguageParser.g:695:10: ({...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:695:11: {...}? => (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:695:20: (otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:695:21: otherlv_9= Name otherlv_10= Colon ( (lv_name_11_0= RULE_ID ) ) otherlv_12= Semicolon
        {
        otherlv_9=(Token)match(input,Name,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_10=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:703:10: ( (lv_name_11_0= RULE_ID ) )
        // InternalExBeeLangTestLanguageParser.g:704:11: (lv_name_11_0= RULE_ID )
        {
        // InternalExBeeLangTestLanguageParser.g:704:11: (lv_name_11_0= RULE_ID )
        // InternalExBeeLangTestLanguageParser.g:705:12: lv_name_11_0= RULE_ID
        {
        lv_name_11_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_12=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred21_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred22_InternalExBeeLangTestLanguageParser
    public final void synpred22_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;

        // InternalExBeeLangTestLanguageParser.g:731:5: ( ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:731:5: ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:731:5: ({...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:732:6: {...}? => ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
        }
        // InternalExBeeLangTestLanguageParser.g:732:118: ( ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:733:7: ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
        // InternalExBeeLangTestLanguageParser.g:736:10: ({...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:736:11: {...}? => (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:736:20: (otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:736:21: otherlv_13= Version otherlv_14= Colon ( (lv_version_15_0= RULE_ID ) ) otherlv_16= Semicolon
        {
        otherlv_13=(Token)match(input,Version,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:744:10: ( (lv_version_15_0= RULE_ID ) )
        // InternalExBeeLangTestLanguageParser.g:745:11: (lv_version_15_0= RULE_ID )
        {
        // InternalExBeeLangTestLanguageParser.g:745:11: (lv_version_15_0= RULE_ID )
        // InternalExBeeLangTestLanguageParser.g:746:12: lv_version_15_0= RULE_ID
        {
        lv_version_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred22_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred26_InternalExBeeLangTestLanguageParser
    public final void synpred26_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_condExpr_9_0 = null;


        // InternalExBeeLangTestLanguageParser.g:896:5: ( ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:896:5: ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:896:5: ({...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:897:6: {...}? => ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // InternalExBeeLangTestLanguageParser.g:897:125: ( ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:898:7: ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // InternalExBeeLangTestLanguageParser.g:901:10: ({...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:901:11: {...}? => (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:901:20: (otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:901:21: otherlv_7= When otherlv_8= Colon ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= Semicolon
        {
        otherlv_7=(Token)match(input,When,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_8=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:909:10: ( (lv_condExpr_9_0= ruleExpression ) )
        // InternalExBeeLangTestLanguageParser.g:910:11: (lv_condExpr_9_0= ruleExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:910:11: (lv_condExpr_9_0= ruleExpression )
        // InternalExBeeLangTestLanguageParser.g:911:12: lv_condExpr_9_0= ruleExpression
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

        otherlv_10=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred26_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred27_InternalExBeeLangTestLanguageParser
    public final void synpred27_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;

        // InternalExBeeLangTestLanguageParser.g:938:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:938:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:938:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:939:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // InternalExBeeLangTestLanguageParser.g:939:125: ( ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:940:7: ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // InternalExBeeLangTestLanguageParser.g:943:10: ({...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:943:11: {...}? => ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:943:20: ( ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:943:21: ( (lv_greedy_11_0= Greedy ) ) otherlv_12= Semicolon
        {
        // InternalExBeeLangTestLanguageParser.g:943:21: ( (lv_greedy_11_0= Greedy ) )
        // InternalExBeeLangTestLanguageParser.g:944:11: (lv_greedy_11_0= Greedy )
        {
        // InternalExBeeLangTestLanguageParser.g:944:11: (lv_greedy_11_0= Greedy )
        // InternalExBeeLangTestLanguageParser.g:945:12: lv_greedy_11_0= Greedy
        {
        lv_greedy_11_0=(Token)match(input,Greedy,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_12=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred28_InternalExBeeLangTestLanguageParser
    public final void synpred28_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;

        // InternalExBeeLangTestLanguageParser.g:967:5: ( ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:967:5: ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:967:5: ({...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:968:6: {...}? => ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // InternalExBeeLangTestLanguageParser.g:968:125: ( ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:969:7: ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // InternalExBeeLangTestLanguageParser.g:972:10: ({...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:972:11: {...}? => (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:972:20: (otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:972:21: otherlv_13= RequiresMin otherlv_14= Colon ( (lv_min_15_0= RULE_INT ) ) otherlv_16= Semicolon
        {
        otherlv_13=(Token)match(input,RequiresMin,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:980:10: ( (lv_min_15_0= RULE_INT ) )
        // InternalExBeeLangTestLanguageParser.g:981:11: (lv_min_15_0= RULE_INT )
        {
        // InternalExBeeLangTestLanguageParser.g:981:11: (lv_min_15_0= RULE_INT )
        // InternalExBeeLangTestLanguageParser.g:982:12: lv_min_15_0= RULE_INT
        {
        lv_min_15_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred28_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred29_InternalExBeeLangTestLanguageParser
    public final void synpred29_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;

        // InternalExBeeLangTestLanguageParser.g:1008:5: ( ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1008:5: ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:1008:5: ({...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1009:6: {...}? => ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // InternalExBeeLangTestLanguageParser.g:1009:125: ( ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:1010:7: ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // InternalExBeeLangTestLanguageParser.g:1013:10: ({...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:1013:11: {...}? => (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:1013:20: (otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:1013:21: otherlv_17= RequiresMax otherlv_18= Colon ( (lv_max_19_0= RULE_INT ) ) otherlv_20= Semicolon
        {
        otherlv_17=(Token)match(input,RequiresMax,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_18=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:1021:10: ( (lv_max_19_0= RULE_INT ) )
        // InternalExBeeLangTestLanguageParser.g:1022:11: (lv_max_19_0= RULE_INT )
        {
        // InternalExBeeLangTestLanguageParser.g:1022:11: (lv_max_19_0= RULE_INT )
        // InternalExBeeLangTestLanguageParser.g:1023:12: lv_max_19_0= RULE_INT
        {
        lv_max_19_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_20=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred29_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred30_InternalExBeeLangTestLanguageParser
    public final void synpred30_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;

        // InternalExBeeLangTestLanguageParser.g:1049:5: ( ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1049:5: ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:1049:5: ({...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1050:6: {...}? => ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // InternalExBeeLangTestLanguageParser.g:1050:125: ( ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:1051:7: ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // InternalExBeeLangTestLanguageParser.g:1054:10: ({...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:1054:11: {...}? => (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:1054:20: (otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:1054:21: otherlv_21= Version otherlv_22= Colon ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= Semicolon
        {
        otherlv_21=(Token)match(input,Version,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_22=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:1062:10: ( (lv_versionRange_23_0= RULE_ID ) )
        // InternalExBeeLangTestLanguageParser.g:1063:11: (lv_versionRange_23_0= RULE_ID )
        {
        // InternalExBeeLangTestLanguageParser.g:1063:11: (lv_versionRange_23_0= RULE_ID )
        // InternalExBeeLangTestLanguageParser.g:1064:12: lv_versionRange_23_0= RULE_ID
        {
        lv_versionRange_23_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_24=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred30_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred32_InternalExBeeLangTestLanguageParser
    public final void synpred32_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_condExpr_8_0 = null;


        // InternalExBeeLangTestLanguageParser.g:1199:5: ( ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1199:5: ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:1199:5: ({...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1200:6: {...}? => ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // InternalExBeeLangTestLanguageParser.g:1200:118: ( ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:1201:7: ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // InternalExBeeLangTestLanguageParser.g:1204:10: ({...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:1204:11: {...}? => (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:1204:20: (otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:1204:21: otherlv_6= When otherlv_7= Colon ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= Semicolon
        {
        otherlv_6=(Token)match(input,When,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_7=(Token)match(input,Colon,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:1212:10: ( (lv_condExpr_8_0= ruleExpression ) )
        // InternalExBeeLangTestLanguageParser.g:1213:11: (lv_condExpr_8_0= ruleExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:1213:11: (lv_condExpr_8_0= ruleExpression )
        // InternalExBeeLangTestLanguageParser.g:1214:12: lv_condExpr_8_0= ruleExpression
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

        otherlv_9=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred32_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred33_InternalExBeeLangTestLanguageParser
    public final void synpred33_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;

        // InternalExBeeLangTestLanguageParser.g:1241:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1241:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:1241:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1242:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // InternalExBeeLangTestLanguageParser.g:1242:118: ( ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:1243:7: ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // InternalExBeeLangTestLanguageParser.g:1246:10: ({...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:1246:11: {...}? => ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:1246:20: ( ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:1246:21: ( (lv_greedy_10_0= Greedy ) ) otherlv_11= Semicolon
        {
        // InternalExBeeLangTestLanguageParser.g:1246:21: ( (lv_greedy_10_0= Greedy ) )
        // InternalExBeeLangTestLanguageParser.g:1247:11: (lv_greedy_10_0= Greedy )
        {
        // InternalExBeeLangTestLanguageParser.g:1247:11: (lv_greedy_10_0= Greedy )
        // InternalExBeeLangTestLanguageParser.g:1248:12: lv_greedy_10_0= Greedy
        {
        lv_greedy_10_0=(Token)match(input,Greedy,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred33_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred34_InternalExBeeLangTestLanguageParser
    public final void synpred34_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;

        // InternalExBeeLangTestLanguageParser.g:1270:5: ( ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1270:5: ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:1270:5: ({...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1271:6: {...}? => ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // InternalExBeeLangTestLanguageParser.g:1271:118: ( ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:1272:7: ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // InternalExBeeLangTestLanguageParser.g:1275:10: ({...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:1275:11: {...}? => (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:1275:20: (otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:1275:21: otherlv_12= RequiresMin otherlv_13= Colon ( (lv_min_14_0= RULE_INT ) ) otherlv_15= Semicolon
        {
        otherlv_12=(Token)match(input,RequiresMin,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:1283:10: ( (lv_min_14_0= RULE_INT ) )
        // InternalExBeeLangTestLanguageParser.g:1284:11: (lv_min_14_0= RULE_INT )
        {
        // InternalExBeeLangTestLanguageParser.g:1284:11: (lv_min_14_0= RULE_INT )
        // InternalExBeeLangTestLanguageParser.g:1285:12: lv_min_14_0= RULE_INT
        {
        lv_min_14_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_15=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred34_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred35_InternalExBeeLangTestLanguageParser
    public final void synpred35_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;

        // InternalExBeeLangTestLanguageParser.g:1311:5: ( ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1311:5: ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:1311:5: ({...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1312:6: {...}? => ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // InternalExBeeLangTestLanguageParser.g:1312:118: ( ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:1313:7: ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // InternalExBeeLangTestLanguageParser.g:1316:10: ({...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:1316:11: {...}? => (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:1316:20: (otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:1316:21: otherlv_16= RequiresMax otherlv_17= Colon ( (lv_max_18_0= RULE_INT ) ) otherlv_19= Semicolon
        {
        otherlv_16=(Token)match(input,RequiresMax,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:1324:10: ( (lv_max_18_0= RULE_INT ) )
        // InternalExBeeLangTestLanguageParser.g:1325:11: (lv_max_18_0= RULE_INT )
        {
        // InternalExBeeLangTestLanguageParser.g:1325:11: (lv_max_18_0= RULE_INT )
        // InternalExBeeLangTestLanguageParser.g:1326:12: lv_max_18_0= RULE_INT
        {
        lv_max_18_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_19=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred35_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred36_InternalExBeeLangTestLanguageParser
    public final void synpred36_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;

        // InternalExBeeLangTestLanguageParser.g:1352:5: ( ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1352:5: ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:1352:5: ({...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:1353:6: {...}? => ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalExBeeLangTestLanguageParser", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // InternalExBeeLangTestLanguageParser.g:1353:118: ( ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) ) )
        // InternalExBeeLangTestLanguageParser.g:1354:7: ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // InternalExBeeLangTestLanguageParser.g:1357:10: ({...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon ) )
        // InternalExBeeLangTestLanguageParser.g:1357:11: {...}? => (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_InternalExBeeLangTestLanguageParser", "true");
        }
        // InternalExBeeLangTestLanguageParser.g:1357:20: (otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon )
        // InternalExBeeLangTestLanguageParser.g:1357:21: otherlv_20= Version otherlv_21= Colon ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= Semicolon
        {
        otherlv_20=(Token)match(input,Version,FollowSets000.FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:1365:10: ( (lv_versionRange_22_0= RULE_ID ) )
        // InternalExBeeLangTestLanguageParser.g:1366:11: (lv_versionRange_22_0= RULE_ID )
        {
        // InternalExBeeLangTestLanguageParser.g:1366:11: (lv_versionRange_22_0= RULE_ID )
        // InternalExBeeLangTestLanguageParser.g:1367:12: lv_versionRange_22_0= RULE_ID
        {
        lv_versionRange_22_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_23=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred36_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred42_InternalExBeeLangTestLanguageParser
    public final void synpred42_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_ClosureParameter_0 = null;


        // InternalExBeeLangTestLanguageParser.g:1569:3: (this_ClosureParameter_0= ruleClosureParameter )
        // InternalExBeeLangTestLanguageParser.g:1569:3: this_ClosureParameter_0= ruleClosureParameter
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
    // $ANTLR end synpred42_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred69_InternalExBeeLangTestLanguageParser
    public final void synpred69_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_VarDeclaration_0 = null;


        // InternalExBeeLangTestLanguageParser.g:2252:3: (this_VarDeclaration_0= ruleVarDeclaration )
        // InternalExBeeLangTestLanguageParser.g:2252:3: this_VarDeclaration_0= ruleVarDeclaration
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
    // $ANTLR end synpred69_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred71_InternalExBeeLangTestLanguageParser
    public final void synpred71_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:2346:4: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )
        // InternalExBeeLangTestLanguageParser.g:2346:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        {
        // InternalExBeeLangTestLanguageParser.g:2346:4: ()
        // InternalExBeeLangTestLanguageParser.g:2347:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalExBeeLangTestLanguageParser.g:2356:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
        // InternalExBeeLangTestLanguageParser.g:2357:5: (lv_functionName_2_0= ruleAssignmentOperator )
        {
        // InternalExBeeLangTestLanguageParser.g:2357:5: (lv_functionName_2_0= ruleAssignmentOperator )
        // InternalExBeeLangTestLanguageParser.g:2358:6: lv_functionName_2_0= ruleAssignmentOperator
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

        // InternalExBeeLangTestLanguageParser.g:2375:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        // InternalExBeeLangTestLanguageParser.g:2376:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:2376:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        // InternalExBeeLangTestLanguageParser.g:2377:6: lv_rightExpr_3_0= ruleAssignmentExpression
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
    // $ANTLR end synpred71_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred85_InternalExBeeLangTestLanguageParser
    public final void synpred85_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3022:4: ( () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) ) )
        // InternalExBeeLangTestLanguageParser.g:3022:4: () otherlv_2= VerticalLineVerticalLine ( (lv_rightExpr_3_0= ruleAndExpression ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3022:4: ()
        // InternalExBeeLangTestLanguageParser.g:3023:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,VerticalLineVerticalLine,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:3036:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
        // InternalExBeeLangTestLanguageParser.g:3037:5: (lv_rightExpr_3_0= ruleAndExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:3037:5: (lv_rightExpr_3_0= ruleAndExpression )
        // InternalExBeeLangTestLanguageParser.g:3038:6: lv_rightExpr_3_0= ruleAndExpression
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
    // $ANTLR end synpred85_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred86_InternalExBeeLangTestLanguageParser
    public final void synpred86_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3087:4: ( () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )
        // InternalExBeeLangTestLanguageParser.g:3087:4: () otherlv_2= AmpersandAmpersand ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3087:4: ()
        // InternalExBeeLangTestLanguageParser.g:3088:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,AmpersandAmpersand,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:3101:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        // InternalExBeeLangTestLanguageParser.g:3102:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:3102:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        // InternalExBeeLangTestLanguageParser.g:3103:6: lv_rightExpr_3_0= ruleRelationalExpression
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
    // $ANTLR end synpred86_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred87_InternalExBeeLangTestLanguageParser
    public final void synpred87_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_functionName_2_0 = null;

        EObject lv_rightExpr_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3152:4: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )
        // InternalExBeeLangTestLanguageParser.g:3152:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3152:4: ()
        // InternalExBeeLangTestLanguageParser.g:3153:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalExBeeLangTestLanguageParser.g:3162:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
        // InternalExBeeLangTestLanguageParser.g:3163:5: (lv_functionName_2_0= ruleRelationalOperator )
        {
        // InternalExBeeLangTestLanguageParser.g:3163:5: (lv_functionName_2_0= ruleRelationalOperator )
        // InternalExBeeLangTestLanguageParser.g:3164:6: lv_functionName_2_0= ruleRelationalOperator
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

        // InternalExBeeLangTestLanguageParser.g:3181:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        // InternalExBeeLangTestLanguageParser.g:3182:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:3182:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        // InternalExBeeLangTestLanguageParser.g:3183:6: lv_rightExpr_3_0= ruleAdditiveExpression
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
    // $ANTLR end synpred87_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred89_InternalExBeeLangTestLanguageParser
    public final void synpred89_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3232:4: ( () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )
        // InternalExBeeLangTestLanguageParser.g:3232:4: () ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3232:4: ()
        // InternalExBeeLangTestLanguageParser.g:3233:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalExBeeLangTestLanguageParser.g:3242:4: ( ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) ) )
        // InternalExBeeLangTestLanguageParser.g:3243:5: ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3243:5: ( (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus ) )
        // InternalExBeeLangTestLanguageParser.g:3244:6: (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus )
        {
        // InternalExBeeLangTestLanguageParser.g:3244:6: (lv_functionName_2_1= PlusSign | lv_functionName_2_2= HyphenMinus )
        int alt111=2;
        int LA111_0 = input.LA(1);

        if ( (LA111_0==PlusSign) ) {
            alt111=1;
        }
        else if ( (LA111_0==HyphenMinus) ) {
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
                // InternalExBeeLangTestLanguageParser.g:3245:7: lv_functionName_2_1= PlusSign
                {
                lv_functionName_2_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalExBeeLangTestLanguageParser.g:3256:7: lv_functionName_2_2= HyphenMinus
                {
                lv_functionName_2_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalExBeeLangTestLanguageParser.g:3269:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        // InternalExBeeLangTestLanguageParser.g:3270:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:3270:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        // InternalExBeeLangTestLanguageParser.g:3271:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
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
    // $ANTLR end synpred89_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred92_InternalExBeeLangTestLanguageParser
    public final void synpred92_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3320:4: ( () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )
        // InternalExBeeLangTestLanguageParser.g:3320:4: () ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3320:4: ()
        // InternalExBeeLangTestLanguageParser.g:3321:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalExBeeLangTestLanguageParser.g:3330:4: ( ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) ) )
        // InternalExBeeLangTestLanguageParser.g:3331:5: ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3331:5: ( (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign ) )
        // InternalExBeeLangTestLanguageParser.g:3332:6: (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign )
        {
        // InternalExBeeLangTestLanguageParser.g:3332:6: (lv_functionName_2_1= Asterisk | lv_functionName_2_2= Solidus | lv_functionName_2_3= PercentSign )
        int alt112=3;
        switch ( input.LA(1) ) {
        case Asterisk:
            {
            alt112=1;
            }
            break;
        case Solidus:
            {
            alt112=2;
            }
            break;
        case PercentSign:
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
                // InternalExBeeLangTestLanguageParser.g:3333:7: lv_functionName_2_1= Asterisk
                {
                lv_functionName_2_1=(Token)match(input,Asterisk,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalExBeeLangTestLanguageParser.g:3344:7: lv_functionName_2_2= Solidus
                {
                lv_functionName_2_2=(Token)match(input,Solidus,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalExBeeLangTestLanguageParser.g:3355:7: lv_functionName_2_3= PercentSign
                {
                lv_functionName_2_3=(Token)match(input,PercentSign,FollowSets000.FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalExBeeLangTestLanguageParser.g:3368:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
        // InternalExBeeLangTestLanguageParser.g:3369:5: (lv_rightExpr_3_0= ruleSetExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:3369:5: (lv_rightExpr_3_0= ruleSetExpression )
        // InternalExBeeLangTestLanguageParser.g:3370:6: lv_rightExpr_3_0= ruleSetExpression
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
    // $ANTLR end synpred92_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred93_InternalExBeeLangTestLanguageParser
    public final void synpred93_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;
        EObject lv_rightExpr_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3419:4: ( () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )
        // InternalExBeeLangTestLanguageParser.g:3419:4: () ( (lv_functionName_2_0= FullStopFullStop ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3419:4: ()
        // InternalExBeeLangTestLanguageParser.g:3420:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalExBeeLangTestLanguageParser.g:3429:4: ( (lv_functionName_2_0= FullStopFullStop ) )
        // InternalExBeeLangTestLanguageParser.g:3430:5: (lv_functionName_2_0= FullStopFullStop )
        {
        // InternalExBeeLangTestLanguageParser.g:3430:5: (lv_functionName_2_0= FullStopFullStop )
        // InternalExBeeLangTestLanguageParser.g:3431:6: lv_functionName_2_0= FullStopFullStop
        {
        lv_functionName_2_0=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_19); if (state.failed) return ;

        }


        }

        // InternalExBeeLangTestLanguageParser.g:3443:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        // InternalExBeeLangTestLanguageParser.g:3444:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:3444:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        // InternalExBeeLangTestLanguageParser.g:3445:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
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
    // $ANTLR end synpred93_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred99_InternalExBeeLangTestLanguageParser
    public final void synpred99_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // InternalExBeeLangTestLanguageParser.g:3698:4: ( () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:3698:4: () ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3698:4: ()
        // InternalExBeeLangTestLanguageParser.g:3699:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalExBeeLangTestLanguageParser.g:3708:4: ( ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) ) )
        // InternalExBeeLangTestLanguageParser.g:3709:5: ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3709:5: ( (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign ) )
        // InternalExBeeLangTestLanguageParser.g:3710:6: (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign )
        {
        // InternalExBeeLangTestLanguageParser.g:3710:6: (lv_functionName_2_1= HyphenMinusHyphenMinus | lv_functionName_2_2= PlusSignPlusSign )
        int alt113=2;
        int LA113_0 = input.LA(1);

        if ( (LA113_0==HyphenMinusHyphenMinus) ) {
            alt113=1;
        }
        else if ( (LA113_0==PlusSignPlusSign) ) {
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
                // InternalExBeeLangTestLanguageParser.g:3711:7: lv_functionName_2_1= HyphenMinusHyphenMinus
                {
                lv_functionName_2_1=(Token)match(input,HyphenMinusHyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalExBeeLangTestLanguageParser.g:3722:7: lv_functionName_2_2= PlusSignPlusSign
                {
                lv_functionName_2_2=(Token)match(input,PlusSignPlusSign,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred99_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred101_InternalExBeeLangTestLanguageParser
    public final void synpred101_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameterList_5_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3767:4: ( ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis ) )
        // InternalExBeeLangTestLanguageParser.g:3767:4: ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis )
        {
        // InternalExBeeLangTestLanguageParser.g:3767:4: ( () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis )
        // InternalExBeeLangTestLanguageParser.g:3768:5: () otherlv_2= FullStop ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= RightParenthesis
        {
        // InternalExBeeLangTestLanguageParser.g:3768:5: ()
        // InternalExBeeLangTestLanguageParser.g:3769:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:3782:5: ( (lv_name_3_0= RULE_ID ) )
        // InternalExBeeLangTestLanguageParser.g:3783:6: (lv_name_3_0= RULE_ID )
        {
        // InternalExBeeLangTestLanguageParser.g:3783:6: (lv_name_3_0= RULE_ID )
        // InternalExBeeLangTestLanguageParser.g:3784:7: lv_name_3_0= RULE_ID
        {
        lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_58); if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:3804:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==Properties||LA114_0==Builder||LA114_0==Cached||(LA114_0>=Output && LA114_0<=Source)||LA114_0==Input||(LA114_0>=This && LA114_0<=Unit)||LA114_0==With||LA114_0==FullStopFullStopFullStop||LA114_0==New||LA114_0==PlusSignPlusSign||LA114_0==HyphenMinusHyphenMinus||LA114_0==ExclamationMark||LA114_0==LeftParenthesis||LA114_0==HyphenMinus||LA114_0==LessThanSign||(LA114_0>=LeftCurlyBracket && LA114_0<=VerticalLine)||LA114_0==RULE_ID||LA114_0==RULE_STRING) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // InternalExBeeLangTestLanguageParser.g:3805:6: (lv_parameterList_5_0= ruleParameterList )
                {
                // InternalExBeeLangTestLanguageParser.g:3805:6: (lv_parameterList_5_0= ruleParameterList )
                // InternalExBeeLangTestLanguageParser.g:3806:7: lv_parameterList_5_0= ruleParameterList
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

        otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred101_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred102_InternalExBeeLangTestLanguageParser
    public final void synpred102_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_indexExpr_9_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3829:4: ( ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket ) )
        // InternalExBeeLangTestLanguageParser.g:3829:4: ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket )
        {
        // InternalExBeeLangTestLanguageParser.g:3829:4: ( () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket )
        // InternalExBeeLangTestLanguageParser.g:3830:5: () otherlv_8= LeftSquareBracket ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= RightSquareBracket
        {
        // InternalExBeeLangTestLanguageParser.g:3830:5: ()
        // InternalExBeeLangTestLanguageParser.g:3831:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_8=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_19); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:3844:5: ( (lv_indexExpr_9_0= ruleExpression ) )
        // InternalExBeeLangTestLanguageParser.g:3845:6: (lv_indexExpr_9_0= ruleExpression )
        {
        // InternalExBeeLangTestLanguageParser.g:3845:6: (lv_indexExpr_9_0= ruleExpression )
        // InternalExBeeLangTestLanguageParser.g:3846:7: lv_indexExpr_9_0= ruleExpression
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

        otherlv_10=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred102_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred103_InternalExBeeLangTestLanguageParser
    public final void synpred103_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        // InternalExBeeLangTestLanguageParser.g:3869:4: ( ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) ) )
        // InternalExBeeLangTestLanguageParser.g:3869:4: ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3869:4: ( () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) ) )
        // InternalExBeeLangTestLanguageParser.g:3870:5: () otherlv_12= FullStop ( (lv_featureName_13_0= RULE_ID ) )
        {
        // InternalExBeeLangTestLanguageParser.g:3870:5: ()
        // InternalExBeeLangTestLanguageParser.g:3871:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_12=(Token)match(input,FullStop,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:3884:5: ( (lv_featureName_13_0= RULE_ID ) )
        // InternalExBeeLangTestLanguageParser.g:3885:6: (lv_featureName_13_0= RULE_ID )
        {
        // InternalExBeeLangTestLanguageParser.g:3885:6: (lv_featureName_13_0= RULE_ID )
        // InternalExBeeLangTestLanguageParser.g:3886:7: lv_featureName_13_0= RULE_ID
        {
        lv_featureName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred103_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred105_InternalExBeeLangTestLanguageParser
    public final void synpred105_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_parameterList_3_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3935:4: ( () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis )
        // InternalExBeeLangTestLanguageParser.g:3935:4: () otherlv_2= LeftParenthesis ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= RightParenthesis
        {
        // InternalExBeeLangTestLanguageParser.g:3935:4: ()
        // InternalExBeeLangTestLanguageParser.g:3936:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:3949:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==Properties||LA115_0==Builder||LA115_0==Cached||(LA115_0>=Output && LA115_0<=Source)||LA115_0==Input||(LA115_0>=This && LA115_0<=Unit)||LA115_0==With||LA115_0==FullStopFullStopFullStop||LA115_0==New||LA115_0==PlusSignPlusSign||LA115_0==HyphenMinusHyphenMinus||LA115_0==ExclamationMark||LA115_0==LeftParenthesis||LA115_0==HyphenMinus||LA115_0==LessThanSign||(LA115_0>=LeftCurlyBracket && LA115_0<=VerticalLine)||LA115_0==RULE_ID||LA115_0==RULE_STRING) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // InternalExBeeLangTestLanguageParser.g:3950:5: (lv_parameterList_3_0= ruleParameterList )
                {
                // InternalExBeeLangTestLanguageParser.g:3950:5: (lv_parameterList_3_0= ruleParameterList )
                // InternalExBeeLangTestLanguageParser.g:3951:6: lv_parameterList_3_0= ruleParameterList
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

        otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred106_InternalExBeeLangTestLanguageParser
    public final void synpred106_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_FeatureCall_0 = null;


        // InternalExBeeLangTestLanguageParser.g:3992:3: (this_FeatureCall_0= ruleFeatureCall )
        // InternalExBeeLangTestLanguageParser.g:3992:3: this_FeatureCall_0= ruleFeatureCall
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
    // $ANTLR end synpred106_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred108_InternalExBeeLangTestLanguageParser
    public final void synpred108_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_Value_2 = null;


        // InternalExBeeLangTestLanguageParser.g:4016:3: (this_Value_2= ruleValue )
        // InternalExBeeLangTestLanguageParser.g:4016:3: this_Value_2= ruleValue
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
    // $ANTLR end synpred108_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred109_InternalExBeeLangTestLanguageParser
    public final void synpred109_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_Literal_3 = null;


        // InternalExBeeLangTestLanguageParser.g:4028:3: (this_Literal_3= ruleLiteral )
        // InternalExBeeLangTestLanguageParser.g:4028:3: this_Literal_3= ruleLiteral
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
    // $ANTLR end synpred109_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred112_InternalExBeeLangTestLanguageParser
    public final void synpred112_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_BlockExpression_6 = null;


        // InternalExBeeLangTestLanguageParser.g:4064:3: (this_BlockExpression_6= ruleBlockExpression )
        // InternalExBeeLangTestLanguageParser.g:4064:3: this_BlockExpression_6= ruleBlockExpression
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
    // $ANTLR end synpred112_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred113_InternalExBeeLangTestLanguageParser
    public final void synpred113_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_WithExpression_7 = null;


        // InternalExBeeLangTestLanguageParser.g:4076:3: (this_WithExpression_7= ruleWithExpression )
        // InternalExBeeLangTestLanguageParser.g:4076:3: this_WithExpression_7= ruleWithExpression
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
    // $ANTLR end synpred113_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred127_InternalExBeeLangTestLanguageParser
    public final void synpred127_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameterList_4_0 = null;


        // InternalExBeeLangTestLanguageParser.g:4686:4: (otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis )
        // InternalExBeeLangTestLanguageParser.g:4686:4: otherlv_3= LeftParenthesis ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= RightParenthesis
        {
        otherlv_3=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:4690:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==Properties||LA117_0==Builder||LA117_0==Cached||(LA117_0>=Output && LA117_0<=Source)||LA117_0==Input||(LA117_0>=This && LA117_0<=Unit)||LA117_0==With||LA117_0==FullStopFullStopFullStop||LA117_0==New||LA117_0==PlusSignPlusSign||LA117_0==HyphenMinusHyphenMinus||LA117_0==ExclamationMark||LA117_0==LeftParenthesis||LA117_0==HyphenMinus||LA117_0==LessThanSign||(LA117_0>=LeftCurlyBracket && LA117_0<=VerticalLine)||LA117_0==RULE_ID||LA117_0==RULE_STRING) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // InternalExBeeLangTestLanguageParser.g:4691:5: (lv_parameterList_4_0= ruleParameterList )
                {
                // InternalExBeeLangTestLanguageParser.g:4691:5: (lv_parameterList_4_0= ruleParameterList )
                // InternalExBeeLangTestLanguageParser.g:4692:6: lv_parameterList_4_0= ruleParameterList
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

        otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred127_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred128_InternalExBeeLangTestLanguageParser
    public final void synpred128_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        // InternalExBeeLangTestLanguageParser.g:4715:4: (otherlv_6= As ( (lv_alias_7_0= RULE_ID ) ) )
        // InternalExBeeLangTestLanguageParser.g:4715:4: otherlv_6= As ( (lv_alias_7_0= RULE_ID ) )
        {
        otherlv_6=(Token)match(input,As,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalExBeeLangTestLanguageParser.g:4719:4: ( (lv_alias_7_0= RULE_ID ) )
        // InternalExBeeLangTestLanguageParser.g:4720:5: (lv_alias_7_0= RULE_ID )
        {
        // InternalExBeeLangTestLanguageParser.g:4720:5: (lv_alias_7_0= RULE_ID )
        // InternalExBeeLangTestLanguageParser.g:4721:6: lv_alias_7_0= RULE_ID
        {
        lv_alias_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred128_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred135_InternalExBeeLangTestLanguageParser
    public final void synpred135_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_parameters_10_0 = null;


        // InternalExBeeLangTestLanguageParser.g:5084:4: ( ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) )
        // InternalExBeeLangTestLanguageParser.g:5084:4: ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        {
        // InternalExBeeLangTestLanguageParser.g:5084:4: ( (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        // InternalExBeeLangTestLanguageParser.g:5085:5: (otherlv_4= VerticalLine )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        {
        // InternalExBeeLangTestLanguageParser.g:5085:5: (otherlv_4= VerticalLine )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==VerticalLine) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // InternalExBeeLangTestLanguageParser.g:5086:6: otherlv_4= VerticalLine
                {
                otherlv_4=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }
                break;

        }

        // InternalExBeeLangTestLanguageParser.g:5091:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        // InternalExBeeLangTestLanguageParser.g:5092:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        {
        // InternalExBeeLangTestLanguageParser.g:5092:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
        // InternalExBeeLangTestLanguageParser.g:5093:7: (lv_parameters_5_0= ruleParameterDeclaration )
        {
        // InternalExBeeLangTestLanguageParser.g:5093:7: (lv_parameters_5_0= ruleParameterDeclaration )
        // InternalExBeeLangTestLanguageParser.g:5094:8: lv_parameters_5_0= ruleParameterDeclaration
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

        // InternalExBeeLangTestLanguageParser.g:5111:6: (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
        loop119:
        do {
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==Comma) ) {
                int LA119_1 = input.LA(2);

                if ( (LA119_1==LeftParenthesis||LA119_1==RULE_ID) ) {
                    alt119=1;
                }


            }


            switch (alt119) {
        	case 1 :
        	    // InternalExBeeLangTestLanguageParser.g:5112:7: otherlv_6= Comma ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    {
        	    otherlv_6=(Token)match(input,Comma,FollowSets000.FOLLOW_35); if (state.failed) return ;
        	    // InternalExBeeLangTestLanguageParser.g:5116:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    // InternalExBeeLangTestLanguageParser.g:5117:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    {
        	    // InternalExBeeLangTestLanguageParser.g:5117:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    // InternalExBeeLangTestLanguageParser.g:5118:9: lv_parameters_7_0= ruleParameterDeclaration
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

        // InternalExBeeLangTestLanguageParser.g:5136:6: (otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==Comma) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // InternalExBeeLangTestLanguageParser.g:5137:7: otherlv_8= Comma ( (lv_varArgs_9_0= FullStopFullStopFullStop ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                {
                otherlv_8=(Token)match(input,Comma,FollowSets000.FOLLOW_36); if (state.failed) return ;
                // InternalExBeeLangTestLanguageParser.g:5141:7: ( (lv_varArgs_9_0= FullStopFullStopFullStop ) )
                // InternalExBeeLangTestLanguageParser.g:5142:8: (lv_varArgs_9_0= FullStopFullStopFullStop )
                {
                // InternalExBeeLangTestLanguageParser.g:5142:8: (lv_varArgs_9_0= FullStopFullStopFullStop )
                // InternalExBeeLangTestLanguageParser.g:5143:9: lv_varArgs_9_0= FullStopFullStopFullStop
                {
                lv_varArgs_9_0=(Token)match(input,FullStopFullStopFullStop,FollowSets000.FOLLOW_35); if (state.failed) return ;

                }


                }

                // InternalExBeeLangTestLanguageParser.g:5155:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                // InternalExBeeLangTestLanguageParser.g:5156:8: (lv_parameters_10_0= ruleParameterDeclaration )
                {
                // InternalExBeeLangTestLanguageParser.g:5156:8: (lv_parameters_10_0= ruleParameterDeclaration )
                // InternalExBeeLangTestLanguageParser.g:5157:9: lv_parameters_10_0= ruleParameterDeclaration
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
    // $ANTLR end synpred135_InternalExBeeLangTestLanguageParser

    // $ANTLR start synpred137_InternalExBeeLangTestLanguageParser
    public final void synpred137_InternalExBeeLangTestLanguageParser_fragment() throws RecognitionException {   
        EObject this_BlockExpressionWithoutBrackets_0 = null;


        // InternalExBeeLangTestLanguageParser.g:5256:3: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets )
        // InternalExBeeLangTestLanguageParser.g:5256:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
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
    // $ANTLR end synpred137_InternalExBeeLangTestLanguageParser

}

@SuppressWarnings("all")
public class InternalExBeeLangTestLanguageParser extends InternalExBeeLangTestLanguageParser3 {



        public InternalExBeeLangTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExBeeLangTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[259+1];
             
             
        }
        


        public InternalExBeeLangTestLanguageParser(TokenStream input, ExBeeLangTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
}
