/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.syntaxcoloring;

/**
 * Xtext uses an {@link IHighlightedPositionAcceptor} to collect any ranges that should
 * be highlighted based on semantic information of your model. It is passed to a
 * {@link ISemanticHighlightingCalculator}.
 * 
 * This interface is not intended to be implemented by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9 
 */
public interface IHighlightedPositionAcceptor {

	/**
	 * Associates a text range with a style.
	 * @param offset the offset of the range.
	 * @param length the length of the range.
	 * @param id the ids of the highlighting style, that should be applied.
	 */
	void addPosition(int offset, int length, String... id);
	
}
