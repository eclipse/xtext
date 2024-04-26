/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.ecore2xtext.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.xtext.ui.ecore2xtext.ide.contentassist.antlr.internal.InternalEcore2XtextTestParser;
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;

public class Ecore2XtextTestParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Ecore2XtextTestGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, Ecore2XtextTestGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getAbstractAccess().getAlternatives(), "rule__Abstract__Alternatives");
			mappings.put(grammarAccess.getConcrete0Access().getAlternatives(), "rule__Concrete0__Alternatives");
			mappings.put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
			mappings.put(grammarAccess.getRootAccess().getGroup(), "rule__Root__Group__0");
			mappings.put(grammarAccess.getRootAccess().getGroup_4(), "rule__Root__Group_4__0");
			mappings.put(grammarAccess.getRootAccess().getGroup_4_3(), "rule__Root__Group_4_3__0");
			mappings.put(grammarAccess.getRootAccess().getGroup_5(), "rule__Root__Group_5__0");
			mappings.put(grammarAccess.getConcrete0_ImplAccess().getGroup(), "rule__Concrete0_Impl__Group__0");
			mappings.put(grammarAccess.getConcrete1_ImplAccess().getGroup(), "rule__Concrete1_Impl__Group__0");
			mappings.put(grammarAccess.getDiamondInheritanceAccess().getGroup(), "rule__DiamondInheritance__Group__0");
			mappings.put(grammarAccess.getRootAccess().getNameAssignment_2(), "rule__Root__NameAssignment_2");
			mappings.put(grammarAccess.getRootAccess().getClassesAssignment_4_2(), "rule__Root__ClassesAssignment_4_2");
			mappings.put(grammarAccess.getRootAccess().getClassesAssignment_4_3_1(), "rule__Root__ClassesAssignment_4_3_1");
			mappings.put(grammarAccess.getRootAccess().getConcrete0Assignment_5_1(), "rule__Root__Concrete0Assignment_5_1");
			mappings.put(grammarAccess.getConcrete0_ImplAccess().getNameAssignment_2(), "rule__Concrete0_Impl__NameAssignment_2");
			mappings.put(grammarAccess.getConcrete1_ImplAccess().getNameAssignment_2(), "rule__Concrete1_Impl__NameAssignment_2");
			mappings.put(grammarAccess.getDiamondInheritanceAccess().getNameAssignment_2(), "rule__DiamondInheritance__NameAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Ecore2XtextTestGrammarAccess grammarAccess;

	@Override
	protected InternalEcore2XtextTestParser createParser() {
		InternalEcore2XtextTestParser result = new InternalEcore2XtextTestParser(null);
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

	public Ecore2XtextTestGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Ecore2XtextTestGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
