/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring

import com.google.inject.Inject
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class DeprecatedTaskHighlightingTest extends TaskHighlightingTest implements IHighlightedPositionAcceptor {
	@Inject
	DefaultSemanticHighlightingCalculator highlighter
	
	override getHighlighter() {
		return highlighter
	}
}