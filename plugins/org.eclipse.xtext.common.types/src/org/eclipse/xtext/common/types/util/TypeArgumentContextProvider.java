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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
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
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Inject;

public class TypeArgumentContextProvider {
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypeConformanceComputer conformanceComputer;
	
	public void setTypeProviderFactory(IJvmTypeProvider.Factory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}
	
	public void setTypeReferences(TypeReferences typeReferences) {
		this.typeReferences = typeReferences;
	}
	
	public void setConformanceComputer(TypeConformanceComputer conformanceComputer) {
		this.conformanceComputer = conformanceComputer;
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
	
	public TypeArgumentContext getExplicitMethodInvocationContext(JvmOperation operation, JvmTypeReference receiverType,
			List<JvmTypeReference> typeArguments) {
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		if (receiverType!=null) {
			map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		}
		Map<JvmTypeParameter, JvmTypeReference> explicitArguments = Maps.newHashMap();
		List<JvmTypeParameter> typeParameters = operation.getTypeParameters();
		int max = Math.min(typeParameters.size(), typeArguments.size());
		for(int i = 0; i < max; i++) {
			explicitArguments.put(typeParameters.get(i), typeArguments.get(i));
		}
		map.putAll(Multimaps.forMap(resolveTypeParametersReferencedInTypeParameters(explicitArguments)));
		Map<JvmTypeParameter, JvmTypeReference> result = findBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext getInferredMethodInvocationContext(JvmOperation op, JvmTypeReference receiverType, JvmTypeReference expectedReturnType, JvmTypeReference ... actualArgumentTypes) {
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		if (receiverType!=null) {
			map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		}
		map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(op, expectedReturnType, actualArgumentTypes)));
		Map<JvmTypeParameter, JvmTypeReference> result = findBestMatches(map);
		return get(result);
	}
	
	
	public Map<JvmTypeParameter, JvmTypeReference> resolveTypeParametersReferencedInTypeParameters(Map<JvmTypeParameter, JvmTypeReference> context) {
		Multimap<JvmTypeParameter, JvmTypeReference> result = LinkedHashMultimap.create(Multimaps.forMap(context));
		for (Entry<JvmTypeParameter, JvmTypeReference> entry : context.entrySet()) {
			EList<JvmTypeConstraint> constraints = entry.getKey().getConstraints();
			if (!constraints.isEmpty()) {
				resolve(entry.getKey(),entry.getValue(),result);
			}
		}
		return findBestMatches(result);
	}
	
	public Map<JvmTypeParameter,JvmTypeReference> resolveReceiver(JvmTypeReference contextRef) {
		if (contextRef==null || contextRef.getType() instanceof JvmPrimitiveType) {
			return emptyMap();
		}
		Multimap<JvmTypeParameter, JvmTypeReference> context = LinkedHashMultimap.create();
		internalComputeContext(contextRef, context);
		return findBestMatches(context);
	}
	
