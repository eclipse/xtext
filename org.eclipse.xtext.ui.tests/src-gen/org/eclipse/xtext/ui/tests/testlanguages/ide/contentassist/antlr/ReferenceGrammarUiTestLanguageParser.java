/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.testlanguages.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.testlanguages.ide.contentassist.antlr.internal.InternalReferenceGrammarUiTestLanguageParser;
import org.eclipse.xtext.ui.tests.testlanguages.services.ReferenceGrammarUiTestLanguageGrammarAccess;

public class ReferenceGrammarUiTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getSpielplatzAccess().getAlternatives_4(), "rule__Spielplatz__Alternatives_4");
			mappings.put(grammarAccess.getPersonAccess().getAlternatives(), "rule__Person__Alternatives");
			mappings.put(grammarAccess.getFarbeAccess().getWertAlternatives_0(), "rule__Farbe__WertAlternatives_0");
			mappings.put(grammarAccess.getFamilieAccess().getNameAlternatives_2_0(), "rule__Familie__NameAlternatives_2_0");
			mappings.put(grammarAccess.getSpielplatzAccess().getGroup(), "rule__Spielplatz__Group__0");
			mappings.put(grammarAccess.getKindAccess().getGroup(), "rule__Kind__Group__0");
			mappings.put(grammarAccess.getErwachsenerAccess().getGroup(), "rule__Erwachsener__Group__0");
			mappings.put(grammarAccess.getSpielzeugAccess().getGroup(), "rule__Spielzeug__Group__0");
			mappings.put(grammarAccess.getFamilieAccess().getGroup(), "rule__Familie__Group__0");
			mappings.put(grammarAccess.getFamilieAccess().getGroup_6(), "rule__Familie__Group_6__0");
			mappings.put(grammarAccess.getSpielplatzAccess().getGroesseAssignment_1(), "rule__Spielplatz__GroesseAssignment_1");
			mappings.put(grammarAccess.getSpielplatzAccess().getBeschreibungAssignment_2(), "rule__Spielplatz__BeschreibungAssignment_2");
			mappings.put(grammarAccess.getSpielplatzAccess().getKinderAssignment_4_0(), "rule__Spielplatz__KinderAssignment_4_0");
			mappings.put(grammarAccess.getSpielplatzAccess().getErzieherAssignment_4_1(), "rule__Spielplatz__ErzieherAssignment_4_1");
			mappings.put(grammarAccess.getSpielplatzAccess().getSpielzeugeAssignment_4_2(), "rule__Spielplatz__SpielzeugeAssignment_4_2");
			mappings.put(grammarAccess.getSpielplatzAccess().getFamilieAssignment_4_3(), "rule__Spielplatz__FamilieAssignment_4_3");
			mappings.put(grammarAccess.getKindAccess().getNameAssignment_2(), "rule__Kind__NameAssignment_2");
			mappings.put(grammarAccess.getKindAccess().getAgeAssignment_3(), "rule__Kind__AgeAssignment_3");
			mappings.put(grammarAccess.getErwachsenerAccess().getNameAssignment_2(), "rule__Erwachsener__NameAssignment_2");
			mappings.put(grammarAccess.getErwachsenerAccess().getAgeAssignment_3(), "rule__Erwachsener__AgeAssignment_3");
			mappings.put(grammarAccess.getSpielzeugAccess().getNameAssignment_2(), "rule__Spielzeug__NameAssignment_2");
			mappings.put(grammarAccess.getSpielzeugAccess().getFarbeAssignment_3(), "rule__Spielzeug__FarbeAssignment_3");
			mappings.put(grammarAccess.getFarbeAccess().getWertAssignment(), "rule__Farbe__WertAssignment");
			mappings.put(grammarAccess.getFamilieAccess().getNameAssignment_2(), "rule__Familie__NameAssignment_2");
			mappings.put(grammarAccess.getFamilieAccess().getMutterAssignment_3(), "rule__Familie__MutterAssignment_3");
			mappings.put(grammarAccess.getFamilieAccess().getVaterAssignment_4(), "rule__Familie__VaterAssignment_4");
			mappings.put(grammarAccess.getFamilieAccess().getKinderAssignment_5(), "rule__Familie__KinderAssignment_5");
			mappings.put(grammarAccess.getFamilieAccess().getKinderAssignment_6_1(), "rule__Familie__KinderAssignment_6_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalReferenceGrammarUiTestLanguageParser createParser() {
		InternalReferenceGrammarUiTestLanguageParser result = new InternalReferenceGrammarUiTestLanguageParser(null);
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

	public ReferenceGrammarUiTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ReferenceGrammarUiTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
