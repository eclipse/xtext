/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.descriptions;

import java.util.List;
import java.util.Objects;

import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.base.Splitter;

public class ClasspathTypeDescriptor implements ITypeDescriptor {
	private static final Splitter PACKAGE_AND_NESTED_CLASS_SPLITTER = Splitter.onPattern("\\.|\\$");

	private final String name;
	private final int modifiers;

	public ClasspathTypeDescriptor(String name, int modifiers) {
		this.name = name;
		this.modifiers = modifiers;
	}

	@Override
	public String getSimpleName() {
		return getQualifiedName().getLastSegment();
	}

	@Override
	public QualifiedName getQualifiedName() {
		List<String> segments = ClasspathTypeDescriptor.PACKAGE_AND_NESTED_CLASS_SPLITTER.splitToList(name);
		return QualifiedName.create(segments);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getModifiers() {
		return modifiers;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ClasspathTypeDescriptor other = (ClasspathTypeDescriptor) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (other.modifiers != modifiers) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, modifiers);
	}

}
