/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.serializer.ISerializationContext;

public class NamedSerializationContexts<T> {
	private final String name;

	private final EClass type;

	private final List<ISerializationContext> contexts;

	private final T value;

	public NamedSerializationContexts(String name, EClass type, List<ISerializationContext> contexts, T value) {
		this.name = name;
		this.type = type;
		this.contexts = contexts;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public EClass getType() {
		return type;
	}

	public List<ISerializationContext> getContexts() {
		return contexts;
	}

	public T getValue() {
		return value;
	}
}
