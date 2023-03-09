/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalXtext;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package org.eclipse.xtext.xtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtext.xtext.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.services.XtextGrammarAccess;

}
@parser::members {
	private XtextGrammarAccess grammarAccess;

	public void setGrammarAccess(XtextGrammarAccess grammarAccess) {
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

// Entry rule entryRuleGrammar
entryRuleGrammar
:
{ before(grammarAccess.getGrammarRule()); }
	 ruleGrammar
{ after(grammarAccess.getGrammarRule()); } 
	 EOF 
;

// Rule Grammar
ruleGrammar 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getGrammarAccess().getGroup()); }
		(rule__Grammar__Group__0)
		{ after(grammarAccess.getGrammarAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleGrammarID
entryRuleGrammarID
:
{ before(grammarAccess.getGrammarIDRule()); }
	 ruleGrammarID
{ after(grammarAccess.getGrammarIDRule()); } 
	 EOF 
;

// Rule GrammarID
ruleGrammarID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getGrammarIDAccess().getGroup()); }
		(rule__GrammarID__Group__0)
		{ after(grammarAccess.getGrammarIDAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAbstractRule
entryRuleAbstractRule
:
{ before(grammarAccess.getAbstractRuleRule()); }
	 ruleAbstractRule
{ after(grammarAccess.getAbstractRuleRule()); } 
	 EOF 
;

// Rule AbstractRule
ruleAbstractRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAbstractRuleAccess().getAlternatives()); }
		(rule__AbstractRule__Alternatives)
		{ after(grammarAccess.getAbstractRuleAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAbstractMetamodelDeclaration
entryRuleAbstractMetamodelDeclaration
:
{ before(grammarAccess.getAbstractMetamodelDeclarationRule()); }
	 ruleAbstractMetamodelDeclaration
{ after(grammarAccess.getAbstractMetamodelDeclarationRule()); } 
	 EOF 
;

// Rule AbstractMetamodelDeclaration
ruleAbstractMetamodelDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); }
		(rule__AbstractMetamodelDeclaration__Alternatives)
		{ after(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleGeneratedMetamodel
entryRuleGeneratedMetamodel
:
{ before(grammarAccess.getGeneratedMetamodelRule()); }
	 ruleGeneratedMetamodel
{ after(grammarAccess.getGeneratedMetamodelRule()); } 
	 EOF 
;

// Rule GeneratedMetamodel
ruleGeneratedMetamodel 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); }
		(rule__GeneratedMetamodel__Group__0)
		{ after(grammarAccess.getGeneratedMetamodelAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReferencedMetamodel
entryRuleReferencedMetamodel
:
{ before(grammarAccess.getReferencedMetamodelRule()); }
	 ruleReferencedMetamodel
{ after(grammarAccess.getReferencedMetamodelRule()); } 
	 EOF 
;

// Rule ReferencedMetamodel
ruleReferencedMetamodel 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReferencedMetamodelAccess().getGroup()); }
		(rule__ReferencedMetamodel__Group__0)
		{ after(grammarAccess.getReferencedMetamodelAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAnnotation
entryRuleAnnotation
:
{ before(grammarAccess.getAnnotationRule()); }
	 ruleAnnotation
{ after(grammarAccess.getAnnotationRule()); } 
	 EOF 
;

// Rule Annotation
ruleAnnotation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAnnotationAccess().getGroup()); }
		(rule__Annotation__Group__0)
		{ after(grammarAccess.getAnnotationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParserRule
entryRuleParserRule
:
{ before(grammarAccess.getParserRuleRule()); }
	 ruleParserRule
{ after(grammarAccess.getParserRuleRule()); } 
	 EOF 
;

// Rule ParserRule
ruleParserRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParserRuleAccess().getGroup()); }
		(rule__ParserRule__Group__0)
		{ after(grammarAccess.getParserRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule RuleNameAndParams
ruleRuleNameAndParams 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleNameAndParamsAccess().getGroup()); }
		(rule__RuleNameAndParams__Group__0)
		{ after(grammarAccess.getRuleNameAndParamsAccess().getGroup()); }
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
		{ before(grammarAccess.getParameterAccess().getNameAssignment()); }
		(rule__Parameter__NameAssignment)
		{ after(grammarAccess.getParameterAccess().getNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeRef
entryRuleTypeRef
:
{ before(grammarAccess.getTypeRefRule()); }
	 ruleTypeRef
{ after(grammarAccess.getTypeRefRule()); } 
	 EOF 
;

// Rule TypeRef
ruleTypeRef 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeRefAccess().getGroup()); }
		(rule__TypeRef__Group__0)
		{ after(grammarAccess.getTypeRefAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAlternatives
entryRuleAlternatives
:
{ before(grammarAccess.getAlternativesRule()); }
	 ruleAlternatives
{ after(grammarAccess.getAlternativesRule()); } 
	 EOF 
;

// Rule Alternatives
ruleAlternatives 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAlternativesAccess().getGroup()); }
		(rule__Alternatives__Group__0)
		{ after(grammarAccess.getAlternativesAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConditionalBranch
entryRuleConditionalBranch
:
{ before(grammarAccess.getConditionalBranchRule()); }
	 ruleConditionalBranch
{ after(grammarAccess.getConditionalBranchRule()); } 
	 EOF 
;

// Rule ConditionalBranch
ruleConditionalBranch 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConditionalBranchAccess().getAlternatives()); }
		(rule__ConditionalBranch__Alternatives)
		{ after(grammarAccess.getConditionalBranchAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUnorderedGroup
entryRuleUnorderedGroup
:
{ before(grammarAccess.getUnorderedGroupRule()); }
	 ruleUnorderedGroup
{ after(grammarAccess.getUnorderedGroupRule()); } 
	 EOF 
;

// Rule UnorderedGroup
ruleUnorderedGroup 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUnorderedGroupAccess().getGroup()); }
		(rule__UnorderedGroup__Group__0)
		{ after(grammarAccess.getUnorderedGroupAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleGroup
entryRuleGroup
:
{ before(grammarAccess.getGroupRule()); }
	 ruleGroup
{ after(grammarAccess.getGroupRule()); } 
	 EOF 
;

// Rule Group
ruleGroup 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getGroupAccess().getGroup()); }
		(rule__Group__Group__0)
		{ after(grammarAccess.getGroupAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAbstractToken
entryRuleAbstractToken
:
{ before(grammarAccess.getAbstractTokenRule()); }
	 ruleAbstractToken
{ after(grammarAccess.getAbstractTokenRule()); } 
	 EOF 
;

// Rule AbstractToken
ruleAbstractToken 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAbstractTokenAccess().getAlternatives()); }
		(rule__AbstractToken__Alternatives)
		{ after(grammarAccess.getAbstractTokenAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAbstractTokenWithCardinality
entryRuleAbstractTokenWithCardinality
:
{ before(grammarAccess.getAbstractTokenWithCardinalityRule()); }
	 ruleAbstractTokenWithCardinality
{ after(grammarAccess.getAbstractTokenWithCardinalityRule()); } 
	 EOF 
;

// Rule AbstractTokenWithCardinality
ruleAbstractTokenWithCardinality 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); }
		(rule__AbstractTokenWithCardinality__Group__0)
		{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAction
entryRuleAction
:
{ before(grammarAccess.getActionRule()); }
	 ruleAction
{ after(grammarAccess.getActionRule()); } 
	 EOF 
;

// Rule Action
ruleAction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getActionAccess().getGroup()); }
		(rule__Action__Group__0)
		{ after(grammarAccess.getActionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAbstractTerminal
entryRuleAbstractTerminal
:
{ before(grammarAccess.getAbstractTerminalRule()); }
	 ruleAbstractTerminal
{ after(grammarAccess.getAbstractTerminalRule()); } 
	 EOF 
;

// Rule AbstractTerminal
ruleAbstractTerminal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); }
		(rule__AbstractTerminal__Alternatives)
		{ after(grammarAccess.getAbstractTerminalAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleKeyword
entryRuleKeyword
:
{ before(grammarAccess.getKeywordRule()); }
	 ruleKeyword
{ after(grammarAccess.getKeywordRule()); } 
	 EOF 
;

// Rule Keyword
ruleKeyword 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getKeywordAccess().getValueAssignment()); }
		(rule__Keyword__ValueAssignment)
		{ after(grammarAccess.getKeywordAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRuleCall
entryRuleRuleCall
:
{ before(grammarAccess.getRuleCallRule()); }
	 ruleRuleCall
{ after(grammarAccess.getRuleCallRule()); } 
	 EOF 
;

// Rule RuleCall
ruleRuleCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleCallAccess().getGroup()); }
		(rule__RuleCall__Group__0)
		{ after(grammarAccess.getRuleCallAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNamedArgument
entryRuleNamedArgument
:
{ before(grammarAccess.getNamedArgumentRule()); }
	 ruleNamedArgument
{ after(grammarAccess.getNamedArgumentRule()); } 
	 EOF 
;

// Rule NamedArgument
ruleNamedArgument 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNamedArgumentAccess().getGroup()); }
		(rule__NamedArgument__Group__0)
		{ after(grammarAccess.getNamedArgumentAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLiteralCondition
entryRuleLiteralCondition
:
{ before(grammarAccess.getLiteralConditionRule()); }
	 ruleLiteralCondition
{ after(grammarAccess.getLiteralConditionRule()); } 
	 EOF 
;

// Rule LiteralCondition
ruleLiteralCondition 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLiteralConditionAccess().getGroup()); }
		(rule__LiteralCondition__Group__0)
		{ after(grammarAccess.getLiteralConditionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleDisjunction
entryRuleDisjunction
:
{ before(grammarAccess.getDisjunctionRule()); }
	 ruleDisjunction
{ after(grammarAccess.getDisjunctionRule()); } 
	 EOF 
;

// Rule Disjunction
ruleDisjunction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDisjunctionAccess().getGroup()); }
		(rule__Disjunction__Group__0)
		{ after(grammarAccess.getDisjunctionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleConjunction
entryRuleConjunction
:
{ before(grammarAccess.getConjunctionRule()); }
	 ruleConjunction
{ after(grammarAccess.getConjunctionRule()); } 
	 EOF 
;

// Rule Conjunction
ruleConjunction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getConjunctionAccess().getGroup()); }
		(rule__Conjunction__Group__0)
		{ after(grammarAccess.getConjunctionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNegation
entryRuleNegation
:
{ before(grammarAccess.getNegationRule()); }
	 ruleNegation
{ after(grammarAccess.getNegationRule()); } 
	 EOF 
;

// Rule Negation
ruleNegation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNegationAccess().getAlternatives()); }
		(rule__Negation__Alternatives)
		{ after(grammarAccess.getNegationAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAtom
entryRuleAtom
:
{ before(grammarAccess.getAtomRule()); }
	 ruleAtom
{ after(grammarAccess.getAtomRule()); } 
	 EOF 
;

// Rule Atom
ruleAtom 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAtomAccess().getAlternatives()); }
		(rule__Atom__Alternatives)
		{ after(grammarAccess.getAtomAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParenthesizedCondition
entryRuleParenthesizedCondition
:
{ before(grammarAccess.getParenthesizedConditionRule()); }
	 ruleParenthesizedCondition
{ after(grammarAccess.getParenthesizedConditionRule()); } 
	 EOF 
;

// Rule ParenthesizedCondition
ruleParenthesizedCondition 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParenthesizedConditionAccess().getGroup()); }
		(rule__ParenthesizedCondition__Group__0)
		{ after(grammarAccess.getParenthesizedConditionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParameterReference
entryRuleParameterReference
:
{ before(grammarAccess.getParameterReferenceRule()); }
	 ruleParameterReference
{ after(grammarAccess.getParameterReferenceRule()); } 
	 EOF 
;

// Rule ParameterReference
ruleParameterReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterReferenceAccess().getParameterAssignment()); }
		(rule__ParameterReference__ParameterAssignment)
		{ after(grammarAccess.getParameterReferenceAccess().getParameterAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalRuleCall
entryRuleTerminalRuleCall
:
{ before(grammarAccess.getTerminalRuleCallRule()); }
	 ruleTerminalRuleCall
{ after(grammarAccess.getTerminalRuleCallRule()); } 
	 EOF 
;

// Rule TerminalRuleCall
ruleTerminalRuleCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); }
		(rule__TerminalRuleCall__RuleAssignment)
		{ after(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleRuleID
entryRuleRuleID
:
{ before(grammarAccess.getRuleIDRule()); }
	 ruleRuleID
{ after(grammarAccess.getRuleIDRule()); } 
	 EOF 
;

// Rule RuleID
ruleRuleID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getRuleIDAccess().getGroup()); }
		(rule__RuleID__Group__0)
		{ after(grammarAccess.getRuleIDAccess().getGroup()); }
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

