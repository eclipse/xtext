/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.semanticHighlight

import com.google.common.base.Preconditions
import com.google.common.collect.BiMap
import com.google.common.collect.ImmutableBiMap
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMultimap
import com.google.inject.Inject
import java.util.List
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.SemanticHighlightingInformation
import org.eclipse.lsp4j.SemanticHighlightingParams
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.util.SemanticHighlightingTokens
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.MergingHighlightedPositionAcceptor
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Log

import static extension org.eclipse.lsp4j.util.SemanticHighlightingTokens.encode
import com.google.common.collect.Maps

/**
 * Shared semantic highlighting manager per language server.
 * Responsible for converting the semantic highlighted ranges into the LSP standard by producing a compact,
 * {@code base64} encoded token string.
 * 
 */
@Log
class SemanticHighlightingRegistry {

	/**
	 * Reserved TextMate scope identifier for styles that cannot be handled.
	 */
	public static val UNKNOWN_SCOPE = 'unknown.xtext';

	/**
	 * TextMate scopes indicating an unhandled style ID to TextMate scope mapping.
	 */
	public static val UNKNOWN_SCOPES = #[UNKNOWN_SCOPE];

	/**
	 * A highlighted range with additional <a href="https://manual.macromates.com/en/language_grammars">TextMate scopes</a> information.
	 */
	@Data
	static class HighlightedRange extends Range {

		/**
		 * The internal index of the corresponding TextMate scope.
		 */
		val int scope;

		new(Position start, Position end, int scope) {
			super(start, end);
			this.scope = scope;
		}
	}

	@Inject
	extension UriExtensions;

	/**
	 * Lookup table for all known TextMate scopes.
	 */
	protected BiMap<Integer, List<String>> scopes;

	protected LanguageClient client;

	def void initialize(Iterable<? extends IResourceServiceProvider> allLanguages, ClientCapabilities capabilities, LanguageClient client) {
		Preconditions.checkState(this.client === null, 'Already initialized.');
		val enabled = capabilities?.textDocument?.semanticHighlightingCapabilities?.semanticHighlighting ?: false;
		val builder = ImmutableBiMap.builder;
		if (enabled) {
			allLanguages
				.map[get(ISemanticHighlightingStyleToTokenMapper)]
				.filterNull
				.map[mapper|mapper.allStyleIds.map[styleId|mapper.toScopes(styleId)]]
				.flatten
				.filter[!nullOrEmpty]
				.toSet
				.forEach [ scope, index |
					builder.put(index, scope)
				];
		}
		scopes = builder.build;
		this.client = client;
	}

	/**
	 * Returns with a list of TextMate scopes for the internal scope index. Returns the
	 * {@link SemanticHighlightingRegistry#UNKNOWN_SCOPES unknown scopes} if no scopes are registered for the argument.
	 */
	def List<String> getScopes(int scopeIndex) {
		checkInitialized;
		return scopes.getOrDefault(scopeIndex, SemanticHighlightingRegistry.UNKNOWN_SCOPES);
	}

	/**
	 * Returns with the internal scope index for the argument. Returns {@code -1} if the scopes
	 * argument is <code>null</code>, the {@link SemanticHighlightingRegistry#UNKNOWN_SCOPES unknown scopes}
	 * or is not registered to this manager.
	 */
	def int getIndex(List<String> scopes) {
		checkInitialized;
		if (scopes.nullOrUnknown) {
			return -1;
		}
		val index = this.scopes.inverse.get(scopes);
		return if(index === null) -1 else index;
	}

	/**
	 * Returns with a view of all scopes known by this manager.
	 */
	def List<List<String>> getAllScopes() {
		checkInitialized;
		val builder = ImmutableList.builder;
		scopes.keySet.forEach [
			builder.add(Preconditions.checkNotNull(scopes.get(it), '''No scopes are available for index: «it»'''))
		];
		return builder.build;
	}

