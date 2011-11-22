/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeErasedSignature {

	public static class Provider {
		
		@Inject
		private IRawTypeHelper rawTypeHelper;
		
		public TypeErasedSignature get(JvmExecutable executable) {
			return new TypeErasedSignature(executable, rawTypeHelper);
		}
	}

	private JvmExecutable executable;

	private List<JvmType> erasureParameterTypes;

	protected TypeErasedSignature(JvmExecutable executable, IRawTypeHelper rawTypeHelper) {
		this.executable = executable;
		if (executable != null) {
			erasureParameterTypes = Lists.newArrayListWithCapacity(executable.getParameters().size());
			for (JvmFormalParameter parameter : executable.getParameters()) {
				List<JvmType> rawTypes = rawTypeHelper.getAllRawTypes(parameter.getParameterType(),
						executable.eResource());
				if (rawTypes.isEmpty()) {
					erasureParameterTypes.add(null);
				} else {
					// see comments in https://bugs.eclipse.org/bugs/show_bug.cgi?id=357958
					erasureParameterTypes.add(rawTypes.get(0));
				}
			}
		} else {
			erasureParameterTypes = Collections.emptyList();
		}
	}

	public String getName() {
		if (executable == null)
			return "null";
		return executable.getSimpleName();
	}

	@Override
	public String toString() {
		if (executable == null)
			return "null";
		StringBuilder result = new StringBuilder(getName());
		result.append('(');
		boolean isFirst = true;
		for (JvmType parameterType: erasureParameterTypes) {
			if (!isFirst) {
				result.append(", ");
			}
			isFirst = false;
			if(parameterType != null)
				result.append(parameterType.getSimpleName());
			else 
				result.append("null");
		}
		result.append(')');
		return result.toString();
	}


	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (other instanceof TypeErasedSignature) {
			TypeErasedSignature otherSignature = (TypeErasedSignature) other;
			return (equal(getName(), otherSignature.getName()))
				&& erasureParameterTypes.equals(otherSignature.erasureParameterTypes);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getName() == null ? 0 : getName().hashCode() + 17 * erasureParameterTypes.hashCode();
	}

}