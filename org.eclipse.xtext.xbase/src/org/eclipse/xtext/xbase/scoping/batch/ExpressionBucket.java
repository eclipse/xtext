/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Map;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A type bucket collects a number of types that originate in the very same
 * source, e.g. all imported types are contained in the same bucket where all
 * types that are available via wildcard imports are contained in a different
 * bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExpressionBucket {
	private final int id;

	private final Map<XExpression, LightweightTypeReference> extensionProviders;

	private final IResolvedFeatures.Provider resolvedFeaturesProvider;

	public ExpressionBucket(int id, Map<XExpression, LightweightTypeReference> extensionProviders,
			final IResolvedFeatures.Provider resolvedFeaturesProvider) {
		this.id = id;
		this.extensionProviders = extensionProviders;
		this.resolvedFeaturesProvider = resolvedFeaturesProvider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extensionProviders == null) ? 0 : extensionProviders.hashCode());
		result = prime * result + id;
		result = prime * result + ((resolvedFeaturesProvider == null) ? 0 : resolvedFeaturesProvider.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpressionBucket other = (ExpressionBucket) obj;
		if (extensionProviders == null) {
			if (other.extensionProviders != null)
				return false;
		} else if (!extensionProviders.equals(other.extensionProviders))
			return false;
		if (id != other.id)
			return false;
		if (resolvedFeaturesProvider == null) {
			if (other.resolvedFeaturesProvider != null)
				return false;
		} else if (!resolvedFeaturesProvider.equals(other.resolvedFeaturesProvider))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("id", id);
		b.add("extensionProviders", extensionProviders);
		b.add("resolvedFeaturesProvider", resolvedFeaturesProvider);
		return b.toString();
	}

	public int getId() {
		return id;
	}

	public Map<XExpression, LightweightTypeReference> getExtensionProviders() {
		return extensionProviders;
	}

	public IResolvedFeatures.Provider getResolvedFeaturesProvider() {
		return resolvedFeaturesProvider;
	}
}