	def void update(ILanguageServerAccess.Context context) {
		checkInitialized;
		if (!(context.resource instanceof XtextResource)) {
			return;
		}
		if (!context.documentOpen) {
			return;
		}

		val resource = context.resource as XtextResource;
		val calculator = resource.resourceServiceProvider?.get(ISemanticHighlightingCalculator);
		val mapper = resource.resourceServiceProvider?.get(ISemanticHighlightingStyleToTokenMapper);
		if (calculator === null || mapper.isIgnoredMapper) {
			return;
		}

		val document = context.document;
		val acceptor = new MergingHighlightedPositionAcceptor(calculator);
		calculator.provideHighlightingFor(resource, acceptor, CancelIndicator.NullImpl);
		val ranges = acceptor.positions.map [ position |
			position.ids.map [ id |
				val start = document.getPosition(position.offset);
				val end = document.getPosition(position.offset + position.length);
				val scope = getIndex(mapper.toScopes(id));
				return new HighlightedRange(start, end, scope);
			]
		].flatten;

		val lines = ranges.toSemanticHighlightingInformation(document);
		val textDocument = context.toVersionedTextDocumentIdentifier;
		notifyClient(new SemanticHighlightingParams(textDocument, lines));
	}

	/**
	 * {@code true} if the argument is an ignored mapper. Otherwise, {@code false}.
	 * If a mapper is ignored, no semantic highlighting information will be calculated. Clients won't be notified at all.
	 * 
	 * By default, the argument is ignored if {@code null}, or instance of the {@link ISemanticHighlightingStyleToTokenMapper.Noop NOOP mapper}.
	 */
	protected def boolean isIgnoredMapper(ISemanticHighlightingStyleToTokenMapper mapper) {
		return mapper === null || mapper instanceof ISemanticHighlightingStyleToTokenMapper.Noop;
	}

	protected def List<SemanticHighlightingInformation> toSemanticHighlightingInformation(
		Iterable<? extends HighlightedRange> ranges, Document document) {

		val builder = ImmutableMultimap.builder;
		ranges.filter[start != end].forEach [
			val startLine = start.line;
			val endLine = end.line;
			if (startLine === endLine) {
				val length = end.character - start.character;
				builder.put(startLine, new SemanticHighlightingTokens.Token(start.character, length, scope));
			} else {
				val startLineContent = document.getLineContent(startLine);
				val startLength = startLineContent.length - start.character;
				builder.put(startLine, new SemanticHighlightingTokens.Token(start.character, startLength, scope));
				for (var line = startLine + 1; line < endLine; line++) {
					val lineContent = document.getLineContent(line);
					builder.put(line, new SemanticHighlightingTokens.Token(0, lineContent.length, scope));
				}
				builder.put(endLine, new SemanticHighlightingTokens.Token(0, end.character, scope));
			}
		];
		return builder.build.asMap.entrySet.map [
			val line = key;
			val tokens = value;
			new SemanticHighlightingInformation(line, tokens.encode);
		].toList.appendEmptyLineTokens(document);
	}

	protected def List<SemanticHighlightingInformation> appendEmptyLineTokens(
		List<SemanticHighlightingInformation> infos, Document document) {

		val lineCount = document.lineCount;
		val tokens = Maps.newHashMap(Maps.uniqueIndex(infos, [line]));
		for (i : 0 ..< lineCount) {
			if (!tokens.containsKey(i)) {
				tokens.put(i, new SemanticHighlightingInformation(i, null))
			}
		}
		return tokens.values.toList;
	}

	protected def VersionedTextDocumentIdentifier toVersionedTextDocumentIdentifier(ILanguageServerAccess.Context context) {
		return new VersionedTextDocumentIdentifier => [
			uri = context.resource.URI.toUriString;
			version = context.document.version;
		];
	}

	protected def void notifyClient(SemanticHighlightingParams params) {
		client.semanticHighlighting(params);
	}

	protected def void checkInitialized() {
		Preconditions.checkState(client !== null, 'Not initialized.');
	}

	protected def boolean isNullOrUnknown(List<String> nullable) {
		return nullable === null || nullable == UNKNOWN_SCOPES;
	}

}
