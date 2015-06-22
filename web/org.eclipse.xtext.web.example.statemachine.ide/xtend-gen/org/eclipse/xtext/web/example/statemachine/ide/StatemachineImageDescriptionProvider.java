package org.eclipse.xtext.web.example.statemachine.ide;

import org.eclipse.xtext.ide.labels.DecoratedImageDescription;
import org.eclipse.xtext.ide.labels.EClassImageDescriptionProvider;
import org.eclipse.xtext.ide.labels.IImageDescription;
import org.eclipse.xtext.ide.labels.SimpleImageDescription;
import org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal;

@SuppressWarnings("all")
public class StatemachineImageDescriptionProvider extends EClassImageDescriptionProvider {
  @Override
  public IImageDescription getImageDescription(final Object element) {
    IImageDescription _xblockexpression = null;
    {
      final IImageDescription baseImage = super.getImageDescription(element);
      IImageDescription _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (element instanceof OutputSignal) {
          _matched=true;
          SimpleImageDescription _simpleImageDescription = new SimpleImageDescription("output");
          _switchResult = new DecoratedImageDescription(baseImage, _simpleImageDescription);
        }
      }
      if (!_matched) {
        _switchResult = baseImage;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
