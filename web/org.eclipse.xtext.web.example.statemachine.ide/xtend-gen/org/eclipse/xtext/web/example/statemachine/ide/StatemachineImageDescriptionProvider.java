/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
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
      if (element instanceof OutputSignal) {
        _matched=true;
        SimpleImageDescription _simpleImageDescription = new SimpleImageDescription("output");
        _switchResult = new DecoratedImageDescription(baseImage, _simpleImageDescription);
      }
      if (!_matched) {
        _switchResult = baseImage;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
