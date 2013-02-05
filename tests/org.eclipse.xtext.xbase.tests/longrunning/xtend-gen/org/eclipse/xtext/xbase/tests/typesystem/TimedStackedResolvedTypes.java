/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.typesystem.TimedExpressionAwareResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.TimedReassigningResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTimes;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TimedStackedResolvedTypes extends StackedResolvedTypes {
  private TypeResolutionTimes times;
  
  public TimedStackedResolvedTypes(final ResolvedTypes parent, final TypeResolutionTimes times) {
    super(parent);
    this.times = times;
  }
  
  public StackedResolvedTypes pushReassigningTypes() {
    TimedReassigningResolvedTypes _timedReassigningResolvedTypes = new TimedReassigningResolvedTypes(this, this.times);
    return _timedReassigningResolvedTypes;
  }
  
  public StackedResolvedTypes pushTypes() {
    TimedStackedResolvedTypes _timedStackedResolvedTypes = new TimedStackedResolvedTypes(this, this.times);
    return _timedStackedResolvedTypes;
  }
  
  public ExpressionAwareStackedResolvedTypes pushTypes(final XExpression context) {
    TimedExpressionAwareResolvedTypes _timedExpressionAwareResolvedTypes = new TimedExpressionAwareResolvedTypes(this, context, this.times);
    return _timedExpressionAwareResolvedTypes;
  }
  
  public IFeatureLinkingCandidate getFeature(final XAbstractFeatureCall featureCall) {
    IFeatureLinkingCandidate _xtrycatchfinallyexpression = null;
    try {
      IFeatureLinkingCandidate _xblockexpression = null;
      {
        this.times.getFeatureTask.start();
        IFeatureLinkingCandidate _feature = super.getFeature(featureCall);
        _xblockexpression = (_feature);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } finally {
      this.times.getFeatureTask.stop();
    }
    return _xtrycatchfinallyexpression;
  }
  
  public LightweightTypeReference getActualType(final JvmIdentifiableElement identifiable) {
    LightweightTypeReference _xtrycatchfinallyexpression = null;
    try {
      LightweightTypeReference _xblockexpression = null;
      {
        this.times.getActualTypeTask.start();
        LightweightTypeReference _actualType = super.getActualType(identifiable);
        _xblockexpression = (_actualType);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } finally {
      this.times.getActualTypeTask.stop();
    }
    return _xtrycatchfinallyexpression;
  }
  
  public LightweightTypeReference getActualType(final XExpression expression) {
    LightweightTypeReference _xtrycatchfinallyexpression = null;
    try {
      LightweightTypeReference _xblockexpression = null;
      {
        this.times.getActualExpressionTypeTask.start();
        LightweightTypeReference _actualType = super.getActualType(expression);
        _xblockexpression = (_actualType);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } finally {
      this.times.getActualExpressionTypeTask.stop();
    }
    return _xtrycatchfinallyexpression;
  }
  
  public List<LightweightBoundTypeArgument> getAllHints(final Object handle) {
    List<LightweightBoundTypeArgument> _xtrycatchfinallyexpression = null;
    try {
      List<LightweightBoundTypeArgument> _xblockexpression = null;
      {
        this.times.getHintsTask.start();
        List<LightweightBoundTypeArgument> _allHints = super.getAllHints(handle);
        _xblockexpression = (_allHints);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } finally {
      this.times.getHintsTask.stop();
    }
    return _xtrycatchfinallyexpression;
  }
}
