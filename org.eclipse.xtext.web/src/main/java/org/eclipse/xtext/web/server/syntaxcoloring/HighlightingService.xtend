/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.syntaxcoloring

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.web.server.model.AbstractCachedService
import org.eclipse.xtext.web.server.model.IXtextWebDocument

/**
 * Service class for semantic highlighting. The syntactic highlighting is assumed
 * to be already computed in the client, since that can usually be done with
 * simple regular expressions in JavaScript.
 */
@Singleton
class HighlightingService extends AbstractCachedService<HighlightingResult> {
	
	@Inject ISemanticHighlightingCalculator highlightingCalculator
	
	/**
	 * Compute the highlighting result for the given document. This method should not be called
	 * directly from the service dispatcher; use {@link #getResult(XtextWebDocumentAccess)} instead
	 * in order to avoid duplicate computations.
	 */
	override compute(IXtextWebDocument it, CancelIndicator cancelIndicator) {
		val result = new HighlightingResult
		val IHighlightedPositionAcceptor acceptor = createHighlightedPositionAcceptor(result.regions)
		highlightingCalculator.provideHighlightingFor(resource, acceptor, cancelIndicator)
		return result
	}
	
	protected def IHighlightedPositionAcceptor createHighlightedPositionAcceptor(List<HighlightingResult.Region> positions) {
		[ offset, length, ids |
			positions += new HighlightingResult.Region(offset, length, ids)			
		]
	}
	
}