/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler;

import java.lang.reflect.Field;
import java.util.Objects;

import org.eclipse.jdt.internal.core.builder.ReferenceCollection;

class AccessibleReferenceCollection extends ReferenceCollection {

	/*
	 * Use reflection to access the fields since the passed values (the ones
	 * passed on to super()) are interned in the super classes' constructor.
	 * Keeping the values that "we" receive would be wrong.
	 */
	static final Field fldQualifiedNameReferences = fld("qualifiedNameReferences");
	static final Field fldSimpleNameReferences = fld("simpleNameReferences");
	static final Field fldRootReferences = fld("rootReferences");

	static Field fld(String name) {
		try {
			Field result = ReferenceCollection.class.getDeclaredField(name);
			result.setAccessible(true);
			return result;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	AccessibleReferenceCollection(char[][][] qualifiedNameReferences, char[][] simpleNameReferences,
			char[][] rootReferences) {
		super(qualifiedNameReferences, simpleNameReferences, rootReferences);
	}

	char[][][] qualifiedNameReferences() {
		try {
			return (char[][][]) fldQualifiedNameReferences.get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException();
		}
	}

	char[][] simpleNameReferences() {
		try {
			return (char[][]) fldSimpleNameReferences.get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException();
		}
	}

	char[][] rootReferences() {
		try {
			return (char[][]) fldRootReferences.get(this);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AccessibleReferenceCollection) {
			AccessibleReferenceCollection other = (AccessibleReferenceCollection) obj;
			return Objects.deepEquals(qualifiedNameReferences(), other.qualifiedNameReferences())
					&& Objects.deepEquals(simpleNameReferences(), other.simpleNameReferences())
					&& Objects.deepEquals(rootReferences(), other.rootReferences());
		}
		return false;
	}

}