/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.ILocationInFileProviderExtension;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;

@SuppressWarnings("all")
public class TreeAppendableUtil {
  @Inject
  private ILocationInFileProvider locationProvider;
  
  public ITreeAppendable traceSignificant(final ITreeAppendable appendable, final EObject source) {
    return this.traceSignificant(appendable, source, false);
  }
  
  public ITreeAppendable traceSignificant(final ITreeAppendable appendable, final EObject source, final boolean useForDebugging) {
    ITreeAppendable _xifexpression = null;
    if ((appendable instanceof TreeAppendable)) {
      _xifexpression = ((TreeAppendable)appendable).trace(source, ILocationInFileProviderExtension.RegionDescription.SIGNIFICANT, useForDebugging);
    } else {
      ITreeAppendable _xblockexpression = null;
      {
        ITextRegion _significantTextRegion = this.locationProvider.getSignificantTextRegion(source);
        final ITextRegionWithLineInformation it = ((ITextRegionWithLineInformation) _significantTextRegion);
        ITreeAppendable _xifexpression_1 = null;
        if (((it != null) && (it != ITextRegion.EMPTY_REGION))) {
          int _offset = it.getOffset();
          int _length = it.getLength();
          int _lineNumber = it.getLineNumber();
          int _endLineNumber = it.getEndLineNumber();
          LocationData _locationData = new LocationData(_offset, _length, _lineNumber, _endLineNumber, null);
          _xifexpression_1 = appendable.trace(_locationData, useForDebugging);
        } else {
          _xifexpression_1 = appendable;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public ITreeAppendable traceWithComments(final ITreeAppendable appendable, final EObject source) {
    ITreeAppendable _xifexpression = null;
    if ((appendable instanceof TreeAppendable)) {
      _xifexpression = ((TreeAppendable)appendable).trace(source, ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS, false);
    } else {
      ITreeAppendable _xblockexpression = null;
      {
        ITextRegion _switchResult = null;
        final ILocationInFileProvider locationProvider = this.locationProvider;
        boolean _matched = false;
        if (locationProvider instanceof ILocationInFileProviderExtension) {
          _matched=true;
          _switchResult = ((ILocationInFileProviderExtension)this.locationProvider).getTextRegion(source, ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS);
        }
        if (!_matched) {
          _switchResult = this.locationProvider.getFullTextRegion(source);
        }
        final ITextRegionWithLineInformation it = ((ITextRegionWithLineInformation) _switchResult);
        ITreeAppendable _xifexpression_1 = null;
        if (((it != null) && (it != ITextRegion.EMPTY_REGION))) {
          int _offset = it.getOffset();
          int _length = it.getLength();
          int _lineNumber = it.getLineNumber();
          int _endLineNumber = it.getEndLineNumber();
          LocationData _locationData = new LocationData(_offset, _length, _lineNumber, _endLineNumber, null);
          _xifexpression_1 = appendable.trace(_locationData);
        } else {
          _xifexpression_1 = appendable;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
