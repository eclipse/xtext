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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug309949TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug309949TestLanguageGrammarAccess;

public class Bug309949TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug309949TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug309949TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives_1(), "rule__Model__Alternatives_1");
			builder.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_0(), "rule__Model__Group_1_0__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_1(), "rule__Model__Group_1_1__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_2(), "rule__Model__Group_1_2__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_3(), "rule__Model__Group_1_3__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_4(), "rule__Model__Group_1_4__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_5(), "rule__Model__Group_1_5__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_6(), "rule__Model__Group_1_6__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_7(), "rule__Model__Group_1_7__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_8(), "rule__Model__Group_1_8__0");
			builder.put(grammarAccess.getModelAccess().getGroup_1_9(), "rule__Model__Group_1_9__0");
			builder.put(grammarAccess.getError_1Access().getGroup(), "rule__Error_1__Group__0");
			builder.put(grammarAccess.getOperation_1Access().getGroup(), "rule__Operation_1__Group__0");
			builder.put(grammarAccess.getError_2Access().getGroup(), "rule__Error_2__Group__0");
			builder.put(grammarAccess.getOperation_2Access().getGroup(), "rule__Operation_2__Group__0");
			builder.put(grammarAccess.getError_3Access().getGroup(), "rule__Error_3__Group__0");
			builder.put(grammarAccess.getOperation_3Access().getGroup(), "rule__Operation_3__Group__0");
			builder.put(grammarAccess.getError_4Access().getGroup(), "rule__Error_4__Group__0");
			builder.put(grammarAccess.getOperation_4Access().getGroup(), "rule__Operation_4__Group__0");
			builder.put(grammarAccess.getError_5Access().getGroup(), "rule__Error_5__Group__0");
			builder.put(grammarAccess.getOperation_5Access().getGroup(), "rule__Operation_5__Group__0");
			builder.put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_0_2(), "rule__Model__ErrorsAssignment_1_0_2");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_0_3(), "rule__Model__OperationsAssignment_1_0_3");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_1_2(), "rule__Model__ErrorsAssignment_1_1_2");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_1_3(), "rule__Model__OperationsAssignment_1_1_3");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_2_2(), "rule__Model__ErrorsAssignment_1_2_2");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_2_3(), "rule__Model__OperationsAssignment_1_2_3");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1_3_1(), "rule__Model__NameAssignment_1_3_1");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_3_3(), "rule__Model__ErrorsAssignment_1_3_3");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_3_4(), "rule__Model__OperationsAssignment_1_3_4");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1_4_1(), "rule__Model__NameAssignment_1_4_1");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_4_3(), "rule__Model__ErrorsAssignment_1_4_3");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_4_4(), "rule__Model__OperationsAssignment_1_4_4");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1_5_1(), "rule__Model__NameAssignment_1_5_1");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_5_3(), "rule__Model__ErrorsAssignment_1_5_3");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_5_4(), "rule__Model__OperationsAssignment_1_5_4");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1_6_1(), "rule__Model__NameAssignment_1_6_1");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_6_3(), "rule__Model__ErrorsAssignment_1_6_3");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_6_4(), "rule__Model__OperationsAssignment_1_6_4");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1_7_1(), "rule__Model__NameAssignment_1_7_1");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_7_3(), "rule__Model__ErrorsAssignment_1_7_3");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_7_4(), "rule__Model__OperationsAssignment_1_7_4");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1_8_1(), "rule__Model__NameAssignment_1_8_1");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_8_3(), "rule__Model__ErrorsAssignment_1_8_3");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_8_4(), "rule__Model__OperationsAssignment_1_8_4");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1_9_1(), "rule__Model__NameAssignment_1_9_1");
			builder.put(grammarAccess.getModelAccess().getErrorsAssignment_1_9_3(), "rule__Model__ErrorsAssignment_1_9_3");
			builder.put(grammarAccess.getModelAccess().getOperationsAssignment_1_9_4(), "rule__Model__OperationsAssignment_1_9_4");
			builder.put(grammarAccess.getError_1Access().getAnnotationsAssignment_0(), "rule__Error_1__AnnotationsAssignment_0");
			builder.put(grammarAccess.getError_1Access().getNameAssignment_2(), "rule__Error_1__NameAssignment_2");
			builder.put(grammarAccess.getOperation_1Access().getAnnotationsAssignment_0(), "rule__Operation_1__AnnotationsAssignment_0");
			builder.put(grammarAccess.getOperation_1Access().getNameAssignment_2(), "rule__Operation_1__NameAssignment_2");
			builder.put(grammarAccess.getError_2Access().getAnnotationsAssignment_0(), "rule__Error_2__AnnotationsAssignment_0");
			builder.put(grammarAccess.getError_2Access().getNameAssignment_2(), "rule__Error_2__NameAssignment_2");
			builder.put(grammarAccess.getOperation_2Access().getAnnotationsAssignment_0(), "rule__Operation_2__AnnotationsAssignment_0");
			builder.put(grammarAccess.getOperation_2Access().getNameAssignment_2(), "rule__Operation_2__NameAssignment_2");
			builder.put(grammarAccess.getError_3Access().getAnnotationsAssignment_0(), "rule__Error_3__AnnotationsAssignment_0");
			builder.put(grammarAccess.getError_3Access().getNameAssignment_2(), "rule__Error_3__NameAssignment_2");
			builder.put(grammarAccess.getOperation_3Access().getAnnotationsAssignment_0(), "rule__Operation_3__AnnotationsAssignment_0");
			builder.put(grammarAccess.getOperation_3Access().getNameAssignment_2(), "rule__Operation_3__NameAssignment_2");
			builder.put(grammarAccess.getError_4Access().getAnnotationsAssignment_0(), "rule__Error_4__AnnotationsAssignment_0");
			builder.put(grammarAccess.getError_4Access().getNameAssignment_2(), "rule__Error_4__NameAssignment_2");
			builder.put(grammarAccess.getOperation_4Access().getAnnotationsAssignment_0(), "rule__Operation_4__AnnotationsAssignment_0");
			builder.put(grammarAccess.getOperation_4Access().getNameAssignment_2(), "rule__Operation_4__NameAssignment_2");
			builder.put(grammarAccess.getError_5Access().getNameAssignment_1(), "rule__Error_5__NameAssignment_1");
			builder.put(grammarAccess.getOperation_5Access().getNameAssignment_1(), "rule__Operation_5__NameAssignment_1");
			builder.put(grammarAccess.getAnnotationAccess().getNameAssignment_1(), "rule__Annotation__NameAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug309949TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug309949TestLanguageParser createParser() {
		InternalBug309949TestLanguageParser result = new InternalBug309949TestLanguageParser(null);
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

	public Bug309949TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug309949TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
