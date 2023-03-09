/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Small utility data structure to carry around in the type reference visitors.
 * May help to guard against infinite recursion and to collect type parameter
 * data.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LightweightTraversalData {
	private final Set<JvmType> visited = new HashSet<>();

	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = new LinkedHashMap<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeParameterMapping == null) ? 0 : typeParameterMapping.hashCode());
		result = prime * result + ((visited == null) ? 0 : visited.hashCode());
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
		LightweightTraversalData other = (LightweightTraversalData) obj;
		if (typeParameterMapping == null) {
			if (other.typeParameterMapping != null)
				return false;
		} else if (!typeParameterMapping.equals(other.typeParameterMapping))
			return false;
		if (visited == null) {
			if (other.visited != null)
				return false;
		} else if (!visited.equals(other.visited))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("visited", visited);
		b.add("typeParameterMapping", typeParameterMapping);
		return b.toString();
	}

	public Set<JvmType> getVisited() {
		return visited;
	}

	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}
}
