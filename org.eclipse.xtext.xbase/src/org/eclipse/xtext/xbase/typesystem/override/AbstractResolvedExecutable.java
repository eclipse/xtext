/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * Base class for resolved representation of a {@link JvmExecutable}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractResolvedExecutable<T extends JvmExecutable> extends AbstractResolvedFeature<T> implements IResolvedExecutable {

	private List<LightweightTypeReference> parameterTypes;
	private List<LightweightTypeReference> declaredExceptions;
	
	protected AbstractResolvedExecutable(T declaration, LightweightTypeReference contextType) {
		super(declaration, contextType);
	}
	
	@Override
	public List<JvmTypeParameter> getTypeParameters() {
		return Collections.unmodifiableList(getDeclaration().getTypeParameters());
	}
	
	@Override
	public List<LightweightTypeReference> getResolvedParameterTypes() {
		JvmExecutable declaration = getDeclaration();
		if (declaration.getParameters().isEmpty())
			return Collections.emptyList();
		if (parameterTypes != null)
			return parameterTypes;
		List<JvmFormalParameter> parameters = declaration.getParameters();
		List<JvmTypeReference> unresolvedParameterTypes = Lists.newArrayListWithCapacity(parameters.size());
		for(JvmFormalParameter parameter: parameters) {
			unresolvedParameterTypes.add(parameter.getParameterType());
		}
		return parameterTypes = getResolvedReferences(unresolvedParameterTypes);
	}
	
	@Override
	public String getResolvedErasureSignature() {
		JvmExecutable declaration = getDeclaration();
		List<LightweightTypeReference> parameterTypes = getResolvedParameterTypes();
		StringBuilder result = new StringBuilder(declaration.getSimpleName().length() + 2 + 20 * parameterTypes.size());
		result.append(declaration.getSimpleName());
		result.append('(');
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(',');
			}
			result.append(parameterTypes.get(i).getRawTypeReference().getJavaIdentifier());
		}
		result.append(')');
		return result.toString();
	}
	
	@Override
	public String getResolvedSignature() {
		JvmExecutable declaration = getDeclaration();
		List<LightweightTypeReference> parameterTypes = getResolvedParameterTypes();
		StringBuilder result = new StringBuilder(declaration.getSimpleName().length() + 2 + 30 * parameterTypes.size());
		result.append(declaration.getSimpleName());
		result.append('(');
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(',');
			}
			result.append(parameterTypes.get(i).getJavaIdentifier());
		}
		result.append(')');
		return result.toString();
	}
	
	@Override
	public String getSimpleSignature() {
		JvmExecutable declaration = getDeclaration();
		List<LightweightTypeReference> parameterTypes = getResolvedParameterTypes();
		StringBuilder result = new StringBuilder(declaration.getSimpleName().length() + 2 + 10 * parameterTypes.size());
		result.append(declaration.getSimpleName());
		result.append('(');
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(", ");
			}
			result.append(parameterTypes.get(i).getSimpleName());
		}
		result.append(')');
		return result.toString();
	}
	
	
	@Override
	public List<LightweightTypeReference> getResolvedExceptions() {
		JvmExecutable declaration = getDeclaration();
		if (declaration.getExceptions().isEmpty())
			return Collections.emptyList();
		if (declaredExceptions != null)
			return declaredExceptions;
		return declaredExceptions = getResolvedReferences(declaration.getExceptions());
	}
	
	@Override
	public String toString() {
		return String.format("%s in context of %s", getDeclaration().getIdentifier(), getContextType().getSimpleName());
	}
}
