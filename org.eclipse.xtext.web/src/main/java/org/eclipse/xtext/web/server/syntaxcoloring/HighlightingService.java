/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.syntaxcoloring;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;

/**
 * Service class for semantic highlighting. The syntactic highlighting is
 * assumed to be already computed in the client, since that can usually be done
 * with simple regular expressions in JavaScript.
 */
@Singleton
public class HighlightingService extends AbstractCachedService<HighlightingResult> {
	@Inject
	private ISemanticHighlightingCalculator highlightingCalculator;

	/**
	 * Compute the highlighting result for the given document. This method should
	 * not be called directly from the service dispatcher; use
	 * {@link #getResult(XtextWebDocumentAccess)} instead in order to avoid
	 * duplicate computations.
	 */
	@Override
	public HighlightingResult compute(IXtextWebDocument doc, CancelIndicator cancelIndicator) {
		HighlightingResult result = new HighlightingResult();
		IHighlightedPositionAcceptor acceptor = createHighlightedPositionAcceptor(result.getRegions());
		highlightingCalculator.provideHighlightingFor(doc.getResource(), acceptor, cancelIndicator);
		return result;
	}

	protected IHighlightedPositionAcceptor createHighlightedPositionAcceptor(
			List<HighlightingResult.Region> positions) {
		return (int offset, int length, String... ids) -> {
			HighlightingResult.Region region = new HighlightingResult.Region(offset, length, ids);
			positions.add(region);
		};
	}
}
