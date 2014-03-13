/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.interpreter;

import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Context {
  private final JvmTypeReference _expectedType;
  
  public JvmTypeReference getExpectedType() {
    return this._expectedType;
  }
  
  private final ClassFinder _classFinder;
  
  public ClassFinder getClassFinder() {
    return this._classFinder;
  }
  
  private final Map<String, JvmIdentifiableElement> _visibleFeatures;
  
  public Map<String, JvmIdentifiableElement> getVisibleFeatures() {
    return this._visibleFeatures;
  }
  
  private final Set<XExpression> _alreadyEvaluating;
  
  public Set<XExpression> getAlreadyEvaluating() {
    return this._alreadyEvaluating;
  }
  
  public Context cloneWithExpectation(final JvmTypeReference newExpectation) {
    ClassFinder _classFinder = this.getClassFinder();
    Map<String, JvmIdentifiableElement> _visibleFeatures = this.getVisibleFeatures();
    Set<XExpression> _alreadyEvaluating = this.getAlreadyEvaluating();
    return new Context(newExpectation, _classFinder, _visibleFeatures, _alreadyEvaluating);
  }
  
  public Context(final JvmTypeReference expectedType, final ClassFinder classFinder, final Map<String, JvmIdentifiableElement> visibleFeatures, final Set<XExpression> alreadyEvaluating) {
    super();
    this._expectedType = expectedType;
    this._classFinder = classFinder;
    this._visibleFeatures = visibleFeatures;
    this._alreadyEvaluating = alreadyEvaluating;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_expectedType== null) ? 0 : _expectedType.hashCode());
    result = prime * result + ((_classFinder== null) ? 0 : _classFinder.hashCode());
    result = prime * result + ((_visibleFeatures== null) ? 0 : _visibleFeatures.hashCode());
    result = prime * result + ((_alreadyEvaluating== null) ? 0 : _alreadyEvaluating.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Context other = (Context) obj;
    if (_expectedType == null) {
      if (other._expectedType != null)
        return false;
    } else if (!_expectedType.equals(other._expectedType))
      return false;
    if (_classFinder == null) {
      if (other._classFinder != null)
        return false;
    } else if (!_classFinder.equals(other._classFinder))
      return false;
    if (_visibleFeatures == null) {
      if (other._visibleFeatures != null)
        return false;
    } else if (!_visibleFeatures.equals(other._visibleFeatures))
      return false;
    if (_alreadyEvaluating == null) {
      if (other._alreadyEvaluating != null)
        return false;
    } else if (!_alreadyEvaluating.equals(other._alreadyEvaluating))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
