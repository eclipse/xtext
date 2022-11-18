/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 * 
 * @deprecated this class is not used anymore and will be removed in a future release
 */
@Deprecated(forRemoval = true)
@ImplementedBy(IEditorHighlightingConfigurationProvider.DefaultImpl.class)
public interface IEditorHighlightingConfigurationProvider {
	@Deprecated
	class DefaultImpl implements IEditorHighlightingConfigurationProvider {
		@Inject
		private IGrammarAccess grammarAccess;

		@Inject
		private LanguageInfo languageInfo;

		@Override
		public String getConfiguration(String editorName) {
			if ("EclipseChe".equals(editorName) || "EclipseOrion".equals(editorName)) {
				StringConcatenation builder = new StringConcatenation();
				builder.append("[");
				builder.newLine();
				builder.append("  ");
				builder.append(getGetStandardPatterns(), "  ");
				builder.newLineIfNotEmpty();
				builder.append("  ");
				builder.append("{");
				builder.newLine();
				builder.append("    ");
				builder.append("match: \"\\\\b(?:");
				builder.append(Joiner.on("|").join(getKeywords()), "    ");
				builder.append(")\\\\b\", ");
				builder.newLineIfNotEmpty();
				builder.append("    ");
				builder.append("name: \"keyword.");
				builder.append(languageInfo.getShortName(), "    ");
				builder.append("\" ");
				builder.newLineIfNotEmpty();
				builder.append("  ");
				builder.append("}");
				builder.newLine();
				builder.append("]");
				builder.newLine();
				return builder.toString();
			} else {
				return new StringConcatenation().toString();
			}
		}

		public CharSequence getGetStandardPatterns() {
			StringConcatenation builder = new StringConcatenation();
			builder.append("{include: \"orion.c-like#comment_singleLine\"},");
			builder.newLine();
			builder.append("{include: \"orion.c-like#comment_block\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#string_doubleQuote\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#string_singleQuote\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#doc_block\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#number_decimal\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#number_hex\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#brace_open\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#brace_close\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#bracket_open\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#bracket_close\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#parenthesis_open\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#parenthesis_close\"},");
			builder.newLine();
			builder.append("{include: \"orion.lib#operator\"},");
			builder.newLine();
			return builder;
		}

		public Iterable<String> getKeywords() {
			Set<String> result = new HashSet<>();
			for (Keyword k : GrammarUtil.containedKeywords(grammarAccess.getGrammar())) {
				if (Character.isLetter(k.getValue().charAt(0))) {
					result.add(k.getValue());
				}
			}
			return IterableExtensions.sort(result);
		}
	}

	/**
	 * provides an editor specific highlighting configuration or null.
	 */
	String getConfiguration(String editorName);
}
