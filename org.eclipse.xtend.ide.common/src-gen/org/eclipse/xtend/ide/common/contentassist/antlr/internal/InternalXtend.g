/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalXtend;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

tokens {
	KW_Package = 'package' ;
	KW_Semicolon = ';' ;
	KW_Class = 'class' ;
	KW_LessThanSign = '<' ;
	KW_Comma = ',' ;
	KW_GreaterThanSign = '>' ;
	KW_Extends = 'extends' ;
	KW_Implements = 'implements' ;
	KW_LeftCurlyBracket = '{' ;
	KW_RightCurlyBracket = '}' ;
	KW_Interface = 'interface' ;
	KW_Enum = 'enum' ;
	KW_Annotation = 'annotation' ;
	KW_LeftParenthesis = '(' ;
	KW_RightParenthesis = ')' ;
	KW_EqualsSignGreaterThanSign = '=>' ;
	KW_EqualsSign = '=' ;
	KW_Extension = 'extension' ;
	KW_Throws = 'throws' ;
	KW_New = 'new' ;
	KW_FullStop = '.' ;
	KW_Public = 'public' ;
	KW_Private = 'private' ;
	KW_Protected = 'protected' ;
	KW_Abstract = 'abstract' ;
	KW_Static = 'static' ;
	KW_Dispatch = 'dispatch' ;
	KW_Final = 'final' ;
	KW_Strictfp = 'strictfp' ;
	KW_Native = 'native' ;
	KW_Volatile = 'volatile' ;
	KW_Synchronized = 'synchronized' ;
	KW_Transient = 'transient' ;
	KW_Val = 'val' ;
	KW_Var = 'var' ;
	KW_Def = 'def' ;
	KW_Override = 'override' ;
	KW_Create = 'create' ;
	KW_Colon = ':' ;
	KW_AFTER = 'AFTER' ;
	KW_BEFORE = 'BEFORE' ;
	KW_SEPARATOR = 'SEPARATOR' ;
	KW_Import = 'import' ;
	KW_FullStopFullStopFullStop = '...' ;
	KW_QuestionMark = '?' ;
	KW_Try = 'try' ;
	KW_Finally = 'finally' ;
	KW_VerticalLine = '|' ;
	KW_Switch = 'switch' ;
	KW_Default = 'default' ;
	KW_Case = 'case' ;
	KW_FOR = 'FOR' ;
	KW_ENDFOR = 'ENDFOR' ;
	KW_IF = 'IF' ;
	KW_ELSE = 'ELSE' ;
	KW_ENDIF = 'ENDIF' ;
	KW_ELSEIF = 'ELSEIF' ;
	KW_CommercialAt = '@' ;
	KW_NumberSign = '#' ;
	KW_LeftSquareBracket = '[' ;
	KW_RightSquareBracket = ']' ;
	KW_PlusSignEqualsSign = '+=' ;
	KW_HyphenMinusEqualsSign = '-=' ;
	KW_AsteriskEqualsSign = '*=' ;
	KW_SolidusEqualsSign = '/=' ;
	KW_PercentSignEqualsSign = '%=' ;
	KW_GreaterThanSignEqualsSign = '>=' ;
	KW_VerticalLineVerticalLine = '||' ;
	KW_AmpersandAmpersand = '&&' ;
	KW_EqualsSignEqualsSign = '==' ;
	KW_ExclamationMarkEqualsSign = '!=' ;
	KW_EqualsSignEqualsSignEqualsSign = '===' ;
	KW_ExclamationMarkEqualsSignEqualsSign = '!==' ;
	KW_Instanceof = 'instanceof' ;
	KW_HyphenMinusGreaterThanSign = '->' ;
	KW_FullStopFullStopLessThanSign = '..<' ;
	KW_FullStopFullStop = '..' ;
	KW_LessThanSignGreaterThanSign = '<>' ;
	KW_QuestionMarkColon = '?:' ;
	KW_PlusSign = '+' ;
	KW_HyphenMinus = '-' ;
	KW_Asterisk = '*' ;
	KW_AsteriskAsterisk = '**' ;
	KW_Solidus = '/' ;
	KW_PercentSign = '%' ;
	KW_ExclamationMark = '!' ;
	KW_As = 'as' ;
	KW_PlusSignPlusSign = '++' ;
	KW_HyphenMinusHyphenMinus = '--' ;
	KW_ColonColon = '::' ;
	KW_QuestionMarkFullStop = '?.' ;
	KW_If = 'if' ;
	KW_Else = 'else' ;
	KW_For = 'for' ;
	KW_While = 'while' ;
	KW_Do = 'do' ;
	KW_Super = 'super' ;
	KW_False = 'false' ;
	KW_True = 'true' ;
	KW_Null = 'null' ;
	KW_Typeof = 'typeof' ;
	KW_Throw = 'throw' ;
	KW_Return = 'return' ;
	KW_Catch = 'catch' ;
	KW_Ampersand = '&' ;
}

@lexer::header {
package org.eclipse.xtend.ide.common.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtend.ide.common.contentassist.antlr.internal;

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
import org.eclipse.xtend.core.services.XtendGrammarAccess;

}
@parser::members {
	private XtendGrammarAccess grammarAccess;

	public void setGrammarAccess(XtendGrammarAccess grammarAccess) {
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
}

// Entry rule entryRuleFile
entryRuleFile
:
{ before(grammarAccess.getFileRule()); }
	 ruleFile
{ after(grammarAccess.getFileRule()); } 
	 EOF 
;

// Rule File
ruleFile 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFileAccess().getGroup()); }
		(rule__File__Group__0)
		{ after(grammarAccess.getFileAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleType
entryRuleType
:
{ before(grammarAccess.getTypeRule()); }
	 ruleType
{ after(grammarAccess.getTypeRule()); } 
	 EOF 
;

// Rule Type
ruleType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeAccess().getGroup()); }
		(rule__Type__Group__0)
		{ after(grammarAccess.getTypeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmSuperTypeReference
entryRuleJvmSuperTypeReference
:
{ before(grammarAccess.getJvmSuperTypeReferenceRule()); }
	 ruleJvmSuperTypeReference
{ after(grammarAccess.getJvmSuperTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmSuperTypeReference
ruleJvmSuperTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmSuperTypeReferenceAccess().getAlternatives()); }
		(rule__JvmSuperTypeReference__Alternatives)
		{ after(grammarAccess.getJvmSuperTypeReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXFunctionSuperTypeRef
entryRuleXFunctionSuperTypeRef
:
{ before(grammarAccess.getXFunctionSuperTypeRefRule()); }
	 ruleXFunctionSuperTypeRef
{ after(grammarAccess.getXFunctionSuperTypeRefRule()); } 
	 EOF 
;

// Rule XFunctionSuperTypeRef
ruleXFunctionSuperTypeRef 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup()); }
		(rule__XFunctionSuperTypeRef__Group__0)
		{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotationField
entryRuleAnnotationField
:
{ before(grammarAccess.getAnnotationFieldRule()); }
	 ruleAnnotationField
{ after(grammarAccess.getAnnotationFieldRule()); } 
	 EOF 
;

// Rule AnnotationField
ruleAnnotationField 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup()); }
		(rule__AnnotationField__Group__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleMember
entryRuleMember
:
{ before(grammarAccess.getMemberRule()); }
	 ruleMember
{ after(grammarAccess.getMemberRule()); } 
	 EOF 
;

// Rule Member
ruleMember 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMemberAccess().getGroup()); }
		(rule__Member__Group__0)
		{ after(grammarAccess.getMemberAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeReferenceNoTypeArgs
entryRuleTypeReferenceNoTypeArgs
:
{ before(grammarAccess.getTypeReferenceNoTypeArgsRule()); }
	 ruleTypeReferenceNoTypeArgs
{ after(grammarAccess.getTypeReferenceNoTypeArgsRule()); } 
	 EOF 
;

// Rule TypeReferenceNoTypeArgs
ruleTypeReferenceNoTypeArgs 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeAssignment()); }
		(rule__TypeReferenceNoTypeArgs__TypeAssignment)
		{ after(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeReferenceWithTypeArgs
entryRuleTypeReferenceWithTypeArgs
:
{ before(grammarAccess.getTypeReferenceWithTypeArgsRule()); }
	 ruleTypeReferenceWithTypeArgs
{ after(grammarAccess.getTypeReferenceWithTypeArgsRule()); } 
	 EOF 
;

// Rule TypeReferenceWithTypeArgs
ruleTypeReferenceWithTypeArgs 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getAlternatives()); }
		(rule__TypeReferenceWithTypeArgs__Alternatives)
		{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParameterizedTypeReferenceWithTypeArgs
entryRuleParameterizedTypeReferenceWithTypeArgs
:
{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule()); }
	 ruleParameterizedTypeReferenceWithTypeArgs
{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule()); } 
	 EOF 
;

// Rule ParameterizedTypeReferenceWithTypeArgs
ruleParameterizedTypeReferenceWithTypeArgs 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup()); }
		(rule__ParameterizedTypeReferenceWithTypeArgs__Group__0)
		{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFunctionID
entryRuleFunctionID
:
{ before(grammarAccess.getFunctionIDRule()); }
	 ruleFunctionID
{ after(grammarAccess.getFunctionIDRule()); } 
	 EOF 
;

// Rule FunctionID
ruleFunctionID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionIDAccess().getAlternatives()); }
		(rule__FunctionID__Alternatives)
		{ after(grammarAccess.getFunctionIDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOperators
entryRuleOperators
:
{ before(grammarAccess.getOperatorsRule()); }
	 ruleOperators
{ after(grammarAccess.getOperatorsRule()); } 
	 EOF 
;

// Rule Operators
ruleOperators 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOperatorsAccess().getAlternatives()); }
		(rule__Operators__Alternatives)
		{ after(grammarAccess.getOperatorsAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXtendEnumLiteral
entryRuleXtendEnumLiteral
:
{ before(grammarAccess.getXtendEnumLiteralRule()); }
	 ruleXtendEnumLiteral
{ after(grammarAccess.getXtendEnumLiteralRule()); } 
	 EOF 
;

// Rule XtendEnumLiteral
ruleXtendEnumLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXtendEnumLiteralAccess().getGroup()); }
		(rule__XtendEnumLiteral__Group__0)
		{ after(grammarAccess.getXtendEnumLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCommonModifier
entryRuleCommonModifier
:
{ before(grammarAccess.getCommonModifierRule()); }
	 ruleCommonModifier
{ after(grammarAccess.getCommonModifierRule()); } 
	 EOF 
;

// Rule CommonModifier
ruleCommonModifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCommonModifierAccess().getAlternatives()); }
		(rule__CommonModifier__Alternatives)
		{ after(grammarAccess.getCommonModifierAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFieldModifier
entryRuleFieldModifier
:
{ before(grammarAccess.getFieldModifierRule()); }
	 ruleFieldModifier
{ after(grammarAccess.getFieldModifierRule()); } 
	 EOF 
;

// Rule FieldModifier
ruleFieldModifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFieldModifierAccess().getAlternatives()); }
		(rule__FieldModifier__Alternatives)
		{ after(grammarAccess.getFieldModifierAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleMethodModifier
entryRuleMethodModifier
:
{ before(grammarAccess.getMethodModifierRule()); }
	 ruleMethodModifier
{ after(grammarAccess.getMethodModifierRule()); } 
	 EOF 
;

// Rule MethodModifier
ruleMethodModifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMethodModifierAccess().getAlternatives()); }
		(rule__MethodModifier__Alternatives)
		{ after(grammarAccess.getMethodModifierAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCreateExtensionInfo
entryRuleCreateExtensionInfo
:
{ before(grammarAccess.getCreateExtensionInfoRule()); }
	 ruleCreateExtensionInfo
{ after(grammarAccess.getCreateExtensionInfoRule()); } 
	 EOF 
;

// Rule CreateExtensionInfo
ruleCreateExtensionInfo 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCreateExtensionInfoAccess().getGroup()); }
		(rule__CreateExtensionInfo__Group__0)
		{ after(grammarAccess.getCreateExtensionInfoAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleValidID
entryRuleValidID
:
{ before(grammarAccess.getValidIDRule()); }
	 ruleValidID
{ after(grammarAccess.getValidIDRule()); } 
	 EOF 
;

// Rule ValidID
ruleValidID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getValidIDAccess().getAlternatives()); }
		(rule__ValidID__Alternatives)
		{ after(grammarAccess.getValidIDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFeatureCallID
entryRuleFeatureCallID
:
{ before(grammarAccess.getFeatureCallIDRule()); }
	 ruleFeatureCallID
{ after(grammarAccess.getFeatureCallIDRule()); } 
	 EOF 
;

// Rule FeatureCallID
ruleFeatureCallID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFeatureCallIDAccess().getAlternatives()); }
		(rule__FeatureCallID__Alternatives)
		{ after(grammarAccess.getFeatureCallIDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInnerVarID
entryRuleInnerVarID
:
{ before(grammarAccess.getInnerVarIDRule()); }
	 ruleInnerVarID
{ after(grammarAccess.getInnerVarIDRule()); } 
	 EOF 
;

// Rule InnerVarID
ruleInnerVarID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInnerVarIDAccess().getAlternatives()); }
		(rule__InnerVarID__Alternatives)
		{ after(grammarAccess.getInnerVarIDAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParameter
entryRuleParameter
:
{ before(grammarAccess.getParameterRule()); }
	 ruleParameter
{ after(grammarAccess.getParameterRule()); } 
	 EOF 
;

// Rule Parameter
ruleParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterAccess().getGroup()); }
		(rule__Parameter__Group__0)
		{ after(grammarAccess.getParameterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAssignment
entryRuleXAssignment
:
{ before(grammarAccess.getXAssignmentRule()); }
	 ruleXAssignment
{ after(grammarAccess.getXAssignmentRule()); } 
	 EOF 
;

// Rule XAssignment
ruleXAssignment 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAssignmentAccess().getAlternatives()); }
		(rule__XAssignment__Alternatives)
		{ after(grammarAccess.getXAssignmentAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXConditionalExpression
entryRuleXConditionalExpression
:
{ before(grammarAccess.getXConditionalExpressionRule()); }
	 ruleXConditionalExpression
{ after(grammarAccess.getXConditionalExpressionRule()); } 
	 EOF 
;

// Rule XConditionalExpression
ruleXConditionalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXConditionalExpressionAccess().getGroup()); }
		(rule__XConditionalExpression__Group__0)
		{ after(grammarAccess.getXConditionalExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXTryCatchFinallyExpression
entryRuleXTryCatchFinallyExpression
:
{ before(grammarAccess.getXTryCatchFinallyExpressionRule()); }
	 ruleXTryCatchFinallyExpression
{ after(grammarAccess.getXTryCatchFinallyExpressionRule()); } 
	 EOF 
;

// Rule XTryCatchFinallyExpression
ruleXTryCatchFinallyExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup()); }
		(rule__XTryCatchFinallyExpression__Group__0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXVariableDeclaration
entryRuleXVariableDeclaration
:
{ before(grammarAccess.getXVariableDeclarationRule()); }
	 ruleXVariableDeclaration
{ after(grammarAccess.getXVariableDeclarationRule()); } 
	 EOF 
;

// Rule XVariableDeclaration
ruleXVariableDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXVariableDeclarationAccess().getGroup()); }
		(rule__XVariableDeclaration__Group__0)
		{ after(grammarAccess.getXVariableDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInitializedVariableDeclaration
entryRuleInitializedVariableDeclaration
:
{ before(grammarAccess.getInitializedVariableDeclarationRule()); }
	 ruleInitializedVariableDeclaration
{ after(grammarAccess.getInitializedVariableDeclarationRule()); } 
	 EOF 
;

// Rule InitializedVariableDeclaration
ruleInitializedVariableDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInitializedVariableDeclarationAccess().getGroup()); }
		(rule__InitializedVariableDeclaration__Group__0)
		{ after(grammarAccess.getInitializedVariableDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule VariableModifier
ruleVariableModifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVariableModifierAccess().getAlternatives()); }
		(rule__VariableModifier__Alternatives)
		{ after(grammarAccess.getVariableModifierAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXConstructorCall
entryRuleXConstructorCall
:
{ before(grammarAccess.getXConstructorCallRule()); }
	 ruleXConstructorCall
{ after(grammarAccess.getXConstructorCallRule()); } 
	 EOF 
;

// Rule XConstructorCall
ruleXConstructorCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXConstructorCallAccess().getGroup()); }
		(rule__XConstructorCall__Group__0)
		{ after(grammarAccess.getXConstructorCallAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXbaseConstructorCall
entryRuleXbaseConstructorCall
:
{ before(grammarAccess.getXbaseConstructorCallRule()); }
	 ruleXbaseConstructorCall
{ after(grammarAccess.getXbaseConstructorCallRule()); } 
	 EOF 
;

// Rule XbaseConstructorCall
ruleXbaseConstructorCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getGroup()); }
		(rule__XbaseConstructorCall__Group__0)
		{ after(grammarAccess.getXbaseConstructorCallAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmFormalParameter
entryRuleJvmFormalParameter
:
{ before(grammarAccess.getJvmFormalParameterRule()); }
	 ruleJvmFormalParameter
{ after(grammarAccess.getJvmFormalParameterRule()); } 
	 EOF 
;

// Rule JvmFormalParameter
ruleJvmFormalParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmFormalParameterAccess().getGroup()); }
		(rule__JvmFormalParameter__Group__0)
		{ after(grammarAccess.getJvmFormalParameterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFullJvmFormalParameter
entryRuleFullJvmFormalParameter
:
{ before(grammarAccess.getFullJvmFormalParameterRule()); }
	 ruleFullJvmFormalParameter
{ after(grammarAccess.getFullJvmFormalParameterRule()); } 
	 EOF 
;

// Rule FullJvmFormalParameter
ruleFullJvmFormalParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFullJvmFormalParameterAccess().getGroup()); }
		(rule__FullJvmFormalParameter__Group__0)
		{ after(grammarAccess.getFullJvmFormalParameterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleMultiTypeReference
entryRuleMultiTypeReference
:
{ before(grammarAccess.getMultiTypeReferenceRule()); }
	 ruleMultiTypeReference
{ after(grammarAccess.getMultiTypeReferenceRule()); } 
	 EOF 
;

// Rule MultiTypeReference
ruleMultiTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMultiTypeReferenceAccess().getGroup()); }
		(rule__MultiTypeReference__Group__0)
		{ after(grammarAccess.getMultiTypeReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXStringLiteral
entryRuleXStringLiteral
:
{ before(grammarAccess.getXStringLiteralRule()); }
	 ruleXStringLiteral
{ after(grammarAccess.getXStringLiteralRule()); } 
	 EOF 
;

// Rule XStringLiteral
ruleXStringLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXStringLiteralAccess().getAlternatives()); }
		(rule__XStringLiteral__Alternatives)
		{ after(grammarAccess.getXStringLiteralAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXSwitchExpression
entryRuleXSwitchExpression
:
{ before(grammarAccess.getXSwitchExpressionRule()); }
	 ruleXSwitchExpression
{ after(grammarAccess.getXSwitchExpressionRule()); } 
	 EOF 
;

// Rule XSwitchExpression
ruleXSwitchExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getGroup()); }
		(rule__XSwitchExpression__Group__0)
		{ after(grammarAccess.getXSwitchExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXCasePart
entryRuleXCasePart
:
{ before(grammarAccess.getXCasePartRule()); }
	 ruleXCasePart
{ after(grammarAccess.getXCasePartRule()); } 
	 EOF 
;

// Rule XCasePart
ruleXCasePart 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXCasePartAccess().getGroup()); }
		(rule__XCasePart__Group__0)
		{ after(grammarAccess.getXCasePartAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXExpressionOrSimpleConstructorCall
entryRuleXExpressionOrSimpleConstructorCall
:
{ before(grammarAccess.getXExpressionOrSimpleConstructorCallRule()); }
	 ruleXExpressionOrSimpleConstructorCall
{ after(grammarAccess.getXExpressionOrSimpleConstructorCallRule()); } 
	 EOF 
;

// Rule XExpressionOrSimpleConstructorCall
ruleXExpressionOrSimpleConstructorCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getAlternatives()); }
		(rule__XExpressionOrSimpleConstructorCall__Alternatives)
		{ after(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSimpleStringLiteral
entryRuleSimpleStringLiteral
:
{ before(grammarAccess.getSimpleStringLiteralRule()); }
	 ruleSimpleStringLiteral
{ after(grammarAccess.getSimpleStringLiteralRule()); } 
	 EOF 
;

// Rule SimpleStringLiteral
ruleSimpleStringLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSimpleStringLiteralAccess().getGroup()); }
		(rule__SimpleStringLiteral__Group__0)
		{ after(grammarAccess.getSimpleStringLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichString
entryRuleRichString
:
{ before(grammarAccess.getRichStringRule()); }
	 ruleRichString
{ after(grammarAccess.getRichStringRule()); } 
	 EOF 
;

// Rule RichString
ruleRichString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringAccess().getGroup()); }
		(rule__RichString__Group__0)
		{ after(grammarAccess.getRichStringAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringLiteral
entryRuleRichStringLiteral
:
{ before(grammarAccess.getRichStringLiteralRule()); }
	 ruleRichStringLiteral
{ after(grammarAccess.getRichStringLiteralRule()); } 
	 EOF 
;

// Rule RichStringLiteral
ruleRichStringLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringLiteralAccess().getGroup()); }
		(rule__RichStringLiteral__Group__0)
		{ after(grammarAccess.getRichStringLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringLiteralStart
entryRuleRichStringLiteralStart
:
{ before(grammarAccess.getRichStringLiteralStartRule()); }
	 ruleRichStringLiteralStart
{ after(grammarAccess.getRichStringLiteralStartRule()); } 
	 EOF 
;

// Rule RichStringLiteralStart
ruleRichStringLiteralStart 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringLiteralStartAccess().getGroup()); }
		(rule__RichStringLiteralStart__Group__0)
		{ after(grammarAccess.getRichStringLiteralStartAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringLiteralInbetween
entryRuleRichStringLiteralInbetween
:
{ before(grammarAccess.getRichStringLiteralInbetweenRule()); }
	 ruleRichStringLiteralInbetween
{ after(grammarAccess.getRichStringLiteralInbetweenRule()); } 
	 EOF 
;

// Rule RichStringLiteralInbetween
ruleRichStringLiteralInbetween 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringLiteralInbetweenAccess().getGroup()); }
		(rule__RichStringLiteralInbetween__Group__0)
		{ after(grammarAccess.getRichStringLiteralInbetweenAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringLiteralEnd
entryRuleRichStringLiteralEnd
:
{ before(grammarAccess.getRichStringLiteralEndRule()); }
	 ruleRichStringLiteralEnd
{ after(grammarAccess.getRichStringLiteralEndRule()); } 
	 EOF 
;

// Rule RichStringLiteralEnd
ruleRichStringLiteralEnd 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringLiteralEndAccess().getGroup()); }
		(rule__RichStringLiteralEnd__Group__0)
		{ after(grammarAccess.getRichStringLiteralEndAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInternalRichString
entryRuleInternalRichString
:
{ before(grammarAccess.getInternalRichStringRule()); }
	 ruleInternalRichString
{ after(grammarAccess.getInternalRichStringRule()); } 
	 EOF 
;

// Rule InternalRichString
ruleInternalRichString 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInternalRichStringAccess().getGroup()); }
		(rule__InternalRichString__Group__0)
		{ after(grammarAccess.getInternalRichStringAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringPart
entryRuleRichStringPart
:
{ before(grammarAccess.getRichStringPartRule()); }
	 ruleRichStringPart
{ after(grammarAccess.getRichStringPartRule()); } 
	 EOF 
;

// Rule RichStringPart
ruleRichStringPart 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringPartAccess().getAlternatives()); }
		(rule__RichStringPart__Alternatives)
		{ after(grammarAccess.getRichStringPartAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringForLoop
entryRuleRichStringForLoop
:
{ before(grammarAccess.getRichStringForLoopRule()); }
	 ruleRichStringForLoop
{ after(grammarAccess.getRichStringForLoopRule()); } 
	 EOF 
;

// Rule RichStringForLoop
ruleRichStringForLoop 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringForLoopAccess().getGroup()); }
		(rule__RichStringForLoop__Group__0)
		{ after(grammarAccess.getRichStringForLoopAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringIf
entryRuleRichStringIf
:
{ before(grammarAccess.getRichStringIfRule()); }
	 ruleRichStringIf
{ after(grammarAccess.getRichStringIfRule()); } 
	 EOF 
;

// Rule RichStringIf
ruleRichStringIf 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringIfAccess().getGroup()); }
		(rule__RichStringIf__Group__0)
		{ after(grammarAccess.getRichStringIfAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRichStringElseIf
entryRuleRichStringElseIf
:
{ before(grammarAccess.getRichStringElseIfRule()); }
	 ruleRichStringElseIf
{ after(grammarAccess.getRichStringElseIfRule()); } 
	 EOF 
;

// Rule RichStringElseIf
ruleRichStringElseIf 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRichStringElseIfAccess().getGroup()); }
		(rule__RichStringElseIf__Group__0)
		{ after(grammarAccess.getRichStringElseIfAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAnnotation
entryRuleXAnnotation
:
{ before(grammarAccess.getXAnnotationRule()); }
	 ruleXAnnotation
{ after(grammarAccess.getXAnnotationRule()); } 
	 EOF 
;

// Rule XAnnotation
ruleXAnnotation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAnnotationAccess().getGroup()); }
		(rule__XAnnotation__Group__0)
		{ after(grammarAccess.getXAnnotationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAnnotationElementValuePair
entryRuleXAnnotationElementValuePair
:
{ before(grammarAccess.getXAnnotationElementValuePairRule()); }
	 ruleXAnnotationElementValuePair
{ after(grammarAccess.getXAnnotationElementValuePairRule()); } 
	 EOF 
;

// Rule XAnnotationElementValuePair
ruleXAnnotationElementValuePair 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAnnotationElementValuePairAccess().getGroup()); }
		(rule__XAnnotationElementValuePair__Group__0)
		{ after(grammarAccess.getXAnnotationElementValuePairAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAnnotationElementValueOrCommaList
entryRuleXAnnotationElementValueOrCommaList
:
{ before(grammarAccess.getXAnnotationElementValueOrCommaListRule()); }
	 ruleXAnnotationElementValueOrCommaList
{ after(grammarAccess.getXAnnotationElementValueOrCommaListRule()); } 
	 EOF 
;

// Rule XAnnotationElementValueOrCommaList
ruleXAnnotationElementValueOrCommaList 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getAlternatives()); }
		(rule__XAnnotationElementValueOrCommaList__Alternatives)
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAnnotationElementValue
entryRuleXAnnotationElementValue
:
{ before(grammarAccess.getXAnnotationElementValueRule()); }
	 ruleXAnnotationElementValue
{ after(grammarAccess.getXAnnotationElementValueRule()); } 
	 EOF 
;

// Rule XAnnotationElementValue
ruleXAnnotationElementValue 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAnnotationElementValueAccess().getAlternatives()); }
		(rule__XAnnotationElementValue__Alternatives)
		{ after(grammarAccess.getXAnnotationElementValueAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAnnotationOrExpression
entryRuleXAnnotationOrExpression
:
{ before(grammarAccess.getXAnnotationOrExpressionRule()); }
	 ruleXAnnotationOrExpression
{ after(grammarAccess.getXAnnotationOrExpressionRule()); } 
	 EOF 
;

// Rule XAnnotationOrExpression
ruleXAnnotationOrExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAnnotationOrExpressionAccess().getAlternatives()); }
		(rule__XAnnotationOrExpression__Alternatives)
		{ after(grammarAccess.getXAnnotationOrExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXExpression
entryRuleXExpression
:
{ before(grammarAccess.getXExpressionRule()); }
	 ruleXExpression
{ after(grammarAccess.getXExpressionRule()); } 
	 EOF 
;

// Rule XExpression
ruleXExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); }
		ruleXAssignment
		{ after(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpSingleAssign
entryRuleOpSingleAssign
:
{ before(grammarAccess.getOpSingleAssignRule()); }
	 ruleOpSingleAssign
{ after(grammarAccess.getOpSingleAssignRule()); } 
	 EOF 
;

// Rule OpSingleAssign
ruleOpSingleAssign 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); }
		'='
		{ after(grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpMultiAssign
entryRuleOpMultiAssign
:
{ before(grammarAccess.getOpMultiAssignRule()); }
	 ruleOpMultiAssign
{ after(grammarAccess.getOpMultiAssignRule()); } 
	 EOF 
;

// Rule OpMultiAssign
ruleOpMultiAssign 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getAlternatives()); }
		(rule__OpMultiAssign__Alternatives)
		{ after(grammarAccess.getOpMultiAssignAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXOrExpression
entryRuleXOrExpression
:
{ before(grammarAccess.getXOrExpressionRule()); }
	 ruleXOrExpression
{ after(grammarAccess.getXOrExpressionRule()); } 
	 EOF 
;

// Rule XOrExpression
ruleXOrExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXOrExpressionAccess().getGroup()); }
		(rule__XOrExpression__Group__0)
		{ after(grammarAccess.getXOrExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpOr
entryRuleOpOr
:
{ before(grammarAccess.getOpOrRule()); }
	 ruleOpOr
{ after(grammarAccess.getOpOrRule()); } 
	 EOF 
;

// Rule OpOr
ruleOpOr 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); }
		'||'
		{ after(grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAndExpression
entryRuleXAndExpression
:
{ before(grammarAccess.getXAndExpressionRule()); }
	 ruleXAndExpression
{ after(grammarAccess.getXAndExpressionRule()); } 
	 EOF 
;

// Rule XAndExpression
ruleXAndExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAndExpressionAccess().getGroup()); }
		(rule__XAndExpression__Group__0)
		{ after(grammarAccess.getXAndExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpAnd
entryRuleOpAnd
:
{ before(grammarAccess.getOpAndRule()); }
	 ruleOpAnd
{ after(grammarAccess.getOpAndRule()); } 
	 EOF 
;

// Rule OpAnd
ruleOpAnd 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); }
		'&&'
		{ after(grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXEqualityExpression
entryRuleXEqualityExpression
:
{ before(grammarAccess.getXEqualityExpressionRule()); }
	 ruleXEqualityExpression
{ after(grammarAccess.getXEqualityExpressionRule()); } 
	 EOF 
;

// Rule XEqualityExpression
ruleXEqualityExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXEqualityExpressionAccess().getGroup()); }
		(rule__XEqualityExpression__Group__0)
		{ after(grammarAccess.getXEqualityExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpEquality
entryRuleOpEquality
:
{ before(grammarAccess.getOpEqualityRule()); }
	 ruleOpEquality
{ after(grammarAccess.getOpEqualityRule()); } 
	 EOF 
;

// Rule OpEquality
ruleOpEquality 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpEqualityAccess().getAlternatives()); }
		(rule__OpEquality__Alternatives)
		{ after(grammarAccess.getOpEqualityAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXRelationalExpression
entryRuleXRelationalExpression
:
{ before(grammarAccess.getXRelationalExpressionRule()); }
	 ruleXRelationalExpression
{ after(grammarAccess.getXRelationalExpressionRule()); } 
	 EOF 
;

// Rule XRelationalExpression
ruleXRelationalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXRelationalExpressionAccess().getGroup()); }
		(rule__XRelationalExpression__Group__0)
		{ after(grammarAccess.getXRelationalExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpCompare
entryRuleOpCompare
:
{ before(grammarAccess.getOpCompareRule()); }
	 ruleOpCompare
{ after(grammarAccess.getOpCompareRule()); } 
	 EOF 
;

// Rule OpCompare
ruleOpCompare 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpCompareAccess().getAlternatives()); }
		(rule__OpCompare__Alternatives)
		{ after(grammarAccess.getOpCompareAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXOtherOperatorExpression
entryRuleXOtherOperatorExpression
:
{ before(grammarAccess.getXOtherOperatorExpressionRule()); }
	 ruleXOtherOperatorExpression
{ after(grammarAccess.getXOtherOperatorExpressionRule()); } 
	 EOF 
;

// Rule XOtherOperatorExpression
ruleXOtherOperatorExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXOtherOperatorExpressionAccess().getGroup()); }
		(rule__XOtherOperatorExpression__Group__0)
		{ after(grammarAccess.getXOtherOperatorExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpOther
entryRuleOpOther
:
{ before(grammarAccess.getOpOtherRule()); }
	 ruleOpOther
{ after(grammarAccess.getOpOtherRule()); } 
	 EOF 
;

// Rule OpOther
ruleOpOther 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpOtherAccess().getAlternatives()); }
		(rule__OpOther__Alternatives)
		{ after(grammarAccess.getOpOtherAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXAdditiveExpression
entryRuleXAdditiveExpression
:
{ before(grammarAccess.getXAdditiveExpressionRule()); }
	 ruleXAdditiveExpression
{ after(grammarAccess.getXAdditiveExpressionRule()); } 
	 EOF 
;

// Rule XAdditiveExpression
ruleXAdditiveExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXAdditiveExpressionAccess().getGroup()); }
		(rule__XAdditiveExpression__Group__0)
		{ after(grammarAccess.getXAdditiveExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpAdd
entryRuleOpAdd
:
{ before(grammarAccess.getOpAddRule()); }
	 ruleOpAdd
{ after(grammarAccess.getOpAddRule()); } 
	 EOF 
;

// Rule OpAdd
ruleOpAdd 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpAddAccess().getAlternatives()); }
		(rule__OpAdd__Alternatives)
		{ after(grammarAccess.getOpAddAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXMultiplicativeExpression
entryRuleXMultiplicativeExpression
:
{ before(grammarAccess.getXMultiplicativeExpressionRule()); }
	 ruleXMultiplicativeExpression
{ after(grammarAccess.getXMultiplicativeExpressionRule()); } 
	 EOF 
;

// Rule XMultiplicativeExpression
ruleXMultiplicativeExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXMultiplicativeExpressionAccess().getGroup()); }
		(rule__XMultiplicativeExpression__Group__0)
		{ after(grammarAccess.getXMultiplicativeExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpMulti
entryRuleOpMulti
:
{ before(grammarAccess.getOpMultiRule()); }
	 ruleOpMulti
{ after(grammarAccess.getOpMultiRule()); } 
	 EOF 
;

// Rule OpMulti
ruleOpMulti 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpMultiAccess().getAlternatives()); }
		(rule__OpMulti__Alternatives)
		{ after(grammarAccess.getOpMultiAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXUnaryOperation
entryRuleXUnaryOperation
:
{ before(grammarAccess.getXUnaryOperationRule()); }
	 ruleXUnaryOperation
{ after(grammarAccess.getXUnaryOperationRule()); } 
	 EOF 
;

// Rule XUnaryOperation
ruleXUnaryOperation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXUnaryOperationAccess().getAlternatives()); }
		(rule__XUnaryOperation__Alternatives)
		{ after(grammarAccess.getXUnaryOperationAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpUnary
entryRuleOpUnary
:
{ before(grammarAccess.getOpUnaryRule()); }
	 ruleOpUnary
{ after(grammarAccess.getOpUnaryRule()); } 
	 EOF 
;

// Rule OpUnary
ruleOpUnary 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpUnaryAccess().getAlternatives()); }
		(rule__OpUnary__Alternatives)
		{ after(grammarAccess.getOpUnaryAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXCastedExpression
entryRuleXCastedExpression
:
{ before(grammarAccess.getXCastedExpressionRule()); }
	 ruleXCastedExpression
{ after(grammarAccess.getXCastedExpressionRule()); } 
	 EOF 
;

// Rule XCastedExpression
ruleXCastedExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXCastedExpressionAccess().getGroup()); }
		(rule__XCastedExpression__Group__0)
		{ after(grammarAccess.getXCastedExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXPostfixOperation
entryRuleXPostfixOperation
:
{ before(grammarAccess.getXPostfixOperationRule()); }
	 ruleXPostfixOperation
{ after(grammarAccess.getXPostfixOperationRule()); } 
	 EOF 
;

// Rule XPostfixOperation
ruleXPostfixOperation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXPostfixOperationAccess().getGroup()); }
		(rule__XPostfixOperation__Group__0)
		{ after(grammarAccess.getXPostfixOperationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOpPostfix
entryRuleOpPostfix
:
{ before(grammarAccess.getOpPostfixRule()); }
	 ruleOpPostfix
{ after(grammarAccess.getOpPostfixRule()); } 
	 EOF 
;

// Rule OpPostfix
ruleOpPostfix 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOpPostfixAccess().getAlternatives()); }
		(rule__OpPostfix__Alternatives)
		{ after(grammarAccess.getOpPostfixAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXMemberFeatureCall
entryRuleXMemberFeatureCall
:
{ before(grammarAccess.getXMemberFeatureCallRule()); }
	 ruleXMemberFeatureCall
{ after(grammarAccess.getXMemberFeatureCallRule()); } 
	 EOF 
;

// Rule XMemberFeatureCall
ruleXMemberFeatureCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup()); }
		(rule__XMemberFeatureCall__Group__0)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXPrimaryExpression
