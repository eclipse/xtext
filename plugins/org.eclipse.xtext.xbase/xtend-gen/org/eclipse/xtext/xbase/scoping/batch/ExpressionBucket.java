/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Map;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
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
  private final int _id;
  
  public int getId() {
    return this._id;
  }
  
  private final Map<XExpression,LightweightTypeReference> _extensionProviders;
  
  public Map<XExpression,LightweightTypeReference> getExtensionProviders() {
    return this._extensionProviders;
  }
  
  private final IResolvedFeatures.Provider _resolvedFeaturesProvider;
  
  public IResolvedFeatures.Provider getResolvedFeaturesProvider() {
    return this._resolvedFeaturesProvider;
  }
  
  public ExpressionBucket(final int id, final Map<XExpression,LightweightTypeReference> extensionProviders, final IResolvedFeatures.Provider resolvedFeaturesProvider) {
    super();
    this._id = id;
    this._extensionProviders = extensionProviders;
    this._resolvedFeaturesProvider = resolvedFeaturesProvider;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _id;
    result = prime * result + ((_extensionProviders== null) ? 0 : _extensionProviders.hashCode());
    result = prime * result + ((_resolvedFeaturesProvider== null) ? 0 : _resolvedFeaturesProvider.hashCode());
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
    ExpressionBucket other = (ExpressionBucket) obj;
    if (other._id != _id)
      return false;
    if (_extensionProviders == null) {
      if (other._extensionProviders != null)
        return false;
    } else if (!_extensionProviders.equals(other._extensionProviders))
      return false;
    if (_resolvedFeaturesProvider == null) {
      if (other._resolvedFeaturesProvider != null)
        return false;
    } else if (!_resolvedFeaturesProvider.equals(other._resolvedFeaturesProvider))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
