package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.ILocationInFileProviderExtension;
import org.eclipse.xtext.resource.ILocationInFileProviderExtension.RegionDescription;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;

@SuppressWarnings("all")
public class TreeAppendableUtil {
  @Inject
  private ILocationInFileProvider locationProvider;
  
  public ITreeAppendable traceSignificant(final ITreeAppendable appendable, final EObject source) {
    ITreeAppendable _traceSignificant = this.traceSignificant(appendable, source, false);
    return _traceSignificant;
  }
  
  public ITreeAppendable traceSignificant(final ITreeAppendable appendable, final EObject source, final boolean useForDebugging) {
    ITreeAppendable _xifexpression = null;
    if ((appendable instanceof TreeAppendable)) {
      TreeAppendable _trace = ((TreeAppendable) appendable).trace(source, RegionDescription.SIGNIFICANT, useForDebugging);
      _xifexpression = _trace;
    } else {
      ITreeAppendable _xblockexpression = null;
      {
        ITextRegion _significantTextRegion = this.locationProvider.getSignificantTextRegion(source);
        final ITextRegionWithLineInformation it = ((ITextRegionWithLineInformation) _significantTextRegion);
        ITreeAppendable _xifexpression_1 = null;
        boolean _notEquals = (!Objects.equal(it, null));
        if (_notEquals) {
          int _offset = it.getOffset();
          int _length = it.getLength();
          int _lineNumber = it.getLineNumber();
          int _endLineNumber = it.getEndLineNumber();
          LocationData _locationData = new LocationData(_offset, _length, _lineNumber, _endLineNumber, null);
          ITreeAppendable _trace_1 = appendable.trace(_locationData, useForDebugging);
          _xifexpression_1 = _trace_1;
        } else {
          _xifexpression_1 = appendable;
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public ITreeAppendable traceWithComments(final ITreeAppendable appendable, final EObject source) {
    ITreeAppendable _xifexpression = null;
    if ((appendable instanceof TreeAppendable)) {
      TreeAppendable _trace = ((TreeAppendable) appendable).trace(source, RegionDescription.INCLUDING_COMMENTS, false);
      _xifexpression = _trace;
    } else {
      ITreeAppendable _xblockexpression = null;
      {
        ITextRegion _switchResult = null;
        final ILocationInFileProvider locationProvider = this.locationProvider;
        boolean _matched = false;
        if (!_matched) {
          if (locationProvider instanceof ILocationInFileProviderExtension) {
            _matched=true;
            ITextRegion _textRegion = ((ILocationInFileProviderExtension)this.locationProvider).getTextRegion(source, RegionDescription.INCLUDING_COMMENTS);
            _switchResult = _textRegion;
          }
        }
        if (!_matched) {
          ITextRegion _fullTextRegion = this.locationProvider.getFullTextRegion(source);
          _switchResult = _fullTextRegion;
        }
        final ITextRegionWithLineInformation it = ((ITextRegionWithLineInformation) _switchResult);
        ITreeAppendable _xifexpression_1 = null;
        boolean _notEquals = (!Objects.equal(it, null));
        if (_notEquals) {
          int _offset = it.getOffset();
          int _length = it.getLength();
          int _lineNumber = it.getLineNumber();
          int _endLineNumber = it.getEndLineNumber();
          LocationData _locationData = new LocationData(_offset, _length, _lineNumber, _endLineNumber, null);
          ITreeAppendable _trace_1 = appendable.trace(_locationData);
          _xifexpression_1 = _trace_1;
        } else {
          _xifexpression_1 = appendable;
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
