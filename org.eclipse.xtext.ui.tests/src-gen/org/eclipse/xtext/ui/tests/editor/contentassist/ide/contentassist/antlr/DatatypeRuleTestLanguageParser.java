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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalDatatypeRuleTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;

public class DatatypeRuleTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
			mappings.put(grammarAccess.getTypesAccess().getGroup(), "rule__Types__Group__0");
			mappings.put(grammarAccess.getSimpleTypeAccess().getGroup(), "rule__SimpleType__Group__0");
			mappings.put(grammarAccess.getCompositeTypeAccess().getGroup(), "rule__CompositeType__Group__0");
			mappings.put(grammarAccess.getTypeIdAccess().getGroup(), "rule__TypeId__Group__0");
			mappings.put(grammarAccess.getTypeIdAccess().getGroup_1(), "rule__TypeId__Group_1__0");
			mappings.put(grammarAccess.getTypeIdAccess().getGroup_1_2(), "rule__TypeId__Group_1_2__0");
			mappings.put(grammarAccess.getTypesAccess().getTypesAssignment_2(), "rule__Types__TypesAssignment_2");
			mappings.put(grammarAccess.getSimpleTypeAccess().getNameAssignment_1(), "rule__SimpleType__NameAssignment_1");
			mappings.put(grammarAccess.getCompositeTypeAccess().getNameAssignment_1(), "rule__CompositeType__NameAssignment_1");
			mappings.put(grammarAccess.getCompositeTypeAccess().getBaseTypeAssignment_3(), "rule__CompositeType__BaseTypeAssignment_3");
			mappings.put(grammarAccess.getCompositeTypeEntryAccess().getDataTypeAssignment(), "rule__CompositeTypeEntry__DataTypeAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private DatatypeRuleTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalDatatypeRuleTestLanguageParser createParser() {
		InternalDatatypeRuleTestLanguageParser result = new InternalDatatypeRuleTestLanguageParser(null);
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

	public DatatypeRuleTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
