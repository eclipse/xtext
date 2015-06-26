/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

/**
 * Xtext uses an {@link IHighlightedPositionAcceptor} to collect any ranges that should
 * be highlighted based on semantic information of your model. It is passed to a
 * {@link ISemanticHighlightingCalculator}.
 * 
 * This interface is not intended to be implemented by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
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
