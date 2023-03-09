/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.ImplementedBy;

/**
 * Clients should implement an <code>ISemanticHighlightingCalculator</code> to compute
 * the mapping from ranges in the input to the appropriate highlighting style.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@ImplementedBy(DefaultSemanticHighlightingCalculator.class)
public interface ISemanticHighlightingCalculator {

	/**
	 * @param resource the resource that will be highlighted. May be <code>null</code> in some rare cases.
	 * @param acceptor used to announce the mapping from text-range to the style's id. The acceptor will never be <code>null</code>.
	 * @param cancelIndicator used to determine whether we should stop searching for highlighting positions
	 * 		(use {@code OperationCanceledManager} to check)
	 */
	void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator);
	
}
