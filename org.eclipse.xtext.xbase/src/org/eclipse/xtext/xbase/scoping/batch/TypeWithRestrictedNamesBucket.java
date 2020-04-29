/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket that 'exports' only a subset of all named features of the
 * contained types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeWithRestrictedNamesBucket extends TypeBucket {
	private final Map<? extends JvmType, ? extends Set<String>> typesToNames;

	public TypeWithRestrictedNamesBucket(int id, Map<? extends JvmType, ? extends Set<String>> types,
			IResolvedFeatures.Provider resolvedFeaturesProvider) {
		super(id, null, resolvedFeaturesProvider);
		this.typesToNames = types;
	}

	@Override
	public boolean isRestrictingNames() {
		return true;
	}

	@Override
	public List<? extends JvmType> getTypes() {
		return new ArrayList<JvmType>(typesToNames.keySet());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((typesToNames == null) ? 0 : typesToNames.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeWithRestrictedNamesBucket other = (TypeWithRestrictedNamesBucket) obj;
		if (typesToNames == null) {
			if (other.typesToNames != null)
				return false;
		} else if (!typesToNames.equals(other.typesToNames))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).addAllFields().toString();
	}

	@Override
	public Map<? extends JvmType, ? extends Set<String>> getTypesToNames() {
		return typesToNames;
	}
}
