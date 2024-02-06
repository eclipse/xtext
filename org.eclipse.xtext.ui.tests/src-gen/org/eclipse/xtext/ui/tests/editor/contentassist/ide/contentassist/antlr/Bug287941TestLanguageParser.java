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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug287941TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug287941TestLanguageGrammarAccess;

public class Bug287941TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug287941TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug287941TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getScopeAccess().getAlternatives(), "rule__Scope__Alternatives");
			builder.put(grammarAccess.getConcreteWhereEntryAccess().getAlternatives(), "rule__ConcreteWhereEntry__Alternatives");
			builder.put(grammarAccess.getAttributeWhereEntryAccess().getAlternatives(), "rule__AttributeWhereEntry__Alternatives");
			builder.put(grammarAccess.getNumericAttributeWhereEntryAccess().getAlternatives(), "rule__NumericAttributeWhereEntry__Alternatives");
			builder.put(grammarAccess.getBooleanAttributeWhereEntryAccess().getAlternatives_4(), "rule__BooleanAttributeWhereEntry__Alternatives_4");
			builder.put(grammarAccess.getNumericOperatorAccess().getAlternatives(), "rule__NumericOperator__Alternatives");
			builder.put(grammarAccess.getStringOperatorAccess().getAlternatives(), "rule__StringOperator__Alternatives");
			builder.put(grammarAccess.getBooleanOperatorAccess().getAlternatives(), "rule__BooleanOperator__Alternatives");
			builder.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getMQLqueryAccess().getGroup(), "rule__MQLquery__Group__0");
			builder.put(grammarAccess.getMQLqueryAccess().getGroup_2(), "rule__MQLquery__Group_2__0");
			builder.put(grammarAccess.getMQLqueryAccess().getGroup_5(), "rule__MQLquery__Group_5__0");
			builder.put(grammarAccess.getMQLqueryAccess().getGroup_6(), "rule__MQLquery__Group_6__0");
			builder.put(grammarAccess.getSelectEntryAccess().getGroup(), "rule__SelectEntry__Group__0");
			builder.put(grammarAccess.getSelectEntryAccess().getGroup_1(), "rule__SelectEntry__Group_1__0");
			builder.put(grammarAccess.getFromEntryAccess().getGroup(), "rule__FromEntry__Group__0");
			builder.put(grammarAccess.getScopeClauseAccess().getGroup(), "rule__ScopeClause__Group__0");
			builder.put(grammarAccess.getResourceScopeAccess().getGroup(), "rule__ResourceScope__Group__0");
			builder.put(grammarAccess.getResourceScopeAccess().getGroup_3(), "rule__ResourceScope__Group_3__0");
			builder.put(grammarAccess.getElementScopeAccess().getGroup(), "rule__ElementScope__Group__0");
			builder.put(grammarAccess.getElementScopeAccess().getGroup_3(), "rule__ElementScope__Group_3__0");
			builder.put(grammarAccess.getWhereEntryAccess().getGroup(), "rule__WhereEntry__Group__0");
			builder.put(grammarAccess.getWhereEntryAccess().getGroup_1(), "rule__WhereEntry__Group_1__0");
			builder.put(grammarAccess.getWhereEntryAccess().getGroup_1_1(), "rule__WhereEntry__Group_1_1__0");
			builder.put(grammarAccess.getAndWhereEntryAccess().getGroup(), "rule__AndWhereEntry__Group__0");
			builder.put(grammarAccess.getAndWhereEntryAccess().getGroup_1(), "rule__AndWhereEntry__Group_1__0");
			builder.put(grammarAccess.getAndWhereEntryAccess().getGroup_1_1(), "rule__AndWhereEntry__Group_1_1__0");
			builder.put(grammarAccess.getParWhereEntryAccess().getGroup(), "rule__ParWhereEntry__Group__0");
			builder.put(grammarAccess.getDoubleWhereEntryAccess().getGroup(), "rule__DoubleWhereEntry__Group__0");
			builder.put(grammarAccess.getLongWhereEntryAccess().getGroup(), "rule__LongWhereEntry__Group__0");
			builder.put(grammarAccess.getVariableWhereEntryAccess().getGroup(), "rule__VariableWhereEntry__Group__0");
			builder.put(grammarAccess.getStringAttributeWhereEntryAccess().getGroup(), "rule__StringAttributeWhereEntry__Group__0");
			builder.put(grammarAccess.getBooleanAttributeWhereEntryAccess().getGroup(), "rule__BooleanAttributeWhereEntry__Group__0");
			builder.put(grammarAccess.getNullWhereEntryAccess().getGroup(), "rule__NullWhereEntry__Group__0");
			builder.put(grammarAccess.getReferenceAliasWhereEntryAccess().getGroup(), "rule__ReferenceAliasWhereEntry__Group__0");
			builder.put(grammarAccess.getSubselectWhereEntryAccess().getGroup(), "rule__SubselectWhereEntry__Group__0");
			builder.put(grammarAccess.getAliasWhereEntryAccess().getGroup(), "rule__AliasWhereEntry__Group__0");
			builder.put(grammarAccess.getModelAccess().getImportsAssignment_0(), "rule__Model__ImportsAssignment_0");
			builder.put(grammarAccess.getModelAccess().getQueryAssignment_1(), "rule__Model__QueryAssignment_1");
			builder.put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
			builder.put(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1(), "rule__MQLquery__SelectEntriesAssignment_1");
			builder.put(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_2_1(), "rule__MQLquery__SelectEntriesAssignment_2_1");
			builder.put(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4(), "rule__MQLquery__FromEntriesAssignment_4");
			builder.put(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_5_1(), "rule__MQLquery__FromEntriesAssignment_5_1");
			builder.put(grammarAccess.getMQLqueryAccess().getWhereEntriesAssignment_6_1(), "rule__MQLquery__WhereEntriesAssignment_6_1");
			builder.put(grammarAccess.getSelectEntryAccess().getSelectAssignment_0(), "rule__SelectEntry__SelectAssignment_0");
			builder.put(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1(), "rule__SelectEntry__AttributeAssignment_1_1");
			builder.put(grammarAccess.getFromEntryAccess().getTypeAssignment_0(), "rule__FromEntry__TypeAssignment_0");
			builder.put(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1(), "rule__FromEntry__WithoutsubtypesAssignment_1");
			builder.put(grammarAccess.getFromEntryAccess().getAliasAssignment_3(), "rule__FromEntry__AliasAssignment_3");
			builder.put(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4(), "rule__FromEntry__ScopeClauseAssignment_4");
			builder.put(grammarAccess.getScopeClauseAccess().getNotInAssignment_0(), "rule__ScopeClause__NotInAssignment_0");
			builder.put(grammarAccess.getScopeClauseAccess().getScopeAssignment_2(), "rule__ScopeClause__ScopeAssignment_2");
			builder.put(grammarAccess.getResourceScopeAccess().getUrisAssignment_2(), "rule__ResourceScope__UrisAssignment_2");
			builder.put(grammarAccess.getResourceScopeAccess().getUrisAssignment_3_1(), "rule__ResourceScope__UrisAssignment_3_1");
			builder.put(grammarAccess.getElementScopeAccess().getUrisAssignment_2(), "rule__ElementScope__UrisAssignment_2");
			builder.put(grammarAccess.getElementScopeAccess().getUrisAssignment_3_1(), "rule__ElementScope__UrisAssignment_3_1");
			builder.put(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1(), "rule__WhereEntry__EntriesAssignment_1_1_1");
			builder.put(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1(), "rule__AndWhereEntry__EntriesAssignment_1_1_1");
			builder.put(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0(), "rule__DoubleWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2(), "rule__DoubleWhereEntry__AttributeAssignment_2");
			builder.put(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3(), "rule__DoubleWhereEntry__OperatorAssignment_3");
			builder.put(grammarAccess.getDoubleWhereEntryAccess().getValueAssignment_4(), "rule__DoubleWhereEntry__ValueAssignment_4");
			builder.put(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0(), "rule__LongWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2(), "rule__LongWhereEntry__AttributeAssignment_2");
			builder.put(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3(), "rule__LongWhereEntry__OperatorAssignment_3");
			builder.put(grammarAccess.getLongWhereEntryAccess().getValueAssignment_4(), "rule__LongWhereEntry__ValueAssignment_4");
			builder.put(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0(), "rule__VariableWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2(), "rule__VariableWhereEntry__AttributeAssignment_2");
			builder.put(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3(), "rule__VariableWhereEntry__OperatorAssignment_3");
			builder.put(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4(), "rule__VariableWhereEntry__RightAliasAssignment_4");
			builder.put(grammarAccess.getVariableWhereEntryAccess().getRightAttributeAssignment_6(), "rule__VariableWhereEntry__RightAttributeAssignment_6");
			builder.put(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0(), "rule__StringAttributeWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2(), "rule__StringAttributeWhereEntry__AttributeAssignment_2");
			builder.put(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3(), "rule__StringAttributeWhereEntry__OperatorAssignment_3");
			builder.put(grammarAccess.getStringAttributeWhereEntryAccess().getPatternAssignment_4(), "rule__StringAttributeWhereEntry__PatternAssignment_4");
			builder.put(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0(), "rule__BooleanAttributeWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2(), "rule__BooleanAttributeWhereEntry__AttributeAssignment_2");
			builder.put(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3(), "rule__BooleanAttributeWhereEntry__OperatorAssignment_3");
			builder.put(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0(), "rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0");
			builder.put(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0(), "rule__NullWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2(), "rule__NullWhereEntry__FeatureAssignment_2");
			builder.put(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3(), "rule__NullWhereEntry__OperatorAssignment_3");
			builder.put(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0(), "rule__ReferenceAliasWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2(), "rule__ReferenceAliasWhereEntry__ReferenceAssignment_2");
			builder.put(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasAssignment_4(), "rule__ReferenceAliasWhereEntry__RightAliasAssignment_4");
			builder.put(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0(), "rule__SubselectWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2(), "rule__SubselectWhereEntry__ReferenceAssignment_2");
			builder.put(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3(), "rule__SubselectWhereEntry__NotInAssignment_3");
			builder.put(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6(), "rule__SubselectWhereEntry__SubQueryAssignment_6");
			builder.put(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0(), "rule__AliasWhereEntry__AliasAssignment_0");
			builder.put(grammarAccess.getAliasWhereEntryAccess().getRightAliasAssignment_2(), "rule__AliasWhereEntry__RightAliasAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug287941TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug287941TestLanguageParser createParser() {
		InternalBug287941TestLanguageParser result = new InternalBug287941TestLanguageParser(null);
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

	public Bug287941TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug287941TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
