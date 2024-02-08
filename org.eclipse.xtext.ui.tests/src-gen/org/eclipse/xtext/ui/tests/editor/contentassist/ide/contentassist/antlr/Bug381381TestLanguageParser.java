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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug381381TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug381381TestLanguageGrammarAccess;

public class Bug381381TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug381381TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug381381TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup(), "rule__CopyFieldNameToVariableStmt__Group__0");
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_0(), "rule__CopyFieldNameToVariableStmt__Group_1_0__0");
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_1(), "rule__CopyFieldNameToVariableStmt__Group_1_1__0");
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getGroup_1_2(), "rule__CopyFieldNameToVariableStmt__Group_1_2__0");
			builder.put(grammarAccess.getModelAccess().getStmtAssignment(), "rule__Model__StmtAssignment");
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getLineAssignment_1_0_4(), "rule__CopyFieldNameToVariableStmt__LineAssignment_1_0_4");
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getColumnAssignment_1_0_6(), "rule__CopyFieldNameToVariableStmt__ColumnAssignment_1_0_6");
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getNameAssignment_1_1_3(), "rule__CopyFieldNameToVariableStmt__NameAssignment_1_1_3");
			builder.put(grammarAccess.getCopyFieldNameToVariableStmtAccess().getUnorderedGroup_1(), "rule__CopyFieldNameToVariableStmt__UnorderedGroup_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug381381TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug381381TestLanguageParser createParser() {
		InternalBug381381TestLanguageParser result = new InternalBug381381TestLanguageParser(null);
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

	public Bug381381TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug381381TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
