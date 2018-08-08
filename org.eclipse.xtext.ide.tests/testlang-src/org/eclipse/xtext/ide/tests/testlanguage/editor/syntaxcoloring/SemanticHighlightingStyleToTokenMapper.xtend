/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
