/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Map;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A type bucket collects a number of types that originate in the
 * very same source, e.g. all imported types are contained in the
 * same bucket where all types that are available via wildcard imports
 * are contained in a different bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class ExpressionBucket {
  private final int id;
  
  private final Map<XExpression, LightweightTypeReference> extensionProviders;
  
  private final IResolvedFeatures.Provider resolvedFeaturesProvider;
  
  public ExpressionBucket(final int id, final Map<XExpression, LightweightTypeReference> extensionProviders, final IResolvedFeatures.Provider resolvedFeaturesProvider) {
    super();
    this.id = id;
    this.extensionProviders = extensionProviders;
    this.resolvedFeaturesProvider = resolvedFeaturesProvider;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.id;
    result = prime * result + ((this.extensionProviders== null) ? 0 : this.extensionProviders.hashCode());
    return prime * result + ((this.resolvedFeaturesProvider== null) ? 0 : this.resolvedFeaturesProvider.hashCode());
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
    ExpressionBucket other = (ExpressionBucket) obj;
    if (other.id != this.id)
      return false;
    if (this.extensionProviders == null) {
      if (other.extensionProviders != null)
        return false;
    } else if (!this.extensionProviders.equals(other.extensionProviders))
      return false;
    if (this.resolvedFeaturesProvider == null) {
      if (other.resolvedFeaturesProvider != null)
        return false;
    } else if (!this.resolvedFeaturesProvider.equals(other.resolvedFeaturesProvider))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("id", this.id);
    b.add("extensionProviders", this.extensionProviders);
    b.add("resolvedFeaturesProvider", this.resolvedFeaturesProvider);
    return b.toString();
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  @Pure
  public Map<XExpression, LightweightTypeReference> getExtensionProviders() {
    return this.extensionProviders;
  }
  
  @Pure
  public IResolvedFeatures.Provider getResolvedFeaturesProvider() {
    return this.resolvedFeaturesProvider;
  }
}
