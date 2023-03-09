/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket that was produced from the synonym of a type. It tracks the
 * conformance flags for a synonym, e.g. boxing or unboxing information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SynonymTypeBucket extends TypeBucket {
	private final int flags;

	public SynonymTypeBucket(int id, List<? extends JvmType> types,
			IResolvedFeatures.Provider resolvedFeaturesProvider, int flags) {
		super(id, types, resolvedFeaturesProvider);
		this.flags = flags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + flags;
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
		SynonymTypeBucket other = (SynonymTypeBucket) obj;
		if (flags != other.flags)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).addAllFields().toString();
	}

	@Override
	public int getFlags() {
		return flags;
	}
}
