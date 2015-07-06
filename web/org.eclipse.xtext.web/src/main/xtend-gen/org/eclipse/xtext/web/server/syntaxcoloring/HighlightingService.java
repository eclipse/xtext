package org.eclipse.xtext.web.server.syntaxcoloring;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.model.AbstractPreComputedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightRegion;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingResult;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class HighlightingService extends AbstractPreComputedService<HighlightingResult> {
  @Inject
  @Extension
  private ISemanticHighlightingCalculator _iSemanticHighlightingCalculator;
  
  protected IHighlightedPositionAcceptor createHighlightedPositionAcceptor(final List<HighlightRegion> positions) {
    final IHighlightedPositionAcceptor _function = new IHighlightedPositionAcceptor() {
      @Override
      public void addPosition(final int $0, final int $1, final String[] $2) {
        HighlightRegion _highlightRegion = new HighlightRegion($0, $1, $2);
        positions.add(_highlightRegion);
      }
    };
    return _function;
  }
  
  @Override
  public HighlightingResult compute(final IXtextWebDocument it, final CancelIndicator cancelIndicator) {
    HighlightingResult _xblockexpression = null;
    {
      final ArrayList<HighlightRegion> regions = CollectionLiterals.<HighlightRegion>newArrayList();
      final IHighlightedPositionAcceptor acceptor = this.createHighlightedPositionAcceptor(regions);
      XtextResource _resource = it.getResource();
      this._iSemanticHighlightingCalculator.provideHighlightingFor(_resource, acceptor);
      String _stateId = it.getStateId();
      _xblockexpression = new HighlightingResult(_stateId, regions);
    }
    return _xblockexpression;
  }
}
