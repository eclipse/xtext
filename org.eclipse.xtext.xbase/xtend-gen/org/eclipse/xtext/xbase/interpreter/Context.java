/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Context {
  private final JvmTypeReference expectedType;
  
  private final ClassFinder classFinder;
  
  private final Map<String, JvmIdentifiableElement> visibleFeatures;
  
  private final Set<XExpression> alreadyEvaluating;
  
  public Context cloneWithExpectation(final JvmTypeReference newExpectation) {
    return new Context(newExpectation, this.classFinder, this.visibleFeatures, this.alreadyEvaluating);
  }
  
  public Context(final JvmTypeReference expectedType, final ClassFinder classFinder, final Map<String, JvmIdentifiableElement> visibleFeatures, final Set<XExpression> alreadyEvaluating) {
    super();
    this.expectedType = expectedType;
    this.classFinder = classFinder;
    this.visibleFeatures = visibleFeatures;
    this.alreadyEvaluating = alreadyEvaluating;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.expectedType== null) ? 0 : this.expectedType.hashCode());
    result = prime * result + ((this.classFinder== null) ? 0 : this.classFinder.hashCode());
    result = prime * result + ((this.visibleFeatures== null) ? 0 : this.visibleFeatures.hashCode());
    return prime * result + ((this.alreadyEvaluating== null) ? 0 : this.alreadyEvaluating.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Context other = (Context) obj;
    if (this.expectedType == null) {
      if (other.expectedType != null)
        return false;
    } else if (!this.expectedType.equals(other.expectedType))
      return false;
    if (this.classFinder == null) {
      if (other.classFinder != null)
        return false;
    } else if (!this.classFinder.equals(other.classFinder))
      return false;
    if (this.visibleFeatures == null) {
      if (other.visibleFeatures != null)
        return false;
    } else if (!this.visibleFeatures.equals(other.visibleFeatures))
      return false;
    if (this.alreadyEvaluating == null) {
      if (other.alreadyEvaluating != null)
        return false;
    } else if (!this.alreadyEvaluating.equals(other.alreadyEvaluating))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("expectedType", this.expectedType);
    b.add("classFinder", this.classFinder);
    b.add("visibleFeatures", this.visibleFeatures);
    b.add("alreadyEvaluating", this.alreadyEvaluating);
    return b.toString();
  }
  
  @Pure
  public JvmTypeReference getExpectedType() {
    return this.expectedType;
  }
  
  @Pure
  public ClassFinder getClassFinder() {
    return this.classFinder;
  }
  
  @Pure
  public Map<String, JvmIdentifiableElement> getVisibleFeatures() {
    return this.visibleFeatures;
  }
  
  @Pure
  public Set<XExpression> getAlreadyEvaluating() {
    return this.alreadyEvaluating;
  }
}