entryRuleXPrimaryExpression
:
{ before(grammarAccess.getXPrimaryExpressionRule()); }
	 ruleXPrimaryExpression
{ after(grammarAccess.getXPrimaryExpressionRule()); } 
	 EOF 
;

// Rule XPrimaryExpression
ruleXPrimaryExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getAlternatives()); }
		(rule__XPrimaryExpression__Alternatives)
		{ after(grammarAccess.getXPrimaryExpressionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXLiteral
entryRuleXLiteral
:
{ before(grammarAccess.getXLiteralRule()); }
	 ruleXLiteral
{ after(grammarAccess.getXLiteralRule()); } 
	 EOF 
;

// Rule XLiteral
ruleXLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXLiteralAccess().getAlternatives()); }
		(rule__XLiteral__Alternatives)
		{ after(grammarAccess.getXLiteralAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXCollectionLiteral
entryRuleXCollectionLiteral
:
{ before(grammarAccess.getXCollectionLiteralRule()); }
	 ruleXCollectionLiteral
{ after(grammarAccess.getXCollectionLiteralRule()); } 
	 EOF 
;

// Rule XCollectionLiteral
ruleXCollectionLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXCollectionLiteralAccess().getAlternatives()); }
		(rule__XCollectionLiteral__Alternatives)
		{ after(grammarAccess.getXCollectionLiteralAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXSetLiteral
entryRuleXSetLiteral
:
{ before(grammarAccess.getXSetLiteralRule()); }
	 ruleXSetLiteral
{ after(grammarAccess.getXSetLiteralRule()); } 
	 EOF 
;

// Rule XSetLiteral
ruleXSetLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXSetLiteralAccess().getGroup()); }
		(rule__XSetLiteral__Group__0)
		{ after(grammarAccess.getXSetLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXListLiteral
entryRuleXListLiteral
:
{ before(grammarAccess.getXListLiteralRule()); }
	 ruleXListLiteral
{ after(grammarAccess.getXListLiteralRule()); } 
	 EOF 
;

// Rule XListLiteral
ruleXListLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXListLiteralAccess().getGroup()); }
		(rule__XListLiteral__Group__0)
		{ after(grammarAccess.getXListLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXClosure
entryRuleXClosure
:
{ before(grammarAccess.getXClosureRule()); }
	 ruleXClosure
{ after(grammarAccess.getXClosureRule()); } 
	 EOF 
;

// Rule XClosure
ruleXClosure 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXClosureAccess().getGroup()); }
		(rule__XClosure__Group__0)
		{ after(grammarAccess.getXClosureAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXExpressionInClosure
entryRuleXExpressionInClosure
:
{ before(grammarAccess.getXExpressionInClosureRule()); }
	 ruleXExpressionInClosure
{ after(grammarAccess.getXExpressionInClosureRule()); } 
	 EOF 
;

// Rule XExpressionInClosure
ruleXExpressionInClosure 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXExpressionInClosureAccess().getGroup()); }
		(rule__XExpressionInClosure__Group__0)
		{ after(grammarAccess.getXExpressionInClosureAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXShortClosure
entryRuleXShortClosure
:
{ before(grammarAccess.getXShortClosureRule()); }
	 ruleXShortClosure
{ after(grammarAccess.getXShortClosureRule()); } 
	 EOF 
;

// Rule XShortClosure
ruleXShortClosure 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXShortClosureAccess().getGroup()); }
		(rule__XShortClosure__Group__0)
		{ after(grammarAccess.getXShortClosureAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXParenthesizedExpression
entryRuleXParenthesizedExpression
:
{ before(grammarAccess.getXParenthesizedExpressionRule()); }
	 ruleXParenthesizedExpression
{ after(grammarAccess.getXParenthesizedExpressionRule()); } 
	 EOF 
;

// Rule XParenthesizedExpression
ruleXParenthesizedExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXParenthesizedExpressionAccess().getGroup()); }
		(rule__XParenthesizedExpression__Group__0)
		{ after(grammarAccess.getXParenthesizedExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXIfExpression
entryRuleXIfExpression
:
{ before(grammarAccess.getXIfExpressionRule()); }
	 ruleXIfExpression
{ after(grammarAccess.getXIfExpressionRule()); } 
	 EOF 
;

// Rule XIfExpression
ruleXIfExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXIfExpressionAccess().getGroup()); }
		(rule__XIfExpression__Group__0)
		{ after(grammarAccess.getXIfExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXForLoopExpression
entryRuleXForLoopExpression
:
{ before(grammarAccess.getXForLoopExpressionRule()); }
	 ruleXForLoopExpression
{ after(grammarAccess.getXForLoopExpressionRule()); } 
	 EOF 
;

// Rule XForLoopExpression
ruleXForLoopExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXForLoopExpressionAccess().getGroup()); }
		(rule__XForLoopExpression__Group__0)
		{ after(grammarAccess.getXForLoopExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXBasicForLoopExpression
entryRuleXBasicForLoopExpression
:
{ before(grammarAccess.getXBasicForLoopExpressionRule()); }
	 ruleXBasicForLoopExpression
{ after(grammarAccess.getXBasicForLoopExpressionRule()); } 
	 EOF 
;

// Rule XBasicForLoopExpression
ruleXBasicForLoopExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXBasicForLoopExpressionAccess().getGroup()); }
		(rule__XBasicForLoopExpression__Group__0)
		{ after(grammarAccess.getXBasicForLoopExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXWhileExpression
entryRuleXWhileExpression
:
{ before(grammarAccess.getXWhileExpressionRule()); }
	 ruleXWhileExpression
{ after(grammarAccess.getXWhileExpressionRule()); } 
	 EOF 
;

// Rule XWhileExpression
ruleXWhileExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXWhileExpressionAccess().getGroup()); }
		(rule__XWhileExpression__Group__0)
		{ after(grammarAccess.getXWhileExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXDoWhileExpression
entryRuleXDoWhileExpression
:
{ before(grammarAccess.getXDoWhileExpressionRule()); }
	 ruleXDoWhileExpression
{ after(grammarAccess.getXDoWhileExpressionRule()); } 
	 EOF 
;

// Rule XDoWhileExpression
ruleXDoWhileExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXDoWhileExpressionAccess().getGroup()); }
		(rule__XDoWhileExpression__Group__0)
		{ after(grammarAccess.getXDoWhileExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXBlockExpression
entryRuleXBlockExpression
:
{ before(grammarAccess.getXBlockExpressionRule()); }
	 ruleXBlockExpression
{ after(grammarAccess.getXBlockExpressionRule()); } 
	 EOF 
;

// Rule XBlockExpression
ruleXBlockExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXBlockExpressionAccess().getGroup()); }
		(rule__XBlockExpression__Group__0)
		{ after(grammarAccess.getXBlockExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXExpressionOrVarDeclaration
entryRuleXExpressionOrVarDeclaration
:
{ before(grammarAccess.getXExpressionOrVarDeclarationRule()); }
	 ruleXExpressionOrVarDeclaration
{ after(grammarAccess.getXExpressionOrVarDeclarationRule()); } 
	 EOF 
;

// Rule XExpressionOrVarDeclaration
ruleXExpressionOrVarDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXExpressionOrVarDeclarationAccess().getAlternatives()); }
		(rule__XExpressionOrVarDeclaration__Alternatives)
		{ after(grammarAccess.getXExpressionOrVarDeclarationAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXFeatureCall
entryRuleXFeatureCall
:
{ before(grammarAccess.getXFeatureCallRule()); }
	 ruleXFeatureCall
{ after(grammarAccess.getXFeatureCallRule()); } 
	 EOF 
;

// Rule XFeatureCall
ruleXFeatureCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getGroup()); }
		(rule__XFeatureCall__Group__0)
		{ after(grammarAccess.getXFeatureCallAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIdOrSuper
entryRuleIdOrSuper
:
{ before(grammarAccess.getIdOrSuperRule()); }
	 ruleIdOrSuper
{ after(grammarAccess.getIdOrSuperRule()); } 
	 EOF 
;

// Rule IdOrSuper
ruleIdOrSuper 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdOrSuperAccess().getAlternatives()); }
		(rule__IdOrSuper__Alternatives)
		{ after(grammarAccess.getIdOrSuperAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXBooleanLiteral
entryRuleXBooleanLiteral
:
{ before(grammarAccess.getXBooleanLiteralRule()); }
	 ruleXBooleanLiteral
{ after(grammarAccess.getXBooleanLiteralRule()); } 
	 EOF 
;

// Rule XBooleanLiteral
ruleXBooleanLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXBooleanLiteralAccess().getGroup()); }
		(rule__XBooleanLiteral__Group__0)
		{ after(grammarAccess.getXBooleanLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXNullLiteral
entryRuleXNullLiteral
:
{ before(grammarAccess.getXNullLiteralRule()); }
	 ruleXNullLiteral
{ after(grammarAccess.getXNullLiteralRule()); } 
	 EOF 
;

// Rule XNullLiteral
ruleXNullLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXNullLiteralAccess().getGroup()); }
		(rule__XNullLiteral__Group__0)
		{ after(grammarAccess.getXNullLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXNumberLiteral
entryRuleXNumberLiteral
:
{ before(grammarAccess.getXNumberLiteralRule()); }
	 ruleXNumberLiteral
{ after(grammarAccess.getXNumberLiteralRule()); } 
	 EOF 
;

// Rule XNumberLiteral
ruleXNumberLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXNumberLiteralAccess().getGroup()); }
		(rule__XNumberLiteral__Group__0)
		{ after(grammarAccess.getXNumberLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXTypeLiteral
entryRuleXTypeLiteral
:
{ before(grammarAccess.getXTypeLiteralRule()); }
	 ruleXTypeLiteral
{ after(grammarAccess.getXTypeLiteralRule()); } 
	 EOF 
;

// Rule XTypeLiteral
ruleXTypeLiteral 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXTypeLiteralAccess().getGroup()); }
		(rule__XTypeLiteral__Group__0)
		{ after(grammarAccess.getXTypeLiteralAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXThrowExpression
entryRuleXThrowExpression
:
{ before(grammarAccess.getXThrowExpressionRule()); }
	 ruleXThrowExpression
{ after(grammarAccess.getXThrowExpressionRule()); } 
	 EOF 
;

// Rule XThrowExpression
ruleXThrowExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXThrowExpressionAccess().getGroup()); }
		(rule__XThrowExpression__Group__0)
		{ after(grammarAccess.getXThrowExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXReturnExpression
entryRuleXReturnExpression
:
{ before(grammarAccess.getXReturnExpressionRule()); }
	 ruleXReturnExpression
{ after(grammarAccess.getXReturnExpressionRule()); } 
	 EOF 
;

// Rule XReturnExpression
ruleXReturnExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXReturnExpressionAccess().getGroup()); }
		(rule__XReturnExpression__Group__0)
		{ after(grammarAccess.getXReturnExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXSynchronizedExpression
entryRuleXSynchronizedExpression
:
{ before(grammarAccess.getXSynchronizedExpressionRule()); }
	 ruleXSynchronizedExpression
{ after(grammarAccess.getXSynchronizedExpressionRule()); } 
	 EOF 
;

// Rule XSynchronizedExpression
ruleXSynchronizedExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXSynchronizedExpressionAccess().getGroup()); }
		(rule__XSynchronizedExpression__Group__0)
		{ after(grammarAccess.getXSynchronizedExpressionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXCatchClause
entryRuleXCatchClause
:
{ before(grammarAccess.getXCatchClauseRule()); }
	 ruleXCatchClause
{ after(grammarAccess.getXCatchClauseRule()); } 
	 EOF 
;

// Rule XCatchClause
ruleXCatchClause 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXCatchClauseAccess().getGroup()); }
		(rule__XCatchClause__Group__0)
		{ after(grammarAccess.getXCatchClauseAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
		(rule__QualifiedName__Group__0)
		{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNumber
entryRuleNumber
@init { 
	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
}
:
{ before(grammarAccess.getNumberRule()); }
	 ruleNumber
{ after(grammarAccess.getNumberRule()); } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Number
ruleNumber 
	@init {
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNumberAccess().getAlternatives()); }
		(rule__Number__Alternatives)
		{ after(grammarAccess.getNumberAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
	myHiddenTokenState.restore();
}

// Entry rule entryRuleJvmTypeReference
entryRuleJvmTypeReference
:
{ before(grammarAccess.getJvmTypeReferenceRule()); }
	 ruleJvmTypeReference
{ after(grammarAccess.getJvmTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmTypeReference
ruleJvmTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); }
		(rule__JvmTypeReference__Alternatives)
		{ after(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArrayBrackets
entryRuleArrayBrackets
:
{ before(grammarAccess.getArrayBracketsRule()); }
	 ruleArrayBrackets
{ after(grammarAccess.getArrayBracketsRule()); } 
	 EOF 
;

// Rule ArrayBrackets
ruleArrayBrackets 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArrayBracketsAccess().getGroup()); }
		(rule__ArrayBrackets__Group__0)
		{ after(grammarAccess.getArrayBracketsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXFunctionTypeRef
entryRuleXFunctionTypeRef
:
{ before(grammarAccess.getXFunctionTypeRefRule()); }
	 ruleXFunctionTypeRef
{ after(grammarAccess.getXFunctionTypeRefRule()); } 
	 EOF 
;

// Rule XFunctionTypeRef
ruleXFunctionTypeRef 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup()); }
		(rule__XFunctionTypeRef__Group__0)
		{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmParameterizedTypeReference
entryRuleJvmParameterizedTypeReference
:
{ before(grammarAccess.getJvmParameterizedTypeReferenceRule()); }
	 ruleJvmParameterizedTypeReference
{ after(grammarAccess.getJvmParameterizedTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmParameterizedTypeReference
ruleJvmParameterizedTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); }
		(rule__JvmParameterizedTypeReference__Group__0)
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmArgumentTypeReference
entryRuleJvmArgumentTypeReference
:
{ before(grammarAccess.getJvmArgumentTypeReferenceRule()); }
	 ruleJvmArgumentTypeReference
{ after(grammarAccess.getJvmArgumentTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmArgumentTypeReference
ruleJvmArgumentTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); }
		(rule__JvmArgumentTypeReference__Alternatives)
		{ after(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmWildcardTypeReference
entryRuleJvmWildcardTypeReference
:
{ before(grammarAccess.getJvmWildcardTypeReferenceRule()); }
	 ruleJvmWildcardTypeReference
{ after(grammarAccess.getJvmWildcardTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmWildcardTypeReference
ruleJvmWildcardTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); }
		(rule__JvmWildcardTypeReference__Group__0)
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmUpperBound
entryRuleJvmUpperBound
:
{ before(grammarAccess.getJvmUpperBoundRule()); }
	 ruleJvmUpperBound
{ after(grammarAccess.getJvmUpperBoundRule()); } 
	 EOF 
;

// Rule JvmUpperBound
ruleJvmUpperBound 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmUpperBoundAccess().getGroup()); }
		(rule__JvmUpperBound__Group__0)
		{ after(grammarAccess.getJvmUpperBoundAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmUpperBoundAnded
entryRuleJvmUpperBoundAnded
:
{ before(grammarAccess.getJvmUpperBoundAndedRule()); }
	 ruleJvmUpperBoundAnded
{ after(grammarAccess.getJvmUpperBoundAndedRule()); } 
	 EOF 
;

// Rule JvmUpperBoundAnded
ruleJvmUpperBoundAnded 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); }
		(rule__JvmUpperBoundAnded__Group__0)
		{ after(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmLowerBound
entryRuleJvmLowerBound
:
{ before(grammarAccess.getJvmLowerBoundRule()); }
	 ruleJvmLowerBound
{ after(grammarAccess.getJvmLowerBoundRule()); } 
	 EOF 
;

// Rule JvmLowerBound
ruleJvmLowerBound 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmLowerBoundAccess().getGroup()); }
		(rule__JvmLowerBound__Group__0)
		{ after(grammarAccess.getJvmLowerBoundAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmLowerBoundAnded
entryRuleJvmLowerBoundAnded
:
{ before(grammarAccess.getJvmLowerBoundAndedRule()); }
	 ruleJvmLowerBoundAnded
{ after(grammarAccess.getJvmLowerBoundAndedRule()); } 
	 EOF 
;

// Rule JvmLowerBoundAnded
ruleJvmLowerBoundAnded 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmLowerBoundAndedAccess().getGroup()); }
		(rule__JvmLowerBoundAnded__Group__0)
		{ after(grammarAccess.getJvmLowerBoundAndedAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmTypeParameter
entryRuleJvmTypeParameter
:
{ before(grammarAccess.getJvmTypeParameterRule()); }
	 ruleJvmTypeParameter
{ after(grammarAccess.getJvmTypeParameterRule()); } 
	 EOF 
;

// Rule JvmTypeParameter
ruleJvmTypeParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmTypeParameterAccess().getGroup()); }
		(rule__JvmTypeParameter__Group__0)
		{ after(grammarAccess.getJvmTypeParameterAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedNameWithWildcard
entryRuleQualifiedNameWithWildcard
:
{ before(grammarAccess.getQualifiedNameWithWildcardRule()); }
	 ruleQualifiedNameWithWildcard
{ after(grammarAccess.getQualifiedNameWithWildcardRule()); } 
	 EOF 
;

// Rule QualifiedNameWithWildcard
ruleQualifiedNameWithWildcard 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); }
		(rule__QualifiedNameWithWildcard__Group__0)
		{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXImportSection
entryRuleXImportSection
:
{ before(grammarAccess.getXImportSectionRule()); }
	 ruleXImportSection
{ after(grammarAccess.getXImportSectionRule()); } 
	 EOF 
;

// Rule XImportSection
ruleXImportSection 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getXImportSectionAccess().getImportDeclarationsAssignment()); }
			(rule__XImportSection__ImportDeclarationsAssignment)
			{ after(grammarAccess.getXImportSectionAccess().getImportDeclarationsAssignment()); }
		)
		(
			{ before(grammarAccess.getXImportSectionAccess().getImportDeclarationsAssignment()); }
			(rule__XImportSection__ImportDeclarationsAssignment)*
			{ after(grammarAccess.getXImportSectionAccess().getImportDeclarationsAssignment()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXImportDeclaration
entryRuleXImportDeclaration
:
{ before(grammarAccess.getXImportDeclarationRule()); }
	 ruleXImportDeclaration
{ after(grammarAccess.getXImportDeclarationRule()); } 
	 EOF 
;

// Rule XImportDeclaration
ruleXImportDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getGroup()); }
		(rule__XImportDeclaration__Group__0)
		{ after(grammarAccess.getXImportDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedNameInStaticImport
entryRuleQualifiedNameInStaticImport
:
{ before(grammarAccess.getQualifiedNameInStaticImportRule()); }
	 ruleQualifiedNameInStaticImport
{ after(grammarAccess.getQualifiedNameInStaticImportRule()); } 
	 EOF 
;

// Rule QualifiedNameInStaticImport
ruleQualifiedNameInStaticImport 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
			(rule__QualifiedNameInStaticImport__Group__0)
			{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
		)
		(
			{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
			(rule__QualifiedNameInStaticImport__Group__0)*
			{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getGroup_2_0()); }
		(rule__Type__Group_2_0__0)
		{ after(grammarAccess.getTypeAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getTypeAccess().getGroup_2_1()); }
		(rule__Type__Group_2_1__0)
		{ after(grammarAccess.getTypeAccess().getGroup_2_1()); }
	)
	|
	(
		{ before(grammarAccess.getTypeAccess().getGroup_2_2()); }
		(rule__Type__Group_2_2__0)
		{ after(grammarAccess.getTypeAccess().getGroup_2_2()); }
	)
	|
	(
		{ before(grammarAccess.getTypeAccess().getGroup_2_3()); }
		(rule__Type__Group_2_3__0)
		{ after(grammarAccess.getTypeAccess().getGroup_2_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmSuperTypeReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmSuperTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getJvmSuperTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getJvmSuperTypeReferenceAccess().getXFunctionSuperTypeRefParserRuleCall_1()); }
		ruleXFunctionSuperTypeRef
		{ after(grammarAccess.getJvmSuperTypeReferenceAccess().getXFunctionSuperTypeRefParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_0()); }
		(rule__AnnotationField__Group_2_0__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_1()); }
		(rule__AnnotationField__Group_2_1__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_1()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_2()); }
		(rule__AnnotationField__Group_2_2__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_2()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_3()); }
		(rule__AnnotationField__Group_2_3__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_3()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_4()); }
		(rule__AnnotationField__Group_2_4__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Alternatives_2_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_0_0_0()); }
		(rule__AnnotationField__Group_2_0_0_0__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_0_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_0_0_1()); }
		(rule__AnnotationField__Group_2_0_0_1__0)
		{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_0_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_0()); }
		(rule__Member__Group_2_0__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_1()); }
		(rule__Member__Group_2_1__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_1()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_2()); }
		(rule__Member__Group_2_2__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_2()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_3()); }
		(rule__Member__Group_2_3__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_3()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_4()); }
		(rule__Member__Group_2_4__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_4()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_5()); }
		(rule__Member__Group_2_5__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_5()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_6()); }
		(rule__Member__Group_2_6__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Alternatives_2_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_0_2_0()); }
		(rule__Member__Group_2_0_2_0__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_0_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_0_2_1()); }
		(rule__Member__Group_2_0_2_1__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_0_2_1()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_0_2_2()); }
		(rule__Member__Group_2_0_2_2__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_0_2_2()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_0_2_3()); }
		(rule__Member__Group_2_0_2_3__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_0_2_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Alternatives_2_0_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_1_1_0()); }
		(rule__Member__ModifiersAssignment_2_0_2_1_1_0)
		{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_1_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_1_1_1()); }
		(rule__Member__ModifiersAssignment_2_0_2_1_1_1)
		{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_1_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Alternatives_2_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_3_0()); }
		(rule__Member__ModifiersAssignment_2_1_3_0)
		{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_3_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_3_1()); }
		(rule__Member__ModifiersAssignment_2_1_3_1)
		{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_3_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Alternatives_2_1_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_0()); }
		(rule__Member__Group_2_1_5_0__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_1()); }
		(rule__Member__Group_2_1_5_1__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_1()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_2()); }
		(rule__Member__Group_2_1_5_2__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_2()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_3()); }
		(rule__Member__Group_2_1_5_3__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_3()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_4()); }
		(rule__Member__Group_2_1_5_4__0)
		{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Alternatives_2_1_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExpressionAssignment_2_1_9_0()); }
		(rule__Member__ExpressionAssignment_2_1_9_0)
		{ after(grammarAccess.getMemberAccess().getExpressionAssignment_2_1_9_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getExpressionAssignment_2_1_9_1()); }
		(rule__Member__ExpressionAssignment_2_1_9_1)
		{ after(grammarAccess.getMemberAccess().getExpressionAssignment_2_1_9_1()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getSemicolonKeyword_2_1_9_2()); }
		';'
		{ after(grammarAccess.getMemberAccess().getSemicolonKeyword_2_1_9_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_0()); }
		(rule__TypeReferenceWithTypeArgs__Group_0__0)
		{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1()); }
		(rule__TypeReferenceWithTypeArgs__Group_1__0)
		{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getXFunctionTypeRefParserRuleCall_2()); }
		ruleXFunctionTypeRef
		{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getXFunctionTypeRefParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionID__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionIDAccess().getValidIDParserRuleCall_0()); }
		ruleValidID
		{ after(grammarAccess.getFunctionIDAccess().getValidIDParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getFunctionIDAccess().getOperatorsParserRuleCall_1()); }
		ruleOperators
		{ after(grammarAccess.getFunctionIDAccess().getOperatorsParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operators__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperatorsAccess().getOpMultiAssignParserRuleCall_0()); }
		ruleOpMultiAssign
		{ after(grammarAccess.getOperatorsAccess().getOpMultiAssignParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpOrParserRuleCall_1()); }
		ruleOpOr
		{ after(grammarAccess.getOperatorsAccess().getOpOrParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpAndParserRuleCall_2()); }
		ruleOpAnd
		{ after(grammarAccess.getOperatorsAccess().getOpAndParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpEqualityParserRuleCall_3()); }
		ruleOpEquality
		{ after(grammarAccess.getOperatorsAccess().getOpEqualityParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpCompareParserRuleCall_4()); }
		ruleOpCompare
		{ after(grammarAccess.getOperatorsAccess().getOpCompareParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpOtherParserRuleCall_5()); }
		ruleOpOther
		{ after(grammarAccess.getOperatorsAccess().getOpOtherParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpMultiParserRuleCall_6()); }
		ruleOpMulti
		{ after(grammarAccess.getOperatorsAccess().getOpMultiParserRuleCall_6()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpUnaryParserRuleCall_7()); }
		ruleOpUnary
		{ after(grammarAccess.getOperatorsAccess().getOpUnaryParserRuleCall_7()); }
	)
	|
	(
		{ before(grammarAccess.getOperatorsAccess().getOpPostfixParserRuleCall_8()); }
		ruleOpPostfix
		{ after(grammarAccess.getOperatorsAccess().getOpPostfixParserRuleCall_8()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CommonModifier__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCommonModifierAccess().getPublicKeyword_0()); }
		'public'
		{ after(grammarAccess.getCommonModifierAccess().getPublicKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getPrivateKeyword_1()); }
		'private'
		{ after(grammarAccess.getCommonModifierAccess().getPrivateKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getProtectedKeyword_2()); }
		'protected'
		{ after(grammarAccess.getCommonModifierAccess().getProtectedKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getPackageKeyword_3()); }
		'package'
		{ after(grammarAccess.getCommonModifierAccess().getPackageKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getAbstractKeyword_4()); }
		'abstract'
		{ after(grammarAccess.getCommonModifierAccess().getAbstractKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getStaticKeyword_5()); }
		'static'
		{ after(grammarAccess.getCommonModifierAccess().getStaticKeyword_5()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getDispatchKeyword_6()); }
		'dispatch'
		{ after(grammarAccess.getCommonModifierAccess().getDispatchKeyword_6()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getFinalKeyword_7()); }
		'final'
		{ after(grammarAccess.getCommonModifierAccess().getFinalKeyword_7()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getStrictfpKeyword_8()); }
		'strictfp'
		{ after(grammarAccess.getCommonModifierAccess().getStrictfpKeyword_8()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getNativeKeyword_9()); }
		'native'
		{ after(grammarAccess.getCommonModifierAccess().getNativeKeyword_9()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getVolatileKeyword_10()); }
		'volatile'
		{ after(grammarAccess.getCommonModifierAccess().getVolatileKeyword_10()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getSynchronizedKeyword_11()); }
		'synchronized'
		{ after(grammarAccess.getCommonModifierAccess().getSynchronizedKeyword_11()); }
	)
	|
	(
		{ before(grammarAccess.getCommonModifierAccess().getTransientKeyword_12()); }
		'transient'
		{ after(grammarAccess.getCommonModifierAccess().getTransientKeyword_12()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FieldModifier__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFieldModifierAccess().getValKeyword_0()); }
		'val'
		{ after(grammarAccess.getFieldModifierAccess().getValKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getFieldModifierAccess().getVarKeyword_1()); }
		'var'
		{ after(grammarAccess.getFieldModifierAccess().getVarKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MethodModifier__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMethodModifierAccess().getDefKeyword_0()); }
		'def'
		{ after(grammarAccess.getMethodModifierAccess().getDefKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getMethodModifierAccess().getOverrideKeyword_1()); }
		'override'
		{ after(grammarAccess.getMethodModifierAccess().getOverrideKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ValidID__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getValidIDAccess().getCreateKeyword_1()); }
		'create'
		{ after(grammarAccess.getValidIDAccess().getCreateKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getValidIDAccess().getAnnotationKeyword_2()); }
		'annotation'
		{ after(grammarAccess.getValidIDAccess().getAnnotationKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getValidIDAccess().getAFTERKeyword_3()); }
		'AFTER'
		{ after(grammarAccess.getValidIDAccess().getAFTERKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getValidIDAccess().getBEFOREKeyword_4()); }
		'BEFORE'
		{ after(grammarAccess.getValidIDAccess().getBEFOREKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getValidIDAccess().getSEPARATORKeyword_5()); }
		'SEPARATOR'
		{ after(grammarAccess.getValidIDAccess().getSEPARATORKeyword_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FeatureCallID__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFeatureCallIDAccess().getInnerVarIDParserRuleCall_0()); }
		ruleInnerVarID
		{ after(grammarAccess.getFeatureCallIDAccess().getInnerVarIDParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_1()); }
		'extension'
		{ after(grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InnerVarID__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInnerVarIDAccess().getIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getInnerVarIDAccess().getIDTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getAbstractKeyword_1()); }
		'abstract'
		{ after(grammarAccess.getInnerVarIDAccess().getAbstractKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getAnnotationKeyword_2()); }
		'annotation'
		{ after(grammarAccess.getInnerVarIDAccess().getAnnotationKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getClassKeyword_3()); }
		'class'
		{ after(grammarAccess.getInnerVarIDAccess().getClassKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getCreateKeyword_4()); }
		'create'
		{ after(grammarAccess.getInnerVarIDAccess().getCreateKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getDefKeyword_5()); }
		'def'
		{ after(grammarAccess.getInnerVarIDAccess().getDefKeyword_5()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getDispatchKeyword_6()); }
		'dispatch'
		{ after(grammarAccess.getInnerVarIDAccess().getDispatchKeyword_6()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getEnumKeyword_7()); }
		'enum'
		{ after(grammarAccess.getInnerVarIDAccess().getEnumKeyword_7()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getExtendsKeyword_8()); }
		'extends'
		{ after(grammarAccess.getInnerVarIDAccess().getExtendsKeyword_8()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getFinalKeyword_9()); }
		'final'
		{ after(grammarAccess.getInnerVarIDAccess().getFinalKeyword_9()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getImplementsKeyword_10()); }
		'implements'
		{ after(grammarAccess.getInnerVarIDAccess().getImplementsKeyword_10()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getImportKeyword_11()); }
		'import'
		{ after(grammarAccess.getInnerVarIDAccess().getImportKeyword_11()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getInterfaceKeyword_12()); }
		'interface'
		{ after(grammarAccess.getInnerVarIDAccess().getInterfaceKeyword_12()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getOverrideKeyword_13()); }
		'override'
		{ after(grammarAccess.getInnerVarIDAccess().getOverrideKeyword_13()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getPackageKeyword_14()); }
		'package'
		{ after(grammarAccess.getInnerVarIDAccess().getPackageKeyword_14()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getPublicKeyword_15()); }
		'public'
		{ after(grammarAccess.getInnerVarIDAccess().getPublicKeyword_15()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getPrivateKeyword_16()); }
		'private'
		{ after(grammarAccess.getInnerVarIDAccess().getPrivateKeyword_16()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getProtectedKeyword_17()); }
		'protected'
		{ after(grammarAccess.getInnerVarIDAccess().getProtectedKeyword_17()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getStaticKeyword_18()); }
		'static'
		{ after(grammarAccess.getInnerVarIDAccess().getStaticKeyword_18()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getThrowsKeyword_19()); }
		'throws'
		{ after(grammarAccess.getInnerVarIDAccess().getThrowsKeyword_19()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getStrictfpKeyword_20()); }
		'strictfp'
		{ after(grammarAccess.getInnerVarIDAccess().getStrictfpKeyword_20()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getNativeKeyword_21()); }
		'native'
		{ after(grammarAccess.getInnerVarIDAccess().getNativeKeyword_21()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getVolatileKeyword_22()); }
		'volatile'
		{ after(grammarAccess.getInnerVarIDAccess().getVolatileKeyword_22()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getSynchronizedKeyword_23()); }
		'synchronized'
		{ after(grammarAccess.getInnerVarIDAccess().getSynchronizedKeyword_23()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getTransientKeyword_24()); }
		'transient'
		{ after(grammarAccess.getInnerVarIDAccess().getTransientKeyword_24()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getAFTERKeyword_25()); }
		'AFTER'
		{ after(grammarAccess.getInnerVarIDAccess().getAFTERKeyword_25()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getBEFOREKeyword_26()); }
		'BEFORE'
		{ after(grammarAccess.getInnerVarIDAccess().getBEFOREKeyword_26()); }
	)
	|
	(
		{ before(grammarAccess.getInnerVarIDAccess().getSEPARATORKeyword_27()); }
		'SEPARATOR'
		{ after(grammarAccess.getInnerVarIDAccess().getSEPARATORKeyword_27()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAssignmentAccess().getGroup_0()); }
		(rule__XAssignment__Group_0__0)
		{ after(grammarAccess.getXAssignmentAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getXAssignmentAccess().getGroup_1()); }
		(rule__XAssignment__Group_1__0)
		{ after(grammarAccess.getXAssignmentAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0()); }
		(rule__XTryCatchFinallyExpression__Group_2_0__0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1()); }
		(rule__XTryCatchFinallyExpression__Group_2_1__0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Alternatives_2_0_6_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6_0_0()); }
		(rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6_0_1()); }
		(rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Alternatives_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1_1_0()); }
		(rule__XTryCatchFinallyExpression__Group_2_1_1_0__0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1_1_1()); }
		(rule__XTryCatchFinallyExpression__Group_2_1_1_1__0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXVariableDeclarationAccess().getGroup_1_0()); }
		(rule__XVariableDeclaration__Group_1_0__0)
		{ after(grammarAccess.getXVariableDeclarationAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXVariableDeclarationAccess().getNameAssignment_1_1()); }
		(rule__XVariableDeclaration__NameAssignment_1_1)
		{ after(grammarAccess.getXVariableDeclarationAccess().getNameAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInitializedVariableDeclarationAccess().getGroup_2_0()); }
		(rule__InitializedVariableDeclaration__Group_2_0__0)
		{ after(grammarAccess.getInitializedVariableDeclarationAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getInitializedVariableDeclarationAccess().getNameAssignment_2_1()); }
		(rule__InitializedVariableDeclaration__NameAssignment_2_1)
		{ after(grammarAccess.getInitializedVariableDeclarationAccess().getNameAssignment_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableModifierAccess().getGroup_0()); }
		(rule__VariableModifier__Group_0__0)
		{ after(grammarAccess.getVariableModifierAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getVariableModifierAccess().getGroup_1()); }
		(rule__VariableModifier__Group_1__0)
		{ after(grammarAccess.getVariableModifierAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Alternatives_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableModifierAccess().getWriteableAssignment_0_0_0()); }
		(rule__VariableModifier__WriteableAssignment_0_0_0)
		{ after(grammarAccess.getVariableModifierAccess().getWriteableAssignment_0_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getVariableModifierAccess().getValKeyword_0_0_1()); }
		'val'
		{ after(grammarAccess.getVariableModifierAccess().getValKeyword_0_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Alternatives_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableModifierAccess().getWriteableAssignment_1_1_0()); }
		(rule__VariableModifier__WriteableAssignment_1_1_0)
		{ after(grammarAccess.getVariableModifierAccess().getWriteableAssignment_1_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getVariableModifierAccess().getValKeyword_1_1_1()); }
		'val'
		{ after(grammarAccess.getVariableModifierAccess().getValKeyword_1_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Alternatives_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_4_1_0()); }
		(rule__XbaseConstructorCall__ArgumentsAssignment_4_1_0)
		{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_4_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getGroup_4_1_1()); }
		(rule__XbaseConstructorCall__Group_4_1_1__0)
		{ after(grammarAccess.getXbaseConstructorCallAccess().getGroup_4_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XStringLiteral__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXStringLiteralAccess().getSimpleStringLiteralParserRuleCall_0()); }
		ruleSimpleStringLiteral
		{ after(grammarAccess.getXStringLiteralAccess().getSimpleStringLiteralParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXStringLiteralAccess().getRichStringParserRuleCall_1()); }
		ruleRichString
		{ after(grammarAccess.getXStringLiteralAccess().getRichStringParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0()); }
		(rule__XSwitchExpression__Group_2_0__0)
		{ after(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1()); }
		(rule__XSwitchExpression__Group_2_1__0)
		{ after(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Alternatives_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCasePartAccess().getGroup_3_0()); }
		(rule__XCasePart__Group_3_0__0)
		{ after(grammarAccess.getXCasePartAccess().getGroup_3_0()); }
	)
	|
	(
		{ before(grammarAccess.getXCasePartAccess().getFallThroughAssignment_3_1()); }
		(rule__XCasePart__FallThroughAssignment_3_1)
		{ after(grammarAccess.getXCasePartAccess().getFallThroughAssignment_3_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionOrSimpleConstructorCall__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getXbaseConstructorCallParserRuleCall_0()); }
		(ruleXbaseConstructorCall)
		{ after(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getXbaseConstructorCallParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getXExpressionParserRuleCall_1()); }
		ruleXExpression
		{ after(grammarAccess.getXExpressionOrSimpleConstructorCallAccess().getXExpressionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_0()); }
		(rule__RichString__ExpressionsAssignment_1_0)
		{ after(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getRichStringAccess().getGroup_1_1()); }
		(rule__RichString__Group_1_1__0)
		{ after(grammarAccess.getRichStringAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralInbetween__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralInbetweenAccess().getValueAssignment_1_0()); }
		(rule__RichStringLiteralInbetween__ValueAssignment_1_0)
		{ after(grammarAccess.getRichStringLiteralInbetweenAccess().getValueAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getRichStringLiteralInbetweenAccess().getValueAssignment_1_1()); }
		(rule__RichStringLiteralInbetween__ValueAssignment_1_1)
		{ after(grammarAccess.getRichStringLiteralInbetweenAccess().getValueAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralEnd__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralEndAccess().getValueAssignment_1_0()); }
		(rule__RichStringLiteralEnd__ValueAssignment_1_0)
		{ after(grammarAccess.getRichStringLiteralEndAccess().getValueAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getRichStringLiteralEndAccess().getValueAssignment_1_1()); }
		(rule__RichStringLiteralEnd__ValueAssignment_1_1)
		{ after(grammarAccess.getRichStringLiteralEndAccess().getValueAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringPart__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringPartAccess().getXExpressionOrVarDeclarationParserRuleCall_0()); }
		ruleXExpressionOrVarDeclaration
		{ after(grammarAccess.getRichStringPartAccess().getXExpressionOrVarDeclarationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRichStringPartAccess().getRichStringForLoopParserRuleCall_1()); }
		ruleRichStringForLoop
		{ after(grammarAccess.getRichStringPartAccess().getRichStringForLoopParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getRichStringPartAccess().getRichStringIfParserRuleCall_2()); }
		ruleRichStringIf
		{ after(grammarAccess.getRichStringPartAccess().getRichStringIfParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Alternatives_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationAccess().getGroup_3_1_0()); }
		(rule__XAnnotation__Group_3_1_0__0)
		{ after(grammarAccess.getXAnnotationAccess().getGroup_3_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXAnnotationAccess().getValueAssignment_3_1_1()); }
		(rule__XAnnotation__ValueAssignment_3_1_1)
		{ after(grammarAccess.getXAnnotationAccess().getValueAssignment_3_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0()); }
		(rule__XAnnotationElementValueOrCommaList__Group_0__0)
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1()); }
		(rule__XAnnotationElementValueOrCommaList__Group_1__0)
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValueAccess().getGroup_0()); }
		(rule__XAnnotationElementValue__Group_0__0)
		{ after(grammarAccess.getXAnnotationElementValueAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationOrExpressionParserRuleCall_1()); }
		ruleXAnnotationOrExpression
		{ after(grammarAccess.getXAnnotationElementValueAccess().getXAnnotationOrExpressionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationOrExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationOrExpressionAccess().getXAnnotationParserRuleCall_0()); }
		ruleXAnnotation
		{ after(grammarAccess.getXAnnotationOrExpressionAccess().getXAnnotationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXAnnotationOrExpressionAccess().getXExpressionParserRuleCall_1()); }
		ruleXExpression
		{ after(grammarAccess.getXAnnotationOrExpressionAccess().getXExpressionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); }
		'+='
		{ after(grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); }
		'-='
		{ after(grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); }
		'*='
		{ after(grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); }
		'/='
		{ after(grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); }
		'%='
		{ after(grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getGroup_5()); }
		(rule__OpMultiAssign__Group_5__0)
		{ after(grammarAccess.getOpMultiAssignAccess().getGroup_5()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAssignAccess().getGroup_6()); }
		(rule__OpMultiAssign__Group_6__0)
		{ after(grammarAccess.getOpMultiAssignAccess().getGroup_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpEquality__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); }
		'=='
		{ after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); }
		'!='
		{ after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2()); }
		'==='
		{ after(grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3()); }
		'!=='
		{ after(grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0()); }
		(rule__XRelationalExpression__Group_1_0__0)
		{ after(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1()); }
		(rule__XRelationalExpression__Group_1_1__0)
		{ after(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpCompare__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); }
		'>='
		{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpCompareAccess().getGroup_1()); }
		(rule__OpCompare__Group_1__0)
		{ after(grammarAccess.getOpCompareAccess().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); }
		'>'
		{ after(grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); }
		'<'
		{ after(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); }
		'->'
		{ after(grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); }
		'..<'
		{ after(grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getGroup_2()); }
		(rule__OpOther__Group_2__0)
		{ after(grammarAccess.getOpOtherAccess().getGroup_2()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); }
		'..'
		{ after(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); }
		'=>'
		{ after(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getGroup_5()); }
		(rule__OpOther__Group_5__0)
		{ after(grammarAccess.getOpOtherAccess().getGroup_5()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getGroup_6()); }
		(rule__OpOther__Group_6__0)
		{ after(grammarAccess.getOpOtherAccess().getGroup_6()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); }
		'<>'
		{ after(grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8()); }
		'?:'
		{ after(grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Alternatives_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpOtherAccess().getGroup_5_1_0()); }
		(rule__OpOther__Group_5_1_0__0)
		{ after(grammarAccess.getOpOtherAccess().getGroup_5_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); }
		'>'
		{ after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Alternatives_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpOtherAccess().getGroup_6_1_0()); }
		(rule__OpOther__Group_6_1_0__0)
		{ after(grammarAccess.getOpOtherAccess().getGroup_6_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); }
		'<'
		{ after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1()); }
	)
	|
	(
		{ before(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); }
		'=>'
		{ after(grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpAdd__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); }
		'+'
		{ after(grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); }
		'-'
		{ after(grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMulti__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); }
		'*'
		{ after(grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); }
		'**'
		{ after(grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); }
		'/'
		{ after(grammarAccess.getOpMultiAccess().getSolidusKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); }
		'%'
		{ after(grammarAccess.getOpMultiAccess().getPercentSignKeyword_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXUnaryOperationAccess().getGroup_0()); }
		(rule__XUnaryOperation__Group_0__0)
		{ after(grammarAccess.getXUnaryOperationAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); }
		ruleXCastedExpression
		{ after(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpUnary__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); }
		'!'
		{ after(grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); }
		'-'
		{ after(grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); }
		'+'
		{ after(grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpPostfix__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0()); }
		'++'
		{ after(grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1()); }
		'--'
		{ after(grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0()); }
		(rule__XMemberFeatureCall__Group_1_0__0)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1()); }
		(rule__XMemberFeatureCall__Group_1_1__0)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Alternatives_1_0_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0()); }
		'.'
		{ after(grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_0_0_0_1_1()); }
		(rule__XMemberFeatureCall__ExplicitStaticAssignment_1_0_0_0_1_1)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_0_0_0_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Alternatives_1_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0()); }
		'.'
		{ after(grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getNullSafeAssignment_1_1_0_0_1_1()); }
		(rule__XMemberFeatureCall__NullSafeAssignment_1_1_0_0_1_1)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getNullSafeAssignment_1_1_0_0_1_1()); }
	)
	|
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_1_0_0_1_2()); }
		(rule__XMemberFeatureCall__ExplicitStaticAssignment_1_1_0_0_1_2)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_1_0_0_1_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Alternatives_1_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_0()); }
		(rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_0)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1()); }
		(rule__XMemberFeatureCall__Group_1_1_3_1_1__0)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XPrimaryExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); }
		ruleXConstructorCall
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); }
		ruleXBlockExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); }
		ruleXSwitchExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3()); }
		(ruleXSynchronizedExpression)
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4()); }
		ruleXFeatureCall
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5()); }
		ruleXLiteral
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6()); }
		ruleXIfExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7()); }
		(ruleXForLoopExpression)
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8()); }
		ruleXBasicForLoopExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9()); }
		ruleXWhileExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10()); }
		ruleXDoWhileExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11()); }
		ruleXThrowExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12()); }
		ruleXReturnExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13()); }
		ruleXTryCatchFinallyExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13()); }
	)
	|
	(
		{ before(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14()); }
		ruleXParenthesizedExpression
		{ after(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XLiteral__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0()); }
		ruleXCollectionLiteral
		{ after(grammarAccess.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1()); }
		(ruleXClosure)
		{ after(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2()); }
		ruleXBooleanLiteral
		{ after(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_3()); }
		ruleXNumberLiteral
		{ after(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4()); }
		ruleXNullLiteral
		{ after(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5()); }
		ruleXStringLiteral
		{ after(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5()); }
	)
	|
	(
		{ before(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6()); }
		ruleXTypeLiteral
		{ after(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCollectionLiteral__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0()); }
		ruleXSetLiteral
		{ after(grammarAccess.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1()); }
		ruleXListLiteral
		{ after(grammarAccess.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionOrVarDeclaration__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0()); }
		(ruleXVariableDeclaration)
		{ after(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1()); }
		ruleXExpression
		{ after(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Alternatives_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_0()); }
		(rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_0)
		{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXFeatureCallAccess().getGroup_3_1_1()); }
		(rule__XFeatureCall__Group_3_1_1__0)
		{ after(grammarAccess.getXFeatureCallAccess().getGroup_3_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IdOrSuper__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0()); }
		ruleFeatureCallID
		{ after(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); }
		'super'
		{ after(grammarAccess.getIdOrSuperAccess().getSuperKeyword_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBooleanLiteral__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0()); }
		'false'
		{ after(grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXBooleanLiteralAccess().getIsTrueAssignment_1_1()); }
		(rule__XBooleanLiteral__IsTrueAssignment_1_1)
		{ after(grammarAccess.getXBooleanLiteralAccess().getIsTrueAssignment_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); }
		RULE_HEX
		{ after(grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getNumberAccess().getGroup_1()); }
		(rule__Number__Group_1__0)
		{ after(grammarAccess.getNumberAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Alternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0()); }
		RULE_INT
		{ after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1()); }
		RULE_DECIMAL
		{ after(grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Alternatives_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0()); }
		RULE_INT
		{ after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1()); }
		RULE_DECIMAL
		{ after(grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); }
		(rule__JvmTypeReference__Group_0__0)
		{ after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); }
		ruleXFunctionTypeRef
		{ after(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmArgumentTypeReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); }
		ruleJvmWildcardTypeReference
		{ after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0()); }
		(rule__JvmWildcardTypeReference__Group_2_0__0)
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1()); }
		(rule__JvmWildcardTypeReference__Group_2_1__0)
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getGroup_1_0()); }
		(rule__XImportDeclaration__Group_1_0__0)
		{ after(grammarAccess.getXImportDeclarationAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1()); }
		(rule__XImportDeclaration__ImportedTypeAssignment_1_1)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1()); }
	)
	|
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2()); }
		(rule__XImportDeclaration__ImportedNamespaceAssignment_1_2)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Alternatives_1_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0()); }
		(rule__XImportDeclaration__WildcardAssignment_1_0_3_0)
		{ after(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0()); }
	)
	|
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1()); }
		(rule__XImportDeclaration__MemberNameAssignment_1_0_3_1)
		{ after(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__File__Group__0__Impl
	rule__File__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFileAccess().getGroup_0()); }
	(rule__File__Group_0__0)?
	{ after(grammarAccess.getFileAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__File__Group__1__Impl
	rule__File__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFileAccess().getImportSectionAssignment_1()); }
	(rule__File__ImportSectionAssignment_1)?
	{ after(grammarAccess.getFileAccess().getImportSectionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__File__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFileAccess().getXtendTypesAssignment_2()); }
	(rule__File__XtendTypesAssignment_2)*
	{ after(grammarAccess.getFileAccess().getXtendTypesAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__File__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__File__Group_0__0__Impl
	rule__File__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFileAccess().getPackageKeyword_0_0()); }
	'package'
	{ after(grammarAccess.getFileAccess().getPackageKeyword_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__File__Group_0__1__Impl
	rule__File__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFileAccess().getPackageAssignment_0_1()); }
	(rule__File__PackageAssignment_0_1)
	{ after(grammarAccess.getFileAccess().getPackageAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__File__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__File__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFileAccess().getSemicolonKeyword_0_2()); }
	(';')?
	{ after(grammarAccess.getFileAccess().getSemicolonKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group__0__Impl
	rule__Type__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getXtendTypeDeclarationAction_0()); }
	()
	{ after(grammarAccess.getTypeAccess().getXtendTypeDeclarationAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group__1__Impl
	rule__Type__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getAnnotationsAssignment_1()); }
	(rule__Type__AnnotationsAssignment_1)*
	{ after(grammarAccess.getTypeAccess().getAnnotationsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getAlternatives_2()); }
	(rule__Type__Alternatives_2)
	{ after(grammarAccess.getTypeAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__0__Impl
	rule__Type__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getXtendClassAnnotationInfoAction_2_0_0()); }
	()
	{ after(grammarAccess.getTypeAccess().getXtendClassAnnotationInfoAction_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__1__Impl
	rule__Type__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getModifiersAssignment_2_0_1()); }
	(rule__Type__ModifiersAssignment_2_0_1)*
	{ after(grammarAccess.getTypeAccess().getModifiersAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__2__Impl
	rule__Type__Group_2_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getClassKeyword_2_0_2()); }
	'class'
	{ after(grammarAccess.getTypeAccess().getClassKeyword_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__3__Impl
	rule__Type__Group_2_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getNameAssignment_2_0_3()); }
	(rule__Type__NameAssignment_2_0_3)
	{ after(grammarAccess.getTypeAccess().getNameAssignment_2_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__4__Impl
	rule__Type__Group_2_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_0_4()); }
	(rule__Type__Group_2_0_4__0)?
	{ after(grammarAccess.getTypeAccess().getGroup_2_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__5__Impl
	rule__Type__Group_2_0__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_0_5()); }
	(rule__Type__Group_2_0_5__0)?
	{ after(grammarAccess.getTypeAccess().getGroup_2_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__6__Impl
	rule__Type__Group_2_0__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_0_6()); }
	(rule__Type__Group_2_0_6__0)?
	{ after(grammarAccess.getTypeAccess().getGroup_2_0_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__7__Impl
	rule__Type__Group_2_0__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_0_7()); }
	'{'
	{ after(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_0_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__8__Impl
	rule__Type__Group_2_0__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getMembersAssignment_2_0_8()); }
	(rule__Type__MembersAssignment_2_0_8)*
	{ after(grammarAccess.getTypeAccess().getMembersAssignment_2_0_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_0_9()); }
	'}'
	{ after(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_0_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_0_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_4__0__Impl
	rule__Type__Group_2_0_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getLessThanSignKeyword_2_0_4_0()); }
	'<'
	{ after(grammarAccess.getTypeAccess().getLessThanSignKeyword_2_0_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_4__1__Impl
	rule__Type__Group_2_0_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_0_4_1()); }
	(rule__Type__TypeParametersAssignment_2_0_4_1)
	{ after(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_0_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_4__2__Impl
	rule__Type__Group_2_0_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_0_4_2()); }
	(rule__Type__Group_2_0_4_2__0)*
	{ after(grammarAccess.getTypeAccess().getGroup_2_0_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGreaterThanSignKeyword_2_0_4_3()); }
	'>'
	{ after(grammarAccess.getTypeAccess().getGreaterThanSignKeyword_2_0_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_0_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_4_2__0__Impl
	rule__Type__Group_2_0_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getCommaKeyword_2_0_4_2_0()); }
	','
	{ after(grammarAccess.getTypeAccess().getCommaKeyword_2_0_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_0_4_2_1()); }
	(rule__Type__TypeParametersAssignment_2_0_4_2_1)
	{ after(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_0_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_0_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_5__0__Impl
	rule__Type__Group_2_0_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getExtendsKeyword_2_0_5_0()); }
	'extends'
	{ after(grammarAccess.getTypeAccess().getExtendsKeyword_2_0_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getExtendsAssignment_2_0_5_1()); }
	(rule__Type__ExtendsAssignment_2_0_5_1)
	{ after(grammarAccess.getTypeAccess().getExtendsAssignment_2_0_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_0_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_6__0__Impl
	rule__Type__Group_2_0_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getImplementsKeyword_2_0_6_0()); }
	'implements'
	{ after(grammarAccess.getTypeAccess().getImplementsKeyword_2_0_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_6__1__Impl
	rule__Type__Group_2_0_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getImplementsAssignment_2_0_6_1()); }
	(rule__Type__ImplementsAssignment_2_0_6_1)
	{ after(grammarAccess.getTypeAccess().getImplementsAssignment_2_0_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_0_6_2()); }
	(rule__Type__Group_2_0_6_2__0)*
	{ after(grammarAccess.getTypeAccess().getGroup_2_0_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_0_6_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_6_2__0__Impl
	rule__Type__Group_2_0_6_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getCommaKeyword_2_0_6_2_0()); }
	','
	{ after(grammarAccess.getTypeAccess().getCommaKeyword_2_0_6_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_0_6_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_0_6_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getImplementsAssignment_2_0_6_2_1()); }
	(rule__Type__ImplementsAssignment_2_0_6_2_1)
	{ after(grammarAccess.getTypeAccess().getImplementsAssignment_2_0_6_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__0__Impl
	rule__Type__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getXtendInterfaceAnnotationInfoAction_2_1_0()); }
	()
	{ after(grammarAccess.getTypeAccess().getXtendInterfaceAnnotationInfoAction_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__1__Impl
	rule__Type__Group_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getModifiersAssignment_2_1_1()); }
	(rule__Type__ModifiersAssignment_2_1_1)*
	{ after(grammarAccess.getTypeAccess().getModifiersAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__2__Impl
	rule__Type__Group_2_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getInterfaceKeyword_2_1_2()); }
	'interface'
	{ after(grammarAccess.getTypeAccess().getInterfaceKeyword_2_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__3__Impl
	rule__Type__Group_2_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getNameAssignment_2_1_3()); }
	(rule__Type__NameAssignment_2_1_3)
	{ after(grammarAccess.getTypeAccess().getNameAssignment_2_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__4__Impl
	rule__Type__Group_2_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_1_4()); }
	(rule__Type__Group_2_1_4__0)?
	{ after(grammarAccess.getTypeAccess().getGroup_2_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__5__Impl
	rule__Type__Group_2_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_1_5()); }
	(rule__Type__Group_2_1_5__0)?
	{ after(grammarAccess.getTypeAccess().getGroup_2_1_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__6__Impl
	rule__Type__Group_2_1__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_1_6()); }
	'{'
	{ after(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_1_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__7__Impl
	rule__Type__Group_2_1__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getMembersAssignment_2_1_7()); }
	(rule__Type__MembersAssignment_2_1_7)*
	{ after(grammarAccess.getTypeAccess().getMembersAssignment_2_1_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_1_8()); }
	'}'
	{ after(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_1_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_4__0__Impl
	rule__Type__Group_2_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getLessThanSignKeyword_2_1_4_0()); }
	'<'
	{ after(grammarAccess.getTypeAccess().getLessThanSignKeyword_2_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_4__1__Impl
	rule__Type__Group_2_1_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_1_4_1()); }
	(rule__Type__TypeParametersAssignment_2_1_4_1)
	{ after(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_4__2__Impl
	rule__Type__Group_2_1_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_1_4_2()); }
	(rule__Type__Group_2_1_4_2__0)*
	{ after(grammarAccess.getTypeAccess().getGroup_2_1_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGreaterThanSignKeyword_2_1_4_3()); }
	'>'
	{ after(grammarAccess.getTypeAccess().getGreaterThanSignKeyword_2_1_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_1_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_4_2__0__Impl
	rule__Type__Group_2_1_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getCommaKeyword_2_1_4_2_0()); }
	','
	{ after(grammarAccess.getTypeAccess().getCommaKeyword_2_1_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_1_4_2_1()); }
	(rule__Type__TypeParametersAssignment_2_1_4_2_1)
	{ after(grammarAccess.getTypeAccess().getTypeParametersAssignment_2_1_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_1_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_5__0__Impl
	rule__Type__Group_2_1_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getExtendsKeyword_2_1_5_0()); }
	'extends'
	{ after(grammarAccess.getTypeAccess().getExtendsKeyword_2_1_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_5__1__Impl
	rule__Type__Group_2_1_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getExtendsAssignment_2_1_5_1()); }
	(rule__Type__ExtendsAssignment_2_1_5_1)
	{ after(grammarAccess.getTypeAccess().getExtendsAssignment_2_1_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_1_5_2()); }
	(rule__Type__Group_2_1_5_2__0)*
	{ after(grammarAccess.getTypeAccess().getGroup_2_1_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_1_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_5_2__0__Impl
	rule__Type__Group_2_1_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getCommaKeyword_2_1_5_2_0()); }
	','
	{ after(grammarAccess.getTypeAccess().getCommaKeyword_2_1_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_1_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_1_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getExtendsAssignment_2_1_5_2_1()); }
	(rule__Type__ExtendsAssignment_2_1_5_2_1)
	{ after(grammarAccess.getTypeAccess().getExtendsAssignment_2_1_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__0__Impl
	rule__Type__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getXtendEnumAnnotationInfoAction_2_2_0()); }
	()
	{ after(grammarAccess.getTypeAccess().getXtendEnumAnnotationInfoAction_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__1__Impl
	rule__Type__Group_2_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getModifiersAssignment_2_2_1()); }
	(rule__Type__ModifiersAssignment_2_2_1)*
	{ after(grammarAccess.getTypeAccess().getModifiersAssignment_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__2__Impl
	rule__Type__Group_2_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getEnumKeyword_2_2_2()); }
	'enum'
	{ after(grammarAccess.getTypeAccess().getEnumKeyword_2_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__3__Impl
	rule__Type__Group_2_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getNameAssignment_2_2_3()); }
	(rule__Type__NameAssignment_2_2_3)
	{ after(grammarAccess.getTypeAccess().getNameAssignment_2_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__4__Impl
	rule__Type__Group_2_2__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_2_4()); }
	'{'
	{ after(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_2_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__5__Impl
	rule__Type__Group_2_2__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_2_5()); }
	(rule__Type__Group_2_2_5__0)?
	{ after(grammarAccess.getTypeAccess().getGroup_2_2_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__6__Impl
	rule__Type__Group_2_2__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getSemicolonKeyword_2_2_6()); }
	(';')?
	{ after(grammarAccess.getTypeAccess().getSemicolonKeyword_2_2_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_2_7()); }
	'}'
	{ after(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_2_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_2_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2_5__0__Impl
	rule__Type__Group_2_2_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getMembersAssignment_2_2_5_0()); }
	(rule__Type__MembersAssignment_2_2_5_0)
	{ after(grammarAccess.getTypeAccess().getMembersAssignment_2_2_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_2_2_5_1()); }
	(rule__Type__Group_2_2_5_1__0)*
	{ after(grammarAccess.getTypeAccess().getGroup_2_2_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_2_5_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2_5_1__0__Impl
	rule__Type__Group_2_2_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2_5_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getCommaKeyword_2_2_5_1_0()); }
	','
	{ after(grammarAccess.getTypeAccess().getCommaKeyword_2_2_5_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2_5_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_2_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_2_5_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getMembersAssignment_2_2_5_1_1()); }
	(rule__Type__MembersAssignment_2_2_5_1_1)
	{ after(grammarAccess.getTypeAccess().getMembersAssignment_2_2_5_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_2_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_3__0__Impl
	rule__Type__Group_2_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getXtendAnnotationTypeAnnotationInfoAction_2_3_0()); }
	()
	{ after(grammarAccess.getTypeAccess().getXtendAnnotationTypeAnnotationInfoAction_2_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_3__1__Impl
	rule__Type__Group_2_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getModifiersAssignment_2_3_1()); }
	(rule__Type__ModifiersAssignment_2_3_1)*
	{ after(grammarAccess.getTypeAccess().getModifiersAssignment_2_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_3__2__Impl
	rule__Type__Group_2_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getAnnotationKeyword_2_3_2()); }
	'annotation'
	{ after(grammarAccess.getTypeAccess().getAnnotationKeyword_2_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_3__3__Impl
	rule__Type__Group_2_3__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getNameAssignment_2_3_3()); }
	(rule__Type__NameAssignment_2_3_3)
	{ after(grammarAccess.getTypeAccess().getNameAssignment_2_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_3__4__Impl
	rule__Type__Group_2_3__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_3_4()); }
	'{'
	{ after(grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_2_3_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_3__5__Impl
	rule__Type__Group_2_3__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getMembersAssignment_2_3_5()); }
	(rule__Type__MembersAssignment_2_3_5)*
	{ after(grammarAccess.getTypeAccess().getMembersAssignment_2_3_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_2_3__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_2_3__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_3_6()); }
	'}'
	{ after(grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_2_3_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionSuperTypeRef__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group__0__Impl
	rule__XFunctionSuperTypeRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup_0()); }
	(rule__XFunctionSuperTypeRef__Group_0__0)?
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group__1__Impl
	rule__XFunctionSuperTypeRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); }
	'=>'
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getReturnTypeAssignment_2()); }
	(rule__XFunctionSuperTypeRef__ReturnTypeAssignment_2)
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getReturnTypeAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionSuperTypeRef__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group_0__0__Impl
	rule__XFunctionSuperTypeRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getInstanceContextAssignment_0_0()); }
	(rule__XFunctionSuperTypeRef__InstanceContextAssignment_0_0)
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getInstanceContextAssignment_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group_0__1__Impl
	rule__XFunctionSuperTypeRef__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup_0_1()); }
	(rule__XFunctionSuperTypeRef__Group_0_1__0)?
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getRightParenthesisKeyword_0_2()); }
	')'
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getRightParenthesisKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionSuperTypeRef__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group_0_1__0__Impl
	rule__XFunctionSuperTypeRef__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesAssignment_0_1_0()); }
	(rule__XFunctionSuperTypeRef__ParamTypesAssignment_0_1_0)
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesAssignment_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup_0_1_1()); }
	(rule__XFunctionSuperTypeRef__Group_0_1_1__0)*
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getGroup_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionSuperTypeRef__Group_0_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group_0_1_1__0__Impl
	rule__XFunctionSuperTypeRef__Group_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getCommaKeyword_0_1_1_0()); }
	','
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getCommaKeyword_0_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionSuperTypeRef__Group_0_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__Group_0_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesAssignment_0_1_1_1()); }
	(rule__XFunctionSuperTypeRef__ParamTypesAssignment_0_1_1_1)
	{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesAssignment_0_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group__0__Impl
	rule__AnnotationField__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getXtendMemberAction_0()); }
	()
	{ after(grammarAccess.getAnnotationFieldAccess().getXtendMemberAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group__1__Impl
	rule__AnnotationField__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getAnnotationsAssignment_1()); }
	(rule__AnnotationField__AnnotationsAssignment_1)*
	{ after(grammarAccess.getAnnotationFieldAccess().getAnnotationsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getAlternatives_2()); }
	(rule__AnnotationField__Alternatives_2)
	{ after(grammarAccess.getAnnotationFieldAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0__0__Impl
	rule__AnnotationField__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getAlternatives_2_0_0()); }
	(rule__AnnotationField__Alternatives_2_0_0)
	{ after(grammarAccess.getAnnotationFieldAccess().getAlternatives_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0__1__Impl
	rule__AnnotationField__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_0_1()); }
	(rule__AnnotationField__Group_2_0_1__0)?
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getSemicolonKeyword_2_0_2()); }
	(';')?
	{ after(grammarAccess.getAnnotationFieldAccess().getSemicolonKeyword_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_0_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_0__0__Impl
	rule__AnnotationField__Group_2_0_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_0_0()); }
	()
	{ after(grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_0__1__Impl
	rule__AnnotationField__Group_2_0_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_0_1()); }
	(rule__AnnotationField__ModifiersAssignment_2_0_0_0_1)*
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_0__2__Impl
	rule__AnnotationField__Group_2_0_0_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_0_2()); }
	(rule__AnnotationField__ModifiersAssignment_2_0_0_0_2)
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_0__3__Impl
	rule__AnnotationField__Group_2_0_0_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_0_3()); }
	(rule__AnnotationField__ModifiersAssignment_2_0_0_0_3)*
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_0__4__Impl
	rule__AnnotationField__Group_2_0_0_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getTypeAssignment_2_0_0_0_4()); }
	(rule__AnnotationField__TypeAssignment_2_0_0_0_4)?
	{ after(grammarAccess.getAnnotationFieldAccess().getTypeAssignment_2_0_0_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_0__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_0_0_0_5()); }
	(rule__AnnotationField__NameAssignment_2_0_0_0_5)
	{ after(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_0_0_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_0_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_1__0__Impl
	rule__AnnotationField__Group_2_0_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_1_0()); }
	()
	{ after(grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_1__1__Impl
	rule__AnnotationField__Group_2_0_0_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_1_1()); }
	(rule__AnnotationField__ModifiersAssignment_2_0_0_1_1)*
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_0_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_1__2__Impl
	rule__AnnotationField__Group_2_0_0_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getTypeAssignment_2_0_0_1_2()); }
	(rule__AnnotationField__TypeAssignment_2_0_0_1_2)
	{ after(grammarAccess.getAnnotationFieldAccess().getTypeAssignment_2_0_0_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_0_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_0_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_0_0_1_3()); }
	(rule__AnnotationField__NameAssignment_2_0_0_1_3)
	{ after(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_0_0_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_1__0__Impl
	rule__AnnotationField__Group_2_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getEqualsSignKeyword_2_0_1_0()); }
	'='
	{ after(grammarAccess.getAnnotationFieldAccess().getEqualsSignKeyword_2_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getInitialValueAssignment_2_0_1_1()); }
	(rule__AnnotationField__InitialValueAssignment_2_0_1_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getInitialValueAssignment_2_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__0__Impl
	rule__AnnotationField__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getXtendClassAnnotationInfoAction_2_1_0()); }
	()
	{ after(grammarAccess.getAnnotationFieldAccess().getXtendClassAnnotationInfoAction_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__1__Impl
	rule__AnnotationField__Group_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_1_1()); }
	(rule__AnnotationField__ModifiersAssignment_2_1_1)*
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__2__Impl
	rule__AnnotationField__Group_2_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getClassKeyword_2_1_2()); }
	'class'
	{ after(grammarAccess.getAnnotationFieldAccess().getClassKeyword_2_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__3__Impl
	rule__AnnotationField__Group_2_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_1_3()); }
	(rule__AnnotationField__NameAssignment_2_1_3)
	{ after(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__4__Impl
	rule__AnnotationField__Group_2_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_4()); }
	(rule__AnnotationField__Group_2_1_4__0)?
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__5__Impl
	rule__AnnotationField__Group_2_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_5()); }
	(rule__AnnotationField__Group_2_1_5__0)?
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__6__Impl
	rule__AnnotationField__Group_2_1__7
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_6()); }
	(rule__AnnotationField__Group_2_1_6__0)?
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__7__Impl
	rule__AnnotationField__Group_2_1__8
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_1_7()); }
	'{'
	{ after(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_1_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__8__Impl
	rule__AnnotationField__Group_2_1__9
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_1_8()); }
	(rule__AnnotationField__MembersAssignment_2_1_8)*
	{ after(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_1_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_1_9()); }
	'}'
	{ after(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_1_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_4__0__Impl
	rule__AnnotationField__Group_2_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getLessThanSignKeyword_2_1_4_0()); }
	'<'
	{ after(grammarAccess.getAnnotationFieldAccess().getLessThanSignKeyword_2_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_4__1__Impl
	rule__AnnotationField__Group_2_1_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_1_4_1()); }
	(rule__AnnotationField__TypeParametersAssignment_2_1_4_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_4__2__Impl
	rule__AnnotationField__Group_2_1_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_4_2()); }
	(rule__AnnotationField__Group_2_1_4_2__0)*
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGreaterThanSignKeyword_2_1_4_3()); }
	'>'
	{ after(grammarAccess.getAnnotationFieldAccess().getGreaterThanSignKeyword_2_1_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_1_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_4_2__0__Impl
	rule__AnnotationField__Group_2_1_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_1_4_2_0()); }
	','
	{ after(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_1_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_1_4_2_1()); }
	(rule__AnnotationField__TypeParametersAssignment_2_1_4_2_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_1_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_1_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_5__0__Impl
	rule__AnnotationField__Group_2_1_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getExtendsKeyword_2_1_5_0()); }
	'extends'
	{ after(grammarAccess.getAnnotationFieldAccess().getExtendsKeyword_2_1_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getExtendsAssignment_2_1_5_1()); }
	(rule__AnnotationField__ExtendsAssignment_2_1_5_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getExtendsAssignment_2_1_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_1_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_6__0__Impl
	rule__AnnotationField__Group_2_1_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getImplementsKeyword_2_1_6_0()); }
	'implements'
	{ after(grammarAccess.getAnnotationFieldAccess().getImplementsKeyword_2_1_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_6__1__Impl
	rule__AnnotationField__Group_2_1_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getImplementsAssignment_2_1_6_1()); }
	(rule__AnnotationField__ImplementsAssignment_2_1_6_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getImplementsAssignment_2_1_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_6_2()); }
	(rule__AnnotationField__Group_2_1_6_2__0)*
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_1_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_1_6_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_6_2__0__Impl
	rule__AnnotationField__Group_2_1_6_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_1_6_2_0()); }
	','
	{ after(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_1_6_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_1_6_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_1_6_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getImplementsAssignment_2_1_6_2_1()); }
	(rule__AnnotationField__ImplementsAssignment_2_1_6_2_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getImplementsAssignment_2_1_6_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__0__Impl
	rule__AnnotationField__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getXtendInterfaceAnnotationInfoAction_2_2_0()); }
	()
	{ after(grammarAccess.getAnnotationFieldAccess().getXtendInterfaceAnnotationInfoAction_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__1__Impl
	rule__AnnotationField__Group_2_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_2_1()); }
	(rule__AnnotationField__ModifiersAssignment_2_2_1)*
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__2__Impl
	rule__AnnotationField__Group_2_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getInterfaceKeyword_2_2_2()); }
	'interface'
	{ after(grammarAccess.getAnnotationFieldAccess().getInterfaceKeyword_2_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__3__Impl
	rule__AnnotationField__Group_2_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_2_3()); }
	(rule__AnnotationField__NameAssignment_2_2_3)
	{ after(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__4__Impl
	rule__AnnotationField__Group_2_2__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_4()); }
	(rule__AnnotationField__Group_2_2_4__0)?
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__5__Impl
	rule__AnnotationField__Group_2_2__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_5()); }
	(rule__AnnotationField__Group_2_2_5__0)?
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__6__Impl
	rule__AnnotationField__Group_2_2__7
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_2_6()); }
	'{'
	{ after(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_2_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__7__Impl
	rule__AnnotationField__Group_2_2__8
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_2_7()); }
	(rule__AnnotationField__MembersAssignment_2_2_7)*
	{ after(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_2_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_2_8()); }
	'}'
	{ after(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_2_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_2_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_4__0__Impl
	rule__AnnotationField__Group_2_2_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getLessThanSignKeyword_2_2_4_0()); }
	'<'
	{ after(grammarAccess.getAnnotationFieldAccess().getLessThanSignKeyword_2_2_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_4__1__Impl
	rule__AnnotationField__Group_2_2_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_2_4_1()); }
	(rule__AnnotationField__TypeParametersAssignment_2_2_4_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_2_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_4__2__Impl
	rule__AnnotationField__Group_2_2_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_4_2()); }
	(rule__AnnotationField__Group_2_2_4_2__0)*
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGreaterThanSignKeyword_2_2_4_3()); }
	'>'
	{ after(grammarAccess.getAnnotationFieldAccess().getGreaterThanSignKeyword_2_2_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_2_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_4_2__0__Impl
	rule__AnnotationField__Group_2_2_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_2_4_2_0()); }
	','
	{ after(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_2_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_2_4_2_1()); }
	(rule__AnnotationField__TypeParametersAssignment_2_2_4_2_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersAssignment_2_2_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_2_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_5__0__Impl
	rule__AnnotationField__Group_2_2_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getExtendsKeyword_2_2_5_0()); }
	'extends'
	{ after(grammarAccess.getAnnotationFieldAccess().getExtendsKeyword_2_2_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_5__1__Impl
	rule__AnnotationField__Group_2_2_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getExtendsAssignment_2_2_5_1()); }
	(rule__AnnotationField__ExtendsAssignment_2_2_5_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getExtendsAssignment_2_2_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_5_2()); }
	(rule__AnnotationField__Group_2_2_5_2__0)*
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_2_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_2_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_5_2__0__Impl
	rule__AnnotationField__Group_2_2_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_2_5_2_0()); }
	','
	{ after(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_2_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_2_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_2_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getExtendsAssignment_2_2_5_2_1()); }
	(rule__AnnotationField__ExtendsAssignment_2_2_5_2_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getExtendsAssignment_2_2_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__0__Impl
	rule__AnnotationField__Group_2_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getXtendEnumAnnotationInfoAction_2_3_0()); }
	()
	{ after(grammarAccess.getAnnotationFieldAccess().getXtendEnumAnnotationInfoAction_2_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__1__Impl
	rule__AnnotationField__Group_2_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_3_1()); }
	(rule__AnnotationField__ModifiersAssignment_2_3_1)*
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__2__Impl
	rule__AnnotationField__Group_2_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getEnumKeyword_2_3_2()); }
	'enum'
	{ after(grammarAccess.getAnnotationFieldAccess().getEnumKeyword_2_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__3__Impl
	rule__AnnotationField__Group_2_3__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_3_3()); }
	(rule__AnnotationField__NameAssignment_2_3_3)
	{ after(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__4__Impl
	rule__AnnotationField__Group_2_3__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_3_4()); }
	'{'
	{ after(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_3_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__5__Impl
	rule__AnnotationField__Group_2_3__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_3_5()); }
	(rule__AnnotationField__Group_2_3_5__0)?
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_3_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__6__Impl
	rule__AnnotationField__Group_2_3__7
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getSemicolonKeyword_2_3_6()); }
	(';')?
	{ after(grammarAccess.getAnnotationFieldAccess().getSemicolonKeyword_2_3_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_3_7()); }
	'}'
	{ after(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_3_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_3_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3_5__0__Impl
	rule__AnnotationField__Group_2_3_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_3_5_0()); }
	(rule__AnnotationField__MembersAssignment_2_3_5_0)
	{ after(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_3_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getGroup_2_3_5_1()); }
	(rule__AnnotationField__Group_2_3_5_1__0)*
	{ after(grammarAccess.getAnnotationFieldAccess().getGroup_2_3_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_3_5_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3_5_1__0__Impl
	rule__AnnotationField__Group_2_3_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3_5_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_3_5_1_0()); }
	','
	{ after(grammarAccess.getAnnotationFieldAccess().getCommaKeyword_2_3_5_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3_5_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_3_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_3_5_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_3_5_1_1()); }
	(rule__AnnotationField__MembersAssignment_2_3_5_1_1)
	{ after(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_3_5_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AnnotationField__Group_2_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_4__0__Impl
	rule__AnnotationField__Group_2_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getXtendAnnotationTypeAnnotationInfoAction_2_4_0()); }
	()
	{ after(grammarAccess.getAnnotationFieldAccess().getXtendAnnotationTypeAnnotationInfoAction_2_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_4__1__Impl
	rule__AnnotationField__Group_2_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_4_1()); }
	(rule__AnnotationField__ModifiersAssignment_2_4_1)*
	{ after(grammarAccess.getAnnotationFieldAccess().getModifiersAssignment_2_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_4__2__Impl
	rule__AnnotationField__Group_2_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getAnnotationKeyword_2_4_2()); }
	'annotation'
	{ after(grammarAccess.getAnnotationFieldAccess().getAnnotationKeyword_2_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_4__3__Impl
	rule__AnnotationField__Group_2_4__4
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_4_3()); }
	(rule__AnnotationField__NameAssignment_2_4_3)
	{ after(grammarAccess.getAnnotationFieldAccess().getNameAssignment_2_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_4__4__Impl
	rule__AnnotationField__Group_2_4__5
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_4_4()); }
	'{'
	{ after(grammarAccess.getAnnotationFieldAccess().getLeftCurlyBracketKeyword_2_4_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_4__5__Impl
	rule__AnnotationField__Group_2_4__6
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_4_5()); }
	(rule__AnnotationField__MembersAssignment_2_4_5)*
	{ after(grammarAccess.getAnnotationFieldAccess().getMembersAssignment_2_4_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AnnotationField__Group_2_4__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__Group_2_4__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_4_6()); }
	'}'
	{ after(grammarAccess.getAnnotationFieldAccess().getRightCurlyBracketKeyword_2_4_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group__0__Impl
	rule__Member__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendMemberAction_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendMemberAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group__1__Impl
	rule__Member__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAnnotationsAssignment_1()); }
	(rule__Member__AnnotationsAssignment_1)*
	{ after(grammarAccess.getMemberAccess().getAnnotationsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAlternatives_2()); }
	(rule__Member__Alternatives_2)
	{ after(grammarAccess.getMemberAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0__0__Impl
	rule__Member__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendFieldAnnotationInfoAction_2_0_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendFieldAnnotationInfoAction_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0__1__Impl
	rule__Member__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_1()); }
	(rule__Member__ModifiersAssignment_2_0_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0__2__Impl
	rule__Member__Group_2_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAlternatives_2_0_2()); }
	(rule__Member__Alternatives_2_0_2)
	{ after(grammarAccess.getMemberAccess().getAlternatives_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0__3__Impl
	rule__Member__Group_2_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_0_3()); }
	(rule__Member__Group_2_0_3__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getSemicolonKeyword_2_0_4()); }
	(';')?
	{ after(grammarAccess.getMemberAccess().getSemicolonKeyword_2_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_0_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_0__0__Impl
	rule__Member__Group_2_0_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_0_0()); }
	(rule__Member__ModifiersAssignment_2_0_2_0_0)
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_0__1__Impl
	rule__Member__Group_2_0_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_0_1()); }
	(rule__Member__ModifiersAssignment_2_0_2_0_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_0__2__Impl
	rule__Member__Group_2_0_2_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_0_2()); }
	(rule__Member__TypeAssignment_2_0_2_0_2)?
	{ after(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_0_3()); }
	(rule__Member__NameAssignment_2_0_2_0_3)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_0_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_1__0__Impl
	rule__Member__Group_2_0_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_1_0()); }
	(rule__Member__ModifiersAssignment_2_0_2_1_0)
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_1__1__Impl
	rule__Member__Group_2_0_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAlternatives_2_0_2_1_1()); }
	(rule__Member__Alternatives_2_0_2_1_1)*
	{ after(grammarAccess.getMemberAccess().getAlternatives_2_0_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_1__2__Impl
	rule__Member__Group_2_0_2_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_1_2()); }
	(rule__Member__TypeAssignment_2_0_2_1_2)
	{ after(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_1_3()); }
	(rule__Member__NameAssignment_2_0_2_1_3)?
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_0_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_2__0__Impl
	rule__Member__Group_2_0_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_0()); }
	(rule__Member__ModifiersAssignment_2_0_2_2_0)
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_2__1__Impl
	rule__Member__Group_2_0_2_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_1()); }
	(rule__Member__ModifiersAssignment_2_0_2_2_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_2__2__Impl
	rule__Member__Group_2_0_2_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_2()); }
	(rule__Member__ModifiersAssignment_2_0_2_2_2)
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_2__3__Impl
	rule__Member__Group_2_0_2_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_3()); }
	(rule__Member__ModifiersAssignment_2_0_2_2_3)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_0_2_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_2__4__Impl
	rule__Member__Group_2_0_2_2__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_2_4()); }
	(rule__Member__TypeAssignment_2_0_2_2_4)
	{ after(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_2_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_2__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_2__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_2_5()); }
	(rule__Member__NameAssignment_2_0_2_2_5)?
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_2_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_0_2_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_3__0__Impl
	rule__Member__Group_2_0_2_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_3_0()); }
	(rule__Member__TypeAssignment_2_0_2_3_0)
	{ after(grammarAccess.getMemberAccess().getTypeAssignment_2_0_2_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_2_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_2_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_3_1()); }
	(rule__Member__NameAssignment_2_0_2_3_1)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_0_2_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_0_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_3__0__Impl
	rule__Member__Group_2_0_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getEqualsSignKeyword_2_0_3_0()); }
	'='
	{ after(grammarAccess.getMemberAccess().getEqualsSignKeyword_2_0_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_0_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_0_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getInitialValueAssignment_2_0_3_1()); }
	(rule__Member__InitialValueAssignment_2_0_3_1)
	{ after(grammarAccess.getMemberAccess().getInitialValueAssignment_2_0_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__0__Impl
	rule__Member__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendFunctionAnnotationInfoAction_2_1_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendFunctionAnnotationInfoAction_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__1__Impl
	rule__Member__Group_2_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_1()); }
	(rule__Member__ModifiersAssignment_2_1_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__2__Impl
	rule__Member__Group_2_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_2()); }
	(rule__Member__ModifiersAssignment_2_1_2)
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__3__Impl
	rule__Member__Group_2_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAlternatives_2_1_3()); }
	(rule__Member__Alternatives_2_1_3)*
	{ after(grammarAccess.getMemberAccess().getAlternatives_2_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__4__Impl
	rule__Member__Group_2_1__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_4()); }
	(rule__Member__Group_2_1_4__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__5__Impl
	rule__Member__Group_2_1__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAlternatives_2_1_5()); }
	(rule__Member__Alternatives_2_1_5)
	{ after(grammarAccess.getMemberAccess().getAlternatives_2_1_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__6__Impl
	rule__Member__Group_2_1__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_6()); }
	(rule__Member__Group_2_1_6__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__7__Impl
	rule__Member__Group_2_1__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getRightParenthesisKeyword_2_1_7()); }
	')'
	{ after(grammarAccess.getMemberAccess().getRightParenthesisKeyword_2_1_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__8__Impl
	rule__Member__Group_2_1__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_8()); }
	(rule__Member__Group_2_1_8__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAlternatives_2_1_9()); }
	(rule__Member__Alternatives_2_1_9)?
	{ after(grammarAccess.getMemberAccess().getAlternatives_2_1_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_4__0__Impl
	rule__Member__Group_2_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_1_4_0()); }
	'<'
	{ after(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_4__1__Impl
	rule__Member__Group_2_1_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_1_4_1()); }
	(rule__Member__TypeParametersAssignment_2_1_4_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_4__2__Impl
	rule__Member__Group_2_1_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_4_2()); }
	(rule__Member__Group_2_1_4_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_1_4_3()); }
	'>'
	{ after(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_1_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_4_2__0__Impl
	rule__Member__Group_2_1_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_1_4_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_1_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_1_4_2_1()); }
	(rule__Member__TypeParametersAssignment_2_1_4_2_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_1_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_0_0()); }
	(rule__Member__Group_2_1_5_0_0__0)
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_0_0__0__Impl
	rule__Member__Group_2_1_5_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getReturnTypeAssignment_2_1_5_0_0_0()); }
	(rule__Member__ReturnTypeAssignment_2_1_5_0_0_0)
	{ after(grammarAccess.getMemberAccess().getReturnTypeAssignment_2_1_5_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_0_0__1__Impl
	rule__Member__Group_2_1_5_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCreateExtensionInfoAssignment_2_1_5_0_0_1()); }
	(rule__Member__CreateExtensionInfoAssignment_2_1_5_0_0_1)
	{ after(grammarAccess.getMemberAccess().getCreateExtensionInfoAssignment_2_1_5_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_0_0__2__Impl
	rule__Member__Group_2_1_5_0_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_0_0_2()); }
	(rule__Member__NameAssignment_2_1_5_0_0_2)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_0_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_0_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_0_0_3()); }
	'('
	{ after(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_0_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_1_0()); }
	(rule__Member__Group_2_1_5_1_0__0)
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_1_0__0__Impl
	rule__Member__Group_2_1_5_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getReturnTypeAssignment_2_1_5_1_0_0()); }
	(rule__Member__ReturnTypeAssignment_2_1_5_1_0_0)
	{ after(grammarAccess.getMemberAccess().getReturnTypeAssignment_2_1_5_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_1_0__1__Impl
	rule__Member__Group_2_1_5_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_1_0_1()); }
	(rule__Member__NameAssignment_2_1_5_1_0_1)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_1_0_2()); }
	'('
	{ after(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_2__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_2_0()); }
	(rule__Member__Group_2_1_5_2_0__0)
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_2_0__0__Impl
	rule__Member__Group_2_1_5_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getReturnTypeAssignment_2_1_5_2_0_0()); }
	(rule__Member__ReturnTypeAssignment_2_1_5_2_0_0)
	{ after(grammarAccess.getMemberAccess().getReturnTypeAssignment_2_1_5_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_2_0__1__Impl
	rule__Member__Group_2_1_5_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_2_0_1()); }
	(rule__Member__NameAssignment_2_1_5_2_0_1)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_2_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_2_0_2()); }
	'('
	{ after(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_3__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_5_3_0()); }
	(rule__Member__Group_2_1_5_3_0__0)
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_5_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_3_0__0__Impl
	rule__Member__Group_2_1_5_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCreateExtensionInfoAssignment_2_1_5_3_0_0()); }
	(rule__Member__CreateExtensionInfoAssignment_2_1_5_3_0_0)
	{ after(grammarAccess.getMemberAccess().getCreateExtensionInfoAssignment_2_1_5_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_3_0__1__Impl
	rule__Member__Group_2_1_5_3_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_3_0_1()); }
	(rule__Member__NameAssignment_2_1_5_3_0_1)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_3_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_3_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_3_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_3_0_2()); }
	'('
	{ after(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_3_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_5_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_4__0__Impl
	rule__Member__Group_2_1_5_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_4_0()); }
	(rule__Member__NameAssignment_2_1_5_4_0)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_1_5_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_5_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_5_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_4_1()); }
	'('
	{ after(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_1_5_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_6__0__Impl
	rule__Member__Group_2_1_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getParametersAssignment_2_1_6_0()); }
	(rule__Member__ParametersAssignment_2_1_6_0)
	{ after(grammarAccess.getMemberAccess().getParametersAssignment_2_1_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_6_1()); }
	(rule__Member__Group_2_1_6_1__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_6_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_6_1__0__Impl
	rule__Member__Group_2_1_6_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_6_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_1_6_1_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_1_6_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_6_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_6_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_6_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getParametersAssignment_2_1_6_1_1()); }
	(rule__Member__ParametersAssignment_2_1_6_1_1)
	{ after(grammarAccess.getMemberAccess().getParametersAssignment_2_1_6_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_8__0__Impl
	rule__Member__Group_2_1_8__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getThrowsKeyword_2_1_8_0()); }
	'throws'
	{ after(grammarAccess.getMemberAccess().getThrowsKeyword_2_1_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_8__1__Impl
	rule__Member__Group_2_1_8__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExceptionsAssignment_2_1_8_1()); }
	(rule__Member__ExceptionsAssignment_2_1_8_1)
	{ after(grammarAccess.getMemberAccess().getExceptionsAssignment_2_1_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_8__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_1_8_2()); }
	(rule__Member__Group_2_1_8_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_1_8_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_1_8_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_8_2__0__Impl
	rule__Member__Group_2_1_8_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_1_8_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_1_8_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_1_8_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_1_8_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExceptionsAssignment_2_1_8_2_1()); }
	(rule__Member__ExceptionsAssignment_2_1_8_2_1)
	{ after(grammarAccess.getMemberAccess().getExceptionsAssignment_2_1_8_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__0__Impl
	rule__Member__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendConstructorAnnotationInfoAction_2_2_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendConstructorAnnotationInfoAction_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__1__Impl
	rule__Member__Group_2_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_2_1()); }
	(rule__Member__ModifiersAssignment_2_2_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__2__Impl
	rule__Member__Group_2_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNewKeyword_2_2_2()); }
	'new'
	{ after(grammarAccess.getMemberAccess().getNewKeyword_2_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__3__Impl
	rule__Member__Group_2_2__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_2_3()); }
	(rule__Member__Group_2_2_3__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__4__Impl
	rule__Member__Group_2_2__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_2_4()); }
	'('
	{ after(grammarAccess.getMemberAccess().getLeftParenthesisKeyword_2_2_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__5__Impl
	rule__Member__Group_2_2__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_2_5()); }
	(rule__Member__Group_2_2_5__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_2_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__6__Impl
	rule__Member__Group_2_2__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getRightParenthesisKeyword_2_2_6()); }
	')'
	{ after(grammarAccess.getMemberAccess().getRightParenthesisKeyword_2_2_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__7__Impl
	rule__Member__Group_2_2__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_2_7()); }
	(rule__Member__Group_2_2_7__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_2_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExpressionAssignment_2_2_8()); }
	(rule__Member__ExpressionAssignment_2_2_8)
	{ after(grammarAccess.getMemberAccess().getExpressionAssignment_2_2_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_2_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_3__0__Impl
	rule__Member__Group_2_2_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_2_3_0()); }
	'<'
	{ after(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_2_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_3__1__Impl
	rule__Member__Group_2_2_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_2_3_1()); }
	(rule__Member__TypeParametersAssignment_2_2_3_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_2_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_3__2__Impl
	rule__Member__Group_2_2_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_2_3_2()); }
	(rule__Member__Group_2_2_3_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_2_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_2_3_3()); }
	'>'
	{ after(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_2_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_2_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_3_2__0__Impl
	rule__Member__Group_2_2_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_2_3_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_2_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_2_3_2_1()); }
	(rule__Member__TypeParametersAssignment_2_2_3_2_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_2_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_2_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_5__0__Impl
	rule__Member__Group_2_2_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getParametersAssignment_2_2_5_0()); }
	(rule__Member__ParametersAssignment_2_2_5_0)
	{ after(grammarAccess.getMemberAccess().getParametersAssignment_2_2_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_2_5_1()); }
	(rule__Member__Group_2_2_5_1__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_2_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_2_5_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_5_1__0__Impl
	rule__Member__Group_2_2_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_5_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_2_5_1_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_2_5_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_5_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_5_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getParametersAssignment_2_2_5_1_1()); }
	(rule__Member__ParametersAssignment_2_2_5_1_1)
	{ after(grammarAccess.getMemberAccess().getParametersAssignment_2_2_5_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_2_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_7__0__Impl
	rule__Member__Group_2_2_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getThrowsKeyword_2_2_7_0()); }
	'throws'
	{ after(grammarAccess.getMemberAccess().getThrowsKeyword_2_2_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_7__1__Impl
	rule__Member__Group_2_2_7__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExceptionsAssignment_2_2_7_1()); }
	(rule__Member__ExceptionsAssignment_2_2_7_1)
	{ after(grammarAccess.getMemberAccess().getExceptionsAssignment_2_2_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_7__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_2_7_2()); }
	(rule__Member__Group_2_2_7_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_2_7_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_2_7_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_7_2__0__Impl
	rule__Member__Group_2_2_7_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_2_7_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_2_7_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_2_7_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_2_7_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExceptionsAssignment_2_2_7_2_1()); }
	(rule__Member__ExceptionsAssignment_2_2_7_2_1)
	{ after(grammarAccess.getMemberAccess().getExceptionsAssignment_2_2_7_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__0__Impl
	rule__Member__Group_2_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendClassAnnotationInfoAction_2_3_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendClassAnnotationInfoAction_2_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__1__Impl
	rule__Member__Group_2_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_3_1()); }
	(rule__Member__ModifiersAssignment_2_3_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__2__Impl
	rule__Member__Group_2_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getClassKeyword_2_3_2()); }
	'class'
	{ after(grammarAccess.getMemberAccess().getClassKeyword_2_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__3__Impl
	rule__Member__Group_2_3__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_3_3()); }
	(rule__Member__NameAssignment_2_3_3)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__4__Impl
	rule__Member__Group_2_3__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_3_4()); }
	(rule__Member__Group_2_3_4__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_3_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__5__Impl
	rule__Member__Group_2_3__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_3_5()); }
	(rule__Member__Group_2_3_5__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_3_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__6__Impl
	rule__Member__Group_2_3__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_3_6()); }
	(rule__Member__Group_2_3_6__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_3_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__7__Impl
	rule__Member__Group_2_3__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_3_7()); }
	'{'
	{ after(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_3_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__8__Impl
	rule__Member__Group_2_3__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getMembersAssignment_2_3_8()); }
	(rule__Member__MembersAssignment_2_3_8)*
	{ after(grammarAccess.getMemberAccess().getMembersAssignment_2_3_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_3_9()); }
	'}'
	{ after(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_3_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_3_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_4__0__Impl
	rule__Member__Group_2_3_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_3_4_0()); }
	'<'
	{ after(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_3_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_4__1__Impl
	rule__Member__Group_2_3_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_3_4_1()); }
	(rule__Member__TypeParametersAssignment_2_3_4_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_3_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_4__2__Impl
	rule__Member__Group_2_3_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_3_4_2()); }
	(rule__Member__Group_2_3_4_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_3_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_3_4_3()); }
	'>'
	{ after(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_3_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_3_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_4_2__0__Impl
	rule__Member__Group_2_3_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_3_4_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_3_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_3_4_2_1()); }
	(rule__Member__TypeParametersAssignment_2_3_4_2_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_3_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_3_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_5__0__Impl
	rule__Member__Group_2_3_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExtendsKeyword_2_3_5_0()); }
	'extends'
	{ after(grammarAccess.getMemberAccess().getExtendsKeyword_2_3_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExtendsAssignment_2_3_5_1()); }
	(rule__Member__ExtendsAssignment_2_3_5_1)
	{ after(grammarAccess.getMemberAccess().getExtendsAssignment_2_3_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_3_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_6__0__Impl
	rule__Member__Group_2_3_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getImplementsKeyword_2_3_6_0()); }
	'implements'
	{ after(grammarAccess.getMemberAccess().getImplementsKeyword_2_3_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_6__1__Impl
	rule__Member__Group_2_3_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getImplementsAssignment_2_3_6_1()); }
	(rule__Member__ImplementsAssignment_2_3_6_1)
	{ after(grammarAccess.getMemberAccess().getImplementsAssignment_2_3_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_3_6_2()); }
	(rule__Member__Group_2_3_6_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_3_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_3_6_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_6_2__0__Impl
	rule__Member__Group_2_3_6_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_3_6_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_3_6_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_3_6_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_3_6_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getImplementsAssignment_2_3_6_2_1()); }
	(rule__Member__ImplementsAssignment_2_3_6_2_1)
	{ after(grammarAccess.getMemberAccess().getImplementsAssignment_2_3_6_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__0__Impl
	rule__Member__Group_2_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendInterfaceAnnotationInfoAction_2_4_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendInterfaceAnnotationInfoAction_2_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__1__Impl
	rule__Member__Group_2_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_4_1()); }
	(rule__Member__ModifiersAssignment_2_4_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__2__Impl
	rule__Member__Group_2_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getInterfaceKeyword_2_4_2()); }
	'interface'
	{ after(grammarAccess.getMemberAccess().getInterfaceKeyword_2_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__3__Impl
	rule__Member__Group_2_4__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_4_3()); }
	(rule__Member__NameAssignment_2_4_3)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__4__Impl
	rule__Member__Group_2_4__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_4_4()); }
	(rule__Member__Group_2_4_4__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_4_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__5__Impl
	rule__Member__Group_2_4__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_4_5()); }
	(rule__Member__Group_2_4_5__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_4_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__6__Impl
	rule__Member__Group_2_4__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_4_6()); }
	'{'
	{ after(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_4_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__7__Impl
	rule__Member__Group_2_4__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getMembersAssignment_2_4_7()); }
	(rule__Member__MembersAssignment_2_4_7)*
	{ after(grammarAccess.getMemberAccess().getMembersAssignment_2_4_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4__8__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_4_8()); }
	'}'
	{ after(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_4_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_4_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_4__0__Impl
	rule__Member__Group_2_4_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_4_4_0()); }
	'<'
	{ after(grammarAccess.getMemberAccess().getLessThanSignKeyword_2_4_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_4__1__Impl
	rule__Member__Group_2_4_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_4_4_1()); }
	(rule__Member__TypeParametersAssignment_2_4_4_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_4_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_4__2__Impl
	rule__Member__Group_2_4_4__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_4_4_2()); }
	(rule__Member__Group_2_4_4_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_4_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_4__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_4_4_3()); }
	'>'
	{ after(grammarAccess.getMemberAccess().getGreaterThanSignKeyword_2_4_4_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_4_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_4_2__0__Impl
	rule__Member__Group_2_4_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_4_4_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_4_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_4_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_4_4_2_1()); }
	(rule__Member__TypeParametersAssignment_2_4_4_2_1)
	{ after(grammarAccess.getMemberAccess().getTypeParametersAssignment_2_4_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_4_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_5__0__Impl
	rule__Member__Group_2_4_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExtendsKeyword_2_4_5_0()); }
	'extends'
	{ after(grammarAccess.getMemberAccess().getExtendsKeyword_2_4_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_5__1__Impl
	rule__Member__Group_2_4_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExtendsAssignment_2_4_5_1()); }
	(rule__Member__ExtendsAssignment_2_4_5_1)
	{ after(grammarAccess.getMemberAccess().getExtendsAssignment_2_4_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_4_5_2()); }
	(rule__Member__Group_2_4_5_2__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_4_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_4_5_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_5_2__0__Impl
	rule__Member__Group_2_4_5_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_4_5_2_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_4_5_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_4_5_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_4_5_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getExtendsAssignment_2_4_5_2_1()); }
	(rule__Member__ExtendsAssignment_2_4_5_2_1)
	{ after(grammarAccess.getMemberAccess().getExtendsAssignment_2_4_5_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__0__Impl
	rule__Member__Group_2_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendEnumAnnotationInfoAction_2_5_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendEnumAnnotationInfoAction_2_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__1__Impl
	rule__Member__Group_2_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_5_1()); }
	(rule__Member__ModifiersAssignment_2_5_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__2__Impl
	rule__Member__Group_2_5__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getEnumKeyword_2_5_2()); }
	'enum'
	{ after(grammarAccess.getMemberAccess().getEnumKeyword_2_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__3__Impl
	rule__Member__Group_2_5__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_5_3()); }
	(rule__Member__NameAssignment_2_5_3)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_5_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__4__Impl
	rule__Member__Group_2_5__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_5_4()); }
	'{'
	{ after(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_5_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__5__Impl
	rule__Member__Group_2_5__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_5_5()); }
	(rule__Member__Group_2_5_5__0)?
	{ after(grammarAccess.getMemberAccess().getGroup_2_5_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__6__Impl
	rule__Member__Group_2_5__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getSemicolonKeyword_2_5_6()); }
	(';')?
	{ after(grammarAccess.getMemberAccess().getSemicolonKeyword_2_5_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_5_7()); }
	'}'
	{ after(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_5_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_5_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5_5__0__Impl
	rule__Member__Group_2_5_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getMembersAssignment_2_5_5_0()); }
	(rule__Member__MembersAssignment_2_5_5_0)
	{ after(grammarAccess.getMemberAccess().getMembersAssignment_2_5_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getGroup_2_5_5_1()); }
	(rule__Member__Group_2_5_5_1__0)*
	{ after(grammarAccess.getMemberAccess().getGroup_2_5_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_5_5_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5_5_1__0__Impl
	rule__Member__Group_2_5_5_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5_5_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getCommaKeyword_2_5_5_1_0()); }
	','
	{ after(grammarAccess.getMemberAccess().getCommaKeyword_2_5_5_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5_5_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_5_5_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_5_5_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getMembersAssignment_2_5_5_1_1()); }
	(rule__Member__MembersAssignment_2_5_5_1_1)
	{ after(grammarAccess.getMemberAccess().getMembersAssignment_2_5_5_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Member__Group_2_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_6__0__Impl
	rule__Member__Group_2_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getXtendAnnotationTypeAnnotationInfoAction_2_6_0()); }
	()
	{ after(grammarAccess.getMemberAccess().getXtendAnnotationTypeAnnotationInfoAction_2_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_6__1__Impl
	rule__Member__Group_2_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getModifiersAssignment_2_6_1()); }
	(rule__Member__ModifiersAssignment_2_6_1)*
	{ after(grammarAccess.getMemberAccess().getModifiersAssignment_2_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_6__2__Impl
	rule__Member__Group_2_6__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getAnnotationKeyword_2_6_2()); }
	'annotation'
	{ after(grammarAccess.getMemberAccess().getAnnotationKeyword_2_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_6__3__Impl
	rule__Member__Group_2_6__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getNameAssignment_2_6_3()); }
	(rule__Member__NameAssignment_2_6_3)
	{ after(grammarAccess.getMemberAccess().getNameAssignment_2_6_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_6__4__Impl
	rule__Member__Group_2_6__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_6_4()); }
	'{'
	{ after(grammarAccess.getMemberAccess().getLeftCurlyBracketKeyword_2_6_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_6__5__Impl
	rule__Member__Group_2_6__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getMembersAssignment_2_6_5()); }
	(rule__Member__MembersAssignment_2_6_5)*
	{ after(grammarAccess.getMemberAccess().getMembersAssignment_2_6_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Member__Group_2_6__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__Group_2_6__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_6_6()); }
	'}'
	{ after(grammarAccess.getMemberAccess().getRightCurlyBracketKeyword_2_6_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeReferenceWithTypeArgs__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_0__0__Impl
	rule__TypeReferenceWithTypeArgs__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0()); }
	ruleParameterizedTypeReferenceWithTypeArgs
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getParameterizedTypeReferenceWithTypeArgsParserRuleCall_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_0_1()); }
	(rule__TypeReferenceWithTypeArgs__Group_0_1__0)*
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeReferenceWithTypeArgs__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_0_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_0_1_0()); }
	(rule__TypeReferenceWithTypeArgs__Group_0_1_0__0)
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeReferenceWithTypeArgs__Group_0_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_0_1_0__0__Impl
	rule__TypeReferenceWithTypeArgs__Group_0_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_0_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); }
	()
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_0_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_0_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_0_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getArrayBracketsParserRuleCall_0_1_0_1()); }
	ruleArrayBrackets
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getArrayBracketsParserRuleCall_0_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeReferenceWithTypeArgs__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_1__0__Impl
	rule__TypeReferenceWithTypeArgs__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getTypeReferenceNoTypeArgsParserRuleCall_1_0()); }
	ruleTypeReferenceNoTypeArgs
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getTypeReferenceNoTypeArgsParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1_1()); }
		(rule__TypeReferenceWithTypeArgs__Group_1_1__0)
		{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1_1()); }
	)
	(
		{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1_1()); }
		(rule__TypeReferenceWithTypeArgs__Group_1_1__0)*
		{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeReferenceWithTypeArgs__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_1_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1_1_0()); }
	(rule__TypeReferenceWithTypeArgs__Group_1_1_0__0)
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeReferenceWithTypeArgs__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_1_1_0__0__Impl
	rule__TypeReferenceWithTypeArgs__Group_1_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0()); }
	()
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_1_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeReferenceWithTypeArgs__Group_1_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceWithTypeArgs__Group_1_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeReferenceWithTypeArgsAccess().getArrayBracketsParserRuleCall_1_1_0_1()); }
	ruleArrayBrackets
	{ after(grammarAccess.getTypeReferenceWithTypeArgsAccess().getArrayBracketsParserRuleCall_1_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group__0__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeAssignment_0()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__TypeAssignment_0)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__0)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__0__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getLessThanSignKeyword_1_0()); }
	'<'
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getLessThanSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__1__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_1()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_1)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__2__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_2()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__0)*
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__3__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGreaterThanSignKeyword_1_3()); }
	'>'
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGreaterThanSignKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__0)*
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__0__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getCommaKeyword_1_2_0()); }
	','
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getCommaKeyword_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_2_1()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_2_1)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__0__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_0()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0__0)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__1__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeAssignment_1_4_1()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__TypeAssignment_1_4_1)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeAssignment_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_2()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__0)?
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_0_0()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__0)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__0__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); }
	()
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getFullStopKeyword_1_4_0_0_1()); }
	'.'
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getFullStopKeyword_1_4_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__0__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getLessThanSignKeyword_1_4_2_0()); }
	('<')
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getLessThanSignKeyword_1_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__1__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_4_2_1()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_4_2_1)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__2__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_2_2()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__0)*
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGroup_1_4_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGreaterThanSignKeyword_1_4_2_3()); }
	'>'
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getGreaterThanSignKeyword_1_4_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__0__Impl
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getCommaKeyword_1_4_2_2_0()); }
	','
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getCommaKeyword_1_4_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__Group_1_4_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_4_2_2_1()); }
	(rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_4_2_2_1)
	{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsAssignment_1_4_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XtendEnumLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XtendEnumLiteral__Group__0__Impl
	rule__XtendEnumLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XtendEnumLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXtendEnumLiteralAccess().getAnnotationsAssignment_0()); }
	(rule__XtendEnumLiteral__AnnotationsAssignment_0)*
	{ after(grammarAccess.getXtendEnumLiteralAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XtendEnumLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XtendEnumLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XtendEnumLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXtendEnumLiteralAccess().getNameAssignment_1()); }
	(rule__XtendEnumLiteral__NameAssignment_1)
	{ after(grammarAccess.getXtendEnumLiteralAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CreateExtensionInfo__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CreateExtensionInfo__Group__0__Impl
	rule__CreateExtensionInfo__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCreateExtensionInfoAccess().getCreateKeyword_0()); }
	'create'
	{ after(grammarAccess.getCreateExtensionInfoAccess().getCreateKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CreateExtensionInfo__Group__1__Impl
	rule__CreateExtensionInfo__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCreateExtensionInfoAccess().getGroup_1()); }
	(rule__CreateExtensionInfo__Group_1__0)?
	{ after(grammarAccess.getCreateExtensionInfoAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CreateExtensionInfo__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCreateExtensionInfoAccess().getCreateExpressionAssignment_2()); }
	(rule__CreateExtensionInfo__CreateExpressionAssignment_2)
	{ after(grammarAccess.getCreateExtensionInfoAccess().getCreateExpressionAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CreateExtensionInfo__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CreateExtensionInfo__Group_1__0__Impl
	rule__CreateExtensionInfo__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCreateExtensionInfoAccess().getNameAssignment_1_0()); }
	(rule__CreateExtensionInfo__NameAssignment_1_0)
	{ after(grammarAccess.getCreateExtensionInfoAccess().getNameAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CreateExtensionInfo__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCreateExtensionInfoAccess().getColonKeyword_1_1()); }
	':'
	{ after(grammarAccess.getCreateExtensionInfoAccess().getColonKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Parameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__0__Impl
	rule__Parameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getAnnotationsAssignment_0()); }
	(rule__Parameter__AnnotationsAssignment_0)*
	{ after(grammarAccess.getParameterAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__1__Impl
	rule__Parameter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getGroup_1()); }
	(rule__Parameter__Group_1__0)?
	{ after(grammarAccess.getParameterAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__2__Impl
	rule__Parameter__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getParameterTypeAssignment_2()); }
	(rule__Parameter__ParameterTypeAssignment_2)
	{ after(grammarAccess.getParameterAccess().getParameterTypeAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__3__Impl
	rule__Parameter__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getVarArgAssignment_3()); }
	(rule__Parameter__VarArgAssignment_3)?
	{ after(grammarAccess.getParameterAccess().getVarArgAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getNameAssignment_4()); }
	(rule__Parameter__NameAssignment_4)
	{ after(grammarAccess.getParameterAccess().getNameAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Parameter__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1__0__Impl
	rule__Parameter__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getExtensionAssignment_1_0()); }
	(rule__Parameter__ExtensionAssignment_1_0)
	{ after(grammarAccess.getParameterAccess().getExtensionAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getAnnotationsAssignment_1_1()); }
	(rule__Parameter__AnnotationsAssignment_1_1)*
	{ after(grammarAccess.getParameterAccess().getAnnotationsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAssignment__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_0__0__Impl
	rule__XAssignment__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0()); }
	()
	{ after(grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_0__1__Impl
	rule__XAssignment__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getFeatureAssignment_0_1()); }
	(rule__XAssignment__FeatureAssignment_0_1)
	{ after(grammarAccess.getXAssignmentAccess().getFeatureAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_0__2__Impl
	rule__XAssignment__Group_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); }
	ruleOpSingleAssign
	{ after(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getValueAssignment_0_3()); }
	(rule__XAssignment__ValueAssignment_0_3)
	{ after(grammarAccess.getXAssignmentAccess().getValueAssignment_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAssignment__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_1__0__Impl
	rule__XAssignment__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getXConditionalExpressionParserRuleCall_1_0()); }
	ruleXConditionalExpression
	{ after(grammarAccess.getXAssignmentAccess().getXConditionalExpressionParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getGroup_1_1()); }
	(rule__XAssignment__Group_1_1__0)?
	{ after(grammarAccess.getXAssignmentAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAssignment__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_1_1__0__Impl
	rule__XAssignment__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getGroup_1_1_0()); }
	(rule__XAssignment__Group_1_1_0__0)
	{ after(grammarAccess.getXAssignmentAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getRightOperandAssignment_1_1_1()); }
	(rule__XAssignment__RightOperandAssignment_1_1_1)
	{ after(grammarAccess.getXAssignmentAccess().getRightOperandAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAssignment__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_1_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getGroup_1_1_0_0()); }
	(rule__XAssignment__Group_1_1_0_0__0)
	{ after(grammarAccess.getXAssignmentAccess().getGroup_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAssignment__Group_1_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_1_1_0_0__0__Impl
	rule__XAssignment__Group_1_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()); }
	()
	{ after(grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAssignment__Group_1_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__Group_1_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAssignmentAccess().getFeatureAssignment_1_1_0_0_1()); }
	(rule__XAssignment__FeatureAssignment_1_1_0_0_1)
	{ after(grammarAccess.getXAssignmentAccess().getFeatureAssignment_1_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConditionalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group__0__Impl
	rule__XConditionalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getXOrExpressionParserRuleCall_0()); }
	ruleXOrExpression
	{ after(grammarAccess.getXConditionalExpressionAccess().getXOrExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getGroup_1()); }
	(rule__XConditionalExpression__Group_1__0)?
	{ after(grammarAccess.getXConditionalExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConditionalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1__0__Impl
	rule__XConditionalExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getGroup_1_0()); }
	(rule__XConditionalExpression__Group_1_0__0)
	{ after(grammarAccess.getXConditionalExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1__1__Impl
	rule__XConditionalExpression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getThenAssignment_1_1()); }
	(rule__XConditionalExpression__ThenAssignment_1_1)
	{ after(grammarAccess.getXConditionalExpressionAccess().getThenAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getGroup_1_2()); }
	(rule__XConditionalExpression__Group_1_2__0)?
	{ after(grammarAccess.getXConditionalExpressionAccess().getGroup_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConditionalExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getGroup_1_0_0()); }
	(rule__XConditionalExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXConditionalExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConditionalExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1_0_0__0__Impl
	rule__XConditionalExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getXIfExpressionIfAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXConditionalExpressionAccess().getXIfExpressionIfAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getConditionalExpressionAssignment_1_0_0_1()); }
	(rule__XConditionalExpression__ConditionalExpressionAssignment_1_0_0_1)
	{ after(grammarAccess.getXConditionalExpressionAccess().getConditionalExpressionAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConditionalExpression__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1_2__0__Impl
	rule__XConditionalExpression__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getColonKeyword_1_2_0()); }
	(':')
	{ after(grammarAccess.getXConditionalExpressionAccess().getColonKeyword_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConditionalExpression__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConditionalExpressionAccess().getElseAssignment_1_2_1()); }
	(rule__XConditionalExpression__ElseAssignment_1_2_1)
	{ after(grammarAccess.getXConditionalExpressionAccess().getElseAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group__0__Impl
	rule__XTryCatchFinallyExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0()); }
	()
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group__1__Impl
	rule__XTryCatchFinallyExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1()); }
	'try'
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getAlternatives_2()); }
	(rule__XTryCatchFinallyExpression__Alternatives_2)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getLeftParenthesisKeyword_2_0_0()); }
	'('
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getLeftParenthesisKeyword_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0__1__Impl
	rule__XTryCatchFinallyExpression__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesAssignment_2_0_1()); }
	(rule__XTryCatchFinallyExpression__ResourcesAssignment_2_0_1)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0__2__Impl
	rule__XTryCatchFinallyExpression__Group_2_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_2()); }
	(rule__XTryCatchFinallyExpression__Group_2_0_2__0)*
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0__3__Impl
	rule__XTryCatchFinallyExpression__Group_2_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getSemicolonKeyword_2_0_3()); }
	(';')?
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getSemicolonKeyword_2_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0__4__Impl
	rule__XTryCatchFinallyExpression__Group_2_0__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getRightParenthesisKeyword_2_0_4()); }
	')'
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getRightParenthesisKeyword_2_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0__5__Impl
	rule__XTryCatchFinallyExpression__Group_2_0__6
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionAssignment_2_0_5()); }
	(rule__XTryCatchFinallyExpression__ExpressionAssignment_2_0_5)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionAssignment_2_0_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6()); }
	(rule__XTryCatchFinallyExpression__Group_2_0_6__0)?
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_0_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_2__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_0_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getSemicolonKeyword_2_0_2_0()); }
	';'
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getSemicolonKeyword_2_0_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesAssignment_2_0_2_1()); }
	(rule__XTryCatchFinallyExpression__ResourcesAssignment_2_0_2_1)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesAssignment_2_0_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_0_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_6__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getAlternatives_2_0_6_0()); }
	(rule__XTryCatchFinallyExpression__Alternatives_2_0_6_0)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getAlternatives_2_0_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_0_6_0_0_0()); }
		(rule__XTryCatchFinallyExpression__CatchClausesAssignment_2_0_6_0_0_0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_0_6_0_0_0()); }
	)
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_0_6_0_0_0()); }
		(rule__XTryCatchFinallyExpression__CatchClausesAssignment_2_0_6_0_0_0)*
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_0_6_0_0_0()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6_0_0_1()); }
	(rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__0)?
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_0_6_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_6_0_0_1_0()); }
	('finally')
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_6_0_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_0_6_0_0_1_1()); }
	(rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_0_6_0_0_1_1)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_0_6_0_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_6_0_1_0()); }
	'finally'
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_0_6_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_0_6_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_0_6_0_1_1()); }
	(rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_0_6_0_1_1)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_0_6_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionAssignment_2_1_0()); }
	(rule__XTryCatchFinallyExpression__ExpressionAssignment_2_1_0)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionAssignment_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getAlternatives_2_1_1()); }
	(rule__XTryCatchFinallyExpression__Alternatives_2_1_1)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getAlternatives_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1_1_0__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_1_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_1_1_0_0()); }
		(rule__XTryCatchFinallyExpression__CatchClausesAssignment_2_1_1_0_0)
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_1_1_0_0()); }
	)
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_1_1_0_0()); }
		(rule__XTryCatchFinallyExpression__CatchClausesAssignment_2_1_1_0_0)*
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_2_1_1_0_0()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1_1_0_1()); }
	(rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__0)?
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_2_1_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_1_0_1_0()); }
	('finally')
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_1_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_1_1_0_1_1()); }
	(rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_1_1_0_1_1)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_1_1_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTryCatchFinallyExpression__Group_2_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1_1_1__0__Impl
	rule__XTryCatchFinallyExpression__Group_2_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_1_1_0()); }
	'finally'
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_2_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTryCatchFinallyExpression__Group_2_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__Group_2_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_1_1_1_1()); }
	(rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_1_1_1_1)
	{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_2_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XVariableDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group__0__Impl
	rule__XVariableDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getGroup_0()); }
	(rule__XVariableDeclaration__Group_0__0)
	{ after(grammarAccess.getXVariableDeclarationAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group__1__Impl
	rule__XVariableDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getAlternatives_1()); }
	(rule__XVariableDeclaration__Alternatives_1)
	{ after(grammarAccess.getXVariableDeclarationAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getGroup_2()); }
	(rule__XVariableDeclaration__Group_2__0)?
	{ after(grammarAccess.getXVariableDeclarationAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XVariableDeclaration__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getGroup_0_0()); }
	(rule__XVariableDeclaration__Group_0_0__0)
	{ after(grammarAccess.getXVariableDeclarationAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XVariableDeclaration__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_0_0__0__Impl
	rule__XVariableDeclaration__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getXtendVariableDeclarationAction_0_0_0()); }
	()
	{ after(grammarAccess.getXVariableDeclarationAccess().getXtendVariableDeclarationAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getVariableModifierParserRuleCall_0_0_1()); }
	ruleVariableModifier
	{ after(grammarAccess.getXVariableDeclarationAccess().getVariableModifierParserRuleCall_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XVariableDeclaration__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getGroup_1_0_0()); }
	(rule__XVariableDeclaration__Group_1_0_0__0)
	{ after(grammarAccess.getXVariableDeclarationAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XVariableDeclaration__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_1_0_0__0__Impl
	rule__XVariableDeclaration__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getTypeAssignment_1_0_0_0()); }
	(rule__XVariableDeclaration__TypeAssignment_1_0_0_0)
	{ after(grammarAccess.getXVariableDeclarationAccess().getTypeAssignment_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getNameAssignment_1_0_0_1()); }
	(rule__XVariableDeclaration__NameAssignment_1_0_0_1)
	{ after(grammarAccess.getXVariableDeclarationAccess().getNameAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XVariableDeclaration__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_2__0__Impl
	rule__XVariableDeclaration__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_2_0()); }
	'='
	{ after(grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XVariableDeclaration__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXVariableDeclarationAccess().getRightAssignment_2_1()); }
	(rule__XVariableDeclaration__RightAssignment_2_1)
	{ after(grammarAccess.getXVariableDeclarationAccess().getRightAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InitializedVariableDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group__0__Impl
	rule__InitializedVariableDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getXtendVariableDeclarationAction_0()); }
	()
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getXtendVariableDeclarationAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group__1__Impl
	rule__InitializedVariableDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getVariableModifierParserRuleCall_1()); }
	ruleVariableModifier
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getVariableModifierParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group__2__Impl
	rule__InitializedVariableDeclaration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getAlternatives_2()); }
	(rule__InitializedVariableDeclaration__Alternatives_2)
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group__3__Impl
	rule__InitializedVariableDeclaration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getEqualsSignKeyword_3()); }
	'='
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getEqualsSignKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getRightAssignment_4()); }
	(rule__InitializedVariableDeclaration__RightAssignment_4)
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getRightAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InitializedVariableDeclaration__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group_2_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getGroup_2_0_0()); }
	(rule__InitializedVariableDeclaration__Group_2_0_0__0)
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getGroup_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InitializedVariableDeclaration__Group_2_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group_2_0_0__0__Impl
	rule__InitializedVariableDeclaration__Group_2_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group_2_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getTypeAssignment_2_0_0_0()); }
	(rule__InitializedVariableDeclaration__TypeAssignment_2_0_0_0)
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getTypeAssignment_2_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group_2_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InitializedVariableDeclaration__Group_2_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__Group_2_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInitializedVariableDeclarationAccess().getNameAssignment_2_0_0_1()); }
	(rule__InitializedVariableDeclaration__NameAssignment_2_0_0_1)
	{ after(grammarAccess.getInitializedVariableDeclarationAccess().getNameAssignment_2_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VariableModifier__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableModifier__Group_0__0__Impl
	rule__VariableModifier__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableModifierAccess().getAlternatives_0_0()); }
	(rule__VariableModifier__Alternatives_0_0)
	{ after(grammarAccess.getVariableModifierAccess().getAlternatives_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableModifier__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableModifierAccess().getExtensionAssignment_0_1()); }
	(rule__VariableModifier__ExtensionAssignment_0_1)?
	{ after(grammarAccess.getVariableModifierAccess().getExtensionAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__VariableModifier__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableModifier__Group_1__0__Impl
	rule__VariableModifier__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableModifierAccess().getExtensionAssignment_1_0()); }
	(rule__VariableModifier__ExtensionAssignment_1_0)
	{ after(grammarAccess.getVariableModifierAccess().getExtensionAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__VariableModifier__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getVariableModifierAccess().getAlternatives_1_1()); }
	(rule__VariableModifier__Alternatives_1_1)
	{ after(grammarAccess.getVariableModifierAccess().getAlternatives_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConstructorCall__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group__0__Impl
	rule__XConstructorCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getXbaseConstructorCallParserRuleCall_0()); }
	ruleXbaseConstructorCall
	{ after(grammarAccess.getXConstructorCallAccess().getXbaseConstructorCallParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getGroup_1()); }
	(rule__XConstructorCall__Group_1__0)?
	{ after(grammarAccess.getXConstructorCallAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConstructorCall__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group_1__0__Impl
	rule__XConstructorCall__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getGroup_1_0()); }
	(rule__XConstructorCall__Group_1_0__0)
	{ after(grammarAccess.getXConstructorCallAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group_1__1__Impl
	rule__XConstructorCall__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getMembersAssignment_1_1()); }
	(rule__XConstructorCall__MembersAssignment_1_1)*
	{ after(grammarAccess.getXConstructorCallAccess().getMembersAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getRightCurlyBracketKeyword_1_2()); }
	'}'
	{ after(grammarAccess.getXConstructorCallAccess().getRightCurlyBracketKeyword_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConstructorCall__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getGroup_1_0_0()); }
	(rule__XConstructorCall__Group_1_0_0__0)
	{ after(grammarAccess.getXConstructorCallAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XConstructorCall__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group_1_0_0__0__Impl
	rule__XConstructorCall__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getAnonymousClassConstructorCallAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXConstructorCallAccess().getAnonymousClassConstructorCallAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XConstructorCall__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXConstructorCallAccess().getLeftCurlyBracketKeyword_1_0_0_1()); }
	'{'
	{ after(grammarAccess.getXConstructorCallAccess().getLeftCurlyBracketKeyword_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XbaseConstructorCall__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group__0__Impl
	rule__XbaseConstructorCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getXConstructorCallAction_0()); }
	()
	{ after(grammarAccess.getXbaseConstructorCallAccess().getXConstructorCallAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group__1__Impl
	rule__XbaseConstructorCall__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getNewKeyword_1()); }
	'new'
	{ after(grammarAccess.getXbaseConstructorCallAccess().getNewKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group__2__Impl
	rule__XbaseConstructorCall__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getConstructorAssignment_2()); }
	(rule__XbaseConstructorCall__ConstructorAssignment_2)
	{ after(grammarAccess.getXbaseConstructorCallAccess().getConstructorAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group__3__Impl
	rule__XbaseConstructorCall__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getGroup_3()); }
	(rule__XbaseConstructorCall__Group_3__0)?
	{ after(grammarAccess.getXbaseConstructorCallAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group__4__Impl
	rule__XbaseConstructorCall__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getGroup_4()); }
	(rule__XbaseConstructorCall__Group_4__0)?
	{ after(grammarAccess.getXbaseConstructorCallAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_5()); }
	(rule__XbaseConstructorCall__ArgumentsAssignment_5)?
	{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XbaseConstructorCall__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_3__0__Impl
	rule__XbaseConstructorCall__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getLessThanSignKeyword_3_0()); }
	('<')
	{ after(grammarAccess.getXbaseConstructorCallAccess().getLessThanSignKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_3__1__Impl
	rule__XbaseConstructorCall__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsAssignment_3_1()); }
	(rule__XbaseConstructorCall__TypeArgumentsAssignment_3_1)
	{ after(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_3__2__Impl
	rule__XbaseConstructorCall__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getGroup_3_2()); }
	(rule__XbaseConstructorCall__Group_3_2__0)*
	{ after(grammarAccess.getXbaseConstructorCallAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getGreaterThanSignKeyword_3_3()); }
	'>'
	{ after(grammarAccess.getXbaseConstructorCallAccess().getGreaterThanSignKeyword_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XbaseConstructorCall__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_3_2__0__Impl
	rule__XbaseConstructorCall__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getCommaKeyword_3_2_0()); }
	','
	{ after(grammarAccess.getXbaseConstructorCallAccess().getCommaKeyword_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsAssignment_3_2_1()); }
	(rule__XbaseConstructorCall__TypeArgumentsAssignment_3_2_1)
	{ after(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsAssignment_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XbaseConstructorCall__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_4__0__Impl
	rule__XbaseConstructorCall__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getExplicitConstructorCallAssignment_4_0()); }
	(rule__XbaseConstructorCall__ExplicitConstructorCallAssignment_4_0)
	{ after(grammarAccess.getXbaseConstructorCallAccess().getExplicitConstructorCallAssignment_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_4__1__Impl
	rule__XbaseConstructorCall__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getAlternatives_4_1()); }
	(rule__XbaseConstructorCall__Alternatives_4_1)?
	{ after(grammarAccess.getXbaseConstructorCallAccess().getAlternatives_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getRightParenthesisKeyword_4_2()); }
	')'
	{ after(grammarAccess.getXbaseConstructorCallAccess().getRightParenthesisKeyword_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XbaseConstructorCall__Group_4_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_4_1_1__0__Impl
	rule__XbaseConstructorCall__Group_4_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_4_1_1_0()); }
	(rule__XbaseConstructorCall__ArgumentsAssignment_4_1_1_0)
	{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_4_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_4_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getGroup_4_1_1_1()); }
	(rule__XbaseConstructorCall__Group_4_1_1_1__0)*
	{ after(grammarAccess.getXbaseConstructorCallAccess().getGroup_4_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XbaseConstructorCall__Group_4_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_4_1_1_1__0__Impl
	rule__XbaseConstructorCall__Group_4_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getCommaKeyword_4_1_1_1_0()); }
	','
	{ after(grammarAccess.getXbaseConstructorCallAccess().getCommaKeyword_4_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XbaseConstructorCall__Group_4_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__Group_4_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_4_1_1_1_1()); }
	(rule__XbaseConstructorCall__ArgumentsAssignment_4_1_1_1_1)
	{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsAssignment_4_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmFormalParameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmFormalParameter__Group__0__Impl
	rule__JvmFormalParameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmFormalParameterAccess().getExtensionAssignment_0()); }
	(rule__JvmFormalParameter__ExtensionAssignment_0)?
	{ after(grammarAccess.getJvmFormalParameterAccess().getExtensionAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmFormalParameter__Group__1__Impl
	rule__JvmFormalParameter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmFormalParameterAccess().getParameterTypeAssignment_1()); }
	(rule__JvmFormalParameter__ParameterTypeAssignment_1)?
	{ after(grammarAccess.getJvmFormalParameterAccess().getParameterTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmFormalParameter__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmFormalParameterAccess().getNameAssignment_2()); }
	(rule__JvmFormalParameter__NameAssignment_2)
	{ after(grammarAccess.getJvmFormalParameterAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FullJvmFormalParameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FullJvmFormalParameter__Group__0__Impl
	rule__FullJvmFormalParameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFullJvmFormalParameterAccess().getExtensionAssignment_0()); }
	(rule__FullJvmFormalParameter__ExtensionAssignment_0)?
	{ after(grammarAccess.getFullJvmFormalParameterAccess().getExtensionAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FullJvmFormalParameter__Group__1__Impl
	rule__FullJvmFormalParameter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeAssignment_1()); }
	(rule__FullJvmFormalParameter__ParameterTypeAssignment_1)
	{ after(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FullJvmFormalParameter__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFullJvmFormalParameterAccess().getNameAssignment_2()); }
	(rule__FullJvmFormalParameter__NameAssignment_2)
	{ after(grammarAccess.getFullJvmFormalParameterAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiTypeReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiTypeReference__Group__0__Impl
	rule__MultiTypeReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); }
	ruleJvmTypeReference
	{ after(grammarAccess.getMultiTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiTypeReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiTypeReferenceAccess().getGroup_1()); }
	(rule__MultiTypeReference__Group_1__0)?
	{ after(grammarAccess.getMultiTypeReferenceAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiTypeReference__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiTypeReference__Group_1__0__Impl
	rule__MultiTypeReference__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiTypeReferenceAccess().getJvmSynonymTypeReferenceReferencesAction_1_0()); }
	()
	{ after(grammarAccess.getMultiTypeReferenceAccess().getJvmSynonymTypeReferenceReferencesAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiTypeReference__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getMultiTypeReferenceAccess().getGroup_1_1()); }
		(rule__MultiTypeReference__Group_1_1__0)
		{ after(grammarAccess.getMultiTypeReferenceAccess().getGroup_1_1()); }
	)
	(
		{ before(grammarAccess.getMultiTypeReferenceAccess().getGroup_1_1()); }
		(rule__MultiTypeReference__Group_1_1__0)*
		{ after(grammarAccess.getMultiTypeReferenceAccess().getGroup_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MultiTypeReference__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiTypeReference__Group_1_1__0__Impl
	rule__MultiTypeReference__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiTypeReferenceAccess().getVerticalLineKeyword_1_1_0()); }
	'|'
	{ after(grammarAccess.getMultiTypeReferenceAccess().getVerticalLineKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MultiTypeReference__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMultiTypeReferenceAccess().getReferencesAssignment_1_1_1()); }
	(rule__MultiTypeReference__ReferencesAssignment_1_1_1)
	{ after(grammarAccess.getMultiTypeReferenceAccess().getReferencesAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group__0__Impl
	rule__XSwitchExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0()); }
	()
	{ after(grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group__1__Impl
	rule__XSwitchExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1()); }
	'switch'
	{ after(grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group__2__Impl
	rule__XSwitchExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getAlternatives_2()); }
	(rule__XSwitchExpression__Alternatives_2)
	{ after(grammarAccess.getXSwitchExpressionAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group__3__Impl
	rule__XSwitchExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group__4__Impl
	rule__XSwitchExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getCasesAssignment_4()); }
	(rule__XSwitchExpression__CasesAssignment_4)*
	{ after(grammarAccess.getXSwitchExpressionAccess().getCasesAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group__5__Impl
	rule__XSwitchExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getGroup_5()); }
	(rule__XSwitchExpression__Group_5__0)?
	{ after(grammarAccess.getXSwitchExpressionAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_0__0__Impl
	rule__XSwitchExpression__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0_0()); }
	(rule__XSwitchExpression__Group_2_0_0__0)
	{ after(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_0__1__Impl
	rule__XSwitchExpression__Group_2_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getSwitchAssignment_2_0_1()); }
	(rule__XSwitchExpression__SwitchAssignment_2_0_1)
	{ after(grammarAccess.getXSwitchExpressionAccess().getSwitchAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2()); }
	')'
	{ after(grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group_2_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_0_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0_0_0()); }
	(rule__XSwitchExpression__Group_2_0_0_0__0)
	{ after(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group_2_0_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_0_0_0__0__Impl
	rule__XSwitchExpression__Group_2_0_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0()); }
	'('
	{ after(grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_0_0_0__1__Impl
	rule__XSwitchExpression__Group_2_0_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_0_0_0_1()); }
	(rule__XSwitchExpression__DeclaredParamAssignment_2_0_0_0_1)
	{ after(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_0_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_0_0_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_0_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2()); }
	':'
	{ after(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_1__0__Impl
	rule__XSwitchExpression__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1_0()); }
	(rule__XSwitchExpression__Group_2_1_0__0)?
	{ after(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getSwitchAssignment_2_1_1()); }
	(rule__XSwitchExpression__SwitchAssignment_2_1_1)
	{ after(grammarAccess.getXSwitchExpressionAccess().getSwitchAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group_2_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1_0_0()); }
	(rule__XSwitchExpression__Group_2_1_0_0__0)
	{ after(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group_2_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_1_0_0__0__Impl
	rule__XSwitchExpression__Group_2_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_1_0_0_0()); }
	(rule__XSwitchExpression__DeclaredParamAssignment_2_1_0_0_0)
	{ after(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_2_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_2_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1()); }
	':'
	{ after(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSwitchExpression__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_5__0__Impl
	rule__XSwitchExpression__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0()); }
	'default'
	{ after(grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_5__1__Impl
	rule__XSwitchExpression__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1()); }
	':'
	{ after(grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSwitchExpression__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSwitchExpressionAccess().getDefaultAssignment_5_2()); }
	(rule__XSwitchExpression__DefaultAssignment_5_2)
	{ after(grammarAccess.getXSwitchExpressionAccess().getDefaultAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCasePart__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group__0__Impl
	rule__XCasePart__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getXCasePartAction_0()); }
	()
	{ after(grammarAccess.getXCasePartAccess().getXCasePartAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group__1__Impl
	rule__XCasePart__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getTypeGuardAssignment_1()); }
	(rule__XCasePart__TypeGuardAssignment_1)?
	{ after(grammarAccess.getXCasePartAccess().getTypeGuardAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group__2__Impl
	rule__XCasePart__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getGroup_2()); }
	(rule__XCasePart__Group_2__0)?
	{ after(grammarAccess.getXCasePartAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getAlternatives_3()); }
	(rule__XCasePart__Alternatives_3)
	{ after(grammarAccess.getXCasePartAccess().getAlternatives_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCasePart__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group_2__0__Impl
	rule__XCasePart__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getCaseKeyword_2_0()); }
	'case'
	{ after(grammarAccess.getXCasePartAccess().getCaseKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getCaseAssignment_2_1()); }
	(rule__XCasePart__CaseAssignment_2_1)
	{ after(grammarAccess.getXCasePartAccess().getCaseAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCasePart__Group_3_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group_3_0__0__Impl
	rule__XCasePart__Group_3_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group_3_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0()); }
	':'
	{ after(grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group_3_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCasePart__Group_3_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__Group_3_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCasePartAccess().getThenAssignment_3_0_1()); }
	(rule__XCasePart__ThenAssignment_3_0_1)
	{ after(grammarAccess.getXCasePartAccess().getThenAssignment_3_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__SimpleStringLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SimpleStringLiteral__Group__0__Impl
	rule__SimpleStringLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleStringLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSimpleStringLiteralAccess().getXStringLiteralAction_0()); }
	()
	{ after(grammarAccess.getSimpleStringLiteralAccess().getXStringLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleStringLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__SimpleStringLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleStringLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSimpleStringLiteralAccess().getValueAssignment_1()); }
	(rule__SimpleStringLiteral__ValueAssignment_1)
	{ after(grammarAccess.getSimpleStringLiteralAccess().getValueAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichString__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group__0__Impl
	rule__RichString__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getRichStringAction_0()); }
	()
	{ after(grammarAccess.getRichStringAccess().getRichStringAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getAlternatives_1()); }
	(rule__RichString__Alternatives_1)
	{ after(grammarAccess.getRichStringAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichString__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group_1_1__0__Impl
	rule__RichString__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_0()); }
	(rule__RichString__ExpressionsAssignment_1_1_0)
	{ after(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group_1_1__1__Impl
	rule__RichString__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_1()); }
	(rule__RichString__ExpressionsAssignment_1_1_1)?
	{ after(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group_1_1__2__Impl
	rule__RichString__Group_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getGroup_1_1_2()); }
	(rule__RichString__Group_1_1_2__0)*
	{ after(grammarAccess.getRichStringAccess().getGroup_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_3()); }
	(rule__RichString__ExpressionsAssignment_1_1_3)
	{ after(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichString__Group_1_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group_1_1_2__0__Impl
	rule__RichString__Group_1_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_2_0()); }
	(rule__RichString__ExpressionsAssignment_1_1_2_0)
	{ after(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichString__Group_1_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__Group_1_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_2_1()); }
	(rule__RichString__ExpressionsAssignment_1_1_2_1)?
	{ after(grammarAccess.getRichStringAccess().getExpressionsAssignment_1_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteral__Group__0__Impl
	rule__RichStringLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralAccess().getRichStringLiteralAction_0()); }
	()
	{ after(grammarAccess.getRichStringLiteralAccess().getRichStringLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralAccess().getValueAssignment_1()); }
	(rule__RichStringLiteral__ValueAssignment_1)
	{ after(grammarAccess.getRichStringLiteralAccess().getValueAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringLiteralStart__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteralStart__Group__0__Impl
	rule__RichStringLiteralStart__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralStart__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralStartAccess().getRichStringLiteralAction_0()); }
	()
	{ after(grammarAccess.getRichStringLiteralStartAccess().getRichStringLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralStart__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteralStart__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralStart__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralStartAccess().getValueAssignment_1()); }
	(rule__RichStringLiteralStart__ValueAssignment_1)
	{ after(grammarAccess.getRichStringLiteralStartAccess().getValueAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringLiteralInbetween__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteralInbetween__Group__0__Impl
	rule__RichStringLiteralInbetween__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralInbetween__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralInbetweenAccess().getRichStringLiteralAction_0()); }
	()
	{ after(grammarAccess.getRichStringLiteralInbetweenAccess().getRichStringLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralInbetween__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteralInbetween__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralInbetween__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralInbetweenAccess().getAlternatives_1()); }
	(rule__RichStringLiteralInbetween__Alternatives_1)
	{ after(grammarAccess.getRichStringLiteralInbetweenAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringLiteralEnd__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteralEnd__Group__0__Impl
	rule__RichStringLiteralEnd__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralEnd__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralEndAccess().getRichStringLiteralAction_0()); }
	()
	{ after(grammarAccess.getRichStringLiteralEndAccess().getRichStringLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralEnd__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringLiteralEnd__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralEnd__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringLiteralEndAccess().getAlternatives_1()); }
	(rule__RichStringLiteralEnd__Alternatives_1)
	{ after(grammarAccess.getRichStringLiteralEndAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InternalRichString__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InternalRichString__Group__0__Impl
	rule__InternalRichString__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInternalRichStringAccess().getRichStringAction_0()); }
	()
	{ after(grammarAccess.getInternalRichStringAccess().getRichStringAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InternalRichString__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInternalRichStringAccess().getGroup_1()); }
	(rule__InternalRichString__Group_1__0)
	{ after(grammarAccess.getInternalRichStringAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InternalRichString__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InternalRichString__Group_1__0__Impl
	rule__InternalRichString__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInternalRichStringAccess().getExpressionsAssignment_1_0()); }
	(rule__InternalRichString__ExpressionsAssignment_1_0)
	{ after(grammarAccess.getInternalRichStringAccess().getExpressionsAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InternalRichString__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInternalRichStringAccess().getGroup_1_1()); }
	(rule__InternalRichString__Group_1_1__0)*
	{ after(grammarAccess.getInternalRichStringAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__InternalRichString__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InternalRichString__Group_1_1__0__Impl
	rule__InternalRichString__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInternalRichStringAccess().getExpressionsAssignment_1_1_0()); }
	(rule__InternalRichString__ExpressionsAssignment_1_1_0)?
	{ after(grammarAccess.getInternalRichStringAccess().getExpressionsAssignment_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__InternalRichString__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInternalRichStringAccess().getExpressionsAssignment_1_1_1()); }
	(rule__InternalRichString__ExpressionsAssignment_1_1_1)
	{ after(grammarAccess.getInternalRichStringAccess().getExpressionsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringForLoop__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__0__Impl
	rule__RichStringForLoop__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getRichStringForLoopAction_0()); }
	()
	{ after(grammarAccess.getRichStringForLoopAccess().getRichStringForLoopAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__1__Impl
	rule__RichStringForLoop__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getFORKeyword_1()); }
	'FOR'
	{ after(grammarAccess.getRichStringForLoopAccess().getFORKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__2__Impl
	rule__RichStringForLoop__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getDeclaredParamAssignment_2()); }
	(rule__RichStringForLoop__DeclaredParamAssignment_2)
	{ after(grammarAccess.getRichStringForLoopAccess().getDeclaredParamAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__3__Impl
	rule__RichStringForLoop__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getColonKeyword_3()); }
	':'
	{ after(grammarAccess.getRichStringForLoopAccess().getColonKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__4__Impl
	rule__RichStringForLoop__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getForExpressionAssignment_4()); }
	(rule__RichStringForLoop__ForExpressionAssignment_4)
	{ after(grammarAccess.getRichStringForLoopAccess().getForExpressionAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__5__Impl
	rule__RichStringForLoop__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getGroup_5()); }
	(rule__RichStringForLoop__Group_5__0)?
	{ after(grammarAccess.getRichStringForLoopAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__6__Impl
	rule__RichStringForLoop__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getGroup_6()); }
	(rule__RichStringForLoop__Group_6__0)?
	{ after(grammarAccess.getRichStringForLoopAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__7__Impl
	rule__RichStringForLoop__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getGroup_7()); }
	(rule__RichStringForLoop__Group_7__0)?
	{ after(grammarAccess.getRichStringForLoopAccess().getGroup_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__8__Impl
	rule__RichStringForLoop__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getEachExpressionAssignment_8()); }
	(rule__RichStringForLoop__EachExpressionAssignment_8)
	{ after(grammarAccess.getRichStringForLoopAccess().getEachExpressionAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getENDFORKeyword_9()); }
	'ENDFOR'
	{ after(grammarAccess.getRichStringForLoopAccess().getENDFORKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringForLoop__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group_5__0__Impl
	rule__RichStringForLoop__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getBEFOREKeyword_5_0()); }
	'BEFORE'
	{ after(grammarAccess.getRichStringForLoopAccess().getBEFOREKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getBeforeAssignment_5_1()); }
	(rule__RichStringForLoop__BeforeAssignment_5_1)
	{ after(grammarAccess.getRichStringForLoopAccess().getBeforeAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringForLoop__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group_6__0__Impl
	rule__RichStringForLoop__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getSEPARATORKeyword_6_0()); }
	'SEPARATOR'
	{ after(grammarAccess.getRichStringForLoopAccess().getSEPARATORKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getSeparatorAssignment_6_1()); }
	(rule__RichStringForLoop__SeparatorAssignment_6_1)
	{ after(grammarAccess.getRichStringForLoopAccess().getSeparatorAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringForLoop__Group_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group_7__0__Impl
	rule__RichStringForLoop__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getAFTERKeyword_7_0()); }
	'AFTER'
	{ after(grammarAccess.getRichStringForLoopAccess().getAFTERKeyword_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringForLoop__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__Group_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringForLoopAccess().getAfterAssignment_7_1()); }
	(rule__RichStringForLoop__AfterAssignment_7_1)
	{ after(grammarAccess.getRichStringForLoopAccess().getAfterAssignment_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringIf__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group__0__Impl
	rule__RichStringIf__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getRichStringIfAction_0()); }
	()
	{ after(grammarAccess.getRichStringIfAccess().getRichStringIfAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group__1__Impl
	rule__RichStringIf__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getIFKeyword_1()); }
	'IF'
	{ after(grammarAccess.getRichStringIfAccess().getIFKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group__2__Impl
	rule__RichStringIf__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getIfAssignment_2()); }
	(rule__RichStringIf__IfAssignment_2)
	{ after(grammarAccess.getRichStringIfAccess().getIfAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group__3__Impl
	rule__RichStringIf__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getThenAssignment_3()); }
	(rule__RichStringIf__ThenAssignment_3)
	{ after(grammarAccess.getRichStringIfAccess().getThenAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group__4__Impl
	rule__RichStringIf__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getElseIfsAssignment_4()); }
	(rule__RichStringIf__ElseIfsAssignment_4)*
	{ after(grammarAccess.getRichStringIfAccess().getElseIfsAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group__5__Impl
	rule__RichStringIf__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getGroup_5()); }
	(rule__RichStringIf__Group_5__0)?
	{ after(grammarAccess.getRichStringIfAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getENDIFKeyword_6()); }
	'ENDIF'
	{ after(grammarAccess.getRichStringIfAccess().getENDIFKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringIf__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group_5__0__Impl
	rule__RichStringIf__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getELSEKeyword_5_0()); }
	'ELSE'
	{ after(grammarAccess.getRichStringIfAccess().getELSEKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringIf__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringIfAccess().getElseAssignment_5_1()); }
	(rule__RichStringIf__ElseAssignment_5_1)
	{ after(grammarAccess.getRichStringIfAccess().getElseAssignment_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RichStringElseIf__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringElseIf__Group__0__Impl
	rule__RichStringElseIf__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringElseIf__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringElseIfAccess().getELSEIFKeyword_0()); }
	'ELSEIF'
	{ after(grammarAccess.getRichStringElseIfAccess().getELSEIFKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringElseIf__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringElseIf__Group__1__Impl
	rule__RichStringElseIf__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringElseIf__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringElseIfAccess().getIfAssignment_1()); }
	(rule__RichStringElseIf__IfAssignment_1)
	{ after(grammarAccess.getRichStringElseIfAccess().getIfAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringElseIf__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RichStringElseIf__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringElseIf__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRichStringElseIfAccess().getThenAssignment_2()); }
	(rule__RichStringElseIf__ThenAssignment_2)
	{ after(grammarAccess.getRichStringElseIfAccess().getThenAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group__0__Impl
	rule__XAnnotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getXAnnotationAction_0()); }
	()
	{ after(grammarAccess.getXAnnotationAccess().getXAnnotationAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group__1__Impl
	rule__XAnnotation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getCommercialAtKeyword_1()); }
	'@'
	{ after(grammarAccess.getXAnnotationAccess().getCommercialAtKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group__2__Impl
	rule__XAnnotation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getAnnotationTypeAssignment_2()); }
	(rule__XAnnotation__AnnotationTypeAssignment_2)
	{ after(grammarAccess.getXAnnotationAccess().getAnnotationTypeAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getGroup_3()); }
	(rule__XAnnotation__Group_3__0)?
	{ after(grammarAccess.getXAnnotationAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotation__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group_3__0__Impl
	rule__XAnnotation__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0()); }
	('(')
	{ after(grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group_3__1__Impl
	rule__XAnnotation__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getAlternatives_3_1()); }
	(rule__XAnnotation__Alternatives_3_1)?
	{ after(grammarAccess.getXAnnotationAccess().getAlternatives_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2()); }
	')'
	{ after(grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotation__Group_3_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group_3_1_0__0__Impl
	rule__XAnnotation__Group_3_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getElementValuePairsAssignment_3_1_0_0()); }
	(rule__XAnnotation__ElementValuePairsAssignment_3_1_0_0)
	{ after(grammarAccess.getXAnnotationAccess().getElementValuePairsAssignment_3_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group_3_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getGroup_3_1_0_1()); }
	(rule__XAnnotation__Group_3_1_0_1__0)*
	{ after(grammarAccess.getXAnnotationAccess().getGroup_3_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotation__Group_3_1_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group_3_1_0_1__0__Impl
	rule__XAnnotation__Group_3_1_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3_1_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getCommaKeyword_3_1_0_1_0()); }
	','
	{ after(grammarAccess.getXAnnotationAccess().getCommaKeyword_3_1_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3_1_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotation__Group_3_1_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__Group_3_1_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationAccess().getElementValuePairsAssignment_3_1_0_1_1()); }
	(rule__XAnnotation__ElementValuePairsAssignment_3_1_0_1_1)
	{ after(grammarAccess.getXAnnotationAccess().getElementValuePairsAssignment_3_1_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValuePair__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValuePair__Group__0__Impl
	rule__XAnnotationElementValuePair__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValuePairAccess().getGroup_0()); }
	(rule__XAnnotationElementValuePair__Group_0__0)
	{ after(grammarAccess.getXAnnotationElementValuePairAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValuePair__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValuePairAccess().getValueAssignment_1()); }
	(rule__XAnnotationElementValuePair__ValueAssignment_1)
	{ after(grammarAccess.getXAnnotationElementValuePairAccess().getValueAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValuePair__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValuePair__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValuePairAccess().getGroup_0_0()); }
	(rule__XAnnotationElementValuePair__Group_0_0__0)
	{ after(grammarAccess.getXAnnotationElementValuePairAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValuePair__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValuePair__Group_0_0__0__Impl
	rule__XAnnotationElementValuePair__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValuePairAccess().getElementAssignment_0_0_0()); }
	(rule__XAnnotationElementValuePair__ElementAssignment_0_0_0)
	{ after(grammarAccess.getXAnnotationElementValuePairAccess().getElementAssignment_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValuePair__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValuePairAccess().getEqualsSignKeyword_0_0_1()); }
	'='
	{ after(grammarAccess.getXAnnotationElementValuePairAccess().getEqualsSignKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0__0__Impl
	rule__XAnnotationElementValueOrCommaList__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_0()); }
	(rule__XAnnotationElementValueOrCommaList__Group_0_0__0)
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0__1__Impl
	rule__XAnnotationElementValueOrCommaList__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_1()); }
	(rule__XAnnotationElementValueOrCommaList__Group_0_1__0)?
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getRightSquareBracketKeyword_0_2()); }
	']'
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getRightSquareBracketKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_0_0()); }
	(rule__XAnnotationElementValueOrCommaList__Group_0_0_0__0)
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_0_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_0_0__0__Impl
	rule__XAnnotationElementValueOrCommaList__Group_0_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralAction_0_0_0_0()); }
	()
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralAction_0_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_0_0__1__Impl
	rule__XAnnotationElementValueOrCommaList__Group_0_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getNumberSignKeyword_0_0_0_1()); }
	'#'
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getNumberSignKeyword_0_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_0_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getLeftSquareBracketKeyword_0_0_0_2()); }
	'['
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getLeftSquareBracketKeyword_0_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_1__0__Impl
	rule__XAnnotationElementValueOrCommaList__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_0_1_0()); }
	(rule__XAnnotationElementValueOrCommaList__ElementsAssignment_0_1_0)
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_1_1()); }
	(rule__XAnnotationElementValueOrCommaList__Group_0_1_1__0)*
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_0_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_1_1__0__Impl
	rule__XAnnotationElementValueOrCommaList__Group_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_0_1_1_0()); }
	','
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_0_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_0_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_0_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_0_1_1_1()); }
	(rule__XAnnotationElementValueOrCommaList__ElementsAssignment_0_1_1_1)
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_0_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_1__0__Impl
	rule__XAnnotationElementValueOrCommaList__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXAnnotationOrExpressionParserRuleCall_1_0()); }
	ruleXAnnotationOrExpression
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXAnnotationOrExpressionParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1()); }
	(rule__XAnnotationElementValueOrCommaList__Group_1_1__0)?
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_1_1__0__Impl
	rule__XAnnotationElementValueOrCommaList__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()); }
	()
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1_1()); }
		(rule__XAnnotationElementValueOrCommaList__Group_1_1_1__0)
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1_1()); }
	)
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1_1()); }
		(rule__XAnnotationElementValueOrCommaList__Group_1_1_1__0)*
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValueOrCommaList__Group_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_1_1_1__0__Impl
	rule__XAnnotationElementValueOrCommaList__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_1_1_1_0()); }
	','
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getCommaKeyword_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValueOrCommaList__Group_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__Group_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_1_1_1_1()); }
	(rule__XAnnotationElementValueOrCommaList__ElementsAssignment_1_1_1_1)
	{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValue__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0__0__Impl
	rule__XAnnotationElementValue__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_0()); }
	(rule__XAnnotationElementValue__Group_0_0__0)
	{ after(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0__1__Impl
	rule__XAnnotationElementValue__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_1()); }
	(rule__XAnnotationElementValue__Group_0_1__0)?
	{ after(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getRightSquareBracketKeyword_0_2()); }
	']'
	{ after(grammarAccess.getXAnnotationElementValueAccess().getRightSquareBracketKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValue__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_0_0()); }
	(rule__XAnnotationElementValue__Group_0_0_0__0)
	{ after(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValue__Group_0_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_0_0__0__Impl
	rule__XAnnotationElementValue__Group_0_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getXListLiteralAction_0_0_0_0()); }
	()
	{ after(grammarAccess.getXAnnotationElementValueAccess().getXListLiteralAction_0_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_0_0__1__Impl
	rule__XAnnotationElementValue__Group_0_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getNumberSignKeyword_0_0_0_1()); }
	'#'
	{ after(grammarAccess.getXAnnotationElementValueAccess().getNumberSignKeyword_0_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_0_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getLeftSquareBracketKeyword_0_0_0_2()); }
	'['
	{ after(grammarAccess.getXAnnotationElementValueAccess().getLeftSquareBracketKeyword_0_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValue__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_1__0__Impl
	rule__XAnnotationElementValue__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getElementsAssignment_0_1_0()); }
	(rule__XAnnotationElementValue__ElementsAssignment_0_1_0)
	{ after(grammarAccess.getXAnnotationElementValueAccess().getElementsAssignment_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_1_1()); }
	(rule__XAnnotationElementValue__Group_0_1_1__0)*
	{ after(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAnnotationElementValue__Group_0_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_1_1__0__Impl
	rule__XAnnotationElementValue__Group_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getCommaKeyword_0_1_1_0()); }
	','
	{ after(grammarAccess.getXAnnotationElementValueAccess().getCommaKeyword_0_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAnnotationElementValue__Group_0_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__Group_0_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAnnotationElementValueAccess().getElementsAssignment_0_1_1_1()); }
	(rule__XAnnotationElementValue__ElementsAssignment_0_1_1_1)
	{ after(grammarAccess.getXAnnotationElementValueAccess().getElementsAssignment_0_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpMultiAssign__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpMultiAssign__Group_5__0__Impl
	rule__OpMultiAssign__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0()); }
	'<'
	{ after(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpMultiAssign__Group_5__1__Impl
	rule__OpMultiAssign__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_1()); }
	'<'
	{ after(grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpMultiAssign__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_5_2()); }
	'='
	{ after(grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpMultiAssign__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpMultiAssign__Group_6__0__Impl
	rule__OpMultiAssign__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0()); }
	'>'
	{ after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpMultiAssign__Group_6__1__Impl
	rule__OpMultiAssign__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1()); }
	('>')?
	{ after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpMultiAssign__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpMultiAssign__Group_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2()); }
	'>='
	{ after(grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOrExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOrExpression__Group__0__Impl
	rule__XOrExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); }
	ruleXAndExpression
	{ after(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOrExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOrExpressionAccess().getGroup_1()); }
	(rule__XOrExpression__Group_1__0)*
	{ after(grammarAccess.getXOrExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOrExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOrExpression__Group_1__0__Impl
	rule__XOrExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOrExpressionAccess().getGroup_1_0()); }
	(rule__XOrExpression__Group_1_0__0)
	{ after(grammarAccess.getXOrExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOrExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOrExpressionAccess().getRightOperandAssignment_1_1()); }
	(rule__XOrExpression__RightOperandAssignment_1_1)
	{ after(grammarAccess.getXOrExpressionAccess().getRightOperandAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOrExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOrExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOrExpressionAccess().getGroup_1_0_0()); }
	(rule__XOrExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXOrExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOrExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOrExpression__Group_1_0_0__0__Impl
	rule__XOrExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOrExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOrExpressionAccess().getFeatureAssignment_1_0_0_1()); }
	(rule__XOrExpression__FeatureAssignment_1_0_0_1)
	{ after(grammarAccess.getXOrExpressionAccess().getFeatureAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAndExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAndExpression__Group__0__Impl
	rule__XAndExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); }
	ruleXEqualityExpression
	{ after(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAndExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAndExpressionAccess().getGroup_1()); }
	(rule__XAndExpression__Group_1__0)*
	{ after(grammarAccess.getXAndExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAndExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAndExpression__Group_1__0__Impl
	rule__XAndExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAndExpressionAccess().getGroup_1_0()); }
	(rule__XAndExpression__Group_1_0__0)
	{ after(grammarAccess.getXAndExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAndExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAndExpressionAccess().getRightOperandAssignment_1_1()); }
	(rule__XAndExpression__RightOperandAssignment_1_1)
	{ after(grammarAccess.getXAndExpressionAccess().getRightOperandAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAndExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAndExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAndExpressionAccess().getGroup_1_0_0()); }
	(rule__XAndExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXAndExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAndExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAndExpression__Group_1_0_0__0__Impl
	rule__XAndExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAndExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAndExpressionAccess().getFeatureAssignment_1_0_0_1()); }
	(rule__XAndExpression__FeatureAssignment_1_0_0_1)
	{ after(grammarAccess.getXAndExpressionAccess().getFeatureAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XEqualityExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XEqualityExpression__Group__0__Impl
	rule__XEqualityExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); }
	ruleXRelationalExpression
	{ after(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XEqualityExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXEqualityExpressionAccess().getGroup_1()); }
	(rule__XEqualityExpression__Group_1__0)*
	{ after(grammarAccess.getXEqualityExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XEqualityExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XEqualityExpression__Group_1__0__Impl
	rule__XEqualityExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXEqualityExpressionAccess().getGroup_1_0()); }
	(rule__XEqualityExpression__Group_1_0__0)
	{ after(grammarAccess.getXEqualityExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XEqualityExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXEqualityExpressionAccess().getRightOperandAssignment_1_1()); }
	(rule__XEqualityExpression__RightOperandAssignment_1_1)
	{ after(grammarAccess.getXEqualityExpressionAccess().getRightOperandAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XEqualityExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XEqualityExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXEqualityExpressionAccess().getGroup_1_0_0()); }
	(rule__XEqualityExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXEqualityExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XEqualityExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XEqualityExpression__Group_1_0_0__0__Impl
	rule__XEqualityExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XEqualityExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXEqualityExpressionAccess().getFeatureAssignment_1_0_0_1()); }
	(rule__XEqualityExpression__FeatureAssignment_1_0_0_1)
	{ after(grammarAccess.getXEqualityExpressionAccess().getFeatureAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XRelationalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group__0__Impl
	rule__XRelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); }
	ruleXOtherOperatorExpression
	{ after(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getAlternatives_1()); }
	(rule__XRelationalExpression__Alternatives_1)*
	{ after(grammarAccess.getXRelationalExpressionAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XRelationalExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_0__0__Impl
	rule__XRelationalExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0_0()); }
	(rule__XRelationalExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getTypeAssignment_1_0_1()); }
	(rule__XRelationalExpression__TypeAssignment_1_0_1)
	{ after(grammarAccess.getXRelationalExpressionAccess().getTypeAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XRelationalExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_0_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0_0_0()); }
	(rule__XRelationalExpression__Group_1_0_0_0__0)
	{ after(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XRelationalExpression__Group_1_0_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_0_0_0__0__Impl
	rule__XRelationalExpression__Group_1_0_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_0_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()); }
	()
	{ after(grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_0_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_0_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_0_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1()); }
	'instanceof'
	{ after(grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XRelationalExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_1__0__Impl
	rule__XRelationalExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1_0()); }
	(rule__XRelationalExpression__Group_1_1_0__0)
	{ after(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getRightOperandAssignment_1_1_1()); }
	(rule__XRelationalExpression__RightOperandAssignment_1_1_1)
	{ after(grammarAccess.getXRelationalExpressionAccess().getRightOperandAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XRelationalExpression__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1_0_0()); }
	(rule__XRelationalExpression__Group_1_1_0_0__0)
	{ after(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XRelationalExpression__Group_1_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_1_0_0__0__Impl
	rule__XRelationalExpression__Group_1_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()); }
	()
	{ after(grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XRelationalExpression__Group_1_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__Group_1_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXRelationalExpressionAccess().getFeatureAssignment_1_1_0_0_1()); }
	(rule__XRelationalExpression__FeatureAssignment_1_1_0_0_1)
	{ after(grammarAccess.getXRelationalExpressionAccess().getFeatureAssignment_1_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpCompare__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpCompare__Group_1__0__Impl
	rule__OpCompare__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpCompare__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); }
	'<'
	{ after(grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpCompare__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpCompare__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpCompare__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); }
	'='
	{ after(grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOtherOperatorExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOtherOperatorExpression__Group__0__Impl
	rule__XOtherOperatorExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); }
	ruleXAdditiveExpression
	{ after(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOtherOperatorExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1()); }
	(rule__XOtherOperatorExpression__Group_1__0)*
	{ after(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOtherOperatorExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOtherOperatorExpression__Group_1__0__Impl
	rule__XOtherOperatorExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1_0()); }
	(rule__XOtherOperatorExpression__Group_1_0__0)
	{ after(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOtherOperatorExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandAssignment_1_1()); }
	(rule__XOtherOperatorExpression__RightOperandAssignment_1_1)
	{ after(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOtherOperatorExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOtherOperatorExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1_0_0()); }
	(rule__XOtherOperatorExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XOtherOperatorExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOtherOperatorExpression__Group_1_0_0__0__Impl
	rule__XOtherOperatorExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XOtherOperatorExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1()); }
	(rule__XOtherOperatorExpression__FeatureAssignment_1_0_0_1)
	{ after(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpOther__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_2__0__Impl
	rule__OpOther__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); }
	'>'
	{ after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); }
	'..'
	{ after(grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpOther__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_5__0__Impl
	rule__OpOther__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); }
	'>'
	{ after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_5__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getAlternatives_5_1()); }
	(rule__OpOther__Alternatives_5_1)
	{ after(grammarAccess.getOpOtherAccess().getAlternatives_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpOther__Group_5_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_5_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_5_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getGroup_5_1_0_0()); }
	(rule__OpOther__Group_5_1_0_0__0)
	{ after(grammarAccess.getOpOtherAccess().getGroup_5_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpOther__Group_5_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_5_1_0_0__0__Impl
	rule__OpOther__Group_5_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_5_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); }
	'>'
	{ after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_5_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_5_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_5_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); }
	'>'
	{ after(grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpOther__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_6__0__Impl
	rule__OpOther__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); }
	'<'
	{ after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getAlternatives_6_1()); }
	(rule__OpOther__Alternatives_6_1)
	{ after(grammarAccess.getOpOtherAccess().getAlternatives_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpOther__Group_6_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_6_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_6_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getGroup_6_1_0_0()); }
	(rule__OpOther__Group_6_1_0_0__0)
	{ after(grammarAccess.getOpOtherAccess().getGroup_6_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OpOther__Group_6_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_6_1_0_0__0__Impl
	rule__OpOther__Group_6_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_6_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); }
	'<'
	{ after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_6_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OpOther__Group_6_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OpOther__Group_6_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); }
	'<'
	{ after(grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAdditiveExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAdditiveExpression__Group__0__Impl
	rule__XAdditiveExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); }
	ruleXMultiplicativeExpression
	{ after(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAdditiveExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAdditiveExpressionAccess().getGroup_1()); }
	(rule__XAdditiveExpression__Group_1__0)*
	{ after(grammarAccess.getXAdditiveExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAdditiveExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAdditiveExpression__Group_1__0__Impl
	rule__XAdditiveExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAdditiveExpressionAccess().getGroup_1_0()); }
	(rule__XAdditiveExpression__Group_1_0__0)
	{ after(grammarAccess.getXAdditiveExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAdditiveExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAdditiveExpressionAccess().getRightOperandAssignment_1_1()); }
	(rule__XAdditiveExpression__RightOperandAssignment_1_1)
	{ after(grammarAccess.getXAdditiveExpressionAccess().getRightOperandAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAdditiveExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAdditiveExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAdditiveExpressionAccess().getGroup_1_0_0()); }
	(rule__XAdditiveExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXAdditiveExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XAdditiveExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAdditiveExpression__Group_1_0_0__0__Impl
	rule__XAdditiveExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XAdditiveExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1()); }
	(rule__XAdditiveExpression__FeatureAssignment_1_0_0_1)
	{ after(grammarAccess.getXAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMultiplicativeExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMultiplicativeExpression__Group__0__Impl
	rule__XMultiplicativeExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); }
	ruleXUnaryOperation
	{ after(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMultiplicativeExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1()); }
	(rule__XMultiplicativeExpression__Group_1__0)*
	{ after(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMultiplicativeExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMultiplicativeExpression__Group_1__0__Impl
	rule__XMultiplicativeExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1_0()); }
	(rule__XMultiplicativeExpression__Group_1_0__0)
	{ after(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMultiplicativeExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandAssignment_1_1()); }
	(rule__XMultiplicativeExpression__RightOperandAssignment_1_1)
	{ after(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMultiplicativeExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMultiplicativeExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1_0_0()); }
	(rule__XMultiplicativeExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMultiplicativeExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMultiplicativeExpression__Group_1_0_0__0__Impl
	rule__XMultiplicativeExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMultiplicativeExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1()); }
	(rule__XMultiplicativeExpression__FeatureAssignment_1_0_0_1)
	{ after(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XUnaryOperation__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XUnaryOperation__Group_0__0__Impl
	rule__XUnaryOperation__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0()); }
	()
	{ after(grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XUnaryOperation__Group_0__1__Impl
	rule__XUnaryOperation__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXUnaryOperationAccess().getFeatureAssignment_0_1()); }
	(rule__XUnaryOperation__FeatureAssignment_0_1)
	{ after(grammarAccess.getXUnaryOperationAccess().getFeatureAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XUnaryOperation__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXUnaryOperationAccess().getOperandAssignment_0_2()); }
	(rule__XUnaryOperation__OperandAssignment_0_2)
	{ after(grammarAccess.getXUnaryOperationAccess().getOperandAssignment_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCastedExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCastedExpression__Group__0__Impl
	rule__XCastedExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0()); }
	ruleXPostfixOperation
	{ after(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCastedExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCastedExpressionAccess().getGroup_1()); }
	(rule__XCastedExpression__Group_1__0)*
	{ after(grammarAccess.getXCastedExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCastedExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCastedExpression__Group_1__0__Impl
	rule__XCastedExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCastedExpressionAccess().getGroup_1_0()); }
	(rule__XCastedExpression__Group_1_0__0)
	{ after(grammarAccess.getXCastedExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCastedExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCastedExpressionAccess().getTypeAssignment_1_1()); }
	(rule__XCastedExpression__TypeAssignment_1_1)
	{ after(grammarAccess.getXCastedExpressionAccess().getTypeAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCastedExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCastedExpression__Group_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCastedExpressionAccess().getGroup_1_0_0()); }
	(rule__XCastedExpression__Group_1_0_0__0)
	{ after(grammarAccess.getXCastedExpressionAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCastedExpression__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCastedExpression__Group_1_0_0__0__Impl
	rule__XCastedExpression__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()); }
	()
	{ after(grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCastedExpression__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1()); }
	'as'
	{ after(grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XPostfixOperation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XPostfixOperation__Group__0__Impl
	rule__XPostfixOperation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0()); }
	ruleXMemberFeatureCall
	{ after(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XPostfixOperation__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXPostfixOperationAccess().getGroup_1()); }
	(rule__XPostfixOperation__Group_1__0)?
	{ after(grammarAccess.getXPostfixOperationAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XPostfixOperation__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XPostfixOperation__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXPostfixOperationAccess().getGroup_1_0()); }
	(rule__XPostfixOperation__Group_1_0__0)
	{ after(grammarAccess.getXPostfixOperationAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XPostfixOperation__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XPostfixOperation__Group_1_0__0__Impl
	rule__XPostfixOperation__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()); }
	()
	{ after(grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XPostfixOperation__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXPostfixOperationAccess().getFeatureAssignment_1_0_1()); }
	(rule__XPostfixOperation__FeatureAssignment_1_0_1)
	{ after(grammarAccess.getXPostfixOperationAccess().getFeatureAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group__0__Impl
	rule__XMemberFeatureCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); }
	ruleXPrimaryExpression
	{ after(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1()); }
	(rule__XMemberFeatureCall__Alternatives_1)*
	{ after(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_0__0__Impl
	rule__XMemberFeatureCall__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0_0()); }
	(rule__XMemberFeatureCall__Group_1_0_0__0)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getValueAssignment_1_0_1()); }
	(rule__XMemberFeatureCall__ValueAssignment_1_0_1)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getValueAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_0_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0_0_0()); }
	(rule__XMemberFeatureCall__Group_1_0_0_0__0)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_0_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_0_0_0__0__Impl
	rule__XMemberFeatureCall__Group_1_0_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()); }
	()
	{ after(grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_0_0_0__1__Impl
	rule__XMemberFeatureCall__Group_1_0_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_0_0_0_1()); }
	(rule__XMemberFeatureCall__Alternatives_1_0_0_0_1)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_0_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_0_0_0__2__Impl
	rule__XMemberFeatureCall__Group_1_0_0_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_0_0_0_2()); }
	(rule__XMemberFeatureCall__FeatureAssignment_1_0_0_0_2)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_0_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_0_0_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_0_0_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); }
	ruleOpSingleAssign
	{ after(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1__0__Impl
	rule__XMemberFeatureCall__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_0()); }
	(rule__XMemberFeatureCall__Group_1_1_0__0)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1__1__Impl
	rule__XMemberFeatureCall__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_1()); }
	(rule__XMemberFeatureCall__Group_1_1_1__0)?
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1__2__Impl
	rule__XMemberFeatureCall__Group_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_1_2()); }
	(rule__XMemberFeatureCall__FeatureAssignment_1_1_2)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1__3__Impl
	rule__XMemberFeatureCall__Group_1_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3()); }
	(rule__XMemberFeatureCall__Group_1_1_3__0)?
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_4()); }
	(rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_4)?
	{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_0_0()); }
	(rule__XMemberFeatureCall__Group_1_1_0_0__0)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_0_0__0__Impl
	rule__XMemberFeatureCall__Group_1_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()); }
	()
	{ after(grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_1_0_0_1()); }
	(rule__XMemberFeatureCall__Alternatives_1_1_0_0_1)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_1__0__Impl
	rule__XMemberFeatureCall__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0()); }
	'<'
	{ after(grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_1__1__Impl
	rule__XMemberFeatureCall__Group_1_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_1()); }
	(rule__XMemberFeatureCall__TypeArgumentsAssignment_1_1_1_1)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_1__2__Impl
	rule__XMemberFeatureCall__Group_1_1_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_1_2()); }
	(rule__XMemberFeatureCall__Group_1_1_1_2__0)*
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3()); }
	'>'
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_1_2__0__Impl
	rule__XMemberFeatureCall__Group_1_1_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0()); }
	','
	{ after(grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_2_1()); }
	(rule__XMemberFeatureCall__TypeArgumentsAssignment_1_1_1_2_1)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_3__0__Impl
	rule__XMemberFeatureCall__Group_1_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallAssignment_1_1_3_0()); }
	(rule__XMemberFeatureCall__ExplicitOperationCallAssignment_1_1_3_0)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallAssignment_1_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_3__1__Impl
	rule__XMemberFeatureCall__Group_1_1_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_1_3_1()); }
	(rule__XMemberFeatureCall__Alternatives_1_1_3_1)?
	{ after(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2()); }
	')'
	{ after(grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1_3_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_3_1_1__0__Impl
	rule__XMemberFeatureCall__Group_1_1_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_0()); }
	(rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_1_0)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1_1()); }
	(rule__XMemberFeatureCall__Group_1_1_3_1_1_1__0)*
	{ after(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XMemberFeatureCall__Group_1_1_3_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_3_1_1_1__0__Impl
	rule__XMemberFeatureCall__Group_1_1_3_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0()); }
	','
	{ after(grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XMemberFeatureCall__Group_1_1_3_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__Group_1_1_3_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_1_1()); }
	(rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_1_1_1)
	{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSetLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group__0__Impl
	rule__XSetLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0()); }
	()
	{ after(grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group__1__Impl
	rule__XSetLiteral__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1()); }
	'#'
	{ after(grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group__2__Impl
	rule__XSetLiteral__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group__3__Impl
	rule__XSetLiteral__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getGroup_3()); }
	(rule__XSetLiteral__Group_3__0)?
	{ after(grammarAccess.getXSetLiteralAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4()); }
	'}'
	{ after(grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSetLiteral__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group_3__0__Impl
	rule__XSetLiteral__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getElementsAssignment_3_0()); }
	(rule__XSetLiteral__ElementsAssignment_3_0)
	{ after(grammarAccess.getXSetLiteralAccess().getElementsAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getGroup_3_1()); }
	(rule__XSetLiteral__Group_3_1__0)*
	{ after(grammarAccess.getXSetLiteralAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSetLiteral__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group_3_1__0__Impl
	rule__XSetLiteral__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0()); }
	','
	{ after(grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSetLiteral__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSetLiteralAccess().getElementsAssignment_3_1_1()); }
	(rule__XSetLiteral__ElementsAssignment_3_1_1)
	{ after(grammarAccess.getXSetLiteralAccess().getElementsAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XListLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group__0__Impl
	rule__XListLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getXListLiteralAction_0()); }
	()
	{ after(grammarAccess.getXListLiteralAccess().getXListLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group__1__Impl
	rule__XListLiteral__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1()); }
	'#'
	{ after(grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group__2__Impl
	rule__XListLiteral__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2()); }
	'['
	{ after(grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group__3__Impl
	rule__XListLiteral__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getGroup_3()); }
	(rule__XListLiteral__Group_3__0)?
	{ after(grammarAccess.getXListLiteralAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4()); }
	']'
	{ after(grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XListLiteral__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group_3__0__Impl
	rule__XListLiteral__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getElementsAssignment_3_0()); }
	(rule__XListLiteral__ElementsAssignment_3_0)
	{ after(grammarAccess.getXListLiteralAccess().getElementsAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getGroup_3_1()); }
	(rule__XListLiteral__Group_3_1__0)*
	{ after(grammarAccess.getXListLiteralAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XListLiteral__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group_3_1__0__Impl
	rule__XListLiteral__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0()); }
	','
	{ after(grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XListLiteral__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXListLiteralAccess().getElementsAssignment_3_1_1()); }
	(rule__XListLiteral__ElementsAssignment_3_1_1)
	{ after(grammarAccess.getXListLiteralAccess().getElementsAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XClosure__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group__0__Impl
	rule__XClosure__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getGroup_0()); }
	(rule__XClosure__Group_0__0)
	{ after(grammarAccess.getXClosureAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group__1__Impl
	rule__XClosure__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getGroup_1()); }
	(rule__XClosure__Group_1__0)?
	{ after(grammarAccess.getXClosureAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group__2__Impl
	rule__XClosure__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getExpressionAssignment_2()); }
	(rule__XClosure__ExpressionAssignment_2)
	{ after(grammarAccess.getXClosureAccess().getExpressionAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3()); }
	']'
	{ after(grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XClosure__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getGroup_0_0()); }
	(rule__XClosure__Group_0_0__0)
	{ after(grammarAccess.getXClosureAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XClosure__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_0_0__0__Impl
	rule__XClosure__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getXClosureAction_0_0_0()); }
	()
	{ after(grammarAccess.getXClosureAccess().getXClosureAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1()); }
	'['
	{ after(grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XClosure__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getGroup_1_0()); }
	(rule__XClosure__Group_1_0__0)
	{ after(grammarAccess.getXClosureAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XClosure__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_1_0__0__Impl
	rule__XClosure__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getGroup_1_0_0()); }
	(rule__XClosure__Group_1_0_0__0)?
	{ after(grammarAccess.getXClosureAccess().getGroup_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getExplicitSyntaxAssignment_1_0_1()); }
	(rule__XClosure__ExplicitSyntaxAssignment_1_0_1)
	{ after(grammarAccess.getXClosureAccess().getExplicitSyntaxAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XClosure__Group_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_1_0_0__0__Impl
	rule__XClosure__Group_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_0()); }
	(rule__XClosure__DeclaredFormalParametersAssignment_1_0_0_0)
	{ after(grammarAccess.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getGroup_1_0_0_1()); }
	(rule__XClosure__Group_1_0_0_1__0)*
	{ after(grammarAccess.getXClosureAccess().getGroup_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XClosure__Group_1_0_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_1_0_0_1__0__Impl
	rule__XClosure__Group_1_0_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0()); }
	','
	{ after(grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XClosure__Group_1_0_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__Group_1_0_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_1_1()); }
	(rule__XClosure__DeclaredFormalParametersAssignment_1_0_0_1_1)
	{ after(grammarAccess.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XExpressionInClosure__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XExpressionInClosure__Group__0__Impl
	rule__XExpressionInClosure__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionInClosure__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0()); }
	()
	{ after(grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionInClosure__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XExpressionInClosure__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionInClosure__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXExpressionInClosureAccess().getGroup_1()); }
	(rule__XExpressionInClosure__Group_1__0)*
	{ after(grammarAccess.getXExpressionInClosureAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XExpressionInClosure__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XExpressionInClosure__Group_1__0__Impl
	rule__XExpressionInClosure__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionInClosure__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXExpressionInClosureAccess().getExpressionsAssignment_1_0()); }
	(rule__XExpressionInClosure__ExpressionsAssignment_1_0)
	{ after(grammarAccess.getXExpressionInClosureAccess().getExpressionsAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionInClosure__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XExpressionInClosure__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionInClosure__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1()); }
	(';')?
	{ after(grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XShortClosure__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group__0__Impl
	rule__XShortClosure__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getGroup_0()); }
	(rule__XShortClosure__Group_0__0)
	{ after(grammarAccess.getXShortClosureAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getExpressionAssignment_1()); }
	(rule__XShortClosure__ExpressionAssignment_1)
	{ after(grammarAccess.getXShortClosureAccess().getExpressionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XShortClosure__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getGroup_0_0()); }
	(rule__XShortClosure__Group_0_0__0)
	{ after(grammarAccess.getXShortClosureAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XShortClosure__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0_0__0__Impl
	rule__XShortClosure__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0()); }
	()
	{ after(grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0_0__1__Impl
	rule__XShortClosure__Group_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getGroup_0_0_1()); }
	(rule__XShortClosure__Group_0_0_1__0)?
	{ after(grammarAccess.getXShortClosureAccess().getGroup_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getExplicitSyntaxAssignment_0_0_2()); }
	(rule__XShortClosure__ExplicitSyntaxAssignment_0_0_2)
	{ after(grammarAccess.getXShortClosureAccess().getExplicitSyntaxAssignment_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XShortClosure__Group_0_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0_0_1__0__Impl
	rule__XShortClosure__Group_0_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_0()); }
	(rule__XShortClosure__DeclaredFormalParametersAssignment_0_0_1_0)
	{ after(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getGroup_0_0_1_1()); }
	(rule__XShortClosure__Group_0_0_1_1__0)*
	{ after(grammarAccess.getXShortClosureAccess().getGroup_0_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XShortClosure__Group_0_0_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0_0_1_1__0__Impl
	rule__XShortClosure__Group_0_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0()); }
	','
	{ after(grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XShortClosure__Group_0_0_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__Group_0_0_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_1_1()); }
	(rule__XShortClosure__DeclaredFormalParametersAssignment_0_0_1_1_1)
	{ after(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XParenthesizedExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XParenthesizedExpression__Group__0__Impl
	rule__XParenthesizedExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XParenthesizedExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); }
	'('
	{ after(grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XParenthesizedExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XParenthesizedExpression__Group__1__Impl
	rule__XParenthesizedExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XParenthesizedExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); }
	ruleXExpression
	{ after(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XParenthesizedExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XParenthesizedExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XParenthesizedExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XIfExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group__0__Impl
	rule__XIfExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0()); }
	()
	{ after(grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group__1__Impl
	rule__XIfExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getIfKeyword_1()); }
	'if'
	{ after(grammarAccess.getXIfExpressionAccess().getIfKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group__2__Impl
	rule__XIfExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group__3__Impl
	rule__XIfExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getIfAssignment_3()); }
	(rule__XIfExpression__IfAssignment_3)
	{ after(grammarAccess.getXIfExpressionAccess().getIfAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group__4__Impl
	rule__XIfExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group__5__Impl
	rule__XIfExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getThenAssignment_5()); }
	(rule__XIfExpression__ThenAssignment_5)
	{ after(grammarAccess.getXIfExpressionAccess().getThenAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getGroup_6()); }
	(rule__XIfExpression__Group_6__0)?
	{ after(grammarAccess.getXIfExpressionAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XIfExpression__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group_6__0__Impl
	rule__XIfExpression__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0()); }
	('else')
	{ after(grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XIfExpression__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXIfExpressionAccess().getElseAssignment_6_1()); }
	(rule__XIfExpression__ElseAssignment_6_1)
	{ after(grammarAccess.getXIfExpressionAccess().getElseAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XForLoopExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group__0__Impl
	rule__XForLoopExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getGroup_0()); }
	(rule__XForLoopExpression__Group_0__0)
	{ after(grammarAccess.getXForLoopExpressionAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group__1__Impl
	rule__XForLoopExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getForExpressionAssignment_1()); }
	(rule__XForLoopExpression__ForExpressionAssignment_1)
	{ after(grammarAccess.getXForLoopExpressionAccess().getForExpressionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group__2__Impl
	rule__XForLoopExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getEachExpressionAssignment_3()); }
	(rule__XForLoopExpression__EachExpressionAssignment_3)
	{ after(grammarAccess.getXForLoopExpressionAccess().getEachExpressionAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XForLoopExpression__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getGroup_0_0()); }
	(rule__XForLoopExpression__Group_0_0__0)
	{ after(grammarAccess.getXForLoopExpressionAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XForLoopExpression__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group_0_0__0__Impl
	rule__XForLoopExpression__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0()); }
	()
	{ after(grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group_0_0__1__Impl
	rule__XForLoopExpression__Group_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1()); }
	'for'
	{ after(grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group_0_0__2__Impl
	rule__XForLoopExpression__Group_0_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2()); }
	'('
	{ after(grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group_0_0__3__Impl
	rule__XForLoopExpression__Group_0_0__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamAssignment_0_0_3()); }
	(rule__XForLoopExpression__DeclaredParamAssignment_0_0_3)
	{ after(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamAssignment_0_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XForLoopExpression__Group_0_0__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__Group_0_0__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4()); }
	':'
	{ after(grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBasicForLoopExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__0__Impl
	rule__XBasicForLoopExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0()); }
	()
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__1__Impl
	rule__XBasicForLoopExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1()); }
	'for'
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__2__Impl
	rule__XBasicForLoopExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__3__Impl
	rule__XBasicForLoopExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_3()); }
	(rule__XBasicForLoopExpression__Group_3__0)?
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__4__Impl
	rule__XBasicForLoopExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4()); }
	';'
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__5__Impl
	rule__XBasicForLoopExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionAssignment_5()); }
	(rule__XBasicForLoopExpression__ExpressionAssignment_5)?
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__6__Impl
	rule__XBasicForLoopExpression__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6()); }
	';'
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__7__Impl
	rule__XBasicForLoopExpression__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_7()); }
	(rule__XBasicForLoopExpression__Group_7__0)?
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__8__Impl
	rule__XBasicForLoopExpression__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8()); }
	')'
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionAssignment_9()); }
	(rule__XBasicForLoopExpression__EachExpressionAssignment_9)
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionAssignment_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBasicForLoopExpression__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_3__0__Impl
	rule__XBasicForLoopExpression__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_0()); }
	(rule__XBasicForLoopExpression__InitExpressionsAssignment_3_0)
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_3_1()); }
	(rule__XBasicForLoopExpression__Group_3_1__0)*
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBasicForLoopExpression__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_3_1__0__Impl
	rule__XBasicForLoopExpression__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0()); }
	','
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_1_1()); }
	(rule__XBasicForLoopExpression__InitExpressionsAssignment_3_1_1)
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBasicForLoopExpression__Group_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_7__0__Impl
	rule__XBasicForLoopExpression__Group_7__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_0()); }
	(rule__XBasicForLoopExpression__UpdateExpressionsAssignment_7_0)
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_7_1()); }
	(rule__XBasicForLoopExpression__Group_7_1__0)*
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBasicForLoopExpression__Group_7_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_7_1__0__Impl
	rule__XBasicForLoopExpression__Group_7_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_7_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0()); }
	','
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_7_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBasicForLoopExpression__Group_7_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__Group_7_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_1_1()); }
	(rule__XBasicForLoopExpression__UpdateExpressionsAssignment_7_1_1)
	{ after(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XWhileExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XWhileExpression__Group__0__Impl
	rule__XWhileExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0()); }
	()
	{ after(grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XWhileExpression__Group__1__Impl
	rule__XWhileExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1()); }
	'while'
	{ after(grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XWhileExpression__Group__2__Impl
	rule__XWhileExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XWhileExpression__Group__3__Impl
	rule__XWhileExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXWhileExpressionAccess().getPredicateAssignment_3()); }
	(rule__XWhileExpression__PredicateAssignment_3)
	{ after(grammarAccess.getXWhileExpressionAccess().getPredicateAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XWhileExpression__Group__4__Impl
	rule__XWhileExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4()); }
	')'
	{ after(grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XWhileExpression__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXWhileExpressionAccess().getBodyAssignment_5()); }
	(rule__XWhileExpression__BodyAssignment_5)
	{ after(grammarAccess.getXWhileExpressionAccess().getBodyAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XDoWhileExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XDoWhileExpression__Group__0__Impl
	rule__XDoWhileExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0()); }
	()
	{ after(grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XDoWhileExpression__Group__1__Impl
	rule__XDoWhileExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1()); }
	'do'
	{ after(grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XDoWhileExpression__Group__2__Impl
	rule__XDoWhileExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXDoWhileExpressionAccess().getBodyAssignment_2()); }
	(rule__XDoWhileExpression__BodyAssignment_2)
	{ after(grammarAccess.getXDoWhileExpressionAccess().getBodyAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XDoWhileExpression__Group__3__Impl
	rule__XDoWhileExpression__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3()); }
	'while'
	{ after(grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XDoWhileExpression__Group__4__Impl
	rule__XDoWhileExpression__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4()); }
	'('
	{ after(grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XDoWhileExpression__Group__5__Impl
	rule__XDoWhileExpression__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXDoWhileExpressionAccess().getPredicateAssignment_5()); }
	(rule__XDoWhileExpression__PredicateAssignment_5)
	{ after(grammarAccess.getXDoWhileExpressionAccess().getPredicateAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XDoWhileExpression__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6()); }
	')'
	{ after(grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBlockExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBlockExpression__Group__0__Impl
	rule__XBlockExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0()); }
	()
	{ after(grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBlockExpression__Group__1__Impl
	rule__XBlockExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1()); }
	'{'
	{ after(grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBlockExpression__Group__2__Impl
	rule__XBlockExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBlockExpressionAccess().getGroup_2()); }
	(rule__XBlockExpression__Group_2__0)*
	{ after(grammarAccess.getXBlockExpressionAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBlockExpression__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()); }
	'}'
	{ after(grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBlockExpression__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBlockExpression__Group_2__0__Impl
	rule__XBlockExpression__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBlockExpressionAccess().getExpressionsAssignment_2_0()); }
	(rule__XBlockExpression__ExpressionsAssignment_2_0)
	{ after(grammarAccess.getXBlockExpressionAccess().getExpressionsAssignment_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBlockExpression__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1()); }
	(';')?
	{ after(grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFeatureCall__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group__0__Impl
	rule__XFeatureCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0()); }
	()
	{ after(grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group__1__Impl
	rule__XFeatureCall__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getGroup_1()); }
	(rule__XFeatureCall__Group_1__0)?
	{ after(grammarAccess.getXFeatureCallAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group__2__Impl
	rule__XFeatureCall__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getFeatureAssignment_2()); }
	(rule__XFeatureCall__FeatureAssignment_2)
	{ after(grammarAccess.getXFeatureCallAccess().getFeatureAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group__3__Impl
	rule__XFeatureCall__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getGroup_3()); }
	(rule__XFeatureCall__Group_3__0)?
	{ after(grammarAccess.getXFeatureCallAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_4()); }
	(rule__XFeatureCall__FeatureCallArgumentsAssignment_4)?
	{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFeatureCall__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_1__0__Impl
	rule__XFeatureCall__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0()); }
	'<'
	{ after(grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_1__1__Impl
	rule__XFeatureCall__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getTypeArgumentsAssignment_1_1()); }
	(rule__XFeatureCall__TypeArgumentsAssignment_1_1)
	{ after(grammarAccess.getXFeatureCallAccess().getTypeArgumentsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_1__2__Impl
	rule__XFeatureCall__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getGroup_1_2()); }
	(rule__XFeatureCall__Group_1_2__0)*
	{ after(grammarAccess.getXFeatureCallAccess().getGroup_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3()); }
	'>'
	{ after(grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFeatureCall__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_1_2__0__Impl
	rule__XFeatureCall__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0()); }
	','
	{ after(grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getTypeArgumentsAssignment_1_2_1()); }
	(rule__XFeatureCall__TypeArgumentsAssignment_1_2_1)
	{ after(grammarAccess.getXFeatureCallAccess().getTypeArgumentsAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFeatureCall__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_3__0__Impl
	rule__XFeatureCall__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getExplicitOperationCallAssignment_3_0()); }
	(rule__XFeatureCall__ExplicitOperationCallAssignment_3_0)
	{ after(grammarAccess.getXFeatureCallAccess().getExplicitOperationCallAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_3__1__Impl
	rule__XFeatureCall__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getAlternatives_3_1()); }
	(rule__XFeatureCall__Alternatives_3_1)?
	{ after(grammarAccess.getXFeatureCallAccess().getAlternatives_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2()); }
	')'
	{ after(grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFeatureCall__Group_3_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_3_1_1__0__Impl
	rule__XFeatureCall__Group_3_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_0()); }
	(rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_1_0)
	{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_3_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getGroup_3_1_1_1()); }
	(rule__XFeatureCall__Group_3_1_1_1__0)*
	{ after(grammarAccess.getXFeatureCallAccess().getGroup_3_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFeatureCall__Group_3_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_3_1_1_1__0__Impl
	rule__XFeatureCall__Group_3_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0()); }
	','
	{ after(grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFeatureCall__Group_3_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__Group_3_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_1_1()); }
	(rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_1_1_1)
	{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XBooleanLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBooleanLiteral__Group__0__Impl
	rule__XBooleanLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XBooleanLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0()); }
	()
	{ after(grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBooleanLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XBooleanLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XBooleanLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXBooleanLiteralAccess().getAlternatives_1()); }
	(rule__XBooleanLiteral__Alternatives_1)
	{ after(grammarAccess.getXBooleanLiteralAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XNullLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XNullLiteral__Group__0__Impl
	rule__XNullLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XNullLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0()); }
	()
	{ after(grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XNullLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XNullLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XNullLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXNullLiteralAccess().getNullKeyword_1()); }
	'null'
	{ after(grammarAccess.getXNullLiteralAccess().getNullKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XNumberLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XNumberLiteral__Group__0__Impl
	rule__XNumberLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XNumberLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0()); }
	()
	{ after(grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XNumberLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XNumberLiteral__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XNumberLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXNumberLiteralAccess().getValueAssignment_1()); }
	(rule__XNumberLiteral__ValueAssignment_1)
	{ after(grammarAccess.getXNumberLiteralAccess().getValueAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XTypeLiteral__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTypeLiteral__Group__0__Impl
	rule__XTypeLiteral__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0()); }
	()
	{ after(grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTypeLiteral__Group__1__Impl
	rule__XTypeLiteral__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1()); }
	'typeof'
	{ after(grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTypeLiteral__Group__2__Impl
	rule__XTypeLiteral__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2()); }
	'('
	{ after(grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTypeLiteral__Group__3__Impl
	rule__XTypeLiteral__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTypeLiteralAccess().getTypeAssignment_3()); }
	(rule__XTypeLiteral__TypeAssignment_3)
	{ after(grammarAccess.getXTypeLiteralAccess().getTypeAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTypeLiteral__Group__4__Impl
	rule__XTypeLiteral__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsAssignment_4()); }
	(rule__XTypeLiteral__ArrayDimensionsAssignment_4)*
	{ after(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XTypeLiteral__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5()); }
	')'
	{ after(grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XThrowExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XThrowExpression__Group__0__Impl
	rule__XThrowExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XThrowExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0()); }
	()
	{ after(grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XThrowExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XThrowExpression__Group__1__Impl
	rule__XThrowExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XThrowExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1()); }
	'throw'
	{ after(grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XThrowExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XThrowExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XThrowExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXThrowExpressionAccess().getExpressionAssignment_2()); }
	(rule__XThrowExpression__ExpressionAssignment_2)
	{ after(grammarAccess.getXThrowExpressionAccess().getExpressionAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XReturnExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XReturnExpression__Group__0__Impl
	rule__XReturnExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XReturnExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0()); }
	()
	{ after(grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XReturnExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XReturnExpression__Group__1__Impl
	rule__XReturnExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XReturnExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1()); }
	'return'
	{ after(grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XReturnExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XReturnExpression__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XReturnExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXReturnExpressionAccess().getExpressionAssignment_2()); }
	(rule__XReturnExpression__ExpressionAssignment_2)?
	{ after(grammarAccess.getXReturnExpressionAccess().getExpressionAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSynchronizedExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group__0__Impl
	rule__XSynchronizedExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getGroup_0()); }
	(rule__XSynchronizedExpression__Group_0__0)
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group__1__Impl
	rule__XSynchronizedExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getParamAssignment_1()); }
	(rule__XSynchronizedExpression__ParamAssignment_1)
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getParamAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group__2__Impl
	rule__XSynchronizedExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getExpressionAssignment_3()); }
	(rule__XSynchronizedExpression__ExpressionAssignment_3)
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getExpressionAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSynchronizedExpression__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getGroup_0_0()); }
	(rule__XSynchronizedExpression__Group_0_0__0)
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XSynchronizedExpression__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group_0_0__0__Impl
	rule__XSynchronizedExpression__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0()); }
	()
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group_0_0__1__Impl
	rule__XSynchronizedExpression__Group_0_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1()); }
	'synchronized'
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group_0_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XSynchronizedExpression__Group_0_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__Group_0_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2()); }
	'('
	{ after(grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XCatchClause__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCatchClause__Group__0__Impl
	rule__XCatchClause__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCatchClauseAccess().getCatchKeyword_0()); }
	('catch')
	{ after(grammarAccess.getXCatchClauseAccess().getCatchKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCatchClause__Group__1__Impl
	rule__XCatchClause__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCatchClause__Group__2__Impl
	rule__XCatchClause__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCatchClauseAccess().getDeclaredParamAssignment_2()); }
	(rule__XCatchClause__DeclaredParamAssignment_2)
	{ after(grammarAccess.getXCatchClauseAccess().getDeclaredParamAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCatchClause__Group__3__Impl
	rule__XCatchClause__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XCatchClause__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXCatchClauseAccess().getExpressionAssignment_4()); }
	(rule__XCatchClause__ExpressionAssignment_4)
	{ after(grammarAccess.getXCatchClauseAccess().getExpressionAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); }
	ruleValidID
	{ after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
	(rule__QualifiedName__Group_1__0)*
	{ after(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__0__Impl
	rule__QualifiedName__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
	('.')
	{ after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); }
	ruleValidID
	{ after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Number__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group_1__0__Impl
	rule__Number__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getAlternatives_1_0()); }
	(rule__Number__Alternatives_1_0)
	{ after(grammarAccess.getNumberAccess().getAlternatives_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getGroup_1_1()); }
	(rule__Number__Group_1_1__0)?
	{ after(grammarAccess.getNumberAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Number__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group_1_1__0__Impl
	rule__Number__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0()); }
	'.'
	{ after(grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Number__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNumberAccess().getAlternatives_1_1_1()); }
	(rule__Number__Alternatives_1_1_1)
	{ after(grammarAccess.getNumberAccess().getAlternatives_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmTypeReference__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0__0__Impl
	rule__JvmTypeReference__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); }
	ruleJvmParameterizedTypeReference
	{ after(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); }
	(rule__JvmTypeReference__Group_0_1__0)*
	{ after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmTypeReference__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); }
	(rule__JvmTypeReference__Group_0_1_0__0)
	{ after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmTypeReference__Group_0_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0_1_0__0__Impl
	rule__JvmTypeReference__Group_0_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); }
	()
	{ after(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); }
	ruleArrayBrackets
	{ after(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayBrackets__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayBrackets__Group__0__Impl
	rule__ArrayBrackets__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayBrackets__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); }
	'['
	{ after(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayBrackets__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayBrackets__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayBrackets__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); }
	']'
	{ after(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group__0__Impl
	rule__XFunctionTypeRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); }
	(rule__XFunctionTypeRef__Group_0__0)?
	{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group__1__Impl
	rule__XFunctionTypeRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); }
	'=>'
	{ after(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); }
	(rule__XFunctionTypeRef__ReturnTypeAssignment_2)
	{ after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0__0__Impl
	rule__XFunctionTypeRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); }
	'('
	{ after(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0__1__Impl
	rule__XFunctionTypeRef__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); }
	(rule__XFunctionTypeRef__Group_0_1__0)?
	{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); }
	')'
	{ after(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1__0__Impl
	rule__XFunctionTypeRef__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); }
	(rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0)
	{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); }
	(rule__XFunctionTypeRef__Group_0_1_1__0)*
	{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group_0_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1_1__0__Impl
	rule__XFunctionTypeRef__Group_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); }
	','
	{ after(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); }
	(rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1)
	{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group__0__Impl
	rule__JvmParameterizedTypeReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); }
	(rule__JvmParameterizedTypeReference__TypeAssignment_0)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); }
	(rule__JvmParameterizedTypeReference__Group_1__0)?
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__0__Impl
	rule__JvmParameterizedTypeReference__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); }
	('<')
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__1__Impl
	rule__JvmParameterizedTypeReference__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__2__Impl
	rule__JvmParameterizedTypeReference__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); }
	(rule__JvmParameterizedTypeReference__Group_1_2__0)*
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__3__Impl
	rule__JvmParameterizedTypeReference__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); }
	'>'
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4()); }
	(rule__JvmParameterizedTypeReference__Group_1_4__0)*
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_2__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); }
	','
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_0__0)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4__1__Impl
	rule__JvmParameterizedTypeReference__Group_1_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1()); }
	(rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_2__0)?
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_0_0__0)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); }
	()
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1()); }
	'.'
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0()); }
	('<')
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_2_2__0)*
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3()); }
	'>'
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0()); }
	','
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmWildcardTypeReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group__0__Impl
	rule__JvmWildcardTypeReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); }
	()
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group__1__Impl
	rule__JvmWildcardTypeReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); }
	'?'
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); }
	(rule__JvmWildcardTypeReference__Alternatives_2)?
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmWildcardTypeReference__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_0__0__Impl
	rule__JvmWildcardTypeReference__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0)
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1)*
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmWildcardTypeReference__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_1__0__Impl
	rule__JvmWildcardTypeReference__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0)
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1)*
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmUpperBound__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBound__Group__0__Impl
	rule__JvmUpperBound__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); }
	'extends'
	{ after(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBound__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmUpperBound__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmUpperBoundAnded__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBoundAnded__Group__0__Impl
	rule__JvmUpperBoundAnded__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); }
	'&'
	{ after(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBoundAnded__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmUpperBoundAnded__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmLowerBound__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBound__Group__0__Impl
	rule__JvmLowerBound__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); }
	'super'
	{ after(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBound__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmLowerBound__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmLowerBoundAnded__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBoundAnded__Group__0__Impl
	rule__JvmLowerBoundAnded__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0()); }
	'&'
	{ after(grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBoundAnded__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmLowerBoundAnded__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmTypeParameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeParameter__Group__0__Impl
	rule__JvmTypeParameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeParameterAccess().getNameAssignment_0()); }
	(rule__JvmTypeParameter__NameAssignment_0)
	{ after(grammarAccess.getJvmTypeParameterAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeParameter__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeParameterAccess().getGroup_1()); }
	(rule__JvmTypeParameter__Group_1__0)?
	{ after(grammarAccess.getJvmTypeParameterAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmTypeParameter__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeParameter__Group_1__0__Impl
	rule__JvmTypeParameter__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_0()); }
	(rule__JvmTypeParameter__ConstraintsAssignment_1_0)
	{ after(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeParameter__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_1()); }
	(rule__JvmTypeParameter__ConstraintsAssignment_1_1)*
	{ after(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedNameWithWildcard__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameWithWildcard__Group__0__Impl
	rule__QualifiedNameWithWildcard__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); }
	ruleQualifiedName
	{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameWithWildcard__Group__1__Impl
	rule__QualifiedNameWithWildcard__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameWithWildcard__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); }
	'*'
	{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XImportDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group__0__Impl
	rule__XImportDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getImportKeyword_0()); }
	'import'
	{ after(grammarAccess.getXImportDeclarationAccess().getImportKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group__1__Impl
	rule__XImportDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getAlternatives_1()); }
	(rule__XImportDeclaration__Alternatives_1)
	{ after(grammarAccess.getXImportDeclarationAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2()); }
	(';')?
	{ after(grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XImportDeclaration__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__0__Impl
	rule__XImportDeclaration__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0()); }
	(rule__XImportDeclaration__StaticAssignment_1_0_0)
	{ after(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__1__Impl
	rule__XImportDeclaration__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1()); }
	(rule__XImportDeclaration__ExtensionAssignment_1_0_1)?
	{ after(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__2__Impl
	rule__XImportDeclaration__Group_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2()); }
	(rule__XImportDeclaration__ImportedTypeAssignment_1_0_2)
	{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3()); }
	(rule__XImportDeclaration__Alternatives_1_0_3)
	{ after(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedNameInStaticImport__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameInStaticImport__Group__0__Impl
	rule__QualifiedNameInStaticImport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameInStaticImport__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); }
	ruleValidID
	{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameInStaticImport__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameInStaticImport__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameInStaticImport__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__File__PackageAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFileAccess().getPackageQualifiedNameParserRuleCall_0_1_0()); }
		ruleQualifiedName
		{ after(grammarAccess.getFileAccess().getPackageQualifiedNameParserRuleCall_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__File__ImportSectionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFileAccess().getImportSectionXImportSectionParserRuleCall_1_0()); }
		ruleXImportSection
		{ after(grammarAccess.getFileAccess().getImportSectionXImportSectionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__File__XtendTypesAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFileAccess().getXtendTypesTypeParserRuleCall_2_0()); }
		ruleType
		{ after(grammarAccess.getFileAccess().getXtendTypesTypeParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__AnnotationsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getAnnotationsXAnnotationParserRuleCall_1_0()); }
		ruleXAnnotation
		{ after(grammarAccess.getTypeAccess().getAnnotationsXAnnotationParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ModifiersAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_0_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__NameAssignment_2_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_0_3_0()); }
		ruleValidID
		{ after(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__TypeParametersAssignment_2_0_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__TypeParametersAssignment_2_0_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_0_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ExtendsAssignment_2_0_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getTypeAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_0_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ImplementsAssignment_2_0_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0()); }
		ruleJvmSuperTypeReference
		{ after(grammarAccess.getTypeAccess().getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ImplementsAssignment_2_0_6_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0()); }
		ruleJvmSuperTypeReference
		{ after(grammarAccess.getTypeAccess().getImplementsJvmSuperTypeReferenceParserRuleCall_2_0_6_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__MembersAssignment_2_0_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getMembersMemberParserRuleCall_2_0_8_0()); }
		ruleMember
		{ after(grammarAccess.getTypeAccess().getMembersMemberParserRuleCall_2_0_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ModifiersAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__NameAssignment_2_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_1_3_0()); }
		ruleValidID
		{ after(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__TypeParametersAssignment_2_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__TypeParametersAssignment_2_1_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getTypeAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ExtendsAssignment_2_1_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0()); }
		ruleJvmSuperTypeReference
		{ after(grammarAccess.getTypeAccess().getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ExtendsAssignment_2_1_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0()); }
		ruleJvmSuperTypeReference
		{ after(grammarAccess.getTypeAccess().getExtendsJvmSuperTypeReferenceParserRuleCall_2_1_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__MembersAssignment_2_1_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getMembersMemberParserRuleCall_2_1_7_0()); }
		ruleMember
		{ after(grammarAccess.getTypeAccess().getMembersMemberParserRuleCall_2_1_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ModifiersAssignment_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__NameAssignment_2_2_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_2_3_0()); }
		ruleValidID
		{ after(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_2_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__MembersAssignment_2_2_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getMembersXtendEnumLiteralParserRuleCall_2_2_5_0_0()); }
		ruleXtendEnumLiteral
		{ after(grammarAccess.getTypeAccess().getMembersXtendEnumLiteralParserRuleCall_2_2_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__MembersAssignment_2_2_5_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getMembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0()); }
		ruleXtendEnumLiteral
		{ after(grammarAccess.getTypeAccess().getMembersXtendEnumLiteralParserRuleCall_2_2_5_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ModifiersAssignment_2_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getTypeAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__NameAssignment_2_3_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_3_3_0()); }
		ruleValidID
		{ after(grammarAccess.getTypeAccess().getNameValidIDParserRuleCall_2_3_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__MembersAssignment_2_3_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getMembersAnnotationFieldParserRuleCall_2_3_5_0()); }
		ruleAnnotationField
		{ after(grammarAccess.getTypeAccess().getMembersAnnotationFieldParserRuleCall_2_3_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__InstanceContextAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getInstanceContextLeftParenthesisKeyword_0_0_0()); }
		(
			{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getInstanceContextLeftParenthesisKeyword_0_0_0()); }
			'('
			{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getInstanceContextLeftParenthesisKeyword_0_0_0()); }
		)
		{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getInstanceContextLeftParenthesisKeyword_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__ParamTypesAssignment_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__ParamTypesAssignment_0_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionSuperTypeRef__ReturnTypeAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionSuperTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionSuperTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__AnnotationsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getAnnotationsXAnnotationParserRuleCall_1_0()); }
		ruleXAnnotation
		{ after(grammarAccess.getAnnotationFieldAccess().getAnnotationsXAnnotationParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_0_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_0_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_0_0_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersFieldModifierParserRuleCall_2_0_0_0_2_0()); }
		ruleFieldModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersFieldModifierParserRuleCall_2_0_0_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_0_0_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_0_3_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__TypeAssignment_2_0_0_0_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getAnnotationFieldAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__NameAssignment_2_0_0_0_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_0_0_0_5_0()); }
		ruleValidID
		{ after(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_0_0_0_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_0_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_1_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_0_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__TypeAssignment_2_0_0_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getAnnotationFieldAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__NameAssignment_2_0_0_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_0_0_1_3_0()); }
		ruleValidID
		{ after(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_0_0_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__InitialValueAssignment_2_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getInitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0()); }
		ruleXAnnotationElementValue
		{ after(grammarAccess.getAnnotationFieldAccess().getInitialValueXAnnotationElementValueParserRuleCall_2_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__NameAssignment_2_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_1_3_0()); }
		ruleValidID
		{ after(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__TypeParametersAssignment_2_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__TypeParametersAssignment_2_1_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ExtendsAssignment_2_1_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_1_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ImplementsAssignment_2_1_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getAnnotationFieldAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ImplementsAssignment_2_1_6_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getAnnotationFieldAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_1_6_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__MembersAssignment_2_1_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getMembersMemberParserRuleCall_2_1_8_0()); }
		ruleMember
		{ after(grammarAccess.getAnnotationFieldAccess().getMembersMemberParserRuleCall_2_1_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__NameAssignment_2_2_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_2_3_0()); }
		ruleValidID
		{ after(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_2_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__TypeParametersAssignment_2_2_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__TypeParametersAssignment_2_2_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getAnnotationFieldAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ExtendsAssignment_2_2_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ExtendsAssignment_2_2_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getAnnotationFieldAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_2_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__MembersAssignment_2_2_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getMembersMemberParserRuleCall_2_2_7_0()); }
		ruleMember
		{ after(grammarAccess.getAnnotationFieldAccess().getMembersMemberParserRuleCall_2_2_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__NameAssignment_2_3_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_3_3_0()); }
		ruleValidID
		{ after(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_3_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__MembersAssignment_2_3_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getMembersXtendEnumLiteralParserRuleCall_2_3_5_0_0()); }
		ruleXtendEnumLiteral
		{ after(grammarAccess.getAnnotationFieldAccess().getMembersXtendEnumLiteralParserRuleCall_2_3_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__MembersAssignment_2_3_5_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getMembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0()); }
		ruleXtendEnumLiteral
		{ after(grammarAccess.getAnnotationFieldAccess().getMembersXtendEnumLiteralParserRuleCall_2_3_5_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__ModifiersAssignment_2_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_4_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getAnnotationFieldAccess().getModifiersCommonModifierParserRuleCall_2_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__NameAssignment_2_4_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_4_3_0()); }
		ruleValidID
		{ after(grammarAccess.getAnnotationFieldAccess().getNameValidIDParserRuleCall_2_4_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AnnotationField__MembersAssignment_2_4_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationFieldAccess().getMembersAnnotationFieldParserRuleCall_2_4_5_0()); }
		ruleAnnotationField
		{ after(grammarAccess.getAnnotationFieldAccess().getMembersAnnotationFieldParserRuleCall_2_4_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__AnnotationsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getAnnotationsXAnnotationParserRuleCall_1_0()); }
		ruleXAnnotation
		{ after(grammarAccess.getMemberAccess().getAnnotationsXAnnotationParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_0_0_0()); }
		ruleFieldModifier
		{ after(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_0_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeAssignment_2_0_2_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_0_2_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_0_3_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_1_0_0()); }
		(
			{ before(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_1_0_0()); }
			'extension'
			{ after(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_1_0_0()); }
		)
		{ after(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0()); }
		ruleFieldModifier
		{ after(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeAssignment_2_0_2_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_0_2_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_1_3_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_2_0_0()); }
		ruleFieldModifier
		{ after(grammarAccess.getMemberAccess().getModifiersFieldModifierParserRuleCall_2_0_2_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_2_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_2_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_2_2_0()); }
		(
			{ before(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_2_2_0()); }
			'extension'
			{ after(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_2_2_0()); }
		)
		{ after(grammarAccess.getMemberAccess().getModifiersExtensionKeyword_2_0_2_2_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_0_2_2_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_2_3_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_0_2_2_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeAssignment_2_0_2_2_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_2_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_0_2_2_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_2_5_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_2_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeAssignment_2_0_2_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_2_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_0_2_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_3_1_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_0_2_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__InitialValueAssignment_2_0_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getInitialValueXExpressionParserRuleCall_2_0_3_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getMemberAccess().getInitialValueXExpressionParserRuleCall_2_0_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersMethodModifierParserRuleCall_2_1_2_0()); }
		ruleMethodModifier
		{ after(grammarAccess.getMemberAccess().getModifiersMethodModifierParserRuleCall_2_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_1_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_1_3_0_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_1_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersMethodModifierParserRuleCall_2_1_3_1_0()); }
		ruleMethodModifier
		{ after(grammarAccess.getMemberAccess().getModifiersMethodModifierParserRuleCall_2_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_1_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_1_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ReturnTypeAssignment_2_1_5_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_1_5_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__CreateExtensionInfoAssignment_2_1_5_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0()); }
		ruleCreateExtensionInfo
		{ after(grammarAccess.getMemberAccess().getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_1_5_0_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_1_5_0_0_2_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_1_5_0_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ReturnTypeAssignment_2_1_5_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0()); }
		ruleTypeReferenceWithTypeArgs
		{ after(grammarAccess.getMemberAccess().getReturnTypeTypeReferenceWithTypeArgsParserRuleCall_2_1_5_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_1_5_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_1_0_1_0()); }
		ruleFunctionID
		{ after(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ReturnTypeAssignment_2_1_5_2_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0()); }
		ruleTypeReferenceNoTypeArgs
		{ after(grammarAccess.getMemberAccess().getReturnTypeTypeReferenceNoTypeArgsParserRuleCall_2_1_5_2_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_1_5_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_2_0_1_0()); }
		ruleFunctionID
		{ after(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__CreateExtensionInfoAssignment_2_1_5_3_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0()); }
		ruleCreateExtensionInfo
		{ after(grammarAccess.getMemberAccess().getCreateExtensionInfoCreateExtensionInfoParserRuleCall_2_1_5_3_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_1_5_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_1_5_3_0_1_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_1_5_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_1_5_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_4_0_0()); }
		ruleFunctionID
		{ after(grammarAccess.getMemberAccess().getNameFunctionIDParserRuleCall_2_1_5_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ParametersAssignment_2_1_6_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_1_6_0_0()); }
		ruleParameter
		{ after(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_1_6_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ParametersAssignment_2_1_6_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_1_6_1_1_0()); }
		ruleParameter
		{ after(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_1_6_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExceptionsAssignment_2_1_8_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExceptionsAssignment_2_1_8_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_1_8_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExpressionAssignment_2_1_9_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExpressionXBlockExpressionParserRuleCall_2_1_9_0_0()); }
		ruleXBlockExpression
		{ after(grammarAccess.getMemberAccess().getExpressionXBlockExpressionParserRuleCall_2_1_9_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExpressionAssignment_2_1_9_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExpressionRichStringParserRuleCall_2_1_9_1_0()); }
		ruleRichString
		{ after(grammarAccess.getMemberAccess().getExpressionRichStringParserRuleCall_2_1_9_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_2_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_2_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_2_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ParametersAssignment_2_2_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_2_5_0_0()); }
		ruleParameter
		{ after(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_2_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ParametersAssignment_2_2_5_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_2_5_1_1_0()); }
		ruleParameter
		{ after(grammarAccess.getMemberAccess().getParametersParameterParserRuleCall_2_2_5_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExceptionsAssignment_2_2_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExceptionsAssignment_2_2_7_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMemberAccess().getExceptionsJvmTypeReferenceParserRuleCall_2_2_7_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExpressionAssignment_2_2_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExpressionXBlockExpressionParserRuleCall_2_2_8_0()); }
		ruleXBlockExpression
		{ after(grammarAccess.getMemberAccess().getExpressionXBlockExpressionParserRuleCall_2_2_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_3_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_3_3_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_3_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_3_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_3_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_3_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExtendsAssignment_2_3_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_3_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ImplementsAssignment_2_3_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getMemberAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ImplementsAssignment_2_3_6_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getMemberAccess().getImplementsJvmParameterizedTypeReferenceParserRuleCall_2_3_6_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__MembersAssignment_2_3_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getMembersMemberParserRuleCall_2_3_8_0()); }
		ruleMember
		{ after(grammarAccess.getMemberAccess().getMembersMemberParserRuleCall_2_3_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_4_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_4_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_4_3_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_4_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_4_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__TypeParametersAssignment_2_4_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0()); }
		ruleJvmTypeParameter
		{ after(grammarAccess.getMemberAccess().getTypeParametersJvmTypeParameterParserRuleCall_2_4_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExtendsAssignment_2_4_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ExtendsAssignment_2_4_5_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0()); }
		ruleJvmParameterizedTypeReference
		{ after(grammarAccess.getMemberAccess().getExtendsJvmParameterizedTypeReferenceParserRuleCall_2_4_5_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__MembersAssignment_2_4_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getMembersMemberParserRuleCall_2_4_7_0()); }
		ruleMember
		{ after(grammarAccess.getMemberAccess().getMembersMemberParserRuleCall_2_4_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_5_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_5_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_5_3_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_5_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__MembersAssignment_2_5_5_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getMembersXtendEnumLiteralParserRuleCall_2_5_5_0_0()); }
		ruleXtendEnumLiteral
		{ after(grammarAccess.getMemberAccess().getMembersXtendEnumLiteralParserRuleCall_2_5_5_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__MembersAssignment_2_5_5_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getMembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0()); }
		ruleXtendEnumLiteral
		{ after(grammarAccess.getMemberAccess().getMembersXtendEnumLiteralParserRuleCall_2_5_5_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__ModifiersAssignment_2_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_6_1_0()); }
		ruleCommonModifier
		{ after(grammarAccess.getMemberAccess().getModifiersCommonModifierParserRuleCall_2_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__NameAssignment_2_6_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_6_3_0()); }
		ruleValidID
		{ after(grammarAccess.getMemberAccess().getNameValidIDParserRuleCall_2_6_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Member__MembersAssignment_2_6_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getMembersAnnotationFieldParserRuleCall_2_6_5_0()); }
		ruleAnnotationField
		{ after(grammarAccess.getMemberAccess().getMembersAnnotationFieldParserRuleCall_2_6_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReferenceNoTypeArgs__TypeAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeJvmTypeCrossReference_0()); }
		(
			{ before(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_1()); }
		)
		{ after(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeJvmTypeCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__TypeAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeCrossReference_0_0()); }
		(
			{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__TypeAssignment_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeCrossReference_1_4_1_0()); }
		(
			{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); }
			ruleValidID
			{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); }
		)
		{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getTypeJvmTypeCrossReference_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedTypeReferenceWithTypeArgs__ArgumentsAssignment_1_4_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XtendEnumLiteral__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXtendEnumLiteralAccess().getAnnotationsXAnnotationParserRuleCall_0_0()); }
		ruleXAnnotation
		{ after(grammarAccess.getXtendEnumLiteralAccess().getAnnotationsXAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XtendEnumLiteral__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXtendEnumLiteralAccess().getNameValidIDParserRuleCall_1_0()); }
		ruleValidID
		{ after(grammarAccess.getXtendEnumLiteralAccess().getNameValidIDParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__NameAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCreateExtensionInfoAccess().getNameValidIDParserRuleCall_1_0_0()); }
		ruleValidID
		{ after(grammarAccess.getCreateExtensionInfoAccess().getNameValidIDParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CreateExtensionInfo__CreateExpressionAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCreateExtensionInfoAccess().getCreateExpressionXExpressionParserRuleCall_2_0()); }
		ruleXExpression
		{ after(grammarAccess.getCreateExtensionInfoAccess().getCreateExpressionXExpressionParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getAnnotationsXAnnotationParserRuleCall_0_0()); }
		ruleXAnnotation
		{ after(grammarAccess.getParameterAccess().getAnnotationsXAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__ExtensionAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getExtensionExtensionKeyword_1_0_0()); }
		(
			{ before(grammarAccess.getParameterAccess().getExtensionExtensionKeyword_1_0_0()); }
			'extension'
			{ after(grammarAccess.getParameterAccess().getExtensionExtensionKeyword_1_0_0()); }
		)
		{ after(grammarAccess.getParameterAccess().getExtensionExtensionKeyword_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__AnnotationsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getAnnotationsXAnnotationParserRuleCall_1_1_0()); }
		ruleXAnnotation
		{ after(grammarAccess.getParameterAccess().getAnnotationsXAnnotationParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__ParameterTypeAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_2_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__VarArgAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getVarArgFullStopFullStopFullStopKeyword_3_0()); }
		(
			{ before(grammarAccess.getParameterAccess().getVarArgFullStopFullStopFullStopKeyword_3_0()); }
			'...'
			{ after(grammarAccess.getParameterAccess().getVarArgFullStopFullStopFullStopKeyword_3_0()); }
		)
		{ after(grammarAccess.getParameterAccess().getVarArgFullStopFullStopFullStopKeyword_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__NameAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getNameValidIDParserRuleCall_4_0()); }
		ruleValidID
		{ after(grammarAccess.getParameterAccess().getNameValidIDParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__FeatureAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); }
		(
			{ before(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1()); }
			ruleFeatureCallID
			{ after(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1()); }
		)
		{ after(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__ValueAssignment_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); }
		ruleXAssignment
		{ after(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__FeatureAssignment_1_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1()); }
			ruleOpMultiAssign
			{ after(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAssignment__RightOperandAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); }
		ruleXAssignment
		{ after(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__ConditionalExpressionAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXConditionalExpressionAccess().getConditionalExpressionQuestionMarkKeyword_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXConditionalExpressionAccess().getConditionalExpressionQuestionMarkKeyword_1_0_0_1_0()); }
			'?'
			{ after(grammarAccess.getXConditionalExpressionAccess().getConditionalExpressionQuestionMarkKeyword_1_0_0_1_0()); }
		)
		{ after(grammarAccess.getXConditionalExpressionAccess().getConditionalExpressionQuestionMarkKeyword_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__ThenAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXConditionalExpressionAccess().getThenXExpressionParserRuleCall_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXConditionalExpressionAccess().getThenXExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConditionalExpression__ElseAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXConditionalExpressionAccess().getElseXExpressionParserRuleCall_1_2_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXConditionalExpressionAccess().getElseXExpressionParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__ResourcesAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesInitializedVariableDeclarationParserRuleCall_2_0_1_0()); }
		ruleInitializedVariableDeclaration
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesInitializedVariableDeclarationParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__ResourcesAssignment_2_0_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesInitializedVariableDeclarationParserRuleCall_2_0_2_1_0()); }
		ruleInitializedVariableDeclaration
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getResourcesInitializedVariableDeclarationParserRuleCall_2_0_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__ExpressionAssignment_2_0_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0_5_0()); }
		ruleXExpression
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__CatchClausesAssignment_2_0_6_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_6_0_0_0_0()); }
		ruleXCatchClause
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_0_6_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_0_6_0_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_0_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_0_6_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_0_6_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__ExpressionAssignment_2_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_1_0_0()); }
		ruleXExpression
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__CatchClausesAssignment_2_1_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_1_1_0_0_0()); }
		ruleXCatchClause
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_2_1_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_1_1_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_0_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_2_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_2_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__TypeAssignment_1_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_0_0_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__NameAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_1_0_0_1_0()); }
		ruleInnerVarID
		{ after(grammarAccess.getXVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__NameAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_1_1_0()); }
		ruleInnerVarID
		{ after(grammarAccess.getXVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XVariableDeclaration__RightAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_2_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__TypeAssignment_2_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInitializedVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getInitializedVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__NameAssignment_2_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInitializedVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_2_0_0_1_0()); }
		ruleInnerVarID
		{ after(grammarAccess.getInitializedVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_2_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__NameAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInitializedVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_2_1_0()); }
		ruleInnerVarID
		{ after(grammarAccess.getInitializedVariableDeclarationAccess().getNameInnerVarIDParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InitializedVariableDeclaration__RightAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInitializedVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0()); }
		ruleXExpression
		{ after(grammarAccess.getInitializedVariableDeclarationAccess().getRightXExpressionParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__WriteableAssignment_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_0_0_0_0()); }
		(
			{ before(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_0_0_0_0()); }
			'var'
			{ after(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_0_0_0_0()); }
		)
		{ after(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__ExtensionAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_0_1_0()); }
		(
			{ before(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_0_1_0()); }
			'extension'
			{ after(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_0_1_0()); }
		)
		{ after(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__ExtensionAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_1_0_0()); }
		(
			{ before(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_1_0_0()); }
			'extension'
			{ after(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_1_0_0()); }
		)
		{ after(grammarAccess.getVariableModifierAccess().getExtensionExtensionKeyword_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableModifier__WriteableAssignment_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_1_1_0_0()); }
		(
			{ before(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_1_1_0_0()); }
			'var'
			{ after(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_1_1_0_0()); }
		)
		{ after(grammarAccess.getVariableModifierAccess().getWriteableVarKeyword_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XConstructorCall__MembersAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXConstructorCallAccess().getMembersMemberParserRuleCall_1_1_0()); }
		ruleMember
		{ after(grammarAccess.getXConstructorCallAccess().getMembersMemberParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__ConstructorAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); }
		(
			{ before(grammarAccess.getXbaseConstructorCallAccess().getConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getXbaseConstructorCallAccess().getConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getXbaseConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__TypeArgumentsAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__TypeArgumentsAssignment_3_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getXbaseConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__ExplicitConstructorCallAssignment_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0()); }
		(
			{ before(grammarAccess.getXbaseConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0()); }
			'('
			{ after(grammarAccess.getXbaseConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0()); }
		)
		{ after(grammarAccess.getXbaseConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__ArgumentsAssignment_4_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0()); }
		ruleXShortClosure
		{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__ArgumentsAssignment_4_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0()); }
		ruleXExpression
		{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__ArgumentsAssignment_4_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XbaseConstructorCall__ArgumentsAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()); }
		ruleXClosure
		{ after(grammarAccess.getXbaseConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__ExtensionAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
		(
			{ before(grammarAccess.getJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
			'extension'
			{ after(grammarAccess.getJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
		)
		{ after(grammarAccess.getJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__ParameterTypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmFormalParameter__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmFormalParameterAccess().getNameInnerVarIDParserRuleCall_2_0()); }
		ruleInnerVarID
		{ after(grammarAccess.getJvmFormalParameterAccess().getNameInnerVarIDParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__ExtensionAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFullJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
		(
			{ before(grammarAccess.getFullJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
			'extension'
			{ after(grammarAccess.getFullJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
		)
		{ after(grammarAccess.getFullJvmFormalParameterAccess().getExtensionExtensionKeyword_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__ParameterTypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeMultiTypeReferenceParserRuleCall_1_0()); }
		ruleMultiTypeReference
		{ after(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeMultiTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FullJvmFormalParameter__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFullJvmFormalParameterAccess().getNameInnerVarIDParserRuleCall_2_0()); }
		ruleInnerVarID
		{ after(grammarAccess.getFullJvmFormalParameterAccess().getNameInnerVarIDParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MultiTypeReference__ReferencesAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMultiTypeReferenceAccess().getReferencesJvmTypeReferenceParserRuleCall_1_1_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getMultiTypeReferenceAccess().getReferencesJvmTypeReferenceParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__DeclaredParamAssignment_2_0_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__SwitchAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__DeclaredParamAssignment_2_1_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__SwitchAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0()); }
		ruleXExpressionOrSimpleConstructorCall
		{ after(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionOrSimpleConstructorCallParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__CasesAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); }
		ruleXCasePart
		{ after(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSwitchExpression__DefaultAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); }
		ruleXExpression
		{ after(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__TypeGuardAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCasePartAccess().getTypeGuardMultiTypeReferenceParserRuleCall_1_0()); }
		ruleMultiTypeReference
		{ after(grammarAccess.getXCasePartAccess().getTypeGuardMultiTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__CaseAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__ThenAssignment_3_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCasePart__FallThroughAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0()); }
		(
			{ before(grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0()); }
			','
			{ after(grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0()); }
		)
		{ after(grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SimpleStringLiteral__ValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSimpleStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getSimpleStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__ExpressionsAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_0_0()); }
		ruleRichStringLiteral
		{ after(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__ExpressionsAssignment_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0()); }
		ruleRichStringLiteralStart
		{ after(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralStartParserRuleCall_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__ExpressionsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_1_0()); }
		ruleRichStringPart
		{ after(grammarAccess.getRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__ExpressionsAssignment_1_1_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0()); }
		ruleRichStringLiteralInbetween
		{ after(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__ExpressionsAssignment_1_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_2_1_0()); }
		ruleRichStringPart
		{ after(grammarAccess.getRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichString__ExpressionsAssignment_1_1_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0()); }
		ruleRichStringLiteralEnd
		{ after(grammarAccess.getRichStringAccess().getExpressionsRichStringLiteralEndParserRuleCall_1_1_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteral__ValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralAccess().getValueRICH_TEXTTerminalRuleCall_1_0()); }
		RULE_RICH_TEXT
		{ after(grammarAccess.getRichStringLiteralAccess().getValueRICH_TEXTTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralStart__ValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralStartAccess().getValueRICH_TEXT_STARTTerminalRuleCall_1_0()); }
		RULE_RICH_TEXT_START
		{ after(grammarAccess.getRichStringLiteralStartAccess().getValueRICH_TEXT_STARTTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralInbetween__ValueAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralInbetweenAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0()); }
		RULE_RICH_TEXT_INBETWEEN
		{ after(grammarAccess.getRichStringLiteralInbetweenAccess().getValueRICH_TEXT_INBETWEENTerminalRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralInbetween__ValueAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralInbetweenAccess().getValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0()); }
		RULE_COMMENT_RICH_TEXT_INBETWEEN
		{ after(grammarAccess.getRichStringLiteralInbetweenAccess().getValueCOMMENT_RICH_TEXT_INBETWEENTerminalRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralEnd__ValueAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralEndAccess().getValueRICH_TEXT_ENDTerminalRuleCall_1_0_0()); }
		RULE_RICH_TEXT_END
		{ after(grammarAccess.getRichStringLiteralEndAccess().getValueRICH_TEXT_ENDTerminalRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringLiteralEnd__ValueAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringLiteralEndAccess().getValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0()); }
		RULE_COMMENT_RICH_TEXT_END
		{ after(grammarAccess.getRichStringLiteralEndAccess().getValueCOMMENT_RICH_TEXT_ENDTerminalRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__ExpressionsAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0()); }
		ruleRichStringLiteralInbetween
		{ after(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__ExpressionsAssignment_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_0_0()); }
		ruleRichStringPart
		{ after(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringPartParserRuleCall_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__InternalRichString__ExpressionsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0()); }
		ruleRichStringLiteralInbetween
		{ after(grammarAccess.getInternalRichStringAccess().getExpressionsRichStringLiteralInbetweenParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__DeclaredParamAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringForLoopAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getRichStringForLoopAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__ForExpressionAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringForLoopAccess().getForExpressionXExpressionParserRuleCall_4_0()); }
		ruleXExpression
		{ after(grammarAccess.getRichStringForLoopAccess().getForExpressionXExpressionParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__BeforeAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringForLoopAccess().getBeforeXExpressionParserRuleCall_5_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getRichStringForLoopAccess().getBeforeXExpressionParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__SeparatorAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringForLoopAccess().getSeparatorXExpressionParserRuleCall_6_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getRichStringForLoopAccess().getSeparatorXExpressionParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__AfterAssignment_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringForLoopAccess().getAfterXExpressionParserRuleCall_7_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getRichStringForLoopAccess().getAfterXExpressionParserRuleCall_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringForLoop__EachExpressionAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringForLoopAccess().getEachExpressionInternalRichStringParserRuleCall_8_0()); }
		ruleInternalRichString
		{ after(grammarAccess.getRichStringForLoopAccess().getEachExpressionInternalRichStringParserRuleCall_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__IfAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringIfAccess().getIfXExpressionParserRuleCall_2_0()); }
		ruleXExpression
		{ after(grammarAccess.getRichStringIfAccess().getIfXExpressionParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__ThenAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringIfAccess().getThenInternalRichStringParserRuleCall_3_0()); }
		ruleInternalRichString
		{ after(grammarAccess.getRichStringIfAccess().getThenInternalRichStringParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__ElseIfsAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringIfAccess().getElseIfsRichStringElseIfParserRuleCall_4_0()); }
		ruleRichStringElseIf
		{ after(grammarAccess.getRichStringIfAccess().getElseIfsRichStringElseIfParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringIf__ElseAssignment_5_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringIfAccess().getElseInternalRichStringParserRuleCall_5_1_0()); }
		ruleInternalRichString
		{ after(grammarAccess.getRichStringIfAccess().getElseInternalRichStringParserRuleCall_5_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringElseIf__IfAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringElseIfAccess().getIfXExpressionParserRuleCall_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getRichStringElseIfAccess().getIfXExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RichStringElseIf__ThenAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRichStringElseIfAccess().getThenInternalRichStringParserRuleCall_2_0()); }
		ruleInternalRichString
		{ after(grammarAccess.getRichStringElseIfAccess().getThenInternalRichStringParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__AnnotationTypeAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationAccess().getAnnotationTypeJvmAnnotationTypeCrossReference_2_0()); }
		(
			{ before(grammarAccess.getXAnnotationAccess().getAnnotationTypeJvmAnnotationTypeQualifiedNameParserRuleCall_2_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getXAnnotationAccess().getAnnotationTypeJvmAnnotationTypeQualifiedNameParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getXAnnotationAccess().getAnnotationTypeJvmAnnotationTypeCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__ElementValuePairsAssignment_3_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0()); }
		ruleXAnnotationElementValuePair
		{ after(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__ElementValuePairsAssignment_3_1_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0()); }
		ruleXAnnotationElementValuePair
		{ after(grammarAccess.getXAnnotationAccess().getElementValuePairsXAnnotationElementValuePairParserRuleCall_3_1_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotation__ValueAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationAccess().getValueXAnnotationElementValueOrCommaListParserRuleCall_3_1_1_0()); }
		ruleXAnnotationElementValueOrCommaList
		{ after(grammarAccess.getXAnnotationAccess().getValueXAnnotationElementValueOrCommaListParserRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__ElementAssignment_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationCrossReference_0_0_0_0()); }
		(
			{ before(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationValidIDParserRuleCall_0_0_0_0_1()); }
			ruleValidID
			{ after(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationValidIDParserRuleCall_0_0_0_0_1()); }
		)
		{ after(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationCrossReference_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValuePair__ValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValuePairAccess().getValueXAnnotationElementValueParserRuleCall_1_0()); }
		ruleXAnnotationElementValue
		{ after(grammarAccess.getXAnnotationElementValuePairAccess().getValueXAnnotationElementValueParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__ElementsAssignment_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0()); }
		ruleXAnnotationOrExpression
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__ElementsAssignment_0_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0()); }
		ruleXAnnotationOrExpression
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValueOrCommaList__ElementsAssignment_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_1_1_1_1_0()); }
		ruleXAnnotationOrExpression
		{ after(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsXAnnotationOrExpressionParserRuleCall_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__ElementsAssignment_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0()); }
		ruleXAnnotationOrExpression
		{ after(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAnnotationElementValue__ElementsAssignment_0_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0()); }
		ruleXAnnotationOrExpression
		{ after(grammarAccess.getXAnnotationElementValueAccess().getElementsXAnnotationOrExpressionParserRuleCall_0_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__FeatureAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1()); }
			ruleOpOr
			{ after(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOrExpression__RightOperandAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); }
		ruleXAndExpression
		{ after(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__FeatureAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1()); }
			ruleOpAnd
			{ after(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAndExpression__RightOperandAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); }
		ruleXEqualityExpression
		{ after(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__FeatureAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1()); }
			ruleOpEquality
			{ after(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XEqualityExpression__RightOperandAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); }
		ruleXRelationalExpression
		{ after(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__TypeAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__FeatureAssignment_1_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1()); }
			ruleOpCompare
			{ after(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XRelationalExpression__RightOperandAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); }
		ruleXOtherOperatorExpression
		{ after(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__FeatureAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1()); }
			ruleOpOther
			{ after(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XOtherOperatorExpression__RightOperandAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); }
		ruleXAdditiveExpression
		{ after(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__FeatureAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1()); }
			ruleOpAdd
			{ after(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XAdditiveExpression__RightOperandAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); }
		ruleXMultiplicativeExpression
		{ after(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__FeatureAssignment_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1()); }
			ruleOpMulti
			{ after(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMultiplicativeExpression__RightOperandAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); }
		ruleXUnaryOperation
		{ after(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__FeatureAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); }
		(
			{ before(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1()); }
			ruleOpUnary
			{ after(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1()); }
		)
		{ after(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XUnaryOperation__OperandAssignment_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0()); }
		ruleXUnaryOperation
		{ after(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCastedExpression__TypeAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XPostfixOperation__FeatureAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0()); }
		(
			{ before(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1()); }
			ruleOpPostfix
			{ after(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1()); }
		)
		{ after(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__ExplicitStaticAssignment_1_0_0_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0()); }
		(
			{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0()); }
			'::'
			{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0()); }
		)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__FeatureAssignment_1_0_0_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); }
		(
			{ before(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1()); }
			ruleFeatureCallID
			{ after(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1()); }
		)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__ValueAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); }
		ruleXAssignment
		{ after(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__NullSafeAssignment_1_1_0_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0()); }
		(
			{ before(grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0()); }
			'?.'
			{ after(grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0()); }
		)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__ExplicitStaticAssignment_1_1_0_0_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0()); }
		(
			{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0()); }
			'::'
			{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0()); }
		)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__TypeArgumentsAssignment_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__TypeArgumentsAssignment_1_1_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__FeatureAssignment_1_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); }
		(
			{ before(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1()); }
			ruleIdOrSuper
			{ after(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1()); }
		)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__ExplicitOperationCallAssignment_1_1_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0()); }
		(
			{ before(grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0()); }
			'('
			{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0()); }
		)
		{ after(grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); }
		ruleXShortClosure
		{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); }
		ruleXExpression
		{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); }
		ruleXClosure
		{ after(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__ElementsAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0()); }
		ruleXExpression
		{ after(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSetLiteral__ElementsAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__ElementsAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0()); }
		ruleXExpression
		{ after(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XListLiteral__ElementsAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__DeclaredFormalParametersAssignment_1_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__DeclaredFormalParametersAssignment_1_0_0_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__ExplicitSyntaxAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0()); }
		(
			{ before(grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0()); }
			'|'
			{ after(grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0()); }
		)
		{ after(grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XClosure__ExpressionAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0()); }
		ruleXExpressionInClosure
		{ after(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XExpressionInClosure__ExpressionsAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0()); }
		ruleXExpressionOrVarDeclaration
		{ after(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__DeclaredFormalParametersAssignment_0_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__DeclaredFormalParametersAssignment_0_0_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__ExplicitSyntaxAssignment_0_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0()); }
		(
			{ before(grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0()); }
			'|'
			{ after(grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0()); }
		)
		{ after(grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XShortClosure__ExpressionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__IfAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); }
		ruleXExpression
		{ after(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__ThenAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); }
		ruleXExpression
		{ after(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XIfExpression__ElseAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__DeclaredParamAssignment_0_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0()); }
		ruleJvmFormalParameter
		{ after(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__ForExpressionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XForLoopExpression__EachExpressionAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0()); }
		ruleXExpression
		{ after(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__InitExpressionsAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0()); }
		ruleXExpressionOrVarDeclaration
		{ after(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__InitExpressionsAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0()); }
		ruleXExpressionOrVarDeclaration
		{ after(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__ExpressionAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0()); }
		ruleXExpression
		{ after(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__UpdateExpressionsAssignment_7_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0()); }
		ruleXExpression
		{ after(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__UpdateExpressionsAssignment_7_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBasicForLoopExpression__EachExpressionAssignment_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0()); }
		ruleXExpression
		{ after(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__PredicateAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); }
		ruleXExpression
		{ after(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XWhileExpression__BodyAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); }
		ruleXExpression
		{ after(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__BodyAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); }
		ruleXExpression
		{ after(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XDoWhileExpression__PredicateAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); }
		ruleXExpression
		{ after(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBlockExpression__ExpressionsAssignment_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0()); }
		ruleXExpressionOrVarDeclaration
		{ after(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__TypeArgumentsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__TypeArgumentsAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__FeatureAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0()); }
		(
			{ before(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1()); }
			ruleIdOrSuper
			{ after(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__ExplicitOperationCallAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0()); }
		(
			{ before(grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0()); }
			'('
			{ after(grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0()); }
		)
		{ after(grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0()); }
		ruleXShortClosure
		{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0()); }
		ruleXExpression
		{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFeatureCall__FeatureCallArgumentsAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0()); }
		ruleXClosure
		{ after(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XBooleanLiteral__IsTrueAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
		(
			{ before(grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
			'true'
			{ after(grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
		)
		{ after(grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XNumberLiteral__ValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); }
		ruleNumber
		{ after(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__TypeAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); }
		(
			{ before(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeQualifiedNameParserRuleCall_3_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeQualifiedNameParserRuleCall_3_0_1()); }
		)
		{ after(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XTypeLiteral__ArrayDimensionsAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0()); }
		ruleArrayBrackets
		{ after(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XThrowExpression__ExpressionAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); }
		ruleXExpression
		{ after(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XReturnExpression__ExpressionAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); }
		ruleXExpression
		{ after(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__ParamAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0()); }
		ruleXExpression
		{ after(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XSynchronizedExpression__ExpressionAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0()); }
		ruleXExpression
		{ after(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__DeclaredParamAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); }
		ruleFullJvmFormalParameter
		{ after(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XCatchClause__ExpressionAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); }
		ruleXExpression
		{ after(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__ReturnTypeAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__TypeAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); }
		(
			{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0()); }
		(
			{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); }
			ruleValidID
			{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); }
		)
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); }
		ruleJvmUpperBound
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); }
		ruleJvmUpperBoundAnded
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); }
		ruleJvmLowerBound
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); }
		ruleJvmLowerBoundAnded
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmTypeParameterAccess().getNameValidIDParserRuleCall_0_0()); }
		ruleValidID
		{ after(grammarAccess.getJvmTypeParameterAccess().getNameValidIDParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__ConstraintsAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0()); }
		ruleJvmUpperBound
		{ after(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeParameter__ConstraintsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0()); }
		ruleJvmUpperBoundAnded
		{ after(grammarAccess.getJvmTypeParameterAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportSection__ImportDeclarationsAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportSectionAccess().getImportDeclarationsXImportDeclarationParserRuleCall_0()); }
		ruleXImportDeclaration
		{ after(grammarAccess.getXImportSectionAccess().getImportDeclarationsXImportDeclarationParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__StaticAssignment_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
			'static'
			{ after(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ExtensionAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
			'extension'
			{ after(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ImportedTypeAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1()); }
			ruleQualifiedNameInStaticImport
			{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__WildcardAssignment_1_0_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
			'*'
			{ after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__MemberNameAssignment_1_0_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); }
		ruleValidID
		{ after(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ImportedTypeAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ImportedNamespaceAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); }
		ruleQualifiedNameWithWildcard
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? (RULE_IDENTIFIER_START|RULE_UNICODE_ESCAPE) (RULE_IDENTIFIER_PART|RULE_UNICODE_ESCAPE)*;

fragment RULE_HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_UNICODE_ESCAPE : '\\' 'u' (RULE_HEX_DIGIT (RULE_HEX_DIGIT (RULE_HEX_DIGIT RULE_HEX_DIGIT?)?)?)?;

RULE_RICH_TEXT : '\'\'\'' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_RICH_TEXT_START : '\'\'\'' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';

RULE_RICH_TEXT_END : '\u00BB' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF);

RULE_RICH_TEXT_INBETWEEN : '\u00BB' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB';

RULE_COMMENT_RICH_TEXT_INBETWEEN : '\u00AB\u00AB' ~(('\n'|'\r'))* ('\r'? '\n' RULE_IN_RICH_STRING* ('\'' '\''?)? '\u00AB')?;

RULE_COMMENT_RICH_TEXT_END : '\u00AB\u00AB' ~(('\n'|'\r'))* ('\r'? '\n' RULE_IN_RICH_STRING* ('\'\'\''|('\'' '\''?)? EOF)|EOF);

fragment RULE_IN_RICH_STRING : ('\'\'' ~(('\u00AB'|'\''))|'\'' ~(('\u00AB'|'\''))|~(('\u00AB'|'\'')));

fragment RULE_IDENTIFIER_START : ('$'|'A'..'Z'|'_'|'a'..'z'|'\u00A2'..'\u00A5'|'\u00AA'|'\u00B5'|'\u00BA'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u0236'|'\u0250'..'\u02C1'|'\u02C6'..'\u02D1'|'\u02E0'..'\u02E4'|'\u02EE'|'\u037A'|'\u0386'|'\u0388'..'\u038A'|'\u038C'|'\u038E'..'\u03A1'|'\u03A3'..'\u03CE'|'\u03D0'..'\u03F5'|'\u03F7'..'\u03FB'|'\u0400'..'\u0481'|'\u048A'..'\u04CE'|'\u04D0'..'\u04F5'|'\u04F8'..'\u04F9'|'\u0500'..'\u050F'|'\u0531'..'\u0556'|'\u0559'|'\u0561'..'\u0587'|'\u05D0'..'\u05EA'|'\u05F0'..'\u05F2'|'\u0621'..'\u063A'|'\u0640'..'\u064A'|'\u066E'..'\u066F'|'\u0671'..'\u06D3'|'\u06D5'|'\u06E5'..'\u06E6'|'\u06EE'..'\u06EF'|'\u06FA'..'\u06FC'|'\u06FF'|'\u0710'|'\u0712'..'\u072F'|'\u074D'..'\u074F'|'\u0780'..'\u07A5'|'\u07B1'|'\u0904'..'\u0939'|'\u093D'|'\u0950'|'\u0958'..'\u0961'|'\u0985'..'\u098C'|'\u098F'..'\u0990'|'\u0993'..'\u09A8'|'\u09AA'..'\u09B0'|'\u09B2'|'\u09B6'..'\u09B9'|'\u09BD'|'\u09DC'..'\u09DD'|'\u09DF'..'\u09E1'|'\u09F0'..'\u09F3'|'\u0A05'..'\u0A0A'|'\u0A0F'..'\u0A10'|'\u0A13'..'\u0A28'|'\u0A2A'..'\u0A30'|'\u0A32'..'\u0A33'|'\u0A35'..'\u0A36'|'\u0A38'..'\u0A39'|'\u0A59'..'\u0A5C'|'\u0A5E'|'\u0A72'..'\u0A74'|'\u0A85'..'\u0A8D'|'\u0A8F'..'\u0A91'|'\u0A93'..'\u0AA8'|'\u0AAA'..'\u0AB0'|'\u0AB2'..'\u0AB3'|'\u0AB5'..'\u0AB9'|'\u0ABD'|'\u0AD0'|'\u0AE0'..'\u0AE1'|'\u0AF1'|'\u0B05'..'\u0B0C'|'\u0B0F'..'\u0B10'|'\u0B13'..'\u0B28'|'\u0B2A'..'\u0B30'|'\u0B32'..'\u0B33'|'\u0B35'..'\u0B39'|'\u0B3D'|'\u0B5C'..'\u0B5D'|'\u0B5F'..'\u0B61'|'\u0B71'|'\u0B83'|'\u0B85'..'\u0B8A'|'\u0B8E'..'\u0B90'|'\u0B92'..'\u0B95'|'\u0B99'..'\u0B9A'|'\u0B9C'|'\u0B9E'..'\u0B9F'|'\u0BA3'..'\u0BA4'|'\u0BA8'..'\u0BAA'|'\u0BAE'..'\u0BB5'|'\u0BB7'..'\u0BB9'|'\u0BF9'|'\u0C05'..'\u0C0C'|'\u0C0E'..'\u0C10'|'\u0C12'..'\u0C28'|'\u0C2A'..'\u0C33'|'\u0C35'..'\u0C39'|'\u0C60'..'\u0C61'|'\u0C85'..'\u0C8C'|'\u0C8E'..'\u0C90'|'\u0C92'..'\u0CA8'|'\u0CAA'..'\u0CB3'|'\u0CB5'..'\u0CB9'|'\u0CBD'|'\u0CDE'|'\u0CE0'..'\u0CE1'|'\u0D05'..'\u0D0C'|'\u0D0E'..'\u0D10'|'\u0D12'..'\u0D28'|'\u0D2A'..'\u0D39'|'\u0D60'..'\u0D61'|'\u0D85'..'\u0D96'|'\u0D9A'..'\u0DB1'|'\u0DB3'..'\u0DBB'|'\u0DBD'|'\u0DC0'..'\u0DC6'|'\u0E01'..'\u0E30'|'\u0E32'..'\u0E33'|'\u0E3F'..'\u0E46'|'\u0E81'..'\u0E82'|'\u0E84'|'\u0E87'..'\u0E88'|'\u0E8A'|'\u0E8D'|'\u0E94'..'\u0E97'|'\u0E99'..'\u0E9F'|'\u0EA1'..'\u0EA3'|'\u0EA5'|'\u0EA7'|'\u0EAA'..'\u0EAB'|'\u0EAD'..'\u0EB0'|'\u0EB2'..'\u0EB3'|'\u0EBD'|'\u0EC0'..'\u0EC4'|'\u0EC6'|'\u0EDC'..'\u0EDD'|'\u0F00'|'\u0F40'..'\u0F47'|'\u0F49'..'\u0F6A'|'\u0F88'..'\u0F8B'|'\u1000'..'\u1021'|'\u1023'..'\u1027'|'\u1029'..'\u102A'|'\u1050'..'\u1055'|'\u10A0'..'\u10C5'|'\u10D0'..'\u10F8'|'\u1100'..'\u1159'|'\u115F'..'\u11A2'|'\u11A8'..'\u11F9'|'\u1200'..'\u1206'|'\u1208'..'\u1246'|'\u1248'|'\u124A'..'\u124D'|'\u1250'..'\u1256'|'\u1258'|'\u125A'..'\u125D'|'\u1260'..'\u1286'|'\u1288'|'\u128A'..'\u128D'|'\u1290'..'\u12AE'|'\u12B0'|'\u12B2'..'\u12B5'|'\u12B8'..'\u12BE'|'\u12C0'|'\u12C2'..'\u12C5'|'\u12C8'..'\u12CE'|'\u12D0'..'\u12D6'|'\u12D8'..'\u12EE'|'\u12F0'..'\u130E'|'\u1310'|'\u1312'..'\u1315'|'\u1318'..'\u131E'|'\u1320'..'\u1346'|'\u1348'..'\u135A'|'\u13A0'..'\u13F4'|'\u1401'..'\u166C'|'\u166F'..'\u1676'|'\u1681'..'\u169A'|'\u16A0'..'\u16EA'|'\u16EE'..'\u16F0'|'\u1700'..'\u170C'|'\u170E'..'\u1711'|'\u1720'..'\u1731'|'\u1740'..'\u1751'|'\u1760'..'\u176C'|'\u176E'..'\u1770'|'\u1780'..'\u17B3'|'\u17D7'|'\u17DB'..'\u17DC'|'\u1820'..'\u1877'|'\u1880'..'\u18A8'|'\u1900'..'\u191C'|'\u1950'..'\u196D'|'\u1970'..'\u1974'|'\u1D00'..'\u1D6B'|'\u1E00'..'\u1E9B'|'\u1EA0'..'\u1EF9'|'\u1F00'..'\u1F15'|'\u1F18'..'\u1F1D'|'\u1F20'..'\u1F45'|'\u1F48'..'\u1F4D'|'\u1F50'..'\u1F57'|'\u1F59'|'\u1F5B'|'\u1F5D'|'\u1F5F'..'\u1F7D'|'\u1F80'..'\u1FB4'|'\u1FB6'..'\u1FBC'|'\u1FBE'|'\u1FC2'..'\u1FC4'|'\u1FC6'..'\u1FCC'|'\u1FD0'..'\u1FD3'|'\u1FD6'..'\u1FDB'|'\u1FE0'..'\u1FEC'|'\u1FF2'..'\u1FF4'|'\u1FF6'..'\u1FFC'|'\u203F'..'\u2040'|'\u2054'|'\u2071'|'\u207F'|'\u20A0'..'\u20B1'|'\u2102'|'\u2107'|'\u210A'..'\u2113'|'\u2115'|'\u2119'..'\u211D'|'\u2124'|'\u2126'|'\u2128'|'\u212A'..'\u212D'|'\u212F'..'\u2131'|'\u2133'..'\u2139'|'\u213D'..'\u213F'|'\u2145'..'\u2149'|'\u2160'..'\u2183'|'\u3005'..'\u3007'|'\u3021'..'\u3029'|'\u3031'..'\u3035'|'\u3038'..'\u303C'|'\u3041'..'\u3096'|'\u309D'..'\u309F'|'\u30A1'..'\u30FF'|'\u3105'..'\u312C'|'\u3131'..'\u318E'|'\u31A0'..'\u31B7'|'\u31F0'..'\u31FF'|'\u3400'..'\u4DB5'|'\u4E00'..'\u9FA5'|'\uA000'..'\uA48C'|'\uAC00'..'\uD7A3'|'\uF900'..'\uFA2D'|'\uFA30'..'\uFA6A'|'\uFB00'..'\uFB06'|'\uFB13'..'\uFB17'|'\uFB1D'|'\uFB1F'..'\uFB28'|'\uFB2A'..'\uFB36'|'\uFB38'..'\uFB3C'|'\uFB3E'|'\uFB40'..'\uFB41'|'\uFB43'..'\uFB44'|'\uFB46'..'\uFBB1'|'\uFBD3'..'\uFD3D'|'\uFD50'..'\uFD8F'|'\uFD92'..'\uFDC7'|'\uFDF0'..'\uFDFC'|'\uFE33'..'\uFE34'|'\uFE4D'..'\uFE4F'|'\uFE69'|'\uFE70'..'\uFE74'|'\uFE76'..'\uFEFC'|'\uFF04'|'\uFF21'..'\uFF3A'|'\uFF3F'|'\uFF41'..'\uFF5A'|'\uFF65'..'\uFFBE'|'\uFFC2'..'\uFFC7'|'\uFFCA'..'\uFFCF'|'\uFFD2'..'\uFFD7'|'\uFFDA'..'\uFFDC'|'\uFFE0'..'\uFFE1'|'\uFFE5'..'\uFFE6');

fragment RULE_IDENTIFIER_PART : (RULE_IDENTIFIER_START|RULE_IDENTIFIER_PART_IMPL);

fragment RULE_IDENTIFIER_PART_IMPL : ('\u0000'..'\b'|'\u000E'..'\u001B'|'0'..'9'|'\u007F'..'\u009F'|'\u00AD'|'\u0300'..'\u0357'|'\u035D'..'\u036F'|'\u0483'..'\u0486'|'\u0591'..'\u05A1'|'\u05A3'..'\u05B9'|'\u05BB'..'\u05BD'|'\u05BF'|'\u05C1'..'\u05C2'|'\u05C4'|'\u0600'..'\u0603'|'\u0610'..'\u0615'|'\u064B'..'\u0658'|'\u0660'..'\u0669'|'\u0670'|'\u06D6'..'\u06DD'|'\u06DF'..'\u06E4'|'\u06E7'..'\u06E8'|'\u06EA'..'\u06ED'|'\u06F0'..'\u06F9'|'\u070F'|'\u0711'|'\u0730'..'\u074A'|'\u07A6'..'\u07B0'|'\u0901'..'\u0903'|'\u093C'|'\u093E'..'\u094D'|'\u0951'..'\u0954'|'\u0962'..'\u0963'|'\u0966'..'\u096F'|'\u0981'..'\u0983'|'\u09BC'|'\u09BE'..'\u09C4'|'\u09C7'..'\u09C8'|'\u09CB'..'\u09CD'|'\u09D7'|'\u09E2'..'\u09E3'|'\u09E6'..'\u09EF'|'\u0A01'..'\u0A03'|'\u0A3C'|'\u0A3E'..'\u0A42'|'\u0A47'..'\u0A48'|'\u0A4B'..'\u0A4D'|'\u0A66'..'\u0A71'|'\u0A81'..'\u0A83'|'\u0ABC'|'\u0ABE'..'\u0AC5'|'\u0AC7'..'\u0AC9'|'\u0ACB'..'\u0ACD'|'\u0AE2'..'\u0AE3'|'\u0AE6'..'\u0AEF'|'\u0B01'..'\u0B03'|'\u0B3C'|'\u0B3E'..'\u0B43'|'\u0B47'..'\u0B48'|'\u0B4B'..'\u0B4D'|'\u0B56'..'\u0B57'|'\u0B66'..'\u0B6F'|'\u0B82'|'\u0BBE'..'\u0BC2'|'\u0BC6'..'\u0BC8'|'\u0BCA'..'\u0BCD'|'\u0BD7'|'\u0BE7'..'\u0BEF'|'\u0C01'..'\u0C03'|'\u0C3E'..'\u0C44'|'\u0C46'..'\u0C48'|'\u0C4A'..'\u0C4D'|'\u0C55'..'\u0C56'|'\u0C66'..'\u0C6F'|'\u0C82'..'\u0C83'|'\u0CBC'|'\u0CBE'..'\u0CC4'|'\u0CC6'..'\u0CC8'|'\u0CCA'..'\u0CCD'|'\u0CD5'..'\u0CD6'|'\u0CE6'..'\u0CEF'|'\u0D02'..'\u0D03'|'\u0D3E'..'\u0D43'|'\u0D46'..'\u0D48'|'\u0D4A'..'\u0D4D'|'\u0D57'|'\u0D66'..'\u0D6F'|'\u0D82'..'\u0D83'|'\u0DCA'|'\u0DCF'..'\u0DD4'|'\u0DD6'|'\u0DD8'..'\u0DDF'|'\u0DF2'..'\u0DF3'|'\u0E31'|'\u0E34'..'\u0E3A'|'\u0E47'..'\u0E4E'|'\u0E50'..'\u0E59'|'\u0EB1'|'\u0EB4'..'\u0EB9'|'\u0EBB'..'\u0EBC'|'\u0EC8'..'\u0ECD'|'\u0ED0'..'\u0ED9'|'\u0F18'..'\u0F19'|'\u0F20'..'\u0F29'|'\u0F35'|'\u0F37'|'\u0F39'|'\u0F3E'..'\u0F3F'|'\u0F71'..'\u0F84'|'\u0F86'..'\u0F87'|'\u0F90'..'\u0F97'|'\u0F99'..'\u0FBC'|'\u0FC6'|'\u102C'..'\u1032'|'\u1036'..'\u1039'|'\u1040'..'\u1049'|'\u1056'..'\u1059'|'\u1369'..'\u1371'|'\u1712'..'\u1714'|'\u1732'..'\u1734'|'\u1752'..'\u1753'|'\u1772'..'\u1773'|'\u17B4'..'\u17D3'|'\u17DD'|'\u17E0'..'\u17E9'|'\u180B'..'\u180D'|'\u1810'..'\u1819'|'\u18A9'|'\u1920'..'\u192B'|'\u1930'..'\u193B'|'\u1946'..'\u194F'|'\u200C'..'\u200F'|'\u202A'..'\u202E'|'\u2060'..'\u2063'|'\u206A'..'\u206F'|'\u20D0'..'\u20DC'|'\u20E1'|'\u20E5'..'\u20EA'|'\u302A'..'\u302F'|'\u3099'..'\u309A'|'\uFB1E'|'\uFE00'..'\uFE0F'|'\uFE20'..'\uFE23'|'\uFEFF'|'\uFF10'..'\uFF19'|'\uFFF9'..'\uFFFB');

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