	public Map<JvmTypeParameter,JvmTypeReference> resolveInferredMethodTypeArgContext(JvmFeature feature, JvmTypeReference expectation, JvmTypeReference... argumentTypes) {
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		if (feature instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) feature;
			// check arguments
			int paramCount = op.getParameters().size();
			if (op.isVarArgs()) {
				paramCount--;
			}
			for (int i = 0; i < paramCount && i < argumentTypes.length; i++) {
				JvmTypeReference actualArgumentType = argumentTypes[i];
				if (actualArgumentType != null) {
					final JvmTypeReference declaredParameterType = op.getParameters().get(i).getParameterType();
					resolve(declaredParameterType, actualArgumentType, map);
				}
			}
			if (op.isVarArgs()) {
				JvmTypeReference parameterType = op.getParameters().get(paramCount).getParameterType();
				if (!(parameterType.getType() instanceof JvmArrayType)) {
					throw new IllegalStateException("VarArg methods expect last paramter to be an array type");
				}
				JvmTypeReference componentType = ((JvmArrayType) parameterType.getType()).getComponentType();
				List<JvmTypeReference> varArgTypes = Lists.newArrayList(Iterables.filter(
						Arrays.asList(argumentTypes).subList(paramCount, argumentTypes.length), Predicates.notNull()));
				if (!varArgTypes.isEmpty()) {
					JvmTypeReference commonVarArgType = conformanceComputer.getCommonSuperType(varArgTypes);
					resolve(componentType, commonVarArgType, map);
				} else {
					if (componentType.getType() instanceof JvmConstraintOwner) {
						List<JvmTypeReference> allUpperBounds = Lists.newArrayList();
						for(JvmTypeConstraint constraint: ((JvmConstraintOwner) componentType.getType()).getConstraints()) {
							if (constraint instanceof JvmUpperBound) {
								allUpperBounds.add(constraint.getTypeReference());
							}
						}
						if (allUpperBounds.isEmpty()) {
							JvmTypeReference objectType = typeReferences.getTypeForName(Object.class, feature);
							resolve(componentType, objectType, map);
						} else {
							JvmTypeReference upperBound = conformanceComputer.getCommonSuperType(allUpperBounds);
							resolve(componentType, upperBound, map);
						}
					} else {
						JvmTypeReference objectType = typeReferences.getTypeForName(Object.class, feature);
						resolve(componentType, objectType, map);
					}
				}
			}
			//try infer from the context type
			if (expectation != null) {
				resolve(op.getReturnType(), expectation, map);
			}
		}
		return findBestMatches(map);
	}

	protected Map<JvmTypeParameter, JvmTypeReference> findBestMatches(Multimap<JvmTypeParameter, JvmTypeReference> map) {
		Map<JvmTypeParameter, JvmTypeReference> result = newHashMap();
		for (JvmTypeParameter param : map.keySet()) {
			Collection<JvmTypeReference> references = map.get(param);
			for (JvmTypeReference jvmTypeReference : references) {
				if (result.containsKey(param)) {
					JvmTypeReference currentBestMatch = result.get(param);
					if (isBetterMatch(currentBestMatch, jvmTypeReference)) {
						result.put(param, jvmTypeReference);
					}
				} else {
					result.put(param, jvmTypeReference);
				}
			}
		}
		return result;
	}

	protected boolean isBetterMatch(JvmTypeReference current, JvmTypeReference isBetter) {
		if (!isResolved(current)) {
			return isResolved(isBetter);
		}
		if (typeReferences.is(current, Void.class)) {
			if (typeReferences.is(isBetter, Void.class))
				return false;
			return true;
		}
		if (isResolved(isBetter) && !EcoreUtil.equals(current, isBetter)) {
			return this.conformanceComputer.isConformant(current, isBetter);
		}
		return false;
	}

	//TODO improve
	protected boolean isResolved(JvmTypeReference type) {
		if (type.getType() instanceof JvmTypeParameter) {
			return false;
		}
		if (type instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcard = (JvmWildcardTypeReference) type;
			if (wildcard.getConstraints().isEmpty())
				return false;
			for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
				if (!isResolved(constraint.getTypeReference()))
					return false;
			}
			return true;
		}
		return true;
	}

	protected void internalComputeContext(JvmTypeReference contextRef, Multimap<JvmTypeParameter, JvmTypeReference> context) {
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
	
	protected void resolve(JvmTypeReference declaration, JvmTypeReference information, Multimap<JvmTypeParameter, JvmTypeReference> existing) {
		JvmTypeParameter typeParameter = getReferenceTypeParameter(declaration);
		if (typeParameter != null) {
			if (!containsEntry(existing, typeParameter, information)) {
				existing.put(typeParameter, information);
				resolve(typeParameter, information, existing);
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

	protected boolean containsEntry(Multimap<JvmTypeParameter, JvmTypeReference> existing,
			JvmTypeParameter typeParameter, JvmTypeReference information) {
		if (existing.containsKey(typeParameter)) {
			Collection<JvmTypeReference> collection = existing.get(typeParameter);
			for (JvmTypeReference jvmTypeReference : collection) {
				if (EcoreUtil.equals(jvmTypeReference, information)) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	protected JvmTypeParameter getReferenceTypeParameter(JvmTypeReference ref) {
		if (ref == null)
			return null;
		if (ref.getType() instanceof JvmTypeParameter) {
			return (JvmTypeParameter) ref.getType();
		}
		if (ref instanceof JvmWildcardTypeReference) {
			EList<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) ref).getConstraints();
			for (JvmTypeConstraint constraint : constraints) {
				if(constraint.getTypeReference().getType() instanceof JvmTypeParameter)
					return (JvmTypeParameter) constraint.getTypeReference().getType();
			}
		}
		return null;
	}
	
	protected void resolve(JvmTypeParameter key, JvmTypeReference value, Multimap<JvmTypeParameter, JvmTypeReference> existing) {
		for (JvmTypeConstraint constrain : key.getConstraints()) {
			JvmTypeReference reference = constrain.getTypeReference();
			resolve(reference,value,existing);
		}
	}

}