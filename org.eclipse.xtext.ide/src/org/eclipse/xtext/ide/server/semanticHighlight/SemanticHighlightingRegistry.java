/**
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.semanticHighlight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SemanticHighlightingCapabilities;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.SemanticHighlightingParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens;
import org.eclipse.lsp4j.util.SemanticHighlightingTokens.Token;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.MergingHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ILanguageServerAccess.Context;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Streams;
import com.google.inject.Inject;

/**
 * Shared semantic highlighting manager per language server. Responsible for converting the semantic highlighted ranges
 * into the LSP standard by producing a compact, {@code base64} encoded token string.
 */
public class SemanticHighlightingRegistry {
	/**
	 * Reserved TextMate scope identifier for styles that cannot be handled.
	 */
	public static final String UNKNOWN_SCOPE = "unknown.xtext";

	/**
	 * TextMate scopes indicating an unhandled style ID to TextMate scope mapping.
	 */
	public static final List<String> UNKNOWN_SCOPES = Collections
			.singletonList(SemanticHighlightingRegistry.UNKNOWN_SCOPE);

	@Inject
	private UriExtensions uriExtensions;

	/**
	 * Lookup table for all known TextMate scopes.
	 */
	protected BiMap<Integer, List<String>> scopes;

	protected LanguageClient client;

	public void initialize(Iterable<? extends IResourceServiceProvider> allLanguages, ClientCapabilities capabilities,
			LanguageClient client) {
		Preconditions.checkState(this.client == null, "Already initialized.");
		TextDocumentClientCapabilities textDocument = capabilities == null ? null : capabilities.getTextDocument();
		SemanticHighlightingCapabilities semanticHighlightingCapabilities = textDocument == null ? null
				: textDocument.getSemanticHighlightingCapabilities();
		boolean semanticHighlighting = semanticHighlightingCapabilities == null ? false
				: semanticHighlightingCapabilities.getSemanticHighlighting();
		ImmutableBiMap.Builder<Integer, List<String>> builder = ImmutableBiMap.builder();
		if (semanticHighlighting) {
			Set<List<String>> allScopes = Streams.stream(allLanguages)
					.map(l -> l.get(ISemanticHighlightingStyleToTokenMapper.class)).filter(m -> m != null)
					.flatMap(mapper -> mapper.getAllStyleIds().stream().map(id -> mapper.toScopes(id)))
					.filter(l -> l != null && !l.isEmpty()).collect(Collectors.toSet());
			int i = 0;
			for (List<String> scopes : allScopes)
				builder.put(i++, scopes);
		}
		this.scopes = builder.build();
		this.client = client;
	}

	/**
	 * Returns with a list of TextMate scopes for the internal scope index. Returns the
	 * {@link SemanticHighlightingRegistry#UNKNOWN_SCOPES unknown scopes} if no scopes are registered for the argument.
	 */
	public List<String> getScopes(int scopeIndex) {
		checkInitialized();
		return scopes.getOrDefault(scopeIndex, SemanticHighlightingRegistry.UNKNOWN_SCOPES);
	}

	/**
	 * Returns with the internal scope index for the argument. Returns {@code -1} if the scopes argument is
	 * <code>null</code>, the {@link SemanticHighlightingRegistry#UNKNOWN_SCOPES unknown scopes} or is not registered to
	 * this manager.
	 */
	public int getIndex(List<String> scopes) {
		checkInitialized();
		if (isNullOrUnknown(scopes))
			return -1;
		Integer index = this.scopes.inverse().get(scopes);
		return index == null ? -1 : index;
	}

	/**
	 * Returns with a view of all scopes known by this manager.
	 */
	public List<List<String>> getAllScopes() {
		checkInitialized();
		ImmutableList.Builder<List<String>> builder = ImmutableList.builder();
		scopes.keySet().forEach(it -> builder
				.add(Preconditions.checkNotNull(scopes.get(it), "No scopes are available for index: " + it)));
		return builder.build();
	}

	public void update(Context context) {
		checkInitialized();
		if (!(context.getResource() instanceof XtextResource))
			return;
		if (!context.isDocumentOpen())
			return;
		XtextResource resource = (XtextResource) context.getResource();
		IResourceServiceProvider resourceServiceProvider = resource.getResourceServiceProvider();
		ISemanticHighlightingCalculator calculator = resourceServiceProvider == null ? null
				: resourceServiceProvider.get(ISemanticHighlightingCalculator.class);
		ISemanticHighlightingStyleToTokenMapper mapper = resourceServiceProvider == null ? null
				: resourceServiceProvider.get(ISemanticHighlightingStyleToTokenMapper.class);
		if (calculator == null || isIgnoredMapper(mapper))
			return;
		Document document = context.getDocument();
		MergingHighlightedPositionAcceptor acceptor = new MergingHighlightedPositionAcceptor(calculator);
		calculator.provideHighlightingFor(resource, acceptor, CancelIndicator.NullImpl);
		Iterable<SemanticHighlightingRegistry.HighlightedRange> ranges = Iterables.concat(ListExtensions
				.map(acceptor.getPositions(), position -> ListExtensions.map(Arrays.asList(position.getIds()), id -> {
					Position start = document.getPosition(position.getOffset());
					Position end = document.getPosition(position.getOffset() + position.getLength());
					int scope = getIndex(mapper.toScopes(id));
					return new SemanticHighlightingRegistry.HighlightedRange(start, end, scope);
				})));
		notifyClient(new SemanticHighlightingParams(toVersionedTextDocumentIdentifier(context),
				toSemanticHighlightingInformation(ranges, document)));
	}

