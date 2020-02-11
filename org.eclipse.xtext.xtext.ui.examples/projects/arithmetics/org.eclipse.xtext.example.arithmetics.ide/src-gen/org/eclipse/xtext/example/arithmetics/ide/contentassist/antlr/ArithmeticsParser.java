/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.example.arithmetics.ide.contentassist.antlr.internal.InternalArithmeticsParser;
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class ArithmeticsParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ArithmeticsGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ArithmeticsGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getAbstractDefinitionAccess().getAlternatives(), "rule__AbstractDefinition__Alternatives");
			builder.put(grammarAccess.getAdditionAccess().getAlternatives_1_0(), "rule__Addition__Alternatives_1_0");
			builder.put(grammarAccess.getMultiplicationAccess().getAlternatives_1_0(), "rule__Multiplication__Alternatives_1_0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
			builder.put(grammarAccess.getModuleAccess().getGroup(), "rule__Module__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getDefinitionAccess().getGroup(), "rule__Definition__Group__0");
			builder.put(grammarAccess.getDefinitionAccess().getGroup_2(), "rule__Definition__Group_2__0");
			builder.put(grammarAccess.getDefinitionAccess().getGroup_2_2(), "rule__Definition__Group_2_2__0");
			builder.put(grammarAccess.getEvaluationAccess().getGroup(), "rule__Evaluation__Group__0");
			builder.put(grammarAccess.getAdditionAccess().getGroup(), "rule__Addition__Group__0");
			builder.put(grammarAccess.getAdditionAccess().getGroup_1(), "rule__Addition__Group_1__0");
			builder.put(grammarAccess.getAdditionAccess().getGroup_1_0_0(), "rule__Addition__Group_1_0_0__0");
			builder.put(grammarAccess.getAdditionAccess().getGroup_1_0_1(), "rule__Addition__Group_1_0_1__0");
			builder.put(grammarAccess.getMultiplicationAccess().getGroup(), "rule__Multiplication__Group__0");
			builder.put(grammarAccess.getMultiplicationAccess().getGroup_1(), "rule__Multiplication__Group_1__0");
			builder.put(grammarAccess.getMultiplicationAccess().getGroup_1_0_0(), "rule__Multiplication__Group_1_0_0__0");
			builder.put(grammarAccess.getMultiplicationAccess().getGroup_1_0_1(), "rule__Multiplication__Group_1_0_1__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_0(), "rule__PrimaryExpression__Group_0__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_1(), "rule__PrimaryExpression__Group_1__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_2(), "rule__PrimaryExpression__Group_2__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2(), "rule__PrimaryExpression__Group_2_2__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2_2(), "rule__PrimaryExpression__Group_2_2_2__0");
			builder.put(grammarAccess.getModuleAccess().getNameAssignment_1(), "rule__Module__NameAssignment_1");
			builder.put(grammarAccess.getModuleAccess().getImportsAssignment_2(), "rule__Module__ImportsAssignment_2");
			builder.put(grammarAccess.getModuleAccess().getStatementsAssignment_3(), "rule__Module__StatementsAssignment_3");
			builder.put(grammarAccess.getImportAccess().getModuleAssignment_1(), "rule__Import__ModuleAssignment_1");
			builder.put(grammarAccess.getDefinitionAccess().getNameAssignment_1(), "rule__Definition__NameAssignment_1");
			builder.put(grammarAccess.getDefinitionAccess().getArgsAssignment_2_1(), "rule__Definition__ArgsAssignment_2_1");
			builder.put(grammarAccess.getDefinitionAccess().getArgsAssignment_2_2_1(), "rule__Definition__ArgsAssignment_2_2_1");
			builder.put(grammarAccess.getDefinitionAccess().getExprAssignment_4(), "rule__Definition__ExprAssignment_4");
			builder.put(grammarAccess.getDeclaredParameterAccess().getNameAssignment(), "rule__DeclaredParameter__NameAssignment");
			builder.put(grammarAccess.getEvaluationAccess().getExpressionAssignment_0(), "rule__Evaluation__ExpressionAssignment_0");
			builder.put(grammarAccess.getAdditionAccess().getRightAssignment_1_1(), "rule__Addition__RightAssignment_1_1");
			builder.put(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1(), "rule__Multiplication__RightAssignment_1_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_1_1(), "rule__PrimaryExpression__ValueAssignment_1_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getFuncAssignment_2_1(), "rule__PrimaryExpression__FuncAssignment_2_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_1(), "rule__PrimaryExpression__ArgsAssignment_2_2_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_2_1(), "rule__PrimaryExpression__ArgsAssignment_2_2_2_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ArithmeticsGrammarAccess grammarAccess;

	@Override
	protected InternalArithmeticsParser createParser() {
		InternalArithmeticsParser result = new InternalArithmeticsParser(null);
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

	public ArithmeticsGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ArithmeticsGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
