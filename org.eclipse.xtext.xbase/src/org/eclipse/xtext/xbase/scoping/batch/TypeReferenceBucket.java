/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A type bucket collects a number of types that originate in the very same
 * source, e.g. all implicit receiver types are contained in the very same
 * bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeReferenceBucket {
	private final int id;

	private final List<JvmTypeReference> types;

	public TypeReferenceBucket(int id, List<JvmTypeReference> types) {
		this.id = id;
		this.types = types;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		TypeReferenceBucket other = (TypeReferenceBucket) obj;
		if (id != other.id)
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
		return b.toString();
	}

	public int getId() {
		return id;
	}

	public List<JvmTypeReference> getTypes() {
		return types;
	}
}
