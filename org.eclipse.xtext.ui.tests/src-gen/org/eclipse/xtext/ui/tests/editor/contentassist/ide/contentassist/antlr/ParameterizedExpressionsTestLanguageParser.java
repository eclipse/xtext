/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalParameterizedExpressionsTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParameterizedExpressionsTestLanguageGrammarAccess;

public class ParameterizedExpressionsTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getRootStatementAccess().getAlternatives(), "rule__RootStatement__Alternatives");
			builder.put(grammarAccess.getFunctionImplAccess().getAlternatives_1(), "rule__FunctionImpl__Alternatives_1");
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getMemberExpressionAccess().getAlternatives_1(), "rule__MemberExpression__Alternatives_1");
			builder.put(grammarAccess.getShiftExpressionAccess().getOpAlternatives_1_0_1_0(), "rule__ShiftExpression__OpAlternatives_1_0_1_0");
			builder.put(grammarAccess.getRelationalOperatorAccess().getAlternatives(), "rule__RelationalOperator__Alternatives");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getAlternatives(), "rule__AssignmentExpression__Alternatives");
			builder.put(grammarAccess.getIdentifierAccess().getAlternatives(), "rule__Identifier__Alternatives");
			builder.put(grammarAccess.getFunctionDeclarationAccess().getGroup(), "rule__FunctionDeclaration__Group__0");
			builder.put(grammarAccess.getFunctionDeclarationAccess().getGroup_0(), "rule__FunctionDeclaration__Group_0__0");
			builder.put(grammarAccess.getFunctionDeclarationAccess().getGroup_0_0(), "rule__FunctionDeclaration__Group_0_0__0");
			builder.put(grammarAccess.getFunctionImplAccess().getGroup(), "rule__FunctionImpl__Group__0");
			builder.put(grammarAccess.getFunctionImplAccess().getGroup_1_0(), "rule__FunctionImpl__Group_1_0__0");
			builder.put(grammarAccess.getFunctionImplAccess().getGroup_1_1(), "rule__FunctionImpl__Group_1_1__0");
			builder.put(grammarAccess.getFunctionHeaderAccess().getGroup(), "rule__FunctionHeader__Group__0");
			builder.put(grammarAccess.getBlockAccess().getGroup(), "rule__Block__Group__0");
			builder.put(grammarAccess.getBlockAccess().getGroup_0(), "rule__Block__Group_0__0");
			builder.put(grammarAccess.getBlockAccess().getGroup_0_0(), "rule__Block__Group_0_0__0");
			builder.put(grammarAccess.getExpressionStatementAccess().getGroup(), "rule__ExpressionStatement__Group__0");
			builder.put(grammarAccess.getLabelledStatementAccess().getGroup(), "rule__LabelledStatement__Group__0");
			builder.put(grammarAccess.getLabelledStatementAccess().getGroup_0(), "rule__LabelledStatement__Group_0__0");
			builder.put(grammarAccess.getLabelledStatementAccess().getGroup_0_0(), "rule__LabelledStatement__Group_0_0__0");
			builder.put(grammarAccess.getMemberExpressionAccess().getGroup(), "rule__MemberExpression__Group__0");
			builder.put(grammarAccess.getMemberExpressionAccess().getGroup_1_0(), "rule__MemberExpression__Group_1_0__0");
			builder.put(grammarAccess.getMemberExpressionAccess().getGroup_1_1(), "rule__MemberExpression__Group_1_1__0");
			builder.put(grammarAccess.getIndexedAccessExpressionTailAccess().getGroup(), "rule__IndexedAccessExpressionTail__Group__0");
			builder.put(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getGroup(), "rule__ParameterizedPropertyAccessExpressionTail__Group__0");
			builder.put(grammarAccess.getShiftExpressionAccess().getGroup(), "rule__ShiftExpression__Group__0");
			builder.put(grammarAccess.getShiftExpressionAccess().getGroup_1(), "rule__ShiftExpression__Group_1__0");
			builder.put(grammarAccess.getShiftExpressionAccess().getGroup_1_0(), "rule__ShiftExpression__Group_1_0__0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getGroup_1_0(), "rule__RelationalExpression__Group_1_0__0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup_1(), "rule__AssignmentExpression__Group_1__0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1(), "rule__AssignmentExpression__Group_1_1__0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0(), "rule__AssignmentExpression__Group_1_1_0__0");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getGroup_1_1_0_0(), "rule__AssignmentExpression__Group_1_1_0_0__0");
			builder.put(grammarAccess.getYieldExpressionAccess().getGroup(), "rule__YieldExpression__Group__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1(), "rule__Expression__Group_1__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_3(), "rule__Expression__Group_1_3__0");
			builder.put(grammarAccess.getFunctionImplAccess().getGeneratorAssignment_1_0_0(), "rule__FunctionImpl__GeneratorAssignment_1_0_0");
			builder.put(grammarAccess.getFunctionHeaderAccess().getNameAssignment_0(), "rule__FunctionHeader__NameAssignment_0");
			builder.put(grammarAccess.getFunctionBodyAccess().getBodyAssignment_1_0(), "rule__FunctionBody__BodyAssignment_1_0");
			builder.put(grammarAccess.getFunctionBodyAccess().getBodyAssignment_0_0(), "rule__FunctionBody__BodyAssignment_0_0");
			builder.put(grammarAccess.getBlockAccess().getStatementsAssignment_1(), "rule__Block__StatementsAssignment_1");
			builder.put(grammarAccess.getExpressionStatementAccess().getExpressionAssignment_0(), "rule__ExpressionStatement__ExpressionAssignment_0");
			builder.put(grammarAccess.getLabelledStatementAccess().getNameAssignment_0_0_0(), "rule__LabelledStatement__NameAssignment_0_0_0");
			builder.put(grammarAccess.getLabelledStatementAccess().getStatementAssignment_1(), "rule__LabelledStatement__StatementAssignment_1");
			builder.put(grammarAccess.getIdentifierRefAccess().getIdAssignment(), "rule__IdentifierRef__IdAssignment");
			builder.put(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexAssignment_1(), "rule__IndexedAccessExpressionTail__IndexAssignment_1");
			builder.put(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyAssignment_1(), "rule__ParameterizedPropertyAccessExpressionTail__PropertyAssignment_1");
			builder.put(grammarAccess.getShiftExpressionAccess().getOpAssignment_1_0_1(), "rule__ShiftExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getShiftExpressionAccess().getRhsAssignment_1_0_2(), "rule__ShiftExpression__RhsAssignment_1_0_2");
			builder.put(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0_1(), "rule__RelationalExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getRelationalExpressionAccess().getRhsAssignment_1_0_2(), "rule__RelationalExpression__RhsAssignment_1_0_2");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getOpAssignment_1_1_0_0_1(), "rule__AssignmentExpression__OpAssignment_1_1_0_0_1");
			builder.put(grammarAccess.getAssignmentExpressionAccess().getRhsAssignment_1_1_1(), "rule__AssignmentExpression__RhsAssignment_1_1_1");
			builder.put(grammarAccess.getYieldExpressionAccess().getManyAssignment_2(), "rule__YieldExpression__ManyAssignment_2");
			builder.put(grammarAccess.getYieldExpressionAccess().getExpressionAssignment_3(), "rule__YieldExpression__ExpressionAssignment_3");
			builder.put(grammarAccess.getExpressionAccess().getExprsAssignment_1_2(), "rule__Expression__ExprsAssignment_1_2");
			builder.put(grammarAccess.getExpressionAccess().getExprsAssignment_1_3_1(), "rule__Expression__ExprsAssignment_1_3_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalParameterizedExpressionsTestLanguageParser createParser() {
		InternalParameterizedExpressionsTestLanguageParser result = new InternalParameterizedExpressionsTestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public ParameterizedExpressionsTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
