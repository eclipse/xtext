/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.example.arithmetics.ide.contentassist.antlr.internal.InternalArithmeticsParser;
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

public class ArithmeticsParser extends AbstractContentAssistParser {

	@Inject
	private ArithmeticsGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalArithmeticsParser createParser() {
		InternalArithmeticsParser result = new InternalArithmeticsParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
					put(grammarAccess.getAbstractDefinitionAccess().getAlternatives(), "rule__AbstractDefinition__Alternatives");
					put(grammarAccess.getAdditionAccess().getAlternatives_1_0(), "rule__Addition__Alternatives_1_0");
					put(grammarAccess.getMultiplicationAccess().getAlternatives_1_0(), "rule__Multiplication__Alternatives_1_0");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getModuleAccess().getGroup(), "rule__Module__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getDefinitionAccess().getGroup(), "rule__Definition__Group__0");
					put(grammarAccess.getDefinitionAccess().getGroup_2(), "rule__Definition__Group_2__0");
					put(grammarAccess.getDefinitionAccess().getGroup_2_2(), "rule__Definition__Group_2_2__0");
					put(grammarAccess.getEvaluationAccess().getGroup(), "rule__Evaluation__Group__0");
					put(grammarAccess.getAdditionAccess().getGroup(), "rule__Addition__Group__0");
					put(grammarAccess.getAdditionAccess().getGroup_1(), "rule__Addition__Group_1__0");
					put(grammarAccess.getAdditionAccess().getGroup_1_0_0(), "rule__Addition__Group_1_0_0__0");
					put(grammarAccess.getAdditionAccess().getGroup_1_0_1(), "rule__Addition__Group_1_0_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup(), "rule__Multiplication__Group__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1(), "rule__Multiplication__Group_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_0(), "rule__Multiplication__Group_1_0_0__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_1(), "rule__Multiplication__Group_1_0_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_0(), "rule__PrimaryExpression__Group_0__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_1(), "rule__PrimaryExpression__Group_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_2(), "rule__PrimaryExpression__Group_2__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2(), "rule__PrimaryExpression__Group_2_2__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_2_2_2(), "rule__PrimaryExpression__Group_2_2_2__0");
					put(grammarAccess.getModuleAccess().getNameAssignment_1(), "rule__Module__NameAssignment_1");
					put(grammarAccess.getModuleAccess().getImportsAssignment_2(), "rule__Module__ImportsAssignment_2");
					put(grammarAccess.getModuleAccess().getStatementsAssignment_3(), "rule__Module__StatementsAssignment_3");
					put(grammarAccess.getImportAccess().getModuleAssignment_1(), "rule__Import__ModuleAssignment_1");
					put(grammarAccess.getDefinitionAccess().getNameAssignment_1(), "rule__Definition__NameAssignment_1");
					put(grammarAccess.getDefinitionAccess().getArgsAssignment_2_1(), "rule__Definition__ArgsAssignment_2_1");
					put(grammarAccess.getDefinitionAccess().getArgsAssignment_2_2_1(), "rule__Definition__ArgsAssignment_2_2_1");
					put(grammarAccess.getDefinitionAccess().getExprAssignment_4(), "rule__Definition__ExprAssignment_4");
					put(grammarAccess.getDeclaredParameterAccess().getNameAssignment(), "rule__DeclaredParameter__NameAssignment");
					put(grammarAccess.getEvaluationAccess().getExpressionAssignment_0(), "rule__Evaluation__ExpressionAssignment_0");
					put(grammarAccess.getAdditionAccess().getRightAssignment_1_1(), "rule__Addition__RightAssignment_1_1");
					put(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1(), "rule__Multiplication__RightAssignment_1_1");
					put(grammarAccess.getPrimaryExpressionAccess().getValueAssignment_1_1(), "rule__PrimaryExpression__ValueAssignment_1_1");
					put(grammarAccess.getPrimaryExpressionAccess().getFuncAssignment_2_1(), "rule__PrimaryExpression__FuncAssignment_2_1");
					put(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_1(), "rule__PrimaryExpression__ArgsAssignment_2_2_1");
					put(grammarAccess.getPrimaryExpressionAccess().getArgsAssignment_2_2_2_1(), "rule__PrimaryExpression__ArgsAssignment_2_2_2_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalArithmeticsParser typedParser = (InternalArithmeticsParser) parser;
			typedParser.entryRuleModule();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
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
}
