/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring

import org.eclipse.xtext.ide.server.semanticHighlight.ISemanticHighlightingStyleToTokenMapper

class SemanticHighlightingStyleToTokenMapper implements ISemanticHighlightingStyleToTokenMapper {

	override toScopes(String styleId) {
		return #[styleId];
	}

	override getAllStyleIds() {
		return SemanticHighlightingCalculatorImpl.STYLES;
	}

}