	/**
	 * {@code true} if the argument is an ignored mapper. Otherwise, {@code false}. If a mapper is ignored, no semantic
	 * highlighting information will be calculated. Clients won't be notified at all.
	 * 
	 * By default, the argument is ignored if {@code null}, or instance of the
	 * {@link ISemanticHighlightingStyleToTokenMapper.Noop NOOP mapper}.
	 */
	protected boolean isIgnoredMapper(ISemanticHighlightingStyleToTokenMapper mapper) {
		return mapper instanceof ISemanticHighlightingStyleToTokenMapper.Noop;
	}

	protected List<SemanticHighlightingInformation> toSemanticHighlightingInformation(
			Iterable<? extends HighlightedRange> ranges, Document document) {
		ImmutableMultimap.Builder<Integer, Token> builder = ImmutableMultimap.builder();
		Iterables.filter(ranges, it -> !Objects.equals(it.getStart(), it.getEnd())).forEach((HighlightedRange it) -> {
			int startLine = it.getStart().getLine();
			int endLine = it.getEnd().getLine();
			if (startLine == endLine) {
				int length = it.getEnd().getCharacter() - it.getStart().getCharacter();
				builder.put(startLine, new Token(it.getStart().getCharacter(), length, it.scope));
			} else {
				String startLineContent = document.getLineContent(startLine);
				int startLength = startLineContent.length() - it.getStart().getCharacter();
				builder.put(startLine, new Token(it.getStart().getCharacter(), startLength, it.scope));
				for (int line = (startLine + 1); (line < endLine); line++) {
					String lineContent = document.getLineContent(line);
					builder.put(line, new Token(0, lineContent.length(), it.scope));
				}
				builder.put(endLine, new Token(0, it.getEnd().getCharacter(), it.scope));
			}
		});
		return appendEmptyLineTokens(IterableExtensions.toList(IterableExtensions
				.map(builder.build().asMap().entrySet(), it -> new SemanticHighlightingInformation(it.getKey(),
						SemanticHighlightingTokens.encode(it.getValue())))),
				document);
	}

	protected List<SemanticHighlightingInformation> appendEmptyLineTokens(List<SemanticHighlightingInformation> infos,
			Document document) {
		int lineCount = document.getLineCount();
		Map<Integer, SemanticHighlightingInformation> tokens = new HashMap<>(
				Maps.uniqueIndex(infos, it -> it.getLine()));
		for (int i = 0; i < lineCount; i++)
			tokens.putIfAbsent(i, new SemanticHighlightingInformation(i, null));
		return new ArrayList<>(tokens.values());
	}

	protected VersionedTextDocumentIdentifier toVersionedTextDocumentIdentifier(Context context) {
		VersionedTextDocumentIdentifier id = new VersionedTextDocumentIdentifier();
		id.setUri(uriExtensions.toUriString(context.getResource().getURI()));
		id.setVersion(context.getDocument().getVersion());
		return id;
	}

	protected void notifyClient(SemanticHighlightingParams params) {
		client.semanticHighlighting(params);
	}

	protected void checkInitialized() {
		Preconditions.checkState(client != null, "Not initialized.");
	}

	protected boolean isNullOrUnknown(List<String> nullable) {
		return SemanticHighlightingRegistry.UNKNOWN_SCOPES.equals(nullable);
	}

	/**
	 * A highlighted range with additional <a href="https://manual.macromates.com/en/language_grammars">TextMate
	 * scopes</a> information.
	 */
	public static class HighlightedRange extends Range {
		/**
		 * The internal index of the corresponding TextMate scope.
		 */
		private final int scope;

		public HighlightedRange(Position start, Position end, int scope) {
			super(start, end);
			this.scope = scope;
		}

		@Override
		public int hashCode() {
			return 31 * super.hashCode() + scope;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			if (!super.equals(obj))
				return false;
			SemanticHighlightingRegistry.HighlightedRange other = (SemanticHighlightingRegistry.HighlightedRange) obj;
			if (other.scope != scope)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).addAllFields().toString();
		}

		public int getScope() {
			return scope;
		}
	}

}
