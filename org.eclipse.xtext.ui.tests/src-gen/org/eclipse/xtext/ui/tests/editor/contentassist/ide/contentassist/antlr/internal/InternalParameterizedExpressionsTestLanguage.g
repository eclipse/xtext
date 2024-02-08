/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalParameterizedExpressionsTestLanguage;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@lexer::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParameterizedExpressionsTestLanguageGrammarAccess;

}
@parser::members {
	private ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess;

	public void setGrammarAccess(ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess) {
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

// Entry rule entryRuleRootStatement
entryRuleRootStatement
:
{ before(grammarAccess.getRootStatementRule()); }
	 ruleRootStatement
{ after(grammarAccess.getRootStatementRule()); } 
	 EOF 
;

// Rule RootStatement
ruleRootStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRootStatementAccess().getAlternatives(), 0
		); }
		(rule__RootStatement__Alternatives)
		{ after(grammarAccess.getRootStatementAccess().getAlternatives(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule RootStatement
norm1_RootStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRootStatementAccess().getAlternatives(), 1
		); }
		(norm1_RootStatement__Alternatives)
		{ after(grammarAccess.getRootStatementAccess().getAlternatives(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFunctionDeclaration
entryRuleFunctionDeclaration
:
{ before(grammarAccess.getFunctionDeclarationRule()); }
	 ruleFunctionDeclaration
{ after(grammarAccess.getFunctionDeclarationRule()); } 
	 EOF 
;

// Rule FunctionDeclaration
ruleFunctionDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionDeclarationAccess().getGroup(), 0
		); }
		(rule__FunctionDeclaration__Group__0)
		{ after(grammarAccess.getFunctionDeclarationAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionDeclaration
norm1_FunctionDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionDeclarationAccess().getGroup(), 1
		); }
		(norm1_FunctionDeclaration__Group__0)
		{ after(grammarAccess.getFunctionDeclarationAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionImpl
ruleFunctionImpl 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionImplAccess().getGroup(), 0
		); }
		(rule__FunctionImpl__Group__0)
		{ after(grammarAccess.getFunctionImplAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionImpl
norm3_FunctionImpl 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionImplAccess().getGroup(), 3
		); }
		(norm3_FunctionImpl__Group__0)
		{ after(grammarAccess.getFunctionImplAccess().getGroup(), 3
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionHeader
ruleFunctionHeader 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getGroup(), 0
		); }
		(rule__FunctionHeader__Group__0)
		{ after(grammarAccess.getFunctionHeaderAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionHeader
norm1_FunctionHeader 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getGroup(), 1
		); }
		(norm1_FunctionHeader__Group__0)
		{ after(grammarAccess.getFunctionHeaderAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionHeader
norm2_FunctionHeader 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getGroup(), 2
		); }
		(norm2_FunctionHeader__Group__0)
		{ after(grammarAccess.getFunctionHeaderAccess().getGroup(), 2
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionHeader
norm3_FunctionHeader 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getGroup(), 3
		); }
		(norm3_FunctionHeader__Group__0)
		{ after(grammarAccess.getFunctionHeaderAccess().getGroup(), 3
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionBody
ruleFunctionBody 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyAssignment_1_0(), 0
		); }
		(rule__FunctionBody__BodyAssignment_1_0)?
		{ after(grammarAccess.getFunctionBodyAccess().getBodyAssignment_1_0(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionBody
norm1_FunctionBody 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyAssignment_1_0(), 1
		); }
		(norm1_FunctionBody__BodyAssignment_1_0)?
		{ after(grammarAccess.getFunctionBodyAccess().getBodyAssignment_1_0(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionBody
norm2_FunctionBody 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyAssignment_0_0(), 2
		); }
		(norm2_FunctionBody__BodyAssignment_0_0)
		{ after(grammarAccess.getFunctionBodyAccess().getBodyAssignment_0_0(), 2
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule FunctionBody
norm3_FunctionBody 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyAssignment_0_0(), 3
		); }
		(norm3_FunctionBody__BodyAssignment_0_0)
		{ after(grammarAccess.getFunctionBodyAccess().getBodyAssignment_0_0(), 3
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBlock
entryRuleBlock
:
{ before(grammarAccess.getBlockRule()); }
	 ruleBlock
{ after(grammarAccess.getBlockRule()); } 
	 EOF 
;

// Rule Block
ruleBlock 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBlockAccess().getGroup(), 0
		); }
		(rule__Block__Group__0)
		{ after(grammarAccess.getBlockAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Block
norm1_Block 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBlockAccess().getGroup(), 1
		); }
		(norm1_Block__Group__0)
		{ after(grammarAccess.getBlockAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStatement
entryRuleStatement
:
{ before(grammarAccess.getStatementRule()); }
	 ruleStatement
{ after(grammarAccess.getStatementRule()); } 
	 EOF 
;

// Rule Statement
ruleStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStatementAccess().getAlternatives(), 0
		); }
		(rule__Statement__Alternatives)
		{ after(grammarAccess.getStatementAccess().getAlternatives(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Statement
norm1_Statement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStatementAccess().getAlternatives(), 1
		); }
		(norm1_Statement__Alternatives)
		{ after(grammarAccess.getStatementAccess().getAlternatives(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExpressionStatement
entryRuleExpressionStatement
:
{ before(grammarAccess.getExpressionStatementRule()); }
	 ruleExpressionStatement
{ after(grammarAccess.getExpressionStatementRule()); } 
	 EOF 
;

// Rule ExpressionStatement
ruleExpressionStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionStatementAccess().getGroup(), 0
		); }
		(rule__ExpressionStatement__Group__0)
		{ after(grammarAccess.getExpressionStatementAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule ExpressionStatement
norm1_ExpressionStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionStatementAccess().getGroup(), 1
		); }
		(norm1_ExpressionStatement__Group__0)
		{ after(grammarAccess.getExpressionStatementAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLabelledStatement
entryRuleLabelledStatement
:
{ before(grammarAccess.getLabelledStatementRule()); }
	 ruleLabelledStatement
{ after(grammarAccess.getLabelledStatementRule()); } 
	 EOF 
;

// Rule LabelledStatement
ruleLabelledStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLabelledStatementAccess().getGroup(), 0
		); }
		(rule__LabelledStatement__Group__0)
		{ after(grammarAccess.getLabelledStatementAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule LabelledStatement
norm1_LabelledStatement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLabelledStatementAccess().getGroup(), 1
		); }
		(norm1_LabelledStatement__Group__0)
		{ after(grammarAccess.getLabelledStatementAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePrimaryExpression
entryRulePrimaryExpression
:
{ before(grammarAccess.getPrimaryExpressionRule()); }
	 rulePrimaryExpression
{ after(grammarAccess.getPrimaryExpressionRule()); } 
	 EOF 
;

// Rule PrimaryExpression
rulePrimaryExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall(), 0
		); }
		ruleIdentifierRef
		{ after(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule PrimaryExpression
norm1_PrimaryExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall(), 1
		); }
		norm1_IdentifierRef
		{ after(grammarAccess.getPrimaryExpressionAccess().getIdentifierRefParserRuleCall(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIdentifierRef
entryRuleIdentifierRef
:
{ before(grammarAccess.getIdentifierRefRule()); }
	 ruleIdentifierRef
{ after(grammarAccess.getIdentifierRefRule()); } 
	 EOF 
;

// Rule IdentifierRef
ruleIdentifierRef 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdentifierRefAccess().getIdAssignment(), 0
		); }
		(rule__IdentifierRef__IdAssignment)
		{ after(grammarAccess.getIdentifierRefAccess().getIdAssignment(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule IdentifierRef
norm1_IdentifierRef 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdentifierRefAccess().getIdAssignment(), 1
		); }
		(norm1_IdentifierRef__IdAssignment)
		{ after(grammarAccess.getIdentifierRefAccess().getIdAssignment(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleMemberExpression
entryRuleMemberExpression
:
{ before(grammarAccess.getMemberExpressionRule()); }
	 ruleMemberExpression
{ after(grammarAccess.getMemberExpressionRule()); } 
	 EOF 
;

// Rule MemberExpression
ruleMemberExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMemberExpressionAccess().getGroup(), 0
		); }
		(rule__MemberExpression__Group__0)
		{ after(grammarAccess.getMemberExpressionAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule MemberExpression
norm1_MemberExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMemberExpressionAccess().getGroup(), 1
		); }
		(norm1_MemberExpression__Group__0)
		{ after(grammarAccess.getMemberExpressionAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule IndexedAccessExpressionTail
ruleIndexedAccessExpressionTail 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getGroup(), 0
		); }
		(rule__IndexedAccessExpressionTail__Group__0)
		{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule IndexedAccessExpressionTail
norm1_IndexedAccessExpressionTail 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getGroup(), 1
		); }
		(norm1_IndexedAccessExpressionTail__Group__0)
		{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule ParameterizedPropertyAccessExpressionTail
ruleParameterizedPropertyAccessExpressionTail 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getGroup(), 0
		); }
		(rule__ParameterizedPropertyAccessExpressionTail__Group__0)
		{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule ParameterizedPropertyAccessExpressionTail
norm1_ParameterizedPropertyAccessExpressionTail 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getGroup(), 1
		); }
		(norm1_ParameterizedPropertyAccessExpressionTail__Group__0)
		{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleShiftExpression
entryRuleShiftExpression
:
{ before(grammarAccess.getShiftExpressionRule()); }
	 ruleShiftExpression
{ after(grammarAccess.getShiftExpressionRule()); } 
	 EOF 
;

// Rule ShiftExpression
ruleShiftExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getGroup(), 0
		); }
		(rule__ShiftExpression__Group__0)
		{ after(grammarAccess.getShiftExpressionAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule ShiftExpression
norm1_ShiftExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getGroup(), 1
		); }
		(norm1_ShiftExpression__Group__0)
		{ after(grammarAccess.getShiftExpressionAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationalExpression
entryRuleRelationalExpression
:
{ before(grammarAccess.getRelationalExpressionRule()); }
	 ruleRelationalExpression
{ after(grammarAccess.getRelationalExpressionRule()); } 
	 EOF 
;

// Rule RelationalExpression
ruleRelationalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getGroup(), 0
		); }
		(rule__RelationalExpression__Group__0)
		{ after(grammarAccess.getRelationalExpressionAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule RelationalExpression
norm1_RelationalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getGroup(), 1
		); }
		(norm1_RelationalExpression__Group__0)
		{ after(grammarAccess.getRelationalExpressionAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule RelationalExpression
norm2_RelationalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getGroup(), 2
		); }
		(norm2_RelationalExpression__Group__0)
		{ after(grammarAccess.getRelationalExpressionAccess().getGroup(), 2
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule RelationalExpression
norm3_RelationalExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getGroup(), 3
		); }
		(norm3_RelationalExpression__Group__0)
		{ after(grammarAccess.getRelationalExpressionAccess().getGroup(), 3
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRelationalOperator
entryRuleRelationalOperator
:
{ before(grammarAccess.getRelationalOperatorRule()); }
	 ruleRelationalOperator
{ after(grammarAccess.getRelationalOperatorRule()); } 
	 EOF 
;

// Rule RelationalOperator
ruleRelationalOperator 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getAlternatives(), 0
		); }
		(rule__RelationalOperator__Alternatives)
		{ after(grammarAccess.getRelationalOperatorAccess().getAlternatives(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule RelationalOperator
norm1_RelationalOperator 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getAlternatives(), 1
		); }
		(norm1_RelationalOperator__Alternatives)
		{ after(grammarAccess.getRelationalOperatorAccess().getAlternatives(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssignmentExpression
entryRuleAssignmentExpression
:
{ before(grammarAccess.getAssignmentExpressionRule()); }
	 ruleAssignmentExpression
{ after(grammarAccess.getAssignmentExpressionRule()); } 
	 EOF 
;

// Rule AssignmentExpression
ruleAssignmentExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1(), 0
		); }
		(rule__AssignmentExpression__Group_1__0)
		{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule AssignmentExpression
norm1_AssignmentExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1(), 1
		); }
		(norm1_AssignmentExpression__Group_1__0)
		{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule AssignmentExpression
norm2_AssignmentExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getAlternatives(), 2
		); }
		(norm2_AssignmentExpression__Alternatives)
		{ after(grammarAccess.getAssignmentExpressionAccess().getAlternatives(), 2
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule AssignmentExpression
norm3_AssignmentExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getAlternatives(), 3
		); }
		(norm3_AssignmentExpression__Alternatives)
		{ after(grammarAccess.getAssignmentExpressionAccess().getAlternatives(), 3
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleYieldExpression
entryRuleYieldExpression
:
{ before(grammarAccess.getYieldExpressionRule()); }
	 ruleYieldExpression
{ after(grammarAccess.getYieldExpressionRule()); } 
	 EOF 
;

// Rule YieldExpression
ruleYieldExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getYieldExpressionAccess().getGroup(), 0
		); }
		(rule__YieldExpression__Group__0)
		{ after(grammarAccess.getYieldExpressionAccess().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule YieldExpression
norm1_YieldExpression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getYieldExpressionAccess().getGroup(), 1
		); }
		(norm1_YieldExpression__Group__0)
		{ after(grammarAccess.getYieldExpressionAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Expression
norm1_Expression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionAccess().getGroup(), 1
		); }
		(norm1_Expression__Group__0)
		{ after(grammarAccess.getExpressionAccess().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Expression
norm3_Expression 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpressionAccess().getGroup(), 3
		); }
		(norm3_Expression__Group__0)
		{ after(grammarAccess.getExpressionAccess().getGroup(), 3
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIdentifier
entryRuleIdentifier
:
{ before(grammarAccess.getIdentifierRule()); }
	 ruleIdentifier
{ after(grammarAccess.getIdentifierRule()); } 
	 EOF 
;

// Rule Identifier
ruleIdentifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdentifierAccess().getAlternatives(), 0
		); }
		(rule__Identifier__Alternatives)
		{ after(grammarAccess.getIdentifierAccess().getAlternatives(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Identifier
norm1_Identifier 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0(), 1
		); }
		RULE_ID
		{ after(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RootStatement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0()); }
		(ruleBlock)
		{ after(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1()); }
		(ruleFunctionDeclaration)
		{ after(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2()); }
		(ruleLabelledStatement)
		{ after(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3()); }
		ruleExpressionStatement
		{ after(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_RootStatement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0()); }
		(norm1_Block)
		{ after(grammarAccess.getRootStatementAccess().getBlockParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1()); }
		(norm1_FunctionDeclaration)
		{ after(grammarAccess.getRootStatementAccess().getFunctionDeclarationParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2()); }
		(norm1_LabelledStatement)
		{ after(grammarAccess.getRootStatementAccess().getLabelledStatementParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3()); }
		norm1_ExpressionStatement
		{ after(grammarAccess.getRootStatementAccess().getExpressionStatementParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionImplAccess().getGroup_1_0()); }
		(rule__FunctionImpl__Group_1_0__0)
		{ after(grammarAccess.getFunctionImplAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getFunctionImplAccess().getGroup_1_1()); }
		(rule__FunctionImpl__Group_1_1__0)
		{ after(grammarAccess.getFunctionImplAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionImplAccess().getGroup_1_0()); }
		(norm3_FunctionImpl__Group_1_0__0)
		{ after(grammarAccess.getFunctionImplAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getFunctionImplAccess().getGroup_1_1()); }
		(norm3_FunctionImpl__Group_1_1__0)
		{ after(grammarAccess.getFunctionImplAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Statement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0()); }
		(ruleFunctionDeclaration)
		{ after(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1()); }
		ruleRootStatement
		{ after(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Statement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0()); }
		(norm1_FunctionDeclaration)
		{ after(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1()); }
		norm1_RootStatement
		{ after(grammarAccess.getStatementAccess().getRootStatementParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberExpressionAccess().getGroup_1_0()); }
		(rule__MemberExpression__Group_1_0__0)
		{ after(grammarAccess.getMemberExpressionAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberExpressionAccess().getGroup_1_1()); }
		(rule__MemberExpression__Group_1_1__0)
		{ after(grammarAccess.getMemberExpressionAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberExpressionAccess().getGroup_1_0()); }
		(norm1_MemberExpression__Group_1_0__0)
		{ after(grammarAccess.getMemberExpressionAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberExpressionAccess().getGroup_1_1()); }
		(norm1_MemberExpression__Group_1_1__0)
		{ after(grammarAccess.getMemberExpressionAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__OpAlternatives_1_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0()); }
		'>>'
		{ after(grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1()); }
		'<<'
		{ after(grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__OpAlternatives_1_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0()); }
		'>>'
		{ after(grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1()); }
		'<<'
		{ after(grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalOperator__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0()); }
		'<'
		{ after(grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1()); }
		'>'
		{ after(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2()); }
		'<='
		{ after(grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); }
		'>='
		{ after(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4()); }
		'instanceof'
		{ after(grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalOperator__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0()); }
		'<'
		{ after(grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1()); }
		'>'
		{ after(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2()); }
		'<='
		{ after(grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); }
		'>='
		{ after(grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4()); }
		'instanceof'
		{ after(grammarAccess.getRelationalOperatorAccess().getInstanceofKeyword_4()); }
	)
	|
	(
		{ before(grammarAccess.getRelationalOperatorAccess().getInKeyword_5_0()); }
		'in'
		{ after(grammarAccess.getRelationalOperatorAccess().getInKeyword_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0()); }
		ruleYieldExpression
		{ after(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1()); }
		(norm2_AssignmentExpression__Group_1__0)
		{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0()); }
		norm1_YieldExpression
		{ after(grammarAccess.getAssignmentExpressionAccess().getYieldExpressionParserRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1()); }
		(norm3_AssignmentExpression__Group_1__0)
		{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Identifier__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getIdentifierAccess().getYieldKeyword_1_0()); }
		'yield'
		{ after(grammarAccess.getIdentifierAccess().getYieldKeyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionDeclaration__Group__0__Impl
	rule__FunctionDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getGroup_0()); }
	(rule__FunctionDeclaration__Group_0__0)
	{ after(grammarAccess.getFunctionDeclarationAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1()); }
	(';')?
	{ after(grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FunctionDeclaration__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionDeclaration__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getGroup_0_0()); }
	(rule__FunctionDeclaration__Group_0_0__0)
	{ after(grammarAccess.getFunctionDeclarationAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FunctionDeclaration__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionDeclaration__Group_0_0__0__Impl
	rule__FunctionDeclaration__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0()); }
	()
	{ after(grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionDeclaration__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionDeclaration__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1()); }
	(ruleFunctionImpl)
	{ after(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_FunctionDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionDeclaration__Group__0__Impl
	norm1_FunctionDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getGroup_0()); }
	(norm1_FunctionDeclaration__Group_0__0)
	{ after(grammarAccess.getFunctionDeclarationAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1()); }
	(';')?
	{ after(grammarAccess.getFunctionDeclarationAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_FunctionDeclaration__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionDeclaration__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionDeclaration__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getGroup_0_0()); }
	(norm1_FunctionDeclaration__Group_0_0__0)
	{ after(grammarAccess.getFunctionDeclarationAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_FunctionDeclaration__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionDeclaration__Group_0_0__0__Impl
	norm1_FunctionDeclaration__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionDeclaration__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0()); }
	()
	{ after(grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionDeclaration__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionDeclaration__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionDeclaration__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1()); }
	(norm3_FunctionImpl)
	{ after(grammarAccess.getFunctionDeclarationAccess().getFunctionImplParserRuleCall_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FunctionImpl__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionImpl__Group__0__Impl
	rule__FunctionImpl__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionKeyword_0()); }
	'function'
	{ after(grammarAccess.getFunctionImplAccess().getFunctionKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionImpl__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getAlternatives_1()); }
	(rule__FunctionImpl__Alternatives_1)
	{ after(grammarAccess.getFunctionImplAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FunctionImpl__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionImpl__Group_1_0__0__Impl
	rule__FunctionImpl__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getGeneratorAssignment_1_0_0()); }
	(rule__FunctionImpl__GeneratorAssignment_1_0_0)
	{ after(grammarAccess.getFunctionImplAccess().getGeneratorAssignment_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionImpl__Group_1_0__1__Impl
	rule__FunctionImpl__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1()); }
	norm2_FunctionHeader
	{ after(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionImpl__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2()); }
	norm1_FunctionBody
	{ after(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FunctionImpl__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionImpl__Group_1_1__0__Impl
	rule__FunctionImpl__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0()); }
	ruleFunctionHeader
	{ after(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionImpl__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionImpl__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1()); }
	ruleFunctionBody
	{ after(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_FunctionImpl__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionImpl__Group__0__Impl
	norm3_FunctionImpl__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionKeyword_0()); }
	'function'
	{ after(grammarAccess.getFunctionImplAccess().getFunctionKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionImpl__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getAlternatives_1()); }
	(norm3_FunctionImpl__Alternatives_1)
	{ after(grammarAccess.getFunctionImplAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_FunctionImpl__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionImpl__Group_1_0__0__Impl
	norm3_FunctionImpl__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getGeneratorAssignment_1_0_0()); }
	(norm3_FunctionImpl__GeneratorAssignment_1_0_0)
	{ after(grammarAccess.getFunctionImplAccess().getGeneratorAssignment_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionImpl__Group_1_0__1__Impl
	norm3_FunctionImpl__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1()); }
	norm3_FunctionHeader
	{ after(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionImpl__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2()); }
	norm1_FunctionBody
	{ after(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_FunctionImpl__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionImpl__Group_1_1__0__Impl
	norm3_FunctionImpl__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0()); }
	norm1_FunctionHeader
	{ after(grammarAccess.getFunctionImplAccess().getFunctionHeaderParserRuleCall_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionImpl__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1()); }
	ruleFunctionBody
	{ after(grammarAccess.getFunctionImplAccess().getFunctionBodyParserRuleCall_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FunctionHeader__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionHeader__Group__0__Impl
	rule__FunctionHeader__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionHeader__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
	(rule__FunctionHeader__NameAssignment_0)?
	{ after(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionHeader__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionHeader__Group__1__Impl
	rule__FunctionHeader__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionHeader__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionHeader__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FunctionHeader__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionHeader__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_FunctionHeader__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionHeader__Group__0__Impl
	norm1_FunctionHeader__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionHeader__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
	(norm1_FunctionHeader__NameAssignment_0)?
	{ after(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionHeader__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionHeader__Group__1__Impl
	norm1_FunctionHeader__Group__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionHeader__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionHeader__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_FunctionHeader__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionHeader__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_FunctionHeader__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_FunctionHeader__Group__0__Impl
	norm2_FunctionHeader__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm2_FunctionHeader__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
	(norm2_FunctionHeader__NameAssignment_0)?
	{ after(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_FunctionHeader__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_FunctionHeader__Group__1__Impl
	norm2_FunctionHeader__Group__2
;
finally {
	restoreStackSize(stackSize);
}

norm2_FunctionHeader__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_FunctionHeader__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_FunctionHeader__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_FunctionHeader__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_FunctionHeader__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionHeader__Group__0__Impl
	norm3_FunctionHeader__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionHeader__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
	(norm3_FunctionHeader__NameAssignment_0)?
	{ after(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionHeader__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionHeader__Group__1__Impl
	norm3_FunctionHeader__Group__2
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionHeader__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getFunctionHeaderAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionHeader__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_FunctionHeader__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionHeader__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getFunctionHeaderAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Block__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group__0__Impl
	rule__Block__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getGroup_0()); }
	(rule__Block__Group_0__0)
	{ after(grammarAccess.getBlockAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group__1__Impl
	rule__Block__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getStatementsAssignment_1()); }
	(rule__Block__StatementsAssignment_1)*
	{ after(grammarAccess.getBlockAccess().getStatementsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2()); }
	'}'
	{ after(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Block__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getGroup_0_0()); }
	(rule__Block__Group_0_0__0)
	{ after(grammarAccess.getBlockAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Block__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group_0_0__0__Impl
	rule__Block__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getBlockAction_0_0_0()); }
	()
	{ after(grammarAccess.getBlockAccess().getBlockAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1()); }
	'{'
	{ after(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Block__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Block__Group__0__Impl
	norm1_Block__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getGroup_0()); }
	(norm1_Block__Group_0__0)
	{ after(grammarAccess.getBlockAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Block__Group__1__Impl
	norm1_Block__Group__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getStatementsAssignment_1()); }
	(norm1_Block__StatementsAssignment_1)*
	{ after(grammarAccess.getBlockAccess().getStatementsAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Block__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2()); }
	'}'
	{ after(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Block__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Block__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getGroup_0_0()); }
	(norm1_Block__Group_0_0__0)
	{ after(grammarAccess.getBlockAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Block__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Block__Group_0_0__0__Impl
	norm1_Block__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getBlockAction_0_0_0()); }
	()
	{ after(grammarAccess.getBlockAccess().getBlockAction_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Block__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1()); }
	'{'
	{ after(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ExpressionStatement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExpressionStatement__Group__0__Impl
	rule__ExpressionStatement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpressionStatement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionStatementAccess().getExpressionAssignment_0()); }
	(rule__ExpressionStatement__ExpressionAssignment_0)
	{ after(grammarAccess.getExpressionStatementAccess().getExpressionAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpressionStatement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExpressionStatement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpressionStatement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); }
	';'
	{ after(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_ExpressionStatement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ExpressionStatement__Group__0__Impl
	norm1_ExpressionStatement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_ExpressionStatement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionStatementAccess().getExpressionAssignment_0()); }
	(norm1_ExpressionStatement__ExpressionAssignment_0)
	{ after(grammarAccess.getExpressionStatementAccess().getExpressionAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ExpressionStatement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ExpressionStatement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_ExpressionStatement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); }
	';'
	{ after(grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LabelledStatement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LabelledStatement__Group__0__Impl
	rule__LabelledStatement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getGroup_0()); }
	(rule__LabelledStatement__Group_0__0)
	{ after(grammarAccess.getLabelledStatementAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LabelledStatement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getStatementAssignment_1()); }
	(rule__LabelledStatement__StatementAssignment_1)
	{ after(grammarAccess.getLabelledStatementAccess().getStatementAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LabelledStatement__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LabelledStatement__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getGroup_0_0()); }
	(rule__LabelledStatement__Group_0_0__0)
	{ after(grammarAccess.getLabelledStatementAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LabelledStatement__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LabelledStatement__Group_0_0__0__Impl
	rule__LabelledStatement__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getNameAssignment_0_0_0()); }
	(rule__LabelledStatement__NameAssignment_0_0_0)
	{ after(grammarAccess.getLabelledStatementAccess().getNameAssignment_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LabelledStatement__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1()); }
	':'
	{ after(grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_LabelledStatement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_LabelledStatement__Group__0__Impl
	norm1_LabelledStatement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getGroup_0()); }
	(norm1_LabelledStatement__Group_0__0)
	{ after(grammarAccess.getLabelledStatementAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_LabelledStatement__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getStatementAssignment_1()); }
	(norm1_LabelledStatement__StatementAssignment_1)
	{ after(grammarAccess.getLabelledStatementAccess().getStatementAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_LabelledStatement__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_LabelledStatement__Group_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getGroup_0_0()); }
	(norm1_LabelledStatement__Group_0_0__0)
	{ after(grammarAccess.getLabelledStatementAccess().getGroup_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_LabelledStatement__Group_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_LabelledStatement__Group_0_0__0__Impl
	norm1_LabelledStatement__Group_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__Group_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getNameAssignment_0_0_0()); }
	(norm1_LabelledStatement__NameAssignment_0_0_0)
	{ after(grammarAccess.getLabelledStatementAccess().getNameAssignment_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__Group_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_LabelledStatement__Group_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__Group_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1()); }
	':'
	{ after(grammarAccess.getLabelledStatementAccess().getColonKeyword_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MemberExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MemberExpression__Group__0__Impl
	rule__MemberExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0()); }
	rulePrimaryExpression
	{ after(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MemberExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getAlternatives_1()); }
	(rule__MemberExpression__Alternatives_1)*
	{ after(grammarAccess.getMemberExpressionAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MemberExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MemberExpression__Group_1_0__0__Impl
	rule__MemberExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0()); }
	()
	{ after(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MemberExpression__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1()); }
	ruleIndexedAccessExpressionTail
	{ after(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__MemberExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MemberExpression__Group_1_1__0__Impl
	rule__MemberExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0()); }
	()
	{ after(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MemberExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MemberExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1()); }
	ruleParameterizedPropertyAccessExpressionTail
	{ after(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_MemberExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_MemberExpression__Group__0__Impl
	norm1_MemberExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0()); }
	norm1_PrimaryExpression
	{ after(grammarAccess.getMemberExpressionAccess().getPrimaryExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_MemberExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getAlternatives_1()); }
	(norm1_MemberExpression__Alternatives_1)*
	{ after(grammarAccess.getMemberExpressionAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_MemberExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_MemberExpression__Group_1_0__0__Impl
	norm1_MemberExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0()); }
	()
	{ after(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_MemberExpression__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1()); }
	norm1_IndexedAccessExpressionTail
	{ after(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTailParserRuleCall_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_MemberExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_MemberExpression__Group_1_1__0__Impl
	norm1_MemberExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0()); }
	()
	{ after(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_MemberExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_MemberExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1()); }
	norm1_ParameterizedPropertyAccessExpressionTail
	{ after(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__IndexedAccessExpressionTail__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IndexedAccessExpressionTail__Group__0__Impl
	rule__IndexedAccessExpressionTail__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IndexedAccessExpressionTail__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0()); }
	'['
	{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IndexedAccessExpressionTail__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IndexedAccessExpressionTail__Group__1__Impl
	rule__IndexedAccessExpressionTail__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IndexedAccessExpressionTail__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexAssignment_1()); }
	(rule__IndexedAccessExpressionTail__IndexAssignment_1)
	{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__IndexedAccessExpressionTail__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__IndexedAccessExpressionTail__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IndexedAccessExpressionTail__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2()); }
	']'
	{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_IndexedAccessExpressionTail__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_IndexedAccessExpressionTail__Group__0__Impl
	norm1_IndexedAccessExpressionTail__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_IndexedAccessExpressionTail__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0()); }
	'['
	{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getLeftSquareBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_IndexedAccessExpressionTail__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_IndexedAccessExpressionTail__Group__1__Impl
	norm1_IndexedAccessExpressionTail__Group__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_IndexedAccessExpressionTail__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexAssignment_1()); }
	(norm1_IndexedAccessExpressionTail__IndexAssignment_1)
	{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_IndexedAccessExpressionTail__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_IndexedAccessExpressionTail__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_IndexedAccessExpressionTail__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2()); }
	']'
	{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getRightSquareBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParameterizedPropertyAccessExpressionTail__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedPropertyAccessExpressionTail__Group__0__Impl
	rule__ParameterizedPropertyAccessExpressionTail__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedPropertyAccessExpressionTail__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0()); }
	'.'
	{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedPropertyAccessExpressionTail__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParameterizedPropertyAccessExpressionTail__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedPropertyAccessExpressionTail__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyAssignment_1()); }
	(rule__ParameterizedPropertyAccessExpressionTail__PropertyAssignment_1)
	{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_ParameterizedPropertyAccessExpressionTail__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ParameterizedPropertyAccessExpressionTail__Group__0__Impl
	norm1_ParameterizedPropertyAccessExpressionTail__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_ParameterizedPropertyAccessExpressionTail__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0()); }
	'.'
	{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getFullStopKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ParameterizedPropertyAccessExpressionTail__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ParameterizedPropertyAccessExpressionTail__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_ParameterizedPropertyAccessExpressionTail__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyAssignment_1()); }
	(norm1_ParameterizedPropertyAccessExpressionTail__PropertyAssignment_1)
	{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ShiftExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ShiftExpression__Group__0__Impl
	rule__ShiftExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0()); }
	ruleMemberExpression
	{ after(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ShiftExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getGroup_1()); }
	(rule__ShiftExpression__Group_1__0)*
	{ after(grammarAccess.getShiftExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ShiftExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ShiftExpression__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getGroup_1_0()); }
	(rule__ShiftExpression__Group_1_0__0)
	{ after(grammarAccess.getShiftExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ShiftExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ShiftExpression__Group_1_0__0__Impl
	rule__ShiftExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0()); }
	()
	{ after(grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ShiftExpression__Group_1_0__1__Impl
	rule__ShiftExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getOpAssignment_1_0_1()); }
	(rule__ShiftExpression__OpAssignment_1_0_1)
	{ after(grammarAccess.getShiftExpressionAccess().getOpAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ShiftExpression__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getRhsAssignment_1_0_2()); }
	(rule__ShiftExpression__RhsAssignment_1_0_2)
	{ after(grammarAccess.getShiftExpressionAccess().getRhsAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_ShiftExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ShiftExpression__Group__0__Impl
	norm1_ShiftExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0()); }
	norm1_MemberExpression
	{ after(grammarAccess.getShiftExpressionAccess().getMemberExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ShiftExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getGroup_1()); }
	(norm1_ShiftExpression__Group_1__0)*
	{ after(grammarAccess.getShiftExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_ShiftExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ShiftExpression__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getGroup_1_0()); }
	(norm1_ShiftExpression__Group_1_0__0)
	{ after(grammarAccess.getShiftExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_ShiftExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ShiftExpression__Group_1_0__0__Impl
	norm1_ShiftExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0()); }
	()
	{ after(grammarAccess.getShiftExpressionAccess().getShiftExpressionLhsAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ShiftExpression__Group_1_0__1__Impl
	norm1_ShiftExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getOpAssignment_1_0_1()); }
	(norm1_ShiftExpression__OpAssignment_1_0_1)
	{ after(grammarAccess.getShiftExpressionAccess().getOpAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_ShiftExpression__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getShiftExpressionAccess().getRhsAssignment_1_0_2()); }
	(norm1_ShiftExpression__RhsAssignment_1_0_2)
	{ after(grammarAccess.getShiftExpressionAccess().getRhsAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group__0__Impl
	rule__RelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
	ruleShiftExpression
	{ after(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
	(rule__RelationalExpression__Group_1__0)*
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
	(rule__RelationalExpression__Group_1_0__0)
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RelationalExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group_1_0__0__Impl
	rule__RelationalExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
	()
	{ after(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group_1_0__1__Impl
	rule__RelationalExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
	(rule__RelationalExpression__OpAssignment_1_0_1)
	{ after(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RelationalExpression__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
	(rule__RelationalExpression__RhsAssignment_1_0_2)
	{ after(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_RelationalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_RelationalExpression__Group__0__Impl
	norm1_RelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
	ruleShiftExpression
	{ after(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_RelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
	(norm1_RelationalExpression__Group_1__0)*
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_RelationalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_RelationalExpression__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
	(norm1_RelationalExpression__Group_1_0__0)
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_RelationalExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_RelationalExpression__Group_1_0__0__Impl
	norm1_RelationalExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
	()
	{ after(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_RelationalExpression__Group_1_0__1__Impl
	norm1_RelationalExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
	(norm1_RelationalExpression__OpAssignment_1_0_1)
	{ after(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_RelationalExpression__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
	(norm1_RelationalExpression__RhsAssignment_1_0_2)
	{ after(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_RelationalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_RelationalExpression__Group__0__Impl
	norm2_RelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
	norm1_ShiftExpression
	{ after(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_RelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
	(norm2_RelationalExpression__Group_1__0)*
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_RelationalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_RelationalExpression__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
	(norm2_RelationalExpression__Group_1_0__0)
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_RelationalExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_RelationalExpression__Group_1_0__0__Impl
	norm2_RelationalExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
	()
	{ after(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_RelationalExpression__Group_1_0__1__Impl
	norm2_RelationalExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
	(norm2_RelationalExpression__OpAssignment_1_0_1)
	{ after(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_RelationalExpression__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
	(norm2_RelationalExpression__RhsAssignment_1_0_2)
	{ after(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_RelationalExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_RelationalExpression__Group__0__Impl
	norm3_RelationalExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
	norm1_ShiftExpression
	{ after(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_RelationalExpression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
	(norm3_RelationalExpression__Group_1__0)*
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_RelationalExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_RelationalExpression__Group_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
	(norm3_RelationalExpression__Group_1_0__0)
	{ after(grammarAccess.getRelationalExpressionAccess().getGroup_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_RelationalExpression__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_RelationalExpression__Group_1_0__0__Impl
	norm3_RelationalExpression__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
	()
	{ after(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_RelationalExpression__Group_1_0__1__Impl
	norm3_RelationalExpression__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
	(norm3_RelationalExpression__OpAssignment_1_0_1)
	{ after(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_RelationalExpression__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
	(norm3_RelationalExpression__RhsAssignment_1_0_2)
	{ after(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignmentExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group_1__0__Impl
	rule__AssignmentExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
	ruleRelationalExpression
	{ after(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
	(rule__AssignmentExpression__Group_1_1__0)?
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignmentExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group_1_1__0__Impl
	rule__AssignmentExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
	(rule__AssignmentExpression__Group_1_1_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
	(rule__AssignmentExpression__RhsAssignment_1_1_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignmentExpression__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group_1_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
	(rule__AssignmentExpression__Group_1_1_0_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignmentExpression__Group_1_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group_1_1_0_0__0__Impl
	rule__AssignmentExpression__Group_1_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
	()
	{ after(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignmentExpression__Group_1_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__Group_1_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
	(rule__AssignmentExpression__OpAssignment_1_1_0_0_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_AssignmentExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_AssignmentExpression__Group_1__0__Impl
	norm1_AssignmentExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
	norm1_RelationalExpression
	{ after(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_AssignmentExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
	(norm1_AssignmentExpression__Group_1_1__0)?
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_AssignmentExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_AssignmentExpression__Group_1_1__0__Impl
	norm1_AssignmentExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
	(norm1_AssignmentExpression__Group_1_1_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_AssignmentExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
	(norm1_AssignmentExpression__RhsAssignment_1_1_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_AssignmentExpression__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_AssignmentExpression__Group_1_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
	(norm1_AssignmentExpression__Group_1_1_0_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_AssignmentExpression__Group_1_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_AssignmentExpression__Group_1_1_0_0__0__Impl
	norm1_AssignmentExpression__Group_1_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
	()
	{ after(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_AssignmentExpression__Group_1_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__Group_1_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
	(norm1_AssignmentExpression__OpAssignment_1_1_0_0_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_AssignmentExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_AssignmentExpression__Group_1__0__Impl
	norm2_AssignmentExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
	norm2_RelationalExpression
	{ after(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_AssignmentExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
	(norm2_AssignmentExpression__Group_1_1__0)?
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_AssignmentExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_AssignmentExpression__Group_1_1__0__Impl
	norm2_AssignmentExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
	(norm2_AssignmentExpression__Group_1_1_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_AssignmentExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
	(norm2_AssignmentExpression__RhsAssignment_1_1_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_AssignmentExpression__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_AssignmentExpression__Group_1_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
	(norm2_AssignmentExpression__Group_1_1_0_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm2_AssignmentExpression__Group_1_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_AssignmentExpression__Group_1_1_0_0__0__Impl
	norm2_AssignmentExpression__Group_1_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
	()
	{ after(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm2_AssignmentExpression__Group_1_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__Group_1_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
	(norm2_AssignmentExpression__OpAssignment_1_1_0_0_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_AssignmentExpression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_AssignmentExpression__Group_1__0__Impl
	norm3_AssignmentExpression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
	norm3_RelationalExpression
	{ after(grammarAccess.getAssignmentExpressionAccess().getRelationalExpressionParserRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_AssignmentExpression__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
	(norm3_AssignmentExpression__Group_1_1__0)?
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_AssignmentExpression__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_AssignmentExpression__Group_1_1__0__Impl
	norm3_AssignmentExpression__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
	(norm3_AssignmentExpression__Group_1_1_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_AssignmentExpression__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
	(norm3_AssignmentExpression__RhsAssignment_1_1_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_AssignmentExpression__Group_1_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_AssignmentExpression__Group_1_1_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
	(norm3_AssignmentExpression__Group_1_1_0_0__0)
	{ after(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_AssignmentExpression__Group_1_1_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_AssignmentExpression__Group_1_1_0_0__0__Impl
	norm3_AssignmentExpression__Group_1_1_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1_1_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
	()
	{ after(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1_1_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_AssignmentExpression__Group_1_1_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__Group_1_1_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
	(norm3_AssignmentExpression__OpAssignment_1_1_0_0_1)
	{ after(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__YieldExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__YieldExpression__Group__0__Impl
	rule__YieldExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0()); }
	()
	{ after(grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__YieldExpression__Group__1__Impl
	rule__YieldExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getYieldKeyword_1()); }
	'yield'
	{ after(grammarAccess.getYieldExpressionAccess().getYieldKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__YieldExpression__Group__2__Impl
	rule__YieldExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getManyAssignment_2()); }
	(rule__YieldExpression__ManyAssignment_2)?
	{ after(grammarAccess.getYieldExpressionAccess().getManyAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__YieldExpression__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getExpressionAssignment_3()); }
	(rule__YieldExpression__ExpressionAssignment_3)?
	{ after(grammarAccess.getYieldExpressionAccess().getExpressionAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_YieldExpression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_YieldExpression__Group__0__Impl
	norm1_YieldExpression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0()); }
	()
	{ after(grammarAccess.getYieldExpressionAccess().getYieldExpressionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_YieldExpression__Group__1__Impl
	norm1_YieldExpression__Group__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getYieldKeyword_1()); }
	'yield'
	{ after(grammarAccess.getYieldExpressionAccess().getYieldKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_YieldExpression__Group__2__Impl
	norm1_YieldExpression__Group__3
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getManyAssignment_2()); }
	(norm1_YieldExpression__ManyAssignment_2)?
	{ after(grammarAccess.getYieldExpressionAccess().getManyAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_YieldExpression__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getYieldExpressionAccess().getExpressionAssignment_3()); }
	(norm1_YieldExpression__ExpressionAssignment_3)?
	{ after(grammarAccess.getYieldExpressionAccess().getExpressionAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Expression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group__0__Impl
	norm1_Expression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0()); }
	norm1_AssignmentExpression
	{ after(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getGroup_1()); }
	(norm1_Expression__Group_1__0)?
	{ after(grammarAccess.getExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Expression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group_1__0__Impl
	norm1_Expression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0()); }
	()
	{ after(grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group_1__1__Impl
	norm1_Expression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getCommaKeyword_1_1()); }
	','
	{ after(grammarAccess.getExpressionAccess().getCommaKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group_1__2__Impl
	norm1_Expression__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getExprsAssignment_1_2()); }
	(norm1_Expression__ExprsAssignment_1_2)
	{ after(grammarAccess.getExpressionAccess().getExprsAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getGroup_1_3()); }
	(norm1_Expression__Group_1_3__0)*
	{ after(grammarAccess.getExpressionAccess().getGroup_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Expression__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group_1_3__0__Impl
	norm1_Expression__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0()); }
	','
	{ after(grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Expression__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getExprsAssignment_1_3_1()); }
	(norm1_Expression__ExprsAssignment_1_3_1)
	{ after(grammarAccess.getExpressionAccess().getExprsAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_Expression__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group__0__Impl
	norm3_Expression__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0()); }
	norm3_AssignmentExpression
	{ after(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getGroup_1()); }
	(norm3_Expression__Group_1__0)?
	{ after(grammarAccess.getExpressionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_Expression__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group_1__0__Impl
	norm3_Expression__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0()); }
	()
	{ after(grammarAccess.getExpressionAccess().getCommaExpressionExprsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group_1__1__Impl
	norm3_Expression__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getCommaKeyword_1_1()); }
	','
	{ after(grammarAccess.getExpressionAccess().getCommaKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group_1__2__Impl
	norm3_Expression__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getExprsAssignment_1_2()); }
	(norm3_Expression__ExprsAssignment_1_2)
	{ after(grammarAccess.getExpressionAccess().getExprsAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getGroup_1_3()); }
	(norm3_Expression__Group_1_3__0)*
	{ after(grammarAccess.getExpressionAccess().getGroup_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm3_Expression__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group_1_3__0__Impl
	norm3_Expression__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0()); }
	','
	{ after(grammarAccess.getExpressionAccess().getCommaKeyword_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm3_Expression__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExpressionAccess().getExprsAssignment_1_3_1()); }
	(norm3_Expression__ExprsAssignment_1_3_1)
	{ after(grammarAccess.getExpressionAccess().getExprsAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FunctionImpl__GeneratorAssignment_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
		(
			{ before(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
			'*'
			{ after(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
		)
		{ after(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionImpl__GeneratorAssignment_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
		(
			{ before(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
			'*'
			{ after(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
		)
		{ after(grammarAccess.getFunctionImplAccess().getGeneratorAsteriskKeyword_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionHeader__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
		ruleIdentifier
		{ after(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionHeader__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
		norm1_Identifier
		{ after(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm2_FunctionHeader__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
		ruleIdentifier
		{ after(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionHeader__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
		norm1_Identifier
		{ after(grammarAccess.getFunctionHeaderAccess().getNameIdentifierParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__FunctionBody__BodyAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0()); }
		ruleBlock
		{ after(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_FunctionBody__BodyAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0()); }
		norm1_Block
		{ after(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm2_FunctionBody__BodyAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0()); }
		ruleBlock
		{ after(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_FunctionBody__BodyAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0()); }
		norm1_Block
		{ after(grammarAccess.getFunctionBodyAccess().getBodyBlockParserRuleCall_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__StatementsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0()); }
		ruleStatement
		{ after(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Block__StatementsAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0()); }
		norm1_Statement
		{ after(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExpressionStatement__ExpressionAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0()); }
		norm1_Expression
		{ after(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ExpressionStatement__ExpressionAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0()); }
		norm3_Expression
		{ after(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__NameAssignment_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0()); }
		ruleIdentifier
		{ after(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LabelledStatement__StatementAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0()); }
		ruleStatement
		{ after(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__NameAssignment_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0()); }
		norm1_Identifier
		{ after(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_LabelledStatement__StatementAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0()); }
		norm1_Statement
		{ after(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifierRef__IdAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0()); }
		ruleIdentifier
		{ after(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_IdentifierRef__IdAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0()); }
		norm1_Identifier
		{ after(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__IndexedAccessExpressionTail__IndexAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0()); }
		norm1_Expression
		{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_IndexedAccessExpressionTail__IndexAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0()); }
		norm3_Expression
		{ after(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterizedPropertyAccessExpressionTail__PropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0()); }
		ruleIdentifier
		{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ParameterizedPropertyAccessExpressionTail__PropertyAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0()); }
		norm1_Identifier
		{ after(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__OpAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getOpAlternatives_1_0_1_0()); }
		(rule__ShiftExpression__OpAlternatives_1_0_1_0)
		{ after(grammarAccess.getShiftExpressionAccess().getOpAlternatives_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ShiftExpression__RhsAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0()); }
		ruleMemberExpression
		{ after(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__OpAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getOpAlternatives_1_0_1_0()); }
		(norm1_ShiftExpression__OpAlternatives_1_0_1_0)
		{ after(grammarAccess.getShiftExpressionAccess().getOpAlternatives_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_ShiftExpression__RhsAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0()); }
		norm1_MemberExpression
		{ after(grammarAccess.getShiftExpressionAccess().getRhsMemberExpressionParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__OpAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
		ruleRelationalOperator
		{ after(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RelationalExpression__RhsAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
		ruleShiftExpression
		{ after(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__OpAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
		norm1_RelationalOperator
		{ after(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_RelationalExpression__RhsAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
		ruleShiftExpression
		{ after(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__OpAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
		ruleRelationalOperator
		{ after(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm2_RelationalExpression__RhsAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
		norm1_ShiftExpression
		{ after(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__OpAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
		norm1_RelationalOperator
		{ after(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_RelationalExpression__RhsAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
		norm1_ShiftExpression
		{ after(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__OpAssignment_1_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
			'='
			{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		)
		{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignmentExpression__RhsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
		ruleAssignmentExpression
		{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__OpAssignment_1_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
			'='
			{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		)
		{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_AssignmentExpression__RhsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
		norm1_AssignmentExpression
		{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__OpAssignment_1_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
			'='
			{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		)
		{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm2_AssignmentExpression__RhsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
		norm2_AssignmentExpression
		{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__OpAssignment_1_1_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		(
			{ before(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
			'='
			{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
		)
		{ after(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_AssignmentExpression__RhsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
		norm3_AssignmentExpression
		{ after(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__ManyAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
		(
			{ before(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
			'*'
			{ after(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
		)
		{ after(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__YieldExpression__ExpressionAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0()); }
		norm2_AssignmentExpression
		{ after(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__ManyAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
		(
			{ before(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
			'*'
			{ after(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
		)
		{ after(grammarAccess.getYieldExpressionAccess().getManyAsteriskKeyword_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_YieldExpression__ExpressionAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0()); }
		norm3_AssignmentExpression
		{ after(grammarAccess.getYieldExpressionAccess().getExpressionAssignmentExpressionParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__ExprsAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0()); }
		norm1_AssignmentExpression
		{ after(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Expression__ExprsAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0()); }
		norm1_AssignmentExpression
		{ after(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__ExprsAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0()); }
		norm3_AssignmentExpression
		{ after(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm3_Expression__ExprsAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0()); }
		norm3_AssignmentExpression
		{ after(grammarAccess.getExpressionAccess().getExprsAssignmentExpressionParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
