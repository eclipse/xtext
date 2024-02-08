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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalContentAssistNoTerminalExtensionTestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistNoTerminalExtensionTestLanguageGrammarAccess;

public class ContentAssistNoTerminalExtensionTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getPolygonBasedNodeShapeAccess().getAlternatives(), "rule__PolygonBasedNodeShape__Alternatives");
			builder.put(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment(), "rule__PolygonBasedShape__ShapeAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalContentAssistNoTerminalExtensionTestLanguageParser createParser() {
		InternalContentAssistNoTerminalExtensionTestLanguageParser result = new InternalContentAssistNoTerminalExtensionTestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS" };
	}

	public ContentAssistNoTerminalExtensionTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
