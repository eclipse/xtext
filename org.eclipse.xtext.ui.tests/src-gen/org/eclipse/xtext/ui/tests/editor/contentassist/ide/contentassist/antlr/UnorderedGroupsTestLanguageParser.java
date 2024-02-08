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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalUnorderedGroupsTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;

public class UnorderedGroupsTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			builder.put(grammarAccess.getSimpleModelAccess().getVisibilityAlternatives_0_0_0(), "rule__SimpleModel__VisibilityAlternatives_0_0_0");
			builder.put(grammarAccess.getSimpleModelAccess().getAlternatives_0_3(), "rule__SimpleModel__Alternatives_0_3");
			builder.put(grammarAccess.getMandatoryModelAccess().getVisibilityAlternatives_0_0_0(), "rule__MandatoryModel__VisibilityAlternatives_0_0_0");
			builder.put(grammarAccess.getMandatoryModelAccess().getAlternatives_0_3(), "rule__MandatoryModel__Alternatives_0_3");
			builder.put(grammarAccess.getLoopedModelAccess().getVisibilityAlternatives_0_0_0(), "rule__LoopedModel__VisibilityAlternatives_0_0_0");
			builder.put(grammarAccess.getLoopedModelAccess().getAlternatives_0_3(), "rule__LoopedModel__Alternatives_0_3");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getVisibilityAlternatives_0_0_0(), "rule__GroupLoopedModel__VisibilityAlternatives_0_0_0");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getAlternatives_0_3(), "rule__GroupLoopedModel__Alternatives_0_3");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0(), "rule__LoopedAlternativeModel__Alternatives_0");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAlternatives_0_0_0(), "rule__LoopedAlternativeModel__VisibilityAlternatives_0_0_0");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getAlternatives_0_3(), "rule__LoopedAlternativeModel__Alternatives_0_3");
			builder.put(grammarAccess.getBug304681FeatureAccess().getAlternatives(), "rule__Bug304681Feature__Alternatives");
			builder.put(grammarAccess.getModelAccess().getGroup_0(), "rule__Model__Group_0__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
			builder.put(grammarAccess.getModelAccess().getGroup_2(), "rule__Model__Group_2__0");
			builder.put(grammarAccess.getModelAccess().getGroup_3(), "rule__Model__Group_3__0");
			builder.put(grammarAccess.getModelAccess().getGroup_4(), "rule__Model__Group_4__0");
			builder.put(grammarAccess.getModelAccess().getGroup_5(), "rule__Model__Group_5__0");
			builder.put(grammarAccess.getSimpleModelAccess().getGroup(), "rule__SimpleModel__Group__0");
			builder.put(grammarAccess.getMandatoryModelAccess().getGroup(), "rule__MandatoryModel__Group__0");
			builder.put(grammarAccess.getLoopedModelAccess().getGroup(), "rule__LoopedModel__Group__0");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getGroup(), "rule__GroupLoopedModel__Group__0");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getGroup(), "rule__LoopedAlternativeModel__Group__0");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getGroup_0_4(), "rule__LoopedAlternativeModel__Group_0_4__0");
			builder.put(grammarAccess.getBug304681ModelAccess().getGroup(), "rule__Bug304681Model__Group__0");
			builder.put(grammarAccess.getBug304681ModelAccess().getGroup_2_0(), "rule__Bug304681Model__Group_2_0__0");
			builder.put(grammarAccess.getBug304681ModelAccess().getGroup_2_1(), "rule__Bug304681Model__Group_2_1__0");
			builder.put(grammarAccess.getBug304681ModelAccess().getGroup_2_2(), "rule__Bug304681Model__Group_2_2__0");
			builder.put(grammarAccess.getBug304681ModelAccess().getGroup_2_3(), "rule__Bug304681Model__Group_2_3__0");
			builder.put(grammarAccess.getBug304681AttributeAccess().getGroup(), "rule__Bug304681Attribute__Group__0");
			builder.put(grammarAccess.getBug304681ReferenceAccess().getGroup(), "rule__Bug304681Reference__Group__0");
			builder.put(grammarAccess.getModelAccess().getFirstAssignment_0_1(), "rule__Model__FirstAssignment_0_1");
			builder.put(grammarAccess.getModelAccess().getSecondAssignment_1_1(), "rule__Model__SecondAssignment_1_1");
			builder.put(grammarAccess.getModelAccess().getThrirdAssignment_2_1(), "rule__Model__ThrirdAssignment_2_1");
			builder.put(grammarAccess.getModelAccess().getForthAssignment_3_1(), "rule__Model__ForthAssignment_3_1");
			builder.put(grammarAccess.getModelAccess().getFifthAssignment_4_1(), "rule__Model__FifthAssignment_4_1");
			builder.put(grammarAccess.getModelAccess().getModelAssignment_5_1(), "rule__Model__ModelAssignment_5_1");
			builder.put(grammarAccess.getSimpleModelAccess().getVisibilityAssignment_0_0(), "rule__SimpleModel__VisibilityAssignment_0_0");
			builder.put(grammarAccess.getSimpleModelAccess().getStaticAssignment_0_1(), "rule__SimpleModel__StaticAssignment_0_1");
			builder.put(grammarAccess.getSimpleModelAccess().getSynchronizedAssignment_0_2(), "rule__SimpleModel__SynchronizedAssignment_0_2");
			builder.put(grammarAccess.getSimpleModelAccess().getAbstractAssignment_0_3_0(), "rule__SimpleModel__AbstractAssignment_0_3_0");
			builder.put(grammarAccess.getSimpleModelAccess().getFinalAssignment_0_3_1(), "rule__SimpleModel__FinalAssignment_0_3_1");
			builder.put(grammarAccess.getSimpleModelAccess().getNameAssignment_2(), "rule__SimpleModel__NameAssignment_2");
			builder.put(grammarAccess.getMandatoryModelAccess().getVisibilityAssignment_0_0(), "rule__MandatoryModel__VisibilityAssignment_0_0");
			builder.put(grammarAccess.getMandatoryModelAccess().getStaticAssignment_0_1(), "rule__MandatoryModel__StaticAssignment_0_1");
			builder.put(grammarAccess.getMandatoryModelAccess().getSynchronizedAssignment_0_2(), "rule__MandatoryModel__SynchronizedAssignment_0_2");
			builder.put(grammarAccess.getMandatoryModelAccess().getAbstractAssignment_0_3_0(), "rule__MandatoryModel__AbstractAssignment_0_3_0");
			builder.put(grammarAccess.getMandatoryModelAccess().getFinalAssignment_0_3_1(), "rule__MandatoryModel__FinalAssignment_0_3_1");
			builder.put(grammarAccess.getMandatoryModelAccess().getNameAssignment_2(), "rule__MandatoryModel__NameAssignment_2");
			builder.put(grammarAccess.getLoopedModelAccess().getVisibilityAssignment_0_0(), "rule__LoopedModel__VisibilityAssignment_0_0");
			builder.put(grammarAccess.getLoopedModelAccess().getStaticAssignment_0_1(), "rule__LoopedModel__StaticAssignment_0_1");
			builder.put(grammarAccess.getLoopedModelAccess().getSynchronizedAssignment_0_2(), "rule__LoopedModel__SynchronizedAssignment_0_2");
			builder.put(grammarAccess.getLoopedModelAccess().getAbstractAssignment_0_3_0(), "rule__LoopedModel__AbstractAssignment_0_3_0");
			builder.put(grammarAccess.getLoopedModelAccess().getFinalAssignment_0_3_1(), "rule__LoopedModel__FinalAssignment_0_3_1");
			builder.put(grammarAccess.getLoopedModelAccess().getNameAssignment_2(), "rule__LoopedModel__NameAssignment_2");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getVisibilityAssignment_0_0(), "rule__GroupLoopedModel__VisibilityAssignment_0_0");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getStaticAssignment_0_1(), "rule__GroupLoopedModel__StaticAssignment_0_1");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getSynchronizedAssignment_0_2(), "rule__GroupLoopedModel__SynchronizedAssignment_0_2");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getAbstractAssignment_0_3_0(), "rule__GroupLoopedModel__AbstractAssignment_0_3_0");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getFinalAssignment_0_3_1(), "rule__GroupLoopedModel__FinalAssignment_0_3_1");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getNameAssignment_2(), "rule__GroupLoopedModel__NameAssignment_2");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getVisibilityAssignment_0_0(), "rule__LoopedAlternativeModel__VisibilityAssignment_0_0");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getStaticAssignment_0_1(), "rule__LoopedAlternativeModel__StaticAssignment_0_1");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedAssignment_0_2(), "rule__LoopedAlternativeModel__SynchronizedAssignment_0_2");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getAbstractAssignment_0_3_0(), "rule__LoopedAlternativeModel__AbstractAssignment_0_3_0");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getFinalAssignment_0_3_1(), "rule__LoopedAlternativeModel__FinalAssignment_0_3_1");
			builder.put(grammarAccess.getLoopedAlternativeModelAccess().getNameAssignment_2(), "rule__LoopedAlternativeModel__NameAssignment_2");
			builder.put(grammarAccess.getBug304681ModelAccess().getShortDescriptionAssignment_2_0_1(), "rule__Bug304681Model__ShortDescriptionAssignment_2_0_1");
			builder.put(grammarAccess.getBug304681ModelAccess().getLongDescriptionAssignment_2_1_1(), "rule__Bug304681Model__LongDescriptionAssignment_2_1_1");
			builder.put(grammarAccess.getBug304681ModelAccess().getUidAssignment_2_2_1(), "rule__Bug304681Model__UidAssignment_2_2_1");
			builder.put(grammarAccess.getBug304681ModelAccess().getFlagAssignment_2_3_0(), "rule__Bug304681Model__FlagAssignment_2_3_0");
			builder.put(grammarAccess.getBug304681ModelAccess().getFeaturesAssignment_2_4(), "rule__Bug304681Model__FeaturesAssignment_2_4");
			builder.put(grammarAccess.getBug304681AttributeAccess().getNameAssignment_1(), "rule__Bug304681Attribute__NameAssignment_1");
			builder.put(grammarAccess.getBug304681ReferenceAccess().getNameAssignment_1(), "rule__Bug304681Reference__NameAssignment_1");
			builder.put(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), "rule__SimpleModel__UnorderedGroup_0");
			builder.put(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), "rule__MandatoryModel__UnorderedGroup_0");
			builder.put(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), "rule__LoopedModel__UnorderedGroup_0");
			builder.put(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), "rule__GroupLoopedModel__UnorderedGroup_0");
			builder.put(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), "rule__Bug304681Model__UnorderedGroup_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalUnorderedGroupsTestLanguageParser createParser() {
		InternalUnorderedGroupsTestLanguageParser result = new InternalUnorderedGroupsTestLanguageParser(null);
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

	public UnorderedGroupsTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
