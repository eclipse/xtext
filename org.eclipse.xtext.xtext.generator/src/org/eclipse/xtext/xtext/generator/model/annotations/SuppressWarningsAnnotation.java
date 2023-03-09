/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.annotations;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * A class annotation configuration for the <code>@SuppressWarnings</code>
 * annotation.
 */
public class SuppressWarningsAnnotation implements IClassAnnotation {
	private String suppress = "all";

	@Override
	public CharSequence generate() {
		StringBuilder stringBuilder = new StringBuilder("@SuppressWarnings(");
		String[] suppressedWarnings = suppress.split("\\s*,\\s*");
		if (suppressedWarnings.length != 1) {
			stringBuilder.append("{");
		}
		String value = Arrays.stream(suppressedWarnings).map((s)-> "\"" + s + "\"").collect(Collectors.joining( ", " ));
		stringBuilder.append(value);
		if (suppressedWarnings.length != 1) {
			stringBuilder.append("}");
		}
		stringBuilder.append(")");
		return stringBuilder;
	}

	@Override
	public boolean appliesTo(JavaFileAccess javaFile) {
		return true;
	}

	@Override
	public TypeReference getAnnotationImport() {
		return new TypeReference(SuppressWarnings.class);
	}

	@Override
	public String toString() {
		return generate().toString();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SuppressWarningsAnnotation;
	}

	@Override
	public int hashCode() {
		return getClass().getName().hashCode();
	}

	public String getSuppress() {
		return suppress;
	}

	public void setSuppress(String suppress) {
		this.suppress = suppress;
	}
}
