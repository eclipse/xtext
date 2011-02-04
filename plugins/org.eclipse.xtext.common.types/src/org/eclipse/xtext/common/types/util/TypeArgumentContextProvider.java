/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

public class TypeArgumentContextProvider {
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private TypeReferences typeReferences;
	
	public void setTypeProviderFactory(IJvmTypeProvider.Factory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}
	
	public void setTypeReferences(TypeReferences typeReferences) {
		this.typeReferences = typeReferences;
	}
	 
	public final TypeArgumentContext getNullContext() {
		return get(Collections.<JvmTypeParameter,JvmTypeReference>emptyMap());
	}
	
	public TypeArgumentContext get(Map<JvmTypeParameter,JvmTypeReference> context) {
		final Map<JvmTypeParameter, JvmTypeReference> resolved = resolveTypeParametersReferencedInTypeParameters(context);
		return new TypeArgumentContext(resolved, typeProviderFactory, typeReferences);
	}
	
	public TypeArgumentContext getReceiverContext(JvmTypeReference receiver) {
		Map<JvmTypeParameter, JvmTypeReference> map = resolveReceiver(receiver);
		return get(map);
	}
	
	public TypeArgumentContext getInferredMethodInvocationContext(JvmOperation op, JvmTypeReference receiverType, JvmTypeReference expectedReturnType, JvmTypeReference ... actualArgumentTypes) {
		Map<JvmTypeParameter, JvmTypeReference> map = newHashMap();
		if (receiverType!=null) {
			map.putAll(resolveReceiver(receiverType));
		}
		map.putAll(resolveInferredMethodTypeArgContext(op, expectedReturnType, actualArgumentTypes));
		return get(map);
	}
	
	
	public Map<JvmTypeParameter, JvmTypeReference> resolveTypeParametersReferencedInTypeParameters(Map<JvmTypeParameter, JvmTypeReference> context) {
		Map<JvmTypeParameter, JvmTypeReference> result = newHashMap(context);
		for (Entry<JvmTypeParameter, JvmTypeReference> entry : context.entrySet()) {
			EList<JvmTypeConstraint> constraints = entry.getKey().getConstraints();
			if (!constraints.isEmpty()) {
				resolve(entry.getKey(),entry.getValue(),result);
			}
		}
		return result;
	}
	
	public Map<JvmTypeParameter,JvmTypeReference> resolveReceiver(JvmTypeReference contextRef) {
		if (contextRef==null)
			throw new NullPointerException("contextReference");
		if (contextRef.getType() instanceof JvmPrimitiveType) {
			return emptyMap();
		}
		Map<JvmTypeParameter, JvmTypeReference> context = Maps.newHashMap();
		internalComputeContext(contextRef, context);
		return context;
	}
	
	public Map<JvmTypeParameter,JvmTypeReference> resolveInferredMethodTypeArgContext(JvmFeature feature, JvmTypeReference expectation, JvmTypeReference... argumentTypes) {
		Map<JvmTypeParameter, JvmTypeReference> map = newHashMap();
		if (feature instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) feature;
			// check arguments
			for (int i = 0; i < argumentTypes.length; i++) {
				JvmTypeReference actualArgumentType = argumentTypes[i];
				final JvmTypeReference declaredArgumentType = op.getParameters().get(i).getParameterType();
				if (actualArgumentType != null) {
					resolve(declaredArgumentType,actualArgumentType,map);
				}
			}
			//try infer from the context type
			if (expectation != null) {
				resolve(op.getReturnType(),expectation, map);
			}
		}
		return map;
	}

	protected void internalComputeContext(JvmTypeReference contextRef, Map<JvmTypeParameter, JvmTypeReference> context) {
		if (contextRef instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference typeRef = (JvmParameterizedTypeReference) contextRef;
			if (typeRef.getType() instanceof JvmTypeParameterDeclarator) {
				List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) typeRef.getType()).getTypeParameters();
				List<JvmTypeReference> typeArguments = typeRef.getArguments();
				if (!typeArguments.isEmpty()) {
					// parameterized type reference
					for (int i = 0; i < typeArguments.size(); i++) {
						JvmTypeReference argument = typeArguments.get(i);
						JvmTypeParameter param = typeParameters.get(i);
						context.put(param, argument);
					}
				}
			}
		}
		JvmType type = contextRef.getType();
		if (type instanceof JvmDeclaredType) {
			JvmDeclaredType declaredType = (JvmDeclaredType) type;
			List<JvmTypeReference> superTypes = declaredType.getSuperTypes();
			if (superTypes.isEmpty())
				return;
			for (JvmTypeReference jvmTypeReference : superTypes) {
				internalComputeContext(jvmTypeReference, context);
			}
		}
	}
	
	protected void resolve(JvmTypeReference declaration, JvmTypeReference information, Map<JvmTypeParameter, JvmTypeReference> existing) {
		if (declaration.getType() instanceof JvmTypeParameter) {
			final JvmTypeParameter typeParam = (JvmTypeParameter) declaration.getType();
			if (!existing.containsKey(typeParam)) {
				existing.put(typeParam, information);
				resolve(typeParam,information, existing);
			}
		}
		if (declaration instanceof JvmParameterizedTypeReference
				&& information instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference declaration2 = (JvmParameterizedTypeReference) declaration;
			JvmParameterizedTypeReference information2 = (JvmParameterizedTypeReference) information;
			EList<JvmTypeReference> declArgs = declaration2.getArguments();
			EList<JvmTypeReference> infoArgs = information2.getArguments();
			for (int i = 0; i < declArgs.size() && i < infoArgs.size(); i++) {
				resolve(declArgs.get(i), infoArgs.get(i), existing);
			}
		}
	}
	
	protected void resolve(JvmTypeParameter key, JvmTypeReference value, Map<JvmTypeParameter, JvmTypeReference> existing) {
		for (JvmTypeConstraint constrain : key.getConstraints()) {
			JvmTypeReference reference = constrain.getTypeReference();
			resolve(reference,value,existing);
		}
	}

}