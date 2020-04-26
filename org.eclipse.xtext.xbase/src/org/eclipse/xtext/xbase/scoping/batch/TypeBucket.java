/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket collects a number of types that originate in the very same
 * source, e.g. all imported types are contained in the same bucket where all
 * types that are available via wildcard imports are contained in a different
 * bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeBucket {
	private final int id;

	private final List<? extends JvmType> types;

	private final IResolvedFeatures.Provider resolvedFeaturesProvider;

	public int getFlags() {
		return ConformanceFlags.CHECKED_SUCCESS;
	}

	public Map<? extends JvmType, ? extends Set<String>> getTypesToNames() {
		return Collections.emptyMap();
	}

	public boolean isRestrictingNames() {
		return false;
	}

	public TypeBucket(int id, List<? extends JvmType> types, IResolvedFeatures.Provider resolvedFeaturesProvider) {
		this.id = id;
		this.types = types;
		this.resolvedFeaturesProvider = resolvedFeaturesProvider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((resolvedFeaturesProvider == null) ? 0 : resolvedFeaturesProvider.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		TypeBucket other = (TypeBucket) obj;
		if (id != other.id)
			return false;
		if (resolvedFeaturesProvider == null) {
			if (other.resolvedFeaturesProvider != null)
				return false;
		} else if (!resolvedFeaturesProvider.equals(other.resolvedFeaturesProvider))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("id", id);
		b.add("types", types);
		b.add("resolvedFeaturesProvider", resolvedFeaturesProvider);
		return b.toString();
	}

	public int getId() {
		return id;
	}

	public List<? extends JvmType> getTypes() {
		return types;
	}

	public IResolvedFeatures.Provider getResolvedFeaturesProvider() {
		return resolvedFeaturesProvider;
	}
}
