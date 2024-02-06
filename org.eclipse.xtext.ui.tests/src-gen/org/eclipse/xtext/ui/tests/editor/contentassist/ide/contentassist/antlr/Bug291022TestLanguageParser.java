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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug291022TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug291022TestLanguageGrammarAccess;

public class Bug291022TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug291022TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug291022TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelElementAccess().getAlternatives_3(), "rule__ModelElement__Alternatives_3");
			builder.put(grammarAccess.getModelAttributeAccess().getAlternatives(), "rule__ModelAttribute__Alternatives");
			builder.put(grammarAccess.getRootModelAccess().getGroup(), "rule__RootModel__Group__0");
			builder.put(grammarAccess.getRootModelAccess().getGroup_3(), "rule__RootModel__Group_3__0");
			builder.put(grammarAccess.getModelElementAccess().getGroup(), "rule__ModelElement__Group__0");
			builder.put(grammarAccess.getModelElementAccess().getGroup_1(), "rule__ModelElement__Group_1__0");
			builder.put(grammarAccess.getModelElementAccess().getGroup_3_1(), "rule__ModelElement__Group_3_1__0");
			builder.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			builder.put(grammarAccess.getRootModelAccess().getNameAssignment_1(), "rule__RootModel__NameAssignment_1");
			builder.put(grammarAccess.getRootModelAccess().getTypeAssignment_2(), "rule__RootModel__TypeAssignment_2");
			builder.put(grammarAccess.getRootModelAccess().getElementsAssignment_3_1(), "rule__RootModel__ElementsAssignment_3_1");
			builder.put(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0(), "rule__ModelElement__FirstReferenceAssignment_0");
			builder.put(grammarAccess.getModelElementAccess().getNameAssignment_1_1(), "rule__ModelElement__NameAssignment_1_1");
			builder.put(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2(), "rule__ModelElement__SecondReferenceAssignment_2");
			builder.put(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1(), "rule__ModelElement__ElementsAssignment_3_1_1");
			builder.put(grammarAccess.getAttributeAccess().getFeatureAssignment_0(), "rule__Attribute__FeatureAssignment_0");
			builder.put(grammarAccess.getAttributeAccess().getValueAssignment_2(), "rule__Attribute__ValueAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug291022TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug291022TestLanguageParser createParser() {
		InternalBug291022TestLanguageParser result = new InternalBug291022TestLanguageParser(null);
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

	public Bug291022TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug291022TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
