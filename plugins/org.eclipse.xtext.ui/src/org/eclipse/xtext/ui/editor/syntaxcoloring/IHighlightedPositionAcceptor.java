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
 * {@link org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator}.
 * 
 * This interface is not intended to be implemented by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor instead
 */
@Deprecated
public interface IHighlightedPositionAcceptor extends org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor {

	// This override is only here to befriend the API tooling.
	/**
	 * {@inheritDoc}
	 */
	@Override
	void addPosition(int offset, int length, String... id);
	
}
