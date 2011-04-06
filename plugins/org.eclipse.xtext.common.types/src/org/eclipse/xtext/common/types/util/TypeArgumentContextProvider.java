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
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
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
	
	@Inject
	private Primitives primitives;
	
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
		final Map<JvmTypeParameter, JvmTypeReference> resolved = resolveTypeParametersReferencedInTypeParameters(context, false);
		return new TypeArgumentContext(resolved, typeProviderFactory, typeReferences);
	}
	
	public TypeArgumentContext getReceiverContext(JvmTypeReference receiver) {
		Map<JvmTypeParameter, JvmTypeReference> map = resolveReceiver(receiver);
		return get(map);
	}
	
	public TypeArgumentContext getReceiverContext(JvmTypeReference receiverType, JvmTypeReference featureType, JvmTypeReference expectedType) {
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		if (receiverType!=null) {
			map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		}
		map.putAll(Multimaps.forMap(resolveInferredTypeArgContext(featureType, expectedType, false)));
		Map<JvmTypeParameter, JvmTypeReference> result = findBestMatches(map);
		return get(result);
	}
	
	protected Map<JvmTypeParameter,JvmTypeReference> resolveInferredTypeArgContext(JvmTypeReference featureType, JvmTypeReference expectation, 
			boolean ignoreOperationTypeParameters) {
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		if (expectation != null) {
			resolve(featureType, expectation, map, ignoreOperationTypeParameters);
		}
		return findBestMatches(map);
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
		map.putAll(Multimaps.forMap(resolveTypeParametersReferencedInTypeParameters(explicitArguments, false)));
		Map<JvmTypeParameter, JvmTypeReference> result = findBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectReceiverContext(TypeArgumentContext context, JvmTypeReference receiverType) {
		if (receiverType == null)
			return context;
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveReceiver(receiverType)));
		Map<JvmTypeParameter, JvmTypeReference> result = findBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectArgumentTypeContext(TypeArgumentContext context, JvmOperation operation, boolean ignoreEmptyVarArgs, JvmTypeReference ... actualArgumentTypes) {
		if (actualArgumentTypes.length == 0 && (!operation.isVarArgs() || ignoreEmptyVarArgs))
			return context;
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(operation, null, ignoreEmptyVarArgs, actualArgumentTypes)));
		Map<JvmTypeParameter, JvmTypeReference> result = findBestMatches(map);
		return get(result);
	}
	
	public TypeArgumentContext injectExpectedTypeContext(TypeArgumentContext context, JvmOperation operation, JvmTypeReference expectedType) {
		if (expectedType == null)
			return context;
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		map.putAll(Multimaps.forMap(context.getContextMap()));
		map.putAll(Multimaps.forMap(resolveInferredMethodTypeArgContext(operation, expectedType, (JvmTypeReference[]) null)));
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
	
	protected Map<JvmTypeParameter, JvmTypeReference> resolveTypeParametersReferencedInTypeParameters(Map<JvmTypeParameter, JvmTypeReference> context, boolean ignoreOperationArguments) {
		Multimap<JvmTypeParameter, JvmTypeReference> result = LinkedHashMultimap.create(Multimaps.forMap(context));
		for (Entry<JvmTypeParameter, JvmTypeReference> entry : context.entrySet()) {
			EList<JvmTypeConstraint> constraints = entry.getKey().getConstraints();
			if (!constraints.isEmpty()) {
				resolve(entry.getKey(),entry.getValue(),result, ignoreOperationArguments);
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
		return resolveInferredMethodTypeArgContext(feature, expectation, false, argumentTypes);
	}
	
	public Map<JvmTypeParameter,JvmTypeReference> resolveInferredMethodTypeArgContext(JvmFeature feature, JvmTypeReference expectation, boolean ignoreEmptyVarArgs, JvmTypeReference... argumentTypes) {
		Multimap<JvmTypeParameter, JvmTypeReference> map = LinkedHashMultimap.create();
		if (feature instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) feature;
			if (argumentTypes != null) {
				// check arguments
				int paramCount = op.getParameters().size();
				if (op.isVarArgs()) {
					paramCount--;
				}
				for (int i = 0; i < paramCount && i < argumentTypes.length; i++) {
					JvmTypeReference actualArgumentType = argumentTypes[i];
					if (actualArgumentType != null) {
						final JvmTypeReference declaredParameterType = op.getParameters().get(i).getParameterType();
						resolve(declaredParameterType, actualArgumentType, map, false);
					}
				}
				if (op.isVarArgs()) {
					JvmTypeReference parameterType = op.getParameters().get(paramCount).getParameterType();
					if (!(parameterType.getType() instanceof JvmArrayType)) {
						throw new IllegalStateException("VarArg methods expect last paramter to be an array type");
					}
					JvmTypeReference componentType = ((JvmArrayType) parameterType.getType()).getComponentType();
					List<JvmTypeReference> varArgTypes = emptyList();
					if (paramCount<= argumentTypes.length) {
						varArgTypes = Lists.newArrayList(Iterables.filter(
							Arrays.asList(argumentTypes).subList(paramCount, argumentTypes.length), Predicates.notNull()));
					}
					if (!varArgTypes.isEmpty()) {
						// TODO remove workaround when https://bugs.eclipse.org/bugs/show_bug.cgi?id=342021 is fixed
						if (!primitives.isPrimitive(componentType)) {
							for(int i = 0; i < varArgTypes.size(); i++) {
								varArgTypes.set(i, primitives.asWrapperTypeIfPrimitive(varArgTypes.get(i)));
							}
						}
						JvmTypeReference commonVarArgType = conformanceComputer.getCommonSuperType(varArgTypes);
						resolve(componentType, commonVarArgType, map, false);
					} else if (!ignoreEmptyVarArgs) {
						JvmTypeReference information = computeVarArgTypeInformation(feature, componentType.getType());
						resolve(componentType, information, map, false);
					}
				}
			}
			//try infer from the context type
			if (expectation != null) {
				resolve(op.getReturnType(), expectation, map, true);
			}
		}
		return findBestMatches(map);
	}

	protected JvmTypeReference computeVarArgTypeInformation(JvmFeature feature, JvmType type) {
		if (type instanceof JvmConstraintOwner) {
			List<JvmTypeReference> allUpperBounds = Lists.newArrayList();
			for(JvmTypeConstraint constraint: ((JvmConstraintOwner) type).getConstraints()) {
				if (constraint instanceof JvmUpperBound) {
					allUpperBounds.add(constraint.getTypeReference());
				}
			}
			if (allUpperBounds.isEmpty()) {
				JvmTypeReference objectType = typeReferences.getTypeForName(Object.class, feature);
				return objectType;
			} else {
				JvmTypeReference upperBound = conformanceComputer.getCommonSuperType(allUpperBounds);
				return upperBound;
			}
		} else if (type instanceof JvmTypeParameterDeclarator && !((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty()) {
			List<JvmTypeReference> arguments = Lists.newArrayList();
			List<JvmTypeParameter> parameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			for(JvmTypeParameter parameter: parameters) {
				arguments.add(computeVarArgTypeInformation(feature, parameter));
			}
			return typeReferences.createTypeRef(type, arguments.toArray(new JvmTypeReference[arguments.size()]));
		} else {
			JvmTypeReference objectType = typeReferences.getTypeForName(Object.class, feature);
			return objectType;
		}
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
		if (current instanceof JvmAnyTypeReference) {
			if (isBetter instanceof JvmAnyTypeReference)
				return false;
			return true;
		}
		if (isBetter instanceof JvmAnyTypeReference)
			return false;
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
						if (argument != null) {
							JvmTypeParameter param = typeParameters.get(i);
							if (context.containsKey(argument.getType())) {
								context.putAll(param, context.get((JvmTypeParameter) argument.getType()));
							} else {
								context.put(param, argument);
							}
						}
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
	
	protected void resolve(JvmTypeReference declaration, JvmTypeReference information, Multimap<JvmTypeParameter, JvmTypeReference> existing, boolean returnTypeContext) {
		JvmTypeParameter typeParameter = getReferenceTypeParameter(declaration);
		if (typeParameter != null) {
			if (isValidParameter(typeParameter, information, returnTypeContext)) {
				if (information != null && !containsEntry(existing, typeParameter, information)) {
					existing.put(typeParameter, information);
					Collection<JvmTypeReference> resolveData = existing.get(typeParameter);
					List<JvmTypeParameter> transitiveParameters = Lists.newArrayListWithExpectedSize(2);
					for(JvmTypeReference resolveDataItem: resolveData) {
						if (resolveDataItem.getType() instanceof JvmTypeParameter) {
							if (resolveDataItem != information)
								transitiveParameters.add((JvmTypeParameter) resolveDataItem.getType());
						}
					}
					for(JvmTypeParameter transitiveParameter: transitiveParameters) {
						if (!containsEntry(existing, transitiveParameter, information)) {
							existing.put(transitiveParameter, information);
						}
					}
					resolve(typeParameter, information, existing, returnTypeContext);
				}
			}
		}
		if (declaration instanceof JvmParameterizedTypeReference
				&& information instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference declaration2 = (JvmParameterizedTypeReference) declaration;
			JvmParameterizedTypeReference information2 = (JvmParameterizedTypeReference) information;
			EList<JvmTypeReference> declArgs = declaration2.getArguments();
			EList<JvmTypeReference> infoArgs = information2.getArguments();
			for (int i = 0; i < declArgs.size() && i < infoArgs.size(); i++) {
				resolve(declArgs.get(i), infoArgs.get(i), existing, returnTypeContext);
			}
		}
	}

	private boolean isValidParameter(JvmTypeParameter typeParameter, JvmTypeReference information, boolean ignoreOperationArguments) {
		if (!ignoreOperationArguments || !(typeParameter.getDeclarator() instanceof JvmOperation))
			return true;
		if (information instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference reference = (JvmParameterizedTypeReference) information;
			if (reference.getType() instanceof JvmTypeParameter) {
				if (typeParameter.getDeclarator() == ((JvmTypeParameter) reference.getType()).getDeclarator()) {
					return false;
				}
			}
			for(JvmTypeReference argument: reference.getArguments()) {
				if (!isValidParameter(typeParameter, argument, ignoreOperationArguments))
					return false;
			}
		} else if (information instanceof JvmWildcardTypeReference) {
			List<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) information).getConstraints();
			for(JvmTypeConstraint constraint: constraints) {
				if (!isValidParameter(typeParameter, constraint.getTypeReference(), ignoreOperationArguments))
					return false;
			}
		} else if (information instanceof JvmGenericArrayTypeReference) {
			return isValidParameter(typeParameter, ((JvmGenericArrayTypeReference) information).getComponentType(), ignoreOperationArguments);
		}
		return true;
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
				if(constraint.getTypeReference() != null && constraint.getTypeReference().getType() instanceof JvmTypeParameter)
					return (JvmTypeParameter) constraint.getTypeReference().getType();
			}
		}
		return null;
	}
	
	protected void resolve(JvmTypeParameter key, JvmTypeReference value, Multimap<JvmTypeParameter, JvmTypeReference> existing, boolean ignoreOperationArguments) {
		for (JvmTypeConstraint constrain : key.getConstraints()) {
			JvmTypeReference reference = constrain.getTypeReference();
			resolve(reference,value,existing, ignoreOperationArguments);
		}
	}

}