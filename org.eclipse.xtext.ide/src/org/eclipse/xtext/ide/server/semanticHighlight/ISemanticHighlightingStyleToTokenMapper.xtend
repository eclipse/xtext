/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.semanticHighlight

import com.google.inject.ImplementedBy
import com.google.inject.Singleton
import java.util.List
import java.util.Set
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition

/**
 * Service for mapping the IDs of the highlighting styles to a list of <a href="https://manual.macromates.com/en/language_grammars">TextMate scopes</a>.
 * 
 * @see IHighlightedPositionAcceptor#addPosition
 * @see LightweightPosition#getIds
 * 
 */
@ImplementedBy(Noop)
interface ISemanticHighlightingStyleToTokenMapper {

	/**
	 * Maps the highlighting style ID to the corresponding TextMate scopes.
	 */
	def List<String> toScopes(String styleId);

	/**
	 * Returns with a set of distinct style identifiers that are used by the {@link IHighlightedPositionAcceptor} when calculating
	 * the highlighted positions with the {@link ISemanticHighlightingCalculator}.
	 * 
	 * <p>
	 * Must not return with {@code null} but an empty set instead.
	 * 
	 * @see IHighlightedPositionAcceptor#addPosition
	 */
	def Set<String> getAllStyleIds();

	/**
	 * The shared, default NOOP implementation of the semantic style ID to TextMate token mapper.
	 */
	@Singleton
	static final class Noop implements ISemanticHighlightingStyleToTokenMapper {

		override toScopes(String styleId) {
			return SemanticHighlightingRegistry.UNKNOWN_SCOPES;
		}

		override getAllStyleIds() {
			return emptySet;
		}

	}

}
