/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.controlflow;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.base.Optional;

public class BooleanResult implements IConstantEvaluationResult<Boolean> {
	private final Boolean value;

	private final boolean compileTimeConstant;

	@Override
	public Optional<Boolean> getValue() {
		return Optional.fromNullable(value);
	}

	public BooleanResult(Boolean value, boolean compileTimeConstant) {
		this.value = value;
		this.compileTimeConstant = compileTimeConstant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (compileTimeConstant ? 1231 : 1237);
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		BooleanResult other = (BooleanResult) obj;
		if (compileTimeConstant != other.compileTimeConstant)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("value", value);
		b.add("compileTimeConstant", compileTimeConstant);
		return b.toString();
	}

	public boolean isCompileTimeConstant() {
		return compileTimeConstant;
	}
}
