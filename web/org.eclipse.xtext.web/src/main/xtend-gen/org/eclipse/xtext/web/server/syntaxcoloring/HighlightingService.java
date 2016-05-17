/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.syntaxcoloring;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingResult;

/**
 * Service class for semantic highlighting. The syntactic highlighting is assumed
 * to be already computed in the client, since that can usually be done with
 * simple regular expressions in JavaScript.
 */
@Singleton
@SuppressWarnings("all")
public class HighlightingService extends AbstractCachedService<HighlightingResult> {
  @Inject
  private ISemanticHighlightingCalculator highlightingCalculator;
  
  /**
   * Compute the highlighting result for the given document. This method should not be called
   * directly from the service dispatcher; use {@link #getResult(XtextWebDocumentAccess)} instead
   * in order to avoid duplicate computations.
   */
  @Override
  public HighlightingResult compute(final IXtextWebDocument it, final CancelIndicator cancelIndicator) {
    final HighlightingResult result = new HighlightingResult();
    List<HighlightingResult.Region> _regions = result.getRegions();
    final IHighlightedPositionAcceptor acceptor = this.createHighlightedPositionAcceptor(_regions);
    XtextResource _resource = it.getResource();
    this.highlightingCalculator.provideHighlightingFor(_resource, acceptor, cancelIndicator);
    return result;
  }
  
  protected IHighlightedPositionAcceptor createHighlightedPositionAcceptor(final List<HighlightingResult.Region> positions) {
    final IHighlightedPositionAcceptor _function = new IHighlightedPositionAcceptor() {
      @Override
      public void addPosition(final int offset, final int length, final String[] ids) {
        HighlightingResult.Region _region = new HighlightingResult.Region(offset, length, ids);
        positions.add(_region);
      }
    };
    return _function;
  }
}