// Entry rule entryRulePredicatedKeyword
entryRulePredicatedKeyword
:
{ before(grammarAccess.getPredicatedKeywordRule()); }
	 rulePredicatedKeyword
{ after(grammarAccess.getPredicatedKeywordRule()); } 
	 EOF 
;

// Rule PredicatedKeyword
rulePredicatedKeyword 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPredicatedKeywordAccess().getGroup()); }
		(rule__PredicatedKeyword__Group__0)
		{ after(grammarAccess.getPredicatedKeywordAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePredicatedRuleCall
entryRulePredicatedRuleCall
:
{ before(grammarAccess.getPredicatedRuleCallRule()); }
	 rulePredicatedRuleCall
{ after(grammarAccess.getPredicatedRuleCallRule()); } 
	 EOF 
;

// Rule PredicatedRuleCall
rulePredicatedRuleCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getGroup()); }
		(rule__PredicatedRuleCall__Group__0)
		{ after(grammarAccess.getPredicatedRuleCallAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssignment
entryRuleAssignment
:
{ before(grammarAccess.getAssignmentRule()); }
	 ruleAssignment
{ after(grammarAccess.getAssignmentRule()); } 
	 EOF 
;

// Rule Assignment
ruleAssignment 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignmentAccess().getGroup()); }
		(rule__Assignment__Group__0)
		{ after(grammarAccess.getAssignmentAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssignableTerminal
entryRuleAssignableTerminal
:
{ before(grammarAccess.getAssignableTerminalRule()); }
	 ruleAssignableTerminal
{ after(grammarAccess.getAssignableTerminalRule()); } 
	 EOF 
;

// Rule AssignableTerminal
ruleAssignableTerminal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); }
		(rule__AssignableTerminal__Alternatives)
		{ after(grammarAccess.getAssignableTerminalAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParenthesizedAssignableElement
entryRuleParenthesizedAssignableElement
:
{ before(grammarAccess.getParenthesizedAssignableElementRule()); }
	 ruleParenthesizedAssignableElement
{ after(grammarAccess.getParenthesizedAssignableElementRule()); } 
	 EOF 
;

// Rule ParenthesizedAssignableElement
ruleParenthesizedAssignableElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); }
		(rule__ParenthesizedAssignableElement__Group__0)
		{ after(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAssignableAlternatives
entryRuleAssignableAlternatives
:
{ before(grammarAccess.getAssignableAlternativesRule()); }
	 ruleAssignableAlternatives
{ after(grammarAccess.getAssignableAlternativesRule()); } 
	 EOF 
;

// Rule AssignableAlternatives
ruleAssignableAlternatives 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAssignableAlternativesAccess().getGroup()); }
		(rule__AssignableAlternatives__Group__0)
		{ after(grammarAccess.getAssignableAlternativesAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCrossReference
entryRuleCrossReference
:
{ before(grammarAccess.getCrossReferenceRule()); }
	 ruleCrossReference
{ after(grammarAccess.getCrossReferenceRule()); } 
	 EOF 
;

// Rule CrossReference
ruleCrossReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCrossReferenceAccess().getGroup()); }
		(rule__CrossReference__Group__0)
		{ after(grammarAccess.getCrossReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCrossReferenceableTerminal
entryRuleCrossReferenceableTerminal
:
{ before(grammarAccess.getCrossReferenceableTerminalRule()); }
	 ruleCrossReferenceableTerminal
{ after(grammarAccess.getCrossReferenceableTerminalRule()); } 
	 EOF 
;

// Rule CrossReferenceableTerminal
ruleCrossReferenceableTerminal 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); }
		(rule__CrossReferenceableTerminal__Alternatives)
		{ after(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParenthesizedElement
entryRuleParenthesizedElement
:
{ before(grammarAccess.getParenthesizedElementRule()); }
	 ruleParenthesizedElement
{ after(grammarAccess.getParenthesizedElementRule()); } 
	 EOF 
;

// Rule ParenthesizedElement
ruleParenthesizedElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParenthesizedElementAccess().getGroup()); }
		(rule__ParenthesizedElement__Group__0)
		{ after(grammarAccess.getParenthesizedElementAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePredicatedGroup
entryRulePredicatedGroup
:
{ before(grammarAccess.getPredicatedGroupRule()); }
	 rulePredicatedGroup
{ after(grammarAccess.getPredicatedGroupRule()); } 
	 EOF 
;

// Rule PredicatedGroup
rulePredicatedGroup 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPredicatedGroupAccess().getGroup()); }
		(rule__PredicatedGroup__Group__0)
		{ after(grammarAccess.getPredicatedGroupAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalRule
entryRuleTerminalRule
:
{ before(grammarAccess.getTerminalRuleRule()); }
	 ruleTerminalRule
{ after(grammarAccess.getTerminalRuleRule()); } 
	 EOF 
;

// Rule TerminalRule
ruleTerminalRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getGroup()); }
		(rule__TerminalRule__Group__0)
		{ after(grammarAccess.getTerminalRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalAlternatives
entryRuleTerminalAlternatives
:
{ before(grammarAccess.getTerminalAlternativesRule()); }
	 ruleTerminalAlternatives
{ after(grammarAccess.getTerminalAlternativesRule()); } 
	 EOF 
;

// Rule TerminalAlternatives
ruleTerminalAlternatives 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalAlternativesAccess().getGroup()); }
		(rule__TerminalAlternatives__Group__0)
		{ after(grammarAccess.getTerminalAlternativesAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalGroup
entryRuleTerminalGroup
:
{ before(grammarAccess.getTerminalGroupRule()); }
	 ruleTerminalGroup
{ after(grammarAccess.getTerminalGroupRule()); } 
	 EOF 
;

// Rule TerminalGroup
ruleTerminalGroup 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalGroupAccess().getGroup()); }
		(rule__TerminalGroup__Group__0)
		{ after(grammarAccess.getTerminalGroupAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalToken
entryRuleTerminalToken
:
{ before(grammarAccess.getTerminalTokenRule()); }
	 ruleTerminalToken
{ after(grammarAccess.getTerminalTokenRule()); } 
	 EOF 
;

// Rule TerminalToken
ruleTerminalToken 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalTokenAccess().getGroup()); }
		(rule__TerminalToken__Group__0)
		{ after(grammarAccess.getTerminalTokenAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTerminalTokenElement
entryRuleTerminalTokenElement
:
{ before(grammarAccess.getTerminalTokenElementRule()); }
	 ruleTerminalTokenElement
{ after(grammarAccess.getTerminalTokenElementRule()); } 
	 EOF 
;

// Rule TerminalTokenElement
ruleTerminalTokenElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); }
		(rule__TerminalTokenElement__Alternatives)
		{ after(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParenthesizedTerminalElement
entryRuleParenthesizedTerminalElement
:
{ before(grammarAccess.getParenthesizedTerminalElementRule()); }
	 ruleParenthesizedTerminalElement
{ after(grammarAccess.getParenthesizedTerminalElementRule()); } 
	 EOF 
;

// Rule ParenthesizedTerminalElement
ruleParenthesizedTerminalElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); }
		(rule__ParenthesizedTerminalElement__Group__0)
		{ after(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAbstractNegatedToken
entryRuleAbstractNegatedToken
:
{ before(grammarAccess.getAbstractNegatedTokenRule()); }
	 ruleAbstractNegatedToken
{ after(grammarAccess.getAbstractNegatedTokenRule()); } 
	 EOF 
;

// Rule AbstractNegatedToken
ruleAbstractNegatedToken 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); }
		(rule__AbstractNegatedToken__Alternatives)
		{ after(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNegatedToken
entryRuleNegatedToken
:
{ before(grammarAccess.getNegatedTokenRule()); }
	 ruleNegatedToken
{ after(grammarAccess.getNegatedTokenRule()); } 
	 EOF 
;

// Rule NegatedToken
ruleNegatedToken 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNegatedTokenAccess().getGroup()); }
		(rule__NegatedToken__Group__0)
		{ after(grammarAccess.getNegatedTokenAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleUntilToken
entryRuleUntilToken
:
{ before(grammarAccess.getUntilTokenRule()); }
	 ruleUntilToken
{ after(grammarAccess.getUntilTokenRule()); } 
	 EOF 
;

// Rule UntilToken
ruleUntilToken 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getUntilTokenAccess().getGroup()); }
		(rule__UntilToken__Group__0)
		{ after(grammarAccess.getUntilTokenAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleWildcard
entryRuleWildcard
:
{ before(grammarAccess.getWildcardRule()); }
	 ruleWildcard
{ after(grammarAccess.getWildcardRule()); } 
	 EOF 
;

// Rule Wildcard
ruleWildcard 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getWildcardAccess().getGroup()); }
		(rule__Wildcard__Group__0)
		{ after(grammarAccess.getWildcardAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEOF
entryRuleEOF
:
{ before(grammarAccess.getEOFRule()); }
	 ruleEOF
{ after(grammarAccess.getEOFRule()); } 
	 EOF 
;

// Rule EOF
ruleEOF 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEOFAccess().getGroup()); }
		(rule__EOF__Group__0)
		{ after(grammarAccess.getEOFAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCharacterRange
entryRuleCharacterRange
:
{ before(grammarAccess.getCharacterRangeRule()); }
	 ruleCharacterRange
{ after(grammarAccess.getCharacterRangeRule()); } 
	 EOF 
;

// Rule CharacterRange
ruleCharacterRange 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCharacterRangeAccess().getGroup()); }
		(rule__CharacterRange__Group__0)
		{ after(grammarAccess.getCharacterRangeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEnumRule
entryRuleEnumRule
:
{ before(grammarAccess.getEnumRuleRule()); }
	 ruleEnumRule
{ after(grammarAccess.getEnumRuleRule()); } 
	 EOF 
;

// Rule EnumRule
ruleEnumRule 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEnumRuleAccess().getGroup()); }
		(rule__EnumRule__Group__0)
		{ after(grammarAccess.getEnumRuleAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEnumLiterals
entryRuleEnumLiterals
:
{ before(grammarAccess.getEnumLiteralsRule()); }
	 ruleEnumLiterals
{ after(grammarAccess.getEnumLiteralsRule()); } 
	 EOF 
;

// Rule EnumLiterals
ruleEnumLiterals 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEnumLiteralsAccess().getGroup()); }
		(rule__EnumLiterals__Group__0)
		{ after(grammarAccess.getEnumLiteralsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleEnumLiteralDeclaration
entryRuleEnumLiteralDeclaration
:
{ before(grammarAccess.getEnumLiteralDeclarationRule()); }
	 ruleEnumLiteralDeclaration
{ after(grammarAccess.getEnumLiteralDeclarationRule()); } 
	 EOF 
;

// Rule EnumLiteralDeclaration
ruleEnumLiteralDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); }
		(rule__EnumLiteralDeclaration__Group__0)
		{ after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractRule__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); }
		ruleParserRule
		{ after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); }
		ruleTerminalRule
		{ after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); }
		ruleEnumRule
		{ after(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractMetamodelDeclaration__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); }
		ruleGeneratedMetamodel
		{ after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); }
		ruleReferencedMetamodel
		{ after(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getGroup_1_0()); }
		(rule__ParserRule__Group_1_0__0)
		{ after(grammarAccess.getParserRuleAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getParserRuleAccess().getGroup_1_1()); }
		(rule__ParserRule__Group_1_1__0)
		{ after(grammarAccess.getParserRuleAccess().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Alternatives_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getWildcardAssignment_1_0_2_0()); }
		(rule__ParserRule__WildcardAssignment_1_0_2_0)
		{ after(grammarAccess.getParserRuleAccess().getWildcardAssignment_1_0_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getParserRuleAccess().getGroup_1_0_2_1()); }
		(rule__ParserRule__Group_1_0_2_1__0)?
		{ after(grammarAccess.getParserRuleAccess().getGroup_1_0_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); }
		ruleUnorderedGroup
		{ after(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getConditionalBranchAccess().getGroup_1()); }
		(rule__ConditionalBranch__Group_1__0)
		{ after(grammarAccess.getConditionalBranchAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractToken__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); }
		ruleAbstractTokenWithCardinality
		{ after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); }
		ruleAction
		{ after(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractTokenWithCardinality__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); }
		ruleAssignment
		{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); }
		ruleAbstractTerminal
		{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); }
		'?'
		{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityQuestionMarkKeyword_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); }
		'*'
		{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAsteriskKeyword_1_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); }
		'+'
		{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityPlusSignKeyword_1_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__OperatorAlternatives_2_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); }
		'='
		{ after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); }
		'+='
		{ after(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractTerminal__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); }
		ruleKeyword
		{ after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); }
		ruleRuleCall
		{ after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); }
		ruleParenthesizedElement
		{ after(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); }
		rulePredicatedKeyword
		{ after(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); }
		rulePredicatedRuleCall
		{ after(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); }
		rulePredicatedGroup
		{ after(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralCondition__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0()); }
		(rule__LiteralCondition__TrueAssignment_1_0)
		{ after(grammarAccess.getLiteralConditionAccess().getTrueAssignment_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getLiteralConditionAccess().getFalseKeyword_1_1()); }
		'false'
		{ after(grammarAccess.getLiteralConditionAccess().getFalseKeyword_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNegationAccess().getAtomParserRuleCall_0()); }
		ruleAtom
		{ after(grammarAccess.getNegationAccess().getAtomParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getNegationAccess().getGroup_1()); }
		(rule__Negation__Group_1__0)
		{ after(grammarAccess.getNegationAccess().getGroup_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Atom__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAtomAccess().getParameterReferenceParserRuleCall_0()); }
		ruleParameterReference
		{ after(grammarAccess.getAtomAccess().getParameterReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAtomAccess().getParenthesizedConditionParserRuleCall_1()); }
		ruleParenthesizedCondition
		{ after(grammarAccess.getAtomAccess().getParenthesizedConditionParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAtomAccess().getLiteralConditionParserRuleCall_2()); }
		ruleLiteralCondition
		{ after(grammarAccess.getAtomAccess().getLiteralConditionParserRuleCall_2()); }
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
		{ before(grammarAccess.getValidIDAccess().getTrueKeyword_1()); }
		'true'
		{ after(grammarAccess.getValidIDAccess().getTrueKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getValidIDAccess().getFalseKeyword_2()); }
		'false'
		{ after(grammarAccess.getValidIDAccess().getFalseKeyword_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedKeyword__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0()); }
		(rule__PredicatedKeyword__PredicatedAssignment_0_0)
		{ after(grammarAccess.getPredicatedKeywordAccess().getPredicatedAssignment_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1()); }
		(rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1)
		{ after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedAssignment_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0()); }
		(rule__PredicatedRuleCall__PredicatedAssignment_0_0)
		{ after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedAssignment_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1()); }
		(rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1)
		{ after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedAssignment_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0()); }
		(rule__Assignment__PredicatedAssignment_0_0)
		{ after(grammarAccess.getAssignmentAccess().getPredicatedAssignment_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1()); }
		(rule__Assignment__FirstSetPredicatedAssignment_0_1)
		{ after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedAssignment_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__OperatorAlternatives_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); }
		'+='
		{ after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); }
		'='
		{ after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); }
		'?='
		{ after(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableTerminal__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); }
		ruleKeyword
		{ after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); }
		ruleRuleCall
		{ after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); }
		ruleParenthesizedAssignableElement
		{ after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); }
		ruleCrossReference
		{ after(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReferenceableTerminal__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); }
		ruleKeyword
		{ after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); }
		ruleRuleCall
		{ after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0()); }
		(rule__PredicatedGroup__PredicatedAssignment_0_0)
		{ after(grammarAccess.getPredicatedGroupAccess().getPredicatedAssignment_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1()); }
		(rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1)
		{ after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedAssignment_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getGroup_2_0()); }
		(rule__TerminalRule__Group_2_0__0)
		{ after(grammarAccess.getTerminalRuleAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalRuleAccess().getGroup_2_1()); }
		(rule__TerminalRule__Group_2_1__0)
		{ after(grammarAccess.getTerminalRuleAccess().getGroup_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalToken__CardinalityAlternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); }
		'?'
		{ after(grammarAccess.getTerminalTokenAccess().getCardinalityQuestionMarkKeyword_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); }
		'*'
		{ after(grammarAccess.getTerminalTokenAccess().getCardinalityAsteriskKeyword_1_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); }
		'+'
		{ after(grammarAccess.getTerminalTokenAccess().getCardinalityPlusSignKeyword_1_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalTokenElement__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); }
		ruleCharacterRange
		{ after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); }
		ruleTerminalRuleCall
		{ after(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); }
		ruleParenthesizedTerminalElement
		{ after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); }
		ruleAbstractNegatedToken
		{ after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); }
		ruleWildcard
		{ after(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); }
		ruleEOF
		{ after(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractNegatedToken__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); }
		ruleNegatedToken
		{ after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); }
		ruleUntilToken
		{ after(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group__0__Impl
	rule__Grammar__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); }
	'grammar'
	{ after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group__1__Impl
	rule__Grammar__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getNameAssignment_1()); }
	(rule__Grammar__NameAssignment_1)
	{ after(grammarAccess.getGrammarAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group__2__Impl
	rule__Grammar__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getGroup_2()); }
	(rule__Grammar__Group_2__0)?
	{ after(grammarAccess.getGrammarAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group__3__Impl
	rule__Grammar__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getGroup_3()); }
	(rule__Grammar__Group_3__0)?
	{ after(grammarAccess.getGrammarAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group__4__Impl
	rule__Grammar__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); }
	(rule__Grammar__MetamodelDeclarationsAssignment_4)*
	{ after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); }
		(rule__Grammar__RulesAssignment_5)
		{ after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); }
	)
	(
		{ before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); }
		(rule__Grammar__RulesAssignment_5)*
		{ after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Grammar__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_2__0__Impl
	rule__Grammar__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); }
	'with'
	{ after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_2__1__Impl
	rule__Grammar__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); }
	(rule__Grammar__UsedGrammarsAssignment_2_1)
	{ after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getGroup_2_2()); }
	(rule__Grammar__Group_2_2__0)*
	{ after(grammarAccess.getGrammarAccess().getGroup_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Grammar__Group_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_2_2__0__Impl
	rule__Grammar__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); }
	','
	{ after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); }
	(rule__Grammar__UsedGrammarsAssignment_2_2_1)
	{ after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Grammar__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3__0__Impl
	rule__Grammar__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); }
	(rule__Grammar__DefinesHiddenTokensAssignment_3_0)
	{ after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3__1__Impl
	rule__Grammar__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); }
	'('
	{ after(grammarAccess.getGrammarAccess().getLeftParenthesisKeyword_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3__2__Impl
	rule__Grammar__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getGroup_3_2()); }
	(rule__Grammar__Group_3_2__0)?
	{ after(grammarAccess.getGrammarAccess().getGroup_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); }
	')'
	{ after(grammarAccess.getGrammarAccess().getRightParenthesisKeyword_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Grammar__Group_3_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3_2__0__Impl
	rule__Grammar__Group_3_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); }
	(rule__Grammar__HiddenTokensAssignment_3_2_0)
	{ after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getGroup_3_2_1()); }
	(rule__Grammar__Group_3_2_1__0)*
	{ after(grammarAccess.getGrammarAccess().getGroup_3_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Grammar__Group_3_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3_2_1__0__Impl
	rule__Grammar__Group_3_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); }
	','
	{ after(grammarAccess.getGrammarAccess().getCommaKeyword_3_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Grammar__Group_3_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__Group_3_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); }
	(rule__Grammar__HiddenTokensAssignment_3_2_1_1)
	{ after(grammarAccess.getGrammarAccess().getHiddenTokensAssignment_3_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__GrammarID__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GrammarID__Group__0__Impl
	rule__GrammarID__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GrammarID__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_0()); }
	ruleValidID
	{ after(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GrammarID__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GrammarID__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GrammarID__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarIDAccess().getGroup_1()); }
	(rule__GrammarID__Group_1__0)*
	{ after(grammarAccess.getGrammarIDAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__GrammarID__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GrammarID__Group_1__0__Impl
	rule__GrammarID__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GrammarID__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GrammarID__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GrammarID__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GrammarID__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_1_1()); }
	ruleValidID
	{ after(grammarAccess.getGrammarIDAccess().getValidIDParserRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__GeneratedMetamodel__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GeneratedMetamodel__Group__0__Impl
	rule__GeneratedMetamodel__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); }
	'generate'
	{ after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GeneratedMetamodel__Group__1__Impl
	rule__GeneratedMetamodel__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); }
	(rule__GeneratedMetamodel__NameAssignment_1)
	{ after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GeneratedMetamodel__Group__2__Impl
	rule__GeneratedMetamodel__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); }
	(rule__GeneratedMetamodel__EPackageAssignment_2)
	{ after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GeneratedMetamodel__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); }
	(rule__GeneratedMetamodel__Group_3__0)?
	{ after(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__GeneratedMetamodel__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GeneratedMetamodel__Group_3__0__Impl
	rule__GeneratedMetamodel__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); }
	'as'
	{ after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__GeneratedMetamodel__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); }
	(rule__GeneratedMetamodel__AliasAssignment_3_1)
	{ after(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReferencedMetamodel__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferencedMetamodel__Group__0__Impl
	rule__ReferencedMetamodel__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); }
	'import'
	{ after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferencedMetamodel__Group__1__Impl
	rule__ReferencedMetamodel__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); }
	(rule__ReferencedMetamodel__EPackageAssignment_1)
	{ after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferencedMetamodel__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); }
	(rule__ReferencedMetamodel__Group_2__0)?
	{ after(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ReferencedMetamodel__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferencedMetamodel__Group_2__0__Impl
	rule__ReferencedMetamodel__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); }
	'as'
	{ after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ReferencedMetamodel__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); }
	(rule__ReferencedMetamodel__AliasAssignment_2_1)
	{ after(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Annotation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__0__Impl
	rule__Annotation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); }
	'@'
	{ after(grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Annotation__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAnnotationAccess().getNameAssignment_1()); }
	(rule__Annotation__NameAssignment_1)
	{ after(grammarAccess.getAnnotationAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group__0__Impl
	rule__ParserRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getAnnotationsAssignment_0()); }
	(rule__ParserRule__AnnotationsAssignment_0)*
	{ after(grammarAccess.getParserRuleAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group__1__Impl
	rule__ParserRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getAlternatives_1()); }
	(rule__ParserRule__Alternatives_1)
	{ after(grammarAccess.getParserRuleAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group__2__Impl
	rule__ParserRule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getGroup_2()); }
	(rule__ParserRule__Group_2__0)?
	{ after(grammarAccess.getParserRuleAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group__3__Impl
	rule__ParserRule__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getColonKeyword_3()); }
	':'
	{ after(grammarAccess.getParserRuleAccess().getColonKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group__4__Impl
	rule__ParserRule__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); }
	(rule__ParserRule__AlternativesAssignment_4)
	{ after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); }
	';'
	{ after(grammarAccess.getParserRuleAccess().getSemicolonKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_0__0__Impl
	rule__ParserRule__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getFragmentAssignment_1_0_0()); }
	(rule__ParserRule__FragmentAssignment_1_0_0)
	{ after(grammarAccess.getParserRuleAccess().getFragmentAssignment_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_0__1__Impl
	rule__ParserRule__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_0_1()); }
	ruleRuleNameAndParams
	{ after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getAlternatives_1_0_2()); }
	(rule__ParserRule__Alternatives_1_0_2)
	{ after(grammarAccess.getParserRuleAccess().getAlternatives_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group_1_0_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_0_2_1__0__Impl
	rule__ParserRule__Group_1_0_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0_2_1_0()); }
	'returns'
	{ after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_0_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_0_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_0_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_0_2_1_1()); }
	(rule__ParserRule__TypeAssignment_1_0_2_1_1)
	{ after(grammarAccess.getParserRuleAccess().getTypeAssignment_1_0_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_1__0__Impl
	rule__ParserRule__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_1_0()); }
	ruleRuleNameAndParams
	{ after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getGroup_1_1_1()); }
	(rule__ParserRule__Group_1_1_1__0)?
	{ after(grammarAccess.getParserRuleAccess().getGroup_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_1_1__0__Impl
	rule__ParserRule__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_1_1_0()); }
	'returns'
	{ after(grammarAccess.getParserRuleAccess().getReturnsKeyword_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1_1_1()); }
	(rule__ParserRule__TypeAssignment_1_1_1_1)
	{ after(grammarAccess.getParserRuleAccess().getTypeAssignment_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2__0__Impl
	rule__ParserRule__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); }
	(rule__ParserRule__DefinesHiddenTokensAssignment_2_0)
	{ after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensAssignment_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2__1__Impl
	rule__ParserRule__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); }
	'('
	{ after(grammarAccess.getParserRuleAccess().getLeftParenthesisKeyword_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2__2__Impl
	rule__ParserRule__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getGroup_2_2()); }
	(rule__ParserRule__Group_2_2__0)?
	{ after(grammarAccess.getParserRuleAccess().getGroup_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); }
	')'
	{ after(grammarAccess.getParserRuleAccess().getRightParenthesisKeyword_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2_2__0__Impl
	rule__ParserRule__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); }
	(rule__ParserRule__HiddenTokensAssignment_2_2_0)
	{ after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); }
	(rule__ParserRule__Group_2_2_1__0)*
	{ after(grammarAccess.getParserRuleAccess().getGroup_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParserRule__Group_2_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2_2_1__0__Impl
	rule__ParserRule__Group_2_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); }
	','
	{ after(grammarAccess.getParserRuleAccess().getCommaKeyword_2_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParserRule__Group_2_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__Group_2_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); }
	(rule__ParserRule__HiddenTokensAssignment_2_2_1_1)
	{ after(grammarAccess.getParserRuleAccess().getHiddenTokensAssignment_2_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleNameAndParams__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group__0__Impl
	rule__RuleNameAndParams__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); }
	(rule__RuleNameAndParams__NameAssignment_0)
	{ after(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); }
	(rule__RuleNameAndParams__Group_1__0)?
	{ after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleNameAndParams__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group_1__0__Impl
	rule__RuleNameAndParams__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()); }
	'<'
	{ after(grammarAccess.getRuleNameAndParamsAccess().getLessThanSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group_1__1__Impl
	rule__RuleNameAndParams__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); }
	(rule__RuleNameAndParams__Group_1_1__0)?
	{ after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()); }
	'>'
	{ after(grammarAccess.getRuleNameAndParamsAccess().getGreaterThanSignKeyword_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleNameAndParams__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group_1_1__0__Impl
	rule__RuleNameAndParams__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); }
	(rule__RuleNameAndParams__ParametersAssignment_1_1_0)
	{ after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); }
	(rule__RuleNameAndParams__Group_1_1_1__0)*
	{ after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleNameAndParams__Group_1_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group_1_1_1__0__Impl
	rule__RuleNameAndParams__Group_1_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); }
	','
	{ after(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleNameAndParams__Group_1_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__Group_1_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); }
	(rule__RuleNameAndParams__ParametersAssignment_1_1_1_1)
	{ after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeRef__Group__0__Impl
	rule__TypeRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeRefAccess().getGroup_0()); }
	(rule__TypeRef__Group_0__0)?
	{ after(grammarAccess.getTypeRefAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeRef__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); }
	(rule__TypeRef__ClassifierAssignment_1)
	{ after(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeRef__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeRef__Group_0__0__Impl
	rule__TypeRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); }
	(rule__TypeRef__MetamodelAssignment_0_0)
	{ after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeRef__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); }
	'::'
	{ after(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Alternatives__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Alternatives__Group__0__Impl
	rule__Alternatives__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); }
	ruleConditionalBranch
	{ after(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Alternatives__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlternativesAccess().getGroup_1()); }
	(rule__Alternatives__Group_1__0)?
	{ after(grammarAccess.getAlternativesAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Alternatives__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Alternatives__Group_1__0__Impl
	rule__Alternatives__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); }
	()
	{ after(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Alternatives__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getAlternativesAccess().getGroup_1_1()); }
		(rule__Alternatives__Group_1_1__0)
		{ after(grammarAccess.getAlternativesAccess().getGroup_1_1()); }
	)
	(
		{ before(grammarAccess.getAlternativesAccess().getGroup_1_1()); }
		(rule__Alternatives__Group_1_1__0)*
		{ after(grammarAccess.getAlternativesAccess().getGroup_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Alternatives__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Alternatives__Group_1_1__0__Impl
	rule__Alternatives__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); }
	'|'
	{ after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Alternatives__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); }
	(rule__Alternatives__ElementsAssignment_1_1_1)
	{ after(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ConditionalBranch__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalBranch__Group_1__0__Impl
	rule__ConditionalBranch__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalBranchAccess().getGroupAction_1_0()); }
	()
	{ after(grammarAccess.getConditionalBranchAccess().getGroupAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalBranch__Group_1__1__Impl
	rule__ConditionalBranch__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1()); }
	'<'
	{ after(grammarAccess.getConditionalBranchAccess().getLessThanSignKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalBranch__Group_1__2__Impl
	rule__ConditionalBranch__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2()); }
	(rule__ConditionalBranch__GuardConditionAssignment_1_2)
	{ after(grammarAccess.getConditionalBranchAccess().getGuardConditionAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalBranch__Group_1__3__Impl
	rule__ConditionalBranch__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3()); }
	'>'
	{ after(grammarAccess.getConditionalBranchAccess().getGreaterThanSignKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ConditionalBranch__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); }
		(rule__ConditionalBranch__ElementsAssignment_1_4)
		{ after(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); }
	)
	(
		{ before(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); }
		(rule__ConditionalBranch__ElementsAssignment_1_4)*
		{ after(grammarAccess.getConditionalBranchAccess().getElementsAssignment_1_4()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UnorderedGroup__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnorderedGroup__Group__0__Impl
	rule__UnorderedGroup__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); }
	ruleGroup
	{ after(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnorderedGroup__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); }
	(rule__UnorderedGroup__Group_1__0)?
	{ after(grammarAccess.getUnorderedGroupAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UnorderedGroup__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnorderedGroup__Group_1__0__Impl
	rule__UnorderedGroup__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); }
	()
	{ after(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnorderedGroup__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); }
		(rule__UnorderedGroup__Group_1_1__0)
		{ after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); }
	)
	(
		{ before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); }
		(rule__UnorderedGroup__Group_1_1__0)*
		{ after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UnorderedGroup__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnorderedGroup__Group_1_1__0__Impl
	rule__UnorderedGroup__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); }
	'&'
	{ after(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UnorderedGroup__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); }
	(rule__UnorderedGroup__ElementsAssignment_1_1_1)
	{ after(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Group__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Group__Group__0__Impl
	rule__Group__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Group__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); }
	ruleAbstractToken
	{ after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Group__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Group__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Group__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGroupAccess().getGroup_1()); }
	(rule__Group__Group_1__0)?
	{ after(grammarAccess.getGroupAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Group__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Group__Group_1__0__Impl
	rule__Group__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Group__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); }
	()
	{ after(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Group__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Group__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Group__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); }
		(rule__Group__ElementsAssignment_1_1)
		{ after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); }
	)
	(
		{ before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); }
		(rule__Group__ElementsAssignment_1_1)*
		{ after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AbstractTokenWithCardinality__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AbstractTokenWithCardinality__Group__0__Impl
	rule__AbstractTokenWithCardinality__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractTokenWithCardinality__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); }
	(rule__AbstractTokenWithCardinality__Alternatives_0)
	{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractTokenWithCardinality__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AbstractTokenWithCardinality__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractTokenWithCardinality__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); }
	(rule__AbstractTokenWithCardinality__CardinalityAssignment_1)?
	{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Action__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group__0__Impl
	rule__Action__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); }
	'{'
	{ after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group__1__Impl
	rule__Action__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getTypeAssignment_1()); }
	(rule__Action__TypeAssignment_1)
	{ after(grammarAccess.getActionAccess().getTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group__2__Impl
	rule__Action__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getGroup_2()); }
	(rule__Action__Group_2__0)?
	{ after(grammarAccess.getActionAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); }
	'}'
	{ after(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Action__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group_2__0__Impl
	rule__Action__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); }
	'.'
	{ after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group_2__1__Impl
	rule__Action__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); }
	(rule__Action__FeatureAssignment_2_1)
	{ after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group_2__2__Impl
	rule__Action__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); }
	(rule__Action__OperatorAssignment_2_2)
	{ after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Action__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Group_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); }
	'current'
	{ after(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleCall__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group__0__Impl
	rule__RuleCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getRuleAssignment_0()); }
	(rule__RuleCall__RuleAssignment_0)
	{ after(grammarAccess.getRuleCallAccess().getRuleAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getGroup_1()); }
	(rule__RuleCall__Group_1__0)?
	{ after(grammarAccess.getRuleCallAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleCall__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group_1__0__Impl
	rule__RuleCall__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0()); }
	'<'
	{ after(grammarAccess.getRuleCallAccess().getLessThanSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group_1__1__Impl
	rule__RuleCall__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1()); }
	(rule__RuleCall__ArgumentsAssignment_1_1)
	{ after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group_1__2__Impl
	rule__RuleCall__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getGroup_1_2()); }
	(rule__RuleCall__Group_1_2__0)*
	{ after(grammarAccess.getRuleCallAccess().getGroup_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group_1__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3()); }
	'>'
	{ after(grammarAccess.getRuleCallAccess().getGreaterThanSignKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleCall__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group_1_2__0__Impl
	rule__RuleCall__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0()); }
	','
	{ after(grammarAccess.getRuleCallAccess().getCommaKeyword_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleCall__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1()); }
	(rule__RuleCall__ArgumentsAssignment_1_2_1)
	{ after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NamedArgument__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NamedArgument__Group__0__Impl
	rule__NamedArgument__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNamedArgumentAccess().getGroup_0()); }
	(rule__NamedArgument__Group_0__0)?
	{ after(grammarAccess.getNamedArgumentAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NamedArgument__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNamedArgumentAccess().getValueAssignment_1()); }
	(rule__NamedArgument__ValueAssignment_1)
	{ after(grammarAccess.getNamedArgumentAccess().getValueAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NamedArgument__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NamedArgument__Group_0__0__Impl
	rule__NamedArgument__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0()); }
	(rule__NamedArgument__ParameterAssignment_0_0)
	{ after(grammarAccess.getNamedArgumentAccess().getParameterAssignment_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NamedArgument__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1()); }
	(rule__NamedArgument__CalledByNameAssignment_0_1)
	{ after(grammarAccess.getNamedArgumentAccess().getCalledByNameAssignment_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__LiteralCondition__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralCondition__Group__0__Impl
	rule__LiteralCondition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralCondition__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0()); }
	()
	{ after(grammarAccess.getLiteralConditionAccess().getLiteralConditionAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralCondition__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__LiteralCondition__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralCondition__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLiteralConditionAccess().getAlternatives_1()); }
	(rule__LiteralCondition__Alternatives_1)
	{ after(grammarAccess.getLiteralConditionAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Disjunction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Disjunction__Group__0__Impl
	rule__Disjunction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); }
	ruleConjunction
	{ after(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Disjunction__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDisjunctionAccess().getGroup_1()); }
	(rule__Disjunction__Group_1__0)*
	{ after(grammarAccess.getDisjunctionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Disjunction__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Disjunction__Group_1__0__Impl
	rule__Disjunction__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); }
	()
	{ after(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Disjunction__Group_1__1__Impl
	rule__Disjunction__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); }
	'|'
	{ after(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Disjunction__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); }
	(rule__Disjunction__RightAssignment_1_2)
	{ after(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Conjunction__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Conjunction__Group__0__Impl
	rule__Conjunction__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); }
	ruleNegation
	{ after(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Conjunction__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConjunctionAccess().getGroup_1()); }
	(rule__Conjunction__Group_1__0)*
	{ after(grammarAccess.getConjunctionAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Conjunction__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Conjunction__Group_1__0__Impl
	rule__Conjunction__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); }
	()
	{ after(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Conjunction__Group_1__1__Impl
	rule__Conjunction__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); }
	'&'
	{ after(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Conjunction__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); }
	(rule__Conjunction__RightAssignment_1_2)
	{ after(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Negation__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Negation__Group_1__0__Impl
	rule__Negation__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNegationAccess().getNegationAction_1_0()); }
	()
	{ after(grammarAccess.getNegationAccess().getNegationAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Negation__Group_1__1__Impl
	rule__Negation__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1()); }
	'!'
	{ after(grammarAccess.getNegationAccess().getExclamationMarkKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Negation__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNegationAccess().getValueAssignment_1_2()); }
	(rule__Negation__ValueAssignment_1_2)
	{ after(grammarAccess.getNegationAccess().getValueAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParenthesizedCondition__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedCondition__Group__0__Impl
	rule__ParenthesizedCondition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedCondition__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0()); }
	'('
	{ after(grammarAccess.getParenthesizedConditionAccess().getLeftParenthesisKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedCondition__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedCondition__Group__1__Impl
	rule__ParenthesizedCondition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedCondition__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedConditionAccess().getDisjunctionParserRuleCall_1()); }
	ruleDisjunction
	{ after(grammarAccess.getParenthesizedConditionAccess().getDisjunctionParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedCondition__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedCondition__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedCondition__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedConditionAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getParenthesizedConditionAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleID__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleID__Group__0__Impl
	rule__RuleID__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleID__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_0()); }
	ruleValidID
	{ after(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleID__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleID__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleID__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleIDAccess().getGroup_1()); }
	(rule__RuleID__Group_1__0)*
	{ after(grammarAccess.getRuleIDAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__RuleID__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleID__Group_1__0__Impl
	rule__RuleID__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleID__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); }
	'::'
	{ after(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleID__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__RuleID__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleID__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_1_1()); }
	ruleValidID
	{ after(grammarAccess.getRuleIDAccess().getValidIDParserRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PredicatedKeyword__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedKeyword__Group__0__Impl
	rule__PredicatedKeyword__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedKeyword__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0()); }
	(rule__PredicatedKeyword__Alternatives_0)
	{ after(grammarAccess.getPredicatedKeywordAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedKeyword__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedKeyword__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedKeyword__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); }
	(rule__PredicatedKeyword__ValueAssignment_1)
	{ after(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PredicatedRuleCall__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group__0__Impl
	rule__PredicatedRuleCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0()); }
	(rule__PredicatedRuleCall__Alternatives_0)
	{ after(grammarAccess.getPredicatedRuleCallAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group__1__Impl
	rule__PredicatedRuleCall__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); }
	(rule__PredicatedRuleCall__RuleAssignment_1)
	{ after(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2()); }
	(rule__PredicatedRuleCall__Group_2__0)?
	{ after(grammarAccess.getPredicatedRuleCallAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PredicatedRuleCall__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group_2__0__Impl
	rule__PredicatedRuleCall__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0()); }
	'<'
	{ after(grammarAccess.getPredicatedRuleCallAccess().getLessThanSignKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group_2__1__Impl
	rule__PredicatedRuleCall__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1()); }
	(rule__PredicatedRuleCall__ArgumentsAssignment_2_1)
	{ after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group_2__2__Impl
	rule__PredicatedRuleCall__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2()); }
	(rule__PredicatedRuleCall__Group_2_2__0)*
	{ after(grammarAccess.getPredicatedRuleCallAccess().getGroup_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3()); }
	'>'
	{ after(grammarAccess.getPredicatedRuleCallAccess().getGreaterThanSignKeyword_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PredicatedRuleCall__Group_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group_2_2__0__Impl
	rule__PredicatedRuleCall__Group_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getCommaKeyword_2_2_0()); }
	','
	{ after(grammarAccess.getPredicatedRuleCallAccess().getCommaKeyword_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedRuleCall__Group_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__Group_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1()); }
	(rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1)
	{ after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsAssignment_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Assignment__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Assignment__Group__0__Impl
	rule__Assignment__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentAccess().getAlternatives_0()); }
	(rule__Assignment__Alternatives_0)?
	{ after(grammarAccess.getAssignmentAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Assignment__Group__1__Impl
	rule__Assignment__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); }
	(rule__Assignment__FeatureAssignment_1)
	{ after(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Assignment__Group__2__Impl
	rule__Assignment__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); }
	(rule__Assignment__OperatorAssignment_2)
	{ after(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Assignment__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); }
	(rule__Assignment__TerminalAssignment_3)
	{ after(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParenthesizedAssignableElement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedAssignableElement__Group__0__Impl
	rule__ParenthesizedAssignableElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedAssignableElement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); }
	'('
	{ after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedAssignableElement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedAssignableElement__Group__1__Impl
	rule__ParenthesizedAssignableElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedAssignableElement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); }
	ruleAssignableAlternatives
	{ after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedAssignableElement__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedAssignableElement__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedAssignableElement__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignableAlternatives__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignableAlternatives__Group__0__Impl
	rule__AssignableAlternatives__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); }
	ruleAssignableTerminal
	{ after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignableAlternatives__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); }
	(rule__AssignableAlternatives__Group_1__0)?
	{ after(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignableAlternatives__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignableAlternatives__Group_1__0__Impl
	rule__AssignableAlternatives__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); }
	()
	{ after(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignableAlternatives__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); }
		(rule__AssignableAlternatives__Group_1_1__0)
		{ after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); }
	)
	(
		{ before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); }
		(rule__AssignableAlternatives__Group_1_1__0)*
		{ after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__AssignableAlternatives__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignableAlternatives__Group_1_1__0__Impl
	rule__AssignableAlternatives__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); }
	'|'
	{ after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__AssignableAlternatives__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); }
	(rule__AssignableAlternatives__ElementsAssignment_1_1_1)
	{ after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CrossReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CrossReference__Group__0__Impl
	rule__CrossReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); }
	'['
	{ after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CrossReference__Group__1__Impl
	rule__CrossReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); }
	(rule__CrossReference__TypeAssignment_1)
	{ after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CrossReference__Group__2__Impl
	rule__CrossReference__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCrossReferenceAccess().getGroup_2()); }
	(rule__CrossReference__Group_2__0)?
	{ after(grammarAccess.getCrossReferenceAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CrossReference__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); }
	']'
	{ after(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CrossReference__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CrossReference__Group_2__0__Impl
	rule__CrossReference__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); }
	'|'
	{ after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CrossReference__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); }
	(rule__CrossReference__TerminalAssignment_2_1)
	{ after(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParenthesizedElement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedElement__Group__0__Impl
	rule__ParenthesizedElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedElement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); }
	'('
	{ after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedElement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedElement__Group__1__Impl
	rule__ParenthesizedElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedElement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); }
	ruleAlternatives
	{ after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedElement__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedElement__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedElement__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__PredicatedGroup__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedGroup__Group__0__Impl
	rule__PredicatedGroup__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedGroupAccess().getAlternatives_0()); }
	(rule__PredicatedGroup__Alternatives_0)
	{ after(grammarAccess.getPredicatedGroupAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedGroup__Group__1__Impl
	rule__PredicatedGroup__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedGroup__Group__2__Impl
	rule__PredicatedGroup__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); }
	(rule__PredicatedGroup__ElementsAssignment_2)
	{ after(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__PredicatedGroup__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group__0__Impl
	rule__TerminalRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getAnnotationsAssignment_0()); }
	(rule__TerminalRule__AnnotationsAssignment_0)*
	{ after(grammarAccess.getTerminalRuleAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group__1__Impl
	rule__TerminalRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_1()); }
	'terminal'
	{ after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group__2__Impl
	rule__TerminalRule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getAlternatives_2()); }
	(rule__TerminalRule__Alternatives_2)
	{ after(grammarAccess.getTerminalRuleAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group__3__Impl
	rule__TerminalRule__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); }
	':'
	{ after(grammarAccess.getTerminalRuleAccess().getColonKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group__4__Impl
	rule__TerminalRule__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); }
	(rule__TerminalRule__AlternativesAssignment_4)
	{ after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); }
	';'
	{ after(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalRule__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group_2_0__0__Impl
	rule__TerminalRule__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_2_0_0()); }
	(rule__TerminalRule__FragmentAssignment_2_0_0)
	{ after(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_0_1()); }
	(rule__TerminalRule__NameAssignment_2_0_1)
	{ after(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalRule__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group_2_1__0__Impl
	rule__TerminalRule__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_1_0()); }
	(rule__TerminalRule__NameAssignment_2_1_0)
	{ after(grammarAccess.getTerminalRuleAccess().getNameAssignment_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getGroup_2_1_1()); }
	(rule__TerminalRule__Group_2_1_1__0)?
	{ after(grammarAccess.getTerminalRuleAccess().getGroup_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalRule__Group_2_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group_2_1_1__0__Impl
	rule__TerminalRule__Group_2_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_1_1_0()); }
	'returns'
	{ after(grammarAccess.getTerminalRuleAccess().getReturnsKeyword_2_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalRule__Group_2_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__Group_2_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1_1_1()); }
	(rule__TerminalRule__TypeAssignment_2_1_1_1)
	{ after(grammarAccess.getTerminalRuleAccess().getTypeAssignment_2_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalAlternatives__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalAlternatives__Group__0__Impl
	rule__TerminalAlternatives__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); }
	ruleTerminalGroup
	{ after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalAlternatives__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); }
	(rule__TerminalAlternatives__Group_1__0)?
	{ after(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalAlternatives__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalAlternatives__Group_1__0__Impl
	rule__TerminalAlternatives__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); }
	()
	{ after(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalAlternatives__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); }
		(rule__TerminalAlternatives__Group_1_1__0)
		{ after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); }
	)
	(
		{ before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); }
		(rule__TerminalAlternatives__Group_1_1__0)*
		{ after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalAlternatives__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalAlternatives__Group_1_1__0__Impl
	rule__TerminalAlternatives__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); }
	'|'
	{ after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalAlternatives__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); }
	(rule__TerminalAlternatives__ElementsAssignment_1_1_1)
	{ after(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalGroup__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalGroup__Group__0__Impl
	rule__TerminalGroup__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalGroup__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); }
	ruleTerminalToken
	{ after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalGroup__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalGroup__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalGroup__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalGroupAccess().getGroup_1()); }
	(rule__TerminalGroup__Group_1__0)?
	{ after(grammarAccess.getTerminalGroupAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalGroup__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalGroup__Group_1__0__Impl
	rule__TerminalGroup__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalGroup__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); }
	()
	{ after(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalGroup__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalGroup__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalGroup__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); }
		(rule__TerminalGroup__ElementsAssignment_1_1)
		{ after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); }
	)
	(
		{ before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); }
		(rule__TerminalGroup__ElementsAssignment_1_1)*
		{ after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TerminalToken__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalToken__Group__0__Impl
	rule__TerminalToken__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalToken__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); }
	ruleTerminalTokenElement
	{ after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalToken__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TerminalToken__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalToken__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); }
	(rule__TerminalToken__CardinalityAssignment_1)?
	{ after(grammarAccess.getTerminalTokenAccess().getCardinalityAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ParenthesizedTerminalElement__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedTerminalElement__Group__0__Impl
	rule__ParenthesizedTerminalElement__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedTerminalElement__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); }
	'('
	{ after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedTerminalElement__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedTerminalElement__Group__1__Impl
	rule__ParenthesizedTerminalElement__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedTerminalElement__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); }
	ruleTerminalAlternatives
	{ after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedTerminalElement__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ParenthesizedTerminalElement__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ParenthesizedTerminalElement__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__NegatedToken__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NegatedToken__Group__0__Impl
	rule__NegatedToken__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__NegatedToken__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); }
	'!'
	{ after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__NegatedToken__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__NegatedToken__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__NegatedToken__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); }
	(rule__NegatedToken__TerminalAssignment_1)
	{ after(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__UntilToken__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UntilToken__Group__0__Impl
	rule__UntilToken__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__UntilToken__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); }
	'->'
	{ after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__UntilToken__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__UntilToken__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__UntilToken__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); }
	(rule__UntilToken__TerminalAssignment_1)
	{ after(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Wildcard__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Wildcard__Group__0__Impl
	rule__Wildcard__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Wildcard__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWildcardAccess().getWildcardAction_0()); }
	()
	{ after(grammarAccess.getWildcardAccess().getWildcardAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Wildcard__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Wildcard__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Wildcard__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EOF__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EOF__Group__0__Impl
	rule__EOF__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EOF__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEOFAccess().getEOFAction_0()); }
	()
	{ after(grammarAccess.getEOFAccess().getEOFAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EOF__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EOF__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EOF__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEOFAccess().getEOFKeyword_1()); }
	'EOF'
	{ after(grammarAccess.getEOFAccess().getEOFKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CharacterRange__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CharacterRange__Group__0__Impl
	rule__CharacterRange__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); }
	ruleKeyword
	{ after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CharacterRange__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCharacterRangeAccess().getGroup_1()); }
	(rule__CharacterRange__Group_1__0)?
	{ after(grammarAccess.getCharacterRangeAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__CharacterRange__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CharacterRange__Group_1__0__Impl
	rule__CharacterRange__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); }
	()
	{ after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CharacterRange__Group_1__1__Impl
	rule__CharacterRange__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); }
	'..'
	{ after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__CharacterRange__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); }
	(rule__CharacterRange__RightAssignment_1_2)
	{ after(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumRule__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group__0__Impl
	rule__EnumRule__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getAnnotationsAssignment_0()); }
	(rule__EnumRule__AnnotationsAssignment_0)*
	{ after(grammarAccess.getEnumRuleAccess().getAnnotationsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group__1__Impl
	rule__EnumRule__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getEnumKeyword_1()); }
	'enum'
	{ after(grammarAccess.getEnumRuleAccess().getEnumKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group__2__Impl
	rule__EnumRule__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getNameAssignment_2()); }
	(rule__EnumRule__NameAssignment_2)
	{ after(grammarAccess.getEnumRuleAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group__3__Impl
	rule__EnumRule__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getGroup_3()); }
	(rule__EnumRule__Group_3__0)?
	{ after(grammarAccess.getEnumRuleAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group__4__Impl
	rule__EnumRule__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getColonKeyword_4()); }
	':'
	{ after(grammarAccess.getEnumRuleAccess().getColonKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group__5__Impl
	rule__EnumRule__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_5()); }
	(rule__EnumRule__AlternativesAssignment_5)
	{ after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_6()); }
	';'
	{ after(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumRule__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group_3__0__Impl
	rule__EnumRule__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getReturnsKeyword_3_0()); }
	'returns'
	{ after(grammarAccess.getEnumRuleAccess().getReturnsKeyword_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumRule__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumRuleAccess().getTypeAssignment_3_1()); }
	(rule__EnumRule__TypeAssignment_3_1)
	{ after(grammarAccess.getEnumRuleAccess().getTypeAssignment_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumLiterals__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiterals__Group__0__Impl
	rule__EnumLiterals__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); }
	ruleEnumLiteralDeclaration
	{ after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiterals__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); }
	(rule__EnumLiterals__Group_1__0)?
	{ after(grammarAccess.getEnumLiteralsAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumLiterals__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiterals__Group_1__0__Impl
	rule__EnumLiterals__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); }
	()
	{ after(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiterals__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); }
		(rule__EnumLiterals__Group_1_1__0)
		{ after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); }
	)
	(
		{ before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); }
		(rule__EnumLiterals__Group_1_1__0)*
		{ after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumLiterals__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiterals__Group_1_1__0__Impl
	rule__EnumLiterals__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); }
	'|'
	{ after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiterals__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); }
	(rule__EnumLiterals__ElementsAssignment_1_1_1)
	{ after(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumLiteralDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiteralDeclaration__Group__0__Impl
	rule__EnumLiteralDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); }
	(rule__EnumLiteralDeclaration__EnumLiteralAssignment_0)
	{ after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiteralDeclaration__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); }
	(rule__EnumLiteralDeclaration__Group_1__0)?
	{ after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__EnumLiteralDeclaration__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiteralDeclaration__Group_1__0__Impl
	rule__EnumLiteralDeclaration__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); }
	'='
	{ after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__EnumLiteralDeclaration__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); }
	(rule__EnumLiteralDeclaration__LiteralAssignment_1_1)
	{ after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Grammar__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); }
		ruleGrammarID
		{ after(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__UsedGrammarsAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); }
		(
			{ before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); }
			ruleGrammarID
			{ after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); }
		)
		{ after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__UsedGrammarsAssignment_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); }
		(
			{ before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); }
			ruleGrammarID
			{ after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); }
		)
		{ after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__DefinesHiddenTokensAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); }
		(
			{ before(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); }
			'hidden'
			{ after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); }
		)
		{ after(grammarAccess.getGrammarAccess().getDefinesHiddenTokensHiddenKeyword_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__HiddenTokensAssignment_3_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); }
		(
			{ before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1()); }
			ruleRuleID
			{ after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_0_0_1()); }
		)
		{ after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__HiddenTokensAssignment_3_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); }
		(
			{ before(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1()); }
			ruleRuleID
			{ after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_3_2_1_1_0_1()); }
		)
		{ after(grammarAccess.getGrammarAccess().getHiddenTokensAbstractRuleCrossReference_3_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__MetamodelDeclarationsAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); }
		ruleAbstractMetamodelDeclaration
		{ after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Grammar__RulesAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); }
		ruleAbstractRule
		{ after(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGeneratedMetamodelAccess().getNameValidIDParserRuleCall_1_0()); }
		ruleValidID
		{ after(grammarAccess.getGeneratedMetamodelAccess().getNameValidIDParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__EPackageAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); }
		(
			{ before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); }
			RULE_STRING
			{ after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__GeneratedMetamodel__AliasAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGeneratedMetamodelAccess().getAliasValidIDParserRuleCall_3_1_0()); }
		ruleValidID
		{ after(grammarAccess.getGeneratedMetamodelAccess().getAliasValidIDParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__EPackageAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); }
		(
			{ before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); }
			RULE_STRING
			{ after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ReferencedMetamodel__AliasAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReferencedMetamodelAccess().getAliasValidIDParserRuleCall_2_1_0()); }
		ruleValidID
		{ after(grammarAccess.getReferencedMetamodelAccess().getAliasValidIDParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Annotation__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getAnnotationAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getParserRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__FragmentAssignment_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); }
		(
			{ before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); }
			'fragment'
			{ after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); }
		)
		{ after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__WildcardAssignment_1_0_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); }
		(
			{ before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); }
			'*'
			{ after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); }
		)
		{ after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_1_0_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__TypeAssignment_1_0_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_0_2_1_1_0()); }
		ruleTypeRef
		{ after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_0_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__TypeAssignment_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); }
		ruleTypeRef
		{ after(grammarAccess.getParserRuleAccess().getTypeTypeRefParserRuleCall_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__DefinesHiddenTokensAssignment_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); }
		(
			{ before(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); }
			'hidden'
			{ after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); }
		)
		{ after(grammarAccess.getParserRuleAccess().getDefinesHiddenTokensHiddenKeyword_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__HiddenTokensAssignment_2_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); }
		(
			{ before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1()); }
			ruleRuleID
			{ after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_0_0_1()); }
		)
		{ after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__HiddenTokensAssignment_2_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); }
		(
			{ before(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1()); }
			ruleRuleID
			{ after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleRuleIDParserRuleCall_2_2_1_1_0_1()); }
		)
		{ after(grammarAccess.getParserRuleAccess().getHiddenTokensAbstractRuleCrossReference_2_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParserRule__AlternativesAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); }
		ruleAlternatives
		{ after(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleNameAndParamsAccess().getNameValidIDParserRuleCall_0_0()); }
		ruleValidID
		{ after(grammarAccess.getRuleNameAndParamsAccess().getNameValidIDParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__ParametersAssignment_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); }
		ruleParameter
		{ after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleNameAndParams__ParametersAssignment_1_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); }
		ruleParameter
		{ after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__NameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__MetamodelAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); }
		(
			{ before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); }
		)
		{ after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeRef__ClassifierAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); }
		(
			{ before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Alternatives__ElementsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); }
		ruleConditionalBranch
		{ after(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__GuardConditionAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalBranchAccess().getGuardConditionDisjunctionParserRuleCall_1_2_0()); }
		ruleDisjunction
		{ after(grammarAccess.getConditionalBranchAccess().getGuardConditionDisjunctionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ConditionalBranch__ElementsAssignment_1_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConditionalBranchAccess().getElementsAbstractTokenParserRuleCall_1_4_0()); }
		ruleAbstractToken
		{ after(grammarAccess.getConditionalBranchAccess().getElementsAbstractTokenParserRuleCall_1_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UnorderedGroup__ElementsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); }
		ruleGroup
		{ after(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Group__ElementsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); }
		ruleAbstractToken
		{ after(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractTokenWithCardinality__CardinalityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); }
		(rule__AbstractTokenWithCardinality__CardinalityAlternatives_1_0)
		{ after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalityAlternatives_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__TypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); }
		ruleTypeRef
		{ after(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__FeatureAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getActionAccess().getFeatureValidIDParserRuleCall_2_1_0()); }
		ruleValidID
		{ after(grammarAccess.getActionAccess().getFeatureValidIDParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__OperatorAssignment_2_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); }
		(rule__Action__OperatorAlternatives_2_2_0)
		{ after(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Keyword__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); }
		RULE_STRING
		{ after(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__RuleAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0()); }
		(
			{ before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_0_1()); }
			ruleRuleID
			{ after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__ArgumentsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_1_0()); }
		ruleNamedArgument
		{ after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__RuleCall__ArgumentsAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_2_1_0()); }
		ruleNamedArgument
		{ after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__ParameterAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0()); }
		(
			{ before(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_0_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_0_0_0_1()); }
		)
		{ after(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__CalledByNameAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); }
		(
			{ before(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); }
			'='
			{ after(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); }
		)
		{ after(grammarAccess.getNamedArgumentAccess().getCalledByNameEqualsSignKeyword_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NamedArgument__ValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNamedArgumentAccess().getValueDisjunctionParserRuleCall_1_0()); }
		ruleDisjunction
		{ after(grammarAccess.getNamedArgumentAccess().getValueDisjunctionParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__LiteralCondition__TrueAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); }
		(
			{ before(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); }
			'true'
			{ after(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); }
		)
		{ after(grammarAccess.getLiteralConditionAccess().getTrueTrueKeyword_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Disjunction__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); }
		ruleConjunction
		{ after(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Conjunction__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0()); }
		ruleNegation
		{ after(grammarAccess.getConjunctionAccess().getRightNegationParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Negation__ValueAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0()); }
		ruleNegation
		{ after(grammarAccess.getNegationAccess().getValueNegationParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ParameterReference__ParameterAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0()); }
		(
			{ before(grammarAccess.getParameterReferenceAccess().getParameterParameterIDTerminalRuleCall_0_1()); }
			RULE_ID
			{ after(grammarAccess.getParameterReferenceAccess().getParameterParameterIDTerminalRuleCall_0_1()); }
		)
		{ after(grammarAccess.getParameterReferenceAccess().getParameterParameterCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRuleCall__RuleAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); }
		(
			{ before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); }
			ruleRuleID
			{ after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); }
		)
		{ after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedKeyword__PredicatedAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		(
			{ before(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
			'=>'
			{ after(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		)
		{ after(grammarAccess.getPredicatedKeywordAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedKeyword__FirstSetPredicatedAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		(
			{ before(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
			'->'
			{ after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		)
		{ after(grammarAccess.getPredicatedKeywordAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedKeyword__ValueAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); }
		RULE_STRING
		{ after(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__PredicatedAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		(
			{ before(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
			'=>'
			{ after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		)
		{ after(grammarAccess.getPredicatedRuleCallAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__FirstSetPredicatedAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		(
			{ before(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
			'->'
			{ after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		)
		{ after(grammarAccess.getPredicatedRuleCallAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__RuleAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); }
		(
			{ before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); }
			ruleRuleID
			{ after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__ArgumentsAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); }
		ruleNamedArgument
		{ after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedRuleCall__ArgumentsAssignment_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); }
		ruleNamedArgument
		{ after(grammarAccess.getPredicatedRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__PredicatedAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		(
			{ before(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
			'=>'
			{ after(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		)
		{ after(grammarAccess.getAssignmentAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__FirstSetPredicatedAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		(
			{ before(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
			'->'
			{ after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		)
		{ after(grammarAccess.getAssignmentAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__FeatureAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentAccess().getFeatureValidIDParserRuleCall_1_0()); }
		ruleValidID
		{ after(grammarAccess.getAssignmentAccess().getFeatureValidIDParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__OperatorAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); }
		(rule__Assignment__OperatorAlternatives_2_0)
		{ after(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Assignment__TerminalAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); }
		ruleAssignableTerminal
		{ after(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AssignableAlternatives__ElementsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); }
		ruleAssignableTerminal
		{ after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__TypeAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); }
		ruleTypeRef
		{ after(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CrossReference__TerminalAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); }
		ruleCrossReferenceableTerminal
		{ after(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__PredicatedAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		(
			{ before(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
			'=>'
			{ after(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
		)
		{ after(grammarAccess.getPredicatedGroupAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__FirstSetPredicatedAssignment_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		(
			{ before(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
			'->'
			{ after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
		)
		{ after(grammarAccess.getPredicatedGroupAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PredicatedGroup__ElementsAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); }
		ruleAlternatives
		{ after(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getTerminalRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__FragmentAssignment_2_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); }
		(
			{ before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); }
			'fragment'
			{ after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); }
		)
		{ after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_2_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__NameAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_0_1_0()); }
		ruleValidID
		{ after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__NameAssignment_2_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_1_0_0()); }
		ruleValidID
		{ after(grammarAccess.getTerminalRuleAccess().getNameValidIDParserRuleCall_2_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__TypeAssignment_2_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_1_1_0()); }
		ruleTypeRef
		{ after(grammarAccess.getTerminalRuleAccess().getTypeTypeRefParserRuleCall_2_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalRule__AlternativesAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); }
		ruleTerminalAlternatives
		{ after(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalAlternatives__ElementsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); }
		ruleTerminalGroup
		{ after(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalGroup__ElementsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); }
		ruleTerminalToken
		{ after(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TerminalToken__CardinalityAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); }
		(rule__TerminalToken__CardinalityAlternatives_1_0)
		{ after(grammarAccess.getTerminalTokenAccess().getCardinalityAlternatives_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__NegatedToken__TerminalAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); }
		ruleTerminalTokenElement
		{ after(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__UntilToken__TerminalAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); }
		ruleTerminalTokenElement
		{ after(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__CharacterRange__RightAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); }
		ruleKeyword
		{ after(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__AnnotationsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
		ruleAnnotation
		{ after(grammarAccess.getEnumRuleAccess().getAnnotationsAnnotationParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_2_0()); }
		ruleValidID
		{ after(grammarAccess.getEnumRuleAccess().getNameValidIDParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__TypeAssignment_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_3_1_0()); }
		ruleTypeRef
		{ after(grammarAccess.getEnumRuleAccess().getTypeTypeRefParserRuleCall_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumRule__AlternativesAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_5_0()); }
		ruleEnumLiterals
		{ after(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiterals__ElementsAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); }
		ruleEnumLiteralDeclaration
		{ after(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); }
		(
			{ before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralValidIDParserRuleCall_0_0_1()); }
			ruleValidID
			{ after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralValidIDParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__EnumLiteralDeclaration__LiteralAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); }
		ruleKeyword
		{ after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); }
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
