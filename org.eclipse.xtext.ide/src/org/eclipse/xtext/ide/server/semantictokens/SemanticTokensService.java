/*******************************************************************************
 * Copyright (c) 2022 Avaloq Evolution AG (http://www.avaloq.com).
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.semantictokens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.SemanticTokenModifiers;
import org.eclipse.lsp4j.SemanticTokenTypes;
import org.eclipse.lsp4j.SemanticTokens;
import org.eclipse.lsp4j.SemanticTokensParams;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition;
import org.eclipse.xtext.ide.editor.syntaxcoloring.MergingHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.util.PositionReader;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;

/**
 * A service for Semantic Tokens.
 * 
 * @author Rub�n Porras Campo - Initial contribution and API
 * @author Jonathan Pollert - Adjust to LSP specification
 * 
 * @since 2.29
 */
@Beta
public class SemanticTokensService {
	@Inject
	private IResourceServiceProvider.Registry languagesRegistry;

	private final List<String> tokenTypes = new ArrayList<>();
	private final List<String> tokenModifiers = new ArrayList<>();

	protected SemanticTokensService() {
		addTokenTypes();
		addTokenModifiers();
	}

	protected void addTokenTypes() {
		tokenTypes.add(SemanticTokenTypes.Namespace);
		tokenTypes.add(SemanticTokenTypes.Type);
		tokenTypes.add(SemanticTokenTypes.Class);
		tokenTypes.add(SemanticTokenTypes.Enum);
		tokenTypes.add(SemanticTokenTypes.Interface);
		tokenTypes.add(SemanticTokenTypes.Struct);
		tokenTypes.add(SemanticTokenTypes.TypeParameter);
		tokenTypes.add(SemanticTokenTypes.Parameter);
		tokenTypes.add(SemanticTokenTypes.Variable);
		tokenTypes.add(SemanticTokenTypes.Property);
		tokenTypes.add(SemanticTokenTypes.EnumMember);
		tokenTypes.add(SemanticTokenTypes.Event);
		tokenTypes.add(SemanticTokenTypes.Function);
		tokenTypes.add(SemanticTokenTypes.Method);
		tokenTypes.add(SemanticTokenTypes.Macro);
		tokenTypes.add(SemanticTokenTypes.Keyword);
		tokenTypes.add(SemanticTokenTypes.Modifier);
		tokenTypes.add(SemanticTokenTypes.Comment);
		tokenTypes.add(SemanticTokenTypes.String);
		tokenTypes.add(SemanticTokenTypes.Number);
		tokenTypes.add(SemanticTokenTypes.Regexp);
		tokenTypes.add(SemanticTokenTypes.Operator);
		tokenTypes.add(SemanticTokenTypes.Decorator);
	}

	protected void addTokenModifiers() {
		tokenModifiers.add(SemanticTokenModifiers.Abstract);
		tokenModifiers.add(SemanticTokenModifiers.Async);
		tokenModifiers.add(SemanticTokenModifiers.Declaration);
		tokenModifiers.add(SemanticTokenModifiers.DefaultLibrary);
		tokenModifiers.add(SemanticTokenModifiers.Definition);
		tokenModifiers.add(SemanticTokenModifiers.Deprecated);
		tokenModifiers.add(SemanticTokenModifiers.Documentation);
		tokenModifiers.add(SemanticTokenModifiers.Modification);
		tokenModifiers.add(SemanticTokenModifiers.Readonly);
		tokenModifiers.add(SemanticTokenModifiers.Static);
	}

	private List<LightweightPosition> getPositions(final XtextResource resource,
			final CancelIndicator cancelIndicator) {
		ISemanticHighlightingCalculator semanticHighlightingCalculator = getService(resource.getURI(),
				ISemanticHighlightingCalculator.class);
		if (semanticHighlightingCalculator != null) {
			MergingHighlightedPositionAcceptor acceptor = new MergingHighlightedPositionAcceptor(
					semanticHighlightingCalculator);
			semanticHighlightingCalculator.provideHighlightingFor(resource, acceptor, cancelIndicator);
			acceptor.mergePositions();
			return acceptor.getPositions();
		}
		return Collections.emptyList();
	}

	/**
	 * Semantic tokens full.
	 *
	 * @param document
	 *            the document
	 * @param resource
	 *            the resource
	 * @param params
	 *            the parameters
	 * @param cancelIndicator
	 *            the cancel indicator
	 * @return the semantic tokens
	 */
	public SemanticTokens semanticTokensFull(final Document document, final XtextResource resource,
			final SemanticTokensParams params, final CancelIndicator cancelIndicator) {
		if (document == null || resource == null) {
			return new SemanticTokens(Collections.emptyList());
		}
		List<Integer> data = new ArrayList<>();
		int lastOffset = 0;
		int lastLine = 0;
		try (PositionReader reader = new PositionReader(document.getContents())) {
			List<LightweightPosition> positions = getPositions(resource, cancelIndicator);
			positions.sort(Comparator.comparing(LightweightPosition::getOffset));
			for (LightweightPosition lightweightPosition : positions) {
				Integer positionTokenType = getTokenType(lightweightPosition.getIds());
				Integer positionTokenModifiers = getTokenModifiers(lightweightPosition.getIds());

				if (positionTokenType != -1) {
					int deltaOffset = lightweightPosition.getOffset() - lastOffset;
					reader.skip(deltaOffset);
					Position position = reader.getPosition();
					
					int deltaLine = position.getLine() - lastLine;
					lastLine = position.getLine();
					lastOffset = lightweightPosition.getOffset();
					
					data.add(deltaLine); // delta line
					// delta start relative to previous token if on the same line or to 0
					data.add(deltaLine == 0 ? deltaOffset : position.getCharacter());
					data.add(lightweightPosition.getLength()); // length
					data.add(positionTokenType); // token type
					data.add(positionTokenModifiers); // token modifiers
				}
			}
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		return new SemanticTokens(data); // resultId not set, no delta support
	}

	public List<String> getTokenTypes() {
		return tokenTypes;
	}

	public List<String> getTokenModifiers() {
		return tokenModifiers;
	}

	/**
	 * @param ids List of tokenType ids to search for in the list of supported tokenTypes
	 * @return index of the first tokenType found by id in the list of supported tokenTypes or -1 if no supported tokenType has been found
	 */
	private int getTokenType(final String[] ids) {
		for (String id : ids) {
			Integer index = tokenTypes.indexOf(id);
			if (index != -1) {
				return index;
			}
		}
		// return -1 to indicate an invalid tokenType.
		return -1;
	}

	private Integer getTokenModifiers(final String[] ids) {
		int bitmask = 0;
		for (String id : ids) {
			Integer index = tokenModifiers.indexOf(id);
			if (index != -1) {
				bitmask |= 1 << index;
			}
		}
		return bitmask;
	}

	private <Service> Service getService(final URI uri, final Class<Service> type) {
		IResourceServiceProvider resourceServiceProvider = languagesRegistry.getResourceServiceProvider(uri);
		if (resourceServiceProvider != null) {
			return resourceServiceProvider.get(type);
		}
		return null;
	}
}
