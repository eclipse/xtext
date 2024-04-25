/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalDomainModelTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DomainModelTestLanguageGrammarAccess;

public class DomainModelTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(DomainModelTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, DomainModelTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
			mappings.put(grammarAccess.getPropertyAccess().getAlternatives(), "rule__Property__Alternatives");
			mappings.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			mappings.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			mappings.put(grammarAccess.getDataTypeAccess().getGroup(), "rule__DataType__Group__0");
			mappings.put(grammarAccess.getClassAccess().getGroup(), "rule__Class__Group__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_2(), "rule__Class__Group_2__0");
			mappings.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			mappings.put(grammarAccess.getReferenceAccess().getGroup(), "rule__Reference__Group__0");
			mappings.put(grammarAccess.getModelAccess().getImportsAssignment_0(), "rule__Model__ImportsAssignment_0");
			mappings.put(grammarAccess.getModelAccess().getElementsAssignment_1(), "rule__Model__ElementsAssignment_1");
			mappings.put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
			mappings.put(grammarAccess.getDataTypeAccess().getNameAssignment_1(), "rule__DataType__NameAssignment_1");
			mappings.put(grammarAccess.getClassAccess().getNameAssignment_1(), "rule__Class__NameAssignment_1");
			mappings.put(grammarAccess.getClassAccess().getSuperClassAssignment_2_1(), "rule__Class__SuperClassAssignment_2_1");
			mappings.put(grammarAccess.getClassAccess().getPropertiesAssignment_4(), "rule__Class__PropertiesAssignment_4");
			mappings.put(grammarAccess.getClassAccess().getSubClassesAssignment_5(), "rule__Class__SubClassesAssignment_5");
			mappings.put(grammarAccess.getAttributeAccess().getNameAssignment_1(), "rule__Attribute__NameAssignment_1");
			mappings.put(grammarAccess.getAttributeAccess().getTypeAssignment_3(), "rule__Attribute__TypeAssignment_3");
			mappings.put(grammarAccess.getReferenceAccess().getNameAssignment_1(), "rule__Reference__NameAssignment_1");
			mappings.put(grammarAccess.getReferenceAccess().getTypeAssignment_3(), "rule__Reference__TypeAssignment_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private DomainModelTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalDomainModelTestLanguageParser createParser() {
		InternalDomainModelTestLanguageParser result = new InternalDomainModelTestLanguageParser(null);
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

	public DomainModelTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DomainModelTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
