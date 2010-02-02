/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.xtext.resource.XtextResource;

/**
 * Clients should implement an <code>ISemanticHighlightingCalculator</code> to compute
 * the mapping from ranges in the input to the appropriate highlighting style.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ISemanticHighlightingCalculator {

	/**
	 * @param resource the resource that will be highlighted. May be <code>null</code> in some rare cases.
	 * @param acceptor used to announce the mapping from text-range to the style's id. The acceptor will never be <code>null</code>.
	 */
	void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor);
	
}
