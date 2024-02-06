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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug304681TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug304681TestLanguageGrammarAccess;

public class Bug304681TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug304681TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug304681TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			builder.put(grammarAccess.getObjectAccess().getAlternatives_0(), "rule__Object__Alternatives_0");
			builder.put(grammarAccess.getFeatureAccess().getAlternatives(), "rule__Feature__Alternatives");
			builder.put(grammarAccess.getReferenceAccess().getAlternatives_4(), "rule__Reference__Alternatives_4");
			builder.put(grammarAccess.getObject2Access().getAlternatives_0(), "rule__Object2__Alternatives_0");
			builder.put(grammarAccess.getFeature2Access().getAlternatives(), "rule__Feature2__Alternatives");
			builder.put(grammarAccess.getAttribute2Access().getAlternatives_3(), "rule__Attribute2__Alternatives_3");
			builder.put(grammarAccess.getReference2Access().getAlternatives_4(), "rule__Reference2__Alternatives_4");
			builder.put(grammarAccess.getModelAccess().getGroup_0(), "rule__Model__Group_0__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
			builder.put(grammarAccess.getPackageDefinitionAccess().getGroup(), "rule__PackageDefinition__Group__0");
			builder.put(grammarAccess.getObjectAccess().getGroup(), "rule__Object__Group__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_3(), "rule__Object__Group_3__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_5_0(), "rule__Object__Group_5_0__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_5_1(), "rule__Object__Group_5_1__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_5_2(), "rule__Object__Group_5_2__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_5_3(), "rule__Object__Group_5_3__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_5_5(), "rule__Object__Group_5_5__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_5_6(), "rule__Object__Group_5_6__0");
			builder.put(grammarAccess.getObjectAccess().getGroup_5_7(), "rule__Object__Group_5_7__0");
			builder.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			builder.put(grammarAccess.getReferenceAccess().getGroup(), "rule__Reference__Group__0");
			builder.put(grammarAccess.getReferenceAccess().getGroup_4_0(), "rule__Reference__Group_4_0__0");
			builder.put(grammarAccess.getReferenceAccess().getGroup_4_0_1_0(), "rule__Reference__Group_4_0_1_0__0");
			builder.put(grammarAccess.getReferenceAccess().getGroup_4_0_1_1(), "rule__Reference__Group_4_0_1_1__0");
			builder.put(grammarAccess.getPackageDefinition2Access().getGroup(), "rule__PackageDefinition2__Group__0");
			builder.put(grammarAccess.getObject2Access().getGroup(), "rule__Object2__Group__0");
			builder.put(grammarAccess.getObject2Access().getGroup_3(), "rule__Object2__Group_3__0");
			builder.put(grammarAccess.getObject2Access().getGroup_5_0(), "rule__Object2__Group_5_0__0");
			builder.put(grammarAccess.getObject2Access().getGroup_5_1(), "rule__Object2__Group_5_1__0");
			builder.put(grammarAccess.getObject2Access().getGroup_5_2(), "rule__Object2__Group_5_2__0");
			builder.put(grammarAccess.getObject2Access().getGroup_5_3(), "rule__Object2__Group_5_3__0");
			builder.put(grammarAccess.getAttribute2Access().getGroup(), "rule__Attribute2__Group__0");
			builder.put(grammarAccess.getAttribute2Access().getGroup_3_0(), "rule__Attribute2__Group_3_0__0");
			builder.put(grammarAccess.getAttribute2Access().getGroup_3_0_1_0(), "rule__Attribute2__Group_3_0_1_0__0");
			builder.put(grammarAccess.getAttribute2Access().getGroup_3_0_1_1(), "rule__Attribute2__Group_3_0_1_1__0");
			builder.put(grammarAccess.getAttribute2Access().getGroup_3_0_1_3(), "rule__Attribute2__Group_3_0_1_3__0");
			builder.put(grammarAccess.getAttribute2Access().getGroup_3_0_1_4(), "rule__Attribute2__Group_3_0_1_4__0");
			builder.put(grammarAccess.getReference2Access().getGroup(), "rule__Reference2__Group__0");
			builder.put(grammarAccess.getReference2Access().getGroup_4_0(), "rule__Reference2__Group_4_0__0");
			builder.put(grammarAccess.getReference2Access().getGroup_4_0_1_0(), "rule__Reference2__Group_4_0_1_0__0");
			builder.put(grammarAccess.getReference2Access().getGroup_4_0_1_1(), "rule__Reference2__Group_4_0_1_1__0");
			builder.put(grammarAccess.getConstraintDefinitionAccess().getGroup(), "rule__ConstraintDefinition__Group__0");
			builder.put(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0(), "rule__ConstraintDefinition__Group_3_0__0");
			builder.put(grammarAccess.getConstraintDefinitionAccess().getGroup_3_1(), "rule__ConstraintDefinition__Group_3_1__0");
			builder.put(grammarAccess.getModelAccess().getDefinitionAssignment_0_1(), "rule__Model__DefinitionAssignment_0_1");
			builder.put(grammarAccess.getModelAccess().getDefinitionAssignment_1_1(), "rule__Model__DefinitionAssignment_1_1");
			builder.put(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2(), "rule__PackageDefinition__NamespaceAssignment_2");
			builder.put(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4(), "rule__PackageDefinition__ContentsAssignment_4");
			builder.put(grammarAccess.getObjectAccess().getEnabledAssignment_0_0(), "rule__Object__EnabledAssignment_0_0");
			builder.put(grammarAccess.getObjectAccess().getAbstractAssignment_0_1(), "rule__Object__AbstractAssignment_0_1");
			builder.put(grammarAccess.getObjectAccess().getNameAssignment_2(), "rule__Object__NameAssignment_2");
			builder.put(grammarAccess.getObjectAccess().getParentAssignment_3_1(), "rule__Object__ParentAssignment_3_1");
			builder.put(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1(), "rule__Object__ShortDescriptionAssignment_5_0_1");
			builder.put(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1(), "rule__Object__LongDescriptionAssignment_5_1_1");
			builder.put(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1(), "rule__Object__SerialVersionUIDAssignment_5_2_1");
			builder.put(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0(), "rule__Object__CloneableAssignment_5_3_0");
			builder.put(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4(), "rule__Object__FeaturesAssignment_5_4");
			builder.put(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1(), "rule__Object__FeaturesAssignment_5_5_1");
			builder.put(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1(), "rule__Object__FeaturesAssignment_5_6_1");
			builder.put(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1(), "rule__Object__FeaturesAssignment_5_7_1");
			builder.put(grammarAccess.getAttributeAccess().getTypeAssignment_1(), "rule__Attribute__TypeAssignment_1");
			builder.put(grammarAccess.getAttributeAccess().getNameAssignment_2(), "rule__Attribute__NameAssignment_2");
			builder.put(grammarAccess.getReferenceAccess().getTypeAssignment_1(), "rule__Reference__TypeAssignment_1");
			builder.put(grammarAccess.getReferenceAccess().getManyAssignment_2(), "rule__Reference__ManyAssignment_2");
			builder.put(grammarAccess.getReferenceAccess().getNameAssignment_3(), "rule__Reference__NameAssignment_3");
			builder.put(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1(), "rule__Reference__ShortDescriptionAssignment_4_0_1_0_1");
			builder.put(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1(), "rule__Reference__LongDescriptionAssignment_4_0_1_1_1");
			builder.put(grammarAccess.getPackageDefinition2Access().getNamespaceAssignment_2(), "rule__PackageDefinition2__NamespaceAssignment_2");
			builder.put(grammarAccess.getPackageDefinition2Access().getContentsAssignment_4(), "rule__PackageDefinition2__ContentsAssignment_4");
			builder.put(grammarAccess.getObject2Access().getEnabledAssignment_0_0(), "rule__Object2__EnabledAssignment_0_0");
			builder.put(grammarAccess.getObject2Access().getAbstractAssignment_0_1(), "rule__Object2__AbstractAssignment_0_1");
			builder.put(grammarAccess.getObject2Access().getNameAssignment_2(), "rule__Object2__NameAssignment_2");
			builder.put(grammarAccess.getObject2Access().getParentAssignment_3_1(), "rule__Object2__ParentAssignment_3_1");
			builder.put(grammarAccess.getObject2Access().getShortDescriptionAssignment_5_0_1(), "rule__Object2__ShortDescriptionAssignment_5_0_1");
			builder.put(grammarAccess.getObject2Access().getLongDescriptionAssignment_5_1_1(), "rule__Object2__LongDescriptionAssignment_5_1_1");
			builder.put(grammarAccess.getObject2Access().getSerialVersionUIDAssignment_5_2_1(), "rule__Object2__SerialVersionUIDAssignment_5_2_1");
			builder.put(grammarAccess.getObject2Access().getCloneableAssignment_5_3_0(), "rule__Object2__CloneableAssignment_5_3_0");
			builder.put(grammarAccess.getObject2Access().getFeaturesAssignment_5_4(), "rule__Object2__FeaturesAssignment_5_4");
			builder.put(grammarAccess.getAttribute2Access().getTypeAssignment_1(), "rule__Attribute2__TypeAssignment_1");
			builder.put(grammarAccess.getAttribute2Access().getNameAssignment_2(), "rule__Attribute2__NameAssignment_2");
			builder.put(grammarAccess.getAttribute2Access().getShortDescriptionAssignment_3_0_1_0_1(), "rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1");
			builder.put(grammarAccess.getAttribute2Access().getLongDescriptionAssignment_3_0_1_1_1(), "rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1");
			builder.put(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2(), "rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2");
			builder.put(grammarAccess.getAttribute2Access().getRequiredAssignment_3_0_1_3_0(), "rule__Attribute2__RequiredAssignment_3_0_1_3_0");
			builder.put(grammarAccess.getAttribute2Access().getTechnicalAssignment_3_0_1_4_0(), "rule__Attribute2__TechnicalAssignment_3_0_1_4_0");
			builder.put(grammarAccess.getReference2Access().getTypeAssignment_1(), "rule__Reference2__TypeAssignment_1");
			builder.put(grammarAccess.getReference2Access().getManyAssignment_2(), "rule__Reference2__ManyAssignment_2");
			builder.put(grammarAccess.getReference2Access().getNameAssignment_3(), "rule__Reference2__NameAssignment_3");
			builder.put(grammarAccess.getReference2Access().getShortDescriptionAssignment_4_0_1_0_1(), "rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1");
			builder.put(grammarAccess.getReference2Access().getLongDescriptionAssignment_4_0_1_1_1(), "rule__Reference2__LongDescriptionAssignment_4_0_1_1_1");
			builder.put(grammarAccess.getConstraintDefinitionAccess().getTypeAssignment_1(), "rule__ConstraintDefinition__TypeAssignment_1");
			builder.put(grammarAccess.getConstraintDefinitionAccess().getParametersAssignment_3_0_1(), "rule__ConstraintDefinition__ParametersAssignment_3_0_1");
			builder.put(grammarAccess.getConstraintDefinitionAccess().getMessageAssignment_3_1_1(), "rule__ConstraintDefinition__MessageAssignment_3_1_1");
			builder.put(grammarAccess.getObjectAccess().getUnorderedGroup_5(), "rule__Object__UnorderedGroup_5");
			builder.put(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), "rule__Reference__UnorderedGroup_4_0_1");
			builder.put(grammarAccess.getObject2Access().getUnorderedGroup_5(), "rule__Object2__UnorderedGroup_5");
			builder.put(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), "rule__Attribute2__UnorderedGroup_3_0_1");
			builder.put(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), "rule__Reference2__UnorderedGroup_4_0_1");
			builder.put(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), "rule__ConstraintDefinition__UnorderedGroup_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug304681TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug304681TestLanguageParser createParser() {
		InternalBug304681TestLanguageParser result = new InternalBug304681TestLanguageParser(null);
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

	public Bug304681TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug304681TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
