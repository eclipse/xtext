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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug288734TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288734TestLanguageGrammarAccess;

public class Bug288734TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug288734TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug288734TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getTConstantAccess().getAlternatives(), "rule__TConstant__Alternatives");
			builder.put(grammarAccess.getTStringConstantAccess().getGroup(), "rule__TStringConstant__Group__0");
			builder.put(grammarAccess.getTIntegerConstantAccess().getGroup(), "rule__TIntegerConstant__Group__0");
			builder.put(grammarAccess.getTBooleanConstantAccess().getGroup(), "rule__TBooleanConstant__Group__0");
			builder.put(grammarAccess.getTAnnotationAccess().getGroup(), "rule__TAnnotation__Group__0");
			builder.put(grammarAccess.getModelAccess().getConstantsAssignment(), "rule__Model__ConstantsAssignment");
			builder.put(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0(), "rule__TStringConstant__AnnotationsAssignment_0");
			builder.put(grammarAccess.getTStringConstantAccess().getNameAssignment_3(), "rule__TStringConstant__NameAssignment_3");
			builder.put(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0(), "rule__TIntegerConstant__AnnotationsAssignment_0");
			builder.put(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3(), "rule__TIntegerConstant__NameAssignment_3");
			builder.put(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0(), "rule__TBooleanConstant__AnnotationsAssignment_0");
			builder.put(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3(), "rule__TBooleanConstant__NameAssignment_3");
			builder.put(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1(), "rule__TAnnotation__DescriptionAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug288734TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug288734TestLanguageParser createParser() {
		InternalBug288734TestLanguageParser result = new InternalBug288734TestLanguageParser(null);
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

	public Bug288734TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug288734TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
